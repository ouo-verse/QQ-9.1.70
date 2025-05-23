package com.tencent.mobileqq.auto.engine.main.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.main.IASFragment;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements IASFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final b f199890d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f199890d = new b();
        }
    }

    private void a() {
        if (this.f199890d.g() != null) {
            this.f199890d.g();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ASEnterBean d16 = this.f199890d.d();
        if (d16 == null) {
            QLog.d("ASNewPluginFragment", 1, "loadViewFromLocalActivityManger enterBean is empty" + this.f199890d.hashCode());
            return;
        }
        this.f199890d.r(((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).getNativeFolderIntent(d16.getSchemeAction(), d16.getAttrs(), d16.getByteAttrs()));
        this.f199890d.p(1);
        this.f199890d.p(2);
        this.f199890d.p(3);
        QLog.d("ASNewPluginFragment", 1, "getViewFromLocalActivityManger cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public View getTargetDecorView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f199890d.g();
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public boolean isAdded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        View g16 = this.f199890d.g();
        if (g16 != null && g16.getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public boolean isRealFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        this.f199890d.a(i3, i16, intent);
        QLog.d("ASNewPluginFragment", 1, "onActivityResult " + i3 + " " + i16);
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, layoutInflater, viewGroup, bundle);
        }
        return this.f199890d.g();
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.f199890d.p(4);
            QLog.d("ASNewPluginFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onNewIntent(@NonNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bundle);
            return;
        }
        this.f199890d.n(bundle);
        ASEnterBean d16 = this.f199890d.d();
        if (d16 == null) {
            return;
        }
        this.f199890d.b(((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).getNativeFolderIntent(d16.getSchemeAction(), d16.getAttrs(), d16.getByteAttrs()));
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f199890d.p(2);
            QLog.d("ASNewPluginFragment", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f199890d.i()) {
            this.f199890d.p(1);
            QLog.d("ASNewPluginFragment", 1, "onResume");
        }
        com.tencent.mobileqq.auto.engine.main.c.a(this.f199890d.e());
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f199890d.p(3);
            QLog.d("ASNewPluginFragment", 1, DKHippyEvent.EVENT_STOP);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setArguments(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            this.f199890d.m(bundle);
            a();
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setHostActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            this.f199890d.o(activity);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setIsSelected(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.f199890d.q(z16);
        }
    }
}
