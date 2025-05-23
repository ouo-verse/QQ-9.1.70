package com.qzone.proxy.feedcomponent.manager;

import android.os.SystemClock;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    ArrayList<String> f50208a;

    /* renamed from: b, reason: collision with root package name */
    int f50209b;

    /* renamed from: c, reason: collision with root package name */
    private long f50210c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ArrayList<String> arrayList, int i3) {
        this.f50208a = arrayList;
        this.f50209b = i3;
        this.f50210c = SystemClock.elapsedRealtime() + i3;
    }

    public String a() {
        ArrayList<String> arrayList = this.f50208a;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.f50208a.get(0);
    }
}
