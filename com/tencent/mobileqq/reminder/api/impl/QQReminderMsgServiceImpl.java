package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsMsg;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderMsgService;
import com.tencent.mobileqq.reminder.push.d;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQReminderMsgServiceImpl implements IQQReminderMsgService {
    static IPatchRedirector $redirector_ = null;
    private static final String QQ_EID = "qq_eid";
    private static final String TAG = "QQReminderMsgService";
    private final d mPushCenter;
    private IQQReminderDataService mReminderDataManager;

    public QQReminderMsgServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mPushCenter = new d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isScreenLocked(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onSystemNotificationShow$0() {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong("notification_show_time", System.currentTimeMillis());
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderMsgService
    public AcsMsg getLastNoticeMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AcsMsg) iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord);
        }
        if (messageRecord == null) {
            return null;
        }
        try {
            long j3 = messageRecord.uniseq;
            for (String str : this.mReminderDataManager.getCacheKeyList()) {
                if (j3 == str.hashCode()) {
                    com.tencent.mobileqq.reminder.biz.entity.a entityByKey = this.mReminderDataManager.getEntityByKey(str);
                    if (entityByKey == null) {
                        return null;
                    }
                    return entityByKey.getAcsMsg();
                }
            }
            return null;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderMsgService
    public void onClickNoticeReport(AcsMsg acsMsg) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) acsMsg);
            return;
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        WadlReportBuilder ext = wadlReportBuilder.setDcId(WadlProxyConsts.TAG_ATTA_NOTICE).setOperModule("9377").setOperId("914025").setExt(1, "937701").setExt(4, "20").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD);
        String str2 = "";
        if (acsMsg == null) {
            str = "";
        } else {
            str = acsMsg.msg_id;
        }
        WadlReportBuilder ext2 = ext.setExt(3, str);
        if (acsMsg != null) {
            str2 = acsMsg.busi_id;
        }
        ext2.setExt(6, str2);
        wadlReportBuilder.report();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime);
        } else {
            this.mReminderDataManager = (IQQReminderDataService) appRuntime.getRuntimeService(IQQReminderDataService.class, "");
            this.mPushCenter.f();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mPushCenter.i();
            this.mPushCenter.d();
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderMsgService
    public void onShowNoticeReport(AcsMsg acsMsg) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) acsMsg);
            return;
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        WadlReportBuilder ext = wadlReportBuilder.setDcId(WadlProxyConsts.TAG_ATTA_NOTICE).setOperModule("9377").setOperId("914024").setExt(1, "937701").setExt(4, "8").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD);
        String str2 = "";
        if (acsMsg == null) {
            str = "";
        } else {
            str = acsMsg.msg_id;
        }
        WadlReportBuilder ext2 = ext.setExt(3, str);
        if (acsMsg != null) {
            str2 = acsMsg.busi_id;
        }
        ext2.setExt(6, str2);
        wadlReportBuilder.report();
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderMsgService
    public void onSystemNotificationShow(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        } else {
            onSystemNotificationShow();
            ThreadManagerV2.excute(new Runnable(message) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderMsgServiceImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Message f280921d;

                {
                    this.f280921d = message;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQReminderMsgServiceImpl.this, (Object) message);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    String str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AcsMsg lastNoticeMsg = QQReminderMsgServiceImpl.this.getLastNoticeMsg(this.f280921d);
                    if (QLog.isColorLevel()) {
                        QLog.i(QQReminderMsgServiceImpl.TAG, 2, "---onSystemNotificationShow----" + lastNoticeMsg);
                    }
                    String str3 = "";
                    if (QQReminderMsgServiceImpl.this.isScreenLocked(BaseApplication.getContext())) {
                        IQQGameHelper iQQGameHelper = (IQQGameHelper) QRoute.api(IQQGameHelper.class);
                        if (lastNoticeMsg == null) {
                            str2 = "";
                        } else {
                            str2 = lastNoticeMsg.msg_id;
                        }
                        if (lastNoticeMsg != null) {
                            str3 = lastNoticeMsg.busi_id;
                        }
                        iQQGameHelper.reportNoticeToDc87("914028", "8", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9377", "937701", str2, str3);
                        return;
                    }
                    IQQGameHelper iQQGameHelper2 = (IQQGameHelper) QRoute.api(IQQGameHelper.class);
                    if (lastNoticeMsg == null) {
                        str = "";
                    } else {
                        str = lastNoticeMsg.msg_id;
                    }
                    if (lastNoticeMsg != null) {
                        str3 = lastNoticeMsg.busi_id;
                    }
                    iQQGameHelper2.reportNoticeToDc87("914030", "8", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9377", "937701", str, str3);
                }
            }, 128, null, true);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderMsgService
    public void registerNtSysMsgNotification() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.mPushCenter.g();
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderMsgService
    public void showRemindDialog(Wallet.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            QQReminderUtil.J(topActivity, aVar);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderMsgService
    public void onSystemNotificationShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.reminder.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                QQReminderMsgServiceImpl.lambda$onSystemNotificationShow$0();
            }
        }, 64, null, false);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderMsgServiceImpl.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQReminderMsgServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QQReminderUtil.j();
                }
            }
        });
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[onSystemNotificationShow]");
        }
    }
}
