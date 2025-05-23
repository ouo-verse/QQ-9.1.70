package com.tencent.proto.lbsshare;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class LBSShare$LocationReq extends MessageMicro<LBSShare$LocationReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56, 64, 74}, new String[]{QCircleSchemeAttr.Polymerize.LAT, "lng", "coordinate", "keyword", "category", "page", "count", "requireMyLbs", "imei"}, new Object[]{0, 0, 0, "", "", 0, 0, 0, ""}, LBSShare$LocationReq.class);
    public final PBInt32Field lat = PBField.initInt32(0);
    public final PBInt32Field lng = PBField.initInt32(0);
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public final PBStringField keyword = PBField.initString("");
    public final PBStringField category = PBField.initString("");
    public final PBUInt32Field page = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field requireMyLbs = PBField.initUInt32(0);
    public final PBStringField imei = PBField.initString("");
}
