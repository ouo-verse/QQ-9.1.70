package com.tencent.mtt.hippy.a;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpRequest;
import com.tencent.mtt.hippy.adapter.http.HippyHttpResponse;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes20.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    g f336973a;

    /* renamed from: b, reason: collision with root package name */
    private final HippyGlobalConfigs f336974b;

    /* renamed from: c, reason: collision with root package name */
    private final String f336975c;

    public k(HippyGlobalConfigs hippyGlobalConfigs, String str, String str2) {
        this.f336974b = hippyGlobalConfigs;
        this.f336975c = str;
        this.f336973a = new g(str2);
    }

    public String a() {
        return String.format(Locale.US, "ws://%s/debugger-live-reload", this.f336975c.split(":")[0] + ":38999");
    }

    public String a(String str, String str2, String str3) {
        if (!this.f336973a.a()) {
            return String.format(Locale.US, "ws://%s/debugger-proxy?role=android_client&clientId=%s&hash=%s&contextName=%s", str, str3, "", str2);
        }
        if (TextUtils.isEmpty(this.f336973a.f())) {
            return String.format(Locale.US, "ws://%s/debugger-proxy?role=android_client&clientId=%s&hash=%s&contextName=%s", this.f336973a.b(), str3, this.f336973a.c(), str2);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f336973a.f());
        String f16 = this.f336973a.f();
        String str4 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (f16.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str4 = ContainerUtils.FIELD_DELIMITER;
        }
        sb5.append(str4);
        sb5.append("role=android_client&clientId=%s&hash=%s&contextName=%s");
        return String.format(Locale.US, sb5.toString(), str3, this.f336973a.c(), str2);
    }

    public String a(String str, String str2, boolean z16, boolean z17, boolean z18) {
        return this.f336973a.a() ? String.format(Locale.US, "%s://%s/%s?platform=android&dev=%s&hot=%s&minify=%s", this.f336973a.e(), this.f336973a.b(), this.f336973a.d(), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18)) : String.format(Locale.US, "%s://%s/%s?platform=android&dev=%s&hot=%s&minify=%s", "http", str, str2, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
    }

    public void a(final a aVar, final String str) {
        HippyHttpRequest hippyHttpRequest = new HippyHttpRequest();
        hippyHttpRequest.setUrl(str);
        this.f336974b.getHttpAdapter().sendRequest(hippyHttpRequest, new HippyHttpAdapter.HttpTaskCallback() { // from class: com.tencent.mtt.hippy.a.k.1
            @Override // com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback
            public void onTaskFailed(HippyHttpRequest hippyHttpRequest2, Throwable th5) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(new j("Could not connect to development server.URL: " + str + "  try to :adb reverse tcp:38989 tcp:38989 , message : " + th5.getMessage()));
                }
            }

            @Override // com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback
            public void onTaskSuccess(HippyHttpRequest hippyHttpRequest2, HippyHttpResponse hippyHttpResponse) throws Exception {
                String str2;
                if (aVar == null) {
                    return;
                }
                if (hippyHttpResponse.getStatusCode().intValue() == 200 && hippyHttpResponse.getInputStream() != null) {
                    aVar.a(hippyHttpResponse.getInputStream());
                    return;
                }
                if (hippyHttpResponse.getErrorStream() != null) {
                    StringBuilder sb5 = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(hippyHttpResponse.getErrorStream(), "UTF-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb5.append(readLine);
                        sb5.append("\r\n");
                    }
                    str2 = sb5.toString();
                } else {
                    str2 = "unknown";
                }
                aVar.a(new j("Could not connect to development server.URL: " + str + "  try to :adb reverse tcp:38989 tcp:38989 , message : " + str2));
            }
        });
    }
}
