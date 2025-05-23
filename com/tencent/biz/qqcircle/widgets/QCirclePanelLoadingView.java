package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;

/* loaded from: classes5.dex */
public class QCirclePanelLoadingView extends QCircleBaseWidgetView {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f93041d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93042e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f93043f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f93044h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f93045i;

    public QCirclePanelLoadingView(@NonNull Context context) {
        this(context, null);
    }

    private void initView() {
        this.f93043f = LoadingUtil.getLoadingDrawable(getContext(), 2);
        ImageView imageView = (ImageView) findViewById(R.id.spu);
        this.f93041d = imageView;
        imageView.setImageDrawable(this.f93043f);
        TextView textView = (TextView) findViewById(R.id.yst);
        this.f93042e = textView;
        textView.setLetterSpacing(0.1f);
    }

    private void l0() {
        QLog.d("QCirclePanelLoadingView", 1, "innerShow");
        m0();
    }

    private void m0() {
        if (!this.f93044h) {
            return;
        }
        setVisibility(0);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g4s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCirclePanelLoadingView";
    }

    public void k0() {
        setVisibility(8);
        this.f93044h = false;
    }

    public void n0() {
        this.f93044h = true;
        l0();
    }

    public void o0(int i3) {
        int a16 = (i3 / 2) - cx.a(37.0f);
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.topMargin = a16;
            setLayoutParams(marginLayoutParams);
        }
        this.f93044h = true;
        l0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f93045i) {
            k0();
        }
    }

    public void setHintText(String str) {
        this.f93042e.setText(str);
    }

    public void setHintTextColor(@ColorInt int i3) {
        this.f93042e.setTextColor(i3);
    }

    public void setHintTextSize(float f16) {
        this.f93042e.setTextSize(f16);
    }

    public void setNeedHideWhenDetachedFromWindow(boolean z16) {
        this.f93045i = z16;
    }

    public QCirclePanelLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCirclePanelLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93044h = false;
        this.f93045i = true;
        initView();
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
