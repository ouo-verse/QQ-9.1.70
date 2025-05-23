package com.tencent.mobileqq.activity.recent.guidebanner.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BeginnerGuideBannerProcessor;
import com.tencent.mobileqq.activity.recent.guidebanner.INewerGuideHelper;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerHandler;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel;
import com.tencent.mobileqq.activity.recent.guidebanner.b;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NewerGuideHelperImpl implements INewerGuideHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "NewerGuideManagerHelper";

    public NewerGuideHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.guidebanner.INewerGuideHelper
    public int getBannerId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return BeginnerGuideBannerProcessor.f185201d;
    }

    @Override // com.tencent.mobileqq.activity.recent.guidebanner.INewerGuideHelper
    public NewerGuideBannerHandler getNewerGuideHandler(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (NewerGuideBannerHandler) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface);
        }
        return (NewerGuideBannerHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.NEWER_GUIDE_BANNER_HANDLER);
    }

    @Override // com.tencent.mobileqq.activity.recent.guidebanner.INewerGuideHelper
    public b getNewerGuideManager(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        }
        return (b) appRuntime.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER);
    }

    @Override // com.tencent.mobileqq.activity.recent.guidebanner.INewerGuideHelper
    public void hideNewerGuideBanner(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
        } else if (appRuntime != null) {
            BannerManager.l().D(BeginnerGuideBannerProcessor.f185201d, 3000);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.guidebanner.INewerGuideHelper
    public <T> boolean isMayKnowRecentBaseData(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) t16)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.recent.guidebanner.INewerGuideHelper
    public void notifyClickCloseBanner(NewerGuideBannerViewModel newerGuideBannerViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) newerGuideBannerViewModel);
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            newerGuideBannerViewModel.b2(runtime);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.guidebanner.INewerGuideHelper
    public void showNewerGuideBanner(AppInterface appInterface, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInterface, obj);
            return;
        }
        MqqHandler handlerWithoutDefault = appInterface.getHandlerWithoutDefault(Conversation.class);
        if (handlerWithoutDefault != null) {
            Message obtain = Message.obtain();
            obtain.what = Conversation.MSG_SHOW_NEWER_GUIDE_BANNER;
            obtain.obj = obj;
            handlerWithoutDefault.sendMessage(obtain);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showNewerGuideBanner get handler fail null");
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.guidebanner.INewerGuideHelper
    public void startBrowser(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, str2);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("source_from", str2);
        context.startActivity(intent);
    }
}
