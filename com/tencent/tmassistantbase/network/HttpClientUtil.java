package com.tencent.tmassistantbase.network;

import android.text.TextUtils;
import com.tencent.tmassistantbase.util.GlobalUtil;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* compiled from: P */
/* loaded from: classes26.dex */
public class HttpClientUtil {
    public static HttpClient createHttpClient() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 4096);
        HttpClientParams.setRedirecting(basicHttpParams, false);
        return new DefaultHttpClient(basicHttpParams);
    }

    public static void setProxy(HttpClient httpClient) {
        String netStatus = GlobalUtil.getNetStatus();
        if (!TextUtils.isEmpty(netStatus)) {
            if (!netStatus.equalsIgnoreCase("cmwap") && !netStatus.equalsIgnoreCase("3gwap") && !netStatus.equalsIgnoreCase("uniwap")) {
                if (netStatus.equalsIgnoreCase("ctwap")) {
                    httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost("10.0.0.200", 80));
                    return;
                }
                return;
            }
            httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost("10.0.0.172", 80));
        }
    }
}
