package com.tencent.hippykotlin.demo.pages.nearby.public_account.vm;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.MatchFriendUserSelfData;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.UserSelfBaseInfo;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginRepo$login$1;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginRequest;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.repo.QQStrangerPublicAccountRepo;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.t;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.foundation.scheduler.SchedulerKt;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.common.a;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import f35.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.i;
import n25.k;
import o25.e;
import o35.d;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes31.dex */
public final class QQStrangerPublicAccountViewModel extends g implements a {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Lazy appId$delegate;
    public e coordinate;
    public final Lazy dtReportBaseParams$delegate;
    public final String dtReportPageId;
    public boolean enteredRealNameVerifyPage;
    public final ComposeFeedListViewModel feedListViewModel;
    public boolean isCardListEnd;
    public final MutableState<Boolean> isHeaderRefreshing;
    public Function0<Unit> lazyTaskUtilHeaderRefreshEnd;
    public boolean needCheckLocationPermissionWhenAppear;
    public boolean needToSetVisitor;
    public final MutableState<Integer> pageState;
    public k poiInfo;
    public byte[] redExt;
    public final QQStrangerPublicAccountRepo repo;
    public final MutableState<Boolean> showUserRegisterLoading;
    public final Lazy userSelfInfo$delegate;
    public boolean visitor;

    public final int getAppId() {
        return ((Number) this.appId$delegate.getValue()).intValue();
    }

    public final com.tencent.kuikly.core.nvi.serialization.json.e getDtReportBaseParams() {
        return (com.tencent.kuikly.core.nvi.serialization.json.e) this.dtReportBaseParams$delegate.getValue();
    }

