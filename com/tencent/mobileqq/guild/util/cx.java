package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.api.IGuildWebApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J(\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J(\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J4\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J4\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J@\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/util/cx;", "", "Landroid/content/Context;", "context", "", "url", "", "a", "Landroid/os/Bundle;", "extra", "b", "guildId", "c", "d", "urlSenderUin", "e", "f", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class cx {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final cx f235542a = new cx();

    cx() {
    }

    @JvmStatic
    public static final void a(@Nullable Context context, @Nullable String url) {
        f(context, url, null, null, null);
    }

    @JvmStatic
    public static final void b(@Nullable Context context, @Nullable String url, @Nullable Bundle extra) {
        f(context, url, null, null, extra);
    }

    @JvmStatic
    public static final void c(@Nullable Context context, @Nullable String url, @Nullable String guildId) {
        f(context, url, guildId, null, null);
    }

    @JvmStatic
    public static final void d(@Nullable Context context, @Nullable String url, @Nullable String guildId, @Nullable Bundle extra) {
        f(context, url, guildId, null, extra);
    }

    @JvmStatic
    public static final void e(@Nullable Context context, @Nullable String url, @Nullable String guildId, @Nullable String urlSenderUin) {
        f(context, url, guildId, urlSenderUin, null);
    }

    @JvmStatic
    public static final void f(@Nullable Context context, @Nullable String url, @Nullable String guildId, @Nullable String urlSenderUin, @Nullable Bundle extra) {
        ((IGuildWebApi) QRoute.api(IGuildWebApi.class)).openWebUrlOnlyForGuild(context, url, extra, urlSenderUin, guildId);
    }
}
