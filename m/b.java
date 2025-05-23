package m;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.util.SparseIntArray;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, BitmapShader> f415867a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, BitmapShader> f415868b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, Bitmap> f415869c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<String, Bitmap> f415870d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private static SparseIntArray f415871e = new SparseIntArray();

    /* renamed from: f, reason: collision with root package name */
    private static SparseIntArray f415872f = new SparseIntArray();

    /* renamed from: g, reason: collision with root package name */
    private static SparseIntArray f415873g = new SparseIntArray();

    /* renamed from: h, reason: collision with root package name */
    private static SparseIntArray f415874h = new SparseIntArray();

    /* renamed from: i, reason: collision with root package name */
    private static SparseIntArray f415875i = new SparseIntArray();

    /* renamed from: j, reason: collision with root package name */
    private static SparseIntArray f415876j = new SparseIntArray();

    /* renamed from: k, reason: collision with root package name */
    private static SparseIntArray f415877k = new SparseIntArray();

    public static void a(int i3) {
        int indexOfKey = f415871e.indexOfKey(i3);
        if (indexOfKey >= 0) {
            f415871e.removeAt(indexOfKey);
        }
        int indexOfKey2 = f415872f.indexOfKey(i3);
        if (indexOfKey2 >= 0) {
            f415872f.removeAt(indexOfKey2);
        }
        int indexOfKey3 = f415873g.indexOfKey(i3);
        if (indexOfKey3 >= 0) {
            f415873g.removeAt(indexOfKey3);
        }
        int indexOfKey4 = f415874h.indexOfKey(i3);
        if (indexOfKey4 >= 0) {
            f415874h.removeAt(indexOfKey4);
        }
        int indexOfKey5 = f415875i.indexOfKey(i3);
        if (indexOfKey5 >= 0) {
            f415875i.removeAt(indexOfKey5);
        }
        int indexOfKey6 = f415876j.indexOfKey(i3);
        if (indexOfKey6 >= 0) {
            f415876j.removeAt(indexOfKey6);
        }
        int indexOfKey7 = f415877k.indexOfKey(i3);
        if (indexOfKey7 >= 0) {
            f415877k.removeAt(indexOfKey7);
        }
    }

    public static Bitmap b(int i3, int i16, int i17, int i18) {
        return f415869c.get(i3 + "_" + i16 + "_" + i17 + "_" + i18);
    }

    public static BitmapShader c(int i3, int i16, int i17, int i18) {
        return f415867a.get(i3 + "_" + i16 + "_" + i17 + "_" + i18);
    }

    public static int d(int i3) {
        return f415875i.get(i3, 256);
    }

    public static int e(int i3) {
        return f415877k.get(i3, 0);
    }

    public static int f(int i3) {
        return f415872f.get(i3, 0);
    }

    public static int g(int i3) {
        return f415876j.get(i3, 0);
    }

    public static int h(int i3) {
        return f415871e.get(i3, 0);
    }

    public static int i(int i3) {
        return f415874h.get(i3, 256);
    }

    public static int j(int i3) {
        return f415873g.get(i3);
    }

    public static Bitmap k(int i3, int i16, int i17, int i18) {
        return f415870d.get(i3 + "_" + i16 + "_" + i17 + "_" + i18);
    }

    public static void l(int i3, int i16, int i17, int i18, Bitmap bitmap) {
        String str = i3 + "_" + i16 + "_" + i17 + "_" + i18;
        if (!f415869c.containsKey(str) && bitmap != null) {
            f415869c.put(str, bitmap);
        }
    }

    public static void m(int i3, int i16, int i17, int i18, BitmapShader bitmapShader) {
        String str = i3 + "_" + i16 + "_" + i17 + "_" + i18;
        if (!f415867a.containsKey(str) && bitmapShader != null) {
            f415867a.put(str, bitmapShader);
        }
    }

    public static void n(int i3, int i16) {
        if (i16 > 0) {
            f415875i.put(i3, i16);
        }
    }

    public static void o(int i3, int i16) {
        f415877k.put(i3, i16);
    }

    public static void p(int i3, int i16) {
        f415872f.put(i3, i16);
    }

    public static void q(int i3, int i16) {
        f415876j.put(i3, i16);
    }

    public static void r(int i3, int i16) {
        f415871e.put(i3, i16);
    }

    public static void s(int i3, int i16) {
        if (i16 > 0) {
            f415874h.put(i3, i16);
        }
    }

    public static void t(int i3, int i16) {
        f415873g.put(i3, i16);
    }

    public static void u(int i3, int i16, int i17, int i18, Bitmap bitmap) {
        String str = i3 + "_" + i16 + "_" + i17 + "_" + i18;
        if (!f415870d.containsKey(str) && bitmap != null) {
            f415870d.put(str, bitmap);
        }
    }
}
