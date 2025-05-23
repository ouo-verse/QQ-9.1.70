package com.tencent.mobileqq.qqlive.framework.component;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.component.SingleUIComponent$uiComponentProxy$2;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0015\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\b\u001a\u00020\u0007J\r\u0010\t\u001a\u00028\u0000\u00a2\u0006\u0004\b\t\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0010\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u0014\u001a\u00020\u000bR!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\r\u001a\u00028\u00008DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u001b\u0010\u0006\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/component/SingleUIComponent;", "Landroid/view/View;", "V", "Lcom/tencent/mobileqq/qqlive/framework/component/b;", "Lcom/tencent/mobileqq/qqlive/framework/component/i;", "l", "()Landroid/view/View;", "", "d", "g", tl.h.F, "", "o", "view", "t", "(Landroid/view/View;)V", "p", "a", "Landroid/view/ViewGroup$LayoutParams;", "f", ReportConstant.COSTREPORT_PREFIX, "com/tencent/mobileqq/qqlive/framework/component/SingleUIComponent$uiComponentProxy$2$a", "e", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/qqlive/framework/component/SingleUIComponent$uiComponentProxy$2$a;", "uiComponentProxy", "r", "Lfi2/a;", "componentContext", "<init>", "(Lfi2/a;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class SingleUIComponent<V extends View> extends b implements i<V> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uiComponentProxy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleUIComponent(@NotNull fi2.a componentContext) {
        super(componentContext);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<SingleUIComponent$uiComponentProxy$2.a>(this) { // from class: com.tencent.mobileqq.qqlive.framework.component.SingleUIComponent$uiComponentProxy$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ SingleUIComponent<V> this$0;

                /* JADX INFO: Add missing generic type declarations: [V] */
                @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqlive/framework/component/SingleUIComponent$uiComponentProxy$2$a", "Lcom/tencent/mobileqq/qqlive/framework/component/UIComponentProxy;", "e", "()Landroid/view/View;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup$LayoutParams;", "f", "", "c", "view", DomainData.DOMAIN_NAME, "(Landroid/view/View;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes17.dex */
                public static final class a<V> extends UIComponentProxy<V> {
                    static IPatchRedirector $redirector_;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ SingleUIComponent<V> f271234m;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    a(SingleUIComponent<V> singleUIComponent) {
                        super(singleUIComponent);
                        this.f271234m = singleUIComponent;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) singleUIComponent);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqlive.framework.component.UIComponentProxy
                    public void c() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                            iPatchRedirector.redirect((short) 5, (Object) this);
                        } else {
                            this.f271234m.o();
                        }
                    }

                    /* JADX WARN: Incorrect return type in method signature: ()TV; */
                    @Override // com.tencent.mobileqq.qqlive.framework.component.UIComponentProxy
                    @NotNull
                    public View e() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        return this.f271234m.p();
                    }

                    @Override // com.tencent.mobileqq.qqlive.framework.component.i
                    @Nullable
                    public ViewGroup.LayoutParams f() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 4, (Object) this);
                        }
                        return this.f271234m.f();
                    }

                    @Override // com.tencent.mobileqq.qqlive.framework.component.i
                    public int m() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                        }
                        return this.f271234m.m();
                    }

                    /* JADX WARN: Incorrect types in method signature: (TV;)V */
                    @Override // com.tencent.mobileqq.qqlive.framework.component.UIComponentProxy
                    public void n(@NotNull View view) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
                        } else {
                            Intrinsics.checkNotNullParameter(view, "view");
                            this.f271234m.t(view);
                        }
                    }
                }

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

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(this.this$0) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.uiComponentProxy = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<V>(this) { // from class: com.tencent.mobileqq.qqlive.framework.component.SingleUIComponent$view$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ SingleUIComponent<V> this$0;

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
                    SingleUIComponent$uiComponentProxy$2.a q16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    q16 = this.this$0.q();
                    return q16.i();
                }
            });
            this.view = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) componentContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SingleUIComponent$uiComponentProxy$2.a q() {
        return (SingleUIComponent$uiComponentProxy$2.a) this.uiComponentProxy.getValue();
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return q().d();
    }

    @Nullable
    public ViewGroup.LayoutParams f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    @NotNull
    public final V g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (V) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return (V) q().g();
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return q().h();
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    @Nullable
    public final V l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (V) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (d()) {
            return r();
        }
        return null;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @NotNull
    public abstract V p();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final V r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (V) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (V) this.view.getValue();
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            q().j();
        }
    }

    public void t(@NotNull V view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }
}
