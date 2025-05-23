package com.tencent.mvi.runtime.wrapper;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.d;
import com.tencent.mvi.runtime.lifeobserver.LifeCycleWrapperObserver;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0017\u001a\u00020\u0001\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000f\u0010\u0007\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0011\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u000bH\u0096\u0001R\u0017\u0010\u0017\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mvi/runtime/wrapper/LifeCycleAction1Wrapper;", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/runtime/lifeobserver/LifeCycleWrapperObserver;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "hashCode", "d", "()I", "", "other", "", "equals", "", "toString", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "call", "sticky", "e", "Lcom/tencent/mvi/base/route/a;", "getObserver", "()Lcom/tencent/mvi/base/route/a;", "observer", "f", "Ljava/lang/String;", "qualifiedName", "Lcom/tencent/mvi/base/route/d;", h.F, "Lcom/tencent/mvi/base/route/d;", "unRegister", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "(Lcom/tencent/mvi/base/route/a;Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mvi/base/route/d;)V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public final class LifeCycleAction1Wrapper extends LifeCycleWrapperObserver implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a observer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String qualifiedName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final d unRegister;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifeCycleAction1Wrapper(@NotNull a observer, @Nullable String str, @NotNull LifecycleOwner lifecycleOwner, @NotNull d unRegister) {
        super(lifecycleOwner);
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(unRegister, "unRegister");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, observer, str, lifecycleOwner, unRegister);
            return;
        }
        this.observer = observer;
        this.qualifiedName = str;
        this.unRegister = unRegister;
    }

    @Override // com.tencent.mvi.base.route.a
    public void call(@NotNull MsgIntent i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) i3);
        } else {
            Intrinsics.checkNotNullParameter(i3, "i");
            this.observer.call(i3);
        }
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.observer.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(LifeCycleAction1Wrapper.class, cls)) {
            return false;
        }
        if (other != null) {
            LifeCycleAction1Wrapper lifeCycleAction1Wrapper = (LifeCycleAction1Wrapper) other;
            if (!(!Intrinsics.areEqual(this.observer, lifeCycleAction1Wrapper.observer)) && !(!Intrinsics.areEqual(this.qualifiedName, lifeCycleAction1Wrapper.qualifiedName)) && !(!Intrinsics.areEqual(this.unRegister, lifeCycleAction1Wrapper.unRegister))) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mvi.runtime.wrapper.LifeCycleAction1Wrapper");
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return Objects.hash(this.observer, this.qualifiedName, this.unRegister);
    }

    @Override // com.tencent.mvi.runtime.lifeobserver.LifeCycleWrapperObserver
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.unRegister.b(this.qualifiedName, this.observer);
        }
    }

    @Override // com.tencent.mvi.base.route.a
    public boolean sticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.observer.sticky();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "LifeCycleAction1Wrapper(observer=" + this.observer + ')';
    }
}
