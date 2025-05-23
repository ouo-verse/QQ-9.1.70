package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoView;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageAttr;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageView;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageViewKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.base.module.CalendarModule;
import com.tencent.hippykotlin.demo.pages.base.module.ICalendar;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView;
import com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView$getCurrentPositionMs$1;
import com.tencent.hippykotlin.demo.pages.foundation.view.VideoState;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.DoubleVideoItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchGuildJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchIcon;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchNineBoxGrid;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPicture;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPictureDetail;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchRichText;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchText;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiImageVideoTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchMultiMediaAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchMultiMediaView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchDateUtil;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonViewKt;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextEvent;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
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
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchMultiImageVideoTemplateView extends QSearchBaseTemplateView<QSearchMultiImageVideoTemplateModel, QSearchMultiImageVideoAttr, QQSearchMultiImageVideoEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchMultiImageVideoTemplateView.class, "btnState", "getBtnState()Z", 0)};
    public static final Companion Companion = new Companion();
    public final ReadWriteProperty btnState$delegate = c.a(Boolean.FALSE);
    public String firstVideoFeedPbToken;
    public QSearchJump jumpLink;
    public aa<QSearchSingleVideoView> videoRef;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public static final void access$renderTitle(Companion companion, ViewContainer viewContainer, QSearchText qSearchText, final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView, final List list, final QSearchJump qSearchJump, final QSearchTemplateReportInfo qSearchTemplateReportInfo) {
            companion.getClass();
            final String str = qSearchText != null ? qSearchText.text : null;
            if (str == null || str.length() == 0) {
                return;
            }
            w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$Companion$renderTitle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(v vVar) {
                    v vVar2 = vVar;
                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$Companion$renderTitle$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(t tVar) {
                            t tVar2 = tVar;
                            tVar2.marginTop(10.0f);
                            tVar2.marginBottom(4.0f);
                            return Unit.INSTANCE;
                        }
                    });
                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView2 = qSearchMultiImageVideoTemplateView;
                    final String str2 = str;
                    final QSearchJump qSearchJump2 = QSearchJump.this;
                    final List<RichTextSpanUnit> list2 = list;
                    final QSearchTemplateReportInfo qSearchTemplateReportInfo2 = qSearchTemplateReportInfo;
                    RichTextViewKt.b(vVar2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$Companion$renderTitle$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(RichTextView richTextView) {
                            RichTextView richTextView2 = richTextView;
                            richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.Companion.renderTitle.1.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(RichTextAttr richTextAttr) {
                                    RichTextAttr richTextAttr2 = richTextAttr;
                                    ce.fontSize$default(richTextAttr2, 17.0f, null, 2, null);
                                    richTextAttr2.lines(2);
                                    richTextAttr2.lineBreakMargin(0.1f);
                                    richTextAttr2.fontWeight500();
                                    richTextAttr2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                    return Unit.INSTANCE;
                                }
                            });
                            QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView3 = QSearchMultiImageVideoTemplateView.this;
                            QSearchText qSearchText2 = new QSearchText(str2, qSearchJump2, 12);
                            List<RichTextSpanUnit> list3 = list2;
                            QSearchMultiImageVideoTemplateView.Companion companion2 = QSearchMultiImageVideoTemplateView.Companion;
                            qSearchMultiImageVideoTemplateView3.getClass();
                            new QSearchMultiImageVideoTemplateView$generateSpanByRichTextSpanUnitList$1(list3, qSearchText2, qSearchMultiImageVideoTemplateView3).invoke(richTextView2);
                            QSearchMultiImageVideoTemplateView.Companion companion3 = QSearchMultiImageVideoTemplateView.Companion;
                            QSearchJump qSearchJump3 = qSearchJump2;
                            QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView4 = QSearchMultiImageVideoTemplateView.this;
                            QSearchTemplateReportInfo qSearchTemplateReportInfo3 = qSearchTemplateReportInfo2;
                            companion3.getClass();
                            if (qSearchJump3 != null) {
                                richTextView2.event(new QSearchMultiImageVideoTemplateView$Companion$setupJumpEvent$1(qSearchMultiImageVideoTemplateView4, qSearchJump3, qSearchTemplateReportInfo3));
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    QSearchJump qSearchJump3 = QSearchJump.this;
                    if (qSearchJump3 != null) {
                        QSearchMultiImageVideoTemplateView.Companion companion2 = QSearchMultiImageVideoTemplateView.Companion;
                        QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView3 = qSearchMultiImageVideoTemplateView;
                        QSearchTemplateReportInfo qSearchTemplateReportInfo3 = qSearchTemplateReportInfo;
                        companion2.getClass();
                        vVar2.event(new QSearchMultiImageVideoTemplateView$Companion$setupJumpEvent$1(qSearchMultiImageVideoTemplateView3, qSearchJump3, qSearchTemplateReportInfo3));
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$buildContentInfo(final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView, QSearchNineBoxGrid qSearchNineBoxGrid) {
        final QSearchTemplateReportInfo qSearchTemplateReportInfo;
        boolean isBlank;
        List<RichTextSpanUnit> emptyList;
        Function1<ViewContainer<?, ?>, Unit> function1;
        qSearchMultiImageVideoTemplateView.getClass();
        final QSearchText qSearchText = qSearchNineBoxGrid.text;
        if (qSearchText == null) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildContentInfo$contentText$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        QSearchReportInfo qSearchReportInfo = qSearchText.reportInfo;
        if (qSearchReportInfo != null) {
            QSearchTemplateReportInfo qSearchTemplateReportInfo2 = new QSearchTemplateReportInfo();
            qSearchTemplateReportInfo2.eid = qSearchReportInfo.eid;
            qSearchTemplateReportInfo2.transferInfo = qSearchReportInfo.reportInfo;
            qSearchTemplateReportInfo = qSearchTemplateReportInfo2;
        } else {
            qSearchTemplateReportInfo = null;
        }
        String str = ((QSearchMultiImageVideoAttr) qSearchMultiImageVideoTemplateView.getAttr()).getData().layoutInfo.highlight;
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (isBlank) {
            str = ((QSearchMultiImageVideoAttr) qSearchMultiImageVideoTemplateView.getAttr()).keyword;
        }
        final QSearchText qSearchText2 = qSearchNineBoxGrid.title;
        if ((qSearchText2 != null ? qSearchText2.text : null) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = qSearchMultiImageVideoTemplateView.getRichTextSpanUnit(qSearchText2.text, str, null);
        }
        final List<RichTextSpanUnit> list = emptyList;
        if (qSearchText.text.length() == 0) {
            function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildContentInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                    QSearchMultiImageVideoTemplateView.Companion.access$renderTitle(QSearchMultiImageVideoTemplateView.Companion, viewContainer, QSearchText.this, qSearchMultiImageVideoTemplateView, list, qSearchText.jumpLink, qSearchTemplateReportInfo);
                    return Unit.INSTANCE;
                }
            };
        } else {
            final List<RichTextSpanUnit> richTextSpanUnit = qSearchMultiImageVideoTemplateView.getRichTextSpanUnit(qSearchText.text, str, qSearchNineBoxGrid.richText);
            function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildContentInfo$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                    ViewContainer<?, ?> viewContainer2 = viewContainer;
                    QSearchMultiImageVideoTemplateView.Companion.access$renderTitle(QSearchMultiImageVideoTemplateView.Companion, viewContainer2, QSearchText.this, qSearchMultiImageVideoTemplateView, list, qSearchText.jumpLink, qSearchTemplateReportInfo);
                    final QSearchText qSearchText3 = qSearchText;
                    final QSearchText qSearchText4 = QSearchText.this;
                    final QSearchTemplateReportInfo qSearchTemplateReportInfo3 = qSearchTemplateReportInfo;
                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView2 = qSearchMultiImageVideoTemplateView;
                    final List<RichTextSpanUnit> list2 = richTextSpanUnit;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildContentInfo$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            final QSearchText qSearchText5 = qSearchText4;
                            final QSearchTemplateReportInfo qSearchTemplateReportInfo4 = qSearchTemplateReportInfo3;
                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView3 = qSearchMultiImageVideoTemplateView2;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContentInfo.2.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    QSearchText qSearchText6 = QSearchText.this;
                                    String str2 = qSearchText6 != null ? qSearchText6.text : null;
                                    if (str2 == null || str2.length() == 0) {
                                        tVar2.marginTop(10.0f);
                                    }
                                    QSearchTemplateReportInfo qSearchTemplateReportInfo5 = qSearchTemplateReportInfo4;
                                    if (qSearchTemplateReportInfo5 != null) {
                                        EcommerceExtKt.vr$default(tVar2, null, qSearchTemplateReportInfo5.eid, qSearchTemplateReportInfo5.getReportParams(qSearchMultiImageVideoTemplateView3.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo5.hashCode()), true, 9);
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView4 = qSearchMultiImageVideoTemplateView2;
                            final QSearchText qSearchText6 = QSearchText.this;
                            final List<RichTextSpanUnit> list3 = list2;
                            final QSearchTemplateReportInfo qSearchTemplateReportInfo5 = qSearchTemplateReportInfo3;
                            RichTextViewKt.b(vVar2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContentInfo.2.1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(RichTextView richTextView) {
                                    RichTextView richTextView2 = richTextView;
                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView5 = QSearchMultiImageVideoTemplateView.this;
                                    final QSearchTemplateReportInfo qSearchTemplateReportInfo6 = qSearchTemplateReportInfo5;
                                    richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContentInfo.2.1.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(RichTextAttr richTextAttr) {
                                            RichTextAttr richTextAttr2 = richTextAttr;
                                            ce.fontSize$default(richTextAttr2, 16.0f, null, 2, null);
                                            richTextAttr2.lines(QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().contentLines);
                                            richTextAttr2.textOverFlowTail();
                                            richTextAttr2.textPostProcessor("em_code");
                                            QSearchTemplateReportInfo qSearchTemplateReportInfo7 = qSearchTemplateReportInfo6;
                                            if (qSearchTemplateReportInfo7 != null) {
                                                EcommerceExtKt.vr$default(richTextAttr2, null, qSearchTemplateReportInfo7.eid, qSearchTemplateReportInfo7.getReportParams(QSearchMultiImageVideoTemplateView.this.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo7.hashCode()), true, 9);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView6 = QSearchMultiImageVideoTemplateView.this;
                                    QSearchText qSearchText7 = qSearchText6;
                                    List<RichTextSpanUnit> list4 = list3;
                                    QSearchMultiImageVideoTemplateView.Companion companion = QSearchMultiImageVideoTemplateView.Companion;
                                    qSearchMultiImageVideoTemplateView6.getClass();
                                    new QSearchMultiImageVideoTemplateView$generateSpanByRichTextSpanUnitList$1(list4, qSearchText7, qSearchMultiImageVideoTemplateView6).invoke(richTextView2);
                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView7 = QSearchMultiImageVideoTemplateView.this;
                                    final QSearchText qSearchText8 = qSearchText6;
                                    richTextView2.event(new Function1<RichTextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContentInfo.2.1.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(RichTextEvent richTextEvent) {
                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView8 = QSearchMultiImageVideoTemplateView.this;
                                            final QSearchText qSearchText9 = qSearchText8;
                                            richTextEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContentInfo.2.1.2.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, qSearchText9.jumpLink);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final QSearchText qSearchText7 = QSearchText.this;
                            if (qSearchText7.jumpLink != null) {
                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView5 = qSearchMultiImageVideoTemplateView2;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContentInfo.2.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView6 = QSearchMultiImageVideoTemplateView.this;
                                        final QSearchText qSearchText8 = qSearchText7;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContentInfo.2.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, qSearchText8.jumpLink);
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
        return function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchMultiImageVideoAttr access$getAttr(QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView) {
        return (QSearchMultiImageVideoAttr) qSearchMultiImageVideoTemplateView.getAttr();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView, com.tencent.kuikly.core.base.AbstractBaseView] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void access$jumpWithFeedPbToken(final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView, final QSearchJump qSearchJump) {
        final ?? r26;
        QSearchSingleVideoView b16;
        QQCirVideoView b17;
        aa<QQVideoView> aaVar;
        qSearchMultiImageVideoTemplateView.getClass();
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$jumpWithFeedPbToken$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r10v6, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r11v12, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx>, java.lang.Iterable, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Long l3) {
                Map<String, String> mutableMapOf;
                String str;
                List mutableListOf;
                int indexOf;
                int collectionSizeOrDefault;
                Long l16 = l3;
                String str2 = QSearchMultiImageVideoTemplateView.this.firstVideoFeedPbToken;
                if (str2 == null) {
                    mutableMapOf = null;
                } else {
                    Intrinsics.checkNotNull(str2);
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("feedPb", str2));
                }
                if (mutableMapOf != null) {
                    QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView2 = qSearchMultiImageVideoTemplateView;
                    QSearchJump qSearchJump2 = qSearchJump;
                    QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView3 = QSearchMultiImageVideoTemplateView.this;
                    if (l16 != null) {
                        mutableMapOf.put("playPosition", String.valueOf(l16.longValue()));
                    }
                    mutableMapOf.put("tab_mask", String.valueOf(QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView2).tabData.tabMask));
                    Integer valueOf = qSearchJump2 != null ? Integer.valueOf(qSearchJump2.type) : null;
                    if (valueOf != null && valueOf.intValue() == 7 && (str = qSearchMultiImageVideoTemplateView3.firstVideoFeedPbToken) != null) {
                        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(str);
                        QSearchTabContentViewModel qSearchTabContentViewModel = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView2).viewModel;
                        if (qSearchTabContentViewModel != null) {
                            int size = qSearchTabContentViewModel.getDataList().size();
                            for (int i3 = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView3).index; i3 < size; i3++) {
                                ISearchItemModel iSearchItemModel = qSearchTabContentViewModel.getDataList().get(i3);
                                DoubleVideoItemModel doubleVideoItemModel = iSearchItemModel instanceof DoubleVideoItemModel ? (DoubleVideoItemModel) iSearchItemModel : null;
                                if (doubleVideoItemModel != null) {
                                    ?? r112 = doubleVideoItemModel.dataList;
                                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(r112, 10);
                                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                    Iterator it = r112.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((StFeedEx) it.next()).feedPbToken);
                                    }
                                    mutableListOf.addAll(arrayList);
                                }
                                QSearchMultiImageVideoTemplateModel qSearchMultiImageVideoTemplateModel = iSearchItemModel instanceof QSearchMultiImageVideoTemplateModel ? (QSearchMultiImageVideoTemplateModel) iSearchItemModel : null;
                                if (qSearchMultiImageVideoTemplateModel != null) {
                                    QSearchTemplateReportInfo qSearchTemplateReportInfo = qSearchMultiImageVideoTemplateModel.reportInfo;
                                    if (qSearchTemplateReportInfo != null && QSearchMultiImageVideoTemplateView.access$getBizId(qSearchMultiImageVideoTemplateView3, qSearchTemplateReportInfo) == 12) {
                                        if (qSearchMultiImageVideoTemplateModel.hashCode() == QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView2).getData().hashCode()) {
                                            indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends String>) ((List<? extends Object>) qSearchMultiImageVideoTemplateModel.feedPbTokenList), qSearchMultiImageVideoTemplateView3.firstVideoFeedPbToken);
                                            if (indexOf == -1) {
                                                mutableListOf.addAll(qSearchMultiImageVideoTemplateModel.feedPbTokenList);
                                            } else {
                                                ?? r102 = qSearchMultiImageVideoTemplateModel.feedPbTokenList;
                                                mutableListOf.addAll(r102.subList(indexOf, r102.size() - 1));
                                            }
                                        } else {
                                            mutableListOf.addAll(qSearchMultiImageVideoTemplateModel.feedPbTokenList);
                                        }
                                    }
                                }
                            }
                        }
                        b bVar = new b();
                        Iterator it5 = mutableListOf.iterator();
                        while (it5.hasNext()) {
                            e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("feedPb", (String) it5.next());
                            Unit unit = Unit.INSTANCE;
                            bVar.a(bVar, m3);
                        }
                        mutableMapOf.put("feedPbTokens", bVar.toString());
                    }
                }
                QSearchMultiImageVideoTemplateView.this.doJump(qSearchJump, mutableMapOf);
                return Unit.INSTANCE;
            }
        };
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        aa<QSearchSingleVideoView> aaVar2 = qSearchMultiImageVideoTemplateView.videoRef;
        if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
            aa<QQCirVideoView> aaVar3 = b16.videoRef;
            if (aaVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoRef");
                aaVar3 = null;
            }
            if (aaVar3 != null && (b17 = aaVar3.b()) != null && (aaVar = b17.videoRef) != null) {
                r26 = aaVar.b();
                objectRef.element = r26;
                if (r26 == 0) {
                    final Function1<VideoState, Unit> function12 = new Function1<VideoState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$getVideoPosition$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(VideoState videoState) {
                            if (videoState == VideoState.PLAYING) {
                                QQVideoView qQVideoView = objectRef.element;
                                final Function1<Long, Unit> function13 = function1;
                                Function1<Long, Unit> function14 = new Function1<Long, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$getVideoPosition$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Long l3) {
                                        function13.invoke(Long.valueOf(l3.longValue()));
                                        return Unit.INSTANCE;
                                    }
                                };
                                qQVideoView.getClass();
                                AbstractBaseView.callRenderViewMethod$default(qQVideoView, "getCurrentPositionMs", null, new QQVideoView$getCurrentPositionMs$1(function14), 2, null);
                            } else {
                                function1.invoke(null);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    AbstractBaseView.callRenderViewMethod$default(r26, "getState", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView$getPlayerSate$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar) {
                            e eVar2 = eVar;
                            if (eVar2 != null) {
                                QQVideoView qQVideoView = QQVideoView.this;
                                Function1<VideoState, Unit> function13 = function12;
                                VideoState access$toState = QQVideoViewKt.access$toState(eVar2.j("state"));
                                if (qQVideoView.isWaitingBufferEnd) {
                                    function13.invoke(VideoState.BUFFERING);
                                } else {
                                    function13.invoke(access$toState);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                    return;
                } else {
                    function1.invoke(null);
                    return;
                }
            }
        }
        r26 = 0;
        objectRef.element = r26;
        if (r26 == 0) {
        }
    }

    public static final void access$reportClickDtEvent(QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView, String str, e eVar) {
        qSearchMultiImageVideoTemplateView.getClass();
        eVar.v("dt_pgid", "pg_qq_network_search_result_level2_page");
        eVar.v("dt_eid", str);
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("clck", eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final Function1<ViewContainer<?, ?>, Unit> buildContent() {
        final QSearchNineBoxGrid qSearchNineBoxGrid = ((QSearchMultiImageVideoAttr) getAttr()).getData().contentData;
        if (qSearchNineBoxGrid == null) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildContent$contentData$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView = QSearchMultiImageVideoTemplateView.this;
                final QSearchNineBoxGrid qSearchNineBoxGrid2 = qSearchNineBoxGrid;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildContent$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        if (QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().layoutInfo.showDivider) {
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContent.1.1.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContent.1.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.mo141height(0.5f);
                                            tVar2.absolutePositionAllZero();
                                            tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView2 = QSearchMultiImageVideoTemplateView.this;
                        final QSearchNineBoxGrid qSearchNineBoxGrid3 = qSearchNineBoxGrid2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContent.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Removed duplicated region for block: B:45:0x01af  */
                            /* JADX WARN: Removed duplicated region for block: B:52:0x01bd  */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(v vVar3) {
                                String str;
                                String str2;
                                boolean z16;
                                final String str3;
                                String str4;
                                String sb5;
                                QSearchReportInfo qSearchReportInfo;
                                QSearchTemplateReportInfo qSearchTemplateReportInfo;
                                final QSearchTemplateReportInfo qSearchTemplateReportInfo2;
                                QSearchButton qSearchButton;
                                Function1 function1;
                                QSearchReportInfo qSearchReportInfo2;
                                final String str5;
                                Function1<ViewContainer<?, ?>, Unit> function12;
                                String str6;
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContent.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.paddingTop(12.0f).paddingBottom(12.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView3 = QSearchMultiImageVideoTemplateView.this;
                                final QSearchNineBoxGrid qSearchNineBoxGrid4 = qSearchNineBoxGrid3;
                                QSearchMultiImageVideoTemplateView.Companion companion = QSearchMultiImageVideoTemplateView.Companion;
                                qSearchMultiImageVideoTemplateView3.getClass();
                                final QSearchIcon qSearchIcon = qSearchNineBoxGrid4.icon;
                                if (qSearchIcon == null) {
                                    function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildBaseInfo$baseInfo$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    str2 = "";
                                    z16 = true;
                                } else {
                                    QSearchText qSearchText = qSearchIcon.subTitle;
                                    if (qSearchText == null || (str = qSearchText.text) == null) {
                                        str = "";
                                    }
                                    if (str.length() > 0) {
                                        str3 = str;
                                        str2 = "";
                                    } else {
                                        if (qSearchIcon.timestamp == 0) {
                                            str2 = "";
                                            z16 = true;
                                            str3 = str2;
                                        } else {
                                            QSearchDateUtil qSearchDateUtil = QSearchDateUtil.INSTANCE;
                                            CalendarModule calendarModule = IPagerIdKtxKt.getCalendarModule(qSearchMultiImageVideoTemplateView3);
                                            int i3 = CalendarModule.$r8$clinit;
                                            str2 = "";
                                            CalendarModule.Calendar calendar = (CalendarModule.Calendar) calendarModule.newCalendarInstance(0L);
                                            CalendarModule.Calendar calendar2 = (CalendarModule.Calendar) IPagerIdKtxKt.getCalendarModule(qSearchMultiImageVideoTemplateView3).newCalendarInstance(qSearchIcon.timestamp * 1000);
                                            if (calendar.timeInMillis() - calendar2.timeInMillis() < 0) {
                                                str3 = str2;
                                            } else {
                                                int i16 = calendar2.get(ICalendar.Field.HOUR_OF_DAY);
                                                int i17 = calendar2.get(ICalendar.Field.MINUS);
                                                long timeInMillis = (((calendar.timeInMillis() - (((calendar.get(r10) * 60) * 60) * 1000)) - ((calendar.get(r14) * 60) * 1000)) - (calendar.get(ICalendar.Field.SECOND) * 1000)) - calendar2.timeInMillis();
                                                if (timeInMillis < 0) {
                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4eca\u5929");
                                                    m3.append(qSearchDateUtil.doubleD(i16));
                                                    m3.append(':');
                                                    m3.append(qSearchDateUtil.doubleD(i17));
                                                    sb5 = m3.toString();
                                                } else if (timeInMillis < 86400000) {
                                                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u6628\u5929");
                                                    m16.append(qSearchDateUtil.doubleD(i16));
                                                    m16.append(':');
                                                    m16.append(qSearchDateUtil.doubleD(i17));
                                                    sb5 = m16.toString();
                                                } else if (timeInMillis < 172800000) {
                                                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u524d\u5929");
                                                    m17.append(qSearchDateUtil.doubleD(i16));
                                                    m17.append(':');
                                                    m17.append(qSearchDateUtil.doubleD(i17));
                                                    sb5 = m17.toString();
                                                } else {
                                                    ICalendar.Field field = ICalendar.Field.YEAR;
                                                    int i18 = calendar2.get(field);
                                                    z16 = true;
                                                    int i19 = calendar2.get(ICalendar.Field.MONTH) + 1;
                                                    int i26 = calendar2.get(ICalendar.Field.DAY_OF_MONTH);
                                                    if (calendar.get(field) == i18) {
                                                        str4 = qSearchDateUtil.doubleD(i19) + '\u6708' + qSearchDateUtil.doubleD(i26) + '\u65e5' + qSearchDateUtil.doubleD(i16) + ':' + qSearchDateUtil.doubleD(i17);
                                                    } else {
                                                        str4 = i18 + '\u5e74' + qSearchDateUtil.doubleD(i19) + '\u6708' + qSearchDateUtil.doubleD(i26) + "\u65e5 " + qSearchDateUtil.doubleD(i16) + ':' + qSearchDateUtil.doubleD(i17);
                                                    }
                                                    str3 = str4;
                                                }
                                                str3 = sb5;
                                            }
                                        }
                                        qSearchReportInfo = qSearchIcon.reportInfo;
                                        qSearchTemplateReportInfo = null;
                                        if (qSearchReportInfo == null) {
                                            qSearchTemplateReportInfo2 = new QSearchTemplateReportInfo();
                                            qSearchTemplateReportInfo2.eid = qSearchReportInfo.eid;
                                            qSearchTemplateReportInfo2.transferInfo = qSearchReportInfo.reportInfo;
                                        } else {
                                            qSearchTemplateReportInfo2 = null;
                                        }
                                        qSearchButton = qSearchNineBoxGrid4.button;
                                        if (qSearchButton != null && (qSearchReportInfo2 = qSearchButton.reportInfo) != null) {
                                            qSearchTemplateReportInfo = new QSearchTemplateReportInfo();
                                            qSearchTemplateReportInfo.eid = qSearchReportInfo2.eid;
                                            qSearchTemplateReportInfo.transferInfo = qSearchReportInfo2.reportInfo;
                                        }
                                        final QSearchTemplateReportInfo qSearchTemplateReportInfo3 = qSearchTemplateReportInfo;
                                        function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildBaseInfo$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                                final QSearchIcon qSearchIcon2 = QSearchIcon.this;
                                                final QSearchNineBoxGrid qSearchNineBoxGrid5 = qSearchNineBoxGrid4;
                                                final QSearchTemplateReportInfo qSearchTemplateReportInfo4 = qSearchTemplateReportInfo2;
                                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView4 = qSearchMultiImageVideoTemplateView3;
                                                final String str7 = str3;
                                                final QSearchTemplateReportInfo qSearchTemplateReportInfo5 = qSearchTemplateReportInfo3;
                                                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildBaseInfo$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        boolean isBlank;
                                                        boolean isBlank2;
                                                        QSearchJump qSearchJump;
                                                        QSearchGuildJump qSearchGuildJump;
                                                        QSearchJump qSearchJump2;
                                                        v vVar6 = vVar5;
                                                        final QSearchTemplateReportInfo qSearchTemplateReportInfo6 = qSearchTemplateReportInfo4;
                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView5 = qSearchMultiImageVideoTemplateView4;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionRow();
                                                                tVar2.alignItemsCenter();
                                                                QSearchTemplateReportInfo qSearchTemplateReportInfo7 = QSearchTemplateReportInfo.this;
                                                                if (qSearchTemplateReportInfo7 != null) {
                                                                    EcommerceExtKt.vr$default(tVar2, null, qSearchTemplateReportInfo7.eid, qSearchTemplateReportInfo7.getReportParams(qSearchMultiImageVideoTemplateView5.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo7.hashCode()), true, 9);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        isBlank = StringsKt__StringsJVMKt.isBlank(QSearchIcon.this.iconLink);
                                                        if (!(!isBlank)) {
                                                            isBlank2 = StringsKt__StringsJVMKt.isBlank(QSearchIcon.this.uin);
                                                            if (!isBlank2) {
                                                                final QSearchIcon qSearchIcon3 = QSearchIcon.this;
                                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar7) {
                                                                        final String str8;
                                                                        QSearchPicture qSearchPicture;
                                                                        v vVar8 = vVar7;
                                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.3.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.size(38.0f, 38.0f);
                                                                                tVar2.marginRight(8.0f);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QSearchIcon qSearchIcon4 = QSearchIcon.this;
                                                                        QQFaceImageViewKt.QQFaceImage(vVar8, new Function1<QQFaceImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.3.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(QQFaceImageView qQFaceImageView) {
                                                                                final QSearchIcon qSearchIcon5 = QSearchIcon.this;
                                                                                qQFaceImageView.attr(new Function1<QQFaceImageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.3.2.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(QQFaceImageAttr qQFaceImageAttr) {
                                                                                        QQFaceImageAttr qQFaceImageAttr2 = qQFaceImageAttr;
                                                                                        qQFaceImageAttr2.size(38.0f, 38.0f);
                                                                                        qQFaceImageAttr2.src(QSearchIcon.this.uin, 0);
                                                                                        qQFaceImageAttr2.borderRadius(4.0f);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        QSearchPictureDetail qSearchPictureDetail = QSearchIcon.this.auth;
                                                                        if (qSearchPictureDetail == null || (qSearchPicture = qSearchPictureDetail.small) == null || (str8 = qSearchPicture.picLink) == null) {
                                                                            str8 = "";
                                                                        }
                                                                        if (str8.length() > 0) {
                                                                            ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.3.3
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ImageView imageView) {
                                                                                    final String str9 = str8;
                                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.3.3.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(af afVar) {
                                                                                            af afVar2 = afVar;
                                                                                            afVar2.positionAbsolute();
                                                                                            afVar2.m142left(20.0f);
                                                                                            afVar2.m150top(20.0f);
                                                                                            afVar2.size(12.0f, 12.0f);
                                                                                            b.a.b(afVar2, str9, false, 2, null);
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
                                                            }
                                                        } else {
                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView6 = qSearchMultiImageVideoTemplateView4;
                                                            final QSearchIcon qSearchIcon4 = QSearchIcon.this;
                                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar7) {
                                                                    final String str8;
                                                                    QSearchPicture qSearchPicture;
                                                                    v vVar8 = vVar7;
                                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.size(38.0f, 38.0f);
                                                                            tVar2.marginRight(8.0f);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    if (QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().nineBoxGridType == 1) {
                                                                        final QSearchIcon qSearchIcon5 = qSearchIcon4;
                                                                        if (qSearchIcon5.iconType == 1) {
                                                                            ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.2
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ImageView imageView) {
                                                                                    final QSearchIcon qSearchIcon6 = QSearchIcon.this;
                                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.2.1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(af afVar) {
                                                                                            af afVar2 = afVar;
                                                                                            afVar2.size(38.0f, 38.0f);
                                                                                            afVar2.borderRadius(19.0f);
                                                                                            b.a.b(afVar2, QSearchIcon.this.iconLink, false, 2, null);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                        } else {
                                                                            ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.3
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ImageView imageView) {
                                                                                    final QSearchIcon qSearchIcon6 = QSearchIcon.this;
                                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.3.1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(af afVar) {
                                                                                            af afVar2 = afVar;
                                                                                            afVar2.size(38.0f, 38.0f);
                                                                                            afVar2.borderRadius(4.0f);
                                                                                            b.a.b(afVar2, QSearchIcon.this.iconLink, false, 2, null);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                        }
                                                                    } else {
                                                                        final QSearchIcon qSearchIcon6 = qSearchIcon4;
                                                                        ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.4
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                final QSearchIcon qSearchIcon7 = QSearchIcon.this;
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.4.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        afVar2.size(38.0f, 38.0f);
                                                                                        afVar2.borderRadius(4.0f);
                                                                                        b.a.b(afVar2, QSearchIcon.this.iconLink, false, 2, null);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                    }
                                                                    QSearchPictureDetail qSearchPictureDetail = qSearchIcon4.auth;
                                                                    if (qSearchPictureDetail == null || (qSearchPicture = qSearchPictureDetail.small) == null || (str8 = qSearchPicture.picLink) == null) {
                                                                        str8 = "";
                                                                    }
                                                                    if (str8.length() > 0) {
                                                                        ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.5
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                final String str9 = str8;
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.5.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        afVar2.positionAbsolute();
                                                                                        afVar2.m142left(20.0f);
                                                                                        afVar2.m150top(20.0f);
                                                                                        afVar2.size(12.0f, 12.0f);
                                                                                        b.a.b(afVar2, str9, false, 2, null);
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
                                                        }
                                                        final QSearchIcon qSearchIcon5 = QSearchIcon.this;
                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView7 = qSearchMultiImageVideoTemplateView4;
                                                        final String str8 = str7;
                                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                final String str9;
                                                                QSearchIcon qSearchIcon6;
                                                                v vVar8 = vVar7;
                                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        tVar.m140flex(1.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                QSearchText qSearchText2 = QSearchIcon.this.title;
                                                                if (qSearchText2 == null || (str9 = qSearchText2.text) == null) {
                                                                    str9 = "";
                                                                }
                                                                if (str9.length() > 0) {
                                                                    KLog kLog = KLog.INSTANCE;
                                                                    StringBuilder m18 = CacheDiskLru$$ExternalSyntheticOutline0.m("buildBaseInfo:    nickName:", str9, "    nineBoxGridType:");
                                                                    m18.append(QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView7).getData().nineBoxGridType);
                                                                    m18.append("     icon.type:");
                                                                    QSearchNineBoxGrid qSearchNineBoxGrid6 = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView7).getData().contentData;
                                                                    m18.append((qSearchNineBoxGrid6 == null || (qSearchIcon6 = qSearchNineBoxGrid6.icon) == null) ? null : Integer.valueOf(qSearchIcon6.iconType));
                                                                    kLog.i("QSearchMultiImageVideoTemplateView", m18.toString());
                                                                    final QSearchIcon qSearchIcon7 = QSearchIcon.this;
                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView8 = qSearchMultiImageVideoTemplateView7;
                                                                    cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            TextView textView2 = textView;
                                                                            final String str10 = str9;
                                                                            textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.2.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ceVar2.marginBottom(4.0f);
                                                                                    ceVar2.text(str10);
                                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                    ceVar2.lines(1);
                                                                                    ceVar2.textOverFlowTail();
                                                                                    ceVar2.fontWeight600();
                                                                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final QSearchIcon qSearchIcon8 = QSearchIcon.this;
                                                                            QSearchText qSearchText3 = qSearchIcon8.title;
                                                                            if ((qSearchText3 != null ? qSearchText3.jumpLink : null) != null) {
                                                                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = qSearchMultiImageVideoTemplateView8;
                                                                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.2.2
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(TextEvent textEvent) {
                                                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView10 = QSearchMultiImageVideoTemplateView.this;
                                                                                        final QSearchIcon qSearchIcon9 = qSearchIcon8;
                                                                                        textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.2.2.1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                                QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, qSearchIcon9.title.jumpLink);
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
                                                                }
                                                                final String str10 = str8;
                                                                final QSearchIcon qSearchIcon8 = QSearchIcon.this;
                                                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = qSearchMultiImageVideoTemplateView7;
                                                                w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar9) {
                                                                        final String str11;
                                                                        QSearchText qSearchText3;
                                                                        String str12;
                                                                        v vVar10 = vVar9;
                                                                        vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.flexDirectionRow();
                                                                                tVar2.alignItemsCenter();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        if (str10.length() > 0) {
                                                                            final QSearchIcon qSearchIcon9 = qSearchIcon8;
                                                                            final String str13 = str10;
                                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView10 = qSearchMultiImageVideoTemplateView9;
                                                                            cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.2
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(TextView textView) {
                                                                                    TextView textView2 = textView;
                                                                                    final String str14 = str13;
                                                                                    textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.2.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ce ceVar) {
                                                                                            ce ceVar2 = ceVar;
                                                                                            ceVar2.text(str14);
                                                                                            ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                            ceVar2.lines(1);
                                                                                            ceVar2.textOverFlowTail();
                                                                                            ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    final QSearchIcon qSearchIcon10 = QSearchIcon.this;
                                                                                    QSearchText qSearchText4 = qSearchIcon10.subTitle;
                                                                                    if ((qSearchText4 != null ? qSearchText4.jumpLink : null) != null) {
                                                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView11 = qSearchMultiImageVideoTemplateView10;
                                                                                        textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.2.2
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(TextEvent textEvent) {
                                                                                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView12 = QSearchMultiImageVideoTemplateView.this;
                                                                                                final QSearchIcon qSearchIcon11 = qSearchIcon10;
                                                                                                textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.2.2.1
                                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                    {
                                                                                                        super(1);
                                                                                                    }

                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                                        QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, qSearchIcon11.subTitle.jumpLink);
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
                                                                        }
                                                                        QSearchIcon qSearchIcon10 = qSearchIcon8.visibleRange;
                                                                        final String str14 = "";
                                                                        if (qSearchIcon10 == null || (str11 = qSearchIcon10.iconLink) == null) {
                                                                            str11 = "";
                                                                        }
                                                                        if (qSearchIcon10 != null && (qSearchText3 = qSearchIcon10.title) != null && (str12 = qSearchText3.text) != null) {
                                                                            str14 = str12;
                                                                        }
                                                                        if (str11.length() > 0) {
                                                                            if (str14.length() > 0) {
                                                                                ah.a(vVar10, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.3
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ImageView imageView) {
                                                                                        final String str15 = str11;
                                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.3.1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(af afVar) {
                                                                                                af afVar2 = afVar;
                                                                                                afVar2.size(12.0f, 12.0f);
                                                                                                b.a.b(afVar2, str15, false, 2, null);
                                                                                                afVar2.marginLeft(4.0f);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.4
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(TextView textView) {
                                                                                        final String str15 = str14;
                                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.4.1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ce ceVar) {
                                                                                                ce ceVar2 = ceVar;
                                                                                                ceVar2.text(str15);
                                                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                                ceVar2.marginLeft(4.0f);
                                                                                                ceVar2.lines(1);
                                                                                                ceVar2.textOverFlowTail();
                                                                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        QSearchButton qSearchButton2 = qSearchNineBoxGrid5.button;
                                                        Integer num = null;
                                                        if (((qSearchButton2 == null || (qSearchJump2 = qSearchButton2.jumpLink) == null) ? null : qSearchJump2.guildJump) != null) {
                                                            Utils utils = Utils.INSTANCE;
                                                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QSearchMultiImageVideoTemplateView init guild addBtn: ");
                                                            QSearchText qSearchText2 = QSearchIcon.this.title;
                                                            m18.append(qSearchText2 != null ? qSearchText2.text : null);
                                                            m18.append(TokenParser.SP);
                                                            QSearchButton qSearchButton3 = qSearchNineBoxGrid5.button;
                                                            if (qSearchButton3 != null && (qSearchJump = qSearchButton3.jumpLink) != null && (qSearchGuildJump = qSearchJump.guildJump) != null) {
                                                                num = Integer.valueOf(qSearchGuildJump.joinStatus);
                                                            }
                                                            m18.append(num);
                                                            utils.logToNative(m18.toString());
                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView8 = qSearchMultiImageVideoTemplateView4;
                                                            Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.5
                                                                {
                                                                    super(0);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Object invoke() {
                                                                    QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = QSearchMultiImageVideoTemplateView.this;
                                                                    return Boolean.valueOf(((Boolean) qSearchMultiImageVideoTemplateView9.btnState$delegate.getValue(qSearchMultiImageVideoTemplateView9, QSearchMultiImageVideoTemplateView.$$delegatedProperties[0])).booleanValue());
                                                                }
                                                            };
                                                            final QSearchNineBoxGrid qSearchNineBoxGrid6 = qSearchNineBoxGrid5;
                                                            final QSearchTemplateReportInfo qSearchTemplateReportInfo7 = qSearchTemplateReportInfo5;
                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = qSearchMultiImageVideoTemplateView4;
                                                            BindDirectivesViewKt.a(vVar6, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                                    final QSearchNineBoxGrid qSearchNineBoxGrid7 = QSearchNineBoxGrid.this;
                                                                    final QSearchTemplateReportInfo qSearchTemplateReportInfo8 = qSearchTemplateReportInfo7;
                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView10 = qSearchMultiImageVideoTemplateView9;
                                                                    w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(v vVar7) {
                                                                            final QSearchNineBoxGrid qSearchNineBoxGrid8 = QSearchNineBoxGrid.this;
                                                                            final QSearchTemplateReportInfo qSearchTemplateReportInfo9 = qSearchTemplateReportInfo8;
                                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView11 = qSearchMultiImageVideoTemplateView10;
                                                                            QSearchGrayBorderButtonViewKt.QSearchGrayBorderButton(vVar7, new Function1<QSearchGrayBorderButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6.1.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
                                                                                
                                                                                    if (r1.joinStatus == 1) goto L12;
                                                                                 */
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                /*
                                                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                                                */
                                                                                public final Unit invoke(QSearchGrayBorderButtonView qSearchGrayBorderButtonView) {
                                                                                    QSearchJump qSearchJump3;
                                                                                    QSearchGrayBorderButtonView qSearchGrayBorderButtonView2 = qSearchGrayBorderButtonView;
                                                                                    final QSearchNineBoxGrid qSearchNineBoxGrid9 = QSearchNineBoxGrid.this;
                                                                                    final QSearchTemplateReportInfo qSearchTemplateReportInfo10 = qSearchTemplateReportInfo9;
                                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView12 = qSearchMultiImageVideoTemplateView11;
                                                                                    qSearchGrayBorderButtonView2.attr(new Function1<QSearchGrayBorderButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6.1.1.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr) {
                                                                                            QSearchJump qSearchJump4;
                                                                                            QSearchGuildJump qSearchGuildJump2;
                                                                                            QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr2 = qSearchGrayBorderButtonAttr;
                                                                                            QSearchButton qSearchButton4 = QSearchNineBoxGrid.this.button;
                                                                                            if ((qSearchButton4 == null || (qSearchJump4 = qSearchButton4.jumpLink) == null || (qSearchGuildJump2 = qSearchJump4.guildJump) == null || qSearchGuildJump2.joinStatus != 2) ? false : true) {
                                                                                                qSearchGrayBorderButtonAttr2.text = "\u5df2\u52a0\u5165";
                                                                                                qSearchGrayBorderButtonAttr2.status = 2;
                                                                                            } else {
                                                                                                qSearchGrayBorderButtonAttr2.text = "\u52a0\u5165";
                                                                                                qSearchGrayBorderButtonAttr2.status = 0;
                                                                                            }
                                                                                            QSearchTemplateReportInfo qSearchTemplateReportInfo11 = qSearchTemplateReportInfo10;
                                                                                            if (qSearchTemplateReportInfo11 != null) {
                                                                                                EcommerceExtKt.vr$default(qSearchGrayBorderButtonAttr2, null, qSearchTemplateReportInfo11.eid, qSearchTemplateReportInfo11.getReportParams(qSearchMultiImageVideoTemplateView12.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo11.hashCode()), true, 9);
                                                                                            }
                                                                                            qSearchGrayBorderButtonAttr2.accessibility(qSearchGrayBorderButtonAttr2.text + "\u6309\u94ae");
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    final QSearchNineBoxGrid qSearchNineBoxGrid10 = QSearchNineBoxGrid.this;
                                                                                    QSearchButton qSearchButton4 = qSearchNineBoxGrid10.button;
                                                                                    boolean z17 = (qSearchButton4 == null || (qSearchJump3 = qSearchButton4.jumpLink) == null || (r1 = qSearchJump3.guildJump) == null) ? false : true;
                                                                                    if (z17) {
                                                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView13 = qSearchMultiImageVideoTemplateView11;
                                                                                        qSearchGrayBorderButtonView2.event(new Function1<QSearchGrayBorderButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6.1.1.2
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
                                                                                            
                                                                                                if ((5 <= r3 && r3 < 14) != false) goto L17;
                                                                                             */
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            /*
                                                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                                                            */
                                                                                            public final Unit invoke(QSearchGrayBorderButtonEvent qSearchGrayBorderButtonEvent) {
                                                                                                final String str9;
                                                                                                QSearchGrayBorderButtonEvent qSearchGrayBorderButtonEvent2 = qSearchGrayBorderButtonEvent;
                                                                                                boolean z18 = true;
                                                                                                boolean z19 = QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).tabData.tabMask == 3;
                                                                                                String str10 = QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).keyword;
                                                                                                if (new Regex("^(?=.*[A-Za-z])\\S{5,14}$").matches(str10)) {
                                                                                                    int length = str10.length();
                                                                                                }
                                                                                                z18 = false;
                                                                                                if (z19) {
                                                                                                    if (z18) {
                                                                                                        str9 = "qq_network_search_post_sub_tab_searchid";
                                                                                                    } else {
                                                                                                        str9 = "qq_network_search_post_sub_tab_keyword";
                                                                                                    }
                                                                                                } else if (z18) {
                                                                                                    str9 = "qq_network_search_post_all_tab_searchid";
                                                                                                } else {
                                                                                                    str9 = "qq_network_search_post_all_tab_keyword";
                                                                                                }
                                                                                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView14 = QSearchMultiImageVideoTemplateView.this;
                                                                                                final QSearchNineBoxGrid qSearchNineBoxGrid11 = qSearchNineBoxGrid10;
                                                                                                qSearchGrayBorderButtonEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6.1.1.2.1
                                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                    {
                                                                                                        super(1);
                                                                                                    }

                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView15 = QSearchMultiImageVideoTemplateView.this;
                                                                                                        final QSearchNineBoxGrid qSearchNineBoxGrid12 = qSearchNineBoxGrid11;
                                                                                                        QSearchGuildJump qSearchGuildJump2 = qSearchNineBoxGrid12.button.jumpLink.guildJump;
                                                                                                        String str11 = str9;
                                                                                                        Function1<e, Unit> function13 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6.1.1.2.1.1
                                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                            {
                                                                                                                super(1);
                                                                                                            }

                                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                                            public final Unit invoke(e eVar) {
                                                                                                                QSearchJump qSearchJump4;
                                                                                                                e eVar2 = eVar;
                                                                                                                int j3 = eVar2 != null ? eVar2.j("code") : -1;
                                                                                                                if (j3 == 0) {
                                                                                                                    QSearchButton qSearchButton5 = QSearchNineBoxGrid.this.button;
                                                                                                                    QSearchGuildJump qSearchGuildJump3 = (qSearchButton5 == null || (qSearchJump4 = qSearchButton5.jumpLink) == null) ? null : qSearchJump4.guildJump;
                                                                                                                    if (qSearchGuildJump3 != null) {
                                                                                                                        qSearchGuildJump3.joinStatus = 2;
                                                                                                                    }
                                                                                                                    QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView16 = qSearchMultiImageVideoTemplateView15;
                                                                                                                    qSearchMultiImageVideoTemplateView16.btnState$delegate.setValue(qSearchMultiImageVideoTemplateView16, QSearchMultiImageVideoTemplateView.$$delegatedProperties[0], Boolean.TRUE);
                                                                                                                } else {
                                                                                                                    Utils.INSTANCE.logToNative("QSearchMultiImageVideoTemplateView joinGuildChannel failed, code=" + j3);
                                                                                                                }
                                                                                                                return Unit.INSTANCE;
                                                                                                            }
                                                                                                        };
                                                                                                        QSearchMultiImageVideoTemplateView.Companion companion2 = QSearchMultiImageVideoTemplateView.Companion;
                                                                                                        qSearchMultiImageVideoTemplateView15.getClass();
                                                                                                        e eVar = new e();
                                                                                                        eVar.v("guildId", String.valueOf(qSearchGuildJump2.guildId));
                                                                                                        eVar.v("joinGuildSig", qSearchGuildJump2.joinGuildSig);
                                                                                                        eVar.v("mainSource", "search");
                                                                                                        eVar.v("subSource", str11);
                                                                                                        Utils.INSTANCE.currentBridgeModule().callNativeMethod("joinGuildChannel", eVar, function13);
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
                                                        }
                                                        final QSearchIcon qSearchIcon6 = QSearchIcon.this;
                                                        if (qSearchIcon6.jumpLink != null) {
                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView10 = qSearchMultiImageVideoTemplateView4;
                                                            vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.7
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(u uVar) {
                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView11 = QSearchMultiImageVideoTemplateView.this;
                                                                    final QSearchIcon qSearchIcon7 = qSearchIcon6;
                                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.7.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, qSearchIcon7.jumpLink);
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
                                    z16 = true;
                                    qSearchReportInfo = qSearchIcon.reportInfo;
                                    qSearchTemplateReportInfo = null;
                                    if (qSearchReportInfo == null) {
                                    }
                                    qSearchButton = qSearchNineBoxGrid4.button;
                                    if (qSearchButton != null) {
                                        qSearchTemplateReportInfo = new QSearchTemplateReportInfo();
                                        qSearchTemplateReportInfo.eid = qSearchReportInfo2.eid;
                                        qSearchTemplateReportInfo.transferInfo = qSearchReportInfo2.reportInfo;
                                    }
                                    final QSearchTemplateReportInfo qSearchTemplateReportInfo32 = qSearchTemplateReportInfo;
                                    function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildBaseInfo$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final QSearchIcon qSearchIcon2 = QSearchIcon.this;
                                            final QSearchNineBoxGrid qSearchNineBoxGrid5 = qSearchNineBoxGrid4;
                                            final QSearchTemplateReportInfo qSearchTemplateReportInfo4 = qSearchTemplateReportInfo2;
                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView4 = qSearchMultiImageVideoTemplateView3;
                                            final String str7 = str3;
                                            final QSearchTemplateReportInfo qSearchTemplateReportInfo5 = qSearchTemplateReportInfo32;
                                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildBaseInfo$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    boolean isBlank;
                                                    boolean isBlank2;
                                                    QSearchJump qSearchJump;
                                                    QSearchGuildJump qSearchGuildJump;
                                                    QSearchJump qSearchJump2;
                                                    v vVar6 = vVar5;
                                                    final QSearchTemplateReportInfo qSearchTemplateReportInfo6 = qSearchTemplateReportInfo4;
                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView5 = qSearchMultiImageVideoTemplateView4;
                                                    vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.flexDirectionRow();
                                                            tVar2.alignItemsCenter();
                                                            QSearchTemplateReportInfo qSearchTemplateReportInfo7 = QSearchTemplateReportInfo.this;
                                                            if (qSearchTemplateReportInfo7 != null) {
                                                                EcommerceExtKt.vr$default(tVar2, null, qSearchTemplateReportInfo7.eid, qSearchTemplateReportInfo7.getReportParams(qSearchMultiImageVideoTemplateView5.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo7.hashCode()), true, 9);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    isBlank = StringsKt__StringsJVMKt.isBlank(QSearchIcon.this.iconLink);
                                                    if (!(!isBlank)) {
                                                        isBlank2 = StringsKt__StringsJVMKt.isBlank(QSearchIcon.this.uin);
                                                        if (!isBlank2) {
                                                            final QSearchIcon qSearchIcon3 = QSearchIcon.this;
                                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar7) {
                                                                    final String str8;
                                                                    QSearchPicture qSearchPicture;
                                                                    v vVar8 = vVar7;
                                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.3.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.size(38.0f, 38.0f);
                                                                            tVar2.marginRight(8.0f);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final QSearchIcon qSearchIcon4 = QSearchIcon.this;
                                                                    QQFaceImageViewKt.QQFaceImage(vVar8, new Function1<QQFaceImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.3.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(QQFaceImageView qQFaceImageView) {
                                                                            final QSearchIcon qSearchIcon5 = QSearchIcon.this;
                                                                            qQFaceImageView.attr(new Function1<QQFaceImageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.3.2.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(QQFaceImageAttr qQFaceImageAttr) {
                                                                                    QQFaceImageAttr qQFaceImageAttr2 = qQFaceImageAttr;
                                                                                    qQFaceImageAttr2.size(38.0f, 38.0f);
                                                                                    qQFaceImageAttr2.src(QSearchIcon.this.uin, 0);
                                                                                    qQFaceImageAttr2.borderRadius(4.0f);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    QSearchPictureDetail qSearchPictureDetail = QSearchIcon.this.auth;
                                                                    if (qSearchPictureDetail == null || (qSearchPicture = qSearchPictureDetail.small) == null || (str8 = qSearchPicture.picLink) == null) {
                                                                        str8 = "";
                                                                    }
                                                                    if (str8.length() > 0) {
                                                                        ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.3.3
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                final String str9 = str8;
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.3.3.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        afVar2.positionAbsolute();
                                                                                        afVar2.m142left(20.0f);
                                                                                        afVar2.m150top(20.0f);
                                                                                        afVar2.size(12.0f, 12.0f);
                                                                                        b.a.b(afVar2, str9, false, 2, null);
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
                                                        }
                                                    } else {
                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView6 = qSearchMultiImageVideoTemplateView4;
                                                        final QSearchIcon qSearchIcon4 = QSearchIcon.this;
                                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                final String str8;
                                                                QSearchPicture qSearchPicture;
                                                                v vVar8 = vVar7;
                                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.size(38.0f, 38.0f);
                                                                        tVar2.marginRight(8.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                if (QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().nineBoxGridType == 1) {
                                                                    final QSearchIcon qSearchIcon5 = qSearchIcon4;
                                                                    if (qSearchIcon5.iconType == 1) {
                                                                        ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                final QSearchIcon qSearchIcon6 = QSearchIcon.this;
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.2.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        afVar2.size(38.0f, 38.0f);
                                                                                        afVar2.borderRadius(19.0f);
                                                                                        b.a.b(afVar2, QSearchIcon.this.iconLink, false, 2, null);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                    } else {
                                                                        ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                final QSearchIcon qSearchIcon6 = QSearchIcon.this;
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.3.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        afVar2.size(38.0f, 38.0f);
                                                                                        afVar2.borderRadius(4.0f);
                                                                                        b.a.b(afVar2, QSearchIcon.this.iconLink, false, 2, null);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                    }
                                                                } else {
                                                                    final QSearchIcon qSearchIcon6 = qSearchIcon4;
                                                                    ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.4
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            final QSearchIcon qSearchIcon7 = QSearchIcon.this;
                                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.4.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(af afVar) {
                                                                                    af afVar2 = afVar;
                                                                                    afVar2.size(38.0f, 38.0f);
                                                                                    afVar2.borderRadius(4.0f);
                                                                                    b.a.b(afVar2, QSearchIcon.this.iconLink, false, 2, null);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                }
                                                                QSearchPictureDetail qSearchPictureDetail = qSearchIcon4.auth;
                                                                if (qSearchPictureDetail == null || (qSearchPicture = qSearchPictureDetail.small) == null || (str8 = qSearchPicture.picLink) == null) {
                                                                    str8 = "";
                                                                }
                                                                if (str8.length() > 0) {
                                                                    ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.5
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            final String str9 = str8;
                                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.2.5.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(af afVar) {
                                                                                    af afVar2 = afVar;
                                                                                    afVar2.positionAbsolute();
                                                                                    afVar2.m142left(20.0f);
                                                                                    afVar2.m150top(20.0f);
                                                                                    afVar2.size(12.0f, 12.0f);
                                                                                    b.a.b(afVar2, str9, false, 2, null);
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
                                                    }
                                                    final QSearchIcon qSearchIcon5 = QSearchIcon.this;
                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView7 = qSearchMultiImageVideoTemplateView4;
                                                    final String str8 = str7;
                                                    w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar7) {
                                                            final String str9;
                                                            QSearchIcon qSearchIcon6;
                                                            v vVar8 = vVar7;
                                                            vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    tVar.m140flex(1.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            QSearchText qSearchText2 = QSearchIcon.this.title;
                                                            if (qSearchText2 == null || (str9 = qSearchText2.text) == null) {
                                                                str9 = "";
                                                            }
                                                            if (str9.length() > 0) {
                                                                KLog kLog = KLog.INSTANCE;
                                                                StringBuilder m18 = CacheDiskLru$$ExternalSyntheticOutline0.m("buildBaseInfo:    nickName:", str9, "    nineBoxGridType:");
                                                                m18.append(QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView7).getData().nineBoxGridType);
                                                                m18.append("     icon.type:");
                                                                QSearchNineBoxGrid qSearchNineBoxGrid6 = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView7).getData().contentData;
                                                                m18.append((qSearchNineBoxGrid6 == null || (qSearchIcon6 = qSearchNineBoxGrid6.icon) == null) ? null : Integer.valueOf(qSearchIcon6.iconType));
                                                                kLog.i("QSearchMultiImageVideoTemplateView", m18.toString());
                                                                final QSearchIcon qSearchIcon7 = QSearchIcon.this;
                                                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView8 = qSearchMultiImageVideoTemplateView7;
                                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        TextView textView2 = textView;
                                                                        final String str10 = str9;
                                                                        textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.marginBottom(4.0f);
                                                                                ceVar2.text(str10);
                                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                ceVar2.lines(1);
                                                                                ceVar2.textOverFlowTail();
                                                                                ceVar2.fontWeight600();
                                                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QSearchIcon qSearchIcon8 = QSearchIcon.this;
                                                                        QSearchText qSearchText3 = qSearchIcon8.title;
                                                                        if ((qSearchText3 != null ? qSearchText3.jumpLink : null) != null) {
                                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = qSearchMultiImageVideoTemplateView8;
                                                                            textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.2.2
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(TextEvent textEvent) {
                                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView10 = QSearchMultiImageVideoTemplateView.this;
                                                                                    final QSearchIcon qSearchIcon9 = qSearchIcon8;
                                                                                    textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.2.2.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                                            QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, qSearchIcon9.title.jumpLink);
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
                                                            }
                                                            final String str10 = str8;
                                                            final QSearchIcon qSearchIcon8 = QSearchIcon.this;
                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = qSearchMultiImageVideoTemplateView7;
                                                            w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar9) {
                                                                    final String str11;
                                                                    QSearchText qSearchText3;
                                                                    String str12;
                                                                    v vVar10 = vVar9;
                                                                    vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.flexDirectionRow();
                                                                            tVar2.alignItemsCenter();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    if (str10.length() > 0) {
                                                                        final QSearchIcon qSearchIcon9 = qSearchIcon8;
                                                                        final String str13 = str10;
                                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView10 = qSearchMultiImageVideoTemplateView9;
                                                                        cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                TextView textView2 = textView;
                                                                                final String str14 = str13;
                                                                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.2.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        ceVar2.text(str14);
                                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                        ceVar2.lines(1);
                                                                                        ceVar2.textOverFlowTail();
                                                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                final QSearchIcon qSearchIcon10 = QSearchIcon.this;
                                                                                QSearchText qSearchText4 = qSearchIcon10.subTitle;
                                                                                if ((qSearchText4 != null ? qSearchText4.jumpLink : null) != null) {
                                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView11 = qSearchMultiImageVideoTemplateView10;
                                                                                    textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.2.2
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(TextEvent textEvent) {
                                                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView12 = QSearchMultiImageVideoTemplateView.this;
                                                                                            final QSearchIcon qSearchIcon11 = qSearchIcon10;
                                                                                            textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.2.2.1
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                                    QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, qSearchIcon11.subTitle.jumpLink);
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
                                                                    }
                                                                    QSearchIcon qSearchIcon10 = qSearchIcon8.visibleRange;
                                                                    final String str14 = "";
                                                                    if (qSearchIcon10 == null || (str11 = qSearchIcon10.iconLink) == null) {
                                                                        str11 = "";
                                                                    }
                                                                    if (qSearchIcon10 != null && (qSearchText3 = qSearchIcon10.title) != null && (str12 = qSearchText3.text) != null) {
                                                                        str14 = str12;
                                                                    }
                                                                    if (str11.length() > 0) {
                                                                        if (str14.length() > 0) {
                                                                            ah.a(vVar10, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.3
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ImageView imageView) {
                                                                                    final String str15 = str11;
                                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.3.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(af afVar) {
                                                                                            af afVar2 = afVar;
                                                                                            afVar2.size(12.0f, 12.0f);
                                                                                            b.a.b(afVar2, str15, false, 2, null);
                                                                                            afVar2.marginLeft(4.0f);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.4
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(TextView textView) {
                                                                                    final String str15 = str14;
                                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.4.3.4.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ce ceVar) {
                                                                                            ce ceVar2 = ceVar;
                                                                                            ceVar2.text(str15);
                                                                                            ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                            ceVar2.marginLeft(4.0f);
                                                                                            ceVar2.lines(1);
                                                                                            ceVar2.textOverFlowTail();
                                                                                            ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    QSearchButton qSearchButton2 = qSearchNineBoxGrid5.button;
                                                    Integer num = null;
                                                    if (((qSearchButton2 == null || (qSearchJump2 = qSearchButton2.jumpLink) == null) ? null : qSearchJump2.guildJump) != null) {
                                                        Utils utils = Utils.INSTANCE;
                                                        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QSearchMultiImageVideoTemplateView init guild addBtn: ");
                                                        QSearchText qSearchText2 = QSearchIcon.this.title;
                                                        m18.append(qSearchText2 != null ? qSearchText2.text : null);
                                                        m18.append(TokenParser.SP);
                                                        QSearchButton qSearchButton3 = qSearchNineBoxGrid5.button;
                                                        if (qSearchButton3 != null && (qSearchJump = qSearchButton3.jumpLink) != null && (qSearchGuildJump = qSearchJump.guildJump) != null) {
                                                            num = Integer.valueOf(qSearchGuildJump.joinStatus);
                                                        }
                                                        m18.append(num);
                                                        utils.logToNative(m18.toString());
                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView8 = qSearchMultiImageVideoTemplateView4;
                                                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.5
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = QSearchMultiImageVideoTemplateView.this;
                                                                return Boolean.valueOf(((Boolean) qSearchMultiImageVideoTemplateView9.btnState$delegate.getValue(qSearchMultiImageVideoTemplateView9, QSearchMultiImageVideoTemplateView.$$delegatedProperties[0])).booleanValue());
                                                            }
                                                        };
                                                        final QSearchNineBoxGrid qSearchNineBoxGrid6 = qSearchNineBoxGrid5;
                                                        final QSearchTemplateReportInfo qSearchTemplateReportInfo7 = qSearchTemplateReportInfo5;
                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = qSearchMultiImageVideoTemplateView4;
                                                        BindDirectivesViewKt.a(vVar6, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                                final QSearchNineBoxGrid qSearchNineBoxGrid7 = QSearchNineBoxGrid.this;
                                                                final QSearchTemplateReportInfo qSearchTemplateReportInfo8 = qSearchTemplateReportInfo7;
                                                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView10 = qSearchMultiImageVideoTemplateView9;
                                                                w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar7) {
                                                                        final QSearchNineBoxGrid qSearchNineBoxGrid8 = QSearchNineBoxGrid.this;
                                                                        final QSearchTemplateReportInfo qSearchTemplateReportInfo9 = qSearchTemplateReportInfo8;
                                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView11 = qSearchMultiImageVideoTemplateView10;
                                                                        QSearchGrayBorderButtonViewKt.QSearchGrayBorderButton(vVar7, new Function1<QSearchGrayBorderButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6.1.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
                                                                            
                                                                                if (r1.joinStatus == 1) goto L12;
                                                                             */
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            /*
                                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                                            */
                                                                            public final Unit invoke(QSearchGrayBorderButtonView qSearchGrayBorderButtonView) {
                                                                                QSearchJump qSearchJump3;
                                                                                QSearchGrayBorderButtonView qSearchGrayBorderButtonView2 = qSearchGrayBorderButtonView;
                                                                                final QSearchNineBoxGrid qSearchNineBoxGrid9 = QSearchNineBoxGrid.this;
                                                                                final QSearchTemplateReportInfo qSearchTemplateReportInfo10 = qSearchTemplateReportInfo9;
                                                                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView12 = qSearchMultiImageVideoTemplateView11;
                                                                                qSearchGrayBorderButtonView2.attr(new Function1<QSearchGrayBorderButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6.1.1.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr) {
                                                                                        QSearchJump qSearchJump4;
                                                                                        QSearchGuildJump qSearchGuildJump2;
                                                                                        QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr2 = qSearchGrayBorderButtonAttr;
                                                                                        QSearchButton qSearchButton4 = QSearchNineBoxGrid.this.button;
                                                                                        if ((qSearchButton4 == null || (qSearchJump4 = qSearchButton4.jumpLink) == null || (qSearchGuildJump2 = qSearchJump4.guildJump) == null || qSearchGuildJump2.joinStatus != 2) ? false : true) {
                                                                                            qSearchGrayBorderButtonAttr2.text = "\u5df2\u52a0\u5165";
                                                                                            qSearchGrayBorderButtonAttr2.status = 2;
                                                                                        } else {
                                                                                            qSearchGrayBorderButtonAttr2.text = "\u52a0\u5165";
                                                                                            qSearchGrayBorderButtonAttr2.status = 0;
                                                                                        }
                                                                                        QSearchTemplateReportInfo qSearchTemplateReportInfo11 = qSearchTemplateReportInfo10;
                                                                                        if (qSearchTemplateReportInfo11 != null) {
                                                                                            EcommerceExtKt.vr$default(qSearchGrayBorderButtonAttr2, null, qSearchTemplateReportInfo11.eid, qSearchTemplateReportInfo11.getReportParams(qSearchMultiImageVideoTemplateView12.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo11.hashCode()), true, 9);
                                                                                        }
                                                                                        qSearchGrayBorderButtonAttr2.accessibility(qSearchGrayBorderButtonAttr2.text + "\u6309\u94ae");
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                final QSearchNineBoxGrid qSearchNineBoxGrid10 = QSearchNineBoxGrid.this;
                                                                                QSearchButton qSearchButton4 = qSearchNineBoxGrid10.button;
                                                                                boolean z17 = (qSearchButton4 == null || (qSearchJump3 = qSearchButton4.jumpLink) == null || (r1 = qSearchJump3.guildJump) == null) ? false : true;
                                                                                if (z17) {
                                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView13 = qSearchMultiImageVideoTemplateView11;
                                                                                    qSearchGrayBorderButtonView2.event(new Function1<QSearchGrayBorderButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6.1.1.2
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
                                                                                        
                                                                                            if ((5 <= r3 && r3 < 14) != false) goto L17;
                                                                                         */
                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        /*
                                                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                                                        */
                                                                                        public final Unit invoke(QSearchGrayBorderButtonEvent qSearchGrayBorderButtonEvent) {
                                                                                            final String str9;
                                                                                            QSearchGrayBorderButtonEvent qSearchGrayBorderButtonEvent2 = qSearchGrayBorderButtonEvent;
                                                                                            boolean z18 = true;
                                                                                            boolean z19 = QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).tabData.tabMask == 3;
                                                                                            String str10 = QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).keyword;
                                                                                            if (new Regex("^(?=.*[A-Za-z])\\S{5,14}$").matches(str10)) {
                                                                                                int length = str10.length();
                                                                                            }
                                                                                            z18 = false;
                                                                                            if (z19) {
                                                                                                if (z18) {
                                                                                                    str9 = "qq_network_search_post_sub_tab_searchid";
                                                                                                } else {
                                                                                                    str9 = "qq_network_search_post_sub_tab_keyword";
                                                                                                }
                                                                                            } else if (z18) {
                                                                                                str9 = "qq_network_search_post_all_tab_searchid";
                                                                                            } else {
                                                                                                str9 = "qq_network_search_post_all_tab_keyword";
                                                                                            }
                                                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView14 = QSearchMultiImageVideoTemplateView.this;
                                                                                            final QSearchNineBoxGrid qSearchNineBoxGrid11 = qSearchNineBoxGrid10;
                                                                                            qSearchGrayBorderButtonEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6.1.1.2.1
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView15 = QSearchMultiImageVideoTemplateView.this;
                                                                                                    final QSearchNineBoxGrid qSearchNineBoxGrid12 = qSearchNineBoxGrid11;
                                                                                                    QSearchGuildJump qSearchGuildJump2 = qSearchNineBoxGrid12.button.jumpLink.guildJump;
                                                                                                    String str11 = str9;
                                                                                                    Function1<e, Unit> function13 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.6.1.1.2.1.1
                                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                        {
                                                                                                            super(1);
                                                                                                        }

                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                        public final Unit invoke(e eVar) {
                                                                                                            QSearchJump qSearchJump4;
                                                                                                            e eVar2 = eVar;
                                                                                                            int j3 = eVar2 != null ? eVar2.j("code") : -1;
                                                                                                            if (j3 == 0) {
                                                                                                                QSearchButton qSearchButton5 = QSearchNineBoxGrid.this.button;
                                                                                                                QSearchGuildJump qSearchGuildJump3 = (qSearchButton5 == null || (qSearchJump4 = qSearchButton5.jumpLink) == null) ? null : qSearchJump4.guildJump;
                                                                                                                if (qSearchGuildJump3 != null) {
                                                                                                                    qSearchGuildJump3.joinStatus = 2;
                                                                                                                }
                                                                                                                QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView16 = qSearchMultiImageVideoTemplateView15;
                                                                                                                qSearchMultiImageVideoTemplateView16.btnState$delegate.setValue(qSearchMultiImageVideoTemplateView16, QSearchMultiImageVideoTemplateView.$$delegatedProperties[0], Boolean.TRUE);
                                                                                                            } else {
                                                                                                                Utils.INSTANCE.logToNative("QSearchMultiImageVideoTemplateView joinGuildChannel failed, code=" + j3);
                                                                                                            }
                                                                                                            return Unit.INSTANCE;
                                                                                                        }
                                                                                                    };
                                                                                                    QSearchMultiImageVideoTemplateView.Companion companion2 = QSearchMultiImageVideoTemplateView.Companion;
                                                                                                    qSearchMultiImageVideoTemplateView15.getClass();
                                                                                                    e eVar = new e();
                                                                                                    eVar.v("guildId", String.valueOf(qSearchGuildJump2.guildId));
                                                                                                    eVar.v("joinGuildSig", qSearchGuildJump2.joinGuildSig);
                                                                                                    eVar.v("mainSource", "search");
                                                                                                    eVar.v("subSource", str11);
                                                                                                    Utils.INSTANCE.currentBridgeModule().callNativeMethod("joinGuildChannel", eVar, function13);
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
                                                    }
                                                    final QSearchIcon qSearchIcon6 = QSearchIcon.this;
                                                    if (qSearchIcon6.jumpLink != null) {
                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView10 = qSearchMultiImageVideoTemplateView4;
                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.7
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView11 = QSearchMultiImageVideoTemplateView.this;
                                                                final QSearchIcon qSearchIcon7 = qSearchIcon6;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildBaseInfo.1.1.7.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, qSearchIcon7.jumpLink);
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
                                function1.invoke(vVar4);
                                QSearchMultiImageVideoTemplateView.access$buildContentInfo(QSearchMultiImageVideoTemplateView.this, qSearchNineBoxGrid3).invoke(vVar4);
                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView4 = QSearchMultiImageVideoTemplateView.this;
                                qSearchMultiImageVideoTemplateView4.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildMediaInfo$1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r14v0, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r14v4, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r2v18, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r2v24, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r2v31, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r2v39, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r2v49, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r2v55, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r2v61, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r2v71, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r2v81, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r2v89, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r6v19, types: [T, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo] */
                                    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                        boolean isBlank;
                                        String str7;
                                        boolean isBlank2;
                                        String str8;
                                        ViewContainer<?, ?> viewContainer3 = viewContainer2;
                                        float f16 = 48;
                                        float f17 = 6;
                                        final float m18 = (((QSearchMultiImageVideoTemplateView.this.getPagerData().m() - f16) - f17) / 3) * 2;
                                        final float m19 = (QSearchMultiImageVideoTemplateView.this.getPagerData().m() - f16) - f17;
                                        QSearchMultiImageVideoTemplateModel data = QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData();
                                        int i27 = data.nineBoxGridType;
                                        String str9 = "";
                                        if (i27 != 0) {
                                            if (i27 == 1) {
                                                if (data.isContainVideo) {
                                                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                                    final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                                                    int size = data.mediaList.size();
                                                    for (int i28 = 0; i28 < size; i28++) {
                                                        if (i28 == 0) {
                                                            booleanRef.element = ((List) data.mediaList.get(i28)).size() > 1;
                                                        }
                                                        int size2 = ((List) data.mediaList.get(i28)).size();
                                                        int i29 = 0;
                                                        while (true) {
                                                            if (i29 >= size2) {
                                                                break;
                                                            }
                                                            ?? r65 = (QSearchMultiMediaInfo) ((List) data.mediaList.get(i28)).get(i29);
                                                            if (r65.type == 2) {
                                                                objectRef.element = r65;
                                                                break;
                                                            }
                                                            i29++;
                                                        }
                                                        if (objectRef.element != 0) {
                                                            break;
                                                        }
                                                    }
                                                    QSearchMultiMediaInfo qSearchMultiMediaInfo = (QSearchMultiMediaInfo) objectRef.element;
                                                    if (qSearchMultiMediaInfo != null) {
                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView5 = QSearchMultiImageVideoTemplateView.this;
                                                        StFeedEx stFeedEx = qSearchMultiMediaInfo.stFeedEx;
                                                        if (stFeedEx != null && (str8 = stFeedEx.feedPbToken) != null) {
                                                            str9 = str8;
                                                        }
                                                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str9);
                                                        if (!isBlank2) {
                                                            qSearchMultiImageVideoTemplateView5.firstVideoFeedPbToken = str9;
                                                            QSearchPicture qSearchPicture = ((QSearchMultiMediaInfo) objectRef.element).pictureInfo;
                                                            qSearchMultiImageVideoTemplateView5.jumpLink = qSearchPicture != null ? qSearchPicture.jumpLink : null;
                                                            viewContainer3.addChild(new QSearchSingleVideoView(), new Function1<QSearchSingleVideoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildMediaInfo$1$4$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(QSearchSingleVideoView qSearchSingleVideoView) {
                                                                    QSearchSingleVideoView qSearchSingleVideoView2 = qSearchSingleVideoView;
                                                                    final Ref.ObjectRef<QSearchMultiMediaInfo> objectRef2 = objectRef;
                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView6 = qSearchMultiImageVideoTemplateView5;
                                                                    final float f18 = m19;
                                                                    final float f19 = m18;
                                                                    final Ref.BooleanRef booleanRef2 = booleanRef;
                                                                    qSearchSingleVideoView2.attr(new Function1<QSearchSingleVideoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildMediaInfo$1$4$1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(QSearchSingleVideoAttr qSearchSingleVideoAttr) {
                                                                            float f26;
                                                                            QSearchSingleVideoAttr qSearchSingleVideoAttr2 = qSearchSingleVideoAttr;
                                                                            qSearchSingleVideoAttr2.marginTop(10.0f);
                                                                            qSearchSingleVideoAttr2.mediaInfo = objectRef2.element;
                                                                            qSearchSingleVideoAttr2.index = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView6).index;
                                                                            QSearchMultiImageVideoAttr access$getAttr = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView6);
                                                                            ReadWriteProperty readWriteProperty = access$getAttr.playIndex$delegate;
                                                                            KProperty<?>[] kPropertyArr = QSearchBaseTemplateAttr.$$delegatedProperties;
                                                                            int intValue = ((Number) readWriteProperty.getValue(access$getAttr, kPropertyArr[0])).intValue();
                                                                            ReadWriteProperty readWriteProperty2 = qSearchSingleVideoAttr2.playIndex$delegate;
                                                                            KProperty<?>[] kPropertyArr2 = QSearchSingleVideoAttr.$$delegatedProperties;
                                                                            readWriteProperty2.setValue(qSearchSingleVideoAttr2, kPropertyArr2[0], Integer.valueOf(intValue));
                                                                            QSearchMultiImageVideoAttr access$getAttr2 = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView6);
                                                                            qSearchSingleVideoAttr2.muted$delegate.setValue(qSearchSingleVideoAttr2, kPropertyArr2[1], Boolean.valueOf(((Boolean) access$getAttr2.muted$delegate.getValue(access$getAttr2, kPropertyArr[1])).booleanValue()));
                                                                            if (objectRef2.element.ratio > 1.0f) {
                                                                                f26 = f18;
                                                                            } else {
                                                                                f26 = f19;
                                                                            }
                                                                            qSearchSingleVideoAttr2.mo153width(f26);
                                                                            qSearchSingleVideoAttr2.borderRadius = 8.0f;
                                                                            StFeedEx stFeedEx2 = objectRef2.element.stFeedEx;
                                                                            Intrinsics.checkNotNull(stFeedEx2);
                                                                            qSearchSingleVideoAttr2.stFeedEx = stFeedEx2;
                                                                            qSearchSingleVideoAttr2.reportParams = qSearchMultiImageVideoTemplateView6.getTemplateCardReportInfo();
                                                                            qSearchSingleVideoAttr2.isUseNewBodyStyle = true;
                                                                            qSearchSingleVideoAttr2.isShowCollectionIcon = booleanRef2.element;
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView7 = qSearchMultiImageVideoTemplateView5;
                                                                    final Ref.ObjectRef<QSearchMultiMediaInfo> objectRef3 = objectRef;
                                                                    qSearchSingleVideoView2.event(new Function1<QSearchSingleVideoEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildMediaInfo$1$4$1.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(QSearchSingleVideoEvent qSearchSingleVideoEvent) {
                                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView8 = QSearchMultiImageVideoTemplateView.this;
                                                                            final Ref.ObjectRef<QSearchMultiMediaInfo> objectRef4 = objectRef3;
                                                                            qSearchSingleVideoEvent.videoClick = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildMediaInfo.1.4.1.2.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(0);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                public final Unit invoke() {
                                                                                    QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = QSearchMultiImageVideoTemplateView.this;
                                                                                    QSearchPicture qSearchPicture2 = objectRef4.element.pictureInfo;
                                                                                    QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(qSearchMultiImageVideoTemplateView9, qSearchPicture2 != null ? qSearchPicture2.jumpLink : null);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                    }
                                                } else if (QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().mediaList.size() == 1 && ((List) QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().mediaList.get(0)).size() == 1) {
                                                    final QSearchMultiMediaInfo qSearchMultiMediaInfo2 = (QSearchMultiMediaInfo) ((List) QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().mediaList.get(0)).get(0);
                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView6 = QSearchMultiImageVideoTemplateView.this;
                                                    QSearchPicture qSearchPicture2 = qSearchMultiMediaInfo2.pictureInfo;
                                                    qSearchMultiImageVideoTemplateView6.jumpLink = qSearchPicture2 != null ? qSearchPicture2.jumpLink : null;
                                                    QSearchSingleMediaViewKt.QSearchSingleMedia(viewContainer3, new Function1<QSearchSingleMediaView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildMediaInfo$1.5
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(QSearchSingleMediaView qSearchSingleMediaView) {
                                                            final QSearchMultiMediaInfo qSearchMultiMediaInfo3 = QSearchMultiMediaInfo.this;
                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView7 = qSearchMultiImageVideoTemplateView6;
                                                            qSearchSingleMediaView.attr(new Function1<QSearchSingleMediaAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildMediaInfo.1.5.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(QSearchSingleMediaAttr qSearchSingleMediaAttr) {
                                                                    QSearchSingleMediaAttr qSearchSingleMediaAttr2 = qSearchSingleMediaAttr;
                                                                    qSearchSingleMediaAttr2.marginTop(10.0f);
                                                                    qSearchSingleMediaAttr2.mediaInfo = QSearchMultiMediaInfo.this;
                                                                    int i36 = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView7).index;
                                                                    QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView8 = qSearchMultiImageVideoTemplateView7;
                                                                    QSearchMultiMediaInfo qSearchMultiMediaInfo4 = QSearchMultiMediaInfo.this;
                                                                    qSearchMultiImageVideoTemplateView8.getClass();
                                                                    new QSearchMultiImageVideoTemplateView$setSingleMediaSize$1(qSearchMultiMediaInfo4, qSearchMultiImageVideoTemplateView8).invoke(qSearchSingleMediaAttr2);
                                                                    qSearchSingleMediaAttr2.borderRadius = 4.0f;
                                                                    qSearchSingleMediaAttr2.reportParams = qSearchMultiImageVideoTemplateView7.getTemplateCardReportInfo();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                } else if (QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().mediaList.size() > 0) {
                                                    if (!((Collection) QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().mediaList.get(0)).isEmpty()) {
                                                        QSearchMultiMediaInfo qSearchMultiMediaInfo3 = (QSearchMultiMediaInfo) ((List) QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().mediaList.get(0)).get(0);
                                                        QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView7 = QSearchMultiImageVideoTemplateView.this;
                                                        QSearchPicture qSearchPicture3 = qSearchMultiMediaInfo3.pictureInfo;
                                                        qSearchMultiImageVideoTemplateView7.jumpLink = qSearchPicture3 != null ? qSearchPicture3.jumpLink : null;
                                                    }
                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView8 = QSearchMultiImageVideoTemplateView.this;
                                                    viewContainer3.addChild(new QSearchMultiMediaView(), new Function1<QSearchMultiMediaView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildMediaInfo$1.6
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(QSearchMultiMediaView qSearchMultiMediaView) {
                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = QSearchMultiImageVideoTemplateView.this;
                                                            qSearchMultiMediaView.attr(new Function1<QSearchMultiMediaAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildMediaInfo.1.6.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(QSearchMultiMediaAttr qSearchMultiMediaAttr) {
                                                                    QSearchMultiMediaAttr qSearchMultiMediaAttr2 = qSearchMultiMediaAttr;
                                                                    qSearchMultiMediaAttr2.marginTop(10.0f);
                                                                    qSearchMultiMediaAttr2.mediaList = QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().mediaList;
                                                                    qSearchMultiMediaAttr2.moreCount = QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().moreCount;
                                                                    qSearchMultiMediaAttr2.reportParams = QSearchMultiImageVideoTemplateView.this.getTemplateCardReportInfo();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                            }
                                        } else if (QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().mediaList.size() == 1 && ((List) QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().mediaList.get(0)).size() == 1) {
                                            final QSearchMultiMediaInfo qSearchMultiMediaInfo4 = (QSearchMultiMediaInfo) ((List) QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().mediaList.get(0)).get(0);
                                            StFeedEx stFeedEx2 = qSearchMultiMediaInfo4.stFeedEx;
                                            if (stFeedEx2 != null && (str7 = stFeedEx2.feedPbToken) != null) {
                                                str9 = str7;
                                            }
                                            QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = QSearchMultiImageVideoTemplateView.this;
                                            QSearchPicture qSearchPicture4 = qSearchMultiMediaInfo4.pictureInfo;
                                            qSearchMultiImageVideoTemplateView9.jumpLink = qSearchPicture4 != null ? qSearchPicture4.jumpLink : null;
                                            if (qSearchMultiMediaInfo4.type == 2) {
                                                isBlank = StringsKt__StringsJVMKt.isBlank(str9);
                                                if (!isBlank) {
                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView10 = QSearchMultiImageVideoTemplateView.this;
                                                    qSearchMultiImageVideoTemplateView10.firstVideoFeedPbToken = str9;
                                                    viewContainer3.addChild(new QSearchSingleVideoView(), new Function1<QSearchSingleVideoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildMediaInfo$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(QSearchSingleVideoView qSearchSingleVideoView) {
                                                            QSearchSingleVideoView qSearchSingleVideoView2 = qSearchSingleVideoView;
                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView11 = QSearchMultiImageVideoTemplateView.this;
                                                            qSearchSingleVideoView2.ref(qSearchSingleVideoView2, new Function1<aa<QSearchSingleVideoView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildMediaInfo.1.1.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(aa<QSearchSingleVideoView> aaVar) {
                                                                    QSearchMultiImageVideoTemplateView.this.videoRef = aaVar;
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final QSearchMultiMediaInfo qSearchMultiMediaInfo5 = qSearchMultiMediaInfo4;
                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView12 = QSearchMultiImageVideoTemplateView.this;
                                                            final float f18 = m19;
                                                            final float f19 = m18;
                                                            qSearchSingleVideoView2.attr(new Function1<QSearchSingleVideoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildMediaInfo.1.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(QSearchSingleVideoAttr qSearchSingleVideoAttr) {
                                                                    float f26;
                                                                    QSearchSingleVideoAttr qSearchSingleVideoAttr2 = qSearchSingleVideoAttr;
                                                                    qSearchSingleVideoAttr2.marginTop(10.0f);
                                                                    qSearchSingleVideoAttr2.mediaInfo = QSearchMultiMediaInfo.this;
                                                                    qSearchSingleVideoAttr2.index = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView12).index;
                                                                    QSearchMultiImageVideoAttr access$getAttr = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView12);
                                                                    ReadWriteProperty readWriteProperty = access$getAttr.playIndex$delegate;
                                                                    KProperty<?>[] kPropertyArr = QSearchBaseTemplateAttr.$$delegatedProperties;
                                                                    int intValue = ((Number) readWriteProperty.getValue(access$getAttr, kPropertyArr[0])).intValue();
                                                                    ReadWriteProperty readWriteProperty2 = qSearchSingleVideoAttr2.playIndex$delegate;
                                                                    KProperty<?>[] kPropertyArr2 = QSearchSingleVideoAttr.$$delegatedProperties;
                                                                    readWriteProperty2.setValue(qSearchSingleVideoAttr2, kPropertyArr2[0], Integer.valueOf(intValue));
                                                                    QSearchMultiImageVideoAttr access$getAttr2 = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView12);
                                                                    qSearchSingleVideoAttr2.muted$delegate.setValue(qSearchSingleVideoAttr2, kPropertyArr2[1], Boolean.valueOf(((Boolean) access$getAttr2.muted$delegate.getValue(access$getAttr2, kPropertyArr[1])).booleanValue()));
                                                                    if (QSearchMultiMediaInfo.this.ratio > 1.0f) {
                                                                        f26 = f18;
                                                                    } else {
                                                                        f26 = f19;
                                                                    }
                                                                    qSearchSingleVideoAttr2.mo153width(f26);
                                                                    qSearchSingleVideoAttr2.borderRadius = 4.0f;
                                                                    StFeedEx stFeedEx3 = QSearchMultiMediaInfo.this.stFeedEx;
                                                                    Intrinsics.checkNotNull(stFeedEx3);
                                                                    qSearchSingleVideoAttr2.stFeedEx = stFeedEx3;
                                                                    qSearchSingleVideoAttr2.reportParams = qSearchMultiImageVideoTemplateView12.getTemplateCardReportInfo();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView13 = QSearchMultiImageVideoTemplateView.this;
                                                            final QSearchMultiMediaInfo qSearchMultiMediaInfo6 = qSearchMultiMediaInfo4;
                                                            qSearchSingleVideoView2.event(new Function1<QSearchSingleVideoEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildMediaInfo.1.1.3
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(QSearchSingleVideoEvent qSearchSingleVideoEvent) {
                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView14 = QSearchMultiImageVideoTemplateView.this;
                                                                    final QSearchMultiMediaInfo qSearchMultiMediaInfo7 = qSearchMultiMediaInfo6;
                                                                    qSearchSingleVideoEvent.videoClick = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildMediaInfo.1.1.3.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView15 = QSearchMultiImageVideoTemplateView.this;
                                                                            QSearchPicture qSearchPicture5 = qSearchMultiMediaInfo7.pictureInfo;
                                                                            QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(qSearchMultiImageVideoTemplateView15, qSearchPicture5 != null ? qSearchPicture5.jumpLink : null);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                            }
                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView11 = QSearchMultiImageVideoTemplateView.this;
                                            QSearchSingleMediaViewKt.QSearchSingleMedia(viewContainer3, new Function1<QSearchSingleMediaView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildMediaInfo$1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchSingleMediaView qSearchSingleMediaView) {
                                                    final QSearchMultiMediaInfo qSearchMultiMediaInfo5 = QSearchMultiMediaInfo.this;
                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView12 = qSearchMultiImageVideoTemplateView11;
                                                    qSearchSingleMediaView.attr(new Function1<QSearchSingleMediaAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildMediaInfo.1.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(QSearchSingleMediaAttr qSearchSingleMediaAttr) {
                                                            QSearchSingleMediaAttr qSearchSingleMediaAttr2 = qSearchSingleMediaAttr;
                                                            qSearchSingleMediaAttr2.marginTop(10.0f);
                                                            qSearchSingleMediaAttr2.mediaInfo = QSearchMultiMediaInfo.this;
                                                            int i36 = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView12).index;
                                                            QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView13 = qSearchMultiImageVideoTemplateView12;
                                                            QSearchMultiMediaInfo qSearchMultiMediaInfo6 = QSearchMultiMediaInfo.this;
                                                            qSearchMultiImageVideoTemplateView13.getClass();
                                                            new QSearchMultiImageVideoTemplateView$setSingleMediaSize$1(qSearchMultiMediaInfo6, qSearchMultiImageVideoTemplateView13).invoke(qSearchSingleMediaAttr2);
                                                            qSearchSingleMediaAttr2.borderRadius = 4.0f;
                                                            qSearchSingleMediaAttr2.reportParams = qSearchMultiImageVideoTemplateView12.getTemplateCardReportInfo();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        } else if (QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().mediaList.size() > 0) {
                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView12 = QSearchMultiImageVideoTemplateView.this;
                                            viewContainer3.addChild(new QSearchMultiMediaView(), new Function1<QSearchMultiMediaView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildMediaInfo$1.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchMultiMediaView qSearchMultiMediaView) {
                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView13 = QSearchMultiImageVideoTemplateView.this;
                                                    qSearchMultiMediaView.attr(new Function1<QSearchMultiMediaAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildMediaInfo.1.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(QSearchMultiMediaAttr qSearchMultiMediaAttr) {
                                                            QSearchMultiMediaAttr qSearchMultiMediaAttr2 = qSearchMultiMediaAttr;
                                                            qSearchMultiMediaAttr2.marginTop(10.0f);
                                                            qSearchMultiMediaAttr2.mediaList = QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().mediaList;
                                                            qSearchMultiMediaAttr2.moreCount = QSearchMultiImageVideoTemplateView.access$getAttr(QSearchMultiImageVideoTemplateView.this).getData().moreCount;
                                                            qSearchMultiMediaAttr2.reportParams = QSearchMultiImageVideoTemplateView.this.getTemplateCardReportInfo();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }.invoke(vVar4);
                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView5 = QSearchMultiImageVideoTemplateView.this;
                                QSearchNineBoxGrid qSearchNineBoxGrid5 = qSearchNineBoxGrid3;
                                qSearchMultiImageVideoTemplateView5.getClass();
                                final QSearchIcon qSearchIcon2 = qSearchNineBoxGrid5.describe;
                                if (qSearchIcon2 == null) {
                                    function12 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildFooterInfo$describeInfo$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                } else {
                                    QSearchText qSearchText2 = qSearchIcon2.title;
                                    if (qSearchText2 == null || (str5 = qSearchText2.text) == null) {
                                        str5 = str2;
                                    }
                                    QSearchText qSearchText3 = qSearchIcon2.subTitle;
                                    final String str7 = (qSearchText3 == null || (str6 = qSearchText3.text) == null) ? str2 : str6;
                                    if (str5.length() == 0 ? z16 : false) {
                                        if (str7.length() == 0 ? z16 : false) {
                                            function12 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildFooterInfo$1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                        }
                                    }
                                    function12 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildFooterInfo$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final String str8 = str5;
                                            final String str9 = str7;
                                            final QSearchIcon qSearchIcon3 = qSearchIcon2;
                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView6 = qSearchMultiImageVideoTemplateView5;
                                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$buildFooterInfo$2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    v vVar6 = vVar5;
                                                    vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.flexDirectionRow();
                                                            tVar2.alignItemsCenter();
                                                            tVar2.marginTop(10.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    if (str8.length() > 0) {
                                                        final QSearchIcon qSearchIcon4 = qSearchIcon3;
                                                        final String str10 = str8;
                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView7 = qSearchMultiImageVideoTemplateView6;
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                TextView textView2 = textView;
                                                                final String str11 = str10;
                                                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.marginRight(4.0f);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        ceVar2.lineHeight(FontModuleExtKt.qqTextViewLineHeightScale() * 20.0f);
                                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                                        ceVar2.text(str11);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QSearchIcon qSearchIcon5 = QSearchIcon.this;
                                                                QSearchText qSearchText4 = qSearchIcon5.title;
                                                                if ((qSearchText4 != null ? qSearchText4.jumpLink : null) != null) {
                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView8 = qSearchMultiImageVideoTemplateView7;
                                                                    textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.2.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextEvent textEvent) {
                                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = QSearchMultiImageVideoTemplateView.this;
                                                                            final QSearchIcon qSearchIcon6 = qSearchIcon5;
                                                                            textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.2.2.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                    QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, qSearchIcon6.title.jumpLink);
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
                                                    }
                                                    if (str9.length() > 0) {
                                                        final QSearchIcon qSearchIcon5 = qSearchIcon3;
                                                        final String str11 = str9;
                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView8 = qSearchMultiImageVideoTemplateView6;
                                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                boolean isBlank;
                                                                v vVar8 = vVar7;
                                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.flexDirectionRow();
                                                                        tVar2.paddingLeft(6.0f).paddingRight(6.0f);
                                                                        tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(12.0f) + 20.0f);
                                                                        tVar2.borderRadius(4.0f);
                                                                        tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_standard_primary"));
                                                                        tVar2.alignItemsCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                isBlank = StringsKt__StringsJVMKt.isBlank(QSearchIcon.this.iconLink);
                                                                if (!isBlank) {
                                                                    final QSearchIcon qSearchIcon6 = QSearchIcon.this;
                                                                    ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.3.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            final QSearchIcon qSearchIcon7 = QSearchIcon.this;
                                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.3.2.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(af afVar) {
                                                                                    af afVar2 = afVar;
                                                                                    afVar2.marginRight(4.0f);
                                                                                    float qqFontScaleAddSize = FontModuleExtKt.qqFontScaleAddSize(12.0f) + 13.0f;
                                                                                    afVar2.size(qqFontScaleAddSize, qqFontScaleAddSize);
                                                                                    afVar2.borderRadius(4.0f);
                                                                                    b.a.b(afVar2, QSearchIcon.this.iconLink, false, 2, null);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                }
                                                                final QSearchIcon qSearchIcon7 = QSearchIcon.this;
                                                                final String str12 = str11;
                                                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = qSearchMultiImageVideoTemplateView8;
                                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.3.3
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        TextView textView2 = textView;
                                                                        final String str13 = str12;
                                                                        textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.3.3.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                                                ceVar2.lines(1);
                                                                                ceVar2.textOverFlowTail();
                                                                                ceVar2.text(str13);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QSearchIcon qSearchIcon8 = QSearchIcon.this;
                                                                        QSearchText qSearchText4 = qSearchIcon8.subTitle;
                                                                        if ((qSearchText4 != null ? qSearchText4.jumpLink : null) != null) {
                                                                            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView10 = qSearchMultiImageVideoTemplateView9;
                                                                            textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.3.3.2
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(TextEvent textEvent) {
                                                                                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView11 = QSearchMultiImageVideoTemplateView.this;
                                                                                    final QSearchIcon qSearchIcon9 = qSearchIcon8;
                                                                                    textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.3.3.2.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                                            QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, qSearchIcon9.subTitle.jumpLink);
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
                                                    final QSearchIcon qSearchIcon6 = qSearchIcon3;
                                                    if (qSearchIcon6.jumpLink != null) {
                                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView9 = qSearchMultiImageVideoTemplateView6;
                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.4
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView10 = QSearchMultiImageVideoTemplateView.this;
                                                                final QSearchIcon qSearchIcon7 = qSearchIcon6;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildFooterInfo.2.1.4.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, qSearchIcon7.jumpLink);
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
                                function12.invoke(vVar4);
                                final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView6 = QSearchMultiImageVideoTemplateView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContent.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView7 = QSearchMultiImageVideoTemplateView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.buildContent.1.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView8 = QSearchMultiImageVideoTemplateView.this;
                                                QSearchJump qSearchJump = qSearchMultiImageVideoTemplateView8.jumpLink;
                                                if (qSearchJump != null) {
                                                    QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(qSearchMultiImageVideoTemplateView8, qSearchJump);
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchMultiImageVideoAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QQSearchMultiImageVideoEvent();
    }

    public final RichTextSpanUnit getMatchIndexSpan(int i3, List<RichTextSpanUnit> list) {
        int size = list.size();
        for (int i16 = 0; i16 < size; i16++) {
            RichTextSpanUnit richTextSpanUnit = list.get(i16);
            if (i3 > richTextSpanUnit.start && i3 <= richTextSpanUnit.end) {
                return richTextSpanUnit;
            }
        }
        return null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final e getReportParams() {
        e reportParams = super.getReportParams();
        reportParams.v("xsj_custom_pgid", "pg_qq_network_search_result_level2_page");
        return reportParams;
    }

    public static final int access$getBizId(QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView, QSearchTemplateReportInfo qSearchTemplateReportInfo) {
        try {
            return new e(qSearchTemplateReportInfo.transferInfo).k(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, -1);
        } catch (Exception e16) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getBizId:  transferInfo:");
            m3.append(qSearchTemplateReportInfo.transferInfo);
            m3.append("    parse transferInfo error:");
            m3.append(e16);
            kLog.i("QSearchMultiImageVideoTemplateView", m3.toString());
            return -1;
        }
    }

    public final void addRichTextSpan(List<RichTextSpanUnit> list, String str, int i3, QSearchText qSearchText) {
        int indexOf$default;
        boolean isBlank;
        h color$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, qSearchText.text, i3, false, 4, (Object) null);
        if (indexOf$default != -1) {
            isBlank = StringsKt__StringsJVMKt.isBlank(qSearchText.color);
            if (!isBlank) {
                color$default = QUIToken.color$default(qSearchText.color);
            } else {
                QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                color$default = QUIToken.color$default("text_link");
            }
            list.add(new RichTextSpanUnit(indexOf$default, qSearchText.text.length() + indexOf$default, color$default, qSearchText.jumpLink, qSearchText.reportInfo));
            addRichTextSpan(list, str, qSearchText.text.length() + indexOf$default, qSearchText);
        }
    }

    public final List<RichTextSpanUnit> getRichTextSpanUnit(String str, String str2, QSearchRichText qSearchRichText) {
        List sortedWith;
        int indexOf$default;
        int indexOf$default2;
        ArrayList arrayListOf;
        if ((qSearchRichText != null ? qSearchRichText.highlightText : null) == null) {
            indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, true, 2, (Object) null);
            if (indexOf$default2 != -1) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new RichTextSpanUnit(indexOf$default2, str2.length() + indexOf$default2, QUISkinColor.INSTANCE.wrapColor("brand_standard"), null, null));
                return arrayListOf;
            }
            return new ArrayList();
        }
        KLog.INSTANCE.i("QSearchMultiImageVideoTemplateView", QUISkinImage$$ExternalSyntheticOutline0.m("getRichTextSpanUnit:    highLightWords:", str2, "     content:", str));
        List<RichTextSpanUnit> arrayList = new ArrayList<>();
        List<QSearchText> list = qSearchRichText.highlightText;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((QSearchText) obj).jumpLink != null) {
                arrayList2.add(obj);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$getRichTextSpanUnit$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((QSearchText) t17).text.length()), Integer.valueOf(((QSearchText) t16).text.length()));
                return compareValues;
            }
        });
        Iterator it = sortedWith.iterator();
        while (it.hasNext()) {
            addRichTextSpan(arrayList, str, 0, (QSearchText) it.next());
        }
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, true, 2, (Object) null);
        if (indexOf$default != -1) {
            arrayList.add(new RichTextSpanUnit(indexOf$default, str2.length() + indexOf$default, QUISkinColor.INSTANCE.wrapColor("brand_standard"), null, null));
        }
        int length = str.length();
        ArrayList arrayList3 = new ArrayList();
        if (length != 0) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList) {
                RichTextSpanUnit richTextSpanUnit = (RichTextSpanUnit) obj2;
                if (richTextSpanUnit.start < richTextSpanUnit.end) {
                    arrayList4.add(obj2);
                }
            }
            int i3 = 0;
            for (int i16 = 1; i16 <= length; i16++) {
                RichTextSpanUnit matchIndexSpan = getMatchIndexSpan(i16, arrayList4);
                int i17 = i16 - 1;
                RichTextSpanUnit matchIndexSpan2 = getMatchIndexSpan(i17, arrayList4);
                if ((matchIndexSpan != null ? matchIndexSpan.hashCode() : 0) != (matchIndexSpan2 != null ? matchIndexSpan2.hashCode() : 0) && i17 > i3) {
                    if (matchIndexSpan2 != null) {
                        arrayList3.add(new RichTextSpanUnit(i3, i17, matchIndexSpan2.color, matchIndexSpan2.jump, matchIndexSpan2.reportInfo));
                    }
                    i3 = i17;
                }
                if (i16 == length && matchIndexSpan != null) {
                    arrayList3.add(new RichTextSpanUnit(i3, i16, matchIndexSpan.color, matchIndexSpan.jump, matchIndexSpan.reportInfo));
                }
            }
        }
        return arrayList3;
    }
}
