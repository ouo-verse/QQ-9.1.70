package com.tencent.mobileqq.guild.avatar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006*\u0001\u0019\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0007J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/avatar/GuildUserAvatarRepository;", "", "Lcom/tencent/mobileqq/guild/avatar/e;", "listener", "", "f", "k", "Lcom/tencent/mobileqq/guild/avatar/d;", "e", "j", "g", "", "guildId", "tinyId", h.F, "", "b", "Z", "isObserverAdd", "Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mListeners", "d", "mAvatarPendantListeners", "com/tencent/mobileqq/guild/avatar/GuildUserAvatarRepository$receiver$1", "Lcom/tencent/mobileqq/guild/avatar/GuildUserAvatarRepository$receiver$1;", "receiver", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildUserAvatarRepository {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildUserAvatarRepository f214647a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isObserverAdd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<e> mListeners;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<d> mAvatarPendantListeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final GuildUserAvatarRepository$receiver$1 receiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/avatar/GuildUserAvatarRepository$a", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "tinyId", "", "onGuildUserAvatarUrlUpdate", "pendantAvatarMeta", "onGuildUserAvatarPendantUpdate", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends GPServiceObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGuildUserAvatarPendantUpdate(@NotNull String tinyId, @NotNull String pendantAvatarMeta) {
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intrinsics.checkNotNullParameter(pendantAvatarMeta, "pendantAvatarMeta");
            Iterator it = GuildUserAvatarRepository.mAvatarPendantListeners.iterator();
            while (it.hasNext()) {
                ((d) it.next()).doOnUrlChange(tinyId, pendantAvatarMeta);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildUserAvatarUrlUpdate(@NotNull String guildId, @NotNull String tinyId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            GuildUserAvatarRepository.f214647a.h(guildId, tinyId);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.mobileqq.guild.avatar.GuildUserAvatarRepository$receiver$1, android.content.BroadcastReceiver] */
    static {
        GuildUserAvatarRepository guildUserAvatarRepository = new GuildUserAvatarRepository();
        f214647a = guildUserAvatarRepository;
        mListeners = new CopyOnWriteArrayList<>();
        mAvatarPendantListeners = new CopyOnWriteArrayList<>();
        ?? r16 = new BroadcastReceiver() { // from class: com.tencent.mobileqq.guild.avatar.GuildUserAvatarRepository$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                GuildUserAvatarRepository.f214647a.g();
            }
        };
        receiver = r16;
        if (BaseApplication.getContext() != null && BaseApplication.getContext().getContentResolver() != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NewIntent.ACTION_LOGIN);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            MobileQQ.sMobileQQ.registerReceiver(r16, intentFilter);
        }
        guildUserAvatarRepository.g();
    }

    GuildUserAvatarRepository() {
    }

    @JvmStatic
    public static final void e(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!isObserverAdd) {
            f214647a.g();
        }
        mAvatarPendantListeners.addIfAbsent(listener);
    }

    @JvmStatic
    public static final void f(@NotNull e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!isObserverAdd) {
            f214647a.g();
        }
        mListeners.addIfAbsent(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null && (waitAppRuntime instanceof AppInterface)) {
            if (!at.c()) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("initObserver sdk isn't ready");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.user.GuildUserAvatarRepository", 1, (String) it.next(), null);
                }
                return;
            }
            ((IGPSService) waitAppRuntime.getRuntimeService(IGPSService.class, "")).addObserver(new a());
            isObserverAdd = true;
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.user.GuildUserAvatarRepository", 2, "initObserver");
                return;
            }
            return;
        }
        Logger logger3 = Logger.f235387a;
        Logger.b bVar2 = new Logger.b();
        bVar2.a().add("initObserver error");
        Iterator<T> it5 = bVar2.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("Guild.user.GuildUserAvatarRepository", 1, (String) it5.next(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(final String guildId, final String tinyId) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.avatar.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildUserAvatarRepository.i(guildId, tinyId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String guildId, String tinyId) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(tinyId, "$tinyId");
        Iterator<T> it = mListeners.iterator();
        while (it.hasNext()) {
            ((e) it.next()).doOnUrlChange(guildId, tinyId);
        }
    }

    @JvmStatic
    public static final void j(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        mAvatarPendantListeners.remove(listener);
    }

    @JvmStatic
    public static final void k(@NotNull e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        mListeners.remove(listener);
    }
}
