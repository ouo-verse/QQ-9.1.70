package com.tencent.android.androidbypass.enhance.scheme.matcher;

import android.text.TextUtils;
import android.util.Patterns;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/scheme/matcher/c;", "Lcom/tencent/android/androidbypass/parser/api/a;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class c implements com.tencent.android.androidbypass.parser.api.a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    @Override // com.tencent.android.androidbypass.parser.api.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
        String str;
        boolean z16;
        String d16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, this, url, parsedResult, clickText)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
        String c16 = parsedResult.c();
        String str2 = null;
        if (c16 != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            str = c16.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase(locale)");
        } else {
            str = null;
        }
        if (!TextUtils.equals("http", str)) {
            String c17 = parsedResult.c();
            if (c17 != null) {
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
                str2 = c17.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.String).toLowerCase(locale)");
            }
            if (!TextUtils.equals("https", str2)) {
                z16 = false;
                d16 = parsedResult.d();
                if (d16 == null) {
                    z17 = Patterns.WEB_URL.matcher(d16).matches();
                } else {
                    z17 = false;
                }
                if (!z16 && z17) {
                    return true;
                }
                return false;
            }
        }
        z16 = true;
        d16 = parsedResult.d();
        if (d16 == null) {
        }
        if (!z16) {
        }
        return false;
    }
}
