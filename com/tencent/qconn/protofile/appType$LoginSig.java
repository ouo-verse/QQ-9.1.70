package com.tencent.qconn.protofile;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class appType$LoginSig extends MessageMicro<appType$LoginSig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"type", PreloadTRTCPlayerParams.KEY_SIG, "appid"}, new Object[]{1, ByteStringMicro.EMPTY, 0}, appType$LoginSig.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field appid = PBField.initUInt32(0);
}
