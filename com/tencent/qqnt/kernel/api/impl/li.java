package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelQRService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener;
import com.tencent.qqnt.kernel.nativeinterface.IQRCallback;
import com.tencent.qqnt.kernel.nativeinterface.IScanQRCallback;
import com.tencent.qqnt.kernel.nativeinterface.InitQRConfig;
import com.tencent.qqnt.kernel.nativeinterface.ScanScene;
import com.tencent.qqnt.kernel.nativeinterface.SwitchOperation;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0003:\u0001\u001cB\u0019\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u000e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J0\u0010\u0013\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/li;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentContactListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelQRService;", "Lcom/tencent/qqnt/kernel/nativeinterface/InitQRConfig;", DownloadInfo.spKey_Config, "", "initConfig", "Lcom/tencent/qqnt/kernel/nativeinterface/ScanScene;", "sence", "", "qrSig", "Lcom/tencent/qqnt/kernel/nativeinterface/IScanQRCallback;", "cb", "sendScanQrRequest", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Lcom/tencent/qqnt/kernel/nativeinterface/SwitchOperation;", "opSwitch", "Lcom/tencent/qqnt/kernel/nativeinterface/IQRCallback;", "sendAuthQrRequest", "sendCancleQrRequest", "SendRejectQrRequest", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelQRService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class li extends BaseService<IKernelRecentContactListener, IKernelQRService> implements IKernelQRService {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/li$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.li$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51976);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public li(@Nullable IKernelQRService iKernelQRService, @NotNull py content) {
        super("QRService", content, iKernelQRService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelQRService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelQRService
    public void SendRejectQrRequest(@Nullable byte[] qrSig, @Nullable IQRCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qrSig, (Object) cb5);
            return;
        }
        IKernelQRService service = getService();
        if (service != null) {
            service.SendRejectQrRequest(qrSig, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelQRService
    public void initConfig(@Nullable InitQRConfig config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) config);
            return;
        }
        IKernelQRService service = getService();
        if (service != null) {
            service.initConfig(config);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelQRService
    public void sendAuthQrRequest(@Nullable byte[] a16, @Nullable byte[] qrSig, @Nullable SwitchOperation opSwitch, @Nullable IQRCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, a16, qrSig, opSwitch, cb5);
            return;
        }
        IKernelQRService service = getService();
        if (service != null) {
            service.sendAuthQrRequest(a16, qrSig, opSwitch, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelQRService
    public void sendCancleQrRequest(@Nullable byte[] qrSig, @Nullable IQRCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qrSig, (Object) cb5);
            return;
        }
        IKernelQRService service = getService();
        if (service != null) {
            service.sendCancleQrRequest(qrSig, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelQRService
    public void sendScanQrRequest(@Nullable ScanScene sence, @Nullable byte[] qrSig, @Nullable IScanQRCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, sence, qrSig, cb5);
            return;
        }
        IKernelQRService service = getService();
        if (service != null) {
            service.sendScanQrRequest(sence, qrSig, cb5);
        }
    }
}
