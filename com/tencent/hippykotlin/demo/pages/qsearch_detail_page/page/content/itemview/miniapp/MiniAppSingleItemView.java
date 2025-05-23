package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView$buildDivider$1;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchMiniAppCache;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
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
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class MiniAppSingleItemView extends QSearchBaseSingleItemView<MiniAppSingleItemAttr, MiniAppSingleItemEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(MiniAppSingleItemView.class, "labelList", "getLabelList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final ReadWriteProperty labelList$delegate = c.b();

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ MiniAppSingleItemAttr access$getAttr(MiniAppSingleItemView miniAppSingleItemView) {
        return (MiniAppSingleItemAttr) miniAppSingleItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
    public static final void access$updateLabel(MiniAppSingleItemView miniAppSingleItemView) {
        if (miniAppSingleItemView.getLabelList().isEmpty() && (!((MiniAppSingleItemAttr) miniAppSingleItemView.getAttr()).getData().labelList.isEmpty())) {
            miniAppSingleItemView.getLabelList().addAll(((MiniAppSingleItemAttr) miniAppSingleItemView.getAttr()).getData().labelList);
        }
        QSearchMiniAppCache qSearchMiniAppCache = QSearchMiniAppCache.INSTANCE;
        String str = ((MiniAppSingleItemAttr) miniAppSingleItemView.getAttr()).getData().appId;
        qSearchMiniAppCache.readCacheIfNeed();
        if (qSearchMiniAppCache.getMiniAppCache().contains(str)) {
            com.tencent.kuikly.core.reactive.collection.c<SearchNetLabel> labelList = miniAppSingleItemView.getLabelList();
            SearchNetLabel searchNetLabel = SearchMiniAppItemModel.shownLabel;
            if (labelList.contains(searchNetLabel)) {
                return;
            }
            miniAppSingleItemView.getLabelList().add(0, searchNetLabel);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final MiniAppSingleItemView miniAppSingleItemView = MiniAppSingleItemView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final MiniAppSingleItemView miniAppSingleItemView2 = MiniAppSingleItemView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Type inference failed for: r9v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(12.0f) + FontModuleExtKt.qqFontScaleAddSize(17.0f) + (MiniAppSingleItemView.access$getAttr(MiniAppSingleItemView.this).getData().labelList.isEmpty() ? 72.0f : 88.0f));
                                tVar2.paddingTop(10.0f);
                                tVar2.paddingBottom(10.0f);
                                tVar2.flexDirectionRow();
                                String eid = MiniAppSingleItemView.access$getAttr(MiniAppSingleItemView.this).getData().getEid();
                                if (eid == null) {
                                    eid = "em_search_small_program_entry";
                                }
                                EcommerceExtKt.vr$default(tVar2, null, eid, MiniAppSingleItemView.this.getReportParams(), null, String.valueOf(MiniAppSingleItemView.access$getAttr(MiniAppSingleItemView.this).getData().hashCode()), true, 9);
                                return Unit.INSTANCE;
                            }
                        });
                        final MiniAppSingleItemView miniAppSingleItemView3 = MiniAppSingleItemView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final MiniAppSingleItemView miniAppSingleItemView4 = MiniAppSingleItemView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        final MiniAppSingleItemView miniAppSingleItemView5 = MiniAppSingleItemView.this;
                                        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.2.1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                MiniAppSingleItemView miniAppSingleItemView6 = MiniAppSingleItemView.this;
                                                SearchMiniAppItemModel data = MiniAppSingleItemView.access$getAttr(miniAppSingleItemView6).getData();
                                                final MiniAppSingleItemView miniAppSingleItemView7 = MiniAppSingleItemView.this;
                                                Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.2.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(e eVar) {
                                                        String joinToString$default;
                                                        e eVar2 = eVar;
                                                        if (eVar2 != null) {
                                                            MiniAppSingleItemView miniAppSingleItemView8 = MiniAppSingleItemView.this;
                                                            if (eVar2.j("code") == 0) {
                                                                QSearchMiniAppCache qSearchMiniAppCache = QSearchMiniAppCache.INSTANCE;
                                                                String str = MiniAppSingleItemView.access$getAttr(miniAppSingleItemView8).getData().appId;
                                                                qSearchMiniAppCache.readCacheIfNeed();
                                                                if (!qSearchMiniAppCache.getMiniAppCache().contains(str)) {
                                                                    qSearchMiniAppCache.getMiniAppCache().add(str);
                                                                    CacheModule cacheModule = Utils.INSTANCE.cacheModule("");
                                                                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(qSearchMiniAppCache.getMiniAppCache(), ",", null, null, 0, null, null, 62, null);
                                                                    cacheModule.setItem("show_mini_app_list", joinToString$default);
                                                                }
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                e eVar = new e();
                                                eVar.v("appId", data.appId);
                                                eVar.t("type", data.type);
                                                eVar.t("scene", data.scene);
                                                Utils.INSTANCE.bridgeModule(miniAppSingleItemView6.getPagerId()).callNativeMethod(MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, eVar, function1);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        long currentTimeStamp = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
                                        if (currentTimeStamp - QSearchUtilKt.lastClickTime > 500) {
                                            function0.invoke();
                                            QSearchUtilKt.lastClickTime = currentTimeStamp;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final MiniAppSingleItemView miniAppSingleItemView4 = MiniAppSingleItemView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final MiniAppSingleItemView miniAppSingleItemView5 = MiniAppSingleItemView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(52.0f, 52.0f);
                                        afVar2.borderRadius(8.0f);
                                        b.a.b(afVar2, MiniAppSingleItemView.access$getAttr(MiniAppSingleItemView.this).getData().cover, false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final MiniAppSingleItemView miniAppSingleItemView5 = MiniAppSingleItemView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.alignSelfCenter();
                                        tVar2.marginLeft(12.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final MiniAppSingleItemView miniAppSingleItemView6 = MiniAppSingleItemView.this;
                                HighlightTextViewKt.HighlightText(vVar4, new Function1<HighlightTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(HighlightTextView highlightTextView) {
                                        final MiniAppSingleItemView miniAppSingleItemView7 = MiniAppSingleItemView.this;
                                        highlightTextView.attr(new Function1<HighlightAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(HighlightAttr highlightAttr) {
                                                HighlightAttr highlightAttr2 = highlightAttr;
                                                highlightAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 24.0f);
                                                highlightAttr2.justifyContentCenter();
                                                highlightAttr2.text = MiniAppSingleItemView.access$getAttr(MiniAppSingleItemView.this).getData().name;
                                                highlightAttr2.highlightText = MiniAppSingleItemView.access$getAttr(MiniAppSingleItemView.this).keyword;
                                                highlightAttr2.fontSize = 17.0f;
                                                highlightAttr2.isIgnoreCase = true;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final MiniAppSingleItemView miniAppSingleItemView7 = MiniAppSingleItemView.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.4.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        MiniAppSingleItemView miniAppSingleItemView8 = MiniAppSingleItemView.this;
                                        KProperty<Object>[] kPropertyArr = MiniAppSingleItemView.$$delegatedProperties;
                                        return Integer.valueOf(miniAppSingleItemView8.getLabelList().size());
                                    }
                                };
                                final MiniAppSingleItemView miniAppSingleItemView8 = MiniAppSingleItemView.this;
                                BindDirectivesViewKt.a(vVar4, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.4.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                        MiniAppSingleItemView miniAppSingleItemView9 = MiniAppSingleItemView.this;
                                        KProperty<Object>[] kPropertyArr = MiniAppSingleItemView.$$delegatedProperties;
                                        if (!miniAppSingleItemView9.getLabelList().isEmpty()) {
                                            final MiniAppSingleItemView miniAppSingleItemView10 = MiniAppSingleItemView.this;
                                            TroopTagViewKt.TroopTag(bindDirectivesView2, new Function1<TroopTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.4.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TroopTagView troopTagView) {
                                                    final MiniAppSingleItemView miniAppSingleItemView11 = MiniAppSingleItemView.this;
                                                    troopTagView.attr(new Function1<TroopTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.4.4.1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TroopTagAttr troopTagAttr) {
                                                            TroopTagAttr troopTagAttr2 = troopTagAttr;
                                                            troopTagAttr2.marginTop(4.0f);
                                                            MiniAppSingleItemView miniAppSingleItemView12 = MiniAppSingleItemView.this;
                                                            KProperty<Object>[] kPropertyArr2 = MiniAppSingleItemView.$$delegatedProperties;
                                                            troopTagAttr2.labelList = miniAppSingleItemView12.getLabelList();
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
                                final MiniAppSingleItemView miniAppSingleItemView9 = MiniAppSingleItemView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.4.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final MiniAppSingleItemView miniAppSingleItemView10 = MiniAppSingleItemView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView.body.1.1.4.5.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(12.0f) + 17.0f);
                                                ceVar2.marginTop(4.0f);
                                                ceVar2.lines(1);
                                                ceVar2.textOverFlowTail();
                                                ceVar2.fontWeight400();
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.text(MiniAppSingleItemView.access$getAttr(MiniAppSingleItemView.this).getData().desc);
                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        MiniAppSingleItemView miniAppSingleItemView6 = MiniAppSingleItemView.this;
                        KProperty<Object>[] kPropertyArr = MiniAppSingleItemView.$$delegatedProperties;
                        miniAppSingleItemView6.getClass();
                        new QSearchBaseSingleItemView$buildDivider$1(miniAppSingleItemView6).invoke(vVar2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new MiniAppSingleItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new MiniAppSingleItemEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView$created$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return QSearchMiniAppCache.INSTANCE.getMiniAppCache();
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.MiniAppSingleItemView$created$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                MiniAppSingleItemView.access$updateLabel(MiniAppSingleItemView.this);
                return Unit.INSTANCE;
            }
        });
    }

    public final com.tencent.kuikly.core.reactive.collection.c<SearchNetLabel> getLabelList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.labelList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView
    public final e getReportParams() {
        e reportParams = super.getReportParams();
        reportParams.v("small_program_name", ((MiniAppSingleItemAttr) getAttr()).getData().name);
        reportParams.v("app_classification", ((MiniAppSingleItemAttr) getAttr()).getData().classification);
        e mergeTransferInfo = TemplateItemsKt.mergeTransferInfo(((MiniAppSingleItemAttr) getAttr()).getData().getReportInfo(), reportParams);
        if (mergeTransferInfo != null) {
            mergeTransferInfo.t("doc_position", ((MiniAppSingleItemAttr) getAttr()).index);
        }
        if (mergeTransferInfo != null) {
            mergeTransferInfo.t("serial_number", ((MiniAppSingleItemAttr) getAttr()).getData().serialNumber);
        }
        reportParams.v("transfer_info", mergeTransferInfo);
        return reportParams;
    }
}
