package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class MobileOrderServer$GetSubscribeReply extends MessageMicro<MobileOrderServer$GetSubscribeReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48, 56, 66}, new String[]{"RetMsg", "RetCode", "IsFlowFree", "ItemList", "MaxExpiredTime", "NextReqTime", "FlowThreshold", "FlowThresholdText"}, new Object[]{"", 0, 0, null, "", 0, 0, ""}, MobileOrderServer$GetSubscribeReply.class);
    public final PBStringField RetMsg = PBField.initString("");
    public final PBInt32Field RetCode = PBField.initInt32(0);
    public final PBInt32Field IsFlowFree = PBField.initInt32(0);
    public final PBRepeatMessageField<MobileOrderServer$SubscribeItem> ItemList = PBField.initRepeatMessage(MobileOrderServer$SubscribeItem.class);
    public final PBStringField MaxExpiredTime = PBField.initString("");
    public final PBUInt32Field NextReqTime = PBField.initUInt32(0);
    public final PBInt32Field FlowThreshold = PBField.initInt32(0);
    public final PBStringField FlowThresholdText = PBField.initString("");
}
