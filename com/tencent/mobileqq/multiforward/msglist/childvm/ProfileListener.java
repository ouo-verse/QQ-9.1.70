package com.tencent.mobileqq.multiforward.msglist.childvm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.be;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import zs.b;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\u001c\u0010\t\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016R\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/multiforward/msglist/childvm/ProfileListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileListener;", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "Lkotlin/collections/HashMap;", "profiles", "", "a", "onProfileSimpleChanged", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/multiforward/msglist/childvm/a;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "vmWr", "listVm", "<init>", "(Lcom/tencent/mobileqq/multiforward/msglist/childvm/a;)V", "e", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ProfileListener implements IKernelProfileListener {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<a> vmWr;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/multiforward/msglist/childvm/ProfileListener$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multiforward.msglist.childvm.ProfileListener$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65400);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ProfileListener(@NotNull a listVm) {
        Intrinsics.checkNotNullParameter(listVm, "listVm");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) listVm);
        } else {
            this.vmWr = new WeakReference<>(listVm);
        }
    }

    private final void a(HashMap<String, UserSimpleInfo> profiles) {
        a aVar = this.vmWr.get();
        if (aVar != null) {
            BuildersKt__Builders_commonKt.launch$default(aVar.d().vmScope(), b.a(Dispatchers.INSTANCE), null, new ProfileListener$handleProfileInfoChanges$1(aVar, profiles, null), 2, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public void onProfileSimpleChanged(@NotNull HashMap<String, UserSimpleInfo> profiles) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) profiles);
            return;
        }
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        new HashMap().putAll(profiles);
        a(profiles);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onSelfStatusChanged(StatusInfo statusInfo) {
        be.b(this, statusInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onStatusAsyncFieldUpdate(HashMap hashMap) {
        be.c(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onStatusUpdate(HashMap hashMap) {
        be.d(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onStrangerRemarkChanged(HashMap hashMap) {
        be.e(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onUserDetailInfoChanged(UserDetailInfo userDetailInfo) {
        be.f(this, userDetailInfo);
    }
}
