package com.tencent.qqnt;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J&\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&J+\u0010\f\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/ITroopReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "configTroopCmdReportObj", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "troopUin", "", "from", "createTroopCmdReportObj", "Ljava/io/Serializable;", "cmdName", "doTroopCmdReport", "req", "requestErrorCode", "", "logicErrorCode", "reportObj", "(Ljava/io/Serializable;Ljava/lang/Integer;Ljava/lang/Integer;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface ITroopReportApi extends QRouteApi {
    void configTroopCmdReportObj(@Nullable ToServiceMsg request, @Nullable String troopUin, @Nullable String from);

    @NotNull
    Serializable createTroopCmdReportObj(@Nullable String cmdName, @Nullable String troopUin, @Nullable String from);

    void doTroopCmdReport(@Nullable ToServiceMsg req, int requestErrorCode, int logicErrorCode);

    void doTroopCmdReport(@Nullable Serializable reportObj, @Nullable Integer requestErrorCode, @Nullable Integer logicErrorCode);
}
