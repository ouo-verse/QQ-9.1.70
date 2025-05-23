package com.tencent.mobileqq.tvideo.authpay;

import android.view.ViewGroup;
import com.tencent.mobileqq.tvideo.authpay.a;
import com.tencent.paysdk.api.q;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c implements q {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f304355a;

    /* renamed from: b, reason: collision with root package name */
    private final a.f f304356b;

    public c(ViewGroup viewGroup, a.f fVar) {
        this.f304355a = viewGroup;
        this.f304356b = fVar;
    }

    @Override // com.tencent.paysdk.api.q
    public void a() {
        QLog.d("TVideoAuthPayWebViewLifecycle", 4, this.f304355a + " onReset ");
    }

    @Override // com.tencent.paysdk.api.q
    public void c() {
        QLog.d("TVideoAuthPayWebViewLifecycle", 4, this.f304355a + " onH5LoadOvertime ");
    }

    @Override // com.tencent.paysdk.api.q
    public void d() {
        QLog.d("TVideoAuthPayWebViewLifecycle", 4, this.f304355a + " onH5LoadFinish ");
    }

    @Override // com.tencent.paysdk.api.q
    public void h() {
        QLog.d("TVideoAuthPayWebViewLifecycle", 4, this.f304355a + " onH5Loading ");
    }

    @Override // com.tencent.paysdk.api.q
    public void onAttach() {
        QLog.d("TVideoAuthPayWebViewLifecycle", 4, this.f304355a + " onAttach ");
    }

    @Override // com.tencent.paysdk.api.q
    public void onCreate() {
        QLog.d("TVideoAuthPayWebViewLifecycle", 4, this.f304355a + " onCreate ");
    }

    @Override // com.tencent.paysdk.api.q
    public void onDetach() {
        QLog.d("TVideoAuthPayWebViewLifecycle", 4, this.f304355a + " onDetach ");
        ViewGroup viewGroup = this.f304355a;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        a.f fVar = this.f304356b;
        if (fVar != null) {
            fVar.a(false);
        }
    }

    @Override // com.tencent.paysdk.api.q
    public void onHide() {
        QLog.d("TVideoAuthPayWebViewLifecycle", 4, this.f304355a + " onHide ");
        ViewGroup viewGroup = this.f304355a;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        a.f fVar = this.f304356b;
        if (fVar != null) {
            fVar.a(false);
        }
    }

    @Override // com.tencent.paysdk.api.q
    public void onShow() {
        QLog.d("TVideoAuthPayWebViewLifecycle", 4, this.f304355a + " onShow ");
        ViewGroup viewGroup = this.f304355a;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        a.f fVar = this.f304356b;
        if (fVar != null) {
            fVar.a(true);
        }
    }
}
