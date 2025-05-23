package com.tencent.open.model;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f341693a;

    /* renamed from: b, reason: collision with root package name */
    public long f341694b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<VirtualInfo> f341695c;

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder("GetVirtualListResult={");
        sb5.append("errorCode=");
        sb5.append(this.f341693a);
        sb5.append(",");
        sb5.append("curVirtualId=");
        sb5.append(this.f341694b);
        sb5.append(",");
        sb5.append("list=");
        ArrayList<VirtualInfo> arrayList = this.f341695c;
        if (arrayList != null) {
            str = arrayList.toString();
        } else {
            str = "null";
        }
        sb5.append(str);
        sb5.append("}");
        return sb5.toString();
    }
}
