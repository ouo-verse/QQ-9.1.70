package com.tencent.mobileqq.qqecommerce.biz.live.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b(\b\u0086\b\u0018\u0000 52\u00020\u0001:\u0001!BW\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u000e\u0012\b\b\u0002\u0010.\u001a\u00020\u000e\u0012\b\b\u0002\u00101\u001a\u00020\u000e\u00a2\u0006\u0004\b2\u00103B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b2\u00104J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\"\u0010\u0012\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\"\u0010*\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0011\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\"\u0010.\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0011\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R\"\u00101\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b0\u0010\u0015\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/live/api/QQECLiveEntryGoodsData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Z", "isXworldAuthenticated", "()Z", "setXworldAuthenticated", "(Z)V", "e", "setEcomAuthenticated", "isEcomAuthenticated", "f", "I", "b", "()I", "l", "(I)V", "liveGoodsNumber", h.F, "a", "setLiveGokGoodsNumber", "liveGokGoodsNumber", "i", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "liveShopGoodsNumber", "g", "setGokWhiteListUser", "isGokWhiteListUser", BdhLogUtil.LogTag.Tag_Conn, "j", "setQShopWhiteListUser", "isQShopWhiteListUser", "D", "k", "isGokSelect", "<init>", "(ZZIIIZZZ)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class QQECLiveEntryGoodsData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private boolean isQShopWhiteListUser;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private boolean isGokSelect;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isXworldAuthenticated;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isEcomAuthenticated;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int liveGoodsNumber;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int liveGokGoodsNumber;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int liveShopGoodsNumber;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isGokWhiteListUser;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/live/api/QQECLiveEntryGoodsData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqecommerce/biz/live/api/QQECLiveEntryGoodsData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qqecommerce/biz/live/api/QQECLiveEntryGoodsData;", "<init>", "()V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.live.api.QQECLiveEntryGoodsData$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion implements Parcelable.Creator<QQECLiveEntryGoodsData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQECLiveEntryGoodsData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QQECLiveEntryGoodsData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQECLiveEntryGoodsData[] newArray(int size) {
            return new QQECLiveEntryGoodsData[size];
        }

        Companion() {
        }
    }

    public QQECLiveEntryGoodsData() {
        this(false, false, 0, 0, 0, false, false, false, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getLiveGokGoodsNumber() {
        return this.liveGokGoodsNumber;
    }

    /* renamed from: b, reason: from getter */
    public final int getLiveGoodsNumber() {
        return this.liveGoodsNumber;
    }

    /* renamed from: c, reason: from getter */
    public final int getLiveShopGoodsNumber() {
        return this.liveShopGoodsNumber;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsEcomAuthenticated() {
        return this.isEcomAuthenticated;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQECLiveEntryGoodsData)) {
            return false;
        }
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = (QQECLiveEntryGoodsData) other;
        if (this.isXworldAuthenticated == qQECLiveEntryGoodsData.isXworldAuthenticated && this.isEcomAuthenticated == qQECLiveEntryGoodsData.isEcomAuthenticated && this.liveGoodsNumber == qQECLiveEntryGoodsData.liveGoodsNumber && this.liveGokGoodsNumber == qQECLiveEntryGoodsData.liveGokGoodsNumber && this.liveShopGoodsNumber == qQECLiveEntryGoodsData.liveShopGoodsNumber && this.isGokWhiteListUser == qQECLiveEntryGoodsData.isGokWhiteListUser && this.isQShopWhiteListUser == qQECLiveEntryGoodsData.isQShopWhiteListUser && this.isGokSelect == qQECLiveEntryGoodsData.isGokSelect) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsGokSelect() {
        return this.isGokSelect;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsGokWhiteListUser() {
        return this.isGokWhiteListUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.isXworldAuthenticated;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isEcomAuthenticated;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (((((((i16 + i17) * 31) + this.liveGoodsNumber) * 31) + this.liveGokGoodsNumber) * 31) + this.liveShopGoodsNumber) * 31;
        ?? r27 = this.isGokWhiteListUser;
        int i19 = r27;
        if (r27 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        ?? r28 = this.isQShopWhiteListUser;
        int i27 = r28;
        if (r28 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        boolean z17 = this.isGokSelect;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i28 + i3;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsQShopWhiteListUser() {
        return this.isQShopWhiteListUser;
    }

    public final void k(boolean z16) {
        this.isGokSelect = z16;
    }

    public final void l(int i3) {
        this.liveGoodsNumber = i3;
    }

    public final void m(int i3) {
        this.liveShopGoodsNumber = i3;
    }

    @NotNull
    public String toString() {
        return "QQECLiveEntryGoodsData(isXworldAuthenticated=" + this.isXworldAuthenticated + ", isEcomAuthenticated=" + this.isEcomAuthenticated + ", liveGoodsNumber=" + this.liveGoodsNumber + ", liveGokGoodsNumber=" + this.liveGokGoodsNumber + ", liveShopGoodsNumber=" + this.liveShopGoodsNumber + ", isGokWhiteListUser=" + this.isGokWhiteListUser + ", isQShopWhiteListUser=" + this.isQShopWhiteListUser + ", isGokSelect=" + this.isGokSelect + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.isXworldAuthenticated ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isEcomAuthenticated ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.liveGoodsNumber);
        parcel.writeInt(this.liveGokGoodsNumber);
        parcel.writeInt(this.liveShopGoodsNumber);
        parcel.writeByte(this.isGokWhiteListUser ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isQShopWhiteListUser ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isGokSelect ? (byte) 1 : (byte) 0);
    }

    public QQECLiveEntryGoodsData(boolean z16, boolean z17, int i3, int i16, int i17, boolean z18, boolean z19, boolean z26) {
        this.isXworldAuthenticated = z16;
        this.isEcomAuthenticated = z17;
        this.liveGoodsNumber = i3;
        this.liveGokGoodsNumber = i16;
        this.liveShopGoodsNumber = i17;
        this.isGokWhiteListUser = z18;
        this.isQShopWhiteListUser = z19;
        this.isGokSelect = z26;
    }

    public /* synthetic */ QQECLiveEntryGoodsData(boolean z16, boolean z17, int i3, int i16, int i17, boolean z18, boolean z19, boolean z26, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? false : z16, (i18 & 2) != 0 ? false : z17, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) != 0 ? 0 : i17, (i18 & 32) != 0 ? false : z18, (i18 & 64) != 0 ? false : z19, (i18 & 128) == 0 ? z26 : false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQECLiveEntryGoodsData(@NotNull Parcel parcel) {
        this(parcel.readByte() != 0, parcel.readByte() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readByte() != 0, parcel.readByte() != 0, parcel.readByte() != 0);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
