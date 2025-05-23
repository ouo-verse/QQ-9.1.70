package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes22.dex */
public final class HotPicMsg$ThirdPartyInfo extends MessageMicro<HotPicMsg$ThirdPartyInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appid;
    public final PBBytesField bytes_icon_url;
    public final PBBytesField bytes_jump_url;
    public final PBBytesField bytes_name;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"bytes_appid", "bytes_icon_url", "bytes_name", "bytes_jump_url"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, HotPicMsg$ThirdPartyInfo.class);
    }

    public HotPicMsg$ThirdPartyInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_appid = PBField.initBytes(byteStringMicro);
        this.bytes_icon_url = PBField.initBytes(byteStringMicro);
        this.bytes_name = PBField.initBytes(byteStringMicro);
        this.bytes_jump_url = PBField.initBytes(byteStringMicro);
    }
}
