package b91;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.ark.ark;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends WebViewPlugin {
    private Context J;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f28071d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f28072e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private String f28073f = null;

    /* renamed from: h, reason: collision with root package name */
    private String f28074h = null;

    /* renamed from: i, reason: collision with root package name */
    private String f28075i = null;

    /* renamed from: m, reason: collision with root package name */
    private String f28076m = null;
    private String C = null;
    private String D = "";
    private ConcurrentHashMap<String, String> E = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> F = new ConcurrentHashMap<>();
    boolean G = false;
    private Dialog H = null;
    private int I = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: b91.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class ViewOnClickListenerC0110a implements View.OnClickListener {
        ViewOnClickListenerC0110a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.I == 0 && !TextUtils.isEmpty(a.this.f28073f)) {
                a.this.f28071d.put(a.this.f28074h, 1);
                WebViewProvider f16 = a.this.mRuntime.f();
                if (f16 != null) {
                    f16.getWebView().loadUrl(a.this.f28073f);
                }
                a.this.f28073f = null;
            }
            a.this.H.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.I == 0 && !TextUtils.isEmpty(a.this.f28074h)) {
                a.this.f28073f = null;
            }
            a.this.H.dismiss();
        }
    }

    private void y(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ArkPlugin", 1, "decodeArkH5Config, keywordCfgJsonStr is empty");
            return;
        }
        this.E.clear();
        this.F.clear();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("web-view-jump-web-config");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("web-view-open-app-config");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    Object obj = optJSONObject.get(str2);
                    if ((obj instanceof String) && obj != null) {
                        this.E.put(str2, (String) obj);
                    }
                }
            }
            if (optJSONObject2 != null) {
                Iterator keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String str3 = (String) keys2.next();
                    Object obj2 = optJSONObject2.get(str3);
                    if ((obj2 instanceof String) && obj2 != null) {
                        this.F.put(str3, (String) obj2);
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e("ArkPlugin", 1, String.format("decodeArkH5Config, parse json failed, err=%s", e16.getMessage()));
        }
    }

    protected boolean A(String str, String str2) {
        int lastIndexOf;
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (lastIndexOf = str.lastIndexOf(str2)) >= 0 && lastIndexOf == str.length() - str2.length();
    }

    protected void B() {
        Activity a16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || (a16 = bVar.a()) == null || a16.isFinishing()) {
            return;
        }
        QQToast.makeText(a16, HardCodeUtil.qqStr(R.string.jqj), 0).show();
    }

    Context getCurrentContext() {
        Activity a16 = this.mRuntime.a();
        while (a16 != null && (a16 instanceof BasePluginActivity)) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "lightapp";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 16L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.J = getCurrentContext();
    }

    protected String v(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean w(String str) {
        boolean z16;
        String str2;
        ark.Application Create;
        Integer num;
        boolean z17 = 1;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String v3 = v(str);
        if (TextUtils.isEmpty(v3)) {
            return true;
        }
        this.f28074h = v3;
        if (this.f28071d.containsKey(v3) && (num = this.f28071d.get(this.f28074h)) != null) {
            if (num.intValue() == 1) {
                return false;
            }
            if (num.intValue() == 0) {
                B();
                return true;
            }
        }
        z();
        WebViewProvider f16 = this.mRuntime.f();
        if (A(this.f28074h, v(f16 != null ? f16.getUrlFromIntent() : null))) {
            this.f28071d.put(this.f28074h, 1);
            return false;
        }
        this.f28073f = str;
        Dialog dialog = this.H;
        if (dialog != null && dialog.isShowing()) {
            return true;
        }
        this.I = 0;
        ConcurrentHashMap<String, String> concurrentHashMap = this.E;
        if (concurrentHashMap != null) {
            for (String str3 : concurrentHashMap.keySet()) {
                if (!TextUtils.isEmpty(this.C) && str3.equals(this.C)) {
                    str2 = this.E.get(str3);
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        str2 = "ask";
        if (!str2.equals("allow")) {
            if (str2.equals("ask")) {
                if (!z16 && !TextUtils.isEmpty(this.f28075i) && (Create = ark.Application.Create(this.C, this.D, this.f28075i)) != null && !TextUtils.isEmpty(str)) {
                    boolean CheckUrlLegality = Create.CheckUrlLegality(str);
                    Create.Release();
                    if (CheckUrlLegality) {
                        this.f28071d.put(this.f28074h, 1);
                        return false;
                    }
                }
                Activity a16 = this.mRuntime.a();
                if (a16 != null && !a16.isFinishing()) {
                    x(a16.getString(R.string.f170464rw));
                    Dialog dialog2 = this.H;
                    if (dialog2 != null) {
                        dialog2.show();
                    }
                }
                return true;
            }
            if (str2.equals("forbidden")) {
                B();
                this.f28071d.put(this.f28074h, Integer.valueOf(!z17));
                return z17;
            }
        }
        z17 = 0;
        this.f28071d.put(this.f28074h, Integer.valueOf(!z17));
        return z17;
    }

    protected void x(String str) {
        Dialog dialog = this.H;
        if (dialog == null) {
            Dialog dialog2 = new Dialog(QBaseActivity.sTopActivity, R.style.qZoneInputDialog);
            this.H = dialog2;
            dialog2.setContentView(R.layout.f167856jn);
            TextView textView = (TextView) this.H.findViewById(R.id.dialogTitle);
            TextView textView2 = (TextView) this.H.findViewById(R.id.dialogText);
            TextView textView3 = (TextView) this.H.findViewById(R.id.dialogLeftBtn);
            TextView textView4 = (TextView) this.H.findViewById(R.id.dialogRightBtn);
            textView.setText(R.string.f173206i10);
            if (!TextUtils.isEmpty(str)) {
                textView2.setText(str);
            }
            textView4.setText(R.string.igh);
            textView4.setOnClickListener(new ViewOnClickListenerC0110a());
            textView3.setOnClickListener(new b());
            textView3.setText(R.string.cancel);
            return;
        }
        TextView textView5 = (TextView) dialog.findViewById(R.id.dialogText);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        textView5.setText(str);
    }

    protected void z() {
        Bundle arguments;
        Bundle extras;
        if (this.G) {
            return;
        }
        try {
            l91.a.a();
        } catch (Exception e16) {
            QLog.e("ArkPlugin", 1, String.format("setupArkEnvironment error, err=%s", e16.getMessage()));
        }
        WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
        if (webViewFragment == null || (arguments = webViewFragment.getArguments()) == null || (extras = ((Intent) arguments.getParcelable("intent")).getExtras()) == null) {
            return;
        }
        this.C = extras.getString(AppConstants.Key.H5_ARK_APP_NAME);
        this.D = extras.getString(AppConstants.Key.H5_ARK_BIZ_SRC, "");
        this.f28075i = extras.getString(AppConstants.Key.H5_ARK_APP_PATH);
        this.f28076m = extras.getString(AppConstants.Key.H5_ARK_APP_DESCRIPTION);
        y(extras.getString(AppConstants.Key.H5_ARK_CHECK_CONFIG));
        this.G = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 16) {
            return w(str);
        }
        return false;
    }
}
