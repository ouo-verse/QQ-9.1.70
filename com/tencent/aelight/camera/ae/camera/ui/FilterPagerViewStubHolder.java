package com.tencent.aelight.camera.ae.camera.ui;

import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class FilterPagerViewStubHolder extends a {

    /* renamed from: h, reason: collision with root package name */
    private VideoFilterViewPager f62332h;

    public FilterPagerViewStubHolder(ViewStub viewStub) {
        super(viewStub);
    }

    public fm2.d o() {
        final fm2.d dVar = new fm2.d(null);
        m(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder.2
            @Override // java.lang.Runnable
            public void run() {
                dVar.a(FilterPagerViewStubHolder.this.f62332h);
            }
        });
        return dVar;
    }

    public void p() {
        if (k()) {
            this.f62332h.E();
        }
    }

    public void q(final boolean z16) {
        i();
        m(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder.1
            @Override // java.lang.Runnable
            public void run() {
                FilterPagerViewStubHolder.this.f62332h.setIsNormalMode(z16);
            }
        });
    }

    public void r(final int i3) {
        m(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder.5
            @Override // java.lang.Runnable
            public void run() {
                FilterPagerViewStubHolder.this.f62332h.P(i3);
            }
        });
    }

    public void t(final VideoFilterViewPager.b bVar) {
        m(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder.4
            @Override // java.lang.Runnable
            public void run() {
                FilterPagerViewStubHolder.this.f62332h.setSecleteCallBack(bVar);
            }
        });
    }

    public void u(boolean z16) {
        i();
        VideoFilterViewPager videoFilterViewPager = this.f62332h;
        if (videoFilterViewPager != null) {
            videoFilterViewPager.setDisableScroll(!z16);
            this.f62332h.F(!z16);
        }
        VideoFilterViewPager videoFilterViewPager2 = this.f62332h;
        if (videoFilterViewPager2 != null) {
            videoFilterViewPager2.setIsNormalMode(z16);
            if (!z16) {
                this.f62332h.P(0);
            } else {
                this.f62332h.U();
            }
        }
    }

    public void w(final boolean z16) {
        i();
        this.f62332h.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder.3
            @Override // java.lang.Runnable
            public void run() {
                m.a aVar = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).I;
                VideoFilterViewPager videoFilterViewPager = FilterPagerViewStubHolder.this.f62332h;
                if (videoFilterViewPager != null && aVar != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - comboFilterData not null");
                    }
                    videoFilterViewPager.setCaptureScene(0);
                    videoFilterViewPager.V();
                    if (!z16) {
                        FilterPagerViewStubHolder.this.f62332h.P(0);
                        return;
                    } else {
                        FilterPagerViewStubHolder.this.f62332h.U();
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - filterPager is null or comboFilterData is null");
                }
            }
        });
    }

    public void v(boolean z16) {
        if (z16 || k()) {
            i();
            this.f62332h.setVisibility(z16 ? 0 : 4);
            this.f62332h.setEnabled(z16);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.a
    protected void l(View view) {
        this.f62332h = (VideoFilterViewPager) view.findViewById(R.id.f163755ru2);
    }

    public void s() {
    }
}
