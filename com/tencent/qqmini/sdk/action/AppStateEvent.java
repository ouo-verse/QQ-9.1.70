package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppStateEvent implements Action {
    private Object obj;
    private int what;

    public static AppStateEvent obtain(int i3) {
        return obtain(i3, null);
    }

    public void notifyRuntime(IMiniAppContext iMiniAppContext) {
        if (iMiniAppContext != null) {
            iMiniAppContext.performAction(this);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Object perform(BaseRuntime baseRuntime) {
        baseRuntime.notifyRuntimeMsgObserver(this.what, this.obj);
        return null;
    }

    public static AppStateEvent obtain(int i3, Object obj) {
        AppStateEvent appStateEvent = new AppStateEvent();
        appStateEvent.what = i3;
        appStateEvent.obj = obj;
        return appStateEvent;
    }
}
