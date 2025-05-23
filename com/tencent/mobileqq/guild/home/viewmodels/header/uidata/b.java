package com.tencent.mobileqq.guild.home.viewmodels.header.uidata;

import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \t2\u00020\u0001:\u0001\u0005B!\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0000H&R\"\u0010\r\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "", "other", "", "b", "a", "c", "", "I", "d", "()I", "setId", "(I)V", "id", "Z", "f", "()Z", "setActive", "(Z)V", "isActive", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "e", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "g", "(Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;)V", "tintColors", "<init>", "(IZLcom/tencent/mobileqq/guild/home/viewmodels/header/e;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildHomeCoverColors tintColors;

    public b(int i3, boolean z16, @NotNull GuildHomeCoverColors tintColors) {
        Intrinsics.checkNotNullParameter(tintColors, "tintColors");
        this.id = i3;
        this.isActive = z16;
        this.tintColors = tintColors;
    }

    public abstract boolean a(@NotNull b other);

    public abstract boolean b(@NotNull b other);

    @Nullable
    public abstract Object c(@NotNull b other);

    /* renamed from: d, reason: from getter */
    public int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public GuildHomeCoverColors getTintColors() {
        return this.tintColors;
    }

    /* renamed from: f, reason: from getter */
    public boolean getIsActive() {
        return this.isActive;
    }

    public void g(@NotNull GuildHomeCoverColors guildHomeCoverColors) {
        Intrinsics.checkNotNullParameter(guildHomeCoverColors, "<set-?>");
        this.tintColors = guildHomeCoverColors;
    }

    public /* synthetic */ b(int i3, boolean z16, GuildHomeCoverColors guildHomeCoverColors, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? false : z16, guildHomeCoverColors);
    }
}
