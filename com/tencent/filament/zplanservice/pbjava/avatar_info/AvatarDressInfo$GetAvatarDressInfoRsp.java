package com.tencent.filament.zplanservice.pbjava.avatar_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class AvatarDressInfo$GetAvatarDressInfoRsp extends MessageMicro<AvatarDressInfo$GetAvatarDressInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"dress_infos"}, new Object[]{null}, AvatarDressInfo$GetAvatarDressInfoRsp.class);
    public final PBRepeatMessageField<AvatarDressInfo$GetDressKeyRsp> dress_infos = PBField.initRepeatMessage(AvatarDressInfo$GetDressKeyRsp.class);
}
