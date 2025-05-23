package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$BannerItem extends MessageMicro<NowQQLiveHomepageProto$BannerItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"string_image_desc", "string_image_title", "string_image_url", "string_jump_url"}, new Object[]{"", "", "", ""}, NowQQLiveHomepageProto$BannerItem.class);
    public final PBStringField string_image_desc = PBField.initString("");
    public final PBStringField string_image_title = PBField.initString("");
    public final PBStringField string_image_url = PBField.initString("");
    public final PBStringField string_jump_url = PBField.initString("");
}
