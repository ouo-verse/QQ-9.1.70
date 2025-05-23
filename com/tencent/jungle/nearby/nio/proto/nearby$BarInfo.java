package com.tencent.jungle.nearby.nio.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class nearby$BarInfo extends MessageMicro<nearby$BarInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_bar_name;
    public final PBBytesField bytes_bar_pic;
    public final PBBytesField bytes_bar_url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_bar_name", "bytes_bar_pic", "bytes_bar_url"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, nearby$BarInfo.class);
    }

    public nearby$BarInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_bar_name = PBField.initBytes(byteStringMicro);
        this.bytes_bar_pic = PBField.initBytes(byteStringMicro);
        this.bytes_bar_url = PBField.initBytes(byteStringMicro);
    }
}
