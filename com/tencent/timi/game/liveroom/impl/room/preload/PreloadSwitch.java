package com.tencent.timi.game.liveroom.impl.room.preload;

import com.google.gson.annotations.SerializedName;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.timi.game.liveroom.impl.room.preload.PreloadSwitch;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \r2\u00020\u0001:\u0001\rB%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/preload/PreloadSwitch;", "", "", "noBusConfig", "Z", "e", "()Z", "noOnlineRank", "g", "noCheckFollow", "f", "<init>", "(ZZZ)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class PreloadSwitch {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f378414b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<PreloadSwitch> f378415c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f378416d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f378417e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f378418f;

    @SerializedName("no_bus_config")
    private final boolean noBusConfig;

    @SerializedName("no_check_follow")
    private final boolean noCheckFollow;

    @SerializedName("no_online_rank")
    private final boolean noOnlineRank;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000f\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/preload/PreloadSwitch$a;", "", "", "isEnable$delegate", "Lkotlin/Lazy;", "f", "()Z", "isEnable", "Lcom/tencent/timi/game/liveroom/impl/room/preload/PreloadSwitch;", "switch$delegate", "e", "()Lcom/tencent/timi/game/liveroom/impl/room/preload/PreloadSwitch;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "onlineRankUnEnable$delegate", "d", "onlineRankUnEnable", "checkFollowUnEnable$delegate", "c", "checkFollowUnEnable", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.preload.PreloadSwitch$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PreloadSwitch e() {
            return (PreloadSwitch) PreloadSwitch.f378415c.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean f() {
            return ((Boolean) PreloadSwitch.f378414b.getValue()).booleanValue();
        }

        public final boolean c() {
            return ((Boolean) PreloadSwitch.f378418f.getValue()).booleanValue();
        }

        public final boolean d() {
            return ((Boolean) PreloadSwitch.f378417e.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Boolean> lazy;
        Lazy<PreloadSwitch> lazy2;
        Lazy<Boolean> lazy3;
        Lazy<Boolean> lazy4;
        Lazy<Boolean> lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.timi.game.liveroom.impl.room.preload.PreloadSwitch$Companion$isEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        });
        f378414b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PreloadSwitch>() { // from class: com.tencent.timi.game.liveroom.impl.room.preload.PreloadSwitch$Companion$switch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PreloadSwitch invoke() {
                return new PreloadSwitch(false, false, false, 7, null);
            }
        });
        f378415c = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.timi.game.liveroom.impl.room.preload.PreloadSwitch$Companion$busConfigUnEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean f16;
                boolean z16;
                PreloadSwitch e16;
                PreloadSwitch.Companion companion = PreloadSwitch.INSTANCE;
                f16 = companion.f();
                if (f16) {
                    e16 = companion.e();
                    if (e16.getNoBusConfig()) {
                        z16 = true;
                        return Boolean.valueOf(z16);
                    }
                }
                z16 = false;
                return Boolean.valueOf(z16);
            }
        });
        f378416d = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.timi.game.liveroom.impl.room.preload.PreloadSwitch$Companion$onlineRankUnEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean f16;
                boolean z16;
                PreloadSwitch e16;
                PreloadSwitch.Companion companion = PreloadSwitch.INSTANCE;
                f16 = companion.f();
                if (f16) {
                    e16 = companion.e();
                    if (e16.getNoOnlineRank()) {
                        z16 = true;
                        return Boolean.valueOf(z16);
                    }
                }
                z16 = false;
                return Boolean.valueOf(z16);
            }
        });
        f378417e = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.timi.game.liveroom.impl.room.preload.PreloadSwitch$Companion$checkFollowUnEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean f16;
                boolean z16;
                PreloadSwitch e16;
                PreloadSwitch.Companion companion = PreloadSwitch.INSTANCE;
                f16 = companion.f();
                if (f16) {
                    e16 = companion.e();
                    if (e16.getNoCheckFollow()) {
                        z16 = true;
                        return Boolean.valueOf(z16);
                    }
                }
                z16 = false;
                return Boolean.valueOf(z16);
            }
        });
        f378418f = lazy5;
    }

    public PreloadSwitch() {
        this(false, false, false, 7, null);
    }

    /* renamed from: e, reason: from getter */
    public final boolean getNoBusConfig() {
        return this.noBusConfig;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getNoCheckFollow() {
        return this.noCheckFollow;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getNoOnlineRank() {
        return this.noOnlineRank;
    }

    public PreloadSwitch(boolean z16, boolean z17, boolean z18) {
        this.noBusConfig = z16;
        this.noOnlineRank = z17;
        this.noCheckFollow = z18;
    }

    public /* synthetic */ PreloadSwitch(boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18);
    }
}
