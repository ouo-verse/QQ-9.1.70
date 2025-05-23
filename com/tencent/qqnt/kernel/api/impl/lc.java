package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService;
import com.tencent.qqnt.kernel.nativeinterface.IOSCheckLikeStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOSGetAggregationCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOSGetAggregationPageEntranceCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOSGetLikeListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOSGetShouldShowAIOStatusAnimationCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOSLikeStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOSReadLikeListCallback;
import com.tencent.qqnt.kernel.nativeinterface.OSCheckLikeReq;
import com.tencent.qqnt.kernel.nativeinterface.OSGetLikeListReq;
import com.tencent.qqnt.kernel.nativeinterface.OSLikeStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.OSReadLikeListReq;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0003:\u0001+B\u0017\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u000f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0012\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001c\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001eH\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0016\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/lc;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelOnlineStatusListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelOnlineStatusService;", "Lcom/tencent/qqnt/kernel/nativeinterface/OSLikeStatusReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IOSLikeStatusCallback;", "callback", "", "setLikeStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/OSCheckLikeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOSCheckLikeStatusCallback;", "checkLikeStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/OSGetLikeListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOSGetLikeListCallback;", "getLikeList", "Lcom/tencent/qqnt/kernel/nativeinterface/OSReadLikeListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOSReadLikeListCallback;", "setReadLikeList", "Lcom/tencent/qqnt/kernel/nativeinterface/IOSGetAggregationCallback;", "getAggregationGroupModels", "didClickAggregationPageEntrance", "Lcom/tencent/qqnt/kernel/nativeinterface/IOSGetAggregationPageEntranceCallback;", "getAggregationPageEntrance", "", "uid", "Lcom/tencent/qqnt/kernel/nativeinterface/IOSGetShouldShowAIOStatusAnimationCallback;", "cb", "getShouldShowAIOStatusAnimation", "listener", "", "addKernelOnlineStatusListener", "listenerID", "removeKernelOnlineStatusListener", "", "enable", "setOnlineStatusLiteBusinessSwitch", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelOnlineStatusService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class lc extends BaseService<IKernelOnlineStatusListener, IKernelOnlineStatusService> implements IKernelOnlineStatusService {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/lc$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.lc$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51068);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lc(@NotNull IKernelOnlineStatusService service, @NotNull py content) {
        super("OnlineStatusService", content, service);
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) service, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
    public long addKernelOnlineStatusListener(@Nullable IKernelOnlineStatusListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this, (Object) listener)).longValue();
        }
        IKernelOnlineStatusService service = getService();
        if (service != null) {
            return service.addKernelOnlineStatusListener(listener);
        }
        return -1L;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
    public void checkLikeStatus(@Nullable OSCheckLikeReq req, @Nullable IOSCheckLikeStatusCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) req, (Object) callback);
            return;
        }
        IKernelOnlineStatusService service = getService();
        if (service != null) {
            service.checkLikeStatus(req, callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
    public void didClickAggregationPageEntrance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        IKernelOnlineStatusService service = getService();
        if (service != null) {
            service.didClickAggregationPageEntrance();
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
    public void getAggregationGroupModels(@Nullable IOSGetAggregationCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback);
            return;
        }
        IKernelOnlineStatusService service = getService();
        if (service != null) {
            service.getAggregationGroupModels(callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
    public void getAggregationPageEntrance(@Nullable IOSGetAggregationPageEntranceCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callback);
            return;
        }
        IKernelOnlineStatusService service = getService();
        if (service != null) {
            service.getAggregationPageEntrance(callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
    public void getLikeList(@Nullable OSGetLikeListReq req, @Nullable IOSGetLikeListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) req, (Object) callback);
            return;
        }
        IKernelOnlineStatusService service = getService();
        if (service != null) {
            service.getLikeList(req, callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
    public void getShouldShowAIOStatusAnimation(@Nullable String uid, @Nullable IOSGetShouldShowAIOStatusAnimationCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) uid, (Object) cb5);
            return;
        }
        IKernelOnlineStatusService service = getService();
        if (service != null) {
            service.getShouldShowAIOStatusAnimation(uid, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
    public void removeKernelOnlineStatusListener(long listenerID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, listenerID);
            return;
        }
        IKernelOnlineStatusService service = getService();
        if (service != null) {
            service.removeKernelOnlineStatusListener(listenerID);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
    public void setLikeStatus(@Nullable OSLikeStatusReq req, @Nullable IOSLikeStatusCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) req, (Object) callback);
            return;
        }
        IKernelOnlineStatusService service = getService();
        if (service != null) {
            service.setLikeStatus(req, callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
    public void setOnlineStatusLiteBusinessSwitch(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, enable);
            return;
        }
        IKernelOnlineStatusService service = getService();
        if (service != null) {
            service.setOnlineStatusLiteBusinessSwitch(enable);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService
    public void setReadLikeList(@Nullable OSReadLikeListReq req, @Nullable IOSReadLikeListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) req, (Object) callback);
            return;
        }
        IKernelOnlineStatusService service = getService();
        if (service != null) {
            service.setReadLikeList(req, callback);
        }
    }
}
