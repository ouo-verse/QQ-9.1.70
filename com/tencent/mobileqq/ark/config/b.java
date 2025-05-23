package com.tencent.mobileqq.ark.config;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
class b extends c {

    /* renamed from: a, reason: collision with root package name */
    private int f199251a;

    public b(int i3) {
        this.f199251a = i3;
    }

    @Override // com.tencent.mobileqq.ark.config.c
    public Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        int i3 = this.f199251a;
        if (i3 < 0 || i3 >= arrayList.size()) {
            return null;
        }
        return arrayList.get(this.f199251a);
    }
}
