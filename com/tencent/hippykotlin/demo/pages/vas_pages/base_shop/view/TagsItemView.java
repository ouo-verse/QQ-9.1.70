package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
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
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.TagsItemData;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class TagsItemView extends ComposeView<TagsItemAttr, l> {
    public final VasBasePage page;

    public TagsItemView(VasBasePage vasBasePage) {
        this.page = vasBasePage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TagsItemAttr access$getAttr(TagsItemView tagsItemView) {
        return (TagsItemAttr) tagsItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final VasBasePage vasBasePage = this.page;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final TagsItemView tagsItemView = TagsItemView.this;
                final VasBasePage vasBasePage2 = vasBasePage;
                VipTrackerKt.VipTracker(viewContainer, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(VipTrackerView vipTrackerView) {
                        VipTrackerView vipTrackerView2 = vipTrackerView;
                        vipTrackerView2.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                vipTrackerViewAttr2.tracker.moduleId = "18";
                                vipTrackerViewAttr2.tracker.expose = true;
                                return Unit.INSTANCE;
                            }
                        });
                        final TagsItemView tagsItemView2 = TagsItemView.this;
                        final VasBasePage vasBasePage3 = vasBasePage2;
                        w.a(vipTrackerView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final TagsItemView tagsItemView3 = TagsItemView.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(TagsItemView.access$getAttr(TagsItemView.this).itemWidth);
                                        tVar2.marginTop(20.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentSpaceBetween();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h hVar;
                                                ce ceVar2 = ceVar;
                                                if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                    hVar = new h(4279901214L);
                                                } else {
                                                    hVar = new h(4293980404L);
                                                }
                                                ceVar2.color(hVar);
                                                ceVar2.text("\u7cbe\u54c1\u5206\u7c7b");
                                                ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                                ceVar2.fontWeightBold();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TagsItemView tagsItemView4 = TagsItemView.this;
                                final VasBasePage vasBasePage4 = vasBasePage3;
                                VipTrackerKt.VipTracker(vVar2, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(VipTrackerView vipTrackerView3) {
                                        final VipTrackerView vipTrackerView4 = vipTrackerView3;
                                        vipTrackerView4.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                Tracker tracker = vipTrackerViewAttr.tracker;
                                                tracker.itemId = "All";
                                                tracker.itemType = "4";
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vipTrackerView4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.2.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.2.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        h hVar;
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u67e5\u770b\u5168\u90e8");
                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                        if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                            hVar = new h(4281169893L);
                                                        } else {
                                                            hVar = new h(4281169893L);
                                                        }
                                                        ceVar2.color(hVar);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TagsItemView tagsItemView5 = TagsItemView.this;
                                        final VasBasePage vasBasePage5 = vasBasePage4;
                                        vipTrackerView4.event(new Function1<VipTrackerViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.2.3.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VipTrackerViewEvent vipTrackerViewEvent) {
                                                final VipTrackerView vipTrackerView5 = VipTrackerView.this;
                                                final TagsItemView tagsItemView6 = tagsItemView5;
                                                final VasBasePage vasBasePage6 = vasBasePage5;
                                                vipTrackerViewEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.2.3.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        final SchemaBuilder.TraceDetailInfo traceDetailInfo = ParamExtKt.getTraceDetailInfo(VipTrackerView.this);
                                                        String addTraceDetailByInfo = SchemaBuilder.INSTANCE.addTraceDetailByInfo(TagsItemView.access$getAttr(tagsItemView6).data.jumpAllUrl, new Function0<SchemaBuilder.TraceDetailInfo>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView$body$1$1$2$3$3$1$result$1
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final SchemaBuilder.TraceDetailInfo invoke() {
                                                                return SchemaBuilder.TraceDetailInfo.this;
                                                            }
                                                        });
                                                        vasBasePage6.platformApi.getVasModule().openPage(addTraceDetailByInfo);
                                                        VasBasePage vasBasePage7 = vasBasePage6;
                                                        KLog.INSTANCE.i(vasBasePage7.getPageName(), AgreementConsentViewKt$$ExternalSyntheticOutline0.m("user click \u67e5\u770b\u5168\u90e8 , result: ", addTraceDetailByInfo));
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
                        final TagsItemView tagsItemView3 = TagsItemView.this;
                        final VasBasePage vasBasePage4 = vasBasePage2;
                        w.a(vipTrackerView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final TagsItemView tagsItemView4 = TagsItemView.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(TagsItemView.access$getAttr(TagsItemView.this).itemWidth);
                                        tVar2.flexDirectionRow();
                                        tVar2.flexWrapWrap();
                                        tVar2.justifyContentSpaceBetween();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final float f16 = (TagsItemView.access$getAttr(TagsItemView.this).itemWidth - 30) / 4;
                                final TagsItemView tagsItemView5 = TagsItemView.this;
                                Function0<c<TagsItemData.TagInfo>> function0 = new Function0<c<TagsItemData.TagInfo>>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final c<TagsItemData.TagInfo> invoke() {
                                        return TagsItemView.access$getAttr(TagsItemView.this).data.getTags();
                                    }
                                };
                                final VasBasePage vasBasePage5 = vasBasePage4;
                                LoopDirectivesViewKt.a(vVar2, function0, new Function2<LoopDirectivesView<TagsItemData.TagInfo>, TagsItemData.TagInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<TagsItemData.TagInfo> loopDirectivesView, TagsItemData.TagInfo tagInfo) {
                                        final TagsItemData.TagInfo tagInfo2 = tagInfo;
                                        final float f17 = f16;
                                        final VasBasePage vasBasePage6 = vasBasePage5;
                                        VipTrackerKt.VipTracker(loopDirectivesView, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VipTrackerView vipTrackerView3) {
                                                final VipTrackerView vipTrackerView4 = vipTrackerView3;
                                                final float f18 = f17;
                                                final TagsItemData.TagInfo tagInfo3 = tagInfo2;
                                                vipTrackerView4.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.3.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                        VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                                        float f19 = f18;
                                                        vipTrackerViewAttr2.size(f19, f19);
                                                        vipTrackerViewAttr2.justifyContentCenter();
                                                        vipTrackerViewAttr2.alignItemsCenter();
                                                        vipTrackerViewAttr2.marginTop(10.0f);
                                                        String valueOf = String.valueOf(tagInfo3.name);
                                                        Tracker tracker = vipTrackerViewAttr2.tracker;
                                                        tracker.itemId = valueOf;
                                                        tracker.itemType = "4";
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TagsItemData.TagInfo tagInfo4 = tagInfo2;
                                                VasDynamicViewKt.VasDynamicImg(vipTrackerView4, new Function1<VasDynamicView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.3.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VasDynamicView vasDynamicView) {
                                                        final TagsItemData.TagInfo tagInfo5 = TagsItemData.TagInfo.this;
                                                        vasDynamicView.attr(new Function1<DynamicAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.3.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(DynamicAttr dynamicAttr) {
                                                                DynamicAttr dynamicAttr2 = dynamicAttr;
                                                                dynamicAttr2.positionAbsolute();
                                                                dynamicAttr2.m142left(0.0f);
                                                                dynamicAttr2.m150top(0.0f);
                                                                dynamicAttr2.m149right(0.0f);
                                                                dynamicAttr2.m138bottom(0.0f);
                                                                dynamicAttr2.with("sceneTag", "shop");
                                                                dynamicAttr2.with("scaleType", "aspectFill");
                                                                dynamicAttr2.with("src", TagsItemData.TagInfo.this.iconUrl);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(vipTrackerView4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.3.1.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.3.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.positionAbsolute();
                                                                tVar2.m142left(0.0f);
                                                                tVar2.m150top(0.0f);
                                                                tVar2.m149right(0.0f);
                                                                tVar2.m138bottom(0.0f);
                                                                tVar2.borderRadius(4.0f);
                                                                tVar2.backgroundColor(h.INSTANCE.o("0x88000000"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TagsItemData.TagInfo tagInfo5 = tagInfo2;
                                                cg.a(vipTrackerView4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.3.1.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final TagsItemData.TagInfo tagInfo6 = TagsItemData.TagInfo.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.3.1.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(TagsItemData.TagInfo.this.name);
                                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                ceVar2.color(h.INSTANCE.m());
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TagsItemData.TagInfo tagInfo6 = tagInfo2;
                                                final VasBasePage vasBasePage7 = vasBasePage6;
                                                vipTrackerView4.event(new Function1<VipTrackerViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.3.1.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VipTrackerViewEvent vipTrackerViewEvent) {
                                                        final TagsItemData.TagInfo tagInfo7 = TagsItemData.TagInfo.this;
                                                        final VasBasePage vasBasePage8 = vasBasePage7;
                                                        final VipTrackerView vipTrackerView5 = vipTrackerView4;
                                                        vipTrackerViewEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView.body.1.1.3.3.1.5.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                SchemaBuilder schemaBuilder = SchemaBuilder.INSTANCE;
                                                                String str = TagsItemData.TagInfo.this.jumpUrl;
                                                                final VipTrackerView vipTrackerView6 = vipTrackerView5;
                                                                String addTraceDetailByInfo = schemaBuilder.addTraceDetailByInfo(str, new Function0<SchemaBuilder.TraceDetailInfo>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView$body$1$1$3$3$1$5$1$result$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final SchemaBuilder.TraceDetailInfo invoke() {
                                                                        return ParamExtKt.getTraceDetailInfo(VipTrackerView.this);
                                                                    }
                                                                });
                                                                vasBasePage8.platformApi.getVasModule().openPage(addTraceDetailByInfo);
                                                                VasBasePage vasBasePage9 = vasBasePage8;
                                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("user click ");
                                                                m3.append(TagsItemData.TagInfo.this.name);
                                                                m3.append(" result :");
                                                                m3.append(addTraceDetailByInfo);
                                                                KLog.INSTANCE.i(vasBasePage9.getPageName(), m3.toString());
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
        return new TagsItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
