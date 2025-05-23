package com.tencent.comic.data;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.util.StringBuilderUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, Integer> f99321d;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Pair<Integer, String>> f99322a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f99323b;

    /* renamed from: c, reason: collision with root package name */
    private int f99324c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33811);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        f99321d = hashMap;
        hashMap.put("obj_ownerid", 11);
        hashMap.put("obj_pos", 12);
        hashMap.put("mod", 16);
        hashMap.put("land_page", 42);
        hashMap.put("detailpage_from", 43);
        hashMap.put("algo_id", 44);
        hashMap.put("trace_scene_id", 45);
        hashMap.put("page_id", 46);
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f99322a = new ConcurrentHashMap<>();
        this.f99323b = new ConcurrentHashMap<>();
        this.f99324c = 0;
    }

    public d a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (d) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        d dVar = new d();
        dVar.f99322a.putAll(this.f99322a);
        dVar.f99323b.putAll(this.f99323b);
        return dVar;
    }

    public String b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        }
        Integer num = f99321d.get(str);
        if (num != null) {
            this.f99322a.put(str, new Pair<>(num, str2));
        }
        return str2;
    }

    public List<String> c(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
        }
        if (list == null) {
            return null;
        }
        if (list.size() <= this.f99324c + 1) {
            ArrayList arrayList = new ArrayList(this.f99324c + 1);
            arrayList.addAll(list);
            list = arrayList;
        }
        for (Map.Entry<String, Pair<Integer, String>> entry : this.f99322a.entrySet()) {
            if (!f99321d.containsKey(entry.getKey())) {
                list.set(((Integer) entry.getValue().first).intValue(), (String) entry.getValue().second);
            }
        }
        return list;
    }

    public void d(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), str2);
        } else if (!TextUtils.isEmpty(str) && i3 > 8) {
            this.f99322a.put(str, new Pair<>(Integer.valueOf(i3), str2));
        }
    }

    public void e(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jSONObject);
            return;
        }
        if (jSONObject == null) {
            return;
        }
        f.f99344a = b("mod", jSONObject.optString("mod_18", f.f99344a));
        f.f99348e = b("obj_pos", jSONObject.optString("obj_pos_14", f.f99348e));
        f.f99349f = b("detailpage_from", jSONObject.optString("detailpage_from_45", f.f99349f));
        if (jSONObject.has("mod")) {
            f.f99354k = jSONObject.optString("mod");
        }
        Log.i("ExtraParams", "updateSetContainerInfoParams: mod=" + jSONObject);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        StringBuilder obtain = StringBuilderUtils.obtain();
        int i3 = 0;
        for (Map.Entry<String, Pair<Integer, String>> entry : this.f99322a.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getValue().second)) {
                if (i3 > 0) {
                    obtain.append(Typography.amp);
                }
                obtain.append(entry.getKey());
                obtain.append(util.base64_pad_url);
                obtain.append(((Integer) entry.getValue().first).intValue() + 2);
                obtain.append('=');
                obtain.append((String) entry.getValue().second);
                i3++;
            }
        }
        return URLEncoder.encode(obtain.toString());
    }
}
