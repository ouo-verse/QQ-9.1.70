package com.tencent.mobileqq.search.business.qcircle.video.base;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.widget.HorizontalListView;
import e80.g;
import lo2.z;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class QCircleSearchDoubleVideoView<T extends z> extends LinearLayout implements g, a, e80.a {

    /* renamed from: m, reason: collision with root package name */
    static final int f283061m = ViewUtils.dip2px(4.0f);

    /* renamed from: d, reason: collision with root package name */
    private HorizontalListView f283062d;

    /* renamed from: e, reason: collision with root package name */
    protected T f283063e;

    /* renamed from: f, reason: collision with root package name */
    private no2.a f283064f;

    /* renamed from: h, reason: collision with root package name */
    private mo2.a f283065h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a f283066i;

    /* JADX INFO: Access modifiers changed from: protected */
    public QCircleSearchDoubleVideoView(Context context) {
        super(context);
    }

    @Nullable
    private g e() {
        int h16;
        if (this.f283063e == null || this.f283062d == null || (h16 = h()) < 0) {
            return null;
        }
        KeyEvent.Callback child = this.f283062d.getChild(h16);
        if (child instanceof g) {
            return (g) child;
        }
        return null;
    }

    private int f() {
        if (this.f283064f == null) {
            return -1;
        }
        String value = this.f283066i.M1().getValue();
        if (TextUtils.isEmpty(value)) {
            return 0;
        }
        int count = this.f283064f.getCount();
        for (int i3 = 0; i3 < count; i3++) {
            if (this.f283064f.getItem(i3).f398449id.get().equals(value)) {
                return i3;
            }
        }
        return 0;
    }

    private int h() {
        int f16 = f();
        if (f16 > this.f283064f.getCount()) {
            this.f283066i.L1();
            return 0;
        }
        return f16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        g e16 = e();
        if (e16 == null) {
            return;
        }
        e16.a();
    }

    @Override // e80.a
    public View c() {
        return this.f283062d;
    }

    @CallSuper
    public void d(T t16) {
        if (this.f283063e == t16) {
            return;
        }
        this.f283063e = t16;
        if (this.f283066i.U1(t16)) {
            this.f283065h.L1();
        }
        this.f283064f.d(t16);
        this.f283066i.T1(t16.W());
    }

    @NonNull
    protected abstract Class<? extends com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a> g();

    protected abstract String i();

    @Override // e80.g
    public boolean isPlaying() {
        g e16 = e();
        if (e16 == null) {
            return false;
        }
        return e16.isPlaying();
    }

    @CallSuper
    public void j() {
        HorizontalListView horizontalListView = (HorizontalListView) findViewById(R.id.eap);
        this.f283062d = horizontalListView;
        horizontalListView.setOverScrollMode(2);
        this.f283062d.setDividerWidth(f283061m);
        VideoReport.setPageId(this.f283062d, "pg_search_result");
        VideoReport.setPageReportPolicy(this.f283062d, PageReportPolicy.REPORT_NONE);
        mo2.a aVar = (mo2.a) wo2.b.b(getContext(), mo2.a.class);
        this.f283065h = aVar;
        if (aVar == null) {
            this.f283065h = new mo2.a();
            QLog.w("QCircleSearchDoubleVideoView", 1, "#init: globalViewModel init fail");
        }
        com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a aVar2 = (com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a) wo2.b.b(getContext(), g());
        this.f283066i = aVar2;
        aVar2.Q1(i());
        this.f283066i.O1(getContext());
        no2.a k3 = k(this.f283062d, this.f283065h, this.f283066i, this);
        this.f283064f = k3;
        this.f283062d.setAdapter((ListAdapter) k3);
    }

    protected abstract no2.a k(HorizontalListView horizontalListView, mo2.a aVar, com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a aVar2, a aVar3);

    @Override // e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        g e16 = e();
        if (e16 == null) {
            return;
        }
        e16.pause();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        g e16 = e();
        if (e16 == null) {
            return;
        }
        e16.play();
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.a
    public void r() {
        if (!isShown()) {
            return;
        }
        KeyEvent.Callback child = this.f283062d.getChild((f() + 1) % this.f283064f.getCount());
        if (child instanceof g) {
            ((g) child).play();
        }
    }

    public void setHotSearchKeyWordId(String str) {
        QLog.i("QCircleSearchDoubleVideoView", 1, "#setHotSearchKeyWordId: searchWord=" + str);
        this.f283064f.e(str);
    }

    public void setSearchKeyWord(String str) {
        this.f283066i.W1(str);
    }

    @Override // e80.g
    public void stop() {
        g e16 = e();
        if (e16 == null) {
            return;
        }
        e16.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QCircleSearchDoubleVideoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QCircleSearchDoubleVideoView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.a
    public void b() {
    }
}
