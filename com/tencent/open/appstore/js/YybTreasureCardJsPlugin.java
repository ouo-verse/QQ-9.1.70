package com.tencent.open.appstore.js;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.TreasureCardJsPlugin;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.base.f;
import com.tencent.open.business.base.c;
import com.tencent.open.business.base.d;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* loaded from: classes22.dex */
public class YybTreasureCardJsPlugin extends BaseInterface implements c {

    /* renamed from: d, reason: collision with root package name */
    private Handler f340894d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private Activity f340895e;

    /* renamed from: f, reason: collision with root package name */
    private WebView f340896f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<AppRuntime> f340897h;

    public YybTreasureCardJsPlugin(Activity activity, WebView webView) {
        AppRuntime appRuntime;
        this.f340895e = activity;
        this.f340896f = webView;
        AppRuntime appRuntime2 = null;
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (activity instanceof PublicFragmentActivityForTool) {
            appRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        } else if (activity instanceof BaseActivity) {
            appRuntime = ((BaseActivity) activity).getAppRuntime();
        } else {
            if (activity instanceof mqq.app.BaseActivity) {
                appRuntime = ((mqq.app.BaseActivity) activity).getAppRuntime();
            }
            this.f340897h = new WeakReference<>(appRuntime2);
            d.a().c(this);
        }
        appRuntime2 = appRuntime;
        this.f340897h = new WeakReference<>(appRuntime2);
        d.a().c(this);
    }

    private void jsCallBack(final String str) {
        this.f340894d.post(new Runnable() { // from class: com.tencent.open.appstore.js.YybTreasureCardJsPlugin.1

            /* renamed from: com.tencent.open.appstore.js.YybTreasureCardJsPlugin$1$a */
            /* loaded from: classes22.dex */
            class a implements ValueCallback<String> {
                a() {
                }

                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str) {
                    f.e(TreasureCardJsPlugin.TAG, "[jsCallBack]:" + str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    YybTreasureCardJsPlugin.this.f340896f.evaluateJavascript(str, new a());
                } catch (Exception e16) {
                    f.b(TreasureCardJsPlugin.TAG, "[jsCallBack] e>>> ", e16);
                }
            }
        });
    }

    public void clearSimCache(String str) {
        try {
            boolean clearCacheAndRequest = VasUtil.getService(this.f340897h.get()).getVasFtManager().clearCacheAndRequest();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Const.BUNDLE_KEY_REQUEST, clearCacheAndRequest);
            f.e(TreasureCardJsPlugin.TAG, TreasureCardJsPlugin.BUSINESS_NAME + str + " request:" + jSONObject);
            jsCallBack(a.JAVASCRIPT_PREFIX + str + "(" + jSONObject.toString() + ")");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public void destroy() {
        d.a().d(this);
        super.destroy();
    }

    public void freeTrafficCardModel(String str, String str2) {
        try {
            IVasFTManager vasFtManager = VasUtil.getService(this.f340897h.get()).getVasFtManager();
            JSONObject json = vasFtManager.obtainCardInfo(str2).toJson();
            json.put("cardStates", vasFtManager.obtainCardState(str2));
            f.e(TreasureCardJsPlugin.TAG, TreasureCardJsPlugin.BUSINESS_NAME + str + " jsonObject:" + json.toString());
            jsCallBack(a.JAVASCRIPT_PREFIX + str + "(" + json.toString() + ")");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public String getInterfaceName() {
        return "yyb_treasureCard";
    }

    @Override // com.tencent.open.business.base.c
    public String getJsCallbackMethod() {
        return null;
    }

    @Override // com.tencent.open.business.base.c
    public WebView getWebview() {
        return this.f340896f;
    }

    public void tcardModel(String str, String str2) {
        try {
            IVasFTManager vasFtManager = VasUtil.getService(this.f340897h.get()).getVasFtManager();
            JSONObject json = vasFtManager.obtainCardInfo(str2).toJson();
            json.put("mobileCardStates", vasFtManager.treasureCardState(str2));
            f.e(TreasureCardJsPlugin.TAG, TreasureCardJsPlugin.BUSINESS_NAME + str + " jsonObject:" + json.toString());
            jsCallBack(a.JAVASCRIPT_PREFIX + str + "(" + json.toString() + ")");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
