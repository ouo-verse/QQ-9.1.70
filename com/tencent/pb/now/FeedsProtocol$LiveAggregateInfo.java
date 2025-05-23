package com.tencent.pb.now;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$LiveAggregateInfo extends MessageMicro<FeedsProtocol$LiveAggregateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"video", AppConstants.TAG_RAW_SHORT_VIDEO, "total_short_size", "id"}, new Object[]{null, null, 0, ""}, FeedsProtocol$LiveAggregateInfo.class);
    public FeedsProtocol$VideoItem video = new FeedsProtocol$VideoItem();
    public final PBRepeatMessageField<FeedsProtocol$ShortVideoInfo> short_video = PBField.initRepeatMessage(FeedsProtocol$ShortVideoInfo.class);
    public final PBUInt32Field total_short_size = PBField.initUInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342130id = PBField.initString("");
}
