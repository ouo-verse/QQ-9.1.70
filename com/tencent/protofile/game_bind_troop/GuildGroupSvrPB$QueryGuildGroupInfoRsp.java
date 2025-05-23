package com.tencent.protofile.game_bind_troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;

/* loaded from: classes22.dex */
public final class GuildGroupSvrPB$QueryGuildGroupInfoRsp extends MessageMicro<GuildGroupSvrPB$QueryGuildGroupInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField binding_status = PBField.initEnum(0);
    public final PBBoolField is_group_member = PBField.initBool(false);
    public final PBBoolField is_group_owner = PBField.initBool(false);
    public final PBStringField join_group_auth_key = PBField.initString("");
    public final PBBoolField freeze = PBField.initBool(false);
    public final PBBoolField dissolved = PBField.initBool(false);
    public final PBBoolField suspended = PBField.initBool(false);
    public final PBUInt64Field group_code = PBField.initUInt64(0);

    static {
        String[] strArr = {"binding_status", "is_group_member", "is_group_owner", "join_group_auth_key", "freeze", "dissolved", AudioContext.State.SUSPENDED, "group_code"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64}, strArr, new Object[]{0, bool, bool, "", bool, bool, bool, 0L}, GuildGroupSvrPB$QueryGuildGroupInfoRsp.class);
    }
}
