package com.tencent.mobileqq.reminder.calendar;

import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
import java.util.Calendar;
import java.util.TimeZone;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionCallback;
import py3.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class CalenderUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f280932a;

    /* renamed from: b, reason: collision with root package name */
    private static String f280933b;

    /* renamed from: c, reason: collision with root package name */
    private static String f280934c;

    /* renamed from: d, reason: collision with root package name */
    protected static String f280935d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements QQPermissionCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f280938d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppActivity f280939e;

        a(Runnable runnable, AppActivity appActivity) {
            this.f280938d = runnable;
            this.f280939e = appActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, CalenderUtils.this, runnable, appActivity);
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), strArr, iArr);
            } else {
                DialogUtil.showPermissionSettingDialog(this.f280939e, null, HardCodeUtil.qqStr(R.string.f170655zh0));
                QLog.d("QQReminder.CalenderUtils", 1, "use deny permission");
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), strArr, iArr);
            } else {
                CalenderUtils.this.j(this.f280938d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31765);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f280932a = "content://com.android.calendar/calendars";
        f280933b = "content://com.android.calendar/events";
        f280934c = "content://com.android.calendar/reminders";
        f280935d = "sp_reminder_calendar";
    }

    public CalenderUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void f(String str) {
        MobileQQ.sMobileQQ.getSharedPreferences(f280935d, 0).edit().remove(str).apply();
    }

    private static String h(CalendarEntity calendarEntity) {
        return "https://ti.qq.com/remind/calendar?msgid=" + calendarEntity.msg_id;
    }

    private long i(String str) {
        return MobileQQ.sMobileQQ.getSharedPreferences(f280935d, 0).getLong(str, -1L);
    }

    private void k(String str, Long l3) {
        MobileQQ.sMobileQQ.getSharedPreferences(f280935d, 0).edit().putLong(str, l3.longValue()).apply();
    }

    protected void a(CalendarEntity calendarEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) calendarEntity);
            return;
        }
        String str = calendarEntity.title;
        String str2 = calendarEntity.content;
        long j3 = calendarEntity.notice_time * 1000;
        try {
            int g16 = g();
            if (g16 < 0) {
                QLog.e("QQReminder.CalenderUtils", 1, "getQQAccount is empty");
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3);
            long time = calendar.getTime().getTime();
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", str);
            contentValues.put("calendar_id", Integer.valueOf(g16));
            contentValues.put("eventTimezone", TimeZone.getDefault().getID());
            contentValues.put("description", str2 + "\n" + h(calendarEntity));
            contentValues.put("dtstart", Long.valueOf(time));
            contentValues.put("dtend", Long.valueOf(time + 7200000));
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            Uri insert = mobileQQ.getContentResolver().insert(Uri.parse(f280933b), contentValues);
            if (insert == null) {
                QLog.e("QQReminder.CalenderUtils", 1, "add to calendar error");
            }
            k(calendarEntity.msg_id, Long.valueOf(ContentUris.parseId(insert)));
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("event_id", Long.valueOf(ContentUris.parseId(insert)));
            contentValues2.put(TuxTimeView.TUX_TIME_STYLE_MINUTES, (Integer) 10);
            contentValues2.put("method", (Integer) 1);
            if (mobileQQ.getContentResolver().insert(Uri.parse(f280934c), contentValues2) == null) {
                QLog.e("QQReminder.CalenderUtils", 1, "add to reminder error");
            }
        } catch (Throwable th5) {
            QLog.e("QQReminder.CalenderUtils", 1, "addToCalendar err: ", th5);
        }
    }

    public void b(AppActivity appActivity, CalendarEntity calendarEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appActivity, (Object) calendarEntity);
        } else {
            ((IQQReminderCalendarService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQReminderCalendarService.class, "")).addCalendarEntity(calendarEntity);
            d(appActivity, new Runnable(calendarEntity) { // from class: com.tencent.mobileqq.reminder.calendar.CalenderUtils.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ CalendarEntity f280936d;

                {
                    this.f280936d = calendarEntity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CalenderUtils.this, (Object) calendarEntity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        CalenderUtils.this.a(this.f280936d);
                    }
                }
            });
        }
    }

    public void c(AppActivity appActivity, CalendarEntity calendarEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appActivity, (Object) calendarEntity);
            return;
        }
        ((IQQReminderCalendarService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQReminderCalendarService.class, "")).deleteCalendarEntity(calendarEntity);
        if (i(calendarEntity.msg_id) != -1) {
            if (QLog.isColorLevel()) {
                QLog.d("QQReminder.CalenderUtils", 2, "delete: check sp contain key");
            }
            d(appActivity, new Runnable(calendarEntity) { // from class: com.tencent.mobileqq.reminder.calendar.CalenderUtils.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ CalendarEntity f280937d;

                {
                    this.f280937d = calendarEntity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CalenderUtils.this, (Object) calendarEntity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        CalenderUtils.this.e(this.f280937d);
                    }
                }
            });
        }
    }

    protected void d(AppActivity appActivity, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appActivity, (Object) runnable);
            return;
        }
        com.tencent.mobileqq.reminder.calendar.a aVar = new com.tencent.mobileqq.reminder.calendar.a(appActivity);
        if (aVar.a()) {
            j(runnable);
        } else {
            aVar.c(23441, new a(runnable, appActivity));
        }
    }

    protected void e(CalendarEntity calendarEntity) {
        long i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) calendarEntity);
            return;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        String str = calendarEntity.msg_id;
        try {
            i3 = i(str);
        } catch (Throwable th5) {
            QLog.e("QQReminder.CalenderUtils", 1, "deleteCalendar err: ", th5);
        }
        if (i3 == -1) {
            return;
        }
        if (b.e(mobileQQ.getContentResolver(), ContentUris.withAppendedId(Uri.parse(f280933b), i3), null, null) == -1) {
            QLog.e("QQReminder.CalenderUtils", 1, "delete reminder fail");
        }
        f(str);
    }

    protected int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 1;
    }

    protected void j(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
        } else {
            ThreadManagerV2.excute(runnable, 32, null, true);
        }
    }
}
