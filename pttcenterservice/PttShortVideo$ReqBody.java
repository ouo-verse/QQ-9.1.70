package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class PttShortVideo$ReqBody extends MessageMicro<PttShortVideo$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 802}, new String[]{"uint32_cmd", "uint32_seq", "msg_PttShortVideoUpload_Req", "msg_PttShortVideoDownload_Req", "rpt_msg_short_video_retweet_req", "rpt_msg_short_video_delete_req", "rpt_msg_extension_req"}, new Object[]{0, 0, null, null, null, null, null}, PttShortVideo$ReqBody.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public PttShortVideo$PttShortVideoUploadReq msg_PttShortVideoUpload_Req = new PttShortVideo$PttShortVideoUploadReq();
    public PttShortVideo$PttShortVideoDownloadReq msg_PttShortVideoDownload_Req = new PttShortVideo$PttShortVideoDownloadReq();
    public final PBRepeatMessageField<PttShortVideo$PttShortVideoRetweetReq> rpt_msg_short_video_retweet_req = PBField.initRepeatMessage(PttShortVideo$PttShortVideoRetweetReq.class);
    public final PBRepeatMessageField<PttShortVideo$PttShortVideoDeleteReq> rpt_msg_short_video_delete_req = PBField.initRepeatMessage(PttShortVideo$PttShortVideoDeleteReq.class);
    public final PBRepeatMessageField<PttShortVideo$ExtensionReq> rpt_msg_extension_req = PBField.initRepeatMessage(PttShortVideo$ExtensionReq.class);
}
