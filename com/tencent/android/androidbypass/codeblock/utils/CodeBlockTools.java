package com.tencent.android.androidbypass.codeblock.utils;

import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.bypass.nativeinterface.CodeNode;
import com.tencent.bypass.nativeinterface.Syntax;
import com.tencent.bypass.nativeinterface.Text;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J4\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J0\u0010#\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002J\u001e\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ,\u0010*\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0&2\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u0011\u00a8\u0006-"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/utils/CodeBlockTools;", "", "", "text", "", "start", "c", "Lcom/tencent/android/androidbypass/codeblock/utils/a;", "buildArgs", "Lcom/tencent/android/androidbypass/codeblock/utils/b;", "buildResult", "", "g", "breakLineText", "f", "Lcom/tencent/bypass/nativeinterface/CodeNode;", "codeNode", "Lcom/tencent/android/androidbypass/codeblock/config/highlight/a;", "highlightConfig", "Lkotlin/Pair;", "", "d", "Lcom/tencent/android/androidbypass/codeblock/span/e;", "highlightNode", "nodeTextAndColorPair", "end", "Lcom/tencent/android/androidbypass/codeblock/utils/d;", h.F, "result", "Lcom/tencent/android/androidbypass/codeblock/span/d;", "highlightLine", "Landroid/graphics/Paint;", "paint", "", "isEnd", "e", "originText", "a", "", "nodeList", "Lcom/tencent/android/androidbypass/codeblock/span/a;", "breakTextLine", "b", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class CodeBlockTools {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final CodeBlockTools f72031a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14087);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f72031a = new CodeBlockTools();
        }
    }

    CodeBlockTools() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    private final int c(CharSequence text, int start) {
        int indexOf = TextUtils.indexOf(text, '\n', start, text.length());
        if (indexOf < 0) {
            return text.length();
        }
        return indexOf + 1;
    }

    private final Pair<String, Integer> d(CodeNode codeNode, com.tencent.android.androidbypass.codeblock.config.highlight.a highlightConfig) {
        Pair<String, Integer> pair;
        int type = codeNode.getType();
        if (type != 1) {
            if (type != 2) {
                return new Pair<>("", Integer.valueOf(highlightConfig.d()));
            }
            Text text = codeNode.getText();
            Intrinsics.checkNotNullExpressionValue(text, "codeNode.text");
            pair = new Pair<>(text.getLiteral(), Integer.valueOf(highlightConfig.d()));
        } else {
            Syntax syntax = codeNode.getSyntax();
            Intrinsics.checkNotNullExpressionValue(syntax, "codeNode.syntax");
            String matchedString = syntax.getMatchedString();
            Syntax syntax2 = codeNode.getSyntax();
            Intrinsics.checkNotNullExpressionValue(syntax2, "codeNode.syntax");
            String type2 = syntax2.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "codeNode.syntax.type");
            pair = new Pair<>(matchedString, Integer.valueOf(highlightConfig.e(type2)));
        }
        return pair;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.android.androidbypass.codeblock.utils.CodeBlockTools$handleCombineResult$1] */
    private final void e(d result, final com.tencent.android.androidbypass.codeblock.span.d highlightLine, com.tencent.android.androidbypass.codeblock.span.e highlightNode, final Paint paint, boolean isEnd) {
        ?? r06 = new Function2<String, Integer, Unit>(paint) { // from class: com.tencent.android.androidbypass.codeblock.utils.CodeBlockTools$handleCombineResult$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Paint $paint;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$paint = paint;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) com.tencent.android.androidbypass.codeblock.span.d.this, (Object) paint);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
                invoke(str, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String text, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) text, i3);
                } else {
                    Intrinsics.checkNotNullParameter(text, "text");
                    com.tencent.android.androidbypass.codeblock.span.d.this.a().add(new com.tencent.android.androidbypass.codeblock.span.e(text, i3, this.$paint.measureText(text)));
                }
            }
        };
        if (isEnd) {
            r06.invoke(highlightNode.b(), highlightNode.a());
            if (!result.c()) {
                r06.invoke(result.b(), result.a());
            }
            highlightNode.e("");
            highlightNode.d(0);
            highlightNode.f(0.0f);
            return;
        }
        if (!result.c()) {
            r06.invoke(highlightNode.b(), highlightNode.a());
            highlightNode.e(result.b());
            highlightNode.d(result.a());
            highlightNode.f(0.0f);
        }
    }

    private final void f(CharSequence breakLineText, a buildArgs, b buildResult) {
        int c16 = buildArgs.c();
        int d16 = buildArgs.d();
        int length = breakLineText.length();
        while (length > 0 && buildArgs.c() < buildArgs.e().size()) {
            int b16 = c.b(buildArgs.e().get(buildArgs.c())) - buildArgs.d();
            if (length >= b16) {
                buildArgs.g(buildArgs.c() + 1);
                buildArgs.c();
                buildArgs.h(0);
                length -= b16;
            } else {
                buildArgs.h(buildArgs.d() + length);
                length = 0;
            }
        }
        buildResult.a().put(buildResult.b(), new com.tencent.android.androidbypass.codeblock.span.a(breakLineText, c16, d16, buildArgs.c(), buildArgs.d()));
    }

    private final void g(CharSequence text, a buildArgs, b buildResult) {
        boolean z16;
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            buildResult.e(true);
            return;
        }
        if (buildResult.b() >= buildArgs.a().c()) {
            buildResult.e(false);
            return;
        }
        int breakText = buildArgs.f().breakText(text, 0, text.length(), true, buildArgs.b(), null);
        f(text.subSequence(0, breakText), buildArgs, buildResult);
        buildResult.d(buildResult.b() + 1);
        buildResult.b();
        g(text.subSequence(breakText, text.length()), buildArgs, buildResult);
    }

    private final d h(com.tencent.android.androidbypass.codeblock.span.e highlightNode, Pair<String, Integer> nodeTextAndColorPair, int start, int end) {
        boolean isBlank;
        boolean isBlank2;
        CharSequence subSequence = nodeTextAndColorPair.getFirst().subSequence(start, end);
        isBlank = StringsKt__StringsJVMKt.isBlank(highlightNode.b());
        if (!isBlank) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(subSequence);
            if (!isBlank2 && highlightNode.a() != nodeTextAndColorPair.getSecond().intValue()) {
                return new d(false, subSequence.toString(), nodeTextAndColorPair.getSecond().intValue());
            }
            highlightNode.e(highlightNode.b() + subSequence);
            return new d(true, "", 0);
        }
        highlightNode.e(highlightNode.b() + subSequence);
        highlightNode.d(nodeTextAndColorPair.getSecond().intValue());
        return new d(true, "", 0);
    }

    public final void a(@NotNull CharSequence originText, @NotNull a buildArgs, @NotNull b buildResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, originText, buildArgs, buildResult);
            return;
        }
        Intrinsics.checkNotNullParameter(originText, "originText");
        Intrinsics.checkNotNullParameter(buildArgs, "buildArgs");
        Intrinsics.checkNotNullParameter(buildResult, "buildResult");
        int i3 = 0;
        while (i3 < originText.length()) {
            int c16 = c(originText, i3);
            g(originText.subSequence(i3, c16), buildArgs, buildResult);
            if (buildResult.b() >= buildArgs.a().c()) {
                if (!buildResult.c() || c16 < originText.length()) {
                    z16 = false;
                }
                buildResult.e(z16);
                return;
            }
            i3 = c16;
        }
    }

    @NotNull
    public final com.tencent.android.androidbypass.codeblock.span.d b(@NotNull Paint paint, @NotNull List<CodeNode> nodeList, @NotNull com.tencent.android.androidbypass.codeblock.span.a breakTextLine, @NotNull com.tencent.android.androidbypass.codeblock.config.highlight.a highlightConfig) {
        Object orNull;
        boolean z16;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.android.androidbypass.codeblock.span.d) iPatchRedirector.redirect((short) 2, this, paint, nodeList, breakTextLine, highlightConfig);
        }
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(nodeList, "nodeList");
        Intrinsics.checkNotNullParameter(breakTextLine, "breakTextLine");
        Intrinsics.checkNotNullParameter(highlightConfig, "highlightConfig");
        com.tencent.android.androidbypass.codeblock.span.e eVar = new com.tencent.android.androidbypass.codeblock.span.e("", 0, 0.0f);
        com.tencent.android.androidbypass.codeblock.span.d dVar = new com.tencent.android.androidbypass.codeblock.span.d(breakTextLine.c(), new ArrayList());
        int a16 = breakTextLine.a();
        int b16 = breakTextLine.b();
        int i17 = 0;
        while (i17 < breakTextLine.c().length()) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(nodeList, a16);
            CodeNode codeNode = (CodeNode) orNull;
            if (codeNode == null) {
                break;
            }
            Pair<String, Integer> d16 = d(codeNode, highlightConfig);
            int length = d16.getFirst().length() - b16;
            int length2 = breakTextLine.c().length() - i17;
            if (length2 <= length) {
                z16 = z17;
            } else {
                z16 = z18;
            }
            if (z16) {
                i3 = length2;
            } else {
                i3 = length;
            }
            int i18 = i17;
            int i19 = b16;
            e(h(eVar, d16, b16, i3 + b16), dVar, eVar, paint, z16);
            if (z16) {
                i16 = length2;
            } else {
                i16 = length;
            }
            i17 = i18 + i16;
            if (z16 && length2 < length) {
                b16 = i19 + length2;
            } else {
                a16++;
                b16 = 0;
            }
            z17 = true;
            z18 = false;
        }
        return dVar;
    }
}
