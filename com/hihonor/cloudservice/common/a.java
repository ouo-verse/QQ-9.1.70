package com.hihonor.cloudservice.common;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import q.q.q.e.w.e;
import q.q.q.w.q.c;
import q.q.q.w.q.c.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a<TOption extends c.a> {

    /* renamed from: a, reason: collision with root package name */
    private TOption f36205a;

    /* renamed from: b, reason: collision with root package name */
    private Context f36206b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Activity> f36207c;

    public a(Activity activity, c<TOption> cVar, TOption toption) {
        this.f36206b = activity.getApplicationContext();
        this.f36207c = new WeakReference<>(activity);
        c(activity, cVar, toption);
    }

    private void b(Context context) {
        e.a(context);
        com.hihonor.honorid.a.c().b(context);
    }

    private void c(Context context, c<TOption> cVar, TOption toption) {
        this.f36206b = context.getApplicationContext();
        this.f36205a = toption;
        b(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TOption a() {
        return this.f36205a;
    }

    public Context d() {
        return this.f36206b;
    }
}
