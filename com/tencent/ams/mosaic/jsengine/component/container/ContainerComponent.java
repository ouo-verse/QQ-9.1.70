package com.tencent.ams.mosaic.jsengine.component.container;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.a;
import com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class ContainerComponent extends BasicComponent implements Container {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected final List<ComponentBase> f71009d;

    public ContainerComponent(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f71009d = new CopyOnWriteArrayList();
        }
    }

    public boolean addChild(ComponentBase componentBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentBase)).booleanValue();
        }
        if (componentBase == null) {
            f.h("ContainerComponent", "addChild failed: child is null");
            return true;
        }
        Container rootView = getJSEngine().d().getRootView();
        if (componentBase.getPositionType() == 3 && rootView != null && this != rootView) {
            rootView.addChild(componentBase);
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer
    public void addLayer(LayerBase layerBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) layerBase);
            return;
        }
        super.addLayer(layerBase);
        ViewGroup view = getView();
        if (view != null) {
            view.setWillNotDraw(false);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.Container
    public List<ComponentBase> getChildren() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f71009d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public abstract ViewGroup getView();

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(Canvas canvas) {
        BasicComponent.c boxShadow;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) canvas);
            return;
        }
        for (ComponentBase componentBase : this.f71009d) {
            if ((componentBase instanceof BasicComponent) && (boxShadow = ((BasicComponent) componentBase).getBoxShadow()) != null) {
                boxShadow.a(canvas, getView(), componentBase.getView());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int p(ComponentBase componentBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) componentBase)).intValue();
        }
        if (componentBase == null) {
            return 0;
        }
        if (componentBase.getHeight() == -1.0f) {
            return -1;
        }
        if (componentBase.getHeight() == -2.0f) {
            return -2;
        }
        return (int) MosaicUtils.j(componentBase.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int q(ComponentBase componentBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) componentBase)).intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int r(ComponentBase componentBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) componentBase)).intValue();
        }
        if (componentBase == null) {
            return 0;
        }
        if (componentBase.getWidth() == -1.0f) {
            return -1;
        }
        if (componentBase.getWidth() == -2.0f) {
            return -2;
        }
        return (int) MosaicUtils.j(componentBase.getWidth());
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.Container
    public void removeAllChildren() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ContainerComponent.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ContainerComponent.this.getView().removeAllViews();
                        ContainerComponent.this.f71009d.clear();
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.Container
    public void removeChild(ComponentBase componentBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) componentBase);
        } else {
            t(componentBase);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(ComponentBase componentBase, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, componentBase, viewGroup, layoutParams);
            return;
        }
        if (componentBase != null && viewGroup != null) {
            if (componentBase.getParent() == this) {
                f.h("ContainerComponent", "add child component:" + componentBase.getId() + " failed: child has been added");
                return;
            }
            if (componentBase.getView().getParent() != null) {
                t(componentBase);
            }
            MosaicUtils.I(new Runnable(componentBase, viewGroup, layoutParams) { // from class: com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ComponentBase f71010d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ViewGroup f71011e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ ViewGroup.LayoutParams f71012f;

                {
                    this.f71010d = componentBase;
                    this.f71011e = viewGroup;
                    this.f71012f = layoutParams;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ContainerComponent.this, componentBase, viewGroup, layoutParams);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int q16 = ContainerComponent.this.q(this.f71010d);
                    try {
                        try {
                            if (q16 == -1) {
                                ContainerComponent.this.f71009d.add(this.f71010d);
                            } else {
                                ContainerComponent.this.f71009d.add(q16, this.f71010d);
                            }
                            this.f71011e.addView(this.f71010d.getView(), q16, this.f71012f);
                            f.e("ContainerComponent", "add child component:" + this.f71010d.getId() + " success index: " + q16);
                        } catch (IndexOutOfBoundsException unused) {
                            this.f71011e.addView(this.f71010d.getView(), this.f71012f);
                            f.h("ContainerComponent", "add child component:" + this.f71010d.getId() + " fail IndexOutOfBoundsException: " + q16);
                        }
                    } catch (Throwable unused2) {
                        f.b("ContainerComponent", "add child component catch IndexOutOfBoundsException addView error again :" + this.f71010d.getId() + " fail IndexOutOfBoundsException: " + q16);
                    }
                    this.f71010d.setParent(ContainerComponent.this);
                    this.f71010d.onAddedToParent();
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.Container
    public void setDescendantFocusability(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        ViewGroup view = getView();
        if (view != null) {
            if ("beforeDescendants".equals(str)) {
                view.setDescendantFocusability(131072);
            } else if ("afterDescendants".equals(str)) {
                view.setDescendantFocusability(262144);
            } else if ("blocksDescendants".equals(str)) {
                view.setDescendantFocusability(393216);
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void setJSEngine(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        super.setJSEngine(aVar);
        Iterator<ComponentBase> it = this.f71009d.iterator();
        while (it.hasNext()) {
            it.next().setJSEngine(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(ComponentBase componentBase) {
        if (componentBase == null) {
            return;
        }
        View view = componentBase.getView();
        if (view.getParent() instanceof ViewGroup) {
            MosaicUtils.I(new Runnable(view, componentBase) { // from class: com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ View f71013d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ComponentBase f71014e;

                {
                    this.f71013d = view;
                    this.f71014e = componentBase;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ContainerComponent.this, view, componentBase);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        ContainerComponent.this.getView().removeView(this.f71013d);
                        this.f71014e.setParent(null);
                        this.f71014e.onRemovedFromParent();
                        ContainerComponent.this.f71009d.remove(this.f71014e);
                    } catch (Throwable th5) {
                        f.i("ContainerComponent", "safeRemoveChildComponent:" + this.f71014e.getId() + " failed", th5);
                    }
                }
            });
        }
    }
}
