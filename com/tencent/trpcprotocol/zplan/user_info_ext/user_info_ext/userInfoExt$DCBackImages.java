package com.tencent.trpcprotocol.zplan.user_info_ext.user_info_ext;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class userInfoExt$DCBackImages extends MessageMicro<userInfoExt$DCBackImages> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"back_images"}, new Object[]{null}, userInfoExt$DCBackImages.class);
    public final PBRepeatMessageField<userInfoExt$DCBackImage> back_images = PBField.initRepeatMessage(userInfoExt$DCBackImage.class);
}
