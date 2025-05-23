package com.tencent.opentelemetry.sdk.metrics.internal.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/* loaded from: classes22.dex */
public final class StringPredicates {
    static IPatchRedirector $redirector_;
    public static final Predicate<String> ALL;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22488);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            ALL = new Predicate() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.m
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$static$0;
                    lambda$static$0 = StringPredicates.lambda$static$0((String) obj);
                    return lambda$static$0;
                }
            };
        }
    }

    StringPredicates() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Predicate<String> exact(final String str) {
        return new Predicate() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.o
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean equals;
                equals = str.equals((String) obj);
                return equals;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$regex$2(Pattern pattern, String str) {
        if (str != null && pattern.matcher(str).matches()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(String str) {
        return true;
    }

    public static Predicate<String> regex(String str) {
        return regex(Pattern.compile(str));
    }

    public static Predicate<String> regex(final Pattern pattern) {
        return new Predicate() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.n
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$regex$2;
                lambda$regex$2 = StringPredicates.lambda$regex$2(pattern, (String) obj);
                return lambda$regex$2;
            }
        };
    }
}
