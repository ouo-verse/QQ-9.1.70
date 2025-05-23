package com.qzone.misc.network.ttt;

import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private int f48542d;

    /* renamed from: a, reason: collision with root package name */
    private final String f48539a = "ActionFlowTempListManager";

    /* renamed from: c, reason: collision with root package name */
    private final int f48541c = 2;

    /* renamed from: b, reason: collision with root package name */
    private volatile LinkedList<ArrayList<d>> f48540b = new LinkedList<>();

    public c(int i3) {
        this.f48542d = i3;
        for (int i16 = 0; i16 < 2; i16++) {
            this.f48540b.add(a());
        }
    }

    private ArrayList<d> a() {
        ArrayList<d> arrayList = new ArrayList<>(this.f48542d);
        for (int i3 = 0; i3 < this.f48542d; i3++) {
            arrayList.add(null);
        }
        return arrayList;
    }

    public ArrayList<d> b() {
        if (this.f48540b.size() > 0) {
            try {
                return this.f48540b.pollFirst();
            } catch (Exception unused) {
                com.qzone.proxy.feedcomponent.b.c("ActionFlowTempListManager", "getAnotherTempActionList Exception");
                return a();
            }
        }
        return a();
    }

    public void c(ArrayList<d> arrayList) {
        this.f48540b.add(arrayList);
    }
}
