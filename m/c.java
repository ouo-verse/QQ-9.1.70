package m;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import com.Vas.ColorFont.FreeTypeLib;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IFontHelper;
import com.tencent.mobileqq.vas.api.g;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f415878f = g.f308459b.isDebugVersion();

    /* renamed from: g, reason: collision with root package name */
    private static c f415879g;

    /* renamed from: a, reason: collision with root package name */
    private FreeTypeLib f415880a = new FreeTypeLib();

    /* renamed from: b, reason: collision with root package name */
    private a f415881b = new a(8);

    /* renamed from: c, reason: collision with root package name */
    public AtomicBoolean f415882c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public AtomicBoolean f415883d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    public AtomicBoolean f415884e = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class a extends LruCache<Integer, String> {
        public a(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z16, Integer num, String str, String str2) {
            super.entryRemoved(z16, num, str, str2);
            d.b("FastColorFontHelper", "release start font " + str);
            c.this.i(num.intValue());
            b.a(num.intValue());
            d.b("FastColorFontHelper", "release end   font " + str);
        }
    }

    c() {
    }

    public static c e() {
        if (f415879g == null) {
            synchronized (c.class) {
                if (f415879g == null) {
                    f415879g = new c();
                }
            }
        }
        return f415879g;
    }

    public int[] a(int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7, int[] iArr8, int i16, int i17, int i18, long j3) {
        return this.f415880a.calculateExpressionSize(i3, iArr, iArr2, iArr3, iArr4, iArr5, iArr6, iArr7, iArr8, i16, i17, i18, j3);
    }

    public int b(int i3, Bitmap bitmap, Bitmap bitmap2) {
        return this.f415880a.getExtraBitmap(i3, bitmap, bitmap2, 0);
    }

    public int c(int i3, Bitmap bitmap, Bitmap bitmap2, int i16) {
        return this.f415880a.getExtraBitmap(i3, bitmap, bitmap2, i16);
    }

    public FreeTypeLib d() {
        return this.f415880a;
    }

    public void f(int i3, int[] iArr, int i16, int[] iArr2) {
        this.f415880a.getTextWidths(i3, iArr, i16, iArr2);
    }

    public Boolean g(int i3) {
        return Boolean.valueOf(!TextUtils.isEmpty(this.f415881b.get(Integer.valueOf(i3))));
    }

    public int h(int i3, String str) {
        if (TextUtils.isEmpty(this.f415881b.get(Integer.valueOf(i3)))) {
            this.f415881b.put(Integer.valueOf(i3), str);
            int[] iArr = new int[5];
            long currentTimeMillis = System.currentTimeMillis();
            int initColorFont = this.f415880a.initColorFont(i3, str, iArr);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 250) {
                ((IFontHelper) QRoute.api(IFontHelper.class)).report(i3, currentTimeMillis2, "initColorFont", String.valueOf(initColorFont));
            }
            d.b("FastColorFontHelper", "initColorFont cost:" + currentTimeMillis2 + " fontId=" + i3 + "  fontWidth:" + iArr[1] + "  fontHeight:" + iArr[2] + "  lineSpace:" + iArr[0] + "  path=" + str);
            int i16 = initColorFont / 100;
            if (i16 >= 2) {
                b.r(i3, i16);
                b.p(i3, initColorFont % 100);
                b.t(i3, iArr[0]);
                b.s(i3, iArr[1]);
                b.n(i3, iArr[2]);
                b.q(i3, iArr[3]);
                b.o(i3, iArr[4]);
            }
            if (i3 >= 8388608 || i3 <= -8388608) {
                d.a("FastColorFontHelper", "\u4e3a\u4e86\u7f13\u5b58\u4e0d\u51fa\u73b0\u95ee\u9898\uff0c\u5b57\u4f53id\u6700\u597d\u9650\u5236\u57283\u4e2a\u5b57\u8282\u4ee5\u5185\uff01");
            }
            return initColorFont;
        }
        d.b("FastColorFontHelper", "\u8be5\u5b57\u4f53\u5df2\u7ecf\u521d\u59cb\u5316  fontId=" + i3 + "  path=" + str);
        return 0;
    }

    public int i(int i3) {
        return this.f415880a.releaseColorFont(i3);
    }

    public int j(int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, Bitmap bitmap, Bitmap bitmap2, int i16, int i17, int i18, int i19, int i26, long j3, int i27, int[] iArr6) {
        return this.f415880a.drawAnimationText(i3, iArr, iArr2, iArr3, iArr4, iArr5, bitmap, bitmap2, i16, i17, i18, i19, i26, j3, i27, iArr6, 0);
    }

    public int k(int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int i16, int i17, int i18, long j3, int i19, Bitmap bitmap, int[] iArr7, int i26) {
        return this.f415880a.renderExpressionBitmap(i3, iArr, iArr2, iArr3, iArr4, iArr5, iArr6, i16, i17, i18, j3, i19, bitmap, iArr7, i26);
    }

    public int l(int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, Bitmap bitmap, int i16, int i17, int i18, int[] iArr6, int i19) {
        return this.f415880a.drawText(i3, iArr, iArr2, iArr3, iArr4, iArr5, bitmap, i16, i17, 0, i18, iArr6, i19);
    }

    public int m(int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, Bitmap bitmap, int i16, int i17, int i18) {
        return this.f415880a.drawText(i3, iArr, iArr2, iArr3, iArr4, iArr5, bitmap, i16, i17, i18, 0, null, 0);
    }

    public int n(int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, Bitmap bitmap, Bitmap bitmap2, int i16, int i17, int i18, int i19, int i26, long j3, int i27, int[] iArr7, int i28) {
        return this.f415880a.drawStrikingText(i3, iArr, iArr2, iArr3, iArr4, iArr5, iArr6, bitmap, bitmap2, i16, i17, i18, i19, i26, j3, i27, iArr7, i28);
    }
}
