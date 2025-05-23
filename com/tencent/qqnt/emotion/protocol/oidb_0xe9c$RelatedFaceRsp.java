package com.tencent.qqnt.emotion.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class oidb_0xe9c$RelatedFaceRsp extends MessageMicro<oidb_0xe9c$RelatedFaceRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_img_info", "img_num"}, new Object[]{null, 0}, oidb_0xe9c$RelatedFaceRsp.class);
    public final PBRepeatMessageField<oidb_0xe9c$ImgInfo> rpt_img_info = PBField.initRepeatMessage(oidb_0xe9c$ImgInfo.class);
    public final PBInt32Field img_num = PBField.initInt32(0);
}
