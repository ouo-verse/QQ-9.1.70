package com.tencent.guild.aio.component.slowmode;

import com.qzone.homepage.business.model.FunnySpaceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/guild/aio/component/slowmode/SlowModeTipType;", "a", "Lcom/tencent/guild/aio/component/slowmode/SlowModeTipType;", "c", "()Lcom/tencent/guild/aio/component/slowmode/SlowModeTipType;", "type", "b", "I", "()I", FunnySpaceModel.META_KEY_CYCLE, "count", "<init>", "(Lcom/tencent/guild/aio/component/slowmode/SlowModeTipType;II)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guild.aio.component.slowmode.f, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class SlowModeUIData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SlowModeTipType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int cycle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int count;

    public SlowModeUIData(@NotNull SlowModeTipType type, int i3, int i16) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.cycle = i3;
        this.count = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: b, reason: from getter */
    public final int getCycle() {
        return this.cycle;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final SlowModeTipType getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SlowModeUIData)) {
            return false;
        }
        SlowModeUIData slowModeUIData = (SlowModeUIData) other;
        if (this.type == slowModeUIData.type && this.cycle == slowModeUIData.cycle && this.count == slowModeUIData.count) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.cycle) * 31) + this.count;
    }

    @NotNull
    public String toString() {
        return "SlowModeUIData(type=" + this.type + ", cycle=" + this.cycle + ", count=" + this.count + ")";
    }

    public /* synthetic */ SlowModeUIData(SlowModeTipType slowModeTipType, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(slowModeTipType, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16);
    }
}
