package com.tencent.turingcam;

import com.tencent.turingcam.usfPi;
import com.tencent.turingface.sdk.mfa.i;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes27.dex */
public class fenkF {
    public static usfPi a(i iVar, URL url, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection.setRequestProperty("User-Agent", "Turing");
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8");
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setRequestMethod(iVar.f382516b);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(iVar.f382518d);
                httpURLConnection.setReadTimeout(iVar.f382519e);
                httpURLConnection.setInstanceFollowRedirects(iVar.f382520f);
                usfPi.spXPg spxpg = new usfPi.spXPg();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    if (responseCode != 305) {
                        switch (responseCode) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                spxpg.f382404a = responseCode;
                                usfPi usfpi = new usfPi(spxpg);
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused) {
                                }
                                return usfpi;
                        }
                    }
                    spxpg.f382404a = responseCode;
                    spxpg.f382407d = true;
                    spxpg.f382406c = httpURLConnection.getHeaderField("Location");
                    usfPi usfpi2 = new usfPi(spxpg);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused2) {
                    }
                    return usfpi2;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    HDnuc.a(bufferedInputStream2, byteArrayOutputStream);
                    URL url2 = httpURLConnection.getURL();
                    if (!url.getHost().equals(url2.getHost())) {
                        spxpg.f382407d = true;
                        spxpg.f382406c = url2.toString();
                    }
                    spxpg.f382405b = byteArrayOutputStream.toByteArray();
                    usfPi usfpi3 = new usfPi(spxpg);
                    HDnuc.a(bufferedInputStream2);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused3) {
                    }
                    return usfpi3;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    HDnuc.a(bufferedInputStream);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            httpURLConnection = null;
        }
    }
}
