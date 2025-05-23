package com.tencent.hippykotlin.demo.pages.nearby.main.control.login;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import f35.g;
import f35.l;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import n25.k;
import org.apache.httpcore.message.TokenParser;
import v25.s;
import zz0.a;

/* loaded from: classes31.dex */
public final class NBPMainLoginViewModel extends NBPMainBaseViewModel {
    public boolean enteredRealNameVerifyPage;
    public boolean hadLogin;
    public int lastReqError;
    public int locationRetryCount;
    public boolean locationSuccess;
    public int loginRetryCount;
    public String locationTimeoutId = "";
    public final NBPMainLoginRepo loginRepo = new NBPMainLoginRepo();
    public String locationHeartBeatTimeoutRef = "";
    public int nextReqInterval = 120000;
    public int currentLoginRequestId = 1;
    public String loginTimeoutRef = "";

    public static final boolean access$isUserVerified(final NBPMainLoginViewModel nBPMainLoginViewModel, l lVar) {
        nBPMainLoginViewModel.getClass();
        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("verifiedStatus: "), lVar != null ? Integer.valueOf(lVar.f397820d) : null, KLog.INSTANCE, "NBPMainLoginViewModel");
        Integer valueOf = lVar != null ? Integer.valueOf(lVar.f397820d) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            final String str = lVar.f397821e;
            e eVar = new e();
            eVar.t("nearby_pop_type", 1);
            eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_nonage_pop_imp", eVar);
            ((QQUIModule) c.f117352a.g().acquireModule("QQUIModule")).openAlertDialog("", "\u9700\u8981\u5b8c\u6210\u5b9e\u540d\u8ba4\u8bc1\u624d\u80fd\u8fdb\u5165\u9644\u8fd1", "\u79bb\u5f00", "\u8ba4\u8bc1", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$showNeedRealNameVerifyAlert$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Boolean bool, Boolean bool2) {
                    boolean booleanValue = bool.booleanValue();
                    bool2.booleanValue();
                    if (booleanValue) {
                        NBPMainLoginViewModel.this.enteredRealNameVerifyPage = true;
                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.openPage$default(str, false, 4);
                    } else {
                        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.closePage$default();
                    }
                    int i3 = booleanValue ? 2 : 1;
                    e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("nearby_pop_type", 1);
                    m3.t("nearby_btn_type", BoxType$EnumUnboxingSharedUtility.ordinal(i3));
                    m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_nonage_pop_clck", m3);
                    return Unit.INSTANCE;
                }
            });
        } else {
            if (valueOf == null || valueOf.intValue() != 3) {
                return true;
            }
            e eVar2 = new e();
            eVar2.t("nearby_pop_type", 2);
            eVar2.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils utils = Utils.INSTANCE;
            utils.currentBridgeModule().reportCustomDtEvent("ev_nearby_nonage_pop_imp", eVar2);
            utils.currentBridgeModule().showAlert(null, "\u62b1\u6b49\uff0c\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u6682\u4e0d\u652f\u6301\u8bbf\u95ee", "\u6211\u77e5\u9053\u4e86", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$showTeenagerBlockAlert$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar3) {
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.closePage$default();
                    e eVar4 = new e();
                    eVar4.t("nearby_pop_type", 2);
                    eVar4.t("nearby_btn_type", 0);
                    eVar4.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_nonage_pop_clck", eVar4);
                    return Unit.INSTANCE;
                }
            });
        }
        return false;
    }

    public final void innerStartLogin(final int i3) {
        KLog.INSTANCE.i("NBPMainLoginViewModel", "innerStartLogin");
        stopLoginTimeout();
        this.loginTimeoutRef = TimerKt.d(20000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$startLoginTimeout$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("on login timeout, ");
                m3.append(NBPMainLoginViewModel.this.currentLoginRequestId);
                m3.append(", ");
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, NBPMainLoginViewModel.this.loginRetryCount, kLog, "NBPMainLoginViewModel");
                NBPMainLoginViewModel nBPMainLoginViewModel = NBPMainLoginViewModel.this;
                if (!nBPMainLoginViewModel.hadLogin) {
                    if (nBPMainLoginViewModel.loginRetryCount <= 3) {
                        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("retry login on time: "), NBPMainLoginViewModel.this.loginRetryCount, kLog, "NBPMainLoginViewModel");
                        NBPMainLoginViewModel nBPMainLoginViewModel2 = NBPMainLoginViewModel.this;
                        nBPMainLoginViewModel2.loginRetryCount++;
                        int i16 = nBPMainLoginViewModel2.currentLoginRequestId + 1;
                        nBPMainLoginViewModel2.currentLoginRequestId = i16;
                        nBPMainLoginViewModel2.innerStartLogin(i16);
                    } else {
                        kLog.i("NBPMainLoginViewModel", "retry login count max, on timeout");
                    }
                }
                return Unit.INSTANCE;
            }
        });
        final long a16 = a.f453719a.a();
        this.loginRepo.login(new Function3<Integer, String, g, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$innerStartLogin$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Type inference failed for: r10v20, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Integer num, String str, g gVar) {
                int intValue = num.intValue();
                String str2 = str;
                final g gVar2 = gVar;
                NBPMainLoginViewModel nBPMainLoginViewModel = NBPMainLoginViewModel.this;
                if (nBPMainLoginViewModel.currentLoginRequestId != i3) {
                    KLog.INSTANCE.i("NBPMainLoginViewModel", "filter last login callback");
                } else {
                    nBPMainLoginViewModel.stopLoginTimeout();
                    if (intValue == 0 && gVar2 != null) {
                        if (!NBPMainLoginViewModel.access$isUserVerified(NBPMainLoginViewModel.this, gVar2.f397804i)) {
                            NBPMainKtxKt.getVmStore().onNBPLogin(false, null);
                        } else {
                            r25.e eVar = gVar2.f397801e;
                            if (eVar != null) {
                                UserDataManager.INSTANCE.updateAndSave(eVar);
                            }
                            UserDataManager.INSTANCE.getUserSelfInfo().isNewUser = gVar2.C;
                            NBPMainLoginViewModel nBPMainLoginViewModel2 = NBPMainLoginViewModel.this;
                            m25.c cVar = gVar2.f397800d;
                            nBPMainLoginViewModel2.getClass();
                            Iterator it = NBPMainKtxKt.getVmStore().viewModels.values().iterator();
                            while (it.hasNext()) {
                                ((NBPMainBaseViewModel) it.next()).onBeforeSetSigData();
                            }
                            if (cVar != null) {
                                UserDataManager.INSTANCE.setSig(cVar.f416055e.f30291a);
                                QQNearbyModule.Companion.getInstance().asyncToNativeMethod("updateCommonInfoToNTNearbyPro", (e) null, (Function1<? super e, Unit>) null);
                            }
                            long a17 = a.f453719a.a();
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("login success costTime:");
                            m3.append(a17 - a16);
                            m3.append(", isNew:");
                            UserDataManager userDataManager = UserDataManager.INSTANCE;
                            m3.append(userDataManager.getUserSelfInfo().isNewUser);
                            kLog.i("NBPMainLoginViewModel", m3.toString());
                            if (userDataManager.getUserSelfInfo().isNewUser) {
                                TimerKt.d(300, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$innerStartLogin$1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[][]{i.d(g.this)});
                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                        QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearbypro_guide_novice_home&custom_back_pressed=1", true, 4);
                                        return Unit.INSTANCE;
                                    }
                                });
                            } else {
                                NBPMainKtxKt.getVmStore().onNBPLogin(true, gVar2);
                                NBPMainLoginViewModel.this.hadLogin = true;
                                final v35.e eVar2 = gVar2.f397803h;
                                if (eVar2 != null) {
                                    if (gVar2.f397802f && !eVar2.f440937f.isEmpty() && !eVar2.f440938h.isEmpty()) {
                                        TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$tryUpdateAvatarHead$1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                KLog.INSTANCE.i("NBPMainLoginViewModel", "tryUpdateAvatarHead");
                                                QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                                v35.e eVar3 = v35.e.this;
                                                companion.getClass();
                                                companion.asyncToNativeMethod("tryUpdateAvatarHead", new Object[]{i.d(eVar3)}, (Function1<Object, Unit>) null);
                                                return Unit.INSTANCE;
                                            }
                                        }, 1, null);
                                    } else {
                                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("needUpdateAvatarHead: ");
                                        m16.append(gVar2.f397802f);
                                        m16.append(", headConfigs: ");
                                        StringBuilder m17 = NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(eVar2.f440937f, m16, ", backgroundConfigs: ");
                                        m17.append(eVar2.f440938h.size());
                                        kLog.i("NBPMainLoginViewModel", m17.toString());
                                    }
                                }
                                NearbyProUtilsKt.setEnterNBPMain(true);
                                NBPMainLoginViewModel.this.loginRetryCount = 0;
                            }
                        }
                    } else {
                        if (intValue == -13002) {
                            NBPMainLoginViewModel.this.getClass();
                            Utils.INSTANCE.currentBridgeModule().showAlert("\u5e10\u53f7\u5b58\u5728\u98ce\u9669", str2, "\u6211\u77e5\u9053\u4e86", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$showInBlackListAlert$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(e eVar3) {
                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (intValue != 15000) {
                            if (NBPMainLoginViewModel.this.loginRetryCount <= 3) {
                                KLog kLog2 = KLog.INSTANCE;
                                StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("retry login: ");
                                m18.append(NBPMainLoginViewModel.this.loginRetryCount);
                                m18.append(", ");
                                m18.append(intValue);
                                kLog2.i("NBPMainLoginViewModel", m18.toString());
                                NBPMainLoginViewModel nBPMainLoginViewModel3 = NBPMainLoginViewModel.this;
                                nBPMainLoginViewModel3.loginRetryCount++;
                                int i16 = nBPMainLoginViewModel3.currentLoginRequestId + 1;
                                nBPMainLoginViewModel3.currentLoginRequestId = i16;
                                nBPMainLoginViewModel3.innerStartLogin(i16);
                            } else {
                                NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("login error: ", intValue, KLog.INSTANCE, "NBPMainLoginViewModel");
                                NBPMainLoginViewModel.this.getClass();
                                Utils.INSTANCE.currentBridgeModule().qToast("\u7f51\u7edc\u5f02\u5e38\uff0c\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                            }
                        } else {
                            NBPMainLoginViewModel.this.getClass();
                            Utils.INSTANCE.currentBridgeModule().showAlert("\u7cfb\u7edf\u7ef4\u62a4\u4e2d", str2, "\u6211\u77e5\u9053\u4e86", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$showClosedAlert$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(e eVar3) {
                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        NBPMainKtxKt.getVmStore().onNBPLogin(false, null);
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onLocationPermissionGranted(boolean z16) {
        KLog.INSTANCE.i("NBPMainLoginViewModel", "nearby_location: login model onLocationPermissionGranted");
        startLocationForPermissionGranted(z16);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPageDidAppear() {
        if (this.enteredRealNameVerifyPage) {
            this.enteredRealNameVerifyPage = false;
            startLogin();
        } else if (this.lastReqError == -10004) {
            KLog.INSTANCE.i("NBPMainLoginViewModel", "location error in background. relocation");
            startLocationHeartBeatTimeout(true);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerWillDestroy() {
        if (this.hadLogin) {
            this.loginRepo.getClass();
            NBPMainLogoutRequest nBPMainLogoutRequest = new NBPMainLogoutRequest();
            NBPMainLoginRepo$logout$1 nBPMainLoginRepo$logout$1 = new Function1<PbResponse<f35.i>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginRepo$logout$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(PbResponse<f35.i> pbResponse) {
                    PbResponse<f35.i> pbResponse2 = pbResponse;
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("logout, code: ");
                    m3.append(pbResponse2.code);
                    m3.append(", msg: ");
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, pbResponse2.f114187msg, kLog, "NBPMainLoginRepo");
                    return Unit.INSTANCE;
                }
            };
            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.user_manager_svr.User.SsoLogout");
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.sendPbRequest$default(nBPMainLogoutRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nBPMainLoginRepo$logout$1), 6);
            this.hadLogin = false;
        }
        stopLocationTimeout();
        stopLocationHeartBeatTimeout();
        stopLoginTimeout();
    }

    public final boolean retryRequestLocation(boolean z16) {
        if (this.locationRetryCount > 3) {
            return false;
        }
        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("start retry location retryCount: "), this.locationRetryCount, KLog.INSTANCE, "NBPMainLoginViewModel");
        this.locationRetryCount++;
        startLocationForPermissionGranted(z16);
        return true;
    }

    public final void startLocationForPermissionGranted(final boolean z16) {
        stopLocationTimeout();
        this.locationTimeoutId = TimerKt.d(5000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$startLocationTimeout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("location timeout retry times:"), NBPMainLoginViewModel.this.locationRetryCount, KLog.INSTANCE, "NBPMainLoginViewModel");
                if (!NBPMainLoginViewModel.this.retryRequestLocation(z16)) {
                    Utils.INSTANCE.currentBridgeModule().qToast("\u7f51\u7edc\u5f02\u5e38\uff0c\u7a0d\u540e\u91cd\u8bd5", QToastMode.Info);
                }
                return Unit.INSTANCE;
            }
        });
        final long a16 = a.f453719a.a();
        QQNearbyModule.Companion.getInstance().startLocation(z16, new Function2<Integer, NBPSsoLocation, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$startLocationForPermissionGranted$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, NBPSsoLocation nBPSsoLocation) {
                int intValue = num.intValue();
                NBPSsoLocation nBPSsoLocation2 = nBPSsoLocation;
                long a17 = a.f453719a.a();
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("nearby_location: startLocation costTime:");
                m3.append(a17 - a16);
                m3.append(", code: ");
                m3.append(intValue);
                m3.append(TokenParser.SP);
                m3.append(nBPSsoLocation2.lat02);
                m3.append(TokenParser.SP);
                m3.append(nBPSsoLocation2.lon02);
                kLog.i("NBPMainLoginViewModel", m3.toString());
                NBPMainLoginViewModel nBPMainLoginViewModel = this;
                boolean z17 = z16;
                nBPMainLoginViewModel.stopLocationTimeout();
                if (intValue == 0) {
                    kLog.i("NBPMainLoginViewModel", "nearby_location: login model onLocationFinish success");
                    nBPMainLoginViewModel.locationSuccess = true;
                    nBPMainLoginViewModel.updateUserSelfLocation(nBPSsoLocation2);
                    NBPMainKtxKt.getVmStore().onLocationFinish(true, nBPSsoLocation2);
                    nBPMainLoginViewModel.locationRetryCount = 0;
                } else {
                    NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("nearby_location: login model onLocationFinish error:", intValue, kLog, "NBPMainLoginViewModel");
                    if (nBPMainLoginViewModel.locationRetryCount <= 3) {
                        nBPMainLoginViewModel.retryRequestLocation(z17);
                    } else {
                        NBPMainKtxKt.getVmStore().onLocationFinish(false, nBPSsoLocation2);
                        NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("nearby_location location error: ", intValue, kLog, "NBPMainLoginViewModel");
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void startLocationHeartBeatTimeout(final boolean z16) {
        stopLocationHeartBeatTimeout();
        if (this.nextReqInterval <= 0) {
            this.nextReqInterval = 120000;
        }
        this.locationHeartBeatTimeoutRef = TimerKt.d(z16 ? 0 : this.nextReqInterval, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$startLocationHeartBeatTimeout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("startLocationHeartBeat: "), z16, KLog.INSTANCE, "NBPMainLoginViewModel");
                QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                final NBPMainLoginViewModel nBPMainLoginViewModel = this;
                companion.startLocation(false, new Function2<Integer, NBPSsoLocation, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$startLocationHeartBeatTimeout$1.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Integer num, NBPSsoLocation nBPSsoLocation) {
                        int intValue = num.intValue();
                        NBPSsoLocation nBPSsoLocation2 = nBPSsoLocation;
                        KLog kLog = KLog.INSTANCE;
                        NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("location heat beat: ", intValue, kLog, "NBPMainLoginViewModel");
                        if (intValue == 0) {
                            final NBPMainLoginViewModel nBPMainLoginViewModel2 = NBPMainLoginViewModel.this;
                            nBPMainLoginViewModel2.getClass();
                            UserDataManager userDataManager = UserDataManager.INSTANCE;
                            NBPLatLng nBPLatLng = userDataManager.getUserSelfInfo().latLng;
                            boolean z17 = ((Math.abs(nBPLatLng.latitude - nBPSsoLocation2.lat02) > 1.0E-7d ? 1 : (Math.abs(nBPLatLng.latitude - nBPSsoLocation2.lat02) == 1.0E-7d ? 0 : -1)) > 0) || ((Math.abs(nBPLatLng.longitude - nBPSsoLocation2.lon02) > 1.0E-7d ? 1 : (Math.abs(nBPLatLng.longitude - nBPSsoLocation2.lon02) == 1.0E-7d ? 0 : -1)) > 0);
                            nBPMainLoginViewModel2.updateUserSelfLocation(nBPSsoLocation2);
                            if (z17) {
                                kLog.i("NBPMainLoginViewModel", "userLocation changed");
                                NBPViewModelStoreKt.getMapViewModel(NBPMainKtxKt.getVmStore()).getClass();
                            }
                            double d16 = 1000000;
                            k kVar = new k((String) null, (String) null, 0, (String) null, nBPSsoLocation2.address, 0, new n25.i((long) (nBPSsoLocation2.lat02 * d16), (long) (nBPSsoLocation2.lon02 * d16), 12), 0, 0, (String) null, (String) null, nBPSsoLocation2.province, nBPSsoLocation2.city, 0, 0, (String) null, nBPSsoLocation2.district, (String) null, (String) null, (String) null, 2025391);
                            NBPMainLoginRepo nBPMainLoginRepo = nBPMainLoginViewModel2.loginRepo;
                            final Function2<Boolean, Integer, Unit> function2 = new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel$onLocationHeartBeatFinish$1
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(Boolean bool, Integer num2) {
                                    bool.booleanValue();
                                    int intValue2 = num2.intValue();
                                    NBPMainLoginViewModel.this.nextReqInterval = intValue2 * 1000;
                                    NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("nextReqInterval location heart beat: ", intValue2, KLog.INSTANCE, "NBPMainLoginViewModel");
                                    NBPMainLoginViewModel.this.startLocationHeartBeatTimeout(false);
                                    return Unit.INSTANCE;
                                }
                            };
                            nBPMainLoginRepo.getClass();
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("reportLocation (");
                            n25.i iVar = kVar.C;
                            m3.append(iVar != null ? Long.valueOf(iVar.f418079d) : null);
                            m3.append(',');
                            n25.i iVar2 = kVar.C;
                            m3.append(iVar2 != null ? Long.valueOf(iVar2.f418080e) : null);
                            m3.append(')');
                            kLog.i("NBPMainLoginRepo", m3.toString());
                            ReportLocationRequest reportLocationRequest = new ReportLocationRequest(userDataManager.getSelfVaguePos(), kVar);
                            Function1<PbResponse<s>, Unit> function1 = new Function1<PbResponse<s>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginRepo$reportLocation$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(PbResponse<s> pbResponse) {
                                    PbResponse<s> pbResponse2 = pbResponse;
                                    KLog kLog2 = KLog.INSTANCE;
                                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("reportLocation nextReqInterval:");
                                    s sVar = pbResponse2.rsp;
                                    ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m16, sVar != null ? sVar.f440895e : -1, kLog2, "NBPMainLoginRepo");
                                    if (pbResponse2.success) {
                                        Function2<Boolean, Integer, Unit> function22 = function2;
                                        Boolean bool = Boolean.TRUE;
                                        s sVar2 = pbResponse2.rsp;
                                        function22.invoke(bool, Integer.valueOf(sVar2 != null ? sVar2.f440895e : -1));
                                    } else {
                                        function2.invoke(Boolean.FALSE, 0);
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.map_svr.Map.SsoReportLocation");
                            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.sendPbRequest$default(reportLocationRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function1), 6);
                        } else {
                            NBPMainLoginViewModel.this.startLocationHeartBeatTimeout(false);
                        }
                        NBPMainLoginViewModel.this.lastReqError = intValue;
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    public final void startLogin() {
        KLog.INSTANCE.i("NBPMainLoginViewModel", "start login");
        Iterator it = NBPMainKtxKt.getVmStore().viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).onNBPBeforeLogin();
        }
        innerStartLogin(this.currentLoginRequestId);
    }

    public final void stopLocationHeartBeatTimeout() {
        if (this.locationHeartBeatTimeoutRef.length() > 0) {
            TimerKt.b(this.locationHeartBeatTimeoutRef);
            this.locationHeartBeatTimeoutRef = "";
            KLog.INSTANCE.i("NBPMainLoginViewModel", "clear heat beat location timeout");
        }
    }

    public final void stopLocationTimeout() {
        if (this.locationTimeoutId.length() > 0) {
            TimerKt.b(this.locationTimeoutId);
            this.locationTimeoutId = "";
            KLog.INSTANCE.i("NBPMainLoginViewModel", "clear location timeout");
        }
    }

    public final void stopLoginTimeout() {
        if (this.loginTimeoutRef.length() > 0) {
            TimerKt.b(this.loginTimeoutRef);
            this.loginTimeoutRef = "";
        }
    }

    public final void updateUserSelfLocation(NBPSsoLocation nBPSsoLocation) {
        NBPLatLng nBPLatLng;
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        double d16 = nBPSsoLocation.lat02;
        if (d16 == 0.0d) {
            if (nBPSsoLocation.lon02 == 0.0d) {
                nBPLatLng = new NBPLatLng(nBPSsoLocation.lat84, nBPSsoLocation.lon84);
                userDataManager.updateAndSave(nBPLatLng, nBPSsoLocation.address, nBPSsoLocation.name, nBPSsoLocation.nation, nBPSsoLocation.province, nBPSsoLocation.city, nBPSsoLocation.district);
            }
        }
        nBPLatLng = new NBPLatLng(d16, nBPSsoLocation.lon02);
        userDataManager.updateAndSave(nBPLatLng, nBPSsoLocation.address, nBPSsoLocation.name, nBPSsoLocation.nation, nBPSsoLocation.province, nBPSsoLocation.city, nBPSsoLocation.district);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onLocationFinish(boolean z16, NBPSsoLocation nBPSsoLocation) {
        if (z16) {
            startLocationHeartBeatTimeout(true);
        }
    }
}
