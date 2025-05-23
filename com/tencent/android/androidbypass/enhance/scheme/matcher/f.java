package com.tencent.android.androidbypass.enhance.scheme.matcher;

import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/scheme/matcher/f;", "Lcom/tencent/android/androidbypass/parser/api/a;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class f implements com.tencent.android.androidbypass.parser.api.a {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        if (r7 != true) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
    
        if (android.text.TextUtils.isEmpty(r9) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        if (r7 != true) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        if (r7 == true) goto L20;
     */
    @Override // com.tencent.android.androidbypass.parser.api.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
        boolean equals;
        boolean equals2;
        boolean equals3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, url, parsedResult, clickText)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
        String c16 = parsedResult.c();
        if (c16 != null) {
            equals3 = StringsKt__StringsJVMKt.equals(c16, SchemaUtils.SCHEMA_MQQAPI, true);
        }
        String c17 = parsedResult.c();
        if (c17 != null) {
            equals2 = StringsKt__StringsJVMKt.equals(c17, "mqqguild", true);
        }
        String c18 = parsedResult.c();
        if (c18 != null) {
            equals = StringsKt__StringsJVMKt.equals(c18, "mqqrouter", true);
        }
        return false;
    }
}
