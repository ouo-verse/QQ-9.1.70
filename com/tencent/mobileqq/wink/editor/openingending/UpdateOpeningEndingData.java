package com.tencent.mobileqq.wink.editor.openingending;

import com.tencent.videocut.model.MediaClip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isFromClipping", "c", "isOpeningClip", "Lcom/tencent/videocut/model/MediaClip;", "Lcom/tencent/videocut/model/MediaClip;", "()Lcom/tencent/videocut/model/MediaClip;", "mediaClip", "<init>", "(ZZLcom/tencent/videocut/model/MediaClip;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.openingending.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class UpdateOpeningEndingData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isFromClipping;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isOpeningClip;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final MediaClip mediaClip;

    public UpdateOpeningEndingData(boolean z16, boolean z17, @Nullable MediaClip mediaClip) {
        this.isFromClipping = z16;
        this.isOpeningClip = z17;
        this.mediaClip = mediaClip;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final MediaClip getMediaClip() {
        return this.mediaClip;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsFromClipping() {
        return this.isFromClipping;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsOpeningClip() {
        return this.isOpeningClip;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateOpeningEndingData)) {
            return false;
        }
        UpdateOpeningEndingData updateOpeningEndingData = (UpdateOpeningEndingData) other;
        if (this.isFromClipping == updateOpeningEndingData.isFromClipping && this.isOpeningClip == updateOpeningEndingData.isOpeningClip && Intrinsics.areEqual(this.mediaClip, updateOpeningEndingData.mediaClip)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.isFromClipping;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.isOpeningClip;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i17 = (i16 + i3) * 31;
        MediaClip mediaClip = this.mediaClip;
        if (mediaClip == null) {
            hashCode = 0;
        } else {
            hashCode = mediaClip.hashCode();
        }
        return i17 + hashCode;
    }

    @NotNull
    public String toString() {
        return "UpdateOpeningEndingData(isFromClipping=" + this.isFromClipping + ", isOpeningClip=" + this.isOpeningClip + ", mediaClip=" + this.mediaClip + ")";
    }
}
