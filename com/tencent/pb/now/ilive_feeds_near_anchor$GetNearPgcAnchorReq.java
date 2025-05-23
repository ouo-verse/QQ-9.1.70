package com.tencent.pb.now;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* loaded from: classes22.dex */
public final class ilive_feeds_near_anchor$GetNearPgcAnchorReq extends MessageMicro<ilive_feeds_near_anchor$GetNearPgcAnchorReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField longitude = PBField.initFloat(0.0f);
    public final PBFloatField latitude = PBField.initFloat(0.0f);
    public final PBDoubleField distance_range = PBField.initDouble(0.0d);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public ilive_feeds_near_anchor$PgcAnchorFilter filter = new MessageMicro<ilive_feeds_near_anchor$PgcAnchorFilter>() { // from class: com.tencent.pb.now.ilive_feeds_near_anchor$PgcAnchorFilter
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uin2gender", "interest_bit", LpReport_UserInfo_dc02148.CONSTELLATION, "home_town", IProfileProtocolConst.KEY_PROFESSION}, new Object[]{0, 0, 0, 0, 0}, ilive_feeds_near_anchor$PgcAnchorFilter.class);
        public final PBUInt32Field uin2gender = PBField.initUInt32(0);
        public final PBUInt32Field interest_bit = PBField.initUInt32(0);
        public final PBUInt32Field constellation = PBField.initUInt32(0);
        public final PBUInt32Field home_town = PBField.initUInt32(0);
        public final PBUInt32Field profession = PBField.initUInt32(0);
    };
    public final PBUInt32Field gender = PBField.initUInt32(0);

    static {
        String[] strArr = {"longitude", "latitude", "distance_range", "start", WidgetCacheConstellationData.NUM, "filter", "gender"};
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 25, 32, 40, 50, 56}, strArr, new Object[]{valueOf, valueOf, Double.valueOf(0.0d), 0, 0, null, 0}, ilive_feeds_near_anchor$GetNearPgcAnchorReq.class);
    }
}
