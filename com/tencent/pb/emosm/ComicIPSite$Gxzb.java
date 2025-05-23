package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* loaded from: classes22.dex */
public final class ComicIPSite$Gxzb extends MessageMicro<ComicIPSite$Gxzb> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50}, new String[]{"appId", "appName", "cover", VipFunCallConstants.KEY_FEET_TYPE, "id", "name"}, new Object[]{0, "", "", 0, "", ""}, ComicIPSite$Gxzb.class);
    public final PBInt32Field appId = PBField.initInt32(0);
    public final PBStringField appName = PBField.initString("");
    public final PBStringField cover = PBField.initString("");
    public final PBInt32Field feeType = PBField.initInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342123id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
}
