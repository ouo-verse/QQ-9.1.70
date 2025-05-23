package com.tencent.mobileqq.guild.home.viewmodels.header.uidata;

import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0005B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0016R\"\u0010\u000e\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0010\u001a\u0004\b\b\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/GuildHomeHeaderSpace;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "other", "", "b", "a", "", "c", "e", "Z", "f", "()Z", "setActive", "(Z)V", "isActive", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "g", "(Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;)V", "tintColors", "", "I", "i", "()I", "distancePx", "<init>", "(ZLcom/tencent/mobileqq/guild/home/viewmodels/header/e;I)V", h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeHeaderSpace extends b {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildHomeCoverColors> f225444i;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildHomeCoverColors tintColors;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int distancePx;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/GuildHomeHeaderSpace$a;", "", "", "distanceDp", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/GuildHomeHeaderSpace;", "b", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "defaultColor$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderSpace$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GuildHomeCoverColors a() {
            return (GuildHomeCoverColors) GuildHomeHeaderSpace.f225444i.getValue();
        }

        @NotNull
        public final GuildHomeHeaderSpace b(float distanceDp) {
            return new GuildHomeHeaderSpace(true, a(), QQGuildUIUtil.f(distanceDp));
        }

        Companion() {
        }
    }

    static {
        Lazy<GuildHomeCoverColors> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeCoverColors>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderSpace$Companion$defaultColor$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeCoverColors invoke() {
                return GuildHomeCoverColors.INSTANCE.c(0, -1);
            }
        });
        f225444i = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeHeaderSpace(boolean z16, @NotNull GuildHomeCoverColors tintColors, int i3) {
        super(1, false, tintColors, 2, null);
        Intrinsics.checkNotNullParameter(tintColors, "tintColors");
        this.isActive = z16;
        this.tintColors = tintColors;
        this.distancePx = i3;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    public boolean a(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if ((other instanceof GuildHomeHeaderSpace) && Intrinsics.areEqual(other, this)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    public boolean b(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if ((other instanceof GuildHomeHeaderSpace) && other.getId() == getId() && ((GuildHomeHeaderSpace) other).distancePx == this.distancePx) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    @Nullable
    public Object c(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    @NotNull
    /* renamed from: e, reason: from getter */
    public GuildHomeCoverColors getTintColors() {
        return this.tintColors;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    /* renamed from: f, reason: from getter */
    public boolean getIsActive() {
        return this.isActive;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    public void g(@NotNull GuildHomeCoverColors guildHomeCoverColors) {
        Intrinsics.checkNotNullParameter(guildHomeCoverColors, "<set-?>");
        this.tintColors = guildHomeCoverColors;
    }

    /* renamed from: i, reason: from getter */
    public final int getDistancePx() {
        return this.distancePx;
    }
}
