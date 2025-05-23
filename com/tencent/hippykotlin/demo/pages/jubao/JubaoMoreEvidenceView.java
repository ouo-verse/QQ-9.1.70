package com.tencent.hippykotlin.demo.pages.jubao;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyMediaModule;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.InputEvent;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.InputView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ai;
import com.tencent.kuikly.core.views.am;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import s4.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoMoreEvidenceView extends JubaoAnimationView {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(JubaoMoreEvidenceView.class, "editHintTextVisible", "getEditHintTextVisible()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(JubaoMoreEvidenceView.class, WidgetCacheConstellationData.MONEY, "getMoney()F", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(JubaoMoreEvidenceView.class, c.PICS, "getPics()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public Function0<Unit> backClickCallback;
    public aa<InputView> inputRef;
    public long lastChoosePicClickTime;
    public Function2<? super List<String>, ? super Float, Unit> onComplete;
    public final PageModel pageModel;
    public final ReadWriteProperty editHintTextVisible$delegate = c01.c.a(Boolean.TRUE);
    public final ReadWriteProperty money$delegate = c01.c.a(Float.valueOf(-1.0f));
    public final ReadWriteProperty pics$delegate = c01.c.b();

    public JubaoMoreEvidenceView(PageModel pageModel) {
        this.pageModel = pageModel;
    }

    public static final com.tencent.kuikly.core.reactive.collection.c access$getPics(JubaoMoreEvidenceView jubaoMoreEvidenceView) {
        return (com.tencent.kuikly.core.reactive.collection.c) jubaoMoreEvidenceView.pics$delegate.getValue(jubaoMoreEvidenceView, $$delegatedProperties[2]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        JubaoAnimationView$body$1 jubaoAnimationView$body$1 = new JubaoAnimationView$body$1(this);
        event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(l lVar) {
                final JubaoMoreEvidenceView jubaoMoreEvidenceView = JubaoMoreEvidenceView.this;
                lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        aa<InputView> aaVar = JubaoMoreEvidenceView.this.inputRef;
                        if (aaVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("inputRef");
                            aaVar = null;
                        }
                        InputView b16 = aaVar.b();
                        if (b16 != null) {
                            b16.h();
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        w.a(this, JubaoUtil$O3BgView$1.INSTANCE);
        JubaoNavBarKt.JubaoNavBar(this, new Function1<JubaoNavBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(JubaoNavBar jubaoNavBar) {
                JubaoNavBar jubaoNavBar2 = jubaoNavBar;
                jubaoNavBar2.setBarData(new NavBarData("\u4e3e\u8bc1\u6750\u6599", true, false));
                final JubaoMoreEvidenceView jubaoMoreEvidenceView = JubaoMoreEvidenceView.this;
                jubaoNavBar2.backClickCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Function0<Unit> function0 = JubaoMoreEvidenceView.this.backClickCallback;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                };
                return Unit.INSTANCE;
            }
        });
        cg.a(this, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$3
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$3.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        ce ceVar2 = ceVar;
                        ceVar2.marginLeft(16.0f);
                        ceVar2.marginTop(16.0f);
                        ceVar2.color(JubaoThemeData.INSTANCE.getTitleTextColor());
                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                        ceVar2.fontWeight400();
                        ceVar2.text("\u635f\u5931\u91d1\u989d");
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        w.a(this, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$4.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.flexDirectionRow();
                        tVar2.marginTop(5.0f);
                        tVar2.mo141height(37.0f);
                        return Unit.INSTANCE;
                    }
                });
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$4.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.4.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginLeft(16.0f);
                                ceVar2.color(JubaoThemeData.INSTANCE.getTitleTextColor());
                                ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                ceVar2.fontWeight500();
                                ceVar2.text("\u00a5");
                                ceVar2.marginTop(9.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoMoreEvidenceView jubaoMoreEvidenceView = JubaoMoreEvidenceView.this;
                ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$4.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        JubaoMoreEvidenceView jubaoMoreEvidenceView2 = JubaoMoreEvidenceView.this;
                        return Boolean.valueOf(((Boolean) jubaoMoreEvidenceView2.editHintTextVisible$delegate.getValue(jubaoMoreEvidenceView2, JubaoMoreEvidenceView.$$delegatedProperties[0])).booleanValue());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$4.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.4.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.4.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u8f93\u5165\u635f\u5931\u91d1\u989d");
                                        ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.marginLeft(9.0f);
                                        ceVar2.marginTop(12.0f);
                                        ceVar2.textAlignCenter();
                                        ceVar2.fontWeight400();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoMoreEvidenceView jubaoMoreEvidenceView2 = JubaoMoreEvidenceView.this;
                am.a(vVar2, new Function1<InputView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$4.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(InputView inputView) {
                        InputView inputView2 = inputView;
                        final JubaoMoreEvidenceView jubaoMoreEvidenceView3 = JubaoMoreEvidenceView.this;
                        inputView2.ref(inputView2, new Function1<aa<InputView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.4.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<InputView> aaVar) {
                                JubaoMoreEvidenceView.this.inputRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        inputView2.attr(new Function1<ai, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.4.5.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ai aiVar) {
                                ai aiVar2 = aiVar;
                                aiVar2.absolutePosition(0.0f, 37.0f, 0.0f, 16.0f);
                                aiVar2.i(JubaoThemeData.INSTANCE.getItemViewTextColor());
                                ai.n(aiVar2, 32, null, 2, null);
                                aiVar2.o();
                                aiVar2.D();
                                aiVar2.r();
                                aiVar2.t(10);
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoMoreEvidenceView jubaoMoreEvidenceView4 = JubaoMoreEvidenceView.this;
                        inputView2.event(new Function1<InputEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.4.5.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(InputEvent inputEvent) {
                                final JubaoMoreEvidenceView jubaoMoreEvidenceView5 = JubaoMoreEvidenceView.this;
                                InputEvent.q(inputEvent, false, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.4.5.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(InputParams inputParams) {
                                        Float floatOrNull;
                                        InputParams inputParams2 = inputParams;
                                        JubaoMoreEvidenceView jubaoMoreEvidenceView6 = JubaoMoreEvidenceView.this;
                                        floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(inputParams2.getText());
                                        float floatValue = floatOrNull != null ? floatOrNull.floatValue() : -1.0f;
                                        ReadWriteProperty readWriteProperty = jubaoMoreEvidenceView6.money$delegate;
                                        KProperty<?>[] kPropertyArr = JubaoMoreEvidenceView.$$delegatedProperties;
                                        readWriteProperty.setValue(jubaoMoreEvidenceView6, kPropertyArr[1], Float.valueOf(floatValue));
                                        JubaoMoreEvidenceView jubaoMoreEvidenceView7 = JubaoMoreEvidenceView.this;
                                        jubaoMoreEvidenceView7.editHintTextVisible$delegate.setValue(jubaoMoreEvidenceView7, kPropertyArr[0], Boolean.valueOf(inputParams2.getText().length() == 0));
                                        return Unit.INSTANCE;
                                    }
                                }, 1, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        w.a(this, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$5
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$5.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getPartingLineColor());
                        tVar2.mo141height(0.6f);
                        tVar2.marginLeft(16.0f);
                        tVar2.marginRight(16.0f);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        cg.a(this, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$6
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$6.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        ce ceVar2 = ceVar;
                        ceVar2.marginLeft(16.0f);
                        ceVar2.marginTop(24.0f);
                        ceVar2.color(JubaoThemeData.INSTANCE.getTitleTextColor());
                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                        ceVar2.fontWeight400();
                        ceVar2.text("\u56fe\u7247\u8bc1\u636e");
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        cg.a(this, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$7
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$7.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        ce ceVar2 = ceVar;
                        ceVar2.text("\u5efa\u8bae\u63d0\u4f9b\u8f6c\u8d26\u622a\u56fe\u7b49\u8bc1\u636e\u4fe1\u606f\uff08\u6700\u591a5\u5f20\uff09");
                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                        ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                        ceVar2.marginLeft(16.0f);
                        ceVar2.marginRight(16.0f);
                        ceVar2.marginTop(14.0f);
                        ceVar2.fontWeight400();
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        cn.a(this, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(cm cmVar) {
                cm cmVar2 = cmVar;
                cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$8.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ck ckVar) {
                        ck ckVar2 = ckVar;
                        ckVar2.w(ckVar2.getPagerData().m() - 32.0f);
                        ckVar2.flexDirection(FlexDirection.COLUMN);
                        ckVar2.m140flex(1.0f);
                        ckVar2.marginBottom(100.0f);
                        ckVar2.m143maxHeight(212.0f);
                        ckVar2.h(3);
                        ckVar2.marginLeft(16.0f);
                        ckVar2.u(12.0f);
                        ckVar2.marginTop(16.0f);
                        ckVar2.showScrollerIndicator(false);
                        return Unit.INSTANCE;
                    }
                });
                final JubaoMoreEvidenceView jubaoMoreEvidenceView = JubaoMoreEvidenceView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$8.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(JubaoMoreEvidenceView.access$getPics(JubaoMoreEvidenceView.this).size() < 5);
                    }
                };
                final JubaoMoreEvidenceView jubaoMoreEvidenceView2 = JubaoMoreEvidenceView.this;
                ConditionViewKt.c(cmVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$8.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final JubaoMoreEvidenceView jubaoMoreEvidenceView3 = JubaoMoreEvidenceView.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(100.0f);
                                        tVar2.mo153width(100.0f);
                                        tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getFillStandardBrand());
                                        tVar2.allCenter();
                                        tVar2.borderRadius(6.0f);
                                        tVar2.accessibility("\u6dfb\u52a0\u56fe\u7247");
                                        tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.3.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.3.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.mo141height(24.0f);
                                                afVar2.mo153width(24.0f);
                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAACXBIWXMAABYlAAAWJQFJUiTwAAABaWlDQ1BEaXNwbGF5IFAzAAB4nHWQvUvDUBTFT6tS0DqIDh0cMolD1NIKdnFoKxRFMFQFq1OafgltfCQpUnETVyn4H1jBWXCwiFRwcXAQRAcR3Zw6KbhoeN6XVNoi3sfl/Ticc7lcwBtQGSv2AijplpFMxKS11Lrke4OHnlOqZrKooiwK/v276/PR9d5PiFlNu3YQ2U9cl84ul3aeAlN//V3Vn8maGv3f1EGNGRbgkYmVbYsJ3iUeMWgp4qrgvMvHgtMunzuelWSc+JZY0gpqhrhJLKc79HwHl4plrbWD2N6f1VeXxRzqUcxhEyYYilBRgQQF4X/8044/ji1yV2BQLo8CLMpESRETssTz0KFhEjJxCEHqkLhz634PrfvJbW3vFZhtcM4v2tpCAzidoZPV29p4BBgaAG7qTDVUR+qh9uZywPsJMJgChu8os2HmwiF3e38M6Hvh/GMM8B0CdpXzryPO7RqFn4Er/QcXKWq8MSlPPgAAAG9JREFUeAHt2DsOgCAQANHVC2ni/Y9goifS1mBDARk+8zoqMgkUuxHS3JaoZNuP53u+r7PKXWt0zgCaATQDaAbQDKAZQDOAZgDtNyWlk1Rr0snOJ0Qb7w+U4lYikwE0A2gG0AygGUAzgGYAzQBJrBczhgxOLUKZ0QAAAABJRU5ErkJggg==", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final JubaoMoreEvidenceView jubaoMoreEvidenceView4 = JubaoMoreEvidenceView.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.3.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final JubaoMoreEvidenceView jubaoMoreEvidenceView5 = JubaoMoreEvidenceView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.3.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                long currentTimeStamp = ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).currentTimeStamp();
                                                JubaoMoreEvidenceView jubaoMoreEvidenceView6 = JubaoMoreEvidenceView.this;
                                                if (currentTimeStamp - jubaoMoreEvidenceView6.lastChoosePicClickTime < 1000 && currentTimeStamp > 0) {
                                                    ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).log("choose pics quick click");
                                                } else {
                                                    jubaoMoreEvidenceView6.lastChoosePicClickTime = currentTimeStamp;
                                                    QQKuiklyMediaModule qQKuiklyMediaModule = (QQKuiklyMediaModule) cVar.g().acquireModule("QQKuiklyMediaModule");
                                                    int size = 5 - JubaoMoreEvidenceView.access$getPics(JubaoMoreEvidenceView.this).size();
                                                    int i3 = AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar) ? 2 : 5;
                                                    final JubaoMoreEvidenceView jubaoMoreEvidenceView7 = JubaoMoreEvidenceView.this;
                                                    Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.3.1.3.1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(e eVar) {
                                                            Object d16;
                                                            e eVar2 = eVar;
                                                            ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("choose pics result is " + eVar2);
                                                            com.tencent.kuikly.core.nvi.serialization.json.b l3 = eVar2 != null ? eVar2.l("imagePaths") : null;
                                                            if (l3 != null && l3.c() > 0) {
                                                                ArrayList arrayList = new ArrayList();
                                                                int c16 = l3.c();
                                                                for (int i16 = 0; i16 < c16; i16++) {
                                                                    if (BooleanCompanionObject.INSTANCE instanceof String) {
                                                                        d16 = Boolean.valueOf(l3.e(i16));
                                                                    } else if (IntCompanionObject.INSTANCE instanceof String) {
                                                                        d16 = Integer.valueOf(l3.i(i16));
                                                                    } else if (LongCompanionObject.INSTANCE instanceof String) {
                                                                        d16 = Long.valueOf(l3.m(i16));
                                                                    } else if (StringCompanionObject.INSTANCE instanceof String) {
                                                                        d16 = l3.o(i16);
                                                                    } else if (DoubleCompanionObject.INSTANCE instanceof String) {
                                                                        d16 = Double.valueOf(l3.g(i16));
                                                                    } else {
                                                                        d16 = l3.d(i16);
                                                                    }
                                                                    if (d16 != null) {
                                                                        arrayList.add((String) d16);
                                                                    } else {
                                                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                                                    }
                                                                }
                                                                JubaoMoreEvidenceView.access$getPics(JubaoMoreEvidenceView.this).addAll(arrayList);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    int i16 = QQKuiklyMediaModule.$r8$clinit;
                                                    qQKuiklyMediaModule.getClass();
                                                    e eVar = new e();
                                                    eVar.t("maxCount", size);
                                                    eVar.v("mediaType", String.valueOf(BoxType$EnumUnboxingSharedUtility.ordinal(i3)));
                                                    eVar.w("needClip", false);
                                                    eVar.t("clipMaskType", 1);
                                                    eVar.t("clipWidth", 0);
                                                    eVar.t("clipHeight", 0);
                                                    eVar.t("clipOutputWidth", 0);
                                                    eVar.t("clipOutputHeight", 0);
                                                    qQKuiklyMediaModule.toNative(false, "chooseMedia", eVar.toString(), function1, false);
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
                final JubaoMoreEvidenceView jubaoMoreEvidenceView3 = JubaoMoreEvidenceView.this;
                Function0<com.tencent.kuikly.core.reactive.collection.c<String>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<String>>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$8.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final com.tencent.kuikly.core.reactive.collection.c<String> invoke() {
                        return JubaoMoreEvidenceView.access$getPics(JubaoMoreEvidenceView.this);
                    }
                };
                final JubaoMoreEvidenceView jubaoMoreEvidenceView4 = JubaoMoreEvidenceView.this;
                LoopDirectivesViewKt.b(cmVar2, function02, new Function4<LoopDirectivesView<String>, String, Integer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$8.5
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public final Unit invoke(LoopDirectivesView<String> loopDirectivesView, String str, Integer num, Integer num2) {
                        final String str2 = str;
                        num.intValue();
                        num2.intValue();
                        final JubaoMoreEvidenceView jubaoMoreEvidenceView5 = JubaoMoreEvidenceView.this;
                        w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(100.0f);
                                        tVar2.mo153width(100.0f);
                                        tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getFillStandardBrand());
                                        tVar2.allCenter();
                                        tVar2.borderRadius(6.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final String str3 = str2;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.5.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final String str4 = str3;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.5.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.mo141height(100.0f);
                                                afVar2.mo153width(100.0f);
                                                b.a.a(afVar2, com.tencent.kuikly.core.base.attr.e.INSTANCE.a(str4), false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final JubaoMoreEvidenceView jubaoMoreEvidenceView6 = jubaoMoreEvidenceView5;
                                final String str4 = str2;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.5.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        ImageView imageView2 = imageView;
                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.5.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.absolutePosition(0.0f, 84.0f, 84.0f, 0.0f);
                                                afVar2.mo141height(16.0f);
                                                afVar2.mo153width(16.0f);
                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGAAAABgCAYAAADimHc4AAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAKoSURBVHgB7dxPTttAFAbwZ1SyDj5BpXIAItWbsi/bbrv0DdqT9AhB3XRLl4ENe5DgCJzAsA5/Hn4JIwUEccae8YvffD8JhUjRKPk+nNgzQzLaAtPpv89Z9jAl4oP67pjMy06YP/0uy583GSlbhn9/RUkE/8od8+5kh5TVf/l/KL3wxViOevUC6redH5QsPtiCApI2RgHKUIAyFKAMBShDAcpQgDIUoAwFKEMBylCAMlMFjEa7dHj4rb4dUWixxjZTgAR0dPSd9ve/LG5DBhVzbBMFuIDyPF/cz/O9YEHFHFsMvoC3ATkhgoo5tjPoAj4KyOkSVMyxVw26gKIoPgzIaRNUU/irYxfFV+pi0AVcXFxSVd02Ps6nhE3DF1VVLZ5DF4MuYD6f02x2GqwE3/Bns7PFc+hi8B/CoUrQCF+YOA3tWoJW+MLMhVjbEjTDF+obs46P/zIFJKEuA91rfOyyLFYLX5ibjPM9EjTDFyZnQ31KaBIzfGF2OjpECbHDF6bXA7qU0Ef4wvyCTJsS+gpfJLIixi8/m+rv5NB8AT7n+U7oOf91TBfQJnynrxLMFtAlfKePEkwWECJ8J3YJ5grwndsJvZ7gy9y2FN+JtZDrCW2Y25biO7cTelHHl8ltKeu8d5GlWYLZbSnvWXeFq1WC6W0pqzaZXtAowfy2FOEzt+NbAralNATVZmJt0xKwLaUhqC6zmjHHXmV2W0qIgGKO7ZjclhIyoJhjC1O7IuSMRD4U5X059GJKrLHNbUsZGvyPmDIUoAwFKEMBylCAMhSgDAUoQwHKUIAyFKBsG7649Y4StgUF7FxTopj5v3oBzA9lokdB/ZqffqkXUJblDfPTpP71hNJQB5+dMz9O5LUTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAM3jNlygAo1gfsKQAAAABJRU5ErkJggg==", false, 2, null);
                                                afVar2.accessibility("\u5220\u9664\u56fe\u7247");
                                                afVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final JubaoMoreEvidenceView jubaoMoreEvidenceView7 = JubaoMoreEvidenceView.this;
                                        final String str5 = str4;
                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.5.1.3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageEvent imageEvent) {
                                                final JubaoMoreEvidenceView jubaoMoreEvidenceView8 = JubaoMoreEvidenceView.this;
                                                final String str6 = str5;
                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.5.1.3.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        BridgeModule bridgeModule = (BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule");
                                                        final JubaoMoreEvidenceView jubaoMoreEvidenceView9 = JubaoMoreEvidenceView.this;
                                                        final String str7 = str6;
                                                        bridgeModule.showAlert(null, "\u786e\u8ba4\u5220\u9664\u8be5\u56fe\u7247\u8bc1\u636e\u5417", "\u53d6\u6d88", "\u786e\u8ba4", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.8.5.1.3.2.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
                                                            
                                                                if (r2.j("index") == 1) goto L8;
                                                             */
                                                            @Override // kotlin.jvm.functions.Function1
                                                            /*
                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                            */
                                                            public final Unit invoke(e eVar) {
                                                                e eVar2 = eVar;
                                                                boolean z16 = eVar2 != null;
                                                                if (z16) {
                                                                    JubaoMoreEvidenceView.access$getPics(JubaoMoreEvidenceView.this).remove(str7);
                                                                    JubaoMoreEvidenceView.this.pageModel.pics.remove(str7);
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
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        w.a(this, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$9.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.absolutePosition(0.0f, 0.0f, 50.0f, 0.0f);
                        tVar2.flexDirectionRow();
                        tVar2.alignItemsFlexEnd();
                        tVar2.justifyContentCenter();
                        return Unit.INSTANCE;
                    }
                });
                final JubaoMoreEvidenceView jubaoMoreEvidenceView = JubaoMoreEvidenceView.this;
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$9.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        v vVar4 = vVar3;
                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.9.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(45.0f);
                                tVar2.mo153width(129.0f);
                                tVar2.borderRadius(4.0f);
                                tVar2.m136border(new com.tencent.kuikly.core.base.e(1.0f, BorderStyle.SOLID, JubaoThemeData.INSTANCE.getButtonBorderSecondaryDefault()));
                                tVar2.allCenter();
                                tVar2.accessibility("\u8df3\u8fc7");
                                tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoMoreEvidenceView jubaoMoreEvidenceView2 = JubaoMoreEvidenceView.this;
                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.9.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final JubaoMoreEvidenceView jubaoMoreEvidenceView3 = JubaoMoreEvidenceView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.9.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        float floatValue;
                                        Function2<? super List<String>, ? super Float, Unit> function2 = JubaoMoreEvidenceView.this.onComplete;
                                        if (function2 != null) {
                                            ArrayList arrayList = new ArrayList();
                                            floatValue = ((Number) r1.money$delegate.getValue(JubaoMoreEvidenceView.this, JubaoMoreEvidenceView.$$delegatedProperties[1])).floatValue();
                                            function2.invoke(arrayList, Float.valueOf(floatValue));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.9.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.9.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u8df3\u8fc7");
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        ceVar2.color(JubaoThemeData.INSTANCE.getButtonTextSecondaryDefault());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoMoreEvidenceView jubaoMoreEvidenceView2 = JubaoMoreEvidenceView.this;
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$9.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        v vVar4 = vVar3;
                        final JubaoMoreEvidenceView jubaoMoreEvidenceView3 = JubaoMoreEvidenceView.this;
                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.9.3.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
                            /* JADX WARN: Removed duplicated region for block: B:8:0x004b  */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(t tVar) {
                                boolean z16;
                                float floatValue;
                                t tVar2 = tVar;
                                tVar2.mo141height(45.0f);
                                tVar2.mo153width(129.0f);
                                tVar2.marginLeft(12.0f);
                                tVar2.borderRadius(4.0f);
                                tVar2.m136border(new com.tencent.kuikly.core.base.e(1.0f, BorderStyle.SOLID, h.INSTANCE.j()));
                                tVar2.allCenter();
                                if (JubaoMoreEvidenceView.access$getPics(JubaoMoreEvidenceView.this).size() <= 0) {
                                    floatValue = ((Number) r0.money$delegate.getValue(JubaoMoreEvidenceView.this, JubaoMoreEvidenceView.$$delegatedProperties[1])).floatValue();
                                    if (floatValue < 0.0f) {
                                        z16 = false;
                                        tVar2.m151touchEnable(z16);
                                        if (z16) {
                                            tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getDisableBtnBgColor());
                                        } else {
                                            tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                        }
                                        tVar2.accessibility("\u63d0\u4ea4");
                                        tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                        return Unit.INSTANCE;
                                    }
                                }
                                z16 = true;
                                tVar2.m151touchEnable(z16);
                                if (z16) {
                                }
                                tVar2.accessibility("\u63d0\u4ea4");
                                tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoMoreEvidenceView jubaoMoreEvidenceView4 = JubaoMoreEvidenceView.this;
                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.9.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final JubaoMoreEvidenceView jubaoMoreEvidenceView5 = JubaoMoreEvidenceView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.9.3.2.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:12:0x004e, code lost:
                                    
                                        if (r4 >= 0.0f) goto L11;
                                     */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(ClickParams clickParams) {
                                        List list;
                                        float floatValue;
                                        float floatValue2;
                                        float floatValue3;
                                        JubaoMoreEvidenceView jubaoMoreEvidenceView6 = JubaoMoreEvidenceView.this;
                                        if (!((Boolean) jubaoMoreEvidenceView6.editHintTextVisible$delegate.getValue(jubaoMoreEvidenceView6, JubaoMoreEvidenceView.$$delegatedProperties[0])).booleanValue()) {
                                            floatValue3 = ((Number) r4.money$delegate.getValue(JubaoMoreEvidenceView.this, JubaoMoreEvidenceView.$$delegatedProperties[1])).floatValue();
                                            if (floatValue3 < 0.0f) {
                                                ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u6570\u5b57\u91d1\u989d", QToastMode.Warning);
                                                return Unit.INSTANCE;
                                            }
                                        }
                                        if (JubaoMoreEvidenceView.access$getPics(JubaoMoreEvidenceView.this).size() <= 0) {
                                            floatValue2 = ((Number) r4.money$delegate.getValue(JubaoMoreEvidenceView.this, JubaoMoreEvidenceView.$$delegatedProperties[1])).floatValue();
                                        }
                                        JubaoMoreEvidenceView jubaoMoreEvidenceView7 = JubaoMoreEvidenceView.this;
                                        Function2<? super List<String>, ? super Float, Unit> function2 = jubaoMoreEvidenceView7.onComplete;
                                        if (function2 != null) {
                                            list = CollectionsKt___CollectionsKt.toList(JubaoMoreEvidenceView.access$getPics(jubaoMoreEvidenceView7));
                                            floatValue = ((Number) r1.money$delegate.getValue(JubaoMoreEvidenceView.this, JubaoMoreEvidenceView.$$delegatedProperties[1])).floatValue();
                                            function2.invoke(list, Float.valueOf(floatValue));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.9.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.9.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u63d0\u4ea4");
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        ceVar2.color(JubaoThemeData.INSTANCE.getConfirmBtnTextColor());
                                        ceVar2.m151touchEnable(false);
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
        ConditionViewKt.c(this, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$10
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean z16 = true;
                if (JubaoMoreEvidenceView.this.pageModel.getOperateStatus() != 1 && JubaoMoreEvidenceView.this.pageModel.getOperateStatus() != 3 && JubaoMoreEvidenceView.this.pageModel.getOperateStatus() != 5 && JubaoMoreEvidenceView.this.pageModel.getOperateStatus() != 6) {
                    z16 = false;
                }
                return Boolean.valueOf(z16);
            }
        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$11
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                final JubaoMoreEvidenceView jubaoMoreEvidenceView = JubaoMoreEvidenceView.this;
                conditionView.addChild(new JubaoSubmitLoading(), new Function1<JubaoSubmitLoading, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView$body$1$11.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(JubaoSubmitLoading jubaoSubmitLoading) {
                        final JubaoMoreEvidenceView jubaoMoreEvidenceView2 = JubaoMoreEvidenceView.this;
                        jubaoSubmitLoading.attr(new Function1<JubaoSubmitLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoMoreEvidenceView.body.1.11.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(JubaoSubmitLoadingAttr jubaoSubmitLoadingAttr) {
                                JubaoSubmitLoadingAttr jubaoSubmitLoadingAttr2 = jubaoSubmitLoadingAttr;
                                if (JubaoMoreEvidenceView.this.pageModel.getOperateStatus() != 5 && JubaoMoreEvidenceView.this.pageModel.getOperateStatus() != 1 && JubaoMoreEvidenceView.this.pageModel.getOperateStatus() != 3) {
                                    jubaoSubmitLoadingAttr2.setText("\u8865\u5145\u6210\u529f");
                                    jubaoSubmitLoadingAttr2.setIcon("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQBAMAAAB8P++eAAAAD1BMVEUAAAD///////////////+PQt5oAAAABHRSTlMAX38wWg1aggAAAH1JREFUSMftzLkNgEAMBVGOBkCiAAIK2BYWuf+aSFaacJyACDyhv/Wmqqp+3pp9PM7c3xx3EoxoOTB6FtwKfAdsSXDpSfAaZwPXcReQQUAWAZkEZBOQUUBWAZkFhDQQ0kBIQCEBhQQUch+gkgEoJKCQgEICCjlAbZ+qqvq0B5FRJNyrh4AbAAAAAElFTkSuQmCC");
                                    jubaoSubmitLoadingAttr2.setShowAnimation(false);
                                } else {
                                    jubaoSubmitLoadingAttr2.setText("\u63d0\u4ea4\u4e2d");
                                    jubaoSubmitLoadingAttr2.setIcon("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAhFBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////8g2+bRAAAALHRSTlMAtHlcjt2kZ4GI5azENj+abc/8ci/VvzrKEpT2nmLy7roc6gdVRBcMJyBPSXMoR70AAAMTSURBVFjDnZbbdqowEEAHAgZaQJQoRsWKotz+///OzABHbb0E9lNXV/d2aKIOvOWcCimFaNNKwyQakUkp4ySx7bipTa1zXl+BuQoKxBywPS9R2khPo8tFAVE/Bjzfaz4mrmGaRtGlzf9MQAHfscNPPgeGEdI+YCPsI55+N79SWIiwoICp2rYQGGCfA9utc3kdKCnAI+QPc6k2pgD78/m8eTcBj5CS/0hdcID8/V6+LNRcyM/wBF3QAOTPZv7LQq5UxfrThOABZoiEaYRO539/Z/BAWSmz66599pHm4Z8XIupqVPA635rd/7lKuQAmlD7piH93zmnKhbNRQW/RJ5rbA0RcUGDGdUb68WiVwy8iBBMaDGnYX6/FcHsiLlRgjI86MoygL1w4mweuFupBEGTD9bhgooYRCNSR490F1jCG0kJ9s9komIq9QRabZHJAoY5YMJn1gljlkwPearFCmsmBZsXYkwOVy2zpVtR6QqB0GQvKqCiKKccZcCCAUBDVhMAXAwUHovGB7z4gmMuUwOkuUEy4SScGHyFDJgQWP8QCmow5jw4ciJ8ALlkmET3WV7vDDgszSCUz+hzFckfYUElm9DHsl8SugRLtOI7l2IBL+nJZ4ywxk4/zoyXj0o/sJ+24wLwL7OkDNU6IeNRB1rsdByJAJAfsdNQAO4SegEjRRhJt7ueHw44QQJxjmxHmge3hQImvGpjUZrzQ1Bf4JqCEDx3nfhO1teEDuKcfSqxq6AnJRxJt5G9OJy6Iu5k8xjc5y/KIHyNUWMANbbPv+7H++PoW+lRwH+5uyDqt8/qDH7hfLhckPNB67DuOH77zxcJ10UcS+EVBPrEV+uXL71foc8KBP8Ts8zqdPU2UMsAvwy5gwROKzud9OqvgF8rDL/Qh4MBT2n4A3ugdGdX/F+nWPtJCMhRseEHk9wPs+4167vi4XPNC1geQjXi3ST8GLOK47gsLLsxyeEfok38LHG8BLgQCPqALh/whgP5dIJAlfEanTucPgWMfWKNuSCWdLkB0ge9EwSh0WNjOnAKzuRe3V3jBP+3SUNMfKha+AAAAAElFTkSuQmCC");
                                    jubaoSubmitLoadingAttr2.setShowAnimation(true);
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
        return jubaoAnimationView$body$1;
    }
}
