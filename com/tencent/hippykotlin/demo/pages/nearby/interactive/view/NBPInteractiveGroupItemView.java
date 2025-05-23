package com.tencent.hippykotlin.demo.pages.nearby.interactive.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyFormatUtils;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model.NBPInteractiveViewModel;
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
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import i35.b;
import i35.d;
import i35.e;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPInteractiveGroupItemView extends ComposeView<NBPInteractiveGroupItemViewAttr, NBPInteractiveGroupItemViewEvent> {
    public final FastClickUtils fastClickUtils = new FastClickUtils(500);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPInteractiveGroupItemViewAttr access$getAttr(NBPInteractiveGroupItemView nBPInteractiveGroupItemView) {
        return (NBPInteractiveGroupItemViewAttr) nBPInteractiveGroupItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        d dVar;
        c<b> interactiveMsgList;
        NBPInteractiveViewModel nBPInteractiveViewModel = ((NBPInteractiveGroupItemViewAttr) getAttr()).viewModel;
        i35.c cVar = null;
        final b bVar = (nBPInteractiveViewModel == null || (interactiveMsgList = nBPInteractiveViewModel.getInteractiveMsgList()) == null) ? null : interactiveMsgList.get(((NBPInteractiveGroupItemViewAttr) getAttr()).index);
        if (bVar != null && (dVar = bVar.f407159f) != null) {
            cVar = dVar.f407169e;
        }
        final i35.c cVar2 = cVar;
        final float m3 = getPagerData().m() - 32.0f;
        final String q16 = com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().n().q("source", "1");
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final float f16 = m3;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView$body$1.1
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
                        mVar2.positionRelative();
                        return Unit.INSTANCE;
                    }
                });
                final NBPInteractiveGroupItemView nBPInteractiveGroupItemView = this;
                final String str = q16;
                final i35.c cVar3 = cVar2;
                final b bVar2 = bVar;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        Event event2 = event;
                        final NBPInteractiveGroupItemView nBPInteractiveGroupItemView2 = NBPInteractiveGroupItemView.this;
                        final String str2 = str;
                        final i35.c cVar4 = cVar3;
                        final b bVar3 = bVar2;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                e eVar;
                                if (!NBPInteractiveGroupItemView.this.fastClickUtils.isFastDoubleClick()) {
                                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearbypro_interactive_users_page&source=");
                                    m16.append(str2);
                                    m16.append("&modal_mode=1&mid=");
                                    i35.c cVar5 = cVar4;
                                    m16.append(cVar5 != null ? Integer.valueOf(cVar5.f407163d) : null);
                                    m16.append("&red_id=");
                                    b bVar4 = bVar3;
                                    m16.append((bVar4 == null || (eVar = bVar4.C) == null) ? null : Integer.valueOf(eVar.f407171d));
                                    m16.append("&icon=");
                                    i35.c cVar6 = cVar4;
                                    m16.append(cVar6 != null ? cVar6.f407166h : null);
                                    m16.append("&title=");
                                    i35.c cVar7 = cVar4;
                                    m16.append(cVar7 != null ? cVar7.f407164e : null);
                                    String sb5 = m16.toString();
                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                    QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
                                    NBPInteractiveViewModel nBPInteractiveViewModel2 = NBPInteractiveGroupItemView.access$getAttr(NBPInteractiveGroupItemView.this).viewModel;
                                    if (nBPInteractiveViewModel2 != null) {
                                        String str3 = str2;
                                        i35.c cVar8 = cVar4;
                                        nBPInteractiveViewModel2.reportInteractive("dt_clck", "em_nearby_to_view", str3, cVar8 != null ? Integer.valueOf(cVar8.f407163d) : null);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPInteractiveGroupItemView nBPInteractiveGroupItemView3 = NBPInteractiveGroupItemView.this;
                        final String str3 = str;
                        final i35.c cVar5 = cVar3;
                        VisibilityEventKt.b(event2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                NBPInteractiveViewModel nBPInteractiveViewModel2 = NBPInteractiveGroupItemView.access$getAttr(NBPInteractiveGroupItemView.this).viewModel;
                                if (nBPInteractiveViewModel2 != null) {
                                    String str4 = str3;
                                    i35.c cVar6 = cVar5;
                                    nBPInteractiveViewModel2.reportInteractive("dt_imp", "em_nearby_to_view", str4, cVar6 != null ? Integer.valueOf(cVar6.f407163d) : null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final i35.c cVar4 = cVar2;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m142left(-4.0f);
                                tVar2.m150top(22.0f);
                                tVar2.size(43.0f, 35.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final i35.c cVar5 = i35.c.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.3.2
                            {
                                super(0);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
                            
                                if (r0.size() == 1) goto L10;
                             */
                            @Override // kotlin.jvm.functions.Function0
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object invoke() {
                                i35.c cVar6 = i35.c.this;
                                boolean z16 = (cVar6 == null || (r0 = cVar6.f407167i) == null) ? false : true;
                                return Boolean.valueOf(z16);
                            }
                        };
                        final i35.c cVar6 = i35.c.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final i35.c cVar7 = i35.c.this;
                                ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final i35.c cVar8 = i35.c.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.3.3.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                List<String> list;
                                                Object first;
                                                af afVar2 = afVar;
                                                afVar2.positionAbsolute();
                                                afVar2.m142left(4.0f);
                                                afVar2.size(32.0f, 32.0f);
                                                afVar2.p();
                                                afVar2.borderRadius(16.0f);
                                                i35.c cVar9 = i35.c.this;
                                                if (cVar9 != null && (list = cVar9.f407167i) != null) {
                                                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                                                    String str2 = (String) first;
                                                    if (str2 != null) {
                                                        b.a.b(afVar2, str2, false, 2, null);
                                                    }
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
                        final i35.c cVar7 = i35.c.this;
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.3.4
                            {
                                super(1);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
                            
                                r0 = kotlin.collections.CollectionsKt___CollectionsKt.take(r0, 2);
                             */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(ConditionView conditionView) {
                                List take;
                                ConditionView conditionView2 = conditionView;
                                i35.c cVar8 = i35.c.this;
                                if (cVar8 != null && (r0 = cVar8.f407167i) != null && take != null) {
                                    final int i3 = 0;
                                    for (Object obj : take) {
                                        int i16 = i3 + 1;
                                        if (i3 < 0) {
                                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                                        }
                                        final String str2 = (String) obj;
                                        ah.a(conditionView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView$body$1$3$4$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final int i17 = i3;
                                                final String str3 = str2;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView$body$1$3$4$1$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.positionAbsolute();
                                                        if (i17 == 0) {
                                                            afVar2.m142left(0.0f);
                                                            afVar2.m150top(0.0f);
                                                        } else {
                                                            afVar2.m149right(0.0f);
                                                            afVar2.m138bottom(0.0f);
                                                        }
                                                        afVar2.m154zIndex(i17 == 0 ? 1 : 0);
                                                        afVar2.size(28.0f, 28.0f);
                                                        afVar2.p();
                                                        afVar2.borderRadius(14.0f);
                                                        b.a.b(afVar2, str3, false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        i3 = i16;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final i35.c cVar5 = cVar2;
                final NBPInteractiveGroupItemView nBPInteractiveGroupItemView2 = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginLeft(9.0f);
                                tVar2.marginTop(19.0f);
                                tVar2.marginBottom(16.0f);
                                tVar2.flexDirectionColumn();
                                tVar2.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final i35.c cVar6 = i35.c.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final i35.c cVar7 = i35.c.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str2;
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        i35.c cVar8 = i35.c.this;
                                        if (cVar8 != null && (str2 = cVar8.f407164e) != null) {
                                            ceVar2.text(str2);
                                        }
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        ceVar2.textPostProcessor("emoji");
                                        ceVar2.fontWeight500();
                                        ceVar2.lineHeight(20.0f);
                                        ceVar2.lines(1);
                                        ceVar2.textOverFlowTail();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final i35.c cVar7 = i35.c.this;
                        final NBPInteractiveGroupItemView nBPInteractiveGroupItemView3 = nBPInteractiveGroupItemView2;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.4.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final i35.c cVar8 = i35.c.this;
                                final NBPInteractiveGroupItemView nBPInteractiveGroupItemView4 = nBPInteractiveGroupItemView3;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.4.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str2;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(4.0f);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        i35.c cVar9 = i35.c.this;
                                        if (cVar9 != null && (str2 = cVar9.f407165f) != null) {
                                            ceVar2.text(str2);
                                        }
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        ceVar2.textPostProcessor("emoji");
                                        ceVar2.fontWeight400();
                                        ceVar2.lineHeight(20.0f);
                                        ceVar2.lines(2);
                                        ceVar2.textOverFlowTail();
                                        ceVar2.m144maxWidth(nBPInteractiveGroupItemView4.getPagerData().l() - 147.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        com.tencent.kuikly.core.views.compose.c.a(vVar2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.4.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ButtonView buttonView) {
                                buttonView.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.4.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(a aVar) {
                                        a aVar2 = aVar;
                                        aVar2.marginTop(9.0f);
                                        aVar2.mo153width(74.0f);
                                        aVar2.mo141height(29.0f);
                                        aVar2.borderRadius(4.0f);
                                        aVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                        aVar2.alignItemsCenter();
                                        aVar2.m(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.4.4.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_BLGb-IgZvXq.png", false, 2, null);
                                                afVar2.size(14.0f, 14.0f);
                                                afVar2.t(QUIToken.color$default("icon_primary"));
                                                afVar2.alignSelfCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.4.4.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u53bb\u770b\u770b");
                                                ceVar2.fontWeight400();
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.lineHeight(20.0f);
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
                final i35.c cVar6 = cVar2;
                final i35.b bVar3 = bVar;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView$body$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final String str2;
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexWrapWrap();
                                tVar2.flexDirectionColumn();
                                tVar2.m149right(0.0f);
                                tVar2.m142left(7.0f);
                                tVar2.marginTop(20.0f);
                                tVar2.marginBottom(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final i35.b bVar4 = bVar3;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final i35.b bVar5 = i35.b.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.5.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        i35.b bVar6 = i35.b.this;
                                        if (bVar6 != null) {
                                            String formatStateItemTime = NearbyFormatUtils.INSTANCE.formatStateItemTime(bVar6.f407160h * 1000);
                                            if (formatStateItemTime.length() <= 5) {
                                                formatStateItemTime = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("\u4eca\u5929 ", formatStateItemTime);
                                            }
                                            ceVar2.text(formatStateItemTime);
                                        }
                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.lineHeight(17.0f);
                                        ceVar2.m149right(0.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        i35.c cVar7 = i35.c.this;
                        if (cVar7 != null && (str2 = cVar7.f407166h) != null) {
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView$body$1$5$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    final String str3 = str2;
                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView$body$1$5$3$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            afVar2.m149right(0.0f);
                                            afVar2.marginTop(8.0f);
                                            afVar2.size(60.0f, 60.0f);
                                            afVar2.p();
                                            afVar2.borderRadius(4.0f);
                                            b.a.b(afVar2, str3, false, 2, null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                });
                final float f17 = m3;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView$body$1.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final float f18 = f17;
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView.body.1.6.1
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
        return new NBPInteractiveGroupItemViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPInteractiveGroupItemViewEvent();
    }
}
