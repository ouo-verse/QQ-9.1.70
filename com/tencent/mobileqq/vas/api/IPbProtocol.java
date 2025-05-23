package com.tencent.mobileqq.vas.api;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0016\u0017J8\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH'J&\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH'J&\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH'J:\u0010\r\u001a\u00020\f\"\f\b\u0000\u0010\u0011*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IPbProtocol;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "Ljava/io/Serializable;", "", "cmd", "Lcom/tencent/mobileqq/pb/MessageMicro;", "req", "Ljava/lang/Class;", "rspClass", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observer", "", Const.BUNDLE_KEY_REQUEST, "reqStr", "", "reqBytes", "T", "Lcom/tencent/mobileqq/vas/api/IPbProtocol$a;", "data", "Lcom/tencent/mobileqq/vas/api/IPbProtocol$b;", "callback", "a", "b", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IPbProtocol extends QRouteApi, IVasManager, Serializable {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IPbProtocol$a;", "", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00e6\u0080\u0001\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00020\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IPbProtocol$b;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "", "isSuccess", "data", "", "onReceived", "(ZLcom/tencent/mobileqq/pb/MessageMicro;)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b<T extends MessageMicro<?>> {
        void onReceived(boolean isSuccess, @Nullable T data);
    }

    <T extends MessageMicro<?>> void request(@NotNull a data, @NotNull Class<T> rspClass, @NotNull b<T> callback);

    @Deprecated(message = "\u4f7f\u7528\u540e\u9762\u65b0\u589e\u7684\u63a5\u53e3")
    void request(@Nullable String cmd, @Nullable MessageMicro<?> req, @Nullable Class<?> rspClass, @Nullable BusinessObserver observer);

    @Deprecated(message = "\u4f7f\u7528\u540e\u9762\u65b0\u589e\u7684\u63a5\u53e3")
    void request(@Nullable String cmd, @Nullable String reqStr, @Nullable BusinessObserver observer);

    @Deprecated(message = "\u4f7f\u7528\u540e\u9762\u65b0\u589e\u7684\u63a5\u53e3")
    void request(@Nullable String cmd, @Nullable byte[] reqBytes, @Nullable BusinessObserver observer);
}
