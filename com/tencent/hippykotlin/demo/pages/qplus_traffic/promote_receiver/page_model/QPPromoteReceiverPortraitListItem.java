package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverPortraitListItem {
    public int groupType;
    public String icon;
    public boolean isBigV;
    public boolean isBlueV;
    public String name;
    public String uin;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QPPromoteReceiverPortraitListItem() {
        this(r0, r0, r0, 63);
        String str = null;
    }

    public final e encode() {
        e eVar = new e();
        eVar.v("uin", this.uin);
        eVar.v("name", Utils.INSTANCE.currentBridgeModule().urlEncode(this.name));
        eVar.v("icon", this.icon);
        eVar.t(NotifyMsgApiImpl.KEY_GROUP_TYPE, this.groupType);
        eVar.w("isBlueV", this.isBlueV);
        eVar.w("isBigV", this.isBigV);
        return eVar;
    }

    public QPPromoteReceiverPortraitListItem(String str, String str2, String str3, int i3, boolean z16, boolean z17) {
        this.uin = str;
        this.name = str2;
        this.icon = str3;
        this.groupType = i3;
        this.isBlueV = z16;
        this.isBigV = z17;
    }

    public /* synthetic */ QPPromoteReceiverPortraitListItem(String str, String str2, String str3, int i3) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, 0, false, false);
    }
}
