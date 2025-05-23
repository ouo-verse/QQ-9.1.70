package com.tencent.mobileqq.guild.temp.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.guild.temp.api.IGuildFolderApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/GuildFolderApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/IGuildFolderApi;", "", "scene", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "toMsgListGuildHelper", "<init>", "()V", "Companion", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildFolderApiImpl implements IGuildFolderApi {
    public static final String PARAM_SCENE = "REQUEST_SCROLL_GUILD_HELPER_SCENE";
    public static final String TAG = "GuildFolderApiImpl";

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFolderApi
    public void toMsgListGuildHelper(String scene, Activity activity) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent();
        intent.setComponent(SplashActivity.getAliasComponent(activity));
        intent.setFlags(335544320);
        intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        intent.putExtra("REQUEST_SCROLL_GUILD_HELPER_SCENE", scene);
        activity.startActivity(intent);
    }
}
