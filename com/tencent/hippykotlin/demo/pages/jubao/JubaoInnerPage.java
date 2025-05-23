package com.tencent.hippykotlin.demo.pages.jubao;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.view.AccessibilityRichTextView;
import com.tencent.hippykotlin.demo.pages.base.view.AccessibilityTextView;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.f;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.loginregister.impl.LoginFailedCommonSceneHandlerApiImpl;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import d45.a;
import defpackage.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes31.dex */
public final class JubaoInnerPage extends BasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(JubaoInnerPage.class, "curPageViewData", "getCurPageViewData()Lcom/tencent/hippykotlin/demo/pages/jubao/PageViewData;", 0)};
    public final JubaoInnerPageController pageController;
    public final PageModel pageModel;
    public final Lazy reportId$delegate;
    public final ReadWriteProperty curPageViewData$delegate = c.a(new PageViewData(0, 0));
    public final ArrayList<PageViewData> pageViewDataStack = new ArrayList<>();
    public final ArrayList<ComposeView<?, ?>> viewStack = new ArrayList<>();

    public JubaoInnerPage() {
        Lazy lazy;
        PageModel pageModel = new PageModel(this);
        this.pageModel = pageModel;
        this.pageController = new JubaoInnerPageController(this, pageModel);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$reportId$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                long currentTimeStamp = ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp();
                int nextInt = Random.INSTANCE.nextInt();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(currentTimeStamp);
                sb5.append('-');
                sb5.append(nextInt);
                return sb5.toString();
            }
        });
        this.reportId$delegate = lazy;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final JubaoInnerPageController jubaoInnerPageController = this.pageController;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getPageBackgroundColor());
                        if (mVar2.getPagerData().getIsAndroid()) {
                            if (mVar2.getPagerData().l() <= 0.0f) {
                                mVar2.mo141height(475.0f);
                            } else {
                                mVar2.mo141height(mVar2.getPagerData().l());
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                final JubaoInnerPage jubaoInnerPage = this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                        JubaoInnerPage jubaoInnerPage2 = JubaoInnerPage.this;
                        jubaoDTBaseParams.v("appid", jubaoInnerPage2.pageModel.getPostData().appId);
                        jubaoDTBaseParams.v("report_id", (String) jubaoInnerPage2.reportId$delegate.getValue());
                        Unit unit = Unit.INSTANCE;
                        EcommerceExtKt.pageVR(mVar, "pg_safe_report_page", jubaoDTBaseParams);
                        return Unit.INSTANCE;
                    }
                });
                if (JubaoInnerPage.this.getPagerData().getIsIOS()) {
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.3
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.3.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    tVar.mo141height(475.0f);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                final JubaoInnerPage jubaoInnerPage2 = this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        JubaoInnerPage jubaoInnerPage3 = JubaoInnerPage.this;
                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                        return Boolean.valueOf(jubaoInnerPage3.getCurPageViewData().curStep == 12);
                    }
                };
                final JubaoInnerPage jubaoInnerPage3 = this;
                final JubaoInnerPageController jubaoInnerPageController2 = jubaoInnerPageController;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        PageModel pageModel = JubaoInnerPage.this.pageModel;
                        final JubaoInnerPageController jubaoInnerPageController3 = jubaoInnerPageController2;
                        conditionView.addChild(new GrayTipView(pageModel), new Function1<GrayTipView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GrayTipView grayTipView) {
                                GrayTipView grayTipView2 = grayTipView;
                                JubaoUtil.fillParent$default(grayTipView2);
                                final JubaoInnerPageController jubaoInnerPageController4 = JubaoInnerPageController.this;
                                grayTipView2.onReportClickCallback = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Integer num) {
                                        String str;
                                        boolean startsWith$default;
                                        int intValue = num.intValue();
                                        JubaoInnerPageController jubaoInnerPageController5 = JubaoInnerPageController.this;
                                        if (intValue == 1) {
                                            jubaoInnerPageController5.jumpToNextPage(7, 8);
                                        } else {
                                            GrayTipData grayTipData = jubaoInnerPageController5.pageModel.getGrayTipData();
                                            if (grayTipData != null && (str = grayTipData.jumpUrl) != null) {
                                                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, LoginFailedCommonSceneHandlerApiImpl.KEY_MINIAPP_PREFIX, false, 2, null);
                                                if (startsWith$default) {
                                                    StringBuilder m3 = HotViewKt$$ExternalSyntheticOutline0.m(str, "&_nq=sessionTime%3D");
                                                    m3.append(jubaoInnerPageController5.pageModel.getPostData().grayIdTime);
                                                    m3.append("%26type%3D");
                                                    m3.append(jubaoInnerPageController5.pageModel.getPostData().grayId);
                                                    m3.append("%26src%3D");
                                                    m3.append(jubaoInnerPageController5.pageModel.getPostData().src);
                                                    m3.append("%26token%3D");
                                                    m3.append(jubaoInnerPageController5.pageModel.getPostData().grayTipToken);
                                                    m3.append("%26chatType%3D");
                                                    m3.append(jubaoInnerPageController5.pageModel.getPostData().chatType);
                                                    QQKuiklyPlatformApi.openPage$default((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi"), m3.toString(), false, 6);
                                                } else {
                                                    QQKuiklyPlatformApi.openPage$default((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi"), str, false, 6);
                                                }
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoInnerPage jubaoInnerPage4 = this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        JubaoInnerPage jubaoInnerPage5 = JubaoInnerPage.this;
                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                        return Boolean.valueOf(jubaoInnerPage5.getCurPageViewData().curStep == 0);
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.7
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        conditionView.addChild(new JubaoLoadingView(), new Function1<JubaoLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.7.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(JubaoLoadingView jubaoLoadingView) {
                                JubaoLoadingView jubaoLoadingView2 = jubaoLoadingView;
                                jubaoLoadingView2.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.7.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(k kVar) {
                                        kVar.m143maxHeight(475.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                JubaoUtil.fillParent$default(jubaoLoadingView2);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoInnerPage jubaoInnerPage5 = this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.8
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        JubaoInnerPage jubaoInnerPage6 = JubaoInnerPage.this;
                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                        return Boolean.valueOf(jubaoInnerPage6.getCurPageViewData().curStep == 1);
                    }
                };
                final JubaoInnerPage jubaoInnerPage6 = this;
                final JubaoInnerPageController jubaoInnerPageController3 = jubaoInnerPageController;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final JubaoInnerPage jubaoInnerPage7 = JubaoInnerPage.this;
                        PageModel pageModel = jubaoInnerPage7.pageModel;
                        ArrayList<JubaoSelectData> arrayList = pageModel.selectData;
                        final JubaoInnerPageController jubaoInnerPageController4 = jubaoInnerPageController3;
                        conditionView.addChild(new JubaoSelectView(pageModel, arrayList), new Function1<JubaoSelectView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.9.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(JubaoSelectView jubaoSelectView) {
                                JubaoSelectView jubaoSelectView2 = jubaoSelectView;
                                JubaoInnerPage.this.viewStack.add(jubaoSelectView2);
                                jubaoSelectView2.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.9.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(k kVar) {
                                        kVar.m143maxHeight(475.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                JubaoUtil.fillParent$default(jubaoSelectView2);
                                final JubaoInnerPageController jubaoInnerPageController5 = jubaoInnerPageController4;
                                jubaoSelectView2.continueCallback = new Function1<ArrayList<JubaoSelectData>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.9.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ArrayList<JubaoSelectData> arrayList2) {
                                        JubaoSelectData jubaoSelectData;
                                        Object last;
                                        String str;
                                        ArrayList<JubaoSelectData> arrayList3 = arrayList2;
                                        final JubaoInnerPageController jubaoInnerPageController6 = JubaoInnerPageController.this;
                                        jubaoInnerPageController6.getClass();
                                        b bVar = new b();
                                        Iterator<T> it = arrayList3.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            JubaoSelectData jubaoSelectData2 = (JubaoSelectData) it.next();
                                            if (jubaoSelectData2.appId.length() > 0) {
                                                bVar.t(jubaoSelectData2.appId);
                                            } else {
                                                bVar.t(jubaoInnerPageController6.pageModel.getPostData().appId);
                                            }
                                        }
                                        ListIterator<JubaoSelectData> listIterator = arrayList3.listIterator(arrayList3.size());
                                        while (true) {
                                            if (!listIterator.hasPrevious()) {
                                                jubaoSelectData = null;
                                                break;
                                            }
                                            jubaoSelectData = listIterator.previous();
                                            if (jubaoSelectData.isFirstChoice) {
                                                break;
                                            }
                                        }
                                        JubaoSelectData jubaoSelectData3 = jubaoSelectData;
                                        if (jubaoSelectData3 == null || (str = jubaoSelectData3.appId) == null) {
                                            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList3);
                                            str = ((JubaoSelectData) last).appId;
                                        }
                                        if (str.length() == 0) {
                                            str = jubaoInnerPageController6.pageModel.originalAppId;
                                        }
                                        ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("selectedArray " + bVar + " curChooseAppId " + str);
                                        jubaoInnerPageController6.pageModel.getPostData().postData.v("selected_data", bVar);
                                        if (Intrinsics.areEqual(str, jubaoInnerPageController6.pageModel.getPostData().appId)) {
                                            if (!JubaoConfig.isQuickJubao) {
                                                jubaoInnerPageController6.jumpToNextPage(4, 1);
                                            } else {
                                                jubaoInnerPageController6.quickJubaoWhenSelectAppId();
                                            }
                                        } else {
                                            O3PostData postData = jubaoInnerPageController6.pageModel.getPostData();
                                            postData.appId = str;
                                            postData.postData.v("appid", str);
                                            jubaoInnerPageController6.pageModel.setOperateStatus(9);
                                            jubaoInnerPageController6.pageModel.pullTemplateData(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$onJubaoSelected$2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Boolean bool) {
                                                    boolean booleanValue = bool.booleanValue();
                                                    JubaoInnerPageController.this.pageModel.setOperateStatus(0);
                                                    if (!booleanValue) {
                                                        JubaoInnerPageController.this.jumpToNextPage(3, 0);
                                                    } else if (!JubaoConfig.isQuickJubao) {
                                                        JubaoInnerPageController.this.jumpToNextPage(4, 1);
                                                    } else {
                                                        JubaoInnerPageController.this.quickJubaoWhenSelectAppId();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoInnerPage jubaoInnerPage7 = this;
                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.10
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        JubaoInnerPage jubaoInnerPage8 = JubaoInnerPage.this;
                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                        return Boolean.valueOf(jubaoInnerPage8.getCurPageViewData().curStep == 3);
                    }
                };
                final JubaoInnerPage jubaoInnerPage8 = this;
                ConditionViewKt.c(viewContainer2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.11
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final JubaoInnerPage jubaoInnerPage9 = JubaoInnerPage.this;
                        ErrorData errorData = jubaoInnerPage9.pageModel.loadingErrorData;
                        conditionView.addChild(new JubaoErrorView(errorData), new Function1<JubaoErrorView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.11.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(JubaoErrorView jubaoErrorView) {
                                JubaoErrorView jubaoErrorView2 = jubaoErrorView;
                                JubaoUtil.fillParent$default(jubaoErrorView2);
                                final JubaoInnerPage jubaoInnerPage10 = JubaoInnerPage.this;
                                jubaoErrorView2.continueCallback = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.11.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Integer num) {
                                        int intValue = num.intValue();
                                        JubaoInnerPageController jubaoInnerPageController4 = JubaoInnerPage.this.pageController;
                                        jubaoInnerPageController4.getClass();
                                        if (intValue == 1) {
                                            jubaoInnerPageController4.toJubaoStartPage();
                                        } else if (intValue == 2) {
                                            jubaoInnerPageController4.pageModel.getO3Module().dismiss();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoInnerPage jubaoInnerPage9 = this;
                Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.12
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        JubaoInnerPage jubaoInnerPage10 = JubaoInnerPage.this;
                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                        return Boolean.valueOf((jubaoInnerPage10.getCurPageViewData().curViewFlag & 1) > 0);
                    }
                };
                final JubaoInnerPage jubaoInnerPage10 = this;
                final JubaoInnerPageController jubaoInnerPageController4 = jubaoInnerPageController;
                ConditionViewKt.c(viewContainer2, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.13
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final JubaoInnerPage jubaoInnerPage11 = JubaoInnerPage.this;
                        ArrayList<JubaoReasonData> arrayList = jubaoInnerPage11.pageModel.reasonsData;
                        final JubaoInnerPageController jubaoInnerPageController5 = jubaoInnerPageController4;
                        conditionView.addChild(new JubaoReasonView(arrayList), new Function1<JubaoReasonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.13.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(JubaoReasonView jubaoReasonView) {
                                JubaoReasonView jubaoReasonView2 = jubaoReasonView;
                                JubaoInnerPage.this.viewStack.add(jubaoReasonView2);
                                JubaoUtil.fillParent$default(jubaoReasonView2);
                                final JubaoInnerPageController jubaoInnerPageController6 = jubaoInnerPageController5;
                                jubaoReasonView2.itemClickCallback = new Function1<JubaoReasonData, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.13.1.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
                                    
                                        if (r1.size() == 1) goto L15;
                                     */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(JubaoReasonData jubaoReasonData) {
                                        boolean z16;
                                        JubaoTypeData jubaoTypeData;
                                        Object orNull;
                                        JubaoReasonData jubaoReasonData2 = jubaoReasonData;
                                        JubaoInnerPageController jubaoInnerPageController7 = JubaoInnerPageController.this;
                                        PageModel pageModel = jubaoInnerPageController7.pageModel;
                                        pageModel.selectedReasonData = jubaoReasonData2;
                                        if (jubaoReasonData2.extra) {
                                            ArrayList<JubaoTypeData> arrayList2 = jubaoReasonData2.types;
                                            if (arrayList2 != null) {
                                                orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList2, 0);
                                                jubaoTypeData = (JubaoTypeData) orNull;
                                            } else {
                                                jubaoTypeData = null;
                                            }
                                            pageModel.selectedTypeData = jubaoTypeData;
                                            jubaoInnerPageController7.jumpToNextPage(5, 4);
                                        } else {
                                            ArrayList<JubaoTypeData> arrayList3 = jubaoReasonData2.types;
                                            if (arrayList3 != null) {
                                                z16 = true;
                                            }
                                            z16 = false;
                                            if (z16) {
                                                jubaoInnerPageController7.onTypeItemClick(jubaoReasonData2.types.get(0));
                                            } else {
                                                jubaoInnerPageController7.jumpToNextPage(6, 2);
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                final JubaoInnerPage jubaoInnerPage12 = JubaoInnerPage.this;
                                final Function0<Boolean> function05 = new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.13.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        JubaoInnerPage jubaoInnerPage13 = JubaoInnerPage.this;
                                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                                        return Boolean.valueOf(jubaoInnerPage13.getCurPageViewData().curStep == 4);
                                    }
                                };
                                jubaoReasonView2.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationViewKt$updateVisibility$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(k kVar) {
                                        kVar.m152visibility(function05.invoke().booleanValue());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoInnerPage jubaoInnerPage11 = this;
                Function0<Object> function05 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.14
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        JubaoInnerPage jubaoInnerPage12 = JubaoInnerPage.this;
                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                        return Boolean.valueOf((jubaoInnerPage12.getCurPageViewData().curViewFlag & 2) > 0);
                    }
                };
                final JubaoInnerPage jubaoInnerPage12 = this;
                final JubaoInnerPageController jubaoInnerPageController5 = jubaoInnerPageController;
                ConditionViewKt.c(viewContainer2, function05, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.15
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        JubaoReasonData jubaoReasonData = JubaoInnerPage.this.pageModel.selectedReasonData;
                        Intrinsics.checkNotNull(jubaoReasonData);
                        final JubaoInnerPage jubaoInnerPage13 = JubaoInnerPage.this;
                        PageModel pageModel = jubaoInnerPage13.pageModel;
                        final JubaoInnerPageController jubaoInnerPageController6 = jubaoInnerPageController5;
                        conditionView.addChild(new JubaoTypeView(jubaoReasonData, pageModel), new Function1<JubaoTypeView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.15.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(JubaoTypeView jubaoTypeView) {
                                JubaoTypeView jubaoTypeView2 = jubaoTypeView;
                                JubaoInnerPage.this.viewStack.add(jubaoTypeView2);
                                JubaoUtil.fillParent$default(jubaoTypeView2);
                                final JubaoInnerPageController jubaoInnerPageController7 = jubaoInnerPageController6;
                                jubaoTypeView2.itemClickCallback = new Function1<JubaoTypeData, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.15.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(JubaoTypeData jubaoTypeData) {
                                        JubaoInnerPageController.this.onTypeItemClick(jubaoTypeData);
                                        return Unit.INSTANCE;
                                    }
                                };
                                final JubaoInnerPageController jubaoInnerPageController8 = jubaoInnerPageController6;
                                jubaoTypeView2.backClickCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.15.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        JubaoInnerPageController.this.onBackClick();
                                        return Unit.INSTANCE;
                                    }
                                };
                                final JubaoInnerPage jubaoInnerPage14 = JubaoInnerPage.this;
                                JubaoAnimationViewKt.updateVisibility(jubaoTypeView2, new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.15.1.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        JubaoInnerPage jubaoInnerPage15 = JubaoInnerPage.this;
                                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                                        return Boolean.valueOf(jubaoInnerPage15.getCurPageViewData().curStep == 6);
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoInnerPage jubaoInnerPage13 = this;
                Function0<Object> function06 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.16
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        JubaoInnerPage jubaoInnerPage14 = JubaoInnerPage.this;
                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                        return Boolean.valueOf((jubaoInnerPage14.getCurPageViewData().curViewFlag & 4) > 0);
                    }
                };
                final JubaoInnerPage jubaoInnerPage14 = this;
                final JubaoInnerPageController jubaoInnerPageController6 = jubaoInnerPageController;
                ConditionViewKt.c(viewContainer2, function06, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.17
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final JubaoInnerPage jubaoInnerPage15 = JubaoInnerPage.this;
                        PageModel pageModel = jubaoInnerPage15.pageModel;
                        final JubaoInnerPageController jubaoInnerPageController7 = jubaoInnerPageController6;
                        conditionView.addChild(new JubaoReasonAddView(pageModel), new Function1<JubaoReasonAddView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.17.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(JubaoReasonAddView jubaoReasonAddView) {
                                JubaoReasonAddView jubaoReasonAddView2 = jubaoReasonAddView;
                                JubaoInnerPage.this.viewStack.add(jubaoReasonAddView2);
                                JubaoUtil.fillParent$default(jubaoReasonAddView2);
                                final JubaoInnerPageController jubaoInnerPageController8 = jubaoInnerPageController7;
                                jubaoReasonAddView2.completeCallback = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.17.1.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
                                    
                                        if (r5.moreEvidence == true) goto L10;
                                     */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(String str) {
                                        JubaoInnerPageController jubaoInnerPageController9 = JubaoInnerPageController.this;
                                        PageModel pageModel2 = jubaoInnerPageController9.pageModel;
                                        pageModel2.addReason = str;
                                        if (pageModel2.evidenceViewFlag == 2) {
                                            JubaoReasonData jubaoReasonData = pageModel2.selectedReasonData;
                                            boolean z16 = jubaoReasonData != null;
                                            if (z16) {
                                                jubaoInnerPageController9.jumpToNextPage(8, 16);
                                            } else {
                                                jubaoInnerPageController9.submit();
                                            }
                                        } else {
                                            jubaoInnerPageController9.jumpToNextPage(7, 8);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                final JubaoInnerPageController jubaoInnerPageController9 = jubaoInnerPageController7;
                                jubaoReasonAddView2.backClickCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.17.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        JubaoInnerPageController.this.onBackClick();
                                        return Unit.INSTANCE;
                                    }
                                };
                                final JubaoInnerPageController jubaoInnerPageController10 = jubaoInnerPageController7;
                                jubaoReasonAddView2.keyboardHeightChangeCallBack = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.17.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Float f16) {
                                        O3Module.updateFloatingView$default(JubaoInnerPageController.this.pageModel.getO3Module(), 0, Integer.valueOf((f16.floatValue() > 0.0f ? 100 : 0) + 580), null, null, 29);
                                        return Unit.INSTANCE;
                                    }
                                };
                                final JubaoInnerPage jubaoInnerPage16 = JubaoInnerPage.this;
                                JubaoAnimationViewKt.updateVisibility(jubaoReasonAddView2, new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.17.1.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        JubaoInnerPage jubaoInnerPage17 = JubaoInnerPage.this;
                                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                                        return Boolean.valueOf(jubaoInnerPage17.getCurPageViewData().curStep == 5);
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoInnerPage jubaoInnerPage15 = this;
                Function0<Object> function07 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.18
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        JubaoInnerPage jubaoInnerPage16 = JubaoInnerPage.this;
                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                        return Boolean.valueOf((jubaoInnerPage16.getCurPageViewData().curViewFlag & 8) > 0);
                    }
                };
                final JubaoInnerPage jubaoInnerPage16 = this;
                final JubaoInnerPageController jubaoInnerPageController7 = jubaoInnerPageController;
                ConditionViewKt.c(viewContainer2, function07, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.19
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        if (!JubaoConfig.isQuickJubao) {
                            final JubaoInnerPage jubaoInnerPage17 = JubaoInnerPage.this;
                            PageModel pageModel = jubaoInnerPage17.pageModel;
                            final JubaoInnerPageController jubaoInnerPageController8 = jubaoInnerPageController7;
                            conditionView2.addChild(new JubaoChatEvidenceView(pageModel), new Function1<JubaoChatEvidenceView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.19.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(JubaoChatEvidenceView jubaoChatEvidenceView) {
                                    JubaoChatEvidenceView jubaoChatEvidenceView2 = jubaoChatEvidenceView;
                                    JubaoInnerPage.this.viewStack.add(jubaoChatEvidenceView2);
                                    JubaoUtil.fillParent$default(jubaoChatEvidenceView2);
                                    final JubaoInnerPageController jubaoInnerPageController9 = jubaoInnerPageController8;
                                    jubaoChatEvidenceView2.selectChatMsgCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.19.1.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            JubaoInnerPageController.this.onSelectChatMsgClick();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final JubaoInnerPageController jubaoInnerPageController10 = jubaoInnerPageController8;
                                    jubaoChatEvidenceView2.submitCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.19.1.2
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            JubaoInnerPageController.this.onSelectChatMsgCompleteClick();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final JubaoInnerPageController jubaoInnerPageController11 = jubaoInnerPageController8;
                                    jubaoChatEvidenceView2.backClickCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.19.1.3
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            JubaoInnerPageController.this.onBackClick();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final JubaoInnerPage jubaoInnerPage18 = JubaoInnerPage.this;
                                    JubaoAnimationViewKt.updateVisibility(jubaoChatEvidenceView2, new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.19.1.4
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            JubaoInnerPage jubaoInnerPage19 = JubaoInnerPage.this;
                                            KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                                            return Boolean.valueOf(jubaoInnerPage19.getCurPageViewData().curStep == 7);
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else {
                            final JubaoInnerPage jubaoInnerPage18 = JubaoInnerPage.this;
                            PageModel pageModel2 = jubaoInnerPage18.pageModel;
                            final JubaoInnerPageController jubaoInnerPageController9 = jubaoInnerPageController7;
                            conditionView2.addChild(new QuickJubaoChatEvidenceView(pageModel2), new Function1<QuickJubaoChatEvidenceView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.19.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QuickJubaoChatEvidenceView quickJubaoChatEvidenceView) {
                                    QuickJubaoChatEvidenceView quickJubaoChatEvidenceView2 = quickJubaoChatEvidenceView;
                                    JubaoInnerPage.this.viewStack.add(quickJubaoChatEvidenceView2);
                                    JubaoUtil.fillParent$default(quickJubaoChatEvidenceView2);
                                    final JubaoInnerPageController jubaoInnerPageController10 = jubaoInnerPageController9;
                                    quickJubaoChatEvidenceView2.selectChatMsgCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.19.2.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            JubaoInnerPageController.this.onSelectChatMsgClick();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final JubaoInnerPageController jubaoInnerPageController11 = jubaoInnerPageController9;
                                    quickJubaoChatEvidenceView2.submitCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.19.2.2
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            JubaoInnerPageController.this.onSelectChatMsgCompleteClick();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final JubaoInnerPageController jubaoInnerPageController12 = jubaoInnerPageController9;
                                    quickJubaoChatEvidenceView2.backClickCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.19.2.3
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            JubaoInnerPageController.this.onBackClick();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final JubaoInnerPage jubaoInnerPage19 = JubaoInnerPage.this;
                                    JubaoAnimationViewKt.updateVisibility(quickJubaoChatEvidenceView2, new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.19.2.4
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            JubaoInnerPage jubaoInnerPage20 = JubaoInnerPage.this;
                                            KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                                            return Boolean.valueOf(jubaoInnerPage20.getCurPageViewData().curStep == 7);
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                });
                final JubaoInnerPage jubaoInnerPage17 = this;
                Function0<Object> function08 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.20
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        JubaoInnerPage jubaoInnerPage18 = JubaoInnerPage.this;
                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                        return Boolean.valueOf((jubaoInnerPage18.getCurPageViewData().curViewFlag & 16) > 0);
                    }
                };
                final JubaoInnerPage jubaoInnerPage18 = this;
                final JubaoInnerPageController jubaoInnerPageController8 = jubaoInnerPageController;
                ConditionViewKt.c(viewContainer2, function08, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.21
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final JubaoInnerPage jubaoInnerPage19 = JubaoInnerPage.this;
                        PageModel pageModel = jubaoInnerPage19.pageModel;
                        final JubaoInnerPageController jubaoInnerPageController9 = jubaoInnerPageController8;
                        conditionView.addChild(new JubaoMoreEvidenceView(pageModel), new Function1<JubaoMoreEvidenceView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.21.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(JubaoMoreEvidenceView jubaoMoreEvidenceView) {
                                JubaoMoreEvidenceView jubaoMoreEvidenceView2 = jubaoMoreEvidenceView;
                                JubaoInnerPage.this.viewStack.add(jubaoMoreEvidenceView2);
                                jubaoMoreEvidenceView2.attr(new JubaoUtil$fillParent$1(0.0f));
                                final JubaoInnerPageController jubaoInnerPageController10 = jubaoInnerPageController9;
                                jubaoMoreEvidenceView2.onComplete = new Function2<List<? extends String>, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.21.1.1
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(List<? extends String> list, Float f16) {
                                        final List<? extends String> list2 = list;
                                        float floatValue = f16.floatValue();
                                        final JubaoInnerPageController jubaoInnerPageController11 = JubaoInnerPageController.this;
                                        if (floatValue < 0.0f) {
                                            jubaoInnerPageController11.pageModel.money = 0L;
                                        } else {
                                            jubaoInnerPageController11.pageModel.money = floatValue * 100;
                                        }
                                        if (!list2.isEmpty()) {
                                            jubaoInnerPageController11.pageModel.setOperateStatus(1);
                                            final PageModel pageModel2 = jubaoInnerPageController11.pageModel;
                                            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$onMoreEvidenceClick$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Boolean bool) {
                                                    boolean booleanValue = bool.booleanValue();
                                                    com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                    ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).log("upload pics complete " + booleanValue);
                                                    if (booleanValue) {
                                                        JubaoInnerPageController jubaoInnerPageController12 = JubaoInnerPageController.this;
                                                        if (!JubaoConfig.isQuickJubao) {
                                                            jubaoInnerPageController12.submit();
                                                        } else {
                                                            jubaoInnerPageController12.updateReasonInner();
                                                        }
                                                    } else {
                                                        ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).qToast("\u4e0a\u4f20\u5931\u8d25", QToastMode.Warning);
                                                        JubaoInnerPageController.this.pageModel.setOperateStatus(0);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            O3Module o3Module = pageModel2.getO3Module();
                                            e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("version", 1);
                                            Unit unit = Unit.INSTANCE;
                                            o3Module.sendRequest("GetCosTmpSecret", m3, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$uploadPics$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.jubao.PageModel$uploadPics$2$1", f = "PageModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                                /* renamed from: com.tencent.hippykotlin.demo.pages.jubao.PageModel$uploadPics$2$1, reason: invalid class name */
                                                /* loaded from: classes31.dex */
                                                public final class AnonymousClass1 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                                                    public final /* synthetic */ Function1<Boolean, Unit> $callback;
                                                    public final /* synthetic */ String $expiredTime;
                                                    public final /* synthetic */ List<String> $files;
                                                    public final /* synthetic */ String $si;
                                                    public final /* synthetic */ String $sk;
                                                    public final /* synthetic */ String $startTime;
                                                    public final /* synthetic */ String $token;
                                                    public final /* synthetic */ PageModel this$0;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    public AnonymousClass1(PageModel pageModel, String str, String str2, List<String> list, String str3, String str4, String str5, Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.this$0 = pageModel;
                                                        this.$startTime = str;
                                                        this.$expiredTime = str2;
                                                        this.$files = list;
                                                        this.$si = str3;
                                                        this.$sk = str4;
                                                        this.$token = str5;
                                                        this.$callback = function1;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.this$0, this.$startTime, this.$expiredTime, this.$files, this.$si, this.$sk, this.$token, this.$callback, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                                        return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object obj) {
                                                        String trimIndent;
                                                        String trimIndent2;
                                                        String trimIndent3;
                                                        String replace$default;
                                                        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        ResultKt.throwOnFailure(obj);
                                                        O3Module o3Module = this.this$0.getO3Module();
                                                        String str = this.$startTime + ';' + this.$expiredTime;
                                                        final PageModel pageModel = this.this$0;
                                                        boolean z16 = false;
                                                        pageModel.uploadSuccessNum = 0;
                                                        pageModel.uploadCompleteNum = 0;
                                                        final List<String> list = this.$files;
                                                        String str2 = this.$si;
                                                        String str3 = this.$sk;
                                                        String str4 = this.$token;
                                                        final Function1<Boolean, Unit> function1 = this.$callback;
                                                        for (final String str5 : list) {
                                                            String str6 = pageModel.pics.get(str5);
                                                            if ((str6 == null || str6.length() == 0) ? true : z16) {
                                                                final Function1<e, Unit> function12 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$uploadPics$2$1$1$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(e eVar) {
                                                                        e eVar2 = eVar;
                                                                        String p16 = eVar2.p("url");
                                                                        ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("uploadFileToCos complete " + eVar2);
                                                                        PageModel.access$onSinglePicUploadComplete(PageModel.this, list.size(), str5, p16, eVar2.j("code") == 200, function1);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("/public/report/");
                                                                m3.append(o3Module.toNative(false, "sha1", AgreementConsentViewKt$$ExternalSyntheticOutline0.m(str5, str), null, true).toString());
                                                                m3.append(".jpeg");
                                                                String sb5 = m3.toString();
                                                                String hmac = o3Module.hmac(str, str3);
                                                                trimIndent = StringsKt__IndentKt.trimIndent("\n        put\n        " + sb5 + "\n\n        x-cos-security-token=" + str4 + "\n        \n    ");
                                                                trimIndent2 = StringsKt__IndentKt.trimIndent("\n        sha1\n        " + str + "\n        " + o3Module.toNative(false, "sha1", trimIndent, null, true).toString() + "\n        \n    ");
                                                                String hmac2 = o3Module.hmac(trimIndent2, hmac);
                                                                StringBuilder a16 = j.a("\n        q-sign-algorithm=sha1\n        &q-ak=", str2, "\n        &q-sign-time=", str, "\n        &q-key-time=");
                                                                a16.append(str);
                                                                a16.append("\n        &q-header-list=x-cos-security-token\n        &q-url-param-list=\n        &q-signature=");
                                                                a16.append(hmac2);
                                                                a16.append("\n    ");
                                                                trimIndent3 = StringsKt__IndentKt.trimIndent(a16.toString());
                                                                replace$default = StringsKt__StringsJVMKt.replace$default(trimIndent3, "\n", "", false, 4, (Object) null);
                                                                final String m16 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("https://accounts-qq-1251316161.cos.ap-guangzhou.tencentcos.cn", sb5);
                                                                e m17 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m(TencentMapServiceProtocol.SERVICE_NAME_AUTHORIZATION, replace$default, "x-cos-security-token", str4);
                                                                Function1<e, Unit> function13 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.UploadUtil$uploadFileToCos$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(e eVar) {
                                                                        final e eVar2 = eVar;
                                                                        Function1<e, Unit> function14 = function12;
                                                                        final String str7 = m16;
                                                                        function14.invoke(new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.UploadUtil$uploadFileToCos$1.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(e eVar3) {
                                                                                e eVar4 = eVar3;
                                                                                e eVar5 = e.this;
                                                                                eVar4.v("code", eVar5 != null ? Integer.valueOf(eVar5.j("code")) : null);
                                                                                eVar4.v("url", str7);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                e m18 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("filePath", str5, "url", m16);
                                                                m18.v("httpHeads", m17);
                                                                Unit unit = Unit.INSTANCE;
                                                                o3Module.toNative(false, "uploadPic", m18.toString(), function13, false).toString();
                                                                str3 = str3;
                                                            } else {
                                                                ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log(str5 + " already uploaded");
                                                                PageModel.access$onSinglePicUploadComplete(pageModel, list.size(), str5, str6, true, function1);
                                                            }
                                                            z16 = false;
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(e eVar) {
                                                    String p16;
                                                    String p17;
                                                    String p18;
                                                    String p19;
                                                    String p26;
                                                    e eVar2 = eVar;
                                                    if (eVar2 != null && eVar2.k("code", -1) == 0) {
                                                        e m16 = eVar2.m("data");
                                                        e m17 = m16 != null ? m16.m("credential") : null;
                                                        String str = (m16 == null || (p26 = m16.p("expired_time")) == null) ? "" : p26;
                                                        String str2 = (m16 == null || (p19 = m16.p("start_time")) == null) ? "" : p19;
                                                        String str3 = (m17 == null || (p18 = m17.p("tmp_secret_id")) == null) ? "" : p18;
                                                        String str4 = (m17 == null || (p17 = m17.p("tmp_secret_key")) == null) ? "" : p17;
                                                        String str5 = (m17 == null || (p16 = m17.p("session_token")) == null) ? "" : p16;
                                                        if (!(str.length() == 0)) {
                                                            if (!(str2.length() == 0)) {
                                                                if (!(str3.length() == 0)) {
                                                                    if (!(str4.length() == 0)) {
                                                                        if (!(str5.length() == 0)) {
                                                                            BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new AnonymousClass1(pageModel2, str2, str, list2, str3, str4, str5, function1, null), 3, null);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("GetCosTmpSecret data is empty " + eVar2);
                                                        function1.invoke(Boolean.FALSE);
                                                    } else {
                                                        ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("GetCosTmpSecret error " + eVar2);
                                                        function1.invoke(Boolean.FALSE);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        } else if (!JubaoConfig.isQuickJubao) {
                                            jubaoInnerPageController11.submit();
                                        } else {
                                            jubaoInnerPageController11.updateReasonInner();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                final JubaoInnerPageController jubaoInnerPageController11 = jubaoInnerPageController9;
                                jubaoMoreEvidenceView2.backClickCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.21.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        JubaoInnerPageController.this.onBackClick();
                                        return Unit.INSTANCE;
                                    }
                                };
                                final JubaoInnerPage jubaoInnerPage20 = JubaoInnerPage.this;
                                JubaoAnimationViewKt.updateVisibility(jubaoMoreEvidenceView2, new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.21.1.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        JubaoInnerPage jubaoInnerPage21 = JubaoInnerPage.this;
                                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                                        return Boolean.valueOf(jubaoInnerPage21.getCurPageViewData().curStep == 8);
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoInnerPage jubaoInnerPage19 = this;
                Function0<Object> function09 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.22
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        JubaoInnerPage jubaoInnerPage20 = JubaoInnerPage.this;
                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                        return Boolean.valueOf(jubaoInnerPage20.getCurPageViewData().curStep == 10);
                    }
                };
                final JubaoInnerPage jubaoInnerPage20 = this;
                ConditionViewKt.c(viewContainer2, function09, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.23
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final JubaoInnerPage jubaoInnerPage21 = JubaoInnerPage.this;
                        ErrorData errorData = jubaoInnerPage21.pageModel.submitErrorData;
                        conditionView.addChild(new JubaoErrorView(errorData), new Function1<JubaoErrorView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.23.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(JubaoErrorView jubaoErrorView) {
                                JubaoErrorView jubaoErrorView2 = jubaoErrorView;
                                JubaoUtil.fillParent$default(jubaoErrorView2);
                                final JubaoInnerPage jubaoInnerPage22 = JubaoInnerPage.this;
                                jubaoErrorView2.continueCallback = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.23.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Integer num) {
                                        Object last;
                                        int intValue = num.intValue();
                                        JubaoInnerPageController jubaoInnerPageController9 = JubaoInnerPage.this.pageController;
                                        jubaoInnerPageController9.getClass();
                                        if (intValue == 0) {
                                            JubaoInnerPage jubaoInnerPage23 = jubaoInnerPageController9.page;
                                            CollectionsKt__MutableCollectionsKt.removeLast(jubaoInnerPage23.pageViewDataStack);
                                            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) jubaoInnerPage23.pageViewDataStack);
                                            jubaoInnerPage23.setCurPageViewData((PageViewData) last);
                                            jubaoInnerPageController9.onViewChanged();
                                        } else if (intValue == 2) {
                                            jubaoInnerPageController9.pageModel.getO3Module().dismiss();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoInnerPage jubaoInnerPage21 = this;
                Function0<Object> function010 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.24
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        JubaoInnerPage jubaoInnerPage22 = JubaoInnerPage.this;
                        KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                        return Boolean.valueOf((jubaoInnerPage22.getCurPageViewData().curViewFlag & 32) > 0);
                    }
                };
                final JubaoInnerPage jubaoInnerPage22 = this;
                final JubaoInnerPageController jubaoInnerPageController9 = jubaoInnerPageController;
                ConditionViewKt.c(viewContainer2, function010, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$body$1.25
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        if (!JubaoConfig.isQuickJubao) {
                            final JubaoInnerPage jubaoInnerPage23 = JubaoInnerPage.this;
                            PageModel pageModel = jubaoInnerPage23.pageModel;
                            final JubaoInnerPageController jubaoInnerPageController10 = jubaoInnerPageController9;
                            conditionView2.addChild(new JubaoCompleteView(pageModel), new Function1<JubaoCompleteView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.25.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(JubaoCompleteView jubaoCompleteView) {
                                    JubaoCompleteView jubaoCompleteView2 = jubaoCompleteView;
                                    JubaoInnerPage.this.viewStack.add(jubaoCompleteView2);
                                    JubaoUtil.fillParent$default(jubaoCompleteView2);
                                    final JubaoInnerPageController jubaoInnerPageController11 = jubaoInnerPageController10;
                                    jubaoCompleteView2.operateCallback = new Function1<OperateData, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.25.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(OperateData operateData) {
                                            JubaoInnerPageController.this.operate(operateData);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final JubaoInnerPage jubaoInnerPage24 = JubaoInnerPage.this;
                                    JubaoAnimationViewKt.updateVisibility(jubaoCompleteView2, new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.25.1.2
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            JubaoInnerPage jubaoInnerPage25 = JubaoInnerPage.this;
                                            KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                                            return Boolean.valueOf(jubaoInnerPage25.getCurPageViewData().curStep == 9);
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else {
                            final JubaoInnerPage jubaoInnerPage24 = JubaoInnerPage.this;
                            PageModel pageModel2 = jubaoInnerPage24.pageModel;
                            final JubaoInnerPageController jubaoInnerPageController11 = jubaoInnerPageController9;
                            conditionView2.addChild(new QuickJubaoCompleteView(pageModel2), new Function1<QuickJubaoCompleteView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.25.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QuickJubaoCompleteView quickJubaoCompleteView) {
                                    QuickJubaoCompleteView quickJubaoCompleteView2 = quickJubaoCompleteView;
                                    JubaoInnerPage.this.viewStack.add(quickJubaoCompleteView2);
                                    JubaoUtil.fillParent$default(quickJubaoCompleteView2);
                                    final JubaoInnerPageController jubaoInnerPageController12 = jubaoInnerPageController11;
                                    quickJubaoCompleteView2.onUpdateReasonSelectCallback = new Function1<UpdateReasonData, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.25.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(UpdateReasonData updateReasonData) {
                                            UpdateReasonData updateReasonData2 = updateReasonData;
                                            JubaoInnerPageController jubaoInnerPageController13 = JubaoInnerPageController.this;
                                            jubaoInnerPageController13.pageModel.updateReason = updateReasonData2;
                                            if (updateReasonData2.flag == 1) {
                                                jubaoInnerPageController13.jumpToNextPage(8, 16);
                                            } else {
                                                jubaoInnerPageController13.updateReasonInner();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final JubaoInnerPageController jubaoInnerPageController13 = jubaoInnerPageController11;
                                    quickJubaoCompleteView2.operateCallback = new Function1<OperateData, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.25.2.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(OperateData operateData) {
                                            JubaoInnerPageController.this.operate(operateData);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final JubaoInnerPage jubaoInnerPage25 = JubaoInnerPage.this;
                                    quickJubaoCompleteView2.closeCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.25.2.3
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            JubaoInnerPage.this.pageModel.getO3Module().dismiss();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final JubaoInnerPage jubaoInnerPage26 = JubaoInnerPage.this;
                                    JubaoAnimationViewKt.updateVisibility(quickJubaoCompleteView2, new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage.body.1.25.2.4
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            JubaoInnerPage jubaoInnerPage27 = JubaoInnerPage.this;
                                            KProperty<Object>[] kPropertyArr = JubaoInnerPage.$$delegatedProperties;
                                            return Boolean.valueOf(jubaoInnerPage27.getCurPageViewData().curStep == 9);
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final Map<String, Module> createExternalModules() {
        Map<String, Module> mutableMap;
        mutableMap = MapsKt__MapsKt.toMutableMap(super.createExternalModules());
        if (mutableMap == null) {
            mutableMap = new LinkedHashMap<>();
        }
        mutableMap.put("QQKuiklySecurityModule", new O3Module());
        mutableMap.put("VasKuiklyModule", new VasModule());
        return mutableMap;
    }

    public final PageViewData getCurPageViewData() {
        return (PageViewData) this.curPageViewData$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setCurPageViewData(PageViewData pageViewData) {
        this.curPageViewData$delegate.setValue(this, $$delegatedProperties[0], pageViewData);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x012a, code lost:
    
        if (r1.equals("100898") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0138, code lost:
    
        r1 = "\u8bc4\u8bba";
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0135, code lost:
    
        if (r1.equals("100897") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0143, code lost:
    
        if (r1.equals("100868") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x018a, code lost:
    
        r1 = "\u5185\u5bb9";
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x014d, code lost:
    
        if (r1.equals("10190") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0165, code lost:
    
        if (r1.equals("10092") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x017c, code lost:
    
        r1 = "\u7fa4\u804a";
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x016f, code lost:
    
        if (r1.equals("10089") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0179, code lost:
    
        if (r1.equals("10087") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0187, code lost:
    
        if (r1.equals("10072") == false) goto L70;
     */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void created() {
        String str;
        boolean startsWith$default;
        boolean startsWith$default2;
        registerViewCreator("TextView", new f() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$registerDefaultAccessibilityForTextComponent$1
            @Override // com.tencent.kuikly.core.pager.f
            public final DeclarativeBaseView<?, ?> createView() {
                return new AccessibilityTextView();
            }
        });
        registerViewCreator("RichTextView", new f() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$registerDefaultAccessibilityForTextComponent$2
            @Override // com.tencent.kuikly.core.pager.f
            public final DeclarativeBaseView<?, ?> createView() {
                return new AccessibilityRichTextView();
            }
        });
        super.created();
        if (this.pageModel.getPostData().grayId.length() > 0) {
            setCurPageViewData(new PageViewData(12, 0));
        }
        this.pageViewDataStack.add(getCurPageViewData());
        b bVar = null;
        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new JubaoInnerPage$created$1(this, null), 3, null);
        final PageModel pageModel = this.pageModel;
        byte[] a16 = a.a(pageModel.getPostData().msgs);
        String decodeToString = a16 != null ? StringsKt__StringsJVMKt.decodeToString(a16) : null;
        if (decodeToString != null) {
            startsWith$default = StringsKt__StringsKt.startsWith$default((CharSequence) decodeToString, '[', false, 2, (Object) null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsKt.startsWith$default((CharSequence) decodeToString, '{', false, 2, (Object) null);
                if (startsWith$default2) {
                    bVar = new e(decodeToString).l("msgs");
                }
            } else {
                bVar = new b(decodeToString);
            }
        }
        if (bVar != null) {
            int c16 = bVar.c();
            if (c16 > 0) {
                pageModel.setEvidenceNum(c16);
                e eVar = new e();
                eVar.t("msgcount", c16);
                eVar.v("msgs", bVar);
                pageModel.selectedMsgRecords = eVar;
                pageModel.getO3Module().uploadChatMsgs(pageModel.getPostData().identifier, pageModel.getPostData().chatUin, pageModel.getPostData().chatType, pageModel.getPostData().groupCode, pageModel.getPostData().evilUin, String.valueOf(pageModel.selectedMsgRecords), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$getMsgsFromPageData$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar2) {
                        String str2;
                        String p16;
                        e eVar3 = eVar2;
                        PageModel pageModel2 = PageModel.this;
                        String str3 = "";
                        if (eVar3 == null || (str2 = eVar3.p("uuid")) == null) {
                            str2 = "";
                        }
                        pageModel2.uuid = str2;
                        O3PostData postData = PageModel.this.getPostData();
                        if (eVar3 != null && (p16 = eVar3.p("result")) != null) {
                            str3 = p16;
                        }
                        postData.postData.v("upload_result", str3);
                        ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("upload msgs result " + eVar3);
                        return Unit.INSTANCE;
                    }
                });
            }
            ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("business msgs is " + bVar);
        }
        String str2 = this.pageModel.getPostData().appId;
        String str3 = this.pageModel.getPostData().customScene;
        if (str3.length() > 0) {
            JubaoConfig.description = str3;
        } else {
            switch (str2.hashCode()) {
                case 46730348:
                    if (str2.equals("10061")) {
                        str = "\u7a7a\u95f4";
                        break;
                    }
                    str = "\u8d26\u53f7";
                    break;
                case 46730380:
                    break;
                case 46730416:
                    break;
                case 46730418:
                    break;
                case 46730442:
                    break;
                case 46731154:
                    if (str2.equals("10111")) {
                        str = "\u9891\u9053";
                        break;
                    }
                    str = "\u8d26\u53f7";
                    break;
                case 46731401:
                    break;
                case 1448642921:
                    break;
                case 1448643013:
                    break;
                case 1448643014:
                    break;
                default:
                    str = "\u8d26\u53f7";
                    break;
            }
            JubaoConfig.description = str;
        }
        BridgeModule bridgeModule = (BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule");
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("page height is ");
        m3.append(getPageData().l());
        bridgeModule.log(m3.toString());
    }
}
