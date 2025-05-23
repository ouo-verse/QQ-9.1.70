package com.tencent.richframework.gallery.delegate.outer;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/richframework/gallery/delegate/outer/ErrorUIConfig;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/drawable/Drawable;", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "getErrorDrawable", "()Landroid/graphics/drawable/Drawable;", "errorTip", "Ljava/lang/String;", "getErrorTip", "()Ljava/lang/String;", "<init>", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class ErrorUIConfig {

    @NotNull
    private final Drawable errorDrawable;

    @NotNull
    private final String errorTip;

    public ErrorUIConfig(@NotNull Drawable errorDrawable, @NotNull String errorTip) {
        Intrinsics.checkNotNullParameter(errorDrawable, "errorDrawable");
        Intrinsics.checkNotNullParameter(errorTip, "errorTip");
        this.errorDrawable = errorDrawable;
        this.errorTip = errorTip;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ErrorUIConfig) {
                ErrorUIConfig errorUIConfig = (ErrorUIConfig) other;
                if (!Intrinsics.areEqual(this.errorDrawable, errorUIConfig.errorDrawable) || !Intrinsics.areEqual(this.errorTip, errorUIConfig.errorTip)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Drawable getErrorDrawable() {
        return this.errorDrawable;
    }

    @NotNull
    public final String getErrorTip() {
        return this.errorTip;
    }

    public int hashCode() {
        int i3;
        Drawable drawable = this.errorDrawable;
        int i16 = 0;
        if (drawable != null) {
            i3 = drawable.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str = this.errorTip;
        if (str != null) {
            i16 = str.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "ErrorUIConfig(errorDrawable=" + this.errorDrawable + ", errorTip=" + this.errorTip + ")";
    }
}
