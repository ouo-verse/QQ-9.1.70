package com.tencent.mobileqq.gateway.localphone.ecdh;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IKernelECDHService;
import com.tencent.qqnt.kernel.nativeinterface.ISendECDHRequestCallback;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.QZoneContant;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneReq;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;
import tencent.im.login.GetLocalPhone$OIDBGetSessionIDReq;
import tencent.im.login.GetLocalPhone$OIDBGetSessionIDRsp;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJC\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J(\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J(\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneLogoutModule;", "", "", "serviceType", "Landroid/os/Bundle;", "extra", "Lcom/tencent/mobileqq/gateway/localphone/ecdh/i;", "", tl.h.F, "(ILandroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionId", "f", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "phoneCode", "phoneType", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneRsp;", "g", "(Ljava/lang/String;Ljava/lang/String;IILandroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "j", QzoneIPCModule.RESULT_CODE, "", "costTime", "i", "Lne1/a;", "callback", "extras", "k", "<init>", "()V", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class LocalPhoneLogoutModule {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneLogoutModule$a;", "", "", "END_GET_LOCAL_PHONE_REPORT", "Ljava/lang/String;", "", "GET_PHONE_SERVICE", "I", "GET_SESSION_ID_SERVICE", "START_GET_LOCAL_PHONE_REPORT", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gateway.localphone.ecdh.LocalPhoneLogoutModule$a, reason: from kotlin metadata */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "rsp", "", "kotlin.jvm.PlatformType", "onResponse"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class b implements ISendECDHRequestCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<GetLocalPhone$OIDBGetPhoneRsp>> f213609a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super i<GetLocalPhone$OIDBGetPhoneRsp>> cancellableContinuation) {
            this.f213609a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ISendECDHRequestCallback
        public final void onResponse(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                return;
            }
            if (i3 != 0) {
                QLog.e("LocalPhoneLogoutModule", 1, "getPhoneToken failed, failed error code: " + i3);
                CancellableContinuation<i<GetLocalPhone$OIDBGetPhoneRsp>> cancellableContinuation = this.f213609a;
                i iVar = new i(-1, null, "getPhoneToken failed");
                if (cancellableContinuation.isActive()) {
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                    return;
                }
                QLog.e("LocalPhone", 1, "getPhoneTokensafeResume call failed ");
                return;
            }
            if (bArr == null) {
                QLog.e("LocalPhoneLogoutModule", 1, "getPhone success, but data is null!");
                CancellableContinuation<i<GetLocalPhone$OIDBGetPhoneRsp>> cancellableContinuation2 = this.f213609a;
                i iVar2 = new i(-1, null, "getPhoneToken data is null!");
                if (cancellableContinuation2.isActive()) {
                    cancellableContinuation2.resumeWith(Result.m476constructorimpl(iVar2));
                    return;
                }
                QLog.e("LocalPhone", 1, "getPhoneTokensafeResume call failed ");
                return;
            }
            try {
                GetLocalPhone$OIDBGetPhoneRsp getLocalPhone$OIDBGetPhoneRsp = new GetLocalPhone$OIDBGetPhoneRsp();
                getLocalPhone$OIDBGetPhoneRsp.mergeFrom(bArr);
                QLog.d("LocalPhoneLogoutModule", 1, "getPhone finish");
                CancellableContinuation<i<GetLocalPhone$OIDBGetPhoneRsp>> cancellableContinuation3 = this.f213609a;
                i iVar3 = new i(0, getLocalPhone$OIDBGetPhoneRsp, null);
                if (cancellableContinuation3.isActive()) {
                    cancellableContinuation3.resumeWith(Result.m476constructorimpl(iVar3));
                } else {
                    QLog.e("LocalPhone", 1, "getPhoneTokensafeResume call failed ");
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.e("LocalPhoneLogoutModule", 1, "data unload failed!!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "rsp", "", "kotlin.jvm.PlatformType", "onResponse"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class c implements ISendECDHRequestCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<String>> f213610a;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super i<String>> cancellableContinuation) {
            this.f213610a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ISendECDHRequestCallback
        public final void onResponse(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                return;
            }
            if (i3 != 0) {
                QLog.e("LocalPhoneLogoutModule", 1, "getSession error code: " + i3);
                CancellableContinuation<i<String>> cancellableContinuation = this.f213610a;
                i iVar = new i(-1, null, "getSessionID onFailed !!");
                if (cancellableContinuation.isActive()) {
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                    return;
                }
                QLog.e("LocalPhone", 1, "getSessionIDsafeResume call failed ");
                return;
            }
            if (bArr == null) {
                CancellableContinuation<i<String>> cancellableContinuation2 = this.f213610a;
                i iVar2 = new i(-1, null, "getSessionID data is null!");
                if (cancellableContinuation2.isActive()) {
                    cancellableContinuation2.resumeWith(Result.m476constructorimpl(iVar2));
                } else {
                    QLog.e("LocalPhone", 1, "getSessionIDsafeResume call failed ");
                }
                QLog.e("LocalPhoneLogoutModule", 1, "getSessionID success, but data is null!");
                return;
            }
            try {
                GetLocalPhone$OIDBGetSessionIDRsp getLocalPhone$OIDBGetSessionIDRsp = new GetLocalPhone$OIDBGetSessionIDRsp();
                getLocalPhone$OIDBGetSessionIDRsp.mergeFrom(bArr);
                String str = getLocalPhone$OIDBGetSessionIDRsp.str_session_id.get();
                if (TextUtils.isEmpty(str)) {
                    QLog.e("LocalPhoneLogoutModule", 1, "getSessionID session is null");
                    CancellableContinuation<i<String>> cancellableContinuation3 = this.f213610a;
                    i iVar3 = new i(-1, null, "getSessionID session is null");
                    if (cancellableContinuation3.isActive()) {
                        cancellableContinuation3.resumeWith(Result.m476constructorimpl(iVar3));
                        return;
                    }
                    QLog.e("LocalPhone", 1, "getSessionIDsafeResume call failed ");
                    return;
                }
                CancellableContinuation<i<String>> cancellableContinuation4 = this.f213610a;
                i iVar4 = new i(0, str, null);
                if (cancellableContinuation4.isActive()) {
                    cancellableContinuation4.resumeWith(Result.m476constructorimpl(iVar4));
                } else {
                    QLog.e("LocalPhone", 1, "getSessionIDsafeResume call failed ");
                }
                QLog.d("LocalPhoneLogoutModule", 1, "onSuccess sessionId: " + str);
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.e("LocalPhoneLogoutModule", 1, "data unload failed!!");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19427);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LocalPhoneLogoutModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(String str, Continuation<? super i<String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LocalPhoneLogoutModule$getMaskPhone$2(str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(String str, String str2, int i3, int i16, Bundle bundle, Continuation<? super i<GetLocalPhone$OIDBGetPhoneRsp>> continuation) {
        Continuation intercepted;
        boolean z16;
        String str3;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d("LocalPhoneLogoutModule", 1, " start getPhone ");
        GetLocalPhone$OIDBGetPhoneReq getLocalPhone$OIDBGetPhoneReq = new GetLocalPhone$OIDBGetPhoneReq();
        getLocalPhone$OIDBGetPhoneReq.str_session_id.set(str);
        getLocalPhone$OIDBGetPhoneReq.int32_phone_data_type.set(i3);
        getLocalPhone$OIDBGetPhoneReq.str_phone_code.set(str2);
        int i17 = 0;
        if (bundle != null) {
            z16 = bundle.getBoolean("bool_compare_mibao");
        } else {
            z16 = false;
        }
        getLocalPhone$OIDBGetPhoneReq.bool_compare_mibao.set(z16);
        String str4 = null;
        if (bundle != null) {
            str3 = bundle.getString("req_sig");
        } else {
            str3 = null;
        }
        if (!TextUtils.isEmpty(str3)) {
            getLocalPhone$OIDBGetPhoneReq.str_new_device_check_sig.set(str3);
        }
        if (bundle != null) {
            str4 = bundle.getString("uin");
        }
        String str5 = str4;
        if (bundle != null) {
            i17 = bundle.getInt(IPublicAccountBrowser.KEY_UIN_TYPE);
        }
        int i18 = i17;
        if (bundle != null && bundle.containsKey("sig_type") && bundle.containsKey("str_sig")) {
            int i19 = bundle.getInt("sig_type", -1);
            String string = bundle.getString("str_sig", "");
            QLog.d("LocalPhoneLogoutModule", 4, "getPhoneToken type: " + i19 + ", sigStr: " + string);
            getLocalPhone$OIDBGetPhoneReq.msg_ldm_sig.sig_type.set(i19);
            getLocalPhone$OIDBGetPhoneReq.msg_ldm_sig.str_sig.set(string);
            getLocalPhone$OIDBGetPhoneReq.msg_ldm_sig.setHasFlag(true);
        }
        IKernelECDHService a16 = a.f213611a.a();
        if (a16 != null) {
            a16.sendOIDBRequest(QZoneContant.QZ_START_QZAPP_REQ, i16, i18, str5, getLocalPhone$OIDBGetPhoneReq.toByteArray(), new b(cancellableContinuationImpl));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h(int i3, Bundle bundle, Continuation<? super i<String>> continuation) {
        Continuation intercepted;
        String str;
        int i16;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d("LocalPhoneLogoutModule", 1, "start getSessionID ");
        GetLocalPhone$OIDBGetSessionIDReq getLocalPhone$OIDBGetSessionIDReq = new GetLocalPhone$OIDBGetSessionIDReq();
        String str2 = null;
        if (bundle != null) {
            str = bundle.getString("req_sig");
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            getLocalPhone$OIDBGetSessionIDReq.str_new_device_check_sig.set(str);
        }
        if (bundle != null) {
            str2 = bundle.getString("uin");
        }
        String str3 = str2;
        if (bundle != null) {
            i16 = bundle.getInt(IPublicAccountBrowser.KEY_UIN_TYPE);
        } else {
            i16 = 0;
        }
        int i17 = i16;
        IKernelECDHService a16 = a.f213611a.a();
        if (a16 != null) {
            a16.sendOIDBRequest(37069, i3, i17, str3, getLocalPhone$OIDBGetSessionIDReq.toByteArray(), new c(cancellableContinuationImpl));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
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
            CorountineFunKt.e(f16, "LocalPhoneLogoutModule", null, null, null, new LocalPhoneLogoutModule$startGetPhone$1(this, serviceType, phoneType, extras, callback, null), 14, null);
        }
    }
}
