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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0003R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/util/trace/k;", "", "", "b", "Landroid/content/Context;", "context", "d", "", "y", "e", "", "a", "c", "Z", "isShowing", "Lcom/tencent/mobileqq/guild/util/trace/GuildTraceSwitchFloat;", "Lcom/tencent/mobileqq/guild/util/trace/GuildTraceSwitchFloat;", "traceSwitchFloat", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes14.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f235688a = new k();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isShowing;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static GuildTraceSwitchFloat traceSwitchFloat;

    k() {
    }

    @JvmStatic
    public static final void a() {
        isShowing = false;
        GuildTraceSwitchFloat guildTraceSwitchFloat = traceSwitchFloat;
        if (guildTraceSwitchFloat != null) {
            Intrinsics.checkNotNull(guildTraceSwitchFloat);
            guildTraceSwitchFloat.p();
            traceSwitchFloat = null;
        }
    }

    @JvmStatic
    public static final boolean b() {
        return isShowing;
    }

    @TargetApi(23)
    private final void c(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    @JvmStatic
    public static final boolean d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return e(context, 10);
    }

    @JvmStatic
    public static final boolean e(@NotNull Context context, int y16) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Settings.canDrawOverlays(context)) {
            f235688a.c(context);
            Toast.makeText(context, "After grant this permission, re-enable GuildTraceTool", 1).show();
            return false;
        }
        isShowing = true;
        if (traceSwitchFloat == null) {
            traceSwitchFloat = new GuildTraceSwitchFloat(context, y16);
        }
        GuildTraceSwitchFloat guildTraceSwitchFloat = traceSwitchFloat;
        Intrinsics.checkNotNull(guildTraceSwitchFloat);
        if (guildTraceSwitchFloat.isShown()) {
            return false;
        }
        GuildTraceSwitchFloat guildTraceSwitchFloat2 = traceSwitchFloat;
        Intrinsics.checkNotNull(guildTraceSwitchFloat2);
        guildTraceSwitchFloat2.s();
        return true;
    }
}
