package ap;

import android.content.Context;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g extends a {
    @Override // ap.a
    protected c r(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, e eVar, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        eVar.d(true);
        j(defaultHttpClient, httpContext, httpUriRequest, str, eVar, context).run();
        return new c(null);
    }

    public g() {
        super(false, 80, WebSocketImpl.DEFAULT_WSS_PORT);
    }
}
