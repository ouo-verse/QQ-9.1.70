package com.tencent.ams.mosaic.jsengine.component.container;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.tencent.ams.mosaic.MosaicView;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlexContainerImpl extends ContainerComponent implements Flex {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private final YogaLayout f71015e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class YogaLayout extends ViewGroup {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final ContainerComponent f71019d;

        /* renamed from: e, reason: collision with root package name */
        private final Map<View, YogaNode> f71020e;

        /* renamed from: f, reason: collision with root package name */
        private final YogaNode f71021f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f71022h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f71023i;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static class a implements YogaMeasureFunction {
            static IPatchRedirector $redirector_;

            public a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            private int a(YogaMeasureMode yogaMeasureMode) {
                if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
                    return Integer.MIN_VALUE;
                }
                if (yogaMeasureMode == YogaMeasureMode.EXACTLY) {
                    return 1073741824;
                }
                return 0;
            }

            @Override // com.facebook.yoga.YogaMeasureFunction
            public long measure(YogaNode yogaNode, float f16, YogaMeasureMode yogaMeasureMode, float f17, YogaMeasureMode yogaMeasureMode2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Long) iPatchRedirector.redirect((short) 2, this, yogaNode, Float.valueOf(f16), yogaMeasureMode, Float.valueOf(f17), yogaMeasureMode2)).longValue();
                }
                View view = (View) yogaNode.getData();
                if (view != null && !(view instanceof YogaLayout)) {
                    view.measure(View.MeasureSpec.makeMeasureSpec((int) f16, a(yogaMeasureMode)), View.MeasureSpec.makeMeasureSpec((int) f17, a(yogaMeasureMode2)));
                    return YogaMeasureOutput.make(view.getMeasuredWidth(), view.getMeasuredHeight());
                }
                return YogaMeasureOutput.make(0, 0);
            }
        }

        public YogaLayout(Context context, ContainerComponent containerComponent) {
            this(context, null, 0, containerComponent);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) containerComponent);
        }

        private void b(YogaNode yogaNode, float f16, float f17) {
            View view = (View) yogaNode.getData();
            if (view != null && view != this) {
                if (view.getVisibility() == 8) {
                    return;
                }
                int round = Math.round(yogaNode.getLayoutX() + f16);
                int round2 = Math.round(yogaNode.getLayoutY() + f17);
                view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutHeight()), 1073741824));
                view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
            }
            int childCount = yogaNode.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (equals(view)) {
                    b(yogaNode.getChildAt(i3), f16, f17);
                } else if (!(view instanceof YogaLayout)) {
                    b(yogaNode.getChildAt(i3), yogaNode.getLayoutX() + f16, yogaNode.getLayoutY() + f17);
                }
            }
        }

        private void c(int i3, int i16) {
            int size = View.MeasureSpec.getSize(i3);
            int size2 = View.MeasureSpec.getSize(i16);
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            if (mode2 == 1073741824) {
                if (this.f71022h) {
                    this.f71021f.setHeightAuto();
                } else {
                    this.f71021f.setHeight(size2);
                }
            }
            if (mode == 1073741824) {
                if (this.f71023i) {
                    this.f71021f.setWidthAuto();
                } else {
                    this.f71021f.setWidth(size);
                }
            }
            if (mode2 == Integer.MIN_VALUE) {
                this.f71021f.setMaxHeight(size2);
            }
            if (mode == Integer.MIN_VALUE) {
                this.f71021f.setMaxWidth(size);
            }
            this.f71021f.calculateLayout(Float.NaN, Float.NaN);
        }

        private void e(View view, boolean z16) {
            YogaNode yogaNode = this.f71020e.get(view);
            if (yogaNode == null) {
                return;
            }
            YogaNode owner = yogaNode.getOwner();
            int i3 = 0;
            while (true) {
                if (i3 >= owner.getChildCount()) {
                    break;
                }
                if (owner.getChildAt(i3).equals(yogaNode)) {
                    owner.removeChildAt(i3);
                    break;
                }
                i3++;
            }
            yogaNode.setData(null);
            this.f71020e.remove(view);
            if (z16) {
                this.f71021f.calculateLayout(Float.NaN, Float.NaN);
            }
        }

        public void a(View view, YogaNode yogaNode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) yogaNode);
                return;
            }
            this.f71021f.setMeasureFunction(null);
            super.addView(view);
            yogaNode.setData(view);
            if (!(view instanceof YogaLayout) && !yogaNode.isMeasureDefined()) {
                yogaNode.setMeasureFunction(new a());
            }
            this.f71020e.put(view, yogaNode);
            YogaNode yogaNode2 = this.f71021f;
            yogaNode2.addChildAt(yogaNode, yogaNode2.getChildCount());
        }

        @Override // android.view.ViewGroup
        protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) layoutParams)).booleanValue();
            }
            return layoutParams instanceof ViewGroup.LayoutParams;
        }

        public YogaNode d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (YogaNode) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.f71021f;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
                return;
            }
            try {
                this.f71019d.o(canvas);
                super.dispatchDraw(canvas);
            } catch (Throwable th5) {
                f.c("FlexContainerImpl", "[YogaLayout][dispatchDraw] error: " + th5.getMessage(), th5);
            }
        }

        @Override // android.view.ViewGroup
        protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 21, (Object) this);
            }
            return new ViewGroup.LayoutParams(-1, -1);
        }

        @Override // android.view.ViewGroup
        public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? new ViewGroup.LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 20, (Object) this, (Object) attributeSet);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            if (!(getParent() instanceof YogaLayout)) {
                c(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i18 - i16, 1073741824));
            }
            b(this.f71021f, 0.0f, 0.0f);
        }

        @Override // android.view.View
        protected void onMeasure(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (!(getParent() instanceof YogaLayout)) {
                c(i3, i16);
            }
            setMeasuredDimension(Math.round(this.f71021f.getLayoutWidth()), Math.round(this.f71021f.getLayoutHeight()));
        }

        @Override // android.view.ViewGroup
        public void removeAllViews() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this);
                return;
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                e(getChildAt(i3), false);
            }
            super.removeAllViews();
        }

        @Override // android.view.ViewGroup
        public void removeAllViewsInLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this);
                return;
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                e(getChildAt(i3), true);
            }
            super.removeAllViewsInLayout();
        }

        @Override // android.view.ViewGroup, android.view.ViewManager
        public void removeView(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
            } else {
                e(view, false);
                super.removeView(view);
            }
        }

        @Override // android.view.ViewGroup
        public void removeViewAt(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, i3);
            } else {
                e(getChildAt(i3), false);
                super.removeViewAt(i3);
            }
        }

        @Override // android.view.ViewGroup
        public void removeViewInLayout(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
            } else {
                e(view, true);
                super.removeViewInLayout(view);
            }
        }

        @Override // android.view.ViewGroup
        public void removeViews(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            for (int i17 = i3; i17 < i3 + i16; i17++) {
                e(getChildAt(i17), false);
            }
            super.removeViews(i3, i16);
        }

        @Override // android.view.ViewGroup
        public void removeViewsInLayout(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            for (int i17 = i3; i17 < i3 + i16; i17++) {
                e(getChildAt(i17), true);
            }
            super.removeViewsInLayout(i3, i16);
        }

        public void setForceHeightAuto(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.f71022h = z16;
            }
        }

        public void setForceWidthAuto(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                this.f71023i = z16;
            }
        }

        public YogaLayout(Context context, AttributeSet attributeSet, int i3, ContainerComponent containerComponent) {
            super(context, attributeSet, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3), containerComponent);
                return;
            }
            this.f71019d = containerComponent;
            MosaicUtils.l(context);
            YogaNode create = YogaNodeFactory.create();
            this.f71021f = create;
            this.f71020e = new HashMap();
            create.setData(this);
        }

        @Override // android.view.ViewGroup
        protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? new ViewGroup.LayoutParams(layoutParams) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 22, (Object) this, (Object) layoutParams);
        }
    }

    public FlexContainerImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        YogaLayout yogaLayout = new YogaLayout(context, this);
        this.f71015e = yogaLayout;
        this.mYogaNode = yogaLayout.d();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent, com.tencent.ams.mosaic.jsengine.component.container.Container
    public boolean addChild(ComponentBase componentBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) componentBase)).booleanValue();
        }
        if (super.addChild(componentBase)) {
            return true;
        }
        if (componentBase.getParent() == this) {
            f.h("FlexContainerImpl", "add child component:" + componentBase.getId() + " failed: child has been added");
            return true;
        }
        if (componentBase.getView().getParent() != null) {
            t(componentBase);
        }
        YogaNode yogaNode = (YogaNode) componentBase.getYogaNode();
        if (yogaNode != null && (getView() instanceof YogaLayout)) {
            MosaicUtils.I(new Runnable(componentBase, (YogaLayout) getView(), yogaNode) { // from class: com.tencent.ams.mosaic.jsengine.component.container.FlexContainerImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ComponentBase f71016d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ YogaLayout f71017e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ YogaNode f71018f;

                {
                    this.f71016d = componentBase;
                    this.f71017e = r7;
                    this.f71018f = yogaNode;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FlexContainerImpl.this, componentBase, r7, yogaNode);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int q16 = FlexContainerImpl.this.q(this.f71016d);
                    try {
                        if (q16 == -1) {
                            FlexContainerImpl.this.f71009d.add(this.f71016d);
                        } else {
                            FlexContainerImpl.this.f71009d.add(q16, this.f71016d);
                        }
                    } catch (Throwable unused) {
                        f.h("FlexContainerImpl", "add child component:" + this.f71016d.getId() + " fail IndexOutOfBoundsException: " + q16);
                    }
                    this.f71017e.a(this.f71016d.getView(), this.f71018f);
                    this.f71016d.setParent(FlexContainerImpl.this);
                    this.f71016d.onAddedToParent();
                }
            });
        }
        return true;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.Flex
    public void applyLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.container.FlexContainerImpl.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlexContainerImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ViewGroup view = FlexContainerImpl.this.getView();
                    if (view != null) {
                        view.requestLayout();
                    }
                    Container rootView = FlexContainerImpl.this.getJSEngine().d().getRootView();
                    if (rootView instanceof MosaicView) {
                        ((MosaicView) rootView).updateFixedComponentLayout();
                    }
                }
            });
        }
    }

    public void forceHeightAuto() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f71015e.setForceHeightAuto(true);
        }
    }

    public void forceWidthAuto() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f71015e.setForceWidthAuto(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "FlexContainerImpl";
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent, com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public ViewGroup getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f71015e : (ViewGroup) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}