    public final String getFirstScreenCacheKey() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("qq_stranger_public_account2_");
        m3.append(getAppId());
        m3.append(c.f117352a.g().getPageData().getAppVersion());
        return m3.toString();
    }

    public final UserSelfBaseInfo getUserSelfInfo() {
        return (UserSelfBaseInfo) this.userSelfInfo$delegate.getValue();
    }

    public final void handleFromSuccessRsp(boolean z16, boolean z17, d dVar) {
        int collectionSizeOrDefault;
        BaseComposeCardViewModel qQStrangerPAFeedCardVM;
        boolean z18 = dVar.f421895i;
        this.visitor = z18;
        this.needToSetVisitor = z18;
        this.isCardListEnd = dVar.f421892e;
        List<o35.a> list = dVar.f421891d;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (o35.a aVar : list) {
            switch (aVar.f421874d) {
                case 1001:
                    qQStrangerPAFeedCardVM = new QQStrangerPAFeedCardVM(aVar.f421876f, this);
                    break;
                case 1002:
                    qQStrangerPAFeedCardVM = new QQStrangerPAInteractCardVM(getAppId(), aVar.f421877h, this);
                    break;
                case 1003:
                    qQStrangerPAFeedCardVM = new QQStrangerPAEntranceCardVM(aVar.f421878i, this);
                    break;
                case 1004:
                    qQStrangerPAFeedCardVM = new QQStrangerPATextCardVM(aVar.f421879m, this);
                    break;
                case 1005:
                    qQStrangerPAFeedCardVM = new QQStrangerPAMoodCardVM(aVar.C, this);
                    break;
                case 1006:
                    qQStrangerPAFeedCardVM = new QQStrangerPASimpleBarCardVM(aVar.D, this);
                    break;
                default:
                    qQStrangerPAFeedCardVM = new QQStrangerPACardVM(this);
                    break;
            }
            arrayList.add(qQStrangerPAFeedCardVM);
        }
        if (!z17) {
            this.feedListViewModel.feedCardViewModelList.clear();
        }
        if (z16) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((QQStrangerPACardVM) it.next()).isFromCache = true;
            }
        }
        this.feedListViewModel.feedCardViewModelList.addAll(arrayList);
        this.pageState.setValue(1);
    }

    public final void onCreateWithEnvReady(final boolean z16) {
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$onCreateWithEnvReady$task$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQStrangerPublicAccountViewModel.this.onFetchCardList(false, null);
                return Unit.INSTANCE;
            }
        };
        if (getAppId() != 2) {
            function0.invoke();
            return;
        }
        final Function3<NBPSsoLocation, e, k, Unit> function3 = new Function3<NBPSsoLocation, e, k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$onCreateWithEnvReady$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(NBPSsoLocation nBPSsoLocation, e eVar, k kVar) {
                QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel = QQStrangerPublicAccountViewModel.this;
                qQStrangerPublicAccountViewModel.coordinate = eVar;
                qQStrangerPublicAccountViewModel.poiInfo = kVar;
                function0.invoke();
                return Unit.INSTANCE;
            }
        };
        final Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$ensureEnvReady$locationTask$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                long a16 = zz0.a.f453719a.a();
                QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                boolean z17 = z16;
                companion.startLocation(z17, new Function2<Integer, NBPSsoLocation, Unit>(a16, this, z17, function3) { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$ensureEnvReady$locationTask$1.1
                    public final /* synthetic */ long $beginTime;
                    public final /* synthetic */ Function3<NBPSsoLocation, e, k, Unit> $onReady;
                    public final /* synthetic */ QQStrangerPublicAccountViewModel this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                        this.$onReady = r5;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Integer num, NBPSsoLocation nBPSsoLocation) {
                        NBPLatLng nBPLatLng;
                        int intValue = num.intValue();
                        NBPSsoLocation nBPSsoLocation2 = nBPSsoLocation;
                        long a17 = zz0.a.f453719a.a();
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("stranger public account: startLocation costTime:");
                        m3.append(a17 - this.$beginTime);
                        m3.append(", code: ");
                        m3.append(intValue);
                        m3.append(" ssoLocation:");
                        m3.append(nBPSsoLocation2.address);
                        m3.append(TokenParser.SP);
                        m3.append(nBPSsoLocation2.lat02);
                        m3.append(TokenParser.SP);
                        m3.append(nBPSsoLocation2.lon02);
                        kLog.i("QQStrangerPublicAccountVM", m3.toString());
                        QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel = this.this$0;
                        Function3<NBPSsoLocation, e, k, Unit> function32 = this.$onReady;
                        int i3 = QQStrangerPublicAccountViewModel.$r8$clinit;
                        qQStrangerPublicAccountViewModel.getClass();
                        if (intValue == 0) {
                            kLog.i("QQStrangerPublicAccountVM", "stranger public account: onLocationFinish success");
                            UserDataManager userDataManager = UserDataManager.INSTANCE;
                            double d16 = nBPSsoLocation2.lat02;
                            if (d16 == 0.0d) {
                                if (nBPSsoLocation2.lon02 == 0.0d) {
                                    nBPLatLng = new NBPLatLng(nBPSsoLocation2.lat84, nBPSsoLocation2.lon84);
                                    userDataManager.updateAndSave(nBPLatLng, nBPSsoLocation2.address, nBPSsoLocation2.name, nBPSsoLocation2.nation, nBPSsoLocation2.province, nBPSsoLocation2.city, nBPSsoLocation2.district);
                                    e eVar = new e((float) nBPSsoLocation2.lat02, (float) nBPSsoLocation2.lon02, 4);
                                    double d17 = 1000000;
                                    i iVar = new i((long) (nBPSsoLocation2.lat02 * d17), (long) (nBPSsoLocation2.lon02 * d17), 12);
                                    String str = nBPSsoLocation2.address;
                                    String str2 = nBPSsoLocation2.nation;
                                    String str3 = nBPSsoLocation2.province;
                                    String str4 = nBPSsoLocation2.city;
                                    String str5 = nBPSsoLocation2.district;
                                    String str6 = nBPSsoLocation2.name;
                                    function32.invoke(nBPSsoLocation2, eVar, new k((String) null, str6, 0, (String) null, str, 0, iVar, 0, 0, (String) null, str2, str3, str4, 0, 0, (String) null, str5, (String) null, (String) null, str6, 1500077));
                                }
                            }
                            nBPLatLng = new NBPLatLng(d16, nBPSsoLocation2.lon02);
                            userDataManager.updateAndSave(nBPLatLng, nBPSsoLocation2.address, nBPSsoLocation2.name, nBPSsoLocation2.nation, nBPSsoLocation2.province, nBPSsoLocation2.city, nBPSsoLocation2.district);
                            e eVar2 = new e((float) nBPSsoLocation2.lat02, (float) nBPSsoLocation2.lon02, 4);
                            double d172 = 1000000;
                            i iVar2 = new i((long) (nBPSsoLocation2.lat02 * d172), (long) (nBPSsoLocation2.lon02 * d172), 12);
                            String str7 = nBPSsoLocation2.address;
                            String str22 = nBPSsoLocation2.nation;
                            String str32 = nBPSsoLocation2.province;
                            String str42 = nBPSsoLocation2.city;
                            String str52 = nBPSsoLocation2.district;
                            String str62 = nBPSsoLocation2.name;
                            function32.invoke(nBPSsoLocation2, eVar2, new k((String) null, str62, 0, (String) null, str7, 0, iVar2, 0, 0, (String) null, str22, str32, str42, 0, 0, (String) null, str52, (String) null, (String) null, str62, 1500077));
                        } else {
                            qQStrangerPublicAccountViewModel.pageState.setValue(2);
                            NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("stranger public account: onLocationFinish error:", intValue, kLog, "QQStrangerPublicAccountVM");
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
        QQNearbyModule.Companion companion = QQNearbyModule.Companion;
        if (companion.getInstance().hadLocationPermission()) {
            function02.invoke();
            return;
        }
        final Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$ensureEnvReady$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                function02.invoke();
                return Unit.INSTANCE;
            }
        };
        KLog.INSTANCE.i("QQStrangerPublicAccountVM", "stranger public account: start request location permission");
        companion.getInstance().requestLocationPermission(new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$requestLocationPermission$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                int intValue = num.intValue();
                NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("stranger public account: on request location permission finish: ", intValue, KLog.INSTANCE, "QQStrangerPublicAccountVM");
                if (intValue == 1) {
                    function03.invoke();
                } else if (intValue == 2) {
                    TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$requestLocationPermission$1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                            return Unit.INSTANCE;
                        }
                    }, 1, null);
                } else if (intValue != 3) {
                    TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$requestLocationPermission$1.2
                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                            return Unit.INSTANCE;
                        }
                    }, 1, null);
                } else {
                    this.needCheckLocationPermissionWhenAppear = true;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void reportPageExposure(boolean z16) {
        String str;
        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("reportPageExposure: ", z16, KLog.INSTANCE, "QQStrangerPublicAccountVM");
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        com.tencent.kuikly.core.nvi.serialization.json.e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams.v("dt_pgid", "pg_nearby_kl_public_account");
        nearbyDTBaseParams.t("nearby_kl_appid", getAppId());
        nearbyDTBaseParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, nearbyDTBaseParams);
    }

    public final void startLogin(final boolean z16) {
        if (getAppId() == 2) {
            Function3<Integer, String, f35.g, Unit> function3 = new Function3<Integer, String, f35.g, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$startLogin$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(Integer num, String str, f35.g gVar) {
                    f35.g gVar2 = gVar;
                    if (num.intValue() == 0 && gVar2 != null) {
                        l lVar = gVar2.f397804i;
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("verifiedStatus: ");
                        m3.append(lVar != null ? Integer.valueOf(lVar.f397820d) : null);
                        m3.append(", ");
                        m3.append(lVar != null ? lVar.f397821e : null);
                        m3.append(", ");
                        AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(m3, z16, kLog, "QQStrangerPublicAccountVM");
                        if (lVar != null && lVar.f397820d == 2) {
                            if (z16) {
                                Utils.INSTANCE.currentBridgeModule().qToast("\u6ce8\u518c\u5931\u8d25, \u8bf7\u7a0d\u540e\u518d\u8bd5", QToastMode.Warning);
                                this.showUserRegisterLoading.setValue(Boolean.FALSE);
                            } else {
                                this.enteredRealNameVerifyPage = true;
                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.openPage$default(lVar.f397821e, false, 4);
                            }
                        } else {
                            if (lVar != null && lVar.f397820d == 3) {
                                this.getClass();
                                Utils.INSTANCE.currentBridgeModule().showAlert(null, "\u62b1\u6b49\uff0c\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u6682\u4e0d\u652f\u6301\u8bbf\u95ee", "\u6211\u77e5\u9053\u4e86", null, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$showTeenagerBlockAlert$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                                        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                        return Unit.INSTANCE;
                                    }
                                });
                            } else {
                                this.visitor = false;
                                r25.e eVar = gVar2.f397801e;
                                if (eVar != null) {
                                    UserDataManager.INSTANCE.updateAndSave(eVar);
                                }
                                UserDataManager userDataManager = UserDataManager.INSTANCE;
                                userDataManager.getUserSelfInfo().isNewUser = gVar2.C;
                                m25.c cVar = gVar2.f397800d;
                                if (cVar != null) {
                                    userDataManager.setSig(cVar.f416055e.f30291a);
                                    QQNearbyModule.Companion.getInstance().asyncToNativeMethod("updateCommonInfoToNTNearbyPro", (com.tencent.kuikly.core.nvi.serialization.json.e) null, (Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit>) null);
                                }
                                if (userDataManager.getUserSelfInfo().isNewUser) {
                                    QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[][]{c45.i.d(gVar2)});
                                    QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                    QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearbypro_guide_novice_home&custom_back_pressed=1", true, 4);
                                }
                                this.showUserRegisterLoading.setValue(Boolean.FALSE);
                            }
                        }
                    } else {
                        this.showUserRegisterLoading.setValue(Boolean.FALSE);
                    }
                    return Unit.INSTANCE;
                }
            };
            long a16 = zz0.a.f453719a.a();
            NBPMainLoginRequest nBPMainLoginRequest = new NBPMainLoginRequest();
            NBPMainLoginRepo$login$1 nBPMainLoginRepo$login$1 = new NBPMainLoginRepo$login$1(a16, function3);
            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.user_manager_svr.User.SsoLogin");
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.sendPbRequest$default(nBPMainLoginRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nBPMainLoginRepo$login$1), 6);
            return;
        }
        if (getAppId() == 1) {
            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://stranger/jump_home_page?from=100&support_guest=0", false, 4);
        }
    }

    public QQStrangerPublicAccountViewModel() {
        MutableState<Integer> mutableStateOf$default;
        MutableState<Boolean> mutableStateOf$default2;
        MutableState<Boolean> mutableStateOf$default3;
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.pageState = mutableStateOf$default;
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showUserRegisterLoading = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isHeaderRefreshing = mutableStateOf$default3;
        this.feedListViewModel = new ComposeFeedListViewModel(new Function1<Function2<? super Boolean, ? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$feedListViewModel$1
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Function2<? super Boolean, ? super Boolean, ? extends Unit> function2) {
                final Function2<? super Boolean, ? super Boolean, ? extends Unit> function22 = function2;
                if (QQStrangerPublicAccountViewModel.this.isHeaderRefreshing.getValue().booleanValue()) {
                    final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel = QQStrangerPublicAccountViewModel.this;
                    qQStrangerPublicAccountViewModel.lazyTaskUtilHeaderRefreshEnd = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$feedListViewModel$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel2 = QQStrangerPublicAccountViewModel.this;
                            Function2<Boolean, Boolean, Unit> function23 = function22;
                            int i3 = QQStrangerPublicAccountViewModel.$r8$clinit;
                            qQStrangerPublicAccountViewModel2.onFetchCardList(true, function23);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    QQStrangerPublicAccountViewModel.this.onFetchCardList(true, function22);
                }
                return Unit.INSTANCE;
            }
        });
        this.dtReportPageId = "pg_nearby_kl_public_account";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.kuikly.core.nvi.serialization.json.e>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$dtReportBaseParams$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.kuikly.core.nvi.serialization.json.e invoke() {
                com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel = QQStrangerPublicAccountViewModel.this;
                eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                eVar.v("dt_pgid", qQStrangerPublicAccountViewModel.dtReportPageId);
                eVar.t("nearby_kl_appid", qQStrangerPublicAccountViewModel.getAppId());
                com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                eVar2.t("nearby_kl_appid", qQStrangerPublicAccountViewModel.getAppId());
                Unit unit = Unit.INSTANCE;
                eVar.v("cur_pg", eVar2);
                return eVar;
            }
        });
        this.dtReportBaseParams$delegate = lazy;
        this.repo = new QQStrangerPublicAccountRepo();
        this.needToSetVisitor = true;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Integer>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$appId$2
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(c.f117352a.g().getPageData().n().k("app_id", 2));
            }
        });
        this.appId$delegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<UserSelfBaseInfo>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$userSelfInfo$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final UserSelfBaseInfo invoke() {
                UserSelfBaseInfo userSelfBaseInfo = new UserSelfBaseInfo(0, 15);
                if (QQStrangerPublicAccountViewModel.this.getAppId() == 2) {
                    UserDataManager userDataManager = UserDataManager.INSTANCE;
                    userSelfBaseInfo.accountId = String.valueOf(userDataManager.getUserSelfInfo().tid);
                    userSelfBaseInfo.nick = userDataManager.getUserSelfInfo().nickName;
                    userSelfBaseInfo.avatarUrl = userDataManager.getUserSelfInfo().avatarUrl;
                    userSelfBaseInfo.appId = 2;
                } else {
                    MatchFriendUserSelfData kLUserSelfInfo = QQNearbyModule.Companion.getInstance().getKLUserSelfInfo();
                    userSelfBaseInfo.appId = 1;
                    userSelfBaseInfo.accountId = kLUserSelfInfo.userId;
                    userSelfBaseInfo.nick = kLUserSelfInfo.userNickName;
                    userSelfBaseInfo.avatarUrl = kLUserSelfInfo.userAvatar;
                }
                return userSelfBaseInfo;
            }
        });
        this.userSelfInfo$delegate = lazy3;
        this.redExt = new byte[0];
        float f16 = 0.0f;
        this.coordinate = new e(f16, f16, 7);
        this.poiInfo = new k((String) null, (String) null, 0, (String) null, (String) null, 0, (i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151);
        this.visitor = true;
    }

    public final void onFetchCardList(final boolean z16, final Function2<? super Boolean, ? super Boolean, Unit> function2) {
        if (!z16) {
            this.isHeaderRefreshing.setValue(Boolean.TRUE);
        }
        this.repo.fetchCardList(z16, getAppId(), this.coordinate, this.poiInfo, this.redExt, new Function3<Boolean, byte[], d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$onFetchCardList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Boolean bool, byte[] bArr, d dVar) {
                boolean booleanValue = bool.booleanValue();
                final byte[] bArr2 = bArr;
                d dVar2 = dVar;
                if (!z16) {
                    this.isHeaderRefreshing.setValue(Boolean.FALSE);
                    Function0<Unit> function0 = this.lazyTaskUtilHeaderRefreshEnd;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    this.lazyTaskUtilHeaderRefreshEnd = null;
                }
                if (booleanValue && dVar2 != null) {
                    this.handleFromSuccessRsp(false, z16, dVar2);
                    if (!z16 && bArr2 != null) {
                        final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel = this;
                        SchedulerKt.a(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$onFetchCardList$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                c cVar = c.f117352a;
                                if (((t) cVar.g().acquireModule("KRTurboDisplayModule")).a()) {
                                    KLog.INSTANCE.i("QQStrangerPublicAccountVM", "did setCurrentUIAsFirstScreenForNextLaunch");
                                    ((t) cVar.g().acquireModule("KRTurboDisplayModule")).b();
                                }
                                zz0.a aVar = zz0.a.f453719a;
                                long a16 = aVar.a();
                                ((com.tencent.kuikly.core.module.e) cVar.g().acquireModule("KRDiskCacheModule")).e(QQStrangerPublicAccountViewModel.this.getFirstScreenCacheKey(), bArr2);
                                long a17 = aVar.a();
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("cache first screen data cost time");
                                m3.append(a17 - a16);
                                m3.append("ms");
                                kLog.e("QQStrangerPublicAccountVM", m3.toString());
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    Function2<Boolean, Boolean, Unit> function22 = function2;
                    if (function22 != null) {
                        function22.invoke(Boolean.valueOf(this.isCardListEnd), Boolean.FALSE);
                    }
                } else {
                    if (!z16) {
                        this.pageState.setValue(3);
                    }
                    Function2<Boolean, Boolean, Unit> function23 = function2;
                    if (function23 != null) {
                        function23.invoke(Boolean.valueOf(this.isCardListEnd), Boolean.TRUE);
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.ntcompose.lifecycle.common.a
    public final void onStateChanged(com.tencent.ntcompose.lifecycle.common.c cVar, Lifecycle.Event event) {
        byte[] encodeToByteArray;
        d dVar;
        if (event == Lifecycle.Event.ON_CREATE) {
            KLog.INSTANCE.i("QQStrangerPublicAccountVM", "on QQStrangerPublicAccountVM create");
            c cVar2 = c.f117352a;
            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(cVar2.g().getPageData().n().p("red_ext"));
            this.redExt = encodeToByteArray;
            onCreateWithEnvReady(false);
            long a16 = zz0.a.f453719a.a();
            byte[] a17 = ((com.tencent.kuikly.core.module.e) cVar2.g().acquireModule("KRDiskCacheModule")).a(getFirstScreenCacheKey());
            if (!(a17.length == 0)) {
                try {
                    dVar = (d) c45.i.b(new d(null, false, null, null, false, 31, null), a17);
                } catch (Throwable th5) {
                    KLog.INSTANCE.e("QQStrangerPublicAccountVM", "cacheByteArrayData decode error: " + th5);
                    dVar = new d(null, false, null, null, false, 31, null);
                }
                long a18 = zz0.a.f453719a.a();
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("get first screen cache data cost:");
                m3.append(a18 - a16);
                m3.append("ms length:");
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, a17.length, kLog, "QQStrangerPublicAccountVM");
                if (!dVar.f421891d.isEmpty()) {
                    handleFromSuccessRsp(true, false, dVar);
                }
            }
            reportPageExposure(true);
            return;
        }
        if (event == Lifecycle.Event.ON_RESUME) {
            if (this.needCheckLocationPermissionWhenAppear) {
                KLog.INSTANCE.i("QQStrangerPublicAccountVM", "pa: start check location permission when onResume");
                this.needCheckLocationPermissionWhenAppear = false;
                onCreateWithEnvReady(true);
            }
            if (this.enteredRealNameVerifyPage) {
                KLog.INSTANCE.i("QQStrangerPublicAccountVM", "pa: start login when onResume");
                this.enteredRealNameVerifyPage = false;
                startLogin(true);
            }
            if (this.needToSetVisitor) {
                KLog.INSTANCE.i("QQStrangerPublicAccountVM", "start check if has registered when onResume");
                this.repo.fetchCardList(false, getAppId(), this.coordinate, this.poiInfo, this.redExt, new Function3<Boolean, byte[], d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$onResume$1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(Boolean bool, byte[] bArr, d dVar2) {
                        d dVar3 = dVar2;
                        if (bool.booleanValue()) {
                            QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel = QQStrangerPublicAccountViewModel.this;
                            boolean z16 = false;
                            qQStrangerPublicAccountViewModel.visitor = dVar3 != null && dVar3.f421895i;
                            if (dVar3 != null && dVar3.f421895i) {
                                z16 = true;
                            }
                            qQStrangerPublicAccountViewModel.needToSetVisitor = z16;
                            AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onResume visitor new state: "), QQStrangerPublicAccountViewModel.this.visitor, KLog.INSTANCE, "QQStrangerPublicAccountVM");
                        }
                        QQStrangerPublicAccountViewModel.this.showUserRegisterLoading.setValue(Boolean.FALSE);
                        QQStrangerPublicAccountViewModel.this.needToSetVisitor = true;
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            reportPageExposure(false);
        }
    }
}
