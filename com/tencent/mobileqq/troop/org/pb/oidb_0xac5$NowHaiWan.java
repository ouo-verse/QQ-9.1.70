package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0xac5$NowHaiWan extends MessageMicro<oidb_0xac5$NowHaiWan> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon;
    public final PBBytesField bytes_title;
    public final PBBytesField bytes_url;
    public final PBUInt32Field uint32_status;
    public final PBUInt32Field uint32_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"bytes_title", "bytes_url", "uint32_status", "bytes_icon", "uint32_type"}, new Object[]{byteStringMicro, byteStringMicro, 0, byteStringMicro, 0}, oidb_0xac5$NowHaiWan.class);
    }

    public oidb_0xac5$NowHaiWan() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.bytes_url = PBField.initBytes(byteStringMicro);
        this.uint32_status = PBField.initUInt32(0);
        this.bytes_icon = PBField.initBytes(byteStringMicro);
        this.uint32_type = PBField.initUInt32(0);
    }
}
