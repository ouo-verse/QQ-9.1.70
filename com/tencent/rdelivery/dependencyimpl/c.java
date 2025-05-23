package com.tencent.rdelivery.dependencyimpl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.raft.standard.net.IRNetwork;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 #2\u00020\u0001:\u0001\u0005B%\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0003J\b\u0010\r\u001a\u00020\u0004H\u0017JT\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0017R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001dR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/rdelivery/dependencyimpl/c;", "Lcom/tencent/raft/standard/net/IRNetwork;", "", DKEngine.GlobalKey.NET_WORK_TYPE, "Lcom/tencent/raft/standard/net/IRNetwork$NetworkStatus;", "a", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "Lcom/tencent/raft/standard/net/IRNetwork$INetworkResult;", "resultListener", "", "b", "getNetworkStatus", "Lcom/tencent/raft/standard/net/IRNetwork$HttpMethod;", "method", "", "urlString", "", "headers", "parameters", "", "payload", "requestWithMethod", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "I", "connectTimeout", "c", "readTimeout", "<init>", "(Landroid/content/Context;II)V", "d", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c implements IRNetwork {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int connectTimeout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int readTimeout;

    @JvmOverloads
    public c(@NotNull Context context) {
        this(context, 0, 0, 6, null);
    }

    private final IRNetwork.NetworkStatus a(int networkType) {
        if (networkType != 20) {
            switch (networkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return IRNetwork.NetworkStatus.MOBILE_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return IRNetwork.NetworkStatus.MOBILE_3G;
                case 13:
                    return IRNetwork.NetworkStatus.MOBILE_4G;
                default:
                    return IRNetwork.NetworkStatus.MOBILE_UNKNOWN;
            }
        }
        return IRNetwork.NetworkStatus.MOBILE_5G;
    }

    @SuppressLint({"LongLogTag"})
    private final void b(Exception e16, IRNetwork.INetworkResult resultListener) {
        IRNetwork.ResultInfo resultInfo = new IRNetwork.ResultInfo();
        resultInfo.setErrorType(IRNetwork.ResultInfo.ErrorType.OTHER_ERROR);
        resultInfo.setErrorMessage(e16.getClass().getSimpleName());
        Log.e("RDelivery_HttpsURLConnectionNetwork", "handleException " + resultInfo.getErrorMessage() + TokenParser.SP + e16.getMessage());
        if (resultListener != null) {
            resultListener.onFail(resultInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.raft.standard.net.IRNetwork
    @SuppressLint({"LongLogTag"})
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IRNetwork.NetworkStatus getNetworkStatus() {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        NetworkInfo networkInfo2;
        Object systemService;
        TelephonyManager telephonyManager;
        int i3;
        NetworkInfo.State state;
        Object obj = null;
        try {
            Object systemService2 = this.context.getSystemService("connectivity");
            if (!(systemService2 instanceof ConnectivityManager)) {
                systemService2 = null;
            }
            connectivityManager = (ConnectivityManager) systemService2;
            try {
            } catch (Exception e16) {
                e = e16;
                Log.e("RDelivery_HttpsURLConnectionNetwork", "getNetworkStatus exception", e);
                networkInfo = null;
                if (networkInfo == null) {
                }
                return IRNetwork.NetworkStatus.NO_NETWORK;
            }
        } catch (Exception e17) {
            e = e17;
            connectivityManager = null;
        }
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo == null && networkInfo.isAvailable()) {
                if (connectivityManager != null) {
                    try {
                        networkInfo2 = connectivityManager.getNetworkInfo(1);
                    } catch (Exception e18) {
                        Log.e("RDelivery_HttpsURLConnectionNetwork", "getNetworkStatus exception2", e18);
                    }
                    if (networkInfo2 == null && (state = networkInfo2.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                        return IRNetwork.NetworkStatus.WIFI;
                    }
                    systemService = this.context.getSystemService("phone");
                    if (systemService instanceof TelephonyManager) {
                        obj = systemService;
                    }
                    telephonyManager = (TelephonyManager) obj;
                    if (telephonyManager == null) {
                        try {
                            i3 = NetworkMonitor.getNetworkType(telephonyManager);
                        } catch (Exception e19) {
                            Log.e("RDelivery_HttpsURLConnectionNetwork", "getNetworkStatus exception", e19);
                            i3 = -1;
                        }
                        return a(i3);
                    }
                    return IRNetwork.NetworkStatus.MOBILE_UNKNOWN;
                }
                networkInfo2 = null;
                if (networkInfo2 == null) {
                }
                systemService = this.context.getSystemService("phone");
                if (systemService instanceof TelephonyManager) {
                }
                telephonyManager = (TelephonyManager) obj;
                if (telephonyManager == null) {
                }
            } else {
                return IRNetwork.NetworkStatus.NO_NETWORK;
            }
        } else {
            return IRNetwork.NetworkStatus.NO_NETWORK;
        }
    }

    @Override // com.tencent.raft.standard.net.IRNetwork
    @SuppressLint({"LongLogTag"})
    public void requestWithMethod(@NotNull IRNetwork.HttpMethod method, @NotNull String urlString, @NotNull Map<String, String> headers, @NotNull Map<String, String> parameters, @Nullable Object payload, @Nullable IRNetwork.INetworkResult resultListener) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        Intrinsics.checkParameterIsNotNull(urlString, "urlString");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(parameters, "parameters");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("requestWithMethod threadId = ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb5.append(currentThread.getId());
        Log.d("RDelivery_HttpsURLConnectionNetwork", sb5.toString());
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                URLConnection openConnection = new URL(urlString).openConnection();
                if (openConnection != null) {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) openConnection;
                    try {
                        httpsURLConnection2.setRequestMethod(method.name());
                        httpsURLConnection2.setConnectTimeout(this.connectTimeout);
                        httpsURLConnection2.setReadTimeout(this.readTimeout);
                        httpsURLConnection2.setDoInput(true);
                        httpsURLConnection2.setDoOutput(true);
                        for (Map.Entry<String, String> entry : headers.entrySet()) {
                            httpsURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                        if (payload != null) {
                            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection2.getOutputStream());
                            try {
                                String obj = payload.toString();
                                Charset forName = Charset.forName("UTF-8");
                                Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(\"UTF-8\")");
                                if (obj != null) {
                                    byte[] bytes = obj.getBytes(forName);
                                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                                    dataOutputStream.write(bytes);
                                    dataOutputStream.flush();
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(dataOutputStream, null);
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                            } catch (Throwable th5) {
                                try {
                                    throw th5;
                                } catch (Throwable th6) {
                                    CloseableKt.closeFinally(dataOutputStream, th5);
                                    throw th6;
                                }
                            }
                        }
                        int responseCode = httpsURLConnection2.getResponseCode();
                        Log.d("RDelivery_HttpsURLConnectionNetwork", "requestWithMethod responseCode = " + responseCode);
                        if (responseCode == 200) {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection2.getInputStream()));
                            try {
                                String readText = TextStreamsKt.readText(bufferedReader);
                                if (resultListener != null) {
                                    resultListener.onSuccess(readText);
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                CloseableKt.closeFinally(bufferedReader, null);
                            } catch (Throwable th7) {
                                try {
                                    throw th7;
                                } catch (Throwable th8) {
                                    CloseableKt.closeFinally(bufferedReader, th7);
                                    throw th8;
                                }
                            }
                        } else {
                            IRNetwork.ResultInfo resultInfo = new IRNetwork.ResultInfo();
                            resultInfo.setErrorType(IRNetwork.ResultInfo.ErrorType.HTTP_ERROR);
                            resultInfo.setErrorCode(Integer.valueOf(responseCode));
                            if (resultListener != null) {
                                resultListener.onFail(resultInfo);
                            }
                        }
                        httpsURLConnection2.disconnect();
                        return;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        httpsURLConnection = httpsURLConnection2;
                        b(e, resultListener);
                        if (httpsURLConnection == null) {
                            return;
                        }
                        httpsURLConnection.disconnect();
                        return;
                    } catch (IOException e17) {
                        e = e17;
                        httpsURLConnection = httpsURLConnection2;
                        b(e, resultListener);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                            return;
                        }
                        return;
                    } catch (Exception e18) {
                        e = e18;
                        httpsURLConnection = httpsURLConnection2;
                        b(e, resultListener);
                        if (httpsURLConnection == null) {
                            return;
                        }
                        httpsURLConnection.disconnect();
                        return;
                    } catch (Throwable th9) {
                        th = th9;
                        httpsURLConnection = httpsURLConnection2;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            } catch (SocketTimeoutException e19) {
                e = e19;
            } catch (IOException e26) {
                e = e26;
            } catch (Exception e27) {
                e = e27;
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }

    @JvmOverloads
    public c(@NotNull Context context, int i3, int i16) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
        this.connectTimeout = i3;
        this.readTimeout = i16;
    }

    public /* synthetic */ c(Context context, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? 20000 : i3, (i17 & 4) != 0 ? 20000 : i16);
    }
}
