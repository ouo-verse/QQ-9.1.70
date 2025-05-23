package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class MqqComicPb$GetMyComicFavorEmotIconsRspBody extends MessageMicro<MqqComicPb$GetMyComicFavorEmotIconsRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rsps"}, new Object[]{null}, MqqComicPb$GetMyComicFavorEmotIconsRspBody.class);
    public final PBRepeatMessageField<MqqComicPb$ComicFavorEmotIcons> rsps = PBField.initRepeatMessage(MqqComicPb$ComicFavorEmotIcons.class);
}
