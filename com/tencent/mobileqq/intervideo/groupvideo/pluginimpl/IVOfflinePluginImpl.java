package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.a;
import com.tencent.biz.common.offline.b;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVOfflineInterface;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class IVOfflinePluginImpl implements IVOfflineInterface {
    private long initTime;
    private Context mApplicationContext;
    private AuthorizeConfig mAuthConfig;
    private String mBid;
    private String mBusinessId;
    private Handler mCheckupHandler;
    private ArrayList<String> mExBusinessIdList;
    private WebView mWebView;
    private String TAG = "IVOfflinePluginImpl";
    private boolean isDestroy = false;
    private boolean isCheckModel = false;

    /* renamed from: ex, reason: collision with root package name */
    private boolean f238225ex = false;
    private int mOfflineLoadMode = 0;

    public IVOfflinePluginImpl(Context context, WebView webView) {
        this.mApplicationContext = context;
        HtmlOffline.K(context);
        this.mWebView = webView;
        this.mAuthConfig = AuthorizeConfig.z(true);
        initHandler();
        this.initTime = System.currentTimeMillis();
    }

    private boolean checkModel() {
        AuthorizeConfig authorizeConfig;
        if (!this.isCheckModel && this.mBusinessId != null && (authorizeConfig = this.mAuthConfig) != null) {
            this.isCheckModel = true;
            String x16 = authorizeConfig.x("ex_offline", "");
            if (!TextUtils.isEmpty(x16)) {
                String[] split = x16.split(",");
                String str = Build.BRAND;
                String model = DeviceInfoMonitor.getModel();
                String str2 = Build.VERSION.RELEASE;
                StringBuilder sb5 = new StringBuilder(str);
                sb5.append(" ");
                sb5.append(model);
                String lowerCase = sb5.toString().toLowerCase();
                sb5.append(" ");
                sb5.append(str2);
                String lowerCase2 = sb5.toString().toLowerCase();
                for (String str3 : split) {
                    String lowerCase3 = str3.toLowerCase();
                    if (lowerCase3.contains(lowerCase) && lowerCase2.startsWith(lowerCase3)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(this.TAG, 2, "*****checkOfflineUrl: in ex offline");
                        }
                        this.mBusinessId = null;
                        this.f238225ex = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOfflineUp(String str) {
        if (!TextUtils.isEmpty(str) && isCheckUpByNative(str)) {
            if (QLog.isColorLevel()) {
                QLog.i(this.TAG, 2, "checkOfflineUp.");
            }
            HtmlOffline.e(str, ((BaseApplicationImpl) BaseApplication.getContext()).waitAppRuntime(null), new a() { // from class: com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl.1
                @Override // com.tencent.biz.common.offline.a
                public void loaded(String str2, int i3) {
                    JSONObject jSONObject;
                    if (QLog.isColorLevel()) {
                        QLog.i(IVOfflinePluginImpl.this.TAG, 2, "checkOfflineUp, param = " + str2 + " code = " + i3);
                    }
                    if (i3 != 9) {
                        if (i3 == -1) {
                            Message obtainMessage = IVOfflinePluginImpl.this.mCheckupHandler.obtainMessage();
                            obtainMessage.arg1 = 2;
                            IVOfflinePluginImpl.this.mCheckupHandler.sendMessage(obtainMessage);
                            return;
                        }
                        return;
                    }
                    try {
                        jSONObject = new JSONObject(str2);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.i(IVOfflinePluginImpl.this.TAG, 2, "checkUp loaded err:" + str2);
                        }
                        jSONObject = null;
                    }
                    Message obtainMessage2 = IVOfflinePluginImpl.this.mCheckupHandler.obtainMessage();
                    obtainMessage2.arg1 = 3;
                    obtainMessage2.obj = jSONObject;
                    IVOfflinePluginImpl.this.mCheckupHandler.sendMessage(obtainMessage2);
                }

                @Override // com.tencent.biz.common.offline.a
                public void progress(int i3) {
                }
            });
        }
    }

    private void checkOfflineUpNotCallback(String str) {
        if (!TextUtils.isEmpty(str) && isCheckUpByNative(str)) {
            if (QLog.isColorLevel()) {
                QLog.i(this.TAG, 2, "checkOfflineUpNotCallback.");
            }
            HtmlOffline.e(str, ((BaseApplicationImpl) BaseApplication.getContext()).waitAppRuntime(null), new a() { // from class: com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl.3
                @Override // com.tencent.biz.common.offline.a
                public void loaded(String str2, int i3) {
                    if (QLog.isColorLevel()) {
                        QLog.i(IVOfflinePluginImpl.this.TAG, 2, "checkOfflineUpNotCallback, param = " + str2 + " code = " + i3);
                    }
                }

                @Override // com.tencent.biz.common.offline.a
                public void progress(int i3) {
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String checkOfflineUrl(String str) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "checkOfflineUrl");
        }
        if (TextUtils.isEmpty(str) || !Uri.parse(str).isHierarchical()) {
            return str;
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("_bid");
            this.mBusinessId = queryParameter;
            if (this.mBid == null) {
                this.mBid = queryParameter;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (TextUtils.isEmpty(this.mBusinessId)) {
            String D = this.mAuthConfig.D(str);
            this.mBusinessId = D;
            if (this.mBid == null) {
                this.mBid = D;
            }
            if (!TextUtils.isEmpty(D)) {
                str2 = HtmlOffline.b(str, "_bid=" + this.mBusinessId);
                if (!checkModel()) {
                    return str;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(this.TAG, 2, "checkOfflineUrl:");
                }
                return str2;
            }
        }
        str2 = str;
        if (!checkModel()) {
        }
    }

    private void initHandler() {
        this.mCheckupHandler = new Handler() { // from class: com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (IVOfflinePluginImpl.this.isDestroy) {
                    return;
                }
                int i3 = message.arg1;
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i(IVOfflinePluginImpl.this.TAG, 4, "checkOfflineUpBack refresh current url");
                        }
                        IVOfflinePluginImpl.this.reloadCurrentUrl();
                        return;
                    }
                    return;
                }
                IVOfflinePluginImpl.this.mOfflineLoadMode = message.arg2;
                String str = (String) message.obj;
                IVOfflinePluginImpl.this.mWebView.loadUrl(str);
                if (QLog.isColorLevel()) {
                    QLog.i(IVOfflinePluginImpl.this.TAG, 2, "mCheckupHandler loadUrl start");
                }
                IVOfflinePluginImpl.this.checkOfflineUp(str);
            }
        };
    }

    private boolean isCheckUpByNative(String str) {
        String str2;
        try {
            str2 = Uri.parse(str).getQueryParameter("_duck");
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i("QQBrowserActivity", 2, "checkOfflineUpr:url parse exception:" + str);
            }
            str2 = "0";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.mAuthConfig.t(str);
        }
        if (TextUtils.isEmpty(str2) || !str2.equals("1")) {
            return true;
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.i("webviewLoadUrl", 4, "1 checkOfflineUp _duck=1");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reloadCurrentUrl() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.loadUrl(webView.getUrl());
            if (QLog.isColorLevel()) {
                QLog.i(this.TAG, 2, "reloadCurrentUrl");
            }
        }
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVOfflineInterface
    public void asyncLoadUrl(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "asyncLoadUrl...");
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (HtmlOffline.N(this.mApplicationContext, str, new b() { // from class: com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl.4
            @Override // com.tencent.biz.common.offline.b
            public void loaded(int i3, String str2) {
                if (QLog.isColorLevel()) {
                    QLog.i(IVOfflinePluginImpl.this.TAG, 2, "transToLocalUrl loadMode:" + i3 + ", time:" + (System.currentTimeMillis() - currentTimeMillis));
                }
                Message obtainMessage = IVOfflinePluginImpl.this.mCheckupHandler.obtainMessage();
                obtainMessage.arg1 = 1;
                obtainMessage.arg2 = i3;
                obtainMessage.obj = str2;
                IVOfflinePluginImpl.this.mCheckupHandler.sendMessage(obtainMessage);
                if (IVOfflinePluginImpl.this.initTime > 0) {
                    IVOfflinePluginImpl.this.initTime = 0L;
                }
            }
        })) {
            return;
        }
        this.mWebView.loadUrl(str);
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "transToLocalUrl: return false");
        }
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVOfflineInterface
    public boolean isOfflineUrl(String str) {
        boolean z16 = true;
        if (TextUtils.isEmpty(this.mBusinessId)) {
            checkOfflineUrl(str);
            z16 = true ^ TextUtils.isEmpty(this.mBusinessId);
        }
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "isOfflineUrl = " + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVOfflineInterface
    public WebResourceResponse shouldInterceptRequest(String str) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "shouldInterceptRequest");
        }
        if (this.f238225ex || TextUtils.isEmpty(str) || !str.startsWith("http")) {
            return null;
        }
        if (TextUtils.isEmpty(this.mBusinessId) && (TextUtils.isEmpty(str) || !str.contains("_bid="))) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "empty bid, shouldInterceptRequest return null");
            }
            return null;
        }
        if (checkModel()) {
            if (QLog.isColorLevel()) {
                QLog.i(this.TAG, 2, "checkModel, return null");
            }
            return null;
        }
        try {
            str2 = Uri.parse(str).getQueryParameter("_bid");
        } catch (Exception e16) {
            e16.printStackTrace();
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.mBusinessId;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        boolean z16 = false;
        if (TextUtils.isEmpty(this.mBusinessId) || !str2.equals(this.mBusinessId)) {
            checkOfflineUpNotCallback(str);
            if (this.mExBusinessIdList == null) {
                this.mExBusinessIdList = new ArrayList<>();
            }
            int size = this.mExBusinessIdList.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (str2.equals(this.mExBusinessIdList.get(i3))) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (!z16) {
                this.mExBusinessIdList.add(str2);
            }
            if (!z16 && !HtmlOffline.R(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "verifySign fail to reload");
                }
                return null;
            }
            z16 = true;
        }
        if ((this.mOfflineLoadMode == 3 || z16) && !HtmlOffline.S(str2, str)) {
            reloadCurrentUrl();
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "shouldInterceptRequest verify single fail to reload");
            }
            return null;
        }
        HtmlOffline.c B = HtmlOffline.B(str2, str);
        if (B == null) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "shouldInterceptRequest return null");
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "shouldInterceptRequest , return local value");
        }
        return new WebResourceResponse(B.f78433a, "utf-8", B.f78434b);
    }

    public void onDestroy() {
        this.isDestroy = true;
    }
}
