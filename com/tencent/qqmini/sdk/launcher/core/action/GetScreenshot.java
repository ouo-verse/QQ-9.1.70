package com.tencent.qqmini.sdk.launcher.core.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetScreenshot implements Action<Void> {
    private Callback callback;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Callback {
        void onGetScreenshot(String str);
    }

    public static void obtain(IMiniAppContext iMiniAppContext, Callback callback) {
        GetScreenshot getScreenshot = new GetScreenshot();
        getScreenshot.callback = callback;
        iMiniAppContext.performAction(getScreenshot);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Void perform(BaseRuntime baseRuntime) {
        baseRuntime.getScreenshot(this.callback);
        return null;
    }
}
