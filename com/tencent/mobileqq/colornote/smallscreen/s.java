package com.tencent.mobileqq.colornote.smallscreen;

import com.tencent.mobileqq.colornote.smallscreen.n;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppService;

/* compiled from: P */
/* loaded from: classes5.dex */
public class s<Callback extends n> {

    /* renamed from: a, reason: collision with root package name */
    private final List<Callback> f201704a = new ArrayList();

    private Object[] a() {
        Object[] objArr;
        synchronized (this.f201704a) {
            if (this.f201704a.size() > 0) {
                objArr = this.f201704a.toArray();
            } else {
                objArr = null;
            }
        }
        return objArr;
    }

    public void b(AppService appService) {
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                ((n) obj).a(appService);
            }
        }
    }

    public void c(Callback callback) {
        synchronized (this.f201704a) {
            this.f201704a.add(callback);
        }
    }
}
