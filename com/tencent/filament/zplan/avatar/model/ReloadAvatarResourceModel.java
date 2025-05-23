package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.avatar.AvatarCheckResult;
import com.tencent.filament.zplan.avatar.FAssetChecker;
import com.tencent.filament.zplan.avatar.FaceVerificationCode;
import com.tencent.filament.zplan.util.Result;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.filament.zplanservice.verify.FilamentVerificationHelper;
import com.tencent.filament.zplanservice.verify.ResourceCheckAlgorithmSelect;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.common.utils.c;
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
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b(\b\u0087\b\u0018\u0000 Z2\u00020\u0001:\u0001\u0014B{\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010#\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020\u0016\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0016\u0012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020&0\u0015\u00a2\u0006\u0004\bX\u0010YJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0091\u0001\u0010(\u001a\u00020\u00002\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020\u00162\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00162\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020&0\u0015H\u00c6\u0001J\t\u0010)\u001a\u00020\u0016H\u00d6\u0001J\t\u0010+\u001a\u00020*H\u00d6\u0001J\u0013\u0010.\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010,H\u00d6\u0003J\t\u0010/\u001a\u00020*H\u00d6\u0001J\u0019\u00104\u001a\u0002032\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020*H\u00d6\u0001R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010>\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u00106\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00158\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010?\u001a\u0004\b@\u0010AR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0017\u0010 \u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010N\u001a\u0004\bO\u0010PR\u0017\u0010\"\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\bQ\u0010Q\u001a\u0004\bR\u0010SR\u0017\u0010#\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010Q\u001a\u0004\bT\u0010SR\u0017\u0010$\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b9\u0010C\u001a\u0004\bJ\u0010ER\u0019\u0010%\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b=\u0010C\u001a\u0004\bU\u0010ER#\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020&0\u00158\u0006\u00a2\u0006\f\n\u0004\bV\u0010?\u001a\u0004\bW\u0010A\u00a8\u0006["}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "Landroid/os/Parcelable;", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckAlgorithmSelect;", "algorithmSelect", "Lcom/tencent/filament/zplan/avatar/AvatarCheckResult;", "g", "f", "e", "c", "b", "E", "a", "", "", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAsset;", "slotAssetMap", "pinchFaceConfigPath", "", "Lcom/tencent/filament/zplan/avatar/model/ZPlanPinchFaceModel;", "pinchFaceData", "Lcom/tencent/filament/zplan/avatar/model/ZPlanCommonGltfFAsset;", "eyelashGltfFAsset", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "pantsLength", "shoeHeight", "bodyTypePath", "aiBodyRefPath", "Lcom/tencent/filament/zplan/avatar/model/ZPlanUgcFAsset;", "ugcResData", "j", "toString", "", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Z", DomainData.DOMAIN_NAME, "()Z", UserInfo.SEX_FEMALE, "(Z)V", "downloadFromNet", "w", "G", "useCache", "Ljava/util/Map;", "u", "()Ljava/util/Map;", h.F, "Ljava/lang/String;", "r", "()Ljava/lang/String;", "i", "Ljava/util/List;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/filament/zplan/avatar/model/ZPlanCommonGltfFAsset;", "o", "()Lcom/tencent/filament/zplan/avatar/model/ZPlanCommonGltfFAsset;", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "p", "()Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()D", "t", "l", "H", "v", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Lcom/tencent/filament/zplan/avatar/model/ZPlanCommonGltfFAsset;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;DDLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "I", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class ReloadAvatarResourceModel implements Parcelable {

    /* renamed from: C, reason: from toString */
    @NotNull
    private final EnumUserGender gender;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private final double pantsLength;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private final double shoeHeight;

    /* renamed from: F, reason: from toString */
    @NotNull
    private final String bodyTypePath;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @Nullable
    private final String aiBodyRefPath;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private final Map<String, ZPlanUgcFAsset> ugcResData;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean downloadFromNet;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean useCache;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    @NotNull
    private final Map<String, ZPlanFAsset> slotAssetMap;

    /* renamed from: h, reason: from toString */
    @Nullable
    private final String pinchFaceConfigPath;

    /* renamed from: i, reason: from kotlin metadata and from toString */
    @NotNull
    private final List<ZPlanPinchFaceModel> pinchFaceData;

    /* renamed from: m, reason: from toString */
    @Nullable
    private final ZPlanCommonGltfFAsset eyelashGltfFAsset;
    public static final Parcelable.Creator<ReloadAvatarResourceModel> CREATOR = new b();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class b implements Parcelable.Creator<ReloadAvatarResourceModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a */
        public final ReloadAvatarResourceModel createFromParcel(@NotNull Parcel in5) {
            String readString;
            Intrinsics.checkNotNullParameter(in5, "in");
            int readInt = in5.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            while (true) {
                readString = in5.readString();
                if (readInt == 0) {
                    break;
                }
                linkedHashMap.put(readString, (ZPlanFAsset) in5.readParcelable(ReloadAvatarResourceModel.class.getClassLoader()));
                readInt--;
            }
            int readInt2 = in5.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add(ZPlanPinchFaceModel.CREATOR.createFromParcel(in5));
                readInt2--;
            }
            ZPlanCommonGltfFAsset zPlanCommonGltfFAsset = (ZPlanCommonGltfFAsset) in5.readParcelable(ReloadAvatarResourceModel.class.getClassLoader());
            EnumUserGender enumUserGender = (EnumUserGender) Enum.valueOf(EnumUserGender.class, in5.readString());
            double readDouble = in5.readDouble();
            double readDouble2 = in5.readDouble();
            String readString2 = in5.readString();
            String readString3 = in5.readString();
            int readInt3 = in5.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt3);
            while (readInt3 != 0) {
                linkedHashMap2.put(in5.readString(), ZPlanUgcFAsset.CREATOR.createFromParcel(in5));
                readInt3--;
                readString3 = readString3;
            }
            return new ReloadAvatarResourceModel(linkedHashMap, readString, arrayList, zPlanCommonGltfFAsset, enumUserGender, readDouble, readDouble2, readString2, readString3, linkedHashMap2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b */
        public final ReloadAvatarResourceModel[] newArray(int i3) {
            return new ReloadAvatarResourceModel[i3];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReloadAvatarResourceModel(@NotNull Map<String, ? extends ZPlanFAsset> slotAssetMap, @Nullable String str, @NotNull List<ZPlanPinchFaceModel> pinchFaceData, @Nullable ZPlanCommonGltfFAsset zPlanCommonGltfFAsset, @NotNull EnumUserGender gender, double d16, double d17, @NotNull String bodyTypePath, @Nullable String str2, @NotNull Map<String, ZPlanUgcFAsset> ugcResData) {
        Intrinsics.checkNotNullParameter(slotAssetMap, "slotAssetMap");
        Intrinsics.checkNotNullParameter(pinchFaceData, "pinchFaceData");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(bodyTypePath, "bodyTypePath");
        Intrinsics.checkNotNullParameter(ugcResData, "ugcResData");
        this.slotAssetMap = slotAssetMap;
        this.pinchFaceConfigPath = str;
        this.pinchFaceData = pinchFaceData;
        this.eyelashGltfFAsset = zPlanCommonGltfFAsset;
        this.gender = gender;
        this.pantsLength = d16;
        this.shoeHeight = d17;
        this.bodyTypePath = bodyTypePath;
        this.aiBodyRefPath = str2;
        this.ugcResData = ugcResData;
    }

    private final boolean A() {
        if (!TextUtils.isEmpty(this.pinchFaceConfigPath) && !c.f385288a.h(this.pinchFaceConfigPath)) {
            return false;
        }
        return true;
    }

    private final boolean B() {
        String str;
        for (Map.Entry<String, ZPlanFAsset> entry : this.slotAssetMap.entrySet()) {
            ZPlanFAsset value = entry.getValue();
            boolean z16 = value instanceof ZPlanCommonGltfFAsset;
            String str2 = null;
            if (z16) {
                str = ((ZPlanCommonGltfFAsset) value).getGltfFilePath();
            } else if (value instanceof ZPlanDressUpFAsset) {
                str = ((ZPlanDressUpFAsset) value).getGltfFilePath();
            } else if (value instanceof ZPlanMakeUpFAsset) {
                str = ((ZPlanMakeUpFAsset) value).getDirPath();
            } else if (value instanceof ZPlanUgcFAsset) {
                str = ((ZPlanUgcFAsset) value).getJsonPath();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str) && !c.f385288a.h(str)) {
                return false;
            }
            if (Intrinsics.areEqual(entry.getKey(), TorsoSlot.FACE.getKey())) {
                if (!z16) {
                    FLog.INSTANCE.e("ReloadAvatarResourceModel", "verifyFace fail. face is not ZPlanCommonGltfFAsset");
                    return false;
                }
                ZPlanCommonGltfFAsset zPlanCommonGltfFAsset = (ZPlanCommonGltfFAsset) value;
                String gltfFilePath = zPlanCommonGltfFAsset.getGltfFilePath();
                if (gltfFilePath != null) {
                    str2 = com.tencent.filament.zplanservice.util.c.b(gltfFilePath);
                }
                if (str2 == null) {
                    FLog.INSTANCE.e("ReloadAvatarResourceModel", "verifyFace fail. faceDir is null. gltfPath:" + zPlanCommonGltfFAsset.getGltfFilePath() + ", url:" + value.getAssetInfo().getUrl());
                    return false;
                }
                Result c16 = FAssetChecker.f105632b.c(str2, value.getAssetInfo().getUrl());
                if (!FaceVerificationCode.INSTANCE.a(c16.getCode()).isPassed()) {
                    String message = c16.getMessage();
                    FLog.INSTANCE.e("ReloadAvatarResourceModel", "verifyFace fail. dir:" + str2 + ", url:" + value.getAssetInfo().getUrl() + " reason:" + message);
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean C() {
        for (ZPlanUgcFAsset zPlanUgcFAsset : this.ugcResData.values()) {
            if (!TextUtils.isEmpty(zPlanUgcFAsset.getJsonPath()) && !c.f385288a.h(zPlanUgcFAsset.getJsonPath())) {
                return false;
            }
        }
        return true;
    }

    private final AvatarCheckResult b(FilamentUrlTemplate urlTemplate, ResourceCheckAlgorithmSelect algorithmSelect) {
        return FAssetChecker.f105632b.a(urlTemplate.getLightAIBodyDriveRefPoseUrl(), urlTemplate, algorithmSelect);
    }

    private final AvatarCheckResult c(FilamentUrlTemplate urlTemplate, ResourceCheckAlgorithmSelect algorithmSelect) {
        String b16 = com.tencent.filament.zplanservice.util.c.b(this.bodyTypePath);
        long currentTimeMillis = System.currentTimeMillis();
        return AvatarCheckResult.INSTANCE.b(urlTemplate.getBodyTypeUrl(), b16, FilamentVerificationHelper.f106448a.a(b16, algorithmSelect), System.currentTimeMillis() - currentTimeMillis);
    }

    private final AvatarCheckResult e(FilamentUrlTemplate urlTemplate, ResourceCheckAlgorithmSelect algorithmSelect) {
        String mEyelashResUrl;
        if (this.gender == EnumUserGender.GENDER_FEMALE) {
            mEyelashResUrl = urlTemplate.getFEyelashResUrl();
        } else {
            mEyelashResUrl = urlTemplate.getMEyelashResUrl();
        }
        return FAssetChecker.f105632b.a(mEyelashResUrl, urlTemplate, algorithmSelect);
    }

    private final AvatarCheckResult f(FilamentUrlTemplate urlTemplate, ResourceCheckAlgorithmSelect algorithmSelect) {
        return FAssetChecker.f105632b.a(urlTemplate.getPinchFaceConfigUrl(), urlTemplate, algorithmSelect);
    }

    private final AvatarCheckResult g(FilamentUrlTemplate urlTemplate, ResourceCheckAlgorithmSelect algorithmSelect) {
        AvatarCheckResult a16 = AvatarCheckResult.INSTANCE.a();
        Iterator<Map.Entry<String, ZPlanFAsset>> it = this.slotAssetMap.entrySet().iterator();
        while (it.hasNext()) {
            a16 = a16.c(FAssetChecker.f105632b.a(it.next().getValue().getAssetInfo().getUrl(), urlTemplate, algorithmSelect));
        }
        return a16;
    }

    public static /* synthetic */ ReloadAvatarResourceModel k(ReloadAvatarResourceModel reloadAvatarResourceModel, Map map, String str, List list, ZPlanCommonGltfFAsset zPlanCommonGltfFAsset, EnumUserGender enumUserGender, double d16, double d17, String str2, String str3, Map map2, int i3, Object obj) {
        return reloadAvatarResourceModel.j((i3 & 1) != 0 ? reloadAvatarResourceModel.slotAssetMap : map, (i3 & 2) != 0 ? reloadAvatarResourceModel.pinchFaceConfigPath : str, (i3 & 4) != 0 ? reloadAvatarResourceModel.pinchFaceData : list, (i3 & 8) != 0 ? reloadAvatarResourceModel.eyelashGltfFAsset : zPlanCommonGltfFAsset, (i3 & 16) != 0 ? reloadAvatarResourceModel.gender : enumUserGender, (i3 & 32) != 0 ? reloadAvatarResourceModel.pantsLength : d16, (i3 & 64) != 0 ? reloadAvatarResourceModel.shoeHeight : d17, (i3 & 128) != 0 ? reloadAvatarResourceModel.bodyTypePath : str2, (i3 & 256) != 0 ? reloadAvatarResourceModel.aiBodyRefPath : str3, (i3 & 512) != 0 ? reloadAvatarResourceModel.ugcResData : map2);
    }

    private final boolean x() {
        if (!TextUtils.isEmpty(this.aiBodyRefPath) && !c.f385288a.h(this.aiBodyRefPath)) {
            return false;
        }
        return true;
    }

    private final boolean y() {
        if (!TextUtils.isEmpty(this.bodyTypePath) && !c.f385288a.h(this.bodyTypePath)) {
            return false;
        }
        return true;
    }

    private final boolean z() {
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset = this.eyelashGltfFAsset;
        if (zPlanCommonGltfFAsset == null || TextUtils.isEmpty(zPlanCommonGltfFAsset.getGltfFilePath()) || c.f385288a.h(this.eyelashGltfFAsset.getGltfFilePath())) {
            return true;
        }
        return false;
    }

    public final boolean E() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        if (B() && A() && z() && y() && x() && C()) {
            z16 = true;
        } else {
            z16 = false;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        FLog.INSTANCE.i("ReloadAvatarResourceModel", "ReloadAvatarResourceModel check isValid=" + z16 + ", cost=" + currentTimeMillis2);
        return z16;
    }

    public final void F(boolean z16) {
        this.downloadFromNet = z16;
    }

    public final void G(boolean z16) {
        this.useCache = z16;
    }

    @NotNull
    public final AvatarCheckResult a(@NotNull FilamentUrlTemplate urlTemplate, @NotNull ResourceCheckAlgorithmSelect algorithmSelect) {
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        Intrinsics.checkNotNullParameter(algorithmSelect, "algorithmSelect");
        return g(urlTemplate, algorithmSelect).c(f(urlTemplate, algorithmSelect)).c(e(urlTemplate, algorithmSelect)).c(c(urlTemplate, algorithmSelect)).c(c(urlTemplate, algorithmSelect)).c(b(urlTemplate, algorithmSelect));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ReloadAvatarResourceModel) {
                ReloadAvatarResourceModel reloadAvatarResourceModel = (ReloadAvatarResourceModel) other;
                if (!Intrinsics.areEqual(this.slotAssetMap, reloadAvatarResourceModel.slotAssetMap) || !Intrinsics.areEqual(this.pinchFaceConfigPath, reloadAvatarResourceModel.pinchFaceConfigPath) || !Intrinsics.areEqual(this.pinchFaceData, reloadAvatarResourceModel.pinchFaceData) || !Intrinsics.areEqual(this.eyelashGltfFAsset, reloadAvatarResourceModel.eyelashGltfFAsset) || !Intrinsics.areEqual(this.gender, reloadAvatarResourceModel.gender) || Double.compare(this.pantsLength, reloadAvatarResourceModel.pantsLength) != 0 || Double.compare(this.shoeHeight, reloadAvatarResourceModel.shoeHeight) != 0 || !Intrinsics.areEqual(this.bodyTypePath, reloadAvatarResourceModel.bodyTypePath) || !Intrinsics.areEqual(this.aiBodyRefPath, reloadAvatarResourceModel.aiBodyRefPath) || !Intrinsics.areEqual(this.ugcResData, reloadAvatarResourceModel.ugcResData)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        Map<String, ZPlanFAsset> map = this.slotAssetMap;
        int i28 = 0;
        if (map != null) {
            i3 = map.hashCode();
        } else {
            i3 = 0;
        }
        int i29 = i3 * 31;
        String str = this.pinchFaceConfigPath;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i36 = (i29 + i16) * 31;
        List<ZPlanPinchFaceModel> list = this.pinchFaceData;
        if (list != null) {
            i17 = list.hashCode();
        } else {
            i17 = 0;
        }
        int i37 = (i36 + i17) * 31;
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset = this.eyelashGltfFAsset;
        if (zPlanCommonGltfFAsset != null) {
            i18 = zPlanCommonGltfFAsset.hashCode();
        } else {
            i18 = 0;
        }
        int i38 = (i37 + i18) * 31;
        EnumUserGender enumUserGender = this.gender;
        if (enumUserGender != null) {
            i19 = enumUserGender.hashCode();
        } else {
            i19 = 0;
        }
        int i39 = (i38 + i19) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.pantsLength);
        int i46 = (i39 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.shoeHeight);
        int i47 = (i46 + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        String str2 = this.bodyTypePath;
        if (str2 != null) {
            i26 = str2.hashCode();
        } else {
            i26 = 0;
        }
        int i48 = (i47 + i26) * 31;
        String str3 = this.aiBodyRefPath;
        if (str3 != null) {
            i27 = str3.hashCode();
        } else {
            i27 = 0;
        }
        int i49 = (i48 + i27) * 31;
        Map<String, ZPlanUgcFAsset> map2 = this.ugcResData;
        if (map2 != null) {
            i28 = map2.hashCode();
        }
        return i49 + i28;
    }

    @NotNull
    public final ReloadAvatarResourceModel j(@NotNull Map<String, ? extends ZPlanFAsset> slotAssetMap, @Nullable String pinchFaceConfigPath, @NotNull List<ZPlanPinchFaceModel> pinchFaceData, @Nullable ZPlanCommonGltfFAsset eyelashGltfFAsset, @NotNull EnumUserGender gender, double pantsLength, double shoeHeight, @NotNull String bodyTypePath, @Nullable String aiBodyRefPath, @NotNull Map<String, ZPlanUgcFAsset> ugcResData) {
        Intrinsics.checkNotNullParameter(slotAssetMap, "slotAssetMap");
        Intrinsics.checkNotNullParameter(pinchFaceData, "pinchFaceData");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(bodyTypePath, "bodyTypePath");
        Intrinsics.checkNotNullParameter(ugcResData, "ugcResData");
        return new ReloadAvatarResourceModel(slotAssetMap, pinchFaceConfigPath, pinchFaceData, eyelashGltfFAsset, gender, pantsLength, shoeHeight, bodyTypePath, aiBodyRefPath, ugcResData);
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final String getAiBodyRefPath() {
        return this.aiBodyRefPath;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getBodyTypePath() {
        return this.bodyTypePath;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getDownloadFromNet() {
        return this.downloadFromNet;
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final ZPlanCommonGltfFAsset getEyelashGltfFAsset() {
        return this.eyelashGltfFAsset;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final EnumUserGender getGender() {
        return this.gender;
    }

    /* renamed from: q, reason: from getter */
    public final double getPantsLength() {
        return this.pantsLength;
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public final String getPinchFaceConfigPath() {
        return this.pinchFaceConfigPath;
    }

    @NotNull
    public final List<ZPlanPinchFaceModel> s() {
        return this.pinchFaceData;
    }

    /* renamed from: t, reason: from getter */
    public final double getShoeHeight() {
        return this.shoeHeight;
    }

    @NotNull
    public String toString() {
        return "ReloadAvatarResourceModel(slotAssetMap=" + this.slotAssetMap + ", pinchFaceConfigPath=" + this.pinchFaceConfigPath + ", pinchFaceData=" + this.pinchFaceData + ", eyelashGltfFAsset=" + this.eyelashGltfFAsset + ", gender=" + this.gender + ", pantsLength=" + this.pantsLength + ", shoeHeight=" + this.shoeHeight + ", bodyTypePath=" + this.bodyTypePath + ", aiBodyRefPath=" + this.aiBodyRefPath + ", ugcResData=" + this.ugcResData + ")";
    }

    @NotNull
    public final Map<String, ZPlanFAsset> u() {
        return this.slotAssetMap;
    }

    @NotNull
    public final Map<String, ZPlanUgcFAsset> v() {
        return this.ugcResData;
    }

    /* renamed from: w, reason: from getter */
    public final boolean getUseCache() {
        return this.useCache;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int r56) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Map<String, ZPlanFAsset> map = this.slotAssetMap;
        parcel.writeInt(map.size());
        for (Map.Entry<String, ZPlanFAsset> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeParcelable(entry.getValue(), r56);
        }
        parcel.writeString(this.pinchFaceConfigPath);
        List<ZPlanPinchFaceModel> list = this.pinchFaceData;
        parcel.writeInt(list.size());
        Iterator<ZPlanPinchFaceModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, 0);
        }
        parcel.writeParcelable(this.eyelashGltfFAsset, r56);
        parcel.writeString(this.gender.name());
        parcel.writeDouble(this.pantsLength);
        parcel.writeDouble(this.shoeHeight);
        parcel.writeString(this.bodyTypePath);
        parcel.writeString(this.aiBodyRefPath);
        Map<String, ZPlanUgcFAsset> map2 = this.ugcResData;
        parcel.writeInt(map2.size());
        for (Map.Entry<String, ZPlanUgcFAsset> entry2 : map2.entrySet()) {
            parcel.writeString(entry2.getKey());
            entry2.getValue().writeToParcel(parcel, 0);
        }
    }
}
