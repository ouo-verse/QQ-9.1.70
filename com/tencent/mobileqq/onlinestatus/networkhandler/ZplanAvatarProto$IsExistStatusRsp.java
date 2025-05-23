package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes16.dex */
public final class ZplanAvatarProto$IsExistStatusRsp extends MessageMicro<ZplanAvatarProto$IsExistStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_exist"}, new Object[]{Boolean.FALSE}, ZplanAvatarProto$IsExistStatusRsp.class);
    public final PBBoolField is_exist = PBField.initBool(false);
}
