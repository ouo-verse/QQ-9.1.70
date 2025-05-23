package com.tencent.biz.qqcircle.preload.task;

import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends BasePreLoadTask<QCircleCommentUpdateEvent> {

    /* renamed from: a, reason: collision with root package name */
    private final QCircleCommentUpdateEvent f91610a;

    public a(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        this.f91610a = qCircleCommentUpdateEvent;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener<QCircleCommentUpdateEvent> onPreLoadListener) {
        if (onPreLoadListener != null) {
            onPreLoadListener.onLoaded(this.f91610a);
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
