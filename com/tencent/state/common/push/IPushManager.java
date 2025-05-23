package com.tencent.state.common.push;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0003H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/common/push/IPushManager;", "", "register", "", "listener", "Lcom/tencent/state/common/push/IPushListener;", "setPushInterceptor", "interceptor", "Lcom/tencent/state/common/push/IPushInterceptor;", "start", "stop", "unregister", "unregisterAll", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IPushManager {
    void register(IPushListener listener);

    void setPushInterceptor(IPushInterceptor interceptor);

    void start();

    void stop();

    void unregister(IPushListener listener);

    void unregisterAll();
}
