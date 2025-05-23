package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/kernel/api/IKickApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "shouldIgnoreNotifyMsfStatusChanged", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/api/IKickApi$b;", "processor", "", "setupKickListen", "tearDownKickListen", "Lcom/tencent/qqnt/kernel/api/IKickApi$a;", "interceptor", "setKickInterceptor", "Lcom/tencent/qqnt/kernel/nativeinterface/KickedInfo;", "info", "kick", "a", "b", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IKickApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/kernel/api/IKickApi$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/KickedInfo;", "info", "", "a", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface a {
        boolean a(@Nullable KickedInfo info);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/kernel/api/IKickApi$b;", "", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/kernel/nativeinterface/KickedInfo;", "info", "", "a", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface b {
        void a(@NotNull AppRuntime appRuntime, @Nullable KickedInfo info);
    }

    void kick(@NotNull KickedInfo info);

    void setKickInterceptor(@Nullable a interceptor);

    void setupKickListen(@NotNull AppRuntime app, @NotNull b processor);

    boolean shouldIgnoreNotifyMsfStatusChanged();

    void tearDownKickListen(@NotNull AppRuntime app);
}
