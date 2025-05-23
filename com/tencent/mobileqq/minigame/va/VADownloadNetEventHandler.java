package com.tencent.mobileqq.minigame.va;

import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncObjectResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/VADownloadNetEventHandler;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "resultCallback", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/AsyncObjectResult;", "(Lcom/tencent/qqmini/sdk/launcher/core/proxy/AsyncObjectResult;)V", "callbackRef", "Lmqq/util/WeakReference;", "onNetChangeEvent", "", "p0", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class VADownloadNetEventHandler implements INetEventHandler {
    private final WeakReference<AsyncObjectResult> callbackRef;

    public VADownloadNetEventHandler(AsyncObjectResult resultCallback) {
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        this.callbackRef = new WeakReference<>(resultCallback);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
    public void onNetChangeEvent(boolean p06) {
        AsyncObjectResult asyncObjectResult = this.callbackRef.get();
        if (asyncObjectResult != null) {
            asyncObjectResult.onReceiveResult(p06, null);
        }
    }
}
