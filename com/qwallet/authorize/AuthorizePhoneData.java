package com.qwallet.authorize;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u0006\u0010&\u001a\u00020\u0004\u0012\u0006\u0010-\u001a\u00020\b\u00a2\u0006\u0004\b.\u0010/J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0017\u0010\u001cR\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001cR\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u001cR\"\u0010-\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/qwallet/authorize/AuthorizePhoneData;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "phoneMask", "c", "phone", "f", "k", "token", h.F, "I", "()I", "source", "i", "g", "sourceTag", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "carrierType", BdhLogUtil.LogTag.Tag_Conn, "j", "state", "D", "Z", "b", "()Z", "setHasSavePhone", "(Z)V", "hasSavePhone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIZ)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final /* data */ class AuthorizePhoneData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AuthorizePhoneData> CREATOR = new a();

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private final int state;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private boolean hasSavePhone;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String phoneMask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String phone;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String token;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int source;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sourceTag;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final int carrierType;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements Parcelable.Creator<AuthorizePhoneData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AuthorizePhoneData createFromParcel(@NotNull Parcel parcel) {
            boolean z16;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            String readString4 = parcel.readString();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            if (parcel.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return new AuthorizePhoneData(readString, readString2, readString3, readInt, readString4, readInt2, readInt3, z16);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AuthorizePhoneData[] newArray(int i3) {
            return new AuthorizePhoneData[i3];
        }
    }

    public AuthorizePhoneData(@NotNull String phoneMask, @NotNull String phone, @NotNull String token, int i3, @NotNull String sourceTag, int i16, int i17, boolean z16) {
        Intrinsics.checkNotNullParameter(phoneMask, "phoneMask");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(sourceTag, "sourceTag");
        this.phoneMask = phoneMask;
        this.phone = phone;
        this.token = token;
        this.source = i3;
        this.sourceTag = sourceTag;
        this.carrierType = i16;
        this.state = i17;
        this.hasSavePhone = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getCarrierType() {
        return this.carrierType;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasSavePhone() {
        return this.hasSavePhone;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPhoneMask() {
        return this.phoneMask;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthorizePhoneData)) {
            return false;
        }
        AuthorizePhoneData authorizePhoneData = (AuthorizePhoneData) other;
        if (Intrinsics.areEqual(this.phoneMask, authorizePhoneData.phoneMask) && Intrinsics.areEqual(this.phone, authorizePhoneData.phone) && Intrinsics.areEqual(this.token, authorizePhoneData.token) && this.source == authorizePhoneData.source && Intrinsics.areEqual(this.sourceTag, authorizePhoneData.sourceTag) && this.carrierType == authorizePhoneData.carrierType && this.state == authorizePhoneData.state && this.hasSavePhone == authorizePhoneData.hasSavePhone) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getSourceTag() {
        return this.sourceTag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((this.phoneMask.hashCode() * 31) + this.phone.hashCode()) * 31) + this.token.hashCode()) * 31) + this.source) * 31) + this.sourceTag.hashCode()) * 31) + this.carrierType) * 31) + this.state) * 31;
        boolean z16 = this.hasSavePhone;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    /* renamed from: j, reason: from getter */
    public final int getState() {
        return this.state;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public String toString() {
        return "AuthorizePhoneData(phoneMask=" + this.phoneMask + ", phone=" + this.phone + ", token=" + this.token + ", source=" + this.source + ", sourceTag=" + this.sourceTag + ", carrierType=" + this.carrierType + ", state=" + this.state + ", hasSavePhone=" + this.hasSavePhone + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.phoneMask);
        parcel.writeString(this.phone);
        parcel.writeString(this.token);
        parcel.writeInt(this.source);
        parcel.writeString(this.sourceTag);
        parcel.writeInt(this.carrierType);
        parcel.writeInt(this.state);
        parcel.writeInt(this.hasSavePhone ? 1 : 0);
    }
}
