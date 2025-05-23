package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyFormatUtils;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.model.SsoGetPersonGeoRequest;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.i;
import n25.k;
import n25.l;
import n25.m;
import q25.g;
import r25.e;
import v25.a;
import v25.p;

/* loaded from: classes31.dex */
public final class NearbyFDPUserFeedTimelineItemViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedTimelineItemViewModel.class, "longitude", "getLongitude()Ljava/lang/Float;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedTimelineItemViewModel.class, "latitude", "getLatitude()Ljava/lang/Float;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedTimelineItemViewModel.class, "itemImageSrc", "getItemImageSrc()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedTimelineItemViewModel.class, "itemTitle", "getItemTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedTimelineItemViewModel.class, "timeInfo", "getTimeInfo()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedTimelineItemViewModel.class, "detailCreateTimeInfo", "getDetailCreateTimeInfo()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedTimelineItemViewModel.class, "visitedCountInfo", "getVisitedCountInfo()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedTimelineItemViewModel.class, "borderUrl", "getBorderUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedTimelineItemViewModel.class, "locationText", "getLocationText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedTimelineItemViewModel.class, "statusContentViewModel", "getStatusContentViewModel()Lcom/tencent/hippykotlin/demo/pages/nearby/feed_detail/view_model/UserFeedsCard/NearbyFDPStatusContentViewModel;", 0)};
    public final ReadWriteProperty borderUrl$delegate;
    public final ReadWriteProperty detailCreateTimeInfo$delegate;
    public a feed;
    public final Lazy fid$delegate;
    public final boolean fromFollowingTab;
    public final String fromThemeId;
    public final ReadWriteProperty itemImageSrc$delegate;
    public final ReadWriteProperty itemTitle$delegate;
    public final int itemType;
    public final ReadWriteProperty latitude$delegate;
    public final ReadWriteProperty locationText$delegate;
    public final ReadWriteProperty longitude$delegate;
    public p person;
    public final ReadWriteProperty statusContentViewModel$delegate;
    public l statusFeed;
    public final ReadWriteProperty timeInfo$delegate;
    public long tinyId;
    public final ReadWriteProperty visitedCountInfo$delegate;

    public /* synthetic */ NearbyFDPUserFeedTimelineItemViewModel(a aVar, l lVar, long j3, String str, boolean z16) {
        this(aVar, lVar, null, j3, str, z16);
    }

    public final String getFid() {
        return (String) this.fid$delegate.getValue();
    }

    public final NearbyFDPStatusContentViewModel getStatusContentViewModel() {
        return (NearbyFDPStatusContentViewModel) this.statusContentViewModel$delegate.getValue(this, $$delegatedProperties[9]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x01be, code lost:
    
        if ((r0.length() > 0) == true) goto L113;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0227  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refreshData() {
        a aVar;
        String str;
        g gVar;
        a aVar2;
        String str2;
        g gVar2;
        long j3;
        g gVar3;
        g gVar4;
        boolean z16;
        String str3;
        l lVar;
        long j16;
        long j17;
        String a16;
        UserDataManager userDataManager;
        l lVar2;
        a aVar3;
        long j18;
        e eVar;
        l lVar3;
        k kVar;
        String str4;
        List<m> list;
        List<m> list2;
        k kVar2;
        i iVar;
        o25.e eVar2;
        a aVar4 = this.feed;
        if (aVar4 != null && (eVar2 = aVar4.f440826f) != null) {
            setLongitude(Float.valueOf(eVar2.f421847e));
            setLatitude(Float.valueOf(eVar2.f421846d));
        }
        l lVar4 = this.statusFeed;
        if (lVar4 != null && (kVar2 = lVar4.C) != null && (iVar = kVar2.C) != null) {
            double d16 = 1000000;
            setLongitude(Float.valueOf((float) (iVar.f418080e / d16)));
            setLatitude(Float.valueOf((float) (iVar.f418079d / d16)));
        }
        a aVar5 = this.feed;
        boolean z17 = true;
        if (aVar5 != null && (list2 = aVar5.I) != null) {
            Iterator<m> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next.f418101h.length() > 0) {
                    this.borderUrl$delegate.setValue(this, $$delegatedProperties[7], next.f418101h);
                    break;
                }
            }
        }
        l lVar5 = this.statusFeed;
        if (lVar5 != null && (list = lVar5.J) != null) {
            Iterator<m> it5 = list.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                m next2 = it5.next();
                if (next2.f418101h.length() > 0) {
                    this.borderUrl$delegate.setValue(this, $$delegatedProperties[7], next2.f418101h);
                    break;
                }
            }
        }
        int i3 = this.itemType;
        Long l3 = null;
        String str5 = "";
        if (i3 == 1) {
            setItemTitle("\u5f53\u524d\u4f4d\u7f6e");
            setLocationText("\u5f53\u524d\u4f4d\u7f6e");
            setTimeInfo(" ");
            updatePerson(this.person);
            if (this.person == null) {
                final long j19 = this.tinyId;
                final Function1<v25.k, Unit> function1 = new Function1<v25.k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedTimelineItemViewModel$refreshData$5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v25.k kVar3) {
                        v25.k kVar4 = kVar3;
                        NearbyFDPUserFeedTimelineItemViewModel.this.updatePerson(kVar4 != null ? kVar4.f440862e : null);
                        return Unit.INSTANCE;
                    }
                };
                SsoGetPersonGeoRequest ssoGetPersonGeoRequest = new SsoGetPersonGeoRequest(j19);
                Function1<PbResponse<v25.k>, Unit> function12 = new Function1<PbResponse<v25.k>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.model.NearbySsoGetPersonGeoRequestModel$Companion$requestSsoGetPersonGeo$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(PbResponse<v25.k> pbResponse) {
                        PbResponse<v25.k> pbResponse2 = pbResponse;
                        if (pbResponse2.success) {
                            KLog kLog = KLog.INSTANCE;
                            NearbyConst nearbyConst = NearbyConst.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestSsoGetPersonGeo success tid:");
                            m3.append(j19);
                            kLog.i("feed_detail_page", m3.toString());
                        } else {
                            KLog kLog2 = KLog.INSTANCE;
                            NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestSsoGetPersonGeo failure tid:");
                            m16.append(j19);
                            m16.append(" code:");
                            m16.append(pbResponse2.code);
                            m16.append(", message:");
                            m16.append(pbResponse2.f114187msg);
                            m16.append('}');
                            kLog2.i("feed_detail_page", m16.toString());
                        }
                        function1.invoke(pbResponse2.rsp);
                        return Unit.INSTANCE;
                    }
                };
                APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.map_svr.Map.SsoGetPersonGeo");
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.sendPbRequest$default(ssoGetPersonGeoRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
            }
        } else if (i3 == 3) {
            setItemTitle("\u66f4\u591a");
            setLocationText("\u66f4\u591a");
            setTimeInfo(" ");
        } else {
            l lVar6 = this.statusFeed;
            if ((lVar6 == null || (gVar4 = lVar6.f418094f) == null || (str = gVar4.f428259f) == null) && ((aVar = this.feed) == null || (gVar = aVar.f440828i) == null || (str = gVar.f428259f) == null)) {
                str = "";
            }
            setItemTitle(str);
            l lVar7 = this.statusFeed;
            if ((lVar7 == null || (gVar3 = lVar7.f418094f) == null || (str2 = gVar3.f428260h) == null) && ((aVar2 = this.feed) == null || (gVar2 = aVar2.f440828i) == null || (str2 = gVar2.f428260h) == null)) {
                str2 = "";
            }
            ReadWriteProperty readWriteProperty = this.itemImageSrc$delegate;
            KProperty<?>[] kPropertyArr = $$delegatedProperties;
            readWriteProperty.setValue(this, kPropertyArr[2], str2);
            NearbyFormatUtils nearbyFormatUtils = NearbyFormatUtils.INSTANCE;
            l lVar8 = this.statusFeed;
            if (lVar8 != null) {
                j3 = lVar8.D;
            } else {
                j3 = this.feed != null ? r5.E : 0L;
            }
            setTimeInfo(nearbyFormatUtils.formatFeedTime(j3 * 1000));
            if (getStatusContentViewModel() == null) {
                this.statusContentViewModel$delegate.setValue(this, kPropertyArr[9], new NearbyFDPStatusContentViewModel(this));
            } else {
                NearbyFDPStatusContentViewModel statusContentViewModel = getStatusContentViewModel();
                if (statusContentViewModel != null) {
                    statusContentViewModel.timelineItemViewModel = this;
                    statusContentViewModel.refreshData();
                }
            }
        }
        ReadWriteProperty readWriteProperty2 = this.locationText$delegate;
        KProperty<?>[] kPropertyArr2 = $$delegatedProperties;
        String str6 = (String) readWriteProperty2.getValue(this, kPropertyArr2[8]);
        if (str6 != null) {
            if (str6.length() > 0) {
                z16 = true;
                if (!z16 && (lVar3 = this.statusFeed) != null && (kVar = lVar3.C) != null && (str4 = kVar.Q) != null) {
                    setLocationText(str4);
                }
                str3 = (String) this.locationText$delegate.getValue(this, kPropertyArr2[8]);
                if (str3 != null) {
                }
                z17 = false;
                if (!z17) {
                    a aVar6 = this.feed;
                    setLocationText(aVar6 != null ? aVar6.H : null);
                }
                NearbyFormatUtils nearbyFormatUtils2 = NearbyFormatUtils.INSTANCE;
                lVar = this.statusFeed;
                if (lVar == null) {
                    j16 = lVar.D;
                } else {
                    j16 = this.feed != null ? r0.E : 0L;
                }
                j17 = j16 * 1000;
                if (j17 != 0) {
                    a16 = "";
                } else {
                    b bVar = (b) c.f117352a.g().acquireModule("KRCalendarModule");
                    bVar.b(j17);
                    a16 = bVar.a(j17, "yyyy\u5e74MM\u6708dd\u65e5 HH:mm");
                }
                this.detailCreateTimeInfo$delegate.setValue(this, kPropertyArr2[5], a16);
                userDataManager = UserDataManager.INSTANCE;
                lVar2 = this.statusFeed;
                if (lVar2 == null && (eVar = lVar2.f418093e) != null) {
                    j18 = eVar.f430610d;
                } else {
                    aVar3 = this.feed;
                    if (aVar3 != null) {
                        j18 = aVar3.f440825e;
                    }
                    if (userDataManager.isHostTid(l3)) {
                        l lVar9 = this.statusFeed;
                        int i16 = lVar9 != null ? lVar9.N : 0;
                        if (i16 > 9999) {
                            str5 = "\u88ab\u6d4f\u89c89999+\u6b21";
                        } else {
                            str5 = "\u88ab\u6d4f\u89c8" + i16 + '\u6b21';
                        }
                    }
                    this.visitedCountInfo$delegate.setValue(this, kPropertyArr2[6], str5);
                }
                l3 = Long.valueOf(j18);
                if (userDataManager.isHostTid(l3)) {
                }
                this.visitedCountInfo$delegate.setValue(this, kPropertyArr2[6], str5);
            }
        }
        z16 = false;
        if (!z16) {
            setLocationText(str4);
        }
        str3 = (String) this.locationText$delegate.getValue(this, kPropertyArr2[8]);
        if (str3 != null) {
        }
        z17 = false;
        if (!z17) {
        }
        NearbyFormatUtils nearbyFormatUtils22 = NearbyFormatUtils.INSTANCE;
        lVar = this.statusFeed;
        if (lVar == null) {
        }
        j17 = j16 * 1000;
        if (j17 != 0) {
        }
        this.detailCreateTimeInfo$delegate.setValue(this, kPropertyArr2[5], a16);
        userDataManager = UserDataManager.INSTANCE;
        lVar2 = this.statusFeed;
        if (lVar2 == null) {
        }
        aVar3 = this.feed;
        if (aVar3 != null) {
        }
        if (userDataManager.isHostTid(l3)) {
        }
        this.visitedCountInfo$delegate.setValue(this, kPropertyArr2[6], str5);
    }

    public final void setItemTitle(String str) {
        this.itemTitle$delegate.setValue(this, $$delegatedProperties[3], str);
    }

    public final void setLatitude(Float f16) {
        this.latitude$delegate.setValue(this, $$delegatedProperties[1], f16);
    }

    public final void setLocationText(String str) {
        this.locationText$delegate.setValue(this, $$delegatedProperties[8], str);
    }

    public final void setLongitude(Float f16) {
        this.longitude$delegate.setValue(this, $$delegatedProperties[0], f16);
    }

    public final void setTimeInfo(String str) {
        this.timeInfo$delegate.setValue(this, $$delegatedProperties[4], str);
    }

    public final void updatePerson(p pVar) {
        o25.e eVar;
        this.person = pVar;
        if (pVar == null || (eVar = pVar.f440881e) == null) {
            return;
        }
        setLongitude(Float.valueOf(eVar.f421847e));
        setLatitude(Float.valueOf(eVar.f421846d));
    }

    public NearbyFDPUserFeedTimelineItemViewModel(a aVar, l lVar, p pVar, long j3, String str, boolean z16) {
        Lazy lazy;
        this.itemType = 2;
        this.feed = aVar;
        this.statusFeed = lVar;
        this.person = pVar;
        this.tinyId = j3;
        this.fromThemeId = str;
        this.fromFollowingTab = z16;
        this.longitude$delegate = c01.c.a(null);
        this.latitude$delegate = c01.c.a(null);
        this.itemImageSrc$delegate = c01.c.a("");
        this.itemTitle$delegate = c01.c.a("");
        this.timeInfo$delegate = c01.c.a("");
        this.detailCreateTimeInfo$delegate = c01.c.a("");
        this.visitedCountInfo$delegate = c01.c.a("");
        this.borderUrl$delegate = c01.c.a("");
        this.locationText$delegate = c01.c.a(null);
        this.statusContentViewModel$delegate = c01.c.a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedTimelineItemViewModel$fid$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str2;
                String str3;
                NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel = NearbyFDPUserFeedTimelineItemViewModel.this;
                a aVar2 = nearbyFDPUserFeedTimelineItemViewModel.feed;
                if (aVar2 != null && (str3 = aVar2.f440824d) != null) {
                    return str3;
                }
                l lVar2 = nearbyFDPUserFeedTimelineItemViewModel.statusFeed;
                return (lVar2 == null || (str2 = lVar2.f418092d) == null) ? "" : str2;
            }
        });
        this.fid$delegate = lazy;
        refreshData();
    }
}
