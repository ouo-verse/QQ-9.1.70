package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$SetMiniUserInfoReq extends MessageMicro<userInfo$SetMiniUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"mini_info_ids", "infos", "open_id", QCircleSchemeAttr.CoverFeed.SOURCE_TYPE}, new Object[]{0, null, "", 0}, userInfo$SetMiniUserInfoReq.class);
    public final PBRepeatField<Integer> mini_info_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public userInfo$MiniInfo infos = new userInfo$MiniInfo();
    public final PBStringField open_id = PBField.initString("");
    public final PBEnumField source_type = PBField.initEnum(0);
}
