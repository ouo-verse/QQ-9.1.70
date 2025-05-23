package im2;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import androidx.annotation.RequiresApi;
import com.tencent.biz.qqstory.utils.d;
import hd0.c;

/* compiled from: P */
@RequiresApi(api = 16)
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f407997a = "0123456789ABCDEF".toCharArray();

    public static Bitmap a(String str, int i3) {
        Bitmap bitmap = null;
        if (!d.j(str)) {
            c.g("MediaUtil", "File note exist when getFrameAtTime(). videoPath = " + str + " millisecond = " + i3);
            return null;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        try {
            bitmap = mediaMetadataRetriever.getFrameAtTime(i3 * 1000, 0);
        } catch (OutOfMemoryError e16) {
            c.h("MediaUtil", "getFrameAtTime", e16);
        }
        mediaMetadataRetriever.release();
        return bitmap;
    }

    public static void b(String str, String str2) {
        Bitmap a16 = a(str, 0);
        if (a16 != null) {
            com.tencent.biz.qqstory.utils.b.a(a16, Bitmap.CompressFormat.JPEG, 80, str2);
        }
    }

    public static long c(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        long j3 = 0;
        try {
            mediaMetadataRetriever.setDataSource(str);
            try {
                j3 = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
            mediaMetadataRetriever.release();
            return j3;
        } catch (Error e17) {
            c.h("MediaUtil", "getVideoDuration path=" + str + " exists=" + d.j(str), e17);
            mediaMetadataRetriever.release();
            return 0L;
        } catch (RuntimeException e18) {
            c.h("MediaUtil", "getVideoDuration path=" + str + " exists=" + d.j(str), e18);
            mediaMetadataRetriever.release();
            return 0L;
        }
    }
}
