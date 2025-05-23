package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class HorizontalBallLoadingView extends MetaballView {
    private float W;

    public HorizontalBallLoadingView(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.widget.MetaballView
    protected int c() {
        return (int) (((IUIToolsApi) QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 10.0f) * this.W);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.widget.MetaballView
    protected int e() {
        return (int) (((IUIToolsApi) QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 6.0f) * this.W);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.widget.MetaballView
    protected void i(Context context, AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, ((IResourceUtil) QRoute.api(IResourceUtil.class)).getBallLoadingView());
        this.W = obtainStyledAttributes.getFloat(((IResourceUtil) QRoute.api(IResourceUtil.class)).getBallLoadingViewBallScale(), 1.0f);
        obtainStyledAttributes.recycle();
    }

    public HorizontalBallLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i(context, attributeSet, 0);
    }

    public HorizontalBallLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        i(context, attributeSet, i3);
    }
}
