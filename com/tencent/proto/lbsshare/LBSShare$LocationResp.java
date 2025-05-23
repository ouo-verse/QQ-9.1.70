package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class LBSShare$LocationResp extends MessageMicro<LBSShare$LocationResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 56}, new String[]{"ec", "poilist", "mylbs", "next", "is_foreign", "search_id", "is_ark"}, new Object[]{0, null, null, 0, 0, "", 0}, LBSShare$LocationResp.class);

    /* renamed from: ec, reason: collision with root package name */
    public final PBUInt32Field f342181ec = PBField.initUInt32(0);
    public final PBRepeatMessageField<LBSShare$POI> poilist = PBField.initRepeatMessage(LBSShare$POI.class);
    public LBSShare$POI mylbs = new LBSShare$POI();
    public final PBUInt32Field next = PBField.initUInt32(0);
    public final PBUInt32Field is_foreign = PBField.initUInt32(0);
    public final PBStringField search_id = PBField.initString("");
    public final PBUInt32Field is_ark = PBField.initUInt32(0);
}
