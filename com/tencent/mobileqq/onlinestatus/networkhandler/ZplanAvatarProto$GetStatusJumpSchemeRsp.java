package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* loaded from: classes16.dex */
public final class ZplanAvatarProto$GetStatusJumpSchemeRsp extends MessageMicro<ZplanAvatarProto$GetStatusJumpSchemeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ZPlanPublishSource.FROM_SCHEME}, new Object[]{""}, ZplanAvatarProto$GetStatusJumpSchemeRsp.class);
    public final PBStringField scheme = PBField.initString("");
}
