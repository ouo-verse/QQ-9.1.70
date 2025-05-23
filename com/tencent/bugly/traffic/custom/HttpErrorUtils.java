package com.tencent.bugly.traffic.custom;

import com.tencent.rmonitor.common.logger.Logger;
import java.net.SocketException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HttpErrorUtils {
    public static final int AUTHENTICATION_EXCEPTION = 907;
    public static final int CLIENT_PROTOCOL_EXCEPTION = 904;
    public static final int CONNECTION_RESET_EXCEPTION = 911;
    public static final int CONNECT_EXCEPTION = 902;
    public static final int MALFORMED_URL_EXCEPTION = 900;
    public static final int NO_FILE_OR_DIRECTORY = 917;
    public static final int SOCKET_TIMEOUT_EXCEPTION = 903;
    public static final int SSL_EXCEPTION = 908;
    private static final String TAG = "HttpErrorUtils";
    public static final int UNKNOWN_HOST_EXCEPTION = 901;
    private static volatile HttpErrorUtils httpErrorUtils;

    HttpErrorUtils() {
    }

    public static HttpErrorUtils getInstance() {
        if (httpErrorUtils == null) {
            synchronized (HttpErrorUtils.class) {
                if (httpErrorUtils == null) {
                    httpErrorUtils = new HttpErrorUtils();
                }
            }
        }
        return httpErrorUtils;
    }

    public boolean isSocketECONNRESET(Exception exc) {
        if (exc == null) {
            return false;
        }
        try {
            if (!(exc instanceof SocketException)) {
                return false;
            }
            if (!exc.getMessage().contains("recvfrom failed: ECONNRESET (Connection reset by peer)")) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            Logger.f365497g.b(TAG, "isSocketECONNRESET error", e16);
            return false;
        }
    }
}
