package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes18.dex */
public final class KidModePassword$LoginSig extends MessageMicro<KidModePassword$LoginSig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"sig_type", PreloadTRTCPlayerParams.KEY_SIG, "appid"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, KidModePassword$LoginSig.class);
    public final PBUInt32Field sig_type = PBField.initUInt32(0);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field appid = PBField.initUInt32(0);
}
