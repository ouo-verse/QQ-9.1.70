package com.tencent.mobileqq.profilecard.service.impl;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.observer.ProfileCardBlacklistObserver;
import com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.relation.common.nt.api.IRelationMsgService;
import com.tencent.relation.common.nt.data.a;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class ProfileCardBlacklistServiceImpl implements IProfileCardBlacklistService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileCardBlacklistServiceImpl";
    private View mElementView;
    private LinearLayout mPageView;
    private ProfileCardBlacklistObserver mProfileCardBlacklistObserver;

    public ProfileCardBlacklistServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mProfileCardBlacklistObserver = null;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService
    public void deleteBlacklistUinMessage(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            ((IRelationMsgService) QRoute.api(IRelationMsgService.class)).deleteRecentContacts(new a(str, 0, ""), new IOperateCallback() { // from class: com.tencent.mobileqq.profilecard.service.impl.ProfileCardBlacklistServiceImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardBlacklistServiceImpl.this);
                    }
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public void onResult(int i3, String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) str2);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(ProfileCardBlacklistServiceImpl.TAG, 2, "deleteBlacklistUinMessage deleteRecentContacts! result " + i3 + " errMsg " + str2);
                    }
                }
            });
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mPageView = new LinearLayout(appRuntime.getApp());
        View view = new View(appRuntime.getApp());
        this.mElementView = view;
        this.mPageView.addView(view);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService
    public void refreshRecentList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.service.impl.ProfileCardBlacklistServiceImpl.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardBlacklistServiceImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    synchronized (this) {
                        if (ProfileCardBlacklistServiceImpl.this.mProfileCardBlacklistObserver == null) {
                            QLog.d(ProfileCardBlacklistServiceImpl.TAG, 1, "mProfileCardBlacklistObserver null");
                        } else {
                            ProfileCardBlacklistServiceImpl.this.mProfileCardBlacklistObserver.onRefreshRecentListFull();
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService
    public void reportItemEvent(String str, String str2, String str3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, str3, hashMap, hashMap2);
            return;
        }
        VideoReport.setPageId(this.mPageView, str2);
        VideoReport.setPageParams(this.mPageView, PageParams.builder().setBasicParams(hashMap).build());
        VideoReport.setElementId(this.mElementView, str3);
        VideoReport.reportEvent(str, this.mElementView, hashMap2);
    }

    @Override // com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService
    public void reportPageEvent(String str, String str2, String str3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3, hashMap, hashMap2);
            return;
        }
        VideoReport.setPageId(this.mPageView, str2);
        VideoReport.setPageParams(this.mPageView, PageParams.builder().setBasicParams(hashMap).build());
        VideoReport.setElementId(this.mElementView, str3);
        VideoReport.reportEvent(str, this.mPageView, hashMap);
    }

    @Override // com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService
    public void setProfileCardBlacklistObserver(ProfileCardBlacklistObserver profileCardBlacklistObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) profileCardBlacklistObserver);
        } else {
            this.mProfileCardBlacklistObserver = profileCardBlacklistObserver;
        }
    }
}
