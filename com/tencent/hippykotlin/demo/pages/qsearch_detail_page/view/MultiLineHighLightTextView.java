package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class MultiLineHighLightTextView extends ComposeView<MultiLineHighLightTextAttr, MultiLineHighLightTextEvent> {
    public String preText = "";
    public String postText = "";
    public String singleText = "";

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ MultiLineHighLightTextAttr access$getAttr(MultiLineHighLightTextView multiLineHighLightTextView) {
        return (MultiLineHighLightTextAttr) multiLineHighLightTextView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.MultiLineHighLightTextView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final MultiLineHighLightTextView multiLineHighLightTextView = MultiLineHighLightTextView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.MultiLineHighLightTextView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.MultiLineHighLightTextView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        if (!(MultiLineHighLightTextView.access$getAttr(MultiLineHighLightTextView.this).text.length() == 0)) {
                            if (!(MultiLineHighLightTextView.this.singleText.length() > 0)) {
                                final MultiLineHighLightTextView multiLineHighLightTextView2 = MultiLineHighLightTextView.this;
                                RichTextViewKt.b(vVar2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.MultiLineHighLightTextView.body.1.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(RichTextView richTextView) {
                                        RichTextView richTextView2 = richTextView;
                                        final MultiLineHighLightTextView multiLineHighLightTextView3 = MultiLineHighLightTextView.this;
                                        richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.MultiLineHighLightTextView.body.1.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(RichTextAttr richTextAttr) {
                                                RichTextAttr richTextAttr2 = richTextAttr;
                                                richTextAttr2.mo141height((FontModuleExtKt.qqFontScaleAddSize(MultiLineHighLightTextView.access$getAttr(MultiLineHighLightTextView.this).fontSize) * MultiLineHighLightTextView.access$getAttr(MultiLineHighLightTextView.this).lines) + 40.0f);
                                                ce.fontSize$default(richTextAttr2, MultiLineHighLightTextView.access$getAttr(MultiLineHighLightTextView.this).fontSize, null, 2, null);
                                                richTextAttr2.fontWeight400();
                                                richTextAttr2.lines(MultiLineHighLightTextView.access$getAttr(MultiLineHighLightTextView.this).lines);
                                                richTextAttr2.textOverFlowTail();
                                                richTextAttr2.lineHeight(20.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final MultiLineHighLightTextView multiLineHighLightTextView4 = MultiLineHighLightTextView.this;
                                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.MultiLineHighLightTextView.body.1.1.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(cf cfVar) {
                                                cf cfVar2 = cfVar;
                                                cfVar2.text(MultiLineHighLightTextView.this.preText);
                                                cfVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final MultiLineHighLightTextView multiLineHighLightTextView5 = MultiLineHighLightTextView.this;
                                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.MultiLineHighLightTextView.body.1.1.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(cf cfVar) {
                                                cf cfVar2 = cfVar;
                                                cfVar2.text(MultiLineHighLightTextView.access$getAttr(MultiLineHighLightTextView.this).highlightText);
                                                cfVar2.color(QUISkinColor.INSTANCE.wrapColor("brand_standard"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final MultiLineHighLightTextView multiLineHighLightTextView6 = MultiLineHighLightTextView.this;
                                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.MultiLineHighLightTextView.body.1.1.3.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(cf cfVar) {
                                                cf cfVar2 = cfVar;
                                                cfVar2.text(MultiLineHighLightTextView.this.postText);
                                                cfVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }
                        final MultiLineHighLightTextView multiLineHighLightTextView3 = MultiLineHighLightTextView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.MultiLineHighLightTextView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final MultiLineHighLightTextView multiLineHighLightTextView4 = MultiLineHighLightTextView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.MultiLineHighLightTextView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(MultiLineHighLightTextView.access$getAttr(MultiLineHighLightTextView.this).fontSize) + 40.0f);
                                        ceVar2.text(MultiLineHighLightTextView.this.singleText);
                                        ceVar2.lines(MultiLineHighLightTextView.access$getAttr(MultiLineHighLightTextView.this).lines);
                                        ceVar2.textOverFlowTail();
                                        ce.fontSize$default(ceVar2, MultiLineHighLightTextView.access$getAttr(MultiLineHighLightTextView.this).fontSize, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.lineHeight(20.0f);
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
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new MultiLineHighLightTextAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new MultiLineHighLightTextEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        int indexOf$default;
        String take;
        String takeLast;
        super.created();
        if (((MultiLineHighLightTextAttr) getAttr()).lines > 1 && ((MultiLineHighLightTextAttr) getAttr()).maxLength > 0 && ((MultiLineHighLightTextAttr) getAttr()).fontSize > 0.0f) {
            if (!(((MultiLineHighLightTextAttr) getAttr()).text.length() == 0)) {
                if (!(((MultiLineHighLightTextAttr) getAttr()).highlightText.length() == 0)) {
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) ((MultiLineHighLightTextAttr) getAttr()).text, ((MultiLineHighLightTextAttr) getAttr()).highlightText, 0, true, 2, (Object) null);
                    if (indexOf$default < 0) {
                        this.singleText = ((MultiLineHighLightTextAttr) getAttr()).text;
                        return;
                    }
                    String substring = ((MultiLineHighLightTextAttr) getAttr()).text.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    this.preText = substring;
                    String substring2 = ((MultiLineHighLightTextAttr) getAttr()).text.substring(((MultiLineHighLightTextAttr) getAttr()).highlightText.length() + indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    this.postText = substring2;
                    if (this.postText.length() + ((MultiLineHighLightTextAttr) getAttr()).highlightText.length() + this.preText.length() <= ((MultiLineHighLightTextAttr) getAttr()).maxLength) {
                        return;
                    }
                    int length = (((MultiLineHighLightTextAttr) getAttr()).maxLength - ((MultiLineHighLightTextAttr) getAttr()).highlightText.length()) / 2;
                    int length2 = this.preText.length() < length ? (length - this.preText.length()) + length : length;
                    if (this.postText.length() < length2) {
                        length += length2 - this.postText.length();
                    }
                    if (this.preText.length() > length) {
                        takeLast = StringsKt___StringsKt.takeLast(this.preText, length);
                        this.preText = takeLast;
                    }
                    if (this.postText.length() > length2) {
                        take = StringsKt___StringsKt.take(this.postText, length2);
                        this.postText = take;
                        return;
                    }
                    return;
                }
            }
            this.singleText = ((MultiLineHighLightTextAttr) getAttr()).text;
            return;
        }
        throw new IllegalStateException(MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR.toString());
    }
}
