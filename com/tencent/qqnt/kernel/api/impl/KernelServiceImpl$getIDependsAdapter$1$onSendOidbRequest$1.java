package com.tencent.qqnt.kernel.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.msf.e;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.SendRequestParam;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class KernelServiceImpl$getIDependsAdapter$1$onSendOidbRequest$1 extends Lambda implements Function0<Boolean> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $cmd;
    final /* synthetic */ SendRequestParam $param;
    final /* synthetic */ byte[] $pbBuffer;
    final /* synthetic */ long $requestId;
    final /* synthetic */ int $serviceType;
    final /* synthetic */ String $traceInfo;
    final /* synthetic */ HashMap<String, byte[]> $transInfoMap;
    final /* synthetic */ KernelServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KernelServiceImpl$getIDependsAdapter$1$onSendOidbRequest$1(int i3, KernelServiceImpl kernelServiceImpl, long j3, int i16, byte[] bArr, SendRequestParam sendRequestParam, String str, HashMap<String, byte[]> hashMap) {
        super(0);
        this.$cmd = i3;
        this.this$0 = kernelServiceImpl;
        this.$requestId = j3;
        this.$serviceType = i16;
        this.$pbBuffer = bArr;
        this.$param = sendRequestParam;
        this.$traceInfo = str;
        this.$transInfoMap = hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), kernelServiceImpl, Long.valueOf(j3), Integer.valueOf(i16), bArr, sendRequestParam, str, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AppRuntime app, IQQNTWrapperSession it, long j3, int i3, int i16, byte[] bArr, SendRequestParam sendRequestParam, String str, HashMap hashMap, KernelServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        e.Companion companion = com.tencent.qqnt.kernel.msf.e.INSTANCE;
        com.tencent.mobileqq.inject.b sAppSetting = this$0.getSAppSetting();
        Intrinsics.checkNotNull(sAppSetting);
        companion.a(app, it, j3, i3, i16, bArr, sendRequestParam, str, hashMap, sAppSetting.getVersion());
        dx3.g sSenderModule = this$0.getSSenderModule();
        if (sSenderModule != null) {
            sSenderModule.onSendOidbRequest(j3, i16, i3, bArr, sendRequestParam, str, hashMap);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Boolean invoke() {
        py pyVar;
        Handler e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QLog.d("KernelService", 1, "KSC: onSendOidbRequest: " + this.$cmd);
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
        final long j3 = this.$requestId;
        final int i3 = this.$cmd;
        final int i16 = this.$serviceType;
        final byte[] bArr = this.$pbBuffer;
        final SendRequestParam sendRequestParam = this.$param;
        final String str = this.$traceInfo;
        final HashMap<String, byte[]> hashMap = this.$transInfoMap;
        final IQQNTWrapperSession iQQNTWrapperSession = kernelServiceImpl.wrapperSession;
        if (iQQNTWrapperSession == null) {
            return null;
        }
        e16 = KernelServiceImpl.INSTANCE.e();
        return Boolean.valueOf(e16.post(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ip
            @Override // java.lang.Runnable
            public final void run() {
                KernelServiceImpl$getIDependsAdapter$1$onSendOidbRequest$1.b(AppRuntime.this, iQQNTWrapperSession, j3, i3, i16, bArr, sendRequestParam, str, hashMap, kernelServiceImpl);
            }
        }));
    }
}
