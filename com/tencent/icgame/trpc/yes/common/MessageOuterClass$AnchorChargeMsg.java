package com.tencent.icgame.trpc.yes.common;

import com.qzone.widget.u;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class MessageOuterClass$AnchorChargeMsg extends MessageMicro<MessageOuterClass$AnchorChargeMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50}, new String[]{"charge_times", "uid", "avatar", "nickname", "upgrade_power", u.COLUMN_TAB_ID}, new Object[]{0L, 0L, "", "", 0L, ""}, MessageOuterClass$AnchorChargeMsg.class);
    public final PBInt64Field charge_times = PBField.initInt64(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField nickname = PBField.initString("");
    public final PBInt64Field upgrade_power = PBField.initInt64(0);
    public final PBStringField tab_id = PBField.initString("");
}
