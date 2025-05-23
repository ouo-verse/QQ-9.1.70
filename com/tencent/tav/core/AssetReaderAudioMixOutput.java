package com.tencent.tav.core;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.reverseaudio.ReverseAudioDecoderTrack;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AssetReaderAudioMixOutput extends AssetReaderOutput {
    public static final String TAG = "AssetReaderAudioMixOutput";
    private IDecoderTrack audioCompositionDecoderTrack;

    @Nullable
    private Map<String, Object> audioSettings;
    private ArrayList<AssetTrack> audioTracks;
    private final Queue<CMSampleBuffer> audioSamplebuffer = new LinkedList();
    private int maxSize = 2;
    private boolean decoderFinished = true;
    private boolean decoderStarted = false;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class PreDecoder implements Runnable {
        private final int maxSize;
        private final Queue<CMSampleBuffer> queue;

        public PreDecoder(Queue<CMSampleBuffer> queue, int i3) {
            this.queue = queue;
            this.maxSize = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!AssetReaderAudioMixOutput.this.decoderFinished) {
                synchronized (this.queue) {
                    while (this.queue.size() == this.maxSize) {
                        try {
                            Logger.v(AssetReaderAudioMixOutput.TAG, "Queue is full, Producer thread waiting for Consumer to take something from queue.");
                            LockMethodProxy.wait(this.queue);
                        } catch (InterruptedException e16) {
                            Logger.e(AssetReaderAudioMixOutput.TAG, "", e16);
                        }
                    }
                    this.queue.add(AssetReaderAudioMixOutput.this.audioCompositionDecoderTrack.readSample());
                    this.queue.notifyAll();
                }
            }
        }
    }

    public AssetReaderAudioMixOutput(ArrayList<AssetTrack> arrayList, Map<String, Object> map, boolean z16, int i3) {
        this.audioTracks = arrayList;
        this.audioSettings = map;
        AudioCompositionDecoderTrack audioCompositionDecoderTrack = new AudioCompositionDecoderTrack(arrayList, 2);
        if (z16) {
            this.audioCompositionDecoderTrack = new ReverseAudioDecoderTrack(audioCompositionDecoderTrack, i3);
        } else {
            this.audioCompositionDecoderTrack = audioCompositionDecoderTrack;
        }
    }

    @Nullable
    public Map<String, Object> getAudioSettings() {
        return this.audioSettings;
    }

    public ArrayList<AssetTrack> getAudioTracks() {
        return this.audioTracks;
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public CMSampleBuffer nextSampleBuffer() {
        CMSampleBuffer remove;
        if (EncoderWriter.PRE_DECODE_AUDIO) {
            synchronized (this.audioSamplebuffer) {
                while (this.audioSamplebuffer.isEmpty()) {
                    try {
                        Logger.i(TAG, "Queue is empty, Consumer thread waiting for Producer to put something in queue.");
                        LockMethodProxy.wait(this.audioSamplebuffer);
                    } catch (InterruptedException e16) {
                        Logger.e(TAG, "nextSampleBuffer error", e16);
                    }
                }
                remove = this.audioSamplebuffer.remove();
                this.audioSamplebuffer.notifyAll();
            }
            return remove;
        }
        return this.audioCompositionDecoderTrack.readSample();
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void preDecode() {
        this.decoderFinished = false;
        this.audioSamplebuffer.clear();
        new BaseThread(new PreDecoder(this.audioSamplebuffer, this.maxSize), "preDecode").start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.tav.core.AssetReaderOutput
    public void release() {
        IDecoderTrack iDecoderTrack = this.audioCompositionDecoderTrack;
        if (iDecoderTrack != null) {
            iDecoderTrack.release();
        }
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        IDecoderTrack iDecoderTrack = this.audioCompositionDecoderTrack;
        if (iDecoderTrack instanceof AudioCompositionDecoderTrack) {
            ((AudioCompositionDecoderTrack) iDecoderTrack).setAudioInfo(audioInfo);
        } else if (iDecoderTrack instanceof ReverseAudioDecoderTrack) {
            ((ReverseAudioDecoderTrack) iDecoderTrack).setAudioInfo(audioInfo);
        }
    }

    public void setAudioMix(AudioMix audioMix) {
        IDecoderTrack iDecoderTrack = this.audioCompositionDecoderTrack;
        if (iDecoderTrack instanceof AudioCompositionDecoderTrack) {
            ((AudioCompositionDecoderTrack) iDecoderTrack).setAudioMix(audioMix);
        } else if (iDecoderTrack instanceof ReverseAudioDecoderTrack) {
            ((ReverseAudioDecoderTrack) iDecoderTrack).setAudioMix(audioMix);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.tav.core.AssetReaderOutput
    public void start(@Nullable IContextCreate iContextCreate, AssetReader assetReader) {
        if (this.audioCompositionDecoderTrack != null && !this.decoderStarted) {
            if (assetReader.getTimeRange() != null) {
                CMTime start = assetReader.getTimeRange().getStart();
                if (start.equals(CMTime.CMTimeZero)) {
                    this.audioCompositionDecoderTrack.start(null, assetReader.getTimeRange());
                } else {
                    this.audioCompositionDecoderTrack.start(null);
                    this.audioCompositionDecoderTrack.seekTo(start, false, false);
                }
            } else {
                this.audioCompositionDecoderTrack.start(null);
            }
            this.decoderStarted = true;
        }
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void stopPreDecode() {
        this.decoderFinished = true;
        this.audioSamplebuffer.clear();
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void markConfigurationAsFinal() {
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void resetForReadingTimeRanges(List<CMTimeRange> list) {
    }
}
