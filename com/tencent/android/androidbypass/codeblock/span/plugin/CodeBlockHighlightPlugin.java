package com.tencent.android.androidbypass.codeblock.span.plugin;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.SparseArray;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.android.androidbypass.codeblock.span.d;
import com.tencent.android.androidbypass.codeblock.span.e;
import com.tencent.android.androidbypass.codeblock.span.event.c;
import com.tencent.android.androidbypass.codeblock.span.plugin.a;
import com.tencent.android.androidbypass.codeblock.utils.CodeBlockTools;
import com.tencent.android.androidbypass.codeblock.utils.c;
import com.tencent.bypass.nativeinterface.CodeNode;
import com.tencent.bypass.nativeinterface.Syntax;
import com.tencent.bypass.nativeinterface.Text;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010;\u001a\u000209\u00a2\u0006\u0004\b<\u0010=J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J,\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\"\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J:\u0010 \u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010\"\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010$\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010*R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010*R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010-R\u0016\u00100\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/plugin/CodeBlockHighlightPlugin;", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/a;", "Lcom/tencent/android/androidbypass/codeblock/span/d;", "highlightLine", "Landroid/graphics/Canvas;", PM.CANVAS, "", "offsetX", "baseLineY", "", "g", "Landroid/graphics/Rect;", "visibleRect", "codeBlockRect", "", NodeProps.LINE_HEIGHT, "Lkotlin/Pair;", "i", "", "text", "", "Lcom/tencent/bypass/nativeinterface/CodeNode;", "parsedNodeList", h.F, "w", "Landroid/graphics/Paint$FontMetricsInt;", "fontMetricsInt", "width", "a", "left", "top", "bottom", "d", "height", "c", "tvVisibleRect", "b", "Lcom/tencent/android/androidbypass/codeblock/config/highlight/a;", "Lcom/tencent/android/androidbypass/codeblock/config/highlight/a;", "highlightConfig", "Landroid/util/SparseArray;", "Lcom/tencent/android/androidbypass/codeblock/span/a;", "Landroid/util/SparseArray;", "breakTextList", "highlightLineList", "I", "highlightAreaVerticalOffset", "e", "highlightAreaHeight", "Landroid/graphics/Paint;", "f", "Lkotlin/Lazy;", "j", "()Landroid/graphics/Paint;", "highlightPaint", "Ljava/util/List;", "drawNodeList", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/b;", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/b;", "pluginContext", "<init>", "(Lcom/tencent/android/androidbypass/codeblock/span/plugin/b;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class CodeBlockHighlightPlugin implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.android.androidbypass.codeblock.config.highlight.a highlightConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<com.tencent.android.androidbypass.codeblock.span.a> breakTextList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<d> highlightLineList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int highlightAreaVerticalOffset;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int highlightAreaHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy highlightPaint;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private List<CodeNode> drawNodeList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final b pluginContext;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/plugin/CodeBlockHighlightPlugin$a;", "", "", "NEW_LINE", "Ljava/lang/String;", "TAG", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.codeblock.span.plugin.CodeBlockHighlightPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13737);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CodeBlockHighlightPlugin(@NotNull b pluginContext) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(pluginContext, "pluginContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pluginContext);
            return;
        }
        this.pluginContext = pluginContext;
        this.highlightConfig = pluginContext.a().b();
        this.breakTextList = new SparseArray<>();
        this.highlightLineList = new SparseArray<>();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Paint>() { // from class: com.tencent.android.androidbypass.codeblock.span.plugin.CodeBlockHighlightPlugin$highlightPaint$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) CodeBlockHighlightPlugin.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                com.tencent.android.androidbypass.codeblock.config.highlight.a aVar;
                com.tencent.android.androidbypass.codeblock.config.highlight.a aVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (Paint) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                aVar = CodeBlockHighlightPlugin.this.highlightConfig;
                paint.setTextSize(aVar.a());
                aVar2 = CodeBlockHighlightPlugin.this.highlightConfig;
                paint.setTypeface(aVar2.b());
                return paint;
            }
        });
        this.highlightPaint = lazy;
        this.drawNodeList = new ArrayList();
    }

    private final void g(d highlightLine, Canvas canvas, float offsetX, float baseLineY) {
        boolean endsWith$default;
        CharSequence b16;
        CharSequence charSequence;
        if (Intrinsics.areEqual(highlightLine.b(), "\n")) {
            return;
        }
        for (e eVar : highlightLine.a()) {
            boolean z16 = false;
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(eVar.b(), "\n", false, 2, null);
            if (endsWith$default) {
                b16 = eVar.b().subSequence(0, eVar.b().length() - 1);
            } else {
                b16 = eVar.b();
            }
            if (b16.length() > 0) {
                z16 = true;
            }
            if (z16) {
                charSequence = b16;
            } else {
                charSequence = null;
            }
            if (charSequence != null) {
                j().setColor(eVar.a());
                canvas.drawText(charSequence, 0, charSequence.length(), offsetX, baseLineY, j());
            }
            offsetX += eVar.c();
        }
    }

    private final List<CodeNode> h(CharSequence text, List<CodeNode> parsedNodeList) {
        boolean z16;
        String str;
        String str2;
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return parsedNodeList;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<CodeNode> it = parsedNodeList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CodeNode next = it.next();
            if (c.c(next).length() + i3 < text.length()) {
                arrayList.add(next);
                i3 += c.c(next).length();
            } else if (c.c(next).length() + i3 == text.length()) {
                arrayList.add(next);
            } else {
                if (next.getType() == 2) {
                    String c16 = c.c(next);
                    int length = text.length() - i3;
                    if (c16 != null) {
                        str = c16.substring(0, length);
                        Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                        str2 = "";
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else if (next.getType() != 1) {
                    str = "";
                    str2 = str;
                } else {
                    String c17 = c.c(next);
                    int length2 = text.length() - i3;
                    if (c17 != null) {
                        String substring = c17.substring(0, length2);
                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                        str2 = substring;
                        str = "";
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                int type = next.getType();
                Syntax syntax = next.getSyntax();
                Intrinsics.checkNotNullExpressionValue(syntax, "node.syntax");
                String type2 = syntax.getType();
                Syntax syntax2 = next.getSyntax();
                Intrinsics.checkNotNullExpressionValue(syntax2, "node.syntax");
                String alias = syntax2.getAlias();
                Syntax syntax3 = next.getSyntax();
                Intrinsics.checkNotNullExpressionValue(syntax3, "node.syntax");
                boolean greedy = syntax3.getGreedy();
                Syntax syntax4 = next.getSyntax();
                Intrinsics.checkNotNullExpressionValue(syntax4, "node.syntax");
                arrayList.add(new CodeNode(type, new Syntax(type2, alias, str2, greedy, syntax4.getTokenized()), new Text(str)));
            }
        }
        return arrayList;
    }

    private final Pair<Integer, Integer> i(Rect visibleRect, Rect codeBlockRect, int lineHeight) {
        int coerceIn;
        int i3;
        int coerceIn2;
        int i16 = this.highlightAreaVerticalOffset + codeBlockRect.top;
        int i17 = visibleRect.top;
        if (i16 < i17) {
            coerceIn = RangesKt___RangesKt.coerceIn((i17 - i16) / lineHeight, 0, this.breakTextList.size());
        } else {
            coerceIn = 0;
        }
        int i18 = i16 + this.highlightAreaHeight;
        if (i18 >= visibleRect.bottom) {
            i3 = (visibleRect.height() / lineHeight) + coerceIn;
        } else {
            i3 = coerceIn + ((i18 - visibleRect.top) / lineHeight);
        }
        coerceIn2 = RangesKt___RangesKt.coerceIn(i3, 0, this.breakTextList.size());
        return new Pair<>(Integer.valueOf(coerceIn), Integer.valueOf(coerceIn2));
    }

    private final Paint j() {
        return (Paint) this.highlightPaint.getValue();
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void a(@NotNull Paint.FontMetricsInt fontMetricsInt, int width, @Nullable CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, fontMetricsInt, Integer.valueOf(width), text);
            return;
        }
        Intrinsics.checkNotNullParameter(fontMetricsInt, "fontMetricsInt");
        if (this.pluginContext.d().c().length() != 0) {
            z16 = false;
        }
        if (!z16 && !this.pluginContext.d().a().isEmpty()) {
            this.drawNodeList = h(text, this.pluginContext.d().a());
            Rect d16 = this.pluginContext.a().getGlobalConfig().d();
            com.tencent.android.androidbypass.codeblock.utils.a aVar = new com.tencent.android.androidbypass.codeblock.utils.a(j(), (width - d16.left) - d16.right, this.highlightConfig, this.drawNodeList, 0, 0);
            this.breakTextList.clear();
            com.tencent.android.androidbypass.codeblock.utils.b bVar = new com.tencent.android.androidbypass.codeblock.utils.b(0, false, this.breakTextList);
            CharSequence c16 = this.pluginContext.d().c();
            if (text != null) {
                c16 = c16.subSequence(0, Math.min(text.length(), c16.length()));
            }
            CodeBlockTools.f72031a.a(c16, aVar, bVar);
            this.pluginContext.c().a(new c.a(bVar.c()));
            this.highlightAreaVerticalOffset = fontMetricsInt.bottom;
            Paint.FontMetricsInt fontMetricsInt2 = j().getFontMetricsInt();
            int size = this.breakTextList.size() * (fontMetricsInt2.bottom - fontMetricsInt2.top);
            this.highlightAreaHeight = size;
            int i3 = fontMetricsInt.bottom + size;
            fontMetricsInt.bottom = i3;
            fontMetricsInt.descent = i3;
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void b(@NotNull Canvas canvas, @NotNull Rect tvVisibleRect, @NotNull Rect codeBlockRect, @Nullable CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, canvas, tvVisibleRect, codeBlockRect, text);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(tvVisibleRect, "tvVisibleRect");
        Intrinsics.checkNotNullParameter(codeBlockRect, "codeBlockRect");
        Paint.FontMetricsInt fontMetricsInt = j().getFontMetricsInt();
        int i3 = fontMetricsInt.bottom - fontMetricsInt.top;
        Pair<Integer, Integer> i16 = i(tvVisibleRect, codeBlockRect, i3);
        Rect d16 = this.pluginContext.a().getGlobalConfig().d();
        float abs = codeBlockRect.top + this.highlightAreaVerticalOffset + Math.abs(fontMetricsInt.top) + (i16.getFirst().intValue() * i3);
        int intValue = i16.getSecond().intValue();
        for (int intValue2 = i16.getFirst().intValue(); intValue2 < intValue; intValue2++) {
            d dVar = this.highlightLineList.get(intValue2);
            if (dVar == null) {
                CodeBlockTools codeBlockTools = CodeBlockTools.f72031a;
                Paint j3 = j();
                List<CodeNode> list = this.drawNodeList;
                com.tencent.android.androidbypass.codeblock.span.a aVar = this.breakTextList.get(intValue2);
                Intrinsics.checkNotNullExpressionValue(aVar, "breakTextList[index]");
                dVar = codeBlockTools.b(j3, list, aVar, this.highlightConfig);
                this.highlightLineList.put(intValue2, dVar);
            }
            g(dVar, canvas, d16.left, abs);
            abs += i3;
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void c(@NotNull Canvas canvas, int width, int height, @Nullable CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, Integer.valueOf(width), Integer.valueOf(height), text);
        } else {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            d(canvas, 0.0f, width, 0, height, text);
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void d(@NotNull Canvas canvas, float left, int width, int top, int bottom, @Nullable CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, canvas, Float.valueOf(left), Integer.valueOf(width), Integer.valueOf(top), Integer.valueOf(bottom), text);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Paint.FontMetricsInt fontMetricsInt = j().getFontMetricsInt();
        int i3 = fontMetricsInt.bottom - fontMetricsInt.top;
        float abs = top + this.highlightAreaVerticalOffset + Math.abs(r9);
        float f16 = left + this.pluginContext.a().getGlobalConfig().d().left;
        int size = this.breakTextList.size();
        for (int i16 = 0; i16 < size; i16++) {
            d dVar = this.highlightLineList.get(i16);
            if (dVar == null || (!Intrinsics.areEqual(dVar.b(), this.breakTextList.get(i16).c()))) {
                CodeBlockTools codeBlockTools = CodeBlockTools.f72031a;
                Paint j3 = j();
                List<CodeNode> list = this.drawNodeList;
                com.tencent.android.androidbypass.codeblock.span.a aVar = this.breakTextList.get(i16);
                Intrinsics.checkNotNullExpressionValue(aVar, "breakTextList[index]");
                dVar = codeBlockTools.b(j3, list, aVar, this.highlightConfig);
                this.highlightLineList.put(i16, dVar);
            }
            g(dVar, canvas, f16, abs);
            abs += i3;
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void e(@NotNull com.tencent.android.androidbypass.codeblock.span.event.a event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            a.C0712a.a(this, event);
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return 2;
    }
}
