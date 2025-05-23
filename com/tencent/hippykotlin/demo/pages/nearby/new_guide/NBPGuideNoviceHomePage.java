package com.tencent.hippykotlin.demo.pages.nearby.new_guide;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageViewEvent;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import defpackage.k;
import f35.g;
import f35.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import t35.a;
import t35.b;

/* loaded from: classes31.dex */
public final class NBPGuideNoviceHomePage extends NearbyBasePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public String nickEditFinishNotifyRef;
    public NBPGuideNoviceViewModel viewModel;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.alignItemsStretch();
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideNoviceHomePage nBPGuideNoviceHomePage = NBPGuideNoviceHomePage.this;
                viewContainer2.addChild(new NBPGuideNoviceFirstPageView(), new Function1<NBPGuideNoviceFirstPageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView) {
                        NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView2 = nBPGuideNoviceFirstPageView;
                        final NBPGuideNoviceHomePage nBPGuideNoviceHomePage2 = NBPGuideNoviceHomePage.this;
                        nBPGuideNoviceFirstPageView2.attr(new Function1<NBPGuideNoviceFirstPageViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideNoviceFirstPageViewAttr nBPGuideNoviceFirstPageViewAttr) {
                                NBPGuideNoviceFirstPageViewAttr nBPGuideNoviceFirstPageViewAttr2 = nBPGuideNoviceFirstPageViewAttr;
                                NBPGuideNoviceViewModel nBPGuideNoviceViewModel = NBPGuideNoviceHomePage.this.viewModel;
                                if (nBPGuideNoviceViewModel != null) {
                                    nBPGuideNoviceFirstPageViewAttr2.viewModel = nBPGuideNoviceViewModel;
                                }
                                nBPGuideNoviceFirstPageViewAttr2.absolutePositionAllZero();
                                NBPGuideNoviceViewModel nBPGuideNoviceViewModel2 = NBPGuideNoviceHomePage.this.viewModel;
                                nBPGuideNoviceFirstPageViewAttr2.m152visibility(nBPGuideNoviceViewModel2 != null && nBPGuideNoviceViewModel2.getCurrentPageIndex() == 0);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideNoviceHomePage nBPGuideNoviceHomePage3 = NBPGuideNoviceHomePage.this;
                        nBPGuideNoviceFirstPageView2.event(new Function1<NBPGuideNoviceFirstPageViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideNoviceFirstPageViewEvent nBPGuideNoviceFirstPageViewEvent) {
                                NBPGuideNoviceFirstPageViewEvent nBPGuideNoviceFirstPageViewEvent2 = nBPGuideNoviceFirstPageViewEvent;
                                nBPGuideNoviceFirstPageViewEvent2.onBackEventHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                        return Unit.INSTANCE;
                                    }
                                };
                                final NBPGuideNoviceHomePage nBPGuideNoviceHomePage4 = NBPGuideNoviceHomePage.this;
                                nBPGuideNoviceFirstPageViewEvent2.onNextEventHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage.body.1.2.2.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPGuideNoviceHomePage nBPGuideNoviceHomePage5 = NBPGuideNoviceHomePage.this;
                                        int i3 = NBPGuideNoviceHomePage.$r8$clinit;
                                        nBPGuideNoviceHomePage5.customDtReportPageExposure("pg_nearby_choose_interest", true);
                                        nBPGuideNoviceHomePage5.customDtReportPageExposure("pg_nearby_new_user_register", false);
                                        NBPGuideNoviceViewModel nBPGuideNoviceViewModel = nBPGuideNoviceHomePage5.viewModel;
                                        if (nBPGuideNoviceViewModel != null) {
                                            nBPGuideNoviceViewModel.currentPageIndex$delegate.setValue(nBPGuideNoviceViewModel, NBPGuideNoviceViewModel.$$delegatedProperties[10], 1);
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
                final NBPGuideNoviceHomePage nBPGuideNoviceHomePage2 = NBPGuideNoviceHomePage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage$body$1.3
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
                    
                        if (r0.getCurrentPageIndex() == 1) goto L8;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        NBPGuideNoviceViewModel nBPGuideNoviceViewModel = NBPGuideNoviceHomePage.this.viewModel;
                        boolean z16 = nBPGuideNoviceViewModel != null;
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPGuideNoviceHomePage nBPGuideNoviceHomePage3 = NBPGuideNoviceHomePage.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPGuideNoviceHomePage nBPGuideNoviceHomePage4 = NBPGuideNoviceHomePage.this;
                        final Function1<ECTransitionView, Unit> function1 = new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionView eCTransitionView) {
                                ECTransitionView eCTransitionView2 = eCTransitionView;
                                eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                        eCTransitionAttr.absolutePositionAllZero();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideNoviceHomePage nBPGuideNoviceHomePage5 = NBPGuideNoviceHomePage.this;
                                eCTransitionView2.addChild(new NBPGuideNoviceSecondPageView(), new Function1<NBPGuideNoviceSecondPageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage.body.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView) {
                                        NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView2 = nBPGuideNoviceSecondPageView;
                                        final NBPGuideNoviceHomePage nBPGuideNoviceHomePage6 = NBPGuideNoviceHomePage.this;
                                        nBPGuideNoviceSecondPageView2.attr(new Function1<NBPGuideNoviceSecondPageViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage.body.1.4.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPGuideNoviceSecondPageViewAttr nBPGuideNoviceSecondPageViewAttr) {
                                                NBPGuideNoviceSecondPageViewAttr nBPGuideNoviceSecondPageViewAttr2 = nBPGuideNoviceSecondPageViewAttr;
                                                NBPGuideNoviceViewModel nBPGuideNoviceViewModel = NBPGuideNoviceHomePage.this.viewModel;
                                                if (nBPGuideNoviceViewModel != null) {
                                                    nBPGuideNoviceSecondPageViewAttr2.viewModel = nBPGuideNoviceViewModel;
                                                }
                                                nBPGuideNoviceSecondPageViewAttr2.absolutePositionAllZero();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideNoviceHomePage nBPGuideNoviceHomePage7 = NBPGuideNoviceHomePage.this;
                                        nBPGuideNoviceSecondPageView2.event(new Function1<NBPGuideNoviceSecondPageViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage.body.1.4.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPGuideNoviceSecondPageViewEvent nBPGuideNoviceSecondPageViewEvent) {
                                                NBPGuideNoviceSecondPageViewEvent nBPGuideNoviceSecondPageViewEvent2 = nBPGuideNoviceSecondPageViewEvent;
                                                final NBPGuideNoviceHomePage nBPGuideNoviceHomePage8 = NBPGuideNoviceHomePage.this;
                                                nBPGuideNoviceSecondPageViewEvent2.onBackEventHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage.body.1.4.1.2.2.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        NBPGuideNoviceHomePage nBPGuideNoviceHomePage9 = NBPGuideNoviceHomePage.this;
                                                        int i3 = NBPGuideNoviceHomePage.$r8$clinit;
                                                        nBPGuideNoviceHomePage9.goFirstPage();
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final NBPGuideNoviceHomePage nBPGuideNoviceHomePage9 = NBPGuideNoviceHomePage.this;
                                                nBPGuideNoviceSecondPageViewEvent2.onNextEventHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage.body.1.4.1.2.2.2
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                                                    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    /*
                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                    */
                                                    public final Unit invoke() {
                                                        String str;
                                                        c<a> selectedTagList;
                                                        Object randomOrNull;
                                                        NBPGuideNoviceHomePage nBPGuideNoviceHomePage10 = NBPGuideNoviceHomePage.this;
                                                        int i3 = NBPGuideNoviceHomePage.$r8$clinit;
                                                        boolean z16 = false;
                                                        nBPGuideNoviceHomePage10.customDtReportPageExposure("pg_nearby_choose_interest", false);
                                                        NBPGuideNoviceViewModel nBPGuideNoviceViewModel = nBPGuideNoviceHomePage10.viewModel;
                                                        if (nBPGuideNoviceViewModel != null && (selectedTagList = nBPGuideNoviceViewModel.getSelectedTagList()) != null) {
                                                            randomOrNull = CollectionsKt___CollectionsKt.randomOrNull(selectedTagList, Random.INSTANCE);
                                                            a aVar = (a) randomOrNull;
                                                            if (aVar != null) {
                                                                str = i.c(aVar);
                                                                if (str != null) {
                                                                    if (str.length() > 0) {
                                                                        z16 = true;
                                                                    }
                                                                }
                                                                String str2 = "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearbypro_main&show_marker_guide=1";
                                                                if (z16) {
                                                                    StringBuilder m3 = HotViewKt$$ExternalSyntheticOutline0.m("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearbypro_main&show_marker_guide=1", "&marker_guide_tag=");
                                                                    m3.append(UriKt.encodeURIComponent(str));
                                                                    str2 = m3.toString();
                                                                }
                                                                DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("jump to:", str2, KLog.INSTANCE, "NoviceGuideHomePage");
                                                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                QQKuiklyPlatformApi.Companion.openPage$default(str2, true, 4);
                                                                return Unit.INSTANCE;
                                                            }
                                                        }
                                                        str = null;
                                                        if (str != null) {
                                                        }
                                                        String str22 = "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearbypro_main&show_marker_guide=1";
                                                        if (z16) {
                                                        }
                                                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("jump to:", str22, KLog.INSTANCE, "NoviceGuideHomePage");
                                                        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.openPage$default(str22, true, 4);
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
                        };
                        conditionView.addChild(new ECTransitionView(), new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt$TransitionFromRightView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionView eCTransitionView) {
                                ECTransitionView eCTransitionView2 = eCTransitionView;
                                eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt$TransitionFromRightView$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                        eCTransitionAttr.transitionType = 3;
                                        return Unit.INSTANCE;
                                    }
                                });
                                function1.invoke(eCTransitionView2);
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

    public final void goFirstPage() {
        customDtReportPageExposure("pg_nearby_new_user_register", true);
        NBPGuideNoviceViewModel nBPGuideNoviceViewModel = this.viewModel;
        if (nBPGuideNoviceViewModel != null && nBPGuideNoviceViewModel.getCurrentPageIndex() == 1) {
            customDtReportPageExposure("pg_nearby_choose_interest", false);
        }
        NBPGuideNoviceViewModel nBPGuideNoviceViewModel2 = this.viewModel;
        if (nBPGuideNoviceViewModel2 == null) {
            return;
        }
        nBPGuideNoviceViewModel2.currentPageIndex$delegate.setValue(nBPGuideNoviceViewModel2, NBPGuideNoviceViewModel.$$delegatedProperties[10], 0);
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            NBPGuideNoviceViewModel nBPGuideNoviceViewModel = this.viewModel;
            if (nBPGuideNoviceViewModel != null && nBPGuideNoviceViewModel.getCurrentPageIndex() > 0) {
                goFirstPage();
            } else {
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.closePage$default();
            }
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        String str = this.nickEditFinishNotifyRef;
        if (str != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("NEARBY_PROFILE_EDIT_NICK_FINISH", str);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        QQKuiklyPlatformApi.Companion.setEdgePopWidth(0.0f);
        goFirstPage();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0011, code lost:
    
        r1 = kotlin.collections.ArraysKt___ArraysKt.firstOrNull(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007a A[LOOP:0: B:21:0x0074->B:23:0x007a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013e  */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void created() {
        g gVar;
        NBPGuideNoviceViewModel nBPGuideNoviceViewModel;
        Long valueOf;
        List<String> avatarUrls;
        Object firstOrNull;
        r25.e eVar;
        String str;
        j jVar;
        List<b> list;
        Object firstOrNull2;
        b bVar;
        List<a> list2;
        int collectionSizeOrDefault;
        Iterator<T> it;
        Object firstOrNull3;
        super.created();
        Object[] sharePenetratePageData = QQNearbyModule.Companion.getInstance().getSharePenetratePageData();
        if (sharePenetratePageData != null && firstOrNull3 != null) {
            byte[] bArr = firstOrNull3 instanceof byte[] ? (byte[]) firstOrNull3 : null;
            if (bArr != null) {
                gVar = (g) i.b(new g(null, null, false, null, null, null, false, null, null, null, 1023, null), bArr);
                nBPGuideNoviceViewModel = new NBPGuideNoviceViewModel();
                nBPGuideNoviceViewModel.loginRsp$delegate.setValue(nBPGuideNoviceViewModel, NBPGuideNoviceViewModel.$$delegatedProperties[0], gVar);
                if (gVar != null && (jVar = gVar.E) != null && (list = jVar.f397813h) != null) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                    bVar = (b) firstOrNull2;
                    if (bVar != null && (list2 = bVar.f435370f) != null) {
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Boolean.valueOf(nBPGuideNoviceViewModel.getTagList().add((a) it.next())));
                        }
                    }
                }
                if (gVar != null && (eVar = gVar.f397801e) != null && (str = eVar.J) != null) {
                    nBPGuideNoviceViewModel.nick$delegate.setValue(nBPGuideNoviceViewModel, NBPGuideNoviceViewModel.$$delegatedProperties[3], str);
                }
                QQNearbyModule.Companion companion = QQNearbyModule.Companion;
                short parseShort = Short.parseShort(companion.getInstance().syncToNativeMethod("getUserGender", (e) null, (Function1<? super e, Unit>) null));
                int i3 = (k.a(com.tencent.kuikly.core.manager.c.f117352a) ? parseShort != 2 : parseShort != 1) ? 1 : 2;
                ReadWriteProperty readWriteProperty = nBPGuideNoviceViewModel.gender$delegate;
                KProperty<?>[] kPropertyArr = NBPGuideNoviceViewModel.$$delegatedProperties;
                readWriteProperty.setValue(nBPGuideNoviceViewModel, kPropertyArr[2], Integer.valueOf(i3));
                valueOf = Long.valueOf(Long.parseLong(companion.getInstance().syncToNativeMethod("getUserBirthday", (e) null, (Function1<? super e, Unit>) null)));
                if (!(valueOf.longValue() != 0)) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    long longValue = valueOf.longValue();
                    nBPGuideNoviceViewModel.birthdayYear$delegate.setValue(nBPGuideNoviceViewModel, kPropertyArr[4], Integer.valueOf((int) ((4294901760L & longValue) >> 16)));
                    nBPGuideNoviceViewModel.birthdayMonth$delegate.setValue(nBPGuideNoviceViewModel, kPropertyArr[5], Integer.valueOf((int) ((65280 & longValue) >> 8)));
                    nBPGuideNoviceViewModel.birthdayDay$delegate.setValue(nBPGuideNoviceViewModel, kPropertyArr[6], Integer.valueOf((int) (longValue & 255)));
                }
                avatarUrls = nBPGuideNoviceViewModel.getAvatarUrls();
                if (avatarUrls != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) avatarUrls);
                    String str2 = (String) firstOrNull;
                    if (str2 != null) {
                        nBPGuideNoviceViewModel.avatar$delegate.setValue(nBPGuideNoviceViewModel, kPropertyArr[1], str2);
                    }
                }
                this.viewModel = nBPGuideNoviceViewModel;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("viewModel: ");
                m3.append(this.viewModel);
                kLog.i("NoviceGuideHomePage", m3.toString());
                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage$created$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        final NBPGuideNoviceHomePage nBPGuideNoviceHomePage = NBPGuideNoviceHomePage.this;
                        nBPGuideNoviceHomePage.getClass();
                        nBPGuideNoviceHomePage.nickEditFinishNotifyRef = com.tencent.kuikly.core.module.k.b(IPagerIdKtxKt.getNotifyModule(nBPGuideNoviceHomePage), "NEARBY_PROFILE_EDIT_NICK_FINISH", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage$addNickEditFinishNotify$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar2) {
                                String p16;
                                NBPGuideNoviceViewModel nBPGuideNoviceViewModel2;
                                e eVar3 = eVar2;
                                if (eVar3 != null && (p16 = eVar3.p("nick")) != null && (nBPGuideNoviceViewModel2 = NBPGuideNoviceHomePage.this.viewModel) != null) {
                                    nBPGuideNoviceViewModel2.nick$delegate.setValue(nBPGuideNoviceViewModel2, NBPGuideNoviceViewModel.$$delegatedProperties[3], p16);
                                }
                                return Unit.INSTANCE;
                            }
                        }, 2, null);
                        return Unit.INSTANCE;
                    }
                };
                KProperty<Object>[] kPropertyArr2 = IPagerIdKtxKt.$$delegatedProperties;
                TimerKt.e(getPagerId(), 1, function0);
            }
        }
        gVar = null;
        nBPGuideNoviceViewModel = new NBPGuideNoviceViewModel();
        nBPGuideNoviceViewModel.loginRsp$delegate.setValue(nBPGuideNoviceViewModel, NBPGuideNoviceViewModel.$$delegatedProperties[0], gVar);
        if (gVar != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            bVar = (b) firstOrNull2;
            if (bVar != null) {
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                it = list2.iterator();
                while (it.hasNext()) {
                }
            }
        }
        if (gVar != null) {
            nBPGuideNoviceViewModel.nick$delegate.setValue(nBPGuideNoviceViewModel, NBPGuideNoviceViewModel.$$delegatedProperties[3], str);
        }
        QQNearbyModule.Companion companion2 = QQNearbyModule.Companion;
        short parseShort2 = Short.parseShort(companion2.getInstance().syncToNativeMethod("getUserGender", (e) null, (Function1<? super e, Unit>) null));
        if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
        }
        ReadWriteProperty readWriteProperty2 = nBPGuideNoviceViewModel.gender$delegate;
        KProperty<?>[] kPropertyArr3 = NBPGuideNoviceViewModel.$$delegatedProperties;
        readWriteProperty2.setValue(nBPGuideNoviceViewModel, kPropertyArr3[2], Integer.valueOf(i3));
        valueOf = Long.valueOf(Long.parseLong(companion2.getInstance().syncToNativeMethod("getUserBirthday", (e) null, (Function1<? super e, Unit>) null)));
        if (!(valueOf.longValue() != 0)) {
        }
        if (valueOf != null) {
        }
        avatarUrls = nBPGuideNoviceViewModel.getAvatarUrls();
        if (avatarUrls != null) {
        }
        this.viewModel = nBPGuideNoviceViewModel;
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m36 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("viewModel: ");
        m36.append(this.viewModel);
        kLog2.i("NoviceGuideHomePage", m36.toString());
        Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage$created$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                final NBPGuideNoviceHomePage nBPGuideNoviceHomePage = NBPGuideNoviceHomePage.this;
                nBPGuideNoviceHomePage.getClass();
                nBPGuideNoviceHomePage.nickEditFinishNotifyRef = com.tencent.kuikly.core.module.k.b(IPagerIdKtxKt.getNotifyModule(nBPGuideNoviceHomePage), "NEARBY_PROFILE_EDIT_NICK_FINISH", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage$addNickEditFinishNotify$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar2) {
                        String p16;
                        NBPGuideNoviceViewModel nBPGuideNoviceViewModel2;
                        e eVar3 = eVar2;
                        if (eVar3 != null && (p16 = eVar3.p("nick")) != null && (nBPGuideNoviceViewModel2 = NBPGuideNoviceHomePage.this.viewModel) != null) {
                            nBPGuideNoviceViewModel2.nick$delegate.setValue(nBPGuideNoviceViewModel2, NBPGuideNoviceViewModel.$$delegatedProperties[3], p16);
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr22 = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 1, function02);
    }

    public final void customDtReportPageExposure(String str, boolean z16) {
        String str2;
        if (z16) {
            str2 = "dt_pgin";
        } else {
            str2 = "dt_pgout";
        }
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str2, AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("dt_pgid", str, DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU"));
    }
}
