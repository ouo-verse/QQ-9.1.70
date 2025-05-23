package com.tencent.component.network.utils.http.pool;

import com.tencent.component.network.module.base.QDLog;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.HttpHost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QzoneClientConnectionOperator extends DefaultClientConnectionOperator {
    private static final PlainSocketFactory staticPlainSocketFactory = new PlainSocketFactory();
    private final CustomDnsResolve customDnsResolve;

    public QzoneClientConnectionOperator(SchemeRegistry schemeRegistry, CustomDnsResolve customDnsResolve) {
        super(schemeRegistry);
        this.customDnsResolve = customDnsResolve;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0189 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0173 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1, types: [org.apache.http.conn.scheme.LayeredSocketFactory] */
    /* JADX WARN: Type inference failed for: r5v13, types: [org.apache.http.conn.scheme.SocketFactory] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [int] */
    /* JADX WARN: Type inference failed for: r7v4, types: [int] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // org.apache.http.impl.conn.DefaultClientConnectionOperator, org.apache.http.conn.ClientConnectionOperator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void openConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, InetAddress inetAddress, HttpContext httpContext, HttpParams httpParams) throws IOException {
        Object obj;
        SocketFactory socketFactory;
        InetAddress[] inetAddressArr;
        ?? r75;
        Object obj2;
        ?? r85;
        SocketFactory socketFactory2;
        int i3;
        InetAddress[] inetAddressArr2;
        if (operatedClientConnection != null) {
            if (httpHost != null) {
                if (httpParams != null) {
                    if (!operatedClientConnection.isOpen()) {
                        Scheme scheme = this.schemeRegistry.getScheme(httpHost.getSchemeName());
                        if (!"https".equalsIgnoreCase(httpHost.getSchemeName())) {
                            super.openConnection(operatedClientConnection, httpHost, inetAddress, httpContext, httpParams);
                            return;
                        }
                        SocketFactory socketFactory3 = scheme.getSocketFactory();
                        InetAddress[] inetAddressArr3 = null;
                        if (socketFactory3 instanceof LayeredSocketFactory) {
                            socketFactory = staticPlainSocketFactory;
                            obj = (LayeredSocketFactory) socketFactory3;
                        } else {
                            obj = null;
                            socketFactory = socketFactory3;
                        }
                        CustomDnsResolve customDnsResolve = this.customDnsResolve;
                        if (customDnsResolve != null) {
                            inetAddressArr3 = customDnsResolve.getAllByName(httpHost.getHostName());
                        }
                        if (inetAddressArr3 != null) {
                            String str = "";
                            for (InetAddress inetAddress2 : inetAddressArr3) {
                                str = str + inetAddress2.getHostAddress() + ";";
                            }
                            QDLog.i(QDLog.TAG_DOWNLOAD, "to download QzoneClientConnectionOperator resolve:" + str);
                        }
                        if (inetAddressArr3 == null || inetAddressArr3.length <= 0) {
                            try {
                                inetAddressArr3 = InetAddress.getAllByName(httpHost.getHostName());
                            } catch (Throwable th5) {
                                if (this.customDnsResolve != null) {
                                    QDLog.e(QDLog.TAG_DOWNLOAD, "dns resolve failed! try switch to custom dns", th5);
                                    InetAddress[] resolveByDns = this.customDnsResolve.resolveByDns(httpHost.getHostName());
                                    if (resolveByDns != null && resolveByDns.length > 0) {
                                        QDLog.e(QDLog.TAG_DOWNLOAD, "custom dns resolve success.");
                                        inetAddressArr = resolveByDns;
                                    } else {
                                        QDLog.e(QDLog.TAG_DOWNLOAD, "dns resolve failed! try switch to custom dns", th5);
                                        throw th5;
                                    }
                                } else {
                                    throw th5;
                                }
                            }
                        }
                        inetAddressArr = inetAddressArr3;
                        int i16 = 0;
                        while (i16 < inetAddressArr.length) {
                            Socket createSocket = socketFactory.createSocket();
                            operatedClientConnection.opening(createSocket, httpHost);
                            try {
                                r75 = inetAddressArr[i16].getHostAddress();
                                ?? r56 = socketFactory;
                                r85 = scheme.resolvePort(httpHost.getPort());
                                socketFactory2 = socketFactory;
                                i3 = i16;
                                SocketFactory socketFactory4 = socketFactory3;
                                inetAddressArr2 = inetAddressArr;
                                ?? r16 = obj;
                                try {
                                    Socket connectSocket = r56.connectSocket(createSocket, r75, r85 == true ? 1 : 0, inetAddress, 0, httpParams);
                                    if (createSocket != connectSocket) {
                                        operatedClientConnection.opening(connectSocket, httpHost);
                                        createSocket = connectSocket;
                                    }
                                    obj2 = inetAddressArr2[i3].getHostAddress();
                                    httpContext.setAttribute("RealRemoteAddr", obj2);
                                    try {
                                        if (r16 != 0) {
                                            r75 = 1;
                                            r75 = 1;
                                            r75 = 1;
                                            r75 = 1;
                                            r75 = 1;
                                            try {
                                                Socket createSocket2 = r16.createSocket(createSocket, httpHost.getHostName(), scheme.resolvePort(httpHost.getPort()), true);
                                                if (createSocket2 != createSocket) {
                                                    operatedClientConnection.opening(createSocket2, httpHost);
                                                }
                                                obj2 = r16;
                                                try {
                                                    prepareSocket(createSocket2, httpContext, httpParams);
                                                    SocketFactory socketFactory5 = socketFactory4;
                                                    operatedClientConnection.openCompleted(socketFactory5.isSecure(createSocket2), httpParams);
                                                    r85 = socketFactory5;
                                                } catch (ConnectException e16) {
                                                    e = e16;
                                                    r85 = socketFactory4;
                                                    if (i3 == inetAddressArr2.length - r75) {
                                                    }
                                                } catch (ConnectTimeoutException e17) {
                                                    e = e17;
                                                    r85 = socketFactory4;
                                                    if (i3 != inetAddressArr2.length - r75) {
                                                    }
                                                }
                                            } catch (ConnectException e18) {
                                                e = e18;
                                                obj2 = r16;
                                                r85 = socketFactory4;
                                                if (i3 == inetAddressArr2.length - r75) {
                                                    i16 = i3 + 1;
                                                    obj = obj2;
                                                    inetAddressArr = inetAddressArr2;
                                                    socketFactory = socketFactory2;
                                                    socketFactory3 = r85;
                                                } else {
                                                    throw new HttpHostConnectException(httpHost, e);
                                                }
                                            } catch (ConnectTimeoutException e19) {
                                                e = e19;
                                                obj2 = r16;
                                                r85 = socketFactory4;
                                                if (i3 != inetAddressArr2.length - r75) {
                                                    throw e;
                                                }
                                                i16 = i3 + 1;
                                                obj = obj2;
                                                inetAddressArr = inetAddressArr2;
                                                socketFactory = socketFactory2;
                                                socketFactory3 = r85;
                                            }
                                        } else {
                                            obj2 = r16;
                                            SocketFactory socketFactory6 = socketFactory4;
                                            r75 = 1;
                                            prepareSocket(createSocket, httpContext, httpParams);
                                            operatedClientConnection.openCompleted(socketFactory6.isSecure(createSocket), httpParams);
                                            r85 = socketFactory6;
                                        }
                                        return;
                                    } catch (ConnectException e26) {
                                        e = e26;
                                    } catch (ConnectTimeoutException e27) {
                                        e = e27;
                                    }
                                } catch (ConnectException e28) {
                                    e = e28;
                                    obj2 = r16;
                                    r85 = socketFactory4;
                                    r75 = 1;
                                } catch (ConnectTimeoutException e29) {
                                    e = e29;
                                    obj2 = r16;
                                    r85 = socketFactory4;
                                    r75 = 1;
                                }
                            } catch (ConnectException e36) {
                                e = e36;
                                r75 = 1;
                                obj2 = obj;
                                r85 = socketFactory3;
                                socketFactory2 = socketFactory;
                                i3 = i16;
                                inetAddressArr2 = inetAddressArr;
                            } catch (ConnectTimeoutException e37) {
                                e = e37;
                                r75 = 1;
                                obj2 = obj;
                                r85 = socketFactory3;
                                socketFactory2 = socketFactory;
                                i3 = i16;
                                inetAddressArr2 = inetAddressArr;
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Connection must not be open.");
                }
                throw new IllegalArgumentException("Parameters must not be null.");
            }
            throw new IllegalArgumentException("Target host must not be null.");
        }
        throw new IllegalArgumentException("Connection must not be null.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.conn.DefaultClientConnectionOperator
    public void prepareSocket(Socket socket, HttpContext httpContext, HttpParams httpParams) throws IOException {
        super.prepareSocket(socket, httpContext, httpParams);
    }

    @Override // org.apache.http.impl.conn.DefaultClientConnectionOperator, org.apache.http.conn.ClientConnectionOperator
    public void updateSecureConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, HttpContext httpContext, HttpParams httpParams) throws IOException {
        super.updateSecureConnection(operatedClientConnection, httpHost, httpContext, httpParams);
    }
}
