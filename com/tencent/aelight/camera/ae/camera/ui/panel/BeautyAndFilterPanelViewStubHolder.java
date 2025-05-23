package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.mobileqq.R;

/* loaded from: classes32.dex */
public class BeautyAndFilterPanelViewStubHolder extends com.tencent.aelight.camera.ae.camera.ui.a implements ao {

    /* renamed from: h, reason: collision with root package name */
    private AEProviderContainerView f62941h;

    /* renamed from: i, reason: collision with root package name */
    private AECaptureMode f62942i;

    public BeautyAndFilterPanelViewStubHolder(ViewStub viewStub) {
        super(viewStub);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void a() {
        if (k()) {
            this.f62941h.D();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void b(final AECaptureController aECaptureController, final com.tencent.aelight.camera.ae.part.c cVar) {
        m(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder.2
            @Override // java.lang.Runnable
            public void run() {
                BeautyAndFilterPanelViewStubHolder.this.f62941h.setCaptureMode(BeautyAndFilterPanelViewStubHolder.this.f62942i);
                BeautyAndFilterPanelViewStubHolder.this.f62941h.setControllerAndManager(aECaptureController, cVar);
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public boolean c() {
        if (k()) {
            return this.f62941h.s();
        }
        return false;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void d(AECaptureMode aECaptureMode) {
        this.f62942i = aECaptureMode;
        if (k()) {
            this.f62941h.setCaptureMode(aECaptureMode);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void e(final pq.a aVar) {
        m(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder.1
            @Override // java.lang.Runnable
            public void run() {
                pq.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(BeautyAndFilterPanelViewStubHolder.this.f62941h);
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void f() {
        if (k()) {
            this.f62941h.e();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void onClear() {
        if (k()) {
            this.f62941h.v();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void onDestroy() {
        if (k()) {
            this.f62941h.w();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void onResume() {
        if (k()) {
            this.f62941h.x();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void onStop() {
        if (k()) {
            this.f62941h.y();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ao
    public void show() {
        i();
        this.f62941h.setVisibility(0);
        this.f62941h.o();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.a
    protected void l(View view) {
        this.f62941h = (AEProviderContainerView) view.findViewById(R.id.rom);
    }
}
