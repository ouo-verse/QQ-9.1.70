package com.tencent.mobileqq.mini.sdk;

import android.app.Activity;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.util.JSONUtil;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public abstract class OutBaseJsPlugin {
    protected MiniAppInterface appInterface;
    boolean isDestroy = false;

    public OutBaseJsPlugin(MiniAppInterface miniAppInterface) {
        this.appInterface = miniAppInterface;
    }

    public boolean canHandleJsRequest(String str) {
        Set<String> eventMap = getEventMap();
        if (eventMap != null) {
            return eventMap.contains(str);
        }
        return false;
    }

    protected String gernerateStateResultParams(JSONObject jSONObject, String str, String str2) {
        return JSONUtil.append(jSONObject, "errMsg", str + ":" + str2).toString();
    }

    public abstract Set<String> getEventMap();

    public String handleNativeRequest(Activity activity, ApkgInfo apkgInfo, String str, String str2, int i3) {
        return "";
    }

    public void onDestroy() {
        this.isDestroy = true;
    }
}
