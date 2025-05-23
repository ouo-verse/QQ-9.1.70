package com.tencent.mobileqq.signature.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.signature.SignTextEditFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenTitleBarHeaderView;
import com.tencent.mobileqq.widget.qus.e;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShopHalfScreenFloatingView extends QUSHalfScreenFloatingView {
    static IPatchRedirector $redirector_;

    /* renamed from: x0, reason: collision with root package name */
    public static int f288467x0;

    /* renamed from: s0, reason: collision with root package name */
    public SignatureBlockContainerLayout f288468s0;

    /* renamed from: t0, reason: collision with root package name */
    private QUSHalfScreenTitleBarHeaderView f288469t0;

    /* renamed from: u0, reason: collision with root package name */
    private SignTextEditFragment f288470u0;

    /* renamed from: v0, reason: collision with root package name */
    private int f288471v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f288472w0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f288473d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f288474e;

        a(Context context, int i3) {
            this.f288473d = context;
            this.f288474e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ShopHalfScreenFloatingView.this, context, Integer.valueOf(i3));
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
        public View getF58528d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            ShopHalfScreenFloatingView.this.f288468s0 = new SignatureBlockContainerLayout(this.f288473d);
            return ShopHalfScreenFloatingView.this.f288468s0;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.f288474e - ViewUtils.dpToPx(16.0f);
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
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f288467x0 = 0;
        }
    }

    public ShopHalfScreenFloatingView(@NonNull Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void T(String str) {
        QUSHalfScreenTitleBarHeaderView qUSHalfScreenTitleBarHeaderView = new QUSHalfScreenTitleBarHeaderView(getContext());
        this.f288469t0 = qUSHalfScreenTitleBarHeaderView;
        qUSHalfScreenTitleBarHeaderView.setTitle(str);
        this.f288469t0.setHalfScreenView(this);
        this.f288469t0.setBackgroundColor(-1);
        this.f288469t0.setThemeId(1001);
        this.f288469t0.f317250d.setColorFilter(-16777216);
        setHeaderView(this.f288469t0);
    }

    public void S(SignTextEditFragment signTextEditFragment, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) signTextEditFragment, i3);
            return;
        }
        Context context = getContext();
        this.f288470u0 = signTextEditFragment;
        setQUSDragFloatController(new a(context, i3));
        setDraggable(false);
        r();
        T("");
        setOutSideTouchEnable(false);
        setVisibility(4);
        setThemeId(1001);
        setOnDismissListener(new b());
        this.f288472w0 = true;
    }

    public void U(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (getVisibility() == 0 && this.f288471v0 == i3) {
            return;
        }
        this.f288471v0 = i3;
        setVisibility(0);
        if (i3 == f288467x0) {
            T("\u6dfb\u52a0\u8bdd\u9898");
            SignatureBlockContainerLayout signatureBlockContainerLayout = this.f288468s0;
            if (signatureBlockContainerLayout != null) {
                signatureBlockContainerLayout.b(f288467x0, this.f288470u0);
            }
            com.tencent.mobileqq.signature.report.a.c().s();
            com.tencent.mobileqq.signature.report.a.c().r(101);
        }
        P(1);
        invalidate();
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
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
            this.f288471v0 = -1;
            this.f288472w0 = false;
        }
    }
}
