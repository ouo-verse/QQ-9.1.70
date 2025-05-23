package com.tencent.mobileqq.wink.editor.smartclip.algorithm;

import com.tencent.mobileqq.wink.editor.smartclip.algorithm.MusicTimePoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0015\u0012\b\b\u0002\u0010!\u001a\u00020\u0015\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0010\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010 \u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\t\u0010\u0018R\u0017\u0010!\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001a\u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "f", "()Z", "useInternalRhythm", "", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint$MusicTimePointType;", "b", "Ljava/util/List;", "e", "()Ljava/util/List;", "pointTypes", "", "c", "J", "()J", "minFreezePointInterval", "d", "I", "()I", "imageCropSpace", "g", "videoCropSpace", "headProtectDuration", "minTotalDuration", "<init>", "(ZLjava/util/List;JIIJJ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.smartclip.algorithm.g, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class TemplateFixedClipConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean useInternalRhythm;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<MusicTimePoint.MusicTimePointType> pointTypes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long minFreezePointInterval;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int imageCropSpace;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int videoCropSpace;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long headProtectDuration;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final long minTotalDuration;

    public TemplateFixedClipConfig() {
        this(false, null, 0L, 0, 0, 0L, 0L, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getHeadProtectDuration() {
        return this.headProtectDuration;
    }

    /* renamed from: b, reason: from getter */
    public final int getImageCropSpace() {
        return this.imageCropSpace;
    }

    /* renamed from: c, reason: from getter */
    public final long getMinFreezePointInterval() {
        return this.minFreezePointInterval;
    }

    /* renamed from: d, reason: from getter */
    public final long getMinTotalDuration() {
        return this.minTotalDuration;
    }

    @NotNull
    public final List<MusicTimePoint.MusicTimePointType> e() {
        return this.pointTypes;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemplateFixedClipConfig)) {
            return false;
        }
        TemplateFixedClipConfig templateFixedClipConfig = (TemplateFixedClipConfig) other;
        if (this.useInternalRhythm == templateFixedClipConfig.useInternalRhythm && Intrinsics.areEqual(this.pointTypes, templateFixedClipConfig.pointTypes) && this.minFreezePointInterval == templateFixedClipConfig.minFreezePointInterval && this.imageCropSpace == templateFixedClipConfig.imageCropSpace && this.videoCropSpace == templateFixedClipConfig.videoCropSpace && this.headProtectDuration == templateFixedClipConfig.headProtectDuration && this.minTotalDuration == templateFixedClipConfig.minTotalDuration) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getUseInternalRhythm() {
        return this.useInternalRhythm;
    }

    /* renamed from: g, reason: from getter */
    public final int getVideoCropSpace() {
        return this.videoCropSpace;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean z16 = this.useInternalRhythm;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((((((r06 * 31) + this.pointTypes.hashCode()) * 31) + androidx.fragment.app.a.a(this.minFreezePointInterval)) * 31) + this.imageCropSpace) * 31) + this.videoCropSpace) * 31) + androidx.fragment.app.a.a(this.headProtectDuration)) * 31) + androidx.fragment.app.a.a(this.minTotalDuration);
    }

    @NotNull
    public String toString() {
        return "TemplateFixedClipConfig(useInternalRhythm=" + this.useInternalRhythm + ", pointTypes=" + this.pointTypes + ", minFreezePointInterval=" + this.minFreezePointInterval + ", imageCropSpace=" + this.imageCropSpace + ", videoCropSpace=" + this.videoCropSpace + ", headProtectDuration=" + this.headProtectDuration + ", minTotalDuration=" + this.minTotalDuration + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TemplateFixedClipConfig(boolean z16, @NotNull List<? extends MusicTimePoint.MusicTimePointType> pointTypes, long j3, int i3, int i16, long j16, long j17) {
        Intrinsics.checkNotNullParameter(pointTypes, "pointTypes");
        this.useInternalRhythm = z16;
        this.pointTypes = pointTypes;
        this.minFreezePointInterval = j3;
        this.imageCropSpace = i3;
        this.videoCropSpace = i16;
        this.headProtectDuration = j16;
        this.minTotalDuration = j17;
    }

    public /* synthetic */ TemplateFixedClipConfig(boolean z16, List list, long j3, int i3, int i16, long j16, long j17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i17 & 4) != 0 ? 0L : j3, (i17 & 8) != 0 ? 0 : i3, (i17 & 16) == 0 ? i16 : 0, (i17 & 32) != 0 ? 0L : j16, (i17 & 64) == 0 ? j17 : 0L);
    }
}
