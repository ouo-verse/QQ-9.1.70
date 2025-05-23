package com.tenpay.sdk.net.utils;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.core.exception.EcdhException;
import com.tenpay.sdk.net.core.request.NetRequest;
import com.tenpay.sdk.net.http.interceptor.PsKeyInterceptor;
import com.tenpay.sdk.net.http.request.HttpRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import org.apache.http.ConnectionClosedException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ&\u0010\r\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u000e\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/sdk/net/utils/ErrorCodeFormat;", "", "()V", "TAG", "", "createErrorJson", "Lorg/json/JSONObject;", Const.BUNDLE_KEY_REQUEST, "Lcom/tenpay/sdk/net/core/request/NetRequest;", "exception", "", "defaultCode", "", "formatErrCode", "formatNetworkErrCode", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ErrorCodeFormat {

    @NotNull
    public static final ErrorCodeFormat INSTANCE = new ErrorCodeFormat();

    @NotNull
    public static final String TAG = "QWalletHttp-ErrorCodeFormat";

    ErrorCodeFormat() {
    }

    public static /* synthetic */ JSONObject createErrorJson$default(ErrorCodeFormat errorCodeFormat, NetRequest netRequest, Throwable th5, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = -1;
        }
        return errorCodeFormat.createErrorJson(netRequest, th5, i3);
    }

    private final int formatNetworkErrCode(Throwable exception, int defaultCode) {
        if (exception == null) {
            return defaultCode;
        }
        if (exception instanceof ClientProtocolException) {
            defaultCode = -1008;
        } else if (exception instanceof SSLPeerUnverifiedException) {
            defaultCode = -1012;
        } else if (exception instanceof NoHttpResponseException) {
            defaultCode = -1011;
        } else if (exception instanceof UnknownHostException) {
            defaultCode = -1009;
        } else if (exception instanceof ConnectionPoolTimeoutException) {
            defaultCode = -1013;
        } else if (exception instanceof ConnectTimeoutException) {
            defaultCode = -1010;
        } else if (exception instanceof IllegalStateException) {
            defaultCode = -1005;
        } else if (exception instanceof SocketException) {
            defaultCode = SocketErrorFormatter.INSTANCE.getSocketExceptionErrorCode(exception, -1006);
        } else if (exception instanceof SocketTimeoutException) {
            defaultCode = -1007;
        } else if (exception instanceof FileNotFoundException) {
            defaultCode = -1001;
        } else if (exception instanceof ConnectionClosedException) {
            defaultCode = -1014;
        } else if (exception instanceof IOException) {
            defaultCode = SocketErrorFormatter.INSTANCE.getSocketExceptionErrorCode(exception, -1002);
        }
        if (defaultCode == -1 && (exception instanceof Exception)) {
            return -1004;
        }
        return defaultCode;
    }

    @NotNull
    public final JSONObject createErrorJson(@Nullable NetRequest<?> request, @Nullable Throwable exception, int defaultCode) {
        int formatErrCode = formatErrCode(request, exception, defaultCode);
        String a16 = p.INSTANCE.a();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retcode", formatErrCode);
            jSONObject.put("retmsg", a16);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "createErrorRspJson error", th5);
        }
        return jSONObject;
    }

    public final int formatErrCode(@Nullable NetRequest<?> request, @Nullable Throwable exception, int defaultCode) {
        if (!NetworkUtil.isNetworkAvailable()) {
            return -999;
        }
        if (exception instanceof OutOfMemoryError) {
            return -2002;
        }
        if ((request instanceof HttpRequest) && PsKeyInterceptor.INSTANCE.isPsKeyEmpty((HttpRequest) request)) {
            return -2003;
        }
        if (exception instanceof EcdhException) {
            return -2004;
        }
        return formatNetworkErrCode(exception, defaultCode);
    }
}
