package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class HotPicMsg$GetVideoInfoReq extends MessageMicro<HotPicMsg$GetVideoInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_ver;
    public final PBBytesField bytes_session_id;
    public final PBUInt32Field uint32_build_ver;
    public final PBUInt32Field uint32_end_video_index;
    public final PBUInt32Field uint32_need_update;
    public final PBUInt32Field uint32_src_term;
    public final PBUInt32Field uint32_start_video_index;
    public final PBUInt32Field uint32_tag_id;
    public final PBUInt64Field uint64_src_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 66, 72}, new String[]{"bytes_session_id", "uint64_src_uin", "uint32_src_term", "uint32_tag_id", "uint32_build_ver", "uint32_start_video_index", "uint32_end_video_index", "bytes_client_ver", "uint32_need_update"}, new Object[]{byteStringMicro, 0L, 0, 0, 0, 0, 0, byteStringMicro, 0}, HotPicMsg$GetVideoInfoReq.class);
    }

    public HotPicMsg$GetVideoInfoReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_session_id = PBField.initBytes(byteStringMicro);
        this.uint64_src_uin = PBField.initUInt64(0L);
        this.uint32_src_term = PBField.initUInt32(0);
        this.uint32_tag_id = PBField.initUInt32(0);
        this.uint32_build_ver = PBField.initUInt32(0);
        this.uint32_start_video_index = PBField.initUInt32(0);
        this.uint32_end_video_index = PBField.initUInt32(0);
        this.bytes_client_ver = PBField.initBytes(byteStringMicro);
        this.uint32_need_update = PBField.initUInt32(0);
    }
}
