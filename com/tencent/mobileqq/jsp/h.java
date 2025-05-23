package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.manager.MonitorManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static volatile BroadcastReceiver f238873f;

    /* renamed from: h, reason: collision with root package name */
    public static AtomicBoolean f238874h;

    /* renamed from: i, reason: collision with root package name */
    public static CopyOnWriteArrayList<WeakReference<h>> f238875i;

    /* renamed from: d, reason: collision with root package name */
    String f238876d;

    /* renamed from: e, reason: collision with root package name */
    WeakReference<h> f238877e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            CopyOnWriteArrayList<WeakReference<h>> copyOnWriteArrayList = h.f238875i;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                Iterator<WeakReference<h>> it = h.f238875i.iterator();
                while (it.hasNext()) {
                    h hVar = it.next().get();
                    if (hVar != null) {
                        hVar.v(context, intent);
                    }
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72643);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f238873f = null;
        f238874h = new AtomicBoolean(false);
        f238875i = null;
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f238876d = "";
            this.f238877e = null;
        }
    }

    private static void t() {
        f238873f = new a();
        if (QLog.isColorLevel()) {
            QLog.d("EventApiPlugin", 2, "init dispatch Event Receiver!");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        intentFilter.addAction("com.tencent.mobileqq.action.closewebview");
        BaseApplicationImpl.getApplication().registerReceiver(f238873f, intentFilter, "com.tencent.msg.permission.pushnotify", null);
        if (f238875i == null) {
            f238875i = new CopyOnWriteArrayList<>();
        }
    }

    private boolean u() {
        Iterator<WeakReference<h>> it = f238875i.iterator();
        while (it.hasNext()) {
            if (it.next().get() == this) {
                return true;
            }
        }
        return false;
    }

    public static void w(String str, JSONObject jSONObject, ArrayList<String> arrayList, String str2) {
        Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        intent.putExtra("event", str);
        if (jSONObject != null) {
            intent.putExtra("data", jSONObject.toString());
        }
        intent.putStringArrayListExtra("domains", arrayList);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str2);
        } catch (JSONException unused) {
        }
        intent.putExtra("source", jSONObject2.toString());
        BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
    }

    public static void x() {
        if (QLog.isColorLevel()) {
            QLog.d("EventApiPlugin", 2, "unRegisterEventReceiver");
        }
        CopyOnWriteArrayList<WeakReference<h>> copyOnWriteArrayList = f238875i;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        if (f238873f != null && f238874h.compareAndSet(true, false)) {
            BaseApplicationImpl.getApplication().unregisterReceiver(f238873f);
            f238873f = null;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "event";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, str, Long.valueOf(j3), map)).booleanValue();
        }
        if (j3 == 8589934606L) {
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    jSONObject.put(HippyTKDListViewAdapter.X, (Integer) map.get("X"));
                    jSONObject.put("y", (Integer) map.get("Y"));
                } catch (ClassCastException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EventApiPlugin", 2, "ClassCastException, " + map.get("X") + ", " + map.get("Y"));
                    }
                    e16.printStackTrace();
                } catch (JSONException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EventApiPlugin", 2, "JSONException, " + map.get("X") + ", " + map.get("Y"));
                    }
                    e17.printStackTrace();
                }
            }
            dispatchJsEvent("qbrowserTitleBarClick", jSONObject, null);
            return true;
        }
        if (j3 != 8589934607L) {
            return false;
        }
        dispatchJsEvent("qbrowserOptionsButtonClick", null, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (!"event".equals(str2)) {
            return false;
        }
        if ("dispatchEvent".equals(str3) && strArr.length == 1 && this.f238877e != null) {
            try {
                CustomWebView e16 = this.mRuntime.e();
                if (e16 == null) {
                    return true;
                }
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("event");
                if (TextUtils.isEmpty(optString)) {
                    if (QLog.isColorLevel()) {
                        QLog.w("EventApiPlugin", 2, "param event is requested");
                    }
                    return true;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                String jSONObject2 = optJSONObject != null ? optJSONObject.toString() : "";
                if (!TextUtils.isEmpty(jSONObject2) && jSONObject2.length() >= 460800) {
                    QLog.e("EventApiPlugin", 1, "param data is over size! " + jSONObject2.length());
                    return true;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("options");
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList<String> arrayList2 = new ArrayList<>();
                String url = e16.getUrl();
                if (optJSONObject2 != null) {
                    boolean optBoolean = optJSONObject2.optBoolean("echo", true);
                    boolean optBoolean2 = optJSONObject2.optBoolean("broadcast", true);
                    JSONArray optJSONArray = optJSONObject2.optJSONArray("domains");
                    if (optJSONArray != null) {
                        z18 = optBoolean;
                        int length = optJSONArray.length();
                        str4 = "";
                        int i3 = 0;
                        while (i3 < length) {
                            int i16 = length;
                            String optString2 = optJSONArray.optString(i3);
                            if (!TextUtils.isEmpty(optString2)) {
                                arrayList.add(optString2);
                            }
                            i3++;
                            length = i16;
                        }
                    } else {
                        z18 = optBoolean;
                        str4 = "";
                    }
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("platos");
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i17 = 0; i17 < length2; i17++) {
                            String optString3 = optJSONArray2.optString(i17);
                            if (!TextUtils.isEmpty(optString3)) {
                                arrayList2.add(optString3);
                            }
                        }
                    }
                    z17 = z18;
                    z16 = optBoolean2;
                } else {
                    str4 = "";
                    z16 = true;
                    z17 = true;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", url);
                if (arrayList.size() == 0 && url != null) {
                    Uri parse = Uri.parse(url);
                    if (parse.isHierarchical()) {
                        arrayList.add(parse.getHost());
                    }
                }
                Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
                intent.putExtra("broadcast", z16);
                intent.putExtra("unique", y());
                intent.putExtra("event", optString);
                if (optJSONObject != null) {
                    intent.putExtra("data", optJSONObject.toString());
                }
                intent.putStringArrayListExtra("domains", arrayList);
                intent.putStringArrayListExtra("platos", arrayList2);
                intent.putExtra("source", jSONObject3.toString());
                if (QLog.isColorLevel()) {
                    Object[] objArr = new Object[5];
                    objArr[0] = this.f238877e.toString();
                    objArr[1] = optString;
                    objArr[2] = optJSONObject != null ? optJSONObject.toString() : "NULL";
                    objArr[3] = TextUtils.join(",", arrayList);
                    objArr[4] = jSONObject3;
                    QLog.d("EventApiPlugin", 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", objArr));
                }
                BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
                if (z17) {
                    dispatchJsEvent(optString, optJSONObject, jSONObject3);
                }
                if (!"cancelPayDialog".equals(optString)) {
                    return true;
                }
                MonitorManager.f().j(1, 6, "\u53d6\u6d88\u652f\u4ed8", str4);
                return true;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return true;
            }
        }
        if (!"miuiInstallInterceptor".equals(str3)) {
            return true;
        }
        if (strArr.length < 1 && QLog.isColorLevel()) {
            QLog.e("EventApiPlugin", 2, "no arguments.");
            return true;
        }
        s(strArr[0]);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (f238874h.compareAndSet(false, true)) {
            try {
                t();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("EventApiPlugin", 2, "error:" + e16.toString());
                }
            }
        }
        if (f238873f != null && f238875i != null && !u()) {
            WeakReference<h> weakReference = new WeakReference<>(this);
            this.f238877e = weakReference;
            f238875i.add(weakReference);
            if (QLog.isColorLevel()) {
                QLog.d("EventApiPlugin", 2, "put current EventApiPlugin into sDispatchEventPlugins: " + this.f238877e.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        if (this.f238877e != null && f238875i != null) {
            if (QLog.isColorLevel()) {
                QLog.d("EventApiPlugin", 2, "remove current EventApiPlugin from sDispatchEventPlugins: " + this.f238877e.toString());
            }
            f238875i.remove(this.f238877e);
            this.f238877e = null;
        }
    }

    Bundle p(JSONObject jSONObject) throws JSONException {
        Iterator keys = jSONObject.keys();
        if (keys != null) {
            Bundle bundle = new Bundle();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!TextUtils.isEmpty(str)) {
                    bundle.putCharSequence(str, jSONObject.getString(str));
                }
            }
            return bundle;
        }
        return null;
    }

    ComponentName q(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("/")) != null && split.length == 2) {
            return new ComponentName(split[0], split[1]);
        }
        return null;
    }

    Intent r(JSONObject jSONObject) throws JSONException {
        Bundle p16;
        if (jSONObject == null) {
            return null;
        }
        Intent intent = new Intent();
        String optString = jSONObject.optString("action", "");
        if (!TextUtils.isEmpty(optString)) {
            intent.setAction(optString);
        }
        String optString2 = jSONObject.optString("category", "");
        if (!TextUtils.isEmpty(optString2)) {
            intent.addCategory(optString2);
        }
        String optString3 = jSONObject.optString("componentName", "");
        if (!TextUtils.isEmpty(optString3)) {
            intent.setComponent(q(optString3));
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("intentExtras");
        if (jSONObject2 != null && (p16 = p(jSONObject2)) != null) {
            intent.putExtras(p16);
        }
        return intent;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0096 -> B:16:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0098 -> B:16:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0078 -> B:16:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007a -> B:16:0x00ae). Please report as a decompilation issue!!! */
    void s(String str) {
        WebViewPlugin.b bVar;
        if (Build.MANUFACTURER.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("EventApiPlugin", 2, "handleMiUIInstallIntercepterEvent,finger print:" + Build.FINGERPRINT + ",config:" + str);
            }
            try {
                Intent r16 = r(new JSONObject(str));
                if (r16 != null && (bVar = this.mRuntime) != null) {
                    Activity a16 = bVar.a();
                    if (a16 != null) {
                        a16.startActivity(r16);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("EventApiPlugin", 2, "activity is null.");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("EventApiPlugin", 2, "intent or runtime is null");
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("EventApiPlugin", 2, "error:" + e16.toString());
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("EventApiPlugin", 2, "error:" + e17.toString());
                }
            }
        }
    }

    public void v(Context context, Intent intent) {
        WeakReference<h> weakReference;
        JSONObject jSONObject;
        String url;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent == null || (weakReference = this.f238877e) == null || weakReference.get() == null || !intent.getBooleanExtra("broadcast", true)) {
            return;
        }
        String stringExtra = intent.getStringExtra("unique");
        if (stringExtra != null && stringExtra.equals(y())) {
            return;
        }
        String stringExtra2 = intent.getStringExtra("event");
        if (TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        if (stringExtra2.equals("closeWebView")) {
            Activity a16 = this.mRuntime.a();
            if (a16 != null) {
                a16.finish();
                return;
            }
            return;
        }
        String stringExtra3 = intent.getStringExtra("data");
        JSONObject jSONObject2 = null;
        if (stringExtra3 != null) {
            try {
                jSONObject = new JSONObject(stringExtra3);
            } catch (JSONException unused) {
                return;
            }
        } else {
            jSONObject = null;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("domains");
        if (stringArrayListExtra == null) {
            return;
        }
        String stringExtra4 = intent.getStringExtra("source");
        if (stringExtra4 != null) {
            try {
                jSONObject2 = new JSONObject(stringExtra4);
            } catch (JSONException unused2) {
                return;
            }
        }
        CustomWebView e16 = this.mRuntime.e();
        if (e16 == null || (url = e16.getUrl()) == null) {
            return;
        }
        String host = Uri.parse(url).getHost();
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[5];
            objArr[0] = this.f238877e.toString();
            objArr[1] = stringExtra2;
            if (jSONObject != null) {
                str = jSONObject.toString();
            } else {
                str = "NULL";
            }
            objArr[2] = str;
            objArr[3] = TextUtils.join(",", stringArrayListExtra);
            objArr[4] = jSONObject2;
            QLog.d("EventApiPlugin", 2, String.format("onReceive, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", objArr));
        }
        if ((!stringExtra2.equals("follow") && !stringExtra2.equals(IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW)) || (!AuthorizeConfig.y().F(url, "publicAccount.isFollowUin") && !AuthorizeConfig.y().F(url, "data.isFollowUin"))) {
            int size = stringArrayListExtra.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (AuthorizeConfig.P(stringArrayListExtra.get(i3), host)) {
                    dispatchJsEvent(stringExtra2, jSONObject, jSONObject2);
                    return;
                }
            }
            return;
        }
        dispatchJsEvent(stringExtra2, jSONObject, jSONObject2);
    }

    String y() {
        if (!TextUtils.isEmpty(this.f238876d)) {
            return this.f238876d;
        }
        Activity a16 = this.mRuntime.a();
        if (a16 != null) {
            this.f238876d = String.valueOf(System.currentTimeMillis()) + String.valueOf(a16.hashCode());
        } else {
            this.f238876d = String.valueOf(System.currentTimeMillis()) + String.valueOf((int) (Math.random() * 1000000.0d));
        }
        return this.f238876d;
    }
}
