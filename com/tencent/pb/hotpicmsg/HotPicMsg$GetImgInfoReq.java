package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class HotPicMsg$GetImgInfoReq extends MessageMicro<HotPicMsg$GetImgInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_ver;
    public final PBBytesField bytes_session_id;
    public final PBStringField str_search_word;
    public final PBUInt32Field uint32_build_ver;
    public final PBUInt32Field uint32_end_pic_index;
    public final PBUInt32Field uint32_need_update;
    public final PBUInt32Field uint32_pic_tag;
    public final PBUInt32Field uint32_search_req;
    public final PBUInt32Field uint32_src_term;
    public final PBUInt32Field uint32_start_pic_index;
    public final PBUInt32Field uint32_support_video;
    public final PBUInt64Field uint64_src_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64, 74, 80, 90, 96}, new String[]{"bytes_session_id", "uint64_src_uin", "uint32_src_term", "uint32_build_ver", "uint32_pic_tag", "uint32_start_pic_index", "uint32_end_pic_index", "uint32_need_update", "bytes_client_ver", "uint32_search_req", "str_search_word", "uint32_support_video"}, new Object[]{byteStringMicro, 0L, 0, 0, 0, 0, 0, 0, byteStringMicro, 0, "", 0}, HotPicMsg$GetImgInfoReq.class);
    }

    public HotPicMsg$GetImgInfoReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_session_id = PBField.initBytes(byteStringMicro);
        this.uint64_src_uin = PBField.initUInt64(0L);
        this.uint32_src_term = PBField.initUInt32(0);
        this.uint32_build_ver = PBField.initUInt32(0);
        this.uint32_pic_tag = PBField.initUInt32(0);
        this.uint32_start_pic_index = PBField.initUInt32(0);
        this.uint32_end_pic_index = PBField.initUInt32(0);
        this.uint32_need_update = PBField.initUInt32(0);
        this.bytes_client_ver = PBField.initBytes(byteStringMicro);
        this.uint32_search_req = PBField.initUInt32(0);
        this.str_search_word = PBField.initString("");
        this.uint32_support_video = PBField.initUInt32(0);
    }
}
