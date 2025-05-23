package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class VipMusicBox$GetProfileMusicBoxInfoReq extends MessageMicro<VipMusicBox$GetProfileMusicBoxInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, VipMusicBox$GetProfileMusicBoxInfoReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
