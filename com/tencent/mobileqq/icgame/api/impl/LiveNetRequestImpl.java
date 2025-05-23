package com.tencent.mobileqq.icgame.api.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.icgame.api.ILiveNetRequest;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.icgame.api.login.ILiveLoginApi;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.icgame.sso.SsoCmdReportConfig;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;
import w32.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b(\u0010)J=\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\f\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000bH\u0002JE\u0010\u0012\u001a\u00020\n\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2'\u0010\u0011\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004H\u0002JE\u0010\u0013\u001a\u00020\n\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2'\u0010\u0011\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004H\u0002J,\u0010\u0015\u001a\u00020\n\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0014H\u0016JS\u0010\u0018\u001a\u00020\n\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f25\u0010\u0017\u001a1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0016H\u0016J,\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u001a\"\b\b\u0000\u0010\u000e*\u00020\u00192\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J1\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u000e*\u00020\u00192\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u001d\"\b\b\u0000\u0010\u000e*\u00020\u00192\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016R\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/impl/LiveNetRequestImpl;", "Lcom/tencent/mobileqq/icgame/api/ILiveNetRequest;", "", "appId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/icgame/api/sso/QQLiveResponse;", "Lcom/tencent/mobileqq/icgame/login/LiveLoginInfo;", "Lkotlin/ParameterName;", "name", "response", "", "Lcom/tencent/mobileqq/icgame/api/login/LoginCallback;", "callback", "doLogin", "T", "Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;", Const.BUNDLE_KEY_REQUEST, "wrapper", "sendRequestWrapper", "doSendRequest", "Lcom/tencent/mobileqq/icgame/api/ILiveNetRequest$Callback;", "sendRequest", "Lcom/tencent/mobileqq/icgame/api/sso/Responsive;", "responsive", "sendRequest2", "Lcom/google/protobuf/nano/MessageNano;", "Landroidx/lifecycle/LiveData;", "sendRequestOnSuspend", "(Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "sendRequestOnFlow", "", "enableSsoReporter", "Z", "", "ssoReportBlackList", "Ljava/util/List;", "Lw32/a;", "protoReport", "Lw32/a;", "<init>", "()V", "Companion", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LiveNetRequestImpl implements ILiveNetRequest {

    @NotNull
    public static final String LOG_TAG = "ICGameVSRequest|ICGameLiveNetRequestImpl";
    private final boolean enableSsoReporter;

    @NotNull
    private final w32.a protoReport;

    @NotNull
    private final List<String> ssoReportBlackList;

    public LiveNetRequestImpl() {
        ArrayList arrayList = new ArrayList();
        this.ssoReportBlackList = arrayList;
        w32.a protocolsReport = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1078").getProtocolsReport();
        Intrinsics.checkNotNullExpressionValue(protocolsReport, "sdk.protocolsReport");
        this.protoReport = protocolsReport;
        Object configBean = ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getConfigBean(ICGameQMCCConfigKeysKt.KEY_ICGAME_LIVE_SDK_SSO_CMD_REPORT_CONFIG, SsoCmdReportConfig.class, new SsoCmdReportConfig(false, null, 3, null));
        Intrinsics.checkNotNullExpressionValue(configBean, "api(IICGameConfigApi::cl\u2026dReportConfig()\n        )");
        SsoCmdReportConfig ssoCmdReportConfig = (SsoCmdReportConfig) configBean;
        boolean enable = ssoCmdReportConfig.getEnable();
        this.enableSsoReporter = enable;
        if (enable) {
            arrayList.addAll(ssoCmdReportConfig.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doLogin(String appId, Function1<? super QQLiveResponse<LiveLoginInfo>, Unit> callback) {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (account == null) {
            account = "";
        }
        ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).login(appId, account, callback);
    }

    private final <T> void doSendRequest(final LiveBaseRequest<? extends T> request, final Function1<? super QQLiveResponse<T>, Unit> wrapper) {
        final long currentTimeMillis = System.currentTimeMillis();
        VSNetworkHelper.getInstance().sendRequest(request, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.icgame.api.impl.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                LiveNetRequestImpl.doSendRequest$lambda$2(LiveBaseRequest.this, this, currentTimeMillis, wrapper, baseRequest, z16, j3, str, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doSendRequest$lambda$2(LiveBaseRequest request, LiveNetRequestImpl this$0, long j3, Function1 wrapper, BaseRequest baseRequest, boolean z16, long j16, String str, Object obj) {
        Object obj2;
        long j17;
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(wrapper, "$wrapper");
        if (obj == null) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        QQLiveResponse qQLiveResponse = new QQLiveResponse(baseRequest, z16, j16, str, obj2);
        if (qQLiveResponse.isFailed()) {
            rt0.a.INSTANCE.h(LOG_TAG, "sendRequestWrapper", "request failed, cmd=" + LiveNetRequestImplKt.getFullCmd(request) + ", retCode=" + j16 + ", errMsg=" + str);
        } else {
            a.Companion companion = rt0.a.INSTANCE;
            if (companion.m()) {
                companion.g(LOG_TAG, "sendRequestWrapper", "request success, cmd=" + LiveNetRequestImplKt.getFullCmd(request));
            }
        }
        this$0.protoReport.i(request, qQLiveResponse);
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (this$0.enableSsoReporter && !this$0.ssoReportBlackList.contains(LiveNetRequestImplKt.getFullCmd(request))) {
            String wantAppId = request.getWantAppId();
            String fullCmd = LiveNetRequestImplKt.getFullCmd(request);
            LiveLoginInfo loginInfo = request.getLoginInfo();
            if (loginInfo != null) {
                j17 = loginInfo.getUid();
            } else {
                j17 = 0;
            }
            com.tencent.mobileqq.icgame.sso.b.a(wantAppId, currentTimeMillis, fullCmd, j16, str, 5, "", j17, AppSetting.f99551k);
        }
        wrapper.invoke(qQLiveResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void sendRequestWrapper(final LiveBaseRequest<? extends T> request, final Function1<? super QQLiveResponse<T>, Unit> wrapper) {
        if (!this.protoReport.isInit()) {
            final long currentTimeMillis = System.currentTimeMillis();
            rt0.a.INSTANCE.k(LOG_TAG, "sendRequestWrapper", "init protoReport, cmd=" + LiveNetRequestImplKt.getFullCmd(request));
            this.protoReport.e(new a.InterfaceC11457a() { // from class: com.tencent.mobileqq.icgame.api.impl.b
                @Override // w32.a.InterfaceC11457a
                public final void a(boolean z16) {
                    LiveNetRequestImpl.sendRequestWrapper$lambda$1(currentTimeMillis, this, request, wrapper, z16);
                }
            });
            return;
        }
        this.protoReport.j(request);
        doSendRequest(request, wrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendRequestWrapper$lambda$1(long j3, LiveNetRequestImpl this$0, LiveBaseRequest request, Function1 wrapper, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(wrapper, "$wrapper");
        rt0.a.INSTANCE.k(LOG_TAG, "sendRequestWrapper", "init protoReport, cost " + (System.currentTimeMillis() - j3));
        this$0.protoReport.j(request);
        this$0.doSendRequest(request, wrapper);
    }

    @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest
    public <T> void sendRequest(@NotNull final LiveBaseRequest<? extends T> request, @Nullable final ILiveNetRequest.Callback<T> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        a.Companion companion = rt0.a.INSTANCE;
        if (companion.l()) {
            companion.g(LOG_TAG, "sendRequest_callback", "cmd=" + LiveNetRequestImplKt.getFullCmd(request));
        }
        if (request.needLogin()) {
            doLogin(request.getWantAppId(), new Function1<QQLiveResponse<LiveLoginInfo>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequest$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<LiveLoginInfo> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<LiveLoginInfo> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.isFailed()) {
                        rt0.a.INSTANCE.h(LiveNetRequestImpl.LOG_TAG, "sendRequest_callback", "login failed, " + it.getRetCode() + ", " + it.getErrMsg());
                        ILiveNetRequest.Callback<T> callback2 = callback;
                        if (callback2 != 0) {
                            callback2.onResponse(new QQLiveResponse(null, it.isSuccess(), it.getRetCode(), it.getErrMsg(), null));
                            return;
                        }
                        return;
                    }
                    rt0.a.INSTANCE.g(LiveNetRequestImpl.LOG_TAG, "sendRequest_callback", "login success");
                    request.setLoginInfo(it.getRsp());
                    LiveNetRequestImpl liveNetRequestImpl = this;
                    LiveBaseRequest<T> liveBaseRequest = request;
                    final ILiveNetRequest.Callback<T> callback3 = callback;
                    liveNetRequestImpl.sendRequestWrapper(liveBaseRequest, new Function1<QQLiveResponse<T>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequest$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke((QQLiveResponse) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull QQLiveResponse<T> res) {
                            Intrinsics.checkNotNullParameter(res, "res");
                            ILiveNetRequest.Callback<T> callback4 = callback3;
                            if (callback4 != null) {
                                callback4.onResponse(res);
                            }
                        }
                    });
                }
            });
        } else {
            request.setLoginInfo(null);
            sendRequestWrapper(request, new Function1<QQLiveResponse<T>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequest$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke((QQLiveResponse) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull QQLiveResponse<T> res) {
                    Intrinsics.checkNotNullParameter(res, "res");
                    ILiveNetRequest.Callback<T> callback2 = callback;
                    if (callback2 != null) {
                        callback2.onResponse(res);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest
    public <T> void sendRequest2(@NotNull final LiveBaseRequest<? extends T> request, @Nullable final Function1<? super QQLiveResponse<T>, Unit> responsive) {
        Intrinsics.checkNotNullParameter(request, "request");
        a.Companion companion = rt0.a.INSTANCE;
        if (companion.l()) {
            companion.g(LOG_TAG, "sendRequest_responsive", "cmd=" + LiveNetRequestImplKt.getFullCmd(request));
        }
        if (request.needLogin()) {
            doLogin(request.getWantAppId(), new Function1<QQLiveResponse<LiveLoginInfo>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequest2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<LiveLoginInfo> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<LiveLoginInfo> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.isFailed()) {
                        rt0.a.INSTANCE.h(LiveNetRequestImpl.LOG_TAG, "sendRequest_responsive", "login failed, " + it.getRetCode() + ", " + it.getErrMsg());
                        Function1<QQLiveResponse<T>, Unit> function1 = responsive;
                        if (function1 != 0) {
                            function1.invoke(new QQLiveResponse(null, it.isSuccess(), it.getRetCode(), it.getErrMsg(), null));
                            return;
                        }
                        return;
                    }
                    rt0.a.INSTANCE.g(LiveNetRequestImpl.LOG_TAG, "sendRequest_responsive", "login success");
                    request.setLoginInfo(it.getRsp());
                    LiveNetRequestImpl liveNetRequestImpl = this;
                    LiveBaseRequest<T> liveBaseRequest = request;
                    final Function1<QQLiveResponse<T>, Unit> function12 = responsive;
                    liveNetRequestImpl.sendRequestWrapper(liveBaseRequest, new Function1<QQLiveResponse<T>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequest2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke((QQLiveResponse) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull QQLiveResponse<T> res) {
                            Intrinsics.checkNotNullParameter(res, "res");
                            Function1<QQLiveResponse<T>, Unit> function13 = function12;
                            if (function13 != null) {
                                function13.invoke(res);
                            }
                        }
                    });
                }
            });
        } else {
            request.setLoginInfo(null);
            sendRequestWrapper(request, new Function1<QQLiveResponse<T>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequest2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke((QQLiveResponse) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull QQLiveResponse<T> res) {
                    Intrinsics.checkNotNullParameter(res, "res");
                    Function1<QQLiveResponse<T>, Unit> function1 = responsive;
                    if (function1 != null) {
                        function1.invoke(res);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest
    @NotNull
    public <T extends MessageNano> Flow<QQLiveResponse<T>> sendRequestOnFlow(@NotNull LiveBaseRequest<? extends T> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return FlowKt.callbackFlow(new LiveNetRequestImpl$sendRequestOnFlow$1(request, this, null));
    }

    @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest
    @Nullable
    public <T extends MessageNano> Object sendRequestOnSuspend(@NotNull final LiveBaseRequest<? extends T> liveBaseRequest, @NotNull Continuation<? super QQLiveResponse<T>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        a.Companion companion = rt0.a.INSTANCE;
        if (companion.l()) {
            companion.g(LOG_TAG, "sendRequestOnSuspend", "cmd=" + LiveNetRequestImplKt.getFullCmd(liveBaseRequest));
        }
        if (liveBaseRequest.needLogin()) {
            doLogin(liveBaseRequest.getWantAppId(), new Function1<QQLiveResponse<LiveLoginInfo>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequestOnSuspend$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<LiveLoginInfo> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<LiveLoginInfo> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.isFailed()) {
                        a.Companion companion2 = rt0.a.INSTANCE;
                        companion2.h(LiveNetRequestImpl.LOG_TAG, "sendRequestOnSuspend", "login failed, " + it.getRetCode() + ", " + it.getErrMsg());
                        if (cancellableContinuationImpl.isActive()) {
                            Continuation continuation2 = cancellableContinuationImpl;
                            Result.Companion companion3 = Result.INSTANCE;
                            continuation2.resumeWith(Result.m476constructorimpl(new QQLiveResponse(null, it.isSuccess(), it.getRetCode(), it.getErrMsg(), null)));
                            return;
                        } else {
                            companion2.k(LiveNetRequestImpl.LOG_TAG, "sendRequestOnSuspend", "cont not active, cmd=" + LiveNetRequestImplKt.getFullCmd(liveBaseRequest));
                            return;
                        }
                    }
                    rt0.a.INSTANCE.g(LiveNetRequestImpl.LOG_TAG, "sendRequestOnSuspend", "login success");
                    liveBaseRequest.setLoginInfo(it.getRsp());
                    LiveNetRequestImpl liveNetRequestImpl = this;
                    final LiveBaseRequest<T> liveBaseRequest2 = liveBaseRequest;
                    final CancellableContinuation<QQLiveResponse<T>> cancellableContinuation = cancellableContinuationImpl;
                    liveNetRequestImpl.sendRequestWrapper(liveBaseRequest2, new Function1<QQLiveResponse<T>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequestOnSuspend$2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke((QQLiveResponse) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull QQLiveResponse<T> res) {
                            Intrinsics.checkNotNullParameter(res, "res");
                            if (cancellableContinuation.isActive()) {
                                cancellableContinuation.resumeWith(Result.m476constructorimpl(res));
                                return;
                            }
                            rt0.a.INSTANCE.k(LiveNetRequestImpl.LOG_TAG, "sendRequestOnSuspend", "cont not active, cmd=" + LiveNetRequestImplKt.getFullCmd(liveBaseRequest2));
                        }
                    });
                }
            });
        } else {
            liveBaseRequest.setLoginInfo(null);
            sendRequestWrapper(liveBaseRequest, new Function1<QQLiveResponse<T>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequestOnSuspend$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke((QQLiveResponse) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull QQLiveResponse<T> res) {
                    Intrinsics.checkNotNullParameter(res, "res");
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(res));
                        return;
                    }
                    rt0.a.INSTANCE.k(LiveNetRequestImpl.LOG_TAG, "sendRequestOnSuspend", "cont not active, cmd=" + LiveNetRequestImplKt.getFullCmd(liveBaseRequest));
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest
    @NotNull
    public <T extends MessageNano> LiveData<QQLiveResponse<T>> sendRequest(@NotNull final LiveBaseRequest<? extends T> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        a.Companion companion = rt0.a.INSTANCE;
        if (companion.l()) {
            companion.g(LOG_TAG, "sendRequest_liveData", "cmd=" + LiveNetRequestImplKt.getFullCmd(request));
        }
        final MutableLiveData mutableLiveData = new MutableLiveData();
        if (request.needLogin()) {
            doLogin(request.getWantAppId(), new Function1<QQLiveResponse<LiveLoginInfo>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequest$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<LiveLoginInfo> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<LiveLoginInfo> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.isFailed()) {
                        rt0.a.INSTANCE.h(LiveNetRequestImpl.LOG_TAG, "sendRequest_liveData", "login failed, " + it.getRetCode() + ", " + it.getErrMsg());
                        mutableLiveData.postValue(new QQLiveResponse(null, it.isSuccess(), it.getRetCode(), it.getErrMsg(), null));
                        return;
                    }
                    rt0.a.INSTANCE.g(LiveNetRequestImpl.LOG_TAG, "sendRequest_liveData", "login success");
                    request.setLoginInfo(it.getRsp());
                    LiveNetRequestImpl liveNetRequestImpl = this;
                    LiveBaseRequest<T> liveBaseRequest = request;
                    final MutableLiveData<QQLiveResponse<T>> mutableLiveData2 = mutableLiveData;
                    liveNetRequestImpl.sendRequestWrapper(liveBaseRequest, new Function1<QQLiveResponse<T>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequest$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke((QQLiveResponse) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull QQLiveResponse<T> res) {
                            Intrinsics.checkNotNullParameter(res, "res");
                            mutableLiveData2.postValue(res);
                        }
                    });
                }
            });
        } else {
            request.setLoginInfo(null);
            sendRequestWrapper(request, new Function1<QQLiveResponse<T>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequest$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke((QQLiveResponse) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull QQLiveResponse<T> res) {
                    Intrinsics.checkNotNullParameter(res, "res");
                    mutableLiveData.postValue(res);
                }
            });
        }
        return mutableLiveData;
    }
}
