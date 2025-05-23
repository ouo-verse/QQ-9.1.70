package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ReqGroupVideo$ReqScreenShareAnswer extends MessageMicro<ReqGroupVideo$ReqScreenShareAnswer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{ShortVideoConstants.FROM_UIN, "to_uin", "is_accept"}, new Object[]{0L, 0L, Boolean.FALSE}, ReqGroupVideo$ReqScreenShareAnswer.class);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBBoolField is_accept = PBField.initBool(false);
}
