package com.tencent.qqnt.doutu.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Doutu$ReqBody extends MessageMicro<Doutu$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"msg_get_imginfo_req", "msg_get_hotpic_req", "msg_get_shanmeng_req", "msg_report_hotpic_req", "testReq"}, new Object[]{null, null, null, null, null}, Doutu$ReqBody.class);
    public Doutu$GetImgInfoReq msg_get_imginfo_req = new Doutu$GetImgInfoReq();
    public Doutu$GetHotPicReq msg_get_hotpic_req = new MessageMicro<Doutu$GetHotPicReq>() { // from class: com.tencent.qqnt.doutu.protocol.Doutu$GetHotPicReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uint64_src_uin", "uint32_src_term", "bytes_pic_md5", "uin32_gender", "uint32_age"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0, 0}, Doutu$GetHotPicReq.class);
        public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
        public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
        public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    };
    public Doutu$GetShanMengReq msg_get_shanmeng_req = new MessageMicro<Doutu$GetShanMengReq>() { // from class: com.tencent.qqnt.doutu.protocol.Doutu$GetShanMengReq
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_url;
        public final PBBytesField bytes_uuid;
        public final PBUInt32Field uin32_gender;
        public final PBUInt32Field uint32_age;
        public final PBUInt32Field uint32_command_id;
        public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 56, 64}, new String[]{"uint64_src_uin", "uint32_src_term", "bytes_uuid", "bytes_md5", "uint32_command_id", "bytes_url", "uin32_gender", "uint32_age"}, new Object[]{0L, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, 0}, Doutu$GetShanMengReq.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.uint32_command_id = PBField.initUInt32(0);
            this.bytes_url = PBField.initBytes(byteStringMicro);
            this.uin32_gender = PBField.initUInt32(0);
            this.uint32_age = PBField.initUInt32(0);
        }
    };
    public Doutu$ReportHotPicReq msg_report_hotpic_req = new MessageMicro<Doutu$ReportHotPicReq>() { // from class: com.tencent.qqnt.doutu.protocol.Doutu$ReportHotPicReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48}, new String[]{"uint64_src_uin", "uint32_src_term", "msg_img_info", "bytes_md5", "uin32_gender", "uint32_age"}, new Object[]{0L, 0, null, ByteStringMicro.EMPTY, 0, 0}, Doutu$ReportHotPicReq.class);
        public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
        public Doutu$ImgInfo msg_img_info = new Doutu$ImgInfo();
        public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
        public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    };
    public Doutu$TestReq testReq = new MessageMicro<Doutu$TestReq>() { // from class: com.tencent.qqnt.doutu.protocol.Doutu$TestReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_src_uin", "uint32_src_term", "uint32_age", "uin32_gender", "randomNum"}, new Object[]{0L, 0, 0, 0, 0}, Doutu$TestReq.class);
        public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
        public final PBUInt32Field uint32_age = PBField.initUInt32(0);
        public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
        public final PBUInt32Field randomNum = PBField.initUInt32(0);
    };
}
