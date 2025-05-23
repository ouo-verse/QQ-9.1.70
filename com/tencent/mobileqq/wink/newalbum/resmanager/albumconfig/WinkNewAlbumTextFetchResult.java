package com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u00a2\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/resmanager/albumconfig/WinkNewAlbumTextFetchResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "clipMemoryInfoJSONPath", "e", "b", "clipTextFeatureJSONPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class WinkNewAlbumTextFetchResult implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String clipMemoryInfoJSONPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String clipTextFeatureJSONPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/resmanager/albumconfig/WinkNewAlbumTextFetchResult$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/albumconfig/WinkNewAlbumTextFetchResult;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/newalbum/resmanager/albumconfig/WinkNewAlbumTextFetchResult;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig.WinkNewAlbumTextFetchResult$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<WinkNewAlbumTextFetchResult> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkNewAlbumTextFetchResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WinkNewAlbumTextFetchResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkNewAlbumTextFetchResult[] newArray(int size) {
            return new WinkNewAlbumTextFetchResult[size];
        }

        Companion() {
        }
    }

    public WinkNewAlbumTextFetchResult(@NotNull String clipMemoryInfoJSONPath, @NotNull String clipTextFeatureJSONPath) {
        Intrinsics.checkNotNullParameter(clipMemoryInfoJSONPath, "clipMemoryInfoJSONPath");
        Intrinsics.checkNotNullParameter(clipTextFeatureJSONPath, "clipTextFeatureJSONPath");
        this.clipMemoryInfoJSONPath = clipMemoryInfoJSONPath;
        this.clipTextFeatureJSONPath = clipTextFeatureJSONPath;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getClipMemoryInfoJSONPath() {
        return this.clipMemoryInfoJSONPath;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getClipTextFeatureJSONPath() {
        return this.clipTextFeatureJSONPath;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkNewAlbumTextFetchResult)) {
            return false;
        }
        WinkNewAlbumTextFetchResult winkNewAlbumTextFetchResult = (WinkNewAlbumTextFetchResult) other;
        if (Intrinsics.areEqual(this.clipMemoryInfoJSONPath, winkNewAlbumTextFetchResult.clipMemoryInfoJSONPath) && Intrinsics.areEqual(this.clipTextFeatureJSONPath, winkNewAlbumTextFetchResult.clipTextFeatureJSONPath)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.clipMemoryInfoJSONPath.hashCode() * 31) + this.clipTextFeatureJSONPath.hashCode();
    }

    @NotNull
    public String toString() {
        return "WinkNewAlbumTextFetchResult(clipMemoryInfoJSONPath=" + this.clipMemoryInfoJSONPath + ", clipTextFeatureJSONPath=" + this.clipTextFeatureJSONPath + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.clipMemoryInfoJSONPath);
        parcel.writeString(this.clipTextFeatureJSONPath);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WinkNewAlbumTextFetchResult(@NotNull Parcel parcel) {
        this(r0, r3 != null ? r3 : "");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        readString = readString == null ? "" : readString;
        String readString2 = parcel.readString();
    }
}
