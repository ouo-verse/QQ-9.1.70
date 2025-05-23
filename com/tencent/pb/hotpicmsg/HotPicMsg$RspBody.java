package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class HotPicMsg$RspBody extends MessageMicro<HotPicMsg$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_get_imginfo_rsp", "msg_get_videoinfo_rsp"}, new Object[]{null, null}, HotPicMsg$RspBody.class);
    public HotPicMsg$GetImgInfoRsp msg_get_imginfo_rsp = new HotPicMsg$GetImgInfoRsp();
    public HotPicMsg$GetVideoInfoRsp msg_get_videoinfo_rsp = new MessageMicro<HotPicMsg$GetVideoInfoRsp>() { // from class: com.tencent.pb.hotpicmsg.HotPicMsg$GetVideoInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48}, new String[]{"int32_result", "bytes_fail_msg", "uint32_build_ver", "rpt_msg_video_info", "rpt_msg_tag_info", "uint32_tag_id"}, new Object[]{0, ByteStringMicro.EMPTY, 0, null, null, 0}, HotPicMsg$GetVideoInfoRsp.class);
        public final PBInt32Field int32_result = PBField.initInt32(0);
        public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_build_ver = PBField.initUInt32(0);
        public final PBRepeatMessageField<HotPicMsg$VideoInfo> rpt_msg_video_info = PBField.initRepeatMessage(HotPicMsg$VideoInfo.class);
        public final PBRepeatMessageField<HotPicMsg$TagInfo> rpt_msg_tag_info = PBField.initRepeatMessage(HotPicMsg$TagInfo.class);
        public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
    };
}
