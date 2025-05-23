package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x5ReqBQRecommend extends MessageMicro<EmosmPb$SubCmd0x5ReqBQRecommend> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"int32_last_recommend_version"}, new Object[]{0}, EmosmPb$SubCmd0x5ReqBQRecommend.class);
    public final PBInt32Field int32_last_recommend_version = PBField.initInt32(0);
}
