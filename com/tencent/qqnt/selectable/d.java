package com.tencent.qqnt.selectable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d implements j {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static final int f362099m;

    /* renamed from: n, reason: collision with root package name */
    private static final int f362100n;

    /* renamed from: o, reason: collision with root package name */
    private static final int f362101o;

    /* renamed from: p, reason: collision with root package name */
    private static final int f362102p;

    /* renamed from: q, reason: collision with root package name */
    private static final int f362103q;

    /* renamed from: r, reason: collision with root package name */
    private static final int f362104r;

    /* renamed from: s, reason: collision with root package name */
    private static final int f362105s;

    /* renamed from: t, reason: collision with root package name */
    private static final int f362106t;

    /* renamed from: u, reason: collision with root package name */
    private static final int f362107u;

    /* renamed from: v, reason: collision with root package name */
    private static final int f362108v;

    /* renamed from: w, reason: collision with root package name */
    private static final int f362109w;

    /* renamed from: a, reason: collision with root package name */
    private boolean f362110a;

    /* renamed from: b, reason: collision with root package name */
    private PopupWindow f362111b;

    /* renamed from: c, reason: collision with root package name */
    private RoundImageView f362112c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f362113d;

    /* renamed from: e, reason: collision with root package name */
    private Canvas f362114e;

    /* renamed from: f, reason: collision with root package name */
    private long f362115f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f362116g;

    /* renamed from: h, reason: collision with root package name */
    private int f362117h;

    /* renamed from: i, reason: collision with root package name */
    private int f362118i;

    /* renamed from: j, reason: collision with root package name */
    private int f362119j;

    /* renamed from: k, reason: collision with root package name */
    private int[] f362120k;

    /* renamed from: l, reason: collision with root package name */
    private float f362121l;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30465);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        int dip2px = ScreenUtil.dip2px(172.0f);
        f362099m = dip2px;
        int dip2px2 = ScreenUtil.dip2px(72.0f);
        f362100n = dip2px2;
        int dip2px3 = dip2px + ScreenUtil.dip2px(16.0f);
        f362101o = dip2px3;
        f362102p = dip2px2 + ScreenUtil.dip2px(14.0f);
        f362103q = dip2px3 / 2;
        f362104r = ScreenUtil.dip2px(100.0f);
        f362105s = ScreenUtil.dip2px(20.0f);
        f362106t = ViewUtils.dpToPx(30.0f);
        f362107u = ViewUtils.dpToPx(8.0f);
        f362108v = ViewUtils.dpToPx(12.0f);
        f362109w = ScreenUtil.dip2px(4.0f);
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f362117h = -1;
        this.f362118i = -1;
        this.f362119j = -1;
        this.f362120k = new int[]{0, 0};
        this.f362121l = 1.0f;
        this.f362116g = new Rect();
    }

    private int b(int i3, int i16) {
        float f16;
        float f17;
        float f18;
        int i17;
        this.f362118i = this.f362117h;
        this.f362117h = i3;
        if (i16 == 0 && (i17 = this.f362119j) != -1) {
            if (i17 > i3) {
                if (i17 - i3 >= f362107u) {
                    this.f362119j = i3;
                }
                i3 = i17;
            } else if (i17 < i3) {
                if (i3 - i17 >= f362107u) {
                    this.f362119j = i3;
                }
                i3 = i17;
            }
        } else {
            this.f362119j = i3;
        }
        if (i16 == 0) {
            return i3 - f362106t;
        }
        if (i16 == 1) {
            f16 = i3;
            f17 = f362106t;
            f18 = 1.5f;
        } else {
            f16 = i3;
            f17 = f362106t;
            f18 = 0.5f;
        }
        return (int) (f16 - (f17 * f18));
    }

    public static RectF d(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }

    private void e(View view, int i3, int i16) {
        this.f362114e.setBitmap(this.f362113d);
        RectF d16 = d(view);
        g("start update ");
        float f16 = i3 - d16.left;
        float f17 = i16 - d16.top;
        float f18 = this.f362121l;
        if (f18 > 0.0f) {
            f16 /= f18;
            f17 /= f18;
        }
        h(f16, f17, 1.5f);
        this.f362114e.drawColor(-1);
        this.f362114e.scale(1.5f, 1.5f);
        Canvas canvas = this.f362114e;
        Rect rect = this.f362116g;
        canvas.translate(-rect.left, -rect.top);
        view.draw(this.f362114e);
        g("get Drawing cache ");
        this.f362114e.setBitmap(null);
        this.f362112c.setImageBitmap(this.f362113d);
    }

    private int f(int i3) {
        int i16;
        int i17 = this.f362117h;
        if (i17 == -1 || (i16 = this.f362118i) == -1) {
            return 0;
        }
        int i18 = f362108v;
        if (i3 > i16 + i18 && i17 > i16 + i18) {
            return 2;
        }
        if (i3 + i18 >= i16 || i17 + i18 >= i16) {
            return 0;
        }
        return 1;
    }

    private void g(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QMagnifier", 2, str + (System.currentTimeMillis() - this.f362115f));
        }
        this.f362115f = System.currentTimeMillis();
    }

    @Override // com.tencent.qqnt.selectable.j
    public void a(@NonNull View view, int i3, int i16, @NonNull View view2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), view2, Boolean.valueOf(z16));
            return;
        }
        if (this.f362111b == null) {
            this.f362115f = System.currentTimeMillis();
            PopupWindow popupWindow = new PopupWindow(BaseApplication.getContext());
            this.f362111b = popupWindow;
            popupWindow.setClippingEnabled(false);
            g("create popWindow ");
            View inflate = ((LayoutInflater) view.getContext().getSystemService("layout_inflater")).inflate(R.layout.f168226pr, (ViewGroup) null, false);
            RoundImageView roundImageView = (RoundImageView) inflate.findViewById(R.id.f164181ls);
            this.f362112c = roundImageView;
            roundImageView.setmRadius(f362109w, false);
            this.f362111b.setContentView(inflate);
            this.f362111b.setWidth(f362101o);
            this.f362111b.setHeight(f362102p);
            this.f362111b.setBackgroundDrawable(null);
            this.f362113d = Bitmap.createBitmap(f362099m, f362100n, Bitmap.Config.ARGB_8888);
            this.f362114e = new Canvas();
            g("create magnifier bitmap and canvas");
        }
        if (z16 || !this.f362110a) {
            e(view, i3, i16);
        }
        int b16 = b(i16, f(i16));
        if (this.f362110a) {
            this.f362111b.update(i3 - f362103q, b16 - f362104r, f362101o, f362102p);
        } else {
            this.f362111b.showAtLocation(view, 0, i3 - f362103q, b16 - f362104r);
        }
        this.f362110a = true;
    }

    @Override // com.tencent.qqnt.selectable.j
    public void c(int[] iArr, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, iArr, Float.valueOf(f16));
        } else {
            if (f16 <= 0.0f) {
                return;
            }
            int[] iArr2 = this.f362120k;
            iArr2[0] = iArr[0];
            iArr2[1] = iArr[1];
            this.f362121l = f16;
        }
    }

    @Override // com.tencent.qqnt.selectable.j
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f362111b.dismiss();
        this.f362110a = false;
        this.f362117h = -1;
        this.f362118i = -1;
        this.f362119j = -1;
    }

    public void h(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        float f19 = f17 - f362105s;
        Rect rect = this.f362116g;
        int i3 = f362099m;
        int i16 = f362100n;
        rect.set((int) (f16 - ((i3 / 2) / f18)), (int) (f19 - ((i16 / 2) / f18)), (int) (f16 + ((i3 / 2) / f18)), (int) (f19 + ((i16 / 2) / f18)));
    }

    @Override // com.tencent.qqnt.selectable.j
    public boolean isShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f362110a;
    }
}
