package com.tencent.hippykotlin.demo.pages.nearby.publish.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ActionSheetAttr;
import com.tencent.kuikly.core.views.ActionSheetView;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.KeyboardParams;
import com.tencent.kuikly.core.views.TextAreaEvent;
import com.tencent.kuikly.core.views.TextAreaView;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ak;
import com.tencent.kuikly.core.views.al;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.cc;
import com.tencent.kuikly.core.views.cd;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt___StringsKt;
import o25.f;

/* loaded from: classes31.dex */
public final class NBPPublishContentView extends ComposeView<NBPPublishContentAttr, NBPPublishContentEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishContentView.class, "showTakePhotoActionSheet", "getShowTakePhotoActionSheet()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishContentView.class, "showModifyPhotoActionSheet", "getShowModifyPhotoActionSheet()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishContentView.class, "textAreaHeight", "getTextAreaHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishContentView.class, "keyboardHeight", "getKeyboardHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishContentView.class, "textContentHeight", "getTextContentHeight()F", 0)};
    public final ReadWriteProperty keyboardHeight$delegate;
    public String notifyCallbackRef;
    public final ReadWriteProperty showModifyPhotoActionSheet$delegate;
    public final ReadWriteProperty showTakePhotoActionSheet$delegate;
    public final ReadWriteProperty textAreaHeight$delegate;
    public aa<TextAreaView> textAreaRef;
    public final ReadWriteProperty textContentHeight$delegate;

    public NBPPublishContentView() {
        Boolean bool = Boolean.FALSE;
        this.showTakePhotoActionSheet$delegate = c.a(bool);
        this.showModifyPhotoActionSheet$delegate = c.a(bool);
        this.notifyCallbackRef = "";
        this.textAreaHeight$delegate = c.a(Float.valueOf(24.0f));
        Float valueOf = Float.valueOf(0.0f);
        this.keyboardHeight$delegate = c.a(valueOf);
        this.textContentHeight$delegate = c.a(valueOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPPublishContentAttr access$getAttr(NBPPublishContentView nBPPublishContentView) {
        return (NBPPublishContentAttr) nBPPublishContentView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final al access$getSpans(NBPPublishContentView nBPPublishContentView) {
        nBPPublishContentView.getClass();
        al alVar = new al();
        ak akVar = new ak();
        akVar.e(((NBPPublishContentAttr) nBPPublishContentView.getAttr()).getViewModel().getContent());
        akVar.d(24.0f);
        akVar.b(Float.valueOf(18.0f));
        akVar.c();
        if (((NBPPublishContentAttr) nBPPublishContentView.getAttr()).getViewModel().getPhotoPath().length() > 0) {
            akVar.a(h.INSTANCE.m());
        } else {
            akVar.a(new h(4279901214L));
        }
        return alVar.a(akVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$handleInputContent(NBPPublishContentView nBPPublishContentView, String str) {
        NBPPublishViewModel viewModel = ((NBPPublishContentAttr) nBPPublishContentView.getAttr()).getViewModel();
        viewModel.content$delegate.setValue(viewModel, NBPPublishViewModel.$$delegatedProperties[9], str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$isImg2txtListVisible(NBPPublishContentView nBPPublishContentView) {
        return ((NBPPublishContentAttr) nBPPublishContentView.getAttr()).getViewModel().getImg2txtContentList().size() > 0;
    }

    public static final void access$reportPicChangePop(NBPPublishContentView nBPPublishContentView, int i3) {
        nBPPublishContentView.getClass();
        e jsonWithPublishPgParams = NearbyConstKt.jsonWithPublishPgParams();
        jsonWithPublishPgParams.v("dt_eid", "em_nearby_pic_change_pop");
        jsonWithPublishPgParams.t("nearby_btn_type", i3);
        jsonWithPublishPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPublishPgParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$selectImg2txt(NBPPublishContentView nBPPublishContentView, String str) {
        TextAreaView b16;
        ((NBPPublishContentAttr) nBPPublishContentView.getAttr()).getViewModel().appendContent(str);
        aa<TextAreaView> aaVar = nBPPublishContentView.textAreaRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        b16.l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final float access$topOffset(NBPPublishContentView nBPPublishContentView) {
        float floatValue = (((Number) nBPPublishContentView.keyboardHeight$delegate.getValue(nBPPublishContentView, $$delegatedProperties[3])).floatValue() + (((NBPPublishContentAttr) nBPPublishContentView.getAttr()).getViewModel().getContentHeight() + ((nBPPublishContentView.getPagerData().getStatusBarHeight() + 44.0f) + 8.0f))) - nBPPublishContentView.getPager().getPageData().l();
        if (floatValue > 0.0f) {
            return -floatValue;
        }
        return 0.0f;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPPublishContentView nBPPublishContentView = NBPPublishContentView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(NearbyProUtilsKt.getPageViewWidthOptimized(mVar2.getPager().getPageData()) - 64.0f, NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel().getContentHeight());
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        mVar2.m150top(NBPPublishContentView.access$topOffset(NBPPublishContentView.this));
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishContentView nBPPublishContentView2 = NBPPublishContentView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPPublishContentView nBPPublishContentView3 = NBPPublishContentView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(NearbyProUtilsKt.getPageViewWidthOptimized(tVar2.getPager().getPageData()) - 64.0f, NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel().getContentHeight() - 40.0f);
                                tVar2.allCenter();
                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                tVar2.borderRadius(20.0f);
                                tVar2.flexDirectionColumn();
                                tVar2.mo139boxShadow(new g(0.0f, 4.0f, 16.0f, new h(0L, 0.08f)));
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPublishContentView nBPPublishContentView4 = NBPPublishContentView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.absolutePosition(2.0f, 2.0f, 2.0f, 2.0f);
                                        tVar2.borderRadius(16.0f);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishContentView nBPPublishContentView5 = NBPPublishContentView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.allCenter();
                                                float pageViewWidthOptimized = ((NearbyProUtilsKt.getPageViewWidthOptimized(tVar2.getPager().getPageData()) - 64.0f) - 32.0f) - 80.0f;
                                                tVar2.size(pageViewWidthOptimized, pageViewWidthOptimized);
                                                tVar2.marginTop(50.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_d8rLzQCS1-2.png", false, 2, null);
                                                        afVar2.size(128.0f, 128.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPublishContentView nBPPublishContentView6 = NBPPublishContentView.this;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPPublishContentView nBPPublishContentView7 = NBPPublishContentView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPPublishContentView.this.hideKeyboard();
                                                        r3.showTakePhotoActionSheet$delegate.setValue(NBPPublishContentView.this, NBPPublishContentView.$$delegatedProperties[0], Boolean.valueOf(true));
                                                        KLog.INSTANCE.i("NBPPublishContentView", "Nbp showTakePhotoActionSheet: showActionSheet");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishContentView nBPPublishContentView6 = NBPPublishContentView.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel().getPhotoPath().length() > 0);
                                    }
                                };
                                final NBPPublishContentView nBPPublishContentView7 = NBPPublishContentView.this;
                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NBPPublishContentView nBPPublishContentView8 = NBPPublishContentView.this;
                                        ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                ImageView imageView2 = imageView;
                                                final NBPPublishContentView nBPPublishContentView9 = NBPPublishContentView.this;
                                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        b.a.a(afVar2, com.tencent.kuikly.core.base.attr.e.INSTANCE.a(NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel().getPhotoPath()), false, 2, null);
                                                        afVar2.p();
                                                        afVar2.absolutePositionAllZero();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishContentView nBPPublishContentView10 = NBPPublishContentView.this;
                                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.4.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageEvent imageEvent) {
                                                        final NBPPublishContentView nBPPublishContentView11 = NBPPublishContentView.this;
                                                        imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.4.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPPublishContentView.this.hideKeyboard();
                                                                r3.showModifyPhotoActionSheet$delegate.setValue(NBPPublishContentView.this, NBPPublishContentView.$$delegatedProperties[1], Boolean.valueOf(true));
                                                                KLog.INSTANCE.i("NBPPublishContentView", "Nbp showModifyPhotoActionSheet: showActionSheet");
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
                                final NBPPublishContentView nBPPublishContentView8 = NBPPublishContentView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final NBPPublishContentView nBPPublishContentView9 = NBPPublishContentView.this;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionColumn();
                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                                tVar2.mo141height(132.0f);
                                                if (NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel().getPhotoPath().length() > 0) {
                                                    tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(0L, 0.0f), 0.0f), new j(new h(0L, 0.6f), 1.0f));
                                                } else {
                                                    tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(0L, 0.0f), 0.0f), new j(new h(0L, 0.0f), 1.0f));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPublishContentView nBPPublishContentView10 = NBPPublishContentView.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                final NBPPublishContentView nBPPublishContentView11 = NBPPublishContentView.this;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionColumn();
                                                        tVar2.justifyContentFlexEnd();
                                                        if (NBPPublishContentView.access$isImg2txtListVisible(NBPPublishContentView.this)) {
                                                            tVar2.mo141height(52.0f);
                                                        } else {
                                                            tVar2.mo141height(84.0f);
                                                        }
                                                        tVar2.alignSelfStretch();
                                                        tVar2.marginLeft(12.0f);
                                                        tVar2.marginRight(12.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishContentView nBPPublishContentView12 = NBPPublishContentView.this;
                                                cd.a(vVar8, new Function1<TextAreaView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextAreaView textAreaView) {
                                                        TextAreaView textAreaView2 = textAreaView;
                                                        final NBPPublishContentView nBPPublishContentView13 = NBPPublishContentView.this;
                                                        textAreaView2.ref(textAreaView2, new Function1<aa<TextAreaView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(aa<TextAreaView> aaVar) {
                                                                NBPPublishContentView.this.textAreaRef = aaVar;
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPPublishContentView nBPPublishContentView14 = NBPPublishContentView.this;
                                                        textAreaView2.attr(new Function1<cc, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(cc ccVar) {
                                                                cc ccVar2 = ccVar;
                                                                NBPPublishContentView nBPPublishContentView15 = NBPPublishContentView.this;
                                                                ccVar2.mo141height(((Number) nBPPublishContentView15.textAreaHeight$delegate.getValue(nBPPublishContentView15, NBPPublishContentView.$$delegatedProperties[2])).floatValue());
                                                                ccVar2.w("\u70b9\u51fb\u5206\u4eab\u66f4\u591a\u540c\u57ce\u8da3\u4e8b\uff5e");
                                                                cc.m(ccVar2, 18.0f, null, 2, null);
                                                                ccVar2.o();
                                                                if (NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel().getPhotoPath().length() > 0) {
                                                                    ccVar2.x(new h(16777215L, 0.4f));
                                                                } else {
                                                                    ccVar2.x(new h(68665789644L));
                                                                }
                                                                ccVar2.D(NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel().getContent());
                                                                ccVar2.v(800);
                                                                if (NBPPublishContentView.access$isImg2txtListVisible(NBPPublishContentView.this)) {
                                                                    ccVar2.m143maxHeight(52.0f);
                                                                } else {
                                                                    ccVar2.m143maxHeight(84.0f);
                                                                }
                                                                ccVar2.H(new h(4278229503L));
                                                                ccVar2.r(NBPPublishContentView.access$getSpans(NBPPublishContentView.this));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPPublishContentView nBPPublishContentView15 = NBPPublishContentView.this;
                                                        textAreaView2.event(new Function1<TextAreaEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextAreaEvent textAreaEvent) {
                                                                TextAreaEvent textAreaEvent2 = textAreaEvent;
                                                                final NBPPublishContentView nBPPublishContentView16 = NBPPublishContentView.this;
                                                                textAreaEvent2.n(true, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2.2.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(InputParams inputParams) {
                                                                        String take;
                                                                        take = StringsKt___StringsKt.take(inputParams.getText(), 800);
                                                                        NBPPublishContentView.access$handleInputContent(NBPPublishContentView.this, take);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                textAreaEvent2.p(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2.2.3.2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        Utils.INSTANCE.currentBridgeModule().qToast("\u5df2\u8d85\u8fc7\u5b57\u6570\u6700\u5927\u9650\u5236", QToastMode.Warning);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPPublishContentView nBPPublishContentView17 = NBPPublishContentView.this;
                                                                TextAreaEvent.k(textAreaEvent2, false, new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2.2.3.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(KeyboardParams keyboardParams) {
                                                                        KeyboardParams keyboardParams2 = keyboardParams;
                                                                        NBPPublishContentView nBPPublishContentView18 = NBPPublishContentView.this;
                                                                        nBPPublishContentView18.keyboardHeight$delegate.setValue(nBPPublishContentView18, NBPPublishContentView.$$delegatedProperties[3], Float.valueOf(keyboardParams2.getHeight()));
                                                                        KLog kLog = KLog.INSTANCE;
                                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("keyboardHeight: ");
                                                                        m3.append(keyboardParams2.getHeight());
                                                                        kLog.i("NBPPublishContentView", m3.toString());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }, 1, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishContentView nBPPublishContentView13 = NBPPublishContentView.this;
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        TextView textView2 = textView;
                                                        final NBPPublishContentView nBPPublishContentView14 = NBPPublishContentView.this;
                                                        textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                Attr.absolutePosition$default(ceVar2, 0.0f, 0.0f, 0.0f, 0.0f, 5, null);
                                                                String content = NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel().getContent();
                                                                if (content.length() == 0) {
                                                                    content = "\u70b9\u51fb\u5206\u4eab\u66f4\u591a\u540c\u57ce\u8da3\u4e8b\uff5e";
                                                                }
                                                                ceVar2.text(content);
                                                                ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                                                ceVar2.fontWeightMedium();
                                                                ceVar2.lineHeight(24.0f);
                                                                ceVar2.m152visibility(false);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPPublishContentView nBPPublishContentView15 = NBPPublishContentView.this;
                                                        textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextEvent textEvent) {
                                                                final NBPPublishContentView nBPPublishContentView16 = NBPPublishContentView.this;
                                                                FrameEventKt.d(textEvent, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.2.3.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(d dVar) {
                                                                        NBPPublishContentView nBPPublishContentView17 = NBPPublishContentView.this;
                                                                        nBPPublishContentView17.textAreaHeight$delegate.setValue(nBPPublishContentView17, NBPPublishContentView.$$delegatedProperties[2], Float.valueOf(dVar.getHeight()));
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
                                        final NBPPublishContentView nBPPublishContentView11 = NBPPublishContentView.this;
                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(NBPPublishContentView.access$isImg2txtListVisible(NBPPublishContentView.this));
                                            }
                                        };
                                        final NBPPublishContentView nBPPublishContentView12 = NBPPublishContentView.this;
                                        ConditionViewKt.c(vVar6, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView) {
                                                final NBPPublishContentView nBPPublishContentView13 = NBPPublishContentView.this;
                                                ar.a(conditionView, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aq<?, ?> aqVar) {
                                                        aq<?, ?> aqVar2 = aqVar;
                                                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ao aoVar) {
                                                                ao aoVar2 = aoVar;
                                                                aoVar2.padding(0.0f, 8.0f, 0.0f, 8.0f);
                                                                aoVar2.marginTop(8.0f);
                                                                aoVar2.mo141height(24.0f);
                                                                aoVar2.flexDirectionRow();
                                                                aoVar2.showScrollerIndicator(false);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPPublishContentView nBPPublishContentView14 = NBPPublishContentView.this;
                                                        Function0<com.tencent.kuikly.core.reactive.collection.c<String>> function03 = new Function0<com.tencent.kuikly.core.reactive.collection.c<String>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4.1.2
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final com.tencent.kuikly.core.reactive.collection.c<String> invoke() {
                                                                return NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel().getImg2txtContentList();
                                                            }
                                                        };
                                                        final NBPPublishContentView nBPPublishContentView15 = NBPPublishContentView.this;
                                                        LoopDirectivesViewKt.a(aqVar2, function03, new Function2<LoopDirectivesView<String>, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4.1.3
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Unit invoke(LoopDirectivesView<String> loopDirectivesView, String str) {
                                                                final String str2 = str;
                                                                final NBPPublishContentView nBPPublishContentView16 = NBPPublishContentView.this;
                                                                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4.1.3.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar7) {
                                                                        v vVar8 = vVar7;
                                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4.1.3.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.marginRight(4.0f);
                                                                                tVar2.mo113backgroundColor(new h(16777215L, 0.15f));
                                                                                tVar2.padding(0.0f, 8.0f, 0.0f, 8.0f);
                                                                                tVar2.borderRadius(4.0f);
                                                                                tVar2.flexDirectionRow();
                                                                                tVar2.alignItemsCenter();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4.1.3.1.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4.1.3.1.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ZSnKv45Z3m2.png", false, 2, null);
                                                                                        afVar2.t(new h(16777215L, 0.55f));
                                                                                        afVar2.size(16.0f, 16.0f);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final String str3 = str2;
                                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4.1.3.1.3
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final String str4 = str3;
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4.1.3.1.3.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        ceVar2.marginLeft(2.0f);
                                                                                        ceVar2.text(str4);
                                                                                        ceVar2.color(new h(16777215L, 0.55f));
                                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                        ceVar2.fontWeight400();
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NBPPublishContentView nBPPublishContentView17 = nBPPublishContentView16;
                                                                        final String str4 = str2;
                                                                        vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4.1.3.1.4
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(u uVar) {
                                                                                final NBPPublishContentView nBPPublishContentView18 = NBPPublishContentView.this;
                                                                                final String str5 = str4;
                                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.4.1.3.1.4.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        NBPPublishContentView.access$selectImg2txt(NBPPublishContentView.this, str5);
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
                                        final NBPPublishContentView nBPPublishContentView13 = NBPPublishContentView.this;
                                        vVar6.addChild(new NBPPublishMapSelectionView(), new Function1<NBPPublishMapSelectionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.5
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPPublishMapSelectionView nBPPublishMapSelectionView) {
                                                NBPPublishMapSelectionView nBPPublishMapSelectionView2 = nBPPublishMapSelectionView;
                                                final NBPPublishContentView nBPPublishContentView14 = NBPPublishContentView.this;
                                                nBPPublishMapSelectionView2.attr(new Function1<NBPPublishMapSelectionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.5.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPPublishMapSelectionAttr nBPPublishMapSelectionAttr) {
                                                        NBPPublishMapSelectionAttr nBPPublishMapSelectionAttr2 = nBPPublishMapSelectionAttr;
                                                        nBPPublishMapSelectionAttr2.viewModel = NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel();
                                                        nBPPublishMapSelectionAttr2.marginTop(12.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishContentView nBPPublishContentView15 = NBPPublishContentView.this;
                                                nBPPublishMapSelectionView2.event(new Function1<NBPPublishMapSelectionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.5.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPPublishMapSelectionEvent nBPPublishMapSelectionEvent) {
                                                        NBPPublishMapSelectionEvent nBPPublishMapSelectionEvent2 = nBPPublishMapSelectionEvent;
                                                        final NBPPublishContentView nBPPublishContentView16 = NBPPublishContentView.this;
                                                        nBPPublishMapSelectionEvent2.selectMapEventHandler = new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.5.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(f fVar) {
                                                                NBPPublishViewModel.selectMapTheme$default(NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel(), fVar, null, true, 2);
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        final NBPPublishContentView nBPPublishContentView17 = NBPPublishContentView.this;
                                                        nBPPublishMapSelectionEvent2.showMapActionSheetEventHandler = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.5.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPPublishContentView.this.hideKeyboard();
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        final NBPPublishContentView nBPPublishContentView18 = NBPPublishContentView.this;
                                                        new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.5.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(String str) {
                                                                NBPPublishContentView.access$selectImg2txt(NBPPublishContentView.this, str);
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        final NBPPublishContentView nBPPublishContentView19 = NBPPublishContentView.this;
                                                        nBPPublishMapSelectionEvent2.showImg2txtActionSheetEventHandler = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.2.2.5.5.2.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPPublishContentView.this.hideKeyboard();
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
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_nwcrB9oNmo8.png", false, 2, null);
                                afVar2.size(80.0f, 40.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishContentView nBPPublishContentView3 = NBPPublishContentView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPPublishContentView nBPPublishContentView4 = NBPPublishContentView.this;
                        return Boolean.valueOf(((Boolean) nBPPublishContentView4.showTakePhotoActionSheet$delegate.getValue(nBPPublishContentView4, NBPPublishContentView.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final NBPPublishContentView nBPPublishContentView4 = NBPPublishContentView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPPublishContentView nBPPublishContentView5 = NBPPublishContentView.this;
                        com.tencent.kuikly.core.views.e.a(conditionView, new Function1<ActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ActionSheetView actionSheetView) {
                                ActionSheetView actionSheetView2 = actionSheetView;
                                final NBPPublishContentView nBPPublishContentView6 = NBPPublishContentView.this;
                                actionSheetView2.attr(new Function1<ActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ActionSheetAttr actionSheetAttr) {
                                        List listOf;
                                        ActionSheetAttr actionSheetAttr2 = actionSheetAttr;
                                        NBPPublishContentView nBPPublishContentView7 = NBPPublishContentView.this;
                                        actionSheetAttr2.w(((Boolean) nBPPublishContentView7.showTakePhotoActionSheet$delegate.getValue(nBPPublishContentView7, NBPPublishContentView.$$delegatedProperties[0])).booleanValue());
                                        final NBPPublishContentView nBPPublishContentView8 = NBPPublishContentView.this;
                                        final NBPPublishContentView nBPPublishContentView9 = NBPPublishContentView.this;
                                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new NBPPublishContentView.ActionSheetItem[]{new NBPPublishContentView.ActionSheetItem("\u62cd\u7167", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.5.1.1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                final NBPPublishViewModel viewModel = NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel();
                                                viewModel.bridgeModule().asyncToNativeMethod("openCamera", new Object[0], new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$openCamera$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        if (obj != null && (obj instanceof String)) {
                                                            NBPPublishViewModel.this.processPhoto((String) obj);
                                                        }
                                                        KLog.INSTANCE.i("NBPPublishViewModel", "Nbp openCamera 3: callback, " + obj);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                KLog kLog = KLog.INSTANCE;
                                                kLog.i("NBPPublishBridgeModule", "Nbp openCamera 2: asyncToNativeMethod");
                                                kLog.i("NBPPublishContentView", "Nbp openCamera 1: Click ActionSheet");
                                                return Unit.INSTANCE;
                                            }
                                        }), new NBPPublishContentView.ActionSheetItem("\u4ece\u76f8\u518c\u4e2d\u9009\u62e9", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.5.1.1.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                final NBPPublishViewModel viewModel = NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel();
                                                viewModel.bridgeModule().asyncToNativeMethod("openAlbum", new Object[0], new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$openAlbum$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        if (obj != null && (obj instanceof String)) {
                                                            NBPPublishViewModel.this.processPhoto((String) obj);
                                                        }
                                                        KLog.INSTANCE.i("NBPPublishViewModel", "Nbp openAlbum 3: callback, " + obj);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                KLog kLog = KLog.INSTANCE;
                                                kLog.i("NBPPublishBridgeModule", "Nbp openAlbum 2: asyncToNativeMethod");
                                                kLog.i("NBPPublishContentView", "Nbp openAlbum 1: Click ActionSheet");
                                                return Unit.INSTANCE;
                                            }
                                        })});
                                        final NBPPublishContentView nBPPublishContentView10 = NBPPublishContentView.this;
                                        Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.5.1.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Boolean bool) {
                                                bool.booleanValue();
                                                r2.showTakePhotoActionSheet$delegate.setValue(NBPPublishContentView.this, NBPPublishContentView.$$delegatedProperties[0], Boolean.valueOf(false));
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        nBPPublishContentView8.getClass();
                                        actionSheetAttr2.j(new NBPPublishContentView$actionSheet$1(listOf, function1, null));
                                        actionSheetAttr2.mo113backgroundColor(h.INSTANCE.j());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishContentView nBPPublishContentView7 = NBPPublishContentView.this;
                                actionSheetView2.event(new Function1<com.tencent.kuikly.core.views.d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.d dVar) {
                                        final NBPPublishContentView nBPPublishContentView8 = NBPPublishContentView.this;
                                        dVar.j(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.5.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                r2.showTakePhotoActionSheet$delegate.setValue(NBPPublishContentView.this, NBPPublishContentView.$$delegatedProperties[0], Boolean.valueOf(false));
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
                final NBPPublishContentView nBPPublishContentView5 = NBPPublishContentView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$body$1.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPPublishContentView nBPPublishContentView6 = NBPPublishContentView.this;
                        return Boolean.valueOf(((Boolean) nBPPublishContentView6.showModifyPhotoActionSheet$delegate.getValue(nBPPublishContentView6, NBPPublishContentView.$$delegatedProperties[1])).booleanValue());
                    }
                };
                final NBPPublishContentView nBPPublishContentView6 = NBPPublishContentView.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$body$1.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPPublishContentView nBPPublishContentView7 = NBPPublishContentView.this;
                        com.tencent.kuikly.core.views.e.a(conditionView, new Function1<ActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.7.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ActionSheetView actionSheetView) {
                                ActionSheetView actionSheetView2 = actionSheetView;
                                final NBPPublishContentView nBPPublishContentView8 = NBPPublishContentView.this;
                                actionSheetView2.attr(new Function1<ActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.7.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ActionSheetAttr actionSheetAttr) {
                                        List listOf;
                                        ActionSheetAttr actionSheetAttr2 = actionSheetAttr;
                                        NBPPublishContentView nBPPublishContentView9 = NBPPublishContentView.this;
                                        actionSheetAttr2.w(((Boolean) nBPPublishContentView9.showModifyPhotoActionSheet$delegate.getValue(nBPPublishContentView9, NBPPublishContentView.$$delegatedProperties[1])).booleanValue());
                                        final NBPPublishContentView nBPPublishContentView10 = NBPPublishContentView.this;
                                        final NBPPublishContentView nBPPublishContentView11 = NBPPublishContentView.this;
                                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new NBPPublishContentView.ActionSheetItem[]{new NBPPublishContentView.ActionSheetItem("\u66f4\u6362\u7167\u7247", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.7.1.1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                r0.showTakePhotoActionSheet$delegate.setValue(NBPPublishContentView.this, NBPPublishContentView.$$delegatedProperties[0], Boolean.valueOf(true));
                                                NBPPublishContentView.access$reportPicChangePop(NBPPublishContentView.this, 1);
                                                KLog.INSTANCE.i("NBPPublishContentView", "Nbp changePhoto 1: Click ActionSheet");
                                                return Unit.INSTANCE;
                                            }
                                        }), new NBPPublishContentView.ActionSheetItem("\u5220\u9664\u7167\u7247", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.7.1.1.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel().processPhoto("");
                                                NBPPublishContentView.access$reportPicChangePop(NBPPublishContentView.this, 2);
                                                KLog.INSTANCE.i("NBPPublishContentView", "Nbp deletePhoto 1: Click ActionSheet");
                                                return Unit.INSTANCE;
                                            }
                                        })});
                                        AnonymousClass3 anonymousClass3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.7.1.1.3
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                e jsonWithPublishPgParams = NearbyConstKt.jsonWithPublishPgParams();
                                                jsonWithPublishPgParams.v("dt_eid", "em_nearby_pic_change_pop");
                                                jsonWithPublishPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithPublishPgParams);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final NBPPublishContentView nBPPublishContentView12 = NBPPublishContentView.this;
                                        Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.7.1.1.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Boolean bool) {
                                                boolean booleanValue = bool.booleanValue();
                                                r0.showModifyPhotoActionSheet$delegate.setValue(NBPPublishContentView.this, NBPPublishContentView.$$delegatedProperties[1], Boolean.valueOf(false));
                                                if (booleanValue) {
                                                    NBPPublishContentView.access$reportPicChangePop(NBPPublishContentView.this, 0);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        nBPPublishContentView10.getClass();
                                        actionSheetAttr2.j(new NBPPublishContentView$actionSheet$1(listOf, function1, anonymousClass3));
                                        actionSheetAttr2.mo113backgroundColor(h.INSTANCE.j());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishContentView nBPPublishContentView9 = NBPPublishContentView.this;
                                actionSheetView2.event(new Function1<com.tencent.kuikly.core.views.d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.7.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.d dVar) {
                                        final NBPPublishContentView nBPPublishContentView10 = NBPPublishContentView.this;
                                        dVar.j(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.7.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                r2.showModifyPhotoActionSheet$delegate.setValue(NBPPublishContentView.this, NBPPublishContentView.$$delegatedProperties[1], Boolean.valueOf(false));
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
                final NBPPublishContentView nBPPublishContentView7 = NBPPublishContentView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$body$1.8
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        Event event2 = event;
                        final NBPPublishContentView nBPPublishContentView8 = NBPPublishContentView.this;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.8.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NBPPublishContentView.this.hideKeyboard();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPublishContentView nBPPublishContentView9 = NBPPublishContentView.this;
                        FrameEventKt.d(event2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.body.1.8.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                d dVar2 = dVar;
                                NBPPublishContentView nBPPublishContentView10 = NBPPublishContentView.this;
                                nBPPublishContentView10.textContentHeight$delegate.setValue(nBPPublishContentView10, NBPPublishContentView.$$delegatedProperties[4], Float.valueOf(dVar2.getHeight()));
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("contentHeight: ");
                                m3.append(dVar2.getHeight());
                                kLog.i("NBPPublishContentView", m3.toString());
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
        return new NBPPublishContentAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPPublishContentEvent();
    }

    public final void hideKeyboard() {
        TextAreaView b16;
        aa<TextAreaView> aaVar = this.textAreaRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        b16.h();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        super.viewDestroyed();
        IPagerIdKtxKt.getNotifyModule(this).e("NBPPublishInitialTopicIdsUpdate", this.notifyCallbackRef);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        this.notifyCallbackRef = k.b(IPagerIdKtxKt.getNotifyModule(this), "NBPPublishInitialTopicIdsUpdate", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$viewDidLoad$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                TextAreaView b16;
                final ArrayList arrayList = new ArrayList();
                NBPPublishViewModel viewModel = NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel();
                ArrayList<n25.m> arrayList2 = (ArrayList) viewModel.topicList$delegate.getValue(viewModel, NBPPublishViewModel.$$delegatedProperties[0]);
                NBPPublishContentView nBPPublishContentView = NBPPublishContentView.this;
                for (n25.m mVar : arrayList2) {
                    if (NBPPublishContentView.access$getAttr(nBPPublishContentView).getViewModel().initialTopicIds.contains(mVar.f418098d)) {
                        arrayList.add(mVar);
                    }
                }
                final NBPPublishContentView nBPPublishContentView2 = NBPPublishContentView.this;
                aa<TextAreaView> aaVar = nBPPublishContentView2.textAreaRef;
                if (aaVar != null && (b16 = aaVar.b()) != null) {
                    b16.k(new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$insertTopicsIntoTextArea$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Integer num) {
                            TextAreaView b17;
                            int intValue = num.intValue();
                            String content = NBPPublishContentView.access$getAttr(NBPPublishContentView.this).getViewModel().getContent();
                            for (n25.m mVar2 : arrayList) {
                                StringBuilder sb5 = new StringBuilder(content);
                                StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('#');
                                m3.append(mVar2.f418099e);
                                sb5.insert(intValue, m3.toString());
                                content = sb5.toString();
                                intValue += mVar2.f418099e.length() + 1;
                            }
                            if (content.length() > 800) {
                                content = StringsKt___StringsKt.take(content, 800);
                                Utils.INSTANCE.currentBridgeModule().qToast("\u5df2\u8d85\u8fc7\u5b57\u6570\u6700\u5927\u9650\u5236", QToastMode.Warning);
                                intValue = 800;
                            }
                            NBPPublishContentView.access$handleInputContent(NBPPublishContentView.this, content);
                            aa<TextAreaView> aaVar2 = NBPPublishContentView.this.textAreaRef;
                            if (aaVar2 != null && (b17 = aaVar2.b()) != null) {
                                b17.n(intValue);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    /* loaded from: classes31.dex */
    public static final class ActionSheetItem {
        public final Function0<Unit> callback;
        public final String title;

        public ActionSheetItem(String str, Function0<Unit> function0) {
            this.title = str;
            this.callback = function0;
        }

        public final int hashCode() {
            return this.callback.hashCode() + (this.title.hashCode() * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ActionSheetItem(title=");
            m3.append(this.title);
            m3.append(", callback=");
            m3.append(this.callback);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionSheetItem)) {
                return false;
            }
            ActionSheetItem actionSheetItem = (ActionSheetItem) obj;
            return Intrinsics.areEqual(this.title, actionSheetItem.title) && Intrinsics.areEqual(this.callback, actionSheetItem.callback);
        }
    }
}
