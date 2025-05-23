package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c extends a {
    public c(Context context, boolean z16) {
        this.f36954e = z16;
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.f36953d = true;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int a(String str) {
        this.f36950a = new com.huawei.hms.framework.network.grs.local.model.a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString("name");
            long j3 = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.f36950a.b(string);
            this.f36950a.a(j3);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    return 0;
                }
            }
            return -1;
        } catch (JSONException e16) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e16.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(String str) {
        JSONObject jSONObject;
        this.f36951b = new ArrayList(16);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("countryOrAreaGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject2.has("countryGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryGroups");
            } else {
                Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONObject = null;
            }
            if (jSONObject == null) {
                return -1;
            }
            if (jSONObject.length() != 0) {
                this.f36951b.addAll(a(jSONObject));
            }
            return 0;
        } catch (JSONException e16) {
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e16.getMessage()));
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad A[Catch: JSONException -> 0x012c, TryCatch #0 {JSONException -> 0x012c, blocks: (B:3:0x0011, B:4:0x0023, B:6:0x0029, B:9:0x003f, B:12:0x0048, B:13:0x005e, B:15:0x0064, B:17:0x0075, B:19:0x0090, B:20:0x00a7, B:22:0x00ad, B:24:0x00c1, B:31:0x00c7, B:35:0x00d8, B:36:0x007a, B:38:0x0080, B:39:0x0087, B:42:0x00ec, B:44:0x00f7, B:45:0x0106, B:46:0x0111, B:48:0x0118, B:49:0x011f, B:53:0x00fc, B:55:0x0102, B:56:0x010b), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0118 A[Catch: JSONException -> 0x012c, TryCatch #0 {JSONException -> 0x012c, blocks: (B:3:0x0011, B:4:0x0023, B:6:0x0029, B:9:0x003f, B:12:0x0048, B:13:0x005e, B:15:0x0064, B:17:0x0075, B:19:0x0090, B:20:0x00a7, B:22:0x00ad, B:24:0x00c1, B:31:0x00c7, B:35:0x00d8, B:36:0x007a, B:38:0x0080, B:39:0x0087, B:42:0x00ec, B:44:0x00f7, B:45:0x0106, B:46:0x0111, B:48:0x0118, B:49:0x011f, B:53:0x00fc, B:55:0x0102, B:56:0x010b), top: B:2:0x0011 }] */
    @Override // com.huawei.hms.framework.network.grs.f.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(String str) {
        JSONObject jSONObject;
        String str2;
        String string;
        Iterator keys;
        String str3 = "countryGroup";
        String str4 = "countryOrAreaGroup";
        try {
            JSONObject jSONObject2 = new JSONObject(str).getJSONObject("services");
            Iterator keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String str5 = (String) keys2.next();
                com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
                cVar.b(str5);
                if (!this.f36956g.contains(str5)) {
                    this.f36956g.add(str5);
                    if (this.f36954e) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(str5);
                        cVar.c(jSONObject3.getString("routeBy"));
                        JSONArray jSONArray = jSONObject3.getJSONArray("servings");
                        int i3 = 0;
                        while (i3 < jSONArray.length()) {
                            JSONObject jSONObject4 = (JSONObject) jSONArray.get(i3);
                            com.huawei.hms.framework.network.grs.local.model.d dVar = new com.huawei.hms.framework.network.grs.local.model.d();
                            if (jSONObject4.has(str4)) {
                                string = jSONObject4.getString(str4);
                            } else if (jSONObject4.has(str3)) {
                                string = jSONObject4.getString(str3);
                            } else {
                                Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");
                                str2 = "no-country";
                                dVar.a(str2);
                                JSONObject jSONObject5 = jSONObject4.getJSONObject("addresses");
                                String str6 = str3;
                                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                                keys = jSONObject5.keys();
                                while (keys.hasNext()) {
                                    Iterator it = keys;
                                    String str7 = (String) keys.next();
                                    String string2 = jSONObject5.getString(str7);
                                    if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(string2)) {
                                        concurrentHashMap.put(str7, jSONObject5.getString(str7));
                                        keys = it;
                                        str4 = str4;
                                    } else {
                                        keys = it;
                                    }
                                }
                                dVar.a(concurrentHashMap);
                                cVar.a(dVar.b(), dVar);
                                i3++;
                                str3 = str6;
                                str4 = str4;
                            }
                            str2 = string;
                            dVar.a(str2);
                            JSONObject jSONObject52 = jSONObject4.getJSONObject("addresses");
                            String str62 = str3;
                            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(16);
                            keys = jSONObject52.keys();
                            while (keys.hasNext()) {
                            }
                            dVar.a(concurrentHashMap2);
                            cVar.a(dVar.b(), dVar);
                            i3++;
                            str3 = str62;
                            str4 = str4;
                        }
                        String str8 = str3;
                        String str9 = str4;
                        List<com.huawei.hms.framework.network.grs.local.model.b> list = null;
                        if (jSONObject3.has("countryOrAreaGroups")) {
                            jSONObject = jSONObject3.getJSONObject("countryOrAreaGroups");
                        } else if (jSONObject3.has("countryGroups")) {
                            jSONObject = jSONObject3.getJSONObject("countryGroups");
                        } else {
                            Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
                            cVar.a(list);
                            if (this.f36950a == null) {
                                this.f36950a = new com.huawei.hms.framework.network.grs.local.model.a();
                            }
                            this.f36950a.a(str5, cVar);
                            str3 = str8;
                            str4 = str9;
                        }
                        list = a((JSONArray) null, jSONObject);
                        cVar.a(list);
                        if (this.f36950a == null) {
                        }
                        this.f36950a.a(str5, cVar);
                        str3 = str8;
                        str4 = str9;
                    }
                }
            }
            return 0;
        } catch (JSONException e16) {
            Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e16.getMessage()));
            return -1;
        }
    }

    public List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : a(jSONObject);
    }

    private List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                bVar.b(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                bVar.c(jSONObject2.getString("name"));
                bVar.a(jSONObject2.getString("description"));
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                    jSONArray = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        hashSet.add((String) jSONArray.get(i3));
                    }
                    bVar.a(hashSet);
                    arrayList.add(bVar);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e16) {
            Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e16.getMessage()));
            return new ArrayList();
        }
    }
}
