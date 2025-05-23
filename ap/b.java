package ap;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class b implements e {

    /* renamed from: b, reason: collision with root package name */
    private Handler f26631b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f26632c;

    /* renamed from: a, reason: collision with root package name */
    private String f26630a = "UTF-8";

    /* renamed from: d, reason: collision with root package name */
    private URI f26633d = null;

    /* renamed from: e, reason: collision with root package name */
    private Header[] f26634e = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final b f26635a;

        a(b bVar) {
            this.f26635a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f26635a.n(message);
        }
    }

    public b() {
        d(false);
    }

    @Override // ap.e
    public void c(URI uri) {
        this.f26633d = uri;
    }

    @Override // ap.e
    public boolean e() {
        return this.f26632c;
    }

    @Override // ap.e
    public void f(HttpResponse httpResponse) throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        StatusLine statusLine = httpResponse.getStatusLine();
        byte[] m3 = m(httpResponse.getEntity());
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (statusLine.getStatusCode() >= 300) {
            j(statusLine.getStatusCode(), httpResponse.getAllHeaders(), m3, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
        } else {
            y(statusLine.getStatusCode(), httpResponse.getAllHeaders(), m3);
        }
    }

    @Override // ap.e
    public void h(Header[] headerArr) {
        this.f26634e = headerArr;
    }

    public String l() {
        String str = this.f26630a;
        return str == null ? "UTF-8" : str;
    }

    protected void n(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                if (objArr != null && objArr.length == 3) {
                    v(((Integer) objArr[0]).intValue(), null, (Header[]) objArr[1], (byte[]) objArr[2]);
                    return;
                } else if (objArr != null && objArr.length >= 4) {
                    v(((Integer) objArr[0]).intValue(), (String) objArr[1], (Header[]) objArr[2], (byte[]) objArr[3]);
                    return;
                } else {
                    Log.e("AsyncHttpResponseHandler", "SUCCESS_MESSAGE didn't got enough params");
                    return;
                }
            case 1:
                Object[] objArr2 = (Object[]) message.obj;
                if (objArr2 != null && objArr2.length >= 4) {
                    q(((Integer) objArr2[0]).intValue(), (Header[]) objArr2[1], (byte[]) objArr2[2], (Throwable) objArr2[3]);
                    return;
                } else {
                    Log.e("AsyncHttpResponseHandler", "FAILURE_MESSAGE didn't got enough params");
                    return;
                }
            case 2:
                u();
                return;
            case 3:
                r();
                return;
            case 4:
                Object[] objArr3 = (Object[]) message.obj;
                if (objArr3 != null && objArr3.length >= 2) {
                    try {
                        s(((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue());
                        return;
                    } catch (Throwable th5) {
                        Log.e("AsyncHttpResponseHandler", "custom onProgress contains an error", th5);
                        return;
                    }
                }
                Log.e("AsyncHttpResponseHandler", "PROGRESS_MESSAGE didn't got enough params");
                return;
            case 5:
                Object[] objArr4 = (Object[]) message.obj;
                if (objArr4 != null && objArr4.length == 1) {
                    t(((Integer) objArr4[0]).intValue());
                    return;
                } else {
                    Log.e("AsyncHttpResponseHandler", "RETRY_MESSAGE didn't get enough params");
                    return;
                }
            case 6:
                p();
                return;
            default:
                return;
        }
    }

    protected Message o(int i3, Object obj) {
        Handler handler = this.f26631b;
        if (handler == null) {
            Message obtain = Message.obtain();
            if (obtain == null) {
                return obtain;
            }
            obtain.what = i3;
            obtain.obj = obj;
            return obtain;
        }
        return Message.obtain(handler, i3, obj);
    }

    public void p() {
        Log.d("AsyncHttpResponseHandler", "Request got cancelled");
    }

    public abstract void q(int i3, Header[] headerArr, byte[] bArr, Throwable th5);

    public abstract void v(int i3, String str, Header[] headerArr, byte[] bArr);

    protected void w(Message message) {
        if (!e() && this.f26631b != null) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            this.f26631b.sendMessage(message);
            return;
        }
        n(message);
    }

    public void z(String str) {
        this.f26630a = str;
    }

    @Override // ap.e
    public final void a(int i3) {
        w(o(5, new Object[]{Integer.valueOf(i3)}));
    }

    @Override // ap.e
    public final void b(int i3, String str, Header[] headerArr, byte[] bArr) {
        w(o(0, new Object[]{Integer.valueOf(i3), str, headerArr, bArr}));
    }

    @Override // ap.e
    public final void j(int i3, Header[] headerArr, byte[] bArr, Throwable th5) {
        w(o(1, new Object[]{Integer.valueOf(i3), headerArr, bArr, th5}));
    }

    public void s(int i3, int i16) {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Integer.valueOf(i16);
        objArr[2] = Double.valueOf(i16 > 0 ? ((i3 * 1.0d) / i16) * 100.0d : -1.0d);
        Log.v("AsyncHttpResponseHandler", String.format("Progress %d from %d (%2.0f%%)", objArr));
    }

    public void t(int i3) {
        Log.d("AsyncHttpResponseHandler", String.format("Request retry no. %d", Integer.valueOf(i3)));
    }

    public final void x(int i3, int i16) {
        w(o(4, new Object[]{Integer.valueOf(i3), Integer.valueOf(i16)}));
    }

    public final void y(int i3, Header[] headerArr, byte[] bArr) {
        w(o(0, new Object[]{Integer.valueOf(i3), headerArr, bArr}));
    }

    @Override // ap.e
    public void d(boolean z16) {
        if (!z16 && Looper.myLooper() == null) {
            Log.w("AsyncHttpResponseHandler", "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
            z16 = true;
        }
        if (!z16 && this.f26631b == null) {
            this.f26631b = new a(this);
        } else if (z16 && this.f26631b != null) {
            this.f26631b = null;
        }
        this.f26632c = z16;
    }

    @Override // ap.e
    public final void g() {
        w(o(3, null));
    }

    @Override // ap.e
    public final void i() {
        w(o(6, null));
    }

    @Override // ap.e
    public final void k() {
        w(o(2, null));
    }

    byte[] m(HttpEntity httpEntity) throws IOException {
        InputStream content;
        if (httpEntity == null || (content = httpEntity.getContent()) == null) {
            return null;
        }
        long contentLength = httpEntity.getContentLength();
        if (contentLength <= TTL.MAX_VALUE) {
            try {
                ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(contentLength <= 0 ? 4096 : (int) contentLength);
                try {
                    byte[] bArr = new byte[4096];
                    int i3 = 0;
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        i3 += read;
                        byteArrayBuffer.append(bArr, 0, read);
                        x(i3, (int) (contentLength <= 0 ? 1L : contentLength));
                    }
                    ap.a.t(content);
                    ap.a.c(httpEntity);
                    return byteArrayBuffer.toByteArray();
                } catch (Throwable th5) {
                    ap.a.t(content);
                    ap.a.c(httpEntity);
                    throw th5;
                }
            } catch (OutOfMemoryError unused) {
                System.gc();
                throw new IOException("File too large to fit into available memory");
            }
        }
        throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
    }

    public void r() {
    }

    public void u() {
    }
}
