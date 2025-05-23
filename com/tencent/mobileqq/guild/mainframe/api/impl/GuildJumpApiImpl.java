package com.tencent.mobileqq.guild.mainframe.api.impl;

import android.app.Activity;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.mainframe.api.IGuildJumpApi;
import com.tencent.mobileqq.guild.profile.IGuildProfileRuntimeService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lv1.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/api/impl/GuildJumpApiImpl;", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildJumpApi;", "", "nickName", "", "alreadyRegister", "Landroid/app/Activity;", "context", "url", "needRegister", PhotoCategorySummaryInfo.AVATAR_URL, "Lqr1/c;", "callback", "", "registerAndJumpGuild", "isGuildUser", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildJumpApiImpl implements IGuildJumpApi {

    @NotNull
    public static final String TAG = "Guild.MF.GuildJumpApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/mainframe/api/impl/GuildJumpApiImpl$b", "Llv1/c;", "", "result", "", "errorMsg", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f227290a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f227291b;

        b(qr1.c cVar, Activity activity, String str) {
            this.f227290a = activity;
            this.f227291b = str;
        }

        @Override // lv1.c
        public void a(int result, @NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            if (result == 0) {
                ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).openGuildByShareUrl(this.f227290a, this.f227291b, "");
            }
        }
    }

    private final boolean alreadyRegister(String nickName) {
        String guildUserDisplayName = ((IGPSService) ch.R0(IGPSService.class)).getGuildUserDisplayName("0", ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId());
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "runtimeService(IGPSServi\u2026::class.java).selfTinyId)");
        Logger.f235387a.d().i(TAG, 1, "current nickName:" + guildUserDisplayName);
        return Intrinsics.areEqual(guildUserDisplayName, nickName);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildJumpApi
    public boolean isGuildUser() {
        return ((IGuildUserService) ch.S0(IGuildUserService.class, "")).isGuildUser();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildJumpApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void registerAndJumpGuild(@NotNull Activity context, @Nullable String url, boolean needRegister, @Nullable String avatarUrl, @Nullable String nickName, @Nullable qr1.c callback) {
        String str;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(context, "context");
        if (url == null) {
            str = "";
        } else {
            str = url;
        }
        if (needRegister) {
            if (avatarUrl != null && avatarUrl.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (nickName != null && nickName.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    if (!alreadyRegister(nickName)) {
                        Logger.f235387a.d().i(TAG, 1, "registerAndJumpGuild url:" + url + ", needRegister:" + needRegister + ", avatarUrl:" + avatarUrl + ", nickName:" + nickName);
                        ((IGuildProfileRuntimeService) ch.S0(IGuildProfileRuntimeService.class, "")).setMyGuildProfile(avatarUrl, nickName, new b(callback, context, str));
                        return;
                    }
                    Logger.f235387a.d().i(TAG, 1, "justJump url:" + url + ", needRegister:" + needRegister + ", avatarUrl:" + avatarUrl + ", nickName:" + nickName);
                    if (callback != null) {
                        callback.a(0, "");
                    }
                    ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).openGuildByShareUrl(context, str, "");
                }
            }
        }
        Logger.f235387a.d().i(TAG, 1, "justJump url:" + url + ", needRegister:" + needRegister + ", avatarUrl:" + avatarUrl + ", nickName:" + nickName);
        if (callback != null) {
        }
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).openGuildByShareUrl(context, str, "");
    }
}
