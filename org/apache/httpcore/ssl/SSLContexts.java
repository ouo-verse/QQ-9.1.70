package org.apache.httpcore.ssl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SSLContexts {
    public static SSLContext createDefault() throws SSLInitializationException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext;
        } catch (KeyManagementException e16) {
            throw new SSLInitializationException(e16.getMessage(), e16);
        } catch (NoSuchAlgorithmException e17) {
            throw new SSLInitializationException(e17.getMessage(), e17);
        }
    }

    public static SSLContext createSystemDefault() throws SSLInitializationException {
        try {
            return SSLContext.getDefault();
        } catch (NoSuchAlgorithmException unused) {
            return createDefault();
        }
    }

    public static SSLContextBuilder custom() {
        return SSLContextBuilder.create();
    }
}
