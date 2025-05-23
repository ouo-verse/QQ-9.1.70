package com.tencent.mobileqq.nearby.ipc;

import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;

/* compiled from: P */
/* loaded from: classes33.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private boolean f252636a;

    public boolean a() {
        return this.f252636a;
    }

    public void d(int i3, Object... objArr) {
        if (i3 == 4102) {
            b((BusinessInfoCheckUpdate.AppInfo) objArr[0]);
        } else {
            if (i3 != 4124) {
                return;
            }
            c();
        }
    }

    protected void c() {
    }

    public void b(BusinessInfoCheckUpdate.AppInfo appInfo) {
    }
}
