package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSConfigGuideFollowHintView extends QCircleBaseWidgetView {

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f90643d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f90644e;

    /* renamed from: f, reason: collision with root package name */
    private AlphaAnimation f90645f;

    public QFSConfigGuideFollowHintView(@NonNull Context context) {
        this(context, null);
    }

    private void initView() {
        this.f90643d = (LinearLayout) findViewById(R.id.f43711n8);
        this.f90644e = (LinearLayout) findViewById(R.id.f39641c8);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g8c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSConfigGuideFollowHintView";
    }

    public void o0() {
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSConfigGuideFollowHintView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QFSConfigGuideFollowHintView.this.f90643d != null && QFSConfigGuideFollowHintView.this.f90644e != null) {
                    QFSConfigGuideFollowHintView.this.f90643d.setVisibility(8);
                    QFSConfigGuideFollowHintView.this.f90644e.clearAnimation();
                    QFSConfigGuideFollowHintView.this.f90644e.setVisibility(8);
                    return;
                }
                QLog.e("QFSConfigGuideFollowHintView", 1, "[hideHintView] mErrorView || mLoadingView should not be null");
            }
        });
    }

    public void p0() {
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSConfigGuideFollowHintView.3
            @Override // java.lang.Runnable
            public void run() {
                if (QFSConfigGuideFollowHintView.this.f90643d != null && QFSConfigGuideFollowHintView.this.f90644e != null) {
                    QFSConfigGuideFollowHintView.this.f90644e.clearAnimation();
                    QFSConfigGuideFollowHintView.this.f90644e.setVisibility(8);
                    QFSConfigGuideFollowHintView.this.f90643d.setVisibility(0);
                    return;
                }
                QLog.e("QFSConfigGuideFollowHintView", 1, "[showError] mErrorView || mLoadingView should not be null");
            }
        });
    }

    public void q0() {
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSConfigGuideFollowHintView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QFSConfigGuideFollowHintView.this.f90643d != null && QFSConfigGuideFollowHintView.this.f90644e != null) {
                    QFSConfigGuideFollowHintView.this.f90643d.setVisibility(8);
                    QFSConfigGuideFollowHintView.this.f90644e.setVisibility(0);
                    if (QFSConfigGuideFollowHintView.this.f90645f == null) {
                        QFSConfigGuideFollowHintView.this.f90645f = new AlphaAnimation(1.0f, 0.75f);
                        QFSConfigGuideFollowHintView.this.f90645f.setRepeatMode(2);
                        QFSConfigGuideFollowHintView.this.f90645f.setRepeatCount(Integer.MAX_VALUE);
                        QFSConfigGuideFollowHintView.this.f90645f.setDuration(750L);
                    }
                    QFSConfigGuideFollowHintView.this.f90644e.startAnimation(QFSConfigGuideFollowHintView.this.f90645f);
                    return;
                }
                QLog.e("QFSConfigGuideFollowHintView", 1, "[showLoading] mErrorView || mLoadingView should not be null");
            }
        });
    }

    public QFSConfigGuideFollowHintView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSConfigGuideFollowHintView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initView();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
