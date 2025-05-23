package po4;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.timi.game.web.business.api.race.LivingRaceNativeEvent;
import com.tencent.timi.game.web.business.impl.plugin.LivingInscriptionWebPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lpo4/j;", "", "Lcom/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin;", "plugin", "", "c", "Lcom/tencent/timi/game/web/business/api/race/LivingRaceNativeEvent;", "event", "b", "Lmqq/util/WeakReference;", "a", "Lmqq/util/WeakReference;", "weakPlugin", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final j f426647c = new j();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<LivingInscriptionWebPlugin> weakPlugin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lpo4/j$a;", "", "Lpo4/j;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lpo4/j;", "a", "()Lpo4/j;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: po4.j$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final j a() {
            return j.f426647c;
        }

        Companion() {
        }
    }

    public final void b(@NotNull LivingRaceNativeEvent event) {
        LivingInscriptionWebPlugin livingInscriptionWebPlugin;
        Intrinsics.checkNotNullParameter(event, "event");
        WeakReference<LivingInscriptionWebPlugin> weakReference = this.weakPlugin;
        if (weakReference != null && (livingInscriptionWebPlugin = weakReference.get()) != null) {
            livingInscriptionWebPlugin.m0(event);
        }
    }

    public final void c(@NotNull LivingInscriptionWebPlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.weakPlugin = new WeakReference<>(plugin);
    }
}
