package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class l {
    public static boolean a() {
        return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("emotion_fav_adjust_title_layout_8983_113692994", Boolean.TRUE).booleanValue();
    }

    public static boolean b() {
        boolean booleanValue = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("emoticon_fav_use_emoji_item_116147289", Boolean.TRUE).booleanValue();
        QLog.i("EmoticonSwitch", 1, "useEmojiItem() ----- emoticon_fav_use_emoji_item_116147289:" + booleanValue);
        return booleanValue;
    }
}
