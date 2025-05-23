package com.tencent.ams.mosaic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.mosaic.MosaicManager;
import com.tencent.ams.mosaic.jsengine.a;
import com.tencent.ams.mosaic.jsengine.common.Env;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent;
import com.tencent.ams.mosaic.jsengine.component.container.FrameContainerImpl;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class MosaicView extends FrameContainerImpl {
    static IPatchRedirector $redirector_;
    private int C;
    private Activity D;
    private int E;
    private boolean F;

    /* renamed from: f, reason: collision with root package name */
    private final Context f70613f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.ams.mosaic.jsengine.a f70614h;

    /* renamed from: i, reason: collision with root package name */
    private Env f70615i;

    /* renamed from: m, reason: collision with root package name */
    private int f70616m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements a.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MosaicManager.g f70617a;

        a(MosaicManager.g gVar) {
            this.f70617a = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MosaicView.this, (Object) gVar);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.a.b
        public void onFail(JSFunction jSFunction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSFunction);
                return;
            }
            com.tencent.ams.mosaic.utils.f.h("MosaicView", "[" + MosaicView.this.E + "] call js onTemplateUpdate fail");
            MosaicManager.g gVar = this.f70617a;
            if (gVar != null) {
                gVar.onViewCreateFail(1004);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.a.b
        public void onSuccess(JSFunction jSFunction, JSValue jSValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSFunction, (Object) jSValue);
                return;
            }
            com.tencent.ams.mosaic.utils.f.e("MosaicView", "[" + MosaicView.this.E + "] call js onTemplateUpdate success");
            MosaicManager.g gVar = this.f70617a;
            if (gVar != null) {
                gVar.onViewCreated(MosaicView.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements a.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MosaicView.this);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.a.b
        public void onFail(JSFunction jSFunction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSFunction);
                return;
            }
            com.tencent.ams.mosaic.utils.f.h("MosaicView", "[" + MosaicView.this.E + "] call js onSizeChanged fail");
        }

        @Override // com.tencent.ams.mosaic.jsengine.a.b
        public void onSuccess(JSFunction jSFunction, JSValue jSValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSFunction, (Object) jSValue);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("MosaicView", "[" + MosaicView.this.E + "] call js onSizeChanged success");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends FrameContainerImpl.FrameLayoutWrapper implements com.tencent.ams.mosaic.a {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        private final Application.ActivityLifecycleCallbacks f70620e;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class a implements Application.ActivityLifecycleCallbacks {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
                    return;
                }
                if (activity == MosaicView.this.D) {
                    com.tencent.ams.mosaic.utils.f.a("MosaicView", "[" + MosaicView.this.E + "] onActivityCreated");
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NonNull Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
                    return;
                }
                if (activity == MosaicView.this.D && MosaicView.this.f70614h != null) {
                    com.tencent.ams.mosaic.utils.f.a("MosaicView", "[" + MosaicView.this.E + "] onActivityDestroyed");
                    MosaicView.this.destroy();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NonNull Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
                    return;
                }
                if (activity == MosaicView.this.D && MosaicView.this.f70614h != null) {
                    com.tencent.ams.mosaic.utils.f.a("MosaicView", "[" + MosaicView.this.E + "] onActivityPaused");
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NonNull Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                    return;
                }
                if (activity == MosaicView.this.D) {
                    com.tencent.ams.mosaic.utils.f.a("MosaicView", "[" + MosaicView.this.E + "] onActivityResumed");
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
                    return;
                }
                if (activity == MosaicView.this.D) {
                    com.tencent.ams.mosaic.utils.f.a("MosaicView", "[" + MosaicView.this.E + "] onActivitySaveInstanceState");
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NonNull Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
                    return;
                }
                if (activity == MosaicView.this.D) {
                    com.tencent.ams.mosaic.utils.f.a("MosaicView", "[" + MosaicView.this.E + "] onActivityStarted");
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NonNull Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
                    return;
                }
                if (activity == MosaicView.this.D) {
                    com.tencent.ams.mosaic.utils.f.a("MosaicView", "[" + MosaicView.this.E + "] onActivityStopped");
                }
            }
        }

        public c(@NonNull Context context, ContainerComponent containerComponent) {
            super(context, containerComponent);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MosaicView.this, context, containerComponent);
            } else {
                this.f70620e = new a();
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.ams.mosaic.utils.f.e("MosaicView", "[" + MosaicView.this.E + "] registerActivityCallback");
            Activity activity = MosaicView.this.D;
            if (activity != null) {
                activity.getApplication().registerActivityLifecycleCallbacks(this.f70620e);
            }
            MosaicManager.j().d(this);
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            com.tencent.ams.mosaic.utils.f.e("MosaicView", "[" + MosaicView.this.E + "] unregisterActivityCallback");
            Activity activity = MosaicView.this.D;
            if (activity != null) {
                activity.getApplication().unregisterActivityLifecycleCallbacks(this.f70620e);
            }
            MosaicManager.j().m(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            super.onAttachedToWindow();
            com.tencent.ams.mosaic.utils.f.e("MosaicView", "[" + MosaicView.this.E + "] onAttachedToWindow");
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            super.onDetachedFromWindow();
            com.tencent.ams.mosaic.utils.f.e("MosaicView", "[" + MosaicView.this.E + "] onDetachedFromWindow");
        }

        @Override // android.view.View
        protected void onSizeChanged(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            super.onSizeChanged(i3, i16, i17, i18);
            com.tencent.ams.mosaic.utils.f.a("MosaicView", "[" + MosaicView.this.E + "] onSizeChanged: w - " + i3 + ", h - " + i16 + ", mJSEngine - " + MosaicView.this.f70614h);
            MosaicView.this.callJsOnSizeChanged(i3, i16);
        }
    }

    public MosaicView(Context context, String str, int i3, int i16) {
        super(context, str, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f70613f = context;
        this.D = MosaicUtils.m(context);
        this.f71024e = new c(context, this);
        this.E = hashCode();
    }

    private void B(String str, Object[] objArr, a.b bVar, boolean z16) {
        com.tencent.ams.mosaic.jsengine.a aVar = this.f70614h;
        if (aVar != null) {
            if (z16) {
                aVar.s(str, objArr, bVar);
            } else {
                aVar.n(str, objArr, bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        com.tencent.ams.mosaic.utils.f.e("MosaicView", "[" + this.E + "] closeJSEngine");
        this.D = null;
        MosaicUtils.F(new Runnable() { // from class: com.tencent.ams.mosaic.l
            @Override // java.lang.Runnable
            public final void run() {
                MosaicView.this.D();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        try {
            this.f70614h.close();
            com.tencent.ams.mosaic.utils.f.e("MosaicView", "[" + this.E + "] closeJSEngine finish");
        } catch (Throwable unused) {
        }
    }

    private void E(List<ComponentBase> list) {
        com.tencent.ams.mosaic.utils.f.a(tag(), "removeChildrenAnimation");
        if (list != null && !list.isEmpty()) {
            for (ComponentBase componentBase : list) {
                if (componentBase != null) {
                    componentBase.removeAnimation();
                    if (componentBase instanceof ContainerComponent) {
                        E(((ContainerComponent) componentBase).getChildren());
                    }
                }
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.FrameContainerImpl, com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent, com.tencent.ams.mosaic.jsengine.component.container.Container
    public boolean addChild(ComponentBase componentBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) componentBase)).booleanValue();
        }
        int r16 = r(componentBase);
        int p16 = p(componentBase);
        if (r16 == 0) {
            r16 = -1;
        }
        if (p16 == 0) {
            p16 = -1;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(r16, p16);
        if (componentBase.getPositionType() == 3) {
            v(componentBase, layoutParams);
        } else {
            layoutParams.leftMargin = componentBase.getLeftMargin();
            layoutParams.rightMargin = componentBase.getRightMargin();
            layoutParams.topMargin = componentBase.getTopMargin();
            layoutParams.bottomMargin = componentBase.getBottomMargin();
            if (!TextUtils.isEmpty(componentBase.getAlignParent())) {
                layoutParams.gravity = covertAlignSplice(componentBase.getAlignParent());
            }
        }
        s(componentBase, getView(), layoutParams);
        return true;
    }

    public void callJsOnSizeChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            callJsOnSizeChanged(i3, i16, f.k().t());
        } else {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("MosaicView", "[" + this.E + "] destroy");
        if (this.F) {
            com.tencent.ams.mosaic.utils.f.h("MosaicView", "[" + this.E + "] is destroyed");
            return;
        }
        this.F = true;
        FrameLayout frameLayout = this.f71024e;
        if (frameLayout instanceof c) {
            ((c) frameLayout).b();
        }
        this.f70614h.n(MosaicConstants$JsFunction.FUNC_ON_DESTROY, null, null);
        this.f70614h.g().b(new g("onActivityDestroyed"));
        MosaicUtils.J(new Runnable() { // from class: com.tencent.ams.mosaic.MosaicView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MosaicView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    MosaicView.this.C();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 1000L);
        Env env = this.f70615i;
        if (env != null) {
            env.c();
        }
        removeAnimation();
        E(getChildren());
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public com.tencent.ams.mosaic.jsengine.a getJSEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.ams.mosaic.jsengine.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f70614h;
    }

    public void registerActivityCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            ((c) this.f71024e).a();
        }
    }

    public void setActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            this.D = activity;
        }
    }

    public void setEngine(@NonNull com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f70614h = aVar;
        }
    }

    public void setEnv(Env env) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) env);
        } else {
            this.f70615i = env;
        }
    }

    public void setEventHandler(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iVar);
            return;
        }
        com.tencent.ams.mosaic.jsengine.a aVar = this.f70614h;
        if (aVar != null) {
            aVar.g().a(iVar);
        }
    }

    public void updateAdData(String str, a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            updateAdData(str, bVar, false);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) bVar);
        }
    }

    public void updateFixedComponentLayout() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        for (ComponentBase componentBase : this.f71009d) {
            if (componentBase != null && componentBase.getPositionType() == 3 && (view = componentBase.getView()) != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    v(componentBase, (FrameLayout.LayoutParams) layoutParams);
                }
            }
        }
    }

    public void updateTemplate(k kVar, MosaicManager.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            updateTemplate(kVar, gVar, false);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) kVar, (Object) gVar);
        }
    }

    public void callJsOnSizeChanged(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        } else {
            if (i3 == this.C && i16 == this.f70616m) {
                return;
            }
            this.f70616m = i16;
            this.C = i3;
            B(MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, new Object[]{Float.valueOf(MosaicUtils.E(i3)), Float.valueOf(MosaicUtils.E(i16))}, new b(), z16);
        }
    }

    public void updateAdData(String str, a.b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            B(MosaicConstants$JsFunction.FUNC_ON_AD_DATA_UPDATE, new Object[]{str}, bVar, z16);
        } else {
            iPatchRedirector.redirect((short) 8, this, str, bVar, Boolean.valueOf(z16));
        }
    }

    public void updateTemplate(k kVar, MosaicManager.g gVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            B(MosaicConstants$JsFunction.FUNC_ON_TEMPLATE_UPDATE, new Object[]{kVar.d()}, new a(gVar), z16);
        } else {
            iPatchRedirector.redirect((short) 6, this, kVar, gVar, Boolean.valueOf(z16));
        }
    }
}
