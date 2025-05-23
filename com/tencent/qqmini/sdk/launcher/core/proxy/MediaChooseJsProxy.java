package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public abstract class MediaChooseJsProxy {
    protected Bridge mBridge;

    /* loaded from: classes23.dex */
    public interface Bridge {
        void hideLoading();

        void responseCancel(int i3, String str, JSONObject jSONObject);

        void responseFail(int i3, String str, JSONObject jSONObject, String str2);

        void responseOk(int i3, String str, JSONObject jSONObject);

        void showLoading(String str);

        void updateLoading(String str);
    }

    public abstract void chooseMedia(Activity activity, String str, String str2, int i3);

    public abstract void create(IMiniAppContext iMiniAppContext);

    public void destroy() {
        this.mBridge = null;
    }

    public void setResponseListener(Bridge bridge) {
        this.mBridge = bridge;
    }
}
