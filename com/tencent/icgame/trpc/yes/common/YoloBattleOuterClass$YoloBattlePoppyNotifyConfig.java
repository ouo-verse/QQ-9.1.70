package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class YoloBattleOuterClass$YoloBattlePoppyNotifyConfig extends MessageMicro<YoloBattleOuterClass$YoloBattlePoppyNotifyConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48}, new String[]{"cmd", "server_address", "thread_route_id", "server_route_id", "serial_key", "timeout"}, new Object[]{0, "", 0L, 0L, 0L, 0}, YoloBattleOuterClass$YoloBattlePoppyNotifyConfig.class);
    public final PBInt32Field cmd = PBField.initInt32(0);
    public final PBStringField server_address = PBField.initString("");
    public final PBInt64Field thread_route_id = PBField.initInt64(0);
    public final PBInt64Field server_route_id = PBField.initInt64(0);
    public final PBUInt64Field serial_key = PBField.initUInt64(0);
    public final PBUInt32Field timeout = PBField.initUInt32(0);
}
