package com.tencent.guild.api.configuration;

import android.content.res.Configuration;
import br0.a;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/api/configuration/GuildConfigurationManager;", "", "Lbr0/a;", "callback", "", "c", "d", "Landroid/content/res/Configuration;", "newConfig", "b", "", "Ljava/util/List;", "configurationListenerList", "<init>", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildConfigurationManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildConfigurationManager f112488a = new GuildConfigurationManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<a> configurationListenerList = new ArrayList();

    GuildConfigurationManager() {
    }

    @JvmStatic
    public static final void c(@NotNull final a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.api.configuration.GuildConfigurationManager$registerConfigurationCallback$$inlined$onMainThread$1
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                List list2;
                list = GuildConfigurationManager.configurationListenerList;
                list.remove(a.this);
                list2 = GuildConfigurationManager.configurationListenerList;
                list2.add(a.this);
            }
        });
    }

    @JvmStatic
    public static final void d(@NotNull final a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.api.configuration.GuildConfigurationManager$unregisterConfigurationCallback$$inlined$onMainThread$1
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                list = GuildConfigurationManager.configurationListenerList;
                list.remove(a.this);
            }
        });
    }

    public final void b(@NotNull final Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.api.configuration.GuildConfigurationManager$notifyGuildConfigurationUpdate$$inlined$onMainThread$1
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                list = GuildConfigurationManager.configurationListenerList;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).onConfigurationChanged(newConfig);
                }
            }
        });
    }
}
