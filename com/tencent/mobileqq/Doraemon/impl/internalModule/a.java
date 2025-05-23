package com.tencent.mobileqq.Doraemon.impl.internalModule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.e;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static BroadcastReceiver f154199g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f154200h;

    /* renamed from: i, reason: collision with root package name */
    private static HashSet<WeakReference<a>> f154201i;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<a> f154202b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, com.tencent.mobileqq.Doraemon.a> f154203c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f154204d;

    /* renamed from: e, reason: collision with root package name */
    private String f154205e;

    /* renamed from: f, reason: collision with root package name */
    private String f154206f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.Doraemon.impl.internalModule.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C7081a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        C7081a() {
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
            Iterator it = a.f154201i.iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.k(context, intent);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66537);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f154199g = null;
        f154200h = false;
        f154201i = null;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f154204d = false;
        }
    }

    private static void f() {
        f154201i = new HashSet<>();
        f154199g = new C7081a();
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f154204d) {
            f154201i.remove(this.f154202b);
            if (f154201i.size() == 0) {
                f154200h = false;
                BaseApplicationImpl.getApplication().unregisterReceiver(f154199g);
            }
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public boolean c(int i3, String str, JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        boolean z16;
        boolean z17;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, jSONObject, aVar)).booleanValue();
        }
        String str3 = "";
        if (i3 != 1) {
            if (i3 != 4) {
                if (i3 != 23) {
                    return false;
                }
                String optString = jSONObject.optString("event", "");
                if (TextUtils.isEmpty(optString)) {
                    if (QLog.isColorLevel()) {
                        QLog.w("DoraemonOpenAPI.event", 2, "event name is required");
                    }
                    DoraemonUtil.c(aVar, -1, "event name is required");
                } else {
                    HashMap<String, com.tencent.mobileqq.Doraemon.a> hashMap = this.f154203c;
                    if (hashMap != null) {
                        hashMap.remove(optString);
                    }
                    DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
                }
            } else {
                try {
                    String optString2 = jSONObject.optString("event");
                    if (TextUtils.isEmpty(optString2)) {
                        if (QLog.isColorLevel()) {
                            QLog.w("DoraemonOpenAPI.event", 2, "event name is required");
                        }
                        DoraemonUtil.c(aVar, -1, "event name is required");
                    } else {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            str3 = optJSONObject.toString();
                        }
                        if (!TextUtils.isEmpty(str3) && str3.length() >= 460800) {
                            if (QLog.isColorLevel()) {
                                QLog.w("DoraemonOpenAPI.event", 2, "param data is over size");
                            }
                            DoraemonUtil.c(aVar, -2, "param data is over size");
                        } else {
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("options");
                            ArrayList<String> arrayList = new ArrayList<>();
                            if (optJSONObject2 != null) {
                                z17 = optJSONObject2.optBoolean("echo", true);
                                boolean optBoolean = optJSONObject2.optBoolean("broadcast", true);
                                JSONArray optJSONArray = optJSONObject2.optJSONArray("domains");
                                if (optJSONArray != null) {
                                    int length = optJSONArray.length();
                                    for (int i16 = 0; i16 < length; i16++) {
                                        String optString3 = optJSONArray.optString(i16);
                                        if (!TextUtils.isEmpty(optString3)) {
                                            arrayList.add(optString3);
                                        }
                                    }
                                }
                                z16 = optBoolean;
                            } else {
                                z16 = true;
                                z17 = true;
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("appid", this.f154095a.f154071c);
                            jSONObject2.put("appType", this.f154095a.f154070b);
                            if (arrayList.size() == 0) {
                                arrayList.add(j());
                            }
                            Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
                            intent.putExtra("broadcast", z16);
                            intent.putExtra("unique", i());
                            intent.putExtra("event", optString2);
                            if (optJSONObject != null) {
                                intent.putExtra("data", optJSONObject.toString());
                            }
                            intent.putStringArrayListExtra("domains", arrayList);
                            intent.putExtra("source", jSONObject2.toString());
                            if (QLog.isColorLevel()) {
                                Object[] objArr = new Object[5];
                                objArr[0] = toString();
                                objArr[1] = optString2;
                                if (optJSONObject != null) {
                                    str2 = optJSONObject.toString();
                                } else {
                                    str2 = "NULL";
                                }
                                objArr[2] = str2;
                                objArr[3] = TextUtils.join(",", arrayList);
                                objArr[4] = jSONObject2;
                                QLog.d("DoraemonOpenAPI.event", 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", objArr));
                            }
                            BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
                            if (z17) {
                                g(optString2, optJSONObject, jSONObject2);
                            }
                            DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
                        }
                    }
                } catch (Throwable th5) {
                    QLog.e("DoraemonOpenAPI.event", 1, th5.getMessage(), th5);
                    DoraemonUtil.c(aVar, -3, th5.getMessage());
                }
            }
            return true;
        }
        String optString4 = jSONObject.optString("event", "");
        if (TextUtils.isEmpty(optString4)) {
            if (QLog.isColorLevel()) {
                QLog.w("DoraemonOpenAPI.event", 2, "event name is required");
            }
            DoraemonUtil.c(aVar, -1, "event name is required");
        } else {
            h();
            this.f154203c.put(optString4, aVar);
            DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
        }
        return true;
    }

    protected void g(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        com.tencent.mobileqq.Doraemon.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, jSONObject, jSONObject2);
            return;
        }
        HashMap<String, com.tencent.mobileqq.Doraemon.a> hashMap = this.f154203c;
        if (hashMap == null) {
            aVar = null;
        } else {
            aVar = hashMap.get(str);
        }
        if (aVar != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("event", str);
                jSONObject3.put("data", jSONObject);
                jSONObject3.put("source", jSONObject2);
            } catch (JSONException e16) {
                QLog.e("DoraemonOpenAPI.event", 1, e16.getMessage(), e16);
            }
            DoraemonUtil.f(aVar, jSONObject3);
        }
    }

    protected void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f154204d) {
            return;
        }
        if (f154199g == null) {
            f();
        }
        if (!f154200h) {
            f154200h = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            BaseApplicationImpl.getApplication().registerReceiver(f154199g, intentFilter, "com.tencent.msg.permission.pushnotify", null);
        }
        this.f154204d = true;
        this.f154203c = new HashMap<>();
        WeakReference<a> weakReference = new WeakReference<>(this);
        this.f154202b = weakReference;
        f154201i.add(weakReference);
    }

    protected String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.f154205e == null) {
            this.f154205e = String.valueOf(System.currentTimeMillis()) + String.valueOf((int) (Math.random() * 1000000.0d));
        }
        return this.f154205e;
    }

    protected String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f154206f == null) {
            this.f154206f = this.f154095a.f154070b + "_" + this.f154095a.f154071c + ".virtual_host";
        }
        return this.f154206f;
    }

    protected void k(Context context, Intent intent) {
        JSONObject jSONObject;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent == null || !intent.getBooleanExtra("broadcast", true)) {
            return;
        }
        String stringExtra = intent.getStringExtra("unique");
        if (stringExtra != null && stringExtra.equals(i())) {
            return;
        }
        String stringExtra2 = intent.getStringExtra("event");
        if (TextUtils.isEmpty(stringExtra2)) {
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
        String j3 = j();
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[5];
            objArr[0] = toString();
            objArr[1] = stringExtra2;
            if (jSONObject != null) {
                str = jSONObject.toString();
            } else {
                str = "NULL";
            }
            objArr[2] = str;
            objArr[3] = TextUtils.join(",", stringArrayListExtra);
            objArr[4] = jSONObject2;
            QLog.d("DoraemonOpenAPI.event", 2, String.format("onReceive, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", objArr));
        }
        int size = stringArrayListExtra.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (AuthorizeConfig.P(stringArrayListExtra.get(i3), j3)) {
                g(stringExtra2, jSONObject, jSONObject2);
                return;
            }
        }
    }
}
