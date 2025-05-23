package com.tencent.aio.api.refreshLoad;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.aio.api.refreshLoad.d;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J(\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0016H&R\"\u0010\u001e\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\"\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lcom/tencent/aio/api/refreshLoad/HeadFooterViewHolder;", "Lcom/tencent/aio/api/refreshLoad/d;", "", "e", "()V", "d", "", "f", "parentWidthMeasure", "parentHeightMeasure", "Lcom/tencent/aio/api/c;", "padding", "k", "Landroid/view/ViewGroup;", "viewGroup", "a", "c", "left", "top", "right", "bottom", "j", "Landroid/view/View;", "b", "", "Z", h.F, "()Z", "setVisible$sdk_debug", "(Z)V", NodeProps.VISIBLE, "Lkotlin/Lazy;", "g", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class HeadFooterViewHolder implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean visible;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy rootView;

    public HeadFooterViewHolder() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.aio.api.refreshLoad.HeadFooterViewHolder$rootView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) HeadFooterViewHolder.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final View invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? HeadFooterViewHolder.this.b() : (View) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            });
            this.rootView = lazy;
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    private final View g() {
        return (View) this.rootView.getValue();
    }

    public void a(@NotNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewGroup);
            return;
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (Intrinsics.areEqual(g().getParent(), viewGroup)) {
            return;
        }
        ViewParent parent = g().getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup2 = (ViewGroup) parent;
        if (viewGroup2 != null) {
            viewGroup2.removeView(g());
        }
        viewGroup.addView(g());
    }

    @NotNull
    public abstract View b();

    public void c(@NotNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewGroup);
            return;
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (Intrinsics.areEqual(g().getParent(), viewGroup)) {
            viewGroup.removeView(g());
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (!this.visible) {
                return;
            }
            i();
            this.visible = false;
            g().setTranslationY(0.0f);
            g().setVisibility(8);
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (this.visible) {
                return;
            }
            l();
            this.visible = true;
            g().setVisibility(0);
        }
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return g().getMeasuredHeight();
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return this.visible;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            d.a.a(this);
        }
    }

    public void j(int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
        } else {
            g().layout(left, top, right, bottom);
        }
    }

    public void k(int parentWidthMeasure, int parentHeightMeasure, @NotNull com.tencent.aio.api.c padding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(parentWidthMeasure), Integer.valueOf(parentHeightMeasure), padding);
        } else {
            Intrinsics.checkNotNullParameter(padding, "padding");
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, g(), parentWidthMeasure, 0, parentHeightMeasure, 0, padding.b(), padding.c(), padding.d(), padding.a(), 20, null);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            d.a.b(this);
        }
    }
}
