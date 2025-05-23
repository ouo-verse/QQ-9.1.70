package com.tencent.mobileqq.oidb.tofuCommon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class TofuCommon$Content extends MessageMicro<TofuCommon$Content> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "color"}, new Object[]{"", ""}, TofuCommon$Content.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField color = PBField.initString("");
}
