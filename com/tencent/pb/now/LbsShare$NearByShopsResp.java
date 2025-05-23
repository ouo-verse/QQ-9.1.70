package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class LbsShare$NearByShopsResp extends MessageMicro<LbsShare$NearByShopsResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"ec", "poilist", "next_begin", "total"}, new Object[]{0, null, 0, 0}, LbsShare$NearByShopsResp.class);

    /* renamed from: ec, reason: collision with root package name */
    public final PBUInt32Field f342136ec = PBField.initUInt32(0);
    public final PBRepeatMessageField<LbsShare$Shop> poilist = PBField.initRepeatMessage(LbsShare$Shop.class);
    public final PBUInt32Field next_begin = PBField.initUInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
}
