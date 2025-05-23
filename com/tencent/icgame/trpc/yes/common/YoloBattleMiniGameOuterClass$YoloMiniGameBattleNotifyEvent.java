package com.tencent.icgame.trpc.yes.common;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleMiniGameOuterClass$YoloMiniGameBattleNotifyEvent extends MessageMicro<YoloBattleMiniGameOuterClass$YoloMiniGameBattleNotifyEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 162}, new String[]{CGNonAgeReport.EVENT_TYPE, "event_time", DownloadInfo.spKey_Config, "extra_data"}, new Object[]{0, 0, null, ""}, YoloBattleMiniGameOuterClass$YoloMiniGameBattleNotifyEvent.class);
    public final PBEnumField event_type = PBField.initEnum(0);
    public final PBUInt32Field event_time = PBField.initUInt32(0);
    public YoloBattleMiniGameOuterClass$YoloMiniGameBattleConfig config = new YoloBattleMiniGameOuterClass$YoloMiniGameBattleConfig();
    public final PBStringField extra_data = PBField.initString("");
}
