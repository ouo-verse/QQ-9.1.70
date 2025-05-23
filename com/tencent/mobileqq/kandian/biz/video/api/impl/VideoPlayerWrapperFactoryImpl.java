package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayerWrapperFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o52.c;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoPlayerWrapperFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPlayerWrapperFactory;", "Landroid/content/Context;", "context", "Lo52/c;", "createPlayer", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class VideoPlayerWrapperFactoryImpl implements IVideoPlayerWrapperFactory {
    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayerWrapperFactory
    public c createPlayer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new VideoPlayerWrapper(context);
    }
}
