package com.tencent.mobileqq.guild.util.trace;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/util/trace/a;", "", "Landroid/content/Context;", "context", "", "c", "", "y", "d", "", "a", "b", "Z", "isShowing", "Lcom/tencent/mobileqq/guild/util/trace/GuildDelegateDebugView;", "Lcom/tencent/mobileqq/guild/util/trace/GuildDelegateDebugView;", "traceSwitchFloat", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f235674a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isShowing;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static GuildDelegateDebugView traceSwitchFloat;

    a() {
    }

    @JvmStatic
    public static final void a() {
        isShowing = false;
        GuildDelegateDebugView guildDelegateDebugView = traceSwitchFloat;
        if (guildDelegateDebugView != null) {
            Intrinsics.checkNotNull(guildDelegateDebugView);
            guildDelegateDebugView.p();
            traceSwitchFloat = null;
        }
    }

    @TargetApi(23)
    private final void b(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    @JvmStatic
    public static final boolean c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return d(context, 10);
    }

    @JvmStatic
    public static final boolean d(@NotNull Context context, int y16) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Settings.canDrawOverlays(context)) {
            f235674a.b(context);
            Toast.makeText(context, "After grant this permission, re-enable GuildTraceTool", 1).show();
            return false;
        }
        isShowing = true;
        if (traceSwitchFloat == null) {
            traceSwitchFloat = new GuildDelegateDebugView(context, y16);
        }
        GuildDelegateDebugView guildDelegateDebugView = traceSwitchFloat;
        Intrinsics.checkNotNull(guildDelegateDebugView);
        if (guildDelegateDebugView.isShown()) {
            return false;
        }
        GuildDelegateDebugView guildDelegateDebugView2 = traceSwitchFloat;
        Intrinsics.checkNotNull(guildDelegateDebugView2);
        guildDelegateDebugView2.r();
        return true;
    }
}
