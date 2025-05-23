package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQGameAioLittleTail$GetShareTailsResponse extends MessageMicro<QQGameAioLittleTail$GetShareTailsResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"tails", "refresh_interval"}, new Object[]{null, 0}, QQGameAioLittleTail$GetShareTailsResponse.class);
    public final PBRepeatMessageField<QQGameAioLittleTail$ShareTail> tails = PBField.initRepeatMessage(QQGameAioLittleTail$ShareTail.class);
    public final PBInt32Field refresh_interval = PBField.initInt32(0);
}
