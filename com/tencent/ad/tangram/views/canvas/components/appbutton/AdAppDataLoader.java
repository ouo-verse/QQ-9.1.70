package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAppDataLoader {
    private static final String APP_DATA_INFO_DOMAIN = "https://h5.gdt.qq.com/player/openapp/";
    private static final String APP_DATA_INFO_DOMAIN_ROOT = "https://h5.gdt.qq.com";

    @NonNull
    private static String converStreamToString(@NonNull InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuffer.append(readLine);
            } else {
                return stringBuffer.toString();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0113 A[Catch: all -> 0x010f, TRY_LEAVE, TryCatch #8 {all -> 0x010f, blocks: (B:62:0x010b, B:55:0x0113), top: B:61:0x010b }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.InputStream] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AdAppBtnData loadGdtAppBtnData(String str, String str2, int i3) {
        ?? r56;
        InputStream inputStream;
        AdAppBtnData adAppBtnData;
        String converStreamToString;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AdLog.i("AdCanvasAppBtnUIAdapter", "loadGdtAppBtnData appid " + str + " channelId " + str2 + " requestTime " + i3);
        ?? r46 = APP_DATA_INFO_DOMAIN + str + "?channelId=" + str2 + "&landingPageType=XJ_CANVAS";
        String str3 = "d_url " + r46;
        AdLog.i("AdCanvasAppBtnUIAdapter", str3);
        try {
            try {
                r46 = (HttpURLConnection) new URL(r46).openConnection();
                try {
                    r46.setRequestMethod("GET");
                    r46.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                    r46.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
                    r46.setRequestProperty("Referer", APP_DATA_INFO_DOMAIN_ROOT);
                    r46.setConnectTimeout(3000);
                    r46.setReadTimeout(3000);
                    if (r46.getResponseCode() == 200) {
                        inputStream = r46.getInputStream();
                        if (inputStream != null) {
                            try {
                                converStreamToString = converStreamToString(inputStream);
                            } catch (Exception e16) {
                                e = e16;
                                AdLog.e("AdCanvasAppBtnUIAdapter", "loadGdtAppBtnData excep", e);
                                if (r46 != 0) {
                                    try {
                                        r46.disconnect();
                                    } catch (Throwable th5) {
                                        AdLog.e("AdCanvasAppBtnUIAdapter", "loadGdtAppBtnData excep", th5);
                                        return null;
                                    }
                                }
                                if (inputStream == null) {
                                    return null;
                                }
                                inputStream.close();
                                return null;
                            }
                        } else {
                            converStreamToString = "";
                        }
                        if (!TextUtils.isEmpty(converStreamToString)) {
                            adAppBtnData = AdAppBtnData.parseJson(new JSONObject(converStreamToString));
                        } else {
                            AdLog.e("AdCanvasAppBtnUIAdapter", "loadGdtAppBtnData result null");
                            adAppBtnData = null;
                        }
                        inputStream2 = inputStream;
                    } else {
                        AdLog.e("AdCanvasAppBtnUIAdapter", "loadGdtAppBtnData failed !!!");
                        adAppBtnData = null;
                    }
                    try {
                        r46.disconnect();
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                    } catch (Throwable th6) {
                        AdLog.e("AdCanvasAppBtnUIAdapter", "loadGdtAppBtnData excep", th6);
                    }
                    return adAppBtnData;
                } catch (Exception e17) {
                    e = e17;
                    inputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    str3 = null;
                    httpURLConnection = r46;
                    r56 = str3;
                    if (httpURLConnection != null) {
                    }
                    if (r56 != 0) {
                    }
                    throw th;
                }
            } catch (Exception e18) {
                e = e18;
                r46 = 0;
                inputStream = null;
            } catch (Throwable th8) {
                th = th8;
                r56 = 0;
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th9) {
                        AdLog.e("AdCanvasAppBtnUIAdapter", "loadGdtAppBtnData excep", th9);
                        throw th;
                    }
                }
                if (r56 != 0) {
                    r56.close();
                }
                throw th;
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }
}
