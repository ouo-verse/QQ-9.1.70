package com.tencent.component.network.utils.http.base;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.params.HttpParams;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SniSSLSocketFactory extends SSLSocketFactory {
    public SniSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        setHostnameVerifier(new X509HostnameVerifier() { // from class: com.tencent.component.network.utils.http.base.SniSSLSocketFactory.1
            @Override // org.apache.http.conn.ssl.X509HostnameVerifier
            public void verify(String str, X509Certificate x509Certificate) throws SSLException {
            }

            @Override // org.apache.http.conn.ssl.X509HostnameVerifier
            public void verify(String str, SSLSocket sSLSocket) throws IOException {
            }

            @Override // org.apache.http.conn.ssl.X509HostnameVerifier
            public void verify(String str, String[] strArr, String[] strArr2) throws SSLException {
            }

            @Override // org.apache.http.conn.ssl.X509HostnameVerifier, javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return false;
            }
        });
    }

    public static void ensureSupportSNI(Socket socket, String str) {
        SSLSocket sSLSocket;
        if (socket != null && (socket instanceof SSLSocket)) {
            sSLSocket = (SSLSocket) socket;
        } else {
            sSLSocket = null;
        }
        if (sSLSocket != null) {
            try {
                HostNameSetter.setServerNameIndication(str, sSLSocket);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i3, InetAddress inetAddress, int i16, HttpParams httpParams) throws IOException {
        return super.connectSocket(socket, str, i3, inetAddress, i16, httpParams);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        return super.createSocket();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws UnknownHostException, IOException {
        return super.createSocket(socket, str, i3, z16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class HostNameSetter {
        private static final AtomicReference<HostNameSetter> CURRENT = new AtomicReference<>();
        private final WeakReference<Class<?>> cls;
        private final WeakReference<Method> setter;

        HostNameSetter(Class<?> cls, Method method) {
            WeakReference<Method> weakReference;
            this.cls = new WeakReference<>(cls);
            if (method == null) {
                weakReference = null;
            } else {
                weakReference = new WeakReference<>(method);
            }
            this.setter = weakReference;
        }

        private static Method init(Class<?> cls) {
            Method method;
            try {
                method = cls.getMethod("setHostname", String.class);
            } catch (NoSuchMethodException e16) {
                initFail(e16);
                method = null;
                CURRENT.set(new HostNameSetter(cls, method));
                return method;
            } catch (SecurityException e17) {
                initFail(e17);
                method = null;
                CURRENT.set(new HostNameSetter(cls, method));
                return method;
            }
            CURRENT.set(new HostNameSetter(cls, method));
            return method;
        }

        private Method reuse(Class<?> cls) {
            boolean z16;
            boolean z17;
            boolean z18 = true;
            if (this.cls.get() != cls) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return init(cls);
            }
            WeakReference<Method> weakReference = this.setter;
            if (weakReference == null) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return null;
            }
            Method method = weakReference.get();
            if (method != null) {
                z18 = false;
            }
            if (z18) {
                return init(cls);
            }
            return method;
        }

        public static void setServerNameIndication(String str, SSLSocket sSLSocket) {
            Method reuse;
            Class<?> cls = sSLSocket.getClass();
            HostNameSetter hostNameSetter = CURRENT.get();
            if (hostNameSetter == null) {
                reuse = init(cls);
            } else {
                reuse = hostNameSetter.reuse(cls);
            }
            if (reuse != null) {
                try {
                    reuse.invoke(sSLSocket, str);
                } catch (IllegalAccessException e16) {
                    setServerNameIndicationFail(e16);
                } catch (IllegalArgumentException e17) {
                    setServerNameIndicationFail(e17);
                } catch (InvocationTargetException e18) {
                    setServerNameIndicationFail(e18);
                }
            }
        }

        private static void initFail(Exception exc) {
        }

        private static void setServerNameIndicationFail(Exception exc) {
        }
    }
}
