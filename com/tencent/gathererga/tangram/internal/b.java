package com.tencent.gathererga.tangram.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gathererga.core.internal.component.cache.c;
import com.tencent.gathererga.core.internal.util.d;
import com.tencent.gathererga.core.internal.util.h;
import com.tencent.gathererga.core.internal.util.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f108384a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f108385b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, JSONObject> f108386c;

    /* renamed from: d, reason: collision with root package name */
    private String f108387d;

    /* renamed from: e, reason: collision with root package name */
    private String f108388e;

    /* renamed from: f, reason: collision with root package name */
    private final List<Integer> f108389f;

    /* renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Object> f108390g;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f108385b = 0;
        this.f108386c = new ConcurrentHashMap<>();
        this.f108389f = new LinkedList();
        this.f108390g = new ConcurrentHashMap<>();
    }

    private boolean h(JSONObject jSONObject, boolean z16, Object obj) {
        String str;
        if (JSONObject.NULL.equals(jSONObject)) {
            return false;
        }
        if (z16) {
            str = "hash";
        } else {
            str = "raw";
        }
        return jSONObject.opt(str).equals(obj);
    }

    private void l() {
        this.f108389f.add(101);
        this.f108389f.add(102);
        this.f108389f.add(103);
        this.f108389f.add(110);
        this.f108389f.add(111);
        this.f108389f.add(112);
        this.f108389f.add(104);
        this.f108389f.add(105);
        this.f108389f.add(106);
        this.f108389f.add(107);
        this.f108389f.add(108);
        this.f108389f.add(109);
        this.f108389f.add(115);
        this.f108389f.add(307);
    }

    @Override // com.tencent.gathererga.core.internal.component.cache.c
    public Object a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        try {
            if (this.f108386c.size() == 0) {
                return null;
            }
            return this.f108386c.get("" + i3);
        } catch (Exception e16) {
            d.b(e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.gathererga.core.internal.component.cache.c
    public void d(int i3, Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), obj, Boolean.valueOf(z16));
            return;
        }
        if (obj == null) {
            d.a("tangram storage save empty result, id = " + i3);
            return;
        }
        this.f108390g.put(Integer.valueOf(i3), obj);
        if (z16) {
            if (this.f108389f.contains(Integer.valueOf(i3))) {
                ul0.a aVar = (ul0.a) com.tencent.gathererga.sdk.c.b(ul0.a.class);
                if (aVar != null) {
                    n("" + i3, aVar.a(Integer.valueOf(i3), String.valueOf(obj)), true);
                    return;
                }
                return;
            }
            n("" + i3, obj, false);
        }
    }

    @Override // com.tencent.gathererga.core.internal.component.cache.c
    public Object g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return this.f108390g.get(Integer.valueOf(i3));
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        o(0);
        d.a("deleteFileCache");
        d.a("deleteFileCache, result = " + new com.tencent.gathererga.core.internal.util.a(this.f108387d, PublicAccountMessageUtilImpl.META_NAME, "UTF-8", true).b());
    }

    public void j(ConcurrentHashMap<Integer, com.tencent.gathererga.tangram.c> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) concurrentHashMap);
            return;
        }
        ConcurrentHashMap<String, JSONObject> concurrentHashMap2 = this.f108386c;
        if (concurrentHashMap2 != null && concurrentHashMap2.size() != 0) {
            d.a("delete single info file cache");
            Iterator<Integer> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                com.tencent.gathererga.tangram.c cVar = concurrentHashMap.get(Integer.valueOf(intValue));
                if (cVar != null && cVar.d() && this.f108386c.containsKey(String.valueOf(intValue))) {
                    this.f108386c.remove(String.valueOf(intValue));
                    this.f108384a = true;
                }
            }
            if (this.f108386c.size() == 0) {
                new com.tencent.gathererga.core.internal.util.a(this.f108387d, PublicAccountMessageUtilImpl.META_NAME, "UTF-8", true).b();
                this.f108384a = false;
            }
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (TextUtils.isEmpty(this.f108387d)) {
            d.a("TangramStorage dirName is empty");
            return;
        }
        if (this.f108385b != 0) {
            return;
        }
        synchronized (this) {
            if (this.f108385b != 0) {
                return;
            }
            o(1);
            d.a("TangramStorage onInit");
            d.a("tangramStorage cache dir = " + this.f108387d);
            this.f108388e = h.c(com.tencent.gathererga.core.internal.component.a.f108209g.f());
            l();
            m();
            o(2);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        d.a("read from file");
        com.tencent.gathererga.core.internal.util.a aVar = new com.tencent.gathererga.core.internal.util.a(this.f108387d, PublicAccountMessageUtilImpl.META_NAME, "UTF-8", true);
        if (!aVar.d()) {
            d.a("file open failed");
            return;
        }
        String e16 = aVar.e();
        try {
            if (TextUtils.isEmpty(e16)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(e16);
                if (jSONObject.optInt("version") < 2) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("hash", jSONObject.optString(str));
                        this.f108386c.put(str, jSONObject2);
                    }
                } else {
                    String optString = jSONObject.optString("content");
                    d.a("read from file = " + optString);
                    String a16 = l.a(this.f108388e, optString);
                    if (TextUtils.isEmpty(a16)) {
                        aVar.a();
                        return;
                    }
                    JSONObject jSONObject3 = new JSONObject(a16);
                    if (!JSONObject.NULL.equals(jSONObject3)) {
                        Iterator keys2 = jSONObject3.keys();
                        while (keys2.hasNext()) {
                            String str2 = (String) keys2.next();
                            String optString2 = jSONObject3.optString(str2);
                            if (!TextUtils.isEmpty(optString2)) {
                                this.f108386c.put(str2, new JSONObject(optString2));
                            }
                        }
                    }
                }
            } catch (Exception e17) {
                d.b(e17.getMessage());
            }
        } finally {
            aVar.a();
        }
    }

    public void n(String str, Object obj, boolean z16) {
        JSONObject jSONObject;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, obj, Boolean.valueOf(z16));
            return;
        }
        try {
            if (!this.f108386c.containsKey(str)) {
                jSONObject = new JSONObject();
            } else if (!h(this.f108386c.get(str), z16, obj)) {
                jSONObject = this.f108386c.get(str);
            } else {
                return;
            }
            this.f108384a = true;
            if (z16) {
                str2 = "hash";
            } else {
                str2 = "raw";
            }
            jSONObject.put(str2, obj);
            this.f108386c.put(str, jSONObject);
            d.a("save string, key = " + str + ", isHash = " + z16);
        } catch (Exception e16) {
            d.b(e16.getMessage());
        }
    }

    public void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            synchronized (this) {
                this.f108385b = i3;
            }
        }
    }

    @Override // com.tencent.gathererga.core.internal.c
    public void onInit(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        } else {
            if (context == null) {
                return;
            }
            this.f108387d = context.getDir("gatherer", 0).getAbsolutePath();
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f108384a && this.f108385b == 2) {
            synchronized (this) {
                if (this.f108384a && this.f108385b == 2) {
                    this.f108384a = false;
                    o(3);
                    com.tencent.gathererga.core.internal.util.a aVar = new com.tencent.gathererga.core.internal.util.a(this.f108387d, PublicAccountMessageUtilImpl.META_NAME, "UTF-8", true);
                    ConcurrentHashMap<String, JSONObject> concurrentHashMap = this.f108386c;
                    if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
                        if (!aVar.d()) {
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            for (String str : this.f108386c.keySet()) {
                                jSONObject.putOpt(str, this.f108386c.get(str));
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("version", 2);
                            jSONObject2.put("content", l.c(this.f108388e, jSONObject.toString()));
                            d.a("write to file: " + jSONObject2.toString());
                            aVar.g(jSONObject2.toString());
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    }
                }
            }
        }
    }
}
