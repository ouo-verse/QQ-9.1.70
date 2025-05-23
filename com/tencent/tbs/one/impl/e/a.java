package com.tencent.tbs.one.impl.e;

import android.os.Process;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a extends BaseThread {

    /* renamed from: a, reason: collision with root package name */
    private final File f374899a;

    public a(File file) {
        this.f374899a = file;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        com.tencent.tbs.one.impl.a.g.a("Running cleanup thread", new Object[0]);
        com.tencent.tbs.one.impl.a.d.a(com.tencent.tbs.one.impl.common.f.a(this.f374899a, Process.myPid()), false);
        File[] listFiles = com.tencent.tbs.one.impl.common.f.a(this.f374899a).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                f.d(file);
            }
        }
    }
}
