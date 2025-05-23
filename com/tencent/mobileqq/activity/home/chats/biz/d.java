package com.tencent.mobileqq.activity.home.chats.biz;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.bm;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.ui.ConversationContainer;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class d extends com.tencent.qqnt.chats.biz.main.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private AppRuntime f182914f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f182915h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f182916i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.activity.home.chats.callbcak.a f182917m;

    public d(com.tencent.mobileqq.activity.home.chats.callbcak.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f182915h = false;
            this.f182917m = aVar;
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void A9(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.f182914f = appRuntime;
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void R9(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        }
    }

    public AppRuntime X9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f182914f;
    }

    public BannerManager Y9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (BannerManager) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f182917m.getBannerManager();
    }

    public Conversation Z9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Conversation) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f182917m.e();
    }

    public bm aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (bm) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f182917m.f();
    }

    public FrameHelperActivity ba() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (FrameHelperActivity) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f182917m.b();
    }

    public MqqHandler ca() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (MqqHandler) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f182917m.d();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: da, reason: merged with bridge method [inline-methods] */
    public ConversationContainer getPartRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ConversationContainer) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.f182917m.getRootView();
    }

    public abstract String ea();

    public boolean ga() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.f182917m.a();
    }

    public boolean ha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f182915h;
    }

    public boolean ia() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.f182917m.h();
    }

    public boolean ja() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.f182917m.g();
    }

    public boolean la() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f182916i;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NonNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            this.f182915h = true;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            this.f182916i = false;
            super.onPartPause(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
            this.f182916i = true;
        }
    }

    public void runOnUiThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) runnable);
            return;
        }
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else {
            QLog.i(ea(), 1, "runOnUiThread but activity == null");
        }
    }
}
