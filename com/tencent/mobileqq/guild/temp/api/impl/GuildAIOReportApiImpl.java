package com.tencent.mobileqq.guild.temp.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.guild.temp.api.IGuildAIOReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016JX\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/GuildAIOReportApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/IGuildAIOReportApi;", "", "channelUin", "newReportPluginEncrypt", "evilUin", "Lmqq/app/AppRuntime;", "appRuntime", "getBuddyFlag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "buddyFlag", "guildId", "selfUin", "", "scene", "reportMsg", "msgCount", "msgEncBase64", "Landroid/os/Bundle;", "bundle", "", "actionSheetReport", "<init>", "()V", "Companion", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildAIOReportApiImpl implements IGuildAIOReportApi {
    public static final String TAG = "GuildAIOReportApiImpl";

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOReportApi
    public void actionSheetReport(Activity activity, String evilUin, String buddyFlag, String guildId, String selfUin, int scene, String reportMsg, int msgCount, String msgEncBase64, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(evilUin, "evilUin");
        Intrinsics.checkNotNullParameter(buddyFlag, "buddyFlag");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(reportMsg, "reportMsg");
        Intrinsics.checkNotNullParameter(msgEncBase64, "msgEncBase64");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        ((IQQGuildJubaoApi) QRoute.api(IQQGuildJubaoApi.class)).actionSheetReport(activity instanceof BaseActivity ? (BaseActivity) activity : null, evilUin, buddyFlag, guildId, selfUin, scene, reportMsg, msgCount, msgEncBase64, bundle.getString("chatuin"), bundle.getBoolean("isdirectmsg", false));
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOReportApi
    public String getBuddyFlag(String evilUin, AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(evilUin, "evilUin");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(evilUin);
        Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026a).getUidFromUin(evilUin)");
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, TAG)) {
            return "1";
        }
        return "0";
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOReportApi
    public String newReportPluginEncrypt(String channelUin) {
        Intrinsics.checkNotNullParameter(channelUin, "channelUin");
        String j3 = NewReportPlugin.j(channelUin, NewReportPlugin.p(1));
        Intrinsics.checkNotNullExpressionValue(j3, "encrypt(channelUin, NewR\u2026eportConstants.MODE_UIN))");
        return j3;
    }
}
