package mo4;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.timi.game.web.business.api.race.LivingRoomInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00032\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lmo4/b;", "", "", "b", "Lcom/tencent/timi/game/web/business/api/race/LivingRoomInfo;", "a", "Lcom/tencent/timi/game/web/business/api/race/LivingRoomInfo;", "c", "()Lcom/tencent/timi/game/web/business/api/race/LivingRoomInfo;", "d", "(Lcom/tencent/timi/game/web/business/api/race/LivingRoomInfo;)V", "currentLivingRoomInfo", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final b f417116c = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LivingRoomInfo currentLivingRoomInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lmo4/b$a;", "", "Lmo4/b;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lmo4/b;", "a", "()Lmo4/b;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: mo4.b$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a() {
            return b.f417116c;
        }

        Companion() {
        }
    }

    public final void b() {
        this.currentLivingRoomInfo = null;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final LivingRoomInfo getCurrentLivingRoomInfo() {
        return this.currentLivingRoomInfo;
    }

    public final void d(@Nullable LivingRoomInfo livingRoomInfo) {
        this.currentLivingRoomInfo = livingRoomInfo;
    }
}
