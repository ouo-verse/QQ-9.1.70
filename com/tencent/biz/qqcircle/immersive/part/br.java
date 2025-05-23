package com.tencent.biz.qqcircle.immersive.part;

import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.QFSInterceptGestureFrameLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class br extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: d, reason: collision with root package name */
    private QFSInterceptGestureFrameLayout f87787d;

    /* renamed from: e, reason: collision with root package name */
    private ViewStub f87788e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleInitBean f87789f;

    private boolean x9() {
        QCircleInitBean qCircleInitBean = this.f87789f;
        if (qCircleInitBean == null) {
            return false;
        }
        return qCircleInitBean.isMiddlePage();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSInterceptFrameLayoutPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return uq3.c.s0();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        View inflate;
        super.onInitView(view);
        this.f87789f = (QCircleInitBean) getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
        if (!x9()) {
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f44071o7);
        this.f87788e = viewStub;
        if (viewStub == null || (inflate = viewStub.inflate()) == null) {
            return;
        }
        inflate.setVisibility(0);
        QFSInterceptGestureFrameLayout qFSInterceptGestureFrameLayout = (QFSInterceptGestureFrameLayout) inflate.findViewById(R.id.f44061o6);
        this.f87787d = qFSInterceptGestureFrameLayout;
        if (qFSInterceptGestureFrameLayout == null) {
            return;
        }
        qFSInterceptGestureFrameLayout.setLayoutStateListener(new a());
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements QFSInterceptGestureFrameLayout.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSInterceptGestureFrameLayout.a
        public void a() {
            if (!fb0.a.b("QFSInterceptFrameLayoutPart_toast", uq3.c.g2())) {
                QCircleToast.o(uq3.c.f2(), 1);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSInterceptGestureFrameLayout.a
        public void c() {
            if (br.this.getActivity() != null) {
                br.this.getActivity().finish();
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSInterceptGestureFrameLayout.a
        public void b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSInterceptGestureFrameLayout.a
        public void onClose() {
        }
    }
}
