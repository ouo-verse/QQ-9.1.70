package com.tencent.mobileqq.gateway.localphone.ecdh;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.gateway.localphone.ecdh.LocalPhoneECDHHandler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneReq;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;
import tencent.im.login.GetLocalPhone$OIDBGetSessionIDReq;
import tencent.im.login.GetLocalPhone$OIDBGetSessionIDRsp;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJO\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002J(\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J(\u0010\u001c\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneLoginModule;", "", "", "serviceType", "", "newDeviceSig", "Lcom/tencent/mobileqq/gateway/localphone/ecdh/i;", "g", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionId", "d", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "phoneCode", "phoneType", "Landroid/os/Bundle;", "extra", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneRsp;", "e", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "j", QzoneIPCModule.RESULT_CODE, "", "costTime", "i", "Lne1/a;", "callback", "extras", "k", "<init>", "()V", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class LocalPhoneLoginModule {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneLoginModule$a;", "", "", "END_GET_LOCAL_PHONE_REPORT", "Ljava/lang/String;", "START_GET_LOCAL_PHONE_REPORT", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gateway.localphone.ecdh.LocalPhoneLoginModule$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneLoginModule$b", "Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneECDHHandler$b;", "", "data", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements LocalPhoneECDHHandler.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<GetLocalPhone$OIDBGetPhoneRsp>> f213606a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super i<GetLocalPhone$OIDBGetPhoneRsp>> cancellableContinuation) {
            this.f213606a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.gateway.localphone.ecdh.LocalPhoneECDHHandler.b
        public void onFail(int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            QLog.e("LocalPhoneLoginModule", 1, "getPhone onFail errCode: " + errorCode + " errMsg: " + errorMsg);
            CancellableContinuation<i<GetLocalPhone$OIDBGetPhoneRsp>> cancellableContinuation = this.f213606a;
            i iVar = new i(errorCode, null, errorMsg);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("LocalPhone", 1, "getPhoneTokensafeResume call failed ");
        }

        @Override // com.tencent.mobileqq.gateway.localphone.ecdh.LocalPhoneECDHHandler.b
        public void onSuccess(@Nullable Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, data);
                return;
            }
            QLog.d("LocalPhoneLoginModule", 1, "getPhone onSuccess");
            if (data == null) {
                QLog.e("LocalPhoneLoginModule", 1, "getPhone success, but data is null!");
                CancellableContinuation<i<GetLocalPhone$OIDBGetPhoneRsp>> cancellableContinuation = this.f213606a;
                i iVar = new i(-1, null, "getPhoneToken data is null!");
                if (cancellableContinuation.isActive()) {
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                    return;
                }
                QLog.e("LocalPhone", 1, "getPhoneTokensafeResume call failed ");
                return;
            }
            try {
                CancellableContinuation<i<GetLocalPhone$OIDBGetPhoneRsp>> cancellableContinuation2 = this.f213606a;
                i iVar2 = new i(0, (GetLocalPhone$OIDBGetPhoneRsp) data, null);
                if (cancellableContinuation2.isActive()) {
                    cancellableContinuation2.resumeWith(Result.m476constructorimpl(iVar2));
                } else {
                    QLog.e("LocalPhone", 1, "getPhoneTokensafeResume call failed ");
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.e("LocalPhoneLoginModule", 1, "data unload failed!!");
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneLoginModule$c", "Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneECDHHandler$b;", "", "data", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements LocalPhoneECDHHandler.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<String>> f213607a;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super i<String>> cancellableContinuation) {
            this.f213607a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.gateway.localphone.ecdh.LocalPhoneECDHHandler.b
        public void onFail(int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            QLog.e("LocalPhoneLoginModule", 1, "getSessionID onFailed !! error code: " + errorCode + " msg: " + errorMsg);
            CancellableContinuation<i<String>> cancellableContinuation = this.f213607a;
            i iVar = new i(-1, null, "getSessionID onFailed !!");
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("LocalPhone", 1, "getSessionIDsafeResume call failed ");
        }

        @Override // com.tencent.mobileqq.gateway.localphone.ecdh.LocalPhoneECDHHandler.b
        public void onSuccess(@Nullable Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, data);
                return;
            }
            if (data == null) {
                QLog.e("LocalPhoneLoginModule", 1, "getSessionID success, but data is null!");
                CancellableContinuation<i<String>> cancellableContinuation = this.f213607a;
                i iVar = new i(-1, null, "getSessionID data is null!");
                if (cancellableContinuation.isActive()) {
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                    return;
                }
                QLog.e("LocalPhone", 1, "getSessionIDsafeResume call failed ");
                return;
            }
            try {
                String str = ((GetLocalPhone$OIDBGetSessionIDRsp) data).str_session_id.get();
                if (TextUtils.isEmpty(str)) {
                    QLog.e("LocalPhoneLoginModule", 1, "getSessionID session is null");
                    CancellableContinuation<i<String>> cancellableContinuation2 = this.f213607a;
                    i iVar2 = new i(-1, null, "getSessionID session is null");
                    if (cancellableContinuation2.isActive()) {
                        cancellableContinuation2.resumeWith(Result.m476constructorimpl(iVar2));
                        return;
                    }
                    QLog.e("LocalPhone", 1, "getSessionIDsafeResume call failed ");
                    return;
                }
                CancellableContinuation<i<String>> cancellableContinuation3 = this.f213607a;
                i iVar3 = new i(0, str, null);
                if (cancellableContinuation3.isActive()) {
                    cancellableContinuation3.resumeWith(Result.m476constructorimpl(iVar3));
                } else {
                    QLog.e("LocalPhone", 1, "getSessionIDsafeResume call failed ");
                }
                QLog.d("LocalPhoneLoginModule", 1, "onSuccess sessionId: " + str);
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.e("LocalPhoneLoginModule", 1, "data unload failed!!");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19339);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LocalPhoneLoginModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object d(String str, Continuation<? super i<String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LocalPhoneLoginModule$getMaskPhone$2(str, null), continuation);
    }

    private final Object e(String str, String str2, int i3, int i16, String str3, Bundle bundle, Continuation<? super i<GetLocalPhone$OIDBGetPhoneRsp>> continuation) {
        Continuation intercepted;
        boolean z16;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d("LocalPhoneLoginModule", 1, " start getPhone ");
        GetLocalPhone$OIDBGetPhoneReq getLocalPhone$OIDBGetPhoneReq = new GetLocalPhone$OIDBGetPhoneReq();
        getLocalPhone$OIDBGetPhoneReq.str_session_id.set(str);
        getLocalPhone$OIDBGetPhoneReq.int32_phone_data_type.set(i3);
        getLocalPhone$OIDBGetPhoneReq.str_phone_code.set(str2);
        if (bundle != null) {
            z16 = bundle.getBoolean("bool_compare_mibao");
        } else {
            z16 = false;
        }
        getLocalPhone$OIDBGetPhoneReq.bool_compare_mibao.set(z16);
        if (str3 != null) {
            getLocalPhone$OIDBGetPhoneReq.str_new_device_check_sig.set(str3);
        }
        if (bundle != null && bundle.containsKey("sig_type") && bundle.containsKey("str_sig")) {
            int i17 = bundle.getInt("sig_type", -1);
            String string = bundle.getString("str_sig", "");
            QLog.d("LocalPhoneLoginModule", 4, "getPhoneToken type: " + i17 + ", sigStr: " + string);
            getLocalPhone$OIDBGetPhoneReq.msg_ldm_sig.sig_type.set(i17);
            getLocalPhone$OIDBGetPhoneReq.msg_ldm_sig.str_sig.set(string);
            getLocalPhone$OIDBGetPhoneReq.msg_ldm_sig.setHasFlag(true);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(LocalPhoneECDHHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.gateway.localphone.ecdh.LocalPhoneECDHHandler");
        ((LocalPhoneECDHHandler) businessHandler).D2(getLocalPhone$OIDBGetPhoneReq, i16, new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object f(LocalPhoneLoginModule localPhoneLoginModule, String str, String str2, int i3, int i16, String str3, Bundle bundle, Continuation continuation, int i17, Object obj) {
        String str4;
        if ((i17 & 16) != 0) {
            str4 = null;
        } else {
            str4 = str3;
        }
        return localPhoneLoginModule.e(str, str2, i3, i16, str4, bundle, continuation);
    }

    private final Object g(int i3, String str, Continuation<? super i<String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d("LocalPhoneLoginModule", 1, "start getSessionID ");
        GetLocalPhone$OIDBGetSessionIDReq getLocalPhone$OIDBGetSessionIDReq = new GetLocalPhone$OIDBGetSessionIDReq();
        if (str != null) {
            getLocalPhone$OIDBGetSessionIDReq.str_new_device_check_sig.set(str);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(LocalPhoneECDHHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.gateway.localphone.ecdh.LocalPhoneECDHHandler");
        ((LocalPhoneECDHHandler) businessHandler).E2(getLocalPhone$OIDBGetSessionIDReq, i3, new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object h(LocalPhoneLoginModule localPhoneLoginModule, int i3, String str, Continuation continuation, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = null;
        }
        return localPhoneLoginModule.g(i3, str, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(int serviceType, int phoneType, int resultCode, long costTime) {
        ReportController.r(null, "dc00898", "", "", "0X800C5D3", "0X800C5D3", serviceType, resultCode, String.valueOf(phoneType), String.valueOf(costTime), "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(int serviceType, int phoneType) {
        ReportController.r(null, "dc00898", "", "", "0X800C5D2", "0X800C5D2", serviceType, 0, String.valueOf(phoneType), "", "", "");
    }

    public final void k(int phoneType, int serviceType, @NotNull ne1.a callback, @Nullable Bundle extras) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(phoneType), Integer.valueOf(serviceType), callback, extras);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "LocalPhoneLoginModule", null, null, null, new LocalPhoneLoginModule$startGetPhone$1(this, serviceType, phoneType, callback, extras, null), 14, null);
        }
    }
}
