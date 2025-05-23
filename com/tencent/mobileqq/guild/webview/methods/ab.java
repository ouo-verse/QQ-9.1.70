package com.tencent.mobileqq.guild.webview.methods;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.GuildUserProfileCardFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.webview.methods.util.CommentInvokeResult;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/ab;", "Lcom/tencent/mobileqq/guild/webview/methods/a;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "k", "<init>", "()V", tl.h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ab extends a {
    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        int i3;
        Activity activity;
        WebViewPlugin.b bVar;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        String f16 = f("guildId");
        String f17 = f("channelId");
        String f18 = f("tinyId");
        int d16 = d("sceneType");
        if (j("profileType")) {
            i3 = d("profileType");
        } else {
            i3 = 0;
        }
        Logger.f235387a.d().i("Guild.jump.JS.AbsJsBridgeMethod", 1, "OpenGuildUserProfileJSMethod, guildId: " + f16 + ", tinyId: " + f18 + " profileType " + i3 + ", sceneType:" + d16);
        if (d16 == 0) {
            d16 = 11;
        }
        GuildProfileData guildProfileData = new GuildProfileData(f16, null, f18, i3, d16);
        guildProfileData.getGuildBaseProfileData().r(f17);
        Intent intent = new Intent();
        intent.putExtra("EXTRA_PROFILE_DATA", guildProfileData);
        com.tencent.mobileqq.guild.webview.g gVar = this.f235756e;
        if (gVar != null && (bVar = gVar.mRuntime) != null) {
            activity = bVar.a();
        } else {
            activity = null;
        }
        if (activity == null) {
            i(CommentInvokeResult.create(-1, "can't find context").toJson());
            return false;
        }
        QPublicFragmentActivity.b.b(activity, intent, QPublicTransFragmentActivity.class, GuildUserProfileCardFragment.class);
        i(CommentInvokeResult.create(0, "").toJson());
        return true;
    }
}
