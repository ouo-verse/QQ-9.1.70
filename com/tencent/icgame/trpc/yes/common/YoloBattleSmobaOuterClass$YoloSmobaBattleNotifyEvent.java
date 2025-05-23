package com.tencent.icgame.trpc.yes.common;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaBattleNotifyEvent extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaBattleNotifyEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{CGNonAgeReport.EVENT_TYPE, "event_time", "one_event", "smoba_config"}, new Object[]{0, 0, null, null}, YoloBattleSmobaOuterClass$YoloSmobaBattleNotifyEvent.class);
    public final PBEnumField event_type = PBField.initEnum(0);
    public final PBUInt32Field event_time = PBField.initUInt32(0);
    public YoloBattleSmobaOuterClass$YoloOneSmobaBattleEvent one_event = new YoloBattleSmobaOuterClass$YoloOneSmobaBattleEvent();
    public YoloBattleSmobaOuterClass$YoloSmobaBattleConfig smoba_config = new YoloBattleSmobaOuterClass$YoloSmobaBattleConfig();
}
