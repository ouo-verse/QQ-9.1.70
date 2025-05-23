package com.tencent.rmonitor.bigbitmap;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.data.j;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.lifecycle.f;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.FileUtil;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import l04.b;
import l04.c;
import l04.e;
import p04.d;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BigBitmapMonitor extends QAPMMonitorPlugin {

    /* renamed from: m, reason: collision with root package name */
    private static volatile BigBitmapMonitor f365454m;

    /* renamed from: d, reason: collision with root package name */
    private final a f365455d = new a();

    /* renamed from: e, reason: collision with root package name */
    private final b f365456e = new b(new m04.a());

    /* renamed from: f, reason: collision with root package name */
    private final c f365457f = new c();

    /* renamed from: h, reason: collision with root package name */
    private final Set<String> f365458h = new HashSet();

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f365459i = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends f {

        /* renamed from: d, reason: collision with root package name */
        private final SparseArray<e> f365460d = new SparseArray<>();

        /* renamed from: e, reason: collision with root package name */
        private final Handler f365461e = new HandlerC9747a(Looper.getMainLooper());

        /* compiled from: P */
        /* renamed from: com.tencent.rmonitor.bigbitmap.BigBitmapMonitor$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        class HandlerC9747a extends Handler {
            HandlerC9747a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                Activity activity;
                if (message.what == 1 && (activity = (Activity) message.obj) != null && !activity.isFinishing()) {
                    a.this.b(activity);
                }
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(@NonNull Activity activity) {
            View decorView = activity.getWindow().getDecorView();
            ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
            e eVar = new e(com.tencent.rmonitor.common.util.c.a(activity, null), decorView, BigBitmapMonitor.this.f365456e, BigBitmapMonitor.this.f365457f);
            viewTreeObserver.addOnGlobalLayoutListener(eVar);
            this.f365460d.put(decorView.hashCode(), eVar);
        }

        @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
        public void onDestroy(@NonNull Activity activity) {
            this.f365461e.removeMessages(1, activity);
            View decorView = activity.getWindow().getDecorView();
            ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
            e eVar = this.f365460d.get(decorView.hashCode());
            if (eVar != null && AndroidVersion.isOverJellyBean()) {
                viewTreeObserver.removeOnGlobalLayoutListener(eVar);
            }
        }

        @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
        public void onPostCreate(@NonNull Activity activity) {
            String simpleName = activity.getClass().getSimpleName();
            if (BigBitmapMonitor.this.h(simpleName)) {
                Logger.f365497g.d("RMonitor_BigBitmap_Monitor", simpleName, " is excluded");
            } else if (AndroidVersion.isOverN()) {
                b(activity);
            } else {
                Handler handler = this.f365461e;
                handler.sendMessage(Message.obtain(handler, 1, activity));
            }
        }
    }

    BigBitmapMonitor() {
    }

    private void g() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(FileUtil.j());
        String str = File.separator;
        sb5.append(str);
        sb5.append("dumpfile");
        sb5.append(str);
        sb5.append(BuglyMonitorName.MEMORY_BIG_BITMAP);
        sb5.append(str);
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (this.f365459i.compareAndSet(false, true)) {
            this.f365456e.a(new p04.b());
            this.f365456e.a(new d());
            this.f365456e.a(new p04.c());
        }
    }

    public static BigBitmapMonitor getInstance() {
        if (f365454m == null) {
            synchronized (BigBitmapMonitor.class) {
                if (f365454m == null) {
                    f365454m = new BigBitmapMonitor();
                }
            }
        }
        return f365454m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(String str) {
        return this.f365458h.contains(str);
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (!AndroidVersion.isOverJellyBean()) {
            Logger.f365497g.w("RMonitor_BigBitmap_Monitor", "BigBitMap don't support below JellyBean");
            return;
        }
        g();
        stop();
        LifecycleCallback.r(this.f365455d);
        RMonitorFeatureHelper.getInstance().onPluginStarted(j.a(BuglyMonitorName.MEMORY_BIG_BITMAP));
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        LifecycleCallback.s(this.f365455d);
        RMonitorFeatureHelper.getInstance().onPluginClosed(j.a(BuglyMonitorName.MEMORY_BIG_BITMAP));
    }
}
