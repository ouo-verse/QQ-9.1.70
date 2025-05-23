package com.tencent.qqnt.kernel.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.SendRequestParam;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class KernelServiceImpl$getIDependsAdapter$1$onSendSSORequest$1 extends Lambda implements Function0<Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ SendRequestParam $param;
    final /* synthetic */ byte[] $pbBuffer;
    final /* synthetic */ long $requestId;
    final /* synthetic */ String $ssoCmd;
    final /* synthetic */ String $traceInfo;
    final /* synthetic */ HashMap<String, byte[]> $transInfoMap;
    final /* synthetic */ KernelServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KernelServiceImpl$getIDependsAdapter$1$onSendSSORequest$1(String str, KernelServiceImpl kernelServiceImpl, long j3, byte[] bArr, SendRequestParam sendRequestParam, String str2, HashMap<String, byte[]> hashMap) {
        super(0);
        this.$ssoCmd = str;
        this.this$0 = kernelServiceImpl;
        this.$requestId = j3;
        this.$pbBuffer = bArr;
        this.$param = sendRequestParam;
        this.$traceInfo = str2;
        this.$transInfoMap = hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, kernelServiceImpl, Long.valueOf(j3), bArr, sendRequestParam, str2, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AppRuntime app, IQQNTWrapperSession it, long j3, String str, byte[] bArr, SendRequestParam sendRequestParam, String str2, HashMap hashMap, KernelServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qqnt.kernel.msf.e.INSTANCE.b(app, it, j3, str, bArr, sendRequestParam, str2, hashMap);
        dx3.g sSenderModule = this$0.getSSenderModule();
        if (sSenderModule != null) {
            sSenderModule.a(j3, str, bArr, sendRequestParam, str2, hashMap);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Object invoke() {
        py pyVar;
        Handler e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QLog.d("KernelService", 1, "KSC: onSendSSORequest: " + this.$ssoCmd);
        pyVar = this.this$0.serviceContent;
        if (pyVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
            pyVar = null;
        }
        final AppRuntime c16 = pyVar.c();
        if (c16 == null) {
            return null;
        }
        final KernelServiceImpl kernelServiceImpl = this.this$0;
        final String str = this.$ssoCmd;
        final long j3 = this.$requestId;
        final byte[] bArr = this.$pbBuffer;
        final SendRequestParam sendRequestParam = this.$param;
        final String str2 = this.$traceInfo;
        final HashMap<String, byte[]> hashMap = this.$transInfoMap;
        final IQQNTWrapperSession iQQNTWrapperSession = kernelServiceImpl.wrapperSession;
        if (iQQNTWrapperSession == null) {
            return null;
        }
        if (!Intrinsics.areEqual(str, BaseConstants.CMD_NT_PUSH_UNREGISTER)) {
            e16 = KernelServiceImpl.INSTANCE.e();
            return Boolean.valueOf(e16.post(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.iq
                @Override // java.lang.Runnable
                public final void run() {
                    KernelServiceImpl$getIDependsAdapter$1$onSendSSORequest$1.b(AppRuntime.this, iQQNTWrapperSession, j3, str, bArr, sendRequestParam, str2, hashMap, kernelServiceImpl);
                }
            }));
        }
        QLog.d("KernelServiceImpl", 1, "sync send offline request");
        com.tencent.qqnt.kernel.msf.e.INSTANCE.b(c16, iQQNTWrapperSession, j3, str, bArr, sendRequestParam, str2, hashMap);
        dx3.g sSenderModule = kernelServiceImpl.getSSenderModule();
        if (sSenderModule == null) {
            return null;
        }
        sSenderModule.a(j3, str, bArr, sendRequestParam, str2, hashMap);
        return Unit.INSTANCE;
    }
}
