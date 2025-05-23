package com.tencent.hippy.qq.view.tkd.listview;

import android.content.Context;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class HippyTKDCustomRefreshHeader extends FrameLayout {
    public HippyTKDCustomRefreshHeader(Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, getRefreshViewHeight()));
    }

    public abstract void endLoadingAnimation(String str);

    public abstract int getMasterRefreshTextAlpha();

    public abstract int getRefreshViewHeight();

    public abstract boolean isShowMasterRefreshText();

    public abstract boolean isShowMasterRefreshToastBg();

    public abstract void onFinishing();

    public abstract void onTranslating(int i3);

    public abstract void startLoadingAnimation();

    public abstract void startPulling();

    public abstract void startSettling();
}
