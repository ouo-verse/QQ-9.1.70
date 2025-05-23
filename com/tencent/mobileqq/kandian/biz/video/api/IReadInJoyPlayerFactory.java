package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import f62.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J*\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayerFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "sceneType", "Lf62/a;", "createPlayer", "", "token", "", "autoAttachVideoView", "openMonet", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IReadInJoyPlayerFactory extends QRouteApi {
    @NotNull
    a createPlayer(int sceneType);

    @NotNull
    a createPlayer(int sceneType, @Nullable String token, boolean autoAttachVideoView, boolean openMonet);
}
