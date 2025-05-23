package com.tencent.ams.mosaic.jsengine.component.container.pager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.ams.mosaic.jsengine.component.container.Container;
import com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent;
import com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager.OrientedViewPager;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.ams.mosaic.utils.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class PagerContainerImpl extends ContainerComponent implements Pager, ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_;
    private int C;
    private JSFunction D;
    private int E;
    private boolean F;
    private final Handler G;
    private final Runnable H;

    /* renamed from: e, reason: collision with root package name */
    private final OrientedViewPager f71028e;

    /* renamed from: f, reason: collision with root package name */
    private final com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager.c f71029f;

    /* renamed from: h, reason: collision with root package name */
    private final b f71030h;

    /* renamed from: i, reason: collision with root package name */
    private ComponentFactory f71031i;

    /* renamed from: m, reason: collision with root package name */
    private int f71032m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends PagerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) PagerContainerImpl.this);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, viewGroup, Integer.valueOf(i3), obj);
            } else {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return PagerContainerImpl.this.getChildren().size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            View view = PagerContainerImpl.this.getChildren().get(i3).getView();
            if (view.getParent() != null) {
                k.c(view);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, obj)).booleanValue();
            }
            if (view == obj) {
                return true;
            }
            return false;
        }

        /* synthetic */ b(PagerContainerImpl pagerContainerImpl, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pagerContainerImpl, (Object) aVar);
        }
    }

    /* loaded from: classes3.dex */
    private class c extends OrientedViewPager {
        static IPatchRedirector $redirector_;

        public c(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PagerContainerImpl.this, (Object) context);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager.OrientedViewPager, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager.OrientedViewPager, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return false;
        }
    }

    public PagerContainerImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.E = gdt_analysis_event.EVENT_GET_USER_AGENT;
        this.G = new Handler(Looper.getMainLooper());
        this.H = new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.container.pager.c
            @Override // java.lang.Runnable
            public final void run() {
                PagerContainerImpl.this.B();
            }
        };
        c cVar = new c(context);
        this.f71028e = cVar;
        cVar.setOrientation(OrientedViewPager.Orientation.VERTICAL);
        com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager.c cVar2 = new com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager.c(context);
        this.f71029f = cVar2;
        cVar.setPageTransformer(true, cVar2);
        b bVar = new b(this, null);
        this.f71030h = bVar;
        cVar.setAdapter(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(ComponentBase componentBase) {
        y(componentBase);
        this.f71030h.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        this.f71030h.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(int i3) {
        this.C = i3;
        int i16 = i3 - 1;
        this.f71028e.setOffscreenPageLimit(i16);
        this.f71029f.g(i16);
        this.f71030h.notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y(ComponentBase componentBase) {
        if (this.f71031i == null) {
            this.f71031i = new ComponentFactory(this.mContext, getJSEngine());
        }
        try {
            Container container = (Container) this.f71031i.createComponent(ComponentFactory.ComponentType.FRAME_CONTAINER, "Frame_Page_Container", -1.0f, -1.0f);
            container.addChild(componentBase);
            this.f71009d.add((ComponentBase) container);
            container.setParent(this);
            container.onAddedToParent();
            this.f71030h.notifyDataSetChanged();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void B() {
        if (this.f71030h.getF373114d() > 1) {
            scrollToPage(this.f71028e.s() + 1, true);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent, com.tencent.ams.mosaic.jsengine.component.container.Container
    public boolean addChild(final ComponentBase componentBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) componentBase)).booleanValue();
        }
        if (componentBase == null) {
            f.h("PagerContainerImpl", "addChild failed: child is null");
            return true;
        }
        if (this.f71031i == null) {
            this.f71031i = new ComponentFactory(this.mContext, getJSEngine());
        }
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.container.pager.b
            @Override // java.lang.Runnable
            public final void run() {
                PagerContainerImpl.this.A(componentBase);
            }
        });
        return true;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.Pager
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.G.post(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.container.pager.a
                @Override // java.lang.Runnable
                public final void run() {
                    PagerContainerImpl.this.C();
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void onAddedToParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        super.onAddedToParent();
        this.f71030h.notifyDataSetChanged();
        this.f71028e.setOnPageChangeListener(this);
        this.f71028e.setCurrentItem(0, false);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else if (i3 == 0) {
            if (this.f71028e.s() == getChildren().size() - this.C) {
                this.f71028e.setCurrentItem(0, false);
            }
            startLoop();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        f.e("PagerContainerImpl", "onPageSelected: " + i3);
        if (this.D != null) {
            getJSEngine().u(this.D, new Object[]{Integer.valueOf(i3)}, null);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.BasicComponent, com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void onRemovedFromParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        stopLoop();
        this.f71028e.setOnPageChangeListener(null);
        super.onRemovedFromParent();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.Pager
    public void scrollToPage(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        f.e("PagerContainerImpl", "scrollToPage position: " + i3 + ", animated: " + z16);
        this.f71028e.setCurrentItem(i3, z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.Pager
    public void setAutoScrollInterval(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        f.e("PagerContainerImpl", "setAutoScrollInterval: " + i3);
        this.E = i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.Pager
    public void setOnPageSelectListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) jSFunction);
        } else {
            this.D = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.Pager
    public void setPageSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        f.e("PagerContainerImpl", "setPageSize: " + i3);
        this.f71032m = i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.Pager
    public void setScroller(int i3, float[] fArr) {
        PathInterpolator pathInterpolator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) fArr);
            return;
        }
        if (fArr != null && fArr.length == 4) {
            pathInterpolator = new PathInterpolator(fArr[0], fArr[1], fArr[2], fArr[3]);
        } else {
            pathInterpolator = null;
        }
        this.f71028e.setScroller(new com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager.a(this.mContext, i3, pathInterpolator));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.Pager
    public void setStackSize(final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        f.e("PagerContainerImpl", "setStackSize: " + i3);
        if (i3 > 1) {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.container.pager.d
                @Override // java.lang.Runnable
                public final void run() {
                    PagerContainerImpl.this.D(i3);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.Pager
    public void startAutoScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            f.e("PagerContainerImpl", "startAutoScroll");
            startLoop();
        }
    }

    public void startLoop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (this.f71032m > 1) {
            this.G.postDelayed(this.H, this.E);
            this.F = true;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.Pager
    public void stopAutoScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            f.e("PagerContainerImpl", "stopAutoScroll");
            stopLoop();
        }
    }

    public void stopLoop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (this.F) {
            this.G.removeCallbacks(this.H);
            this.F = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "PagerContainerImpl";
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent, com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public ViewGroup getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f71028e : (ViewGroup) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
