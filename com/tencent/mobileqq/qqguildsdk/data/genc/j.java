package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    protected int f266638a;

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<Long> f266639b = new ArrayList<>();

    public int a() {
        return this.f266638a;
    }

    public ArrayList<Long> b() {
        return this.f266639b;
    }

    public void c(int i3) {
        this.f266638a = i3;
    }

    public void d(ArrayList<Long> arrayList) {
        this.f266639b = arrayList;
    }

    public String toString() {
        return "GWGProAVChannelNoticeMemberInfo{mAtMemberType=" + this.f266638a + "mAtRoleIds=" + this.f266639b + "}";
    }
}
