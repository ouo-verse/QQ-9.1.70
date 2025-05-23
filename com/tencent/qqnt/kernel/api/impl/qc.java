package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoAlbumAccessDelegate;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoPreCheckCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoAuthorizationInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001fB\u0019\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0010H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/qc;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoHostListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoHostService;", "Lcom/tencent/qqnt/kernel/api/ah;", "listener", "", "addKernelWiFiPhotoHostListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoAlbumAccessDelegate;", "delegate", "setAlbumAccessDelegate", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoPreCheckCallback;", "cb", "C0", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "requestVisitLocalAlbum", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Lcom/tencent/qqnt/kernel/nativeinterface/WiFiPhotoAuthorizationInfo;", "info", "acceptRequest", "reason", "rejectRequest", "error", "disconnect", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoHostService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class qc extends BaseService<IKernelWiFiPhotoHostListener, IKernelWiFiPhotoHostService> implements com.tencent.qqnt.kernel.api.ah {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/qc$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.qc$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54392);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qc(@Nullable IKernelWiFiPhotoHostService iKernelWiFiPhotoHostService, @NotNull py content) {
        super("WifiPhotoHostService", content, iKernelWiFiPhotoHostService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelWiFiPhotoHostService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ah
    public void C0(@Nullable IKernelWiFiPhotoPreCheckCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cb5);
            return;
        }
        IKernelWiFiPhotoHostService service = getService();
        if (service != null) {
            service.precheckIfDeviceSupportWiFiPhotoRequest(cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ah
    public void acceptRequest(int requestId, @Nullable WiFiPhotoAuthorizationInfo info, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(requestId), info, cb5);
            return;
        }
        IKernelWiFiPhotoHostService service = getService();
        if (service != null) {
            service.acceptRequest(requestId, info, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ah
    public void addKernelWiFiPhotoHostListener(@Nullable IKernelWiFiPhotoHostListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
            return;
        }
        IKernelWiFiPhotoHostService service = getService();
        if (service != null) {
            service.addKernelWiFiPhotoHostListener(listener);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ah
    public void disconnect(int error) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, error);
            return;
        }
        IKernelWiFiPhotoHostService service = getService();
        if (service != null) {
            service.disconnect(error);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ah
    public void rejectRequest(int requestId, int reason, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(requestId), Integer.valueOf(reason), cb5);
            return;
        }
        IKernelWiFiPhotoHostService service = getService();
        if (service != null) {
            service.rejectRequest(requestId, reason, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ah
    public void requestVisitLocalAlbum(@Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cb5);
            return;
        }
        IKernelWiFiPhotoHostService service = getService();
        if (service != null) {
            service.requestVisitLocalAlbum(cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ah
    public void setAlbumAccessDelegate(@Nullable IKernelWiFiPhotoAlbumAccessDelegate delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) delegate);
            return;
        }
        IKernelWiFiPhotoHostService service = getService();
        if (service != null) {
            service.setAlbumAccessDelegate(delegate);
        }
    }
}
