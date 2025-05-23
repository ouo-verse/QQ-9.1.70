package com.tencent.opentelemetry.sdk.trace.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.trace.StatusCode;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableStatusData implements StatusData {
    static IPatchRedirector $redirector_;
    static final StatusData ERROR;
    static final StatusData OK;
    static final StatusData UNSET;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.sdk.trace.data.ImmutableStatusData$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$api$trace$StatusCode;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13635);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[StatusCode.values().length];
            $SwitchMap$com$tencent$opentelemetry$api$trace$StatusCode = iArr;
            try {
                iArr[StatusCode.UNSET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$trace$StatusCode[StatusCode.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$trace$StatusCode[StatusCode.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13627);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        OK = createInternal(StatusCode.OK, "");
        UNSET = createInternal(StatusCode.UNSET, "");
        ERROR = createInternal(StatusCode.ERROR, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableStatusData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StatusData create(StatusCode statusCode, String str) {
        if (str == null || str.isEmpty()) {
            int i3 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$api$trace$StatusCode[statusCode.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return d.b();
                    }
                } else {
                    return d.c();
                }
            } else {
                return d.d();
            }
        }
        return createInternal(statusCode, str);
    }

    private static StatusData createInternal(StatusCode statusCode, String str) {
        return new AutoValue_ImmutableStatusData(statusCode, str);
    }
}
