package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$WindowInfo extends MessageMicro<Security$WindowInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"id", "value", "wording", "document_config"}, new Object[]{0, 0, "", null}, Security$WindowInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBEnumField f381617id = PBField.initEnum(0);
    public final PBUInt32Field value = PBField.initUInt32(0);
    public final PBStringField wording = PBField.initString("");
    public Security$DocumentConfig document_config = new Security$DocumentConfig();
}
