package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_near_anchor$GetNearMicroAnchorRsp extends MessageMicro<ilive_feeds_near_anchor$GetNearMicroAnchorRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"ret", "micro_infos", "micro_anchor_num"}, new Object[]{0, null, 0}, ilive_feeds_near_anchor$GetNearMicroAnchorRsp.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBRepeatMessageField<ilive_feeds_near_anchor$NearMicroAnchor> micro_infos = PBField.initRepeatMessage(ilive_feeds_near_anchor$NearMicroAnchor.class);
    public final PBUInt32Field micro_anchor_num = PBField.initUInt32(0);
}
