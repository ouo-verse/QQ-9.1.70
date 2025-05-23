package com.tencent.mobileqq.guild.temp.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.guild.temp.api.ITroopGuildAIOApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.guild.event.GuildHandlePassiveExitTroop;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J#\u0010\u000e\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/TroopGuildAIOApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/ITroopGuildAIOApi;", "Landroid/content/Context;", "context", "", "troopUin", "Landroid/os/Bundle;", "bundle", "Landroid/content/Intent;", "getJumpToTroopGuildIntent", "", "jumpToTroopFeedList", "", QQBrowserActivity.KEY_MSG_TYPE, "onHandlePassiveExitTroop", "(Ljava/lang/String;Ljava/lang/Integer;)V", "", "show", "", "helper", "updateFeedPopUp", "<init>", "()V", "Companion", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class TroopGuildAIOApiImpl implements ITroopGuildAIOApi {
    private static final String TAG = "TroopGuildAIOApiImpl";

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildAIOApi
    public Intent getJumpToTroopGuildIntent(Context context, String troopUin, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intent aioIntent = BaseAIOUtils.m(SplashActivity.getAliasIntent(context), new int[]{2});
        aioIntent.putExtra("uin", troopUin);
        aioIntent.putExtra("troop_uin", troopUin);
        aioIntent.putExtra("uintype", 1);
        aioIntent.putExtra(AppConstants.Key.TROOP_GUILD_BUNDLE, bundle);
        aioIntent.setAction("com.tencent.mobileqq.action.CHAT");
        Intrinsics.checkNotNullExpressionValue(aioIntent, "aioIntent");
        return aioIntent;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildAIOApi
    public void jumpToTroopFeedList(Context context, String troopUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        try {
            if (TextUtils.isEmpty(troopUin)) {
                QLog.e(TAG, 1, "jumpToTroopFeedList failed, troopuin is empty!");
            } else {
                ((IGuildFeedConfigAPi) QRoute.api(IGuildFeedConfigAPi.class)).launchTroopFeedActivity(context, troopUin);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "openTroopGuild e:", th5);
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildAIOApi
    public void onHandlePassiveExitTroop(String troopUin, Integer msgType) {
        if ((msgType != null && msgType.intValue() == 8) || (msgType != null && msgType.intValue() == 7)) {
            QLog.i(TAG, 1, "[onHandlePassiveExitTroop] Exit");
            SimpleEventBus.getInstance().dispatchEvent(new GuildHandlePassiveExitTroop(troopUin));
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildAIOApi
    public void updateFeedPopUp(boolean show, Object helper) {
    }
}
