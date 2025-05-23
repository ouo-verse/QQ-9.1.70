package com.tencent.aio.part.root.panel.bottomdialog.mvx.vm;

import com.tencent.aio.part.root.panel.bottomdialog.mvx.intent.BottomDialogShowIntent;
import com.tencent.aio.part.root.panel.bottomdialog.mvx.intent.a;
import com.tencent.aio.part.root.panel.bottomdialog.mvx.state.BottomDialogState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0007*\u0002\u0012\u0016\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/vm/a;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/intent/a;", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/state/BottomDialogState;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "l", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "d", "I", "showCount", "com/tencent/aio/part/root/panel/bottomdialog/mvx/vm/a$b", "e", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/vm/a$b;", "onBackEventCallback", "com/tencent/aio/part/root/panel/bottomdialog/mvx/vm/a$a", "f", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/vm/a$a;", "action", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a extends com.tencent.aio.base.mvvm.b<com.tencent.aio.part.root.panel.bottomdialog.mvx.intent.a, BottomDialogState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int showCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b onBackEventCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final C0638a action;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aio/part/root/panel/bottomdialog/mvx/vm/a$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.bottomdialog.mvx.vm.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0638a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        C0638a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                a.this.m(i3);
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/part/root/panel/bottomdialog/mvx/vm/a$b", "Lcom/tencent/aio/api/runtime/emitter/a;", "", "onBackEvent", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class b implements com.tencent.aio.api.runtime.emitter.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.aio.api.runtime.emitter.a
        public boolean onBackEvent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
            }
            if (a.this.showCount > 0) {
                a.this.updateUI(new BottomDialogState(false, null, 0, 0, 0, null, 62, null));
                return true;
            }
            return false;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.onBackEventCallback = new b();
            this.action = new C0638a();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.aio.part.root.panel.bottomdialog.mvx.intent.a intent) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C0635a) {
            int i16 = this.showCount;
            if (((a.C0635a) intent).a()) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            this.showCount = i16 + i3;
        }
    }

    public final void m(@NotNull MsgIntent i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) i3);
            return;
        }
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof BottomDialogShowIntent.BottomDialogShowAtLocationIntent) {
            BottomDialogShowIntent.BottomDialogShowAtLocationIntent bottomDialogShowAtLocationIntent = (BottomDialogShowIntent.BottomDialogShowAtLocationIntent) i3;
            updateUI(new BottomDialogState(bottomDialogShowAtLocationIntent.a(), bottomDialogShowAtLocationIntent.b(), 1, bottomDialogShowAtLocationIntent.c(), bottomDialogShowAtLocationIntent.d(), null, 32, null));
        } else if (i3 instanceof BottomDialogShowIntent.BottomDialogShowAnchorView) {
            BottomDialogShowIntent.BottomDialogShowAnchorView bottomDialogShowAnchorView = (BottomDialogShowIntent.BottomDialogShowAnchorView) i3;
            updateUI(new BottomDialogState(bottomDialogShowAnchorView.a(), bottomDialogShowAnchorView.c(), 2, 0, 0, bottomDialogShowAnchorView.b(), 24, null));
        } else if (i3 instanceof BottomDialogShowIntent) {
            updateUI(new BottomDialogState(((BottomDialogShowIntent) i3).a(), null, 0, 0, 0, null, 62, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.onDestroy();
            ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this.onBackEventCallback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(BottomDialogShowIntent.class).getQualifiedName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(BottomDialogShowIntent.BottomDialogShowAnchorView.class).getQualifiedName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(BottomDialogShowIntent.BottomDialogShowAtLocationIntent.class).getQualifiedName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this.onBackEventCallback);
    }
}
