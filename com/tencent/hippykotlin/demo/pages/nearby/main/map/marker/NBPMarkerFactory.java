package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerUIConfig;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerUIConfig;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerViewModel;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.log.KLog;
import cooperation.qzone.util.WnsError;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o25.e;
import r25.b;
import r25.c;
import v25.a;
import v25.p;

/* loaded from: classes31.dex */
public final class NBPMarkerFactory {
    public static final NBPMarkerFactory INSTANCE = new NBPMarkerFactory();

    public final NBPMapMarker generateMapMarker(a aVar) {
        NBPFeedMarkerViewModel.Companion.getClass();
        NBPFeedMarkerViewModel nBPFeedMarkerViewModel = new NBPFeedMarkerViewModel(aVar);
        NBPLatLng nBPLatLng = nBPFeedMarkerViewModel.position;
        if (nBPLatLng == null) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("position is null when generate feedViewModel feed:");
            m3.append(aVar.f440824d);
            m3.append(" text:");
            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, aVar.f440827h, kLog, "NBPFeedMarkerViewModel");
            return null;
        }
        if (!nBPFeedMarkerViewModel.hasImage) {
            if (nBPFeedMarkerViewModel.title.length() == 0) {
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("no image & text when generate feedViewModel feed:");
                m16.append(aVar.f440824d);
                m16.append(" text:");
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m16, aVar.f440827h, kLog2, "NBPFeedMarkerViewModel");
                return null;
            }
        }
        Function1 function1 = (Function1) nBPFeedMarkerViewModel.viewBuilder$delegate.getValue();
        String str = nBPFeedMarkerViewModel.key;
        double doubleValue = ((Number) nBPFeedMarkerViewModel.zIndex$delegate.getValue()).doubleValue();
        NBPFeedMarkerUIConfig companion = NBPFeedMarkerUIConfig.Companion.getInstance();
        companion.getClass();
        return new NBPMapMarker(nBPLatLng, function1, nBPFeedMarkerViewModel, str, doubleValue, new w(companion.bubbleWidth, companion.bubbleHeight), nBPFeedMarkerViewModel, nBPFeedMarkerViewModel);
    }

    public final NBPMapMarker generateHostMapMarker(NBPLatLng nBPLatLng) {
        List mutableListOf;
        NBPHostMarkerViewModel.Companion companion = NBPHostMarkerViewModel.Companion;
        NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
        long j3 = userSelfInfo.tid;
        e eVar = new e((float) nBPLatLng.latitude, (float) nBPLatLng.longitude, 4);
        String str = userSelfInfo.nickName;
        String str2 = userSelfInfo.avatarUrl;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new b(1001, new c(userSelfInfo.avatarDressBorderUrl, 23), 2));
        p pVar = new p(j3, eVar, str, str2, mutableListOf, WnsError.WNS_CODE_LOGIN_SID_ILLEGAL);
        NBPHostMarkerViewModel nBPHostMarkerViewModel = new NBPHostMarkerViewModel(pVar);
        NBPLatLng nBPLatLng2 = nBPHostMarkerViewModel.position;
        if (nBPLatLng2 == null) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("position is null when generate personViewModel tid:");
            m3.append(pVar.f440880d);
            m3.append(" text:");
            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, pVar.f440882f, kLog, "NBPFeedMarkerViewModel");
            return null;
        }
        Intrinsics.checkNotNull(nBPLatLng2);
        return new NBPMapMarker(nBPLatLng2, (Function1) nBPHostMarkerViewModel.viewBuilder$delegate.getValue(), nBPHostMarkerViewModel, nBPHostMarkerViewModel.key, nBPHostMarkerViewModel.zIndex, NBPHostMarkerUIConfig.size, nBPHostMarkerViewModel, nBPHostMarkerViewModel);
    }
}
