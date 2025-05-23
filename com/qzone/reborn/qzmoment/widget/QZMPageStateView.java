package com.qzone.reborn.qzmoment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.FrameLayout;
import bn.h;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.mobileqq.R;

/* loaded from: classes37.dex */
public class QZMPageStateView extends QZoneBaseWidgetView<h> {

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f59135e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f59136f;

    public QZMPageStateView(Context context) {
        super(context);
    }

    private void n0() {
        ViewStub viewStub;
        if (this.f59135e == null && (viewStub = (ViewStub) findViewById(R.id.nm9)) != null) {
            this.f59135e = (FrameLayout) viewStub.inflate();
            this.f59135e.addView(getData().a().build());
        }
    }

    private void o0() {
        ViewStub viewStub;
        if (this.f59136f == null && (viewStub = (ViewStub) findViewById(R.id.nm_)) != null) {
            this.f59136f = (FrameLayout) viewStub.inflate();
            this.f59136f.addView(getData().b().build());
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f128453e;
    }

    public void p0() {
        if (getData() == null || getData().a() == null) {
            return;
        }
        n0();
        FrameLayout frameLayout = this.f59135e;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        FrameLayout frameLayout2 = this.f59136f;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        setVisibility(0);
    }

    public void showErrorView() {
        if (getData() == null || getData().b() == null) {
            return;
        }
        o0();
        FrameLayout frameLayout = this.f59136f;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        FrameLayout frameLayout2 = this.f59135e;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        setVisibility(0);
    }

    public QZMPageStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(h hVar, int i3) {
    }
}
