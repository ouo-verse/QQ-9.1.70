package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsMsg;
import Wallet.AcsSubNoticeRsp;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.ipc.IComIPCUtils;
import com.tencent.mobileqq.reminder.api.IQQActivateFriendService;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.reminder.calendar.CalenderUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.er;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DBBuildUtil;
import cooperation.qwallet.plugin.FakeUrl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQReminderCalendarServiceImpl implements IQQReminderCalendarService {
    static IPatchRedirector $redirector_ = null;
    private static final int SUBSCRIBE_LIMIT = 2;
    private static final int SUBSCRIBE_SUCCESS = 0;
    public static final String TAG = "QQReminderCalendarImpl";
    private AppRuntime app;
    private EntityManager mEntityManager;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IQQReminderCalendarService.a f280900d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppActivity f280901e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f280902f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f280903h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f280904i;

        a(IQQReminderCalendarService.a aVar, AppActivity appActivity, String str, String str2, boolean z16) {
            this.f280900d = aVar;
            this.f280901e = appActivity;
            this.f280902f = str;
            this.f280903h = str2;
            this.f280904i = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQReminderCalendarServiceImpl.this, aVar, appActivity, str, str2, Boolean.valueOf(z16));
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (i3 != 2002) {
                return;
            }
            try {
                if (!z16) {
                    QQReminderCalendarServiceImpl.this.setSubCalendarNotifyListener(this.f280900d, 3, "system error");
                    return;
                }
                AcsSubNoticeRsp acsSubNoticeRsp = (AcsSubNoticeRsp) bundle.getSerializable("rsp");
                if (acsSubNoticeRsp == null) {
                    QQReminderCalendarServiceImpl.this.setSubCalendarNotifyListener(this.f280900d, 3, "system error");
                    return;
                }
                if (QQReminderCalendarServiceImpl.this.app != null && this.f280901e != null) {
                    int i16 = acsSubNoticeRsp.ret_code;
                    String str = acsSubNoticeRsp.err_str;
                    QLog.i(QQReminderCalendarServiceImpl.TAG, 1, "QQReminderServlet.sendSubscribeReminder retCode: " + i16 + " msg: " + str);
                    if (i16 == 0) {
                        QQReminderCalendarServiceImpl.this.subscribeSuccess(acsSubNoticeRsp, this.f280902f, this.f280903h, this.f280904i, this.f280901e);
                    } else if (i16 == 2) {
                        QQReminderCalendarServiceImpl.this.subscribeLimit(acsSubNoticeRsp, this.f280901e);
                    }
                    QQReminderCalendarServiceImpl.this.setSubCalendarNotifyListener(this.f280900d, i16, str);
                    return;
                }
                QQReminderCalendarServiceImpl.this.setSubCalendarNotifyListener(this.f280900d, 3, "system error");
            } catch (Throwable th5) {
                QLog.e(QQReminderCalendarServiceImpl.TAG, 1, QLog.getStackTraceString(th5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQReminderCalendarServiceImpl.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                QLog.w(QQReminderCalendarServiceImpl.TAG, 1, "subNotifyMsg dialog onClick");
            }
        }
    }

    public QQReminderCalendarServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private CalendarEntity acsMsg2CalendarEntity(AcsMsg acsMsg) {
        CalendarEntity calendarEntity = new CalendarEntity();
        calendarEntity.content = "";
        calendarEntity.msg_id = acsMsg.msg_id;
        calendarEntity.notice_time = acsMsg.notice_time;
        calendarEntity.title = acsMsg.title;
        calendarEntity.jump_url = acsMsg.jump_url;
        return calendarEntity;
    }

    private static boolean isToday(long j3) {
        Date date = new Date(j3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd", Locale.SIMPLIFIED_CHINESE);
        if (simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date(NetConnInfoCenter.getServerTimeMillis())))) {
            return true;
        }
        return false;
    }

    private void runAtOtherThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(runnable, 32, null, true);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubCalendarNotifyListener(IQQReminderCalendarService.a aVar, int i3, String str) {
        if (aVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("retcode", i3);
        bundle.putString("retmsg", str);
        aVar.onResult(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subscribeLimit(AcsSubNoticeRsp acsSubNoticeRsp, AppActivity appActivity) {
        JSONObject jSONObject;
        QLog.i(TAG, 1, "subNotifyMsg occur SUBSCRIBE_LIMIT: " + acsSubNoticeRsp.err_str);
        try {
            jSONObject = new JSONObject(acsSubNoticeRsp.err_str);
        } catch (JSONException e16) {
            QLog.w(TAG, 1, "subNotifyMsg fail: ", e16);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        QQCustomDialog qQCustomDialog = new QQCustomDialog(appActivity, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(jSONObject.optString("title"));
        qQCustomDialog.setMessageWithoutAutoLink(jSONObject.optString("retmsg"));
        qQCustomDialog.setPositiveButton(jSONObject.optString(FakeUrl.FAKE_RBUTTON), new b());
        qQCustomDialog.setCanceledOnTouchOutside(true);
        qQCustomDialog.setCancelable(false);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subscribeSuccess(AcsSubNoticeRsp acsSubNoticeRsp, String str, String str2, boolean z16, AppActivity appActivity) {
        boolean z17;
        IQQReminderDataService iQQReminderDataService;
        AcsMsg acsMsg = acsSubNoticeRsp.f25141msg;
        QLog.i(TAG, 1, "QQReminderServlet.sendSubscribeReminder subscribe succ acsMsg: " + acsMsg);
        if (acsMsg != null && isToday(acsMsg.notice_time * 1000)) {
            AppRuntime appRuntime = this.app;
            if (appRuntime != null) {
                iQQReminderDataService = (IQQReminderDataService) appRuntime.getRuntimeService(IQQReminderDataService.class, "");
            } else {
                iQQReminderDataService = null;
            }
            if (iQQReminderDataService != null) {
                iQQReminderDataService.saveReminderMsg(acsMsg);
            }
        }
        if (acsMsg != null && z16 && acsMsg.calendar == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            AppRuntime appRuntime2 = this.app;
            if (appRuntime2 != null) {
                ((IQQReminderCalendarService) appRuntime2.getRuntimeService(IQQReminderCalendarService.class, "")).setCalendarAlarm(appActivity, acsMsg2CalendarEntity(acsMsg));
            }
            ReportController.o(null, "dc00898", "", "", "0X800C2CD", "0X800C2CD", 0, 0, "", "", str, str2);
        }
        boolean isNetSupport = NetworkUtil.isNetSupport(appActivity);
        QLog.i(TAG, 1, "QQReminderServlet.sendSubscribeReminder isNerSupport: " + isNetSupport);
        if (isNetSupport) {
            AppRuntime appRuntime3 = this.app;
            if (appRuntime3 != null) {
                IQQActivateFriendService iQQActivateFriendService = (IQQActivateFriendService) appRuntime3.getRuntimeService(IQQActivateFriendService.class, "");
                if (iQQActivateFriendService != null) {
                    iQQActivateFriendService.setSwitchValueForQQNotify(true, true);
                    return;
                }
                return;
            }
            boolean isQQReminderOpen = ((IComIPCUtils) QRoute.api(IComIPCUtils.class)).isQQReminderOpen();
            QLog.i(TAG, 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + isQQReminderOpen);
            if (!isQQReminderOpen) {
                QLog.i(TAG, 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
                ((IComIPCUtils) QRoute.api(IComIPCUtils.class)).setQQReminderSwitch(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderCalendarService
    public void addCalendarEntity(CalendarEntity calendarEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) calendarEntity);
        } else {
            runAtOtherThread(new Runnable(calendarEntity) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderCalendarServiceImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ CalendarEntity f280898d;

                {
                    this.f280898d = calendarEntity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQReminderCalendarServiceImpl.this, (Object) calendarEntity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (this.f280898d != null) {
                        QQReminderCalendarServiceImpl.this.mEntityManager.persistOrReplace(this.f280898d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderCalendarService
    public void deleteCalendarAlarm(AppActivity appActivity, CalendarEntity calendarEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appActivity, (Object) calendarEntity);
        } else if (isCalendarOpen(appActivity)) {
            new CalenderUtils().c(appActivity, calendarEntity);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderCalendarService
    public void deleteCalendarEntity(CalendarEntity calendarEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) calendarEntity);
        } else {
            runAtOtherThread(new Runnable(calendarEntity) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderCalendarServiceImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ CalendarEntity f280899d;

                {
                    this.f280899d = calendarEntity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQReminderCalendarServiceImpl.this, (Object) calendarEntity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    CalendarEntity calendarEntity2 = this.f280899d;
                    if (calendarEntity2 != null) {
                        int delete = QQReminderCalendarServiceImpl.this.mEntityManager.delete(CalendarEntity.class.getSimpleName(), "msg_id = ?", new String[]{calendarEntity2.msg_id});
                        if (QLog.isColorLevel()) {
                            QLog.d(QQReminderCalendarServiceImpl.TAG, 1, "deleteCalendar msgId: ", this.f280899d.msg_id, " count: ", Integer.valueOf(delete));
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderCalendarService
    public boolean isCalendarOpen(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context)).booleanValue();
        }
        return er.b(context, "KEY_REMINDER_CALENDAR", true);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.app = appRuntime;
            this.mEntityManager = DBBuildUtil.getDefaultEntityManagerFactoryBuilder(null).build().createEntityManager();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mEntityManager.close();
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderCalendarService
    public List<CalendarEntity> queryCalendarEntity(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return this.mEntityManager.query(CalendarEntity.class, CalendarEntity.class.getSimpleName(), false, "msg_id = ?", new String[]{str}, (String) null, (String) null, "notice_time", (String) null);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderCalendarService
    public void setCalendarAlarm(AppActivity appActivity, CalendarEntity calendarEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appActivity, (Object) calendarEntity);
        } else if (isCalendarOpen(appActivity)) {
            new CalenderUtils().b(appActivity, calendarEntity);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderCalendarService
    public void subCalendarNotify(AppActivity appActivity, String str, String str2, String str3, boolean z16, IQQReminderCalendarService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, appActivity, str, str2, str3, Boolean.valueOf(z16), aVar);
            return;
        }
        if (this.app != null && appActivity != null && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            IQQReminderService iQQReminderService = (IQQReminderService) this.app.getRuntimeService(IQQReminderService.class, "");
            if (iQQReminderService == null) {
                setSubCalendarNotifyListener(aVar, 3, "system error");
                return;
            } else {
                iQQReminderService.sendSubscribeReminder(str2, str3, new a(aVar, appActivity, str, str2, z16));
                return;
            }
        }
        setSubCalendarNotifyListener(aVar, 3, "system error");
    }
}
