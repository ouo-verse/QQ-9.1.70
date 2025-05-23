package com.tencent.guild.api.msglist.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.guild.api.msglist.IGuildAIOMultiActionApi;
import com.tencent.mobileqq.guild.temp.api.IGuildAIOReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JX\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guild/api/msglist/impl/GuildAIOMultiActionApiImpl;", "Lcom/tencent/guild/api/msglist/IGuildAIOMultiActionApi;", "()V", "actionSheetReport", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "evilUin", "", "buddyFlag", "guildId", "selfUin", "scene", "", "reportMsg", "msgCount", "msgEncBase64", "bundle", "Landroid/os/Bundle;", "getBuddyFlag", "appRuntime", "Lmqq/app/AppRuntime;", "newReportPluginEncrypt", "channelUin", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildAIOMultiActionApiImpl implements IGuildAIOMultiActionApi {
    @Override // com.tencent.guild.api.msglist.IGuildAIOMultiActionApi
    public void actionSheetReport(@NotNull Activity activity, @NotNull String evilUin, @NotNull String buddyFlag, @NotNull String guildId, @NotNull String selfUin, int scene, @NotNull String reportMsg, int msgCount, @NotNull String msgEncBase64, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(evilUin, "evilUin");
        Intrinsics.checkNotNullParameter(buddyFlag, "buddyFlag");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(reportMsg, "reportMsg");
        Intrinsics.checkNotNullParameter(msgEncBase64, "msgEncBase64");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        ((IGuildAIOReportApi) QRoute.api(IGuildAIOReportApi.class)).actionSheetReport(activity, evilUin, buddyFlag, guildId, selfUin, scene, reportMsg, msgCount, msgEncBase64, bundle);
    }

    @Override // com.tencent.guild.api.msglist.IGuildAIOMultiActionApi
    @NotNull
    public String getBuddyFlag(@NotNull String evilUin, @NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(evilUin, "evilUin");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        return ((IGuildAIOReportApi) QRoute.api(IGuildAIOReportApi.class)).getBuddyFlag(evilUin, appRuntime);
    }

    @Override // com.tencent.guild.api.msglist.IGuildAIOMultiActionApi
    @NotNull
    public String newReportPluginEncrypt(@NotNull String channelUin) {
        Intrinsics.checkNotNullParameter(channelUin, "channelUin");
        return ((IGuildAIOReportApi) QRoute.api(IGuildAIOReportApi.class)).newReportPluginEncrypt(channelUin);
    }
}
