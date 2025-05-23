package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class feeds_inner_define$ThemeMsgInfo extends MessageMicro<feeds_inner_define$ThemeMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_feedsid;
    public final PBBytesField opt_bytes_msg;
    public final PBBytesField opt_bytes_reserve;
    public final PBUInt64Field opt_uint64_fromuin = PBField.initUInt64(0);
    public final PBUInt64Field opt_uint64_time = PBField.initUInt64(0);
    public final PBUInt64Field opt_uint64_modtime = PBField.initUInt64(0);
    public final PBUInt32Field opt_uint32_cmmntid = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58}, new String[]{"opt_uint64_fromuin", "opt_uint64_time", "opt_uint64_modtime", "opt_uint32_cmmntid", "opt_bytes_feedsid", "opt_bytes_reserve", "opt_bytes_msg"}, new Object[]{0L, 0L, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro}, feeds_inner_define$ThemeMsgInfo.class);
    }

    public feeds_inner_define$ThemeMsgInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.opt_bytes_feedsid = PBField.initBytes(byteStringMicro);
        this.opt_bytes_reserve = PBField.initBytes(byteStringMicro);
        this.opt_bytes_msg = PBField.initBytes(byteStringMicro);
    }
}
