package com.tencent.weiyun.transmission.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.ErrorCode;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ErrorCodeUtil {
    static IPatchRedirector $redirector_;

    public ErrorCodeUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getErrorCode4IOException(IOException iOException) {
        String message;
        if (iOException == null) {
            message = null;
        } else {
            message = iOException.getMessage();
        }
        if (message != null) {
            message = message.toLowerCase();
        }
        if (iOException instanceof ConnectException) {
            if (message != null && Pattern.compile(".*network.*is.*unreachable.*").matcher(message).matches()) {
                return ErrorCode.TRAN_NO_NETWORK;
            }
            return ErrorCode.TRAN_SOCKET_CONNECT_FAIL;
        }
        if (iOException instanceof MalformedURLException) {
            return ErrorCode.TRAN_SOCKET_MALFORMED_URL;
        }
        if (iOException instanceof SocketTimeoutException) {
            if (message != null && Pattern.compile(".*failed.*to.*connect.*").matcher(message).matches()) {
                return ErrorCode.TRAN_SOCKET_CONNECT_TIMEOUT;
            }
            return 1830002;
        }
        if (iOException instanceof UnknownHostException) {
            return ErrorCode.TRAN_SOCKET_UNKNOWN_HOST;
        }
        if (iOException instanceof ProtocolException) {
            return ErrorCode.TRAN_SOCKET_PROTOCOL;
        }
        if (iOException instanceof PortUnreachableException) {
            return ErrorCode.TRAN_SOCKET_PORT_UNREACHABLE;
        }
        if (iOException instanceof NoRouteToHostException) {
            return ErrorCode.TRAN_SOCKET_NO_ROUT_TO_HOST;
        }
        if (iOException instanceof EOFException) {
            return ErrorCode.TRAN_SOCKET_END_OF_FILE;
        }
        if (iOException instanceof BindException) {
            return ErrorCode.TRAN_SOCKET_BIND_ERROR;
        }
        if (iOException instanceof SocketException) {
            if (message == null) {
                return ErrorCode.TRAN_SOCKET_ERROR;
            }
            if (Pattern.compile(".*no.*route.*to.*").matcher(message).matches()) {
                return ErrorCode.TRAN_SOCKET_NO_ROUT_TO_HOST;
            }
            if (Pattern.compile(".*etimedout.*").matcher(message).matches()) {
                return 1830001;
            }
            if (Pattern.compile(".*socket.*is.*closed.*").matcher(message).matches()) {
                return 1830003;
            }
            if (Pattern.compile(".*connect.*reset.*by.*peer.*").matcher(message).matches()) {
                return ErrorCode.TRAN_SOCKET_RESET_BY_PEER;
            }
            if (Pattern.compile(".*connect.*reset.*").matcher(message).matches()) {
                return 1830004;
            }
            if (Pattern.compile(".*broken.*pipe.*").matcher(message).matches()) {
                return ErrorCode.TRAN_SOCKET_BROKEN_PIPE;
            }
            if (Pattern.compile(".*connection.*refused.*").matcher(message).matches()) {
                return ErrorCode.TRAN_SOCKET_CONN_REFUSED;
            }
            if (Pattern.compile(".*too.*many.*open.*files.*").matcher(message).matches()) {
                return ErrorCode.TRAN_SOCKET_TOO_MANY_OPEN_FILES;
            }
            if (Pattern.compile(".*address.*family.*").matcher(message).matches()) {
                return ErrorCode.TRAN_SOCKET_ADDRESS_FAMILY;
            }
            if (Pattern.compile(".*jvm_bind.*").matcher(message).matches()) {
                return ErrorCode.TRAN_SOCKET_BIND_ERROR;
            }
            return ErrorCode.TRAN_SOCKET_ERROR_OTHERS;
        }
        if (iOException instanceof ClosedByInterruptException) {
            return ErrorCode.TRAN_CHANNEL_CLOSED_BY_INTERRUPT;
        }
        if (iOException instanceof AsynchronousCloseException) {
            return ErrorCode.TRAN_CHANNEL_ASYNCHRONOUS_CLOSE;
        }
        if (iOException instanceof ClosedChannelException) {
            return ErrorCode.TRAN_CHANNEL_CLOSED;
        }
        if (message != null) {
            if (Pattern.compile(".*unexpected.*end.*of.*stream.*").matcher(message).matches()) {
                return ErrorCode.TRAN_SOCKET_UNEXPECTED_END_OF_STREAM;
            }
            if (Pattern.compile(".*no.*space.*left.*on.*device.*").matcher(message).matches() || Pattern.compile(".*no.*space.*available.*").matcher(message).matches()) {
                return ErrorCode.TRAN_DOWNLOAD_SPACE_LACK;
            }
            return ErrorCode.TRAN_SOCKET_ERROR_OTHERS;
        }
        return ErrorCode.TRAN_SOCKET_ERROR_OTHERS;
    }

    public static String getErrorMsg(int i3) {
        return ErrorMessages.getErrorString(i3);
    }

    public static String getWnsErrorMsg(int i3, String str) {
        return null;
    }

    public static boolean isHttpError(int i3) {
        if (i3 > 1829000 && i3 < 1829999) {
            return true;
        }
        return false;
    }

    public static boolean isNeedReLogin(int i3) {
        if (i3 != 190050) {
            return false;
        }
        return true;
    }

    public static boolean isNotLogin(int i3) {
        return false;
    }

    public static boolean isSessionDeprived(int i3) {
        if (i3 != 190050 && i3 != 10025) {
            return false;
        }
        return true;
    }

    public static boolean isSocketError(int i3) {
        if (i3 > 1830000) {
            return true;
        }
        return false;
    }
}
