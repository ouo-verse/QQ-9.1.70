package com.tencent.mobileqq.vas.avatar;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class IdleGetDynamic extends IdleUpdater {

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<VasAvatarLoader> f308724e;

    public IdleGetDynamic() {
        super(32);
    }

    @Override // com.tencent.mobileqq.vas.avatar.IdleUpdater
    public void e() {
        ArrayList<VasAvatarLoader> arrayList;
        synchronized (this) {
            arrayList = this.f308724e;
            this.f308724e = null;
        }
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.get(i3).f(true);
        }
    }

    public synchronized void g(VasAvatarLoader vasAvatarLoader) {
        if (this.f308724e == null) {
            this.f308724e = new ArrayList<>();
        }
        this.f308724e.add(vasAvatarLoader);
        if (this.f308724e.size() == 1) {
            f();
        }
    }
}
