package nr;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos.MediaCodecThumbnailGenerator;
import com.tencent.biz.qqstory.utils.d;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f420729a = "MediaUtil";

    /* compiled from: P */
    /* renamed from: nr.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10863a implements bs.a<Boolean, MediaCodecThumbnailGenerator.c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f420730a;

        C10863a(Object obj) {
            this.f420730a = obj;
        }

        @Override // bs.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call(Boolean bool, MediaCodecThumbnailGenerator.c cVar) {
            QLog.e(a.f420729a, 2, "MediaCodecThumbnailGenerator finished().");
            synchronized (this.f420730a) {
                this.f420730a.notifyAll();
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements bs.a<Boolean, MediaCodecThumbnailGenerator.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f420731a;

        b(c cVar) {
            this.f420731a = cVar;
        }

        @Override // bs.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call(Boolean bool, MediaCodecThumbnailGenerator.b bVar) {
            Bitmap bitmap = bVar.f68739b;
            if (bitmap == null) {
                return null;
            }
            c cVar = this.f420731a;
            cVar.f420732a = bitmap;
            cVar.f420733b = bVar.f68741d;
            QLog.e(a.f420729a, 2, "MediaCodecThumbnailGenerator progress " + bVar.f68741d);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f420732a;

        /* renamed from: b, reason: collision with root package name */
        public long f420733b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.media.MediaMetadataRetriever] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap c(String str, int i3) {
        MediaMetadataRetriever mediaMetadataRetriever;
        ?? j3 = d.j(str);
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        r1 = null;
        Bitmap bitmap = null;
        try {
            if (j3 == 0) {
                hd0.c.g(f420729a, "File note exist when getFrameAtTime(). videoPath = " + str + " millisecond = " + i3);
                return null;
            }
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (OutOfMemoryError e16) {
                e = e16;
                mediaMetadataRetriever = null;
            } catch (Throwable th5) {
                th = th5;
                if (mediaMetadataRetriever2 != null) {
                    mediaMetadataRetriever2.release();
                }
                throw th;
            }
            try {
                mediaMetadataRetriever.setDataSource(str);
                bitmap = mediaMetadataRetriever.getFrameAtTime(i3 * 1000, 0);
                j3 = mediaMetadataRetriever;
            } catch (OutOfMemoryError e17) {
                e = e17;
                QLog.d(f420729a, 1, "getFrameAtTime error, ", e);
                j3 = mediaMetadataRetriever;
            }
            j3.release();
            return bitmap;
        } catch (Throwable th6) {
            th = th6;
            mediaMetadataRetriever2 = j3;
        }
    }

    public static c d(String str, int i3) {
        Object obj = new Object();
        c cVar = new c();
        MediaCodecThumbnailGenerator mediaCodecThumbnailGenerator = new MediaCodecThumbnailGenerator();
        mediaCodecThumbnailGenerator.d(ThreadManagerV2.getSubThreadLooper());
        mediaCodecThumbnailGenerator.b(str, null, false, 480, i3, 10000, 1, true, new C10863a(obj), new b(cVar));
        synchronized (obj) {
            try {
                obj.wait(5000L);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
        return cVar;
    }

    public static long e(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            return Long.parseLong(extractMetadata);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            ms.a.d(f420729a, "[getVideoDuration]", e16);
            return 0L;
        } catch (RuntimeException e17) {
            ms.a.d(f420729a, "[getVideoDuration]", e17);
            return 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ea, code lost:
    
        if (r6 == null) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap b(String str, LocalMediaInfo localMediaInfo, long j3) {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            int i3 = localMediaInfo.mediaWidth;
            int i16 = localMediaInfo.mediaHeight;
            if (localMediaInfo.rotation % 180 != 0) {
                i16 = i3;
                i3 = i16;
            }
            bitmap = o71.b.e(str, i3, i16, false) == 0 ? TrimNative.isGetFrameReady() : false ? o71.b.a(j3, j3 - 500) : null;
            if (bitmap != null) {
                try {
                    ByteBuffer allocate = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getRowBytes());
                    bitmap.copyPixelsToBuffer(allocate);
                    allocate.rewind();
                    int i17 = i3 * i16;
                    int[] iArr = new int[i17];
                    for (int i18 = 0; i18 < i17; i18++) {
                        int i19 = allocate.get();
                        int i26 = allocate.get();
                        int i27 = allocate.get();
                        byte b16 = allocate.get();
                        if (b16 > 0 && b16 != 255) {
                            float f16 = b16 * 1.0f;
                            i19 = (int) (((i19 * 1.0f) / f16) * 255.0f);
                            i26 = (int) (((i26 * 1.0f) / f16) * 255.0f);
                            i27 = (int) (((i27 * 1.0f) / f16) * 255.0f);
                            if (i19 > 255) {
                                i19 = 255;
                            }
                            if (i26 > 255) {
                                i26 = 255;
                            }
                            if (i27 > 255) {
                                i27 = 255;
                            }
                        }
                        iArr[i18] = ((i19 << 16) & ITVKAsset.VOD_ASSET_MASK_BIT) | (-16777216) | ((i26 << 8) & 65280) | (i27 & 255);
                    }
                    bitmap = Bitmap.createBitmap(iArr, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                } catch (Throwable th5) {
                    th = th5;
                    QLog.e(f420729a, 1, "getFrame error, ", th);
                    if (bitmap == null) {
                    }
                    return bitmap;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            bitmap = null;
        }
        try {
            if (bitmap == null) {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever2.setDataSource(str);
                        bitmap = mediaMetadataRetriever2.getFrameAtTime(1000 * j3, 3);
                        mediaMetadataRetriever2.release();
                    } catch (Exception e16) {
                        e = e16;
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        QLog.e(f420729a, 1, "getFrame error, ", e);
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        QLog.e(f420729a, 1, "getFrame oom, ", e);
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        return bitmap;
                    } catch (Throwable th7) {
                        th = th7;
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    e = e18;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                }
            }
            return bitmap;
        } catch (Throwable th8) {
            th = th8;
        }
    }
}
