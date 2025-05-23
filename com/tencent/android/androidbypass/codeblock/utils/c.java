package com.tencent.android.androidbypass.codeblock.utils;

import com.tencent.bypass.nativeinterface.CodeNode;
import com.tencent.bypass.nativeinterface.Syntax;
import com.tencent.bypass.nativeinterface.Text;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001ae\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001`\u0002*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001`\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\n\u0010\n\u001a\u00020\t*\u00020\b\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\b\u00a8\u0006\f"}, d2 = {"Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "color", "", "names", "a", "(Ljava/util/HashMap;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/HashMap;", "Lcom/tencent/bypass/nativeinterface/CodeNode;", "", "b", "c", "bypass_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class c {
    @NotNull
    public static final HashMap<String, String> a(@NotNull HashMap<String, String> addColor, @NotNull String color, @NotNull String... names) {
        Intrinsics.checkNotNullParameter(addColor, "$this$addColor");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(names, "names");
        for (String str : names) {
            addColor.put(str, color);
        }
        return addColor;
    }

    public static final int b(@NotNull CodeNode length) {
        Intrinsics.checkNotNullParameter(length, "$this$length");
        int type = length.getType();
        if (type != 1) {
            if (type != 2) {
                return 0;
            }
            Text text = length.getText();
            Intrinsics.checkNotNullExpressionValue(text, "text");
            return text.getLiteral().length();
        }
        Syntax syntax = length.getSyntax();
        Intrinsics.checkNotNullExpressionValue(syntax, "syntax");
        return syntax.getMatchedString().length();
    }

    @NotNull
    public static final String c(@NotNull CodeNode plainText) {
        Intrinsics.checkNotNullParameter(plainText, "$this$plainText");
        int type = plainText.getType();
        if (type != 1) {
            if (type != 2) {
                return "";
            }
            Text text = plainText.getText();
            Intrinsics.checkNotNullExpressionValue(text, "text");
            String literal = text.getLiteral();
            Intrinsics.checkNotNullExpressionValue(literal, "text.literal");
            return literal;
        }
        Syntax syntax = plainText.getSyntax();
        Intrinsics.checkNotNullExpressionValue(syntax, "syntax");
        String matchedString = syntax.getMatchedString();
        Intrinsics.checkNotNullExpressionValue(matchedString, "syntax.matchedString");
        return matchedString;
    }
}
