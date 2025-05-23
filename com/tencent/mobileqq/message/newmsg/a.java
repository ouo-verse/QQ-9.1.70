package com.tencent.mobileqq.message.newmsg;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.CompoundButton;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.bk;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f245809d;

    /* renamed from: e, reason: collision with root package name */
    boolean f245810e;

    /* renamed from: f, reason: collision with root package name */
    CompoundButton.OnCheckedChangeListener f245811f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.message.newmsg.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class DialogInterfaceOnClickListenerC8025a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        DialogInterfaceOnClickListenerC8025a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f245813d;

        b(QBaseActivity qBaseActivity) {
            this.f245813d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) qBaseActivity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                c.b();
                a.this.i(this.f245813d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class c {
        static IPatchRedirector $redirector_;

        private static void a(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("param_action", str);
            QQBeaconReport.report("", "msg_notification_open_system_notification_setting", hashMap);
        }

        public static void b() {
            a("click");
        }

        public static void c() {
            a("show");
        }
    }

    public a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f245810e = true;
        this.f245809d = qQAppInterface;
        this.f245810e = h();
    }

    public static a d(QQAppInterface qQAppInterface) {
        return (a) qQAppInterface.getManager(QQManagerFactory.NEW_MSG_NOTIFICATION_MANAGER);
    }

    private Bitmap e(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (QLog.isColorLevel()) {
                QLog.d("NewMsgNotificationManager", 2, "getBitmapFromLocal: invoked. ", " id: ", Integer.valueOf(parseInt), " iconUrl: ", str);
            }
            return BitmapFactory.decodeResource(this.f245809d.getApp().getResources(), com.tencent.mobileqq.growth.a.a(parseInt));
        } catch (Exception e16) {
            QLog.e("NewMsgNotificationManager", 1, "getBitmapFromLocal: failed. ", e16);
            return null;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("NewMsgNotificationManager", 2, "getBitmapFromLocal: failed. ", e17);
                return null;
            }
            return null;
        }
    }

    public static Bitmap f(String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            QLog.e("NewMsgNotificationManager", 1, "getBitmapFromUrl: failed. can't run in ui thread. ", str);
            return null;
        }
        String filePath = AbsDownloader.getFilePath(str);
        File file = new File(filePath);
        long uptimeMillis = SystemClock.uptimeMillis();
        g gVar = new g(str, file);
        gVar.Q = true;
        gVar.f313008f = 2;
        gVar.f313004c = filePath;
        gVar.v(512);
        int n3 = DownloaderFactory.n(gVar, null, null);
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (QLog.isColorLevel()) {
            QLog.i("NewMsgNotificationManager", 2, "download cost " + uptimeMillis2 + " result " + n3 + " key " + gVar.f313004c + " iconUrl: " + str);
        }
        return SafeBitmapFactory.decodeFile(filePath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(QBaseActivity qBaseActivity) {
        Intent a16 = bk.a(this.f245809d.getApp());
        QBaseActivity qBaseActivity2 = QBaseActivity.sTopActivity;
        if (qBaseActivity2 != null) {
            qBaseActivity2.startActivity(a16);
        } else {
            qBaseActivity.startActivity(a16);
        }
    }

    private boolean k(int i3, String str) {
        boolean b16 = b();
        if (QLog.isColorLevel()) {
            QLog.d("NewMsgNotificationManager", 2, "newMsgNotificationEnabled: invoked. ", " systemNotificationEnabled: ", Boolean.valueOf(b16));
        }
        if (!q(i3) && !p(str)) {
            return true;
        }
        return g();
    }

    private static boolean p(String str) {
        return AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(str);
    }

    private static boolean q(int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 3000 || i3 == 1009 || i3 == 1001 || i3 == 10002 || i3 == 10004 || i3 == 1003 || i3 == 1004 || i3 == 1005 || i3 == 1020 || i3 == 1000 || i3 == 1023 || i3 == 1024 || i3 == 1025 || i3 == 7220 || i3 == 7120 || i3 == 7200 || i3 == 1008 || i3 == 3001 || i3 == 7210 || i3 == 7230 || i3 == 7 || i3 == 6000 || i3 == 6003 || i3 == 7000 || i3 == 10007 || i3 == 10008 || i3 == 10014 || i3 == 10010 || i3 == 1046) {
            return true;
        }
        return false;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        boolean areNotificationsEnabled = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.getContext());
        if (QLog.isColorLevel()) {
            QLog.d("NewMsgNotificationManager", 2, "systemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(areNotificationsEnabled));
        }
        return areNotificationsEnabled;
    }

    public Bitmap c(String str, String str2, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Bitmap) iPatchRedirector.redirect((short) 15, this, str, str2, bitmap);
        }
        if (TextUtils.isEmpty(str2)) {
            return bitmap;
        }
        if ("2".equals(str)) {
            return f(str2);
        }
        if ("1".equals(str)) {
            return e(str2);
        }
        return bitmap;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean readValue = SettingCloneUtil.readValue((Context) this.f245809d.getApp(), this.f245809d.getCurrentUin(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true);
        if (QLog.isColorLevel()) {
            QLog.d("NewMsgNotificationManager", 2, "globalSwitchOn: invoked. ", " enable: ", Boolean.valueOf(readValue));
        }
        return readValue;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (SettingCloneUtil.isContainValue(this.f245809d.getApp(), this.f245809d.getCurrentUin(), null, AppConstants.SYSTEM_NOTIFICATION_ENABLED_KEY)) {
            return SettingCloneUtil.readValue((Context) this.f245809d.getApp(), this.f245809d.getCurrentUin(), (String) null, AppConstants.SYSTEM_NOTIFICATION_ENABLED_KEY, true);
        }
        return b();
    }

    public boolean j(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("NewMsgNotificationManager", 2, "needDecodeIcon: invoked. ", " iconType: ", str, " iconUrl: ", str2);
        }
        if (("1".equals(str) || "2".equals(str)) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        return false;
    }

    public boolean l(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        if (message == null) {
            return true;
        }
        return k(message.istroop, message.frienduin);
    }

    public boolean m(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (messageRecord == null) {
            return true;
        }
        return k(messageRecord.istroop, messageRecord.frienduin);
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.f245811f = null;
        }
    }

    public void o(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) qBaseActivity);
            return;
        }
        DialogInterfaceOnClickListenerC8025a dialogInterfaceOnClickListenerC8025a = new DialogInterfaceOnClickListenerC8025a();
        DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, qBaseActivity.getString(R.string.irm), qBaseActivity.getString(R.string.cancel), qBaseActivity.getString(R.string.irl), new b(qBaseActivity), dialogInterfaceOnClickListenerC8025a).show();
        c.c();
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }
}
