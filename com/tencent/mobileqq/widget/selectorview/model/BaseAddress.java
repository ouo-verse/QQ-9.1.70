package com.tencent.mobileqq.widget.selectorview.model;

import com.tencent.mobileqq.utils.ChnToSpell;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BaseAddress implements Serializable {
    public static final int ADDRESS_TYPE_CITY = 2;
    public static final int ADDRESS_TYPE_COUNTY = 0;
    public static final int ADDRESS_TYPE_DISTRICT = 3;
    public static final int ADDRESS_TYPE_PROVINCE = 1;
    public int addressType;
    public String code;
    public LinkedHashMap<String, BaseAddress> dataMap;
    public boolean hasCity;
    public boolean hasDistrict;
    public boolean hasProvince;
    public String name;
    public String pinyinAll;
    public String pinyinFirst;

    public BaseAddress(String str, String str2, int i3) {
        this.name = str;
        this.code = str2;
        this.addressType = i3;
        if (i3 == 0) {
            String d16 = ChnToSpell.d(str, 1);
            this.pinyinAll = d16;
            this.pinyinFirst = String.valueOf(d16.charAt(0)).toUpperCase();
        }
        this.dataMap = new LinkedHashMap<>(15);
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            return ((BaseAddress) obj).code.equals(this.code);
        }
        return false;
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

    public ArrayList<BaseAddress> getDataList() {
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
