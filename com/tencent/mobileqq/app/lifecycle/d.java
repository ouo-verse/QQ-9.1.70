package com.tencent.mobileqq.app.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d extends DefaultBaseActivityLifecycleCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private MiniMsgUser f195827d;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityDestroyed(Activity activity) {
        MiniMsgUser miniMsgUser;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else if ((activity instanceof QBaseActivity) && ((QBaseActivity) activity).isNeedMiniMsg() && (miniMsgUser = this.f195827d) != null) {
            miniMsgUser.destroy();
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPause(Activity activity) {
        MiniMsgUser miniMsgUser;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else if ((activity instanceof QBaseActivity) && ((QBaseActivity) activity).isNeedMiniMsg() && (miniMsgUser = this.f195827d) != null) {
            miniMsgUser.onBackground();
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPreCreated(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
        } else if ((activity instanceof QBaseActivity) && ((QBaseActivity) activity).isNeedMiniMsg()) {
            this.f195827d = new MiniMsgUser(activity, e());
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityResume(Activity activity) {
        MiniMsgUser miniMsgUser;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else if ((activity instanceof QBaseActivity) && ((QBaseActivity) activity).isNeedMiniMsg() && (miniMsgUser = this.f195827d) != null) {
            miniMsgUser.onForeground();
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnWindowFocusChanged(Activity activity, boolean z16) {
        MiniMsgUser miniMsgUser;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, activity, Boolean.valueOf(z16));
            return;
        }
        if (activity instanceof QBaseActivity) {
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            if (z16 && !qBaseActivity.isShowOnFirst()) {
                if (qBaseActivity.isNeedMiniMsg() && (miniMsgUser = this.f195827d) != null) {
                    miniMsgUser.showOnFirst();
                }
                qBaseActivity.setShowOnFirst(true);
            }
        }
    }

    protected MiniMsgUserParam e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MiniMsgUserParam) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = 0;
        miniMsgUserParam.accessType = 0;
        miniMsgUserParam.entryType = 0;
        miniMsgUserParam.positionX = -1;
        miniMsgUserParam.positionY = -1;
        miniMsgUserParam.colorType = 0;
        miniMsgUserParam.filterMsgType = 0;
        return miniMsgUserParam;
    }
}
