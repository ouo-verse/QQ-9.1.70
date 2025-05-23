package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.biz.video.api.IVideoExtractFrameManager;
import com.tencent.mobileqq.kandian.biz.video.c;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoExtractFrameManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoExtractFrameManager;", "()V", "onEnterBackground", "", "onEnterForeground", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class VideoExtractFrameManagerImpl implements IVideoExtractFrameManager {
    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoExtractFrameManager
    public void onEnterBackground() {
        c.c();
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoExtractFrameManager
    public void onEnterForeground() {
        c.d();
    }
}
