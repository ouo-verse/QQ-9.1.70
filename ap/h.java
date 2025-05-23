package ap;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class h extends b {
    public h(String str) {
        z(str);
    }

    public abstract void B(int i3, Header[] headerArr, String str, Throwable th5);

    public abstract void C(int i3, String str, Header[] headerArr, String str2);

    @Override // ap.b
    public void q(int i3, Header[] headerArr, byte[] bArr, Throwable th5) {
        B(i3, headerArr, A(bArr, l()), th5);
    }

    @Override // ap.b
    public void v(int i3, String str, Header[] headerArr, byte[] bArr) {
        C(i3, str, headerArr, A(bArr, l()));
    }

    public static String A(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e16) {
            Log.e("TextHttpResponseHandler", "Encoding response into string failed", e16);
            return null;
        }
    }
}
