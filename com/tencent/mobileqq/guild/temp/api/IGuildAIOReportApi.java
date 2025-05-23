package com.tencent.mobileqq.guild.temp.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JX\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/IGuildAIOReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "actionSheetReport", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "evilUin", "", "buddyFlag", "guildId", "selfUin", "scene", "", "reportMsg", "msgCount", "msgEncBase64", "bundle", "Landroid/os/Bundle;", "getBuddyFlag", "appRuntime", "Lmqq/app/AppRuntime;", "newReportPluginEncrypt", "channelUin", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildAIOReportApi extends QRouteApi {
    void actionSheetReport(@NotNull Activity activity, @NotNull String evilUin, @NotNull String buddyFlag, @NotNull String guildId, @NotNull String selfUin, int scene, @NotNull String reportMsg, int msgCount, @NotNull String msgEncBase64, @NotNull Bundle bundle);

    @NotNull
    String getBuddyFlag(@NotNull String evilUin, @NotNull AppRuntime appRuntime);

    @NotNull
    String newReportPluginEncrypt(@NotNull String channelUin);
}
