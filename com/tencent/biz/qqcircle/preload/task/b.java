package com.tencent.biz.qqcircle.preload.task;

import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.wink.api.WinkVideoCommentCompleteEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends BasePreLoadTask<WinkVideoCommentCompleteEvent> {

    /* renamed from: a, reason: collision with root package name */
    private final WinkVideoCommentCompleteEvent f91611a;

    public b(WinkVideoCommentCompleteEvent winkVideoCommentCompleteEvent) {
        this.f91611a = winkVideoCommentCompleteEvent;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener<WinkVideoCommentCompleteEvent> onPreLoadListener) {
        if (onPreLoadListener != null) {
            onPreLoadListener.onLoaded(this.f91611a);
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
