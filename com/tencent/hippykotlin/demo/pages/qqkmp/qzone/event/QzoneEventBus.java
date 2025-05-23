package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event;

import com.tencent.kuikly.core.kmp.f;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneEventBus;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/IEventObserver;", "observer", "", "register", "unregister", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneBaseEvent;", "event", "postEvent", "", "TAG", "Ljava/lang/String;", "Lcom/tencent/kuikly/core/kmp/f;", "observers", "Lcom/tencent/kuikly/core/kmp/f;", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneEventBus {
    private static final String TAG = "QzoneEventBus";
    public static final QzoneEventBus INSTANCE = new QzoneEventBus();
    private static final f<IEventObserver> observers = new f<>();

    QzoneEventBus() {
    }

    public final void postEvent(QzoneBaseEvent event) {
        KLog.INSTANCE.d(TAG, "postEvent, event:" + event);
        for (IEventObserver iEventObserver : observers) {
            KLog.INSTANCE.d(TAG, "onEvent, event:" + event + ", observer:" + iEventObserver);
            if (iEventObserver != null) {
                iEventObserver.onEvent(event);
            }
        }
    }

    public final void register(IEventObserver observer) {
        KLog.INSTANCE.d(TAG, "register, observer:" + observer);
        observers.add(observer);
    }

    public final void unregister(IEventObserver observer) {
        KLog.INSTANCE.d(TAG, "unregister, observer:" + observer);
        observers.remove(observer);
    }
}
