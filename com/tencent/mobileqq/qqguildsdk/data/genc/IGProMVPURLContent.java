package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProMVPURLContent extends Serializable {
    String getDisplayText();

    int getIconType();

    IGProMVPTencentDocsContent getTencentDocsContent();

    IGProMVPThirdPlatform getThirdPlatform();

    IGProMVPCommThirdShareInfo getThirdShareInfo();

    IGProMVPThirdVideoInfo getThirdVideoInfo();

    int getType();

    String getUrl();

    IGProMVPWeixinOfficialAccountsContent getWeixinOffcialAccountsContent();

    String toString();
}
