package com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class QqstrangerUserInfoPB$DatingPurpose extends MessageMicro<QqstrangerUserInfoPB$DatingPurpose> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"dating_purpose_id", "dating_purpose_name"}, new Object[]{0, ""}, QqstrangerUserInfoPB$DatingPurpose.class);
    public final PBUInt32Field dating_purpose_id = PBField.initUInt32(0);
    public final PBStringField dating_purpose_name = PBField.initString("");
}
