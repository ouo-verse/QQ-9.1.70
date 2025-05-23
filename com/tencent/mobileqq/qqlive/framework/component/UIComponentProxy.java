package com.tencent.mobileqq.qqlive.framework.component;

import android.os.Looper;
import android.view.View;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.exception.QQLiveException;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000f\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0004H&J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\r\u0010\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0006\u0010\u0012\u001a\u00020\u0004R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u001b\u0010\n\u001a\u00028\u00008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0016\u0010\u001a\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/component/UIComponentProxy;", "Landroid/view/View;", "V", "Lcom/tencent/mobileqq/qqlive/framework/component/i;", "", "k", "g", "()Landroid/view/View;", "l", "c", "view", DomainData.DOMAIN_NAME, "(Landroid/view/View;)V", "e", "", "a", tl.h.F, "d", "j", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", HippyQQConstants.URL_COMPONENT_NAME, "Lkotlin/Lazy;", "i", "f", "Z", "requestLoadView", "viewLoadStatus", "isViewCreated", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/component/e;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class UIComponentProxy<V extends View> implements i<V> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e component;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy view;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean requestLoadView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean viewLoadStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isViewCreated;

    public UIComponentProxy(@NotNull e component) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(component, "component");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) component);
            return;
        }
        this.component = component;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<V>(this) { // from class: com.tencent.mobileqq.qqlive.framework.component.UIComponentProxy$view$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ UIComponentProxy<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                }
            }

            /* JADX WARN: Incorrect return type in method signature: ()TV; */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                this.this$0.c();
                V e16 = this.this$0.e();
                ((UIComponentProxy) this.this$0).isViewCreated = true;
                return e16;
            }
        });
        this.view = lazy;
    }

    private final void k() {
        this.requestLoadView = true;
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    public abstract void c();

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.viewLoadStatus;
    }

    @NotNull
    public abstract V e();

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    @NotNull
    public V g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (V) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (!this.viewLoadStatus) {
            i();
            n(i());
            this.viewLoadStatus = true;
        }
        return i();
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.requestLoadView;
    }

    @NotNull
    public final V i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (V) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (V) this.view.getValue();
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            com.tencent.mobileqq.qqlive.framework.c.e(new QQLiveException("\u9700\u8981\u518d\u4e3b\u7ebf\u7a0b\u8c03\u7528requestLoadView"));
        }
        if (d()) {
            return;
        }
        k();
        this.component.e().C0(new com.tencent.mobileqq.qqlive.framework.pageevent.c(this.component.getKey(), this.component.getClass()));
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    @Nullable
    public V l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (V) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.isViewCreated) {
            return i();
        }
        return null;
    }

    public abstract void n(@NotNull V view);
}
