package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageAttr;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageView;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageViewKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView$buildDivider$1;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTroopTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class TroopSingleItemView extends QSearchBaseSingleItemView<TroopSingleItemAttr, TroopSingleItemEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$clickJoinTroop(TroopSingleItemView troopSingleItemView) {
        final SearchTroopItemModel data = ((TroopSingleItemAttr) troopSingleItemView.getAttr()).getData();
        Utils.INSTANCE.currentBridgeModule().joinTroop(data.troopUin, data.name, data.isExactSearch, data.authSign, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView$clickJoinTroop$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                int intValue = num.intValue();
                String str = SearchTroopItemModel.this.troopUin;
                c.f117352a.k(BridgeManager.f117344a.u()).setMemoryCache(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("QSearchTroopStatus_", str), Integer.valueOf(intValue));
                k notifyModule = Utils.INSTANCE.notifyModule("");
                e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("troop_uin", str, "status", intValue);
                Unit unit = Unit.INSTANCE;
                k.d(notifyModule, "update_troop_join_status", m3, false, 4, null);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TroopSingleItemAttr access$getAttr(TroopSingleItemView troopSingleItemView) {
        return (TroopSingleItemAttr) troopSingleItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$openTroopPage(TroopSingleItemView troopSingleItemView) {
        String str;
        troopSingleItemView.getClass();
        try {
            e eVar = new e();
            eVar.v("search_query_text", ((TroopSingleItemAttr) troopSingleItemView.getAttr()).keyword);
            eVar.v("trace_id", ((TroopSingleItemAttr) troopSingleItemView.getAttr()).traceId);
            eVar.t("jump_type", 1);
            eVar.v("group_name", ((TroopSingleItemAttr) troopSingleItemView.getAttr()).getData().name);
            str = eVar.toString();
        } catch (JSONException e16) {
            Utils utils = Utils.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getJumpUrl");
            m3.append(e16.getMessage());
            utils.logToNative(m3.toString());
            str = "";
        }
        String str2 = str;
        SearchTroopItemModel data = ((TroopSingleItemAttr) troopSingleItemView.getAttr()).getData();
        Utils.INSTANCE.currentBridgeModule().openTroopPage(data.troopUin, data.name, data.isExactSearch, data.authSign, str2, ((TroopSingleItemAttr) troopSingleItemView.getAttr()).keyword);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        if (((TroopSingleItemAttr) getAttr()).getData().labelFlag == 0) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView$oldStyle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                    final TroopSingleItemView troopSingleItemView = TroopSingleItemView.this;
                    w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView$oldStyle$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            final TroopSingleItemView troopSingleItemView2 = TroopSingleItemView.this;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.1
                                {
                                    super(1);
                                }

                                /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    float qqFontScaleAddSize = FontModuleExtKt.qqFontScaleAddSize(17.0f);
                                    if (!TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().labelList.isEmpty()) {
                                        qqFontScaleAddSize += FontModuleExtKt.qqFontScaleAddSize(10.0f);
                                    }
                                    if (TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().desc.length() > 0) {
                                        qqFontScaleAddSize += (FontModuleExtKt.qqFontScale() * 17.0f) - 17.0f;
                                    }
                                    tVar2.mo141height(qqFontScaleAddSize + 88.0f);
                                    tVar2.flexDirectionRow();
                                    tVar2.paddingTop(10.0f);
                                    tVar2.paddingBottom(10.0f);
                                    String eid = TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().getEid();
                                    if (eid == null) {
                                        eid = "em_search_group_entry";
                                    }
                                    EcommerceExtKt.vr$default(tVar2, null, eid, TroopSingleItemView.this.getReportParams(), null, String.valueOf(TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().hashCode()), true, 9);
                                    return Unit.INSTANCE;
                                }
                            });
                            final TroopSingleItemView troopSingleItemView3 = TroopSingleItemView.this;
                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(u uVar) {
                                    final TroopSingleItemView troopSingleItemView4 = TroopSingleItemView.this;
                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            TroopSingleItemView.access$openTroopPage(TroopSingleItemView.this);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final TroopSingleItemView troopSingleItemView4 = TroopSingleItemView.this;
                            QQFaceImageViewKt.QQFaceImage(vVar2, new Function1<QQFaceImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QQFaceImageView qQFaceImageView) {
                                    final TroopSingleItemView troopSingleItemView5 = TroopSingleItemView.this;
                                    qQFaceImageView.attr(new Function1<QQFaceImageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.3.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QQFaceImageAttr qQFaceImageAttr) {
                                            QQFaceImageAttr qQFaceImageAttr2 = qQFaceImageAttr;
                                            qQFaceImageAttr2.src(TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().troopUin, 1);
                                            qQFaceImageAttr2.size(52.0f, 52.0f);
                                            qQFaceImageAttr2.borderRadius(26.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final TroopSingleItemView troopSingleItemView5 = TroopSingleItemView.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.4
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.4.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.m140flex(1.0f);
                                            tVar2.flexDirectionColumn();
                                            tVar2.marginLeft(12.0f);
                                            tVar2.marginRight(12.0f);
                                            tVar2.alignSelfCenter();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final TroopSingleItemView troopSingleItemView6 = TroopSingleItemView.this;
                                    HighlightTextViewKt.HighlightText(vVar4, new Function1<HighlightTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.4.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(HighlightTextView highlightTextView) {
                                            final TroopSingleItemView troopSingleItemView7 = TroopSingleItemView.this;
                                            highlightTextView.attr(new Function1<HighlightAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.4.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(HighlightAttr highlightAttr) {
                                                    HighlightAttr highlightAttr2 = highlightAttr;
                                                    highlightAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 24.0f);
                                                    highlightAttr2.justifyContentCenter();
                                                    highlightAttr2.text = TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().name;
                                                    highlightAttr2.highlightText = TroopSingleItemView.access$getAttr(TroopSingleItemView.this).keyword;
                                                    highlightAttr2.fontSize = 17.0f;
                                                    highlightAttr2.isIgnoreCase = true;
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final TroopSingleItemView troopSingleItemView7 = TroopSingleItemView.this;
                                    TroopTagViewKt.TroopTag(vVar4, new Function1<TroopTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.4.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TroopTagView troopTagView) {
                                            final TroopSingleItemView troopSingleItemView8 = TroopSingleItemView.this;
                                            troopTagView.attr(new Function1<TroopTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.4.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TroopTagAttr troopTagAttr) {
                                                    TroopTagAttr troopTagAttr2 = troopTagAttr;
                                                    troopTagAttr2.marginTop(4.0f);
                                                    troopTagAttr2.labelList = TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().labelList;
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final TroopSingleItemView troopSingleItemView8 = TroopSingleItemView.this;
                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.4.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final TroopSingleItemView troopSingleItemView9 = TroopSingleItemView.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.4.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.mo141height(FontModuleExtKt.qqFontScale() * 17.0f);
                                                    ceVar2.marginTop(4.0f);
                                                    ceVar2.text(TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().desc);
                                                    ceVar2.fontWeight400();
                                                    ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                    ceVar2.lines(1);
                                                    ceVar2.textOverFlowTail();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final TroopSingleItemView troopSingleItemView6 = TroopSingleItemView.this;
                            Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.5
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Integer.valueOf(TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().getJoinStatus());
                                }
                            };
                            final TroopSingleItemView troopSingleItemView7 = TroopSingleItemView.this;
                            BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.6
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                    final TroopSingleItemView troopSingleItemView8 = TroopSingleItemView.this;
                                    QSearchGrayBorderButtonViewKt.QSearchGrayBorderButton(bindDirectivesView, new Function1<QSearchGrayBorderButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.6.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchGrayBorderButtonView qSearchGrayBorderButtonView) {
                                            QSearchGrayBorderButtonView qSearchGrayBorderButtonView2 = qSearchGrayBorderButtonView;
                                            final TroopSingleItemView troopSingleItemView9 = TroopSingleItemView.this;
                                            qSearchGrayBorderButtonView2.attr(new Function1<QSearchGrayBorderButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.6.1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr) {
                                                    QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr2 = qSearchGrayBorderButtonAttr;
                                                    qSearchGrayBorderButtonAttr2.marginLeft(12.0f);
                                                    qSearchGrayBorderButtonAttr2.alignSelfCenter();
                                                    int joinStatus = TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().getJoinStatus();
                                                    if (joinStatus == 0) {
                                                        qSearchGrayBorderButtonAttr2.text = "\u5df2\u52a0\u5165";
                                                        qSearchGrayBorderButtonAttr2.status = 1;
                                                    } else if (joinStatus != 1) {
                                                        qSearchGrayBorderButtonAttr2.text = "\u7b49\u5f85\u9a8c\u8bc1";
                                                        qSearchGrayBorderButtonAttr2.status = 2;
                                                    } else {
                                                        qSearchGrayBorderButtonAttr2.text = "\u52a0\u5165";
                                                        qSearchGrayBorderButtonAttr2.status = 0;
                                                    }
                                                    EcommerceExtKt.elementVR(qSearchGrayBorderButtonAttr2, "em_bas_group_enter_button", TroopSingleItemView.this.getReportParams());
                                                    qSearchGrayBorderButtonAttr2.accessibility(qSearchGrayBorderButtonAttr2.text + "\u6309\u94ae");
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            if (TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().getJoinStatus() == 1) {
                                                final TroopSingleItemView troopSingleItemView10 = TroopSingleItemView.this;
                                                qSearchGrayBorderButtonView2.event(new Function1<QSearchGrayBorderButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.6.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchGrayBorderButtonEvent qSearchGrayBorderButtonEvent) {
                                                        final TroopSingleItemView troopSingleItemView11 = TroopSingleItemView.this;
                                                        qSearchGrayBorderButtonEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.oldStyle.1.1.6.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                TroopSingleItemView.access$clickJoinTroop(TroopSingleItemView.this);
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
                                    return Unit.INSTANCE;
                                }
                            });
                            TroopSingleItemView troopSingleItemView8 = TroopSingleItemView.this;
                            int i3 = TroopSingleItemView.$r8$clinit;
                            troopSingleItemView8.getClass();
                            new QSearchBaseSingleItemView$buildDivider$1(troopSingleItemView8).invoke(vVar2);
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView$newStyle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final TroopSingleItemView troopSingleItemView = TroopSingleItemView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView$newStyle$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final TroopSingleItemView troopSingleItemView2 = TroopSingleItemView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingTop(8.0f);
                                tVar2.paddingBottom(12.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsFlexStart();
                                String eid = TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().getEid();
                                if (eid == null) {
                                    eid = "em_search_group_entry";
                                }
                                EcommerceExtKt.vr$default(tVar2, null, eid, TroopSingleItemView.this.getReportParams(), null, String.valueOf(TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().hashCode()), true, 9);
                                return Unit.INSTANCE;
                            }
                        });
                        final TroopSingleItemView troopSingleItemView3 = TroopSingleItemView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final TroopSingleItemView troopSingleItemView4 = TroopSingleItemView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        TroopSingleItemView.access$openTroopPage(TroopSingleItemView.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TroopSingleItemView troopSingleItemView4 = TroopSingleItemView.this;
                        QQFaceImageViewKt.QQFaceImage(vVar2, new Function1<QQFaceImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QQFaceImageView qQFaceImageView) {
                                final TroopSingleItemView troopSingleItemView5 = TroopSingleItemView.this;
                                qQFaceImageView.attr(new Function1<QQFaceImageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QQFaceImageAttr qQFaceImageAttr) {
                                        QQFaceImageAttr qQFaceImageAttr2 = qQFaceImageAttr;
                                        qQFaceImageAttr2.marginTop(10.0f);
                                        qQFaceImageAttr2.src(TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().troopUin, 1);
                                        qQFaceImageAttr2.size(52.0f, 52.0f);
                                        qQFaceImageAttr2.borderRadius(26.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TroopSingleItemView troopSingleItemView5 = TroopSingleItemView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.marginTop(12.0f);
                                        tVar2.marginLeft(12.0f);
                                        tVar2.alignSelfCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TroopSingleItemView troopSingleItemView6 = TroopSingleItemView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.m140flex(1.0f);
                                                tVar2.flexDirectionColumn();
                                                tVar2.marginRight(12.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TroopSingleItemView troopSingleItemView7 = TroopSingleItemView.this;
                                        HighlightTextViewKt.HighlightText(vVar6, new Function1<HighlightTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(HighlightTextView highlightTextView) {
                                                final TroopSingleItemView troopSingleItemView8 = TroopSingleItemView.this;
                                                highlightTextView.attr(new Function1<HighlightAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(HighlightAttr highlightAttr) {
                                                        HighlightAttr highlightAttr2 = highlightAttr;
                                                        highlightAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 24.0f);
                                                        highlightAttr2.justifyContentCenter();
                                                        highlightAttr2.text = TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().name;
                                                        highlightAttr2.highlightText = TroopSingleItemView.access$getAttr(TroopSingleItemView.this).keyword;
                                                        highlightAttr2.fontSize = 17.0f;
                                                        highlightAttr2.isIgnoreCase = true;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TroopSingleItemView troopSingleItemView8 = TroopSingleItemView.this;
                                        TroopTagViewKt.TroopTag(vVar6, new Function1<TroopTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TroopTagView troopTagView) {
                                                final TroopSingleItemView troopSingleItemView9 = TroopSingleItemView.this;
                                                troopTagView.attr(new Function1<TroopTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TroopTagAttr troopTagAttr) {
                                                        TroopTagAttr troopTagAttr2 = troopTagAttr;
                                                        troopTagAttr2.marginTop(5.0f);
                                                        troopTagAttr2.labelList = TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().labelList;
                                                        troopTagAttr2.useWrapMode = true;
                                                        troopTagAttr2.wrapMarginTop = 5.0f;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TroopSingleItemView troopSingleItemView9 = TroopSingleItemView.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.2.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final TroopSingleItemView troopSingleItemView10 = TroopSingleItemView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.2.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginTop(5.0f);
                                                        ceVar2.text(TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().desc);
                                                        ceVar2.fontWeight400();
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.lineHeight(FontModuleExtKt.qqTextViewLineHeightScale() * 20.0f);
                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                        ceVar2.lines(2);
                                                        ceVar2.textOverFlowTail();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final SearchNetLabel searchNetLabel = TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().bottomLabel;
                                        if (searchNetLabel != null) {
                                            TroopTagViewKt.TroopTag(vVar6, new Function1<TroopTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView$newStyle$1$1$4$2$5$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TroopTagView troopTagView) {
                                                    final SearchNetLabel searchNetLabel2 = SearchNetLabel.this;
                                                    troopTagView.attr(new Function1<TroopTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView$newStyle$1$1$4$2$5$1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TroopTagAttr troopTagAttr) {
                                                            List<SearchNetLabel> mutableListOf;
                                                            TroopTagAttr troopTagAttr2 = troopTagAttr;
                                                            troopTagAttr2.marginTop(5.0f);
                                                            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(SearchNetLabel.this);
                                                            troopTagAttr2.labelList = mutableListOf;
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
                                final TroopSingleItemView troopSingleItemView7 = TroopSingleItemView.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Integer.valueOf(TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().getJoinStatus());
                                    }
                                };
                                final TroopSingleItemView troopSingleItemView8 = TroopSingleItemView.this;
                                BindDirectivesViewKt.a(vVar4, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        final TroopSingleItemView troopSingleItemView9 = TroopSingleItemView.this;
                                        QSearchGrayBorderButtonViewKt.QSearchGrayBorderButton(bindDirectivesView, new Function1<QSearchGrayBorderButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchGrayBorderButtonView qSearchGrayBorderButtonView) {
                                                QSearchGrayBorderButtonView qSearchGrayBorderButtonView2 = qSearchGrayBorderButtonView;
                                                final TroopSingleItemView troopSingleItemView10 = TroopSingleItemView.this;
                                                qSearchGrayBorderButtonView2.attr(new Function1<QSearchGrayBorderButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr) {
                                                        QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr2 = qSearchGrayBorderButtonAttr;
                                                        int joinStatus = TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().getJoinStatus();
                                                        if (joinStatus == 0) {
                                                            qSearchGrayBorderButtonAttr2.text = "\u5df2\u52a0\u5165";
                                                            qSearchGrayBorderButtonAttr2.status = 1;
                                                        } else if (joinStatus != 1) {
                                                            qSearchGrayBorderButtonAttr2.text = "\u7b49\u5f85\u9a8c\u8bc1";
                                                            qSearchGrayBorderButtonAttr2.status = 2;
                                                        } else {
                                                            qSearchGrayBorderButtonAttr2.text = "\u52a0\u5165";
                                                            qSearchGrayBorderButtonAttr2.status = 0;
                                                        }
                                                        EcommerceExtKt.elementVR(qSearchGrayBorderButtonAttr2, "em_bas_group_enter_button", TroopSingleItemView.this.getReportParams());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                if (TroopSingleItemView.access$getAttr(TroopSingleItemView.this).getData().getJoinStatus() == 1) {
                                                    final TroopSingleItemView troopSingleItemView11 = TroopSingleItemView.this;
                                                    qSearchGrayBorderButtonView2.event(new Function1<QSearchGrayBorderButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.4.1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(QSearchGrayBorderButtonEvent qSearchGrayBorderButtonEvent) {
                                                            final TroopSingleItemView troopSingleItemView12 = TroopSingleItemView.this;
                                                            qSearchGrayBorderButtonEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView.newStyle.1.1.4.4.1.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    TroopSingleItemView.access$clickJoinTroop(TroopSingleItemView.this);
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
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        TroopSingleItemView troopSingleItemView6 = TroopSingleItemView.this;
                        int i3 = TroopSingleItemView.$r8$clinit;
                        troopSingleItemView6.getClass();
                        new QSearchBaseSingleItemView$buildDivider$1(troopSingleItemView6).invoke(vVar2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new TroopSingleItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TroopSingleItemEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        k.b(Utils.INSTANCE.notifyModule(""), "update_troop_join_status", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.TroopSingleItemView$created$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                if (eVar2 != null) {
                    TroopSingleItemView troopSingleItemView = TroopSingleItemView.this;
                    if (Intrinsics.areEqual(eVar2.p("troop_uin"), TroopSingleItemView.access$getAttr(troopSingleItemView).getData().troopUin)) {
                        int j3 = eVar2.j("status");
                        SearchTroopItemModel data = TroopSingleItemView.access$getAttr(troopSingleItemView).getData();
                        data.joinStatus$delegate.setValue(data, SearchTroopItemModel.$$delegatedProperties[0], Integer.valueOf(j3));
                    }
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView
    public final e getReportParams() {
        List listOf;
        String joinToString$default;
        e reportParams = super.getReportParams();
        reportParams.v("group_name", ((TroopSingleItemAttr) getAttr()).getData().name);
        reportParams.v("group_id", ((TroopSingleItemAttr) getAttr()).getData().troopUin);
        e eVar = ((TroopSingleItemAttr) getAttr()).getData().labelReportParams;
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            Object e16 = eVar.e(next);
            if (e16 != null) {
                reportParams.v(next, e16);
            }
        }
        QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel = ((TroopSingleItemAttr) getAttr()).viewModel;
        if (qSearchTroopTabContentViewModel != null) {
            reportParams.v("sort_type", qSearchTroopTabContentViewModel.getSelectedSortRule().text);
            reportParams.v("tag_type", qSearchTroopTabContentViewModel.getSelectedTroopLabel().text);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{qSearchTroopTabContentViewModel.getHighlightProvince().text, qSearchTroopTabContentViewModel.getHighlightCity().text, qSearchTroopTabContentViewModel.getHighlightCounty().text});
            ArrayList arrayList = new ArrayList();
            for (Object obj : listOf) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
            reportParams.v("regional_type", joinToString$default);
        }
        e mergeTransferInfo = TemplateItemsKt.mergeTransferInfo(((TroopSingleItemAttr) getAttr()).getData().getReportInfo(), reportParams);
        if (mergeTransferInfo != null) {
            mergeTransferInfo.t("doc_position", ((TroopSingleItemAttr) getAttr()).index);
        }
        if (mergeTransferInfo != null) {
            mergeTransferInfo.t("serial_number", ((TroopSingleItemAttr) getAttr()).getData().serialNumber);
        }
        reportParams.v("transfer_info", mergeTransferInfo);
        return reportParams;
    }
}
