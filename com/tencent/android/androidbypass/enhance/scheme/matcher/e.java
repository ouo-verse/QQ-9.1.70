package com.tencent.android.androidbypass.enhance.scheme.matcher;

import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/scheme/matcher/e;", "Lcom/tencent/android/androidbypass/parser/api/a;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class e implements com.tencent.android.androidbypass.parser.api.a {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.android.androidbypass.parser.api.a
    public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
        boolean equals;
        String d16;
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, url, parsedResult, clickText)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
        String c16 = parsedResult.c();
        if (c16 != null) {
            equals = StringsKt__StringsJVMKt.equals(c16, SchemaUtils.SCHEMA_MQQAPI, true);
            if (equals && (d16 = parsedResult.d()) != null && d16.equals("markdown") && (b16 = parsedResult.b()) != null && b16.equals("/template")) {
                return true;
            }
        }
        return false;
    }
}
