package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.biz.video.ReadInJoyPlayerFactory;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory;
import f62.a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0096\u0001\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/ReadInJoyPlayerFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayerFactory;", "", "sceneType", "Lf62/a;", "createPlayer", "", "token", "", "autoAttachVideoView", "openMonet", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ReadInJoyPlayerFactoryImpl implements IReadInJoyPlayerFactory {
    private final /* synthetic */ ReadInJoyPlayerFactory $$delegate_0 = new ReadInJoyPlayerFactory();

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory
    public a createPlayer(int sceneType) {
        return this.$$delegate_0.createPlayer(sceneType);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory
    public a createPlayer(int sceneType, String token, boolean autoAttachVideoView, boolean openMonet) {
        return this.$$delegate_0.createPlayer(sceneType, token, autoAttachVideoView, openMonet);
    }
}
