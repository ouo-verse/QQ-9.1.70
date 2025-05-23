package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ComicIPSite$ModuleInfo extends MessageMicro<ComicIPSite$ModuleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"appId", "itemId", "isRetSummary"}, new Object[]{0, "", Boolean.FALSE}, ComicIPSite$ModuleInfo.class);
    public final PBInt32Field appId = PBField.initInt32(0);
    public final PBStringField itemId = PBField.initString("");
    public final PBBoolField isRetSummary = PBField.initBool(false);
}
