package com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import c45.a;
import c45.i;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyFollowRepo$setFollowState$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$fetchFollowData$1;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.FetchStatus;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPNewEditViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import q35.b;
import q35.d;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPFollowerViewModel extends g {
    public static final /* synthetic */ int $r8$clinit = 0;
    public String accountId;
    public int appId;
    public int clickAreaInt;
    public SnapshotStateList<Integer> fansFollowStatusList;
    public SnapshotStateList<af> fansList;
    public final MutableState followInfoOnlySelf$delegate;
    public SnapshotStateList<af> followingList;
    public SnapshotStateList<Integer> followingStatusList;
    public MutableState<Boolean> isEnterLoading;
    public boolean isFansListEnd;
    public boolean isFollowingListEnd;
    public boolean isRequesting;
    public MutableState<Boolean> isSelf;
    public final MutableState isShowActionSheet$delegate;
    public MutableState<Float> marginBottom;
    public List<a> roundParamList;
    public final MutableState showFansUnfollowActionSheet$delegate;
    public final MutableState showFollowingUnfollowActionSheet$delegate;
    public final MutableState totalFansCount$delegate;
    public final MutableState totalFollowingCount$delegate;
    public String unFollowAccount;

    /* loaded from: classes31.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BoxType$EnumUnboxingSharedUtility.values(2).length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NBPFollowerViewModel(com.tencent.kuikly.core.pager.g gVar) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState<Boolean> mutableStateOf$default4;
        MutableState<Boolean> mutableStateOf$default5;
        MutableState<Float> mutableStateOf$default6;
        List<a> mutableListOf;
        MutableState mutableStateOf$default7;
        MutableState mutableStateOf$default8;
        MutableState mutableStateOf$default9;
        this.accountId = "";
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.followInfoOnlySelf$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.totalFansCount$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.totalFollowingCount$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.isEnterLoading = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isSelf = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.marginBottom = mutableStateOf$default6;
        this.fansList = SnapshotStateKt.mutableStateListOf();
        this.fansFollowStatusList = SnapshotStateKt.mutableStateListOf();
        this.followingList = SnapshotStateKt.mutableStateListOf();
        this.followingStatusList = SnapshotStateKt.mutableStateListOf();
        a aVar = a.f30290b;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(aVar, aVar);
        this.roundParamList = mutableListOf;
        SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(FetchStatus.NULL_STATE, null, 2, null);
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isShowActionSheet$delegate = mutableStateOf$default7;
        this.unFollowAccount = "";
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showFansUnfollowActionSheet$delegate = mutableStateOf$default8;
        mutableStateOf$default9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showFollowingUnfollowActionSheet$delegate = mutableStateOf$default9;
        this.appId = gVar.n().j("appid");
        this.accountId = gVar.n().p(ReportDataBuilder.KEY_ACCOUNT_ID);
        this.clickAreaInt = gVar.n().j("click_area");
        setFollowInfoOnlySelf(gVar.n().g("follow_only_self", false));
        this.isSelf.setValue(Boolean.valueOf(Intrinsics.areEqual(this.accountId, String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().getTid()))));
        if (this.isSelf.getValue().booleanValue()) {
            this.marginBottom.setValue(Float.valueOf(gVar.getIsAndroid() ? 66.0f : 86.0f));
        }
        int fromInt$enumunboxing$ = ListTitle$EnumUnboxingLocalUtility.Companion.fromInt$enumunboxing$(this.clickAreaInt);
        fetchFollowerPageData$default(this, this.appId, fromInt$enumunboxing$ == 0 ? 1 : fromInt$enumunboxing$, true, true, true, this.isSelf.getValue().booleanValue(), this.accountId, this.roundParamList, 256);
        TimerKt.d(10, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                final NBPFollowerViewModel nBPFollowerViewModel = NBPFollowerViewModel.this;
                nBPFollowerViewModel.getClass();
                k.b((k) c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_HOMEPAGE_FOLLOW_STATUS_CHANGED", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel$addFollowCountChangeEvent$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        e eVar2 = eVar;
                        if (eVar2 != null) {
                            String p16 = eVar2.p("accountId");
                            boolean f16 = eVar2.f("doFollow");
                            KLog.INSTANCE.i("NBPFollowerPageViewModel", "homepage changed followStatus id:" + p16 + ", doFollow: " + f16);
                            int i3 = 0;
                            int i16 = -1;
                            if (f16 && NBPFollowerViewModel.this.isSelf.getValue().booleanValue()) {
                                NBPFollowerViewModel nBPFollowerViewModel2 = NBPFollowerViewModel.this;
                                nBPFollowerViewModel2.setTotalFollowingCount(nBPFollowerViewModel2.getTotalFollowingCount() + 1);
                                Iterator<af> it = NBPFollowerViewModel.this.fansList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    if (Intrinsics.areEqual(String.valueOf(it.next().f433207e), p16)) {
                                        i16 = i3;
                                        break;
                                    }
                                    i3++;
                                }
                                if (i16 >= 0 && i16 < NBPFollowerViewModel.this.fansFollowStatusList.size() && NBPFollowerViewModel.this.fansFollowStatusList.get(i16).intValue() != 4) {
                                    NBPFollowerViewModel.this.fansFollowStatusList.set(i16, 3);
                                }
                            } else if (!f16 && NBPFollowerViewModel.this.isSelf.getValue().booleanValue()) {
                                Iterator<af> it5 = NBPFollowerViewModel.this.fansList.iterator();
                                int i17 = 0;
                                while (true) {
                                    if (!it5.hasNext()) {
                                        i17 = -1;
                                        break;
                                    }
                                    if (Intrinsics.areEqual(String.valueOf(it5.next().f433207e), p16)) {
                                        break;
                                    }
                                    i17++;
                                }
                                if (i17 != -1 && NBPFollowerViewModel.this.fansFollowStatusList.get(i17).intValue() == 3) {
                                    NBPFollowerViewModel.this.fansFollowStatusList.set(i17, 2);
                                }
                                Iterator<af> it6 = NBPFollowerViewModel.this.followingList.iterator();
                                while (true) {
                                    if (!it6.hasNext()) {
                                        i3 = -1;
                                        break;
                                    }
                                    if (Intrinsics.areEqual(String.valueOf(it6.next().f433207e), p16)) {
                                        break;
                                    }
                                    i3++;
                                }
                                if (i3 != -1) {
                                    NBPFollowerViewModel.this.followingList.remove(i3);
                                    NBPFollowerViewModel.this.setTotalFollowingCount(r8.getTotalFollowingCount() - 1);
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                return Unit.INSTANCE;
            }
        });
    }

    public final void dtReportElementClick(String str, boolean z16) {
        e dTPageParam = getDTPageParam(z16);
        dTPageParam.v("dt_eid", str);
        dTPageParam.v("cur_pg", getDTPageParam(z16));
        dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTPageParam);
    }

    public final void dtReportElementImp(String str, boolean z16) {
        e dTPageParam = getDTPageParam(z16);
        dTPageParam.v("dt_eid", str);
        dTPageParam.v("cur_pg", getDTPageParam(z16));
        dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", dTPageParam);
    }

    public final String formatUserTags(af afVar) {
        List take;
        int collectionSizeOrDefault;
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        String str = afVar.f433214i;
        if (str.length() > 0) {
            arrayList.add(str);
        }
        take = CollectionsKt___CollectionsKt.take(afVar.I, 3 - arrayList.size());
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(take, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = take.iterator();
        while (it.hasNext()) {
            arrayList2.add(((t35.a) it.next()).f435363e);
        }
        arrayList.addAll(arrayList2);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "\u00b7", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    public final e getDTPageParam(boolean z16) {
        if (!z16) {
            e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
            nearbyDTBaseParams.v("dt_pgid", "pg_nearby_fans");
            return nearbyDTBaseParams;
        }
        e nearbyDTBaseParams2 = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams2.v("dt_pgid", "pg_nearby_focus");
        return nearbyDTBaseParams2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getFollowInfoOnlySelf() {
        return ((Boolean) this.followInfoOnlySelf$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getTotalFansCount() {
        return ((Number) this.totalFansCount$delegate.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getTotalFollowingCount() {
        return ((Number) this.totalFollowingCount$delegate.getValue()).intValue();
    }

    public final void postNotify() {
        k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
        e eVar = new e();
        eVar.v(ReportDataBuilder.KEY_ACCOUNT_ID, this.accountId);
        eVar.t(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_FANS_COUNT, getTotalFansCount());
        eVar.t("following_count", getTotalFollowingCount());
        Unit unit = Unit.INSTANCE;
        k.d(kVar, "NEARBY_FANS_COUNT_CHANGED_EVENT", eVar, false, 4, null);
    }

    public final void setFollowInfoOnlySelf(boolean z16) {
        this.followInfoOnlySelf$delegate.setValue(Boolean.valueOf(z16));
    }

    public final void setShowActionSheet(boolean z16) {
        this.isShowActionSheet$delegate.setValue(Boolean.valueOf(z16));
    }

    public final void setShowFansUnfollowActionSheet(boolean z16) {
        this.showFansUnfollowActionSheet$delegate.setValue(Boolean.valueOf(z16));
    }

    public final void setShowFollowingUnfollowActionSheet(boolean z16) {
        this.showFollowingUnfollowActionSheet$delegate.setValue(Boolean.valueOf(z16));
    }

    public final void setTotalFollowingCount(int i3) {
        this.totalFollowingCount$delegate.setValue(Integer.valueOf(i3));
    }

    public final void dtReportPrivateElementClick(int i3) {
        e dTPageParam = getDTPageParam(false);
        dTPageParam.v("dt_eid", "em_nearby_privilege_set_float");
        dTPageParam.t("nearby_btn_type", i3);
        dTPageParam.v("cur_pg", getDTPageParam(true));
        dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTPageParam);
    }

    public final void dtReportPageExposure(boolean z16, boolean z17) {
        String str;
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        e dTPageParam = getDTPageParam(z17);
        dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, dTPageParam);
    }

    public final void setFollowState(int i3, String str) {
        final String str2;
        if (i3 == 0) {
            str2 = "\u53d6\u5173";
        } else {
            str2 = "\u5173\u6ce8";
        }
        int i16 = this.appId;
        Function1<b, Unit> function1 = new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel$setFollowState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(b bVar) {
                Utils.INSTANCE.currentBridgeModule().qToast(OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(new StringBuilder(), str2, "\u6210\u529f"), QToastMode.Success);
                return Unit.INSTANCE;
            }
        };
        Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel$setFollowState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str3) {
                num.intValue();
                Utils.INSTANCE.currentBridgeModule().qToast(OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(new StringBuilder(), str2, "\u5931\u8d25"), QToastMode.Warning);
                DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("Follow page setFollowState: error. msg: ", str3, KLog.INSTANCE, "NBPFollowerPageViewModel");
                return Unit.INSTANCE;
            }
        };
        q35.a aVar = new q35.a(QQNearbyModule.Companion.getInstance().getCommonExtInfo(), i3, str, 2);
        NearbyFollowRepo$setFollowState$1 nearbyFollowRepo$setFollowState$1 = new NearbyFollowRepo$setFollowState$1(i16, function1, function2, str, i3);
        QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.follow", "SsoDoFollow", i16, new a(i.d(aVar))));
        QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(nearbyFollowRepo$setFollowState$1);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
    }

    public final void setFollowOnlySelf(final boolean z16) {
        new NBPNewEditViewModel(this.appId, 35).save(new af(null, 0L, null, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, z16, -1, 191), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel$setFollowOnlySelf$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                boolean booleanValue = bool.booleanValue();
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Publicly follow data: ");
                m3.append(z16);
                m3.append(", Completed: ");
                m3.append(booleanValue);
                kLog.i("NBPFollowerPageViewModel", m3.toString());
                return Unit.INSTANCE;
            }
        });
        k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
        e eVar = new e();
        eVar.w("followsOnlySelf", z16);
        Unit unit = Unit.INSTANCE;
        k.d(kVar, "NEARBY_CHANGE_FANS_LIST_VISIBLE", eVar, false, 4, null);
    }

    public static void fetchFollowerPageData$default(final NBPFollowerViewModel nBPFollowerViewModel, final int i3, final int i16, boolean z16, final boolean z17, final boolean z18, final boolean z19, final String str, final List list, int i17) {
        boolean z26 = (i17 & 4) != 0 ? false : z16;
        final int i18 = (i17 & 256) != 0 ? 20 : 0;
        nBPFollowerViewModel.getClass();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        if (i16 != 0) {
            final int i19 = iArr[i16 + (-1)] != 1 ? 1 : 0;
            final int i26 = 1 - i19;
            int value = ListTitle$EnumUnboxingLocalUtility.getValue(i16);
            a aVar = (a) list.get(i19);
            Function1<d, Unit> function1 = new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel$fetchFollowerPageData$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(d dVar) {
                    int collectionSizeOrDefault;
                    int collectionSizeOrDefault2;
                    d dVar2 = dVar;
                    if (i16 == 2) {
                        nBPFollowerViewModel.followingList.addAll(dVar2.f428317d);
                        SnapshotStateList<Integer> snapshotStateList = nBPFollowerViewModel.followingStatusList;
                        List<af> list2 = dVar2.f428317d;
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Integer.valueOf(((af) it.next()).f433217k0));
                        }
                        snapshotStateList.addAll(arrayList);
                        nBPFollowerViewModel.isFollowingListEnd = dVar2.f428321i;
                    } else {
                        nBPFollowerViewModel.fansList.addAll(dVar2.f428317d);
                        SnapshotStateList<Integer> snapshotStateList2 = nBPFollowerViewModel.fansFollowStatusList;
                        List<af> list3 = dVar2.f428317d;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                        Iterator<T> it5 = list3.iterator();
                        while (it5.hasNext()) {
                            arrayList2.add(Integer.valueOf(((af) it5.next()).f433217k0));
                        }
                        snapshotStateList2.addAll(arrayList2);
                        nBPFollowerViewModel.isFansListEnd = dVar2.f428321i;
                    }
                    int i27 = dVar2.f428319f;
                    if (i27 > 0) {
                        nBPFollowerViewModel.totalFansCount$delegate.setValue(Integer.valueOf(i27));
                    }
                    int i28 = dVar2.f428318e;
                    if (i28 > 0) {
                        nBPFollowerViewModel.setTotalFollowingCount(i28);
                    }
                    nBPFollowerViewModel.roundParamList.set(i19, dVar2.f428320h);
                    NBPFollowerViewModel nBPFollowerViewModel2 = nBPFollowerViewModel;
                    nBPFollowerViewModel2.isRequesting = false;
                    nBPFollowerViewModel2.isEnterLoading.setValue(Boolean.FALSE);
                    return Unit.INSTANCE;
                }
            };
            Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel$fetchFollowerPageData$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str2) {
                    num.intValue();
                    NBPFollowerViewModel nBPFollowerViewModel2 = NBPFollowerViewModel.this;
                    nBPFollowerViewModel2.isRequesting = false;
                    nBPFollowerViewModel2.isEnterLoading.setValue(Boolean.FALSE);
                    KLog.INSTANCE.e("NBPFollowerPageViewModel", "fetchFollowData: error. msg: " + str2);
                    return Unit.INSTANCE;
                }
            };
            q35.c cVar = new q35.c(QQNearbyModule.Companion.getInstance().getCommonExtInfo(), value, z17, z18, z19, str, aVar, i18, 2);
            NBPNewHomeRepository$fetchFollowData$1 nBPNewHomeRepository$fetchFollowData$1 = new NBPNewHomeRepository$fetchFollowData$1(i3, function1, function2);
            QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.follow", "SsoGetFollowData", i3, new a(i.d(cVar))));
            QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(nBPNewHomeRepository$fetchFollowData$1);
            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
            if (z26) {
                final int i27 = i16 == 1 ? 2 : 1;
                TimerKt.d(20, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel$fetchFollowerPageData$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Incorrect types in method signature: (ILjava/lang/Object;ZZZLjava/lang/String;Ljava/util/List<Lc45/a;>;IILcom/tencent/hippykotlin/demo/pages/nearby/follower_page/view_model/NBPFollowerViewModel;)V */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        int i28 = i3;
                        int value2 = ListTitle$EnumUnboxingLocalUtility.getValue(i27);
                        boolean z27 = z17;
                        boolean z28 = z18;
                        boolean z29 = z19;
                        String str2 = str;
                        a aVar2 = list.get(i26);
                        int i29 = i18;
                        final NBPFollowerViewModel nBPFollowerViewModel2 = nBPFollowerViewModel;
                        final int i36 = i27;
                        final int i37 = i26;
                        Function1<d, Unit> function12 = new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel$fetchFollowerPageData$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                int collectionSizeOrDefault;
                                int collectionSizeOrDefault2;
                                d dVar2 = dVar;
                                int i38 = dVar2.f428319f;
                                if (i38 > 0) {
                                    NBPFollowerViewModel.this.totalFansCount$delegate.setValue(Integer.valueOf(i38));
                                }
                                int i39 = dVar2.f428318e;
                                if (i39 > 0) {
                                    NBPFollowerViewModel.this.setTotalFollowingCount(i39);
                                }
                                if (i36 == 2) {
                                    NBPFollowerViewModel.this.followingList.addAll(dVar2.f428317d);
                                    SnapshotStateList<Integer> snapshotStateList = NBPFollowerViewModel.this.followingStatusList;
                                    List<af> list2 = dVar2.f428317d;
                                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                                    Iterator<T> it = list2.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(Integer.valueOf(((af) it.next()).f433217k0));
                                    }
                                    snapshotStateList.addAll(arrayList);
                                    NBPFollowerViewModel.this.isFollowingListEnd = dVar2.f428321i;
                                } else {
                                    NBPFollowerViewModel.this.fansList.addAll(dVar2.f428317d);
                                    SnapshotStateList<Integer> snapshotStateList2 = NBPFollowerViewModel.this.fansFollowStatusList;
                                    List<af> list3 = dVar2.f428317d;
                                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                                    Iterator<T> it5 = list3.iterator();
                                    while (it5.hasNext()) {
                                        arrayList2.add(Integer.valueOf(((af) it5.next()).f433217k0));
                                    }
                                    snapshotStateList2.addAll(arrayList2);
                                    NBPFollowerViewModel.this.isFansListEnd = dVar2.f428321i;
                                }
                                NBPFollowerViewModel.this.roundParamList.set(i37, dVar2.f428320h);
                                NBPFollowerViewModel nBPFollowerViewModel3 = NBPFollowerViewModel.this;
                                nBPFollowerViewModel3.isRequesting = false;
                                nBPFollowerViewModel3.isEnterLoading.setValue(Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        };
                        final NBPFollowerViewModel nBPFollowerViewModel3 = nBPFollowerViewModel;
                        Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel$fetchFollowerPageData$3.2
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Integer num, String str3) {
                                num.intValue();
                                NBPFollowerViewModel nBPFollowerViewModel4 = NBPFollowerViewModel.this;
                                nBPFollowerViewModel4.isRequesting = false;
                                nBPFollowerViewModel4.isEnterLoading.setValue(Boolean.FALSE);
                                KLog.INSTANCE.e("NBPFollowerPageViewModel", "fetchFollowData: error. msg: " + str3);
                                return Unit.INSTANCE;
                            }
                        };
                        q35.c cVar2 = new q35.c(QQNearbyModule.Companion.getInstance().getCommonExtInfo(), value2, z27, z28, z29, str2, aVar2, i29, 2);
                        NBPNewHomeRepository$fetchFollowData$1 nBPNewHomeRepository$fetchFollowData$12 = new NBPNewHomeRepository$fetchFollowData$1(i28, function12, function22);
                        QQStrangerSsoRequest qQStrangerSsoRequest2 = new QQStrangerSsoRequest(new u35.a("QQStranger.follow", "SsoGetFollowData", i28, new a(i.d(cVar2))));
                        QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$12 = new QQStrangerSsoService$sendProxyRequest$1(nBPNewHomeRepository$fetchFollowData$12);
                        APICallTechReporter aPICallTechReporter2 = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
                        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                        NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter2, qQStrangerSsoService$sendProxyRequest$12, qQStrangerSsoRequest2, null, 6);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            return;
        }
        throw null;
    }
}
