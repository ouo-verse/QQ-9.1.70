package com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class QqstrangerUserInfoPB$SetUserTacitAnswerReq extends MessageMicro<QqstrangerUserInfoPB$SetUserTacitAnswerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"id", "answer", "status"}, new Object[]{0, 0, 0}, QqstrangerUserInfoPB$SetUserTacitAnswerReq.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f381612id = PBField.initUInt32(0);
    public final PBUInt32Field answer = PBField.initUInt32(0);
    public final PBEnumField status = PBField.initEnum(0);
}
