package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* loaded from: classes10.dex */
public enum GiftPanelHelper$Entrance {
    TROOP_PLUS_PANEL(VipFunCallConstants.KEY_GROUP),
    TROOP_PROFILE_CARD("qunziliaoka"),
    TROOP_GIFT_ITEM("ark"),
    TROOP_GIFT_ITEM_BACK("ark"),
    TROOP_GIFT_EASTER_EGG("caidan"),
    TROOP_BIRTH_BANNER("troopBirth"),
    TROOP_BIRTH_PICK_MEMBER("troopBirth"),
    TROOP_BIRTH_ITEM("troopBirth"),
    TROOP_NONE_FROM("troopnone");

    private final String name;

    GiftPanelHelper$Entrance(String str) {
        this.name = str;
    }

    public String getString() {
        return this.name;
    }
}
