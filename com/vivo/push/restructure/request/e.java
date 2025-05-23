package com.vivo.push.restructure.request;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.g;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f387835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Looper looper) {
        super(looper);
        this.f387835a = dVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Map map;
        Map map2;
        int i3 = message.what;
        map = this.f387835a.f387830a;
        if (map.containsKey(Integer.valueOf(i3))) {
            map2 = this.f387835a.f387830a;
            g.a().execute(new f(this, (b) map2.remove(Integer.valueOf(i3))));
        }
    }
}
