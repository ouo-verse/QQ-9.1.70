package com.tencent.mobileqq.wink.newalbum.collector;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s83.WinkNewAlbumConfigInfo;
import s83.WinkNewAlbumFeatureConfigInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u000e\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "storyID", "b", "I", "c", "()I", "priorityIndex", "Ls83/a;", "Ls83/a;", "()Ls83/a;", "albumConfigInfo", "Ls83/b;", "Ls83/b;", "()Ls83/b;", "featureConfigInfo", "<init>", "(Ljava/lang/String;ILs83/a;Ls83/b;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.newalbum.collector.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkNewAlbumCollectorConfigInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String storyID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int priorityIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final WinkNewAlbumConfigInfo albumConfigInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final WinkNewAlbumFeatureConfigInfo featureConfigInfo;

    public WinkNewAlbumCollectorConfigInfo(@NotNull String storyID, int i3, @NotNull WinkNewAlbumConfigInfo albumConfigInfo, @NotNull WinkNewAlbumFeatureConfigInfo featureConfigInfo) {
        Intrinsics.checkNotNullParameter(storyID, "storyID");
        Intrinsics.checkNotNullParameter(albumConfigInfo, "albumConfigInfo");
        Intrinsics.checkNotNullParameter(featureConfigInfo, "featureConfigInfo");
        this.storyID = storyID;
        this.priorityIndex = i3;
        this.albumConfigInfo = albumConfigInfo;
        this.featureConfigInfo = featureConfigInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final WinkNewAlbumConfigInfo getAlbumConfigInfo() {
        return this.albumConfigInfo;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final WinkNewAlbumFeatureConfigInfo getFeatureConfigInfo() {
        return this.featureConfigInfo;
    }

    /* renamed from: c, reason: from getter */
    public final int getPriorityIndex() {
        return this.priorityIndex;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getStoryID() {
        return this.storyID;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkNewAlbumCollectorConfigInfo)) {
            return false;
        }
        WinkNewAlbumCollectorConfigInfo winkNewAlbumCollectorConfigInfo = (WinkNewAlbumCollectorConfigInfo) other;
        if (Intrinsics.areEqual(this.storyID, winkNewAlbumCollectorConfigInfo.storyID) && this.priorityIndex == winkNewAlbumCollectorConfigInfo.priorityIndex && Intrinsics.areEqual(this.albumConfigInfo, winkNewAlbumCollectorConfigInfo.albumConfigInfo) && Intrinsics.areEqual(this.featureConfigInfo, winkNewAlbumCollectorConfigInfo.featureConfigInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.storyID.hashCode() * 31) + this.priorityIndex) * 31) + this.albumConfigInfo.hashCode()) * 31) + this.featureConfigInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "WinkNewAlbumCollectorConfigInfo(storyID=" + this.storyID + ", priorityIndex=" + this.priorityIndex + ", albumConfigInfo=" + this.albumConfigInfo + ", featureConfigInfo=" + this.featureConfigInfo + ")";
    }
}
