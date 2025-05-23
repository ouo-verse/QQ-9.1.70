package com.tencent.pb.webview;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class UrlQuery$UrlQueryReq extends MessageMicro<UrlQuery$UrlQueryReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_app_name;
    public final PBBytesField bytes_device_name;
    public final PBBytesField bytes_guid;
    public final PBBytesField bytes_imei;
    public final PBBytesField bytes_plateform;
    public final PBBytesField bytes_qq_pf_to;
    public final PBBytesField bytes_refer;
    public final PBBytesField bytes_url;
    public final PBUInt64Field uint32_msg_chatid;
    public final PBUInt32Field uint32_msg_from;
    public final PBUInt32Field uint32_msg_type;
    public final PBUInt64Field uint32_send_uin;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subappid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_os_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 90, 98, 106, 170, 176, 184, 192, 200}, new String[]{"uint64_uin", "uint32_appid", "uint32_subappid", "uint32_os_type", "bytes_app_name", "bytes_device_name", "bytes_imei", "bytes_guid", "bytes_url", "bytes_qq_pf_to", "bytes_refer", "bytes_plateform", "uint32_msg_type", "uint32_msg_from", "uint32_send_uin", "uint32_msg_chatid"}, new Object[]{0L, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0L, 0L}, UrlQuery$UrlQueryReq.class);
    }

    public UrlQuery$UrlQueryReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_app_name = PBField.initBytes(byteStringMicro);
        this.bytes_device_name = PBField.initBytes(byteStringMicro);
        this.bytes_imei = PBField.initBytes(byteStringMicro);
        this.bytes_guid = PBField.initBytes(byteStringMicro);
        this.bytes_url = PBField.initBytes(byteStringMicro);
        this.bytes_qq_pf_to = PBField.initBytes(byteStringMicro);
        this.bytes_refer = PBField.initBytes(byteStringMicro);
        this.bytes_plateform = PBField.initBytes(byteStringMicro);
        this.uint32_msg_type = PBField.initUInt32(0);
        this.uint32_msg_from = PBField.initUInt32(0);
        this.uint32_send_uin = PBField.initUInt64(0L);
        this.uint32_msg_chatid = PBField.initUInt64(0L);
    }
}
