package com.qq.e.tg.jsbridge;

import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.qq.e.comm.pi.JsCallback;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.tangram.TangramAdManager;
import com.qq.e.tg.tangram.action.TangramAdActionTrigger;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TangramJSInterface {

    /* renamed from: a, reason: collision with root package name */
    private JsCallback f40531a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f40532b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<View> f40533c;

    public static String getJSInterfaceServiceName() {
        return "TangramJSInterface";
    }

    @JavascriptInterface
    public void handleMessage(String str) {
        View view;
        if (!TextUtils.isEmpty(str)) {
            GDTLogger.d("TangramJSInterfacemessage length:" + str.length());
        }
        if (TangramAdManager.getInstance() != null && TangramAdManager.getInstance().getAdActionTrigger() != null) {
            TangramAdActionTrigger adActionTrigger = TangramAdManager.getInstance().getAdActionTrigger();
            WeakReference<View> weakReference = this.f40533c;
            if (weakReference != null) {
                view = weakReference.get();
            } else {
                view = null;
            }
            adActionTrigger.handleJs(view, this.f40532b, str, this.f40531a);
        }
    }

    public TangramJSInterface setAdInfo(JSONObject jSONObject) {
        this.f40532b = jSONObject;
        return this;
    }

    public TangramJSInterface setJsCallback(JsCallback jsCallback) {
        this.f40531a = jsCallback;
        return this;
    }

    public TangramJSInterface setWebView(WeakReference<View> weakReference) {
        this.f40533c = weakReference;
        return this;
    }
}
