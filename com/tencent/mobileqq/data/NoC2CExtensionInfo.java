package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NoC2CExtensionInfo extends Entity {
    public static final int TYPE_EXT_C2C = 0;
    public static final int TYPE_EXT_COUNT = 3;
    public static final int TYPE_EXT_DISCUSSION = 2;
    public static final int TYPE_EXT_GROUP = 1;

    @notColumn
    public boolean isDataChanged;
    public int type;
    public String uin;
    public int chatInputType = 0;
    public int showC2CPanel = 1;
    public int pttChangeVoiceType = 0;

    @defaultValue(defaultInteger = -1)
    public int audioPanelType = -1;

    public static String getNoC2Ckey(int i3, String str) {
        return i3 + "_" + str;
    }
}
