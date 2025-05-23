package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\r\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "assetPath", "b", "I", "c", "()I", "type", "", "J", "()J", "sourceTimeDurationUs", "<init>", "(Ljava/lang/String;IJ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.clipping.thumbnail.i, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ThumbAssetModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String assetPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long sourceTimeDurationUs;

    public ThumbAssetModel(@NotNull String assetPath, int i3, long j3) {
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        this.assetPath = assetPath;
        this.type = i3;
        this.sourceTimeDurationUs = j3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAssetPath() {
        return this.assetPath;
    }

    /* renamed from: b, reason: from getter */
    public final long getSourceTimeDurationUs() {
        return this.sourceTimeDurationUs;
    }

    /* renamed from: c, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThumbAssetModel)) {
            return false;
        }
        ThumbAssetModel thumbAssetModel = (ThumbAssetModel) other;
        if (Intrinsics.areEqual(this.assetPath, thumbAssetModel.assetPath) && this.type == thumbAssetModel.type && this.sourceTimeDurationUs == thumbAssetModel.sourceTimeDurationUs) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.assetPath.hashCode() * 31) + this.type) * 31) + androidx.fragment.app.a.a(this.sourceTimeDurationUs);
    }

    @NotNull
    public String toString() {
        return "ThumbAssetModel(assetPath=" + this.assetPath + ", type=" + this.type + ", sourceTimeDurationUs=" + this.sourceTimeDurationUs + ")";
    }
}
