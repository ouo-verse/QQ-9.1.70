package com.tencent.webbundle.sdk;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.webbundle.sdk.HybridIdleTaskHelper;
import com.tencent.webbundle.sdk.WebBundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class WebBundleManager implements WebBundle.PreloadStateListener {
    static IPatchRedirector $redirector_ = null;
    private static final String DEFAULT_BIZ_ID = "webBundle";
    private static final String TAG = "WebBundle.WebBundleManager";
    private static HashMap<String, WebBundleManager> sInstanceMap;
    private WebBundleConfig config;
    private boolean isInit;
    private String mBizid;
    private final HashMap<String, Integer> mPreloadFailCntMap;
    private final HashMap<String, ArrayList<WebBundle>> mPreloadedPool;
    private WebBundle mPreloadingOne;
    private IWebBundleRuntime runtime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11061);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            sInstanceMap = new HashMap<>();
        }
    }

    WebBundleManager(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mBizid = DEFAULT_BIZ_ID;
        this.mPreloadingOne = null;
        this.mPreloadedPool = new HashMap<>();
        this.mPreloadFailCntMap = new HashMap<>();
        this.mBizid = str;
    }

    public static WebBundleManager getInstance() {
        return getInstance(DEFAULT_BIZ_ID);
    }

    @Nullable
    private String getNextPreloadUrl() {
        WebBundleConfig webBundleConfig;
        if (this.mPreloadingOne == null && (webBundleConfig = this.config) != null) {
            Iterator<String> it = webBundleConfig.getPreloadUrlList().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (getPreloadedCount(next) < this.config.getPreloadWebViewCount() && getPreloadFailedCount(next) < 2) {
                    return next;
                }
            }
        }
        return null;
    }

    private int getPreloadFailedCount(String str) {
        Integer num = this.mPreloadFailCntMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private int getPreloadedCount(String str) {
        ArrayList<WebBundle> arrayList = this.mPreloadedPool.get(str);
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    private int getPreloadingCount(String str) {
        if (this.mPreloadingOne == null) {
            return 0;
        }
        return 1;
    }

    private void onPreloadFailed(WebBundle webBundle) {
        String preloadUrl = webBundle.getPreloadUrl();
        if (this.mPreloadingOne == webBundle) {
            this.mPreloadingOne = null;
        }
        log(3, TAG, "on webbundle preload failed. preloading = ", String.valueOf(getPreloadingCount(preloadUrl)), ", preloaded = ", String.valueOf(getPreloadedCount(preloadUrl)), ", preloadUrl = ", preloadUrl);
        Integer num = this.mPreloadFailCntMap.get(preloadUrl);
        if (num == null) {
            num = 0;
        }
        this.mPreloadFailCntMap.put(preloadUrl, Integer.valueOf(num.intValue() + 1));
        triggerPreload();
    }

    private void onPreloadSuccess(WebBundle webBundle) {
        String preloadUrl = webBundle.getPreloadUrl();
        if (this.mPreloadingOne == webBundle) {
            this.mPreloadingOne = null;
        }
        ArrayList<WebBundle> arrayList = this.mPreloadedPool.get(preloadUrl);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mPreloadedPool.put(preloadUrl, arrayList);
        }
        arrayList.add(webBundle);
        log(3, TAG, "on webbundle preload success. preloading = ", String.valueOf(getPreloadingCount(preloadUrl)), ", preloaded = ", String.valueOf(getPreloadedCount(preloadUrl)), ", preloadUrl = ", preloadUrl);
        this.mPreloadFailCntMap.put(preloadUrl, 0);
        triggerPreload();
    }

    public final void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        ThreadManager.checkMainThread("destroy");
        log(3, TAG, "destroy webbundle.");
        if (this.isInit) {
            WebBundle webBundle = this.mPreloadingOne;
            if (webBundle != null) {
                webBundle.forceStop("destroy");
            }
            Iterator<String> it = this.mPreloadedPool.keySet().iterator();
            while (it.hasNext()) {
                ArrayList<WebBundle> arrayList = this.mPreloadedPool.get(it.next());
                Iterator<WebBundle> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    it5.next().destroy();
                }
                arrayList.clear();
            }
            this.mPreloadFailCntMap.clear();
            this.isInit = false;
            this.config.reset();
            this.config = null;
            this.runtime.destroy();
            this.runtime = null;
        }
        HybridIdleTaskHelper.getInstance().removeIdleTask(this.mBizid.hashCode());
        sInstanceMap.remove(this.mBizid);
    }

    @Nullable
    public final WebBundle getAvailableWebBundle(@NotNull Context context, @NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (WebBundle) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) str);
        }
        WebBundle webBundle = null;
        if (!this.isInit) {
            return null;
        }
        ThreadManager.checkMainThread("getAvailableWebBundle");
        ArrayList<WebBundle> arrayList = this.mPreloadedPool.get(str);
        log(3, TAG, "get available webbundle. preloading = ", String.valueOf(getPreloadingCount(str)), ", preloaded = ", String.valueOf(getPreloadedCount(str)), ", preloadUrl = ", str);
        if (arrayList != null && arrayList.size() > 0) {
            webBundle = arrayList.remove(0);
            webBundle.resetContext(context);
        }
        this.mPreloadFailCntMap.put(str, 0);
        triggerPreload(500L);
        return webBundle;
    }

    public final WebBundleConfig getConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (WebBundleConfig) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.config;
    }

    public final IWebBundleRuntime getRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IWebBundleRuntime) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.runtime;
    }

    public final synchronized void init(@NotNull IWebBundleRuntime iWebBundleRuntime, @NotNull WebBundleConfig webBundleConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iWebBundleRuntime, (Object) webBundleConfig);
            return;
        }
        if (this.isInit) {
            return;
        }
        if (webBundleConfig.isValidate()) {
            this.runtime = iWebBundleRuntime;
            this.config = webBundleConfig;
            this.isInit = true;
            log(3, TAG, "init webbundle success.");
            return;
        }
        throw new IllegalArgumentException("invalid webbundle config.");
    }

    public boolean isInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isInit;
    }

    public final void log(int i3, @NotNull String str, @NotNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (this.config == null) {
            return;
        }
        String str3 = "[" + this.mBizid + "]" + str2;
        if (this.config.isLogPrintEnabled()) {
            if (i3 == 3) {
                Log.d(str, str3);
            } else if (i3 == 4) {
                Log.i(str, str3);
            } else if (i3 == 5) {
                Log.w(str, str3);
            } else if (i3 == 6) {
                Log.e(str, str3);
            }
        }
        if (this.config.getLogListener() != null) {
            this.config.getLogListener().log(i3, str, str3);
        }
    }

    @Override // com.tencent.webbundle.sdk.WebBundle.PreloadStateListener
    public void onStateChange(@NotNull WebBundle webBundle, @NotNull WebBundle.WebBundlePreloadState webBundlePreloadState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) webBundle, (Object) webBundlePreloadState);
            return;
        }
        ThreadManager.checkMainThread("onStateChange");
        if (webBundlePreloadState == WebBundle.WebBundlePreloadState.SUCCESS) {
            onPreloadSuccess(webBundle);
        } else if (webBundlePreloadState == WebBundle.WebBundlePreloadState.FAILED) {
            onPreloadFailed(webBundle);
        }
    }

    public final boolean openWebViewWithWebBundle(@NotNull Activity activity, @NotNull String str, @NotNull JSONObject jSONObject, @Nullable Intent intent, @NotNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, activity, str, jSONObject, intent, str2)).booleanValue();
        }
        if (!this.isInit) {
            return false;
        }
        ThreadManager.checkMainThread("openWebViewWithWebBundle");
        if (intent == null) {
            intent = new Intent();
        }
        intent.setComponent(new ComponentName(activity.getPackageName(), this.config.getCarrierActivityClass().getName()));
        intent.putExtra(WebBundleConstants.WEBBUNDLE_PRELOAD_URL, str2);
        intent.putExtra(WebBundleConstants.WEBBUNDLE_REAL_URL, str);
        intent.putExtra(WebBundleConstants.WEBBUNDLE_BUNDLE_DATA, jSONObject.toString());
        activity.startActivity(intent);
        return true;
    }

    public final void preload(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        if (!this.isInit) {
            return;
        }
        ThreadManager.checkMainThread("preload");
        String nextPreloadUrl = getNextPreloadUrl();
        if (nextPreloadUrl == null) {
            return;
        }
        log(3, TAG, "start to preload webbundle. preloading = ", String.valueOf(getPreloadingCount(nextPreloadUrl)), ", preloaded = ", String.valueOf(getPreloadedCount(nextPreloadUrl)), ". preloadUrl = ", nextPreloadUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", WebBundleConstants.EVENT_TYPE_OF_PRELOAD_VIEW);
            jSONObject.put("url", WebBundleConstants.EVENT_ARGUMENT_OF_PRELOAD_TYPE);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        WebBundle webBundle = new WebBundle(context, this.mBizid);
        webBundle.startPreload(nextPreloadUrl, jSONObject, this);
        this.mPreloadingOne = webBundle;
    }

    public final void triggerPreload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            triggerPreload(0L);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public static WebBundleManager getInstance(String str) {
        WebBundleManager webBundleManager = sInstanceMap.get(str);
        if (webBundleManager == null) {
            synchronized (WebBundleManager.class) {
                webBundleManager = sInstanceMap.get(str);
                if (webBundleManager == null) {
                    webBundleManager = new WebBundleManager(str);
                    sInstanceMap.put(str, webBundleManager);
                }
            }
        }
        return webBundleManager;
    }

    public final void triggerPreload(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            ThreadManager.getUiHandler().postDelayed(new Runnable() { // from class: com.tencent.webbundle.sdk.WebBundleManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebBundleManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (WebBundleManager.this.isInit && WebBundleManager.this.runtime != null && WebBundleManager.this.runtime.getContext() != null) {
                        HybridIdleTaskHelper.getInstance().addIdleTask(new HybridIdleTaskHelper.PreloadWebBundleTask(WebBundleManager.this.runtime.getContext(), WebBundleManager.this.mBizid));
                    }
                }
            }, j3);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        }
    }

    public final void log(int i3, @NotNull String str, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), str, strArr);
            return;
        }
        if (strArr == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str2 : strArr) {
            sb5.append(str2);
        }
        log(i3, str, sb5.toString());
    }
}
