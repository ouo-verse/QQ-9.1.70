package com.tencent.paysdk.network;

import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.paysdk.vipauth.requestdata.BaseRequestData;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes22.dex */
public class RequestWrapper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f342032a;

    /* renamed from: b, reason: collision with root package name */
    private BaseRequestData f342033b;

    /* renamed from: c, reason: collision with root package name */
    private RequestType f342034c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class RequestType {
        private static final /* synthetic */ RequestType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RequestType GET;
        public static final RequestType POST;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(MessageHandlerConstants.NOTIFY_TYPE_TRIBE_TMP);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            RequestType requestType = new RequestType("GET", 0);
            GET = requestType;
            RequestType requestType2 = new RequestType("POST", 1);
            POST = requestType2;
            $VALUES = new RequestType[]{requestType, requestType2};
        }

        RequestType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static RequestType valueOf(String str) {
            return (RequestType) Enum.valueOf(RequestType.class, str);
        }

        public static RequestType[] values() {
            return (RequestType[]) $VALUES.clone();
        }
    }

    public RequestWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342034c = RequestType.POST;
        }
    }

    public BaseRequestData a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseRequestData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f342033b;
    }

    public RequestType b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RequestType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f342034c;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f342032a;
    }

    public void d(BaseRequestData baseRequestData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseRequestData);
        } else {
            this.f342033b = baseRequestData;
        }
    }

    public void e(RequestType requestType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) requestType);
        } else {
            this.f342034c = requestType;
        }
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f342032a = str;
        }
    }
}
