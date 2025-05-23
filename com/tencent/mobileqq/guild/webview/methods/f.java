package com.tencent.mobileqq.guild.webview.methods;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.webview.g;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJP\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\b\"\u0004\u0018\u00010\u0004H\u0096\u0002\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/f;", "Lcom/tencent/mobileqq/guild/webview/g$a;", "Lcom/tencent/mobileqq/guild/webview/g;", "plugin", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "", "a", "(Lcom/tencent/mobileqq/guild/webview/g;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f implements g.a {
    @Override // com.tencent.mobileqq.guild.webview.g.a
    public boolean a(@Nullable com.tencent.mobileqq.guild.webview.g plugin, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        Activity activity;
        WebViewPlugin.b bVar;
        Intrinsics.checkNotNullParameter(args, "args");
        if (plugin != null && (bVar = plugin.mRuntime) != null) {
            activity = bVar.a();
        } else {
            activity = null;
        }
        RobotInfoFragment.wh((FragmentActivity) activity, "", args[1], "", args[0], "2", false, 12);
        return true;
    }
}
