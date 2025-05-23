package com.tencent.aelight.camera.ae.flashshow.ui.panel;

import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.ae.flashshow.ui.LSCaptureController;
import com.tencent.mobileqq.R;

/* loaded from: classes32.dex */
public class LSBeautyAndFilterPanelViewStubHolder extends com.tencent.aelight.camera.ae.flashshow.tips.c implements d {

    /* renamed from: d, reason: collision with root package name */
    private LSProviderContainerView f64941d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f64942e;

    /* renamed from: f, reason: collision with root package name */
    private int f64943f;

    /* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.panel.LSBeautyAndFilterPanelViewStubHolder$3, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ LSBeautyAndFilterPanelViewStubHolder this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f64941d.K();
        }
    }

    public LSBeautyAndFilterPanelViewStubHolder(ViewStub viewStub) {
        this(viewStub, true);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.panel.d
    public void a(final jq.b bVar) {
        f(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.LSBeautyAndFilterPanelViewStubHolder.1
            @Override // java.lang.Runnable
            public void run() {
                jq.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(LSBeautyAndFilterPanelViewStubHolder.this.f64941d);
                }
            }
        });
    }

    public void h() {
        if (d()) {
            this.f64941d.e();
        }
    }

    public void i() {
        this.f64941d.k0(3);
    }

    public void j(final LSCaptureController lSCaptureController, final lq.b bVar) {
        f(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.LSBeautyAndFilterPanelViewStubHolder.2
            @Override // java.lang.Runnable
            public void run() {
                LSBeautyAndFilterPanelViewStubHolder.this.f64941d.setControllerAndManager(lSCaptureController, bVar);
            }
        });
    }

    public void k(int i3) {
        this.f64943f = i3;
    }

    public void l() {
        c();
        this.f64941d.setVisibility(0);
        this.f64941d.M();
    }

    public LSBeautyAndFilterPanelViewStubHolder(ViewStub viewStub, boolean z16) {
        super(viewStub);
        this.f64943f = 0;
        this.f64942e = z16;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.tips.c
    protected void e(View view) {
        LSProviderContainerView lSProviderContainerView = (LSProviderContainerView) view.findViewById(R.id.rom);
        this.f64941d = lSProviderContainerView;
        lSProviderContainerView.S(view.getContext(), this.f64942e, this.f64943f);
    }
}
