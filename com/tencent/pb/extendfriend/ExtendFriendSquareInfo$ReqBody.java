package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ExtendFriendSquareInfo$ReqBody extends MessageMicro<ExtendFriendSquareInfo$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_req_buff;
    public final PBBytesField bytes_req_page_cookies;
    public ExtendFriendSquareInfo$LBSInfo msg_lbs_info;
    public final PBBytesField str_keyword;
    public final PBUInt32Field uint32_get_online_number;
    public final PBUInt32Field uint32_req_num;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 58}, new String[]{"uint64_uin", "bytes_req_page_cookies", "uint32_req_num", "str_keyword", "bytes_req_buff", "uint32_get_online_number", "msg_lbs_info"}, new Object[]{0L, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, null}, ExtendFriendSquareInfo$ReqBody.class);
    }

    public ExtendFriendSquareInfo$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_req_page_cookies = PBField.initBytes(byteStringMicro);
        this.uint32_req_num = PBField.initUInt32(0);
        this.str_keyword = PBField.initBytes(byteStringMicro);
        this.bytes_req_buff = PBField.initBytes(byteStringMicro);
        this.uint32_get_online_number = PBField.initUInt32(0);
        this.msg_lbs_info = new ExtendFriendSquareInfo$LBSInfo();
    }
}
