package com.tencent.mobileqq.wink.magicAvatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.ttpic.openapi.filter.LightConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0007\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b3\u00104B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b3\u00105J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R6\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\f\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\"\u0010-\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\f\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R\"\u00100\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\f\u001a\u0004\b1\u0010\u000e\"\u0004\b2\u0010\u0010\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "uploadUrl", "Ljava/lang/String;", "getUploadUrl", "()Ljava/lang/String;", "setUploadUrl", "(Ljava/lang/String;)V", "generateAvatarUrl", "getGenerateAvatarUrl", "setGenerateAvatarUrl", "generateAvatarFilePath", "getGenerateAvatarFilePath", "setGenerateAvatarFilePath", "generateAvatarQrUrl", "getGenerateAvatarQrUrl", "setGenerateAvatarQrUrl", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;", "Lkotlin/collections/ArrayList;", "materials", "Ljava/util/ArrayList;", "getMaterials", "()Ljava/util/ArrayList;", "setMaterials", "(Ljava/util/ArrayList;)V", "", "glass", "Z", "getGlass", "()Z", "setGlass", "(Z)V", "gender", "getGender", "setGender", "originStyleName", "getOriginStyleName", "setOriginStyleName", "originFilePath", "getOriginFilePath", "setOriginFilePath", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarGenerateInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private String gender;

    @NotNull
    private String generateAvatarFilePath;

    @NotNull
    private String generateAvatarQrUrl;

    @NotNull
    private String generateAvatarUrl;
    private boolean glass;

    @Nullable
    private ArrayList<MagicAvatarMaterialInfo> materials;

    @NotNull
    private String originFilePath;

    @NotNull
    private String originStyleName;

    @NotNull
    private String uploadUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarGenerateInfo$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<MagicAvatarGenerateInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MagicAvatarGenerateInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MagicAvatarGenerateInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MagicAvatarGenerateInfo[] newArray(int size) {
            return new MagicAvatarGenerateInfo[size];
        }

        Companion() {
        }
    }

    public MagicAvatarGenerateInfo() {
        this.uploadUrl = "";
        this.generateAvatarUrl = "";
        this.generateAvatarFilePath = "";
        this.generateAvatarQrUrl = "";
        this.gender = LightConstants.MALE;
        this.originStyleName = "";
        this.originFilePath = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getGender() {
        return this.gender;
    }

    @NotNull
    public final String getGenerateAvatarFilePath() {
        return this.generateAvatarFilePath;
    }

    @NotNull
    public final String getGenerateAvatarQrUrl() {
        return this.generateAvatarQrUrl;
    }

    @NotNull
    public final String getGenerateAvatarUrl() {
        return this.generateAvatarUrl;
    }

    public final boolean getGlass() {
        return this.glass;
    }

    @Nullable
    public final ArrayList<MagicAvatarMaterialInfo> getMaterials() {
        return this.materials;
    }

    @NotNull
    public final String getOriginFilePath() {
        return this.originFilePath;
    }

    @NotNull
    public final String getOriginStyleName() {
        return this.originStyleName;
    }

    @NotNull
    public final String getUploadUrl() {
        return this.uploadUrl;
    }

    public final void setGender(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gender = str;
    }

    public final void setGenerateAvatarFilePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.generateAvatarFilePath = str;
    }

    public final void setGenerateAvatarQrUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.generateAvatarQrUrl = str;
    }

    public final void setGenerateAvatarUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.generateAvatarUrl = str;
    }

    public final void setGlass(boolean z16) {
        this.glass = z16;
    }

    public final void setMaterials(@Nullable ArrayList<MagicAvatarMaterialInfo> arrayList) {
        this.materials = arrayList;
    }

    public final void setOriginFilePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originFilePath = str;
    }

    public final void setOriginStyleName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originStyleName = str;
    }

    public final void setUploadUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uploadUrl = str;
    }

    @NotNull
    public String toString() {
        return "MagicAvatarGenerateInfo(uploadUrl='" + this.uploadUrl + "', generateAvatarUrl='" + this.generateAvatarUrl + "', generateAvatarFilePath='" + this.generateAvatarFilePath + "', generateAvatarQrUrl='" + this.generateAvatarQrUrl + "', materials=" + this.materials + ", glass=" + this.glass + ", gender='" + this.gender + "', originStyleName='" + this.originStyleName + ", originFilePath='" + this.originFilePath + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.uploadUrl);
        parcel.writeString(this.generateAvatarUrl);
        parcel.writeString(this.generateAvatarFilePath);
        parcel.writeString(this.generateAvatarQrUrl);
        parcel.writeByte(this.glass ? (byte) 1 : (byte) 0);
        parcel.writeString(this.gender);
        parcel.writeString(this.originStyleName);
        parcel.writeString(this.originFilePath);
        ArrayList<MagicAvatarMaterialInfo> arrayList = this.materials;
        if (arrayList != null) {
            parcel.writeParcelableArray((Parcelable[]) arrayList.toArray(new MagicAvatarMaterialInfo[arrayList.size()]), flags);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MagicAvatarGenerateInfo(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.uploadUrl = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.generateAvatarUrl = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.generateAvatarFilePath = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.generateAvatarQrUrl = readString4 == null ? "" : readString4;
        this.glass = parcel.readByte() != 0;
        String readString5 = parcel.readString();
        this.gender = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        this.originStyleName = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        this.originFilePath = readString7 != null ? readString7 : "";
        Parcelable[] readParcelableArray = parcel.readParcelableArray(MagicAvatarMaterialInfo.class.getClassLoader());
        this.materials = new ArrayList<>();
        if (readParcelableArray != null) {
            Iterator it = ArrayIteratorKt.iterator(readParcelableArray);
            while (it.hasNext()) {
                Parcelable parcelable = (Parcelable) it.next();
                ArrayList<MagicAvatarMaterialInfo> arrayList = this.materials;
                if (arrayList != null) {
                    Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo");
                    arrayList.add((MagicAvatarMaterialInfo) parcelable);
                }
            }
        }
    }
}
