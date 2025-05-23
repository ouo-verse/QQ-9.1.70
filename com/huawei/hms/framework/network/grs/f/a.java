package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected com.huawei.hms.framework.network.grs.local.model.a f36950a;

    /* renamed from: b, reason: collision with root package name */
    protected List<com.huawei.hms.framework.network.grs.local.model.b> f36951b;

    /* renamed from: c, reason: collision with root package name */
    protected Map<String, String> f36952c = new ConcurrentHashMap(16);

    /* renamed from: d, reason: collision with root package name */
    protected boolean f36953d = false;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f36954e = false;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f36955f = false;

    /* renamed from: g, reason: collision with root package name */
    protected Set<String> f36956g = new HashSet(16);

    private int b(String str, Context context) {
        if (f(com.huawei.hms.framework.network.grs.h.c.a(str, context)) != 0) {
            return -1;
        }
        Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", str);
        return 0;
    }

    private int f(String str) {
        int b16;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.f36954e && (b16 = b(str)) != 0) {
            return b16;
        }
        int a16 = a(str);
        if (a16 != 0) {
            return a16;
        }
        return e(str);
    }

    private int g(String str) {
        List<com.huawei.hms.framework.network.grs.local.model.b> list;
        int c16;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.f36954e && (((list = this.f36951b) == null || list.isEmpty()) && (c16 = c(str)) != 0)) {
            return c16;
        }
        return d(str);
    }

    public abstract int a(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str, Context context) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(GrsApp.getInstance().getBrand("/"));
        sb5.append(str);
        return b(sb5.toString(), context) != 0 ? -1 : 0;
    }

    public abstract int b(String str);

    public int c(String str) {
        JSONArray jSONArray;
        this.f36951b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            this.f36951b.addAll(a(jSONArray));
            return 0;
        } catch (JSONException e16) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e16.getMessage()));
            return -1;
        }
    }

    public int d(String str) {
        try {
            b(new JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (JSONException e16) {
            Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e16.getMessage()));
            return -1;
        }
    }

    public abstract int e(String str);

    public boolean e() {
        return this.f36953d;
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z16) {
        Map<String, String> a16 = a(context, aVar, grsBaseInfo, str, z16);
        if (a16 != null) {
            return a16.get(str2);
        }
        Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    public com.huawei.hms.framework.network.grs.local.model.a b() {
        return this.f36950a;
    }

    public Set<String> c() {
        return this.f36956g;
    }

    public boolean d() {
        return this.f36955f;
    }

    public List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONArray jSONArray) {
        JSONArray jSONArray2;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        try {
            ArrayList arrayList = new ArrayList(16);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                bVar.b(jSONObject.getString("id"));
                bVar.c(jSONObject.getString("name"));
                bVar.a(jSONObject.getString("description"));
                if (jSONObject.has("countriesOrAreas")) {
                    jSONArray2 = jSONObject.getJSONArray("countriesOrAreas");
                } else if (jSONObject.has("countries")) {
                    jSONArray2 = jSONObject.getJSONArray("countries");
                } else {
                    Logger.w("AbstractLocalManager", "current country or area group has not config countries or areas.");
                    jSONArray2 = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray2 != null && jSONArray2.length() != 0) {
                    for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                        hashSet.add((String) jSONArray2.get(i16));
                    }
                    bVar.a(hashSet);
                    arrayList.add(bVar);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e16) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e16.getMessage()));
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(JSONArray jSONArray) {
        List<com.huawei.hms.framework.network.grs.local.model.b> list;
        String str;
        Iterator keys;
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
            String string = jSONObject.getString("name");
            cVar.b(string);
            if (!this.f36956g.contains(string)) {
                this.f36956g.add(string);
                if (this.f36954e) {
                    cVar.c(jSONObject.getString("routeBy"));
                    JSONArray jSONArray2 = jSONObject.getJSONArray("servings");
                    for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray2.get(i16);
                        com.huawei.hms.framework.network.grs.local.model.d dVar = new com.huawei.hms.framework.network.grs.local.model.d();
                        String str2 = "countryOrAreaGroup";
                        if (!jSONObject2.has("countryOrAreaGroup")) {
                            str2 = "countryGroup";
                            if (!jSONObject2.has("countryGroup")) {
                                Logger.v("AbstractLocalManager", "maybe this service{%s} routeBy is unconditional.", string);
                                str = "no-country";
                                dVar.a(str);
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("addresses");
                                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                                keys = jSONObject3.keys();
                                while (keys.hasNext()) {
                                    String str3 = (String) keys.next();
                                    String string2 = jSONObject3.getString(str3);
                                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(string2)) {
                                        concurrentHashMap.put(str3, jSONObject3.getString(str3));
                                    }
                                }
                                dVar.a(concurrentHashMap);
                                cVar.a(dVar.b(), dVar);
                            }
                        }
                        str = jSONObject2.getString(str2);
                        dVar.a(str);
                        JSONObject jSONObject32 = jSONObject2.getJSONObject("addresses");
                        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(16);
                        keys = jSONObject32.keys();
                        while (keys.hasNext()) {
                        }
                        dVar.a(concurrentHashMap2);
                        cVar.a(dVar.b(), dVar);
                    }
                    String str4 = "countryOrAreaGroups";
                    if (!jSONObject.has("countryOrAreaGroups")) {
                        str4 = "countryGroups";
                        if (!jSONObject.has("countryGroups")) {
                            Logger.i("AbstractLocalManager", "service use default countryOrAreaGroup");
                            list = null;
                            cVar.a(list);
                            if (this.f36950a == null) {
                                this.f36950a = new com.huawei.hms.framework.network.grs.local.model.a();
                            }
                            this.f36950a.a(string, cVar);
                        }
                    }
                    list = a(jSONObject.getJSONArray(str4));
                    cVar.a(list);
                    if (this.f36950a == null) {
                    }
                    this.f36950a.a(string, cVar);
                }
            }
        }
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z16) {
        com.huawei.hms.framework.network.grs.local.model.a aVar2 = this.f36950a;
        if (aVar2 == null) {
            Logger.w("AbstractLocalManager", "application data is null.");
            return null;
        }
        com.huawei.hms.framework.network.grs.local.model.c a16 = aVar2.a(str);
        if (a16 == null) {
            Logger.w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String b16 = e.b(context, aVar, a16.b(), grsBaseInfo, z16);
        if (b16 == null) {
            Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", a16.b());
            return null;
        }
        List<com.huawei.hms.framework.network.grs.local.model.b> a17 = a16.a();
        com.huawei.hms.framework.network.grs.local.model.d a18 = a16.a(((a17 == null || a17.size() == 0) ? this.f36952c : a(a17, grsBaseInfo, b16)).get(b16));
        if (a18 == null) {
            return null;
        }
        return a18.a();
    }

    private Map<String, String> a(List<com.huawei.hms.framework.network.grs.local.model.b> list, GrsBaseInfo grsBaseInfo, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (com.huawei.hms.framework.network.grs.local.model.b bVar : list) {
            if (bVar.a().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), bVar.b());
            }
            if (bVar.a().contains(str)) {
                Logger.v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, bVar.b());
            }
        }
        return concurrentHashMap;
    }

    public void a() {
        com.huawei.hms.framework.network.grs.local.model.a aVar = this.f36950a;
        if (aVar != null) {
            aVar.a();
            this.f36955f = true;
        }
    }

    public void a(Context context, List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            if (Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str)) {
                if (g(com.huawei.hms.framework.network.grs.h.c.a(GrsApp.getInstance().getBrand("/") + str, context)) == 0) {
                    Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", str);
                } else {
                    Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", str);
                }
            }
        }
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        this.f36952c.put("no_route_country", "no-country");
        List<com.huawei.hms.framework.network.grs.local.model.b> list = this.f36951b;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (com.huawei.hms.framework.network.grs.local.model.b bVar : this.f36951b) {
            if (bVar.a().contains(grsBaseInfo.getIssueCountry())) {
                this.f36952c.put(grsBaseInfo.getIssueCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getRegCountry())) {
                this.f36952c.put(grsBaseInfo.getRegCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getSerCountry())) {
                this.f36952c.put(grsBaseInfo.getSerCountry(), bVar.b());
            }
        }
        this.f36951b = null;
    }
}
