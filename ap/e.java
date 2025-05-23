package ap;

import java.io.IOException;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface e {
    void a(int i3);

    void b(int i3, String str, Header[] headerArr, byte[] bArr);

    void c(URI uri);

    void d(boolean z16);

    boolean e();

    void f(HttpResponse httpResponse) throws IOException;

    void g();

    void h(Header[] headerArr);

    void i();

    void j(int i3, Header[] headerArr, byte[] bArr, Throwable th5);

    void k();
}
