package com.tencent.mobileqq.mini.network.http;

import NS_COMM.COMM;
import android.util.Log;
import com.tencent.mobileqq.mini.network.http.httpRequest.HttpCheckNavigateRightRequest;
import com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetAppInfoByIdRequest;
import com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetAppInfoByLinkRequest;
import com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetCodeRequest;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HttpCmdManager {
    public static final String SECURITY_URL = "https://q.qq.com/security/bypass_channel";
    public static final String TAG = "HttpCmdManager";
    private static final HttpCmdManager sInstance = new HttpCmdManager();

    HttpCmdManager() {
    }

    public static HttpCmdManager g() {
        return sInstance;
    }

    public void checkNavigateRight(String str, String str2, String str3, HttpCmdResult httpCmdResult) {
        sendRequest("https://q.qq.com/security/bypass_channel?forbid_token=" + str3, new HttpCheckNavigateRightRequest(str, str2), httpCmdResult);
    }

    public void getAppInfoById(COMM.StCommonExt stCommonExt, String str, String str2, String str3, String str4, String str5, HttpCmdResult httpCmdResult) {
        sendRequest("https://q.qq.com/security/bypass_channel?forbid_token=" + str4, new HttpGetAppInfoByIdRequest(stCommonExt, str, 1, 0, str2, str3, str5), httpCmdResult);
    }

    public void getAppInfoByLink(String str, int i3, String str2, HttpCmdResult httpCmdResult) {
        sendRequest("https://q.qq.com/security/bypass_channel?forbid_token=" + str2, new HttpGetAppInfoByLinkRequest(str, i3), httpCmdResult);
    }

    public void getCode(String str, String str2, HttpCmdResult httpCmdResult) {
        sendRequest("https://q.qq.com/security/bypass_channel?forbid_token=" + str2, new HttpGetCodeRequest(str), httpCmdResult);
    }

    private void sendRequest(String str, final HttpProtoBufRequest httpProtoBufRequest, final HttpCmdResult httpCmdResult) {
        byte[] bArr;
        try {
            bArr = httpProtoBufRequest.encode();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleRequest Exception: " + Log.getStackTraceString(e16));
            bArr = null;
        }
        if (bArr == null) {
            bArr = new byte[4];
        }
        MiniappHttpUtil.httpPostV2(str, fh.b(bArr), null, new HttpCallBack() { // from class: com.tencent.mobileqq.mini.network.http.HttpCmdManager.1
            @Override // com.tencent.mobileqq.mini.network.http.HttpCallBack
            public void httpCallBack(int i3, byte[] bArr2, Map<String, List<String>> map) {
                if (i3 == 200 && httpCmdResult != null) {
                    JSONObject onResponse = httpProtoBufRequest.onResponse(i3, bArr2);
                    if (onResponse != null) {
                        httpCmdResult.onCmdListener(true, onResponse);
                        return;
                    } else {
                        httpCmdResult.onCmdListener(false, new JSONObject());
                        return;
                    }
                }
                HttpCmdResult httpCmdResult2 = httpCmdResult;
                if (httpCmdResult2 != null) {
                    httpCmdResult2.onCmdListener(false, new JSONObject());
                }
                QLog.e(HttpCmdManager.TAG, 1, "sendRequest, retCode: " + i3);
            }

            @Override // com.tencent.mobileqq.mini.network.http.HttpCallBack
            public void headersReceived(int i3, Map<String, List<String>> map) {
            }

            @Override // com.tencent.mobileqq.mini.network.http.HttpCallBack
            public void onProgressUpdate(int i3, int i16, int i17) {
            }
        }, null);
    }
}
