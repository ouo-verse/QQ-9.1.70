package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class aa {

    /* renamed from: c, reason: collision with root package name */
    private static aa f97931c;

    /* renamed from: d, reason: collision with root package name */
    private static Object f97932d = new Object();

    /* renamed from: a, reason: collision with root package name */
    boolean f97933a = false;

    /* renamed from: b, reason: collision with root package name */
    public List<a> f97934b = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void onSubProcessConfigChanged(boolean z16);
    }

    aa() {
    }

    public static aa a() {
        if (f97931c == null) {
            synchronized (f97932d) {
                if (f97931c == null) {
                    f97931c = new aa();
                }
            }
        }
        return f97931c;
    }
}
