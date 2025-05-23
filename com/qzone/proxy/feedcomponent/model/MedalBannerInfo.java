package com.qzone.proxy.feedcomponent.model;

import NS_UNDEAL_COUNT.medal_banner;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MedalBannerInfo implements SmartParcelable {

    @NeedParcel
    public String bannerText;

    @NeedParcel
    public String jumpSchema;

    @NeedParcel
    public String jumpUrl;

    @NeedParcel
    public int retcode;

    public MedalBannerInfo() {
        this.retcode = -1;
        this.bannerText = "";
        this.jumpSchema = "";
        this.jumpUrl = "";
    }

    public MedalBannerInfo(medal_banner medal_bannerVar) {
        this.retcode = -1;
        this.bannerText = "";
        this.jumpSchema = "";
        this.jumpUrl = "";
        this.retcode = medal_bannerVar.retcode;
        this.bannerText = medal_bannerVar.bannerText;
        this.jumpSchema = medal_bannerVar.jumpSchema;
        this.jumpUrl = medal_bannerVar.jumpUrl;
    }
}
