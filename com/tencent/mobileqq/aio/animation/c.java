package com.tencent.mobileqq.aio.animation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.animation.AIOAnimationState;
import com.tencent.mobileqq.aio.animation.a;
import com.tencent.mobileqq.aio.animation.api.IAioAnimationApi;
import com.tencent.mobileqq.aio.animation.data.a;
import com.tencent.mobileqq.aio.event.AIOMsgViewRect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u0007H\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/animation/a;", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationState;", "Lcom/tencent/mobileqq/aio/animation/data/a;", "", "height", "", "f1", "g1", "deltaY", "d1", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "b1", "state", "c1", "Landroid/content/Context;", "getContext", "Landroid/view/ViewGroup;", "getParent", "getWidth", "getInputBarHeight", "V0", "", "Lcom/tencent/mobileqq/aio/animation/data/a$a;", "j0", "Landroid/view/View$OnLayoutChangeListener;", "listener", "Y0", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "rootContainer", "Lcom/tencent/mobileqq/aio/animation/data/h;", "e", "Lcom/tencent/mobileqq/aio/animation/data/h;", "animationContainer", "<init>", "()V", "f", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c extends com.tencent.aio.base.mvvm.a<a, AIOAnimationState> implements com.tencent.mobileqq.aio.animation.data.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout rootContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.animation.data.h animationContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.c$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41769);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d1(int deltaY) {
        com.tencent.mobileqq.aio.animation.data.h hVar = this.animationContainer;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationContainer");
            hVar = null;
        }
        hVar.c(deltaY);
    }

    private final void e1() {
        com.tencent.mobileqq.aio.animation.data.h hVar = this.animationContainer;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationContainer");
            hVar = null;
        }
        hVar.stopAnimation();
        ((IAioAnimationApi) QRoute.api(IAioAnimationApi.class)).cancelAll();
    }

    private final void f1(int height) {
        com.tencent.mobileqq.aio.animation.data.h hVar = this.animationContainer;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationContainer");
            hVar = null;
        }
        hVar.b(height);
    }

    private final void g1(int height) {
        com.tencent.mobileqq.aio.animation.data.h hVar = this.animationContainer;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationContainer");
            hVar = null;
        }
        hVar.a(height);
    }

    @Override // com.tencent.mobileqq.aio.animation.data.a
    public int V0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        a.C7232a c7232a = new a.C7232a(0, 1, null);
        sendIntent(c7232a);
        return c7232a.a();
    }

    @Override // com.tencent.mobileqq.aio.animation.data.a
    public void Y0(@NotNull View.OnLayoutChangeListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        RelativeLayout relativeLayout = this.rootContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            relativeLayout = null;
        }
        relativeLayout.addOnLayoutChangeListener(listener);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, AIOAnimationState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        com.tencent.mobileqq.aio.animation.data.h hVar = this.animationContainer;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationContainer");
            hVar = null;
        }
        return new AIOAnimationVM(hVar);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AIOAnimationState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOAnimationState.ListScrolled) {
            d1(((AIOAnimationState.ListScrolled) state).a());
            return;
        }
        if (state instanceof AIOAnimationState.StopAnimation) {
            e1();
        } else if (state instanceof AIOAnimationState.UpdateTitleHeight) {
            g1(((AIOAnimationState.UpdateTitleHeight) state).a());
        } else if (state instanceof AIOAnimationState.UpdateBottomHeight) {
            f1(((AIOAnimationState.UpdateBottomHeight) state).a());
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.data.a
    @NotNull
    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Context) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        RelativeLayout relativeLayout = this.rootContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            relativeLayout = null;
        }
        Context context = relativeLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootContainer.context");
        return context;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.a
    public int getInputBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        a.b bVar = new a.b(0, 1, null);
        sendIntent(bVar);
        return bVar.a();
    }

    @Override // com.tencent.mobileqq.aio.animation.data.a
    @NotNull
    public ViewGroup getParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        RelativeLayout relativeLayout = this.rootContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            return null;
        }
        return relativeLayout;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.a
    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        RelativeLayout relativeLayout = this.rootContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            relativeLayout = null;
        }
        return relativeLayout.getWidth();
    }

    @Override // com.tencent.mobileqq.aio.animation.data.a
    @NotNull
    public List<a.C7235a> j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        a.c cVar = new a.c(null);
        sendIntent(cVar);
        if (cVar.a() == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        List<AIOMsgViewRect> a16 = cVar.a();
        Intrinsics.checkNotNull(a16);
        for (AIOMsgViewRect aIOMsgViewRect : a16) {
            arrayList.add(new a.C7235a(aIOMsgViewRect.a(), aIOMsgViewRect.c(), aIOMsgViewRect.b()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.a
    public void l(@NotNull View.OnLayoutChangeListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        RelativeLayout relativeLayout = this.rootContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            relativeLayout = null;
        }
        relativeLayout.removeOnLayoutChangeListener(listener);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        RelativeLayout relativeLayout = new RelativeLayout(createViewParams.a());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.rootContainer = relativeLayout;
        com.tencent.mobileqq.aio.animation.data.h createContainer = ((IAioAnimationApi) QRoute.api(IAioAnimationApi.class)).createContainer(createViewParams.a());
        this.animationContainer = createContainer;
        Object obj = createContainer;
        if (createContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationContainer");
            obj = null;
        }
        ((View) obj).setVisibility(0);
        ViewGroup b16 = createViewParams.b();
        Object obj2 = this.animationContainer;
        if (obj2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationContainer");
            obj2 = null;
        }
        b16.addView((View) obj2, new ViewGroup.LayoutParams(-1, -1));
        com.tencent.mobileqq.aio.animation.data.h hVar = this.animationContainer;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationContainer");
            hVar = null;
        }
        hVar.d(this);
        RelativeLayout relativeLayout2 = this.rootContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            return null;
        }
        return relativeLayout2;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.mobileqq.aio.animation.data.h hVar = this.animationContainer;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationContainer");
            hVar = null;
        }
        hVar.stopAnimation();
    }
}
