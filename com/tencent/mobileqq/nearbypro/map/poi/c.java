package com.tencent.mobileqq.nearbypro.map.poi;

import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.SearchResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.weiyun.poi.PoiDbManager;
import cooperation.qzone.LbsDataV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/poi/c;", "", "Lcooperation/qzone/LbsDataV2$PoiInfo;", PoiDbManager.TBL_POI, "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "c", "latLng", "", "type", "Lcooperation/qzone/LbsDataV2$GpsInfo;", "a", "Lcom/tencent/lbssearch/object/result/Geo2AddressResultObject$ReverseAddressResult;", "result", "d", "Lcom/tencent/lbssearch/object/result/SuggestionResultObject$SuggestionData;", "f", "Lcom/tencent/lbssearch/object/result/SearchResultObject$SearchResultData;", "e", "<init>", "()V", "qq_nearby_pro_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f253579a = new c();

    c() {
    }

    public static /* synthetic */ LbsDataV2.GpsInfo b(c cVar, LatLng latLng, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return cVar.a(latLng, i3);
    }

    public final LbsDataV2.GpsInfo a(LatLng latLng, int type) {
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        LbsDataV2.GpsInfo gpsInfo = new LbsDataV2.GpsInfo();
        double d16 = 1000000;
        gpsInfo.lat = (int) (latLng.latitude * d16);
        gpsInfo.lon = (int) (latLng.longitude * d16);
        gpsInfo.gpsType = type;
        return gpsInfo;
    }

    public final LatLng c(LbsDataV2.PoiInfo poi) {
        Intrinsics.checkNotNullParameter(poi, "poi");
        LbsDataV2.GpsInfo gpsInfo = poi.gpsInfo;
        return new LatLng(gpsInfo.lat / 1000000.0d, gpsInfo.lon / 1000000.0d);
    }

    public final LbsDataV2.PoiInfo d(Geo2AddressResultObject.ReverseAddressResult result, LatLng latLng) {
        String str;
        int i3;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        Geo2AddressResultObject.ReverseAddressResult.FormatterAddress formatterAddress = result.formatted_addresses;
        if (formatterAddress == null) {
            str = result.address;
        } else {
            str = formatterAddress.recommend;
        }
        poiInfo.poiId = "";
        poiInfo.poiName = str;
        poiInfo.poiType = 0;
        poiInfo.poiTypeName = "";
        poiInfo.poiDefaultName = str;
        poiInfo.address = result.address;
        String adcode = result.ad_info.adcode;
        if (adcode != null) {
            Intrinsics.checkNotNullExpressionValue(adcode, "adcode");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(adcode);
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
                poiInfo.districtCode = i3;
                poiInfo.distance = 0;
                AdInfo adInfo = result.ad_info;
                poiInfo.country = adInfo.nation;
                poiInfo.province = adInfo.province;
                poiInfo.city = adInfo.city;
                poiInfo.district = adInfo.district;
                poiInfo.gpsInfo = b(f253579a, latLng, 0, 2, null);
                return poiInfo;
            }
        }
        i3 = 0;
        poiInfo.districtCode = i3;
        poiInfo.distance = 0;
        AdInfo adInfo2 = result.ad_info;
        poiInfo.country = adInfo2.nation;
        poiInfo.province = adInfo2.province;
        poiInfo.city = adInfo2.city;
        poiInfo.district = adInfo2.district;
        poiInfo.gpsInfo = b(f253579a, latLng, 0, 2, null);
        return poiInfo;
    }

    public final LbsDataV2.PoiInfo e(SearchResultObject.SearchResultData result) {
        int i3;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(result, "result");
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        poiInfo.poiId = result.f118548id;
        String str = result.title;
        poiInfo.poiName = str;
        poiInfo.poiType = 0;
        poiInfo.poiTypeName = "";
        poiInfo.poiDefaultName = str;
        poiInfo.address = result.address;
        String adcode = result.ad_info.adcode;
        if (adcode != null) {
            Intrinsics.checkNotNullExpressionValue(adcode, "adcode");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(adcode);
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
                poiInfo.districtCode = i3;
                poiInfo.distance = (int) result.distance;
                AdInfo adInfo = result.ad_info;
                poiInfo.country = adInfo.nation;
                poiInfo.province = adInfo.province;
                poiInfo.city = adInfo.city;
                poiInfo.district = adInfo.district;
                c cVar = f253579a;
                LatLng latLng = result.latLng;
                Intrinsics.checkNotNullExpressionValue(latLng, "result.latLng");
                poiInfo.gpsInfo = b(cVar, latLng, 0, 2, null);
                poiInfo.phoneNumber = result.tel;
                return poiInfo;
            }
        }
        i3 = 0;
        poiInfo.districtCode = i3;
        poiInfo.distance = (int) result.distance;
        AdInfo adInfo2 = result.ad_info;
        poiInfo.country = adInfo2.nation;
        poiInfo.province = adInfo2.province;
        poiInfo.city = adInfo2.city;
        poiInfo.district = adInfo2.district;
        c cVar2 = f253579a;
        LatLng latLng2 = result.latLng;
        Intrinsics.checkNotNullExpressionValue(latLng2, "result.latLng");
        poiInfo.gpsInfo = b(cVar2, latLng2, 0, 2, null);
        poiInfo.phoneNumber = result.tel;
        return poiInfo;
    }

    public final LbsDataV2.PoiInfo f(SuggestionResultObject.SuggestionData result) {
        int i3;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(result, "result");
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        poiInfo.poiId = result.f118552id;
        String str = result.title;
        poiInfo.poiName = str;
        poiInfo.poiType = 0;
        poiInfo.poiTypeName = "";
        poiInfo.poiDefaultName = str;
        poiInfo.address = result.address;
        String adcode = result.adcode;
        if (adcode != null) {
            Intrinsics.checkNotNullExpressionValue(adcode, "adcode");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(adcode);
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
                poiInfo.districtCode = i3;
                poiInfo.distance = (int) result._distance;
                poiInfo.country = "";
                poiInfo.province = result.province;
                poiInfo.city = result.city;
                poiInfo.district = result.district;
                c cVar = f253579a;
                LatLng latLng = result.latLng;
                Intrinsics.checkNotNullExpressionValue(latLng, "result.latLng");
                poiInfo.gpsInfo = b(cVar, latLng, 0, 2, null);
                return poiInfo;
            }
        }
        i3 = 0;
        poiInfo.districtCode = i3;
        poiInfo.distance = (int) result._distance;
        poiInfo.country = "";
        poiInfo.province = result.province;
        poiInfo.city = result.city;
        poiInfo.district = result.district;
        c cVar2 = f253579a;
        LatLng latLng2 = result.latLng;
        Intrinsics.checkNotNullExpressionValue(latLng2, "result.latLng");
        poiInfo.gpsInfo = b(cVar2, latLng2, 0, 2, null);
        return poiInfo;
    }
}
