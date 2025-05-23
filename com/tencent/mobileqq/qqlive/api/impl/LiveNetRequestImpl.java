package com.tencent.mobileqq.qqlive.api.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062+\u0010\u0007\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\bj\u0002`\u000eH\u0002J,\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\t0\u0010\"\b\b\u0000\u0010\u0011*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0014H\u0016J,\u0010\u000f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00142\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u0015H\u0016JS\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u001425\u0010\u0017\u001a1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00110\t\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u0002H\u0011\u0018\u0001`\u0018H\u0016J,\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\t0\u001a\"\b\b\u0000\u0010\u0011*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0014H\u0016J/\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00110\t\"\b\b\u0000\u0010\u0011*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJH\u0010\u001d\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00142)\b\u0004\u0010\u001e\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00110\t\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\bH\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/LiveNetRequestImpl;", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest;", "()V", "doLogin", "", "appId", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "Lkotlin/ParameterName;", "name", "response", "Lcom/tencent/mobileqq/qqlive/api/login/LoginCallback;", "sendRequest", "Landroidx/lifecycle/LiveData;", "T", "Lcom/google/protobuf/nano/MessageNano;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "sendRequest2", "responsive", "Lcom/tencent/mobileqq/qqlive/api/sso/Responsive;", "sendRequestOnFlow", "Lkotlinx/coroutines/flow/Flow;", "sendRequestOnSuspend", "(Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRequestWrapper", "wrapper", "Companion", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class LiveNetRequestImpl implements ILiveNetRequest {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String LOG_TAG = "VSRequest|LiveNetRequestImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/LiveNetRequestImpl$Companion;", "", "()V", "LOG_TAG", "", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31740);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LiveNetRequestImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doLogin(final String appId, final Function1<? super QQLiveResponse<LiveLoginInfo>, Unit> callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            peekAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        }
        if (peekAppRuntime != null) {
            final String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            if (account == null) {
                account = "";
            }
            TicketManager ticketManager = (TicketManager) peekAppRuntime.getManager(2);
            if (ticketManager != null) {
                if (ticketManager.useAsyncTicketInterface()) {
                    ticketManager.getA2(bv.b(account, 0L), 16, new MainTicketCallback(appId, account, callback) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$doLogin$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ String $appId;
                        final /* synthetic */ Function1<QQLiveResponse<LiveLoginInfo>, Unit> $callback;
                        final /* synthetic */ String $uin;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            this.$appId = appId;
                            this.$uin = account;
                            this.$callback = callback;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, appId, account, callback);
                            }
                        }

                        @Override // mqq.manager.MainTicketCallback
                        public void onFail(int errorCode, @NotNull String errorMsg) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                            } else {
                                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                                QLog.i(LiveNetRequestImpl.LOG_TAG, 1, "doLogin async get login ticket fail");
                            }
                        }

                        @Override // mqq.manager.MainTicketCallback
                        public void onSuccess(@NotNull MainTicketInfo info) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(info, "info");
                            QLog.i(LiveNetRequestImpl.LOG_TAG, 1, "doLogin async get login ticket success");
                            ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).login(this.$appId, this.$uin, info.getA2(), this.$callback);
                        }
                    });
                    return;
                }
                String a26 = ticketManager.getA2(account);
                QLog.i(LOG_TAG, 1, "doLogin sync get login ticket");
                ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).login(appId, account, a26, callback);
            }
        }
    }

    private final <T> void sendRequestWrapper(final LiveBaseRequest<? extends T> request, final Function1<? super QQLiveResponse<T>, Unit> wrapper) {
        VSNetworkHelper.getInstance().sendRequest(request, new VSDispatchObserver.OnVSRspCallBack(request, wrapper) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequestWrapper$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ LiveBaseRequest<T> $request;
            final /* synthetic */ Function1<QQLiveResponse<T>, Unit> $wrapper;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$request = request;
                this.$wrapper = wrapper;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) request, (Object) wrapper);
                }
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                Object obj2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj);
                    return;
                }
                if (obj == null) {
                    obj2 = null;
                } else {
                    obj2 = obj;
                }
                QQLiveResponse<T> qQLiveResponse = new QQLiveResponse<>(baseRequest, z16, j3, str, obj2);
                if (qQLiveResponse.isFailed()) {
                    AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request failed, cmd=" + LiveNetRequestImplKt.getFullCmd(this.$request) + ", retCode=" + j3 + ", errMsg=" + str);
                } else {
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    if (companion.isColorLevel()) {
                        companion.d(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request success, cmd=" + LiveNetRequestImplKt.getFullCmd(this.$request));
                    }
                }
                this.$wrapper.invoke(qQLiveResponse);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest
    public <T> void sendRequest(@NotNull final LiveBaseRequest<? extends T> request, @Nullable final ILiveNetRequest.Callback<T> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.d(LOG_TAG, "sendRequest_callback", "cmd=" + LiveNetRequestImplKt.getFullCmd(request));
        }
        if (request.needLogin()) {
            doLogin(request.getAppId(), new Function1<QQLiveResponse<LiveLoginInfo>, Unit>(callback, request, this) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequest$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ILiveNetRequest.Callback<T> $callback;
                final /* synthetic */ LiveBaseRequest<T> $request;
                final /* synthetic */ LiveNetRequestImpl this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$callback = callback;
                    this.$request = request;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, callback, request, this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<LiveLoginInfo> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<LiveLoginInfo> it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.isFailed()) {
                        AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequest_callback", "login failed, " + it.getRetCode() + ", " + it.getErrMsg());
                        ILiveNetRequest.Callback<T> callback2 = this.$callback;
                        if (callback2 != 0) {
                            callback2.onResponse(new QQLiveResponse(null, it.isSuccess(), it.getRetCode(), it.getErrMsg(), null));
                            return;
                        }
                        return;
                    }
                    this.$request.setLoginInfo(it.getRsp());
                    final LiveBaseRequest<T> liveBaseRequest = this.$request;
                    final ILiveNetRequest.Callback<T> callback3 = this.$callback;
                    VSNetworkHelper.getInstance().sendRequest(liveBaseRequest, new VSDispatchObserver.OnVSRspCallBack(callback3) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequest$1$invoke$$inlined$sendRequestWrapper$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ ILiveNetRequest.Callback $callback$inlined;

                        {
                            this.$callback$inlined = callback3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) LiveBaseRequest.this, (Object) callback3);
                            }
                        }

                        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                            Object obj2;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj);
                                return;
                            }
                            if (obj == null) {
                                obj2 = null;
                            } else {
                                obj2 = obj;
                            }
                            QQLiveResponse<T> qQLiveResponse = new QQLiveResponse<>(baseRequest, z16, j3, str, obj2);
                            if (qQLiveResponse.isFailed()) {
                                AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request failed, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this) + ", retCode=" + j3 + ", errMsg=" + str);
                            } else {
                                AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                                if (companion2.isColorLevel()) {
                                    companion2.d(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request success, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this));
                                }
                            }
                            ILiveNetRequest.Callback callback4 = this.$callback$inlined;
                            if (callback4 != null) {
                                callback4.onResponse(qQLiveResponse);
                            }
                        }
                    });
                }
            });
        } else {
            request.setLoginInfo(null);
            VSNetworkHelper.getInstance().sendRequest(request, new VSDispatchObserver.OnVSRspCallBack(callback) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequest$$inlined$sendRequestWrapper$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ILiveNetRequest.Callback $callback$inlined;

                {
                    this.$callback$inlined = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveBaseRequest.this, (Object) callback);
                    }
                }

                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    Object obj2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj);
                        return;
                    }
                    if (obj == null) {
                        obj2 = null;
                    } else {
                        obj2 = obj;
                    }
                    QQLiveResponse<T> qQLiveResponse = new QQLiveResponse<>(baseRequest, z16, j3, str, obj2);
                    if (qQLiveResponse.isFailed()) {
                        AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request failed, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this) + ", retCode=" + j3 + ", errMsg=" + str);
                    } else {
                        AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                        if (companion2.isColorLevel()) {
                            companion2.d(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request success, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this));
                        }
                    }
                    ILiveNetRequest.Callback callback2 = this.$callback$inlined;
                    if (callback2 != null) {
                        callback2.onResponse(qQLiveResponse);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest
    public <T> void sendRequest2(@NotNull final LiveBaseRequest<? extends T> request, @Nullable final Function1<? super QQLiveResponse<T>, Unit> responsive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) responsive);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.d(LOG_TAG, "sendRequest_responsive", "cmd=" + LiveNetRequestImplKt.getFullCmd(request));
        }
        if (request.needLogin()) {
            doLogin(request.getAppId(), new Function1<QQLiveResponse<LiveLoginInfo>, Unit>(responsive, request, this) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequest2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ LiveBaseRequest<T> $request;
                final /* synthetic */ Function1<QQLiveResponse<T>, Unit> $responsive;
                final /* synthetic */ LiveNetRequestImpl this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$responsive = responsive;
                    this.$request = request;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, responsive, request, this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<LiveLoginInfo> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<LiveLoginInfo> it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.isFailed()) {
                        AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequest_responsive", "login failed, " + it.getRetCode() + ", " + it.getErrMsg());
                        Function1<QQLiveResponse<T>, Unit> function1 = this.$responsive;
                        if (function1 != 0) {
                            function1.invoke(new QQLiveResponse(null, it.isSuccess(), it.getRetCode(), it.getErrMsg(), null));
                            return;
                        }
                        return;
                    }
                    this.$request.setLoginInfo(it.getRsp());
                    final LiveBaseRequest<T> liveBaseRequest = this.$request;
                    final Function1<QQLiveResponse<T>, Unit> function12 = this.$responsive;
                    VSNetworkHelper.getInstance().sendRequest(liveBaseRequest, new VSDispatchObserver.OnVSRspCallBack(function12) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequest2$1$invoke$$inlined$sendRequestWrapper$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Function1 $responsive$inlined;

                        {
                            this.$responsive$inlined = function12;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) LiveBaseRequest.this, (Object) function12);
                            }
                        }

                        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                            Object obj2;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj);
                                return;
                            }
                            if (obj == null) {
                                obj2 = null;
                            } else {
                                obj2 = obj;
                            }
                            QQLiveResponse qQLiveResponse = new QQLiveResponse(baseRequest, z16, j3, str, obj2);
                            if (qQLiveResponse.isFailed()) {
                                AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request failed, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this) + ", retCode=" + j3 + ", errMsg=" + str);
                            } else {
                                AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                                if (companion2.isColorLevel()) {
                                    companion2.d(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request success, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this));
                                }
                            }
                            Function1 function13 = this.$responsive$inlined;
                            if (function13 != null) {
                                function13.invoke(qQLiveResponse);
                            }
                        }
                    });
                }
            });
        } else {
            request.setLoginInfo(null);
            VSNetworkHelper.getInstance().sendRequest(request, new VSDispatchObserver.OnVSRspCallBack(responsive) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequest2$$inlined$sendRequestWrapper$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1 $responsive$inlined;

                {
                    this.$responsive$inlined = responsive;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveBaseRequest.this, (Object) responsive);
                    }
                }

                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    Object obj2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj);
                        return;
                    }
                    if (obj == null) {
                        obj2 = null;
                    } else {
                        obj2 = obj;
                    }
                    QQLiveResponse qQLiveResponse = new QQLiveResponse(baseRequest, z16, j3, str, obj2);
                    if (qQLiveResponse.isFailed()) {
                        AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request failed, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this) + ", retCode=" + j3 + ", errMsg=" + str);
                    } else {
                        AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                        if (companion2.isColorLevel()) {
                            companion2.d(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request success, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this));
                        }
                    }
                    Function1 function1 = this.$responsive$inlined;
                    if (function1 != null) {
                        function1.invoke(qQLiveResponse);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest
    @NotNull
    public <T extends MessageNano> Flow<QQLiveResponse<T>> sendRequestOnFlow(@NotNull LiveBaseRequest<? extends T> request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Flow) iPatchRedirector.redirect((short) 6, (Object) this, (Object) request);
        }
        Intrinsics.checkNotNullParameter(request, "request");
        return FlowKt.callbackFlow(new LiveNetRequestImpl$sendRequestOnFlow$1(request, this, null));
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest
    @Nullable
    public <T extends MessageNano> Object sendRequestOnSuspend(@NotNull final LiveBaseRequest<? extends T> liveBaseRequest, @NotNull Continuation<? super QQLiveResponse<T>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.d(LOG_TAG, "sendRequestOnSuspend", "cmd=" + LiveNetRequestImplKt.getFullCmd(liveBaseRequest));
            }
            if (liveBaseRequest.needLogin()) {
                doLogin(liveBaseRequest.getAppId(), new Function1<QQLiveResponse<LiveLoginInfo>, Unit>(cancellableContinuationImpl, liveBaseRequest, this) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequestOnSuspend$2$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ CancellableContinuation<QQLiveResponse<T>> $cont;
                    final /* synthetic */ LiveBaseRequest<T> $request;
                    final /* synthetic */ LiveNetRequestImpl this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                        this.$cont = cancellableContinuationImpl;
                        this.$request = liveBaseRequest;
                        this.this$0 = this;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, cancellableContinuationImpl, liveBaseRequest, this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<LiveLoginInfo> qQLiveResponse) {
                        invoke2(qQLiveResponse);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull QQLiveResponse<LiveLoginInfo> it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (it.isFailed()) {
                            AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                            companion2.e(LiveNetRequestImpl.LOG_TAG, "sendRequestOnSuspend", "login failed, " + it.getRetCode() + ", " + it.getErrMsg());
                            if (this.$cont.isActive()) {
                                Continuation continuation2 = this.$cont;
                                Result.Companion companion3 = Result.INSTANCE;
                                continuation2.resumeWith(Result.m476constructorimpl(new QQLiveResponse(null, it.isSuccess(), it.getRetCode(), it.getErrMsg(), null)));
                                return;
                            } else {
                                companion2.i(LiveNetRequestImpl.LOG_TAG, "sendRequestOnSuspend", "cont not active, cmd=" + LiveNetRequestImplKt.getFullCmd(this.$request));
                                return;
                            }
                        }
                        this.$request.setLoginInfo(it.getRsp());
                        final LiveBaseRequest<T> liveBaseRequest2 = this.$request;
                        final CancellableContinuation<QQLiveResponse<T>> cancellableContinuation = this.$cont;
                        VSNetworkHelper.getInstance().sendRequest(liveBaseRequest2, new VSDispatchObserver.OnVSRspCallBack(cancellableContinuation, liveBaseRequest2) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequestOnSuspend$2$1$invoke$$inlined$sendRequestWrapper$1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ CancellableContinuation $cont$inlined;
                            final /* synthetic */ LiveBaseRequest $request$inlined;

                            {
                                this.$cont$inlined = cancellableContinuation;
                                this.$request$inlined = liveBaseRequest2;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, LiveBaseRequest.this, cancellableContinuation, liveBaseRequest2);
                                }
                            }

                            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                                Object obj2;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj);
                                    return;
                                }
                                if (obj == null) {
                                    obj2 = null;
                                } else {
                                    obj2 = obj;
                                }
                                QQLiveResponse qQLiveResponse = new QQLiveResponse(baseRequest, z16, j3, str, obj2);
                                if (qQLiveResponse.isFailed()) {
                                    AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request failed, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this) + ", retCode=" + j3 + ", errMsg=" + str);
                                } else {
                                    AegisLogger.Companion companion4 = AegisLogger.INSTANCE;
                                    if (companion4.isColorLevel()) {
                                        companion4.d(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request success, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this));
                                    }
                                }
                                if (this.$cont$inlined.isActive()) {
                                    this.$cont$inlined.resumeWith(Result.m476constructorimpl(qQLiveResponse));
                                    return;
                                }
                                AegisLogger.INSTANCE.i(LiveNetRequestImpl.LOG_TAG, "sendRequestOnSuspend", "cont not active, cmd=" + LiveNetRequestImplKt.getFullCmd(this.$request$inlined));
                            }
                        });
                    }
                });
            } else {
                liveBaseRequest.setLoginInfo(null);
                VSNetworkHelper.getInstance().sendRequest(liveBaseRequest, new VSDispatchObserver.OnVSRspCallBack(cancellableContinuationImpl, liveBaseRequest) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequestOnSuspend$lambda$4$$inlined$sendRequestWrapper$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ CancellableContinuation $cont$inlined;
                    final /* synthetic */ LiveBaseRequest $request$inlined;

                    {
                        this.$cont$inlined = cancellableContinuationImpl;
                        this.$request$inlined = liveBaseRequest;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, LiveBaseRequest.this, cancellableContinuationImpl, liveBaseRequest);
                        }
                    }

                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                        Object obj2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj);
                            return;
                        }
                        if (obj == null) {
                            obj2 = null;
                        } else {
                            obj2 = obj;
                        }
                        QQLiveResponse qQLiveResponse = new QQLiveResponse(baseRequest, z16, j3, str, obj2);
                        if (qQLiveResponse.isFailed()) {
                            AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request failed, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this) + ", retCode=" + j3 + ", errMsg=" + str);
                        } else {
                            AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                            if (companion2.isColorLevel()) {
                                companion2.d(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request success, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this));
                            }
                        }
                        if (this.$cont$inlined.isActive()) {
                            this.$cont$inlined.resumeWith(Result.m476constructorimpl(qQLiveResponse));
                            return;
                        }
                        AegisLogger.INSTANCE.i(LiveNetRequestImpl.LOG_TAG, "sendRequestOnSuspend", "cont not active, cmd=" + LiveNetRequestImplKt.getFullCmd(this.$request$inlined));
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
        return iPatchRedirector.redirect((short) 5, (Object) this, (Object) liveBaseRequest, (Object) continuation);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest
    @NotNull
    public <T extends MessageNano> LiveData<QQLiveResponse<T>> sendRequest(@NotNull final LiveBaseRequest<? extends T> request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this, (Object) request);
        }
        Intrinsics.checkNotNullParameter(request, "request");
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.d(LOG_TAG, "sendRequest_liveData", "cmd=" + LiveNetRequestImplKt.getFullCmd(request));
        }
        final MutableLiveData mutableLiveData = new MutableLiveData();
        if (request.needLogin()) {
            doLogin(request.getAppId(), new Function1<QQLiveResponse<LiveLoginInfo>, Unit>(mutableLiveData, request, this) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequest$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ MutableLiveData<QQLiveResponse<T>> $liveData;
                final /* synthetic */ LiveBaseRequest<T> $request;
                final /* synthetic */ LiveNetRequestImpl this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$liveData = mutableLiveData;
                    this.$request = request;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, mutableLiveData, request, this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<LiveLoginInfo> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<LiveLoginInfo> it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.isFailed()) {
                        AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequest_liveData", "login failed, " + it.getRetCode() + ", " + it.getErrMsg());
                        this.$liveData.postValue(new QQLiveResponse(null, it.isSuccess(), it.getRetCode(), it.getErrMsg(), null));
                        return;
                    }
                    this.$request.setLoginInfo(it.getRsp());
                    final LiveBaseRequest<T> liveBaseRequest = this.$request;
                    final MutableLiveData<QQLiveResponse<T>> mutableLiveData2 = this.$liveData;
                    VSNetworkHelper.getInstance().sendRequest(liveBaseRequest, new VSDispatchObserver.OnVSRspCallBack(mutableLiveData2) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequest$3$invoke$$inlined$sendRequestWrapper$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ MutableLiveData $liveData$inlined;

                        {
                            this.$liveData$inlined = mutableLiveData2;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) LiveBaseRequest.this, (Object) mutableLiveData2);
                            }
                        }

                        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                            Object obj2;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj);
                                return;
                            }
                            if (obj == null) {
                                obj2 = null;
                            } else {
                                obj2 = obj;
                            }
                            QQLiveResponse qQLiveResponse = new QQLiveResponse(baseRequest, z16, j3, str, obj2);
                            if (qQLiveResponse.isFailed()) {
                                AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request failed, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this) + ", retCode=" + j3 + ", errMsg=" + str);
                            } else {
                                AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                                if (companion2.isColorLevel()) {
                                    companion2.d(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request success, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this));
                                }
                            }
                            this.$liveData$inlined.postValue(qQLiveResponse);
                        }
                    });
                }
            });
        } else {
            request.setLoginInfo(null);
            VSNetworkHelper.getInstance().sendRequest(request, new VSDispatchObserver.OnVSRspCallBack(mutableLiveData) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequest$$inlined$sendRequestWrapper$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ MutableLiveData $liveData$inlined;

                {
                    this.$liveData$inlined = mutableLiveData;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveBaseRequest.this, (Object) mutableLiveData);
                    }
                }

                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    Object obj2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj);
                        return;
                    }
                    if (obj == null) {
                        obj2 = null;
                    } else {
                        obj2 = obj;
                    }
                    QQLiveResponse qQLiveResponse = new QQLiveResponse(baseRequest, z16, j3, str, obj2);
                    if (qQLiveResponse.isFailed()) {
                        AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request failed, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this) + ", retCode=" + j3 + ", errMsg=" + str);
                    } else {
                        AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                        if (companion2.isColorLevel()) {
                            companion2.d(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request success, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this));
                        }
                    }
                    this.$liveData$inlined.postValue(qQLiveResponse);
                }
            });
        }
        return mutableLiveData;
    }
}
