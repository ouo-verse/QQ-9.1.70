package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class MqqComicPb$SetMyComicFavorEmotIconsReqBody extends MessageMicro<MqqComicPb$SetMyComicFavorEmotIconsReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"reqs"}, new Object[]{null}, MqqComicPb$SetMyComicFavorEmotIconsReqBody.class);
    public final PBRepeatMessageField<MqqComicPb$ComicFavorEmotIcons> reqs = PBField.initRepeatMessage(MqqComicPb$ComicFavorEmotIcons.class);
}
