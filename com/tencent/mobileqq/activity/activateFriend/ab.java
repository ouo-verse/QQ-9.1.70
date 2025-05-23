package com.tencent.mobileqq.activity.activateFriend;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ab extends ReportDialog {
    static IPatchRedirector $redirector_;
    Animatable C;
    Context D;

    public ab(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.C = null;
        this.D = null;
        init(context);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.dismiss();
        Animatable animatable = this.C;
        if (animatable != null) {
            animatable.stop();
        }
    }

    protected void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        super.requestWindowFeature(1);
        this.D = context;
        setContentView(LayoutInflater.from(context).inflate(R.layout.cak, (ViewGroup) null));
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                window.addFlags(67108864);
            }
        }
        setCanceledOnTouchOutside(false);
        ImageView imageView = (ImageView) super.findViewById(R.id.gez);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, -1.0f, 2, 1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(800L);
        translateAnimation.setRepeatCount(-1);
        imageView.startAnimation(translateAnimation);
        super.setCancelable(false);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            try {
                dismiss();
                Context context = this.D;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                    return false;
                }
                return false;
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        Context context = this.D;
        if (context != null) {
            Animatable animatable = (Animatable) context.getResources().getDrawable(R.drawable.common_loading6);
            this.C = animatable;
            if (animatable != null) {
                animatable.start();
            }
        }
    }
}
