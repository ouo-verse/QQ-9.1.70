package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$ClientInfo extends MessageMicro<NowSummaryCard$ClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField client_version;
    public final PBBytesField imei;
    public final PBUInt32Field platform;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"client_version", "platform", "imei"}, new Object[]{byteStringMicro, 0, byteStringMicro}, NowSummaryCard$ClientInfo.class);
    }

    public NowSummaryCard$ClientInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.client_version = PBField.initBytes(byteStringMicro);
        this.platform = PBField.initUInt32(0);
        this.imei = PBField.initBytes(byteStringMicro);
    }
}
