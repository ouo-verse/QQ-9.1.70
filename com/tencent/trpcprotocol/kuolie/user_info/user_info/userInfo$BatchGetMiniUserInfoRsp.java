package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$BatchGetMiniUserInfoRsp extends MessageMicro<userInfo$BatchGetMiniUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "infos"}, new Object[]{0, null}, userInfo$BatchGetMiniUserInfoRsp.class);
    public final PBEnumField code = PBField.initEnum(0);
    public final PBRepeatMessageField<userInfo$MiniInfo> infos = PBField.initRepeatMessage(userInfo$MiniInfo.class);
}
