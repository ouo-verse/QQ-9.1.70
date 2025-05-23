package com.tencent.ams.mosaic.jsengine.component.slide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener;
import com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveView;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import com.tencent.ams.mosaic.jsengine.component.FeatureComponent;
import com.tencent.ams.mosaic.jsengine.e;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SlideComponentImpl extends FeatureComponent implements SlideComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final SlideInteractiveView f71270d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71271e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f71272f;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements f.c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f71273a;

        a(String str) {
            this.f71273a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SlideComponentImpl.this, (Object) str);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("SlideComponentImpl", "onLoadFinish: " + this.f71273a + ", object: " + obj);
            if (obj instanceof Bitmap) {
                SlideComponentImpl.this.m((Bitmap) obj);
            } else {
                if (obj instanceof Drawable) {
                    Drawable drawable = (Drawable) obj;
                    SlideComponentImpl.this.m(MosaicUtils.k(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()));
                    return;
                }
                com.tencent.ams.mosaic.utils.f.h("SlideComponentImpl", "onLoadFinish: icon bitmap load failed");
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("SlideComponentImpl", "onLoadStart: " + this.f71273a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements SlideInteractiveListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSFunction f71275a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSFunction f71276b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSFunction f71277c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSFunction f71278d;

        b(JSFunction jSFunction, JSFunction jSFunction2, JSFunction jSFunction3, JSFunction jSFunction4) {
            this.f71275a = jSFunction;
            this.f71276b = jSFunction2;
            this.f71277c = jSFunction3;
            this.f71278d = jSFunction4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SlideComponentImpl.this, jSFunction, jSFunction2, jSFunction3, jSFunction4);
            }
        }

        @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener
        public void onEndAnimationFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "onAnimatorFinish");
            if (this.f71277c != null) {
                SlideComponentImpl.this.getJSEngine().u(this.f71277c, new Object[0], null);
            }
        }

        @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener
        public void onGestureResult(boolean z16, View view, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), view, Float.valueOf(f16), Float.valueOf(f17));
                return;
            }
            com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "onGestureResult :" + z16 + " xOffset:" + f16 + " yOffset:" + f17);
            if (z16 && SlideComponentImpl.this.f71272f) {
                MosaicUtils.a0(((ComponentBase) SlideComponentImpl.this).mContext, 200);
            }
            if (this.f71276b != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", Boolean.valueOf(z16));
                hashMap.put("xOffset", Float.valueOf(f16));
                hashMap.put("yOffset", Float.valueOf(f17));
                SlideComponentImpl.this.getJSEngine().u(this.f71276b, new Object[]{hashMap}, null);
            }
        }

        @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener
        public void onGestureStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (this.f71275a != null) {
                SlideComponentImpl.this.getJSEngine().u(this.f71275a, null, null);
            }
        }

        @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener
        public void onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) motionEvent);
            } else if (motionEvent != null) {
                SlideComponentImpl.this.getJSEngine().u(this.f71278d, new Object[]{Integer.valueOf(motionEvent.getAction()), Float.valueOf(MosaicUtils.E(view.getLeft() + motionEvent.getX())), Float.valueOf(MosaicUtils.E(view.getTop() + motionEvent.getY()))}, null);
            }
        }
    }

    public SlideComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f71270d = new SlideInteractiveView(context);
        setTitle("\u5411\u4e0a\u6ed1\u52a8");
        setSubTitle("\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528");
        setGestureSlideValidHeight(110);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Bitmap bitmap) {
        com.tencent.ams.mosaic.utils.f.a("SlideComponentImpl", "setIconBitmap");
        if (bitmap != null) {
            this.f71270d.setSlideIconBitmap(bitmap, true);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f71270d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onActivityDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        this.f71270d.stop();
        super.onActivityDestroyed();
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "onActivityDestroyed");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        super.onSwitchBackground();
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_BACKGROUND);
        this.f71270d.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        super.onSwitchForeground();
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_FOREGROUND);
        this.f71270d.resume();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slide.SlideComponent
    public void setBottomPadding(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "setBottomPadding: " + f16);
        this.f71270d.setBottomPaddingDp(f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureClickHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "setGestureColor: " + str);
        this.f71270d.setGestureColor(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureSlideHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "setGestureSlideHotArea leftMargin: " + i3 + " rightMargin:" + i16 + " bottomMargin:" + i17 + " height:" + i18);
        this.f71270d.setGestureHotArea((int) MosaicUtils.j((float) i3), (int) MosaicUtils.j((float) i16), (int) MosaicUtils.j((float) i17), (int) MosaicUtils.j((float) i18));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureSlideValidHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "setGestureSlideValidHeight: " + i3);
        this.f71270d.setGestureSlideValidHeightDp(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "setGestureStrokeWidth: " + i3);
        this.f71270d.setGestureStrokeWidthDp(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "setGestureVisible: " + z16);
        this.f71270d.setGestureVisible(z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slide.SlideComponent
    public void setIconUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str)) {
            getImageLoader().loadImage(str, new a(str));
        } else {
            com.tencent.ams.mosaic.utils.f.h("SlideComponentImpl", "loadIconBitmap failed: no data or src");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slide.SlideComponent
    public void setInteractListeners(JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) jSObject);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "setInteractListeners :" + jSObject);
        Map<String, Object> f16 = e.f(getJSEngine().l(), jSObject);
        if (f16 == null) {
            com.tencent.ams.mosaic.utils.f.h("SlideComponentImpl", "setInteractListeners failed: invalid listenerDict");
            return;
        }
        this.f71270d.setSlideInteractiveListener(new b(e.c(f16.get("onGestureStart")), e.c(f16.get("onGestureResult")), e.c(f16.get("onEndAnimatorFinish")), e.c(f16.get("onTouch"))));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setSlideGestureListener(JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) jSFunction, (Object) jSFunction2);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slide.SlideComponent
    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "setSubTitle: " + str);
        this.f71270d.setSubTitle(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slide.SlideComponent
    public void setSuccessVibrate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.f71272f = z16;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slide.SlideComponent
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "setTitle: " + str);
        this.f71270d.setTitle(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slide.SlideComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "start: " + this.f71271e);
        this.f71270d.start();
        this.f71271e = true;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slide.SlideComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlideComponentImpl", "stop: " + this.f71271e);
        this.f71270d.stop();
        this.f71271e = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "SlideComponentImpl";
    }
}
