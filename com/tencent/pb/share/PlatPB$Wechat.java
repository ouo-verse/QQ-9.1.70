package com.tencent.pb.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class PlatPB$Wechat extends MessageMicro<PlatPB$Wechat> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"title", "description", "url"}, new Object[]{"", "", ""}, PlatPB$Wechat.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
