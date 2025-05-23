package com.tencent.timi.game.liveroom.impl.room.input;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010#\u001a\u00020\u0007\u0012\u0006\u0010%\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010'J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\fR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0013\u0010\fR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\fR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010#\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0016\u0010\"R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b\u0011\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/n;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "()Ljava/util/List;", NodeProps.BACKGROUND_COLORS, "b", "getBackgroundPositions", "backgroundPositions", "c", "borderColors", "d", "getBorderPositions", "borderPositions", "e", "textColors", "f", "getTextPositions", "textPositions", "g", "Ljava/lang/String;", "getIconUrl", "()Ljava/lang/String;", "iconUrl", tl.h.F, "Z", "()Z", "isSingleLine", "i", "text", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.input.n, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class BarrageConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> backgroundColors;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Integer> backgroundPositions;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> borderColors;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Integer> borderPositions;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> textColors;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Integer> textPositions;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String iconUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSingleLine;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    public BarrageConfig(@NotNull List<String> backgroundColors, @NotNull List<Integer> backgroundPositions, @NotNull List<String> borderColors, @NotNull List<Integer> borderPositions, @NotNull List<String> textColors, @NotNull List<Integer> textPositions, @Nullable String str, boolean z16, @NotNull String text) {
        Intrinsics.checkNotNullParameter(backgroundColors, "backgroundColors");
        Intrinsics.checkNotNullParameter(backgroundPositions, "backgroundPositions");
        Intrinsics.checkNotNullParameter(borderColors, "borderColors");
        Intrinsics.checkNotNullParameter(borderPositions, "borderPositions");
        Intrinsics.checkNotNullParameter(textColors, "textColors");
        Intrinsics.checkNotNullParameter(textPositions, "textPositions");
        Intrinsics.checkNotNullParameter(text, "text");
        this.backgroundColors = backgroundColors;
        this.backgroundPositions = backgroundPositions;
        this.borderColors = borderColors;
        this.borderPositions = borderPositions;
        this.textColors = textColors;
        this.textPositions = textPositions;
        this.iconUrl = str;
        this.isSingleLine = z16;
        this.text = text;
    }

    @NotNull
    public final List<String> a() {
        return this.backgroundColors;
    }

    @NotNull
    public final List<String> b() {
        return this.borderColors;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final List<String> d() {
        return this.textColors;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSingleLine() {
        return this.isSingleLine;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BarrageConfig)) {
            return false;
        }
        BarrageConfig barrageConfig = (BarrageConfig) other;
        if (Intrinsics.areEqual(this.backgroundColors, barrageConfig.backgroundColors) && Intrinsics.areEqual(this.backgroundPositions, barrageConfig.backgroundPositions) && Intrinsics.areEqual(this.borderColors, barrageConfig.borderColors) && Intrinsics.areEqual(this.borderPositions, barrageConfig.borderPositions) && Intrinsics.areEqual(this.textColors, barrageConfig.textColors) && Intrinsics.areEqual(this.textPositions, barrageConfig.textPositions) && Intrinsics.areEqual(this.iconUrl, barrageConfig.iconUrl) && this.isSingleLine == barrageConfig.isSingleLine && Intrinsics.areEqual(this.text, barrageConfig.text)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((this.backgroundColors.hashCode() * 31) + this.backgroundPositions.hashCode()) * 31) + this.borderColors.hashCode()) * 31) + this.borderPositions.hashCode()) * 31) + this.textColors.hashCode()) * 31) + this.textPositions.hashCode()) * 31;
        String str = this.iconUrl;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i3 = (hashCode2 + hashCode) * 31;
        boolean z16 = this.isSingleLine;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((i3 + i16) * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        return "BarrageConfig(backgroundColors=" + this.backgroundColors + ", backgroundPositions=" + this.backgroundPositions + ", borderColors=" + this.borderColors + ", borderPositions=" + this.borderPositions + ", textColors=" + this.textColors + ", textPositions=" + this.textPositions + ", iconUrl=" + this.iconUrl + ", isSingleLine=" + this.isSingleLine + ", text=" + this.text + ")";
    }
}
