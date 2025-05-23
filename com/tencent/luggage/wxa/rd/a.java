package com.tencent.luggage.wxa.rd;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public static a f139591c;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f139593b = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    public final Scheduler f139592a = Schedulers.from(this);

    public static Scheduler a() {
        if (f139591c == null) {
            synchronized (a.class) {
                if (f139591c == null) {
                    f139591c = new a();
                }
            }
        }
        return f139591c.f139592a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f139593b.post(runnable);
    }
}
