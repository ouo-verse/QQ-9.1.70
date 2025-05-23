package com.tencent.hippykotlin.demo.pages.nearby.common_share;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionEvent;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.MiddlePageShareConfig;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyCalendarPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyFeedPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMoodPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.moodPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$handle$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$request$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.GetFeedStatusRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyMapThemeRepo$fetchFeedShareInfo$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.SsoGetFeedShareInfoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.PageLoadTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ShareItemData;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPBaseShareVM;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareDataExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPBasePosterView;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPThemeAttachConfig;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPThemePosterConfig;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.i;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import defpackage.j;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import oicq.wlogin_sdk.tools.util;
import p25.a;
import p35.ah;
import w25.g;
import x25.m;

/* loaded from: classes31.dex */
public final class NearbyCommonSharePage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyCommonSharePage.class, "isLoadingIndicatorEnabled", "isLoadingIndicatorEnabled()Z", 0)};
    public int appId;
    public long createTime;
    public final ReadWriteProperty isLoadingIndicatorEnabled$delegate;
    public boolean isPageClosing;
    public boolean poiCanceled;
    public final Lazy shareHelper$delegate;
    public int shareType;
    public NBPBaseShareVM<?> shareVM;

    public NearbyCommonSharePage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NearbyCommonShareHelper>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$shareHelper$2

            /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$shareHelper$2$1, reason: invalid class name */
            /* loaded from: classes31.dex */
            public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Integer, Boolean, String, Unit> {
                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(Integer num, Boolean bool, String str) {
                    int intValue = num.intValue();
                    boolean booleanValue = bool.booleanValue();
                    String str2 = str;
                    NearbyCommonSharePage nearbyCommonSharePage = (NearbyCommonSharePage) this.receiver;
                    KProperty<Object>[] kPropertyArr = NearbyCommonSharePage.$$delegatedProperties;
                    nearbyCommonSharePage.getClass();
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleSuccess: feedId=");
                    NBPBaseShareVM<?> nBPBaseShareVM = nearbyCommonSharePage.shareVM;
                    if (nBPBaseShareVM == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                        nBPBaseShareVM = null;
                    }
                    Object posterData = nBPBaseShareVM.getPosterData();
                    NearbyFeedPosterData nearbyFeedPosterData = posterData instanceof NearbyFeedPosterData ? (NearbyFeedPosterData) posterData : null;
                    m3.append(nearbyFeedPosterData != null ? nearbyFeedPosterData.feedId : null);
                    m3.append(" toast=");
                    m3.append(str2);
                    kLog.i("NearbyFeedSharePage", m3.toString());
                    if (str2 != null) {
                        Utils.INSTANCE.currentBridgeModule().qToast(str2, QToastMode.Success);
                    }
                    if (booleanValue) {
                        nearbyCommonSharePage.closeAndReport(intValue, true);
                    }
                    return Unit.INSTANCE;
                }

                public AnonymousClass1(Object obj) {
                    super(3, obj, NearbyCommonSharePage.class, "handleSuccess", "handleSuccess(IZLjava/lang/String;)V", 0);
                }
            }

            /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$shareHelper$2$2, reason: invalid class name */
            /* loaded from: classes31.dex */
            public final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<Boolean, String, Unit> {
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Boolean bool, String str) {
                    NearbyCommonSharePage.access$handleError((NearbyCommonSharePage) this.receiver, bool.booleanValue(), str);
                    return Unit.INSTANCE;
                }

                public AnonymousClass2(Object obj) {
                    super(2, obj, NearbyCommonSharePage.class, "handleError", "handleError(ZLjava/lang/String;)V", 0);
                }
            }

            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final NearbyCommonShareHelper invoke() {
                String pagerId = NearbyCommonSharePage.this.getPagerId();
                NBPBaseShareVM<?> nBPBaseShareVM = NearbyCommonSharePage.this.shareVM;
                if (nBPBaseShareVM == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                    nBPBaseShareVM = null;
                }
                return new NearbyCommonShareHelper(pagerId, nBPBaseShareVM, new AnonymousClass1(NearbyCommonSharePage.this), new AnonymousClass2(NearbyCommonSharePage.this));
            }
        });
        this.shareHelper$delegate = lazy;
        this.appId = 2;
        this.shareType = 4;
        this.isLoadingIndicatorEnabled$delegate = c.a(Boolean.FALSE);
    }

    public static final NearbyCommonShareHelper access$getShareHelper(NearbyCommonSharePage nearbyCommonSharePage) {
        return (NearbyCommonShareHelper) nearbyCommonSharePage.shareHelper$delegate.getValue();
    }

    public static final void access$handleError(NearbyCommonSharePage nearbyCommonSharePage, boolean z16, String str) {
        nearbyCommonSharePage.getClass();
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleError: feedId=");
        NBPBaseShareVM<?> nBPBaseShareVM = nearbyCommonSharePage.shareVM;
        if (nBPBaseShareVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareVM");
            nBPBaseShareVM = null;
        }
        Object posterData = nBPBaseShareVM.getPosterData();
        NearbyFeedPosterData nearbyFeedPosterData = posterData instanceof NearbyFeedPosterData ? (NearbyFeedPosterData) posterData : null;
        m3.append(nearbyFeedPosterData != null ? nearbyFeedPosterData.feedId : null);
        m3.append(" toast=");
        m3.append(str);
        kLog.e("NearbyFeedSharePage", m3.toString());
        if (str != null) {
            Utils.INSTANCE.currentBridgeModule().qToast(str, QToastMode.Info);
        }
        if (z16) {
            nearbyCommonSharePage.closeAndReport(5, false);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NearbyCommonSharePage nearbyCommonSharePage = NearbyCommonSharePage.this;
                ECTransitionViewKt.TransitionFadeInOutView(viewContainer, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionView eCTransitionView) {
                        ECTransitionView eCTransitionView2 = eCTransitionView;
                        final NearbyCommonSharePage nearbyCommonSharePage2 = NearbyCommonSharePage.this;
                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                eCTransitionAttr2.m140flex(1.0f);
                                eCTransitionAttr2.mo113backgroundColor(new h(0, 0, 0, 0.74f));
                                eCTransitionAttr2.paddingTop(NearbyCommonSharePage.this.getPageData().getStatusBarHeight());
                                NBPBaseShareVM<?> nBPBaseShareVM = NearbyCommonSharePage.this.shareVM;
                                if (nBPBaseShareVM == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                    nBPBaseShareVM = null;
                                }
                                eCTransitionAttr2.setTransitionAppear(!nBPBaseShareVM.isPageClosed());
                                return Unit.INSTANCE;
                            }
                        });
                        eCTransitionView2.event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                                eCTransitionEvent.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        if (!bool.booleanValue()) {
                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyCommonSharePage nearbyCommonSharePage3 = NearbyCommonSharePage.this;
                        w.a(eCTransitionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyCommonSharePage nearbyCommonSharePage4 = NearbyCommonSharePage.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        u uVar2 = uVar;
                                        final NearbyCommonSharePage nearbyCommonSharePage5 = NearbyCommonSharePage.this;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NearbyCommonSharePage nearbyCommonSharePage6 = NearbyCommonSharePage.this;
                                                KProperty<Object>[] kPropertyArr = NearbyCommonSharePage.$$delegatedProperties;
                                                nearbyCommonSharePage6.closeAndReport(5, false);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyCommonSharePage nearbyCommonSharePage6 = NearbyCommonSharePage.this;
                                        FrameEventKt.d(uVar2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(d dVar) {
                                                d dVar2 = dVar;
                                                NBPBaseShareVM<?> nBPBaseShareVM = NearbyCommonSharePage.this.shareVM;
                                                NBPBaseShareVM<?> nBPBaseShareVM2 = null;
                                                if (nBPBaseShareVM == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                    nBPBaseShareVM = null;
                                                }
                                                float height = dVar2.getHeight();
                                                ReadWriteProperty readWriteProperty = nBPBaseShareVM.posterContainerHeight$delegate;
                                                KProperty<?>[] kPropertyArr = NBPBaseShareVM.$$delegatedProperties;
                                                readWriteProperty.setValue(nBPBaseShareVM, kPropertyArr[11], Float.valueOf(height));
                                                NBPBaseShareVM<?> nBPBaseShareVM3 = NearbyCommonSharePage.this.shareVM;
                                                if (nBPBaseShareVM3 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                } else {
                                                    nBPBaseShareVM2 = nBPBaseShareVM3;
                                                }
                                                nBPBaseShareVM2.posterContainerWidth$delegate.setValue(nBPBaseShareVM2, kPropertyArr[12], Float.valueOf(dVar2.getWidth()));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyCommonSharePage nearbyCommonSharePage5 = NearbyCommonSharePage.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NearbyCommonSharePage nearbyCommonSharePage6 = NearbyCommonSharePage.this;
                                        return Boolean.valueOf(((Boolean) nearbyCommonSharePage6.isLoadingIndicatorEnabled$delegate.getValue(nearbyCommonSharePage6, NearbyCommonSharePage.$$delegatedProperties[0])).booleanValue());
                                    }
                                };
                                final NearbyCommonSharePage nearbyCommonSharePage6 = NearbyCommonSharePage.this;
                                ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NearbyCommonSharePage nearbyCommonSharePage7 = NearbyCommonSharePage.this;
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                final NearbyCommonSharePage nearbyCommonSharePage8 = NearbyCommonSharePage.this;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.absolutePositionAllZero();
                                                        NBPBaseShareVM<?> nBPBaseShareVM = NearbyCommonSharePage.this.shareVM;
                                                        NBPBaseShareVM<?> nBPBaseShareVM2 = null;
                                                        if (nBPBaseShareVM == null) {
                                                            Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                            nBPBaseShareVM = null;
                                                        }
                                                        float floatValue = ((Number) nBPBaseShareVM.posterContainerWidth$delegate.getValue(nBPBaseShareVM, NBPBaseShareVM.$$delegatedProperties[12])).floatValue();
                                                        NBPBaseShareVM<?> nBPBaseShareVM3 = NearbyCommonSharePage.this.shareVM;
                                                        if (nBPBaseShareVM3 == null) {
                                                            Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                        } else {
                                                            nBPBaseShareVM2 = nBPBaseShareVM3;
                                                        }
                                                        tVar2.size(floatValue, nBPBaseShareVM2.getPosterContainerHeight());
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                i.a(vVar4, new Function1<com.tencent.kuikly.core.views.h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3.4.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(com.tencent.kuikly.core.views.h hVar) {
                                                        hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3.4.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(f fVar) {
                                                                fVar.h(false);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyCommonSharePage nearbyCommonSharePage7 = NearbyCommonSharePage.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3.5
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NBPBaseShareVM<?> nBPBaseShareVM = NearbyCommonSharePage.this.shareVM;
                                        if (nBPBaseShareVM == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                            nBPBaseShareVM = null;
                                        }
                                        return Boolean.valueOf(nBPBaseShareVM.isDataReady());
                                    }
                                };
                                final NearbyCommonSharePage nearbyCommonSharePage8 = NearbyCommonSharePage.this;
                                ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.3.6
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        ConditionView conditionView2 = conditionView;
                                        KLog.INSTANCE.i("NearbyFeedSharePage", "PosterViewBuilder ready to create");
                                        NBPBaseShareVM<?> nBPBaseShareVM = NearbyCommonSharePage.this.shareVM;
                                        if (nBPBaseShareVM == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                            nBPBaseShareVM = null;
                                        }
                                        Function1<ViewContainer<?, ?>, Unit> function1 = ((NBPBasePosterView) nBPBaseShareVM.currentPoster$delegate.getValue(nBPBaseShareVM, NBPBaseShareVM.$$delegatedProperties[0])).posterViewBuilder;
                                        if (function1 != null) {
                                            function1.invoke(conditionView2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyCommonSharePage nearbyCommonSharePage4 = NearbyCommonSharePage.this;
                        ECTransitionViewKt.TransitionFromBottomView(eCTransitionView2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionView eCTransitionView3) {
                                ECTransitionView eCTransitionView4 = eCTransitionView3;
                                final NearbyCommonSharePage nearbyCommonSharePage5 = NearbyCommonSharePage.this;
                                eCTransitionView4.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                        NearbyCommonSharePage nearbyCommonSharePage6 = NearbyCommonSharePage.this;
                                        KProperty<Object>[] kPropertyArr = NearbyCommonSharePage.$$delegatedProperties;
                                        eCTransitionAttr.setTransitionAppear(nearbyCommonSharePage6.isReadyToShowShare());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyCommonSharePage nearbyCommonSharePage6 = NearbyCommonSharePage.this;
                                eCTransitionView4.event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                                        final NearbyCommonSharePage nearbyCommonSharePage7 = NearbyCommonSharePage.this;
                                        eCTransitionEvent.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Boolean bool) {
                                                NBPPoiPosterView b16;
                                                NearbyFeedPosterView b17;
                                                bool.booleanValue();
                                                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QRCode start to render, shareType: "), NearbyCommonSharePage.this.shareType, KLog.INSTANCE, "NearbyFeedSharePage");
                                                NearbyCommonSharePage nearbyCommonSharePage8 = NearbyCommonSharePage.this;
                                                int i3 = nearbyCommonSharePage8.shareType;
                                                NBPBaseShareVM<?> nBPBaseShareVM = null;
                                                if (i3 == 4) {
                                                    NBPBaseShareVM<?> nBPBaseShareVM2 = nearbyCommonSharePage8.shareVM;
                                                    if (nBPBaseShareVM2 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                    } else {
                                                        nBPBaseShareVM = nBPBaseShareVM2;
                                                    }
                                                    aa<NearbyFeedPosterView> aaVar = nBPBaseShareVM.shareFeedMainViewRef;
                                                    if (aaVar != null && (b17 = aaVar.b()) != null) {
                                                        ReadWriteProperty readWriteProperty = b17.showQRCode$delegate;
                                                        KProperty<?>[] kPropertyArr = NearbyFeedPosterView.$$delegatedProperties;
                                                        if (!((Boolean) readWriteProperty.getValue(b17, kPropertyArr[0])).booleanValue()) {
                                                            b17.showQRCode$delegate.setValue(b17, kPropertyArr[0], Boolean.TRUE);
                                                        }
                                                    }
                                                } else if (i3 == 3) {
                                                    NBPBaseShareVM<?> nBPBaseShareVM3 = nearbyCommonSharePage8.shareVM;
                                                    if (nBPBaseShareVM3 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                    } else {
                                                        nBPBaseShareVM = nBPBaseShareVM3;
                                                    }
                                                    aa<NBPPoiPosterView> aaVar2 = nBPBaseShareVM.shareMiddleMainViewRef;
                                                    if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
                                                        ReadWriteProperty readWriteProperty2 = b16.showQRCode$delegate;
                                                        KProperty<?>[] kPropertyArr2 = NBPPoiPosterView.$$delegatedProperties;
                                                        if (!((Boolean) readWriteProperty2.getValue(b16, kPropertyArr2[0])).booleanValue()) {
                                                            b16.showQRCode$delegate.setValue(b16, kPropertyArr2[0], Boolean.TRUE);
                                                        }
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyCommonSharePage nearbyCommonSharePage7 = NearbyCommonSharePage.this;
                                eCTransitionView4.addChild(new NBPSharePanelView(), new Function1<NBPSharePanelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPSharePanelView nBPSharePanelView) {
                                        NBPSharePanelView nBPSharePanelView2 = nBPSharePanelView;
                                        final NearbyCommonSharePage nearbyCommonSharePage8 = NearbyCommonSharePage.this;
                                        nBPSharePanelView2.attr(new Function1<NBPSharePanelViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.4.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPSharePanelViewAttr nBPSharePanelViewAttr) {
                                                NBPSharePanelViewAttr nBPSharePanelViewAttr2 = nBPSharePanelViewAttr;
                                                int i3 = NearbyCommonSharePage.this.shareType;
                                                if (i3 == 3 || i3 == 2 || i3 == 1) {
                                                    nBPSharePanelViewAttr2.showShareNBPFeed = true;
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyCommonSharePage nearbyCommonSharePage9 = NearbyCommonSharePage.this;
                                        nBPSharePanelView2.event(new Function1<NBPSharePanelViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.4.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPSharePanelViewEvent nBPSharePanelViewEvent) {
                                                NBPSharePanelViewEvent nBPSharePanelViewEvent2 = nBPSharePanelViewEvent;
                                                final NearbyCommonSharePage nearbyCommonSharePage10 = NearbyCommonSharePage.this;
                                                nBPSharePanelViewEvent2.onItemClickHandler = new Function1<ShareItemData, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.4.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    /* JADX WARN: Removed duplicated region for block: B:24:0x00cb  */
                                                    /* JADX WARN: Removed duplicated region for block: B:31:0x00e1  */
                                                    /* JADX WARN: Removed duplicated region for block: B:51:0x0127  */
                                                    /* JADX WARN: Removed duplicated region for block: B:58:0x013f  */
                                                    @Override // kotlin.jvm.functions.Function1
                                                    /*
                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                    */
                                                    public final Unit invoke(ShareItemData shareItemData) {
                                                        final int intValue;
                                                        NBPBaseShareVM<?> nBPBaseShareVM;
                                                        Integer num;
                                                        int i3;
                                                        Integer num2;
                                                        final ShareItemData shareItemData2 = shareItemData;
                                                        final NearbyCommonSharePage nearbyCommonSharePage11 = NearbyCommonSharePage.this;
                                                        if (shareItemData2 != null) {
                                                            KProperty<Object>[] kPropertyArr = NearbyCommonSharePage.$$delegatedProperties;
                                                            nearbyCommonSharePage11.getClass();
                                                            KLog kLog = KLog.INSTANCE;
                                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleShare: item=");
                                                            m3.append(shareItemData2.text);
                                                            m3.append(", ready=");
                                                            m3.append(nearbyCommonSharePage11.isReadyToShowShare());
                                                            m3.append(", QQArkVieTag=");
                                                            NBPBaseShareVM<?> nBPBaseShareVM2 = nearbyCommonSharePage11.shareVM;
                                                            NBPBaseShareVM<?> nBPBaseShareVM3 = null;
                                                            if (nBPBaseShareVM2 == null) {
                                                                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                nBPBaseShareVM2 = null;
                                                            }
                                                            m3.append(nBPBaseShareVM2.shareQQArkViewTag);
                                                            m3.append(", WXArkViewTag=");
                                                            NBPBaseShareVM<?> nBPBaseShareVM4 = nearbyCommonSharePage11.shareVM;
                                                            if (nBPBaseShareVM4 == null) {
                                                                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                nBPBaseShareVM4 = null;
                                                            }
                                                            m3.append(nBPBaseShareVM4.shareWXArkViewTag);
                                                            m3.append(", MainViewTag=");
                                                            NBPBaseShareVM<?> nBPBaseShareVM5 = nearbyCommonSharePage11.shareVM;
                                                            if (nBPBaseShareVM5 == null) {
                                                                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                nBPBaseShareVM5 = null;
                                                            }
                                                            NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, nBPBaseShareVM5.shareMainViewTag, kLog, "NearbyFeedSharePage");
                                                            if (nearbyCommonSharePage11.shareType == 4) {
                                                                if (Intrinsics.areEqual(shareItemData2, NBPSharePanelViewKt.ShareItemQQ)) {
                                                                    NBPBaseShareVM<?> nBPBaseShareVM6 = nearbyCommonSharePage11.shareVM;
                                                                    if (nBPBaseShareVM6 == null) {
                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                        nBPBaseShareVM6 = null;
                                                                    }
                                                                    num2 = nBPBaseShareVM6.shareQQArkViewTag;
                                                                } else if (Intrinsics.areEqual(shareItemData2, NBPSharePanelViewKt.ShareItemWechat)) {
                                                                    NBPBaseShareVM<?> nBPBaseShareVM7 = nearbyCommonSharePage11.shareVM;
                                                                    if (nBPBaseShareVM7 == null) {
                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                        nBPBaseShareVM7 = null;
                                                                    }
                                                                    num2 = nBPBaseShareVM7.shareWXArkViewTag;
                                                                } else if (Intrinsics.areEqual(shareItemData2, NBPSharePanelViewKt.ShareItemWechatMoment)) {
                                                                    NBPBaseShareVM<?> nBPBaseShareVM8 = nearbyCommonSharePage11.shareVM;
                                                                    if (nBPBaseShareVM8 == null) {
                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                        nBPBaseShareVM8 = null;
                                                                    }
                                                                    num2 = nBPBaseShareVM8.shareWXArkViewTag;
                                                                } else {
                                                                    NBPBaseShareVM<?> nBPBaseShareVM9 = nearbyCommonSharePage11.shareVM;
                                                                    if (nBPBaseShareVM9 == null) {
                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                        nBPBaseShareVM9 = null;
                                                                    }
                                                                    num2 = nBPBaseShareVM9.shareMainViewTag;
                                                                }
                                                                if (num2 != null) {
                                                                    intValue = num2.intValue();
                                                                    nBPBaseShareVM = nearbyCommonSharePage11.shareVM;
                                                                    if (nBPBaseShareVM == null) {
                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                        nBPBaseShareVM = null;
                                                                    }
                                                                    num = nBPBaseShareVM.shareMainViewTag;
                                                                    if (num != null && intValue == num.intValue()) {
                                                                        i3 = nearbyCommonSharePage11.shareType;
                                                                        if (i3 != 1) {
                                                                            NBPBaseShareVM<?> nBPBaseShareVM10 = nearbyCommonSharePage11.shareVM;
                                                                            if (nBPBaseShareVM10 == null) {
                                                                                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                            } else {
                                                                                nBPBaseShareVM3 = nBPBaseShareVM10;
                                                                            }
                                                                            nBPBaseShareVM3.shareMainViewReadyToCapture.executeOnDone(false, new Function1<Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$handleShare$4
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(Unit unit) {
                                                                                    Triple triple;
                                                                                    NearbyCommonShareHelper access$getShareHelper = NearbyCommonSharePage.access$getShareHelper(NearbyCommonSharePage.this);
                                                                                    ShareItemData shareItemData3 = shareItemData2;
                                                                                    int i16 = intValue;
                                                                                    NBPBaseShareVM<?> nBPBaseShareVM11 = NearbyCommonSharePage.this.shareVM;
                                                                                    if (nBPBaseShareVM11 == null) {
                                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                                        nBPBaseShareVM11 = null;
                                                                                    }
                                                                                    moodPosterData moodposterdata = (moodPosterData) nBPBaseShareVM11.moodPosterConfig$delegate.getValue(nBPBaseShareVM11, NBPBaseShareVM.$$delegatedProperties[3]);
                                                                                    NBPBaseShareVM<?> nBPBaseShareVM12 = NearbyCommonSharePage.this.shareVM;
                                                                                    if (nBPBaseShareVM12 == null) {
                                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                                        nBPBaseShareVM12 = null;
                                                                                    }
                                                                                    Object posterData = nBPBaseShareVM12.getPosterData();
                                                                                    Intrinsics.checkNotNull(posterData, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyCalendarPosterData");
                                                                                    NearbyCalendarPosterData nearbyCalendarPosterData = (NearbyCalendarPosterData) posterData;
                                                                                    if (nearbyCalendarPosterData instanceof NearbyFeedPosterData) {
                                                                                        NearbyFeedPosterData nearbyFeedPosterData = (NearbyFeedPosterData) nearbyCalendarPosterData;
                                                                                        triple = new Triple(Integer.valueOf(nearbyFeedPosterData.appId), nearbyFeedPosterData.feedId, null);
                                                                                    } else {
                                                                                        if (nearbyCalendarPosterData instanceof NearbyMiddlePosterData ? true : nearbyCalendarPosterData instanceof NearbyMoodPosterData ? true : nearbyCalendarPosterData instanceof NearbyCalendarPosterData) {
                                                                                            triple = new Triple(Integer.valueOf(access$getShareHelper.viewModel.appId), null, nearbyCalendarPosterData.getPosterData());
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                    int intValue2 = ((Number) triple.component1()).intValue();
                                                                                    String str = (String) triple.component2();
                                                                                    Object component3 = triple.component3();
                                                                                    KLog kLog2 = KLog.INSTANCE;
                                                                                    StringBuilder m16 = VasBusinessReportData$$ExternalSyntheticOutline0.m(NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("share: appId=", intValue2, ", target="), shareItemData3.text, ", feedId=", str, ", posterData=");
                                                                                    m16.append(component3);
                                                                                    kLog2.i("NearbyCommonShareHelper", m16.toString());
                                                                                    if (access$getShareHelper.viewModel.isQRCodeRendering()) {
                                                                                        kLog2.i("NearbyCommonShareHelper", "share is blocked by QRCode rendering");
                                                                                        ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast("\u6d77\u62a5\u6e32\u67d3\u4e2d\uff0c\u8bf7\u7a0d\u540e", QToastMode.Info);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemNBPFeed)) {
                                                                                        NearbyCommonShareHelper.access$shareByFeed(access$getShareHelper, i16, nearbyCalendarPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemCopyLink)) {
                                                                                        NearbyCommonShareHelper.access$shareByCopyLink(access$getShareHelper, moodposterdata, nearbyCalendarPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemSaveFile)) {
                                                                                        NearbyCommonShareHelper.access$shareBySaveFile(access$getShareHelper, i16);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemQQ)) {
                                                                                        NearbyCommonShareHelper.access$shareByQQ(access$getShareHelper, intValue2, i16, moodposterdata, nearbyCalendarPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemQQZone)) {
                                                                                        NearbyCommonShareHelper.access$shareByQQZone(access$getShareHelper, i16);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemWechat)) {
                                                                                        NearbyCommonShareHelper.access$shareByWechat(access$getShareHelper, i16, moodposterdata, nearbyCalendarPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemWechatMoment)) {
                                                                                        NearbyCommonShareHelper.access$shareByWechatMoment(access$getShareHelper, i16, moodposterdata, nearbyCalendarPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemXhs)) {
                                                                                        NearbyCommonShareHelper.access$shareByXhs(access$getShareHelper, i16, moodposterdata, nearbyCalendarPosterData);
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                        } else if (i3 == 2) {
                                                                            NBPBaseShareVM<?> nBPBaseShareVM11 = nearbyCommonSharePage11.shareVM;
                                                                            if (nBPBaseShareVM11 == null) {
                                                                                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                            } else {
                                                                                nBPBaseShareVM3 = nBPBaseShareVM11;
                                                                            }
                                                                            nBPBaseShareVM3.shareMainViewReadyToCapture.executeOnDone(false, new Function1<Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$handleShare$3
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(Unit unit) {
                                                                                    Triple triple;
                                                                                    NearbyCommonShareHelper access$getShareHelper = NearbyCommonSharePage.access$getShareHelper(NearbyCommonSharePage.this);
                                                                                    ShareItemData shareItemData3 = shareItemData2;
                                                                                    int i16 = intValue;
                                                                                    NBPBaseShareVM<?> nBPBaseShareVM12 = NearbyCommonSharePage.this.shareVM;
                                                                                    if (nBPBaseShareVM12 == null) {
                                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                                        nBPBaseShareVM12 = null;
                                                                                    }
                                                                                    moodPosterData moodposterdata = (moodPosterData) nBPBaseShareVM12.moodPosterConfig$delegate.getValue(nBPBaseShareVM12, NBPBaseShareVM.$$delegatedProperties[3]);
                                                                                    NBPBaseShareVM<?> nBPBaseShareVM13 = NearbyCommonSharePage.this.shareVM;
                                                                                    if (nBPBaseShareVM13 == null) {
                                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                                        nBPBaseShareVM13 = null;
                                                                                    }
                                                                                    Object posterData = nBPBaseShareVM13.getPosterData();
                                                                                    Intrinsics.checkNotNull(posterData, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMoodPosterData");
                                                                                    NearbyMoodPosterData nearbyMoodPosterData = (NearbyMoodPosterData) posterData;
                                                                                    if (nearbyMoodPosterData instanceof NearbyFeedPosterData) {
                                                                                        NearbyFeedPosterData nearbyFeedPosterData = (NearbyFeedPosterData) nearbyMoodPosterData;
                                                                                        triple = new Triple(Integer.valueOf(nearbyFeedPosterData.appId), nearbyFeedPosterData.feedId, null);
                                                                                    } else {
                                                                                        if (nearbyMoodPosterData instanceof NearbyMiddlePosterData ? true : nearbyMoodPosterData instanceof NearbyMoodPosterData ? true : nearbyMoodPosterData instanceof NearbyCalendarPosterData) {
                                                                                            triple = new Triple(Integer.valueOf(access$getShareHelper.viewModel.appId), null, nearbyMoodPosterData.getPosterData());
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                    int intValue2 = ((Number) triple.component1()).intValue();
                                                                                    String str = (String) triple.component2();
                                                                                    Object component3 = triple.component3();
                                                                                    KLog kLog2 = KLog.INSTANCE;
                                                                                    StringBuilder m16 = VasBusinessReportData$$ExternalSyntheticOutline0.m(NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("share: appId=", intValue2, ", target="), shareItemData3.text, ", feedId=", str, ", posterData=");
                                                                                    m16.append(component3);
                                                                                    kLog2.i("NearbyCommonShareHelper", m16.toString());
                                                                                    if (access$getShareHelper.viewModel.isQRCodeRendering()) {
                                                                                        kLog2.i("NearbyCommonShareHelper", "share is blocked by QRCode rendering");
                                                                                        ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast("\u6d77\u62a5\u6e32\u67d3\u4e2d\uff0c\u8bf7\u7a0d\u540e", QToastMode.Info);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemNBPFeed)) {
                                                                                        NearbyCommonShareHelper.access$shareByFeed(access$getShareHelper, i16, nearbyMoodPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemCopyLink)) {
                                                                                        NearbyCommonShareHelper.access$shareByCopyLink(access$getShareHelper, moodposterdata, nearbyMoodPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemSaveFile)) {
                                                                                        NearbyCommonShareHelper.access$shareBySaveFile(access$getShareHelper, i16);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemQQ)) {
                                                                                        NearbyCommonShareHelper.access$shareByQQ(access$getShareHelper, intValue2, i16, moodposterdata, nearbyMoodPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemQQZone)) {
                                                                                        NearbyCommonShareHelper.access$shareByQQZone(access$getShareHelper, i16);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemWechat)) {
                                                                                        NearbyCommonShareHelper.access$shareByWechat(access$getShareHelper, i16, moodposterdata, nearbyMoodPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemWechatMoment)) {
                                                                                        NearbyCommonShareHelper.access$shareByWechatMoment(access$getShareHelper, i16, moodposterdata, nearbyMoodPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemXhs)) {
                                                                                        NearbyCommonShareHelper.access$shareByXhs(access$getShareHelper, i16, moodposterdata, nearbyMoodPosterData);
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                        } else if (i3 == 3) {
                                                                            NBPBaseShareVM<?> nBPBaseShareVM12 = nearbyCommonSharePage11.shareVM;
                                                                            if (nBPBaseShareVM12 == null) {
                                                                                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                            } else {
                                                                                nBPBaseShareVM3 = nBPBaseShareVM12;
                                                                            }
                                                                            nBPBaseShareVM3.shareMainViewReadyToCapture.executeOnDone(false, new Function1<Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$handleShare$2
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(Unit unit) {
                                                                                    Triple triple;
                                                                                    NearbyCommonShareHelper access$getShareHelper = NearbyCommonSharePage.access$getShareHelper(NearbyCommonSharePage.this);
                                                                                    ShareItemData shareItemData3 = shareItemData2;
                                                                                    int i16 = intValue;
                                                                                    NBPBaseShareVM<?> nBPBaseShareVM13 = NearbyCommonSharePage.this.shareVM;
                                                                                    if (nBPBaseShareVM13 == null) {
                                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                                        nBPBaseShareVM13 = null;
                                                                                    }
                                                                                    MiddlePageShareConfig middlePageShareConfig = (MiddlePageShareConfig) nBPBaseShareVM13.middlePosterConfig$delegate.getValue(nBPBaseShareVM13, NBPBaseShareVM.$$delegatedProperties[2]);
                                                                                    NBPBaseShareVM<?> nBPBaseShareVM14 = NearbyCommonSharePage.this.shareVM;
                                                                                    if (nBPBaseShareVM14 == null) {
                                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                                        nBPBaseShareVM14 = null;
                                                                                    }
                                                                                    Object posterData = nBPBaseShareVM14.getPosterData();
                                                                                    Intrinsics.checkNotNull(posterData, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData");
                                                                                    NearbyMiddlePosterData nearbyMiddlePosterData = (NearbyMiddlePosterData) posterData;
                                                                                    if (nearbyMiddlePosterData instanceof NearbyFeedPosterData) {
                                                                                        NearbyFeedPosterData nearbyFeedPosterData = (NearbyFeedPosterData) nearbyMiddlePosterData;
                                                                                        triple = new Triple(Integer.valueOf(nearbyFeedPosterData.appId), nearbyFeedPosterData.feedId, null);
                                                                                    } else {
                                                                                        if (nearbyMiddlePosterData instanceof NearbyMiddlePosterData ? true : nearbyMiddlePosterData instanceof NearbyMoodPosterData ? true : nearbyMiddlePosterData instanceof NearbyCalendarPosterData) {
                                                                                            triple = new Triple(Integer.valueOf(access$getShareHelper.viewModel.appId), null, nearbyMiddlePosterData.getPosterData());
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                    int intValue2 = ((Number) triple.component1()).intValue();
                                                                                    String str = (String) triple.component2();
                                                                                    Object component3 = triple.component3();
                                                                                    KLog kLog2 = KLog.INSTANCE;
                                                                                    StringBuilder m16 = VasBusinessReportData$$ExternalSyntheticOutline0.m(NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("share: appId=", intValue2, ", target="), shareItemData3.text, ", feedId=", str, ", posterData=");
                                                                                    m16.append(component3);
                                                                                    kLog2.i("NearbyCommonShareHelper", m16.toString());
                                                                                    if (access$getShareHelper.viewModel.isQRCodeRendering()) {
                                                                                        kLog2.i("NearbyCommonShareHelper", "share is blocked by QRCode rendering");
                                                                                        ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast("\u6d77\u62a5\u6e32\u67d3\u4e2d\uff0c\u8bf7\u7a0d\u540e", QToastMode.Info);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemNBPFeed)) {
                                                                                        NearbyCommonShareHelper.access$shareByFeed(access$getShareHelper, i16, nearbyMiddlePosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemCopyLink)) {
                                                                                        NearbyCommonShareHelper.access$shareByCopyLink(access$getShareHelper, middlePageShareConfig, nearbyMiddlePosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemSaveFile)) {
                                                                                        NearbyCommonShareHelper.access$shareBySaveFile(access$getShareHelper, i16);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemQQ)) {
                                                                                        NearbyCommonShareHelper.access$shareByQQ(access$getShareHelper, intValue2, i16, middlePageShareConfig, nearbyMiddlePosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemQQZone)) {
                                                                                        NearbyCommonShareHelper.access$shareByQQZone(access$getShareHelper, i16);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemWechat)) {
                                                                                        NearbyCommonShareHelper.access$shareByWechat(access$getShareHelper, i16, middlePageShareConfig, nearbyMiddlePosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemWechatMoment)) {
                                                                                        NearbyCommonShareHelper.access$shareByWechatMoment(access$getShareHelper, i16, middlePageShareConfig, nearbyMiddlePosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemXhs)) {
                                                                                        NearbyCommonShareHelper.access$shareByXhs(access$getShareHelper, i16, middlePageShareConfig, nearbyMiddlePosterData);
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                        } else if (i3 == 4) {
                                                                            NBPBaseShareVM<?> nBPBaseShareVM13 = nearbyCommonSharePage11.shareVM;
                                                                            if (nBPBaseShareVM13 == null) {
                                                                                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                            } else {
                                                                                nBPBaseShareVM3 = nBPBaseShareVM13;
                                                                            }
                                                                            nBPBaseShareVM3.shareMainViewReadyToCapture.executeOnDone(false, new Function1<Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$handleShare$1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(Unit unit) {
                                                                                    Triple triple;
                                                                                    NearbyCommonShareHelper access$getShareHelper = NearbyCommonSharePage.access$getShareHelper(NearbyCommonSharePage.this);
                                                                                    ShareItemData shareItemData3 = shareItemData2;
                                                                                    int i16 = intValue;
                                                                                    NBPBaseShareVM<?> nBPBaseShareVM14 = NearbyCommonSharePage.this.shareVM;
                                                                                    if (nBPBaseShareVM14 == null) {
                                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                                        nBPBaseShareVM14 = null;
                                                                                    }
                                                                                    NBPThemePosterConfig posterConfig = nBPBaseShareVM14.getPosterConfig();
                                                                                    NBPBaseShareVM<?> nBPBaseShareVM15 = NearbyCommonSharePage.this.shareVM;
                                                                                    if (nBPBaseShareVM15 == null) {
                                                                                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                                        nBPBaseShareVM15 = null;
                                                                                    }
                                                                                    Object posterData = nBPBaseShareVM15.getPosterData();
                                                                                    Intrinsics.checkNotNull(posterData, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyFeedPosterData");
                                                                                    NearbyFeedPosterData nearbyFeedPosterData = (NearbyFeedPosterData) posterData;
                                                                                    if (nearbyFeedPosterData instanceof NearbyFeedPosterData) {
                                                                                        triple = new Triple(Integer.valueOf(nearbyFeedPosterData.appId), nearbyFeedPosterData.feedId, null);
                                                                                    } else {
                                                                                        if (nearbyFeedPosterData instanceof NearbyMiddlePosterData ? true : nearbyFeedPosterData instanceof NearbyMoodPosterData ? true : nearbyFeedPosterData instanceof NearbyCalendarPosterData) {
                                                                                            triple = new Triple(Integer.valueOf(access$getShareHelper.viewModel.appId), null, nearbyFeedPosterData.getPosterData());
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                    int intValue2 = ((Number) triple.component1()).intValue();
                                                                                    String str = (String) triple.component2();
                                                                                    Object component3 = triple.component3();
                                                                                    KLog kLog2 = KLog.INSTANCE;
                                                                                    StringBuilder m16 = VasBusinessReportData$$ExternalSyntheticOutline0.m(NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("share: appId=", intValue2, ", target="), shareItemData3.text, ", feedId=", str, ", posterData=");
                                                                                    m16.append(component3);
                                                                                    kLog2.i("NearbyCommonShareHelper", m16.toString());
                                                                                    if (access$getShareHelper.viewModel.isQRCodeRendering()) {
                                                                                        kLog2.i("NearbyCommonShareHelper", "share is blocked by QRCode rendering");
                                                                                        ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast("\u6d77\u62a5\u6e32\u67d3\u4e2d\uff0c\u8bf7\u7a0d\u540e", QToastMode.Info);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemNBPFeed)) {
                                                                                        NearbyCommonShareHelper.access$shareByFeed(access$getShareHelper, i16, nearbyFeedPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemCopyLink)) {
                                                                                        NearbyCommonShareHelper.access$shareByCopyLink(access$getShareHelper, posterConfig, nearbyFeedPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemSaveFile)) {
                                                                                        NearbyCommonShareHelper.access$shareBySaveFile(access$getShareHelper, i16);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemQQ)) {
                                                                                        NearbyCommonShareHelper.access$shareByQQ(access$getShareHelper, intValue2, i16, posterConfig, nearbyFeedPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemQQZone)) {
                                                                                        NearbyCommonShareHelper.access$shareByQQZone(access$getShareHelper, i16);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemWechat)) {
                                                                                        NearbyCommonShareHelper.access$shareByWechat(access$getShareHelper, i16, posterConfig, nearbyFeedPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemWechatMoment)) {
                                                                                        NearbyCommonShareHelper.access$shareByWechatMoment(access$getShareHelper, i16, posterConfig, nearbyFeedPosterData);
                                                                                    } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemXhs)) {
                                                                                        NearbyCommonShareHelper.access$shareByXhs(access$getShareHelper, i16, posterConfig, nearbyFeedPosterData);
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                        }
                                                                    } else if (nearbyCommonSharePage11.shareType == 4) {
                                                                        NBPBaseShareVM<?> nBPBaseShareVM14 = nearbyCommonSharePage11.shareVM;
                                                                        if (nBPBaseShareVM14 == null) {
                                                                            Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                        } else {
                                                                            nBPBaseShareVM3 = nBPBaseShareVM14;
                                                                        }
                                                                        nBPBaseShareVM3.shareMainViewReadyToCapture.executeOnDone(false, new Function1<Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$handleShare$5
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Unit unit) {
                                                                                Triple triple;
                                                                                NearbyCommonShareHelper access$getShareHelper = NearbyCommonSharePage.access$getShareHelper(NearbyCommonSharePage.this);
                                                                                ShareItemData shareItemData3 = shareItemData2;
                                                                                int i16 = intValue;
                                                                                NBPBaseShareVM<?> nBPBaseShareVM15 = NearbyCommonSharePage.this.shareVM;
                                                                                if (nBPBaseShareVM15 == null) {
                                                                                    Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                                    nBPBaseShareVM15 = null;
                                                                                }
                                                                                NBPThemePosterConfig posterConfig = nBPBaseShareVM15.getPosterConfig();
                                                                                NBPBaseShareVM<?> nBPBaseShareVM16 = NearbyCommonSharePage.this.shareVM;
                                                                                if (nBPBaseShareVM16 == null) {
                                                                                    Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                                    nBPBaseShareVM16 = null;
                                                                                }
                                                                                Object posterData = nBPBaseShareVM16.getPosterData();
                                                                                Intrinsics.checkNotNull(posterData, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyFeedPosterData");
                                                                                NearbyFeedPosterData nearbyFeedPosterData = (NearbyFeedPosterData) posterData;
                                                                                if (nearbyFeedPosterData instanceof NearbyFeedPosterData) {
                                                                                    triple = new Triple(Integer.valueOf(nearbyFeedPosterData.appId), nearbyFeedPosterData.feedId, null);
                                                                                } else {
                                                                                    if (nearbyFeedPosterData instanceof NearbyMiddlePosterData ? true : nearbyFeedPosterData instanceof NearbyMoodPosterData ? true : nearbyFeedPosterData instanceof NearbyCalendarPosterData) {
                                                                                        triple = new Triple(Integer.valueOf(access$getShareHelper.viewModel.appId), null, nearbyFeedPosterData.getPosterData());
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                                int intValue2 = ((Number) triple.component1()).intValue();
                                                                                String str = (String) triple.component2();
                                                                                Object component3 = triple.component3();
                                                                                KLog kLog2 = KLog.INSTANCE;
                                                                                StringBuilder m16 = VasBusinessReportData$$ExternalSyntheticOutline0.m(NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("share: appId=", intValue2, ", target="), shareItemData3.text, ", feedId=", str, ", posterData=");
                                                                                m16.append(component3);
                                                                                kLog2.i("NearbyCommonShareHelper", m16.toString());
                                                                                if (access$getShareHelper.viewModel.isQRCodeRendering()) {
                                                                                    kLog2.i("NearbyCommonShareHelper", "share is blocked by QRCode rendering");
                                                                                    ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast("\u6d77\u62a5\u6e32\u67d3\u4e2d\uff0c\u8bf7\u7a0d\u540e", QToastMode.Info);
                                                                                } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemNBPFeed)) {
                                                                                    NearbyCommonShareHelper.access$shareByFeed(access$getShareHelper, i16, nearbyFeedPosterData);
                                                                                } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemCopyLink)) {
                                                                                    NearbyCommonShareHelper.access$shareByCopyLink(access$getShareHelper, posterConfig, nearbyFeedPosterData);
                                                                                } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemSaveFile)) {
                                                                                    NearbyCommonShareHelper.access$shareBySaveFile(access$getShareHelper, i16);
                                                                                } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemQQ)) {
                                                                                    NearbyCommonShareHelper.access$shareByQQ(access$getShareHelper, intValue2, i16, posterConfig, nearbyFeedPosterData);
                                                                                } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemQQZone)) {
                                                                                    NearbyCommonShareHelper.access$shareByQQZone(access$getShareHelper, i16);
                                                                                } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemWechat)) {
                                                                                    NearbyCommonShareHelper.access$shareByWechat(access$getShareHelper, i16, posterConfig, nearbyFeedPosterData);
                                                                                } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemWechatMoment)) {
                                                                                    NearbyCommonShareHelper.access$shareByWechatMoment(access$getShareHelper, i16, posterConfig, nearbyFeedPosterData);
                                                                                } else if (Intrinsics.areEqual(shareItemData3, NBPSharePanelViewKt.ShareItemXhs)) {
                                                                                    NearbyCommonShareHelper.access$shareByXhs(access$getShareHelper, i16, posterConfig, nearbyFeedPosterData);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                    }
                                                                }
                                                            } else {
                                                                NBPBaseShareVM<?> nBPBaseShareVM15 = nearbyCommonSharePage11.shareVM;
                                                                if (nBPBaseShareVM15 == null) {
                                                                    Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                                                    nBPBaseShareVM15 = null;
                                                                }
                                                                Integer num3 = nBPBaseShareVM15.shareMainViewTag;
                                                                if (num3 != null) {
                                                                    intValue = num3.intValue();
                                                                    nBPBaseShareVM = nearbyCommonSharePage11.shareVM;
                                                                    if (nBPBaseShareVM == null) {
                                                                    }
                                                                    num = nBPBaseShareVM.shareMainViewTag;
                                                                    if (num != null) {
                                                                        i3 = nearbyCommonSharePage11.shareType;
                                                                        if (i3 != 1) {
                                                                        }
                                                                    }
                                                                    if (nearbyCommonSharePage11.shareType == 4) {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final NearbyCommonSharePage nearbyCommonSharePage11 = NearbyCommonSharePage.this;
                                                nBPSharePanelViewEvent2.onCloseClickHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.4.3.2.2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        NearbyCommonSharePage nearbyCommonSharePage12 = NearbyCommonSharePage.this;
                                                        KProperty<Object>[] kPropertyArr = NearbyCommonSharePage.$$delegatedProperties;
                                                        nearbyCommonSharePage12.closeAndReport(5, false);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyCommonSharePage nearbyCommonSharePage5 = NearbyCommonSharePage.this;
                        ConditionViewKt.c(eCTransitionView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPBaseShareVM<?> nBPBaseShareVM = NearbyCommonSharePage.this.shareVM;
                                if (nBPBaseShareVM == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                    nBPBaseShareVM = null;
                                }
                                return Boolean.valueOf(((Boolean) nBPBaseShareVM.isPreparing$delegate.getValue(nBPBaseShareVM, NBPBaseShareVM.$$delegatedProperties[4])).booleanValue());
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.6
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.6.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.6.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.absolutePositionAllZero();
                                                tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().l());
                                                tVar2.mo113backgroundColor(new h(0, 0, 0, 0.74f));
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        i.a(vVar2, new Function1<com.tencent.kuikly.core.views.h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.6.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.h hVar) {
                                                hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage.body.1.1.6.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(f fVar) {
                                                        fVar.h(false);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    public final void closeAndReport(int i3, boolean z16) {
        if (this.isPageClosing) {
            return;
        }
        NBPBaseShareVM<?> nBPBaseShareVM = this.shareVM;
        NBPBaseShareVM<?> nBPBaseShareVM2 = null;
        if (nBPBaseShareVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareVM");
            nBPBaseShareVM = null;
        }
        if (nBPBaseShareVM.isPageClosed()) {
            return;
        }
        this.isPageClosing = true;
        NBPBaseShareVM<?> nBPBaseShareVM3 = this.shareVM;
        if (nBPBaseShareVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareVM");
            nBPBaseShareVM3 = null;
        }
        nBPBaseShareVM3.reportPageExposure(false);
        if (z16) {
            NBPBaseShareVM<?> nBPBaseShareVM4 = this.shareVM;
            if (nBPBaseShareVM4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                nBPBaseShareVM4 = null;
            }
            nBPBaseShareVM4.getClass();
            e eVar = new e();
            eVar.t("share_source", i3);
            Unit unit = Unit.INSTANCE;
            e dTElementParams = nBPBaseShareVM4.getDTElementParams(eVar);
            dTElementParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_kl_share_success", dTElementParams);
        }
        long NBPCurrentTime = 1000 - (APICallTechReporterKt.NBPCurrentTime() - this.createTime);
        if (NBPCurrentTime > 0) {
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$closeAndReport$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPBaseShareVM<?> nBPBaseShareVM5 = NearbyCommonSharePage.this.shareVM;
                    if (nBPBaseShareVM5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                        nBPBaseShareVM5 = null;
                    }
                    nBPBaseShareVM5.isPageClosed$delegate.setValue(nBPBaseShareVM5, NBPBaseShareVM.$$delegatedProperties[10], Boolean.TRUE);
                    NearbyCommonSharePage.this.isPageClosing = false;
                    return Unit.INSTANCE;
                }
            };
            KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
            TimerKt.e(getPagerId(), (int) NBPCurrentTime, function0);
            return;
        }
        NBPBaseShareVM<?> nBPBaseShareVM5 = this.shareVM;
        if (nBPBaseShareVM5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareVM");
        } else {
            nBPBaseShareVM2 = nBPBaseShareVM5;
        }
        nBPBaseShareVM2.isPageClosed$delegate.setValue(nBPBaseShareVM2, NBPBaseShareVM.$$delegatedProperties[10], Boolean.TRUE);
        this.isPageClosing = false;
    }

    public final boolean isReadyToShowShare() {
        NBPBaseShareVM<?> nBPBaseShareVM = this.shareVM;
        NBPBaseShareVM<?> nBPBaseShareVM2 = null;
        if (nBPBaseShareVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareVM");
            nBPBaseShareVM = null;
        }
        if (nBPBaseShareVM.isDataReady()) {
            NBPBaseShareVM<?> nBPBaseShareVM3 = this.shareVM;
            if (nBPBaseShareVM3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                nBPBaseShareVM3 = null;
            }
            if (nBPBaseShareVM3.isMainViewRendered()) {
                NBPBaseShareVM<?> nBPBaseShareVM4 = this.shareVM;
                if (nBPBaseShareVM4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                    nBPBaseShareVM4 = null;
                }
                if (nBPBaseShareVM4.isQQArkViewRendered()) {
                    NBPBaseShareVM<?> nBPBaseShareVM5 = this.shareVM;
                    if (nBPBaseShareVM5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                        nBPBaseShareVM5 = null;
                    }
                    if (nBPBaseShareVM5.isWXArkViewRendered()) {
                        NBPBaseShareVM<?> nBPBaseShareVM6 = this.shareVM;
                        if (nBPBaseShareVM6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                        } else {
                            nBPBaseShareVM2 = nBPBaseShareVM6;
                        }
                        if (!nBPBaseShareVM2.isPageClosed()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            closeAndReport(5, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011e  */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31, types: [com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyFeedPosterData, T] */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r2v19, types: [com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyCalendarPosterData, T] */
    /* JADX WARN: Type inference failed for: r3v9, types: [T, com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMoodPosterData] */
    /* JADX WARN: Type inference failed for: r4v14, types: [T, com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData] */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void created() {
        boolean z16;
        k25.d dVar;
        g gVar;
        final ?? r16;
        Object orNull;
        Object firstOrNull;
        final NBPThemePosterConfig nBPThemePosterConfig;
        String decodeToString;
        String decodeToString2;
        super.created();
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("created: pageData=");
        m3.append(getPageData().n());
        kLog.i("NearbyFeedSharePage", m3.toString());
        this.createTime = APICallTechReporterKt.NBPCurrentTime();
        getPageData().n().j("nbp_source");
        this.appId = getPagerData().n().k("app_id", 2);
        this.shareType = getPageData().n().k(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, 4);
        this.poiCanceled = getPageData().n().g("poi_canceled", false);
        QQNearbyModule.Companion companion = QQNearbyModule.Companion;
        Object[] sharePenetratePageData = companion.getInstance().getSharePenetratePageData();
        if (sharePenetratePageData != null) {
            if (!(sharePenetratePageData.length == 0)) {
                z16 = false;
                if (!z16) {
                    kLog.e("NearbyFeedSharePage", "created: \u6570\u636e\u9519\u8bef\uff0c\u5173\u95ed\u9875\u9762");
                    QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.closePage$default();
                    return;
                }
                int i3 = this.shareType;
                NBPBaseShareVM<?> nBPBaseShareVM = null;
                if (i3 == 1) {
                    Object[] sharePenetratePageData2 = companion.getInstance().getSharePenetratePageData();
                    long o16 = getPageData().n().o("timestamp", APICallTechReporterKt.NBPCurrentTime());
                    try {
                        k25.d dVar2 = new k25.d(null, null, null, 0, null, null, null, 127, null);
                        Object obj = sharePenetratePageData2 != null ? sharePenetratePageData2[0] : null;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
                        dVar = (k25.d) c45.i.b(dVar2, (byte[]) obj);
                    } catch (Exception unused) {
                        dVar = new k25.d(null, null, null, 0, null, null, null, 127, null);
                    }
                    if (dVar.f411451e.length() == 0) {
                        KLog.INSTANCE.e("NearbyFeedSharePage", "created: \u6570\u636e\u9519\u8bef\uff0c\u5173\u95ed\u9875\u9762");
                        Utils.INSTANCE.currentBridgeModule().qToast("\u6570\u636e\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                    }
                    final ?? nearbyCalendarPosterData = new NearbyCalendarPosterData(dVar, o16);
                    Function1<NBPBaseShareVM<NearbyCalendarPosterData>, Unit> function1 = new Function1<NBPBaseShareVM<NearbyCalendarPosterData>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$created$4

                        /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$created$4$1, reason: invalid class name */
                        /* loaded from: classes31.dex */
                        public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Boolean, String, Unit> {
                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Boolean bool, String str) {
                                NearbyCommonSharePage.access$handleError((NearbyCommonSharePage) this.receiver, bool.booleanValue(), str);
                                return Unit.INSTANCE;
                            }

                            public AnonymousClass1(Object obj) {
                                super(2, obj, NearbyCommonSharePage.class, "handleError", "handleError(ZLjava/lang/String;)V", 0);
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(NBPBaseShareVM<NearbyCalendarPosterData> nBPBaseShareVM2) {
                            NBPBaseShareVM<NearbyCalendarPosterData> nBPBaseShareVM3 = nBPBaseShareVM2;
                            NearbyCommonSharePage.this.shareVM = nBPBaseShareVM3;
                            NearbyCalendarPosterData nearbyCalendarPosterData2 = nearbyCalendarPosterData;
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(NearbyCommonSharePage.this);
                            NBPCalendarShareVM.Companion.getClass();
                            KLog kLog2 = KLog.INSTANCE;
                            kLog2.i("NBPMoodShareVM", "generate middle page Poster");
                            NBPCalendarShareVM nBPCalendarShareVM = new NBPCalendarShareVM(nBPBaseShareVM3, nearbyCalendarPosterData2, anonymousClass1);
                            kLog2.i("NBPMoodShareVM", "start to initData");
                            PageLoadTechReporter pageLoadTechReporter = new PageLoadTechReporter("nearby_common_share", 2);
                            nBPCalendarShareVM.pageLoadReporter = pageLoadTechReporter;
                            pageLoadTechReporter.startPart1();
                            nBPCalendarShareVM.shareVM.setPosterData(nearbyCalendarPosterData2);
                            k25.d dVar3 = nearbyCalendarPosterData2.luckyCard;
                            ReadWriteProperty readWriteProperty = nBPCalendarShareVM.luckyCard$delegate;
                            KProperty<?>[] kPropertyArr = NBPCalendarShareVM.$$delegatedProperties;
                            readWriteProperty.setValue(nBPCalendarShareVM, kPropertyArr[0], dVar3);
                            nBPCalendarShareVM.shareVM.setMainViewRendered();
                            nBPCalendarShareVM.shareVM.setQQArkViewRendered();
                            nBPCalendarShareVM.shareVM.setWXArkViewRendered();
                            kLog2.d("NBPMoodShareVM", "initData: cfg=" + ((k25.d) nBPCalendarShareVM.luckyCard$delegate.getValue(nBPCalendarShareVM, kPropertyArr[0])));
                            nBPCalendarShareVM.shareVM.setDataReady();
                            PageLoadTechReporter pageLoadTechReporter2 = nBPCalendarShareVM.pageLoadReporter;
                            if (pageLoadTechReporter2 != null) {
                                pageLoadTechReporter2.finishPart1();
                            }
                            PageLoadTechReporter pageLoadTechReporter3 = nBPCalendarShareVM.pageLoadReporter;
                            if (pageLoadTechReporter3 != null) {
                                pageLoadTechReporter3.startPart2();
                            }
                            PageLoadTechReporter pageLoadTechReporter4 = nBPCalendarShareVM.pageLoadReporter;
                            if (pageLoadTechReporter4 != null) {
                                pageLoadTechReporter4.startPart3();
                            }
                            PageLoadTechReporter pageLoadTechReporter5 = nBPCalendarShareVM.pageLoadReporter;
                            if (pageLoadTechReporter5 != null) {
                                pageLoadTechReporter5.startPart4();
                            }
                            new com.tencent.kuikly.core.base.w(315.0f, 424.0f);
                            NBPBasePosterView nBPBasePosterView = new NBPBasePosterView((Function1) nBPCalendarShareVM.middleViewBuilder$delegate.getValue(), nBPCalendarShareVM.posterData);
                            kLog2.i("NearbyFeedSharePage", "created: calendarPagePoster");
                            nBPBaseShareVM3.setCurrentPoster(nBPBasePosterView);
                            return Unit.INSTANCE;
                        }
                    };
                    int i16 = this.appId;
                    new NearbyCommonSharePage$initShareVM$shareVM$1(this);
                    NBPBaseShareVM<NearbyCalendarPosterData> nBPBaseShareVM2 = new NBPBaseShareVM<>(i16);
                    nBPBaseShareVM2.posterData = nearbyCalendarPosterData;
                    nBPBaseShareVM2.poiCanceled = this.poiCanceled;
                    function1.invoke(nBPBaseShareVM2);
                } else if (i3 == 2) {
                    if (!(sharePenetratePageData.length == 0) && sharePenetratePageData.length >= 2) {
                        try {
                            g gVar2 = new g(0L, null, null, null, null, null, false, null, 0, 0, 1023, null);
                            Object obj2 = sharePenetratePageData[0];
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.ByteArray");
                            gVar = (g) c45.i.b(gVar2, (byte[]) obj2);
                        } catch (Exception unused2) {
                            gVar = null;
                        }
                        Object obj3 = sharePenetratePageData[1];
                        byte[] bArr = obj3 instanceof byte[] ? (byte[]) obj3 : null;
                        String decodeToString3 = bArr != null ? StringsKt__StringsJVMKt.decodeToString(bArr) : null;
                        if (gVar != null && decodeToString3 != null) {
                            final ?? nearbyMoodPosterData = new NearbyMoodPosterData(gVar, decodeToString3, 2);
                            Function1<NBPBaseShareVM<NearbyMoodPosterData>, Unit> function12 = new Function1<NBPBaseShareVM<NearbyMoodPosterData>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$created$3

                                /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$created$3$1, reason: invalid class name */
                                /* loaded from: classes31.dex */
                                public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Boolean, String, Unit> {
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Boolean bool, String str) {
                                        NearbyCommonSharePage.access$handleError((NearbyCommonSharePage) this.receiver, bool.booleanValue(), str);
                                        return Unit.INSTANCE;
                                    }

                                    public AnonymousClass1(Object obj) {
                                        super(2, obj, NearbyCommonSharePage.class, "handleError", "handleError(ZLjava/lang/String;)V", 0);
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(NBPBaseShareVM<NearbyMoodPosterData> nBPBaseShareVM3) {
                                    boolean isBlank;
                                    boolean isBlank2;
                                    boolean isBlank3;
                                    boolean contains$default;
                                    String str;
                                    NBPBaseShareVM<NearbyMoodPosterData> nBPBaseShareVM4 = nBPBaseShareVM3;
                                    NearbyCommonSharePage.this.shareVM = nBPBaseShareVM4;
                                    NearbyMoodPosterData nearbyMoodPosterData2 = nearbyMoodPosterData;
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(NearbyCommonSharePage.this);
                                    NBPMoodShareVM.Companion.getClass();
                                    KLog kLog2 = KLog.INSTANCE;
                                    kLog2.i("NBPMoodShareVM", "generate middle page Poster");
                                    NBPMoodShareVM nBPMoodShareVM = new NBPMoodShareVM(nBPBaseShareVM4, nearbyMoodPosterData2, anonymousClass1);
                                    kLog2.i("NBPMoodShareVM", "start to initData");
                                    int i17 = 2;
                                    PageLoadTechReporter pageLoadTechReporter = new PageLoadTechReporter("nearby_common_share", 2);
                                    nBPMoodShareVM.pageLoadReporter = pageLoadTechReporter;
                                    pageLoadTechReporter.startPart1();
                                    nBPMoodShareVM.shareVM.setPosterData(nearbyMoodPosterData2);
                                    g gVar3 = nearbyMoodPosterData2.user;
                                    ReadWriteProperty readWriteProperty = nBPMoodShareVM.user$delegate;
                                    KProperty<?>[] kPropertyArr = NBPMoodShareVM.$$delegatedProperties;
                                    readWriteProperty.setValue(nBPMoodShareVM, kPropertyArr[0], gVar3);
                                    try {
                                        e eVar = new e(nearbyMoodPosterData2.config);
                                        e m16 = eVar.m("indicatorConfig");
                                        nBPMoodShareVM.shareVM.mapThemeId = String.valueOf(m16 != null ? m16.p("mapThemeId") : null);
                                        String p16 = m16 != null ? m16.p("moodTitle") : null;
                                        if (p16 == null) {
                                            p16 = "";
                                        }
                                        a aVar = ((g) nBPMoodShareVM.user$delegate.getValue(nBPMoodShareVM, kPropertyArr[0])).f444489e;
                                        if (aVar == null) {
                                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) p16, (CharSequence) "\u7948\u798f", false, 2, (Object) null);
                                            if (!contains$default) {
                                                i17 = 1;
                                            }
                                        } else {
                                            i17 = aVar.f424995e;
                                        }
                                        nBPMoodShareVM.mid = i17;
                                        nBPMoodShareVM.posterData.mid = i17;
                                        e m17 = eVar.m("shareConfig");
                                        if (m17 == null || (str = m17.p("mainPosterBg910")) == null) {
                                            str = "";
                                        }
                                        nBPMoodShareVM.mainPosterBgUrl = str;
                                    } catch (JSONException e16) {
                                        KLog kLog3 = KLog.INSTANCE;
                                        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("JSON parsing error: ");
                                        m18.append(e16.getMessage());
                                        kLog3.e("NBPMoodShareVM", m18.toString());
                                    } catch (Exception e17) {
                                        KLog kLog4 = KLog.INSTANCE;
                                        StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Unexpected error: ");
                                        m19.append(e17.getMessage());
                                        kLog4.e("NBPMoodShareVM", m19.toString());
                                    }
                                    UserDataManager userDataManager = UserDataManager.INSTANCE;
                                    String str2 = userDataManager.getUserSelfInfo().nickName;
                                    String str3 = userDataManager.getUserSelfInfo().avatarUrl;
                                    String valueOf = String.valueOf(userDataManager.getUserSelfInfo().tid);
                                    QQNearbyModule.UserInfo userInfo = QQNearbyModule.Companion.getInstance().getUserInfo();
                                    if (userInfo != null && Intrinsics.areEqual(userInfo.tid, valueOf)) {
                                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                                        if (isBlank2) {
                                            str2 = userInfo.nick;
                                        }
                                        isBlank3 = StringsKt__StringsJVMKt.isBlank(str3);
                                        if (isBlank3) {
                                            str3 = userInfo.avatar;
                                        }
                                    }
                                    String str4 = str3;
                                    isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                                    String str5 = isBlank ? "\u9644\u8fd1\u7528\u6237" : str2;
                                    int i18 = nBPMoodShareVM.mid;
                                    NBPSsoLocation nBPSsoLocation = UserDataManager.ssoLocation;
                                    String str6 = nBPMoodShareVM.mainPosterBgUrl;
                                    nBPMoodShareVM.keyMoodData = new moodPosterData(i18, valueOf, nBPSsoLocation, str4, str5, str6 == null ? "" : str6, 44);
                                    nBPMoodShareVM.shareVM.setMainViewRendered();
                                    nBPMoodShareVM.shareVM.setQQArkViewRendered();
                                    nBPMoodShareVM.shareVM.setWXArkViewRendered();
                                    moodPosterData moodposterdata = nBPMoodShareVM.keyMoodData;
                                    KLog kLog5 = KLog.INSTANCE;
                                    kLog5.d("NBPMoodShareVM", "initData: cfg=" + moodposterdata);
                                    NBPBaseShareVM<NearbyMoodPosterData> nBPBaseShareVM5 = nBPMoodShareVM.shareVM;
                                    nBPBaseShareVM5.moodPosterConfig$delegate.setValue(nBPBaseShareVM5, NBPBaseShareVM.$$delegatedProperties[3], moodposterdata);
                                    nBPMoodShareVM.shareVM.setDataReady();
                                    PageLoadTechReporter pageLoadTechReporter2 = nBPMoodShareVM.pageLoadReporter;
                                    if (pageLoadTechReporter2 != null) {
                                        pageLoadTechReporter2.finishPart1();
                                    }
                                    PageLoadTechReporter pageLoadTechReporter3 = nBPMoodShareVM.pageLoadReporter;
                                    if (pageLoadTechReporter3 != null) {
                                        pageLoadTechReporter3.startPart2();
                                    }
                                    PageLoadTechReporter pageLoadTechReporter4 = nBPMoodShareVM.pageLoadReporter;
                                    if (pageLoadTechReporter4 != null) {
                                        pageLoadTechReporter4.startPart3();
                                    }
                                    PageLoadTechReporter pageLoadTechReporter5 = nBPMoodShareVM.pageLoadReporter;
                                    if (pageLoadTechReporter5 != null) {
                                        pageLoadTechReporter5.startPart4();
                                    }
                                    new com.tencent.kuikly.core.base.w(315.0f, 424.0f);
                                    NBPBasePosterView nBPBasePosterView = new NBPBasePosterView((Function1) nBPMoodShareVM.middleViewBuilder$delegate.getValue(), nBPMoodShareVM.posterData);
                                    kLog5.i("NearbyFeedSharePage", "created: moodPagePoster");
                                    nBPBaseShareVM4.setCurrentPoster(nBPBasePosterView);
                                    return Unit.INSTANCE;
                                }
                            };
                            int i17 = this.appId;
                            new NearbyCommonSharePage$initShareVM$shareVM$1(this);
                            NBPBaseShareVM<NearbyMoodPosterData> nBPBaseShareVM3 = new NBPBaseShareVM<>(i17);
                            nBPBaseShareVM3.posterData = nearbyMoodPosterData;
                            nBPBaseShareVM3.poiCanceled = this.poiCanceled;
                            function12.invoke(nBPBaseShareVM3);
                        } else {
                            KLog.INSTANCE.e("NearbyFeedSharePage", "created: \u6570\u636e\u9519\u8bef\uff0c\u5173\u95ed\u9875\u9762\uff1a\u7f3a\u5c11user\u6216config");
                            QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                            return;
                        }
                    } else {
                        kLog.e("NearbyFeedSharePage", "created: \u6570\u636e\u9519\u8bef\uff0c\u5173\u95ed\u9875\u9762");
                        QQKuiklyPlatformApi.Companion companion4 = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.closePage$default();
                        return;
                    }
                } else if (i3 == 3) {
                    m mVar = new m(null, null, 0L, null, 0L, null, false, null, null, 0L, null, 0, null, null, 16383, null);
                    Object obj4 = sharePenetratePageData[0];
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.ByteArray");
                    m mVar2 = (m) c45.i.b(mVar, (byte[]) obj4);
                    final ?? nearbyMiddlePosterData = new NearbyMiddlePosterData(mVar2);
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("created middle page share: poiId=");
                    ah ahVar = mVar2.f447113d;
                    m16.append(ahVar != null ? ahVar.f425143d : null);
                    kLog.i("NearbyFeedSharePage", m16.toString());
                    Function1<NBPBaseShareVM<NearbyMiddlePosterData>, Unit> function13 = new Function1<NBPBaseShareVM<NearbyMiddlePosterData>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$created$2

                        /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$created$2$1, reason: invalid class name */
                        /* loaded from: classes31.dex */
                        public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Boolean, String, Unit> {
                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Boolean bool, String str) {
                                NearbyCommonSharePage.access$handleError((NearbyCommonSharePage) this.receiver, bool.booleanValue(), str);
                                return Unit.INSTANCE;
                            }

                            public AnonymousClass1(Object obj) {
                                super(2, obj, NearbyCommonSharePage.class, "handleError", "handleError(ZLjava/lang/String;)V", 0);
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(NBPBaseShareVM<NearbyMiddlePosterData> nBPBaseShareVM4) {
                            e eVar;
                            MiddlePageShareConfig middlePageShareConfig;
                            NBPBaseShareVM<NearbyMiddlePosterData> nBPBaseShareVM5 = nBPBaseShareVM4;
                            NearbyCommonSharePage nearbyCommonSharePage = NearbyCommonSharePage.this;
                            nearbyCommonSharePage.shareVM = nBPBaseShareVM5;
                            int i18 = nearbyCommonSharePage.appId;
                            NearbyMiddlePosterData nearbyMiddlePosterData2 = nearbyMiddlePosterData;
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(NearbyCommonSharePage.this);
                            NBPMiddleShareVM.Companion companion5 = NBPMiddleShareVM.Companion;
                            KLog kLog2 = KLog.INSTANCE;
                            kLog2.i("NBPMiddleShareVM", "generate middle page Poster");
                            NBPMiddleShareVM nBPMiddleShareVM = new NBPMiddleShareVM(i18, nBPBaseShareVM5, nearbyMiddlePosterData2, anonymousClass1);
                            kLog2.i("NBPMiddleShareVM", "initData");
                            nBPMiddleShareVM.appId = i18;
                            PageLoadTechReporter pageLoadTechReporter = new PageLoadTechReporter("nearby_common_share", 2);
                            nBPMiddleShareVM.pageLoadReporter = pageLoadTechReporter;
                            pageLoadTechReporter.startPart1();
                            nBPMiddleShareVM.shareVM.setPosterData(nearbyMiddlePosterData2);
                            String stringFromQQCommonConfig = QQNearbyModule.Companion.getInstance().getStringFromQQCommonConfig("105584", "{}");
                            kLog2.i("NBPMiddleShareVM", "getMiddlePageQQMCConfig: 105584: " + stringFromQQCommonConfig);
                            if (stringFromQQCommonConfig.length() == 0) {
                                middlePageShareConfig = new MiddlePageShareConfig("", "", "", "", 16);
                            } else {
                                try {
                                    eVar = new e(stringFromQQCommonConfig);
                                } catch (Exception unused3) {
                                    eVar = new e();
                                }
                                middlePageShareConfig = new MiddlePageShareConfig(eVar.q("poster_text", "\u770b\u770b\u4f60\u70b9\u4eae\u57ce\u5e02\u591a\u5c11\u89d2\u843d\u5427"), eVar.q("title_fallback_text", "\u6765\u770b\u770b\u9644\u8fd1\u7684\u8fd9\u4e2a\u5b9d\u85cf\u5730\u70b9"), eVar.q("desc_fallback_text", "\u6765QQ\u9644\u8fd1\uff0c\u53d1\u73b0\u66f4\u591a\u8eab\u8fb9\u7684\u5b9d\u85cf\u5730\u70b9"), eVar.q("wx_share_title", "\u6211\u4eceQQ\u9644\u8fd1\u5411\u4f60\u5206\u4eab\u4e86\u4e00\u4e2a\u65b0\u7684\u5730\u70b9"), eVar.q("wx_share_desc", "\u6765QQ\u9644\u8fd1\uff0c\u53d1\u73b0\u66f4\u591a\u8eab\u8fb9\u7684\u5b9d\u85cf\u5730\u70b9"));
                            }
                            KLog kLog3 = KLog.INSTANCE;
                            kLog3.d("NBPMiddleShareVM", "initData: cfg=" + middlePageShareConfig);
                            NBPBaseShareVM<NearbyMiddlePosterData> nBPBaseShareVM6 = nBPMiddleShareVM.shareVM;
                            nBPBaseShareVM6.middlePosterConfig$delegate.setValue(nBPBaseShareVM6, NBPBaseShareVM.$$delegatedProperties[2], middlePageShareConfig);
                            nBPMiddleShareVM.shareVM.setDataReady();
                            PageLoadTechReporter pageLoadTechReporter2 = nBPMiddleShareVM.pageLoadReporter;
                            if (pageLoadTechReporter2 != null) {
                                pageLoadTechReporter2.finishPart1();
                            }
                            PageLoadTechReporter pageLoadTechReporter3 = nBPMiddleShareVM.pageLoadReporter;
                            if (pageLoadTechReporter3 != null) {
                                pageLoadTechReporter3.startPart2();
                            }
                            PageLoadTechReporter pageLoadTechReporter4 = nBPMiddleShareVM.pageLoadReporter;
                            if (pageLoadTechReporter4 != null) {
                                pageLoadTechReporter4.startPart3();
                            }
                            PageLoadTechReporter pageLoadTechReporter5 = nBPMiddleShareVM.pageLoadReporter;
                            if (pageLoadTechReporter5 != null) {
                                pageLoadTechReporter5.startPart4();
                            }
                            nBPMiddleShareVM.shareVM.setMainViewRendered();
                            nBPMiddleShareVM.shareVM.setQQArkViewRendered();
                            nBPMiddleShareVM.shareVM.setWXArkViewRendered();
                            new com.tencent.kuikly.core.base.w(315.0f, 424.0f);
                            NBPBasePosterView nBPBasePosterView = new NBPBasePosterView((Function1) nBPMiddleShareVM.middleViewBuilder$delegate.getValue(), nBPMiddleShareVM.posterData);
                            kLog3.i("NearbyFeedSharePage", "created: middlePagePoster");
                            nBPBaseShareVM5.setCurrentPoster(nBPBasePosterView);
                            return Unit.INSTANCE;
                        }
                    };
                    int i18 = this.appId;
                    new NearbyCommonSharePage$initShareVM$shareVM$1(this);
                    NBPBaseShareVM<NearbyMiddlePosterData> nBPBaseShareVM4 = new NBPBaseShareVM<>(i18);
                    nBPBaseShareVM4.posterData = nearbyMiddlePosterData;
                    nBPBaseShareVM4.poiCanceled = this.poiCanceled;
                    function13.invoke(nBPBaseShareVM4);
                } else {
                    if (i3 != 4) {
                        kLog.e("NearbyFeedSharePage", "created: NBPShareType\u9519\u8bef\uff0c\u5173\u95ed\u9875\u9762");
                        QQKuiklyPlatformApi.Companion companion5 = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.closePage$default();
                        return;
                    }
                    try {
                        Object obj5 = sharePenetratePageData[0];
                        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.ByteArray");
                        decodeToString2 = StringsKt__StringsJVMKt.decodeToString((byte[]) obj5);
                        r16 = NBPFeedShareDataExtKt.fromJsonStr(decodeToString2);
                    } catch (Exception unused3) {
                        r16 = 0;
                    }
                    orNull = ArraysKt___ArraysKt.getOrNull(sharePenetratePageData, 1);
                    byte[] bArr2 = orNull instanceof byte[] ? (byte[]) orNull : null;
                    if (bArr2 != null) {
                        try {
                            if (this.appId == 1) {
                                decodeToString = StringsKt__StringsJVMKt.decodeToString(bArr2);
                                nBPThemePosterConfig = NBPThemePosterConfig.Companion.parseJson(new e(decodeToString));
                            } else {
                                v25.e eVar = (v25.e) c45.i.b(new v25.e(null, null, 0, 7, null), bArr2);
                                NBPThemeAttachConfig.Companion companion6 = NBPThemeAttachConfig.Companion;
                                o25.f fVar = eVar.f440846e;
                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) companion6.parseJsonStr(fVar != null ? fVar.L : null).posters910);
                                nBPThemePosterConfig = (NBPThemePosterConfig) firstOrNull;
                            }
                        } catch (Exception unused4) {
                        }
                        if (r16 != 0) {
                            KLog.INSTANCE.e("NearbyFeedSharePage", "created: \u6570\u636e\u9519\u8bef\uff0c\u5173\u95ed\u9875\u9762\uff1a\u7f3a\u5c11posterData\u6216posterConfig");
                            QQKuiklyPlatformApi.Companion companion7 = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                            return;
                        } else {
                            Function1<NBPBaseShareVM<NearbyFeedPosterData>, Unit> function14 = new Function1<NBPBaseShareVM<NearbyFeedPosterData>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$created$1

                                /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$created$1$1, reason: invalid class name */
                                /* loaded from: classes31.dex */
                                public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Boolean, String, Unit> {
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Boolean bool, String str) {
                                        NearbyCommonSharePage.access$handleError((NearbyCommonSharePage) this.receiver, bool.booleanValue(), str);
                                        return Unit.INSTANCE;
                                    }

                                    public AnonymousClass1(Object obj) {
                                        super(2, obj, NearbyCommonSharePage.class, "handleError", "handleError(ZLjava/lang/String;)V", 0);
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(NBPBaseShareVM<NearbyFeedPosterData> nBPBaseShareVM5) {
                                    final List listOf;
                                    Object firstOrNull2;
                                    NBPBaseShareVM<NearbyFeedPosterData> nBPBaseShareVM6 = nBPBaseShareVM5;
                                    NearbyCommonSharePage nearbyCommonSharePage = NearbyCommonSharePage.this;
                                    nearbyCommonSharePage.shareVM = nBPBaseShareVM6;
                                    int i19 = nearbyCommonSharePage.appId;
                                    NearbyFeedPosterData nearbyFeedPosterData = r16;
                                    NBPThemePosterConfig nBPThemePosterConfig2 = nBPThemePosterConfig;
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(NearbyCommonSharePage.this);
                                    NBPFeedShareVM.Companion companion8 = NBPFeedShareVM.Companion;
                                    KLog kLog2 = KLog.INSTANCE;
                                    kLog2.i("NBPFeedShareVM", "generate feed Poster");
                                    final NBPFeedShareVM nBPFeedShareVM = new NBPFeedShareVM(i19, nBPBaseShareVM6, nearbyFeedPosterData, anonymousClass1);
                                    kLog2.i("NBPFeedShareVM", "initData");
                                    nBPFeedShareVM.appId = i19;
                                    PageLoadTechReporter pageLoadTechReporter = new PageLoadTechReporter("nearby_common_share", 2);
                                    nBPFeedShareVM.pageLoadReporter = pageLoadTechReporter;
                                    pageLoadTechReporter.startPart1();
                                    nBPFeedShareVM.shareVM.setPosterData(nearbyFeedPosterData);
                                    if (nBPThemePosterConfig2 != null) {
                                        nBPFeedShareVM.updatePosterConfig(nBPThemePosterConfig2);
                                    } else if (i19 == 1) {
                                        final String str = nearbyFeedPosterData.feedId;
                                        listOf = CollectionsKt__CollectionsJVMKt.listOf(str);
                                        final Function3<p35.v, Integer, String, Unit> function3 = new Function3<p35.v, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM$checkFeedStatus$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(p35.v vVar, Integer num, String str2) {
                                                Map<String, Integer> map;
                                                Integer num2;
                                                p35.v vVar2 = vVar;
                                                num.intValue();
                                                boolean z17 = (vVar2 == null || (map = vVar2.f425218d) == null || (num2 = map.get(str)) == null || num2.intValue() != 2) ? false : true;
                                                KLog kLog3 = KLog.INSTANCE;
                                                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("checkFeedStatus: ");
                                                m17.append(vVar2 != null ? vVar2.f425218d : null);
                                                m17.append(", isForbiddened=");
                                                m17.append(z17);
                                                kLog3.i("NBPFeedShareVM", m17.toString());
                                                if (z17) {
                                                    nBPFeedShareVM.handleError.invoke(Boolean.TRUE, "\u8be5\u52a8\u6001\u5ba1\u6838\u4e2d\uff0c\u6682\u4e0d\u652f\u6301\u5206\u4eab");
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        GetFeedStatusRequest getFeedStatusRequest = new GetFeedStatusRequest(i19, listOf);
                                        Function4<p35.v, byte[], Integer, String, Unit> function4 = new Function4<p35.v, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedRepo$getFeedStats$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(4);
                                            }

                                            @Override // kotlin.jvm.functions.Function4
                                            public final Unit invoke(p35.v vVar, byte[] bArr3, Integer num, String str2) {
                                                p35.v vVar2 = vVar;
                                                int intValue = num.intValue();
                                                String str3 = str2;
                                                KLog kLog3 = KLog.INSTANCE;
                                                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getFeedStats: rspIsNull=");
                                                m17.append(vVar2 == null);
                                                m17.append(" feedId=");
                                                m17.append(listOf);
                                                m17.append(", code=");
                                                m17.append(intValue);
                                                m17.append(", msg=");
                                                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m17, str3, kLog3, "StrangerFeedRepo");
                                                function3.invoke(vVar2, Integer.valueOf(intValue), str3);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        c45.a aVar = new c45.a(c45.i.d(getFeedStatusRequest.getRequest()));
                                        int appId = getFeedStatusRequest.getAppId();
                                        CommonProxyService$request$1 commonProxyService$request$1 = new CommonProxyService$request$1(function4, getFeedStatusRequest);
                                        StringBuilder m17 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("req: appId=", appId, " service=", "QQStranger.FeedSvr", " method=");
                                        m17.append("GetFeedStatus");
                                        kLog2.i("CommonProxyService", m17.toString());
                                        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, appId + util.base64_pad_url + "QQStranger.FeedSvr.GetFeedStatus");
                                        CommonProxyRequest commonProxyRequest = new CommonProxyRequest(appId, "QQStranger.FeedSvr", "GetFeedStatus", aVar);
                                        QQKuiklyPlatformApi.Companion companion9 = QQKuiklyPlatformApi.Companion;
                                        QQKuiklyPlatformApi.Companion.sendPbRequest$default(commonProxyRequest, null, new CommonProxyService$handle$1(aPICallTechReporter, commonProxyService$request$1), 6);
                                        String stringFromQQCommonConfig = QQNearbyModule.Companion.getInstance().getStringFromQQCommonConfig("105495", "{}");
                                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("getJiebanQQMCConfig: 105495: ", stringFromQQCommonConfig, kLog2, "NBPFeedShareVM");
                                        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) NBPThemeAttachConfig.Companion.parseJsonStr(stringFromQQCommonConfig).posters910);
                                        nBPFeedShareVM.updatePosterConfig((NBPThemePosterConfig) firstOrNull2);
                                    } else if (i19 == 2) {
                                        NearbyFeedPosterData nearbyFeedPosterData2 = nBPFeedShareVM.posterData;
                                        final String str2 = nearbyFeedPosterData2.feedId;
                                        final String str3 = nearbyFeedPosterData2.themeId;
                                        kLog2.i("NBPFeedShareVM", QUISkinImage$$ExternalSyntheticOutline0.m("fetchShareInfo: feedId=", str2, ", theme=", str3));
                                        Function1<PbResponse<v25.e>, Unit> function15 = new Function1<PbResponse<v25.e>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM$fetchNearbyPosterConfig$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(PbResponse<v25.e> pbResponse) {
                                                String str4;
                                                Object firstOrNull3;
                                                PbResponse<v25.e> pbResponse2 = pbResponse;
                                                v25.e eVar2 = pbResponse2.rsp;
                                                if (pbResponse2.success && eVar2 != null) {
                                                    NBPThemeAttachConfig.Companion companion10 = NBPThemeAttachConfig.Companion;
                                                    o25.f fVar2 = eVar2.f440846e;
                                                    firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) companion10.parseJsonStr(fVar2 != null ? fVar2.L : null).posters910);
                                                    nBPFeedShareVM.updatePosterConfig((NBPThemePosterConfig) firstOrNull3);
                                                } else {
                                                    KLog kLog3 = KLog.INSTANCE;
                                                    StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchShareInfo: feedId=");
                                                    m18.append(str2);
                                                    m18.append(", theme=");
                                                    m18.append(str3);
                                                    m18.append(", ");
                                                    m18.append(pbResponse2.code);
                                                    m18.append(", ");
                                                    m18.append(pbResponse2.f114187msg);
                                                    kLog3.e("NBPFeedShareVM", m18.toString());
                                                    if (NearbyProUtilsKt.isShowBackendErrorMsg(pbResponse2.code)) {
                                                        str4 = pbResponse2.f114187msg;
                                                    } else {
                                                        str4 = "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                    }
                                                    nBPFeedShareVM.handleError.invoke(Boolean.TRUE, str4);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        boolean z17 = str3.length() == 0;
                                        if ((str3.length() > 0) && !new Regex("^[a-zA-Z0-9]+$").matches(str3)) {
                                            str3 = "";
                                            z17 = true;
                                        }
                                        StringBuilder a16 = j.a("start fetch feed share info: ", str2, ", ", str3, ", ");
                                        a16.append(z17);
                                        kLog2.i("NearbyMapThemeRepo", a16.toString());
                                        SsoGetFeedShareInfoRequest ssoGetFeedShareInfoRequest = new SsoGetFeedShareInfoRequest(str2, str3, z17);
                                        NearbyMapThemeRepo$fetchFeedShareInfo$1 nearbyMapThemeRepo$fetchFeedShareInfo$1 = new NearbyMapThemeRepo$fetchFeedShareInfo$1(function15);
                                        APICallTechReporter aPICallTechReporter2 = new APICallTechReporter(1, "trpc.lplan.map_svr.Map.SsoGetFeedShareInfo");
                                        QQKuiklyPlatformApi.Companion companion10 = QQKuiklyPlatformApi.Companion;
                                        QQKuiklyPlatformApi.Companion.sendPbRequest$default(ssoGetFeedShareInfoRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter2, nearbyMapThemeRepo$fetchFeedShareInfo$1), 6);
                                    }
                                    new com.tencent.kuikly.core.base.w(315.0f, 424.0f);
                                    NBPBasePosterView nBPBasePosterView = new NBPBasePosterView((Function1) nBPFeedShareVM.feedViewBuilder$delegate.getValue(), nBPFeedShareVM.posterData);
                                    NearbyFeedPosterData nearbyFeedPosterData3 = r16;
                                    kLog2.i("NearbyFeedSharePage", "created: feed poster");
                                    nBPBaseShareVM6.setCurrentPoster(nBPBasePosterView);
                                    nBPBaseShareVM6.feedId = nearbyFeedPosterData3.feedId;
                                    return Unit.INSTANCE;
                                }
                            };
                            int i19 = this.appId;
                            new NearbyCommonSharePage$initShareVM$shareVM$1(this);
                            NBPBaseShareVM<NearbyFeedPosterData> nBPBaseShareVM5 = new NBPBaseShareVM<>(i19);
                            nBPBaseShareVM5.posterData = r16;
                            nBPBaseShareVM5.poiCanceled = this.poiCanceled;
                            function14.invoke(nBPBaseShareVM5);
                        }
                    }
                    nBPThemePosterConfig = null;
                    if (r16 != 0) {
                    }
                }
                NBPBaseShareVM<?> nBPBaseShareVM6 = this.shareVM;
                if (nBPBaseShareVM6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                    nBPBaseShareVM6 = null;
                }
                nBPBaseShareVM6.shareType = this.shareType;
                NBPBaseShareVM<?> nBPBaseShareVM7 = this.shareVM;
                if (nBPBaseShareVM7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                } else {
                    nBPBaseShareVM = nBPBaseShareVM7;
                }
                nBPBaseShareVM.reportPageExposure(true);
                NearbyConst nearbyConst = NearbyConst.INSTANCE;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$created$5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        NearbyCommonSharePage nearbyCommonSharePage = NearbyCommonSharePage.this;
                        nearbyCommonSharePage.getClass();
                        IPagerIdKtxKt.getBridgeModule(nearbyCommonSharePage).setWhiteStatusBarStyle();
                        return Unit.INSTANCE;
                    }
                };
                KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                TimerKt.e(getPagerId(), 16, function0);
                TimerKt.e(getPagerId(), 500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$created$6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        NearbyCommonSharePage nearbyCommonSharePage = NearbyCommonSharePage.this;
                        nearbyCommonSharePage.isLoadingIndicatorEnabled$delegate.setValue(nearbyCommonSharePage, NearbyCommonSharePage.$$delegatedProperties[0], Boolean.TRUE);
                        return Unit.INSTANCE;
                    }
                });
                TimerKt.e(getPagerId(), 10000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage$created$7
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        if (!NearbyCommonSharePage.this.isReadyToShowShare()) {
                            KLog kLog2 = KLog.INSTANCE;
                            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("created: timeout, isMainViewRendered=");
                            NBPBaseShareVM<?> nBPBaseShareVM8 = NearbyCommonSharePage.this.shareVM;
                            NBPBaseShareVM<?> nBPBaseShareVM9 = null;
                            if (nBPBaseShareVM8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                nBPBaseShareVM8 = null;
                            }
                            m17.append(nBPBaseShareVM8.isMainViewRendered());
                            m17.append(", isQQArkViewRendered=");
                            NBPBaseShareVM<?> nBPBaseShareVM10 = NearbyCommonSharePage.this.shareVM;
                            if (nBPBaseShareVM10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                nBPBaseShareVM10 = null;
                            }
                            m17.append(nBPBaseShareVM10.isQQArkViewRendered());
                            m17.append(", isWXArkViewRendered=");
                            NBPBaseShareVM<?> nBPBaseShareVM11 = NearbyCommonSharePage.this.shareVM;
                            if (nBPBaseShareVM11 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                nBPBaseShareVM11 = null;
                            }
                            m17.append(nBPBaseShareVM11.isWXArkViewRendered());
                            m17.append(", isPageClosed=");
                            NBPBaseShareVM<?> nBPBaseShareVM12 = NearbyCommonSharePage.this.shareVM;
                            if (nBPBaseShareVM12 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                                nBPBaseShareVM12 = null;
                            }
                            m17.append(nBPBaseShareVM12.isPageClosed());
                            kLog2.e("NearbyFeedSharePage", m17.toString());
                            NearbyCommonSharePage.access$handleError(NearbyCommonSharePage.this, true, "\u52a0\u8f7d\u8d85\u65f6\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                            NBPBaseShareVM<?> nBPBaseShareVM13 = NearbyCommonSharePage.this.shareVM;
                            if (nBPBaseShareVM13 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("shareVM");
                            } else {
                                nBPBaseShareVM9 = nBPBaseShareVM13;
                            }
                            nBPBaseShareVM9.reportPageExposure(false);
                        }
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
