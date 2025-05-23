package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes20.dex */
public final class WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq extends MessageMicro<WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq> {
    public static final int PIC_VIDEO_2QCLOUD_LIST_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pic_video_2qcloud_list"}, new Object[]{null}, WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq.class);
    public final PBRepeatMessageField<WeiyunPB$PicVideo2QcloudItem> pic_video_2qcloud_list = PBField.initRepeatMessage(WeiyunPB$PicVideo2QcloudItem.class);
}
