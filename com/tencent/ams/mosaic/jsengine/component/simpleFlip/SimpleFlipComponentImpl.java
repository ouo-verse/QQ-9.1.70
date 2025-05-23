package com.tencent.ams.mosaic.jsengine.component.simpleFlip;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.flip.FlipView;
import com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import com.tencent.ams.mosaic.jsengine.component.FeatureComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SimpleFlipComponentImpl extends FeatureComponent implements SimpleFlipComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final FlipView f71264d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71265e;

    /* renamed from: f, reason: collision with root package name */
    private JSFunction f71266f;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements IFlipInteractiveListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        float f71267a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSFunction f71268b;

        a(JSFunction jSFunction) {
            this.f71268b = jSFunction;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SimpleFlipComponentImpl.this, (Object) jSFunction);
            }
        }

        @Override // com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener
        public void onBackInteractProgress(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
                return;
            }
            this.f71267a = f16;
            f.a("SimpleFlipComponentImpl", "onBackInteractProgress angle: " + f16);
        }

        @Override // com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener
        public void onInteractProgress(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
                return;
            }
            this.f71267a = f16;
            f.a("SimpleFlipComponentImpl", "onInteractProgress angle: " + f16);
            SimpleFlipComponentImpl.this.getJSEngine().u(this.f71268b, new Object[]{2, Float.valueOf(f16)}, null);
        }

        @Override // com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener
        public void onInteractResult(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            f.a("SimpleFlipComponentImpl", "onInteractResult mode: " + i3 + ", isSuccess: " + z16);
            if (!z16) {
                return;
            }
            if (i3 == 1 && SimpleFlipComponentImpl.this.f71266f != null) {
                SimpleFlipComponentImpl.this.getJSEngine().u(SimpleFlipComponentImpl.this.f71266f, new Object[]{0, 0}, null);
                return;
            }
            if (SimpleFlipComponentImpl.this.f71265e) {
                MosaicUtils.a0(((ComponentBase) SimpleFlipComponentImpl.this).mContext, 200);
            }
            SimpleFlipComponentImpl.this.getJSEngine().u(this.f71268b, new Object[]{3, Float.valueOf(this.f71267a)}, null);
        }

        @Override // com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener
        public void onInteractStart(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            f.a("SimpleFlipComponentImpl", "onInteractStart mode: " + i3);
            SimpleFlipComponentImpl.this.getJSEngine().u(this.f71268b, new Object[]{1, 0}, null);
        }
    }

    public SimpleFlipComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f71264d = new FlipView(context);
        setTitle("\u7ffb\u8f6c\u624b\u673a");
        setSubTitle("\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528");
        setFlipAngle(45);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f71264d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onActivityDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        this.f71264d.stop();
        super.onActivityDestroyed();
        f.a("SimpleFlipComponentImpl", "onActivityDestroyed");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.onSwitchBackground();
        f.a("SimpleFlipComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_BACKGROUND);
        this.f71264d.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.onSwitchForeground();
        f.a("SimpleFlipComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_FOREGROUND);
        this.f71264d.resume();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.simpleFlip.SimpleFlipComponent
    public void setBottomPadding(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            return;
        }
        f.a("SimpleFlipComponentImpl", "setBottomPadding: " + f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.simpleFlip.SimpleFlipComponent
    public void setFlipAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        f.a("SimpleFlipComponentImpl", "setFlipAngle: " + i3);
        this.f71264d.setTargetRotationThreshold((float) i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.simpleFlip.SimpleFlipComponent
    public void setGestureClickHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        f.a("SimpleFlipComponentImpl", "setGestureClickHotArea: " + i3 + ", " + i16 + ", " + i17 + ", " + i18);
        this.f71264d.setClickHotArea(1, (float) i3, (float) i16, (float) i17, (float) i18);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.simpleFlip.SimpleFlipComponent
    public void setHotAreaClickListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) jSFunction);
        } else {
            f.a("SimpleFlipComponentImpl", "setHotAreaClickListener");
            this.f71266f = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.simpleFlip.SimpleFlipComponent
    public void setInteractListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) jSFunction);
            return;
        }
        f.a("SimpleFlipComponentImpl", "setInteractListener");
        if (jSFunction == null) {
            return;
        }
        this.f71264d.setInteractiveListener(new a(jSFunction));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.simpleFlip.SimpleFlipComponent
    public void setReverseAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        f.e("SimpleFlipComponentImpl", "setReverseAngle, reverseAngle: " + i3);
        FlipView flipView = this.f71264d;
        if (flipView != null) {
            flipView.setReverseRotationThreshold(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.simpleFlip.SimpleFlipComponent
    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        f.a("SimpleFlipComponentImpl", "setSubTitle: " + str);
        this.f71264d.setSubTitleText(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.simpleFlip.SimpleFlipComponent
    public void setSuccessVibrate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.f71265e = z16;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.simpleFlip.SimpleFlipComponent
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        f.a("SimpleFlipComponentImpl", "setTitle: " + str);
        this.f71264d.setTitleText(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.simpleFlip.SimpleFlipComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            f.a("SimpleFlipComponentImpl", "start");
            this.f71264d.start();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.simpleFlip.SimpleFlipComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            f.a("SimpleFlipComponentImpl", "stop");
            this.f71264d.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "SimpleFlipComponentImpl";
    }
}
