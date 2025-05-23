package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class Hongbao$HbTab extends MessageMicro<Hongbao$HbTab> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"id", "hb_tab_type", "title", "url"}, new Object[]{"", 0, "", ""}, Hongbao$HbTab.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f278696id = PBField.initString("");
    public final PBEnumField hb_tab_type = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
