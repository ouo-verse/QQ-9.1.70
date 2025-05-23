package fs;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g {

    /* renamed from: j, reason: collision with root package name */
    private static boolean[] f400414j = new boolean[5];

    /* renamed from: a, reason: collision with root package name */
    public String f400415a;

    /* renamed from: b, reason: collision with root package name */
    public String f400416b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f400417c;

    /* renamed from: d, reason: collision with root package name */
    public Bitmap f400418d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f400419e;

    /* renamed from: f, reason: collision with root package name */
    public int f400420f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f400421g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f400422h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f400423i = false;

    public g(String str) {
        this.f400415a = str;
    }

    public static boolean a(int i3) {
        if (i3 < 0 || i3 > 4) {
            return true;
        }
        return f400414j[i3];
    }

    public static void b(int[] iArr) {
        for (int i3 = 0; i3 < 5; i3++) {
            if (iArr != null && iArr.length == 5) {
                boolean[] zArr = f400414j;
                zArr[i3] = zArr[i3] | (iArr[i3] > 0);
            } else {
                f400414j[i3] = false;
            }
        }
    }
}
