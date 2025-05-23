package com.tencent.mobileqq.qqguildsdk.data;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private int f266751a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<Long> f266752b;

    public int a() {
        return this.f266751a;
    }

    public ArrayList<Long> b() {
        return this.f266752b;
    }

    public String toString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GProBindRoleGroupsInfo{mAuthControlSwitchType=");
        sb5.append(this.f266751a);
        sb5.append(",mRoleGroupIds=");
        ArrayList<Long> arrayList = this.f266752b;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append(",}");
        return sb5.toString();
    }
}
