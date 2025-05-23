package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class HighlightTextView extends QSearchBaseAdaptWidthView<HighlightAttr, HighlightEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HighlightTextView.class, "preText", "getPreText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HighlightTextView.class, "postText", "getPostText()Ljava/lang/String;", 0)};
    public aa<RichTextView> textRef;
    public final ReadWriteProperty preText$delegate = c.a("");
    public final ReadWriteProperty postText$delegate = c.a("");
    public String originPreText = "";
    public String originPostText = "";
    public String highlightText = "";
    public boolean needRichText = true;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ HighlightAttr access$getAttr(HighlightTextView highlightTextView) {
        return (HighlightAttr) highlightTextView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView
    public final Function1<ViewContainer<?, ?>, Unit> buildContent() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView$buildContent$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final HighlightTextView highlightTextView = HighlightTextView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView$buildContent$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(!HighlightTextView.this.needRichText);
                    }
                };
                final HighlightTextView highlightTextView2 = HighlightTextView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView$buildContent$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final HighlightTextView highlightTextView3 = HighlightTextView.this;
                        cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView.buildContent.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final HighlightTextView highlightTextView4 = HighlightTextView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView.buildContent.1.2.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        RichTextView b16;
                                        FlexNode flexNode;
                                        ce ceVar2 = ceVar;
                                        HighlightTextView highlightTextView5 = HighlightTextView.this;
                                        KProperty<Object>[] kPropertyArr = HighlightTextView.$$delegatedProperties;
                                        if (Intrinsics.areEqual(highlightTextView5.getPostText(), HighlightTextView.this.originPostText)) {
                                            str = HighlightTextView.this.getPostText();
                                        } else {
                                            aa<RichTextView> aaVar = HighlightTextView.this.textRef;
                                            if (aaVar != null && (b16 = aaVar.b()) != null && (flexNode = b16.getFlexNode()) != null) {
                                                flexNode.a0();
                                            }
                                            str = HighlightTextView.this.getPostText() + Typography.ellipsis;
                                        }
                                        ceVar2.text(str);
                                        ce.fontSize$default(ceVar2, HighlightTextView.access$getAttr(HighlightTextView.this).fontSize, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.lines(1);
                                        ceVar2.textOverFlowTail();
                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final HighlightTextView highlightTextView3 = HighlightTextView.this;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView$buildContent$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final HighlightTextView highlightTextView4 = HighlightTextView.this;
                        RichTextViewKt.b(conditionView, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView.buildContent.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextView richTextView) {
                                RichTextView richTextView2 = richTextView;
                                final HighlightTextView highlightTextView5 = HighlightTextView.this;
                                richTextView2.ref(richTextView2, new Function1<aa<RichTextView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView.buildContent.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<RichTextView> aaVar) {
                                        HighlightTextView.this.textRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final HighlightTextView highlightTextView6 = HighlightTextView.this;
                                richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView.buildContent.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                        RichTextAttr richTextAttr2 = richTextAttr;
                                        ce.fontSize$default(richTextAttr2, HighlightTextView.access$getAttr(HighlightTextView.this).fontSize, null, 2, null);
                                        richTextAttr2.fontWeight400();
                                        richTextAttr2.lines(1);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final HighlightTextView highlightTextView7 = HighlightTextView.this;
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView.buildContent.1.3.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        String sb5;
                                        RichTextView b16;
                                        FlexNode flexNode;
                                        cf cfVar2 = cfVar;
                                        HighlightTextView highlightTextView8 = HighlightTextView.this;
                                        KProperty<Object>[] kPropertyArr = HighlightTextView.$$delegatedProperties;
                                        if (Intrinsics.areEqual(highlightTextView8.getPreText(), HighlightTextView.this.originPreText)) {
                                            sb5 = HighlightTextView.this.getPreText();
                                        } else {
                                            aa<RichTextView> aaVar = HighlightTextView.this.textRef;
                                            if (aaVar != null && (b16 = aaVar.b()) != null && (flexNode = b16.getFlexNode()) != null) {
                                                flexNode.a0();
                                            }
                                            StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m(Typography.ellipsis);
                                            m3.append(HighlightTextView.this.getPreText());
                                            sb5 = m3.toString();
                                        }
                                        cfVar2.text(sb5);
                                        cfVar2.color(HighlightTextView.access$getAttr(HighlightTextView.this).textColor);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final HighlightTextView highlightTextView8 = HighlightTextView.this;
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView.buildContent.1.3.1.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        cf cfVar2 = cfVar;
                                        cfVar2.text(HighlightTextView.this.highlightText);
                                        cfVar2.color(QUISkinColor.INSTANCE.wrapColor("brand_standard"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final HighlightTextView highlightTextView9 = HighlightTextView.this;
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView.buildContent.1.3.1.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        String str;
                                        RichTextView b16;
                                        FlexNode flexNode;
                                        cf cfVar2 = cfVar;
                                        HighlightTextView highlightTextView10 = HighlightTextView.this;
                                        KProperty<Object>[] kPropertyArr = HighlightTextView.$$delegatedProperties;
                                        if (Intrinsics.areEqual(highlightTextView10.getPostText(), HighlightTextView.this.originPostText)) {
                                            str = HighlightTextView.this.getPostText();
                                        } else {
                                            aa<RichTextView> aaVar = HighlightTextView.this.textRef;
                                            if (aaVar != null && (b16 = aaVar.b()) != null && (flexNode = b16.getFlexNode()) != null) {
                                                flexNode.a0();
                                            }
                                            str = HighlightTextView.this.getPostText() + Typography.ellipsis;
                                        }
                                        cfVar2.text(str);
                                        cfVar2.color(HighlightTextView.access$getAttr(HighlightTextView.this).textColor);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                ?? r06 = HighlightTextView.access$getAttr(HighlightTextView.this).tailContentBuilder;
                if (r06 != 0) {
                    r06.invoke(viewContainer2);
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new HighlightAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new HighlightEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        String replace$default;
        boolean isBlank;
        int indexOf$default;
        String take;
        String take2;
        String takeLast;
        super.created();
        replace$default = StringsKt__StringsJVMKt.replace$default(((HighlightAttr) getAttr()).text, "\n", " ", false, 4, (Object) null);
        isBlank = StringsKt__StringsJVMKt.isBlank(((HighlightAttr) getAttr()).highlightText);
        if (!isBlank) {
            indexOf$default = StringsKt__StringsKt.indexOf$default(replace$default, ((HighlightAttr) getAttr()).highlightText, 0, ((HighlightAttr) getAttr()).isIgnoreCase, 2, (Object) null);
            if (indexOf$default < 0) {
                this.needRichText = false;
            }
        } else {
            this.needRichText = false;
            indexOf$default = 0;
        }
        if (!this.needRichText) {
            setPostText(replace$default);
            this.originPostText = getPostText();
        } else {
            String substring = replace$default.substring(indexOf$default, ((HighlightAttr) getAttr()).highlightText.length() + indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            this.highlightText = substring;
            String substring2 = replace$default.substring(substring.length() + indexOf$default, replace$default.length());
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            setPostText(substring2);
            this.originPostText = getPostText();
            take = StringsKt___StringsKt.take(replace$default, indexOf$default);
            setPreText(take);
            this.originPreText = getPreText();
        }
        if (getPreText().length() > ((HighlightAttr) getAttr()).maxLength) {
            takeLast = StringsKt___StringsKt.takeLast(getPreText(), ((HighlightAttr) getAttr()).maxLength);
            setPreText(takeLast);
        }
        if (getPostText().length() > ((HighlightAttr) getAttr()).maxLength) {
            take2 = StringsKt___StringsKt.take(getPostText(), ((HighlightAttr) getAttr()).maxLength);
            setPostText(take2);
        }
        int i3 = (((HighlightAttr) getAttr()).maxLength * 2) / 4;
        int i16 = 0;
        while (true) {
            if (getPostText().length() + this.highlightText.length() + getPreText().length() <= ((HighlightAttr) getAttr()).maxLength) {
                return;
            }
            int i17 = i16 + 1;
            if (i16 >= i3) {
                return;
            }
            if (!(getPreText().length() > 0)) {
                if (!(getPostText().length() > 0)) {
                    return;
                }
            }
            shrinkWidth();
            i16 = i17;
        }
    }

    public final String getPostText() {
        return (String) this.postText$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final String getPreText() {
        return (String) this.preText$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setPostText(String str) {
        this.postText$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final void setPreText(String str) {
        this.preText$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView
    public final boolean shrinkWidth() {
        CharSequence removeRange;
        String str = "";
        if (getPreText().length() > getPostText().length()) {
            if (getPreText().length() > 4) {
                removeRange = StringsKt__StringsKt.removeRange((CharSequence) getPreText(), 0, 4);
                str = removeRange.toString();
            }
            setPreText(str);
            return true;
        }
        if (getPostText().length() > 4) {
            str = StringsKt___StringsKt.take(getPostText(), getPostText().length() - 4);
        }
        setPostText(str);
        return true;
    }
}
