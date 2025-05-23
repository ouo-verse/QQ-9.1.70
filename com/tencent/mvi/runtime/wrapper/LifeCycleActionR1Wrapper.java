package com.tencent.mvi.runtime.wrapper;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.b;
import com.tencent.mvi.base.route.e;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.runtime.lifeobserver.LifeCycleWrapperObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0011\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001R\u0017\u0010\u000f\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mvi/runtime/wrapper/LifeCycleActionR1Wrapper;", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/runtime/lifeobserver/LifeCycleWrapperObserver;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "hashCode", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "call", "e", "Lcom/tencent/mvi/base/route/b;", "getObserver", "()Lcom/tencent/mvi/base/route/b;", "observer", "", "f", "Ljava/lang/String;", "qualifiedName", "Lcom/tencent/mvi/base/route/e;", h.F, "Lcom/tencent/mvi/base/route/e;", "unRegister", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "(Lcom/tencent/mvi/base/route/b;Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mvi/base/route/e;)V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public final class LifeCycleActionR1Wrapper extends LifeCycleWrapperObserver implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b observer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String qualifiedName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final e unRegister;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifeCycleActionR1Wrapper(@NotNull b observer, @Nullable String str, @NotNull LifecycleOwner lifecycleOwner, @NotNull e unRegister) {
        super(lifecycleOwner);
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(unRegister, "unRegister");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, observer, str, lifecycleOwner, unRegister);
            return;
        }
        this.observer = observer;
        this.qualifiedName = str;
        this.unRegister = unRegister;
    }

    @Override // com.tencent.mvi.base.route.b
    @NotNull
    public k call(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (k) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        return this.observer.call(intent);
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.observer.hashCode();
    }

    @Override // com.tencent.mvi.runtime.lifeobserver.LifeCycleWrapperObserver
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.unRegister.a(this.qualifiedName);
        }
    }
}
