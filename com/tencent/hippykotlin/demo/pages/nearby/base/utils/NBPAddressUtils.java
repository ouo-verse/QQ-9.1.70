package com.tencent.hippykotlin.demo.pages.nearby.base.utils;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.NetworkModule;
import com.tencent.kuikly.core.module.NetworkResponse;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPAddressUtils {
    public static final NBPAddressUtils INSTANCE = new NBPAddressUtils();
    public static final List<String> specialCities;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("\u4e1c\u4eac");
        specialCities = listOf;
    }

    public final String firstNotEmpty(String... strArr) {
        for (String str : strArr) {
            if (str.length() > 0) {
                return str;
            }
        }
        return "";
    }

    public final void geo2Address(final double d16, final double d17, final Function1<? super NBPSsoLocation, Unit> function1) {
        KLog.INSTANCE.i("NBPAddressUtils", "geo2Address: lat02 = " + d16 + ", lon02 = " + d17);
        final Function1<e, Unit> function12 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.utils.NBPAddressUtils$geo2Address$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                e eVar2 = eVar;
                if (eVar2 == null) {
                    KLog.INSTANCE.e("NBPAddressUtils", "geo2Address: result is null");
                    function1.invoke(null);
                } else {
                    e m3 = eVar2.m("address_component");
                    if (m3 == null) {
                        KLog.INSTANCE.e("NBPAddressUtils", "geo2Address: address_component is null");
                        function1.invoke(null);
                    } else {
                        String p16 = eVar2.p("address");
                        String p17 = m3.p("nation");
                        String p18 = m3.p("province");
                        String p19 = m3.p("district");
                        String p26 = m3.p("street");
                        String p27 = m3.p("street_number");
                        String p28 = m3.p("city");
                        e m16 = eVar2.m("formatted_addresses");
                        String str7 = "";
                        if (m16 == null || (str = m16.p("recommend")) == null) {
                            str = "";
                        }
                        e m17 = eVar2.m(QAdVrReport.ElementID.AD_INFO);
                        if (m17 != null) {
                            str2 = p17.length() == 0 ? m17.p("nation") : p28;
                            if (str2.length() == 0) {
                                str2 = m17.p("city");
                            }
                            if (p18.length() == 0) {
                                str2 = m17.p("province");
                            }
                            if (p19.length() == 0) {
                                str2 = m17.p("district");
                            }
                            if (p16.length() == 0) {
                                p16 = m17.p("name");
                            }
                            str7 = m17.p("city_code");
                        } else {
                            str2 = p28;
                        }
                        String str8 = str7;
                        String str9 = str2;
                        if (!(str2.length() == 0)) {
                            str3 = str8;
                            str4 = p16;
                            str5 = p26;
                            str6 = str9;
                        } else if (Intrinsics.areEqual(p17, CountrySelectView.NAME_CHINA)) {
                            str5 = p26;
                            str3 = str8;
                            str4 = p16;
                            str6 = NBPAddressUtils.INSTANCE.firstNotEmpty(p18, p19, p17);
                        } else {
                            str5 = p26;
                            NBPAddressUtils nBPAddressUtils = NBPAddressUtils.INSTANCE;
                            String p29 = m3.p("locality");
                            String p36 = m3.p("ad_level_2");
                            String p37 = m3.p("ad_level_1");
                            str3 = str8;
                            if (NBPAddressUtils.specialCities.contains(p37)) {
                                str4 = p16;
                                str6 = p37;
                            } else {
                                str4 = p16;
                                str6 = nBPAddressUtils.firstNotEmpty(p29, p36, p37, p17, "\u9644\u8fd1");
                            }
                        }
                        if (str.length() == 0) {
                            if (Intrinsics.areEqual(p17, CountrySelectView.NAME_CHINA)) {
                                str = NBPAddressUtils.INSTANCE.firstNotEmpty(p27, p19, str6, p18, p17);
                            } else {
                                str = NBPAddressUtils.INSTANCE.firstNotEmpty(m3.p("ad_level_5"), m3.p("ad_level_4"), m3.p("ad_level_3"), m3.p("ad_level_2"), m3.p("ad_level_1"), m3.p("locality"), p17, "\u672a\u77e5\u5730\u70b9");
                            }
                        }
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("geo2Address: lat02 = ");
                        m18.append(d16);
                        m18.append(", lon02 = ");
                        m18.append(d17);
                        m18.append(", name = ");
                        m18.append(str);
                        String str10 = str4;
                        String str11 = str3;
                        StringBuilder m19 = VasBusinessReportData$$ExternalSyntheticOutline0.m(VasBusinessReportData$$ExternalSyntheticOutline0.m(VasBusinessReportData$$ExternalSyntheticOutline0.m(m18, ", address = ", str10, ", nation = ", p17), ", province = ", p18, ", city = ", str6), ", cityCode = ", str11, ", district = ", p19);
                        m19.append(", street = ");
                        m19.append(str5);
                        m19.append(", streetNo = ");
                        m19.append(p27);
                        kLog.i("NBPAddressUtils", m19.toString());
                        Function1<NBPSsoLocation, Unit> function13 = function1;
                        NBPSsoLocation nBPSsoLocation = new NBPSsoLocation();
                        double d18 = d16;
                        double d19 = d17;
                        nBPSsoLocation.lat02 = d18;
                        nBPSsoLocation.lon02 = d19;
                        nBPSsoLocation.name = str;
                        nBPSsoLocation.address = str10;
                        nBPSsoLocation.nation = p17;
                        nBPSsoLocation.province = p18;
                        nBPSsoLocation.city = str6;
                        nBPSsoLocation.cityCode = str11;
                        nBPSsoLocation.district = p19;
                        nBPSsoLocation.street = str5;
                        nBPSsoLocation.streetNo = p27;
                        function13.invoke(nBPSsoLocation);
                    }
                }
                return Unit.INSTANCE;
            }
        };
        NetworkModule networkModule = (NetworkModule) c.f117352a.g().acquireModule("KRNetworkModule");
        String syncToNativeMethod = QQNearbyModule.Companion.getInstance().syncToNativeMethod("getTencentMapKey", (e) null, (Function1<? super e, Unit>) null);
        if (syncToNativeMethod.length() == 0) {
            syncToNativeMethod = "I6ZBZ-SVI3L-TDGPI-EC2MP-KVTEJ-CCFLL";
        }
        networkModule.g("https://apis.map.qq.com/ws/geocoder/v1/?location=" + d16 + ',' + d17 + "&key=" + syncToNativeMethod, new e(), new Function4<e, Boolean, String, NetworkResponse, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.utils.NBPAddressUtils$callWSGeocoderAPI$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(e eVar, Boolean bool, String str, NetworkResponse networkResponse) {
                e eVar2 = eVar;
                boolean booleanValue = bool.booleanValue();
                KLog kLog = KLog.INSTANCE;
                kLog.i("NBPAddressUtils", "callWSGeocoderAPI: success: " + booleanValue + ", msg: " + str + ", result: " + eVar2);
                int j3 = eVar2.j("status");
                if (j3 != 0) {
                    StringBuilder m3 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("callWSGeocoderAPI, status: ", j3, ", msg: ");
                    m3.append(eVar2.p("message"));
                    kLog.i("NBPAddressUtils", m3.toString());
                    function12.invoke(null);
                } else {
                    e m16 = eVar2.m("result");
                    if (m16 == null) {
                        kLog.i("NBPAddressUtils", "callWSGeocoderAPI, result json is null");
                        function12.invoke(null);
                    } else {
                        function12.invoke(m16);
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }
}
