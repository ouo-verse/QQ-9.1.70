package com.tencent.mobileqq.ar.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

/* loaded from: classes11.dex */
public abstract class ScanEntryProviderView extends FrameLayout {
    protected boolean C;
    protected boolean D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    protected AppInterface f198778d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f198779e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f198780f;

    /* renamed from: h, reason: collision with root package name */
    protected View f198781h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.ar.model.a f198782i;

    /* renamed from: m, reason: collision with root package name */
    protected d f198783m;

    public ScanEntryProviderView(Context context, d dVar) {
        super(context);
        this.f198779e = false;
        this.C = false;
        this.D = false;
        this.E = true;
        this.f198780f = context;
        this.f198783m = dVar;
    }

    public void A() {
        com.tencent.mobileqq.ar.model.a aVar = this.f198782i;
        if (aVar != null) {
            aVar.K();
        }
    }

    public void C() {
        com.tencent.mobileqq.ar.model.a aVar = this.f198782i;
        if (aVar != null) {
            aVar.I();
        }
    }

    public void D() {
        this.D = false;
        this.C = true;
        com.tencent.mobileqq.ar.model.a aVar = this.f198782i;
        if (aVar != null) {
            aVar.I();
        }
    }

    public void E() {
        this.D = true;
        this.C = false;
        com.tencent.mobileqq.ar.model.a aVar = this.f198782i;
        if (aVar != null) {
            aVar.J();
        }
    }

    public void F() {
        com.tencent.mobileqq.ar.model.a aVar = this.f198782i;
        if (aVar != null) {
            aVar.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(boolean z16) {
        if (this.E != z16) {
            this.E = z16;
            d dVar = this.f198783m;
            if (dVar != null) {
                dVar.e(z16);
            }
        }
    }

    public void setAppInterface(AppInterface appInterface) {
        this.f198778d = appInterface;
    }

    public boolean u() {
        return false;
    }

    public void w() {
        ((ScanTorchActivity) this.f198780f).doOnBackPressed(false);
    }

    public boolean y() {
        return ((ScanTorchActivity) this.f198780f).isResume();
    }

    public abstract void z(Bundle bundle);

    public void B(ARCommonConfigInfo aRCommonConfigInfo) {
    }

    public void setRectAreas(Rect rect) {
    }

    public void v(boolean z16) {
    }

    public void x(String str) {
    }
}
