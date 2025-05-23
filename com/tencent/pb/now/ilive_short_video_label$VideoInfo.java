package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_short_video_label$VideoInfo extends MessageMicro<ilive_short_video_label$VideoInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"vid", "url", "cover_url"}, new Object[]{ByteStringMicro.EMPTY, "", ""}, ilive_short_video_label$VideoInfo.class);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField url = PBField.initString("");
    public final PBStringField cover_url = PBField.initString("");
}
