package com.tencent.common.danmaku.core;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.common.danmaku.inject.b f99652a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<BlockingQueue<com.tencent.common.danmaku.data.a>> f99653b;

    /* renamed from: c, reason: collision with root package name */
    private final BlockingQueue<com.tencent.common.danmaku.data.a> f99654c;

    public d(com.tencent.common.danmaku.inject.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f99653b = new SparseArray<>();
        this.f99654c = new LinkedBlockingQueue();
        this.f99652a = bVar;
    }

    public com.tencent.common.danmaku.data.a a(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.common.danmaku.data.a) iPatchRedirector.redirect((short) 2, (Object) this, i3, obj);
        }
        BlockingQueue<com.tencent.common.danmaku.data.a> blockingQueue = this.f99653b.get(i3);
        if (blockingQueue == null) {
            blockingQueue = new LinkedBlockingQueue<>();
        }
        com.tencent.common.danmaku.data.a poll = blockingQueue.poll();
        if (poll == null) {
            poll = this.f99652a.d(i3);
            com.tencent.common.danmaku.util.e.g("DanmakuFactory", poll, " is created ");
        } else {
            com.tencent.common.danmaku.util.e.g("DanmakuFactory", poll, " is reused ");
        }
        poll.e0();
        poll.i0(obj);
        return poll;
    }

    protected int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 300;
    }

    public void c(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        int type = aVar.getType();
        BlockingQueue<com.tencent.common.danmaku.data.a> blockingQueue = this.f99653b.get(type);
        if (blockingQueue == null) {
            blockingQueue = new LinkedBlockingQueue<>();
            this.f99653b.put(type, blockingQueue);
        }
        if (b() > blockingQueue.size()) {
            blockingQueue.add(aVar);
        }
    }
}
