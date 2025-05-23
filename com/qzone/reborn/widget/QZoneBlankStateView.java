package com.qzone.reborn.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneBlankStateView extends QZoneBaseWidgetView<uc.a> {

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f59608e;

    /* renamed from: f, reason: collision with root package name */
    private QUIButton f59609f;

    /* renamed from: h, reason: collision with root package name */
    private QUIButton f59610h;

    /* renamed from: i, reason: collision with root package name */
    private QUIEmptyState f59611i;

    /* renamed from: m, reason: collision with root package name */
    private QUIEmptyState f59612m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f59613a = "";

        /* renamed from: b, reason: collision with root package name */
        View.OnClickListener f59614b = null;

        /* renamed from: c, reason: collision with root package name */
        String f59615c = "";

        /* renamed from: d, reason: collision with root package name */
        View.OnClickListener f59616d = null;

        /* renamed from: e, reason: collision with root package name */
        QUIEmptyState.Builder f59617e;

        public QUIEmptyState.Builder a() {
            return this.f59617e;
        }

        public a b(QUIEmptyState.Builder builder) {
            this.f59617e = builder;
            return this;
        }

        public a c(View.OnClickListener onClickListener) {
            this.f59614b = onClickListener;
            return this;
        }

        public a d(String str) {
            this.f59613a = str;
            return this;
        }

        public a e(View.OnClickListener onClickListener) {
            this.f59616d = onClickListener;
            return this;
        }

        public a f(String str) {
            this.f59615c = str;
            return this;
        }
    }

    public QZoneBlankStateView(Context context) {
        super(context);
    }

    private void hideErrorView() {
        QUIEmptyState qUIEmptyState = this.f59612m;
        if (qUIEmptyState == null) {
            return;
        }
        qUIEmptyState.setVisibility(8);
    }

    private void m0(QUIEmptyState qUIEmptyState) {
        if (this.f59608e.getChildCount() > 0) {
            this.f59608e.addView(qUIEmptyState, 0);
        } else {
            this.f59608e.addView(qUIEmptyState);
        }
    }

    private void p0() {
        QUIEmptyState qUIEmptyState = this.f59611i;
        if (qUIEmptyState == null) {
            return;
        }
        qUIEmptyState.setVisibility(8);
    }

    private void r0() {
        if (this.f59608e.getChildCount() > 2) {
            this.f59608e.removeViewAt(0);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f1294160;
    }

    public boolean q0() {
        QUIEmptyState qUIEmptyState;
        return getVisibility() == 0 && (qUIEmptyState = this.f59611i) != null && qUIEmptyState.getVisibility() == 0;
    }

    public void s0() {
        if (getData() == null || getData().a() == null || getData().a().a() == null) {
            return;
        }
        r0();
        QUIEmptyState build = getData().a().a().build();
        this.f59611i = build;
        m0(build);
        u0(getData().a());
        v0(getData().a());
        hideErrorView();
        setVisibility(0);
    }

    public void showErrorView() {
        if (getData() == null || getData().b() == null || getData().a().a() == null) {
            return;
        }
        r0();
        QUIEmptyState build = getData().b().a().build();
        this.f59612m = build;
        m0(build);
        u0(getData().b());
        v0(getData().b());
        p0();
        setVisibility(0);
    }

    public void u0(a aVar) {
        if (this.f59609f == null) {
            return;
        }
        if (TextUtils.isEmpty(aVar.f59613a)) {
            this.f59609f.setVisibility(8);
            return;
        }
        this.f59609f.setText(aVar.f59613a);
        View.OnClickListener onClickListener = aVar.f59614b;
        if (onClickListener != null) {
            this.f59609f.setOnClickListener(onClickListener);
        }
        this.f59609f.setVisibility(0);
    }

    public void v0(a aVar) {
        if (this.f59610h == null) {
            return;
        }
        if (TextUtils.isEmpty(aVar.f59615c)) {
            this.f59610h.setVisibility(8);
            return;
        }
        this.f59610h.setText(aVar.f59615c);
        View.OnClickListener onClickListener = aVar.f59616d;
        if (onClickListener != null) {
            this.f59610h.setOnClickListener(onClickListener);
        }
        this.f59610h.setVisibility(0);
    }

    public QZoneBlankStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public void o0() {
        setVisibility(8);
    }

    public QZoneBlankStateView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initView();
    }

    private void initView() {
        this.f59608e = (LinearLayout) findViewById(R.id.mqw);
        this.f59609f = (QUIButton) findViewById(R.id.mqv);
        this.f59610h = (QUIButton) findViewById(R.id.mqx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(uc.a aVar, int i3) {
    }
}
