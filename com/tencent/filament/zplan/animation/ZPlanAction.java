package com.tencent.filament.zplan.animation;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.filament.zplan.avatar.AvatarCheckResult;
import com.tencent.filament.zplan.avatar.FAssetChecker;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.verify.ResourceCheckAlgorithmSelect;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010 \u001a\u00020\b\u0012\u0006\u0010\"\u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020\b\u0012\u0006\u0010(\u001a\u00020\b\u00a2\u0006\u0004\b)\u0010*J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\nH\u00d6\u0001J\u0019\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\nH\u00d6\u0001R\"\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010 \u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\u0017\u0010\"\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001e\u001a\u0004\b!\u0010\u001fR\u0017\u0010%\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010\u001fR\u0017\u0010(\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010\u001f\u00a8\u0006+"}, d2 = {"Lcom/tencent/filament/zplan/animation/ZPlanAction;", "Landroid/os/Parcelable;", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckAlgorithmSelect;", "algorithmSelect", "Lcom/tencent/filament/zplan/avatar/AvatarCheckResult;", "a", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Z", "c", "()Z", "f", "(Z)V", "downloadFromNet", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "faceAnimationGltfPath", "b", "bodyAnimationGltfPath", h.F, "getFaceAnimationUrl", "faceAnimationUrl", "i", "getBodyAnimationUrl", "bodyAnimationUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class ZPlanAction implements Parcelable {
    public static final Parcelable.Creator<ZPlanAction> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean downloadFromNet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String faceAnimationGltfPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String bodyAnimationGltfPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String faceAnimationUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String bodyAnimationUrl;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<ZPlanAction> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ZPlanAction createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new ZPlanAction(in5.readString(), in5.readString(), in5.readString(), in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ZPlanAction[] newArray(int i3) {
            return new ZPlanAction[i3];
        }
    }

    public ZPlanAction(@NotNull String faceAnimationGltfPath, @NotNull String bodyAnimationGltfPath, @NotNull String faceAnimationUrl, @NotNull String bodyAnimationUrl) {
        Intrinsics.checkNotNullParameter(faceAnimationGltfPath, "faceAnimationGltfPath");
        Intrinsics.checkNotNullParameter(bodyAnimationGltfPath, "bodyAnimationGltfPath");
        Intrinsics.checkNotNullParameter(faceAnimationUrl, "faceAnimationUrl");
        Intrinsics.checkNotNullParameter(bodyAnimationUrl, "bodyAnimationUrl");
        this.faceAnimationGltfPath = faceAnimationGltfPath;
        this.bodyAnimationGltfPath = bodyAnimationGltfPath;
        this.faceAnimationUrl = faceAnimationUrl;
        this.bodyAnimationUrl = bodyAnimationUrl;
    }

    @NotNull
    public final AvatarCheckResult a(@NotNull FilamentUrlTemplate urlTemplate, @NotNull ResourceCheckAlgorithmSelect algorithmSelect) {
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        Intrinsics.checkNotNullParameter(algorithmSelect, "algorithmSelect");
        FAssetChecker fAssetChecker = FAssetChecker.f105632b;
        return fAssetChecker.a(this.faceAnimationUrl, urlTemplate, algorithmSelect).c(fAssetChecker.a(this.bodyAnimationUrl, urlTemplate, algorithmSelect));
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getBodyAnimationGltfPath() {
        return this.bodyAnimationGltfPath;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getDownloadFromNet() {
        return this.downloadFromNet;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getFaceAnimationGltfPath() {
        return this.faceAnimationGltfPath;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ZPlanAction) {
                ZPlanAction zPlanAction = (ZPlanAction) other;
                if (!Intrinsics.areEqual(this.faceAnimationGltfPath, zPlanAction.faceAnimationGltfPath) || !Intrinsics.areEqual(this.bodyAnimationGltfPath, zPlanAction.bodyAnimationGltfPath) || !Intrinsics.areEqual(this.faceAnimationUrl, zPlanAction.faceAnimationUrl) || !Intrinsics.areEqual(this.bodyAnimationUrl, zPlanAction.bodyAnimationUrl)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final void f(boolean z16) {
        this.downloadFromNet = z16;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.faceAnimationGltfPath;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.bodyAnimationGltfPath;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str3 = this.faceAnimationUrl;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str4 = this.bodyAnimationUrl;
        if (str4 != null) {
            i18 = str4.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "ZPlanAction(faceAnimationGltfPath=" + this.faceAnimationGltfPath + ", bodyAnimationGltfPath=" + this.bodyAnimationGltfPath + ", faceAnimationUrl=" + this.faceAnimationUrl + ", bodyAnimationUrl=" + this.bodyAnimationUrl + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.faceAnimationGltfPath);
        parcel.writeString(this.bodyAnimationGltfPath);
        parcel.writeString(this.faceAnimationUrl);
        parcel.writeString(this.bodyAnimationUrl);
    }
}
