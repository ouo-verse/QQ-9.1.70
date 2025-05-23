package com.tencent.ams.mosaic.jsengine.component.lottie;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LottieComponentImpl extends BasicComponent implements LottieComponent, Animator.AnimatorListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final LottieAnimationView f71240d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71241e;

    /* renamed from: f, reason: collision with root package name */
    private JSFunction f71242f;

    public LottieComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.f71240d = lottieAnimationView;
        try {
            lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
            lottieAnimationView.addAnimatorListener(this);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        try {
            this.f71240d.playAnimation();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        try {
            this.f71240d.cancelAnimation();
        } catch (Exception unused) {
        }
    }

    private boolean s(String str) {
        try {
            LottieAnimationView.class.getMethod("setAnimation", String.class).invoke(this.f71240d, str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean t(String str) {
        try {
            LottieAnimationView.class.getMethod("setAnimation", JSONObject.class).invoke(this.f71240d, new JSONObject(str));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean u(String str) {
        try {
            LottieAnimationView.class.getMethod("setAnimationFromJson", String.class).invoke(this.f71240d, str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean v(String str) {
        try {
            LottieAnimationView.class.getMethod("setAnimationFromUrl", String.class).invoke(this.f71240d, str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f71240d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.lottie.LottieComponent
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        try {
            return this.f71240d.isAnimating();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void onAddedToParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onAddedToParent();
        if (this.f71241e) {
            start();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) animator);
        } else {
            f.e("LottieComponentImpl", "onAnimationCancel");
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) animator);
            return;
        }
        f.e("LottieComponentImpl", "onAnimationEnd");
        if (this.f71242f != null) {
            getJSEngine().u(this.f71242f, null, null);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) animator);
        } else {
            f.e("LottieComponentImpl", "onAnimationRepeat");
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) animator);
        } else {
            f.e("LottieComponentImpl", "onAnimationStart");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.lottie.LottieComponent
    public void setAnimationCallback(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) jSFunction);
        } else {
            f.e("LottieComponentImpl", "setAnimationCallback");
            this.f71242f = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.lottie.LottieComponent
    public void setAutoPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        f.e("LottieComponentImpl", "setAutoPlay: " + z16);
        this.f71241e = z16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.lottie.LottieComponent
    public void setJsonString(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        f.e("LottieComponentImpl", "setJsonString");
        if (TextUtils.isEmpty(str)) {
            f.h("LottieComponentImpl", "setJsonString failed: empty json");
        } else if (t(str)) {
            f.e("LottieComponentImpl", "setJsonString by json object");
        } else if (u(str)) {
            f.e("LottieComponentImpl", "setJsonString by json string");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.lottie.LottieComponent
    public void setRepeatCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        f.e("LottieComponentImpl", "setRepeatCount: " + i3);
        try {
            this.f71240d.setRepeatCount(i3);
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.lottie.LottieComponent
    public void setSrc(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        f.e("LottieComponentImpl", "setSrc: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            if (str.startsWith("resource://")) {
                String replace = str.replace("resource://", "");
                if (s(replace)) {
                    f.e("LottieComponentImpl", "setSrc from assets: " + replace);
                    return;
                }
                return;
            }
            return;
        }
        if (v(str)) {
            f.e("LottieComponentImpl", "setSrc from url: " + str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.lottie.LottieComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            f.e("LottieComponentImpl", "start");
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.lottie.b
                @Override // java.lang.Runnable
                public final void run() {
                    LottieComponentImpl.this.q();
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.lottie.LottieComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            f.e("LottieComponentImpl", "stop");
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.lottie.a
                @Override // java.lang.Runnable
                public final void run() {
                    LottieComponentImpl.this.r();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "LottieComponentImpl";
    }
}
