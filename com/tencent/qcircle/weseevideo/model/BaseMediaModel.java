package com.tencent.qcircle.weseevideo.model;

import com.tencent.qcircle.weseevideo.common.utils.GsonUtils;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseMediaModel implements Cloneable, Serializable {
    private final transient HashMap<String, String> extraParams = new HashMap<>(0);

    public void clearExtraParams() {
        this.extraParams.clear();
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Map<String, String> getExtraParams() {
        return this.extraParams;
    }

    public int getIntParam(String str) {
        String str2 = this.extraParams.get(str);
        if (str2 != null) {
            if (str2.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
                try {
                    return Integer.parseInt(str2.substring(2), 16);
                } catch (Exception unused) {
                    return 0;
                }
            }
            try {
                return Integer.parseInt(str2);
            } catch (Exception unused2) {
            }
        }
        return 0;
    }

    public String getParam(String str) {
        return this.extraParams.get(str);
    }

    public void putParam(String str, String str2) {
        this.extraParams.put(str, str2);
    }

    public void setExtraParams(Map<String, String> map) {
        this.extraParams.clear();
        if (map != null) {
            this.extraParams.putAll(map);
        }
    }

    public String toString() {
        return GsonUtils.obj2Json(this);
    }
}
