package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cm<T> {

    /* renamed from: d, reason: collision with root package name */
    protected final LinkedHashMap<String, QFSBaseFeedChildPresenter<T>> f86069d = new LinkedHashMap<>();

    public void b(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter<T> qFSBaseFeedChildPresenter = this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.C0(hVar);
            }
        }
    }

    public void c(QFSBaseFeedChildPresenter<T> qFSBaseFeedChildPresenter) {
        if (qFSBaseFeedChildPresenter == null) {
            return;
        }
        String name = qFSBaseFeedChildPresenter.getClass().getName();
        if (this.f86069d.get(name) != null) {
            QLog.e("QFSFeedPresenterManager", 1, "[registerPresenter] you can not register same class presenter, className: " + name, new RuntimeException());
        }
        this.f86069d.put(qFSBaseFeedChildPresenter.getClass().getName(), qFSBaseFeedChildPresenter);
        qFSBaseFeedChildPresenter.W0(this);
    }

    public void d(QFSBaseFeedChildPresenter<T> qFSBaseFeedChildPresenter) {
        if (qFSBaseFeedChildPresenter == null) {
            return;
        }
        this.f86069d.remove(qFSBaseFeedChildPresenter.getClass().getName());
        qFSBaseFeedChildPresenter.W0(null);
    }
}
