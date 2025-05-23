package com.tencent.tav.core;

import android.text.TextUtils;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioDecoderTrack;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.ReActionThread;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.player.Player;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioCompositionDecoderTrack implements IDecoderTrack {
    private static final String TAG = "AudioCompositionDecoder";
    private CMSampleBuffer _lastReadAudioBuffer;
    private boolean asyncEnable;
    private HashMap<Integer, AudioCompositor> audioCompositorMap;
    private AudioInfo audioInfo;
    private AudioMix audioMix;
    private List<AssetTrack> audioTracks;
    private boolean decoderStarted;
    private final DecoderThread decoderThread;
    private ArrayList<AudioDecoderTrack> decoderTrackList;
    private AudioMixer mAudioMixer;
    private float rate;
    private float volume;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class DecoderThread extends ReActionThread {
        private static final String NAME = "AudioCompositionAsyncDecoderThread";
        private final Object nextFrameDecoderLock;
        private CMSampleBuffer pcmFrame;

        public DecoderThread() {
            super(NAME);
            this.nextFrameDecoderLock = new Object();
        }

        @Override // com.tencent.tav.decoder.ReActionThread
        protected void doAction() {
            synchronized (this.nextFrameDecoderLock) {
                Logger.v(AudioCompositionDecoderTrack.TAG, "doAction: start ");
                CMSampleBuffer doReadSample = AudioCompositionDecoderTrack.this.doReadSample();
                this.pcmFrame = doReadSample;
                if (doReadSample.getSampleByteBuffer() != null) {
                    CMSampleBuffer cMSampleBuffer = this.pcmFrame;
                    cMSampleBuffer.setSampleByteBuffer(AudioCompositionDecoderTrack.this.processFrame(cMSampleBuffer.getSampleByteBuffer(), AudioCompositionDecoderTrack.this.volume, AudioCompositionDecoderTrack.this.rate, AudioCompositionDecoderTrack.this.audioInfo));
                }
                Logger.v(AudioCompositionDecoderTrack.TAG, "doAction: finish ");
            }
        }

        @Override // com.tencent.tav.decoder.ReActionThread, com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
        }
    }

    public AudioCompositionDecoderTrack(List<AssetTrack> list, int i3) {
        this.audioTracks = new ArrayList();
        this.decoderTrackList = new ArrayList<>();
        this.audioCompositorMap = new HashMap<>();
        this.volume = 1.0f;
        this.rate = 1.0f;
        this.decoderStarted = false;
        this.decoderThread = new DecoderThread();
        this.mAudioMixer = new AudioMixer();
        this.audioInfo = new AudioInfo();
        this.asyncEnable = Player.getPlayerStaticConfig(Player.PlayerStaticConfigKey.CONFIG_STATIC_AUDIO_SYNC_ENABLE);
        this.audioTracks = list;
        initAudioDecodeTracks(null);
        initAudioMix();
    }

    private DecoderTrackSegment createDecoderTrackSegment(AssetTrack assetTrack, AssetTrackSegment assetTrackSegment) {
        DecoderAssetTrack decoderAssetTrack;
        if (assetTrackSegment.isEmpty()) {
            decoderAssetTrack = null;
        } else {
            decoderAssetTrack = new DecoderAssetTrack();
            decoderAssetTrack.assetPath = assetTrack.getSourcePath();
            decoderAssetTrack.trackId = assetTrack.getTrackID();
            decoderAssetTrack.mediaType = assetTrack.getMediaType();
            decoderAssetTrack.extraInfo = assetTrack.getExtraInfo();
            decoderAssetTrack.size = assetTrack.getNaturalSize();
            decoderAssetTrack.preferredTransform = assetTrack.getPreferredTransform();
            decoderAssetTrack.preferredVolume = assetTrack.getPreferredVolume();
            decoderAssetTrack.frameRate = (int) assetTrack.getNominalFrameRate();
        }
        CMTimeRange source = assetTrackSegment.getTimeMapping().getSource();
        DecoderTrackSegment decoderTrackSegment = new DecoderTrackSegment(new CMTimeRange(source.getStart(), source.getDuration()), decoderAssetTrack);
        decoderTrackSegment.setScaledDuration(assetTrackSegment.getScaleDuration());
        return decoderTrackSegment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized CMSampleBuffer doReadSample() {
        CMTime cMTime;
        AudioMixInputParameters audioMixInputParameters;
        Logger.v(TAG, "doReadSample: start ");
        if (this.decoderTrackList.isEmpty()) {
            Logger.e(TAG, "doReadSample:[finish] decoderTrackList.isEmpty ");
            return new CMSampleBuffer(CMSampleState.fromError(-100L));
        }
        AudioDecoderTrack audioDecoderTrack = this.decoderTrackList.get(0);
        CMSampleBuffer readSample = audioDecoderTrack.readSample();
        if (readSample.getState().getStateCode() < -1) {
            Logger.e(TAG, "doReadSample:[failed]");
            return readSample;
        }
        this._lastReadAudioBuffer = readSample;
        ByteBuffer sampleByteBuffer = readSample.getSampleByteBuffer();
        if (this._lastReadAudioBuffer.getSampleByteBuffer() == null) {
            sampleByteBuffer = audioDecoderTrack.getEmptyAudioBuffer();
        }
        if (sampleByteBuffer != null) {
            sampleByteBuffer.position(0);
        }
        CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(this._lastReadAudioBuffer.getTime(), sampleByteBuffer);
        int size = this.decoderTrackList.size() - 1;
        while (true) {
            cMTime = null;
            if (size <= 0) {
                break;
            }
            AudioDecoderTrack audioDecoderTrack2 = this.decoderTrackList.get(size);
            AudioCompositor audioCompositor = this.audioCompositorMap.get(Integer.valueOf(audioDecoderTrack2.getTrackID()));
            if (audioCompositor == null) {
                Logger.e(TAG, "doReadSample: audioCompositorMap.get(decoderTrack.getTrackID(), return null!");
            } else {
                Logger.v(TAG, "doReadSample: readMergeSample " + size);
                AudioMix audioMix = this.audioMix;
                if (audioMix != null) {
                    audioMixInputParameters = audioMix.getInputParametersWithTrackID(audioDecoderTrack2.getTrackID());
                } else {
                    audioMixInputParameters = null;
                }
                cMSampleBuffer = audioCompositor.readMergeSample(audioDecoderTrack2, audioMixInputParameters, cMSampleBuffer);
                Logger.v(TAG, "doReadSample: readMergeSample finish " + size);
                if (cMSampleBuffer != null && cMSampleBuffer.getState().getStateCode() < -1) {
                    break;
                }
            }
            size--;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doReadSample:[success]  ");
        if (cMSampleBuffer != null) {
            cMTime = cMSampleBuffer.getTime();
        }
        sb5.append(cMTime);
        Logger.v(TAG, sb5.toString());
        return cMSampleBuffer;
    }

    private void initAudioDecodeTracks(CMTimeRange cMTimeRange) {
        CMTime duration;
        if (this.audioTracks == null) {
            return;
        }
        synchronized (this) {
            this.decoderTrackList.clear();
        }
        AudioDecoderTrack audioDecoderTrack = new AudioDecoderTrack();
        ArrayList arrayList = new ArrayList();
        CMTime cMTime = CMTime.CMTimeZero;
        if (cMTimeRange == null) {
            duration = getDuration();
        } else {
            duration = cMTimeRange.getDuration();
        }
        arrayList.add(createDecoderTrackSegment((AssetTrack) null, new CompositionTrackSegment(new CMTimeRange(cMTime, duration))));
        audioDecoderTrack.setTrackID(0);
        audioDecoderTrack.setTrackSegments(arrayList);
        audioDecoderTrack.setVolume(0.0f);
        audioDecoderTrack.setDecodeType(IDecoder.DecodeType.Audio);
        audioDecoderTrack.setAudioInfo(this.audioInfo);
        this.decoderTrackList.add(audioDecoderTrack);
        for (AssetTrack assetTrack : this.audioTracks) {
            if (assetTrack.getMediaType() == 2) {
                AudioDecoderTrack audioDecoderTrack2 = new AudioDecoderTrack();
                AudioCompositor audioCompositor = new AudioCompositor(this.audioInfo);
                List<AssetTrackSegment> segments = assetTrack.getSegments();
                ArrayList arrayList2 = new ArrayList();
                for (AssetTrackSegment assetTrackSegment : segments) {
                    if (assetTrackSegment instanceof CompositionTrackSegment) {
                        arrayList2.add(createDecoderTrackSegment(assetTrack, (CompositionTrackSegment) assetTrackSegment));
                    } else {
                        arrayList2.add(createDecoderTrackSegment(assetTrack, assetTrackSegment));
                    }
                }
                audioDecoderTrack2.setTrackID(assetTrack.getTrackID());
                audioDecoderTrack2.setTrackSegments(arrayList2);
                audioDecoderTrack2.setAudioInfo(this.audioInfo);
                audioDecoderTrack2.setFrameRate((int) assetTrack.getNominalFrameRate());
                audioDecoderTrack2.setVolume(assetTrack.getPreferredVolume());
                audioDecoderTrack2.setDecodeType(IDecoder.DecodeType.Audio);
                if (assetTrack.getTimeRange() != null) {
                    audioDecoderTrack2.clipRangeAndClearRange(new CMTimeRange(assetTrack.getTimeRange().getStart(), assetTrack.getTimeRange().getDuration()));
                }
                this.decoderTrackList.add(audioDecoderTrack2);
                this.audioCompositorMap.put(Integer.valueOf(assetTrack.getTrackID()), audioCompositor);
            }
        }
    }

    private void initAudioMix() {
        List<AssetTrack> list = this.audioTracks;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (AssetTrack assetTrack : this.audioTracks) {
                if (assetTrack != null) {
                    MutableAudioMixInputParameters mutableAudioMixInputParameters = new MutableAudioMixInputParameters(assetTrack, null);
                    mutableAudioMixInputParameters.setVolumeForTimeRange(assetTrack.getPreferredVolume(), assetTrack.getTimeRange());
                    arrayList.add(mutableAudioMixInputParameters);
                }
            }
            this.audioMix = new AudioMix(arrayList);
        }
    }

    public synchronized void addTrack(AssetTrack assetTrack) {
        this.audioTracks.add(assetTrack);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void asyncReadNextSample(CMTime cMTime) {
        Logger.v(TAG, "asyncReadNextSample: " + cMTime);
        Logger.v(TAG, "asyncReadNextSample: enable " + this.asyncEnable);
        if (this.asyncEnable && this.decoderThread.pcmFrame == null) {
            synchronized (this.decoderThread.nextFrameDecoderLock) {
                if (this.decoderThread.pcmFrame == null) {
                    this.decoderThread.action();
                }
            }
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getCurrentSampleTime() {
        return this.decoderTrackList.get(0).getCurrentSampleTime();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getDuration() {
        CMTime cMTime = CMTime.CMTimeZero;
        Iterator<AssetTrack> it = this.audioTracks.iterator();
        while (it.hasNext()) {
            CMTime duration = it.next().getDuration();
            if (duration.bigThan(cMTime)) {
                cMTime = duration;
            }
        }
        return cMTime;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getFrameDuration() {
        return CMTime.CMTimeZero;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getFrameRate() {
        return 0;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getTrackId() {
        return 0;
    }

    public synchronized ByteBuffer processFrame(ByteBuffer byteBuffer, float f16, float f17, AudioInfo audioInfo) {
        this.mAudioMixer.setAudioInfo(audioInfo.sampleRate, audioInfo.channelCount, audioInfo.pcmEncoding);
        return this.mAudioMixer.processBytes(byteBuffer, f17, f16, 1.0f);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readCurrentSample() {
        return null;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample() {
        if (this.decoderTrackList.size() != 0) {
            synchronized (this.decoderThread.nextFrameDecoderLock) {
                if (this.decoderThread.pcmFrame != null) {
                    CMSampleBuffer cMSampleBuffer = this.decoderThread.pcmFrame;
                    this.decoderThread.pcmFrame = null;
                    return cMSampleBuffer;
                }
                CMSampleBuffer doReadSample = doReadSample();
                if (doReadSample != null && doReadSample.getSampleByteBuffer() != null) {
                    doReadSample.setSampleByteBuffer(processFrame(doReadSample.getSampleByteBuffer(), this.volume, this.rate, this.audioInfo));
                }
                return doReadSample;
            }
        }
        return new CMSampleBuffer(CMSampleState.fromError(-100L));
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public synchronized void release() {
        Logger.d(TAG, "release: " + this);
        Iterator<AudioDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.decoderTrackList.clear();
        this.audioTracks.clear();
        if (this.asyncEnable) {
            this.decoderThread.release();
        }
        Iterator<AudioCompositor> it5 = this.audioCompositorMap.values().iterator();
        while (it5.hasNext()) {
            it5.next().release();
        }
        Logger.d(TAG, "release: finish" + this);
    }

    public synchronized void removeTrack(AssetTrack assetTrack) {
        this.audioTracks.remove(assetTrack);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer seekTo(CMTime cMTime, boolean z16, boolean z17) {
        AudioTapProcessor audioTapProcessor;
        Logger.v(TAG, "seekTo:[timeUs " + cMTime + "] [needRead " + z16 + "] [quickSeek " + z17 + "]");
        synchronized (this.decoderThread.nextFrameDecoderLock) {
            this.decoderThread.pcmFrame = null;
        }
        Iterator<AudioDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            AudioDecoderTrack next = it.next();
            Logger.v(TAG, "seekTo: " + next);
            CMSampleBuffer seekTo = next.seekTo(cMTime, false, z17);
            AudioMixInputParameters inputParametersWithTrackID = this.audioMix.getInputParametersWithTrackID(next.getTrackID());
            if (seekTo != null && inputParametersWithTrackID != null && (audioTapProcessor = inputParametersWithTrackID.audioTapProcessor) != null) {
                audioTapProcessor.seekTo(seekTo.getTime());
                Logger.v(TAG, "final seekTo: " + seekTo.getTime());
            }
        }
        synchronized (this) {
            this._lastReadAudioBuffer = null;
            Iterator<AudioCompositor> it5 = this.audioCompositorMap.values().iterator();
            while (it5.hasNext()) {
                it5.next().clear();
            }
        }
        return null;
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        this.audioInfo = audioInfo.m262clone();
        this.mAudioMixer = new AudioMixer(audioInfo.sampleRate, audioInfo.channelCount);
        Iterator<AudioDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            it.next().setAudioInfo(audioInfo);
        }
        Iterator<AudioCompositor> it5 = this.audioCompositorMap.values().iterator();
        while (it5.hasNext()) {
            it5.next().setAudioInfo(audioInfo);
        }
    }

    public void setAudioMix(AudioMix audioMix) {
        this.audioMix = audioMix;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setFrameRate(int i3) {
        Iterator<AudioDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            it.next().setFrameRate(i3);
        }
    }

    public void setRate(float f16) {
        this.rate = f16;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setVolume(float f16) {
        List<AudioMixInputParameters> inputParameters;
        Logger.i(TAG, "setVolume: " + f16);
        AudioMix audioMix = this.audioMix;
        if (audioMix != null && (inputParameters = audioMix.getInputParameters()) != null) {
            for (AudioMixInputParameters audioMixInputParameters : inputParameters) {
                if (audioMixInputParameters != null && (audioMixInputParameters instanceof MutableAudioMixInputParameters)) {
                    ((MutableAudioMixInputParameters) audioMixInputParameters).setVolumeForTimeRange(f16);
                }
            }
        }
        this.volume = f16;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start() {
        start(null);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator) {
        start(surfaceCreator, null);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator, CMTimeRange cMTimeRange) {
        int i3;
        Logger.d(TAG, "start: " + cMTimeRange);
        if (this.decoderStarted) {
            return;
        }
        Logger.d(TAG, "start: " + this);
        if (this.asyncEnable) {
            this.decoderThread.start();
        }
        initAudioDecodeTracks(cMTimeRange);
        this.decoderStarted = true;
        CMTimeRange cMTimeRange2 = null;
        for (int i16 = 0; i16 < this.decoderTrackList.size(); i16++) {
            if (i16 > 0 && i16 - 1 < this.audioTracks.size()) {
                AssetTrack assetTrack = this.audioTracks.get(i3);
                if (assetTrack != null && assetTrack.getTimeRange() != null) {
                    cMTimeRange2 = new CMTimeRange(assetTrack.getTimeRange().getStart(), assetTrack.getTimeRange().getDuration());
                }
            } else {
                cMTimeRange2 = new CMTimeRange(CMTime.CMTimeZero, getDuration());
            }
            this.decoderTrackList.get(i16).start(null, cMTimeRange2);
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample(CMTime cMTime) {
        return readSample();
    }

    private DecoderTrackSegment createDecoderTrackSegment(AssetTrack assetTrack, CompositionTrackSegment compositionTrackSegment) {
        DecoderAssetTrack decoderAssetTrack;
        if (compositionTrackSegment.isEmpty()) {
            decoderAssetTrack = null;
        } else {
            decoderAssetTrack = new DecoderAssetTrack();
            decoderAssetTrack.trackId = compositionTrackSegment.getSourceTrackID();
            decoderAssetTrack.mediaType = assetTrack.getMediaType();
            decoderAssetTrack.assetPath = compositionTrackSegment.getSourcePath();
            decoderAssetTrack.extraInfo = compositionTrackSegment.getExtraInfo();
            decoderAssetTrack.preferredTransform = assetTrack.getPreferredTransform();
            decoderAssetTrack.size = assetTrack.getNaturalSize();
            decoderAssetTrack.frameRate = (int) assetTrack.getNominalFrameRate();
            decoderAssetTrack.preferredVolume = assetTrack.getPreferredVolume();
            if (!TextUtils.isEmpty(decoderAssetTrack.assetPath)) {
                decoderAssetTrack.sourceType = compositionTrackSegment.getSourceType();
            }
        }
        CMTimeRange source = compositionTrackSegment.getTimeMapping().getSource();
        DecoderTrackSegment decoderTrackSegment = new DecoderTrackSegment(new CMTimeRange(source.getStart(), source.getDuration()), decoderAssetTrack);
        decoderTrackSegment.setScaledDuration(compositionTrackSegment.getScaleDuration());
        return decoderTrackSegment;
    }

    public AudioCompositionDecoderTrack(int i3) {
        this.audioTracks = new ArrayList();
        this.decoderTrackList = new ArrayList<>();
        this.audioCompositorMap = new HashMap<>();
        this.volume = 1.0f;
        this.rate = 1.0f;
        this.decoderStarted = false;
        this.decoderThread = new DecoderThread();
        this.mAudioMixer = new AudioMixer();
        this.audioInfo = new AudioInfo();
        this.asyncEnable = Player.getPlayerStaticConfig(Player.PlayerStaticConfigKey.CONFIG_STATIC_AUDIO_SYNC_ENABLE);
        initAudioDecodeTracks(null);
        initAudioMix();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void clipRangeAndClearRange(CMTimeRange cMTimeRange) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setDecodeType(IDecoder.DecodeType decodeType) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackIndex(int i3) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackSegments(List<DecoderTrackSegment> list) {
    }
}
