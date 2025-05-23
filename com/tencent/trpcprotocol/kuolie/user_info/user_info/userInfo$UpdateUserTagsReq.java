package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$UpdateUserTagsReq extends MessageMicro<userInfo$UpdateUserTagsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"tag_ids", "open_id", "tag_owner", QCircleSchemeAttr.CoverFeed.SOURCE_TYPE}, new Object[]{0, "", 0, 0}, userInfo$UpdateUserTagsReq.class);
    public final PBRepeatField<Integer> tag_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField open_id = PBField.initString("");
    public final PBEnumField tag_owner = PBField.initEnum(0);
    public final PBEnumField source_type = PBField.initEnum(0);
}
