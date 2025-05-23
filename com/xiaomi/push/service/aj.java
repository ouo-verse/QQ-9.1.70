package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import com.xiaomi.push.hz;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class aj {

    /* renamed from: a, reason: collision with root package name */
    private static List<a> f389596a = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f389597a;

        /* renamed from: b, reason: collision with root package name */
        public final long f389598b;

        /* renamed from: c, reason: collision with root package name */
        public final int f389599c;

        /* renamed from: d, reason: collision with root package name */
        public final Notification.Action[] f389600d;

        a(String str, long j3, int i3, Notification.Action[] actionArr) {
            this.f389597a = str;
            this.f389598b = j3;
            this.f389599c = i3;
            this.f389600d = actionArr;
        }
    }

    private static void a() {
        for (int size = f389596a.size() - 1; size >= 0; size--) {
            a aVar = f389596a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f389598b > 5000) {
                f389596a.remove(aVar);
            }
        }
        if (f389596a.size() > 10) {
            f389596a.remove(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(Context context, StatusBarNotification statusBarNotification, int i3) {
        if (hz.j(context) && i3 > 0 && statusBarNotification != null) {
            c(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i3, k.u(statusBarNotification.getNotification())));
        }
    }

    private static void c(a aVar) {
        f389596a.add(aVar);
        a();
    }
}
