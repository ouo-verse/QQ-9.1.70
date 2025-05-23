package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar;

/* compiled from: P */
/* loaded from: classes33.dex */
public class EmptyCustomMiniGameNavigationBar extends BaseGameNavigationBar {
    public EmptyCustomMiniGameNavigationBar(Context context) {
        super(context);
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar
    public ICapsuleButton getCapsuleButton() {
        return null;
    }

    public EmptyCustomMiniGameNavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmptyCustomMiniGameNavigationBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar
    public void requestLandscapeLayout() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar
    public void attachMiniAppContext(IMiniAppContext iMiniAppContext) {
    }

    public void attachPCInstructionWithBubbleText(String str) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar
    public BaseGameNavigationBar setWindowInfo(WindowInfo windowInfo) {
        return this;
    }
}
