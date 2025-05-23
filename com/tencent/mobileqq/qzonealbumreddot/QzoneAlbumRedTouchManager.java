package com.tencent.mobileqq.qzonealbumreddot;

import NS_MOBILE_PHOTO.operation_red_touch_req;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import mqq.app.NewIntent;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QzoneAlbumRedTouchManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f279327d;

    public QzoneAlbumRedTouchManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f279327d = qQAppInterface;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences d() {
        String str;
        QQAppInterface qQAppInterface = this.f279327d;
        if (qQAppInterface != null && qQAppInterface.getCurrentAccountUin() != null) {
            str = this.f279327d.getCurrentAccountUin();
        } else {
            str = "";
        }
        return BaseApplication.getContext().getSharedPreferences(str + "_QZoneAlbumRedTouch", 0);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (this.f279327d == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QzoneAlbumRedTouchManager", 2, "clearRedTouch");
            }
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QzoneAlbumRedTouchManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QQAppInterface qQAppInterface = QzoneAlbumRedTouchManager.this.f279327d;
                    if (qQAppInterface == null) {
                        return;
                    }
                    IRedTouchManager iRedTouchManager = (IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "");
                    String valueOf = String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_MY_PHOTO);
                    BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(valueOf);
                    if (appInfoByPath != null && appInfoByPath.iNewFlag.get() == 1) {
                        iRedTouchManager.dismissRedTouch(valueOf);
                        LocalMultiProcConfig.putBool(QZoneHelper.QzoneSharePrefrenceConstants.KEY_PHOTO_GUIDE_IS_RED, false);
                        QZoneClickReport.startReportImediately(QzoneAlbumRedTouchManager.this.f279327d.getCurrentAccountUin(), "443", "2");
                    } else {
                        NewIntent newIntent = new NewIntent(QzoneAlbumRedTouchManager.this.f279327d.getApplication(), b.class);
                        newIntent.putExtra("req", new operation_red_touch_req(2L));
                        QzoneAlbumRedTouchManager.this.f279327d.startServlet(newIntent);
                    }
                }
            });
        }
    }

    @TargetApi(9)
    public void e(BusinessInfoCheckUpdate.AppInfo appInfo) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInfo);
        } else if (appInfo != null && appInfo.iNewFlag.get() != 0 && (qQAppInterface = this.f279327d) != null) {
            QZoneClickReport.startReportImediately(qQAppInterface.getCurrentAccountUin(), "443", "1");
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QzoneAlbumRedTouchManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QzoneAlbumRedTouchManager.this.d().edit().putLong(QZoneHelper.QzoneSharePrefrenceConstants.KEY_PHOTO_GUIDE_HAS_RED_DATE, System.currentTimeMillis()).apply();
                    }
                }
            });
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f279327d = null;
        }
    }
}
