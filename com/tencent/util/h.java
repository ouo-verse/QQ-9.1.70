package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0005\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J5\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u000eH\u0002J\u001c\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/util/h;", "", "", "input", "keyword", "c", "", "keywordStart", "result", "", "a", "valueStart", "Lcom/tencent/util/Pair;", "g", "", "quoteChar", "f", "(ILjava/lang/String;Ljava/lang/Character;)Lcom/tencent/util/Pair;", "keywordEnd", "d", "e", "", "keywords", "b", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f383982a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39167);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f383982a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a(int keywordStart, String keyword, String result) {
        boolean z16;
        boolean z17;
        int length = keyword.length() + keywordStart;
        if (keywordStart != 0 && e(result.charAt(keywordStart - 1))) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (length < result.length() && e(result.charAt(length))) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }

    private final String c(String input, String keyword) {
        int indexOf$default;
        boolean z16;
        Pair<Integer, String> g16;
        int i3 = 0;
        do {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) input, keyword, i3, false, 4, (Object) null);
            z16 = true;
            if (indexOf$default >= 0) {
                h hVar = f383982a;
                String str = input;
                if (!hVar.a(indexOf$default, keyword, str)) {
                    i3 = indexOf$default + keyword.length();
                } else {
                    int length = indexOf$default + keyword.length();
                    if (length < str.length() && (str.charAt(length) == '\"' || str.charAt(length) == '\'')) {
                        length++;
                    }
                    int d16 = hVar.d(length, str);
                    if (d16 < str.length()) {
                        if (str.charAt(d16) != '\"' && str.charAt(d16) != '\'') {
                            z16 = false;
                        }
                        if (z16) {
                            g16 = hVar.f(d16 + 1, str, Character.valueOf(str.charAt(d16)));
                        } else {
                            g16 = hVar.g(d16, str);
                        }
                        Integer num = g16.first;
                        Intrinsics.checkNotNullExpressionValue(num, "pair.first");
                        i3 = num.intValue();
                        input = g16.second;
                        Intrinsics.checkNotNullExpressionValue(input, "pair.second");
                    }
                }
                z16 = false;
            }
        } while (!z16);
        return input;
    }

    private final int d(int keywordEnd, String result) {
        char charAt;
        while (keywordEnd < result.length() && ((charAt = result.charAt(keywordEnd)) == ' ' || charAt == ':' || charAt == '=')) {
            keywordEnd++;
        }
        return keywordEnd;
    }

    private final boolean e(char c16) {
        if (!Character.isLetterOrDigit(c16) && c16 != '_' && c16 != '-') {
            return false;
        }
        return true;
    }

    private final Pair<Integer, String> f(int valueStart, String input, Character quoteChar) {
        int i3 = valueStart;
        boolean z16 = false;
        while (i3 < input.length()) {
            char charAt = input.charAt(i3);
            if (z16) {
                z16 = false;
            } else if (charAt == '\\') {
                z16 = true;
            } else if (quoteChar != null && charAt == quoteChar.charValue()) {
                break;
            }
            i3++;
        }
        if (i3 < input.length()) {
            String substring = input.substring(valueStart, i3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String d16 = k.d(substring);
            StringBuilder sb5 = new StringBuilder();
            String substring2 = input.substring(0, valueStart);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            sb5.append(substring2);
            sb5.append(d16);
            String substring3 = input.substring(i3);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
            sb5.append(substring3);
            input = sb5.toString();
            i3 = valueStart + d16.length() + 1;
        }
        return new Pair<>(Integer.valueOf(i3), input);
    }

    private final Pair<Integer, String> g(int valueStart, String input) {
        char charAt;
        int i3 = valueStart;
        while (i3 < input.length() && (charAt = input.charAt(i3)) != ' ' && charAt != ',' && charAt != ';' && charAt != '}') {
            i3++;
        }
        String substring = input.substring(valueStart, i3);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String d16 = k.d(substring);
        StringBuilder sb5 = new StringBuilder();
        String substring2 = input.substring(0, valueStart);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        sb5.append(substring2);
        sb5.append(d16);
        String substring3 = input.substring(i3);
        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
        sb5.append(substring3);
        return new Pair<>(Integer.valueOf(valueStart + d16.length()), sb5.toString());
    }

    @NotNull
    public final String b(@NotNull String input, @NotNull Iterable<String> keywords) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) input, (Object) keywords);
        }
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Iterator<String> it = keywords.iterator();
        while (it.hasNext()) {
            input = c(input, it.next());
        }
        return input;
    }
}
