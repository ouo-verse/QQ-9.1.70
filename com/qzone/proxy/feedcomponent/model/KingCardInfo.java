package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_kingcard;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class KingCardInfo implements SmartParcelable {

    @NeedParcel
    public String buttonTitle;

    @NeedParcel
    public String jumpUrl;

    @NeedParcel
    public boolean showGuide;

    public KingCardInfo() {
    }

    public String toString() {
        return "KingCardInfo [showGuide=" + this.showGuide + ", buttonTitle=" + this.buttonTitle + ", jumpUrl=" + this.jumpUrl + "]";
    }

    public KingCardInfo(boolean z16, String str, String str2) {
        this.showGuide = z16;
        this.buttonTitle = str;
        this.jumpUrl = str2;
    }

    public static KingCardInfo create(s_kingcard s_kingcardVar) {
        if (s_kingcardVar == null) {
            return null;
        }
        return new KingCardInfo(s_kingcardVar.is_guide, s_kingcardVar.button_title, s_kingcardVar.jump_url);
    }
}
