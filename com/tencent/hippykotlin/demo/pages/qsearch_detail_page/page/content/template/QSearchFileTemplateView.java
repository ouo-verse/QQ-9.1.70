package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchFileTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchFileTemplateView extends QSearchBaseTemplateView<QSearchFileTemplateModel, QSearchFileAttr, QSearchFileEvent> {
    public aa<v> groupNameAndTagContainerRef;
    public aa<TextView> groupNameTextRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchFileAttr access$getAttr(QSearchFileTemplateView qSearchFileTemplateView) {
        return (QSearchFileAttr) qSearchFileTemplateView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$openFilePage(QSearchFileTemplateView qSearchFileTemplateView) {
        if (((QSearchFileAttr) qSearchFileTemplateView.getAttr()).getData().fileLink.length() > 0) {
            BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), ((QSearchFileAttr) qSearchFileTemplateView.getAttr()).getData().fileLink, false, null, null, 30);
        } else {
            Utils.INSTANCE.logToNative("openFilePage fail. fileLink is empty");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$openTroopPage(QSearchFileTemplateView qSearchFileTemplateView) {
        String str;
        qSearchFileTemplateView.getClass();
        try {
            e eVar = new e();
            eVar.v("search_query_text", ((QSearchFileAttr) qSearchFileTemplateView.getAttr()).keyword);
            eVar.v("trace_id", ((QSearchFileAttr) qSearchFileTemplateView.getAttr()).traceId);
            eVar.t("jump_type", 1);
            eVar.v("group_name", ((QSearchFileAttr) qSearchFileTemplateView.getAttr()).getData().groupName);
            str = eVar.toString();
        } catch (JSONException e16) {
            Utils utils = Utils.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getJumpUrl");
            m3.append(e16.getMessage());
            utils.logToNative(m3.toString());
            str = "";
        }
        String str2 = str;
        QSearchFileTemplateModel data = ((QSearchFileAttr) qSearchFileTemplateView.getAttr()).getData();
        Utils.INSTANCE.currentBridgeModule().openTroopPage(data.groupId, data.groupName, false, data.authSign, str2, ((QSearchFileAttr) qSearchFileTemplateView.getAttr()).keyword);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final Function1<ViewContainer<?, ?>, Unit> buildContent() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView$buildContent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchFileTemplateView qSearchFileTemplateView = QSearchFileTemplateView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView$buildContent$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QSearchFileTemplateView qSearchFileTemplateView2 = QSearchFileTemplateView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final QSearchFileTemplateView qSearchFileTemplateView3 = QSearchFileTemplateView.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.paddingTop(12.0f);
                                        tVar2.paddingBottom(12.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsFlexStart();
                                        if (!QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).isOnFileAddTroopPanel) {
                                            EcommerceExtKt.vr$default(tVar2, null, "em_bas_group_file_entry", QSearchFileTemplateView.this.getReportParams(), null, String.valueOf(QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).getData().hashCode()), true, 9);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (!QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).isOnFileAddTroopPanel) {
                                    final QSearchFileTemplateView qSearchFileTemplateView4 = QSearchFileTemplateView.this;
                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(u uVar) {
                                            final QSearchFileTemplateView qSearchFileTemplateView5 = QSearchFileTemplateView.this;
                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    if (QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).getData().isInGroup) {
                                                        QSearchFileTemplateView.access$openFilePage(QSearchFileTemplateView.this);
                                                    } else {
                                                        final QSearchFileTemplateView qSearchFileTemplateView6 = QSearchFileTemplateView.this;
                                                        b pager = qSearchFileTemplateView6.getPager();
                                                        Intrinsics.checkNotNull(pager, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage");
                                                        ((QSearchDetailPage) pager).setDialogBuilder(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView$showFileAddTroopPanel$1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                                                final QSearchFileTemplateView qSearchFileTemplateView7 = QSearchFileTemplateView.this;
                                                                viewContainer2.addChild(new QSearchFileAddTroopPanelView(), new Function1<QSearchFileAddTroopPanelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView$showFileAddTroopPanel$1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView) {
                                                                        final QSearchFileTemplateView qSearchFileTemplateView8 = QSearchFileTemplateView.this;
                                                                        qSearchFileAddTroopPanelView.attr(new Function1<QSearchFileAddTroopPanelAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.showFileAddTroopPanel.1.1.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(QSearchFileAddTroopPanelAttr qSearchFileAddTroopPanelAttr) {
                                                                                QSearchFileAddTroopPanelAttr qSearchFileAddTroopPanelAttr2 = qSearchFileAddTroopPanelAttr;
                                                                                qSearchFileAddTroopPanelAttr2.fileTemplateModel = QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).getData();
                                                                                qSearchFileAddTroopPanelAttr2.fileTemplateReportParams = QSearchFileTemplateView.this.getReportParams();
                                                                                qSearchFileAddTroopPanelAttr2.enableClickMask = true;
                                                                                qSearchFileAddTroopPanelAttr2.tabData = QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).tabData;
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
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                final QSearchFileTemplateView qSearchFileTemplateView5 = QSearchFileTemplateView.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final QSearchFileTemplateView qSearchFileTemplateView6 = QSearchFileTemplateView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.mo153width(48.0f);
                                                afVar2.mo141height(48.0f);
                                                b.a.b(afVar2, QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).getData().fileIconUrl, false, 2, null);
                                                afVar2.borderRadius(7.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchFileTemplateView qSearchFileTemplateView6 = QSearchFileTemplateView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.m140flex(1.0f);
                                                tVar2.flexDirectionColumn();
                                                tVar2.marginLeft(12.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchFileTemplateView qSearchFileTemplateView7 = QSearchFileTemplateView.this;
                                        HighlightTextViewKt.HighlightText(vVar6, new Function1<HighlightTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(HighlightTextView highlightTextView) {
                                                final QSearchFileTemplateView qSearchFileTemplateView8 = QSearchFileTemplateView.this;
                                                highlightTextView.attr(new Function1<HighlightAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(HighlightAttr highlightAttr) {
                                                        HighlightAttr highlightAttr2 = highlightAttr;
                                                        highlightAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 24.0f);
                                                        highlightAttr2.justifyContentCenter();
                                                        highlightAttr2.text = QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).getData().fileName;
                                                        highlightAttr2.highlightText = QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).keyword;
                                                        highlightAttr2.fontSize = 17.0f;
                                                        highlightAttr2.isIgnoreCase = true;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchFileTemplateView qSearchFileTemplateView8 = QSearchFileTemplateView.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.marginTop(4.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchFileTemplateView qSearchFileTemplateView9 = QSearchFileTemplateView.this;
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final QSearchFileTemplateView qSearchFileTemplateView10 = QSearchFileTemplateView.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).getData().fileSize);
                                                                ceVar2.fontWeight400();
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginLeft(6.0f);
                                                                ceVar2.text("\u6765\u81ea");
                                                                ceVar2.fontWeight400();
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchFileTemplateView qSearchFileTemplateView10 = QSearchFileTemplateView.this;
                                                w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar9) {
                                                        v vVar10 = vVar9;
                                                        final QSearchFileTemplateView qSearchFileTemplateView11 = QSearchFileTemplateView.this;
                                                        vVar10.ref(vVar10, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(aa<v> aaVar) {
                                                                QSearchFileTemplateView.this.groupNameAndTagContainerRef = aaVar;
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.4.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.m140flex(1.0f);
                                                                tVar2.flexDirectionRow();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QSearchFileTemplateView qSearchFileTemplateView12 = QSearchFileTemplateView.this;
                                                        cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.4.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                TextView textView2 = textView;
                                                                final QSearchFileTemplateView qSearchFileTemplateView13 = QSearchFileTemplateView.this;
                                                                textView2.ref(textView2, new Function1<aa<TextView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.4.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(aa<TextView> aaVar) {
                                                                        QSearchFileTemplateView.this.groupNameTextRef = aaVar;
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QSearchFileTemplateView qSearchFileTemplateView14 = QSearchFileTemplateView.this;
                                                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.4.3.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text(QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).getData().groupName);
                                                                        ceVar2.fontWeight400();
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_link"));
                                                                        ceVar2.lines(1);
                                                                        ceVar2.textOverFlowTail();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QSearchFileTemplateView qSearchFileTemplateView15 = QSearchFileTemplateView.this;
                                                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.4.3.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextEvent textEvent) {
                                                                        TextEvent textEvent2 = textEvent;
                                                                        final QSearchFileTemplateView qSearchFileTemplateView16 = QSearchFileTemplateView.this;
                                                                        textEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.4.3.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                QSearchFileTemplateView.access$openTroopPage(QSearchFileTemplateView.this);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QSearchFileTemplateView qSearchFileTemplateView17 = QSearchFileTemplateView.this;
                                                                        FrameEventKt.d(textEvent2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.4.3.3.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(d dVar) {
                                                                                TextView b16;
                                                                                ce ceVar;
                                                                                v b17;
                                                                                t tVar;
                                                                                FlexNode flexNode;
                                                                                float f16 = 0.0f;
                                                                                float length = QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).getData().label.text.length() > 0 ? (QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).getData().label.text.length() * 10.0f) + 16.0f : 0.0f;
                                                                                aa<TextView> aaVar = QSearchFileTemplateView.this.groupNameTextRef;
                                                                                if (aaVar != null && (b16 = aaVar.b()) != null && (ceVar = (ce) b16.getViewAttr()) != null) {
                                                                                    aa<v> aaVar2 = QSearchFileTemplateView.this.groupNameAndTagContainerRef;
                                                                                    if (aaVar2 != null && (b17 = aaVar2.b()) != null && (tVar = (t) b17.getViewAttr()) != null && (flexNode = tVar.getFlexNode()) != null) {
                                                                                        f16 = flexNode.v();
                                                                                    }
                                                                                    ceVar.m144maxWidth(f16 - length);
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
                                                        if (QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).getData().label.text.length() > 0) {
                                                            final QSearchFileTemplateView qSearchFileTemplateView13 = QSearchFileTemplateView.this;
                                                            TroopTagViewKt.TroopTag(vVar10, new Function1<TroopTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.4.4
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TroopTagView troopTagView) {
                                                                    final QSearchFileTemplateView qSearchFileTemplateView14 = QSearchFileTemplateView.this;
                                                                    troopTagView.attr(new Function1<TroopTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.1.4.3.4.4.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TroopTagAttr troopTagAttr) {
                                                                            List<SearchNetLabel> mutableListOf;
                                                                            TroopTagAttr troopTagAttr2 = troopTagAttr;
                                                                            troopTagAttr2.marginLeft(6.0f);
                                                                            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).getData().label);
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
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).getData().layoutInfo.showDivider && !QSearchFileTemplateView.access$getAttr(QSearchFileTemplateView.this).isOnFileAddTroopPanel) {
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.2
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView.buildContent.1.1.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            Attr.absolutePosition$default(tVar2, 0.0f, 60.0f, 0.0f, 0.0f, 1, null);
                                            tVar2.mo141height(0.5f);
                                            tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchFileAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchFileEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final float getPaddingHorizontal() {
        return ((QSearchFileAttr) getAttr()).isOnFileAddTroopPanel ? 8.0f : 16.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final e getReportParams() {
        e reportParams = super.getReportParams();
        reportParams.v("group_name", ((QSearchFileAttr) getAttr()).getData().groupName);
        reportParams.v("group_id", ((QSearchFileAttr) getAttr()).getData().groupId);
        reportParams.v("file_id", ((QSearchFileAttr) getAttr()).getData().fileId);
        reportParams.v("file_name", ((QSearchFileAttr) getAttr()).getData().fileName);
        return reportParams;
    }
}
