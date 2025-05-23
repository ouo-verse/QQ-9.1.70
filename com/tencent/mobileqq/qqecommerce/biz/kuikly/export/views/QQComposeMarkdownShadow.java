package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.SizeF;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.android.androidbypass.parser.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b$\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQComposeMarkdownShadow;", "Li01/f;", "", "text", "", "width", "Landroid/text/Layout;", "f", "", "propKey", "", "propValue", "", "b", "Landroid/util/SizeF;", "constraintSize", "c", "Lcom/tencent/android/androidbypass/parser/d;", "Lcom/tencent/android/androidbypass/parser/d;", "markdownParserBuilder", "Landroid/text/Layout;", "g", "()Landroid/text/Layout;", "setTextLayout", "(Landroid/text/Layout;)V", "textLayout", "", "d", UserInfo.SEX_FEMALE, "fontSize", "e", "Ljava/lang/String;", "paragraphSpacing", "I", "maxLines", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "cachedTextView", "Lcom/tencent/android/androidbypass/parser/a;", "i", "Lcom/tencent/android/androidbypass/parser/a;", "parser", "Landroid/text/TextPaint;", "j", "Lkotlin/Lazy;", "()Landroid/text/TextPaint;", "textPaint", "<init>", "()V", "k", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQComposeMarkdownShadow extends i01.f {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Layout textLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float paragraphSpacing;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int maxLines;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView cachedTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.android.androidbypass.parser.a parser;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy textPaint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.android.androidbypass.parser.d markdownParserBuilder = com.tencent.qqnt.markdown.g.f359430a.g();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float fontSize = 17.0f;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String text = "";

    public QQComposeMarkdownShadow() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextPaint>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQComposeMarkdownShadow$textPaint$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextPaint invoke() {
                float f16;
                TextPaint textPaint = new TextPaint();
                QQComposeMarkdownShadow qQComposeMarkdownShadow = QQComposeMarkdownShadow.this;
                textPaint.setAntiAlias(true);
                textPaint.setDither(true);
                textPaint.setColor(-16777216);
                com.tencent.kuikly.core.render.android.a aVar = qQComposeMarkdownShadow.get_kuiklyRenderContext();
                f16 = qQComposeMarkdownShadow.fontSize;
                textPaint.setTextSize(com.tencent.kuikly.core.render.android.css.ktx.b.s(aVar, f16));
                return textPaint;
            }
        });
        this.textPaint = lazy;
    }

    private final TextPaint h() {
        return (TextPaint) this.textPaint.getValue();
    }

    @Override // i01.b
    public void b(String propKey, Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        int hashCode = propKey.hashCode();
        if (hashCode == -1556686091) {
            if (propKey.equals("paragraphSpacing")) {
                this.paragraphSpacing = Float.parseFloat(propValue.toString());
                this.markdownParserBuilder.i().Z = this.paragraphSpacing;
                this.parser = null;
                return;
            }
            return;
        }
        if (hashCode != 246938863) {
            if (hashCode == 390232059 && propKey.equals("maxLines")) {
                this.maxLines = Integer.parseInt(propValue.toString());
                return;
            }
            return;
        }
        if (propKey.equals("markdown")) {
            this.text = propValue.toString();
        }
    }

    @Override // i01.b
    public SizeF c(SizeF constraintSize) {
        Intrinsics.checkNotNullParameter(constraintSize, "constraintSize");
        TextView textView = this.cachedTextView;
        if (textView == null) {
            com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
            textView = new TextView(aVar != null ? aVar.getContext() : null);
            textView.setTextColor(-16777216);
            this.cachedTextView = textView;
        }
        TextView textView2 = textView;
        com.tencent.android.androidbypass.parser.a aVar2 = this.parser;
        if (aVar2 == null) {
            aVar2 = this.markdownParserBuilder.b();
            this.parser = aVar2;
        }
        this.textLayout = f(a.C0724a.a(aVar2, this.text, textView2, null, 4, null), (int) constraintSize.getWidth());
        return new SizeF(r9.getWidth(), r9.getHeight());
    }

    /* renamed from: g, reason: from getter */
    public final Layout getTextLayout() {
        return this.textLayout;
    }

    private final Layout f(CharSequence text, int width) {
        if (width <= 0) {
            width = (int) Layout.getDesiredWidth(text, h());
        }
        StaticLayout build = StaticLayout.Builder.obtain(text, 0, text.length(), h(), width).setMaxLines(this.maxLines).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(false).build();
        Intrinsics.checkNotNullExpressionValue(build, "{\n            StaticLayo\u2026       .build()\n        }");
        return build;
    }
}
