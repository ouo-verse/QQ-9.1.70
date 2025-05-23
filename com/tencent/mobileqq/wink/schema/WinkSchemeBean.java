package com.tencent.mobileqq.wink.schema;

import java.io.Serializable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkSchemeBean implements Serializable {
    private static final long serialVersionUID = 322069543369932762L;
    private String mAction;
    private HashMap<String, String> mAttrs;
    private HashMap<String, byte[]> mByteAttrs;
    private long mEnterTime;

    public HashMap<String, String> getAttrs() {
        return this.mAttrs;
    }

    public HashMap<String, byte[]> getByteAttrs() {
        return this.mByteAttrs;
    }

    public long getEnterTime() {
        return this.mEnterTime;
    }

    public String getSchemeAction() {
        return this.mAction;
    }

    public WinkSchemeBean setAttrs(HashMap<String, String> hashMap) {
        this.mAttrs = hashMap;
        return this;
    }

    public WinkSchemeBean setByteAttrs(HashMap<String, byte[]> hashMap) {
        this.mByteAttrs = hashMap;
        return this;
    }

    public void setEnterTime(long j3) {
        this.mEnterTime = j3;
    }

    public WinkSchemeBean setSchemeAction(String str) {
        this.mAction = str;
        return this;
    }
}
