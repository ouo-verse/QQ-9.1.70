package com.tencent.mtt.hippy.common;

import com.tencent.mtt.hippy.utils.ArgumentUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyArray {
    private final ArrayList mDatas = new ArrayList();

    public void clear() {
        this.mDatas.clear();
    }

    public HippyArray copy() {
        HippyArray hippyArray = new HippyArray();
        Iterator it = this.mDatas.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof HippyMap) {
                next = ((HippyMap) next).copy();
            } else if (next instanceof HippyArray) {
                next = ((HippyArray) next).copy();
            }
            hippyArray.pushObject(next);
        }
        return hippyArray;
    }

    public Object get(int i3) {
        return this.mDatas.get(i3);
    }

    public HippyArray getArray(int i3) {
        if (this.mDatas.size() <= i3) {
            return null;
        }
        Object obj = this.mDatas.get(i3);
        if (!(obj instanceof HippyArray)) {
            return null;
        }
        return (HippyArray) obj;
    }

    public boolean getBoolean(int i3) {
        if (this.mDatas.size() <= i3) {
            return false;
        }
        Object obj = this.mDatas.get(i3);
        if (!(obj instanceof Boolean) || !((Boolean) obj).booleanValue()) {
            return false;
        }
        return true;
    }

    public double getDouble(int i3) {
        if (this.mDatas.size() <= i3) {
            return 0.0d;
        }
        Object obj = this.mDatas.get(i3);
        if (!(obj instanceof Number)) {
            return 0.0d;
        }
        return ((Number) obj).doubleValue();
    }

    public int getInt(int i3) {
        if (this.mDatas.size() <= i3) {
            return 0;
        }
        Object obj = this.mDatas.get(i3);
        if (!(obj instanceof Number)) {
            return 0;
        }
        return ((Number) obj).intValue();
    }

    public long getLong(int i3) {
        if (this.mDatas.size() <= i3) {
            return 0L;
        }
        Object obj = this.mDatas.get(i3);
        if (!(obj instanceof Number)) {
            return 0L;
        }
        return ((Number) obj).longValue();
    }

    public HippyMap getMap(int i3) {
        if (this.mDatas.size() <= i3) {
            return null;
        }
        Object obj = this.mDatas.get(i3);
        if (!(obj instanceof HippyMap)) {
            return null;
        }
        return (HippyMap) obj;
    }

    public Object getObject(int i3) {
        if (this.mDatas.size() > i3) {
            return this.mDatas.get(i3);
        }
        return null;
    }

    public String getSignature(int i3) {
        Object obj = get(i3);
        if (obj == null) {
            return null;
        }
        return ArgumentUtils.getSupportSignature(obj.getClass());
    }

    public String getString(int i3) {
        if (this.mDatas.size() > i3) {
            return String.valueOf(this.mDatas.get(i3));
        }
        return null;
    }

    public void pushArray(HippyArray hippyArray) {
        this.mDatas.add(hippyArray);
    }

    public void pushBoolean(boolean z16) {
        this.mDatas.add(Boolean.valueOf(z16));
    }

    public void pushDouble(double d16) {
        this.mDatas.add(Double.valueOf(d16));
    }

    public void pushInt(int i3) {
        this.mDatas.add(Integer.valueOf(i3));
    }

    public void pushJSONArray(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    Object opt = jSONArray.opt(i3);
                    if (opt == null) {
                        pushNull();
                    } else if (opt instanceof JSONObject) {
                        HippyMap hippyMap = new HippyMap();
                        hippyMap.pushJSONObject((JSONObject) opt);
                        pushMap(hippyMap);
                    } else if (opt instanceof JSONArray) {
                        HippyArray hippyArray = new HippyArray();
                        hippyArray.pushJSONArray((JSONArray) opt);
                        pushArray(hippyArray);
                    } else {
                        pushObject(opt);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
        }
    }

    public void pushLong(long j3) {
        this.mDatas.add(Long.valueOf(j3));
    }

    public void pushMap(HippyMap hippyMap) {
        this.mDatas.add(hippyMap);
    }

    public void pushNull() {
        this.mDatas.add(null);
    }

    public void pushObject(Object obj) {
        this.mDatas.add(obj);
    }

    public void pushString(String str) {
        this.mDatas.add(str);
    }

    public void setObject(int i3, Object obj) {
        this.mDatas.set(i3, obj);
    }

    public int size() {
        return this.mDatas.size();
    }

    public JSONArray toJSONArray() {
        JSONArray jSONArray = new JSONArray();
        if (size() <= 0) {
            return jSONArray;
        }
        try {
            Iterator it = this.mDatas.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof HippyMap) {
                    next = ((HippyMap) next).toJSONObject();
                } else if (next instanceof HippyArray) {
                    next = ((HippyArray) next).toJSONArray();
                }
                jSONArray.mo162put(next);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jSONArray;
    }

    public String toString() {
        return this.mDatas.toString();
    }
}
