package com.tencent.pts.utils;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes22.dex */
public abstract class PTSStrToObjMap implements Map<String, Object> {
    static IPatchRedirector $redirector_;
    protected String TAG;
    private final HashMap<String, Object> mMap;

    public PTSStrToObjMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = getClass().getSimpleName();
            this.mMap = new HashMap<>();
        }
    }

    @Override // java.util.Map
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.mMap.clear();
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        return this.mMap.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, obj)).booleanValue();
        }
        return this.mMap.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Set) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mMap.entrySet();
    }

    @Override // java.util.Map
    public Object get(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, obj);
        }
        return this.mMap.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.mMap.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Set) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mMap.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) map);
        } else {
            this.mMap.putAll(map);
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, (Object) this, obj);
        }
        return this.mMap.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mMap.size();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Collection) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mMap.values();
    }

    @Override // java.util.Map
    public Object put(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.mMap.put(str, obj) : iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, obj);
    }

    public PTSStrToObjMap(Map<String, Object> map) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
        } else if (map != null) {
            putAll(map);
        }
    }

    public PTSStrToObjMap(JSONObject jSONObject) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
            return;
        }
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    String str = (String) keys.next();
                    put(str, jSONObject.get(str));
                } catch (JSONException e16) {
                    PTSLog.e(this.TAG, "init PTSStrToObjMap, e = ", e16);
                }
            }
        }
    }
}
