package com.tencent.qqnt.aio.reserve2.animation;

import android.os.Bundle;
import android.view.View;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.aio.panel.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.activity.delegatevb.FullForegroundVB;
import com.tencent.qqnt.aio.reserve2.animation.AnimationMviUIState;
import com.tencent.qqnt.aio.reserve2.animation.BusiAnimationEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0011\b\u0007\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R7\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001e`\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/aio/reserve2/animation/BusiAnimationVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "", "Lcom/tencent/qqnt/aio/reserve2/animation/AnimationMviUIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "Lcom/tencent/qqnt/aio/reserve2/animation/BusiAnimationEvent$AddFullScreenView;", "o", "Lcom/tencent/qqnt/aio/reserve2/animation/BusiAnimationEvent$GetFullScreenView;", "p", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/qqnt/aio/reserve2/animation/BusiAnimationVM$b", "e", "Lcom/tencent/qqnt/aio/reserve2/animation/BusiAnimationVM$b;", "mAction", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "mFullScreenBusiList", h.F, "mAlwaysFullScreenBusiList", "Ljava/util/HashMap;", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "i", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Ljava/util/HashMap;", "mFullScreenViewMap", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class BusiAnimationVM extends com.tencent.qqnt.aio.baseVM.a<Object, AnimationMviUIState> {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final Lazy<Boolean> C;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> mFullScreenBusiList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> mAlwaysFullScreenBusiList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mFullScreenViewMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/reserve2/animation/BusiAnimationVM$a;", "", "", "fullScreenSwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "fullScreenSwitch", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.reserve2.animation.BusiAnimationVM$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) BusiAnimationVM.C.getValue()).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/reserve2/animation/BusiAnimationVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusiAnimationVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                BusiAnimationVM.this.E(i3);
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

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60629);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(BusiAnimationVM$Companion$fullScreenSwitch$2.INSTANCE);
        C = lazy;
    }

    public BusiAnimationVM() {
        ArrayList<Integer> arrayListOf;
        ArrayList<Integer> arrayListOf2;
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mAction = new b();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(2);
        this.mFullScreenBusiList = arrayListOf;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(6, 9);
        this.mAlwaysFullScreenBusiList = arrayListOf2;
        lazy = LazyKt__LazyJVMKt.lazy(BusiAnimationVM$mFullScreenViewMap$2.INSTANCE);
        this.mFullScreenViewMap = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof BusiAnimationEvent.AddFullScreenView) {
            o((BusiAnimationEvent.AddFullScreenView) intent);
        } else if (intent instanceof BusiAnimationEvent.RemoveFullScreenView) {
            updateUI(new AnimationMviUIState.RemoveFullScreenView(((BusiAnimationEvent.RemoveFullScreenView) intent).a()));
        } else if (intent instanceof BusiAnimationEvent.GetFullScreenView) {
            p((BusiAnimationEvent.GetFullScreenView) intent);
        }
    }

    private final HashMap<Integer, View> n() {
        return (HashMap) this.mFullScreenViewMap.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o(BusiAnimationEvent.AddFullScreenView intent) {
        Companion companion = INSTANCE;
        if (companion.b() && this.mAlwaysFullScreenBusiList.contains(Integer.valueOf(intent.a()))) {
            n().put(Integer.valueOf(intent.a()), intent.b());
            SimpleEventBus.getInstance().dispatchEvent(new FullForegroundVB.AddAnimViewEvent(intent.a()));
            QLog.i(FrameworkVM.TAG, 1, "handleAddView  intent.busiType:" + intent.a());
            return;
        }
        if (companion.b() && this.mFullScreenBusiList.contains(Integer.valueOf(intent.a())) && c.f193019a.b((com.tencent.aio.api.runtime.a) getMContext())) {
            n().put(Integer.valueOf(intent.a()), intent.b());
            j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            Bundle bundle = new Bundle();
            bundle.putInt("key_anim_type", intent.a());
            Unit unit = Unit.INSTANCE;
            e16.h(new ExternalCommIntent("add_full_screen_foreground_view", bundle));
            return;
        }
        updateUI(new AnimationMviUIState.AddFullScreenView(intent.a(), intent.b()));
    }

    private final void p(BusiAnimationEvent.GetFullScreenView intent) {
        intent.c(n().remove(Integer.valueOf(intent.a())));
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.reserve2.animation.BusiAnimationEvent.AddFullScreenView");
        hashSet.add("com.tencent.qqnt.aio.reserve2.animation.BusiAnimationEvent.RemoveFullScreenView");
        hashSet.add("com.tencent.qqnt.aio.reserve2.animation.BusiAnimationEvent.GetFullScreenView");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        n().clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
    }
}
