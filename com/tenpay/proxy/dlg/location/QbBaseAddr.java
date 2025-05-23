package com.tenpay.proxy.dlg.location;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QbBaseAddr {
    public static final int ADDRESS_TYPE_CITY = 2;
    public static final int ADDRESS_TYPE_COUNTY = 0;
    public static final int ADDRESS_TYPE_DISTRICT = 3;
    public static final int ADDRESS_TYPE_PROVINCE = 1;
    public int addressType;
    public String code;
    public LinkedHashMap<String, QbBaseAddr> dataMap = new LinkedHashMap<>(15);
    public boolean hasCity;
    public boolean hasDistrict;
    public boolean hasProvince;
    public String name;

    public QbBaseAddr(String str, String str2, int i3) {
        this.name = str;
        this.code = str2;
        this.addressType = i3;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == null || !(obj instanceof QbBaseAddr) || (str = ((QbBaseAddr) obj).code) == null || !str.equals(this.code)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public int getColumnNember() {
        ?? r06 = this.hasProvince;
        int i3 = r06;
        if (this.hasCity) {
            i3 = r06 + 1;
        }
        if (this.hasDistrict) {
            return i3 + 1;
        }
        return i3;
    }

    public ArrayList<QbBaseAddr> getDataList() {
        if (this.dataMap != null) {
            return new ArrayList<>(this.dataMap.values());
        }
        return null;
    }

    public int hashCode() {
        return this.code.hashCode();
    }

    public String toString() {
        return this.name;
    }
}
