package om2;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.image.ApngImage;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f423137a;

    /* renamed from: g, reason: collision with root package name */
    private int[] f423143g;

    /* renamed from: j, reason: collision with root package name */
    protected Bitmap f423146j;

    /* renamed from: b, reason: collision with root package name */
    private long f423138b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f423139c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f423140d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f423141e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f423142f = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f423144h = 0;

    /* renamed from: i, reason: collision with root package name */
    protected int f423145i = -1;

    /* renamed from: k, reason: collision with root package name */
    private final int[] f423147k = new int[7];

    public boolean a() {
        this.f423139c = ApngImage.nativeGetNextFrame(this.f423138b, this.f423139c, this.f423146j, this.f423147k);
        int[] iArr = this.f423147k;
        if (iArr[5] != 0) {
            lm2.c.c("ApngDecoder", "decode fail, err=" + this.f423147k[5]);
            return false;
        }
        int i3 = iArr[3];
        this.f423145i = i3;
        if (i3 >= e()) {
            lm2.c.c("ApngDecoder", "decode fail, invalid frame index, " + this.f423145i + ">=" + e());
            return false;
        }
        this.f423143g[this.f423145i] = this.f423147k[4];
        return true;
    }

    public Bitmap b() {
        return this.f423146j.copy(Bitmap.Config.ARGB_8888, false);
    }

    public int c() {
        return f(d());
    }

    public int d() {
        return this.f423145i;
    }

    public int e() {
        return this.f423142f;
    }

    public int f(int i3) {
        return this.f423143g[this.f423145i];
    }

    protected void finalize() throws Throwable {
        super.finalize();
        i();
    }

    public String g() {
        return this.f423137a;
    }

    public boolean h(String str) {
        if (TextUtils.isEmpty(str) || this.f423137a != null) {
            return false;
        }
        this.f423138b = ApngImage.nativeStartDecode(str, this.f423147k, 0);
        int[] iArr = this.f423147k;
        if (iArr[5] != 0) {
            return false;
        }
        this.f423137a = str;
        int i3 = iArr[0];
        this.f423140d = i3;
        int i16 = iArr[1];
        this.f423141e = i16;
        int i17 = iArr[2];
        this.f423142f = i17;
        this.f423144h = iArr[6];
        this.f423145i = -1;
        this.f423143g = new int[i17];
        this.f423146j = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        return true;
    }

    public void i() {
        Bitmap bitmap = this.f423146j;
        if (bitmap != null) {
            bitmap.recycle();
            this.f423146j = null;
        }
        long j3 = this.f423139c;
        if (j3 != 0) {
            ApngImage.nativeFreeFrame(j3);
            this.f423139c = 0L;
        }
        long j16 = this.f423138b;
        if (j16 != 0) {
            ApngImage.nativeFreeImage(j16);
            this.f423138b = 0L;
        }
    }
}
