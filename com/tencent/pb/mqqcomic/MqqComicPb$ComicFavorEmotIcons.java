package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class MqqComicPb$ComicFavorEmotIcons extends MessageMicro<MqqComicPb$ComicFavorEmotIcons> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"md5", "info"}, new Object[]{"", ""}, MqqComicPb$ComicFavorEmotIcons.class);
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField info = PBField.initString("");
}
