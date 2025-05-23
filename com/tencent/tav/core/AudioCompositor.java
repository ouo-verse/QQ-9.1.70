package com.tencent.tav.core;

import androidx.annotation.NonNull;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.decoder.AudioDecoderTrack;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioCompositor {
    private AudioMixer audioMixer;
    private ShortBuffer currentSamples;
    private ShortBuffer lastSamples;
    private final String TAG = "AudioCompositor@" + Integer.toHexString(hashCode());

    @NonNull
    private final AudioResample audioResample = new AudioResample();

    public AudioCompositor(AudioInfo audioInfo) {
        this.audioMixer = new AudioMixer(audioInfo.sampleRate, audioInfo.channelCount);
    }

    private AudioInfo resample(CMSampleBuffer cMSampleBuffer, AudioInfo audioInfo) {
        ByteBuffer sampleByteBuffer = cMSampleBuffer.getSampleByteBuffer();
        if (sampleByteBuffer != null && sampleByteBuffer.limit() > 0) {
            ByteBuffer resample = this.audioResample.resample(sampleByteBuffer, audioInfo);
            if (resample != null) {
                audioInfo = this.audioResample.getDestAudioInfo();
                sampleByteBuffer = resample;
            }
            cMSampleBuffer.setSampleByteBuffer(sampleByteBuffer);
            return audioInfo;
        }
        Logger.d(this.audioResample.TAG, "resample: \u4e0d\u8fdb\u884c\u91cd\u91c7\u6837 byteBuffer = " + sampleByteBuffer);
        return audioInfo;
    }

    public synchronized void clear() {
        this.currentSamples = null;
        this.lastSamples = null;
    }

    public ByteBuffer processFrame(ByteBuffer byteBuffer, float f16, float f17, AudioInfo audioInfo) {
        this.audioMixer.setAudioInfo(audioInfo.sampleRate, audioInfo.channelCount, audioInfo.pcmEncoding);
        return this.audioMixer.processBytes(byteBuffer, f17, f16, 1.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x01aa, code lost:
    
        r16.currentSamples.flip();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01c9, code lost:
    
        return new com.tencent.tav.coremedia.CMSampleBuffer(r19.getTime(), r16.audioMixer.mergeSamples(r19.getSampleByteBuffer().asShortBuffer(), r16.currentSamples));
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059 A[Catch: all -> 0x01e8, TryCatch #0 {, blocks: (B:10:0x0009, B:14:0x0013, B:16:0x0023, B:19:0x002a, B:20:0x0047, B:22:0x004b, B:24:0x0051, B:26:0x0059, B:27:0x007d, B:28:0x008d, B:74:0x01cb, B:77:0x0030, B:5:0x01e2, B:33:0x0099, B:36:0x00f9, B:38:0x0104, B:39:0x010e, B:41:0x0114, B:46:0x0120, B:48:0x012a, B:50:0x0130, B:51:0x0143, B:56:0x0157, B:58:0x0160, B:61:0x0167, B:62:0x0184, B:67:0x016d, B:53:0x019d, B:63:0x01aa), top: B:9:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d A[Catch: all -> 0x01e8, TryCatch #0 {, blocks: (B:10:0x0009, B:14:0x0013, B:16:0x0023, B:19:0x002a, B:20:0x0047, B:22:0x004b, B:24:0x0051, B:26:0x0059, B:27:0x007d, B:28:0x008d, B:74:0x01cb, B:77:0x0030, B:5:0x01e2, B:33:0x0099, B:36:0x00f9, B:38:0x0104, B:39:0x010e, B:41:0x0114, B:46:0x0120, B:48:0x012a, B:50:0x0130, B:51:0x0143, B:56:0x0157, B:58:0x0160, B:61:0x0167, B:62:0x0184, B:67:0x016d, B:53:0x019d, B:63:0x01aa), top: B:9:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01aa A[EDGE_INSN: B:76:0x01aa->B:63:0x01aa BREAK  A[LOOP:0: B:30:0x0095->B:45:0x01a7], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized CMSampleBuffer readMergeSample(AudioDecoderTrack audioDecoderTrack, AudioMixInputParameters audioMixInputParameters, CMSampleBuffer cMSampleBuffer) {
        ShortBuffer shortBuffer;
        int position;
        int i3;
        int i16;
        float f16;
        if (cMSampleBuffer != null) {
            if (cMSampleBuffer.getSampleByteBuffer() != null && audioDecoderTrack != null) {
                int limit = cMSampleBuffer.getSampleByteBuffer().asShortBuffer().limit();
                ShortBuffer shortBuffer2 = this.currentSamples;
                if (shortBuffer2 != null && shortBuffer2.capacity() >= limit) {
                    this.currentSamples.clear();
                    shortBuffer = this.lastSamples;
                    if (shortBuffer != null && shortBuffer.remaining() > 0) {
                        if (limit >= this.lastSamples.remaining()) {
                            int position2 = this.lastSamples.position();
                            int limit2 = this.lastSamples.limit();
                            int i17 = position2 + limit;
                            this.lastSamples.limit(i17);
                            this.currentSamples.put(this.lastSamples);
                            this.lastSamples.limit(limit2);
                            this.lastSamples.position(i17);
                        } else {
                            this.currentSamples.put(this.lastSamples);
                            ShortBuffer shortBuffer3 = this.lastSamples;
                            shortBuffer3.position(shortBuffer3.limit());
                        }
                    }
                    position = this.currentSamples.position();
                    i3 = 0;
                    while (true) {
                        if (position < limit) {
                            break;
                        }
                        try {
                            CMSampleBuffer readSample = audioDecoderTrack.readSample(cMSampleBuffer.getTime());
                            Logger.v(this.TAG, "readMergeSample: new time = " + cMSampleBuffer.getTime() + ",audioBuffer:" + readSample.getTime());
                            String str = this.TAG;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("readMergeSample: loopCount = ");
                            i16 = i3 + 1;
                            sb5.append(i3);
                            sb5.append(", audioBuffer = ");
                            sb5.append(readSample);
                            Logger.v(str, sb5.toString());
                            if (readSample.getState().getStateCode() <= -1) {
                                return cMSampleBuffer;
                            }
                            audioDecoderTrack.asyncReadNextSample(readSample.getTime());
                            if (audioMixInputParameters != null) {
                                f16 = audioMixInputParameters.getVolumeAtTime(readSample.getTime());
                            } else {
                                f16 = 1.0f;
                            }
                            if (readSample.getSampleByteBuffer() != null && readSample.getSampleByteBuffer().limit() > 0) {
                                AudioInfo resample = resample(readSample, audioDecoderTrack.getAudioInfo());
                                if (audioMixInputParameters != null && audioMixInputParameters.getAudioTapProcessor() != null) {
                                    readSample.setSampleByteBuffer(audioMixInputParameters.getAudioTapProcessor().processAudioPCM(readSample.getTime(), readSample.getSampleByteBuffer(), resample));
                                }
                                ShortBuffer asShortBuffer = processFrame(readSample.getSampleByteBuffer(), f16, 1.0f, resample).asShortBuffer();
                                int i18 = limit - position;
                                if (asShortBuffer.limit() > i18) {
                                    int limit3 = asShortBuffer.limit() - i18;
                                    ShortBuffer shortBuffer4 = this.lastSamples;
                                    if (shortBuffer4 != null && shortBuffer4.capacity() >= limit3) {
                                        this.lastSamples.clear();
                                        asShortBuffer.position(i18);
                                        this.lastSamples.put(asShortBuffer);
                                        this.lastSamples.flip();
                                        asShortBuffer.position(0);
                                        asShortBuffer.limit(i18);
                                        this.currentSamples.put(asShortBuffer);
                                    }
                                    ByteBuffer allocate = ByteBuffer.allocate(limit3 * 2);
                                    allocate.order(cMSampleBuffer.getSampleByteBuffer().order());
                                    this.lastSamples = allocate.asShortBuffer();
                                    asShortBuffer.position(i18);
                                    this.lastSamples.put(asShortBuffer);
                                    this.lastSamples.flip();
                                    asShortBuffer.position(0);
                                    asShortBuffer.limit(i18);
                                    this.currentSamples.put(asShortBuffer);
                                } else {
                                    this.currentSamples.put(asShortBuffer);
                                    position += asShortBuffer.limit();
                                }
                            }
                            i3 = i16;
                        } catch (Throwable th5) {
                            Logger.e(this.TAG, "readMergeSample: ", th5);
                            return new CMSampleBuffer(CMSampleState.fromError(-1L, "catch error", th5));
                        }
                    }
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(limit * 2);
                allocate2.order(cMSampleBuffer.getSampleByteBuffer().order());
                this.currentSamples = allocate2.asShortBuffer();
                shortBuffer = this.lastSamples;
                if (shortBuffer != null) {
                    if (limit >= this.lastSamples.remaining()) {
                    }
                }
                position = this.currentSamples.position();
                i3 = 0;
                while (true) {
                    if (position < limit) {
                    }
                    i3 = i16;
                }
            }
        }
        this.currentSamples = null;
        this.lastSamples = null;
        return cMSampleBuffer;
    }

    public void release() {
        this.audioResample.release();
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        this.audioMixer = new AudioMixer(audioInfo.sampleRate, audioInfo.channelCount);
    }
}
