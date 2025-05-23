package com.tencent.qqmini.sdk.action;

import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* compiled from: P */
/* loaded from: classes23.dex */
public class HideInputAction implements Action {
    public static void hideInput(IMiniAppContext iMiniAppContext) {
        iMiniAppContext.performAction(obtain());
    }

    public static HideInputAction obtain() {
        return new HideInputAction();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Object perform(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (page == null) {
            return null;
        }
        page.hideSoftInput((View) page.getCapsuleButton());
        return null;
    }
}
