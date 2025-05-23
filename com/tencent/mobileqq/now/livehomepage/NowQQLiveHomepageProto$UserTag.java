package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$UserTag extends MessageMicro<NowQQLiveHomepageProto$UserTag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50}, new String[]{"pic_url", "wording", "color", "change_color", "type", "background_pic_url"}, new Object[]{"", "", 0, "", 0, ""}, NowQQLiveHomepageProto$UserTag.class);
    public final PBStringField pic_url = PBField.initString("");
    public final PBStringField wording = PBField.initString("");
    public final PBUInt32Field color = PBField.initUInt32(0);
    public final PBStringField change_color = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField background_pic_url = PBField.initString("");
}
