package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ReqGroupVideo$MsgScreenShareAnswer extends MessageMicro<ReqGroupVideo$MsgScreenShareAnswer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{ShortVideoConstants.FROM_UIN, "is_accept"}, new Object[]{0L, Boolean.FALSE}, ReqGroupVideo$MsgScreenShareAnswer.class);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public final PBBoolField is_accept = PBField.initBool(false);
}
