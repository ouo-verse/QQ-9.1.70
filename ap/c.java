package ap;

import com.qzone.video.TVK_SDK.mediaplayer.http.AsyncHttpRequest;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<AsyncHttpRequest> f26636a;

    public c(AsyncHttpRequest asyncHttpRequest) {
        this.f26636a = new WeakReference<>(asyncHttpRequest);
    }

    public boolean a() {
        AsyncHttpRequest asyncHttpRequest = this.f26636a.get();
        return asyncHttpRequest == null || asyncHttpRequest.isCancelled();
    }

    public boolean b() {
        AsyncHttpRequest asyncHttpRequest = this.f26636a.get();
        return asyncHttpRequest == null || asyncHttpRequest.e();
    }

    public boolean c() {
        boolean z16 = a() || b();
        if (z16) {
            this.f26636a.clear();
        }
        return z16;
    }
}
