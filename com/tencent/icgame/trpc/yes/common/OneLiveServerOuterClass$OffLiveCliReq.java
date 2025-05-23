package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class OneLiveServerOuterClass$OffLiveCliReq extends MessageMicro<OneLiveServerOuterClass$OffLiveCliReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"RoleInfo", "SwitchOn", "AppID"}, new Object[]{null, Boolean.FALSE, 0L}, OneLiveServerOuterClass$OffLiveCliReq.class);
    public OneLiveServerOuterClass$SGameRoleInfo RoleInfo = new MessageMicro<OneLiveServerOuterClass$SGameRoleInfo>() { // from class: com.tencent.icgame.trpc.yes.common.OneLiveServerOuterClass$SGameRoleInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"UID", "OpenID", "PlatID", "LogicWorldID", "SvrEntityID"}, new Object[]{0L, "", 0, 0, 0}, OneLiveServerOuterClass$SGameRoleInfo.class);
        public final PBUInt64Field UID = PBField.initUInt64(0);
        public final PBStringField OpenID = PBField.initString("");
        public final PBUInt32Field PlatID = PBField.initUInt32(0);
        public final PBUInt32Field LogicWorldID = PBField.initUInt32(0);
        public final PBUInt32Field SvrEntityID = PBField.initUInt32(0);
    };
    public final PBBoolField SwitchOn = PBField.initBool(false);
    public final PBUInt64Field AppID = PBField.initUInt64(0);
}
