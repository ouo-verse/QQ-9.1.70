package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.QSearchContactWholeCardItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.QSearchContactWholeCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialogAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialogEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchRichTextUtil;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.RichTextSpanUnit;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.q;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.v;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchContactTabContentView extends QSearchTabContentView {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchContactTabContentView.class, "showSearchEmptyActionSheet", "getShowSearchEmptyActionSheet()Z", 0)};
    public final ReadWriteProperty showSearchEmptyActionSheet$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchTabContentAttr access$getAttr(QSearchContactTabContentView qSearchContactTabContentView) {
        return (QSearchTabContentAttr) qSearchContactTabContentView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final Function1<ViewContainer<?, ?>, Unit> appendEmptyView(e eVar) {
        final String str;
        q qVar;
        String str2;
        kuikly.com.tencent.trpcprotocol.search.unifysearch.e emptyPageExtraInfo = ((QSearchTabContentAttr) getAttr()).getViewModel().getEmptyPageExtraInfo();
        final String str3 = "";
        if (emptyPageExtraInfo == null || (str = emptyPageExtraInfo.f413192h) == null) {
            str = "";
        }
        kuikly.com.tencent.trpcprotocol.search.unifysearch.e emptyPageExtraInfo2 = ((QSearchTabContentAttr) getAttr()).getViewModel().getEmptyPageExtraInfo();
        if (emptyPageExtraInfo2 != null && (str2 = emptyPageExtraInfo2.f413189d) != null) {
            str3 = str2;
        }
        kuikly.com.tencent.trpcprotocol.search.unifysearch.e emptyPageExtraInfo3 = ((QSearchTabContentAttr) getAttr()).getViewModel().getEmptyPageExtraInfo();
        final List<v> list = (emptyPageExtraInfo3 == null || (qVar = emptyPageExtraInfo3.f413191f) == null) ? null : qVar.f413242d;
        KLog.INSTANCE.d("ashionTest11", QUISkinImage$$ExternalSyntheticOutline0.m("appendEmptyView   emptyTitle\uff1a", str, "   emptyContent:", str3));
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView$appendEmptyView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final String str4 = str;
                final QSearchContactTabContentView qSearchContactTabContentView = this;
                w.a(viewContainer2, new Function1<com.tencent.kuikly.core.views.v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView$appendEmptyView$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.views.v vVar) {
                        com.tencent.kuikly.core.views.v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.appendEmptyView.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                Attr.absolutePosition$default(tVar, 0.0f, 0.0f, 60.0f, 0.0f, 1, null);
                                return Unit.INSTANCE;
                            }
                        });
                        final String str5 = str4;
                        final QSearchContactTabContentView qSearchContactTabContentView2 = qSearchContactTabContentView;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.appendEmptyView.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                TextView textView2 = textView;
                                final String str6 = str5;
                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.appendEmptyView.1.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(str6);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_link"));
                                        ceVar2.alignSelfCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchContactTabContentView qSearchContactTabContentView3 = qSearchContactTabContentView2;
                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.appendEmptyView.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextEvent textEvent) {
                                        final QSearchContactTabContentView qSearchContactTabContentView4 = QSearchContactTabContentView.this;
                                        textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.appendEmptyView.1.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QSearchContactTabContentView.this.setShowSearchEmptyActionSheet(true);
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
                final QSearchContactTabContentView qSearchContactTabContentView2 = this;
                final String str5 = str;
                final String str6 = str3;
                final List<v> list2 = list;
                viewContainer2.addChild(new QSearchCommonSimpleTitleBottomDialog(), new Function1<QSearchCommonSimpleTitleBottomDialog, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView$appendEmptyView$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog) {
                        QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog2 = qSearchCommonSimpleTitleBottomDialog;
                        final QSearchContactTabContentView qSearchContactTabContentView3 = QSearchContactTabContentView.this;
                        final String str7 = str5;
                        final String str8 = str6;
                        final List<v> list3 = list2;
                        qSearchCommonSimpleTitleBottomDialog2.attr(new Function1<QSearchCommonSimpleTitleBottomDialogAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.appendEmptyView.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchCommonSimpleTitleBottomDialogAttr qSearchCommonSimpleTitleBottomDialogAttr) {
                                QSearchCommonSimpleTitleBottomDialogAttr qSearchCommonSimpleTitleBottomDialogAttr2 = qSearchCommonSimpleTitleBottomDialogAttr;
                                QSearchContactTabContentView qSearchContactTabContentView4 = QSearchContactTabContentView.this;
                                qSearchCommonSimpleTitleBottomDialogAttr2.setShowDialog(((Boolean) qSearchContactTabContentView4.showSearchEmptyActionSheet$delegate.getValue(qSearchContactTabContentView4, QSearchContactTabContentView.$$delegatedProperties[0])).booleanValue());
                                qSearchCommonSimpleTitleBottomDialogAttr2.title$delegate.setValue(qSearchCommonSimpleTitleBottomDialogAttr2, QSearchCommonSimpleTitleBottomDialogAttr.$$delegatedProperties[1], str7);
                                final QSearchContactTabContentView qSearchContactTabContentView5 = QSearchContactTabContentView.this;
                                final String str9 = str8;
                                final List<v> list4 = list3;
                                qSearchCommonSimpleTitleBottomDialogAttr2.contentBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.appendEmptyView.1.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        int i3;
                                        List<v> sortedWith;
                                        final ArrayList arrayList;
                                        RichTextSpanUnit richTextSpanUnit;
                                        RichTextSpanUnit richTextSpanUnit2;
                                        ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                        final QSearchContactTabContentView qSearchContactTabContentView6 = QSearchContactTabContentView.this;
                                        String str10 = str9;
                                        List<v> list5 = list4;
                                        KProperty<Object>[] kPropertyArr = QSearchContactTabContentView.$$delegatedProperties;
                                        qSearchContactTabContentView6.getClass();
                                        if (list5 == null) {
                                            arrayList = new ArrayList();
                                        } else {
                                            ArrayList arrayList2 = new ArrayList();
                                            ArrayList arrayList3 = new ArrayList();
                                            Iterator<T> it = list5.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                Object next = it.next();
                                                if ((((v) next).f413264e == null ? 0 : 1) != 0) {
                                                    arrayList3.add(next);
                                                }
                                            }
                                            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView$generateSpanList$$inlined$sortedByDescending$1
                                                /* JADX WARN: Multi-variable type inference failed */
                                                @Override // java.util.Comparator
                                                public final int compare(T t16, T t17) {
                                                    int compareValues;
                                                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((v) t17).f413263d.length()), Integer.valueOf(((v) t16).f413263d.length()));
                                                    return compareValues;
                                                }
                                            });
                                            for (final v vVar : sortedWith) {
                                                QSearchRichTextUtil.INSTANCE.addRichTextSpan(arrayList2, str10, 0, vVar.f413263d, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView$generateSpanList$3$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.openPage$default(v.this.f413264e, false, 6);
                                                        qSearchContactTabContentView6.setShowSearchEmptyActionSheet(false);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            }
                                            int length = str10.length();
                                            ArrayList arrayList4 = new ArrayList();
                                            if (length != 0) {
                                                ArrayList arrayList5 = new ArrayList();
                                                Iterator it5 = arrayList2.iterator();
                                                while (it5.hasNext()) {
                                                    Object next2 = it5.next();
                                                    RichTextSpanUnit richTextSpanUnit3 = (RichTextSpanUnit) next2;
                                                    if (richTextSpanUnit3.start < richTextSpanUnit3.end) {
                                                        arrayList5.add(next2);
                                                    }
                                                }
                                                int i16 = 0;
                                                while (i3 <= length) {
                                                    int size = arrayList5.size();
                                                    int i17 = 0;
                                                    while (true) {
                                                        richTextSpanUnit = null;
                                                        if (i17 >= size) {
                                                            richTextSpanUnit2 = null;
                                                            break;
                                                        }
                                                        RichTextSpanUnit richTextSpanUnit4 = (RichTextSpanUnit) arrayList5.get(i17);
                                                        if (i3 > richTextSpanUnit4.start && i3 <= richTextSpanUnit4.end) {
                                                            richTextSpanUnit2 = richTextSpanUnit4;
                                                            break;
                                                        }
                                                        i17++;
                                                    }
                                                    int i18 = i3 - 1;
                                                    int size2 = arrayList5.size();
                                                    int i19 = 0;
                                                    while (true) {
                                                        if (i19 >= size2) {
                                                            break;
                                                        }
                                                        RichTextSpanUnit richTextSpanUnit5 = (RichTextSpanUnit) arrayList5.get(i19);
                                                        if (i18 > richTextSpanUnit5.start && i18 <= richTextSpanUnit5.end) {
                                                            richTextSpanUnit = richTextSpanUnit5;
                                                            break;
                                                        }
                                                        i19++;
                                                    }
                                                    if ((richTextSpanUnit2 != null ? richTextSpanUnit2.hashCode() : 0) != (richTextSpanUnit != null ? richTextSpanUnit.hashCode() : 0) && i18 > i16) {
                                                        if (richTextSpanUnit != null) {
                                                            arrayList4.add(new RichTextSpanUnit(i16, i18, richTextSpanUnit.color, richTextSpanUnit.jump, richTextSpanUnit.clickFun));
                                                        }
                                                        i16 = i18;
                                                    }
                                                    if (i3 == length && richTextSpanUnit2 != null) {
                                                        arrayList4.add(new RichTextSpanUnit(i16, i3, richTextSpanUnit2.color, richTextSpanUnit2.jump, richTextSpanUnit2.clickFun));
                                                    }
                                                    i3++;
                                                }
                                            }
                                            arrayList = arrayList4;
                                        }
                                        final String str11 = str9;
                                        RichTextViewKt.b(viewContainer4, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.appendEmptyView.1.2.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(RichTextView richTextView) {
                                                RichTextView richTextView2 = richTextView;
                                                richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.appendEmptyView.1.2.1.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                                        RichTextAttr richTextAttr2 = richTextAttr;
                                                        richTextAttr2.marginTop(20.0f);
                                                        richTextAttr2.marginBottom(34.0f);
                                                        richTextAttr2.marginLeft(19.0f);
                                                        richTextAttr2.marginRight(19.0f);
                                                        ce.fontSize$default(richTextAttr2, 14.0f, null, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str12 = str11;
                                                final List<RichTextSpanUnit> list6 = arrayList;
                                                final Function0 function0 = null;
                                                new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchRichTextUtil$generateSpanByRichTextSpanUnitList$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(RichTextView richTextView3) {
                                                        RichTextView richTextView4 = richTextView3;
                                                        final Ref.IntRef intRef = new Ref.IntRef();
                                                        List<RichTextSpanUnit> list7 = list6;
                                                        final String str13 = str12;
                                                        final Function0<Unit> function02 = function0;
                                                        for (final RichTextSpanUnit richTextSpanUnit6 : list7) {
                                                            RichTextViewKt.c(richTextView4, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchRichTextUtil$generateSpanByRichTextSpanUnitList$1$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(cf cfVar) {
                                                                    cf cfVar2 = cfVar;
                                                                    String substring = str13.substring(intRef.element, richTextSpanUnit6.start);
                                                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                                    cfVar2.text(substring);
                                                                    cfVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                                    final Function0<Unit> function03 = function02;
                                                                    cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchRichTextUtil$generateSpanByRichTextSpanUnitList$1$1$1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            Function0<Unit> function04 = function03;
                                                                            if (function04 != null) {
                                                                                function04.invoke();
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            RichTextViewKt.c(richTextView4, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchRichTextUtil$generateSpanByRichTextSpanUnitList$1$1$2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(cf cfVar) {
                                                                    cf cfVar2 = cfVar;
                                                                    String str14 = str13;
                                                                    RichTextSpanUnit richTextSpanUnit7 = richTextSpanUnit6;
                                                                    String substring = str14.substring(richTextSpanUnit7.start, richTextSpanUnit7.end);
                                                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                                    cfVar2.text(substring);
                                                                    cfVar2.color(richTextSpanUnit6.color);
                                                                    final RichTextSpanUnit richTextSpanUnit8 = richTextSpanUnit6;
                                                                    cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchRichTextUtil$generateSpanByRichTextSpanUnitList$1$1$2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            Function0<Unit> function03 = RichTextSpanUnit.this.clickFun;
                                                                            if (function03 != null) {
                                                                                function03.invoke();
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            intRef.element = richTextSpanUnit6.end;
                                                        }
                                                        if (intRef.element < str12.length()) {
                                                            final String str14 = str12;
                                                            final Function0<Unit> function03 = function0;
                                                            RichTextViewKt.c(richTextView4, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchRichTextUtil$generateSpanByRichTextSpanUnitList$1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(cf cfVar) {
                                                                    cf cfVar2 = cfVar;
                                                                    String substring = str14.substring(intRef.element);
                                                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                                                                    cfVar2.text(substring);
                                                                    cfVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                                    final Function0<Unit> function04 = function03;
                                                                    cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchRichTextUtil.generateSpanByRichTextSpanUnitList.1.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            Function0<Unit> function05 = function04;
                                                                            if (function05 != null) {
                                                                                function05.invoke();
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }.invoke(richTextView2);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchContactTabContentView qSearchContactTabContentView4 = QSearchContactTabContentView.this;
                        qSearchCommonSimpleTitleBottomDialog2.event(new Function1<QSearchCommonSimpleTitleBottomDialogEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.appendEmptyView.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchCommonSimpleTitleBottomDialogEvent qSearchCommonSimpleTitleBottomDialogEvent) {
                                final QSearchContactTabContentView qSearchContactTabContentView5 = QSearchContactTabContentView.this;
                                qSearchCommonSimpleTitleBottomDialogEvent.onDismiss = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.appendEmptyView.1.2.2.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QSearchContactTabContentView.this.setShowSearchEmptyActionSheet(false);
                                        return Unit.INSTANCE;
                                    }
                                };
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

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final Function1<ViewContainer<?, ?>, Unit> configItemView(final ISearchItemModel iSearchItemModel, final int i3) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView$configItemView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                KLog.INSTANCE.d("ashionTest11", "configItemView   \u6d4b\u8bd5\u517c\u5bb9");
                final ISearchItemModel iSearchItemModel2 = ISearchItemModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView$configItemView$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(ISearchItemModel.this instanceof SearchContactItemModel);
                    }
                };
                final ISearchItemModel iSearchItemModel3 = ISearchItemModel.this;
                final QSearchContactTabContentView qSearchContactTabContentView = this;
                final int i16 = i3;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView$configItemView$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ISearchItemModel iSearchItemModel4 = ISearchItemModel.this;
                        Intrinsics.checkNotNull(iSearchItemModel4, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel");
                        final SearchContactItemModel searchContactItemModel = (SearchContactItemModel) iSearchItemModel4;
                        final QSearchContactTabContentView qSearchContactTabContentView2 = qSearchContactTabContentView;
                        final int i17 = i16;
                        conditionView.addChild(new QSearchContactWholeCardItemView(), new Function1<QSearchContactWholeCardItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.configItemView.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchContactWholeCardItemView qSearchContactWholeCardItemView) {
                                final SearchContactItemModel searchContactItemModel2 = SearchContactItemModel.this;
                                final QSearchContactTabContentView qSearchContactTabContentView3 = qSearchContactTabContentView2;
                                final int i18 = i17;
                                qSearchContactWholeCardItemView.attr(new Function1<QSearchContactWholeCardItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView.configItemView.1.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchContactWholeCardItemAttr qSearchContactWholeCardItemAttr) {
                                        QSearchContactWholeCardItemAttr qSearchContactWholeCardItemAttr2 = qSearchContactWholeCardItemAttr;
                                        qSearchContactWholeCardItemAttr2.data = SearchContactItemModel.this;
                                        qSearchContactWholeCardItemAttr2.keyword = QSearchContactTabContentView.access$getAttr(qSearchContactTabContentView3).getViewModel().keyword;
                                        qSearchContactWholeCardItemAttr2.index = i18;
                                        qSearchContactWholeCardItemAttr2.traceId = QSearchContactTabContentView.access$getAttr(qSearchContactTabContentView3).getViewModel().repo.currentTraceId;
                                        qSearchContactWholeCardItemAttr2.isFirstItem = i18 == 0;
                                        qSearchContactWholeCardItemAttr2.tabData = QSearchContactTabContentView.access$getAttr(qSearchContactTabContentView3).tabData;
                                        qSearchContactWholeCardItemAttr2.setLastItem(i18 == QSearchContactTabContentView.access$getAttr(qSearchContactTabContentView3).getViewModel().getDataList().size() - 1);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QSearchContactTabContentView qSearchContactTabContentView2 = this;
                final ISearchItemModel iSearchItemModel4 = ISearchItemModel.this;
                final int i17 = i3;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView$configItemView$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        QSearchContactTabContentView qSearchContactTabContentView3 = QSearchContactTabContentView.this;
                        ISearchItemModel iSearchItemModel5 = iSearchItemModel4;
                        int i18 = i17;
                        KProperty<Object>[] kPropertyArr = QSearchContactTabContentView.$$delegatedProperties;
                        qSearchContactTabContentView3.getClass();
                        new QSearchTabContentView$configItemView$1(iSearchItemModel5, i18, qSearchContactTabContentView3).invoke(conditionView);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    public final void setShowSearchEmptyActionSheet(boolean z16) {
        this.showSearchEmptyActionSheet$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
