package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final String f36906e = "a";

    /* renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f36907a;

    /* renamed from: b, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f36908b;

    /* renamed from: c, reason: collision with root package name */
    private h f36909c;

    /* renamed from: d, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f36910d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.huawei.hms.framework.network.grs.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0259a implements com.huawei.hms.framework.network.grs.b {

        /* renamed from: a, reason: collision with root package name */
        String f36911a;

        /* renamed from: b, reason: collision with root package name */
        Map<String, String> f36912b;

        /* renamed from: c, reason: collision with root package name */
        IQueryUrlsCallBack f36913c;

        /* renamed from: d, reason: collision with root package name */
        Context f36914d;

        /* renamed from: e, reason: collision with root package name */
        GrsBaseInfo f36915e;

        /* renamed from: f, reason: collision with root package name */
        com.huawei.hms.framework.network.grs.e.a f36916f;

        C0259a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f36911a = str;
            this.f36912b = map;
            this.f36913c = iQueryUrlsCallBack;
            this.f36914d = context;
            this.f36915e = grsBaseInfo;
            this.f36916f = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Map<String, String> map = this.f36912b;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f36911a, StringUtils.anonymizeMessage(new JSONObject(this.f36912b).toString()));
                this.f36913c.onCallBackSuccess(this.f36912b);
                return;
            }
            if (this.f36912b == null) {
                Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                Map<String, String> a16 = com.huawei.hms.framework.network.grs.f.b.a(this.f36914d.getPackageName(), this.f36915e).a(this.f36914d, this.f36916f, this.f36915e, this.f36911a, true);
                if (a16 == null || a16.isEmpty()) {
                    Logger.e(a.f36906e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f36911a);
                }
                if (a16 == null) {
                    a16 = new ConcurrentHashMap<>();
                }
                Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f36911a, StringUtils.anonymizeMessage(new JSONObject(a16).toString()));
                this.f36913c.onCallBackSuccess(a16);
                return;
            }
            Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrls\uff1aReturn [%s] Urls is Empty", this.f36911a);
            this.f36913c.onCallBackFail(-3);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            IQueryUrlsCallBack iQueryUrlsCallBack;
            String j3 = dVar.j();
            Map<String, String> a16 = a.a(j3, this.f36911a);
            if (a16.isEmpty()) {
                Map<String, String> map = this.f36912b;
                if (map == null || map.isEmpty()) {
                    if (this.f36912b == null) {
                        if (!TextUtils.isEmpty(j3)) {
                            Logger.e(a.f36906e, "The serviceName[%s] is not configured on the GRS server.", this.f36911a);
                        }
                        Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                        Map<String, String> a17 = com.huawei.hms.framework.network.grs.f.b.a(this.f36914d.getPackageName(), this.f36915e).a(this.f36914d, this.f36916f, this.f36915e, this.f36911a, true);
                        if (a17 == null || a17.isEmpty()) {
                            Logger.e(a.f36906e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f36911a);
                        }
                        if (a17 == null) {
                            a17 = new ConcurrentHashMap<>();
                        }
                        Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f36911a, StringUtils.anonymizeMessage(new JSONObject(a17).toString()));
                        this.f36913c.onCallBackSuccess(a17);
                        return;
                    }
                    Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrls\uff1aReturn [%s] Urls is Empty", this.f36911a);
                    this.f36913c.onCallBackFail(-5);
                    return;
                }
                Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", this.f36911a, StringUtils.anonymizeMessage(new JSONObject(this.f36912b).toString()));
                iQueryUrlsCallBack = this.f36913c;
                a16 = this.f36912b;
            } else {
                Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", this.f36911a, StringUtils.anonymizeMessage(new JSONObject(a16).toString()));
                iQueryUrlsCallBack = this.f36913c;
            }
            iQueryUrlsCallBack.onCallBackSuccess(a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b implements com.huawei.hms.framework.network.grs.b {

        /* renamed from: a, reason: collision with root package name */
        String f36917a;

        /* renamed from: b, reason: collision with root package name */
        String f36918b;

        /* renamed from: c, reason: collision with root package name */
        IQueryUrlCallBack f36919c;

        /* renamed from: d, reason: collision with root package name */
        String f36920d;

        /* renamed from: e, reason: collision with root package name */
        Context f36921e;

        /* renamed from: f, reason: collision with root package name */
        GrsBaseInfo f36922f;

        /* renamed from: g, reason: collision with root package name */
        com.huawei.hms.framework.network.grs.e.a f36923g;

        b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f36917a = str;
            this.f36918b = str2;
            this.f36919c = iQueryUrlCallBack;
            this.f36920d = str3;
            this.f36921e = context;
            this.f36922f = grsBaseInfo;
            this.f36923g = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            if (!TextUtils.isEmpty(this.f36920d)) {
                Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f36917a, this.f36918b, StringUtils.anonymizeMessage(this.f36920d));
                this.f36919c.onCallBackSuccess(this.f36920d);
                return;
            }
            if (TextUtils.isEmpty(this.f36920d)) {
                Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                String a16 = com.huawei.hms.framework.network.grs.f.b.a(this.f36921e.getPackageName(), this.f36922f).a(this.f36921e, this.f36923g, this.f36922f, this.f36917a, this.f36918b, true);
                if (a16 == null || a16.isEmpty()) {
                    Logger.e(a.f36906e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f36917a, this.f36918b);
                }
                Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f36917a, this.f36918b, StringUtils.anonymizeMessage(a16));
                this.f36919c.onCallBackSuccess(a16);
                return;
            }
            Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrl\uff1aReturn [%s][%s] Url is Empty", this.f36917a, this.f36918b);
            this.f36919c.onCallBackFail(-3);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            IQueryUrlCallBack iQueryUrlCallBack;
            String str;
            String j3 = dVar.j();
            Map<String, String> a16 = a.a(j3, this.f36917a);
            if (a16.containsKey(this.f36918b)) {
                String str2 = a.f36906e;
                String str3 = this.f36918b;
                Logger.i(str2, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", this.f36917a, str3, StringUtils.anonymizeMessage(a16.get(str3)));
                iQueryUrlCallBack = this.f36919c;
                str = a16.get(this.f36918b);
            } else {
                if (TextUtils.isEmpty(this.f36920d)) {
                    if (TextUtils.isEmpty(this.f36920d)) {
                        if (!TextUtils.isEmpty(j3)) {
                            Logger.e(a.f36906e, "The serviceName[%s][%s] is not configured on the GRS server.", this.f36917a, this.f36918b);
                        }
                        Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                        String a17 = com.huawei.hms.framework.network.grs.f.b.a(this.f36921e.getPackageName(), this.f36922f).a(this.f36921e, this.f36923g, this.f36922f, this.f36917a, this.f36918b, true);
                        if (a17 == null || a17.isEmpty()) {
                            Logger.e(a.f36906e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f36917a, this.f36918b);
                        }
                        Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f36917a, this.f36918b, StringUtils.anonymizeMessage(a17));
                        this.f36919c.onCallBackSuccess(a17);
                        return;
                    }
                    Logger.i(a.f36906e, "GrsClientManager.ayncGetGrsUrl\uff1aReturn [%s][%s] Url is Empty", this.f36917a, this.f36918b);
                    this.f36919c.onCallBackFail(-5);
                    return;
                }
                String str4 = a.f36906e;
                String str5 = this.f36918b;
                Logger.i(str4, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f36917a, str5, StringUtils.anonymizeMessage(a16.get(str5)));
                iQueryUrlCallBack = this.f36919c;
                str = this.f36920d;
            }
            iQueryUrlCallBack.onCallBackSuccess(str);
        }
    }

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar, h hVar, com.huawei.hms.framework.network.grs.e.c cVar) {
        this.f36907a = grsBaseInfo;
        this.f36908b = aVar;
        this.f36909c = hVar;
        this.f36910d = cVar;
    }

    public static CountryCodeBean a(Context context, boolean z16) {
        return new CountryCodeBean(context, z16);
    }

    public String a(Context context, String str) {
        com.huawei.hms.framework.network.grs.g.d a16 = this.f36909c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.f36907a, context), str, this.f36910d);
        return a16 == null ? "" : a16.m() ? this.f36908b.a().a(this.f36907a.getGrsParasKey(true, true, context), "") : a16.j();
    }

    public String a(String str, String str2, Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str3 = a(str, bVar, context).get(str2);
        if (bVar.a() && !TextUtils.isEmpty(str3)) {
            Logger.i(f36906e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            return str3;
        }
        String a16 = a(context, str);
        String str4 = a(a16, str).get(str2);
        if (!TextUtils.isEmpty(str4)) {
            Logger.i(f36906e, "GrsClientManager.synGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str4));
            return str4;
        }
        if (TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(a16)) {
                Logger.e(f36906e, "The serviceName[%s][%s] is not configured on the GRS server.", str, str2);
            }
            String str5 = f36906e;
            Logger.i(str5, "GrsClientManager.synGetGrsUrl: Get URL from Local JSON File.");
            str3 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.f36907a).a(context, this.f36908b, this.f36907a, str, str2, true);
            if (str3 == null || str3.isEmpty()) {
                Logger.e(str5, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", str, str2);
            }
        }
        Logger.i(f36906e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
        return str3;
    }

    public static Map<String, Map<String, String>> a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(f36906e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                if (!TextUtils.isEmpty(str2)) {
                    concurrentHashMap.put(str2, a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e16) {
            Logger.w(f36906e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e16.getMessage()));
            return concurrentHashMap;
        }
    }

    public Map<String, String> a(String str, Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> a16 = a(str, bVar, context);
        if (bVar.a() && !a16.isEmpty()) {
            Logger.i(f36906e, "Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(a16).toString()));
            return a16;
        }
        String a17 = a(context, str);
        Map<String, String> a18 = a(a17, str);
        if (!a18.isEmpty()) {
            Logger.i(f36906e, "GrsClientManager.synGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(a18).toString()));
            return a18;
        }
        if (a16.isEmpty()) {
            if (!TextUtils.isEmpty(a17)) {
                Logger.e(f36906e, "The serviceName[%s] is not configured on the GRS server.", str);
            }
            String str2 = f36906e;
            Logger.i(str2, "GrsClientManager.synGetGrsUrls: Get URL from Local JSON File.");
            a16 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.f36907a).a(context, this.f36908b, this.f36907a, str, true);
            if (a16 == null || a16.isEmpty()) {
                Logger.e(str2, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", str);
            }
        }
        String str3 = f36906e;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = StringUtils.anonymizeMessage(a16 != null ? new JSONObject(a16).toString() : "");
        Logger.i(str3, "GrsClientManager.synGetGrsUrls: Return [%s] Urls: %s", objArr);
        return a16;
    }

    private Map<String, String> a(String str, com.huawei.hms.framework.network.grs.e.b bVar, Context context) {
        Map<String, String> a16 = this.f36908b.a(this.f36907a, str, bVar, context);
        if (a16 != null && !a16.isEmpty()) {
            Logger.i(f36906e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
            return a16;
        }
        Map<String, String> a17 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.f36907a).a(context, this.f36908b, this.f36907a, str, false);
        Logger.i(f36906e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
        return a17 != null ? a17 : new HashMap();
    }

    public static Map<String, String> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.w(f36906e, "isSpExpire jsonValue from server is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.w(f36906e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return hashMap;
            }
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                hashMap.put(str3, jSONObject2.get(str3).toString());
            }
            return hashMap;
        } catch (JSONException e16) {
            Logger.w(f36906e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e16.getMessage()));
            return hashMap;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String obj = jSONObject.get(str).toString();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(obj)) {
                    concurrentHashMap.put(str, obj);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e16) {
            Logger.w(f36906e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e16.getMessage()));
            return concurrentHashMap;
        }
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> a16 = a(str, bVar, context);
        if (!bVar.a()) {
            this.f36909c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.f36907a, context), new C0259a(str, a16, iQueryUrlsCallBack, context, this.f36907a, this.f36908b), str, this.f36910d);
            return;
        }
        if (a16.isEmpty()) {
            Logger.i(f36906e, "GrsClientManager.ayncGetGrsUrls\uff1aReturn [%s] Urls is Empty", str);
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            String str2 = f36906e;
            Logger.i(str2, "GrsClientManager.ayncGetGrsUrls\uff1aReturn [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(a16).toString()));
            Logger.i(str2, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(a16).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(a16);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str3 = a(str, bVar, context).get(str2);
        if (!bVar.a()) {
            this.f36909c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.f36907a, context), new b(str, str2, iQueryUrlCallBack, str3, context, this.f36907a, this.f36908b), str, this.f36910d);
        } else if (TextUtils.isEmpty(str3)) {
            Logger.i(f36906e, "GrsClientManager.ayncGetGrsUrl\uff1aReturn [%s][%s] Url is Empty", str, str2);
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            Logger.i(f36906e, "GrsClientManager.ayncGetGrsUrl\uff1aReturn [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            iQueryUrlCallBack.onCallBackSuccess(str3);
        }
    }
}
