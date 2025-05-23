package com.tencent.relation.common.runnable;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/relation/common/runnable/RelationRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/relation/common/runnable/a;", "d", "Ljava/lang/ref/WeakReference;", "getCallbackWeakReference", "()Ljava/lang/ref/WeakReference;", "setCallbackWeakReference", "(Ljava/lang/ref/WeakReference;)V", "callbackWeakReference", "callback", "<init>", "(Lcom/tencent/relation/common/runnable/a;)V", "relation-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RelationRunnable implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<a> callbackWeakReference;

    public RelationRunnable(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
        } else {
            this.callbackWeakReference = new WeakReference<>(callback);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        WeakReference<a> weakReference = this.callbackWeakReference;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.callback();
        }
    }
}
