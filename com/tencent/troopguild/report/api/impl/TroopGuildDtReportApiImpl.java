package com.tencent.troopguild.report.api.impl;

import com.tencent.imcore.message.Message;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.troopguild.api.ITroopGuildMsgApi;
import com.tencent.troopguild.report.api.ITroopGuildDtReportApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import wo4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/troopguild/report/api/impl/TroopGuildDtReportApiImpl;", "Lcom/tencent/troopguild/report/api/ITroopGuildDtReportApi;", "()V", "reportMsgPushClick", "", "pushMsgInfo", "Lcom/tencent/troopguild/api/ITroopGuildMsgApi$MsgPushInfo;", "reportMsgPushExposure", "msg", "Lcom/tencent/imcore/message/Message;", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class TroopGuildDtReportApiImpl implements ITroopGuildDtReportApi {
    @Override // com.tencent.troopguild.report.api.ITroopGuildDtReportApi
    public void reportMsgPushClick(@NotNull ITroopGuildMsgApi.MsgPushInfo pushMsgInfo) {
        Intrinsics.checkNotNullParameter(pushMsgInfo, "pushMsgInfo");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_push_type", Integer.valueOf(pushMsgInfo.getPushType()));
        hashMap.put("group_id", pushMsgInfo.getGroupId());
        hashMap.put("group_is_sgrp", 1);
        hashMap.put("sgrp_channel_id", pushMsgInfo.getGroupId());
        hashMap.put("sgrp_sub_channel_id", pushMsgInfo.getChannelId());
        hashMap.put("sgrp_push_place", Integer.valueOf(pushMsgInfo.getPushPlace()));
        VideoReport.reportEvent("ev_group_channel_push_click", hashMap);
    }

    @Override // com.tencent.troopguild.report.api.ITroopGuildDtReportApi
    public void reportMsgPushExposure(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_push_type", Integer.valueOf(a.d(msg2)));
        hashMap.put("group_id", msg2.frienduin);
        hashMap.put("group_is_sgrp", 1);
        hashMap.put("sgrp_channel_id", a.b(msg2));
        hashMap.put("sgrp_sub_channel_id", a.a(msg2));
        hashMap.put("sgrp_push_place", Integer.valueOf(a.c(msg2)));
        VideoReport.reportEvent("ev_group_channel_push_exposure", hashMap);
    }
}
