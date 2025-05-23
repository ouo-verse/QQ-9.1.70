package com.tencent.videocut.render.extension;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.model.WinkUserInfo;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.WatermarkDataSourceModel;
import com.tencent.videocut.model.WatermarkDateModel;
import com.tencent.videocut.model.WatermarkPoiModel;
import com.tencent.videocut.model.WatermarkPoiModelWrapper;
import com.tencent.videocut.model.WatermarkUserModel;
import cooperation.qzone.LbsDataV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import org.light.datasource.LightBaseDataSourceValue;
import org.light.datasource.LightDateDataSourceValue;
import org.light.datasource.LightLocationDataSourceValue;
import org.light.datasource.LightUserInfoDataSourceValue;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00042\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00042\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u000b\u001a\u00020\n*\u00020\t\u001a\f\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\f\u001a\u0014\u0010\u0013\u001a\u00020\u0012*\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0010\u001a\u0012\u0010\u0016\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014\u001a\u0010\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\u00020\u000f\u001a\n\u0010\u001a\u001a\u00020\u0018*\u00020\u0014\u001a\n\u0010\u001b\u001a\u00020\u0014*\u00020\u0018\u001a\f\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u0004\u001a\n\u0010\u001e\u001a\u00020\u001c*\u00020\n\u001a\f\u0010\u001f\u001a\u0004\u0018\u00010\u001c*\u00020\u0012\u001a\f\u0010 \u001a\u0004\u0018\u00010\u001c*\u00020\r\u00a8\u0006!"}, d2 = {"Lcom/tencent/videocut/model/StickerModel;", "", "checkEditable", "a", "Lcom/tencent/videocut/model/WatermarkDataSourceModel;", "b", "g", "d", "e", "", "Lcom/tencent/videocut/model/WatermarkDateModel;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/wink/editor/model/c;", "Lcom/tencent/videocut/model/WatermarkUserModel;", "r", "Lcooperation/qzone/LbsDataV2$PoiList;", "", "useIndex", "Lcom/tencent/videocut/model/WatermarkPoiModelWrapper;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcooperation/qzone/LbsDataV2$PoiInfo;", "poiInfo", tl.h.F, "", "Lcom/tencent/videocut/model/WatermarkPoiModel;", "p", "o", "i", "Lorg/light/datasource/LightBaseDataSourceValue;", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class i {
    public static final boolean a(@NotNull StickerModel stickerModel, boolean z16) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        Iterator<T> it = stickerModel.watermarkModel.values().iterator();
        while (it.hasNext()) {
            if (b((WatermarkDataSourceModel) it.next(), z16)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(@NotNull WatermarkDataSourceModel watermarkDataSourceModel, boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(watermarkDataSourceModel, "<this>");
        if (z16) {
            z17 = watermarkDataSourceModel.isEditable;
        } else {
            z17 = true;
        }
        if (z17 && Intrinsics.areEqual(watermarkDataSourceModel.dataKey, LightConstants.DataSourceKey.LOCATION) && watermarkDataSourceModel.menuTypeList.contains(WatermarkDataSourceModel.MenuType.LOCATION)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean c(StickerModel stickerModel, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return a(stickerModel, z16);
    }

    public static final boolean d(@NotNull StickerModel stickerModel, boolean z16) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        Iterator<T> it = stickerModel.watermarkModel.values().iterator();
        while (it.hasNext()) {
            if (e((WatermarkDataSourceModel) it.next(), z16)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean e(@NotNull WatermarkDataSourceModel watermarkDataSourceModel, boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(watermarkDataSourceModel, "<this>");
        if (z16) {
            z17 = watermarkDataSourceModel.isEditable;
        } else {
            z17 = true;
        }
        if (z17 && Intrinsics.areEqual(watermarkDataSourceModel.dataKey, LightConstants.DataSourceKey.DATE) && watermarkDataSourceModel.menuTypeList.contains(WatermarkDataSourceModel.MenuType.DATE_TIME)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean f(StickerModel stickerModel, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return d(stickerModel, z16);
    }

    public static final boolean g(@NotNull WatermarkDataSourceModel watermarkDataSourceModel, boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(watermarkDataSourceModel, "<this>");
        if (z16) {
            z17 = watermarkDataSourceModel.isEditable;
        } else {
            z17 = true;
        }
        if (z17 && Intrinsics.areEqual(watermarkDataSourceModel.dataKey, LightConstants.DataSourceKey.USER_INFO)) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final WatermarkPoiModelWrapper h(@NotNull WatermarkPoiModelWrapper watermarkPoiModelWrapper, @NotNull LbsDataV2.PoiInfo poiInfo) {
        List listOf;
        Intrinsics.checkNotNullParameter(watermarkPoiModelWrapper, "<this>");
        Intrinsics.checkNotNullParameter(poiInfo, "poiInfo");
        WatermarkPoiModel o16 = o(poiInfo);
        if (!Intrinsics.areEqual(watermarkPoiModelWrapper.usedPoiModel, o16)) {
            if (!watermarkPoiModelWrapper.poiModelList.contains(o16)) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(o16);
                return new WatermarkPoiModelWrapper(o16, 0, listOf, null, 8, null);
            }
            return new WatermarkPoiModelWrapper(o16, watermarkPoiModelWrapper.poiModelList.indexOf(o16), watermarkPoiModelWrapper.poiModelList, null, 8, null);
        }
        return watermarkPoiModelWrapper;
    }

    @NotNull
    public static final LbsDataV2.PoiInfo i(@NotNull WatermarkPoiModel watermarkPoiModel) {
        Intrinsics.checkNotNullParameter(watermarkPoiModel, "<this>");
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        poiInfo.poiId = watermarkPoiModel.poiId;
        poiInfo.poiName = watermarkPoiModel.poiName;
        poiInfo.poiType = watermarkPoiModel.poiType;
        poiInfo.poiTypeName = watermarkPoiModel.poiTypeName;
        poiInfo.poiDefaultName = watermarkPoiModel.poiDefaultName;
        poiInfo.address = watermarkPoiModel.address;
        poiInfo.districtCode = watermarkPoiModel.districtCode;
        poiInfo.distance = watermarkPoiModel.distance;
        poiInfo.hotValue = watermarkPoiModel.hotValue;
        poiInfo.phoneNumber = watermarkPoiModel.phoneNumber;
        poiInfo.poiOrderType = watermarkPoiModel.poiOrderType;
        poiInfo.poiNum = watermarkPoiModel.poiNum;
        poiInfo.dianPingId = watermarkPoiModel.dianPingId;
        poiInfo.country = watermarkPoiModel.country;
        poiInfo.province = watermarkPoiModel.province;
        poiInfo.city = watermarkPoiModel.city;
        poiInfo.district = watermarkPoiModel.district;
        LbsDataV2.GpsInfo gpsInfo = new LbsDataV2.GpsInfo();
        float f16 = 1000000;
        gpsInfo.lat = (int) (watermarkPoiModel.latitude * f16);
        gpsInfo.lon = (int) (watermarkPoiModel.longitude * f16);
        poiInfo.gpsInfo = gpsInfo;
        return poiInfo;
    }

    @Nullable
    public static final LightBaseDataSourceValue j(@NotNull WatermarkDataSourceModel watermarkDataSourceModel) {
        Intrinsics.checkNotNullParameter(watermarkDataSourceModel, "<this>");
        WatermarkDateModel watermarkDateModel = watermarkDataSourceModel.watermarkDateModel;
        if (watermarkDateModel != null) {
            return k(watermarkDateModel);
        }
        WatermarkPoiModelWrapper watermarkPoiModelWrapper = watermarkDataSourceModel.watermarkPoiModelWrapper;
        if (watermarkPoiModelWrapper != null) {
            return l(watermarkPoiModelWrapper);
        }
        WatermarkUserModel watermarkUserModel = watermarkDataSourceModel.watermarkUserModel;
        if (watermarkUserModel != null) {
            return m(watermarkUserModel);
        }
        return null;
    }

    @NotNull
    public static final LightBaseDataSourceValue k(@NotNull WatermarkDateModel watermarkDateModel) {
        Intrinsics.checkNotNullParameter(watermarkDateModel, "<this>");
        LightDateDataSourceValue lightDateDataSourceValue = new LightDateDataSourceValue();
        lightDateDataSourceValue.setTimestamp(watermarkDateModel.timestampUs / 1000000);
        return lightDateDataSourceValue;
    }

    @Nullable
    public static final LightBaseDataSourceValue l(@NotNull WatermarkPoiModelWrapper watermarkPoiModelWrapper) {
        Object orNull;
        Intrinsics.checkNotNullParameter(watermarkPoiModelWrapper, "<this>");
        orNull = CollectionsKt___CollectionsKt.getOrNull(watermarkPoiModelWrapper.poiModelList, watermarkPoiModelWrapper.usedPoiModelIndex);
        WatermarkPoiModel watermarkPoiModel = (WatermarkPoiModel) orNull;
        if (watermarkPoiModel != null) {
            LightLocationDataSourceValue lightLocationDataSourceValue = new LightLocationDataSourceValue();
            lightLocationDataSourceValue.setAddress(watermarkPoiModel.address);
            lightLocationDataSourceValue.setCountry(watermarkPoiModel.country);
            lightLocationDataSourceValue.setProvince(watermarkPoiModel.province);
            lightLocationDataSourceValue.setCity(watermarkPoiModel.city);
            lightLocationDataSourceValue.setLongitude(String.valueOf(watermarkPoiModel.longitude));
            lightLocationDataSourceValue.setLatitude(String.valueOf(watermarkPoiModel.latitude));
            lightLocationDataSourceValue.setTown(watermarkPoiModel.town);
            lightLocationDataSourceValue.setVillage(watermarkPoiModel.village);
            lightLocationDataSourceValue.setDistrict(watermarkPoiModel.district);
            lightLocationDataSourceValue.setRoad(watermarkPoiModel.road);
            lightLocationDataSourceValue.setDisplayName(watermarkPoiModel.displayName);
            lightLocationDataSourceValue.setPoiName(watermarkPoiModel.poiName);
            return lightLocationDataSourceValue;
        }
        return null;
    }

    @Nullable
    public static final LightBaseDataSourceValue m(@NotNull WatermarkUserModel watermarkUserModel) {
        Intrinsics.checkNotNullParameter(watermarkUserModel, "<this>");
        LightUserInfoDataSourceValue lightUserInfoDataSourceValue = new LightUserInfoDataSourceValue();
        lightUserInfoDataSourceValue.setNickName(watermarkUserModel.nickName);
        lightUserInfoDataSourceValue.setAvatarPath(watermarkUserModel.logoPath);
        lightUserInfoDataSourceValue.setSettlementTimeLabel(watermarkUserModel.settlementTimeLabel);
        lightUserInfoDataSourceValue.setGender(watermarkUserModel.gender);
        lightUserInfoDataSourceValue.setLocationLabel(watermarkUserModel.locationLabel);
        lightUserInfoDataSourceValue.setDescribeLabel(watermarkUserModel.describeLabel);
        lightUserInfoDataSourceValue.setConstellationLabel(watermarkUserModel.constellationLabel);
        lightUserInfoDataSourceValue.setMonthLabel(watermarkUserModel.monthLabel);
        lightUserInfoDataSourceValue.setDayLabel(watermarkUserModel.dayLabel);
        lightUserInfoDataSourceValue.setAgeLabel(watermarkUserModel.ageLabel);
        return lightUserInfoDataSourceValue;
    }

    @NotNull
    public static final WatermarkDateModel n(long j3) {
        return new WatermarkDateModel(j3, null, 2, null);
    }

    @NotNull
    public static final WatermarkPoiModel o(@NotNull LbsDataV2.PoiInfo poiInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Intrinsics.checkNotNullParameter(poiInfo, "<this>");
        String str11 = poiInfo.poiId;
        String str12 = "";
        if (str11 == null) {
            str = "";
        } else {
            str = str11;
        }
        String poiName = poiInfo.poiName;
        if (poiName == null) {
            str2 = "";
        } else {
            str2 = poiName;
        }
        int i3 = poiInfo.poiType;
        String str13 = poiInfo.poiTypeName;
        if (str13 == null) {
            str3 = "";
        } else {
            str3 = str13;
        }
        String str14 = poiInfo.poiDefaultName;
        if (str14 == null) {
            str4 = "";
        } else {
            str4 = str14;
        }
        String str15 = poiInfo.address;
        if (str15 == null) {
            str5 = "";
        } else {
            str5 = str15;
        }
        int i16 = poiInfo.districtCode;
        int i17 = poiInfo.distance;
        int i18 = poiInfo.hotValue;
        String str16 = poiInfo.phoneNumber;
        if (str16 == null) {
            str6 = "";
        } else {
            str6 = str16;
        }
        int i19 = poiInfo.poiOrderType;
        int i26 = poiInfo.poiNum;
        String str17 = poiInfo.dianPingId;
        if (str17 == null) {
            str7 = "";
        } else {
            str7 = str17;
        }
        String str18 = poiInfo.country;
        if (str18 == null) {
            str8 = "";
        } else {
            str8 = str18;
        }
        String str19 = poiInfo.province;
        if (str19 == null) {
            str9 = "";
        } else {
            str9 = str19;
        }
        String str20 = poiInfo.city;
        if (str20 == null) {
            str10 = "";
        } else {
            str10 = str20;
        }
        String str21 = poiInfo.district;
        if (str21 != null) {
            str12 = str21;
        }
        LbsDataV2.GpsInfo gpsInfo = poiInfo.gpsInfo;
        float f16 = (gpsInfo.lon * 1.0f) / 1000000.0f;
        float f17 = (gpsInfo.lat * 1.0f) / 1000000.0f;
        Intrinsics.checkNotNullExpressionValue(poiName, "poiName");
        return new WatermarkPoiModel(str5, str8, str9, str10, f16, f17, "", "", str12, "", poiName, str2, str, i3, str3, str4, i16, i17, i18, str6, i19, i26, str7, null, 8388608, null);
    }

    @NotNull
    public static final List<WatermarkPoiModel> p(@NotNull LbsDataV2.PoiList poiList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(poiList, "<this>");
        ArrayList<LbsDataV2.PoiInfo> poiInfos = poiList.poiInfos;
        Intrinsics.checkNotNullExpressionValue(poiInfos, "poiInfos");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(poiInfos, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (LbsDataV2.PoiInfo it : poiInfos) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(o(it));
        }
        return arrayList;
    }

    @NotNull
    public static final WatermarkPoiModelWrapper q(@Nullable LbsDataV2.PoiList poiList, int i3) {
        Object orNull;
        List emptyList;
        if (poiList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return new WatermarkPoiModelWrapper(null, -1, emptyList, null, 8, null);
        }
        List<WatermarkPoiModel> p16 = p(poiList);
        orNull = CollectionsKt___CollectionsKt.getOrNull(p16, i3);
        WatermarkPoiModel watermarkPoiModel = (WatermarkPoiModel) orNull;
        if (watermarkPoiModel == null) {
            i3 = -1;
        }
        return new WatermarkPoiModelWrapper(watermarkPoiModel, i3, p16, null, 8, null);
    }

    @NotNull
    public static final WatermarkUserModel r(@Nullable WinkUserInfo winkUserInfo) {
        if (winkUserInfo == null) {
            return new WatermarkUserModel(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        }
        return new WatermarkUserModel(winkUserInfo.getNickName(), winkUserInfo.getLogoLocalPath(), winkUserInfo.getSettlementTimeLabel(), winkUserInfo.getGender(), winkUserInfo.getLocationLabel(), winkUserInfo.getDescribeLabel(), winkUserInfo.getConstellationLabel(), winkUserInfo.getMonthLabel(), winkUserInfo.getDayLabel(), winkUserInfo.getAgeLabel(), null, 1024, null);
    }
}
