package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.IFetchNearbyProUserInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProCommonExtInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001dB\u0019\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016JD\u0010\u0016\u001a\u00020\u00072\u001e\u0010\u0012\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u0001`\u00112\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/lb;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelNearbyProListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelNearbyProService;", "Lcom/tencent/qqnt/kernel/api/x;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "", "Y", "listener", "addKernelNearbyProListener", "removeKernelNearbyProListener", "Lcom/tencent/qqnt/kernel/nativeinterface/NearbyProCommonExtInfo;", "extInfo", "setCommonExtInfo", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "tinyIdList", "", "forceUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchNearbyProUserInfoCallback;", "fetchNearbyProUserInfo", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelNearbyProService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class lb extends BaseService<IKernelNearbyProListener, IKernelNearbyProService> implements com.tencent.qqnt.kernel.api.x {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/lb$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.lb$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50539);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lb(@Nullable IKernelNearbyProService iKernelNearbyProService, @NotNull py content) {
        super("NearbyProService", content, iKernelNearbyProService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelNearbyProService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.x
    public void Y(@NotNull IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        IKernelNearbyProService service = getService();
        if (service != null) {
            service.getNearbyAllContactsUnreadCnt(cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.x
    public void addKernelNearbyProListener(@NotNull IKernelNearbyProListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        IKernelNearbyProService service = getService();
        if (service != null) {
            service.addKernelNearbyProListener(listener);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.x
    public void fetchNearbyProUserInfo(@Nullable ArrayList<Long> tinyIdList, @Nullable NearbyProCommonExtInfo extInfo, boolean forceUpdate, @Nullable IFetchNearbyProUserInfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, tinyIdList, extInfo, Boolean.valueOf(forceUpdate), cb5);
            return;
        }
        IKernelNearbyProService service = getService();
        if (service != null) {
            service.fetchNearbyProUserInfo(tinyIdList, extInfo, forceUpdate, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.x
    public void removeKernelNearbyProListener(@NotNull IKernelNearbyProListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        IKernelNearbyProService service = getService();
        if (service != null) {
            service.removeKernelNearbyProListener(listener);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.x
    public void setCommonExtInfo(@NotNull NearbyProCommonExtInfo extInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) extInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        IKernelNearbyProService service = getService();
        if (service != null) {
            service.setCommonExtInfo(extInfo);
        }
    }
}
