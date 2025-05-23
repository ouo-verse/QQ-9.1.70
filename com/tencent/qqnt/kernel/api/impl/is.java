package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.IGetRevealTofuAuthorityCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessClearType;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import com.tencent.qqnt.kernel.nativeinterface.RevealAuthorityReq;
import com.tencent.qqnt.kernel.nativeinterface.RevealDoufuInfo;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001+B\u0019\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J8\u0010\u0012\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J,\u0010\u0015\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0019\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010!\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u001a\u0010\"\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0012\u0010#\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010$\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/is;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelLiteBusinessService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelLiteBusinessListener;", "listener", "", "addListener", "listenerId", "", "removeListener", "", "uid", "Ljava/util/HashSet;", "Lcom/tencent/qqnt/kernel/nativeinterface/LiteBusinessType;", "Lkotlin/collections/HashSet;", "businessTypes", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "getLiteBusiness", "Lcom/tencent/qqnt/kernel/nativeinterface/LiteBusinessClearType;", "clearTypes", "clearLiteBusiness", "Lcom/tencent/qqnt/kernel/nativeinterface/RevealAuthorityReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetRevealTofuAuthorityCallback;", "getRevealTofuAuthority", "Lcom/tencent/qqnt/kernel/nativeinterface/RevealDoufuInfo;", "doufu", "insertRevealSuc", "revealInfo", "recentRevealExposure", "", "scene", "clickLiteAction", "exposeLiteAction", "clearLiteActionForTesting", "generateLiteActionForTesting", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelLiteBusinessService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class is extends BaseService<IKernelLiteBusinessService, IKernelLiteBusinessService> implements IKernelLiteBusinessService {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/is$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.is$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49637);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public is(@Nullable IKernelLiteBusinessService iKernelLiteBusinessService, @NotNull py content) {
        super("LiteBusinessService", content, iKernelLiteBusinessService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelLiteBusinessService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
    public long addListener(@Nullable IKernelLiteBusinessListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener)).longValue();
        }
        IKernelLiteBusinessService service = getService();
        if (service != null) {
            return service.addListener(listener);
        }
        return 0L;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
    public void clearLiteActionForTesting(@Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) callback);
            return;
        }
        IKernelLiteBusinessService service = getService();
        if (service != null) {
            service.clearLiteActionForTesting(callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
    public void clearLiteBusiness(@Nullable String uid, @Nullable HashSet<LiteBusinessClearType> clearTypes, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, uid, clearTypes, callback);
            return;
        }
        IKernelLiteBusinessService service = getService();
        if (service != null) {
            service.clearLiteBusiness(uid, clearTypes, callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
    public void clickLiteAction(@Nullable String uid, int scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) uid, scene);
            return;
        }
        IKernelLiteBusinessService service = getService();
        if (service != null) {
            service.clickLiteAction(uid, scene);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
    public void exposeLiteAction(@Nullable String uid, int scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) uid, scene);
            return;
        }
        IKernelLiteBusinessService service = getService();
        if (service != null) {
            service.exposeLiteAction(uid, scene);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
    public void generateLiteActionForTesting(@Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) callback);
            return;
        }
        IKernelLiteBusinessService service = getService();
        if (service != null) {
            service.generateLiteActionForTesting(callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
    public void getLiteBusiness(@Nullable String uid, @Nullable HashSet<LiteBusinessType> businessTypes, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uid, businessTypes, callback);
            return;
        }
        IKernelLiteBusinessService service = getService();
        if (service != null) {
            service.getLiteBusiness(uid, businessTypes, callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
    public void getRevealTofuAuthority(@Nullable RevealAuthorityReq req, @Nullable IGetRevealTofuAuthorityCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) req, (Object) callback);
            return;
        }
        IKernelLiteBusinessService service = getService();
        if (service != null) {
            service.getRevealTofuAuthority(req, callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
    public void insertRevealSuc(@Nullable RevealDoufuInfo doufu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) doufu);
            return;
        }
        IKernelLiteBusinessService service = getService();
        if (service != null) {
            service.insertRevealSuc(doufu);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
    public void recentRevealExposure(@Nullable RevealDoufuInfo revealInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) revealInfo);
            return;
        }
        IKernelLiteBusinessService service = getService();
        if (service != null) {
            service.recentRevealExposure(revealInfo);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService
    public void removeListener(long listenerId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, listenerId);
            return;
        }
        IKernelLiteBusinessService service = getService();
        if (service != null) {
            service.removeListener(listenerId);
        }
    }
}
