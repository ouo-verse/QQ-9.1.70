package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.mobileqq.R;

/* loaded from: classes32.dex */
public class DYBeautyAndFilterPanelViewStubHolder extends com.tencent.aelight.camera.ae.camera.ui.a implements ao {

    /* renamed from: h, reason: collision with root package name */
    private DYAEProviderContainerView f63011h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f63012i;

    public DYBeautyAndFilterPanelViewStubHolder(ViewStub viewStub) {
        this(viewStub, true);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void a() {
        if (k()) {
            this.f63011h.v0();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void b(final AECaptureController aECaptureController, final com.tencent.aelight.camera.ae.part.c cVar) {
        m(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.DYBeautyAndFilterPanelViewStubHolder.2
            @Override // java.lang.Runnable
            public void run() {
                DYBeautyAndFilterPanelViewStubHolder.this.f63011h.setControllerAndManager(aECaptureController, cVar);
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public boolean c() {
        if (k()) {
            return this.f63011h.Y();
        }
        return false;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void d(AECaptureMode aECaptureMode) {
        if (k()) {
            this.f63011h.setCaptureMode(aECaptureMode);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void e(final pq.a aVar) {
        m(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.DYBeautyAndFilterPanelViewStubHolder.1
            @Override // java.lang.Runnable
            public void run() {
                pq.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(DYBeautyAndFilterPanelViewStubHolder.this.f63011h);
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void f() {
        if (k()) {
            this.f63011h.e();
        }
    }

    public void o() {
        this.f63011h.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.DYBeautyAndFilterPanelViewStubHolder.3
            @Override // java.lang.Runnable
            public void run() {
                DYBeautyAndFilterPanelViewStubHolder.this.f63011h.O();
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void onClear() {
        if (k()) {
            this.f63011h.b0();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void onDestroy() {
        if (k()) {
            this.f63011h.c0();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void onResume() {
        if (k()) {
            this.f63011h.d0();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void onStop() {
        if (k()) {
            this.f63011h.e0();
        }
    }

    public void p() {
        this.f63011h.u0(1);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void show() {
        i();
        this.f63011h.setVisibility(0);
        this.f63011h.Q();
    }

    public DYBeautyAndFilterPanelViewStubHolder(ViewStub viewStub, boolean z16) {
        super(viewStub);
        this.f63012i = z16;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.a
    protected void l(View view) {
        DYAEProviderContainerView dYAEProviderContainerView = (DYAEProviderContainerView) view.findViewById(R.id.rom);
        this.f63011h = dYAEProviderContainerView;
        dYAEProviderContainerView.V(view.getContext(), this.f63012i);
    }
}
