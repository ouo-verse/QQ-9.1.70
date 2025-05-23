package com.tencent.qqmini.sdk.launcher.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class BaseGameNavigationBar extends RelativeLayout {
    public BaseGameNavigationBar(Context context) {
        super(context);
    }

    public abstract void attachMiniAppContext(IMiniAppContext iMiniAppContext);

    public abstract ICapsuleButton getCapsuleButton();

    public abstract void requestLandscapeLayout();

    public abstract BaseGameNavigationBar setWindowInfo(WindowInfo windowInfo);

    public BaseGameNavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseGameNavigationBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
