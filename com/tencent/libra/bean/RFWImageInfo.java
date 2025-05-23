package com.tencent.libra.bean;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RFWImageInfo {
    public String key;
    public String local;
    public long maxage = 259200;
    public long modified;
    public int state;
    public long updatetime;
    public String url;

    public boolean equals(Object obj) {
        RFWImageInfo rFWImageInfo = (RFWImageInfo) obj;
        if (rFWImageInfo != null) {
            return rFWImageInfo.key.equals(this.key);
        }
        return false;
    }

    public int hashCode() {
        return this.key.hashCode();
    }
}
