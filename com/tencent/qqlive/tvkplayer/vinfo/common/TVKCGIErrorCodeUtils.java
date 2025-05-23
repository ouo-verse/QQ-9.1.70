package com.tencent.qqlive.tvkplayer.vinfo.common;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKCGIErrorCodeUtils {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static final class Code {
        public static final int CODE_BATCH_VINFO_PARSE_ERROR = 33;
        public static final int CODE_BODY_OFFLINE_CHANGE_ONLINE = 25;
        public static final int CODE_BODY_OFFLINE_URL_EMPTY_ERROR = 24;
        public static final int CODE_BODY_PARSE_ERROR = 23;
        public static final int CODE_CGI_ERROR = 14;
        public static final int CODE_CGI_PARAMS_ERROR = 30;
        public static final int CODE_CGI_RECEIVE_NOT_XML = 13;
        public static final int CODE_CIRCULAR_REDIRECT = 10;
        public static final int CODE_CLIENT_PROTOCOL = 9;
        public static final int CODE_CONNECTION_ERROR = 3;
        public static final int CODE_CONNECTION_TIMEOUT = 4;
        public static final int CODE_CONTENT_PARSE_ERROR = 15;
        public static final int CODE_FILE_NOTFOUND_ERROR = 8;
        public static final int CODE_GENERAL_IO_ERROR = 6;
        public static final int CODE_HTTP_STATUS_CODE = 12;
        public static final int CODE_ILLEGAL_ARGUMENT = 7;
        public static final int CODE_IPV6_ADDRESS_NOT_FIND_FAILED = 31;
        public static final int CODE_LIVE_NO_PLAYBACK_INFO = 28;
        public static final int CODE_NETWORK_UNREACHABLE = 22;
        public static final int CODE_NO_HTTP_RESPONSE = 11;
        public static final int CODE_REQUEST_TIME_OUT = 5;
        public static final int CODE_SOCKET_EXCEPTION = 21;
        public static final int CODE_SSL_EXCEPTION = 16;
        public static final int CODE_SSL_HANDSHAKE_EXCEPTION = 17;
        public static final int CODE_SSL_KEY_EXCEPTION = 18;
        public static final int CODE_SSL_PEERUNVERIFIED_EXCEPTION = 19;
        public static final int CODE_SSL_PROTOCOL_EXCEPTION = 20;
        public static final int CODE_SUCCESS = 0;
        public static final int CODE_UNKNOWN = 1;
        public static final int CODE_UNKNOWN_HOST = 2;
        public static final int CODE_VINFO_DECRYPT_ERROR = 32;
    }

    private static int getErrCodeByConnectionException(@NonNull ConnectException connectException) {
        if (connectException.toString().contains("Network is unreachable")) {
            return 22;
        }
        return 3;
    }

    private static int getErrCodeByIOException(@NonNull IOException iOException) {
        if (iOException instanceof SocketTimeoutException) {
            return 5;
        }
        if (iOException instanceof UnknownHostException) {
            return 2;
        }
        if (iOException instanceof FileNotFoundException) {
            return 8;
        }
        if (iOException instanceof ConnectException) {
            return getErrCodeByConnectionException((ConnectException) iOException);
        }
        if (iOException instanceof SSLException) {
            return getErrCodeBySSLxception((SSLException) iOException);
        }
        if (iOException instanceof SocketException) {
            return 21;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return 15;
        }
        return 6;
    }

    private static int getErrCodeBySSLxception(@NonNull SSLException sSLException) {
        if (sSLException instanceof SSLHandshakeException) {
            return 17;
        }
        if (sSLException instanceof SSLKeyException) {
            return 18;
        }
        if (sSLException instanceof SSLPeerUnverifiedException) {
            return 19;
        }
        if (sSLException instanceof SSLProtocolException) {
            return 20;
        }
        return 16;
    }

    public static int getErrCodeByThrowable(Throwable th5) {
        if (th5 == null) {
            return 1;
        }
        if (th5 instanceof ITVKHttpProcessor.InvalidResponseCodeException) {
            return ((ITVKHttpProcessor.InvalidResponseCodeException) th5).responseCode;
        }
        if (th5 instanceof IOException) {
            return getErrCodeByIOException((IOException) th5);
        }
        if (!(th5 instanceof XmlPullParserException)) {
            return 1;
        }
        return 15;
    }
}
