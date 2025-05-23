package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.GroupVideoCmdReq;
import com.tencent.qqnt.kernel.nativeinterface.IGroupVideoCmdRequestRsp;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0015B\u0019\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/a;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelAVSDKListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelAVSDKService;", "Lcom/tencent/qqnt/kernel/api/e;", "listener", "", "addKernelAVSDKListener", "removeKernelAVSDKListener", "allowAlbumNotify", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupVideoCmdReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupVideoCmdRequestRsp;", "cb", "startGroupVideoCmdRequestFromAVSDK", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelAVSDKService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends BaseService<IKernelAVSDKListener, IKernelAVSDKService> implements com.tencent.qqnt.kernel.api.e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable IKernelAVSDKService iKernelAVSDKService, @NotNull py content) {
        super("AVSDKService", content, iKernelAVSDKService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelAVSDKService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.e
    public void addKernelAVSDKListener(@Nullable IKernelAVSDKListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
            return;
        }
        IKernelAVSDKService service = getService();
        if (service != null) {
            service.addKernelAVSDKListener(listener);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.e
    public void allowAlbumNotify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        IKernelAVSDKService service = getService();
        if (service != null) {
            service.allowAlbumNotify();
        }
    }

    @Override // com.tencent.qqnt.kernel.api.e
    public void removeKernelAVSDKListener(@Nullable IKernelAVSDKListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            return;
        }
        IKernelAVSDKService service = getService();
        if (service != null) {
            service.removeKernelAVSDKListener(listener);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.e
    public void startGroupVideoCmdRequestFromAVSDK(@Nullable GroupVideoCmdReq req, @Nullable IGroupVideoCmdRequestRsp cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        IKernelAVSDKService service = getService();
        if (service != null) {
            service.startGroupVideoCmdRequestFromAVSDK(req, cb5);
        }
    }
}
