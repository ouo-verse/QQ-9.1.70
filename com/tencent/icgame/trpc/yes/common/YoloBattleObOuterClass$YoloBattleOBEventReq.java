package com.tencent.icgame.trpc.yes.common;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleObOuterClass$YoloBattleOBEventReq extends MessageMicro<YoloBattleObOuterClass$YoloBattleOBEventReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{CGNonAgeReport.EVENT_TYPE, "route_info"}, new Object[]{0, null}, YoloBattleObOuterClass$YoloBattleOBEventReq.class);
    public final PBEnumField event_type = PBField.initEnum(0);
    public YoloBattleObOuterClass$YoloBattleOBNotifyEventRouteInfo route_info = new YoloBattleObOuterClass$YoloBattleOBNotifyEventRouteInfo();
}
