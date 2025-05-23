package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$RcmdFollowItem extends MessageMicro<NowQQLiveHomepageProto$RcmdFollowItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"string_name", "string_id", "string_head_img_url", "string_description"}, new Object[]{"", "", "", ""}, NowQQLiveHomepageProto$RcmdFollowItem.class);
    public final PBStringField string_name = PBField.initString("");
    public final PBStringField string_id = PBField.initString("");
    public final PBStringField string_head_img_url = PBField.initString("");
    public final PBStringField string_description = PBField.initString("");
}
