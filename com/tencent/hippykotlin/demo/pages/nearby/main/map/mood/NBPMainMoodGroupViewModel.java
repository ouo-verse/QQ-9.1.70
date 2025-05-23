package com.tencent.hippykotlin.demo.pages.nearby.main.map.mood;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQContext;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerRect;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceConfig;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceUIConfig;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.weiyun.poi.PoiDbManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import o25.f;
import p25.a;
import w25.c;
import w25.g;

/* loaded from: classes31.dex */
public final class NBPMainMoodGroupViewModel extends NBPMainBaseViewModel {
    public final long STABILITY_THRESHOLD;
    public CameraPosition currentCameraPosition;
    public int currentRequestId;
    public String currentThemeId;
    public boolean firstPositionChangeFinish;
    public boolean hadOnMapCameraChangedFinish;
    public List<NBPMapMarker> lastMarkers;
    public long lastUpdateTime;
    public boolean mapThemesLoaded;
    public MarkerRect markerRect;
    public boolean moodEntranceDidLayout;
    public NBPMoodGroupEntranceMarkerViewModel moodGroupMarkerVM;
    public boolean needFetchMoodGroupEntranceWhenAppear;
    public final int numRectHorizontal;
    public final int numRectVertical;
    public final float rectHeight;
    public final float rectWidth;
    public final Set<MarkerRect> rectangles;

    public NBPMainMoodGroupViewModel() {
        List<NBPMapMarker> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.lastMarkers = emptyList;
        this.STABILITY_THRESHOLD = 50L;
        this.rectWidth = 180.0f;
        this.rectHeight = 91.0f;
        QQContext qQContext = QQContext.INSTANCE;
        float f16 = 40;
        this.numRectHorizontal = (int) ((qQContext.getPageData().m() - 180.0f) / f16);
        float f17 = 2;
        this.numRectVertical = (int) (((qQContext.getPageData().l() / f17) - 200) / f16);
        this.rectangles = new LinkedHashSet();
        this.markerRect = MarkerRect.Companion.createRectWithSize((qQContext.getPageData().m() - 180.0f) / f17, 150.0f, 180.0f, 91.0f);
    }

