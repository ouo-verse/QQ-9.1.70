package com.tencent.timi.game.liveroom.impl.room.userlevel.bean;

import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/userlevel/bean/UserLevelToggle;", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class UserLevelToggle {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f378593b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f378594c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f378595d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f378596e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f378597f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f378598g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f378599h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Lazy<Integer> f378600i;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001b\u0010\u0016\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001b\u0010\u001b\u001a\u00020\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/userlevel/bean/UserLevelToggle$a;", "", "", "showGiftPanelView$delegate", "Lkotlin/Lazy;", "c", "()Z", "showGiftPanelView", "showRank$delegate", "f", "showRank", "showMiniCard$delegate", "e", "showMiniCard", "showMessage$delegate", "d", "showMessage", "showEnterRoomBubble$delegate", "b", "showEnterRoomBubble", "useRemoteBubbleBg$delegate", "g", "useRemoteBubbleBg", "", "enterRoomBannerMaxCount$delegate", "a", "()I", "enterRoomBannerMaxCount", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ((Number) UserLevelToggle.f378600i.getValue()).intValue();
        }

        public final boolean b() {
            return ((Boolean) UserLevelToggle.f378598g.getValue()).booleanValue();
        }

        public final boolean c() {
            return ((Boolean) UserLevelToggle.f378593b.getValue()).booleanValue();
        }

        public final boolean d() {
            return ((Boolean) UserLevelToggle.f378596e.getValue()).booleanValue();
        }

        public final boolean e() {
            return ((Boolean) UserLevelToggle.f378595d.getValue()).booleanValue();
        }

        public final boolean f() {
            return ((Boolean) UserLevelToggle.f378594c.getValue()).booleanValue();
        }

        public final boolean g() {
            return ((Boolean) UserLevelToggle.f378599h.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Boolean> lazy;
        Lazy<Boolean> lazy2;
        Lazy<Boolean> lazy3;
        Lazy<Boolean> lazy4;
        Lazy<Boolean> lazy5;
        Lazy<Boolean> lazy6;
        Lazy<Boolean> lazy7;
        Lazy<Integer> lazy8;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle$Companion$showGiftPanelView$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Boolean valueOf = Boolean.valueOf(ht3.a.e("qqlive_show_gift_panel_user_pay_level", true));
                boolean booleanValue = valueOf.booleanValue();
                AegisLogger.INSTANCE.i("Gift|UserLevelToggle", "showGiftPanelView:" + booleanValue);
                return valueOf;
            }
        });
        f378593b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle$Companion$showRank$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Boolean valueOf = Boolean.valueOf(ht3.a.e("qqlive_show_rank_user_pay_level", true));
                boolean booleanValue = valueOf.booleanValue();
                AegisLogger.INSTANCE.i("Gift|UserLevelToggle", "showRank:" + booleanValue);
                return valueOf;
            }
        });
        f378594c = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle$Companion$showMiniCard$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Boolean valueOf = Boolean.valueOf(ht3.a.e("qqlive_show_mini_card_user_pay_level", true));
                boolean booleanValue = valueOf.booleanValue();
                AegisLogger.INSTANCE.i("Gift|UserLevelToggle", "showMiniCard:" + booleanValue);
                return valueOf;
            }
        });
        f378595d = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle$Companion$showMessage$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Boolean valueOf = Boolean.valueOf(ht3.a.e("qqlive_show_message_user_pay_level", true));
                boolean booleanValue = valueOf.booleanValue();
                AegisLogger.INSTANCE.i("Gift|UserLevelToggle", "show message:" + booleanValue);
                return valueOf;
            }
        });
        f378596e = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle$Companion$showUpgradeMsg$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Boolean valueOf = Boolean.valueOf(ht3.a.e("qqlive_show_message_user_pay_level", true));
                boolean booleanValue = valueOf.booleanValue();
                AegisLogger.INSTANCE.i("Gift|UserLevelToggle", "showUpgradeMsg:" + booleanValue);
                return valueOf;
            }
        });
        f378597f = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle$Companion$showEnterRoomBubble$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Boolean valueOf = Boolean.valueOf(ht3.a.e("qqlive_show_enter_room_bubble", true));
                boolean booleanValue = valueOf.booleanValue();
                AegisLogger.INSTANCE.i("Gift|UserLevelToggle", "showEnterRoomBubble:" + booleanValue);
                return valueOf;
            }
        });
        f378598g = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle$Companion$useRemoteBubbleBg$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Boolean valueOf = Boolean.valueOf(ht3.a.e("qqlive_enter_room_use_remote_bubble_bg", true));
                boolean booleanValue = valueOf.booleanValue();
                AegisLogger.INSTANCE.i("Gift|UserLevelToggle", "useRemoteBubbleBg:" + booleanValue);
                return valueOf;
            }
        });
        f378599h = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle$Companion$enterRoomBannerMaxCount$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                Integer valueOf = Integer.valueOf(ht3.a.b("qqlive_enter_room_banner_max_count", 20));
                int intValue = valueOf.intValue();
                AegisLogger.INSTANCE.i("Gift|UserLevelToggle", "enterRoomBannerMaxCount:" + intValue);
                return valueOf;
            }
        });
        f378600i = lazy8;
    }
}
