package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareImageData;", "", "imagePath", "", "(Ljava/lang/String;)V", "getImagePath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class SquareImageData {

    @NotNull
    private final String imagePath;

    public SquareImageData(@NotNull String imagePath) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        this.imagePath = imagePath;
    }

    public static /* synthetic */ SquareImageData copy$default(SquareImageData squareImageData, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = squareImageData.imagePath;
        }
        return squareImageData.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getImagePath() {
        return this.imagePath;
    }

    @NotNull
    public final SquareImageData copy(@NotNull String imagePath) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        return new SquareImageData(imagePath);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof SquareImageData) || !Intrinsics.areEqual(this.imagePath, ((SquareImageData) other).imagePath)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @NotNull
    public final String getImagePath() {
        return this.imagePath;
    }

    public int hashCode() {
        String str = this.imagePath;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "SquareImageData(imagePath=" + this.imagePath + ")";
    }
}
