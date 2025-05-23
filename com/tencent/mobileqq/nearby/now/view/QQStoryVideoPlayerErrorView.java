package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.now.IHardCordUtil;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;

/* loaded from: classes15.dex */
public class QQStoryVideoPlayerErrorView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    protected TextView f252794d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f252795e;

    public QQStoryVideoPlayerErrorView(Context context) {
        super(context);
        a(context);
    }

    public void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(((IResourceUtil) QRoute.api(IResourceUtil.class)).getNearbyVideoPlayerErrorLayout(), (ViewGroup) this, true);
        this.f252794d = (TextView) inflate.findViewById(((IResourceUtil) QRoute.api(IResourceUtil.class)).getRetry());
        this.f252795e = (TextView) inflate.findViewById(((IResourceUtil) QRoute.api(IResourceUtil.class)).getTips());
    }

    public void b(int i3) {
        this.f252795e.setVisibility(0);
        this.f252794d.setVisibility(8);
    }

    public void c() {
        this.f252794d.setText(((IHardCordUtil) QRoute.api(IHardCordUtil.class)).qqStr(((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQStrQQStoryV88c3cc80()));
        this.f252794d.setVisibility(0);
        this.f252795e.setVisibility(8);
    }

    public void setOnRetryClickListener(View.OnClickListener onClickListener) {
        this.f252794d.setOnClickListener(onClickListener);
        this.f252795e.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        this.f252795e.setText(str);
    }

    public QQStoryVideoPlayerErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
