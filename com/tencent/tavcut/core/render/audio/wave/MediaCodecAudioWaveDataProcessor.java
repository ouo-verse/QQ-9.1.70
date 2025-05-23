package com.tencent.tavcut.core.render.audio.wave;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.videocut.utils.g;
import com.tencent.videocut.utils.r;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0002J\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0002J\u0014\u0010%\u001a\u00020\u00192\n\u0010&\u001a\u00060'j\u0002`(H\u0002J\u0016\u0010)\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u000200H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/wave/MediaCodecAudioWaveDataProcessor;", "Lcom/tencent/tavcut/core/render/audio/wave/IAudioWaveDataProcessor;", "()V", "audioDecoder", "Landroid/media/MediaCodec;", "audioPath", "", "channelCount", "", "dataCaptureListener", "Lcom/tencent/tavcut/core/render/audio/wave/IWaveDataCaptureListener;", "encodingPcmBit", "gapDurationUs", "", "lastNotifyTime", "mediaExtractor", "Landroid/media/MediaExtractor;", "mediaFormat", "Landroid/media/MediaFormat;", "sampleRate", "startTime", TAVOneClickFilmStickerEffect.TRACK_INDEX, "waveDataCalculator", "Lcom/tencent/tavcut/core/render/audio/wave/AudioWaveDataCalculator;", "decodeAudio", "", "decodeForWaveData", "path", "perSecondSampleCnt", "listener", "handleInputBufferIndex", "", "inputBufIndex", "handleOutputBufferIndex", "outputBufferIndex", "audioBufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "notifyDecodeError", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "notifyWaveData", "data", "", "", "prepare", "processWaveData", "pcmByteBuffer", "Ljava/nio/ByteBuffer;", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class MediaCodecAudioWaveDataProcessor implements IAudioWaveDataProcessor {
    private static final String AUDIO_MIME_PREFIX = "audio/";
    private static final long DECODE_DEFAULT_AWAIT_TIME_US = 10000;
    private static final String TAG = "MediaCodecAudioWaveDataProcessor";
    private MediaCodec audioDecoder;
    private int channelCount;
    private IWaveDataCaptureListener dataCaptureListener;
    private long gapDurationUs;
    private long lastNotifyTime;
    private MediaExtractor mediaExtractor;
    private MediaFormat mediaFormat;
    private int sampleRate;
    private long startTime;
    private AudioWaveDataCalculator waveDataCalculator;
    private String audioPath = "";
    private int trackIndex = -1;
    private int encodingPcmBit = 2;

    public static final /* synthetic */ MediaExtractor access$getMediaExtractor$p(MediaCodecAudioWaveDataProcessor mediaCodecAudioWaveDataProcessor) {
        MediaExtractor mediaExtractor = mediaCodecAudioWaveDataProcessor.mediaExtractor;
        if (mediaExtractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
        }
        return mediaExtractor;
    }

    public static final /* synthetic */ AudioWaveDataCalculator access$getWaveDataCalculator$p(MediaCodecAudioWaveDataProcessor mediaCodecAudioWaveDataProcessor) {
        AudioWaveDataCalculator audioWaveDataCalculator = mediaCodecAudioWaveDataProcessor.waveDataCalculator;
        if (audioWaveDataCalculator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("waveDataCalculator");
        }
        return audioWaveDataCalculator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a3, code lost:
    
        if (r0 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00eb, code lost:
    
        r0.release();
        r0 = new java.lang.StringBuilder();
        r0.append("onWaveFormDataCaptureFinished cost Time = ");
        r0.append(java.lang.System.currentTimeMillis() - r9.startTime);
        r0.append("  ");
        r0.append("  allWaveFormData = ");
        r1 = r9.waveDataCalculator;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0114, code lost:
    
        if (r1 != null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0116, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("waveDataCalculator");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0119, code lost:
    
        r0.append(r1.getWaveDataList().size());
        com.tencent.tavcut.core.render.log.TavLogger.d(com.tencent.tavcut.core.render.audio.wave.MediaCodecAudioWaveDataProcessor.TAG, r0.toString());
        r0 = r9.dataCaptureListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012d, code lost:
    
        if (r0 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012f, code lost:
    
        r1 = r9.waveDataCalculator;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0131, code lost:
    
        if (r1 != null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0133, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("waveDataCalculator");
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0136, code lost:
    
        r0.onWaveFormDataCaptureFinished(r1.getWaveDataList());
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x013d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e8, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c6, code lost:
    
        if (r0 != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00e6, code lost:
    
        if (r0 != null) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void decodeAudio() {
        MediaExtractor mediaExtractor;
        try {
            try {
                try {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("prepare to start audio decoder format = ");
                    MediaFormat mediaFormat = this.mediaFormat;
                    if (mediaFormat == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaFormat");
                    }
                    sb5.append(mediaFormat);
                    TavLogger.i(TAG, sb5.toString());
                    MediaFormat mediaFormat2 = this.mediaFormat;
                    if (mediaFormat2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaFormat");
                    }
                    MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat2.getString("mime"));
                    Intrinsics.checkExpressionValueIsNotNull(createDecoderByType, "MediaCodec.createDecoder\u2026ng(MediaFormat.KEY_MIME))");
                    this.audioDecoder = createDecoderByType;
                    if (createDecoderByType == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                    }
                    MediaFormat mediaFormat3 = this.mediaFormat;
                    if (mediaFormat3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaFormat");
                    }
                    boolean z16 = false;
                    createDecoderByType.configure(mediaFormat3, (Surface) null, (MediaCrypto) null, 0);
                    MediaCodec mediaCodec = this.audioDecoder;
                    if (mediaCodec == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                    }
                    mediaCodec.start();
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    boolean z17 = false;
                    while (!z16) {
                        if (!z17) {
                            MediaCodec mediaCodec2 = this.audioDecoder;
                            if (mediaCodec2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                            }
                            z17 = handleInputBufferIndex(mediaCodec2.dequeueInputBuffer(-1L));
                        }
                        MediaCodec mediaCodec3 = this.audioDecoder;
                        if (mediaCodec3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                        }
                        z16 = handleOutputBufferIndex(mediaCodec3.dequeueOutputBuffer(bufferInfo, 10000L), bufferInfo);
                    }
                    MediaCodec mediaCodec4 = this.audioDecoder;
                    if (mediaCodec4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                    }
                    mediaCodec4.stop();
                    MediaCodec mediaCodec5 = this.audioDecoder;
                    if (mediaCodec5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                    }
                    mediaCodec5.release();
                    mediaExtractor = this.mediaExtractor;
                } catch (IllegalArgumentException e16) {
                    TavLogger.e(TAG, "read sample data error", e16);
                    notifyDecodeError(e16);
                    MediaCodec mediaCodec6 = this.audioDecoder;
                    if (mediaCodec6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                    }
                    mediaCodec6.stop();
                    MediaCodec mediaCodec7 = this.audioDecoder;
                    if (mediaCodec7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                    }
                    mediaCodec7.release();
                    mediaExtractor = this.mediaExtractor;
                }
            } catch (IllegalStateException e17) {
                TavLogger.e(TAG, "read sample data error", e17);
                notifyDecodeError(e17);
                MediaCodec mediaCodec8 = this.audioDecoder;
                if (mediaCodec8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                }
                mediaCodec8.stop();
                MediaCodec mediaCodec9 = this.audioDecoder;
                if (mediaCodec9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                }
                mediaCodec9.release();
                mediaExtractor = this.mediaExtractor;
            }
        } catch (Throwable th5) {
            MediaCodec mediaCodec10 = this.audioDecoder;
            if (mediaCodec10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
            }
            mediaCodec10.stop();
            MediaCodec mediaCodec11 = this.audioDecoder;
            if (mediaCodec11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
            }
            mediaCodec11.release();
            MediaExtractor mediaExtractor2 = this.mediaExtractor;
            if (mediaExtractor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
            }
            mediaExtractor2.release();
            throw th5;
        }
    }

    private final boolean handleInputBufferIndex(int inputBufIndex) {
        if (inputBufIndex >= 0) {
            MediaCodec mediaCodec = this.audioDecoder;
            if (mediaCodec == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
            }
            ByteBuffer inputBuffer = mediaCodec.getInputBuffer(inputBufIndex);
            if (inputBuffer != null) {
                MediaExtractor mediaExtractor = this.mediaExtractor;
                if (mediaExtractor == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
                }
                int readSampleData = mediaExtractor.readSampleData(inputBuffer, 0);
                if (readSampleData <= 0) {
                    MediaCodec mediaCodec2 = this.audioDecoder;
                    if (mediaCodec2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                    }
                    mediaCodec2.queueInputBuffer(inputBufIndex, 0, 0, 0L, 4);
                    TavLogger.d(TAG, "decode saw inputEOS EOS; audio path = " + this.audioPath);
                    return true;
                }
                MediaCodec mediaCodec3 = this.audioDecoder;
                if (mediaCodec3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                }
                MediaExtractor mediaExtractor2 = this.mediaExtractor;
                if (mediaExtractor2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
                }
                mediaCodec3.queueInputBuffer(inputBufIndex, 0, readSampleData, mediaExtractor2.getSampleTime(), 0);
                MediaExtractor mediaExtractor3 = this.mediaExtractor;
                if (mediaExtractor3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
                }
                mediaExtractor3.advance();
            }
        }
        return false;
    }

    private final boolean handleOutputBufferIndex(int outputBufferIndex, MediaCodec.BufferInfo audioBufferInfo) {
        if (outputBufferIndex >= 0) {
            if ((audioBufferInfo.flags & 2) != 0) {
                MediaCodec mediaCodec = this.audioDecoder;
                if (mediaCodec == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                }
                mediaCodec.releaseOutputBuffer(outputBufferIndex, false);
                return false;
            }
            if (audioBufferInfo.size != 0) {
                MediaCodec mediaCodec2 = this.audioDecoder;
                if (mediaCodec2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
                }
                ByteBuffer outputBuffer = mediaCodec2.getOutputBuffer(outputBufferIndex);
                if (outputBuffer != null) {
                    outputBuffer.position(audioBufferInfo.offset);
                    outputBuffer.limit(audioBufferInfo.offset + audioBufferInfo.size);
                    processWaveData(outputBuffer);
                    outputBuffer.clear();
                }
            }
            MediaCodec mediaCodec3 = this.audioDecoder;
            if (mediaCodec3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
            }
            mediaCodec3.releaseOutputBuffer(outputBufferIndex, false);
            if ((audioBufferInfo.flags & 4) != 0) {
                TavLogger.d(TAG, "saw output EOS.");
                return true;
            }
        } else if (outputBufferIndex == -3) {
            TavLogger.d(TAG, "output buffers have changed.");
        } else if (outputBufferIndex == -2) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("output format has changed to ");
            MediaCodec mediaCodec4 = this.audioDecoder;
            if (mediaCodec4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
            }
            sb5.append(mediaCodec4.getOutputFormat());
            TavLogger.d(TAG, sb5.toString());
        } else if (outputBufferIndex == -1) {
            TavLogger.d(TAG, "INFO_TRY_AGAIN_LATER");
        }
        return false;
    }

    private final void notifyDecodeError(Exception ex5) {
        IWaveDataCaptureListener iWaveDataCaptureListener = this.dataCaptureListener;
        if (iWaveDataCaptureListener != null) {
            String message = ex5.getMessage();
            if (message == null) {
                message = "";
            }
            iWaveDataCaptureListener.onCaptureError(3, message);
        }
    }

    private final void notifyWaveData(List<Float> data) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastNotifyTime >= r.f384266a.d(this.gapDurationUs)) {
            IWaveDataCaptureListener iWaveDataCaptureListener = this.dataCaptureListener;
            if (iWaveDataCaptureListener != null) {
                iWaveDataCaptureListener.onWaveFormDataCapture(data);
            }
            this.lastNotifyTime = currentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean prepare() {
        boolean z16;
        boolean startsWith$default;
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mediaExtractor = mediaExtractor;
            mediaExtractor.setDataSource(this.audioPath);
            MediaExtractor mediaExtractor2 = this.mediaExtractor;
            if (mediaExtractor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
            }
            int trackCount = mediaExtractor2.getTrackCount();
            for (int i3 = 0; i3 < trackCount; i3++) {
                MediaExtractor mediaExtractor3 = this.mediaExtractor;
                if (mediaExtractor3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
                }
                MediaFormat format = mediaExtractor3.getTrackFormat(i3);
                String mime = format.getString("mime");
                Intrinsics.checkExpressionValueIsNotNull(mime, "mime");
                if (mime.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    int i16 = 2;
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(mime, "audio/", false, 2, null);
                    if (startsWith$default) {
                        this.trackIndex = i3;
                        MediaExtractor mediaExtractor4 = this.mediaExtractor;
                        if (mediaExtractor4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
                        }
                        mediaExtractor4.selectTrack(i3);
                        this.sampleRate = format.getInteger("sample-rate");
                        this.channelCount = format.getInteger("channel-count");
                        if (format.containsKey("pcm-encoding")) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                i16 = format.getInteger("pcm-encoding");
                            }
                            this.encodingPcmBit = i16;
                        }
                        Intrinsics.checkExpressionValueIsNotNull(format, "format");
                        this.mediaFormat = format;
                        return true;
                    }
                }
            }
            return false;
        } catch (IOException e16) {
            TavLogger.e(TAG, "Fail to init MediaExtractor", e16);
            return false;
        } catch (IllegalArgumentException e17) {
            TavLogger.e(TAG, "Fail to init MediaExtractor", e17);
            return false;
        }
    }

    private final void processWaveData(ByteBuffer pcmByteBuffer) {
        AudioWaveDataCalculator audioWaveDataCalculator = this.waveDataCalculator;
        if (audioWaveDataCalculator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("waveDataCalculator");
        }
        notifyWaveData(audioWaveDataCalculator.audioPcmToWaveData(pcmByteBuffer));
    }

    @Override // com.tencent.tavcut.core.render.audio.wave.IAudioWaveDataProcessor
    public void decodeForWaveData(@NotNull String path, int perSecondSampleCnt, long gapDurationUs, @NotNull IWaveDataCaptureListener listener) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        if (!g.f384239a.h(path)) {
            TavLogger.e(TAG, "Audio do not exist inputAudioPath = " + path);
            IWaveDataCaptureListener iWaveDataCaptureListener = this.dataCaptureListener;
            if (iWaveDataCaptureListener != null) {
                iWaveDataCaptureListener.onCaptureError(1, "Audio don't exist");
                return;
            }
            return;
        }
        this.audioPath = path;
        this.startTime = System.currentTimeMillis();
        this.dataCaptureListener = listener;
        this.gapDurationUs = gapDurationUs;
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new MediaCodecAudioWaveDataProcessor$decodeForWaveData$1(this, perSecondSampleCnt, null), 2, null);
    }
}
