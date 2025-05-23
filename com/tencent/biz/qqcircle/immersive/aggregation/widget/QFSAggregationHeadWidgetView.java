package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.widget.immersive.ImmersiveUtils;
import qqcircle.QQCircleFeedBase$StMusicPageData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAggregationHeadWidgetView extends QCircleBaseWidgetView<QQCircleFeedBase$StMusicPageData> implements LifecycleOwner {

    /* renamed from: d, reason: collision with root package name */
    private LifecycleRegistry f84788d;

    /* renamed from: e, reason: collision with root package name */
    private int f84789e;

    /* renamed from: f, reason: collision with root package name */
    private double f84790f;

    /* renamed from: h, reason: collision with root package name */
    private float f84791h;

    /* renamed from: i, reason: collision with root package name */
    private float f84792i;

    /* renamed from: m, reason: collision with root package name */
    private float f84793m;

    public QFSAggregationHeadWidgetView(@NonNull Context context) {
        super(context);
        l0(context);
    }

    private void l0(Context context) {
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f84788d = lifecycleRegistry;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        this.f84789e = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f84791h = ImmersiveUtils.getScreenWidth();
        this.f84790f = Math.tan(0.5235987755982988d);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f84788d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSAggregationHeadWidgetView";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f84788d.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                float abs = Math.abs(this.f84792i - x16);
                float abs2 = Math.abs(this.f84793m - y16);
                if (x16 - this.f84792i > this.f84789e && abs * this.f84790f > abs2) {
                    return true;
                }
            }
        } else {
            this.f84792i = motionEvent.getX();
            this.f84793m = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            float x16 = motionEvent.getX();
            float f16 = this.f84792i;
            if (x16 - f16 > 0.0f && x16 - f16 >= this.f84791h / 4.0f && (getContext() instanceof Activity)) {
                ((Activity) getContext()).onBackPressed();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData, int i3) {
    }
}
