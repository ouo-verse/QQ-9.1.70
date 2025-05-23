package com.tencent.android.androidbypass;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Spanned;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.android.androidbypass.codeblock.span.CodeBlockSpan;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J0\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0006\u0010\u0011\u001a\u00020\u0005R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006%"}, d2 = {"Lcom/tencent/android/androidbypass/MarkdownTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", h.F, "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "scene", "", "e", "()Ljava/util/Map;", "attr", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class MarkdownTextView extends AppCompatTextView {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String scene;

    @JvmOverloads
    public MarkdownTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
    }

    @NotNull
    public final Map<String, String> e() {
        CharSequence charSequence;
        CodeBlockSpan[] codeBlockSpanArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Pair[] pairArr = new Pair[6];
        int i3 = 0;
        pairArr[0] = TuplesKt.to("text_length", String.valueOf(getText().length()));
        pairArr[1] = TuplesKt.to("width", String.valueOf(getWidth()));
        pairArr[2] = TuplesKt.to("height", String.valueOf(getHeight()));
        pairArr[3] = TuplesKt.to("hash", String.valueOf(hashCode()));
        CharSequence text = getText();
        if (!(text instanceof Spanned)) {
            charSequence = null;
        } else {
            charSequence = text;
        }
        Spanned spanned = (Spanned) charSequence;
        if (spanned != null && (codeBlockSpanArr = (CodeBlockSpan[]) spanned.getSpans(0, text.length(), CodeBlockSpan.class)) != null) {
            i3 = codeBlockSpanArr.length;
        }
        pairArr[4] = TuplesKt.to("has_code", String.valueOf(i3));
        pairArr[5] = TuplesKt.to("scene", this.scene);
        return b.g(pairArr);
    }

    public final void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        CharSequence text = getText();
        if (!(text instanceof Spanned)) {
            text = null;
        }
        Spanned spanned = (Spanned) text;
        if (spanned != null) {
            CodeBlockSpan[] codeBlockSpanArr = (CodeBlockSpan[]) spanned.getSpans(0, getText().length(), CodeBlockSpan.class);
            if (codeBlockSpanArr != null) {
                for (CodeBlockSpan codeBlockSpan : codeBlockSpanArr) {
                    codeBlockSpan.q();
                }
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        b.d().c();
        super.onDraw(canvas);
        b.d().b(e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        b.e().c();
        super.onLayout(changed, left, top, right, bottom);
        b.e().b(e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        b.f().c();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        b.f().b(e());
    }

    public final void setScene(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.scene = str;
        }
    }

    @JvmOverloads
    public MarkdownTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ MarkdownTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MarkdownTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.scene = "unknown";
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, wt.a.M, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl\u2026e.MarkdownTextView, 0, 0)");
        try {
            String string = obtainStyledAttributes.getString(wt.a.N);
            this.scene = string != null ? string : "unknown";
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
