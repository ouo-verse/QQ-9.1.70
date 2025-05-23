package com.tencent.mobileqq.minigame.va;

/* compiled from: P */
/* loaded from: classes15.dex */
public class GameLoginInfo {
    public String accessToken;
    public String appId;
    public String openId;
    public String payToken;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GameLoginInfo{");
        stringBuffer.append("accessToken='");
        stringBuffer.append(this.accessToken);
        stringBuffer.append('\'');
        stringBuffer.append(", payToken='");
        stringBuffer.append(this.payToken);
        stringBuffer.append('\'');
        stringBuffer.append(", openId='");
        stringBuffer.append(this.openId);
        stringBuffer.append('\'');
        stringBuffer.append(", appId='");
        stringBuffer.append(this.appId);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
