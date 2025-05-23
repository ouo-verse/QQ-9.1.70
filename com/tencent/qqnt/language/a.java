package com.tencent.qqnt.language;

import androidx.annotation.StringRes;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/language/a;", "", "", "resourceId", "Ljava/util/Locale;", "locale", "", "a", "<init>", "()V", "language_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f359318a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41555);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f359318a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ CharSequence b(a aVar, int i3, Locale locale, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return aVar.a(i3, locale);
    }

    @NotNull
    public final CharSequence a(@StringRes int resourceId, @NotNull Locale locale) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, resourceId, (Object) locale);
        }
        Intrinsics.checkNotNullParameter(locale, "locale");
        try {
            String string = BaseApplication.context.getResources().getString(resourceId);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            BaseApplic\u2026ing(resourceId)\n        }");
            return string;
        } catch (Throwable th5) {
            QLog.d("LanguageUtil", 1, th5.getMessage());
            return "";
        }
    }
}
