package com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail;

import androidx.annotation.RequiresApi;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0017J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/f;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "assetPath", "", "b", "J", "()J", "time", "<init>", "(Ljava/lang/String;J)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.f, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class LRUKey {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String assetPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long time;

    public LRUKey(@NotNull String assetPath, long j3) {
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        this.assetPath = assetPath;
        this.time = j3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAssetPath() {
        return this.assetPath;
    }

    /* renamed from: b, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(LRUKey.class, other.getClass())) {
            return false;
        }
        LRUKey lRUKey = (LRUKey) other;
        if (this.time == lRUKey.time && Intrinsics.areEqual(this.assetPath, lRUKey.assetPath)) {
            return true;
        }
        return false;
    }

    @RequiresApi(19)
    public int hashCode() {
        return Objects.hash(this.assetPath, Long.valueOf(this.time));
    }

    @NotNull
    public String toString() {
        return "LRUKey(assetPath=" + this.assetPath + ", time=" + this.time + ")";
    }
}
