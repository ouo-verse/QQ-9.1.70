package com.tencent.proto.lbsshare;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class LBSShare$POI extends MessageMicro<LBSShare$POI> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 58, 66, 74, 80, 90, 98, 106}, new String[]{"name", "addr", "shop_url", QCircleSchemeAttr.Polymerize.LAT, "lng", "coordinate", "id", "shop_url_quan", "dpid", "shop_count", "shangquan_url", "shangquan_wording", "POI_preview_url"}, new Object[]{"", "", "", 0, 0, 0, "", "", "", 0, "", "", ""}, LBSShare$POI.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField addr = PBField.initString("");
    public final PBStringField shop_url = PBField.initString("");
    public final PBInt32Field lat = PBField.initInt32(0);
    public final PBInt32Field lng = PBField.initInt32(0);
    public final PBUInt32Field coordinate = PBField.initUInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342183id = PBField.initString("");
    public final PBStringField shop_url_quan = PBField.initString("");
    public final PBStringField dpid = PBField.initString("");
    public final PBUInt32Field shop_count = PBField.initUInt32(0);
    public final PBStringField shangquan_url = PBField.initString("");
    public final PBStringField shangquan_wording = PBField.initString("");
    public final PBStringField POI_preview_url = PBField.initString("");
}
