package com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class oidb_0xe9b$QZoneInfo extends MessageMicro<oidb_0xe9b$QZoneInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_space_name;
    public final PBBytesField bytes_update_content;
    public final PBRepeatField<String> str_newly_img_url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_space_name", "bytes_update_content", "str_newly_img_url"}, new Object[]{byteStringMicro, byteStringMicro, ""}, oidb_0xe9b$QZoneInfo.class);
    }

    public oidb_0xe9b$QZoneInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_space_name = PBField.initBytes(byteStringMicro);
        this.bytes_update_content = PBField.initBytes(byteStringMicro);
        this.str_newly_img_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    }
}
