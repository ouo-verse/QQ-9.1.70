package com.tencent.hippykotlin.demo.pages.nearby.city_walk.view;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyFormatUtils;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.j;
import n25.k;
import n25.l;
import n35.z;

/* loaded from: classes31.dex */
public final class NBPCityWalkSelectPageItemView extends ComposeView<NBPCityWalkItemViewAttr, NBPCityWalkItemViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPCityWalkItemViewAttr access$getAttr(NBPCityWalkSelectPageItemView nBPCityWalkSelectPageItemView) {
        return (NBPCityWalkItemViewAttr) nBPCityWalkSelectPageItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final l lVar = ((NBPCityWalkItemViewAttr) getAttr()).statusFeed;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusFeed");
            lVar = null;
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPCityWalkSelectPageItemView nBPCityWalkSelectPageItemView = NBPCityWalkSelectPageItemView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width((mVar2.getPagerData().m() / 2) - 4.0f);
                        NBPCityWalkItemViewAttr access$getAttr = NBPCityWalkSelectPageItemView.access$getAttr(NBPCityWalkSelectPageItemView.this);
                        if (((Boolean) access$getAttr.isLineFirst$delegate.getValue(access$getAttr, NBPCityWalkItemViewAttr.$$delegatedProperties[0])).booleanValue()) {
                            mVar2.alignItemsFlexEnd();
                        } else {
                            mVar2.alignItemsFlexStart();
                        }
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkSelectPageItemView nBPCityWalkSelectPageItemView2 = NBPCityWalkSelectPageItemView.this;
                final l lVar2 = lVar;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPCityWalkSelectPageItemView nBPCityWalkSelectPageItemView3 = NBPCityWalkSelectPageItemView.this;
                        final l lVar3 = lVar2;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                boolean z16 = NBPCityWalkSelectPageItemView.access$getAttr(NBPCityWalkSelectPageItemView.this).getViewModel().getChooseList().indexOf(lVar3) != -1;
                                NBPCityWalkViewModel viewModel = NBPCityWalkSelectPageItemView.access$getAttr(NBPCityWalkSelectPageItemView.this).getViewModel();
                                l lVar4 = lVar3;
                                if (!z16) {
                                    if (viewModel.getChooseList().size() >= 9) {
                                        Utils.INSTANCE.currentBridgeModule().toast("\u6700\u591a\u9009\u62e99\u6761\u8db3\u8ff9\u54e6");
                                    } else {
                                        viewModel.getChooseList().add(lVar4);
                                    }
                                } else {
                                    viewModel.getChooseList().remove(lVar4);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final l lVar3 = lVar;
                final NBPCityWalkSelectPageItemView nBPCityWalkSelectPageItemView3 = NBPCityWalkSelectPageItemView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(167.0f);
                                tVar2.mo141height(201.0f);
                                tVar2.flexDirectionColumn();
                                tVar2.borderRadius(8.0f);
                                tVar2.mo113backgroundColor(new h(16777215L, 1.0f));
                                tVar2.mo139boxShadow(new g(0.0f, 2.0f, 2.0f, new h(0L, 0.08f)));
                                return Unit.INSTANCE;
                            }
                        });
                        final l lVar4 = l.this;
                        final NBPCityWalkSelectPageItemView nBPCityWalkSelectPageItemView4 = nBPCityWalkSelectPageItemView3;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(167.0f, 167.0f);
                                        tVar2.flexDirectionColumn();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final l lVar5 = l.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final l lVar6 = l.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                Object firstOrNull;
                                                n35.v vVar5;
                                                n35.w wVar;
                                                List<z> list;
                                                Object firstOrNull2;
                                                af afVar2 = afVar;
                                                afVar2.positionAbsolute();
                                                afVar2.m142left(0.0f);
                                                afVar2.m150top(0.0f);
                                                afVar2.m149right(0.0f);
                                                afVar2.m138bottom(0.0f);
                                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) l.this.f418097m);
                                                j jVar = (j) firstOrNull;
                                                if (jVar != null && (wVar = jVar.f418083d) != null && (list = wVar.f418273d) != null) {
                                                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                                                    z zVar = (z) firstOrNull2;
                                                    if (zVar != null) {
                                                        vVar5 = zVar.f418280d;
                                                        NearbyProKtxKt.srcWithIndexNode(afVar2, vVar5);
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                                vVar5 = null;
                                                NearbyProKtxKt.srcWithIndexNode(afVar2, vVar5);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.positionAbsolute();
                                                tVar2.m142left(0.0f);
                                                tVar2.m138bottom(0.0f);
                                                tVar2.mo153width(167.0f);
                                                tVar2.mo141height(42.0f);
                                                tVar2.mo135backgroundLinearGradient(Direction.TO_TOP, new com.tencent.kuikly.core.base.j(new h(4281545523L), 0.0f), new com.tencent.kuikly.core.base.j(new h(5131854L), 1.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkSelectPageItemView nBPCityWalkSelectPageItemView5 = nBPCityWalkSelectPageItemView4;
                                final l lVar6 = l.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(24.0f, 24.0f);
                                                tVar2.positionAbsolute();
                                                tVar2.m142left(8.0f);
                                                tVar2.m150top(8.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCityWalkSelectPageItemView nBPCityWalkSelectPageItemView6 = NBPCityWalkSelectPageItemView.this;
                                        final l lVar7 = lVar6;
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.4.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NBPCityWalkSelectPageItemView nBPCityWalkSelectPageItemView7 = NBPCityWalkSelectPageItemView.this;
                                                final l lVar8 = lVar7;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.4.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        String str;
                                                        af afVar2 = afVar;
                                                        afVar2.m140flex(1.0f);
                                                        if (NBPCityWalkSelectPageItemView.access$getAttr(NBPCityWalkSelectPageItemView.this).getViewModel().getChooseList().indexOf(lVar8) != -1) {
                                                            str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_WQfAvA8QxLC.png";
                                                        } else {
                                                            str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_9TX3pi1Dxpj.png";
                                                        }
                                                        b.a.b(afVar2, str, false, 2, null);
                                                        afVar2.p();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCityWalkSelectPageItemView nBPCityWalkSelectPageItemView7 = NBPCityWalkSelectPageItemView.this;
                                        final l lVar8 = lVar6;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.4.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPCityWalkSelectPageItemView nBPCityWalkSelectPageItemView8 = NBPCityWalkSelectPageItemView.this;
                                                final l lVar9 = lVar8;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.4.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.color(new h(16777215L, 1.0f));
                                                        ceVar2.textAlignCenter();
                                                        ceVar2.lineHeight(22.0f);
                                                        int indexOf = NBPCityWalkSelectPageItemView.access$getAttr(NBPCityWalkSelectPageItemView.this).getViewModel().getChooseList().indexOf(lVar9);
                                                        if (indexOf != -1) {
                                                            str = String.valueOf(indexOf + 1);
                                                        } else {
                                                            str = " ";
                                                        }
                                                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("text, ", str, KLog.INSTANCE, "NBPCityWalkSelectPageItemView");
                                                        ceVar2.text(str);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final l lVar7 = l.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                tVar2.positionAbsolute();
                                                tVar2.m142left(6.0f);
                                                tVar2.m138bottom(27.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.5.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.5.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(14.0f, 14.0f);
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_hVogM16l2TC.png", false, 2, null);
                                                        afVar2.p();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final l lVar8 = l.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.5.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final l lVar9 = l.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.5.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text(NearbyFormatUtils.INSTANCE.formatStateItemTime(l.this.D * 1000));
                                                        ceVar2.color(new h(16777215L, 1.0f));
                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                        ceVar2.lines(1);
                                                        ceVar2.textOverFlowTail();
                                                        ceVar2.m140flex(1.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final k kVar = l.this.C;
                                if (kVar != null) {
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.6
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            v vVar6 = vVar5;
                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.6.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.flexDirectionRow();
                                                    tVar2.marginTop(8.0f);
                                                    tVar2.alignItemsCenter();
                                                    tVar2.positionAbsolute();
                                                    tVar2.m142left(6.0f);
                                                    tVar2.m138bottom(8.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.6.2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.6.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            afVar2.size(14.0f, 14.0f);
                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Vplnmw9WlIG.png", false, 2, null);
                                                            afVar2.p();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final k kVar2 = k.this;
                                            cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.6.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final k kVar3 = k.this;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.2.6.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.mo153width(140.0f);
                                                            ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                            ceVar2.lines(1);
                                                            ceVar2.color(new h(16777215L, 1.0f));
                                                            ceVar2.textOverFlowTail();
                                                            ceVar2.text(k.this.Q);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
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
                        final l lVar5 = l.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final l lVar6 = l.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectPageItemView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.fontFamily("PingFang SC");
                                        ceVar2.color(new h(4278190080L));
                                        ceVar2.marginLeft(8.0f);
                                        ceVar2.marginRight(8.0f);
                                        ceVar2.lineHeight(34.0f);
                                        ceVar2.lines(1);
                                        ceVar2.textOverFlowTail();
                                        ceVar2.textPostProcessor("emoji");
                                        l lVar7 = l.this;
                                        byte[] bArr = lVar7.f418096i.f30291a;
                                        if (true ^ (bArr.length == 0)) {
                                            str = StringsKt__StringsJVMKt.decodeToString(bArr);
                                        } else {
                                            q25.g gVar = lVar7.f418094f;
                                            if (gVar == null || (str = gVar.f428259f) == null) {
                                                str = "";
                                            }
                                        }
                                        ceVar2.text(str);
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
        return new NBPCityWalkItemViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPCityWalkItemViewEvent();
    }
}
