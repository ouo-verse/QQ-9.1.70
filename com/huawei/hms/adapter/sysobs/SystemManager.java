package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class SystemManager {

    /* renamed from: a, reason: collision with root package name */
    private static SystemManager f36683a = new SystemManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f36684b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static SystemNotifier f36685c = new a();

    SystemManager() {
    }

    public static SystemManager getInstance() {
        return f36683a;
    }

    public static SystemNotifier getSystemNotifier() {
        return f36685c;
    }

    public void notifyNoticeResult(int i3) {
        f36685c.notifyNoticeObservers(i3);
    }

    public void notifyResolutionResult(Intent intent, String str) {
        f36685c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i3) {
        f36685c.notifyObservers(i3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements SystemNotifier {

        /* renamed from: a, reason: collision with root package name */
        private final List<SystemObserver> f36686a = new ArrayList();

        a() {
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyNoticeObservers(int i3) {
            synchronized (SystemManager.f36684b) {
                Iterator<SystemObserver> it = this.f36686a.iterator();
                while (it.hasNext()) {
                    if (it.next().onNoticeResult(i3)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.f36684b) {
                Iterator<SystemObserver> it = this.f36686a.iterator();
                while (it.hasNext()) {
                    if (it.next().onSolutionResult(intent, str)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void registerObserver(SystemObserver systemObserver) {
            if (systemObserver != null && !this.f36686a.contains(systemObserver)) {
                synchronized (SystemManager.f36684b) {
                    this.f36686a.add(systemObserver);
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.f36684b) {
                this.f36686a.remove(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(int i3) {
            synchronized (SystemManager.f36684b) {
                Iterator<SystemObserver> it = this.f36686a.iterator();
                while (it.hasNext()) {
                    if (it.next().onUpdateResult(i3)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
