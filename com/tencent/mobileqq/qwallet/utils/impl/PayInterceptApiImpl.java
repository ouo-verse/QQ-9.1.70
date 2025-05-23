package com.tencent.mobileqq.qwallet.utils.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.qwallet.utils.IPayInterceptApi;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class PayInterceptApiImpl implements IPayInterceptApi {
    public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDsE3WI7sDFUi6QWV/oK8qozDvS\nTlxmu1a3NSFxeOrjlVEVtOx8yIMVFYIixq/Fv1XgUlyvL7bGJbaLLKaqlYruGd2z\nNbaIz90Zm4H0pMFHx4vCYhsRP1HXbVMo2ZDiHEDbnSm/99uzFPPiXqLi8jE9t4if\n0GuYdSZfe5o+SIKT5QIDAQAB";
    private static final String TAG = "PayInterceptApi";
    private static volatile IPayInterceptApi sInstance;
    private List<a> mConfigs = null;

    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f279270a;

        /* renamed from: b, reason: collision with root package name */
        public String f279271b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f279272c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f279273d;

        /* renamed from: e, reason: collision with root package name */
        public String f279274e;

        /* renamed from: f, reason: collision with root package name */
        public Pattern f279275f;

        /* renamed from: g, reason: collision with root package name */
        public Pattern f279276g;

        /* renamed from: h, reason: collision with root package name */
        public String f279277h;

        public static List<a> a(String str) {
            boolean z16;
            boolean z17;
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null) {
                        a aVar = new a();
                        aVar.f279270a = jSONObject.optString("sourceURLRegular");
                        aVar.f279271b = jSONObject.optString("interceptURLRegular");
                        if (jSONObject.optInt("shouldReport") == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        aVar.f279272c = z16;
                        if (jSONObject.optInt("shouldIntercept") == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        aVar.f279273d = z17;
                        aVar.f279274e = jSONObject.optString("jumpURL");
                        arrayList.add(aVar);
                    }
                }
            } catch (Exception e16) {
                QLog.e(PayInterceptApiImpl.TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
            return arrayList;
        }

        public String toString() {
            return "InterceptConfig [mSrcUrlRegular=" + this.f279270a + ", mInterceptUrlRegular=" + this.f279271b + ", mIsReport=" + this.f279272c + ", mIsIntercept=" + this.f279273d + ", mJumpUrl=" + this.f279274e + "]";
        }
    }

    public PayInterceptApiImpl() {
        loadConfigFromSP();
    }

    public static String rsaDecrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
                byte[] decode = Base64.decode(str, 0);
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, generatePublic);
                return new String(cipher.doFinal(decode));
            } catch (Exception e16) {
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
        }
        return null;
    }

    public void loadConfigFromSP() {
        String stringConfig = ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getStringConfig(IQWalletUnitedConfigApi.QWALLET_INTERCEPT_APP_CONFIG, "");
        if (!TextUtils.isEmpty(stringConfig)) {
            this.mConfigs = a.a(stringConfig);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadConfigFromSP|" + this.mConfigs);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.utils.IPayInterceptApi
    public boolean tryIntercept(String str, Object obj) {
        WebBackForwardList copyBackForwardList;
        String str2;
        boolean matches;
        String str3;
        List<String> list;
        WebViewProvider webViewProvider = (WebViewProvider) obj;
        if (this.mConfigs != null && !TextUtils.isEmpty(str) && webViewProvider != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleIntercept:" + str);
            }
            CustomWebView webView = webViewProvider.getWebView();
            if (webView != null && (copyBackForwardList = webView.copyBackForwardList()) != null && copyBackForwardList.getCurrentIndex() == copyBackForwardList.getSize() - 1) {
                Iterator<a> it = this.mConfigs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (!TextUtils.isEmpty(next.f279271b)) {
                        if (next.f279275f == null) {
                            next.f279275f = Pattern.compile(next.f279271b);
                        }
                        if (next.f279275f.matcher(str).matches()) {
                            SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) webViewProvider.getComponentProvider().a(-2);
                            if (swiftBrowserStatistics != null && (list = swiftBrowserStatistics.I0) != null && list.size() > 0) {
                                str2 = list.get(0);
                            } else {
                                str2 = "";
                            }
                            if (TextUtils.isEmpty(next.f279270a)) {
                                matches = true;
                            } else {
                                if (next.f279276g == null) {
                                    next.f279276g = Pattern.compile(next.f279270a);
                                }
                                matches = next.f279276g.matcher(str2).matches();
                            }
                            if (matches) {
                                if (next.f279272c) {
                                    VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "InterceptOpenOtherApp", null, "originURL=" + str2 + "|interceptURL=" + str, 0, null);
                                }
                                if (!next.f279273d) {
                                    return false;
                                }
                                if (!TextUtils.isEmpty(next.f279274e)) {
                                    if (TextUtils.isEmpty(next.f279277h)) {
                                        next.f279277h = rsaDecrypt(next.f279274e, PUBLIC_KEY);
                                    }
                                    String str4 = next.f279277h;
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TAG, 2, "jumpUrl:" + str4);
                                    }
                                    if (TextUtils.isEmpty(str4)) {
                                        return false;
                                    }
                                    if (str4.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                                        str3 = str4 + "&j=";
                                    } else {
                                        str3 = str4 + "?j=";
                                    }
                                    try {
                                        str3 = str3 + URLEncoder.encode(str, "UTF-8");
                                    } catch (UnsupportedEncodingException e16) {
                                        QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TAG, 2, "jumpUrl with params:" + str3);
                                    }
                                    webView.loadUrl(str3);
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
