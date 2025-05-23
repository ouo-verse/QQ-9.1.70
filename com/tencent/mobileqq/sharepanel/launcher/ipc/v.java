package com.tencent.mobileqq.sharepanel.launcher.ipc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0006R\"\u0010\f\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/ipc/v;", "Lcom/tencent/mobileqq/sharepanel/o;", "", "b", "a", "", "I", "callbackId", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCClientFragment;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "fragmentRef", "fragment", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCClientFragment;I)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class v implements com.tencent.mobileqq.sharepanel.o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int callbackId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<SharePanelIPCClientFragment> fragmentRef;

    public v(@NotNull SharePanelIPCClientFragment fragment, int i3) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragment, i3);
        } else {
            this.callbackId = i3;
            this.fragmentRef = new WeakReference<>(fragment);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.o
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        SharePanelIPCClientFragment sharePanelIPCClientFragment = this.fragmentRef.get();
        if (sharePanelIPCClientFragment != null) {
            sharePanelIPCClientFragment.Ch(this.callbackId, false);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.o
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        SharePanelIPCClientFragment sharePanelIPCClientFragment = this.fragmentRef.get();
        if (sharePanelIPCClientFragment != null) {
            sharePanelIPCClientFragment.Ch(this.callbackId, true);
        }
    }
}
