package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u00a1\u0001\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0018\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\b\u0010-\u001a\u0004\u0018\u00010(\u0012\u0006\u00103\u001a\u00020.\u0012\u0006\u00108\u001a\u000204\u0012\u0006\u0010;\u001a\u000204\u0012\u0006\u0010>\u001a\u00020\u0002\u0012\u0006\u0010A\u001a\u00020\u0002\u0012\b\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020E0\u0018\u0012\b\u0010J\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bK\u0010LJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R#\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010 \u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010-\u001a\u0004\u0018\u00010(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00103\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0017\u00108\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00105\u001a\u0004\b6\u00107R\u0017\u0010;\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u00107R\u0017\u0010>\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b<\u0010\u0011\u001a\u0004\b=\u0010\u0013R\u0017\u0010A\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b?\u0010\u0011\u001a\u0004\b@\u0010\u0013R\u0019\u0010D\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\bB\u0010\u0011\u001a\u0004\bC\u0010\u0013R#\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020E0\u00188\u0006\u00a2\u0006\f\n\u0004\bF\u0010\u001b\u001a\u0004\bG\u0010\u001dR\u0019\u0010J\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\bI\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006M"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/AvatarResourceModel;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "shaderDir", "e", "c", "indirectLightPath", "", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAsset;", "f", "Ljava/util/Map;", "j", "()Ljava/util/Map;", "slotAssetMap", h.F, "pinchFaceConfigPath", "", "Lcom/tencent/filament/zplan/avatar/model/ZPlanPinchFaceModel;", "i", "Ljava/util/List;", "getPinchFaceData", "()Ljava/util/List;", "pinchFaceData", "Lcom/tencent/filament/zplan/avatar/model/ZPlanCommonGltfFAsset;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/filament/zplan/avatar/model/ZPlanCommonGltfFAsset;", "b", "()Lcom/tencent/filament/zplan/avatar/model/ZPlanCommonGltfFAsset;", "eyelashGltfFAsset", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "getGender", "()Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "D", "getPantsLength", "()D", "pantsLength", "E", "getShoeHeight", "shoeHeight", UserInfo.SEX_FEMALE, "getKawaiiPath", "kawaiiPath", "G", "getBodyTypePath", "bodyTypePath", "H", "a", "aiBodyRefPath", "Lcom/tencent/filament/zplan/avatar/model/ZPlanUgcFAsset;", "I", "getUgcResData", "ugcResData", "J", "lutTexturePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Lcom/tencent/filament/zplan/avatar/model/ZPlanCommonGltfFAsset;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class AvatarResourceModel implements Parcelable {
    public static final Parcelable.Creator<AvatarResourceModel> CREATOR = new a();

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private final EnumUserGender gender;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private final double pantsLength;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private final double shoeHeight;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @NotNull
    private final String kawaiiPath;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @NotNull
    private final String bodyTypePath;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @Nullable
    private final String aiBodyRefPath;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @NotNull
    private final Map<String, ZPlanUgcFAsset> ugcResData;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @Nullable
    private final String lutTexturePath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String shaderDir;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String indirectLightPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<String, ZPlanFAsset> slotAssetMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String pinchFaceConfigPath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<ZPlanPinchFaceModel> pinchFaceData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ZPlanCommonGltfFAsset eyelashGltfFAsset;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<AvatarResourceModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AvatarResourceModel createFromParcel(@NotNull Parcel in5) {
            String readString;
            Intrinsics.checkNotNullParameter(in5, "in");
            String readString2 = in5.readString();
            String readString3 = in5.readString();
            int readInt = in5.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            while (true) {
                readString = in5.readString();
                if (readInt == 0) {
                    break;
                }
                linkedHashMap.put(readString, (ZPlanFAsset) in5.readParcelable(AvatarResourceModel.class.getClassLoader()));
                readInt--;
            }
            int readInt2 = in5.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add(ZPlanPinchFaceModel.CREATOR.createFromParcel(in5));
                readInt2--;
            }
            ZPlanCommonGltfFAsset zPlanCommonGltfFAsset = (ZPlanCommonGltfFAsset) in5.readParcelable(AvatarResourceModel.class.getClassLoader());
            EnumUserGender enumUserGender = (EnumUserGender) Enum.valueOf(EnumUserGender.class, in5.readString());
            double readDouble = in5.readDouble();
            double readDouble2 = in5.readDouble();
            String readString4 = in5.readString();
            String readString5 = in5.readString();
            String readString6 = in5.readString();
            int readInt3 = in5.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt3);
            while (readInt3 != 0) {
                linkedHashMap2.put(in5.readString(), ZPlanUgcFAsset.CREATOR.createFromParcel(in5));
                readInt3--;
                readString4 = readString4;
                readDouble2 = readDouble2;
            }
            return new AvatarResourceModel(readString2, readString3, linkedHashMap, readString, arrayList, zPlanCommonGltfFAsset, enumUserGender, readDouble, readDouble2, readString4, readString5, readString6, linkedHashMap2, in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AvatarResourceModel[] newArray(int i3) {
            return new AvatarResourceModel[i3];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AvatarResourceModel(@Nullable String str, @Nullable String str2, @NotNull Map<String, ? extends ZPlanFAsset> slotAssetMap, @Nullable String str3, @NotNull List<ZPlanPinchFaceModel> pinchFaceData, @Nullable ZPlanCommonGltfFAsset zPlanCommonGltfFAsset, @NotNull EnumUserGender gender, double d16, double d17, @NotNull String kawaiiPath, @NotNull String bodyTypePath, @Nullable String str4, @NotNull Map<String, ZPlanUgcFAsset> ugcResData, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(slotAssetMap, "slotAssetMap");
        Intrinsics.checkNotNullParameter(pinchFaceData, "pinchFaceData");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(kawaiiPath, "kawaiiPath");
        Intrinsics.checkNotNullParameter(bodyTypePath, "bodyTypePath");
        Intrinsics.checkNotNullParameter(ugcResData, "ugcResData");
        this.shaderDir = str;
        this.indirectLightPath = str2;
        this.slotAssetMap = slotAssetMap;
        this.pinchFaceConfigPath = str3;
        this.pinchFaceData = pinchFaceData;
        this.eyelashGltfFAsset = zPlanCommonGltfFAsset;
        this.gender = gender;
        this.pantsLength = d16;
        this.shoeHeight = d17;
        this.kawaiiPath = kawaiiPath;
        this.bodyTypePath = bodyTypePath;
        this.aiBodyRefPath = str4;
        this.ugcResData = ugcResData;
        this.lutTexturePath = str5;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAiBodyRefPath() {
        return this.aiBodyRefPath;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final ZPlanCommonGltfFAsset getEyelashGltfFAsset() {
        return this.eyelashGltfFAsset;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getIndirectLightPath() {
        return this.indirectLightPath;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getLutTexturePath() {
        return this.lutTexturePath;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof AvatarResourceModel) {
                AvatarResourceModel avatarResourceModel = (AvatarResourceModel) other;
                if (!Intrinsics.areEqual(this.shaderDir, avatarResourceModel.shaderDir) || !Intrinsics.areEqual(this.indirectLightPath, avatarResourceModel.indirectLightPath) || !Intrinsics.areEqual(this.slotAssetMap, avatarResourceModel.slotAssetMap) || !Intrinsics.areEqual(this.pinchFaceConfigPath, avatarResourceModel.pinchFaceConfigPath) || !Intrinsics.areEqual(this.pinchFaceData, avatarResourceModel.pinchFaceData) || !Intrinsics.areEqual(this.eyelashGltfFAsset, avatarResourceModel.eyelashGltfFAsset) || !Intrinsics.areEqual(this.gender, avatarResourceModel.gender) || Double.compare(this.pantsLength, avatarResourceModel.pantsLength) != 0 || Double.compare(this.shoeHeight, avatarResourceModel.shoeHeight) != 0 || !Intrinsics.areEqual(this.kawaiiPath, avatarResourceModel.kawaiiPath) || !Intrinsics.areEqual(this.bodyTypePath, avatarResourceModel.bodyTypePath) || !Intrinsics.areEqual(this.aiBodyRefPath, avatarResourceModel.aiBodyRefPath) || !Intrinsics.areEqual(this.ugcResData, avatarResourceModel.ugcResData) || !Intrinsics.areEqual(this.lutTexturePath, avatarResourceModel.lutTexturePath)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getPinchFaceConfigPath() {
        return this.pinchFaceConfigPath;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getShaderDir() {
        return this.shaderDir;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        String str = this.shaderDir;
        int i38 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i39 = i3 * 31;
        String str2 = this.indirectLightPath;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i46 = (i39 + i16) * 31;
        Map<String, ZPlanFAsset> map = this.slotAssetMap;
        if (map != null) {
            i17 = map.hashCode();
        } else {
            i17 = 0;
        }
        int i47 = (i46 + i17) * 31;
        String str3 = this.pinchFaceConfigPath;
        if (str3 != null) {
            i18 = str3.hashCode();
        } else {
            i18 = 0;
        }
        int i48 = (i47 + i18) * 31;
        List<ZPlanPinchFaceModel> list = this.pinchFaceData;
        if (list != null) {
            i19 = list.hashCode();
        } else {
            i19 = 0;
        }
        int i49 = (i48 + i19) * 31;
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset = this.eyelashGltfFAsset;
        if (zPlanCommonGltfFAsset != null) {
            i26 = zPlanCommonGltfFAsset.hashCode();
        } else {
            i26 = 0;
        }
        int i56 = (i49 + i26) * 31;
        EnumUserGender enumUserGender = this.gender;
        if (enumUserGender != null) {
            i27 = enumUserGender.hashCode();
        } else {
            i27 = 0;
        }
        int i57 = (i56 + i27) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.pantsLength);
        int i58 = (i57 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.shoeHeight);
        int i59 = (i58 + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        String str4 = this.kawaiiPath;
        if (str4 != null) {
            i28 = str4.hashCode();
        } else {
            i28 = 0;
        }
        int i65 = (i59 + i28) * 31;
        String str5 = this.bodyTypePath;
        if (str5 != null) {
            i29 = str5.hashCode();
        } else {
            i29 = 0;
        }
        int i66 = (i65 + i29) * 31;
        String str6 = this.aiBodyRefPath;
        if (str6 != null) {
            i36 = str6.hashCode();
        } else {
            i36 = 0;
        }
        int i67 = (i66 + i36) * 31;
        Map<String, ZPlanUgcFAsset> map2 = this.ugcResData;
        if (map2 != null) {
            i37 = map2.hashCode();
        } else {
            i37 = 0;
        }
        int i68 = (i67 + i37) * 31;
        String str7 = this.lutTexturePath;
        if (str7 != null) {
            i38 = str7.hashCode();
        }
        return i68 + i38;
    }

    @NotNull
    public final Map<String, ZPlanFAsset> j() {
        return this.slotAssetMap;
    }

    @NotNull
    public String toString() {
        return "AvatarResourceModel(shaderDir=" + this.shaderDir + ", indirectLightPath=" + this.indirectLightPath + ", slotAssetMap=" + this.slotAssetMap + ", pinchFaceConfigPath=" + this.pinchFaceConfigPath + ", pinchFaceData=" + this.pinchFaceData + ", eyelashGltfFAsset=" + this.eyelashGltfFAsset + ", gender=" + this.gender + ", pantsLength=" + this.pantsLength + ", shoeHeight=" + this.shoeHeight + ", kawaiiPath=" + this.kawaiiPath + ", bodyTypePath=" + this.bodyTypePath + ", aiBodyRefPath=" + this.aiBodyRefPath + ", ugcResData=" + this.ugcResData + ", lutTexturePath=" + this.lutTexturePath + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.shaderDir);
        parcel.writeString(this.indirectLightPath);
        Map<String, ZPlanFAsset> map = this.slotAssetMap;
        parcel.writeInt(map.size());
        for (Map.Entry<String, ZPlanFAsset> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeParcelable(entry.getValue(), flags);
        }
        parcel.writeString(this.pinchFaceConfigPath);
        List<ZPlanPinchFaceModel> list = this.pinchFaceData;
        parcel.writeInt(list.size());
        Iterator<ZPlanPinchFaceModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, 0);
        }
        parcel.writeParcelable(this.eyelashGltfFAsset, flags);
        parcel.writeString(this.gender.name());
        parcel.writeDouble(this.pantsLength);
        parcel.writeDouble(this.shoeHeight);
        parcel.writeString(this.kawaiiPath);
        parcel.writeString(this.bodyTypePath);
        parcel.writeString(this.aiBodyRefPath);
        Map<String, ZPlanUgcFAsset> map2 = this.ugcResData;
        parcel.writeInt(map2.size());
        for (Map.Entry<String, ZPlanUgcFAsset> entry2 : map2.entrySet()) {
            parcel.writeString(entry2.getKey());
            entry2.getValue().writeToParcel(parcel, 0);
        }
        parcel.writeString(this.lutTexturePath);
    }
}
