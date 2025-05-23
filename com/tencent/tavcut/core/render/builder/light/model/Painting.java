package com.tencent.tavcut.core.render.builder.light.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.enums.BackgroundFillMode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003JH\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006#"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/Painting;", "", "backgroundFillMode", "Lorg/light/lightAssetKit/enums/BackgroundFillMode;", "backgroundColor", "", "renderSize", "Lorg/light/lightAssetKit/components/Size;", "fillScale", "", "pagPath", "(Lorg/light/lightAssetKit/enums/BackgroundFillMode;Ljava/lang/String;Lorg/light/lightAssetKit/components/Size;Ljava/lang/Float;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getBackgroundFillMode", "()Lorg/light/lightAssetKit/enums/BackgroundFillMode;", "getFillScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPagPath", "getRenderSize", "()Lorg/light/lightAssetKit/components/Size;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lorg/light/lightAssetKit/enums/BackgroundFillMode;Ljava/lang/String;Lorg/light/lightAssetKit/components/Size;Ljava/lang/Float;Ljava/lang/String;)Lcom/tencent/tavcut/core/render/builder/light/model/Painting;", "equals", "", "other", "hashCode", "", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class Painting {

    @NotNull
    private final String backgroundColor;

    @Nullable
    private final BackgroundFillMode backgroundFillMode;

    @Nullable
    private final Float fillScale;

    @Nullable
    private final String pagPath;

    @Nullable
    private final Size renderSize;

    public Painting() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ Painting copy$default(Painting painting, BackgroundFillMode backgroundFillMode, String str, Size size, Float f16, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            backgroundFillMode = painting.backgroundFillMode;
        }
        if ((i3 & 2) != 0) {
            str = painting.backgroundColor;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            size = painting.renderSize;
        }
        Size size2 = size;
        if ((i3 & 8) != 0) {
            f16 = painting.fillScale;
        }
        Float f17 = f16;
        if ((i3 & 16) != 0) {
            str2 = painting.pagPath;
        }
        return painting.copy(backgroundFillMode, str3, size2, f17, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final BackgroundFillMode getBackgroundFillMode() {
        return this.backgroundFillMode;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Size getRenderSize() {
        return this.renderSize;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Float getFillScale() {
        return this.fillScale;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getPagPath() {
        return this.pagPath;
    }

    @NotNull
    public final Painting copy(@Nullable BackgroundFillMode backgroundFillMode, @NotNull String backgroundColor, @Nullable Size renderSize, @Nullable Float fillScale, @Nullable String pagPath) {
        Intrinsics.checkParameterIsNotNull(backgroundColor, "backgroundColor");
        return new Painting(backgroundFillMode, backgroundColor, renderSize, fillScale, pagPath);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Painting) {
                Painting painting = (Painting) other;
                if (!Intrinsics.areEqual(this.backgroundFillMode, painting.backgroundFillMode) || !Intrinsics.areEqual(this.backgroundColor, painting.backgroundColor) || !Intrinsics.areEqual(this.renderSize, painting.renderSize) || !Intrinsics.areEqual((Object) this.fillScale, (Object) painting.fillScale) || !Intrinsics.areEqual(this.pagPath, painting.pagPath)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final BackgroundFillMode getBackgroundFillMode() {
        return this.backgroundFillMode;
    }

    @Nullable
    public final Float getFillScale() {
        return this.fillScale;
    }

    @Nullable
    public final String getPagPath() {
        return this.pagPath;
    }

    @Nullable
    public final Size getRenderSize() {
        return this.renderSize;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        BackgroundFillMode backgroundFillMode = this.backgroundFillMode;
        int i19 = 0;
        if (backgroundFillMode != null) {
            i3 = backgroundFillMode.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = i3 * 31;
        String str = this.backgroundColor;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        Size size = this.renderSize;
        if (size != null) {
            i17 = size.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        Float f16 = this.fillScale;
        if (f16 != null) {
            i18 = f16.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        String str2 = this.pagPath;
        if (str2 != null) {
            i19 = str2.hashCode();
        }
        return i29 + i19;
    }

    @NotNull
    public String toString() {
        return "Painting(backgroundFillMode=" + this.backgroundFillMode + ", backgroundColor=" + this.backgroundColor + ", renderSize=" + this.renderSize + ", fillScale=" + this.fillScale + ", pagPath=" + this.pagPath + ")";
    }

    public Painting(@Nullable BackgroundFillMode backgroundFillMode, @NotNull String backgroundColor, @Nullable Size size, @Nullable Float f16, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(backgroundColor, "backgroundColor");
        this.backgroundFillMode = backgroundFillMode;
        this.backgroundColor = backgroundColor;
        this.renderSize = size;
        this.fillScale = f16;
        this.pagPath = str;
    }

    public /* synthetic */ Painting(BackgroundFillMode backgroundFillMode, String str, Size size, Float f16, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : backgroundFillMode, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? null : size, (i3 & 8) == 0 ? f16 : null, (i3 & 16) != 0 ? "" : str2);
    }
}
