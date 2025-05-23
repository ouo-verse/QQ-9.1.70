package com.tencent.opentelemetry.sdk.common;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class InstrumentationScopeInfo {
    static IPatchRedirector $redirector_;
    private static final InstrumentationScopeInfo EMPTY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9757);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EMPTY = create("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstrumentationScopeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static InstrumentationScopeInfo create(String str) {
        Objects.requireNonNull(str, "name");
        return new AutoValue_InstrumentationScopeInfo(str, null, null);
    }

    public static InstrumentationScopeInfo empty() {
        return EMPTY;
    }

    public abstract String getName();

    @Nullable
    public abstract String getSchemaUrl();

    @Nullable
    public abstract String getVersion();

    public static InstrumentationScopeInfo create(String str, @Nullable String str2, @Nullable String str3) {
        Objects.requireNonNull(str, "name");
        return new AutoValue_InstrumentationScopeInfo(str, str2, str3);
    }
}
