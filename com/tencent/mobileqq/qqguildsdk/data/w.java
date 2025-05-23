package com.tencent.mobileqq.qqguildsdk.data;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private int f266749a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<Long> f266750b;

    public int a() {
        return this.f266749a;
    }

    public ArrayList<Long> b() {
        return this.f266750b;
    }

    public String toString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GProBindMembersInfo{mAuthControlSwitchType=");
        sb5.append(this.f266749a);
        sb5.append(",mMemberIds=");
        ArrayList<Long> arrayList = this.f266750b;
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
