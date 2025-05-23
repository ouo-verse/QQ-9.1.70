package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view;

import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import com.tencent.hippykotlin.demo.pages.foundation.view.DynamicAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.VasDynamicView;
import com.tencent.hippykotlin.demo.pages.foundation.view.VasDynamicViewKt;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.SchemaBuilder;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.Tracker;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerKt;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerView;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerViewAttr;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerViewEvent;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.ParamExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class FuncModItem extends ComposeView<FuncModItemAttr, l> {
    public FuncModItem(VasBasePage vasBasePage) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FuncModItemAttr access$getAttr(FuncModItem funcModItem) {
        return (FuncModItemAttr) funcModItem.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final FuncModItem funcModItem = FuncModItem.this;
                VipTrackerKt.VipTracker(viewContainer, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(VipTrackerView vipTrackerView) {
                        final VipTrackerView vipTrackerView2 = vipTrackerView;
                        final FuncModItem funcModItem2 = FuncModItem.this;
                        vipTrackerView2.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                String encodeURIComponent = UriKt.encodeURIComponent(FuncModItem.access$getAttr(FuncModItem.this).data.getUrl());
                                Tracker tracker = vipTrackerViewAttr2.tracker;
                                tracker.itemId = encodeURIComponent;
                                tracker.itemType = "2";
                                vipTrackerViewAttr2.mo153width(FuncModItem.access$getAttr(FuncModItem.this).itemWidth);
                                vipTrackerViewAttr2.flexDirectionRow();
                                vipTrackerViewAttr2.alignItemsCenter();
                                vipTrackerViewAttr2.accessibility(FuncModItem.access$getAttr(FuncModItem.this).data.getTitle() + TokenParser.SP + FuncModItem.access$getAttr(FuncModItem.this).data.getDesc());
                                return Unit.INSTANCE;
                            }
                        });
                        final FuncModItem funcModItem3 = FuncModItem.this;
                        VasDynamicViewKt.VasDynamicImg(vipTrackerView2, new Function1<VasDynamicView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(VasDynamicView vasDynamicView) {
                                final FuncModItem funcModItem4 = FuncModItem.this;
                                vasDynamicView.attr(new Function1<DynamicAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(DynamicAttr dynamicAttr) {
                                        DynamicAttr dynamicAttr2 = dynamicAttr;
                                        dynamicAttr2.marginLeft(10.0f);
                                        dynamicAttr2.size(44.0f, 44.0f);
                                        dynamicAttr2.with("sceneTag", "shop");
                                        dynamicAttr2.with("src", FuncModItem.access$getAttr(FuncModItem.this).data.getIcon());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final FuncModItem funcModItem4 = FuncModItem.this;
                        w.a(vipTrackerView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.flexDirectionColumn();
                                        tVar2.marginLeft(8.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final FuncModItem funcModItem5 = FuncModItem.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final FuncModItem funcModItem6 = FuncModItem.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h hVar;
                                                ce ceVar2 = ceVar;
                                                ceVar2.text(FuncModItem.access$getAttr(FuncModItem.this).data.getTitle());
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                    hVar = new h(4279901214L);
                                                } else {
                                                    hVar = new h(4293980404L);
                                                }
                                                ceVar2.color(hVar);
                                                ceVar2.fontWeightBold();
                                                ceVar2.lines(1);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final FuncModItem funcModItem6 = FuncModItem.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem.body.1.1.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final FuncModItem funcModItem7 = FuncModItem.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem.body.1.1.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h hVar;
                                                ce ceVar2 = ceVar;
                                                ceVar2.text(FuncModItem.access$getAttr(FuncModItem.this).data.getDesc());
                                                ceVar2.marginTop(4.0f);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                    hVar = new h(4287664276L);
                                                } else {
                                                    hVar = new h(4287664276L);
                                                }
                                                ceVar2.color(hVar);
                                                ceVar2.lines(1);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final FuncModItem funcModItem5 = FuncModItem.this;
                        vipTrackerView2.event(new Function1<VipTrackerViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem.body.1.1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(VipTrackerViewEvent vipTrackerViewEvent) {
                                final FuncModItem funcModItem6 = FuncModItem.this;
                                final VipTrackerView vipTrackerView3 = vipTrackerView2;
                                vipTrackerViewEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem.body.1.1.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Function1<? super SchemaBuilder.TraceDetailInfo, Unit> function1 = FuncModItem.access$getAttr(FuncModItem.this).click;
                                        if (function1 != null) {
                                            function1.invoke(ParamExtKt.getTraceDetailInfo(vipTrackerView3));
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new FuncModItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
