package com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class QqstrangerUserInfoPB$GetUserTacitHistoryReq extends MessageMicro<QqstrangerUserInfoPB$GetUserTacitHistoryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"filter", "offset", "limit"}, new Object[]{0, 0, 0}, QqstrangerUserInfoPB$GetUserTacitHistoryReq.class);
    public final PBEnumField filter = PBField.initEnum(0);
    public final PBUInt32Field offset = PBField.initUInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
}
