package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class AudioRecordController extends BaseThread {
    public WeakReference<g> C;

    public AudioRecordController(g gVar) {
        super("AudioRecordThread");
        this.C = new WeakReference<>(gVar);
    }

    public abstract void o();

    public abstract void p();

    public abstract void q();

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        o();
    }
}
