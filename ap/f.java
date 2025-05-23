package ap;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* compiled from: P */
/* loaded from: classes39.dex */
class f implements HttpRequestRetryHandler {

    /* renamed from: c, reason: collision with root package name */
    private static final HashSet<Class<?>> f26642c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashSet<Class<?>> f26643d;

    /* renamed from: a, reason: collision with root package name */
    private final int f26644a;

    /* renamed from: b, reason: collision with root package name */
    private final int f26645b;

    static {
        HashSet<Class<?>> hashSet = new HashSet<>();
        f26642c = hashSet;
        HashSet<Class<?>> hashSet2 = new HashSet<>();
        f26643d = hashSet2;
        hashSet.add(NoHttpResponseException.class);
        hashSet.add(UnknownHostException.class);
        hashSet.add(SocketException.class);
        hashSet2.add(InterruptedIOException.class);
        hashSet2.add(SSLException.class);
    }

    public f(int i3, int i16) {
        this.f26644a = i3;
        this.f26645b = i16;
    }

    protected boolean a(HashSet<Class<?>> hashSet, Throwable th5) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th5)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0026, code lost:
    
        if (a(ap.f.f26643d, r3) == false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    @Override // org.apache.http.client.HttpRequestRetryHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean retryRequest(IOException iOException, int i3, HttpContext httpContext) {
        boolean z16;
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        if (bool != null) {
            bool.booleanValue();
        }
        if (i3 <= this.f26644a) {
            z16 = true;
            if (!a(f26642c, iOException)) {
            }
            if (!z16 && ((HttpUriRequest) httpContext.getAttribute("http.request")) == null) {
                return false;
            }
            if (!z16) {
                SystemClock.sleep(this.f26645b);
            } else {
                iOException.printStackTrace();
            }
            return z16;
        }
        z16 = false;
        if (!z16) {
        }
        if (!z16) {
        }
        return z16;
    }
}
