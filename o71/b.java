package o71;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f422178a;

    /* renamed from: b, reason: collision with root package name */
    private static int f422179b;

    /* renamed from: c, reason: collision with root package name */
    private static int f422180c;

    /* renamed from: d, reason: collision with root package name */
    private static int f422181d;

    public static Bitmap a(long j3, long j16) {
        int i3;
        int i16 = f422180c;
        if (i16 <= 0 || (i3 = f422181d) <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i16, i3, Bitmap.Config.ARGB_8888);
        if (TrimNative.getFrame(j3, j16, createBitmap) != 0) {
            if (createBitmap != null && !createBitmap.isRecycled()) {
                createBitmap.recycle();
            }
            return null;
        }
        return createBitmap;
    }

    public static Bitmap b(long j3, long j16) {
        int i3;
        int i16 = f422178a;
        if (i16 <= 0 || (i3 = f422179b) <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i16, i3, Bitmap.Config.ARGB_8888);
        if (TrimNative.getThumbnail(j3, j16, createBitmap) != 0) {
            if (createBitmap != null && !createBitmap.isRecycled()) {
                createBitmap.recycle();
            }
            return null;
        }
        return createBitmap;
    }

    public static int c(String str, int i3, int i16, int i17, int i18, int i19, int i26) {
        f422178a = i19;
        f422179b = i26;
        try {
            return TrimNative.prepare(str, i3, i16, i17, i18, i19, i26);
        } catch (Throwable th5) {
            QLog.e("ThumbnailUtils", 1, "init failed:" + Log.getStackTraceString(th5));
            return -444;
        }
    }

    public static int d(String str, int i3, int i16) {
        return e(str, i3, i16, true);
    }

    public static int e(String str, int i3, int i16, boolean z16) {
        f422180c = i3;
        f422181d = i16;
        if (z16) {
            if (i3 > i16) {
                f422180c = 480;
                f422181d = (int) (i16 / ((i3 * 1.0d) / 480.0d));
            } else {
                f422181d = 480;
                f422180c = (int) (i3 / ((i16 * 1.0d) / 480.0d));
            }
        }
        return TrimNative.initGetFrame(str, f422180c, f422181d);
    }
}
