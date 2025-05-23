package cooperation.qwallet.open.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0017\u0010\u001f\"\u0004\b \u0010!R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!\u00a8\u0006)"}, d2 = {"Lcooperation/qwallet/open/data/PayInfoBase;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "I", "e", "()I", "payType", "b", "payFrom", "f", "c", "payPlatform", h.F, "a", "payAppType", "i", "Ljava/lang/String;", "()Ljava/lang/String;", "setQVersion", "(Ljava/lang/String;)V", "qVersion", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "j", "uin", "<init>", "(IIIILjava/lang/String;Ljava/lang/String;)V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final /* data */ class PayInfoBase implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PayInfoBase> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int payType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int payFrom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int payPlatform;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int payAppType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String qVersion;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String uin;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class a implements Parcelable.Creator<PayInfoBase> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PayInfoBase createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PayInfoBase(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PayInfoBase[] newArray(int i3) {
            return new PayInfoBase[i3];
        }
    }

    public PayInfoBase(int i3, int i16, int i17, int i18, @Nullable String str, @Nullable String str2) {
        this.payType = i3;
        this.payFrom = i16;
        this.payPlatform = i17;
        this.payAppType = i18;
        this.qVersion = str;
        this.uin = str2;
    }

    /* renamed from: a, reason: from getter */
    public final int getPayAppType() {
        return this.payAppType;
    }

    /* renamed from: b, reason: from getter */
    public final int getPayFrom() {
        return this.payFrom;
    }

    /* renamed from: c, reason: from getter */
    public final int getPayPlatform() {
        return this.payPlatform;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getPayType() {
        return this.payType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayInfoBase)) {
            return false;
        }
        PayInfoBase payInfoBase = (PayInfoBase) other;
        if (this.payType == payInfoBase.payType && this.payFrom == payInfoBase.payFrom && this.payPlatform == payInfoBase.payPlatform && this.payAppType == payInfoBase.payAppType && Intrinsics.areEqual(this.qVersion, payInfoBase.qVersion) && Intrinsics.areEqual(this.uin, payInfoBase.uin)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getQVersion() {
        return this.qVersion;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        int hashCode;
        int i3 = ((((((this.payType * 31) + this.payFrom) * 31) + this.payPlatform) * 31) + this.payAppType) * 31;
        String str = this.qVersion;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String str2 = this.uin;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    public final void j(@Nullable String str) {
        this.uin = str;
    }

    @NotNull
    public String toString() {
        return "PayInfoBase(payType=" + this.payType + ", payFrom=" + this.payFrom + ", payPlatform=" + this.payPlatform + ", payAppType=" + this.payAppType + ", qVersion=" + this.qVersion + ", uin=" + this.uin + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.payType);
        parcel.writeInt(this.payFrom);
        parcel.writeInt(this.payPlatform);
        parcel.writeInt(this.payAppType);
        parcel.writeString(this.qVersion);
        parcel.writeString(this.uin);
    }

    public /* synthetic */ PayInfoBase(int i3, int i16, int i17, int i18, String str, String str2, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, i17, (i19 & 8) != 0 ? 0 : i18, (i19 & 16) != 0 ? null : str, (i19 & 32) != 0 ? null : str2);
    }
}