    public final int countMarkersInRect(MarkerRect markerRect, List<NBPMapMarker> list) {
        boolean contains$default;
        boolean contains$default2;
        int i3 = 0;
        for (NBPMapMarker nBPMapMarker : list) {
            float f16 = 2;
            float width = nBPMapMarker.screenX - (nBPMapMarker.markerViewSize.getWidth() / f16);
            float height = nBPMapMarker.screenY - (nBPMapMarker.markerViewSize.getHeight() / f16);
            MarkerRect markerRect2 = new MarkerRect(width, height, nBPMapMarker.markerViewSize.getWidth() + width, nBPMapMarker.markerViewSize.getHeight() + height);
            float max = Math.max(markerRect.left, markerRect2.left);
            float max2 = Math.max(markerRect.top, markerRect2.top);
            float min = Math.min(markerRect.right, markerRect2.right);
            float min2 = Math.min(markerRect.bottom, markerRect2.bottom);
            if ((((min <= max || min2 <= max2) ? null : new MarkerRect(max, max2, min, min2)) == null ? 0.0d : (r9.width * r9.height) / (markerRect2.width * markerRect2.height)) > 0.001d) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) nBPMapMarker.key, (CharSequence) QCircleDaTongConstant.ElementParamValue.OPERATION, false, 2, (Object) null);
                if (contains$default) {
                    return 99;
                }
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) nBPMapMarker.key, (CharSequence) PoiDbManager.TBL_POI, false, 2, (Object) null);
                if (contains$default2) {
                    return 99;
                }
                i3++;
            }
        }
        return i3;
    }

    public final void fetchMoodGroupEntrance(final boolean z16) {
        final String str = this.currentThemeId;
        if (str == null) {
            KLog.INSTANCE.i("NBPMainMoodGroupViewModel", "fetchMoodGroupEntrance, themeId is null");
            return;
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.mood.NBPMainMoodGroupViewModel$fetchMoodGroupEntrance$fetchTask$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                final NBPMainMoodGroupViewModel nBPMainMoodGroupViewModel = NBPMainMoodGroupViewModel.this;
                final int i3 = nBPMainMoodGroupViewModel.currentRequestId + 1;
                nBPMainMoodGroupViewModel.currentRequestId = i3;
                String str2 = str;
                final boolean z17 = z16;
                Integer findMid = nBPMainMoodGroupViewModel.findMid(str2);
                KLog kLog = KLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[innerFetchMoodGroupEntrance] themeId: ");
                sb5.append(str2);
                sb5.append(", mid: ");
                sb5.append(findMid);
                sb5.append(", requestId: ");
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(sb5, i3, kLog, "NBPMainMoodGroupViewModel");
                if (findMid != null) {
                    final CameraPosition cameraPosition = nBPMainMoodGroupViewModel.currentCameraPosition;
                    if (cameraPosition == null) {
                        kLog.i("NBPMainMoodGroupViewModel", "[innerFetchMoodGroupEntrance], currentCameraPosition is null");
                    } else {
                        int intValue = findMid.intValue();
                        final Function1<c, Unit> function1 = new Function1<c, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.mood.NBPMainMoodGroupViewModel$innerFetchMoodGroupEntrance$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Removed duplicated region for block: B:54:0x029b  */
                            /* JADX WARN: Removed duplicated region for block: B:71:0x0260  */
                            /* JADX WARN: Removed duplicated region for block: B:72:0x026a  */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(c cVar) {
                                CameraPosition cameraPosition2;
                                MarkerRect markerRect;
                                String str3;
                                float f16;
                                float f17;
                                e m3;
                                NBPMoodGroupEntranceConfig nBPMoodGroupEntranceConfig;
                                float f18;
                                NBPMapMarker nBPMapMarker;
                                g gVar;
                                a aVar;
                                g gVar2;
                                a aVar2;
                                g gVar3;
                                w25.a aVar3;
                                w25.a aVar4;
                                w25.a aVar5;
                                c cVar2 = cVar;
                                if (NBPMainMoodGroupViewModel.this.currentRequestId != i3) {
                                    KLog kLog2 = KLog.INSTANCE;
                                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mid had changed return: ");
                                    m16.append(NBPMainMoodGroupViewModel.this.currentRequestId);
                                    m16.append(", ");
                                    ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m16, i3, kLog2, "NBPMainMoodGroupViewModel");
                                } else {
                                    KLog kLog3 = KLog.INSTANCE;
                                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[fetchMoodGroupEntrance]: ");
                                    m17.append(z17);
                                    m17.append(", moodName: ");
                                    m17.append((cVar2 == null || (aVar5 = cVar2.f444475d) == null) ? null : Integer.valueOf(aVar5.f444465d));
                                    m17.append(", ");
                                    m17.append((cVar2 == null || (aVar4 = cVar2.f444475d) == null) ? null : aVar4.H);
                                    m17.append(", ");
                                    m17.append((cVar2 == null || (aVar3 = cVar2.f444475d) == null) ? null : aVar3.f444467f);
                                    m17.append(", ");
                                    m17.append(((cVar2 == null || (gVar3 = cVar2.f444476e) == null) ? null : gVar3.f444489e) != null);
                                    m17.append(", ");
                                    m17.append((cVar2 == null || (gVar2 = cVar2.f444476e) == null || (aVar2 = gVar2.f444489e) == null) ? null : aVar2.D);
                                    m17.append(", ");
                                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m17, (cVar2 == null || (gVar = cVar2.f444476e) == null || (aVar = gVar.f444489e) == null) ? null : aVar.C, kLog3, "NBPMainMoodGroupViewModel");
                                    if (z17) {
                                        kLog3.i("NBPMainMoodGroupViewModel", "updateFromExitMoodGroup");
                                        NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel = NBPMainMoodGroupViewModel.this.moodGroupMarkerVM;
                                        if (nBPMoodGroupEntranceMarkerViewModel != null) {
                                            nBPMoodGroupEntranceMarkerViewModel.autoJoinedMood$delegate.setValue(nBPMoodGroupEntranceMarkerViewModel, NBPMoodGroupEntranceMarkerViewModel.$$delegatedProperties[0], Boolean.TRUE);
                                        }
                                    } else {
                                        NBPMainMoodGroupViewModel nBPMainMoodGroupViewModel2 = NBPMainMoodGroupViewModel.this;
                                        nBPMainMoodGroupViewModel2.moodEntranceDidLayout = true;
                                        CameraPosition cameraPosition3 = cameraPosition;
                                        MarkerRect markerRect2 = nBPMainMoodGroupViewModel2.markerRect;
                                        NBPMoodGroupEntranceMarkerViewModel.Companion.getClass();
                                        if (cVar2 == null) {
                                            kLog3.i("NBPMoodGroupEntranceMarkerViewModel", "[generateMarker]: GetEntranceRsp null");
                                        } else {
                                            w25.a aVar6 = cVar2.f444475d;
                                            if (aVar6 == null) {
                                                kLog3.i("NBPMoodGroupEntranceMarkerViewModel", "[generateMarker]: entrance null");
                                            } else {
                                                if ((markerRect2 != null ? Float.valueOf(markerRect2.width) : null) != null && markerRect2.width >= 100.0f) {
                                                    StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[generateMarker]: markerRect info: centerX: ");
                                                    m18.append(markerRect2.getCenterX());
                                                    m18.append(", centerY: ");
                                                    m18.append(markerRect2.getCenterY());
                                                    m18.append(", size:(");
                                                    m18.append(markerRect2.width);
                                                    m18.append(", ");
                                                    m18.append(markerRect2.height);
                                                    m18.append(')');
                                                    kLog3.i("NBPMoodGroupEntranceMarkerViewModel", m18.toString());
                                                    String str4 = aVar6.F;
                                                    if (str4.length() == 0) {
                                                        kLog3.e("NBPMoodGroupEntranceConfig", "parseFromAttachConfig jsonStr is empty");
                                                        cameraPosition2 = cameraPosition3;
                                                        markerRect = markerRect2;
                                                    } else {
                                                        try {
                                                            e eVar = new e(str4);
                                                            e m19 = eVar.m("backgroundConfig");
                                                            e m26 = m19 != null ? m19.m("background") : null;
                                                            if (m26 == null || (str3 = m26.p("src")) == null) {
                                                                str3 = "";
                                                            }
                                                            if (str3.length() > 0) {
                                                                cameraPosition2 = cameraPosition3;
                                                                if (m26 != null) {
                                                                    markerRect = markerRect2;
                                                                    f18 = (float) m26.i("height", 1.0d);
                                                                } else {
                                                                    markerRect = markerRect2;
                                                                    f18 = 1.0f;
                                                                }
                                                                float i16 = m26 != null ? (float) m26.i("width", 1.0d) : 1.0f;
                                                                com.tencent.kuikly.core.manager.c cVar3 = com.tencent.kuikly.core.manager.c.f117352a;
                                                                float l3 = cVar3.g().getPageData().l() / f18;
                                                                float l16 = cVar3.g().getPageData().l();
                                                                float f19 = l3 * i16;
                                                                kLog3.i("NBPMoodGroupEntranceConfig", "\u60c5\u7eea\u80cc\u666f\u9884\u52a0\u8f7d " + str3 + ", " + f19 + 'x' + l16);
                                                                f17 = l16;
                                                                f16 = f19;
                                                            } else {
                                                                cameraPosition2 = cameraPosition3;
                                                                markerRect = markerRect2;
                                                                f16 = 0.0f;
                                                                f17 = 0.0f;
                                                            }
                                                            m3 = eVar.m("entranceConfig");
                                                        } catch (Exception e16) {
                                                            cameraPosition2 = cameraPosition3;
                                                            markerRect = markerRect2;
                                                            KLog kLog4 = KLog.INSTANCE;
                                                            StringBuilder m27 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("parseFromAttachConfig parse json error: ");
                                                            m27.append(e16.getMessage());
                                                            kLog4.e("NBPMoodGroupEntranceConfig", m27.toString());
                                                        }
                                                        if (m3 == null) {
                                                            kLog3.e("NBPMoodGroupEntranceConfig", "parseFromAttachConfig entranceConfig is null");
                                                        } else {
                                                            nBPMoodGroupEntranceConfig = new NBPMoodGroupEntranceConfig(m3.q("iconUrl", ""), m3.q("iconBgUrl", ""), (float) m3.i("aggregateLevel", 0.5d), m3.g("isMoodEntryAdaptive", true), str3, f16, f17);
                                                            if (nBPMoodGroupEntranceConfig != null) {
                                                                KLog.INSTANCE.i("NBPMoodGroupEntranceMarkerViewModel", "[generateMarker]: NBPMoodGroupEntranceConfig null");
                                                            } else {
                                                                NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel2 = new NBPMoodGroupEntranceMarkerViewModel(aVar6, cVar2, nBPMoodGroupEntranceConfig, cameraPosition2, markerRect);
                                                                NBPLatLng nBPLatLng = nBPMoodGroupEntranceMarkerViewModel2.position;
                                                                Intrinsics.checkNotNull(nBPLatLng);
                                                                nBPMapMarker = new NBPMapMarker(nBPLatLng, (Function1) nBPMoodGroupEntranceMarkerViewModel2.viewBuilder$delegate.getValue(), nBPMoodGroupEntranceMarkerViewModel2, nBPMoodGroupEntranceMarkerViewModel2.key, nBPMoodGroupEntranceMarkerViewModel2.zIndex, NBPMoodGroupEntranceUIConfig.size, nBPMoodGroupEntranceMarkerViewModel2, nBPMoodGroupEntranceMarkerViewModel2);
                                                                if (nBPMapMarker != null) {
                                                                    NBPMainMoodGroupViewModel nBPMainMoodGroupViewModel3 = NBPMainMoodGroupViewModel.this;
                                                                    Object obj = nBPMapMarker.data;
                                                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerViewModel");
                                                                    nBPMainMoodGroupViewModel3.moodGroupMarkerVM = (NBPMoodGroupEntranceMarkerViewModel) obj;
                                                                    NBPViewModelStoreKt.getMarkersViewModel(NBPMainKtxKt.getVmStore()).addMarker(nBPMapMarker);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    nBPMoodGroupEntranceConfig = null;
                                                    if (nBPMoodGroupEntranceConfig != null) {
                                                    }
                                                } else {
                                                    kLog3.i("NBPMoodGroupEntranceMarkerViewModel", "[generateMarker]: markerRect null or size error");
                                                }
                                            }
                                        }
                                        nBPMapMarker = null;
                                        if (nBPMapMarker != null) {
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        kLog.i("NBPMainMoodGroupRepo", "start fetchMoodGroupEntrance, moodId: " + intValue);
                        GetMoodGroupEntranceReq getMoodGroupEntranceReq = new GetMoodGroupEntranceReq(intValue);
                        Function1<PbResponse<c>, Unit> function12 = new Function1<PbResponse<c>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.mood.NBPMainMoodGroupRepo$fetchMoodGroupEntrance$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PbResponse<c> pbResponse) {
                                w25.a aVar;
                                w25.a aVar2;
                                PbResponse<c> pbResponse2 = pbResponse;
                                KLog kLog2 = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("finish fetchMoodGroupEntrance, code: ");
                                m3.append(pbResponse2.code);
                                m3.append(", msg: ");
                                m3.append(pbResponse2.f114187msg);
                                m3.append(", bgUrl: ");
                                c cVar = pbResponse2.rsp;
                                String str3 = null;
                                m3.append((cVar == null || (aVar2 = cVar.f444475d) == null) ? null : aVar2.f444468h);
                                m3.append(", small: ");
                                c cVar2 = pbResponse2.rsp;
                                if (cVar2 != null && (aVar = cVar2.f444475d) != null) {
                                    str3 = aVar.G;
                                }
                                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, str3, kLog2, "NBPMainMoodGroupRepo");
                                function1.invoke(pbResponse2.rsp);
                                return Unit.INSTANCE;
                            }
                        };
                        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.mood_svr.MoodSvr.SsoGetEntrance");
                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getMoodGroupEntranceReq, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
                    }
                }
                NBPMainMoodGroupViewModel.this.getClass();
                return Unit.INSTANCE;
            }
        };
        Integer findMid = findMid(str);
        if (this.currentCameraPosition != null && this.firstPositionChangeFinish && (this.mapThemesLoaded || findMid == null || findMid.intValue() != 0)) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[fetchMoodGroupEntrance] start fetch task, ");
            m3.append(this.mapThemesLoaded);
            m3.append(", ");
            m3.append(findMid);
            m3.append(", ");
            m3.append(this.currentCameraPosition != null);
            m3.append(", ");
            m3.append(this.firstPositionChangeFinish);
            kLog.i("NBPMainMoodGroupViewModel", m3.toString());
            function0.invoke();
            return;
        }
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[fetchMoodGroupEntrance] lazy task, ");
        m16.append(this.mapThemesLoaded);
        m16.append(", ");
        m16.append(findMid);
        m16.append(", ");
        m16.append(this.currentCameraPosition != null);
        m16.append(", ");
        AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(m16, this.firstPositionChangeFinish, kLog2, "NBPMainMoodGroupViewModel");
    }

    public final Integer findMid(String str) {
        if (str.length() == 0) {
            return 0;
        }
        f theme = NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getVmStore()).getTheme(str);
        if (theme != null) {
            if (theme.H) {
                return 0;
            }
            int i3 = theme.N;
            if (i3 != 0) {
                return Integer.valueOf(i3);
            }
        }
        return null;
    }

    public final MarkerRect findMinMarkersRect(Set<MarkerRect> set, List<NBPMapMarker> list) {
        Object obj;
        Iterator<T> it = set.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int countMarkersInRect = countMarkersInRect((MarkerRect) next, list);
                do {
                    Object next2 = it.next();
                    int countMarkersInRect2 = countMarkersInRect((MarkerRect) next2, list);
                    if (countMarkersInRect > countMarkersInRect2) {
                        next = next2;
                        countMarkersInRect = countMarkersInRect2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        MarkerRect markerRect = (MarkerRect) obj;
        if (markerRect != null) {
            return markerRect;
        }
        float m3 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(com.tencent.kuikly.core.manager.c.f117352a);
        float f16 = this.rectWidth;
        float f17 = (m3 - f16) / 2;
        return new MarkerRect(f17, 150.0f, f16 + f17, this.rectHeight + 150.0f);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onFetchMaker(int i3, String str) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("[onFetchMaker]: ", i3, ", ", str, ", ");
        m3.append(this.mapThemesLoaded);
        m3.append(", ");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, this.currentThemeId, kLog, "NBPMainMoodGroupViewModel");
        if (i3 <= 1 && !Intrinsics.areEqual(this.currentThemeId, str)) {
            this.currentThemeId = str;
            fetchMoodGroupEntrance(false);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onFirstPositionChangeFinish() {
        KLog kLog = KLog.INSTANCE;
        kLog.i("NBPMainMoodGroupViewModel", "[onFirstPositionChangeFinish]");
        this.markerRect = findMinMarkersRect(this.rectangles, this.lastMarkers);
        this.firstPositionChangeFinish = true;
        StringBuilder m3 = NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(this.lastMarkers, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("final markers size\uff1a"), ", markerRect: ");
        m3.append(this.markerRect);
        kLog.i("NBPMainMoodGroupViewModel", m3.toString());
        fetchMoodGroupEntrance(false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapCameraChangedFinish(CameraPosition cameraPosition) {
        KLog.INSTANCE.i("NBPMainMoodGroupViewModel", "[NBPMainMoodGroupViewModel], onMapCameraChangedFinish");
        if (!this.hadOnMapCameraChangedFinish) {
            this.hadOnMapCameraChangedFinish = true;
            fetchMoodGroupEntrance(false);
        }
        this.currentCameraPosition = cameraPosition;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapThemesLoaded() {
        KLog.INSTANCE.i("NBPMainMoodGroupViewModel", "[onMapThemesLoaded]");
        this.mapThemesLoaded = true;
        fetchMoodGroupEntrance(false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMarkersDisplayed(List<NBPMapMarker> list) {
        long NBPCurrentTime = APICallTechReporterKt.NBPCurrentTime();
        if (this.moodEntranceDidLayout) {
            return;
        }
        if (this.lastUpdateTime == 0) {
            this.lastUpdateTime = NBPCurrentTime;
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("lastUpdateTime: ");
        m3.append(this.lastUpdateTime);
        m3.append(", currentTime: ");
        m3.append(NBPCurrentTime);
        m3.append(" , result: ");
        m3.append(NBPCurrentTime - this.lastUpdateTime);
        kLog.i("NBPMainMoodGroupViewModel", m3.toString());
        if (NBPCurrentTime - this.lastUpdateTime >= this.STABILITY_THRESHOLD && list.size() >= 5) {
            this.lastMarkers = list;
            kLog.i("NBPMainMoodGroupViewModel", "update markerRect");
            this.markerRect = findMinMarkersRect(this.rectangles, list);
        } else {
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("markers size didn't change or to small, or Waiting for markers to stabilize, ignore this time. received markers size: ");
            m16.append(list.size());
            kLog.i("NBPMainMoodGroupViewModel", m16.toString());
            this.lastUpdateTime = NBPCurrentTime;
            this.lastMarkers = list;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPageDidAppear() {
        int i3 = 0;
        int i16 = 1;
        if (this.needFetchMoodGroupEntranceWhenAppear) {
            KLog.INSTANCE.i("NBPMainMoodGroupViewModel", "[onPageDidAppear], needFetchMoodGroupEntranceWhenAppear");
            fetchMoodGroupEntrance(true);
            this.needFetchMoodGroupEntranceWhenAppear = false;
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("numRectVertical:");
        m3.append(this.numRectVertical);
        m3.append(", numRectHorizontal:");
        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, this.numRectHorizontal, kLog, "NBPMainMoodGroupViewModel");
        Set<MarkerRect> set = this.rectangles;
        float f16 = 2;
        float m16 = (GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(com.tencent.kuikly.core.manager.c.f117352a) - this.rectWidth) / f16;
        int i17 = (this.numRectHorizontal / 2) + 1;
        while (i3 < i17) {
            float f17 = 40.0f;
            float f18 = i3 * 40.0f;
            float f19 = m16 + f18;
            set.add(new MarkerRect(f19, 200.0f, this.rectWidth + f19, this.rectHeight + 200.0f));
            float f26 = m16 - f18;
            set.add(new MarkerRect(f26, 200.0f, this.rectWidth + f26, this.rectHeight + 200.0f));
            set.add(new MarkerRect(f19, 160.0f, this.rectWidth + f19, this.rectHeight + 160.0f));
            set.add(new MarkerRect(f26, 160.0f, this.rectWidth + f26, this.rectHeight + 160.0f));
            set.add(new MarkerRect(f19, 120.0f, this.rectWidth + f19, this.rectHeight + 120.0f));
            set.add(new MarkerRect(f26, 120.0f, this.rectWidth + f26, this.rectHeight + 120.0f));
            int i18 = this.numRectVertical;
            int i19 = i16;
            while (i19 < i18) {
                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                float f27 = i19 * f17;
                float l3 = (cVar.g().getPageData().l() / f16) + f27;
                set.add(new MarkerRect(f19, l3, this.rectWidth + f19, this.rectHeight + l3));
                float l16 = (cVar.g().getPageData().l() / f16) + f27;
                set.add(new MarkerRect(f26, l16, this.rectWidth + f26, this.rectHeight + l16));
                i19++;
                f17 = 40.0f;
            }
            i3++;
            i16 = 1;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerCreated() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerWillDestroy() {
    }
}
