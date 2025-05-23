package com.tencent.gamematrix.gmcg.api.model;

import com.tencent.gamematrix.gmcg.api.util.CGStringUtil;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgSdkLoginCfg {
    public String pBizId;
    public String pCustomAppBizInfo;
    public String pCustomServer;
    public String pGameMatrixChannelId;
    public Map<String, String> pServerMapping;
    public boolean pUseFakeLogin;
    public String pUserId;
    public String pUserKey;
    public int pServerType = 0;
    public boolean pCustomServerForDebug = false;

    GmCgSdkLoginCfg() {
    }

    public boolean isValid() {
        if (CGStringUtil.notEmpty(this.pBizId) && CGStringUtil.notEmpty(this.pUserId) && CGStringUtil.notEmpty(this.pUserKey)) {
            return true;
        }
        return false;
    }

    public void setAppBizInfo(String str) {
        this.pCustomAppBizInfo = str;
    }

    public void setGameMatrixChannelId(String str) {
        this.pGameMatrixChannelId = str;
    }

    public void setServerMapping(Map<String, String> map) {
        this.pServerMapping = map;
    }

    public void setServerType(int i3) {
        this.pServerType = i3;
    }

    public void setServerTypeAsCustom(String str) {
        this.pServerType = 4;
        this.pCustomServer = str;
        this.pCustomServerForDebug = false;
    }

    public void setServerTypeAsCustomForDebug(String str) {
        this.pServerType = 4;
        this.pCustomServer = str;
        this.pCustomServerForDebug = true;
    }

    public void useFakeLogin(boolean z16) {
        this.pUseFakeLogin = z16;
    }

    public GmCgSdkLoginCfg(String str, String str2, String str3) {
        this.pBizId = str;
        this.pUserId = str2;
        this.pUserKey = str3;
    }
}
