package com.tencent.qqnt.emotion.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes24.dex */
public final class PicSearchSvr$EmotionInfo extends MessageMicro<PicSearchSvr$EmotionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_url"}, new Object[]{ByteStringMicro.EMPTY}, PicSearchSvr$EmotionInfo.class);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
}
