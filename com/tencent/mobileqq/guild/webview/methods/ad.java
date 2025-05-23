package com.tencent.mobileqq.guild.webview.methods;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.guild.channel.create.dialog.GuildLinkSubChannelExaminingHintDialog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/ad;", "Lcom/tencent/mobileqq/guild/webview/methods/a;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "k", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ad extends a {
    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        GuildLinkSubChannelExaminingHintDialog.Companion companion = GuildLinkSubChannelExaminingHintDialog.INSTANCE;
        Activity a16 = this.f235756e.mRuntime.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentManager supportFragmentManager = ((FragmentActivity) a16).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "mPlugin.mRuntime.activit\u2026y).supportFragmentManager");
        companion.a(supportFragmentManager);
        return true;
    }
}
