package com.tencent.mobileqq.kandian.biz.video.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsIPCClient;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsIPCClient$a;", "observer", "", "addObserver", "removeObserver", "", "action", "Landroid/os/Bundle;", "params", "callServer", "a", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"tool"})
/* loaded from: classes15.dex */
public interface IVideoFeedsIPCClient extends QRouteApi {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsIPCClient$a;", "", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface a {
    }

    void addObserver(@NotNull a observer);

    @Nullable
    Bundle callServer(@Nullable String action, @Nullable Bundle params);

    void removeObserver(@NotNull a observer);
}
