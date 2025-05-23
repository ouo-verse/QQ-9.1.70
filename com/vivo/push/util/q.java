package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.f.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f387927a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f387928b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, List list) {
        this.f387928b = pVar;
        this.f387927a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsideNotificationItem insideNotificationItem;
        long j3;
        Context context;
        InsideNotificationItem insideNotificationItem2;
        long j16;
        int i3;
        NotifyArriveCallbackByUser notifyArriveCallbackByUser;
        u.a aVar;
        insideNotificationItem = this.f387928b.f387921b;
        if (insideNotificationItem != null) {
            ad b16 = ad.b();
            j3 = this.f387928b.f387922c;
            b16.a("com.vivo.push.notify_key", j3);
            context = this.f387928b.f387920a;
            List list = this.f387927a;
            insideNotificationItem2 = this.f387928b.f387921b;
            j16 = this.f387928b.f387922c;
            i3 = this.f387928b.f387924e;
            notifyArriveCallbackByUser = this.f387928b.f387925f;
            aVar = this.f387928b.f387926g;
            NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j16, i3, notifyArriveCallbackByUser, aVar);
        }
    }
}
