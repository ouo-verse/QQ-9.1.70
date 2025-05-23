package com.tencent.trpcprotocol.qqva.ai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class DrawCards$Card extends MessageMicro<DrawCards$Card> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"image_url", "name"}, new Object[]{"", ""}, DrawCards$Card.class);
    public final PBStringField image_url = PBField.initString("");
    public final PBStringField name = PBField.initString("");
}
