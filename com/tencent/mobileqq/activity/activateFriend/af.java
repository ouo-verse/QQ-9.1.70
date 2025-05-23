package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.activateFriend.biz.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class af {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements c.a, EIPCResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<c.a> f177958d;

        a(WeakReference<c.a> weakReference) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
            } else {
                this.f177958d = weakReference;
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle bundle;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) eIPCResult);
                return;
            }
            if (eIPCResult != null && eIPCResult.code == 0) {
                bundle = eIPCResult.data;
            } else {
                bundle = null;
            }
            if (bundle != null) {
                z16 = bundle.getBoolean("allowed");
            } else {
                z16 = false;
            }
            onResult(z16);
        }

        @Override // com.tencent.mobileqq.activity.activateFriend.biz.c.a
        public void onResult(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            c.a aVar = this.f177958d.get();
            if (aVar != null) {
                aVar.onResult(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AcsMsg acsMsg) {
        if (d(acsMsg) && QLog.isColorLevel()) {
            QLog.d("[QQNotify]QQReminderAMSHelper", 1, "call AMS report");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(WeakReference<Activity> weakReference, AcsMsg acsMsg, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("[QQNotify]QQReminderAMSHelper", 1, "QQNotify AMS notify click");
        }
    }

    public static boolean c() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d("[QQNotify]QQReminderAMSHelper", 1, "changeQQReminderSwitch: QQAppInterface is null");
                return false;
            }
            return false;
        }
        return ((ActivateFriendsManager) runtime.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).t(true);
    }

    public static boolean d(AcsMsg acsMsg) {
        if (acsMsg != null && "bf15cdd9f2aa2b578f3af4c3e433f077".equals(acsMsg.busi_id)) {
            return true;
        }
        return false;
    }

    public static void e(WeakReference<c.a> weakReference) {
        c.a aVar;
        if (MobileQQ.sProcessId == 1) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (!(runtime instanceof QQAppInterface)) {
                if (QLog.isColorLevel()) {
                    QLog.d("[QQNotify]QQReminderAMSHelper", 1, "changeQQReminderSwitch: QQAppInterface is null");
                    return;
                }
                return;
            } else {
                if (c() && (aVar = weakReference.get()) != null) {
                    aVar.onResult(true);
                    return;
                }
                ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) runtime.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
                activateFriendsManager.k(weakReference);
                activateFriendsManager.L(true, true);
                return;
            }
        }
        QIPCClientHelper.getInstance().callServer("QQNotifyIPCModule", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, null, new a(weakReference));
    }

    private static AcsMsg f(Bundle bundle) {
        AcsMsg acsMsg = new AcsMsg();
        acsMsg.busi_id = bundle.getString("busi_id");
        acsMsg.msg_id = bundle.getString("msg_id");
        acsMsg.content = bundle.getString("content");
        acsMsg.btn_text = bundle.getString("btn_text");
        acsMsg.title = bundle.getString("title");
        acsMsg.mn_reserved = bundle.getString("mn_reserved");
        acsMsg.notice_time = bundle.getLong("notice_time");
        acsMsg.banner_type = bundle.getInt("banner_type");
        acsMsg.banner_url = bundle.getString("banner_url");
        return acsMsg;
    }

    public static void g(Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("[QQNotify]QQReminderAMSHelper", 1, "addQQReminderMsg is call");
        }
        if (MobileQQ.sProcessId == 1) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (!(runtime instanceof QQAppInterface)) {
                if (QLog.isColorLevel()) {
                    QLog.d("[QQNotify]QQReminderAMSHelper", 1, "changeQQReminderSwitch: QQAppInterface is null");
                    return;
                }
                return;
            }
            ((IQQReminderDataService) runtime.getRuntimeService(IQQReminderDataService.class, "")).doNotifyByPush(f(bundle));
            return;
        }
        QIPCClientHelper.getInstance().callServer("QQNotifyIPCModule", "add_msg", bundle, null);
    }
}
