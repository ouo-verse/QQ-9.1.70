package com.tencent.proto.lbsshare;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class LBSShare$NearByShopsReq extends MessageMicro<LBSShare$NearByShopsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{QCircleSchemeAttr.Polymerize.LAT, "lng", "coordinate", "begin", "limit", "version"}, new Object[]{0, 0, 0, 0, 0, 0}, LBSShare$NearByShopsReq.class);
    public final PBInt32Field lat = PBField.initInt32(0);
    public final PBInt32Field lng = PBField.initInt32(0);
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public final PBUInt32Field begin = PBField.initUInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
}
