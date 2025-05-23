package n15;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0003J2\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0003J\"\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Ln15/c;", "", "", "videoPath", "", "timeUs", "", "maxSize", "Landroid/graphics/Bitmap;", "e", "Landroid/media/MediaExtractor;", "extractor", "f", TAVOneClickFilmStickerEffect.TRACK_INDEX, "Landroid/media/MediaCodec;", "decoder", "Ln15/a;", "outputSurface", "seekTimeUs", "b", "c", "", "Z", "VERBOSE", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f418006a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean VERBOSE = false;

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap d(String videoPath, long j3, int i3) {
        Intrinsics.checkNotNullParameter(videoPath, "$videoPath");
        return f418006a.e(videoPath, j3, i3);
    }

    private final int f(MediaExtractor extractor) {
        boolean startsWith$default;
        int trackCount = extractor.getTrackCount();
        for (int i3 = 0; i3 < trackCount; i3++) {
            MediaFormat trackFormat = extractor.getTrackFormat(i3);
            Intrinsics.checkNotNullExpressionValue(trackFormat, "extractor.getTrackFormat(i)");
            String string = trackFormat.getString("mime");
            if (string != null) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(string, "video/", false, 2, null);
                if (startsWith$default) {
                    if (VERBOSE) {
                        Log.d("ExtractUtil", "Extractor selected track " + i3 + " (" + string + "): " + trackFormat);
                    }
                    return i3;
                }
            }
        }
        return -1;
    }

    public final Bitmap c(final String videoPath, final long timeUs, final int maxSize) throws ExecutionException, InterruptedException {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        return (Bitmap) ProxyExecutors.newSingleThreadExecutor().submit(new Callable() { // from class: n15.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Bitmap d16;
                d16 = c.d(videoPath, timeUs, maxSize);
                return d16;
            }
        }).get();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:13|(1:15)(1:53)|16|(1:52)(1:20)|(5:(2:22|(1:(8:25|26|27|28|29|30|31|32))(1:(8:50|26|27|28|29|30|31|32)))|29|30|31|32)|51|26|27|28) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a9, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bitmap e(String videoPath, long timeUs, int maxSize) throws IOException {
        MediaCodec mediaCodec;
        MediaExtractor mediaExtractor;
        int i3;
        a aVar;
        int i16 = maxSize;
        a aVar2 = null;
        try {
            File file = new File(videoPath);
            if (file.canRead()) {
                mediaExtractor = new MediaExtractor();
                try {
                    mediaExtractor.setDataSource(file.toString());
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    int f16 = f(mediaExtractor);
                    if (f16 >= 0) {
                        mediaExtractor.selectTrack(f16);
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(f16);
                        Intrinsics.checkNotNullExpressionValue(trackFormat, "extractor.getTrackFormat(trackIndex)");
                        int integer = trackFormat.containsKey("rotation-degrees") ? trackFormat.getInteger("rotation-degrees") : 0;
                        int integer2 = trackFormat.getInteger("width");
                        int integer3 = trackFormat.getInteger("height");
                        if (integer == 90 || integer == 270) {
                            integer3 = integer2;
                            integer2 = integer3;
                        }
                        try {
                            if (i16 > 0) {
                                float f17 = integer2 / integer3;
                                if (integer3 > integer2) {
                                    if (integer3 > i16) {
                                        int i17 = (int) (i16 * f17);
                                        i3 = i16;
                                        i16 = i17;
                                        aVar = new a(i16, i3);
                                        String string = trackFormat.getString("mime");
                                        Intrinsics.checkNotNull(string);
                                        mediaCodec = MediaCodec.createDecoderByType(string);
                                        mediaCodec.configure(trackFormat, aVar.getSurface(), (MediaCrypto) null, 0);
                                        mediaCodec.start();
                                        Bitmap b16 = b(mediaExtractor, f16, mediaCodec, aVar, timeUs);
                                        aVar.g();
                                        mediaCodec.stop();
                                        mediaCodec.release();
                                        mediaExtractor.release();
                                        return b16;
                                    }
                                } else if (integer2 > i16) {
                                    i3 = (int) (i16 / f17);
                                    aVar = new a(i16, i3);
                                    String string2 = trackFormat.getString("mime");
                                    Intrinsics.checkNotNull(string2);
                                    mediaCodec = MediaCodec.createDecoderByType(string2);
                                    mediaCodec.configure(trackFormat, aVar.getSurface(), (MediaCrypto) null, 0);
                                    mediaCodec.start();
                                    Bitmap b162 = b(mediaExtractor, f16, mediaCodec, aVar, timeUs);
                                    aVar.g();
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                    mediaExtractor.release();
                                    return b162;
                                }
                            }
                            mediaCodec.configure(trackFormat, aVar.getSurface(), (MediaCrypto) null, 0);
                            mediaCodec.start();
                            Bitmap b1622 = b(mediaExtractor, f16, mediaCodec, aVar, timeUs);
                            aVar.g();
                            mediaCodec.stop();
                            mediaCodec.release();
                            mediaExtractor.release();
                            return b1622;
                        } catch (Throwable th6) {
                            th = th6;
                            aVar2 = aVar;
                            if (aVar2 != null) {
                            }
                            if (mediaCodec != null) {
                            }
                            if (mediaCodec != null) {
                            }
                            if (mediaExtractor != null) {
                            }
                            throw th;
                        }
                        i16 = integer2;
                        i3 = integer3;
                        aVar = new a(i16, i3);
                        String string22 = trackFormat.getString("mime");
                        Intrinsics.checkNotNull(string22);
                        mediaCodec = MediaCodec.createDecoderByType(string22);
                    } else {
                        throw new RuntimeException("No video track found in " + file);
                    }
                } catch (Throwable th7) {
                    th = th7;
                    mediaCodec = null;
                    if (aVar2 != null) {
                    }
                    if (mediaCodec != null) {
                    }
                    if (mediaCodec != null) {
                    }
                    if (mediaExtractor != null) {
                    }
                    throw th;
                }
            } else {
                try {
                    throw new FileNotFoundException("Unable to read " + file);
                } catch (Throwable th8) {
                    th = th8;
                    mediaCodec = null;
                    mediaExtractor = null;
                    if (aVar2 != null) {
                        aVar2.g();
                    }
                    if (mediaCodec != null) {
                        mediaCodec.stop();
                    }
                    if (mediaCodec != null) {
                        mediaCodec.release();
                    }
                    if (mediaExtractor != null) {
                        mediaExtractor.release();
                    }
                    throw th;
                }
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bitmap b(MediaExtractor extractor, int trackIndex, MediaCodec decoder, a outputSurface, long seekTimeUs) throws IOException {
        String str;
        int i3;
        MediaCodec mediaCodec;
        int i16;
        boolean z16;
        MediaCodec mediaCodec2 = decoder;
        ByteBuffer[] inputBuffers = decoder.getInputBuffers();
        Intrinsics.checkNotNullExpressionValue(inputBuffers, "decoder.inputBuffers");
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int i17 = 0;
        Bitmap bitmap = null;
        int i18 = 0;
        boolean z17 = false;
        boolean z18 = false;
        while (!z17) {
            boolean z19 = VERBOSE;
            if (z19) {
                Log.d("ExtractUtil", "loop");
            }
            if (z18) {
                str = "ExtractUtil";
                i3 = i18;
            } else {
                int dequeueInputBuffer = mediaCodec2.dequeueInputBuffer(10000);
                if (dequeueInputBuffer < 0) {
                    str = "ExtractUtil";
                    i3 = i18;
                    if (z19) {
                        Log.d(str, "input buffer not available");
                    }
                } else {
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    int i19 = i18;
                    extractor.seekTo(seekTimeUs, 2);
                    int readSampleData = extractor.readSampleData(byteBuffer, i17);
                    if (readSampleData < 0) {
                        str = "ExtractUtil";
                        decoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        if (z19) {
                            Log.d(str, "sent input EOS");
                        }
                        i18 = i19;
                        z18 = true;
                    } else {
                        str = "ExtractUtil";
                        if (extractor.getSampleTrackIndex() != trackIndex) {
                            Log.w(str, "WEIRD: got sample from track " + extractor.getSampleTrackIndex() + ", expected " + trackIndex);
                        }
                        decoder.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, extractor.getSampleTime(), 0);
                        if (z19) {
                            Log.d(str, "submitted frame " + i19 + " to dec, size=" + readSampleData);
                        }
                        i18 = i19 + 1;
                        extractor.advance();
                    }
                    if (z17) {
                        mediaCodec = decoder;
                        int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000);
                        if (dequeueOutputBuffer == -1) {
                            if (z19) {
                                Log.d(str, "no output from decoder available");
                            }
                        } else if (dequeueOutputBuffer == -3) {
                            if (z19) {
                                Log.d(str, "decoder output buffers changed");
                            }
                        } else if (dequeueOutputBuffer == -2) {
                            MediaFormat outputFormat = decoder.getOutputFormat();
                            Intrinsics.checkNotNullExpressionValue(outputFormat, "decoder.outputFormat");
                            if (z19) {
                                Log.d(str, "decoder output format changed: " + outputFormat);
                            }
                        } else if (dequeueOutputBuffer < 0) {
                            Log.e(str, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                        } else {
                            if (z19) {
                                Log.d(str, "surface decoder given buffer " + dequeueOutputBuffer + " (size=" + bufferInfo.size + ")");
                            }
                            if ((bufferInfo.flags & 4) != 0) {
                                if (z19) {
                                    Log.d(str, "output EOS");
                                }
                                z17 = true;
                            }
                            boolean z26 = bufferInfo.size != 0;
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z26);
                            if (z26) {
                                if (z19) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("awaiting decode of frame ");
                                    z16 = 0;
                                    sb5.append(0);
                                    Log.d(str, sb5.toString());
                                } else {
                                    z16 = 0;
                                }
                                outputSurface.a();
                                outputSurface.b(z16);
                                bitmap = outputSurface.h(true);
                                if (z19) {
                                    Log.d(str, "result bitmap: " + bitmap);
                                }
                                z17 = true;
                                i16 = z16;
                                i17 = i16;
                                mediaCodec2 = mediaCodec;
                            } else {
                                mediaCodec2 = mediaCodec;
                                i17 = 0;
                            }
                        }
                    } else {
                        mediaCodec = decoder;
                    }
                    i16 = 0;
                    i17 = i16;
                    mediaCodec2 = mediaCodec;
                }
            }
            i18 = i3;
            if (z17) {
            }
            i16 = 0;
            i17 = i16;
            mediaCodec2 = mediaCodec;
        }
        return bitmap;
    }
}
