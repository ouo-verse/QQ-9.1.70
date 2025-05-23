package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class MqqComicPb$DelMyComicFavorEmotIconsReqBody extends MessageMicro<MqqComicPb$DelMyComicFavorEmotIconsReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"md5List"}, new Object[]{""}, MqqComicPb$DelMyComicFavorEmotIconsReqBody.class);
    public final PBRepeatField<String> md5List = PBField.initRepeat(PBStringField.__repeatHelper__);
}
