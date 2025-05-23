package com.tencent.mobileqq.wink.editor.sticker.sticker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.annotations.Expose;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b%\u0010&B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\tH\u00c6\u0001J\t\u0010\r\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003R\u001a\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0017\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001b\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/RecentStickerData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "component1", "id", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "hasHit", "Z", "getHasHit", "()Z", "setHasHit", "(Z)V", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "setMaterial", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "isFromSearch", "setFromSearch", "<init>", "(Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class RecentStickerData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Expose(deserialize = false, serialize = false)
    private boolean hasHit;

    @Expose
    @NotNull
    private final String id;

    @Expose
    private boolean isFromSearch;

    @Expose(deserialize = false, serialize = false)
    public MetaMaterial material;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/RecentStickerData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/RecentStickerData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/editor/sticker/sticker/RecentStickerData;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.RecentStickerData$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<RecentStickerData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecentStickerData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RecentStickerData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RecentStickerData[] newArray(int size) {
            return new RecentStickerData[size];
        }

        Companion() {
        }
    }

    public RecentStickerData(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
    }

    public static /* synthetic */ RecentStickerData copy$default(RecentStickerData recentStickerData, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = recentStickerData.id;
        }
        return recentStickerData.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final RecentStickerData copy(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return new RecentStickerData(id5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof RecentStickerData) && Intrinsics.areEqual(this.id, ((RecentStickerData) other).id)) {
            return true;
        }
        return false;
    }

    public final boolean getHasHit() {
        return this.hasHit;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final MetaMaterial getMaterial() {
        MetaMaterial metaMaterial = this.material;
        if (metaMaterial != null) {
            return metaMaterial;
        }
        Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.KEY_MATERIAL);
        return null;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    /* renamed from: isFromSearch, reason: from getter */
    public final boolean getIsFromSearch() {
        return this.isFromSearch;
    }

    public final void setFromSearch(boolean z16) {
        this.isFromSearch = z16;
    }

    public final void setHasHit(boolean z16) {
        this.hasHit = z16;
    }

    public final void setMaterial(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<set-?>");
        this.material = metaMaterial;
    }

    @NotNull
    public String toString() {
        return "RecentStickerData(id=" + this.id + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeByte(this.isFromSearch ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RecentStickerData(@NotNull Parcel parcel) {
        this(r0 == null ? "" : r0);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.isFromSearch = parcel.readByte() != 0;
    }
}
