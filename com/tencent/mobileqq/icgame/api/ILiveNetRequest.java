package com.tencent.mobileqq.icgame.api;

import androidx.lifecycle.LiveData;
import com.google.protobuf.nano.MessageNano;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0017J,\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u0003\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH&J,\u0010\u0002\u001a\u00020\t\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u000bH&JS\u0010\f\u001a\u00020\t\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b25\u0010\r\u001a1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00050\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u000ej\n\u0012\u0004\u0012\u0002H\u0005\u0018\u0001`\u0012H&J,\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u0014\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH&J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/ILiveNetRequest;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "sendRequest", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/icgame/api/sso/QQLiveResponse;", "T", "Lcom/google/protobuf/nano/MessageNano;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;", "", "callback", "Lcom/tencent/mobileqq/icgame/api/ILiveNetRequest$Callback;", "sendRequest2", "responsive", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "response", "Lcom/tencent/mobileqq/icgame/api/sso/Responsive;", "sendRequestOnFlow", "Lkotlinx/coroutines/flow/Flow;", "sendRequestOnSuspend", "(Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Callback", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILiveNetRequest extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/ILiveNetRequest$Callback;", "T", "", "onResponse", "", "response", "Lcom/tencent/mobileqq/icgame/api/sso/QQLiveResponse;", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public interface Callback<T> {
        void onResponse(@NotNull QQLiveResponse<T> response);
    }

    @NotNull
    <T extends MessageNano> LiveData<QQLiveResponse<T>> sendRequest(@NotNull LiveBaseRequest<? extends T> request);

    <T> void sendRequest(@NotNull LiveBaseRequest<? extends T> request, @Nullable Callback<T> callback);

    <T> void sendRequest2(@NotNull LiveBaseRequest<? extends T> request, @Nullable Function1<? super QQLiveResponse<T>, Unit> responsive);

    @NotNull
    <T extends MessageNano> Flow<QQLiveResponse<T>> sendRequestOnFlow(@NotNull LiveBaseRequest<? extends T> request);

    @Nullable
    <T extends MessageNano> Object sendRequestOnSuspend(@NotNull LiveBaseRequest<? extends T> liveBaseRequest, @NotNull Continuation<? super QQLiveResponse<T>> continuation);
}
