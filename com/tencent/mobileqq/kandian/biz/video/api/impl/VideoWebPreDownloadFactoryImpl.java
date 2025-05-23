package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownloadFactory;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import f62.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoWebPreDownloadFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoWebPreDownloadFactory;", "Lf62/d;", OperateCustomButton.OPERATE_CREATE, "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class VideoWebPreDownloadFactoryImpl implements IVideoWebPreDownloadFactory {
    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownloadFactory
    public d create() {
        return new com.tencent.mobileqq.kandian.glue.video.d();
    }
}
