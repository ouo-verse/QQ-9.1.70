package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$GetMiniUserInfoRsp extends MessageMicro<userInfo$GetMiniUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"code", "infos", "ext_tags"}, new Object[]{0, null, null}, userInfo$GetMiniUserInfoRsp.class);
    public final PBEnumField code = PBField.initEnum(0);
    public userInfo$MiniInfo infos = new userInfo$MiniInfo();
    public final PBRepeatMessageField<userInfo$ExtTag> ext_tags = PBField.initRepeatMessage(userInfo$ExtTag.class);
}
