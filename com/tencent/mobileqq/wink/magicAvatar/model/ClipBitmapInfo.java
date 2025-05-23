package com.tencent.mobileqq.wink.magicAvatar.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/model/ClipBitmapInfo;", "", "isPreview", "", "path", "", "videoFilePath", "(ZLjava/lang/String;Ljava/lang/String;)V", "()Z", "getPath", "()Ljava/lang/String;", "getVideoFilePath", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class ClipBitmapInfo {
    private final boolean isPreview;

    @Nullable
    private final String path;

    @Nullable
    private final String videoFilePath;

    public ClipBitmapInfo(boolean z16, @Nullable String str, @Nullable String str2) {
        this.isPreview = z16;
        this.path = str;
        this.videoFilePath = str2;
    }

    public static /* synthetic */ ClipBitmapInfo copy$default(ClipBitmapInfo clipBitmapInfo, boolean z16, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = clipBitmapInfo.isPreview;
        }
        if ((i3 & 2) != 0) {
            str = clipBitmapInfo.path;
        }
        if ((i3 & 4) != 0) {
            str2 = clipBitmapInfo.videoFilePath;
        }
        return clipBitmapInfo.copy(z16, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsPreview() {
        return this.isPreview;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getVideoFilePath() {
        return this.videoFilePath;
    }

    @NotNull
    public final ClipBitmapInfo copy(boolean isPreview, @Nullable String path, @Nullable String videoFilePath) {
        return new ClipBitmapInfo(isPreview, path, videoFilePath);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClipBitmapInfo)) {
            return false;
        }
        ClipBitmapInfo clipBitmapInfo = (ClipBitmapInfo) other;
        if (this.isPreview == clipBitmapInfo.isPreview && Intrinsics.areEqual(this.path, clipBitmapInfo.path) && Intrinsics.areEqual(this.videoFilePath, clipBitmapInfo.videoFilePath)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final String getVideoFilePath() {
        return this.videoFilePath;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.isPreview;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        String str = this.path;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String str2 = this.videoFilePath;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    public final boolean isPreview() {
        return this.isPreview;
    }

    @NotNull
    public String toString() {
        return "ClipBitmapInfo(isPreview=" + this.isPreview + ", path=" + this.path + ", videoFilePath=" + this.videoFilePath + ")";
    }
}
