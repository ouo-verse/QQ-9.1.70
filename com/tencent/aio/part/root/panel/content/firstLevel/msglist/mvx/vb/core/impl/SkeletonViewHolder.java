package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import android.content.Context;
import android.view.View;
import com.tencent.aio.api.list.o;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0096\u0001J\u0019\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0096\u0001R\u001b\u0010\b\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/SkeletonViewHolder;", "Lcom/tencent/aio/api/list/o$a;", "Landroid/content/Context;", "context", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "", "a", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/aio/api/list/o;", DTConstants.TAG.API, "b", "c", "Lkotlin/Lazy;", "d", "()Landroid/view/View;", "holder", "<init>", "(Lcom/tencent/aio/api/list/o$a;Landroid/content/Context;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class SkeletonViewHolder implements o.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ o.a f69623b;

    public SkeletonViewHolder(@NotNull o.a holder, @NotNull final Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) holder, (Object) context);
            return;
        }
        this.f69623b = holder;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>(context) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.SkeletonViewHolder$rootView$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) SkeletonViewHolder.this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? SkeletonViewHolder.this.createView(this.$context) : (View) iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        });
        this.rootView = lazy;
    }

    @Override // com.tencent.aio.api.list.o.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f69623b.a();
        }
    }

    @Override // com.tencent.aio.api.list.o.a
    public void b(@NotNull View rootView, @NotNull o api) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView, (Object) api);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(api, "api");
        this.f69623b.b(rootView, api);
    }

    @Override // com.tencent.aio.api.list.o.a
    public void c(@NotNull View rootView, @NotNull o api) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) rootView, (Object) api);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(api, "api");
        this.f69623b.c(rootView, api);
    }

    @Override // com.tencent.aio.api.list.o.a
    @NotNull
    public View createView(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f69623b.createView(context);
    }

    @NotNull
    public final View d() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            value = iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            value = this.rootView.getValue();
        }
        return (View) value;
    }
}
