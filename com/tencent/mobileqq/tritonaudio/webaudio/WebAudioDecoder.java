package com.tencent.mobileqq.tritonaudio.webaudio;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.triton.utils.TritonKeep;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@TritonKeep
@RequiresApi(16)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0019\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0082 J\u0019\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0082 J)\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0017H\u0082 J\u0018\u0010#\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioDecoder;", "", "()V", "DECODE_TIMEOUT", "", "TAG", "", "audioCachePath", "createTempAudioFile", "Ljava/io/File;", "byteBuffer", "Ljava/nio/ByteBuffer;", "doDecode", "", "ptr", "extractor", "Landroid/media/MediaExtractor;", "doDecodeByCodec", "codec", "Landroid/media/MediaCodec;", "audioFormat", "Landroid/media/MediaFormat;", "getSampleDepth", "", "init", "context", "Landroid/content/Context;", "onDecodeEnd", "success", "", "onDecodeFrame", "onDecodeInit", "channelCount", "sampleRate", "sampleDepth", "startDecode", "ByteBufferDataSource", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class WebAudioDecoder {
    private static final long DECODE_TIMEOUT = 3000;
    public static final WebAudioDecoder INSTANCE = new WebAudioDecoder();
    private static final String TAG = "WebAudioDecoder";
    private static String audioCachePath;

    WebAudioDecoder() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileOutputStream] */
    private final File createTempAudioFile(ByteBuffer byteBuffer) {
        ?? r06;
        File file;
        String str = audioCachePath;
        ?? r26 = null;
        r2 = null;
        File file2 = null;
        try {
            if (str == null) {
                Log.e(TAG, "createTempAudioFile: cachePath is null");
                return null;
            }
            try {
                file = new File(str, String.valueOf(System.currentTimeMillis()));
                if (file.exists()) {
                    file.delete();
                } else {
                    File parentFile = file.getParentFile();
                    if (parentFile == null) {
                        Intrinsics.throwNpe();
                    }
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                }
                file.createNewFile();
                r06 = new FileOutputStream(file);
            } catch (Exception e16) {
                e = e16;
                r06 = 0;
            } catch (Throwable th5) {
                th = th5;
                if (r26 != null) {
                    r26.close();
                }
                throw th;
            }
            try {
                r06.getChannel().write(byteBuffer);
                r06.flush();
                r06.close();
                file2 = file;
                str = r06;
            } catch (Exception e17) {
                e = e17;
                Log.e(TAG, "createTempAudioFile: write audio data fail.", e);
                str = r06;
                if (r06 != 0) {
                    r06.close();
                    str = r06;
                }
                return file2;
            }
            return file2;
        } catch (Throwable th6) {
            th = th6;
            r26 = str;
        }
    }

    private final void doDecode(long ptr, MediaExtractor extractor) {
        MediaFormat mediaFormat;
        boolean startsWith$default;
        MediaCodec mediaCodec = null;
        try {
            try {
                int trackCount = extractor.getTrackCount();
                int i3 = 0;
                while (true) {
                    if (i3 < trackCount) {
                        MediaFormat trackFormat = extractor.getTrackFormat(i3);
                        Intrinsics.checkExpressionValueIsNotNull(trackFormat, "extractor.getTrackFormat(i)");
                        String string = trackFormat.getString("mime");
                        if (string != null) {
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(string, "audio", false, 2, null);
                            if (startsWith$default) {
                                extractor.selectTrack(i3);
                                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
                                Intrinsics.checkExpressionValueIsNotNull(createDecoderByType, "MediaCodec.createDecoderByType(mime)");
                                createDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                                createDecoderByType.start();
                                mediaCodec = createDecoderByType;
                                mediaFormat = trackFormat;
                                break;
                            }
                        }
                        i3++;
                    } else {
                        mediaFormat = null;
                        break;
                    }
                }
            } catch (Exception e16) {
                Log.e(TAG, "doDecode: begin codec fail.", e16);
                onDecodeEnd(ptr, false);
                if (0 != 0) {
                    mediaCodec.stop();
                }
                if (0 == 0) {
                    return;
                }
            }
            if (mediaCodec != null && mediaFormat != null) {
                doDecodeByCodec(ptr, extractor, mediaCodec, mediaFormat);
                mediaCodec.stop();
                mediaCodec.release();
                return;
            }
            Log.e(TAG, "doDecode: codec=" + mediaCodec + ", format=" + mediaFormat);
            onDecodeEnd(ptr, false);
            if (mediaCodec != null) {
                mediaCodec.stop();
            }
            if (mediaCodec != null) {
                mediaCodec.release();
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                mediaCodec.stop();
            }
            if (0 != 0) {
                mediaCodec.release();
            }
            throw th5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void doDecodeByCodec(long ptr, MediaExtractor extractor, MediaCodec codec, MediaFormat audioFormat) {
        boolean z16;
        long j3;
        MediaCodec mediaCodec;
        int i3;
        boolean z17;
        int dequeueInputBuffer;
        MediaCodec mediaCodec2 = codec;
        onDecodeInit(ptr, audioFormat.getInteger("channel-count"), audioFormat.getInteger("sample-rate"), getSampleDepth(audioFormat));
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int i16 = 0;
        boolean z18 = false;
        boolean z19 = false;
        while (true) {
            if (z18 && z19) {
                onDecodeEnd(ptr, true);
                return;
            }
            if (!z18 && (dequeueInputBuffer = mediaCodec2.dequeueInputBuffer(3000L)) >= 0) {
                ByteBuffer inputBuffer = mediaCodec2.getInputBuffer(dequeueInputBuffer);
                if (inputBuffer == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(inputBuffer, "codec.getInputBuffer(inputIndex)!!");
                int readSampleData = extractor.readSampleData(inputBuffer, i16);
                if (readSampleData < 0) {
                    j3 = 3000;
                    mediaCodec = mediaCodec2;
                    codec.queueInputBuffer(dequeueInputBuffer, 0, 0, extractor.getSampleTime(), 4);
                    z16 = true;
                } else {
                    z16 = z18;
                    j3 = 3000;
                    mediaCodec = mediaCodec2;
                    codec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, extractor.getSampleTime(), 0);
                    extractor.advance();
                }
            } else {
                z16 = z18;
                j3 = 3000;
                mediaCodec = mediaCodec2;
            }
            if (!z19) {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, j3);
                if (dequeueOutputBuffer >= 0) {
                    if (bufferInfo.size > 0) {
                        ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(dequeueOutputBuffer);
                        if (outputBuffer != null) {
                            ByteBuffer data = ByteBuffer.allocateDirect(bufferInfo.size);
                            z17 = 0;
                            outputBuffer.get(data.array(), 0, bufferInfo.size);
                            Intrinsics.checkExpressionValueIsNotNull(data, "data");
                            onDecodeFrame(ptr, data);
                        } else {
                            z17 = 0;
                        }
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z17);
                        i3 = z17;
                    } else {
                        i3 = 0;
                    }
                    if ((bufferInfo.flags & 4) != 0) {
                        z19 = true;
                    }
                } else {
                    i3 = 0;
                    i3 = 0;
                    if (dequeueOutputBuffer == -2) {
                        Intrinsics.checkExpressionValueIsNotNull(codec.getOutputFormat(), "codec.outputFormat");
                    }
                }
            } else {
                i3 = 0;
            }
            mediaCodec2 = mediaCodec;
            i16 = i3;
            z18 = z16;
        }
    }

    private final int getSampleDepth(MediaFormat audioFormat) {
        if (Build.VERSION.SDK_INT >= 24) {
            if (!audioFormat.containsKey("pcm-encoding")) {
                return 16;
            }
            int integer = audioFormat.getInteger("pcm-encoding");
            if (integer != 3) {
                if (integer != 4) {
                    return 16;
                }
                return 32;
            }
            return 8;
        }
        return audioFormat.getInteger("bit-width");
    }

    private final native void onDecodeEnd(long ptr, boolean success);

    private final native void onDecodeFrame(long ptr, ByteBuffer byteBuffer);

    private final native void onDecodeInit(long ptr, int channelCount, int sampleRate, int sampleDepth);

    @JvmStatic
    public static final void startDecode(long ptr, @NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkParameterIsNotNull(byteBuffer, "byteBuffer");
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            try {
                mediaExtractor.setDataSource(new ByteBufferDataSource(byteBuffer));
                INSTANCE.doDecode(ptr, mediaExtractor);
            } catch (Exception e16) {
                INSTANCE.onDecodeEnd(ptr, false);
                Log.e(TAG, "startDecode: fail.", e16);
            }
        } finally {
            mediaExtractor.release();
        }
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        audioCachePath = new File(context.getCacheDir(), "minigamewebaudio").getAbsolutePath();
    }

    /* compiled from: P */
    @RequiresApi(23)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioDecoder$ByteBufferDataSource;", "Landroid/media/MediaDataSource;", "byteBuffer", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "close", "", "getSize", "", "readAt", "", "position", "buffer", "", "offset", "size", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    private static final class ByteBufferDataSource extends MediaDataSource {
        private final ByteBuffer byteBuffer;

        public ByteBufferDataSource(@NotNull ByteBuffer byteBuffer) {
            Intrinsics.checkParameterIsNotNull(byteBuffer, "byteBuffer");
            this.byteBuffer = byteBuffer;
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return this.byteBuffer.capacity();
        }

        @Override // android.media.MediaDataSource
        public int readAt(long position, @NotNull byte[] buffer, int offset, int size) {
            Intrinsics.checkParameterIsNotNull(buffer, "buffer");
            if (position >= this.byteBuffer.capacity()) {
                return -1;
            }
            this.byteBuffer.position((int) position);
            int min = Math.min(this.byteBuffer.remaining(), size);
            this.byteBuffer.get(buffer, offset, min);
            return min;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
