package com.tencent.icgame.trpc.yes.common;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$GetAnniversaryCelebrationIndexRsp extends MessageMicro<LiveActivityServerOuterClass$GetAnniversaryCelebrationIndexRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56}, new String[]{"award_list", "page_info", "status", QCircleSchemeAttr.Detail.CURRENT_TIME, "task_time", "open_time", "close_time"}, new Object[]{null, null, 0, 0L, 0L, 0L, 0L}, LiveActivityServerOuterClass$GetAnniversaryCelebrationIndexRsp.class);
    public final PBRepeatMessageField<LiveActivityServerOuterClass$AwardItem> award_list = PBField.initRepeatMessage(LiveActivityServerOuterClass$AwardItem.class);
    public LiveActivityServerOuterClass$AcctivityPage page_info = new LiveActivityServerOuterClass$AcctivityPage();
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBInt64Field current_time = PBField.initInt64(0);
    public final PBInt64Field task_time = PBField.initInt64(0);
    public final PBInt64Field open_time = PBField.initInt64(0);
    public final PBInt64Field close_time = PBField.initInt64(0);
}
