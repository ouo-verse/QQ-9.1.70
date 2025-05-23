package com.tencent.mobileqq.sharepanel.launcher.ipc;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/ipc/u;", "Lcom/tencent/mobileqq/sharepanel/m;", "Landroid/content/Intent;", "intent", "", "a", "onFail", "", "I", "callbackId", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCClientFragment;", "kotlin.jvm.PlatformType", "b", "Ljava/lang/ref/WeakReference;", "fragmentRef", "fragment", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCClientFragment;I)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class u implements com.tencent.mobileqq.sharepanel.m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int callbackId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<SharePanelIPCClientFragment> fragmentRef;

    public u(@NotNull SharePanelIPCClientFragment fragment, int i3) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragment, i3);
        } else {
            this.callbackId = i3;
            this.fragmentRef = new WeakReference<>(fragment);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.m
    public void a(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        SharePanelIPCClientFragment sharePanelIPCClientFragment = this.fragmentRef.get();
        if (sharePanelIPCClientFragment != null) {
            sharePanelIPCClientFragment.zh(this.callbackId, true, intent);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.m
    public void onFail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        SharePanelIPCClientFragment sharePanelIPCClientFragment = this.fragmentRef.get();
        if (sharePanelIPCClientFragment != null) {
            sharePanelIPCClientFragment.zh(this.callbackId, false, null);
        }
    }
}
