package com.tencent.mobileqq.guild.temp.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.guild.activity.AIOSingleTaskTransActivity;
import com.tencent.mobileqq.guild.activity.GuildChatActivity;
import com.tencent.mobileqq.guild.activity.GuildChatFragment;
import com.tencent.mobileqq.guild.temp.api.IGuildActivityApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/GuildActivityApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/IGuildActivityApi;", "()V", "getAIOSingleActivityClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/guild/activity/AIOSingleTaskTransActivity;", "getGuildChatActivityClass", "Lcom/tencent/mobileqq/guild/activity/GuildChatActivity;", "getGuildChatFragmentClass", "Lcom/tencent/mobileqq/guild/activity/GuildChatFragment;", "isGuildAIOSingleTaskActivity", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "isGuildChatActivity", "isSplashActivity", "launchGuildChatPieInSplitMode", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class GuildActivityApiImpl implements IGuildActivityApi {
    @Override // com.tencent.mobileqq.guild.temp.api.IGuildActivityApi
    public Class<AIOSingleTaskTransActivity> getAIOSingleActivityClass() {
        return AIOSingleTaskTransActivity.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildActivityApi
    public Class<GuildChatActivity> getGuildChatActivityClass() {
        return GuildChatActivity.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildActivityApi
    public Class<GuildChatFragment> getGuildChatFragmentClass() {
        return GuildChatFragment.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildActivityApi
    public boolean isGuildAIOSingleTaskActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return activity instanceof AIOSingleTaskTransActivity;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildActivityApi
    public boolean isGuildChatActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return activity instanceof GuildChatActivity;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildActivityApi
    public boolean isSplashActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return activity instanceof SplashActivity;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildActivityApi
    public void launchGuildChatPieInSplitMode(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        IQQGuildUIUtilApi iQQGuildUIUtilApi = (IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class);
        Class<GuildChatFragment> guildChatFragmentClass = getGuildChatFragmentClass();
        Intrinsics.checkNotNull(guildChatFragmentClass, "null cannot be cast to non-null type java.lang.Class<out com.tencent.mobileqq.fragment.QPublicBaseFragment>");
        iQQGuildUIUtilApi.launchFragmentInSplitMode(context, intent, guildChatFragmentClass, LaunchMode.singleTask);
    }
}
