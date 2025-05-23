package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQGameAioLittleTail$ShareUrl extends MessageMicro<QQGameAioLittleTail$ShareUrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"url", "type"}, new Object[]{"", 0}, QQGameAioLittleTail$ShareUrl.class);
    public final PBStringField url = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
}
