package com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.indicators.magicindicator.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class CommonNavigator extends FrameLayout implements bx3.a, a.InterfaceC9635a {
    static IPatchRedirector $redirector_;
    private float C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private List<Object> K;
    private DataSetObserver L;

    /* renamed from: d, reason: collision with root package name */
    private HorizontalScrollView f357055d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f357056e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f357057f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.qqnt.indicators.magicindicator.a f357058h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f357059i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f357060m;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    class a extends DataSetObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CommonNavigator.this);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                com.tencent.qqnt.indicators.magicindicator.a unused = CommonNavigator.this.f357058h;
                CommonNavigator.c(CommonNavigator.this);
                throw null;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    public CommonNavigator(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.C = 0.5f;
        this.D = true;
        this.E = true;
        this.J = true;
        this.K = new ArrayList();
        this.L = new a();
        com.tencent.qqnt.indicators.magicindicator.a aVar = new com.tencent.qqnt.indicators.magicindicator.a();
        this.f357058h = aVar;
        aVar.b(this);
    }

    static /* bridge */ /* synthetic */ com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.a c(CommonNavigator commonNavigator) {
        commonNavigator.getClass();
        return null;
    }

    private void e() {
        View inflate;
        removeAllViews();
        if (this.f357059i) {
            inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168358fr1, this);
        } else {
            inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168357fr0, this);
        }
        this.f357055d = (HorizontalScrollView) inflate.findViewById(R.id.iig);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.title_container);
        this.f357056e = linearLayout;
        linearLayout.setPadding(this.G, 0, this.F, 0);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.xme);
        this.f357057f = linearLayout2;
        if (this.H) {
            linearLayout2.getParent().bringChildToFront(this.f357057f);
        }
        f();
    }

    private void f() {
        if (this.f357058h.a() <= 0) {
            return;
        }
        getContext();
        throw null;
    }

    @Override // bx3.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            e();
        }
    }

    @Override // bx3.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onLayout(z16, i3, i16, i17, i18);
        }
    }

    public void setAdapter(com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        }
    }

    public void setAdjustMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f357059i = z16;
        }
    }

    public void setEnablePivotScroll(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.f357060m = z16;
        }
    }

    public void setFollowTouch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.E = z16;
        }
    }

    public void setIndicatorOnTop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, z16);
        } else {
            this.H = z16;
        }
    }

    public void setLeftPadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
        } else {
            this.G = i3;
        }
    }

    public void setReselectWhenLayout(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
        } else {
            this.J = z16;
        }
    }

    public void setRightPadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
        } else {
            this.F = i3;
        }
    }

    public void setScrollPivotX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        } else {
            this.C = f16;
        }
    }

    public void setSkimOver(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.I = z16;
            this.f357058h.c(z16);
        }
    }

    public void setSmoothScroll(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.D = z16;
        }
    }
}
