package com.tencent.gamematrix.gmcg.sdk.config;

import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGSdkLoginInfo {
    public String pBizId;
    public int pServerEnvType = 0;
    public String pUserId;
    public String pUserKey;

    public static CGSdkLoginInfo fromJsonString(String str) {
        return (CGSdkLoginInfo) new Gson().fromJson(str, CGSdkLoginInfo.class);
    }

    public boolean isValid() {
        if (CGStringUtil.notEmpty(this.pBizId) && CGStringUtil.notEmpty(this.pUserId) && CGStringUtil.notEmpty(this.pUserKey)) {
            return true;
        }
        return false;
    }

    public String toJsonString() {
        return new Gson().toJson(this);
    }
}
