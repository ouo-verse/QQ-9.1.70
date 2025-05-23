package com.tencent.rmonitor.custom;

import android.text.TextUtils;
import com.tencent.bugly.common.cache.IProcessContextCache;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s04.c;
import s04.d;
import s04.e;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements ICustomDataEditorForIssue {

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f365540j = {"a11", "a12", "a13"};

    /* renamed from: e, reason: collision with root package name */
    private final e f365544e;

    /* renamed from: f, reason: collision with root package name */
    private final e f365545f;

    /* renamed from: g, reason: collision with root package name */
    private final CopyOnWriteArraySet<c> f365546g;

    /* renamed from: h, reason: collision with root package name */
    private long f365547h = 0;

    /* renamed from: i, reason: collision with root package name */
    private IProcessContextCache f365548i = null;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, Double> f365541b = new ConcurrentHashMap<>(10);

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<String>> f365542c = new ConcurrentHashMap<>(10);

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<String>> f365543d = new ConcurrentHashMap<>(f365540j.length);

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        int i3 = 0;
        for (String str : ICustomDataEditor.STRING_PARAM_KEYS) {
            i3 = Math.max(str.length(), i3);
        }
        this.f365544e = new e(i3 + 1, ICustomDataEditor.STRING_PARAM_KEYS.length);
        this.f365545f = new e(200, 100);
        this.f365546g = new CopyOnWriteArraySet<>();
    }

    private void a() {
        this.f365547h++;
        try {
            Iterator<c> it = this.f365546g.iterator();
            while (it.hasNext()) {
                it.next().a(this.f365547h);
            }
        } catch (Throwable unused) {
        }
    }

    private void b(String str, double d16) {
        IProcessContextCache iProcessContextCache = this.f365548i;
        if (iProcessContextCache != null) {
            iProcessContextCache.put(str, d16);
            iProcessContextCache.apply();
        }
        a();
    }

    private void c(String str, String str2) {
        IProcessContextCache iProcessContextCache = this.f365548i;
        if (iProcessContextCache != null) {
            iProcessContextCache.put(str, str2);
            iProcessContextCache.apply();
        }
        a();
    }

    private void d(String str, List<String> list) {
        IProcessContextCache iProcessContextCache = this.f365548i;
        if (iProcessContextCache != null) {
            iProcessContextCache.put(str, list);
            iProcessContextCache.apply();
        }
        a();
    }

    private void h(ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap, ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap2) {
        for (String str : concurrentHashMap.keySet()) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = concurrentHashMap.get(str);
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                concurrentHashMap2.put(str, new CopyOnWriteArrayList<>(copyOnWriteArrayList));
            }
        }
    }

    @NotNull
    private List<String> n(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList = null;
        if (s04.a.b(ICustomDataEditor.STRING_ARRAY_PARAM_KEYS, str)) {
            concurrentHashMap = this.f365542c;
        } else if (s04.a.b(f365540j, str)) {
            concurrentHashMap = this.f365543d;
        } else {
            concurrentHashMap = null;
        }
        if (concurrentHashMap != null) {
            copyOnWriteArrayList = concurrentHashMap.get(str);
        }
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            if (concurrentHashMap != null) {
                concurrentHashMap.put(str, copyOnWriteArrayList);
            }
        }
        return copyOnWriteArrayList;
    }

    private boolean q(String str) {
        if (str != null && !str.isEmpty() && str.length() <= 1024) {
            return false;
        }
        return true;
    }

    private JSONArray r(List<String> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
            return jSONArray;
        }
        return null;
    }

    private void s(JSONObject jSONObject) throws JSONException {
        for (Map.Entry<String, Double> entry : this.f365541b.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            if (value != null) {
                jSONObject.put(key, value);
            }
        }
    }

    private void v(JSONObject jSONObject, ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap) throws JSONException {
        for (Map.Entry<String, CopyOnWriteArrayList<String>> entry : concurrentHashMap.entrySet()) {
            String key = entry.getKey();
            JSONArray r16 = r(entry.getValue());
            if (r16 != null) {
                jSONObject.put(key, r16);
            }
        }
    }

    @Override // com.tencent.rmonitor.custom.ICustomDataEditor
    public boolean addStringToSequence(@ICustomDataEditor.StringArrayParamKey String str, String str2) {
        List<String> list;
        boolean z16 = false;
        if (q(str2)) {
            return false;
        }
        if (s04.a.b(ICustomDataEditor.STRING_ARRAY_PARAM_KEYS, str)) {
            list = n(str);
            if (list.size() < 30) {
                list.add(str2);
                z16 = true;
            }
        } else {
            list = null;
        }
        if (z16) {
            d(str, list);
        }
        return z16;
    }

    @Override // com.tencent.rmonitor.custom.ICustomDataEditor
    public boolean addStringToStringArrayParam(String str, String str2) {
        List<String> list;
        boolean z16 = false;
        if (q(str2)) {
            return false;
        }
        if (s04.a.b(ICustomDataEditor.STRING_ARRAY_PARAM_KEYS, str)) {
            list = n(str);
            if (!list.contains(str2) && list.size() < 30) {
                list.add(str2);
                z16 = true;
            }
        } else {
            list = null;
        }
        if (z16) {
            d(str, list);
        }
        return z16;
    }

    public boolean e(String str, String str2) {
        List<String> list;
        boolean z16 = false;
        if (!TextUtils.isEmpty(str2) && str2.length() <= 1024) {
            if (s04.a.b(f365540j, str)) {
                list = n(str);
                if (!list.contains(str2) && list.size() < 30) {
                    list.add(str2);
                    z16 = true;
                }
            } else {
                list = null;
            }
            if (z16) {
                d(str, list);
            }
        }
        return z16;
    }

    public boolean f(String str) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        boolean z16 = false;
        if (s04.a.b(f365540j, str)) {
            copyOnWriteArrayList = this.f365543d.get(str);
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                copyOnWriteArrayList.clear();
                z16 = true;
            }
        } else {
            copyOnWriteArrayList = null;
        }
        if (z16) {
            d(str, copyOnWriteArrayList);
        }
        return z16;
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a clone() {
        a aVar = new a();
        aVar.f365541b.putAll(this.f365541b);
        aVar.f365544e.c(this.f365544e);
        aVar.f365545f.c(this.f365545f);
        h(this.f365542c, aVar.f365542c);
        h(this.f365543d, aVar.f365543d);
        return aVar;
    }

    @Override // com.tencent.rmonitor.custom.ICustomDataEditor
    public double getNumberParam(String str) {
        Double d16;
        if (s04.a.b(ICustomDataEditor.NUMBER_PARAM_KEYS, str)) {
            d16 = this.f365541b.get(str);
        } else {
            d16 = null;
        }
        if (d16 != null) {
            return d16.doubleValue();
        }
        return 0.0d;
    }

    @Override // com.tencent.rmonitor.custom.ICustomDataEditor
    public List<String> getStringArrayParam(String str) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (s04.a.b(ICustomDataEditor.STRING_ARRAY_PARAM_KEYS, str)) {
            copyOnWriteArrayList = this.f365542c.get(str);
        } else {
            copyOnWriteArrayList = null;
        }
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = d.f433068a;
        }
        return Collections.unmodifiableList(copyOnWriteArrayList);
    }

    @Override // com.tencent.rmonitor.custom.ICustomDataEditor
    public String getStringParam(String str) {
        String str2;
        if (s04.a.b(ICustomDataEditor.STRING_PARAM_KEYS, str)) {
            str2 = this.f365544e.getUserData(str);
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @Override // com.tencent.rmonitor.custom.IUserDataEditor
    public String getUserData(String str) {
        return this.f365545f.getUserData(str);
    }

    public JSONObject i() {
        try {
            return this.f365545f.e();
        } catch (Throwable unused) {
            return null;
        }
    }

    public long j() {
        return this.f365547h;
    }

    public JSONObject k() {
        try {
            if (this.f365543d.isEmpty()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                v(jSONObject, this.f365543d);
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public List<String> l(String str) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (s04.a.b(f365540j, str)) {
            copyOnWriteArrayList = this.f365543d.get(str);
        } else {
            copyOnWriteArrayList = null;
        }
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = d.f433068a;
        }
        return Collections.unmodifiableList(copyOnWriteArrayList);
    }

    public JSONObject m() {
        try {
            JSONArray r16 = r(this.f365543d.get("a11"));
            JSONArray r17 = r(this.f365543d.get("a12"));
            if (r16 == null && r17 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            if (r16 != null) {
                try {
                    jSONObject.put("a11", r16);
                } catch (Throwable unused) {
                }
            }
            if (r17 != null) {
                jSONObject.put("a12", r17);
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public JSONObject o() {
        JSONObject jSONObject = null;
        try {
            if (!this.f365544e.a()) {
                jSONObject = this.f365544e.e();
            }
            if (!this.f365541b.isEmpty()) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                s(jSONObject);
            }
            if (!this.f365542c.isEmpty()) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                v(jSONObject, this.f365542c);
            }
            if (!this.f365543d.isEmpty()) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                v(jSONObject, this.f365543d);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public boolean p() {
        if (this.f365541b.isEmpty() && this.f365544e.a() && this.f365545f.a() && this.f365542c.isEmpty() && this.f365543d.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.rmonitor.custom.ICustomDataEditor
    public boolean putNumberParam(String str, double d16) {
        boolean z16;
        if (s04.a.b(ICustomDataEditor.NUMBER_PARAM_KEYS, str)) {
            this.f365541b.put(str, Double.valueOf(d16));
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            b(str, d16);
        }
        return z16;
    }

    @Override // com.tencent.rmonitor.custom.ICustomDataEditor
    public boolean putStringParam(String str, String str2) {
        boolean z16;
        if (s04.a.b(ICustomDataEditor.STRING_PARAM_KEYS, str)) {
            str2 = s04.a.a(str2);
            this.f365544e.putUserData(str, str2);
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            c(str, str2);
        }
        return z16;
    }

    @Override // com.tencent.rmonitor.custom.IUserDataEditor
    public boolean putUserData(String str, String str2) {
        boolean putUserData = this.f365545f.putUserData(str, str2);
        if (putUserData) {
            c("user_data_" + str, str2);
        }
        return putUserData;
    }

    @Override // com.tencent.rmonitor.custom.ICustomDataEditor
    public boolean removeStringFromStringArrayParam(String str, String str2) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        boolean z16 = false;
        if (q(str2)) {
            return false;
        }
        if (s04.a.b(ICustomDataEditor.STRING_ARRAY_PARAM_KEYS, str)) {
            copyOnWriteArrayList = this.f365542c.get(str);
            if (copyOnWriteArrayList != null) {
                z16 = copyOnWriteArrayList.remove(str2);
            }
        } else {
            copyOnWriteArrayList = null;
        }
        if (z16) {
            d(str, copyOnWriteArrayList);
        }
        return z16;
    }

    public String t(String str) {
        String d16 = this.f365545f.d(str);
        if (!TextUtils.isEmpty(d16)) {
            c("user_data_" + str, "");
        }
        return d16;
    }

    public void u(IProcessContextCache iProcessContextCache) {
        this.f365548i = iProcessContextCache;
    }
}
