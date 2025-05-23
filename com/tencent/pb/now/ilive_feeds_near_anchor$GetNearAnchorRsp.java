package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_near_anchor$GetNearAnchorRsp extends MessageMicro<ilive_feeds_near_anchor$GetNearAnchorRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"ret", "anchor_num", "anchor_infos", "allow_repeated", "gender_filter"}, new Object[]{0, 0, null, 0, 0}, ilive_feeds_near_anchor$GetNearAnchorRsp.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBUInt32Field anchor_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<ilive_feeds_near_anchor$NearAnchorInfo> anchor_infos = PBField.initRepeatMessage(ilive_feeds_near_anchor$NearAnchorInfo.class);
    public final PBUInt32Field allow_repeated = PBField.initUInt32(0);
    public final PBEnumField gender_filter = PBField.initEnum(0);
}
