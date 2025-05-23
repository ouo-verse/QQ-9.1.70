package com.tencent.troopguild.report.api;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.troopguild.api.ITroopGuildMsgApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/troopguild/report/api/ITroopGuildDtReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reportMsgPushClick", "", "pushMsgInfo", "Lcom/tencent/troopguild/api/ITroopGuildMsgApi$MsgPushInfo;", "reportMsgPushExposure", "msg", "Lcom/tencent/imcore/message/Message;", "troop-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes7.dex */
public interface ITroopGuildDtReportApi extends QRouteApi {
    void reportMsgPushClick(@NotNull ITroopGuildMsgApi.MsgPushInfo pushMsgInfo);

    void reportMsgPushExposure(@NotNull Message msg2);
}
