package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$RecentExpireInfo extends MessageMicro<giftMidgroundPanel$RecentExpireInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{VasQQSettingMeImpl.EXPIRE_TIME, "expire_num"}, new Object[]{0L, 0L}, giftMidgroundPanel$RecentExpireInfo.class);
    public final PBInt64Field expire_time = PBField.initInt64(0);
    public final PBInt64Field expire_num = PBField.initInt64(0);
}
