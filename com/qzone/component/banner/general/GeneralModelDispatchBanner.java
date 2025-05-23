package com.qzone.component.banner.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.qzone.component.banner.Banner;
import com.qzone.component.banner.general.GeneralModelDispatchBanner;
import com.qzone.component.banner.general.builder.GeneralModelBaseCardView;
import com.qzone.feed.business.model.a;
import com.tencent.qphone.base.util.QLog;
import gf.s;
import i6.b;
import i6.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GeneralModelDispatchBanner extends Banner implements s {

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f46570h;

    /* renamed from: i, reason: collision with root package name */
    private GeneralModelBaseCardView f46571i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f46572m;

    public GeneralModelDispatchBanner(Context context) {
        super(context);
        this.f46572m = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        g();
        this.f46571i = null;
    }

    @Override // gf.s
    public View R() {
        GeneralModelBaseCardView generalModelBaseCardView;
        if (l() && (generalModelBaseCardView = this.f46571i) != null) {
            return generalModelBaseCardView;
        }
        return null;
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 700;
    }

    @Override // com.qzone.component.banner.Banner
    public void destroy() {
        super.destroy();
        p();
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 30;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        FrameLayout frameLayout = this.f46570h;
        if (frameLayout == null || !this.f46297e || this.f46571i == null || this.f46572m) {
            return;
        }
        frameLayout.setVisibility(z16 ? 0 : 8);
        QLog.d("GeneralBusinessDispatchBanner", 1, "internal_show  needShow = " + z16);
        if (z16) {
            this.f46298f = false;
            return;
        }
        GeneralModelBaseCardView generalModelBaseCardView = this.f46571i;
        if (generalModelBaseCardView != null) {
            generalModelBaseCardView.a();
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        FrameLayout frameLayout;
        return this.f46297e && (frameLayout = this.f46570h) != null && frameLayout.getVisibility() == 0;
    }

    @Override // com.qzone.component.banner.Banner
    public void p() {
        super.p();
        QLog.d("GeneralBusinessDispatchBanner", 1, "mModelCardView=" + this.f46571i);
        GeneralModelBaseCardView generalModelBaseCardView = this.f46571i;
        if (generalModelBaseCardView != null) {
            generalModelBaseCardView.onDestroy();
        }
    }

    @Override // com.qzone.component.banner.Banner
    public void q() {
        super.q();
        GeneralModelBaseCardView generalModelBaseCardView = this.f46571i;
        if (generalModelBaseCardView != null) {
            generalModelBaseCardView.onPause();
        }
    }

    @Override // com.qzone.component.banner.Banner
    public void r() {
        super.r();
        GeneralModelBaseCardView generalModelBaseCardView = this.f46571i;
        if (generalModelBaseCardView != null) {
            generalModelBaseCardView.onResume();
        }
    }

    @Override // com.qzone.component.banner.Banner
    public void t(a aVar) {
        FrameLayout frameLayout = this.f46570h;
        if (frameLayout == null) {
            return;
        }
        frameLayout.removeAllViews();
        GeneralModelBaseCardView a16 = b.a(this.f46570h, new i6.a(aVar));
        this.f46571i = a16;
        if (a16 != null) {
            a16.setActionCallback(new d() { // from class: i6.c
                @Override // i6.d
                public final void b() {
                    GeneralModelDispatchBanner.this.v();
                }
            });
            this.f46571i.onInit();
            this.f46571i.setDividerLineVisible(true);
            c();
        }
    }

    public GeneralModelDispatchBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f46572m = false;
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        if (inflate instanceof FrameLayout) {
            this.f46570h = (FrameLayout) inflate;
            this.f46297e = true;
        }
    }
}
