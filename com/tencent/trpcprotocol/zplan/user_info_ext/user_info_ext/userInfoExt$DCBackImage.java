package com.tencent.trpcprotocol.zplan.user_info_ext.user_info_ext;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class userInfoExt$DCBackImage extends MessageMicro<userInfoExt$DCBackImage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50}, new String[]{"url", "dark_url", "image_type", "is_select", "update_time", "ext_infos"}, new Object[]{"", "", 0, 0, 0L, null}, userInfoExt$DCBackImage.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField dark_url = PBField.initString("");
    public final PBEnumField image_type = PBField.initEnum(0);
    public final PBEnumField is_select = PBField.initEnum(0);
    public final PBUInt64Field update_time = PBField.initUInt64(0);
    public final PBRepeatMessageField<userInfoExt$ExtInfo> ext_infos = PBField.initRepeatMessage(userInfoExt$ExtInfo.class);
}
