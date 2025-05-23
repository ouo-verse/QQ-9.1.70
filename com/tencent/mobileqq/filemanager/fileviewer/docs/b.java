package com.tencent.mobileqq.filemanager.fileviewer.docs;

import androidx.annotation.Nullable;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f208296d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private Set<String> f208297e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private Set<Integer> f208298f = new HashSet();

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, Long> f208299h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private HashMap<String, Long> f208300i = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, Long> f208301m = new HashMap<>();
    private HashMap<String, Long> C = new HashMap<>();
    private HashMap<String, String> D = new HashMap<>();
    private boolean E = false;

    private static void j(JSONObject jSONObject, HashMap<String, Long> hashMap) {
        Iterator keys = jSONObject.keys();
        long j3 = 0L;
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                j3 = Long.valueOf(jSONObject.getLong(str));
            } catch (Exception e16) {
                QLog.e("TroopDocsPreviewConfigBean", 1, "jsonConvertToMap failed, exception is ", e16);
            }
            hashMap.put(str, j3);
        }
    }

    private static void k(JSONObject jSONObject, HashMap<String, String> hashMap) {
        Iterator keys = jSONObject.keys();
        String str = null;
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            try {
                str = jSONObject.getString(str2);
            } catch (Exception e16) {
                QLog.e("TroopDocsPreviewConfigBean", 1, "jsonConvertToMap failed, exception is ", e16);
            }
            hashMap.put(str2, str);
        }
    }

    @Nullable
    public static b l(String str) {
        QLog.d("TroopDocsPreviewConfigBean", 2, "TROOP_DOCS_PREVIEW_CONFIG handleTroopDocsPreviewConfig" + str);
        if (str != null && !str.isEmpty()) {
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopDocsPreviewConfigBean", 2, "TROOP_DOCS_PREVIEW_CONFIG jsonConfig:" + jSONObject.toString());
                }
                if (jSONObject.has("support_extensions")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("support_extensions");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        bVar.f208296d.add(jSONArray.getString(i3).toLowerCase());
                    }
                }
                if (jSONObject.has("gray_troop_uin")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("gray_troop_uin");
                    bVar.E = true;
                    for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                        bVar.f208297e.add(jSONArray2.getString(i16));
                    }
                } else {
                    bVar.E = false;
                }
                if (jSONObject.has("entrance_id")) {
                    JSONArray jSONArray3 = jSONObject.getJSONArray("entrance_id");
                    for (int i17 = 0; i17 < jSONArray3.length(); i17++) {
                        bVar.f208298f.add(Integer.valueOf(jSONArray3.getInt(i17)));
                    }
                }
                if (jSONObject.has("support_max_size_wifi")) {
                    j(jSONObject.optJSONObject("support_max_size_wifi"), bVar.f208299h);
                }
                if (jSONObject.has("support_min_size_wifi")) {
                    j(jSONObject.optJSONObject("support_min_size_wifi"), bVar.f208300i);
                }
                if (jSONObject.has("support_max_size_wwan")) {
                    j(jSONObject.optJSONObject("support_max_size_wwan"), bVar.f208301m);
                }
                if (jSONObject.has("support_min_size_wwan")) {
                    j(jSONObject.optJSONObject("support_min_size_wwan"), bVar.C);
                }
                if (jSONObject.has("extensions_2_url")) {
                    k(jSONObject.optJSONObject("extensions_2_url"), bVar.D);
                }
            } catch (Exception e16) {
                QLog.e("TroopDocsPreviewConfigBean", 1, e16.getLocalizedMessage(), e16);
            }
            return bVar;
        }
        return null;
    }

    public HashMap<String, String> a() {
        return this.D;
    }

    public Set<String> b() {
        return this.f208297e;
    }

    public Set<Integer> c() {
        return this.f208298f;
    }

    public Set<String> d() {
        return this.f208296d;
    }

    public HashMap<String, Long> e() {
        return this.f208299h;
    }

    public HashMap<String, Long> f() {
        return this.f208301m;
    }

    public HashMap<String, Long> g() {
        return this.f208300i;
    }

    public HashMap<String, Long> h() {
        return this.C;
    }

    public boolean i() {
        return this.E;
    }
}
