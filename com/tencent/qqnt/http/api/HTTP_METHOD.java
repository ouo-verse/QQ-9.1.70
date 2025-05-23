package com.tencent.qqnt.http.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.apache.http.client.methods.HttpPut;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/http/api/HTTP_METHOD;", "", "(Ljava/lang/String;I)V", "GET", "HEAD", "POST", "DELETE", HttpPut.METHOD_NAME, "PATCH", "http_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class HTTP_METHOD {
    private static final /* synthetic */ HTTP_METHOD[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final HTTP_METHOD DELETE;
    public static final HTTP_METHOD GET;
    public static final HTTP_METHOD HEAD;
    public static final HTTP_METHOD PATCH;
    public static final HTTP_METHOD POST;
    public static final HTTP_METHOD PUT;

    private static final /* synthetic */ HTTP_METHOD[] $values() {
        return new HTTP_METHOD[]{GET, HEAD, POST, DELETE, PUT, PATCH};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42542);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        GET = new HTTP_METHOD("GET", 0);
        HEAD = new HTTP_METHOD("HEAD", 1);
        POST = new HTTP_METHOD("POST", 2);
        DELETE = new HTTP_METHOD("DELETE", 3);
        PUT = new HTTP_METHOD(HttpPut.METHOD_NAME, 4);
        PATCH = new HTTP_METHOD("PATCH", 5);
        $VALUES = $values();
    }

    HTTP_METHOD(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static HTTP_METHOD valueOf(String str) {
        return (HTTP_METHOD) Enum.valueOf(HTTP_METHOD.class, str);
    }

    public static HTTP_METHOD[] values() {
        return (HTTP_METHOD[]) $VALUES.clone();
    }
}
