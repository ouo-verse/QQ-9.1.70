package com.tencent.common.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;

/* compiled from: P */
/* loaded from: classes5.dex */
public class InnerFrame extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Activity f99516d;

    /* renamed from: e, reason: collision with root package name */
    private InnerFrameManager f99517e;

    /* renamed from: f, reason: collision with root package name */
    private BaseQQAppInterface f99518f;

    public InnerFrame(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f99516d = null;
        this.f99517e = null;
        this.f99518f = null;
    }

    public Activity e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Activity) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f99516d;
    }

    public BaseQQAppInterface f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (BaseQQAppInterface) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f99518f;
    }

    public InnerFrameManager g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (InnerFrameManager) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f99517e;
    }

    protected void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    public void i(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    public void j(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bundle);
        } else if (QLog.isColorLevel()) {
            QLog.d("InnerFrame", 2, "onCreate");
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d("InnerFrame", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d("InnerFrame", 2, "onResume");
        }
    }

    public void m(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle);
        } else if (QLog.isColorLevel()) {
            QLog.d("InnerFrame", 2, "onStart");
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d("InnerFrame", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d("InnerFrame", 2, DKHippyEvent.EVENT_STOP);
        }
    }

    public void setActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("InnerFrame", 2, "setActivity");
        }
        this.f99516d = activity;
    }

    public void setAppIntf(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("InnerFrame", 2, "setAppIntf");
        }
        this.f99518f = baseQQAppInterface;
        h();
    }

    public void setContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            setContentView(LayoutInflater.from(this.f99516d).inflate(i3, (ViewGroup) this, false));
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
    }

    public void setInnerFrameManager(InnerFrameManager innerFrameManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) innerFrameManager);
        } else {
            this.f99517e = innerFrameManager;
        }
    }

    public void setContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
            return;
        }
        if (getChildCount() > 0) {
            removeAllViews();
        }
        addView(view);
    }

    public InnerFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f99516d = null;
        this.f99517e = null;
        this.f99518f = null;
    }

    public InnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f99516d = null;
        this.f99517e = null;
        this.f99518f = null;
    }
}
