package com.tencent.timi.game.expand.hall.impl.teamtoast;

import com.tencent.timi.game.utils.l;
import java.util.concurrent.ConcurrentLinkedQueue;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentLinkedQueue<a> f376962a = new ConcurrentLinkedQueue<>();

    private void a(a aVar) {
        if (this.f376962a.size() > 19) {
            this.f376962a.poll();
        }
        if (aVar != null) {
            this.f376962a.add(aVar);
            l.b("TeamToastModel", "Queue +1=" + this.f376962a.size());
        }
    }

    public void b(CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str) {
        a aVar = new a();
        aVar.d(commonOuterClass$QQUserId);
        aVar.c(str.replace("{{nick}}", ""));
        a(aVar);
    }

    public a c() {
        a poll = this.f376962a.poll();
        if (poll != null) {
            l.b("TeamToastModel", "Queue -1=" + this.f376962a.size());
        }
        return poll;
    }
}
