package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchGuildJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchButtonInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchCommonItemTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
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
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.LoadResolutionParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchCommonItemTemplateView extends QSearchBaseTemplateView<QSearchCommonItemTemplateModel, QSearchCommonItemTemplateAttr, QSearchCommonItemTemplateEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public String notifyGuildJoinCb;
    public String notifyTroopJoinCb;

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$buildAvatar(QSearchCommonItemTemplateView qSearchCommonItemTemplateView) {
        if (!qSearchCommonItemTemplateView.hasValidAvatar()) {
            return null;
        }
        return new QSearchCommonItemTemplateView$buildAvatar$1(((QSearchCommonItemTemplateAttr) qSearchCommonItemTemplateView.getAttr()).getData().avatarType, qSearchCommonItemTemplateView, ((QSearchCommonItemTemplateAttr) qSearchCommonItemTemplateView.getAttr()).getData().avatar, ((QSearchCommonItemTemplateAttr) qSearchCommonItemTemplateView.getAttr()).getData().uin, ((QSearchCommonItemTemplateAttr) qSearchCommonItemTemplateView.getAttr()).getData().uinType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchCommonItemTemplateAttr access$getAttr(QSearchCommonItemTemplateView qSearchCommonItemTemplateView) {
        return (QSearchCommonItemTemplateAttr) qSearchCommonItemTemplateView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final Function1<ViewContainer<?, ?>, Unit> buildContent() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildContent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                if (QSearchCommonItemTemplateView.access$getAttr(QSearchCommonItemTemplateView.this).getData().layoutInfo.showDivider) {
                    final QSearchCommonItemTemplateView qSearchCommonItemTemplateView = QSearchCommonItemTemplateView.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildContent$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            final QSearchCommonItemTemplateView qSearchCommonItemTemplateView2 = QSearchCommonItemTemplateView.this;
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildContent.1.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.mo141height(0.5f);
                                    QSearchCommonItemTemplateView qSearchCommonItemTemplateView3 = QSearchCommonItemTemplateView.this;
                                    int i3 = QSearchCommonItemTemplateView.$r8$clinit;
                                    float f16 = qSearchCommonItemTemplateView3.hasValidAvatar() ? 60.0f : 0.0f;
                                    QSearchCommonItemTemplateView.this.getClass();
                                    tVar2.marginLeft(f16 + 16.0f);
                                    QSearchCommonItemTemplateView.this.getClass();
                                    tVar2.marginRight(16.0f);
                                    tVar2.absolutePositionAllZero();
                                    tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                final QSearchCommonItemTemplateView qSearchCommonItemTemplateView2 = QSearchCommonItemTemplateView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildContent$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildContent.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingTop(12.0f);
                                tVar2.paddingBottom(12.0f);
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        Function1 access$buildAvatar = QSearchCommonItemTemplateView.access$buildAvatar(QSearchCommonItemTemplateView.this);
                        if (access$buildAvatar != null) {
                            ((QSearchCommonItemTemplateView$buildAvatar$1) access$buildAvatar).invoke(vVar2);
                        }
                        final QSearchCommonItemTemplateView qSearchCommonItemTemplateView3 = QSearchCommonItemTemplateView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildContent.1.2.2
                            {
                                super(1);
                            }

                            /* JADX WARN: Type inference failed for: r0v21, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildContent.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.flexDirectionColumn();
                                        tVar2.alignSelfCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchCommonItemTemplateView qSearchCommonItemTemplateView4 = QSearchCommonItemTemplateView.this;
                                HighlightTextViewKt.HighlightText(vVar4, new Function1<HighlightTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildContent.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(HighlightTextView highlightTextView) {
                                        final QSearchCommonItemTemplateView qSearchCommonItemTemplateView5 = QSearchCommonItemTemplateView.this;
                                        highlightTextView.attr(new Function1<HighlightAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildContent.1.2.2.2.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Type inference failed for: r1v10, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildTitleTail$1, kotlin.jvm.internal.Lambda] */
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(HighlightAttr highlightAttr) {
                                                HighlightAttr highlightAttr2 = highlightAttr;
                                                highlightAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 24.0f);
                                                highlightAttr2.justifyContentCenter();
                                                highlightAttr2.text = QSearchCommonItemTemplateView.access$getAttr(QSearchCommonItemTemplateView.this).getData().title;
                                                highlightAttr2.highlightText = QSearchCommonItemTemplateView.access$getAttr(QSearchCommonItemTemplateView.this).keyword;
                                                highlightAttr2.fontSize = 17.0f;
                                                final QSearchCommonItemTemplateView qSearchCommonItemTemplateView6 = QSearchCommonItemTemplateView.this;
                                                qSearchCommonItemTemplateView6.getClass();
                                                highlightAttr2.tailContentBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildTitleTail$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                        final QSearchCommonItemTemplateView qSearchCommonItemTemplateView7 = QSearchCommonItemTemplateView.this;
                                                        final float f16 = 16.0f;
                                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildTitleTail$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar5) {
                                                                v vVar6 = vVar5;
                                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildTitleTail.1.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        tVar.flexDirectionRow();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                ?? r06 = QSearchCommonItemTemplateView.access$getAttr(QSearchCommonItemTemplateView.this).getData().titleIcons;
                                                                final float f17 = f16;
                                                                Iterator it = r06.iterator();
                                                                final int i3 = 0;
                                                                while (it.hasNext()) {
                                                                    Object next = it.next();
                                                                    int i16 = i3 + 1;
                                                                    if (i3 < 0) {
                                                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                                    }
                                                                    final String str = (String) next;
                                                                    ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildTitleTail$1$1$2$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            ImageView imageView2 = imageView;
                                                                            final float f18 = f17;
                                                                            final int i17 = i3;
                                                                            final String str2 = str;
                                                                            imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildTitleTail$1$1$2$1.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(af afVar) {
                                                                                    af afVar2 = afVar;
                                                                                    float f19 = f18;
                                                                                    afVar2.size(f19, f19);
                                                                                    afVar2.marginLeft(i17 == 0 ? 4.0f : 2.0f);
                                                                                    b.a.b(afVar2, str2, false, 2, null);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final float f19 = f17;
                                                                            imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildTitleTail$1$1$2$1.2
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ImageEvent imageEvent) {
                                                                                    final ImageEvent imageEvent2 = imageEvent;
                                                                                    final float f26 = f19;
                                                                                    imageEvent2.i(new Function1<LoadResolutionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildTitleTail.1.1.2.1.2.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        /* JADX WARN: Type inference failed for: r3v7, types: [com.tencent.kuikly.core.base.Attr] */
                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(LoadResolutionParams loadResolutionParams) {
                                                                                            ?? viewAttr;
                                                                                            LoadResolutionParams loadResolutionParams2 = loadResolutionParams;
                                                                                            if (loadResolutionParams2.getWidth() > 0 && loadResolutionParams2.getHeight() > 0) {
                                                                                                float height = (f26 / loadResolutionParams2.getHeight()) * loadResolutionParams2.getWidth();
                                                                                                AbstractBaseView<?, ?> view = imageEvent2.getView();
                                                                                                if (view != null && (viewAttr = view.getViewAttr()) != 0) {
                                                                                                    viewAttr.mo153width(height);
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
                                                                    i3 = i16;
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                highlightAttr2.isIgnoreCase = true;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (!QSearchCommonItemTemplateView.access$getAttr(QSearchCommonItemTemplateView.this).getData().topLabelList.isEmpty()) {
                                    final QSearchCommonItemTemplateView qSearchCommonItemTemplateView5 = QSearchCommonItemTemplateView.this;
                                    TroopTagViewKt.TroopTag(vVar4, new Function1<TroopTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildContent.1.2.2.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TroopTagView troopTagView) {
                                            final QSearchCommonItemTemplateView qSearchCommonItemTemplateView6 = QSearchCommonItemTemplateView.this;
                                            troopTagView.attr(new Function1<TroopTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildContent.1.2.2.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TroopTagAttr troopTagAttr) {
                                                    TroopTagAttr troopTagAttr2 = troopTagAttr;
                                                    troopTagAttr2.marginTop(4.0f);
                                                    troopTagAttr2.labelList = QSearchCommonItemTemplateView.access$getAttr(QSearchCommonItemTemplateView.this).getData().topLabelList;
                                                    troopTagAttr2.useWrapMode = true;
                                                    troopTagAttr2.wrapMarginTop = 5.0f;
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                if (QSearchCommonItemTemplateView.access$getAttr(QSearchCommonItemTemplateView.this).getData().content.length() > 0) {
                                    final QSearchCommonItemTemplateView qSearchCommonItemTemplateView6 = QSearchCommonItemTemplateView.this;
                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildContent.1.2.2.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final QSearchCommonItemTemplateView qSearchCommonItemTemplateView7 = QSearchCommonItemTemplateView.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildContent.1.2.2.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.marginTop(4.0f);
                                                    ceVar2.text(QSearchCommonItemTemplateView.access$getAttr(QSearchCommonItemTemplateView.this).getData().content);
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
                                }
                                if (!QSearchCommonItemTemplateView.access$getAttr(QSearchCommonItemTemplateView.this).getData().bottomLabelList.isEmpty()) {
                                    final QSearchCommonItemTemplateView qSearchCommonItemTemplateView7 = QSearchCommonItemTemplateView.this;
                                    TroopTagViewKt.TroopTag(vVar4, new Function1<TroopTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildContent.1.2.2.5
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TroopTagView troopTagView) {
                                            final QSearchCommonItemTemplateView qSearchCommonItemTemplateView8 = QSearchCommonItemTemplateView.this;
                                            troopTagView.attr(new Function1<TroopTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildContent.1.2.2.5.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TroopTagAttr troopTagAttr) {
                                                    TroopTagAttr troopTagAttr2 = troopTagAttr;
                                                    troopTagAttr2.marginTop(4.0f);
                                                    troopTagAttr2.labelList = QSearchCommonItemTemplateView.access$getAttr(QSearchCommonItemTemplateView.this).getData().bottomLabelList;
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
                        final QSearchButtonInfo qSearchButtonInfo = QSearchCommonItemTemplateView.access$getAttr(QSearchCommonItemTemplateView.this).getData().commonButton;
                        if (qSearchButtonInfo != null) {
                            final QSearchCommonItemTemplateView qSearchCommonItemTemplateView4 = QSearchCommonItemTemplateView.this;
                            int i3 = qSearchButtonInfo.buttonType;
                            if (i3 != 2 && i3 != 3) {
                                qSearchCommonItemTemplateView4.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildCommonButton$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final QSearchButtonInfo qSearchButtonInfo2 = QSearchButtonInfo.this;
                                        final QSearchCommonItemTemplateView qSearchCommonItemTemplateView5 = qSearchCommonItemTemplateView4;
                                        QSearchGrayBorderButtonViewKt.QSearchGrayBorderButton(viewContainer3, new Function1<QSearchGrayBorderButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildCommonButton$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchGrayBorderButtonView qSearchGrayBorderButtonView) {
                                                QSearchGrayBorderButtonView qSearchGrayBorderButtonView2 = qSearchGrayBorderButtonView;
                                                final QSearchButtonInfo qSearchButtonInfo3 = QSearchButtonInfo.this;
                                                final QSearchCommonItemTemplateView qSearchCommonItemTemplateView6 = qSearchCommonItemTemplateView5;
                                                qSearchGrayBorderButtonView2.attr(new Function1<QSearchGrayBorderButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildCommonButton.1.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr) {
                                                        QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr2 = qSearchGrayBorderButtonAttr;
                                                        qSearchGrayBorderButtonAttr2.marginLeft(12.0f);
                                                        QSearchButtonInfo qSearchButtonInfo4 = QSearchButtonInfo.this;
                                                        qSearchGrayBorderButtonAttr2.text = qSearchButtonInfo4.text;
                                                        qSearchGrayBorderButtonAttr2.status = qSearchButtonInfo4.status;
                                                        qSearchGrayBorderButtonAttr2.alignSelfCenter();
                                                        QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchButtonInfo.this.reportInfo;
                                                        if (qSearchTemplateReportInfo != null) {
                                                            EcommerceExtKt.vr$default(qSearchGrayBorderButtonAttr2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchCommonItemTemplateView6.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                                        }
                                                        qSearchGrayBorderButtonAttr2.accessibility(qSearchGrayBorderButtonAttr2.text + "\u6309\u94ae");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchCommonItemTemplateView qSearchCommonItemTemplateView7 = qSearchCommonItemTemplateView5;
                                                final QSearchButtonInfo qSearchButtonInfo4 = QSearchButtonInfo.this;
                                                qSearchGrayBorderButtonView2.event(new Function1<QSearchGrayBorderButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildCommonButton.1.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchGrayBorderButtonEvent qSearchGrayBorderButtonEvent) {
                                                        final QSearchCommonItemTemplateView qSearchCommonItemTemplateView8 = QSearchCommonItemTemplateView.this;
                                                        final QSearchButtonInfo qSearchButtonInfo5 = qSearchButtonInfo4;
                                                        qSearchGrayBorderButtonEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildCommonButton.1.1.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                QSearchCommonItemTemplateView.this.clickButton(qSearchButtonInfo5);
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
                                }.invoke(vVar2);
                            } else {
                                qSearchCommonItemTemplateView4.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildStatusUpdatableButton$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final QSearchButtonInfo qSearchButtonInfo2 = QSearchButtonInfo.this;
                                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildStatusUpdatableButton$1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                QSearchButtonInfo qSearchButtonInfo3 = QSearchButtonInfo.this;
                                                int i16 = qSearchButtonInfo3.buttonType;
                                                if (i16 == 2) {
                                                    return Integer.valueOf(qSearchButtonInfo3.getJoinGroupStatus());
                                                }
                                                if (i16 != 3) {
                                                    return null;
                                                }
                                                return Integer.valueOf(qSearchButtonInfo3.getJoinGuildStatus());
                                            }
                                        };
                                        final QSearchCommonItemTemplateView qSearchCommonItemTemplateView5 = qSearchCommonItemTemplateView4;
                                        final QSearchButtonInfo qSearchButtonInfo3 = QSearchButtonInfo.this;
                                        BindDirectivesViewKt.a(viewContainer3, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildStatusUpdatableButton$1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                final QSearchCommonItemTemplateView qSearchCommonItemTemplateView6 = QSearchCommonItemTemplateView.this;
                                                final QSearchButtonInfo qSearchButtonInfo4 = qSearchButtonInfo3;
                                                QSearchGrayBorderButtonViewKt.QSearchGrayBorderButton(bindDirectivesView, new Function1<QSearchGrayBorderButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildStatusUpdatableButton.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchGrayBorderButtonView qSearchGrayBorderButtonView) {
                                                        QSearchGrayBorderButtonView qSearchGrayBorderButtonView2 = qSearchGrayBorderButtonView;
                                                        final QSearchButtonInfo qSearchButtonInfo5 = qSearchButtonInfo4;
                                                        final QSearchCommonItemTemplateView qSearchCommonItemTemplateView7 = QSearchCommonItemTemplateView.this;
                                                        qSearchGrayBorderButtonView2.attr(new Function1<QSearchGrayBorderButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildStatusUpdatableButton.1.2.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr) {
                                                                QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr2 = qSearchGrayBorderButtonAttr;
                                                                qSearchGrayBorderButtonAttr2.marginLeft(12.0f);
                                                                QSearchButtonInfo qSearchButtonInfo6 = QSearchButtonInfo.this;
                                                                qSearchGrayBorderButtonAttr2.text = qSearchButtonInfo6.text;
                                                                qSearchGrayBorderButtonAttr2.status = qSearchButtonInfo6.status;
                                                                qSearchGrayBorderButtonAttr2.alignSelfCenter();
                                                                QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchButtonInfo.this.reportInfo;
                                                                if (qSearchTemplateReportInfo != null) {
                                                                    EcommerceExtKt.vr$default(qSearchGrayBorderButtonAttr2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchCommonItemTemplateView7.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                                                }
                                                                qSearchGrayBorderButtonAttr2.accessibility(qSearchGrayBorderButtonAttr2.text + "\u6309\u94ae");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        KLog kLog = KLog.INSTANCE;
                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("buildCommonButton  from title ");
                                                        m3.append(QSearchCommonItemTemplateView.access$getAttr(QSearchCommonItemTemplateView.this).getData().title);
                                                        m3.append("   buttonType:");
                                                        m3.append(qSearchButtonInfo4.buttonType);
                                                        m3.append("  joinGroupStatus:");
                                                        m3.append(qSearchButtonInfo4.getJoinGroupStatus());
                                                        m3.append("  joinGuildStatus:");
                                                        m3.append(qSearchButtonInfo4.getJoinGuildStatus());
                                                        m3.append("  text:");
                                                        m3.append(qSearchButtonInfo4.text);
                                                        m3.append("   status:");
                                                        m3.append(qSearchButtonInfo4.status);
                                                        m3.append(TokenParser.SP);
                                                        kLog.i("QSearchCommonItemTemplateView", m3.toString());
                                                        QSearchButtonInfo qSearchButtonInfo6 = qSearchButtonInfo4;
                                                        int i16 = qSearchButtonInfo6.buttonType;
                                                        if (i16 == 2 ? qSearchButtonInfo6.getJoinGroupStatus() == 1 : i16 != 3 || qSearchButtonInfo6.getJoinGuildStatus() == 0) {
                                                            final QSearchButtonInfo qSearchButtonInfo7 = qSearchButtonInfo4;
                                                            final QSearchCommonItemTemplateView qSearchCommonItemTemplateView8 = QSearchCommonItemTemplateView.this;
                                                            qSearchGrayBorderButtonView2.event(new Function1<QSearchGrayBorderButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildStatusUpdatableButton.1.2.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(QSearchGrayBorderButtonEvent qSearchGrayBorderButtonEvent) {
                                                                    final QSearchButtonInfo qSearchButtonInfo8 = QSearchButtonInfo.this;
                                                                    final QSearchCommonItemTemplateView qSearchCommonItemTemplateView9 = qSearchCommonItemTemplateView8;
                                                                    qSearchGrayBorderButtonEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildStatusUpdatableButton.1.2.1.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
                                                                        
                                                                            if ((5 <= r0 && r0 < 14) != false) goto L22;
                                                                         */
                                                                        /* JADX WARN: Removed duplicated region for block: B:41:0x00a5  */
                                                                        /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
                                                                        /* JADX WARN: Removed duplicated region for block: B:47:0x00b0  */
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        /*
                                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                                        */
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            boolean z16;
                                                                            String str;
                                                                            int i17 = QSearchButtonInfo.this.buttonType;
                                                                            if (i17 == 2) {
                                                                                String str2 = QSearchCommonItemTemplateView.access$getAttr(qSearchCommonItemTemplateView9).keyword;
                                                                                if (new Regex("\\d+").matches(str2)) {
                                                                                    int length = str2.length();
                                                                                    if (6 <= length && length < 10) {
                                                                                        z16 = true;
                                                                                        r1 = QSearchCommonItemTemplateView.access$getAttr(qSearchCommonItemTemplateView9).tabData.tabMask == 6;
                                                                                        QSearchButtonInfo.this.extensionMap.put("subSourceId", String.valueOf(!z16 ? r1 ? 1020 : 1019 : r1 ? 1022 : 1021));
                                                                                    }
                                                                                }
                                                                                z16 = false;
                                                                                if (QSearchCommonItemTemplateView.access$getAttr(qSearchCommonItemTemplateView9).tabData.tabMask == 6) {
                                                                                }
                                                                                QSearchButtonInfo.this.extensionMap.put("subSourceId", String.valueOf(!z16 ? r1 ? 1020 : 1019 : r1 ? 1022 : 1021));
                                                                            } else if (i17 == 3) {
                                                                                boolean z17 = QSearchCommonItemTemplateView.access$getAttr(qSearchCommonItemTemplateView9).tabData.tabMask == 3;
                                                                                String str3 = QSearchCommonItemTemplateView.access$getAttr(qSearchCommonItemTemplateView9).keyword;
                                                                                if (new Regex("^(?=.*[A-Za-z])\\S{5,14}$").matches(str3)) {
                                                                                    int length2 = str3.length();
                                                                                }
                                                                                r1 = false;
                                                                                if (z17) {
                                                                                    if (r1) {
                                                                                        str = "qq_network_search_channel_sub_tab_searchid";
                                                                                    } else {
                                                                                        str = "qq_network_search_channel_sub_tab_keyword";
                                                                                    }
                                                                                } else if (r1) {
                                                                                    str = "qq_network_search_channel_all_tab_searchid";
                                                                                } else {
                                                                                    str = "qq_network_search_channel_all_tab_keyword";
                                                                                }
                                                                                QSearchButtonInfo.this.extensionMap.put("subSource", str);
                                                                            }
                                                                            qSearchCommonItemTemplateView9.clickButton(QSearchButtonInfo.this);
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
                                }.invoke(vVar2);
                            }
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
        return new QSearchCommonItemTemplateAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchCommonItemTemplateEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        QSearchButtonInfo qSearchButtonInfo = ((QSearchCommonItemTemplateAttr) getAttr()).getData().commonButton;
        Integer valueOf = qSearchButtonInfo != null ? Integer.valueOf(qSearchButtonInfo.buttonType) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            this.notifyTroopJoinCb = k.b(Utils.INSTANCE.notifyModule(""), "update_troop_join_status", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$created$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    if (eVar2 != null) {
                        QSearchCommonItemTemplateView qSearchCommonItemTemplateView = QSearchCommonItemTemplateView.this;
                        String p16 = eVar2.p("troop_uin");
                        QSearchButtonInfo qSearchButtonInfo2 = QSearchCommonItemTemplateView.access$getAttr(qSearchCommonItemTemplateView).getData().commonButton;
                        if (Intrinsics.areEqual(p16, qSearchButtonInfo2 != null ? qSearchButtonInfo2.troopUin : null)) {
                            int j3 = eVar2.j("status");
                            QSearchButtonInfo qSearchButtonInfo3 = QSearchCommonItemTemplateView.access$getAttr(qSearchCommonItemTemplateView).getData().commonButton;
                            if (qSearchButtonInfo3 != null) {
                                qSearchButtonInfo3.editJoinGroupStatus(j3);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, 2, null);
        } else if (valueOf != null && valueOf.intValue() == 3) {
            this.notifyGuildJoinCb = k.b(Utils.INSTANCE.notifyModule(""), "update_guild_join_status", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$created$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    QSearchJump qSearchJump;
                    QSearchGuildJump qSearchGuildJump;
                    e eVar2 = eVar;
                    if (eVar2 != null) {
                        QSearchCommonItemTemplateView qSearchCommonItemTemplateView = QSearchCommonItemTemplateView.this;
                        String p16 = eVar2.p("guildId");
                        QSearchButtonInfo qSearchButtonInfo2 = QSearchCommonItemTemplateView.access$getAttr(qSearchCommonItemTemplateView).getData().commonButton;
                        if (Intrinsics.areEqual(p16, String.valueOf((qSearchButtonInfo2 == null || (qSearchJump = qSearchButtonInfo2.jumpInfo) == null || (qSearchGuildJump = qSearchJump.guildJump) == null) ? null : Long.valueOf(qSearchGuildJump.guildId)))) {
                            int j3 = eVar2.j("status");
                            QSearchButtonInfo qSearchButtonInfo3 = QSearchCommonItemTemplateView.access$getAttr(qSearchCommonItemTemplateView).getData().commonButton;
                            if (qSearchButtonInfo3 != null) {
                                qSearchButtonInfo3.editJoinGuildStatus(j3);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean hasValidAvatar() {
        if (((QSearchCommonItemTemplateAttr) getAttr()).getData().avatar.length() > 0) {
            return true;
        }
        return ((QSearchCommonItemTemplateAttr) getAttr()).getData().uin.length() > 0;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        String str = this.notifyTroopJoinCb;
        if (str != null) {
            Utils.INSTANCE.notifyModule("").e("update_troop_join_status", str);
        }
        String str2 = this.notifyGuildJoinCb;
        if (str2 != null) {
            Utils.INSTANCE.notifyModule("").e("update_guild_join_status", str2);
        }
        super.viewDestroyed();
    }
}
