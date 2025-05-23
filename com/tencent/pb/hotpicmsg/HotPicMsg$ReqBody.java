package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes22.dex */
public final class HotPicMsg$ReqBody extends MessageMicro<HotPicMsg$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_get_imginfo_req", "msg_get_videoinfo_req"}, new Object[]{null, null}, HotPicMsg$ReqBody.class);
    public HotPicMsg$GetImgInfoReq msg_get_imginfo_req = new HotPicMsg$GetImgInfoReq();
    public HotPicMsg$GetVideoInfoReq msg_get_videoinfo_req = new HotPicMsg$GetVideoInfoReq();
}
