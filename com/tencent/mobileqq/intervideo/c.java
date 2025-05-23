package com.tencent.mobileqq.intervideo;

import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class c implements PluginManagerUpdater {

    /* renamed from: a, reason: collision with root package name */
    private final File f238150a;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Callable<File> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public File call() throws Exception {
            if (c.this.f238150a.exists()) {
                return c.this.f238150a;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements Callable<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f238152d;

        b(File file) {
            this.f238152d = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(c.this.f238150a.exists() && this.f238152d == c.this.f238150a);
        }
    }

    public c(String str) {
        this.f238150a = new File("/data/local/tmp/" + str + "PluginManager.apk");
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public File getLatest() {
        if (this.f238150a.exists()) {
            return this.f238150a;
        }
        return null;
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public boolean wasUpdating() {
        return false;
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public Future<Boolean> isAvailable(File file) {
        return ThreadManagerExecutor.getExecutorService(16).submit(new b(file));
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public Future<File> update() {
        return ThreadManagerExecutor.getExecutorService(16).submit(new a());
    }
}
