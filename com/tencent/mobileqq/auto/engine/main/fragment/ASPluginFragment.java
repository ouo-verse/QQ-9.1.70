package com.tencent.mobileqq.auto.engine.main.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.enter.ASEngineEnter;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.main.IASFragment;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qcircle.api.interfaces.QCircleHookPluginIntentCallBack;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;

/* loaded from: classes11.dex */
public class ASPluginFragment extends ReportAndroidXFragment implements IASFragment {
    static IPatchRedirector $redirector_;
    private Handler C;
    private FrameLayout D;
    private final b E;
    private View F;

    public ASPluginFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.E = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh() {
        if (this.E.g() != null) {
            QLog.d("ASPluginFragment", 1, "getPluginIntent : mFSTabView not null ");
        } else if (this.E.f() == null) {
            QLog.d("ASPluginFragment", 1, "start LocalActivityManager failed no init data ");
        } else {
            HostUIHelper.getInstance().setPluginIntentHook(new QCircleHookPluginIntentCallBack() { // from class: com.tencent.mobileqq.auto.engine.main.fragment.ASPluginFragment.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ASPluginFragment.this);
                    }
                }

                @Override // com.tencent.mobileqq.qcircle.api.interfaces.QCircleHookPluginIntentCallBack
                public void getPluginIntent(Intent intent) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
                    } else {
                        ASPluginFragment.this.getMainHandler().post(new Runnable(intent) { // from class: com.tencent.mobileqq.auto.engine.main.fragment.ASPluginFragment.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Intent f199888d;

                            {
                                this.f199888d = intent;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) intent);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                View r16 = ASPluginFragment.this.E.r(this.f199888d);
                                QLog.d("ASPluginFragment", 1, "getPluginIntent : mFSTabView = " + r16);
                                if (ASPluginFragment.this.D != null && r16 != null) {
                                    QLog.d("ASPluginFragment", 1, "add mFSTabView : " + r16);
                                    ASPluginFragment.this.D.addView(r16, new FrameLayout.LayoutParams(-1, -1));
                                    ASPluginFragment.this.E.p(1);
                                }
                            }
                        });
                    }
                }
            });
            ASEngineEnter.b(this.E.d());
        }
    }

    public Handler getMainHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Handler) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.C == null) {
            this.C = new Handler(Looper.getMainLooper());
        }
        return this.C;
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public View getTargetDecorView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.E.g() != null) {
            return this.E.g();
        }
        return this.D;
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public boolean isRealFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
            this.E.a(i3, i16, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            view = (View) iPatchRedirector.redirect((short) 6, this, layoutInflater, viewGroup, bundle);
        } else {
            View inflate = layoutInflater.inflate(R.layout.dzh, viewGroup, false);
            this.F = inflate;
            this.D = (FrameLayout) inflate.findViewById(R.id.t06);
            view = this.F;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.onDestroy();
            this.E.p(4);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onNewIntent(@NonNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle);
            return;
        }
        this.E.n(bundle);
        ASEnterBean d16 = this.E.d();
        if (d16 == null) {
            return;
        }
        this.E.b(((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).getNativeFolderIntent(d16.getSchemeAction(), d16.getAttrs(), d16.getByteAttrs()));
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onPause();
            this.E.p(2);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onResume();
        if (this.F == null || !this.E.i()) {
            return;
        }
        this.F.post(new Runnable() { // from class: com.tencent.mobileqq.auto.engine.main.fragment.ASPluginFragment.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ASPluginFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ASPluginFragment.this.sh();
                    ASPluginFragment.this.E.p(1);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onStop();
            this.E.p(3);
        }
    }

    @Override // androidx.fragment.app.Fragment, com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setArguments(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            super.setArguments(bundle);
            this.E.m(bundle);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setHostActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            this.E.o(activity);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setIsSelected(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.E.q(z16);
        }
    }
}
