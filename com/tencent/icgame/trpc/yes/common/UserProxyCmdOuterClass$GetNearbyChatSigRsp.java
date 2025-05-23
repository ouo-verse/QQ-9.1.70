package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$GetNearbyChatSigRsp extends MessageMicro<UserProxyCmdOuterClass$GetNearbyChatSigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"code", "msg", PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{0, "", ByteStringMicro.EMPTY}, UserProxyCmdOuterClass$GetNearbyChatSigRsp.class);
    public final PBUInt32Field code = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f116207msg = PBField.initString("");
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
