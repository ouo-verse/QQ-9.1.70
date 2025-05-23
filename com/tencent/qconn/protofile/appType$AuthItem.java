package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class appType$AuthItem extends MessageMicro<appType$AuthItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58}, new String[]{"default_flag", "id", "title", "api_list", "is_new", "logo_url", "desc"}, new Object[]{0, 0, "", "", 0, "", ""}, appType$AuthItem.class);
    public final PBSInt32Field default_flag = PBField.initSInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f342466id = PBField.initUInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField api_list = PBField.initString("");
    public final PBSInt32Field is_new = PBField.initSInt32(0);
    public final PBStringField logo_url = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
}
