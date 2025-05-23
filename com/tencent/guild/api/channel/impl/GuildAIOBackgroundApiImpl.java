package com.tencent.guild.api.channel.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.guild.api.channel.IGuildAIOBackgroundApi;
import com.tencent.mobileqq.guild.temp.api.IGuildBackgroundApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guild/api/channel/impl/GuildAIOBackgroundApiImpl;", "Lcom/tencent/guild/api/channel/IGuildAIOBackgroundApi;", "Landroid/content/Context;", "context", "", "curFriendUid", "", "uinType", "Landroid/view/View;", "aioCreate", "selfUin", "", "aioDelayLoad", "aioResume", "aioPause", "aioDestroy", "curFriendUin", "Landroid/graphics/drawable/Drawable;", "getCurrentChatBackgroundDrawable", "getCurrentChatBackgroundBg", "<init>", "()V", "Companion", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAIOBackgroundApiImpl implements IGuildAIOBackgroundApi {

    @NotNull
    public static final String TAG = "AIOChatBackgroundApiImpl";

    @Override // com.tencent.guild.api.channel.IGuildAIOBackgroundApi
    @Nullable
    public View aioCreate(@Nullable Context context, @NotNull String curFriendUid, int uinType) {
        Intrinsics.checkNotNullParameter(curFriendUid, "curFriendUid");
        return ((IGuildBackgroundApi) QRoute.api(IGuildBackgroundApi.class)).getGuildBackground().b(context, curFriendUid, uinType);
    }

    @Override // com.tencent.guild.api.channel.IGuildAIOBackgroundApi
    public void aioDelayLoad(@NotNull String selfUin) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        ((IGuildBackgroundApi) QRoute.api(IGuildBackgroundApi.class)).getGuildBackground().a(selfUin);
    }

    @Override // com.tencent.guild.api.channel.IGuildAIOBackgroundApi
    public void aioDestroy() {
        ((IGuildBackgroundApi) QRoute.api(IGuildBackgroundApi.class)).getGuildBackground().onDestroy();
    }

    @Override // com.tencent.guild.api.channel.IGuildAIOBackgroundApi
    public void aioPause() {
        ((IGuildBackgroundApi) QRoute.api(IGuildBackgroundApi.class)).getGuildBackground().onPause();
    }

    @Override // com.tencent.guild.api.channel.IGuildAIOBackgroundApi
    public void aioResume() {
        ((IGuildBackgroundApi) QRoute.api(IGuildBackgroundApi.class)).getGuildBackground().onResume();
    }

    @Override // com.tencent.guild.api.channel.IGuildAIOBackgroundApi
    @Nullable
    public String getCurrentChatBackgroundBg(@NotNull String curFriendUin, int uinType) {
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        return ((IGuildBackgroundApi) QRoute.api(IGuildBackgroundApi.class)).getGuildBackground().getCurrentChatBackgroundBg(curFriendUin, uinType);
    }

    @Override // com.tencent.guild.api.channel.IGuildAIOBackgroundApi
    @Nullable
    public Drawable getCurrentChatBackgroundDrawable(@NotNull String curFriendUin, int uinType) {
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        return ((IGuildBackgroundApi) QRoute.api(IGuildBackgroundApi.class)).getGuildBackground().getCurrentChatBackgroundDrawable(curFriendUin, uinType);
    }
}
