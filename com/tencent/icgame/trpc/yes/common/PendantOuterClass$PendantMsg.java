package com.tencent.icgame.trpc.yes.common;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* loaded from: classes7.dex */
public final class PendantOuterClass$PendantMsg extends MessageMicro<PendantOuterClass$PendantMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56, 64, 72, 82, 88, 96}, new String[]{"ad_id", "pic", "jump_type", "jump_value", "view", StateEvent.Name.COUNTDOWN_TIME, QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time", "type", "content", "uid_list", QCircleSchemeAttr.Detail.CURRENT_TIME}, new Object[]{0, null, 0, "", 0, 0L, 0L, 0L, 0, null, 0L, 0L}, PendantOuterClass$PendantMsg.class);
    public final PBInt32Field ad_id = PBField.initInt32(0);
    public CommonOuterClass$ImageItem pic = new CommonOuterClass$ImageItem();
    public final PBInt32Field jump_type = PBField.initInt32(0);
    public final PBStringField jump_value = PBField.initString("");
    public final PBInt32Field view = PBField.initInt32(0);
    public final PBUInt64Field countdown_time = PBField.initUInt64(0);
    public final PBUInt64Field begin_time = PBField.initUInt64(0);
    public final PBUInt64Field end_time = PBField.initUInt64(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public PendantOuterClass$PendantMsgContent content = new PendantOuterClass$PendantMsgContent();
    public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field current_time = PBField.initUInt64(0);
}
