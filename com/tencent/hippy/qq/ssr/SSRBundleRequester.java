package com.tencent.hippy.qq.ssr;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IBaseHttpAdapter;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.ISSRBundleRequester;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.module.HippyQQHttpModule;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ah;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import dk0.b;
import dk0.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SSRBundleRequester implements ISSRBundleRequester {
    private static final String COOKIE = "Cookie";
    private static final int HTTP_STATUS_UNKNOWN = -1;
    private static final String KEY_CONTENT_TYPE = "Content-Type";
    private static final String KEY_HEAD_CONTAINER_SIZE = "containerSize";
    private static final String KEY_HEAD_DENSITY_DPI = "densityDpi";
    private static final String KEY_HEAD_FONT_SCALE = "fontScale";
    private static final String KEY_HEAD_PLATFORM = "platform";
    private static final String KEY_HEAD_P_SKEY = "p_skey=";
    private static final String KEY_HEAD_P_UIN = "p_uin=";
    private static final String KEY_HEAD_QQ_VERSION = "qqversion";
    private static final String KEY_HEAD_REQUEST_FROM = "reqFrom";
    private static final String KEY_HEAD_SCALE = "scale";
    private static final String KEY_HEAD_SCREEN_SIZE = "screenSize";
    private static final String KEY_HEAD_THEME_ID = "themeid";
    private static final String KEY_HEAD_WINDOW_SIZE = "windowSize";
    private static final int REQUEST_TIME_OUT = 5000;
    private static final String SEMICOLON = ";";
    private static final String SIZE_CONNECTION_STRING = "*";
    private static final String TAG = "SSRBundleRequester";
    private ISSRBundleRequester.OnGetSSRBundleListener getSSRBundleListener;
    private volatile boolean isRequestFinished = false;
    private String requestFrom = ISSRBundleRequester.FROM_SSR;
    private String resultMessage;
    private String ssrBundleContent;
    private int statusCode;

    private void addParamsToCookie(String str, HashMap<String, String> hashMap) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(getPUin())) {
            sb5.append(KEY_HEAD_P_UIN);
            sb5.append(getPUin());
        }
        if (!TextUtils.isEmpty(str)) {
            if (sb5.length() > 0) {
                sb5.append(";");
            }
            sb5.append(KEY_HEAD_P_SKEY);
            sb5.append(str);
        }
        if (sb5.length() > 0) {
            hashMap.put("Cookie", sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequestSSRBundle(IBaseHttpAdapter iBaseHttpAdapter, OpenHippyInfo openHippyInfo, String str) {
        dk0.a aVar = new dk0.a();
        aVar.f394017a = getHttpRequestHeader(openHippyInfo.bundleName, str);
        aVar.f394018b = openHippyInfo.ssrBundleUrl;
        aVar.f394019c = "GET";
        aVar.f394020d = null;
        aVar.f394021e = 5000;
        final HashMap hashMap = new HashMap();
        iBaseHttpAdapter.sendRequest(aVar, new c.a() { // from class: com.tencent.hippy.qq.ssr.SSRBundleRequester.2
            @Override // dk0.c.a
            public void onHeadersReceived(int i3, Map<String, List<String>> map) {
                SSRBundleRequester.this.saveHttpHeaders(map, hashMap);
            }

            @Override // dk0.c.a
            public void onHttpFinish(b bVar) {
                SSRBundleRequester.this.onHttpResponse(bVar, hashMap);
            }

            @Override // dk0.c.a
            public void onHttpStart() {
            }
        }, false);
    }

    private HashMap<String, String> getHttpRequestHeader(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(KEY_HEAD_QQ_VERSION, ah.P());
        hashMap.put("platform", "android");
        hashMap.put(KEY_HEAD_THEME_ID, QQTheme.getCurrentThemeId());
        hashMap.put(KEY_HEAD_REQUEST_FROM, this.requestFrom);
        addParamsToCookie(str2, hashMap);
        BaseApplication context = BaseApplication.getContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
        hashMap.put("screenSize", displayMetrics2.widthPixels + "*" + displayMetrics2.heightPixels);
        hashMap.put(KEY_HEAD_WINDOW_SIZE, displayMetrics.widthPixels + "*" + displayMetrics.heightPixels);
        int i3 = displayMetrics.heightPixels;
        int fixedWidth = ((IHippySetting) QRoute.api(IHippySetting.class)).getFixedWidth(str);
        if (fixedWidth <= 0) {
            fixedWidth = displayMetrics.widthPixels;
        }
        hashMap.put(KEY_HEAD_CONTAINER_SIZE, fixedWidth + "*" + i3);
        hashMap.put("scale", String.valueOf(displayMetrics.density));
        hashMap.put(KEY_HEAD_FONT_SCALE, String.valueOf(displayMetrics.scaledDensity));
        hashMap.put(KEY_HEAD_DENSITY_DPI, String.valueOf(displayMetrics.densityDpi));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public sd2.a getPSKeyCallback(final IBaseHttpAdapter iBaseHttpAdapter, final OpenHippyInfo openHippyInfo, final String str, final boolean z16) {
        final long currentTimeMillis = System.currentTimeMillis();
        return new sd2.a() { // from class: com.tencent.hippy.qq.ssr.SSRBundleRequester.1
            @Override // sd2.a
            public void onFail(@NonNull String str2) {
                QLog.e(SSRBundleRequester.TAG, 1, "[getPskeyCallback] failed:", str2, ",cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("domain", str);
                hashMap.put("reportFrom", "ssrRequest");
                hashMap.put(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, str2);
                HippyReporter.getInstance().reportToDengTa(openHippyInfo.bundleName, 0, HippyReporter.EventCode.HIPPY_PSKEY, -1, hashMap);
                IPskeyManager pSKeyManager = SSRBundleRequester.this.getPSKeyManager();
                if (!z16 || pSKeyManager == null) {
                    SSRBundleRequester.this.doRequestSSRBundle(iBaseHttpAdapter, openHippyInfo, null);
                } else {
                    String str3 = str;
                    pSKeyManager.replacePskey(new String[]{str3}, SSRBundleRequester.this.getPSKeyCallback(iBaseHttpAdapter, openHippyInfo, str3, false));
                }
            }

            @Override // sd2.a
            public void onSuccess(@NonNull Map<String, String> map) {
                SSRBundleRequester.this.doRequestSSRBundle(iBaseHttpAdapter, openHippyInfo, map.get(str));
                QLog.i(SSRBundleRequester.TAG, 1, "[getPskeyCallback]  cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IPskeyManager getPSKeyManager() {
        AppInterface appInterface = HippyUtils.getAppInterface();
        if (appInterface != null) {
            return (IPskeyManager) appInterface.getRuntimeService(IPskeyManager.class, "all");
        }
        return null;
    }

    private String getPUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return HttpBaseUtil.a(peekAppRuntime.getAccount());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHttpResponse(b bVar, HashMap<String, String> hashMap) {
        this.isRequestFinished = true;
        if (bVar == null) {
            this.statusCode = -1;
            this.resultMessage = "unknown error";
        } else {
            this.statusCode = NumberUtil.stringToInt(bVar.f394022a, -1);
            this.resultMessage = bVar.f394025d;
            byte[] bArr = bVar.f394023b;
            if (bArr != null) {
                this.ssrBundleContent = HippyQQHttpModule.readAsString(bArr, HippyQQHttpModule.getHeader(hashMap, "Content-Type"));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onHttpResponse statusCode:", Integer.valueOf(this.statusCode), " msg:", this.resultMessage);
        }
        ISSRBundleRequester.OnGetSSRBundleListener onGetSSRBundleListener = this.getSSRBundleListener;
        if (onGetSSRBundleListener != null) {
            onGetSSRBundleListener.onGetSSRBundle(this.statusCode, this.resultMessage, this.ssrBundleContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveHttpHeaders(Map<String, List<String>> map, HashMap<String, String> hashMap) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (key != null && value != null && value.size() > 0) {
                hashMap.put(key, value.get(0));
            }
        }
    }

    @Override // com.tencent.hippy.qq.api.ISSRBundleRequester
    public void getSSRBundle(ISSRBundleRequester.OnGetSSRBundleListener onGetSSRBundleListener) {
        if (this.isRequestFinished) {
            onGetSSRBundleListener.onGetSSRBundle(this.statusCode, this.resultMessage, this.ssrBundleContent);
        } else {
            this.getSSRBundleListener = onGetSSRBundleListener;
        }
    }

    @Override // com.tencent.hippy.qq.api.ISSRBundleRequester
    public void requestSSRBundle(IBaseHttpAdapter iBaseHttpAdapter, OpenHippyInfo openHippyInfo) {
        if (iBaseHttpAdapter != null && !TextUtils.isEmpty(openHippyInfo.ssrBundleUrl) && !TextUtils.isEmpty(openHippyInfo.bundleName)) {
            String str = openHippyInfo.domain;
            if (TextUtils.isEmpty(str)) {
                str = HippyAccessHelper.getDomainByBundleName(openHippyInfo.bundleName);
            }
            IPskeyManager pSKeyManager = getPSKeyManager();
            if (!TextUtils.isEmpty(str) && pSKeyManager != null) {
                pSKeyManager.getPskey(new String[]{str}, getPSKeyCallback(iBaseHttpAdapter, openHippyInfo, str, true));
            } else {
                doRequestSSRBundle(iBaseHttpAdapter, openHippyInfo, null);
            }
        }
    }

    @Override // com.tencent.hippy.qq.api.ISSRBundleRequester
    public ISSRBundleRequester setSSRBundleListener(ISSRBundleRequester.OnGetSSRBundleListener onGetSSRBundleListener) {
        this.getSSRBundleListener = onGetSSRBundleListener;
        return this;
    }

    @Override // com.tencent.hippy.qq.api.ISSRBundleRequester
    public SSRBundleRequester setRequestFrom(String str) {
        if (str == null) {
            str = "";
        }
        this.requestFrom = str;
        return this;
    }
}
