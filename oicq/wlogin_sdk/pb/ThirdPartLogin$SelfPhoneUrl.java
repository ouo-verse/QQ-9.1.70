package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$SelfPhoneUrl extends MessageMicro<ThirdPartLogin$SelfPhoneUrl> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88}, new String[]{"str_upload_url", "int32_channel_id"}, new Object[]{"", 0}, ThirdPartLogin$SelfPhoneUrl.class);
    public final PBStringField str_upload_url = PBField.initString("");
    public final PBInt32Field int32_channel_id = PBField.initInt32(0);
}
