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
public abstract class InstrumentationLibraryInfo {
    static IPatchRedirector $redirector_;
    private static final InstrumentationLibraryInfo EMPTY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9771);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EMPTY = create("", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstrumentationLibraryInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static InstrumentationLibraryInfo create(String str, @Nullable String str2) {
        Objects.requireNonNull(str, "name");
        return new AutoValue_InstrumentationLibraryInfo(str, str2, null);
    }

    public static InstrumentationLibraryInfo empty() {
        return EMPTY;
    }

    public abstract String getName();

    @Nullable
    public abstract String getSchemaUrl();

    @Nullable
    public abstract String getVersion();

    public static InstrumentationLibraryInfo create(String str, @Nullable String str2, @Nullable String str3) {
        Objects.requireNonNull(str, "name");
        return new AutoValue_InstrumentationLibraryInfo(str, str2, str3);
    }
}
