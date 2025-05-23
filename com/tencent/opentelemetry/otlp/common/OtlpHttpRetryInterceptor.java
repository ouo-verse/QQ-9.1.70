package com.tencent.opentelemetry.otlp.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OtlpHttpRetryInterceptor implements Interceptor {
    static IPatchRedirector $redirector_;
    private int count;
    public int maxRetryCount;

    public OtlpHttpRetryInterceptor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.count = 0;
            this.maxRetryCount = i3;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Response) iPatchRedirector.redirect((short) 2, (Object) this, (Object) chain);
        }
        return retry(chain);
    }

    public Response retry(Interceptor.Chain chain) {
        Response response;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Response) iPatchRedirector.redirect((short) 3, (Object) this, (Object) chain);
        }
        try {
            response = chain.proceed(chain.request());
            while (!response.isSuccessful() && (i3 = this.count) < this.maxRetryCount) {
                try {
                    this.count = i3 + 1;
                    response = retry(chain);
                } catch (Exception unused) {
                    while (true) {
                        int i16 = this.count;
                        if (i16 >= this.maxRetryCount) {
                            break;
                        }
                        this.count = i16 + 1;
                        response = retry(chain);
                    }
                    return response;
                }
            }
        } catch (Exception unused2) {
            response = null;
        }
        return response;
    }
}
