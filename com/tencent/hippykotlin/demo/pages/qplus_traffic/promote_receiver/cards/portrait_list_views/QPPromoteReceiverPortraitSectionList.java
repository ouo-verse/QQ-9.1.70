package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchItemCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitListItem;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitPageModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverPortraitSectionList extends ComposeView<k, l> {
    public final QPPromoteReceiverPortraitSectionListModel viewModel;

    public QPPromoteReceiverPortraitSectionList(QPPromoteReceiverPortraitSectionListModel qPPromoteReceiverPortraitSectionListModel) {
        this.viewModel = qPPromoteReceiverPortraitSectionListModel;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel = this.viewModel.pageModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        return Unit.INSTANCE;
                    }
                });
                final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel2 = QPPromoteReceiverPortraitPageModel.this;
                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.mo141height(56.0f);
                                tVar2.flexDirectionRow();
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel3 = QPPromoteReceiverPortraitPageModel.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return QPPromoteReceiverPortraitPageModel.this.getSelectedList();
                            }
                        };
                        final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList2 = qPPromoteReceiverPortraitSectionList;
                        BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList3 = QPPromoteReceiverPortraitSectionList.this;
                                ah.a(bindDirectivesView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        ImageView imageView2 = imageView;
                                        final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList4 = QPPromoteReceiverPortraitSectionList.this;
                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.3.1.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
                                            /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
                                            @Override // kotlin.jvm.functions.Function1
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(af afVar) {
                                                boolean z16;
                                                af afVar2 = afVar;
                                                afVar2.size(24.0f, 24.0f);
                                                afVar2.marginLeft(16.0f);
                                                QPPromoteReceiverPortraitSectionListModel qPPromoteReceiverPortraitSectionListModel = QPPromoteReceiverPortraitSectionList.this.viewModel;
                                                if (qPPromoteReceiverPortraitSectionListModel.getSectionList().size() != 0) {
                                                    Iterator<QPPromoteReceiverPortraitListItem> it = qPPromoteReceiverPortraitSectionListModel.getSectionList().iterator();
                                                    while (it.hasNext()) {
                                                        if (!qPPromoteReceiverPortraitSectionListModel.pageModel.hasSelectedItem(it.next())) {
                                                        }
                                                    }
                                                    z16 = true;
                                                    if (!z16) {
                                                        b.a.b(afVar2, "qecommerce_skin_checkbox_general_selected_qq", false, 2, null);
                                                    } else {
                                                        b.a.b(afVar2, "qecommerce_skin_checkbox_general_normal", false, 2, null);
                                                    }
                                                    afVar2.borderRadius(12.0f);
                                                    return Unit.INSTANCE;
                                                }
                                                z16 = false;
                                                if (!z16) {
                                                }
                                                afVar2.borderRadius(12.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList5 = QPPromoteReceiverPortraitSectionList.this;
                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.3.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageEvent imageEvent) {
                                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList6 = QPPromoteReceiverPortraitSectionList.this;
                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.3.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        QPPromoteReceiverPortraitSectionListModel qPPromoteReceiverPortraitSectionListModel = QPPromoteReceiverPortraitSectionList.this.viewModel;
                                                        qPPromoteReceiverPortraitSectionListModel.getClass();
                                                        ArrayList arrayList = new ArrayList();
                                                        arrayList.addAll(qPPromoteReceiverPortraitSectionListModel.getSectionList());
                                                        QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel4 = qPPromoteReceiverPortraitSectionListModel.pageModel;
                                                        qPPromoteReceiverPortraitPageModel4.getClass();
                                                        ArrayList arrayList2 = new ArrayList();
                                                        ArrayList arrayList3 = new ArrayList();
                                                        Iterator it = arrayList.iterator();
                                                        int i3 = 0;
                                                        while (it.hasNext()) {
                                                            Object next = it.next();
                                                            int i16 = i3 + 1;
                                                            if (i3 < 0) {
                                                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                            }
                                                            if (!qPPromoteReceiverPortraitPageModel4.hasSelectedItem((QPPromoteReceiverPortraitListItem) next)) {
                                                                arrayList2.add(Integer.valueOf(i3));
                                                            } else {
                                                                arrayList3.add(Integer.valueOf(i3));
                                                            }
                                                            i3 = i16;
                                                        }
                                                        if (arrayList2.isEmpty()) {
                                                            Iterator it5 = arrayList3.iterator();
                                                            while (it5.hasNext()) {
                                                                qPPromoteReceiverPortraitPageModel4.onSwitchItemStatus((QPPromoteReceiverPortraitListItem) arrayList.get(((Number) it5.next()).intValue()));
                                                            }
                                                        } else {
                                                            if (arrayList2.size() + qPPromoteReceiverPortraitPageModel4.getSelectedList().size() > 20) {
                                                                BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u6700\u591a\u9009\u62e9");
                                                                m3.append(qPPromoteReceiverPortraitPageModel4.selectedMaxNum);
                                                                m3.append('\u4e2a');
                                                                currentBridgeModule.toast(m3.toString());
                                                            } else {
                                                                Iterator it6 = arrayList2.iterator();
                                                                while (it6.hasNext()) {
                                                                    qPPromoteReceiverPortraitPageModel4.onSwitchItemStatus((QPPromoteReceiverPortraitListItem) arrayList.get(((Number) it6.next()).intValue()));
                                                                }
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
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList3 = qPPromoteReceiverPortraitSectionList;
                        final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel4 = QPPromoteReceiverPortraitPageModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.marginLeft(8.0f);
                                        tVar2.mo153width(((tVar2.getPagerData().m() - 16.0f) - 24.0f) - 8.0f);
                                        tVar2.justifyContentSpaceBetween();
                                        tVar2.alignItemsCenter();
                                        tVar2.flexDirectionRow();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList4 = QPPromoteReceiverPortraitSectionList.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList5 = QPPromoteReceiverPortraitSectionList.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QPPromoteReceiverPortraitSectionListModel qPPromoteReceiverPortraitSectionListModel = QPPromoteReceiverPortraitSectionList.this.viewModel;
                                                qPPromoteReceiverPortraitSectionListModel.isCollapsed$delegate.setValue(qPPromoteReceiverPortraitSectionListModel, QPPromoteReceiverPortraitSectionListModel.$$delegatedProperties[2], Boolean.valueOf(!qPPromoteReceiverPortraitSectionListModel.isCollapsed()));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList5 = QPPromoteReceiverPortraitSectionList.this;
                                final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel5 = qPPromoteReceiverPortraitPageModel4;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.flexDirectionRow();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList6 = QPPromoteReceiverPortraitSectionList.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList7 = QPPromoteReceiverPortraitSectionList.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        QPPromoteReceiverPortraitSectionListModel qPPromoteReceiverPortraitSectionListModel = QPPromoteReceiverPortraitSectionList.this.viewModel;
                                                        ceVar2.text((String) qPPromoteReceiverPortraitSectionListModel.title$delegate.getValue(qPPromoteReceiverPortraitSectionListModel, QPPromoteReceiverPortraitSectionListModel.$$delegatedProperties[0]));
                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                        ceVar2.textAlignCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel6 = qPPromoteReceiverPortraitPageModel5;
                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.3.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return QPPromoteReceiverPortraitPageModel.this.getSelectedList();
                                            }
                                        };
                                        final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList7 = QPPromoteReceiverPortraitSectionList.this;
                                        BindDirectivesViewKt.a(vVar6, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.3.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList8 = QPPromoteReceiverPortraitSectionList.this;
                                                cg.a(bindDirectivesView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.3.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList9 = QPPromoteReceiverPortraitSectionList.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.3.4.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('\uff08');
                                                                QPPromoteReceiverPortraitSectionListModel qPPromoteReceiverPortraitSectionListModel = QPPromoteReceiverPortraitSectionList.this.viewModel;
                                                                Iterator<QPPromoteReceiverPortraitListItem> it = qPPromoteReceiverPortraitSectionListModel.getSectionList().iterator();
                                                                int i3 = 0;
                                                                while (it.hasNext()) {
                                                                    if (qPPromoteReceiverPortraitSectionListModel.pageModel.hasSelectedItem(it.next())) {
                                                                        i3++;
                                                                    }
                                                                }
                                                                m3.append(i3);
                                                                m3.append('/');
                                                                m3.append(QPPromoteReceiverPortraitSectionList.this.viewModel.getSectionList().size());
                                                                m3.append('\uff09');
                                                                ceVar2.text(m3.toString());
                                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                ceVar2.textAlignCenter();
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
                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList6 = QPPromoteReceiverPortraitSectionList.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(QPPromoteReceiverPortraitSectionList.this.viewModel.isCollapsed());
                                    }
                                };
                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList7 = QPPromoteReceiverPortraitSectionList.this;
                                BindDirectivesViewKt.a(vVar4, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList8 = QPPromoteReceiverPortraitSectionList.this;
                                        w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.5.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.5.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(40.0f, 40.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList9 = QPPromoteReceiverPortraitSectionList.this;
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.5.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList10 = QPPromoteReceiverPortraitSectionList.this;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.2.4.5.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(10.0f, 10.0f);
                                                                b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_friendspicker", false, 2, null);
                                                                if (QPPromoteReceiverPortraitSectionList.this.viewModel.isCollapsed()) {
                                                                    afVar2.transform(new com.tencent.kuikly.core.base.t(0.0f, 0.0f, 0.0f, 6, null));
                                                                } else {
                                                                    afVar2.transform(new com.tencent.kuikly.core.base.t(90.0f, 0.0f, 0.0f, 6, null));
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
                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList2 = this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(!QPPromoteReceiverPortraitSectionList.this.viewModel.isCollapsed());
                    }
                };
                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList3 = this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList4 = QPPromoteReceiverPortraitSectionList.this;
                        ar.a(conditionView, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList5 = QPPromoteReceiverPortraitSectionList.this;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.marginLeft(32.0f);
                                        aoVar2.mo153width(aoVar2.getPagerData().m() - 32.0f);
                                        aoVar2.mo141height(QPPromoteReceiverPortraitSectionList.this.viewModel.getSectionList().size() * 56.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList6 = QPPromoteReceiverPortraitSectionList.this;
                                Function0<c<QPPromoteReceiverPortraitListItem>> function02 = new Function0<c<QPPromoteReceiverPortraitListItem>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.4.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final c<QPPromoteReceiverPortraitListItem> invoke() {
                                        return QPPromoteReceiverPortraitSectionList.this.viewModel.getSectionList();
                                    }
                                };
                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList7 = QPPromoteReceiverPortraitSectionList.this;
                                LoopDirectivesViewKt.a(aqVar2, function02, new Function2<LoopDirectivesView<QPPromoteReceiverPortraitListItem>, QPPromoteReceiverPortraitListItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.4.1.3
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<QPPromoteReceiverPortraitListItem> loopDirectivesView, QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem) {
                                        final QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem2 = qPPromoteReceiverPortraitListItem;
                                        final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList8 = QPPromoteReceiverPortraitSectionList.this;
                                        loopDirectivesView.addChild(new QPPromoteReceiverPortraitItemCard(), new Function1<QPPromoteReceiverPortraitItemCard, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.4.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard) {
                                                final QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList9 = QPPromoteReceiverPortraitSectionList.this;
                                                final QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem3 = qPPromoteReceiverPortraitListItem2;
                                                qPPromoteReceiverPortraitItemCard.attr(new Function1<QPPromoteReceiverSearchItemCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList.body.1.4.1.3.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QPPromoteReceiverSearchItemCardAttr qPPromoteReceiverSearchItemCardAttr) {
                                                        QPPromoteReceiverSearchItemCardAttr qPPromoteReceiverSearchItemCardAttr2 = qPPromoteReceiverSearchItemCardAttr;
                                                        qPPromoteReceiverSearchItemCardAttr2.viewModel = QPPromoteReceiverPortraitSectionList.this.viewModel.pageModel;
                                                        qPPromoteReceiverSearchItemCardAttr2.item(qPPromoteReceiverPortraitListItem3);
                                                        qPPromoteReceiverSearchItemCardAttr2.mo153width(qPPromoteReceiverSearchItemCardAttr2.getPagerData().m() - 32.0f);
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
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
