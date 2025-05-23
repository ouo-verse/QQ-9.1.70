package com.tencent.filament.zplan.bgplane;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014JN\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/tencent/filament/zplan/bgplane/Backdrop;", "", "gltfPath", "", "imagePath", "isDark", "", "hideGroups", "", "scale", "", "offsetY", "(Ljava/lang/String;Ljava/lang/String;IZLjava/lang/Float;Ljava/lang/Float;)V", "getGltfPath", "()Ljava/lang/String;", "getHideGroups", "()Z", "getImagePath", "()I", "getOffsetY", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getScale", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;IZLjava/lang/Float;Ljava/lang/Float;)Lcom/tencent/filament/zplan/bgplane/Backdrop;", "equals", "other", "hashCode", "toString", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class Backdrop {

    @NotNull
    private final String gltfPath;
    private final boolean hideGroups;

    @NotNull
    private final String imagePath;
    private final int isDark;

    @Nullable
    private final Float offsetY;

    @Nullable
    private final Float scale;

    public Backdrop(@NotNull String gltfPath, @NotNull String imagePath, int i3, boolean z16, @Nullable Float f16, @Nullable Float f17) {
        Intrinsics.checkNotNullParameter(gltfPath, "gltfPath");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        this.gltfPath = gltfPath;
        this.imagePath = imagePath;
        this.isDark = i3;
        this.hideGroups = z16;
        this.scale = f16;
        this.offsetY = f17;
    }

    public static /* synthetic */ Backdrop copy$default(Backdrop backdrop, String str, String str2, int i3, boolean z16, Float f16, Float f17, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = backdrop.gltfPath;
        }
        if ((i16 & 2) != 0) {
            str2 = backdrop.imagePath;
        }
        String str3 = str2;
        if ((i16 & 4) != 0) {
            i3 = backdrop.isDark;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            z16 = backdrop.hideGroups;
        }
        boolean z17 = z16;
        if ((i16 & 16) != 0) {
            f16 = backdrop.scale;
        }
        Float f18 = f16;
        if ((i16 & 32) != 0) {
            f17 = backdrop.offsetY;
        }
        return backdrop.copy(str, str3, i17, z17, f18, f17);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGltfPath() {
        return this.gltfPath;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getImagePath() {
        return this.imagePath;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIsDark() {
        return this.isDark;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHideGroups() {
        return this.hideGroups;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Float getScale() {
        return this.scale;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Float getOffsetY() {
        return this.offsetY;
    }

    @NotNull
    public final Backdrop copy(@NotNull String gltfPath, @NotNull String imagePath, int isDark, boolean hideGroups, @Nullable Float scale, @Nullable Float offsetY) {
        Intrinsics.checkNotNullParameter(gltfPath, "gltfPath");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        return new Backdrop(gltfPath, imagePath, isDark, hideGroups, scale, offsetY);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Backdrop) {
                Backdrop backdrop = (Backdrop) other;
                if (!Intrinsics.areEqual(this.gltfPath, backdrop.gltfPath) || !Intrinsics.areEqual(this.imagePath, backdrop.imagePath) || this.isDark != backdrop.isDark || this.hideGroups != backdrop.hideGroups || !Intrinsics.areEqual((Object) this.scale, (Object) backdrop.scale) || !Intrinsics.areEqual((Object) this.offsetY, (Object) backdrop.offsetY)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getGltfPath() {
        return this.gltfPath;
    }

    public final boolean getHideGroups() {
        return this.hideGroups;
    }

    @NotNull
    public final String getImagePath() {
        return this.imagePath;
    }

    @Nullable
    public final Float getOffsetY() {
        return this.offsetY;
    }

    @Nullable
    public final Float getScale() {
        return this.scale;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.gltfPath;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.imagePath;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (((i19 + i16) * 31) + this.isDark) * 31;
        boolean z16 = this.hideGroups;
        int i27 = z16;
        if (z16 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        Float f16 = this.scale;
        if (f16 != null) {
            i17 = f16.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        Float f17 = this.offsetY;
        if (f17 != null) {
            i18 = f17.hashCode();
        }
        return i29 + i18;
    }

    public final int isDark() {
        return this.isDark;
    }

    @NotNull
    public String toString() {
        return "Backdrop(gltfPath=" + this.gltfPath + ", imagePath=" + this.imagePath + ", isDark=" + this.isDark + ", hideGroups=" + this.hideGroups + ", scale=" + this.scale + ", offsetY=" + this.offsetY + ")";
    }

    public /* synthetic */ Backdrop(String str, String str2, int i3, boolean z16, Float f16, Float f17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, z16, (i16 & 16) != 0 ? null : f16, (i16 & 32) != 0 ? null : f17);
    }
}
