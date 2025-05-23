package com.tencent.hippykotlin.demo.pages.nearby.publish.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.module.b;
import com.tencent.kuikly.core.module.r;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ActionSheetAttr;
import com.tencent.kuikly.core.views.ActionSheetView;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.TransitionType;
import com.tencent.kuikly.core.views.TransitionView;
import com.tencent.kuikly.core.views.TransitionViewKt;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ci;
import com.tencent.kuikly.core.views.d;
import com.tencent.kuikly.core.views.e;
import com.tencent.kuikly.core.views.n;
import com.tencent.kuikly.core.views.o;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import o25.f;

/* loaded from: classes31.dex */
public final class NBPPublishMapSelectionView extends ComposeView<NBPPublishMapSelectionAttr, NBPPublishMapSelectionEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishMapSelectionView.class, "activated", "getActivated()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishMapSelectionView.class, "showThemeSelectionView", "getShowThemeSelectionView()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishMapSelectionView.class, "showImg2txtSelectionView", "getShowImg2txtSelectionView()Z", 0)};
    public final ReadWriteProperty activated$delegate;
    public final ReadWriteProperty showImg2txtSelectionView$delegate;
    public final ReadWriteProperty showThemeSelectionView$delegate;

    public NBPPublishMapSelectionView() {
        Boolean bool = Boolean.FALSE;
        this.activated$delegate = c.a(bool);
        this.showThemeSelectionView$delegate = c.a(bool);
        this.showImg2txtSelectionView$delegate = c.a(bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPPublishMapSelectionAttr access$getAttr(NBPPublishMapSelectionView nBPPublishMapSelectionView) {
        return (NBPPublishMapSelectionAttr) nBPPublishMapSelectionView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String access$getMapSelectThemeIcon(NBPPublishMapSelectionView nBPPublishMapSelectionView) {
        Object firstOrNull;
        String str;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) ((NBPPublishMapSelectionAttr) nBPPublishMapSelectionView.getAttr()).getViewModel().getSelectThemeList());
        f fVar = (f) firstOrNull;
        return (fVar == null || (str = fVar.C) == null) ? "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_tb-ce7mP53r.png" : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String access$getMapSelectThemeLabel(NBPPublishMapSelectionView nBPPublishMapSelectionView) {
        Object firstOrNull;
        String str;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) ((NBPPublishMapSelectionAttr) nBPPublishMapSelectionView.getAttr()).getViewModel().getSelectThemeList());
        f fVar = (f) firstOrNull;
        return (fVar == null || (str = fVar.f421850e) == null) ? "\u9009\u62e9\u5730\u56fe" : str;
    }

    public static final h access$getMapSelectThemePrimaryColor(NBPPublishMapSelectionView nBPPublishMapSelectionView) {
        if (nBPPublishMapSelectionView.isPhotoMode()) {
            return h.INSTANCE.m();
        }
        return new h(4281169893L);
    }

    public static final h access$getMapSelectThemeSecondaryColor(NBPPublishMapSelectionView nBPPublishMapSelectionView) {
        if (nBPPublishMapSelectionView.isPhotoMode()) {
            return new h(16777215L, 0.55f);
        }
        return new h(4287664276L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$selectMapTheme(NBPPublishMapSelectionView nBPPublishMapSelectionView, f fVar) {
        Function1<? super f, Unit> function1 = ((NBPPublishMapSelectionEvent) nBPPublishMapSelectionView.getViewEvent()).selectMapEventHandler;
        if (function1 != null) {
            function1.invoke(fVar);
        }
        if (fVar != null) {
            b bVar = (b) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRCalendarModule");
            String a16 = bVar.a(b.c(bVar, 0L, 1, null).a(), TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
            r rVar = (r) nBPPublishMapSelectionView.acquireModule("KRSharedPreferencesModule");
            if (Intrinsics.areEqual(rVar.getItem("NBPPublishMapSelectionView_selectTipsKey"), a16)) {
                return;
            }
            rVar.setItem("NBPPublishMapSelectionView_selectTipsKey", a16);
            QQNearbyModule.Companion.getInstance().getClass();
            Utils.INSTANCE.bridgeModule(BridgeManager.f117344a.u()).qToast("\u9009\u62e9\u4e3b\u9898\uff0c\u52a8\u6001\u5c06\u4f1a\u589e\u52a0\u66dd\u5149", QToastMode.Info);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.size(mVar2.getPagerData().m() - 64.0f, 24.0f);
                        mVar2.marginLeft(12.0f);
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishMapSelectionView nBPPublishMapSelectionView = NBPPublishMapSelectionView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        ((NBPPublishMapSelectionAttr) NBPPublishMapSelectionView.this.getAttr()).getViewModel().getClass();
                        return Boolean.FALSE;
                    }
                };
                final NBPPublishMapSelectionView nBPPublishMapSelectionView2 = NBPPublishMapSelectionView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPPublishMapSelectionView nBPPublishMapSelectionView3 = NBPPublishMapSelectionView.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView4 = NBPPublishMapSelectionView.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(24.0f);
                                        NBPPublishMapSelectionView nBPPublishMapSelectionView5 = NBPPublishMapSelectionView.this;
                                        KProperty<Object>[] kPropertyArr = NBPPublishMapSelectionView.$$delegatedProperties;
                                        if (nBPPublishMapSelectionView5.isPhotoMode()) {
                                            new h(16777215L, 0.1f);
                                        } else {
                                            tVar2.mo113backgroundColor(new h(167793150L));
                                        }
                                        tVar2.borderRadius(8.0f);
                                        tVar2.alignItemsCenter();
                                        tVar2.flexDirectionRow();
                                        tVar2.marginRight(4.0f);
                                        tVar2.paddingLeft(8.0f);
                                        tVar2.paddingRight(8.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView5 = NBPPublishMapSelectionView.this;
                                ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NBPPublishMapSelectionView nBPPublishMapSelectionView6 = NBPPublishMapSelectionView.this;
                                        KProperty<Object>[] kPropertyArr = NBPPublishMapSelectionView.$$delegatedProperties;
                                        return Boolean.valueOf(nBPPublishMapSelectionView6.isPhotoMode());
                                    }
                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView2) {
                                        o.a(conditionView2, new Function1<n, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(n nVar) {
                                                nVar.attr(new Function1<com.tencent.kuikly.core.views.m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.3.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(com.tencent.kuikly.core.views.m mVar) {
                                                        mVar.absolutePositionAllZero();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView6 = NBPPublishMapSelectionView.this;
                                ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(NBPPublishMapSelectionView.access$getAttr(NBPPublishMapSelectionView.this).getViewModel().isRequestImg2txt());
                                    }
                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView2) {
                                        TransitionViewKt.a(conditionView2, TransitionType.CUSTOM, new Function1<TransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TransitionView transitionView) {
                                                TransitionView transitionView2 = transitionView;
                                                transitionView2.attr(new Function1<ci, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.5.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ci ciVar) {
                                                        ci ciVar2 = ciVar;
                                                        ciVar2.i(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.5.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Attr attr) {
                                                                attr.transform(new com.tencent.kuikly.core.base.t(0.0f, 0.0f, 0.0f, 6, null));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ciVar2.j(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.5.1.1.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Attr attr) {
                                                                attr.transform(new com.tencent.kuikly.core.base.t(360.0f, 0.0f, 0.0f, 6, null));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ciVar2.h(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.5f, null, 2, null).i(true));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(transitionView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.5.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.5.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_t67dmQ1UM82.png", false, 2, null);
                                                                afVar2.t(h.INSTANCE.m());
                                                                afVar2.size(14.0f, 14.0f);
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
                                ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView2) {
                                        ah.a(conditionView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.6.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.6.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ZSnKv45Z3m2.png", false, 2, null);
                                                        afVar2.t(h.INSTANCE.m());
                                                        afVar2.size(14.0f, 14.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView7 = NBPPublishMapSelectionView.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.7
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NBPPublishMapSelectionView.access$getMapSelectThemePrimaryColor(NBPPublishMapSelectionView.this);
                                    }
                                };
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView8 = NBPPublishMapSelectionView.this;
                                BindDirectivesViewKt.a(vVar2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.8
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView9 = NBPPublishMapSelectionView.this;
                                        cg.a(bindDirectivesView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.8.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView10 = NBPPublishMapSelectionView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.8.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u667a\u80fd\u6587\u6848");
                                                        ceVar2.color(NBPPublishMapSelectionView.access$getMapSelectThemePrimaryColor(NBPPublishMapSelectionView.this));
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.marginLeft(2.0f);
                                                        ceVar2.fontWeightMedium();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView9 = NBPPublishMapSelectionView.this;
                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.9
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NBPPublishMapSelectionView nBPPublishMapSelectionView10 = NBPPublishMapSelectionView.this;
                                        return Boolean.valueOf(((Boolean) nBPPublishMapSelectionView10.showImg2txtSelectionView$delegate.getValue(nBPPublishMapSelectionView10, NBPPublishMapSelectionView.$$delegatedProperties[2])).booleanValue());
                                    }
                                };
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView10 = NBPPublishMapSelectionView.this;
                                ConditionViewKt.c(vVar2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.10
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView2) {
                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView11 = NBPPublishMapSelectionView.this;
                                        e.a(conditionView2, new Function1<ActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.10.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ActionSheetView actionSheetView) {
                                                ActionSheetView actionSheetView2 = actionSheetView;
                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView12 = NBPPublishMapSelectionView.this;
                                                actionSheetView2.attr(new Function1<ActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.10.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ActionSheetAttr actionSheetAttr) {
                                                        ActionSheetAttr actionSheetAttr2 = actionSheetAttr;
                                                        NBPPublishMapSelectionView nBPPublishMapSelectionView13 = NBPPublishMapSelectionView.this;
                                                        actionSheetAttr2.w(((Boolean) nBPPublishMapSelectionView13.showImg2txtSelectionView$delegate.getValue(nBPPublishMapSelectionView13, NBPPublishMapSelectionView.$$delegatedProperties[2])).booleanValue());
                                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView14 = NBPPublishMapSelectionView.this;
                                                        nBPPublishMapSelectionView14.getClass();
                                                        actionSheetAttr2.j(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$img2txtSelectionView$1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                                ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                                viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$img2txtSelectionView$1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(m mVar) {
                                                                        mVar.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView15 = NBPPublishMapSelectionView.this;
                                                                viewContainer4.addChild(new NBPPublishImg2txtSelectionView(), new Function1<NBPPublishImg2txtSelectionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$img2txtSelectionView$1.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView) {
                                                                        NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView2 = nBPPublishImg2txtSelectionView;
                                                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView16 = NBPPublishMapSelectionView.this;
                                                                        nBPPublishImg2txtSelectionView2.attr(new Function1<NBPPublishImg2txtSelectionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.img2txtSelectionView.1.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(NBPPublishImg2txtSelectionAttr nBPPublishImg2txtSelectionAttr) {
                                                                                nBPPublishImg2txtSelectionAttr.viewModel = NBPPublishMapSelectionView.access$getAttr(NBPPublishMapSelectionView.this).getViewModel();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView17 = NBPPublishMapSelectionView.this;
                                                                        nBPPublishImg2txtSelectionView2.event(new Function1<NBPPublishImg2txtSelectionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.img2txtSelectionView.1.2.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(NBPPublishImg2txtSelectionEvent nBPPublishImg2txtSelectionEvent) {
                                                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView18 = NBPPublishMapSelectionView.this;
                                                                                nBPPublishImg2txtSelectionEvent.eventHandler = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.img2txtSelectionView.1.2.2.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(String str) {
                                                                                        NBPPublishMapSelectionView.access$getAttr(NBPPublishMapSelectionView.this).getViewModel().appendContent(str);
                                                                                        r2.showImg2txtSelectionView$delegate.setValue(NBPPublishMapSelectionView.this, NBPPublishMapSelectionView.$$delegatedProperties[2], Boolean.valueOf(false));
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
                                                        actionSheetAttr2.mo113backgroundColor(h.INSTANCE.j());
                                                        actionSheetAttr2.i(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.10.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.10.1.1.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar3) {
                                                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.10.1.1.1.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                tVar.mo113backgroundColor(h.INSTANCE.j());
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
                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView13 = NBPPublishMapSelectionView.this;
                                                actionSheetView2.event(new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.10.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(d dVar) {
                                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView14 = NBPPublishMapSelectionView.this;
                                                        dVar.j(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.10.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                r2.showImg2txtSelectionView$delegate.setValue(NBPPublishMapSelectionView.this, NBPPublishMapSelectionView.$$delegatedProperties[2], Boolean.valueOf(false));
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
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView11 = NBPPublishMapSelectionView.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.11
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView12 = NBPPublishMapSelectionView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.3.1.11.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                ClickParams clickParams2 = clickParams;
                                                r0.showImg2txtSelectionView$delegate.setValue(NBPPublishMapSelectionView.this, NBPPublishMapSelectionView.$$delegatedProperties[2], Boolean.valueOf(true));
                                                Function1<Object, Unit> function1 = ((NBPPublishMapSelectionEvent) NBPPublishMapSelectionView.this.getViewEvent()).showImg2txtActionSheetEventHandler;
                                                if (function1 != null) {
                                                    function1.invoke(clickParams2);
                                                }
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
                final NBPPublishMapSelectionView nBPPublishMapSelectionView3 = NBPPublishMapSelectionView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPPublishMapSelectionView nBPPublishMapSelectionView4 = NBPPublishMapSelectionView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(24.0f);
                                NBPPublishMapSelectionView nBPPublishMapSelectionView5 = NBPPublishMapSelectionView.this;
                                KProperty<Object>[] kPropertyArr = NBPPublishMapSelectionView.$$delegatedProperties;
                                if (nBPPublishMapSelectionView5.isPhotoMode()) {
                                    new h(16777215L, 0.1f);
                                } else {
                                    tVar2.mo113backgroundColor(new h(167793150L));
                                }
                                tVar2.borderRadius(8.0f);
                                tVar2.alignItemsCenter();
                                tVar2.flexDirectionRow();
                                tVar2.paddingLeft(8.0f);
                                tVar2.paddingRight(8.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPublishMapSelectionView nBPPublishMapSelectionView5 = NBPPublishMapSelectionView.this;
                        ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPPublishMapSelectionView nBPPublishMapSelectionView6 = NBPPublishMapSelectionView.this;
                                KProperty<Object>[] kPropertyArr = NBPPublishMapSelectionView.$$delegatedProperties;
                                return Boolean.valueOf(nBPPublishMapSelectionView6.isPhotoMode());
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                o.a(conditionView, new Function1<n, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(n nVar) {
                                        nVar.attr(new Function1<com.tencent.kuikly.core.views.m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.3.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.m mVar) {
                                                mVar.absolutePositionAllZero();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPublishMapSelectionView nBPPublishMapSelectionView6 = NBPPublishMapSelectionView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NBPPublishMapSelectionView.access$getMapSelectThemePrimaryColor(NBPPublishMapSelectionView.this);
                            }
                        };
                        final NBPPublishMapSelectionView nBPPublishMapSelectionView7 = NBPPublishMapSelectionView.this;
                        BindDirectivesViewKt.a(vVar2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView8 = NBPPublishMapSelectionView.this;
                                ah.a(bindDirectivesView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView9 = NBPPublishMapSelectionView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.5.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                b.a.b(afVar2, NBPPublishMapSelectionView.access$getMapSelectThemeIcon(NBPPublishMapSelectionView.this), false, 2, null);
                                                afVar2.size(14.0f, 14.0f);
                                                afVar2.t(NBPPublishMapSelectionView.access$getMapSelectThemePrimaryColor(NBPPublishMapSelectionView.this));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView9 = NBPPublishMapSelectionView.this;
                                cg.a(bindDirectivesView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.5.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView10 = NBPPublishMapSelectionView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.5.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text(NBPPublishMapSelectionView.access$getMapSelectThemeLabel(NBPPublishMapSelectionView.this));
                                                ceVar2.color(NBPPublishMapSelectionView.access$getMapSelectThemePrimaryColor(NBPPublishMapSelectionView.this));
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.marginLeft(2.0f);
                                                ceVar2.fontWeightMedium();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView10 = NBPPublishMapSelectionView.this;
                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.5.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NBPPublishMapSelectionView.access$getAttr(NBPPublishMapSelectionView.this).getViewModel().getClass();
                                        return Boolean.TRUE;
                                    }
                                };
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView11 = NBPPublishMapSelectionView.this;
                                ConditionViewKt.c(bindDirectivesView2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.5.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView12 = NBPPublishMapSelectionView.this;
                                        ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.5.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView13 = NBPPublishMapSelectionView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.5.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_p7mZ5IdEDXQ.png", false, 2, null);
                                                        afVar2.size(10.0f, 10.0f);
                                                        afVar2.marginLeft(2.0f);
                                                        afVar2.t(NBPPublishMapSelectionView.access$getMapSelectThemePrimaryColor(NBPPublishMapSelectionView.this));
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
                        final NBPPublishMapSelectionView nBPPublishMapSelectionView8 = NBPPublishMapSelectionView.this;
                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.6
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPPublishMapSelectionView nBPPublishMapSelectionView9 = NBPPublishMapSelectionView.this;
                                return Boolean.valueOf(((Boolean) nBPPublishMapSelectionView9.showThemeSelectionView$delegate.getValue(nBPPublishMapSelectionView9, NBPPublishMapSelectionView.$$delegatedProperties[1])).booleanValue());
                            }
                        };
                        final NBPPublishMapSelectionView nBPPublishMapSelectionView9 = NBPPublishMapSelectionView.this;
                        ConditionViewKt.c(vVar2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.7
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView10 = NBPPublishMapSelectionView.this;
                                e.a(conditionView, new Function1<ActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.7.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ActionSheetView actionSheetView) {
                                        ActionSheetView actionSheetView2 = actionSheetView;
                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView11 = NBPPublishMapSelectionView.this;
                                        actionSheetView2.attr(new Function1<ActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.7.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ActionSheetAttr actionSheetAttr) {
                                                ActionSheetAttr actionSheetAttr2 = actionSheetAttr;
                                                NBPPublishMapSelectionView nBPPublishMapSelectionView12 = NBPPublishMapSelectionView.this;
                                                actionSheetAttr2.w(((Boolean) nBPPublishMapSelectionView12.showThemeSelectionView$delegate.getValue(nBPPublishMapSelectionView12, NBPPublishMapSelectionView.$$delegatedProperties[1])).booleanValue());
                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView13 = NBPPublishMapSelectionView.this;
                                                nBPPublishMapSelectionView13.getClass();
                                                actionSheetAttr2.j(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$themeSelectionView$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                        ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                        viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$themeSelectionView$1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(m mVar) {
                                                                mVar.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView14 = NBPPublishMapSelectionView.this;
                                                        viewContainer4.addChild(new NBPPublishThemeSelectionView(), new Function1<NBPPublishThemeSelectionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$themeSelectionView$1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NBPPublishThemeSelectionView nBPPublishThemeSelectionView) {
                                                                NBPPublishThemeSelectionView nBPPublishThemeSelectionView2 = nBPPublishThemeSelectionView;
                                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView15 = NBPPublishMapSelectionView.this;
                                                                nBPPublishThemeSelectionView2.attr(new Function1<NBPPublishThemeSelectionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.themeSelectionView.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(NBPPublishThemeSelectionAttr nBPPublishThemeSelectionAttr) {
                                                                        nBPPublishThemeSelectionAttr.viewModel = NBPPublishMapSelectionView.access$getAttr(NBPPublishMapSelectionView.this).getViewModel();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView16 = NBPPublishMapSelectionView.this;
                                                                nBPPublishThemeSelectionView2.event(new Function1<NBPPublishThemeSelectionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.themeSelectionView.1.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(NBPPublishThemeSelectionEvent nBPPublishThemeSelectionEvent) {
                                                                        NBPPublishThemeSelectionEvent nBPPublishThemeSelectionEvent2 = nBPPublishThemeSelectionEvent;
                                                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView17 = NBPPublishMapSelectionView.this;
                                                                        nBPPublishThemeSelectionEvent2.eventHandler = new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.themeSelectionView.1.2.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(f fVar) {
                                                                                String str;
                                                                                f fVar2 = fVar;
                                                                                NBPPublishMapSelectionView.access$selectMapTheme(NBPPublishMapSelectionView.this, fVar2);
                                                                                r0.showThemeSelectionView$delegate.setValue(NBPPublishMapSelectionView.this, NBPPublishMapSelectionView.$$delegatedProperties[1], Boolean.valueOf(false));
                                                                                com.tencent.kuikly.core.nvi.serialization.json.e jsonWithPublishPgParams = NearbyConstKt.jsonWithPublishPgParams();
                                                                                jsonWithPublishPgParams.v("dt_eid", "em_nearby_thematic_map_float");
                                                                                if (fVar2 == null || (str = fVar2.f421849d) == null) {
                                                                                    str = "";
                                                                                }
                                                                                jsonWithPublishPgParams.v("nearby_map_id", str);
                                                                                jsonWithPublishPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPublishPgParams);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        VisibilityEventKt.b(nBPPublishThemeSelectionEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.themeSelectionView.1.2.2.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Object obj) {
                                                                                com.tencent.kuikly.core.nvi.serialization.json.e jsonWithPublishPgParams = NearbyConstKt.jsonWithPublishPgParams();
                                                                                jsonWithPublishPgParams.v("dt_eid", "em_nearby_thematic_map_float");
                                                                                jsonWithPublishPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithPublishPgParams);
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
                                                actionSheetAttr2.mo113backgroundColor(h.INSTANCE.j());
                                                actionSheetAttr2.i(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.7.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.7.1.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar3) {
                                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.7.1.1.1.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        tVar.mo113backgroundColor(h.INSTANCE.j());
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
                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView12 = NBPPublishMapSelectionView.this;
                                        actionSheetView2.event(new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.7.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(d dVar) {
                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView13 = NBPPublishMapSelectionView.this;
                                                dVar.j(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.7.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        r2.showThemeSelectionView$delegate.setValue(NBPPublishMapSelectionView.this, NBPPublishMapSelectionView.$$delegatedProperties[1], Boolean.valueOf(false));
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
                        final NBPPublishMapSelectionView nBPPublishMapSelectionView10 = NBPPublishMapSelectionView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.8
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView11 = NBPPublishMapSelectionView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.4.8.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ClickParams clickParams2 = clickParams;
                                        r0.showThemeSelectionView$delegate.setValue(NBPPublishMapSelectionView.this, NBPPublishMapSelectionView.$$delegatedProperties[1], Boolean.valueOf(true));
                                        Function1<Object, Unit> function1 = ((NBPPublishMapSelectionEvent) NBPPublishMapSelectionView.this.getViewEvent()).showMapActionSheetEventHandler;
                                        if (function1 != null) {
                                            function1.invoke(clickParams2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishMapSelectionView nBPPublishMapSelectionView4 = NBPPublishMapSelectionView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean booleanValue;
                        boolean z16;
                        booleanValue = ((Boolean) r0.activated$delegate.getValue(NBPPublishMapSelectionView.this, NBPPublishMapSelectionView.$$delegatedProperties[0])).booleanValue();
                        if ((booleanValue || NBPPublishMapSelectionView.access$getAttr(NBPPublishMapSelectionView.this).getViewModel().hasPublishInfo()) && NBPPublishMapSelectionView.access$getAttr(NBPPublishMapSelectionView.this).getViewModel().getSelectThemeList().size() == 0) {
                            ((NBPPublishMapSelectionAttr) NBPPublishMapSelectionView.this.getAttr()).getViewModel().getClass();
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPPublishMapSelectionView nBPPublishMapSelectionView5 = NBPPublishMapSelectionView.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        boolean booleanValue;
                        ConditionView conditionView2 = conditionView;
                        booleanValue = ((Boolean) r0.activated$delegate.getValue(NBPPublishMapSelectionView.this, NBPPublishMapSelectionView.$$delegatedProperties[0])).booleanValue();
                        if (!booleanValue) {
                            final NBPPublishMapSelectionView nBPPublishMapSelectionView6 = NBPPublishMapSelectionView.this;
                            Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    NBPPublishMapSelectionView nBPPublishMapSelectionView7 = NBPPublishMapSelectionView.this;
                                    nBPPublishMapSelectionView7.activated$delegate.setValue(nBPPublishMapSelectionView7, NBPPublishMapSelectionView.$$delegatedProperties[0], Boolean.TRUE);
                                    return Unit.INSTANCE;
                                }
                            };
                            KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                            TimerKt.e(conditionView2.getPagerId(), 5, function03);
                            com.tencent.kuikly.core.nvi.serialization.json.e jsonWithPublishPgParams = NearbyConstKt.jsonWithPublishPgParams();
                            jsonWithPublishPgParams.v("dt_eid", "em_nearby_thematic_map_tag");
                            jsonWithPublishPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithPublishPgParams);
                        }
                        final NBPPublishMapSelectionView nBPPublishMapSelectionView7 = NBPPublishMapSelectionView.this;
                        ar.a(conditionView2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView8 = NBPPublishMapSelectionView.this;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        boolean booleanValue2;
                                        boolean booleanValue3;
                                        ao aoVar2 = aoVar;
                                        aoVar2.marginLeft(6.0f);
                                        aoVar2.marginRight(16.0f);
                                        aoVar2.m140flex(1.0f);
                                        aoVar2.mo141height(24.0f);
                                        aoVar2.flexDirectionRow();
                                        aoVar2.showScrollerIndicator(false);
                                        booleanValue2 = ((Boolean) r1.activated$delegate.getValue(NBPPublishMapSelectionView.this, NBPPublishMapSelectionView.$$delegatedProperties[0])).booleanValue();
                                        if (booleanValue2) {
                                            aoVar2.m147opacity(1.0f);
                                        } else {
                                            aoVar2.m147opacity(0.0f);
                                        }
                                        com.tencent.kuikly.core.base.b l3 = b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.5f, null, 2, null);
                                        booleanValue3 = ((Boolean) r1.activated$delegate.getValue(NBPPublishMapSelectionView.this, NBPPublishMapSelectionView.$$delegatedProperties[0])).booleanValue();
                                        aoVar2.animate(l3, Boolean.valueOf(booleanValue3));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView9 = NBPPublishMapSelectionView.this;
                                Function0<com.tencent.kuikly.core.reactive.collection.c<f>> function04 = new Function0<com.tencent.kuikly.core.reactive.collection.c<f>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.3.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final com.tencent.kuikly.core.reactive.collection.c<f> invoke() {
                                        return NBPPublishMapSelectionView.access$getAttr(NBPPublishMapSelectionView.this).getViewModel().getThemeList();
                                    }
                                };
                                final NBPPublishMapSelectionView nBPPublishMapSelectionView10 = NBPPublishMapSelectionView.this;
                                LoopDirectivesViewKt.b(aqVar2, function04, new Function4<LoopDirectivesView<f>, f, Integer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.3.3
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public final Unit invoke(LoopDirectivesView<f> loopDirectivesView, f fVar, Integer num, Integer num2) {
                                        final f fVar2 = fVar;
                                        num.intValue();
                                        num2.intValue();
                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView11 = NBPPublishMapSelectionView.this;
                                        w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.3.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView12 = NBPPublishMapSelectionView.this;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.3.3.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        h hVar;
                                                        t tVar2 = tVar;
                                                        tVar2.allCenter();
                                                        tVar2.paddingLeft(8.0f);
                                                        tVar2.paddingRight(8.0f);
                                                        tVar2.marginRight(4.0f);
                                                        tVar2.flexDirectionRow();
                                                        tVar2.borderRadius(4.0f);
                                                        BorderStyle borderStyle = BorderStyle.SOLID;
                                                        NBPPublishMapSelectionView nBPPublishMapSelectionView13 = NBPPublishMapSelectionView.this;
                                                        KProperty<Object>[] kPropertyArr2 = NBPPublishMapSelectionView.$$delegatedProperties;
                                                        if (nBPPublishMapSelectionView13.isPhotoMode()) {
                                                            hVar = new h(16777215L, 0.2f);
                                                        } else {
                                                            hVar = new h(0L, 0.1f);
                                                        }
                                                        tVar2.m136border(new com.tencent.kuikly.core.base.e(0.5f, borderStyle, hVar));
                                                        tVar2.mo113backgroundColor(h.INSTANCE.j());
                                                        tVar2.mo141height(24.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final f fVar3 = fVar2;
                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView13 = NBPPublishMapSelectionView.this;
                                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.3.3.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final f fVar4 = f.this;
                                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView14 = nBPPublishMapSelectionView13;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.3.3.1.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(14.0f, 14.0f);
                                                                afVar2.marginRight(2.0f);
                                                                b.a.b(afVar2, f.this.C, false, 2, null);
                                                                afVar2.t(NBPPublishMapSelectionView.access$getMapSelectThemeSecondaryColor(nBPPublishMapSelectionView14));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView14 = NBPPublishMapSelectionView.this;
                                                final f fVar4 = fVar2;
                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.3.3.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView15 = NBPPublishMapSelectionView.this;
                                                        final f fVar5 = fVar4;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.3.3.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                ceVar2.color(NBPPublishMapSelectionView.access$getMapSelectThemeSecondaryColor(NBPPublishMapSelectionView.this));
                                                                ceVar2.text(fVar5.f421850e);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishMapSelectionView nBPPublishMapSelectionView15 = NBPPublishMapSelectionView.this;
                                                final f fVar5 = fVar2;
                                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.3.3.1.4
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPPublishMapSelectionView nBPPublishMapSelectionView16 = NBPPublishMapSelectionView.this;
                                                        final f fVar6 = fVar5;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishMapSelectionView.body.1.6.3.3.1.4.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPPublishMapSelectionView.access$selectMapTheme(NBPPublishMapSelectionView.this, fVar6);
                                                                com.tencent.kuikly.core.nvi.serialization.json.e jsonWithPublishPgParams2 = NearbyConstKt.jsonWithPublishPgParams();
                                                                f fVar7 = fVar6;
                                                                jsonWithPublishPgParams2.v("dt_eid", "em_nearby_thematic_map_tag");
                                                                jsonWithPublishPgParams2.v("nearby_map_id", fVar7.f421849d);
                                                                jsonWithPublishPgParams2.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPublishPgParams2);
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPPublishMapSelectionAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPPublishMapSelectionEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isPhotoMode() {
        return ((NBPPublishMapSelectionAttr) getAttr()).getViewModel().getPhotoPath().length() > 0;
    }
}
