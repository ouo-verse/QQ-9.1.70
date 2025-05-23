package com.tencent.mobileqq.vas.api;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import eipc.EIPCCallback;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J.\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IPbProtocolSSo;", "Ljava/io/Serializable;", Const.BUNDLE_KEY_REQUEST, "", "cmd", "", "req", "Lcom/tencent/mobileqq/pb/MessageMicro;", "rspClass", "Ljava/lang/Class;", "callback", "Leipc/EIPCCallback;", "reqBytes", "", "reqStr", "traceId", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IPbProtocolSSo extends Serializable {
    void request(@Nullable String cmd, @Nullable MessageMicro<?> req, @Nullable Class<?> rspClass, @Nullable EIPCCallback callback);

    void request(@Nullable String cmd, @Nullable String reqStr, @Nullable EIPCCallback callback);

    void request(@Nullable String cmd, @Nullable String reqStr, @NotNull String traceId, @Nullable EIPCCallback callback);

    void request(@Nullable String cmd, @Nullable byte[] reqBytes, @Nullable EIPCCallback callback);
}
