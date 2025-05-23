package com.gcloudsdk.apollo.apollovoice.httpclient;

import com.gcloudsdk.apollo.ApolloVoiceLog;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FastHostnameVerifier implements HostnameVerifier {
    public String mHost;

    public FastHostnameVerifier(String str) {
        this.mHost = str;
    }

    public boolean equals(Object obj) {
        String str;
        String str2 = this.mHost;
        if (str2 == null || str2.equals("") || !(obj instanceof FastHostnameVerifier) || (str = ((FastHostnameVerifier) obj).mHost) == null || str.equals("")) {
            return false;
        }
        return this.mHost.equals(str);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        boolean z16;
        if (!str.equalsIgnoreCase(this.mHost) && !HttpsURLConnection.getDefaultHostnameVerifier().verify(this.mHost, sSLSession)) {
            z16 = false;
        } else {
            z16 = true;
        }
        ApolloVoiceLog.LogI("hostname: " + str + " verify result: " + z16);
        return z16;
    }
}
