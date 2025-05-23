package com.tencent.mobileqq.aio.reserve2.animate;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.reserve2.animate.PhotoPanelDragAnimateEvent;
import com.tencent.mobileqq.aio.reserve2.animate.PhotoPanelDragAnimateState;
import com.tencent.mobileqq.aio.reserve2.mask.TransparentMaskEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.aio.utils.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007*\u0001\u0012\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve2/animate/c;", "Lcom/tencent/qqnt/aio/lazy/lazyInit/b;", "Lol3/b;", "Lcom/tencent/mobileqq/aio/reserve2/animate/PhotoPanelDragAnimateState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "initMsgIntent", "", "E", "Lcom/tencent/mobileqq/aio/reserve2/animate/PhotoPanelDragAnimateEvent$AnimateEvent;", "event", "o", "", DomainData.DOMAIN_NAME, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/mobileqq/aio/reserve2/animate/c$a", "f", "Lcom/tencent/mobileqq/aio/reserve2/animate/c$a;", "mMessageAction", "<init>", "(Lcom/tencent/mvi/base/route/MsgIntent;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class c extends com.tencent.qqnt.aio.lazy.lazyInit.b<ol3.b, PhotoPanelDragAnimateState> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mMessageAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/reserve2/animate/c$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                c.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull MsgIntent initMsgIntent) {
        super(initMsgIntent);
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) initMsgIntent);
        } else {
            this.mMessageAction = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent initMsgIntent) {
        if (initMsgIntent instanceof PhotoPanelDragAnimateEvent.AnimateEvent) {
            o((PhotoPanelDragAnimateEvent.AnimateEvent) initMsgIntent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int n() {
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(InputEvent.GetInputBarHeight.f188570d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.input.edit.AIOInputMsgResult.GetInputBarHeightResult");
        return ((d.c) k3).a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o(PhotoPanelDragAnimateEvent.AnimateEvent event) {
        updateUI(new PhotoPanelDragAnimateState.PhotoPanelAnimateState(event.b(), n(), event.a()));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new TransparentMaskEvent.UpdateMaskVisibility(event.b()));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.ShowBlurMsgView(event.b()));
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.b
    public void l(@NotNull MsgIntent initMsgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) initMsgIntent);
        } else {
            Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
            E(initMsgIntent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroy();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b(j.f352301a.a(Reflection.getOrCreateKotlinClass(PhotoPanelDragAnimateEvent.AnimateEvent.class)), this.mMessageAction);
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        context.e().d(j.f352301a.a(Reflection.getOrCreateKotlinClass(PhotoPanelDragAnimateEvent.AnimateEvent.class)), this.mMessageAction);
    }
}
