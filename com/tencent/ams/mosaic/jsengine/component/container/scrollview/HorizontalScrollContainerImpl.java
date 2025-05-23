package com.tencent.ams.mosaic.jsengine.component.container.scrollview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.component.container.FlexContainerImpl;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class HorizontalScrollContainerImpl extends BasicScrollContainer<MOHorizontalScrollView> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends MOHorizontalScrollView {
        static IPatchRedirector $redirector_;

        a(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HorizontalScrollContainerImpl.this, (Object) context);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                HorizontalScrollContainerImpl.this.o(canvas);
                super.dispatchDraw(canvas);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            }
        }
    }

    public HorizontalScrollContainerImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.container.scrollview.BasicScrollContainer
    @NonNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public MOHorizontalScrollView w(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MOHorizontalScrollView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        return new a(context);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.scrollview.Scroll
    public float getScrollPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return MosaicUtils.E(((MOHorizontalScrollView) this.f71095e).getScrollX());
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.scrollview.Scroll
    public void scrollTo(float f16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Boolean.valueOf(z16));
        } else if (!z16) {
            ((MOHorizontalScrollView) this.f71095e).scrollTo((int) MosaicUtils.j(f16), 0);
        } else {
            ((MOHorizontalScrollView) this.f71095e).smoothScrollTo((int) MosaicUtils.j(f16), 0);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.scrollview.Scroll
    public void setScrollEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            ((MOHorizontalScrollView) this.f71095e).setNestedScrollingEnabled(z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.scrollview.Scroll
    public void showScrollIndicator(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            ((MOHorizontalScrollView) this.f71095e).setHorizontalScrollBarEnabled(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "HorizontalScrollContainerImpl";
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.scrollview.BasicScrollContainer
    protected void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ViewGroup viewGroup = this.f71096f;
        if (viewGroup instanceof LinearLayout) {
            ((LinearLayout) viewGroup).setOrientation(0);
        }
        ((MOHorizontalScrollView) this.f71095e).addView(this.f71096f, new FrameLayout.LayoutParams(-2, -1));
        ((MOHorizontalScrollView) this.f71095e).setOnScrollChangeListener(this);
        FlexContainerImpl flexContainerImpl = this.f71097h;
        if (flexContainerImpl != null) {
            flexContainerImpl.forceWidthAuto();
        }
    }
}
