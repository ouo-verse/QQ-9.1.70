package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.os.ResultReceiver;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public abstract class NavigationProxy {
    public abstract boolean launchByAppType(int i3, Activity activity, String str, int i16, JSONObject jSONObject, ResultReceiver resultReceiver);

    public abstract void onAfterLaunchByAppInfo(JSONObject jSONObject);

    public abstract void onBeforeNavigateToMiniProgram();
}
