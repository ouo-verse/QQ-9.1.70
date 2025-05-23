package com.tencent.biz.qqcircle.immersive.manager;

import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qqcircle.immersive.events.QFSLifecycleCollectionEvent;
import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c implements IQQFrontBackListener {

    /* renamed from: e, reason: collision with root package name */
    private static volatile c f87207e;

    /* renamed from: d, reason: collision with root package name */
    private final Set<a> f87208d = new CopyOnWriteArraySet();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void b(QFSLifecycleCollectionEvent qFSLifecycleCollectionEvent);
    }

    c() {
        QCircleListenerProxyManager.getInstance().addQQFrontBackListener(this);
    }

    public static c d() {
        if (f87207e == null) {
            synchronized (c.class) {
                if (f87207e == null) {
                    f87207e = new c();
                }
            }
        }
        return f87207e;
    }

    private void e(QFSLifecycleCollectionEvent qFSLifecycleCollectionEvent) {
        Set<a> set = this.f87208d;
        if (set != null && !set.isEmpty()) {
            Iterator<a> it = this.f87208d.iterator();
            while (it.hasNext()) {
                it.next().b(qFSLifecycleCollectionEvent);
            }
        }
    }

    public void a() {
        e(new QFSLifecycleCollectionEvent(QFSLifecycleCollectionEvent.QFSCollectionType.BUSINESS_LIFECYCLE, new QFSLifecycleCollectionEvent.b(QFSLifecycleCollectionEvent.QFSBusinessLifecycleEnum.RELEASE)));
    }

    public void b(String str, e30.b bVar, int i3) {
        e(new QFSLifecycleCollectionEvent(QFSLifecycleCollectionEvent.QFSCollectionType.LIST_LIFECYCLE, new QFSLifecycleCollectionEvent.c(str, bVar, i3, QFSLifecycleCollectionEvent.QFSListLifecycleEnum.SELECTED)));
    }

    public void c(int i3, String str, int i16, QFSLifecycleCollectionEvent.QFSPageLifecycleEnum qFSPageLifecycleEnum) {
        e(new QFSLifecycleCollectionEvent(QFSLifecycleCollectionEvent.QFSCollectionType.PAGE_LIFECYCLE, new QFSLifecycleCollectionEvent.d(i3, str, i16, qFSPageLifecycleEnum)));
    }

    public void f(a aVar) {
        Set<a> set;
        if (aVar != null && (set = this.f87208d) != null) {
            set.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQQFrontBackListener
    public void onQQEnterBackground() {
        e(new QFSLifecycleCollectionEvent(QFSLifecycleCollectionEvent.QFSCollectionType.APPLICATION_LIFECYCLE, new QFSLifecycleCollectionEvent.a(QFSLifecycleCollectionEvent.QFSApplicationLifecycleEnum.BACKGROUND)));
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQQFrontBackListener
    public void onQQEnterForeground() {
        e(new QFSLifecycleCollectionEvent(QFSLifecycleCollectionEvent.QFSCollectionType.APPLICATION_LIFECYCLE, new QFSLifecycleCollectionEvent.a(QFSLifecycleCollectionEvent.QFSApplicationLifecycleEnum.FOREGROUND)));
    }
}
