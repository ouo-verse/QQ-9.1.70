package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B+\u0012$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ%\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\u00c6\u0003J/\u0010\r\u001a\u00020\u00002$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\u00c6\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0007H\u00d6\u0001J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000fH\u0016R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/LiteBanner;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "extInfo", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "getExtInfo", "()Ljava/util/HashMap;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class LiteBanner implements Parcelable {

    @NotNull
    private static final String TAG = "LiteBanner";

    @NotNull
    private final HashMap<String, String> extInfo;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<LiteBanner> CREATOR = new Parcelable.Creator<LiteBanner>() { // from class: com.tencent.mobileqq.winkpublish.model.params.LiteBanner$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public LiteBanner createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LiteBanner(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public LiteBanner[] newArray(int size) {
            return new LiteBanner[size];
        }
    };

    public LiteBanner() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiteBanner copy$default(LiteBanner liteBanner, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            hashMap = liteBanner.extInfo;
        }
        return liteBanner.copy(hashMap);
    }

    @NotNull
    public final HashMap<String, String> component1() {
        return this.extInfo;
    }

    @NotNull
    public final LiteBanner copy(@NotNull HashMap<String, String> extInfo) {
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        return new LiteBanner(extInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof LiteBanner) && Intrinsics.areEqual(this.extInfo, ((LiteBanner) other).extInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final HashMap<String, String> getExtInfo() {
        return this.extInfo;
    }

    public int hashCode() {
        return this.extInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiteBanner(extInfo=" + this.extInfo + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeSerializable(this.extInfo);
    }

    public LiteBanner(@NotNull HashMap<String, String> extInfo) {
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        this.extInfo = extInfo;
    }

    public /* synthetic */ LiteBanner(HashMap hashMap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((HashMap<String, String>) ((i3 & 1) != 0 ? new HashMap() : hashMap));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LiteBanner(@NotNull Parcel parcel) {
        this((HashMap<String, String>) r2);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Serializable readSerializable = parcel.readSerializable();
        Intrinsics.checkNotNull(readSerializable, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    }
}
