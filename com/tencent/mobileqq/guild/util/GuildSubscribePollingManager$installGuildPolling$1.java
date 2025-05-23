package com.tencent.mobileqq.guild.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qphone.base.util.QLog;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Incorrect field signature: TT; */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/util/GuildSubscribePollingManager$installGuildPolling$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildSubscribePollingManager$installGuildPolling$1 implements LifecycleEventObserver {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f235375d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f235376e;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235377a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f235377a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Incorrect types in method signature: (TT;Ljava/lang/String;)V */
    public GuildSubscribePollingManager$installGuildPolling$1(LifecycleOwner lifecycleOwner, String str) {
        this.f235375d = lifecycleOwner;
        this.f235376e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LifecycleOwner source, LifecycleOwner guildIdOwner, String pageId) {
        Intrinsics.checkNotNullParameter(source, "$source");
        Intrinsics.checkNotNullParameter(guildIdOwner, "$guildIdOwner");
        Intrinsics.checkNotNullParameter(pageId, "$pageId");
        if (!source.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            GuildSubscribePollingManager.f235373a.d(((com.tencent.mobileqq.guild.homev2.misc.d) guildIdOwner).getGuildId(), pageId);
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull final LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        Logger logger = Logger.f235387a;
        String str = this.f235376e;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.GuildSubscribePollingManager", 1, "guildPollingPage onStateChanged:" + event + " " + str);
        }
        int i3 = a.f235377a[event.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    source.getLifecycle().removeObserver(this);
                    return;
                }
                return;
            } else {
                final LifecycleOwner lifecycleOwner = this.f235375d;
                final String str2 = this.f235376e;
                Function0.b(256, new Runnable() { // from class: com.tencent.mobileqq.guild.util.bb
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildSubscribePollingManager$installGuildPolling$1.b(LifecycleOwner.this, lifecycleOwner, str2);
                    }
                });
                return;
            }
        }
        GuildSubscribePollingManager.f235373a.c(((com.tencent.mobileqq.guild.homev2.misc.d) this.f235375d).getGuildId(), this.f235376e);
    }
}
