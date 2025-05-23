package com.tencent.hippykotlin.demo.pages.nearby.interactive.view;

import c01.c;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NBPInteractivePageSource$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyFollowRepo$setFollowState$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model.NBPInteractiveViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model.NBPInteractiveViewModel$doFollowBack$2;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import i35.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPInteractiveFollowedMeView extends ComposeView<NBPInteractiveFollowedMeViewAttr, NBPInteractiveFollowedMeViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPInteractiveFollowedMeView.class, "hasClickFollowBack", "getHasClickFollowBack()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPInteractiveFollowedMeView.class, "canceledFollow", "getCanceledFollow()Z", 0)};
    public final ReadWriteProperty canceledFollow$delegate;
    public final ReadWriteProperty hasClickFollowBack$delegate;
    public String source;

    public NBPInteractiveFollowedMeView() {
        Boolean bool = Boolean.FALSE;
        this.hasClickFollowBack$delegate = c.a(bool);
        this.canceledFollow$delegate = c.a(bool);
        this.source = NBPInteractivePageSource$EnumUnboxingLocalUtility._getValue(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPInteractiveFollowedMeViewAttr access$getAttr(NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView) {
        return (NBPInteractiveFollowedMeViewAttr) nBPInteractiveFollowedMeView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPInteractiveFollowedMeViewEvent access$getEvent(NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView) {
        return (NBPInteractiveFollowedMeViewEvent) nBPInteractiveFollowedMeView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPInteractiveViewModel nBPInteractiveViewModel = ((NBPInteractiveFollowedMeViewAttr) getAttr()).viewModel;
        final a aVar = ((NBPInteractiveFollowedMeViewAttr) getAttr()).followData;
        final float m3 = getPagerData().m() - 32.0f;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final float f16 = m3;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.justifyContentSpaceBetween();
                        mVar2.mo153width(f16);
                        mVar2.alignSelfCenter();
                        mVar2.marginLeft(16.0f);
                        mVar2.marginTop(16.0f);
                        mVar2.paddingBottom(16.0f);
                        mVar2.positionRelative();
                        return Unit.INSTANCE;
                    }
                });
                final a aVar2 = aVar;
                final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView = this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        ImageView imageView2 = imageView;
                        final a aVar3 = a.this;
                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                String str;
                                s35.af afVar2;
                                af afVar3 = afVar;
                                afVar3.size(32.0f, 32.0f);
                                afVar3.p();
                                afVar3.borderRadius(16.0f);
                                a aVar4 = a.this;
                                if (aVar4 == null || (afVar2 = aVar4.f407155h) == null || (str = afVar2.E) == null) {
                                    str = "";
                                }
                                b.a.b(afVar3, str, false, 2, null);
                                afVar3.marginRight(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView2 = nBPInteractiveFollowedMeView;
                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageEvent imageEvent) {
                                final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView3 = NBPInteractiveFollowedMeView.this;
                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Function0<Unit> function0 = NBPInteractiveFollowedMeView.access$getEvent(NBPInteractiveFollowedMeView.this).avatarClickFn;
                                        if (function0 != null) {
                                            function0.invoke();
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
                final a aVar3 = aVar;
                final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView2 = this;
                final NBPInteractiveViewModel nBPInteractiveViewModel2 = nBPInteractiveViewModel;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionColumn();
                                return Unit.INSTANCE;
                            }
                        });
                        final a aVar4 = a.this;
                        final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView3 = nBPInteractiveFollowedMeView2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentSpaceBetween();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final a aVar5 = a.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final a aVar6 = a.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                s35.af afVar;
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                a aVar7 = a.this;
                                                if (aVar7 == null || (afVar = aVar7.f407155h) == null || (str = afVar.f433209f) == null) {
                                                    str = "";
                                                }
                                                ceVar2.text(str);
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.textPostProcessor("emoji");
                                                ceVar2.fontWeight500();
                                                ceVar2.lineHeight(20.0f);
                                                ceVar2.m144maxWidth(200.0f);
                                                ceVar2.lines(1);
                                                ceVar2.textOverFlowTail();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView4 = nBPInteractiveFollowedMeView3;
                                InteractiveTimeViewKt.InteractiveTime(vVar4, new Function1<InteractiveTimeView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(InteractiveTimeView interactiveTimeView) {
                                        final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView5 = NBPInteractiveFollowedMeView.this;
                                        interactiveTimeView.attr(new Function1<InteractiveTimeViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InteractiveTimeViewAttr interactiveTimeViewAttr) {
                                                interactiveTimeViewAttr.createTime = (int) NBPInteractiveFollowedMeView.access$getAttr(NBPInteractiveFollowedMeView.this).timestamp;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final a aVar5 = a.this;
                        final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView4 = nBPInteractiveFollowedMeView2;
                        final NBPInteractiveViewModel nBPInteractiveViewModel3 = nBPInteractiveViewModel2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        tVar2.justifyContentSpaceBetween();
                                        tVar2.marginTop(4.0f);
                                        tVar2.mo153width(218.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final a aVar6 = a.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final a aVar7 = a.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.fontWeight400();
                                                a aVar8 = a.this;
                                                if (aVar8 == null || (str = aVar8.f407153e) == null) {
                                                    str = "\u5f00\u59cb\u5173\u6ce8\u4f60";
                                                }
                                                ceVar2.text(str);
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final a aVar7 = a.this;
                                final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView5 = nBPInteractiveFollowedMeView4;
                                final NBPInteractiveViewModel nBPInteractiveViewModel4 = nBPInteractiveViewModel3;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.flexDirectionRow();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final a aVar8 = a.this;
                                        final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView6 = nBPInteractiveFollowedMeView5;
                                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
                                            
                                                if (((java.lang.Boolean) r0.hasClickFollowBack$delegate.getValue(r0, com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.$$delegatedProperties[0])).booleanValue() != false) goto L11;
                                             */
                                            @Override // kotlin.jvm.functions.Function0
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Object invoke() {
                                                boolean booleanValue;
                                                a aVar9 = a.this;
                                                boolean z16 = true;
                                                if (aVar9 != null && aVar9.f407156i == 2) {
                                                    NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView7 = nBPInteractiveFollowedMeView6;
                                                }
                                                booleanValue = ((Boolean) r0.canceledFollow$delegate.getValue(nBPInteractiveFollowedMeView6, NBPInteractiveFollowedMeView.$$delegatedProperties[1])).booleanValue();
                                                if (!booleanValue) {
                                                    z16 = false;
                                                }
                                                return Boolean.valueOf(z16);
                                            }
                                        };
                                        final NBPInteractiveViewModel nBPInteractiveViewModel5 = nBPInteractiveViewModel4;
                                        final a aVar9 = a.this;
                                        final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView7 = nBPInteractiveFollowedMeView5;
                                        ConditionViewKt.c(vVar6, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView) {
                                                final NBPInteractiveViewModel nBPInteractiveViewModel6 = NBPInteractiveViewModel.this;
                                                final a aVar10 = aVar9;
                                                final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView8 = nBPInteractiveFollowedMeView7;
                                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.3.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionRow();
                                                                tVar2.size(62.0f, 29.0f);
                                                                tVar2.marginTop(12.0f);
                                                                tVar2.marginRight(8.0f);
                                                                tVar2.borderRadius(4.0f);
                                                                tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                                                tVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPInteractiveViewModel nBPInteractiveViewModel7 = NBPInteractiveViewModel.this;
                                                        final a aVar11 = aVar10;
                                                        final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView9 = nBPInteractiveFollowedMeView8;
                                                        vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.3.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                u uVar2 = uVar;
                                                                final NBPInteractiveViewModel nBPInteractiveViewModel8 = NBPInteractiveViewModel.this;
                                                                final a aVar12 = aVar11;
                                                                final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView10 = nBPInteractiveFollowedMeView9;
                                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.3.1.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        boolean booleanValue;
                                                                        s35.af afVar;
                                                                        final NBPInteractiveViewModel nBPInteractiveViewModel9 = NBPInteractiveViewModel.this;
                                                                        if (nBPInteractiveViewModel9 != null) {
                                                                            a aVar13 = aVar12;
                                                                            String valueOf = String.valueOf((aVar13 == null || (afVar = aVar13.f407155h) == null) ? null : Long.valueOf(afVar.f433207e));
                                                                            Function1<q35.b, Unit> function1 = new Function1<q35.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model.NBPInteractiveViewModel$doFollowBack$1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(q35.b bVar) {
                                                                                    NBPInteractiveViewModel nBPInteractiveViewModel10 = NBPInteractiveViewModel.this;
                                                                                    nBPInteractiveViewModel10.mutualFollowText$delegate.setValue(nBPInteractiveViewModel10, NBPInteractiveViewModel.$$delegatedProperties[1], "\u5df2\u5173\u6ce8");
                                                                                    Utils.INSTANCE.currentBridgeModule().qToast("\u5df2\u5173\u6ce8", QToastMode.Success);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            NBPInteractiveViewModel$doFollowBack$2 nBPInteractiveViewModel$doFollowBack$2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model.NBPInteractiveViewModel$doFollowBack$2
                                                                                @Override // kotlin.jvm.functions.Function2
                                                                                public final Unit invoke(Integer num, String str) {
                                                                                    num.intValue();
                                                                                    Utils.INSTANCE.currentBridgeModule().qToast("\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                                                                                    DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("setFollowState: error. msg: ", str, KLog.INSTANCE, "NBPInteractivePage");
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            q35.a aVar14 = new q35.a(QQNearbyModule.Companion.getInstance().getCommonExtInfo(), 1, valueOf, 2);
                                                                            NearbyFollowRepo$setFollowState$1 nearbyFollowRepo$setFollowState$1 = new NearbyFollowRepo$setFollowState$1(2, function1, nBPInteractiveViewModel$doFollowBack$2, valueOf, 1);
                                                                            QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.follow", "SsoDoFollow", 2, new c45.a(i.d(aVar14))));
                                                                            QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(nearbyFollowRepo$setFollowState$1);
                                                                            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
                                                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                            NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
                                                                        }
                                                                        NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView11 = nBPInteractiveFollowedMeView10;
                                                                        nBPInteractiveFollowedMeView11.hasClickFollowBack$delegate.setValue(nBPInteractiveFollowedMeView11, NBPInteractiveFollowedMeView.$$delegatedProperties[0], Boolean.TRUE);
                                                                        NBPInteractiveViewModel nBPInteractiveViewModel10 = NBPInteractiveFollowedMeView.access$getAttr(nBPInteractiveFollowedMeView10).viewModel;
                                                                        if (nBPInteractiveViewModel10 != null) {
                                                                            String str = nBPInteractiveFollowedMeView10.source;
                                                                            KProperty<Object>[] kPropertyArr = NBPInteractiveViewModel.$$delegatedProperties;
                                                                            nBPInteractiveViewModel10.reportInteractive("dt_clck", "em_nearby_backfocus", str, 1);
                                                                        }
                                                                        booleanValue = ((Boolean) r11.canceledFollow$delegate.getValue(nBPInteractiveFollowedMeView10, NBPInteractiveFollowedMeView.$$delegatedProperties[1])).booleanValue();
                                                                        if (booleanValue) {
                                                                            r11.canceledFollow$delegate.setValue(nBPInteractiveFollowedMeView10, NBPInteractiveFollowedMeView.$$delegatedProperties[1], Boolean.valueOf(false));
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView11 = nBPInteractiveFollowedMeView9;
                                                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.3.1.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        NBPInteractiveViewModel nBPInteractiveViewModel9 = NBPInteractiveFollowedMeView.access$getAttr(NBPInteractiveFollowedMeView.this).viewModel;
                                                                        if (nBPInteractiveViewModel9 != null) {
                                                                            String str = NBPInteractiveFollowedMeView.this.source;
                                                                            KProperty<Object>[] kPropertyArr = NBPInteractiveViewModel.$$delegatedProperties;
                                                                            nBPInteractiveViewModel9.reportInteractive("dt_imp", "em_nearby_backfocus", str, 1);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.3.1.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.3.1.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        af afVar2 = afVar;
                                                                        afVar2.size(14.0f, 14.0f);
                                                                        b.a.b(afVar2, QUIToken.INSTANCE.image("mutual_follow", QUIToken.color$default("icon_primary")), false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.3.1.4
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.3.1.4.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.marginLeft(4.0f);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        ceVar2.fontWeight400();
                                                                        ceVar2.text("\u56de\u5173");
                                                                        ceVar2.color(QUIToken.color$default("text_primary"));
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
                                        final NBPInteractiveViewModel nBPInteractiveViewModel6 = nBPInteractiveViewModel4;
                                        final a aVar10 = a.this;
                                        final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView8 = nBPInteractiveFollowedMeView5;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.size(62.0f, 29.0f);
                                                        tVar2.marginTop(12.0f);
                                                        tVar2.borderRadius(4.0f);
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPInteractiveViewModel nBPInteractiveViewModel7 = NBPInteractiveViewModel.this;
                                                final a aVar11 = aVar10;
                                                final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView9 = nBPInteractiveFollowedMeView8;
                                                vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.4.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        u uVar2 = uVar;
                                                        final NBPInteractiveViewModel nBPInteractiveViewModel8 = NBPInteractiveViewModel.this;
                                                        final a aVar12 = aVar11;
                                                        final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView10 = nBPInteractiveFollowedMeView9;
                                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.4.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                String str;
                                                                s35.af afVar;
                                                                String str2;
                                                                s35.af afVar2;
                                                                s35.af afVar3;
                                                                NBPInteractiveViewModel nBPInteractiveViewModel9 = NBPInteractiveViewModel.this;
                                                                if (nBPInteractiveViewModel9 != null) {
                                                                    a aVar13 = aVar12;
                                                                    long j3 = (aVar13 == null || (afVar3 = aVar13.f407155h) == null) ? 0L : afVar3.f433207e;
                                                                    String str3 = "";
                                                                    if (aVar13 == null || (afVar2 = aVar13.f407155h) == null || (str = afVar2.f433209f) == null) {
                                                                        str = "";
                                                                    }
                                                                    if (aVar13 != null && (afVar = aVar13.f407155h) != null && (str2 = afVar.E) != null) {
                                                                        str3 = str2;
                                                                    }
                                                                    QQNearbyModule.Companion.getInstance().launchNearbyAIOFragment(nBPInteractiveViewModel9.pageData.n().j("key_from"), String.valueOf(j3), str, str3);
                                                                }
                                                                NBPInteractiveViewModel nBPInteractiveViewModel10 = NBPInteractiveFollowedMeView.access$getAttr(nBPInteractiveFollowedMeView10).viewModel;
                                                                if (nBPInteractiveViewModel10 != null) {
                                                                    String str4 = nBPInteractiveFollowedMeView10.source;
                                                                    KProperty<Object>[] kPropertyArr = NBPInteractiveViewModel.$$delegatedProperties;
                                                                    nBPInteractiveViewModel10.reportInteractive("dt_clck", "em_nearby_chat", str4, 1);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView11 = nBPInteractiveFollowedMeView9;
                                                        VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.4.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPInteractiveViewModel nBPInteractiveViewModel9 = NBPInteractiveFollowedMeView.access$getAttr(NBPInteractiveFollowedMeView.this).viewModel;
                                                                if (nBPInteractiveViewModel9 != null) {
                                                                    String str = NBPInteractiveFollowedMeView.this.source;
                                                                    KProperty<Object>[] kPropertyArr = NBPInteractiveViewModel.$$delegatedProperties;
                                                                    nBPInteractiveViewModel9.reportInteractive("dt_imp", "em_nearby_chat", str, 1);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.4.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.4.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(14.0f, 14.0f);
                                                                b.a.b(afVar2, QUIToken.INSTANCE.image("message", QUIToken.color$default("icon_primary")), false, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.4.4
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.3.3.3.4.4.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginLeft(4.0f);
                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                ceVar2.fontWeight400();
                                                                ceVar2.text("\u804a\u5929");
                                                                ceVar2.color(QUIToken.color$default("text_primary"));
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
                final float f17 = m3;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final float f18 = f17;
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView.body.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.positionAbsolute();
                                tVar2.m140flex(1.0f);
                                tVar2.m138bottom(0.0f);
                                tVar2.m142left(0.0f);
                                tVar2.mo141height(0.5f);
                                tVar2.mo153width(f18);
                                tVar2.mo113backgroundColor(QUIToken.color$default("border_standard"));
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
        return new NBPInteractiveFollowedMeViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPInteractiveFollowedMeViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        k.b((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_HOMEPAGE_FOLLOW_STATUS_CHANGED", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView$created$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                s35.af afVar;
                boolean booleanValue;
                s35.af afVar2;
                e eVar2 = eVar;
                if (eVar2 != null) {
                    String p16 = eVar2.p("accountId");
                    boolean f16 = eVar2.f("doFollow");
                    KLog.INSTANCE.i("NBPInteractiveFollowedMeView", "homepage changed followStatus id:" + p16 + ", doFollow: " + f16);
                    a aVar = NBPInteractiveFollowedMeView.access$getAttr(NBPInteractiveFollowedMeView.this).followData;
                    Long l3 = null;
                    if (Intrinsics.areEqual(p16, String.valueOf((aVar == null || (afVar2 = aVar.f407155h) == null) ? null : Long.valueOf(afVar2.f433207e))) && f16) {
                        NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView = NBPInteractiveFollowedMeView.this;
                        nBPInteractiveFollowedMeView.hasClickFollowBack$delegate.setValue(nBPInteractiveFollowedMeView, NBPInteractiveFollowedMeView.$$delegatedProperties[0], Boolean.TRUE);
                        booleanValue = ((Boolean) r1.canceledFollow$delegate.getValue(NBPInteractiveFollowedMeView.this, NBPInteractiveFollowedMeView.$$delegatedProperties[1])).booleanValue();
                        if (booleanValue) {
                            r1.canceledFollow$delegate.setValue(NBPInteractiveFollowedMeView.this, NBPInteractiveFollowedMeView.$$delegatedProperties[1], Boolean.valueOf(false));
                        }
                    }
                    a aVar2 = NBPInteractiveFollowedMeView.access$getAttr(NBPInteractiveFollowedMeView.this).followData;
                    if (aVar2 != null && (afVar = aVar2.f407155h) != null) {
                        l3 = Long.valueOf(afVar.f433207e);
                    }
                    if (Intrinsics.areEqual(p16, String.valueOf(l3)) && !f16) {
                        r8.canceledFollow$delegate.setValue(NBPInteractiveFollowedMeView.this, NBPInteractiveFollowedMeView.$$delegatedProperties[1], Boolean.valueOf(true));
                    }
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }
}
