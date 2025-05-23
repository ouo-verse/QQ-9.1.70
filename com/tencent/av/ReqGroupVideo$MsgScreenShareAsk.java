package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ReqGroupVideo$MsgScreenShareAsk extends MessageMicro<ReqGroupVideo$MsgScreenShareAsk> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{ShortVideoConstants.FROM_UIN, "ask_wording"}, new Object[]{0L, ByteStringMicro.EMPTY}, ReqGroupVideo$MsgScreenShareAsk.class);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public final PBBytesField ask_wording = PBField.initBytes(ByteStringMicro.EMPTY);
}
