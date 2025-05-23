package com.tencent.ams.mosaic.jsengine.component.gesture;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.slideinteractive.FeatureGestureView;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.component.FeatureComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GestureComponentImpl extends FeatureComponent implements GestureComponent, SlideGestureViewHelper.ISlideGestureListener {
    static IPatchRedirector $redirector_;
    private float C;

    /* renamed from: d, reason: collision with root package name */
    private final FeatureGestureView f71123d;

    /* renamed from: e, reason: collision with root package name */
    private JSFunction f71124e;

    /* renamed from: f, reason: collision with root package name */
    private JSFunction f71125f;

    /* renamed from: h, reason: collision with root package name */
    private float f71126h;

    /* renamed from: i, reason: collision with root package name */
    private float f71127i;

    /* renamed from: m, reason: collision with root package name */
    private float f71128m;

    public GestureComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        FeatureGestureView featureGestureView = new FeatureGestureView(context);
        this.f71123d = featureGestureView;
        featureGestureView.setSlideGestureListener(this);
    }

    private void j(int i3, float f16, float f17) {
        if (this.f71125f != null) {
            getJSEngine().u(this.f71125f, new Object[]{Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17)}, null);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void commit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f71123d;
    }

    public boolean isInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onGestureResult(int i3, View view, boolean z16, float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), view, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        } else if (this.f71124e != null) {
            getJSEngine().u(this.f71124e, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z16), Float.valueOf(this.f71126h), Float.valueOf(this.f71127i), Float.valueOf(this.f71128m), Float.valueOf(this.C)}, null);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onGestureStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view, (Object) motionEvent);
            return;
        }
        if (motionEvent != null) {
            if (motionEvent.getAction() == 0) {
                this.f71126h = MosaicUtils.E(view.getLeft() + motionEvent.getX());
                float E = MosaicUtils.E(view.getTop() + motionEvent.getY());
                this.f71127i = E;
                j(0, this.f71126h, E);
                return;
            }
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                if (motionEvent.getAction() == 2) {
                    j(2, MosaicUtils.E(view.getLeft() + motionEvent.getX()), MosaicUtils.E(view.getTop() + motionEvent.getY()));
                }
            } else {
                this.f71128m = MosaicUtils.E(view.getLeft() + motionEvent.getX());
                float E2 = MosaicUtils.E(view.getTop() + motionEvent.getY());
                this.C = E2;
                j(1, this.f71128m, E2);
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureClickHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.f71123d.setGestureClickHotArea((int) MosaicUtils.j(i3), (int) MosaicUtils.j(i16), (int) MosaicUtils.j(i17), (int) MosaicUtils.j(i18));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f71123d.setGestureColor(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureSlideHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.f71123d.setGestureSlideHotArea((int) MosaicUtils.j(i3), (int) MosaicUtils.j(i16), (int) MosaicUtils.j(i17), (int) MosaicUtils.j(i18));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureSlideValidHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f71123d.setGestureSlideValidHeightDp(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f71123d.setGestureStrokeWidthDp(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.f71123d.setGestureVisible(z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setSlideGestureListener(JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jSFunction, (Object) jSFunction2);
        } else {
            this.f71124e = jSFunction;
            this.f71125f = jSFunction2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "GestureComponentImpl";
    }
}
