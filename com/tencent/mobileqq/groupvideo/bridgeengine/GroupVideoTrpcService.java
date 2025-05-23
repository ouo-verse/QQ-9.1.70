package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.groupvideo.api.GroupVideoRemoteResponse;
import com.tencent.mobileqq.groupvideo.ipc.GroupVideoQIPCClient;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.api.f;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J6\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016JB\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/bridgeengine/GroupVideoTrpcService;", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IGroupVideoTrpcService;", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IGroupVideoNTPushListener;", "listener", "", "addPushListener", "removePushListener", "", "ssoCmd", "", "ssoCmdStr", "", "data", "serializationType", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IGroupVideoTrpcCallback;", "callback", "sendOIDBRequest", "service", "method", "refer", "sendRequest", "<init>", "()V", "Companion", "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GroupVideoTrpcService implements IGroupVideoTrpcService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int DEFAULT_OIDB_CMD = 4752;
    private static final int EC_ERROR_PARAMS_INVALID = -1;
    public static final int IM_OIDB_CMD = 4753;
    public static final int PUSH_OIDB_CMD = 4754;

    @NotNull
    private static final String TAG = "GroupVideoTrpcService";

    @NotNull
    private static final AtomicInteger reqNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/bridgeengine/GroupVideoTrpcService$a;", "", "", "DEFAULT_OIDB_CMD", "I", "EC_ERROR_PARAMS_INVALID", "IM_OIDB_CMD", "PUSH_OIDB_CMD", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicInteger;", "reqNum", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.groupvideo.bridgeengine.GroupVideoTrpcService$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/groupvideo/bridgeengine/GroupVideoTrpcService$b", "Lcom/tencent/mobileqq/groupvideo/api/a;", "Lcom/tencent/mobileqq/groupvideo/api/GroupVideoRemoteResponse;", "successResponse", "", "a", "errorResponse", "b", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements com.tencent.mobileqq.groupvideo.api.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f213708a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f213709b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f213710c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IGroupVideoTrpcCallback f213711d;

        b(long j3, int i3, String str, IGroupVideoTrpcCallback iGroupVideoTrpcCallback) {
            this.f213708a = j3;
            this.f213709b = i3;
            this.f213710c = str;
            this.f213711d = iGroupVideoTrpcCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), str, iGroupVideoTrpcCallback);
            }
        }

        @Override // com.tencent.mobileqq.groupvideo.api.a
        public void a(@NotNull GroupVideoRemoteResponse successResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) successResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            long currentTimeMillis = System.currentTimeMillis() - this.f213708a;
            int i3 = this.f213709b;
            if (i3 != 4752 || (i3 == 4752 && QLog.isColorLevel())) {
                QLog.i(GroupVideoTrpcService.TAG, 1, "onReceive sendRequest success,  cost " + currentTimeMillis + " ms, sendKey " + this.f213710c + ", , code: " + successResponse.getCode() + ", msg: " + successResponse.getMsg());
            }
            IGroupVideoTrpcCallback iGroupVideoTrpcCallback = this.f213711d;
            if (iGroupVideoTrpcCallback != null) {
                iGroupVideoTrpcCallback.onSuccess(new IGroupVideoTrpcRemoteResponse(successResponse.getCode(), successResponse.getMsg(), successResponse.getData(), 0, ""));
            }
        }

        @Override // com.tencent.mobileqq.groupvideo.api.a
        public void b(@NotNull GroupVideoRemoteResponse errorResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            QLog.i(GroupVideoTrpcService.TAG, 1, "onReceive sendRequest error, cost " + (System.currentTimeMillis() - this.f213708a) + " ms, sendKey " + this.f213710c + ", , code: " + errorResponse.getCode() + ", msg: " + errorResponse.getMsg());
            IGroupVideoTrpcCallback iGroupVideoTrpcCallback = this.f213711d;
            if (iGroupVideoTrpcCallback != null) {
                iGroupVideoTrpcCallback.onError(new IGroupVideoTrpcRemoteResponse(errorResponse.getCode(), errorResponse.getMsg(), errorResponse.getData(), 0, ""));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/groupvideo/bridgeengine/GroupVideoTrpcService$c", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "successRsp", "", "b", "errorRsp", "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGroupVideoTrpcCallback f213712a;

        c(IGroupVideoTrpcCallback iGroupVideoTrpcCallback) {
            this.f213712a = iGroupVideoTrpcCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iGroupVideoTrpcCallback);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse errorRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorRsp);
                return;
            }
            Intrinsics.checkNotNullParameter(errorRsp, "errorRsp");
            QLog.i(GroupVideoTrpcService.TAG, 1, "onReceive sendRequest error, successRsp = " + errorRsp);
            IGroupVideoTrpcCallback iGroupVideoTrpcCallback = this.f213712a;
            if (iGroupVideoTrpcCallback != null) {
                iGroupVideoTrpcCallback.onError(new IGroupVideoTrpcRemoteResponse(errorRsp.code, errorRsp.f293941msg, errorRsp.data, errorRsp.channelCode, errorRsp.channelMsg));
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse successRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) successRsp);
                return;
            }
            Intrinsics.checkNotNullParameter(successRsp, "successRsp");
            QLog.i(GroupVideoTrpcService.TAG, 1, "onReceive sendRequest success, successRsp = " + successRsp);
            IGroupVideoTrpcCallback iGroupVideoTrpcCallback = this.f213712a;
            if (iGroupVideoTrpcCallback != null) {
                iGroupVideoTrpcCallback.onSuccess(new IGroupVideoTrpcRemoteResponse(successRsp.code, successRsp.f293941msg, successRsp.data, successRsp.channelCode, successRsp.channelMsg));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23448);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
            reqNum = new AtomicInteger(0);
        }
    }

    public GroupVideoTrpcService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IGroupVideoTrpcService
    public void addPushListener(@Nullable IGroupVideoNTPushListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else {
            GroupVideoQIPCClient.INSTANCE.a().v(listener);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IGroupVideoTrpcService
    public void removePushListener(@Nullable IGroupVideoNTPushListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            GroupVideoQIPCClient.INSTANCE.a().v(null);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IGroupVideoTrpcService
    public void sendOIDBRequest(int ssoCmd, @Nullable String ssoCmdStr, @Nullable byte[] data, int serializationType, @Nullable IGroupVideoTrpcCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(ssoCmd), ssoCmdStr, data, Integer.valueOf(serializationType), callback);
            return;
        }
        if (ssoCmd != 0 && data != null) {
            if (!AppNetConnInfo.isNetSupport()) {
                QLog.i(TAG, 1, "#sendOIDBRequest: without network!! return null");
                IGroupVideoTrpcRemoteResponse iGroupVideoTrpcRemoteResponse = new IGroupVideoTrpcRemoteResponse(-1, "#sendRequest: without network!! return null", null, 0, "");
                if (callback != null) {
                    callback.onError(iGroupVideoTrpcRemoteResponse);
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str = ssoCmdStr + "_" + reqNum.incrementAndGet();
            if (ssoCmd != 4752 || (ssoCmd == 4752 && QLog.isColorLevel())) {
                QLog.i(TAG, 1, "onReceive sendRequest sendKey " + str);
            }
            GroupVideoQIPCClient.INSTANCE.a().s(ssoCmd, ssoCmdStr, data, serializationType, new b(currentTimeMillis, ssoCmd, str, callback));
            return;
        }
        QLog.e(TAG, 1, "sendOIDBRequest error, params is invalid.");
        if (callback != null) {
            callback.onSuccess(new IGroupVideoTrpcRemoteResponse(-1, "send request params invalid", null, 0, ""));
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IGroupVideoTrpcService
    public void sendRequest(@Nullable String service, @Nullable String method, @Nullable byte[] data, int serializationType, @Nullable String refer, @Nullable IGroupVideoTrpcCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, service, method, data, Integer.valueOf(serializationType), refer, callback);
            return;
        }
        if (service != null && method != null && data != null) {
            if (!AppNetConnInfo.isNetSupport()) {
                QLog.i(TAG, 1, "#sendRequest: without network!! return null");
                IGroupVideoTrpcRemoteResponse iGroupVideoTrpcRemoteResponse = new IGroupVideoTrpcRemoteResponse(-1, "#sendRequest: without network!! return null", null, 0, "");
                if (callback != null) {
                    callback.onError(iGroupVideoTrpcRemoteResponse);
                    return;
                }
                return;
            }
            ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest(service, method, data, serializationType, null, new c(callback));
            return;
        }
        QLog.e(TAG, 1, "sendRequest error, params is invalid.");
        if (callback != null) {
            callback.onSuccess(new IGroupVideoTrpcRemoteResponse(-1, "send request params invalid", null, 0, ""));
        }
    }
}
