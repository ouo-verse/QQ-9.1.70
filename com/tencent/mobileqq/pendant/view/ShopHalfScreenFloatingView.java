package com.tencent.mobileqq.pendant.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.tencent.mobileqq.pendant.AvatarPendantShopFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenTitleBarHeaderView;
import com.tencent.mobileqq.widget.qus.e;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ShopHalfScreenFloatingView extends QUSHalfScreenFloatingView {
    static IPatchRedirector $redirector_;

    /* renamed from: w0, reason: collision with root package name */
    public static int f257570w0;

    /* renamed from: x0, reason: collision with root package name */
    public static int f257571x0;

    /* renamed from: y0, reason: collision with root package name */
    public static int f257572y0;

    /* renamed from: s0, reason: collision with root package name */
    public PendantAvatarShopLayout f257573s0;

    /* renamed from: t0, reason: collision with root package name */
    private QUSHalfScreenTitleBarHeaderView f257574t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f257575u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f257576v0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f257577d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AvatarPendantShopFragment f257578e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f257579f;

        a(Context context, AvatarPendantShopFragment avatarPendantShopFragment, int i3) {
            this.f257577d = context;
            this.f257578e = avatarPendantShopFragment;
            this.f257579f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ShopHalfScreenFloatingView.this, context, avatarPendantShopFragment, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            ShopHalfScreenFloatingView.this.f257573s0 = new PendantAvatarShopLayout(this.f257577d);
            ShopHalfScreenFloatingView.this.f257573s0.y(this.f257578e);
            PendantAvatarShopLayout pendantAvatarShopLayout = ShopHalfScreenFloatingView.this.f257573s0;
            pendantAvatarShopLayout.f257526g = 23;
            return pendantAvatarShopLayout.t();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.f257579f - ViewUtils.dpToPx(16.0f);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements QUSBaseHalfScreenFloatingView.l {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShopHalfScreenFloatingView.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ShopHalfScreenFloatingView.this.setVisibility(8);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(HiHealthStatusCodes.CANCEL_SELECT_DEVICE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f257570w0 = 0;
        f257571x0 = 1;
        f257572y0 = 2;
    }

    public ShopHalfScreenFloatingView(@NonNull Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void U(String str) {
        QUSHalfScreenTitleBarHeaderView qUSHalfScreenTitleBarHeaderView = new QUSHalfScreenTitleBarHeaderView(getContext());
        this.f257574t0 = qUSHalfScreenTitleBarHeaderView;
        qUSHalfScreenTitleBarHeaderView.setTitle(str);
        this.f257574t0.setHalfScreenView(this);
        if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null)) {
            this.f257574t0.setBackgroundColor(-16777216);
            this.f257574t0.f317251e.setTextColor(-1);
            this.f257574t0.f317250d.setColorFilter(-1);
            this.f257574t0.setThemeId(1000);
            setThemeId(1000);
        } else {
            this.f257574t0.setBackgroundColor(-1);
            this.f257574t0.f317251e.setTextColor(-16777216);
            this.f257574t0.f317250d.setColorFilter(-16777216);
            this.f257574t0.setThemeId(1001);
            setThemeId(1001);
        }
        setHeaderView(this.f257574t0);
    }

    public void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        PendantAvatarShopLayout pendantAvatarShopLayout = this.f257573s0;
        if (pendantAvatarShopLayout != null) {
            pendantAvatarShopLayout.s();
        }
    }

    public void T(AvatarPendantShopFragment avatarPendantShopFragment, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) avatarPendantShopFragment, i3);
            return;
        }
        setQUSDragFloatController(new a(getContext(), avatarPendantShopFragment, i3));
        setDraggable(false);
        r();
        U("");
        setOutSideTouchEnable(false);
        setVisibility(4);
        setOnDismissListener(new b());
        this.f257576v0 = true;
    }

    public void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        PendantAvatarShopLayout pendantAvatarShopLayout = this.f257573s0;
        if (pendantAvatarShopLayout != null && this.f257575u0 == f257571x0) {
            pendantAvatarShopLayout.H();
        }
    }

    public void W(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (getVisibility() == 0 && this.f257575u0 == i3) {
            return;
        }
        this.f257575u0 = i3;
        setVisibility(0);
        if (i3 == f257570w0) {
            U("\u9009\u62e9" + com.tencent.mobileqq.vip.api.b.a().getSplendidTitle() + "\u5934\u50cf");
        } else if (i3 == f257571x0) {
            U("\u9009\u62e9\u8d85\u7ea7QQ\u79c0\u5934\u50cf");
            this.f257573s0.H();
        } else if (i3 == f257572y0) {
            U("\u9009\u62e9\u4e2a\u6027\u5934\u50cf");
            this.f257573s0.F();
        }
        P(1);
        invalidate();
    }

    public ShopHalfScreenFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ShopHalfScreenFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f257575u0 = -1;
            this.f257576v0 = false;
        }
    }
}
