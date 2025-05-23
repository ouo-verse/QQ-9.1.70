package com.tencent.rmonitor.base.config.data;

import com.tencent.bugly.common.config.creator.CommonConfigCreator;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes25.dex */
public class ConfigCreatorProxy implements com.tencent.rmonitor.base.config.e {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.tencent.rmonitor.base.config.e> f365304a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f365305b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final ConfigCreatorProxy f365306a = new ConfigCreatorProxy();
    }

    private void b() {
        if (this.f365304a.isEmpty()) {
            c();
        }
    }

    private synchronized void c() {
        if (this.f365305b) {
            return;
        }
        Logger.f365497g.i("RMonitor_config", "generate creator");
        a(e("com.tencent.rmonitor.base.config.creator.LagConfigCreator"));
        a(e("com.tencent.rmonitor.base.config.creator.MemoryConfigCreator"));
        a(e("com.tencent.rmonitor.base.config.creator.ResourceConfigCreator"));
        a(e("com.tencent.bugly.crashreport.common.config.CrashConfigCreator"));
        a(e("com.tencent.rmonitor.base.config.creator.DefaultConfigCreator"));
        a(new CommonConfigCreator());
        this.f365305b = true;
    }

    public static ConfigCreatorProxy d() {
        return b.f365306a;
    }

    private com.tencent.rmonitor.base.config.e e(String str) {
        try {
            return (com.tencent.rmonitor.base.config.e) Class.forName(str).newInstance();
        } catch (Throwable unused) {
            Logger.f365497g.i("RMonitor_config", "new creator fail {" + str + "}");
            return null;
        }
    }

    public void a(com.tencent.rmonitor.base.config.e eVar) {
        if (eVar != null && !this.f365304a.contains(eVar)) {
            this.f365304a.add(eVar);
            if (Logger.verbos) {
                Logger.f365497g.v("RMonitor_config", "add config creator {" + eVar + "}");
            }
        }
    }

    @Override // com.tencent.rmonitor.base.config.e
    public k createConfig(String str) {
        b();
        Iterator<com.tencent.rmonitor.base.config.e> it = this.f365304a.iterator();
        k kVar = null;
        while (it.hasNext() && (kVar = it.next().createConfig(str)) == null) {
        }
        return kVar;
    }

    @Override // com.tencent.rmonitor.base.config.e
    public m createPluginConfig(String str) {
        b();
        Iterator<com.tencent.rmonitor.base.config.e> it = this.f365304a.iterator();
        m mVar = null;
        while (it.hasNext() && (mVar = it.next().createPluginConfig(str)) == null) {
        }
        return mVar;
    }

    ConfigCreatorProxy() {
        this.f365304a = new CopyOnWriteArrayList<>();
        this.f365305b = false;
    }
}
