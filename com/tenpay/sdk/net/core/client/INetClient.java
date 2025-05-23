package com.tenpay.sdk.net.core.client;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tenpay.sdk.net.core.result.NetResult;
import com.tenpay.sdk.net.core.task.NetTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J(\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/sdk/net/core/client/INetClient;", "T", "Lcom/tenpay/sdk/net/core/task/NetTask;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tenpay/sdk/net/core/result/NetResult;", "", "sendRequest", "", "netTask", "callback", "Lkotlin/Function1;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface INetClient<T extends NetTask<?>, R extends NetResult> {
    void sendRequest(@NotNull NetTask<?> netTask, @NotNull Function1<? super R, Unit> callback);
}
