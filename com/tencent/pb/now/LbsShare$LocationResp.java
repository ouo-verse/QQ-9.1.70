package com.tencent.pb.now;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class LbsShare$LocationResp extends MessageMicro<LbsShare$LocationResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50}, new String[]{"ec", "poilist", "mylbs", "next", "is_foreign", "search_id"}, new Object[]{0, null, null, 0, 0, ""}, LbsShare$LocationResp.class);

    /* renamed from: ec, reason: collision with root package name */
    public final PBUInt32Field f342135ec = PBField.initUInt32(0);
    public final PBRepeatMessageField<LbsShare$POI> poilist = PBField.initRepeatMessage(LbsShare$POI.class);
    public LbsShare$POI mylbs = new MessageMicro<LbsShare$POI>() { // from class: com.tencent.pb.now.LbsShare$POI
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 58, 66, 74, 80, 90, 98, 106, 114}, new String[]{"name", "addr", "shop_url", QCircleSchemeAttr.Polymerize.LAT, "lng", "coordinate", "id", "shop_url_quan", "dpid", "shop_count", "shangquan_url", "shangquan_wording", "POI_preview_url", "city"}, new Object[]{"", "", "", 0, 0, 0, "", "", "", 0, "", "", "", ""}, LbsShare$POI.class);
        public final PBStringField name = PBField.initString("");
        public final PBStringField addr = PBField.initString("");
        public final PBStringField shop_url = PBField.initString("");
        public final PBInt32Field lat = PBField.initInt32(0);
        public final PBInt32Field lng = PBField.initInt32(0);
        public final PBUInt32Field coordinate = PBField.initUInt32(0);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f342137id = PBField.initString("");
        public final PBStringField shop_url_quan = PBField.initString("");
        public final PBStringField dpid = PBField.initString("");
        public final PBUInt32Field shop_count = PBField.initUInt32(0);
        public final PBStringField shangquan_url = PBField.initString("");
        public final PBStringField shangquan_wording = PBField.initString("");
        public final PBStringField POI_preview_url = PBField.initString("");
        public final PBStringField city = PBField.initString("");
    };
    public final PBUInt32Field next = PBField.initUInt32(0);
    public final PBUInt32Field is_foreign = PBField.initUInt32(0);
    public final PBStringField search_id = PBField.initString("");
}
