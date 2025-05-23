package com.tencent.rfix.lib.config;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.tls.Tls12SocketFactory;
import com.tencent.rfix.loader.utils.CloseUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f implements IRNetwork {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.rdelivery.dependencyimpl.c f364948a;

    public f(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f364948a = new com.tencent.rdelivery.dependencyimpl.c(context);
        }
    }

    private void a(Exception exc, @Nullable IRNetwork.INetworkResult iNetworkResult) {
        RFixLog.e("RFix.RDeliveryNetwork", "handleException!", exc);
        IRNetwork.ResultInfo resultInfo = new IRNetwork.ResultInfo();
        resultInfo.setErrorType(IRNetwork.ResultInfo.ErrorType.OTHER_ERROR);
        resultInfo.setErrorMessage(exc.getClass().getSimpleName());
        if (iNetworkResult != null) {
            iNetworkResult.onFail(resultInfo);
        }
    }

    @Override // com.tencent.raft.standard.net.IRNetwork
    public IRNetwork.NetworkStatus getNetworkStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IRNetwork.NetworkStatus) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f364948a.getNetworkStatus();
    }

    @Override // com.tencent.raft.standard.net.IRNetwork
    public void requestWithMethod(@NotNull IRNetwork.HttpMethod httpMethod, @NotNull String str, @NotNull Map<String, String> map, @NotNull Map<String, String> map2, @Nullable Object obj, @Nullable IRNetwork.INetworkResult iNetworkResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, httpMethod, str, map, map2, obj, iNetworkResult);
            return;
        }
        RFixLog.d("RFix.RDeliveryNetwork", "requestWithMethod threadId=" + Thread.currentThread().getId());
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection2.setRequestMethod(httpMethod.name());
                    httpURLConnection2.setConnectTimeout(15000);
                    httpURLConnection2.setReadTimeout(15000);
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setDoOutput(true);
                    for (String str2 : map.keySet()) {
                        httpURLConnection2.setRequestProperty(str2, map.get(str2));
                    }
                    Tls12SocketFactory.enableTls12OnPreKitkat(httpURLConnection2);
                    httpURLConnection2.getOutputStream().write(obj.toString().getBytes(StandardCharsets.UTF_8));
                    int responseCode = httpURLConnection2.getResponseCode();
                    RFixLog.d("RFix.RDeliveryNetwork", "requestWithMethod responseCode=" + responseCode);
                    if (responseCode == 200) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream(), StandardCharsets.UTF_8));
                        StringBuilder sb5 = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else {
                                sb5.append(readLine);
                            }
                        }
                        if (iNetworkResult != null) {
                            iNetworkResult.onSuccess(sb5.toString());
                        }
                    } else {
                        IRNetwork.ResultInfo resultInfo = new IRNetwork.ResultInfo();
                        resultInfo.setErrorType(IRNetwork.ResultInfo.ErrorType.HTTP_ERROR);
                        resultInfo.setErrorCode(Integer.valueOf(responseCode));
                        if (iNetworkResult != null) {
                            iNetworkResult.onFail(resultInfo);
                        }
                    }
                    CloseUtil.disconnectQuietly(httpURLConnection2);
                } catch (Exception e16) {
                    e = e16;
                    httpURLConnection = httpURLConnection2;
                    a(e, iNetworkResult);
                    CloseUtil.disconnectQuietly(httpURLConnection);
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = httpURLConnection2;
                    CloseUtil.disconnectQuietly(httpURLConnection);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
