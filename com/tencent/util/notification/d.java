package com.tencent.util.notification;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.notification.struct.ProcessorFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

/* compiled from: P */
@Deprecated
/* loaded from: classes27.dex */
public class d implements Manager {
    static IPatchRedirector $redirector_;
    static AtomicBoolean C;
    private static final boolean D;

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f383994d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, Integer> f383995e;

    /* renamed from: f, reason: collision with root package name */
    private int f383996f;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, Boolean> f383997h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, Boolean> f383998i;

    /* renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f383999m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77628);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            C = new AtomicBoolean(true);
            D = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notify_id_manager_async_write_sp_128169955", true);
        }
    }

    public d(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f383999m = new AtomicBoolean(false);
        this.f383994d = qQAppInterface;
        this.f383997h = new ConcurrentHashMap();
        this.f383998i = new ConcurrentHashMap();
        o();
    }

    public static boolean e() {
        return C.get();
    }

    public static d g() {
        return h((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
    }

    public static d h(QQAppInterface qQAppInterface) {
        return (d) qQAppInterface.getManager(QQManagerFactory.NOTIFY_ID_MANAGER);
    }

    public static boolean j(int i3, String str) {
        if (ProcessorFactory.c(i3) && l(str)) {
            return true;
        }
        return false;
    }

    public static boolean k(Message message) {
        if (message == null || !ProcessorFactory.c(message.istroop) || !l(message.frienduin)) {
            return false;
        }
        return true;
    }

    private static boolean l(String str) {
        return Friends.isValidUin(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(QQNotificationManager qQNotificationManager) {
        for (int i3 = 512; i3 < 522; i3++) {
            qQNotificationManager.cancel("NotifyIdManager", i3);
        }
        if (D) {
            this.f383995e.clear();
            r(new HashMap());
        }
    }

    private static void n(String str, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        try {
            for (String str2 : str.split(",")) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                concurrentHashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
            }
        } catch (Exception e16) {
            QLog.e("NotifyIdManager", 1, "restoreUinIdMapFromSp: failed. ", e16);
        }
    }

    private void o() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(BaseApplication.context, "common_mmkv_configurations");
        String string = withAccount.getString("SP_KEY_CURRENT_NOTIFY_ID_MAP", null);
        if (!TextUtils.isEmpty(string)) {
            n(string, concurrentHashMap);
        }
        if (QLog.isColorLevel()) {
            QLog.d("NotifyIdManager", 2, "restoreUinIdMapFromSp: invoked. ", " mapStr: ", string);
        }
        this.f383995e = concurrentHashMap;
        this.f383996f = withAccount.getInt("SP_KEY_CURRENT_NOTIFY_ID", 512);
    }

    private void p() {
        QMMKV.withAccount(BaseApplication.context, "common_mmkv_configurations").putInt("SP_KEY_CURRENT_NOTIFY_ID", this.f383996f).apply();
        if (QLog.isColorLevel()) {
            QLog.d("NotifyIdManager", 2, "saveCurrentIdToSp: invoked. ", " mCurrentMinId: ", Integer.valueOf(this.f383996f));
        }
    }

    private void q() {
        r(this.f383995e);
    }

    private static void r(Map<String, Integer> map) {
        StringBuilder sb5 = new StringBuilder();
        for (String str : map.keySet()) {
            sb5.append(str);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(map.get(str));
            sb5.append(",");
        }
        if (sb5.length() >= 1) {
            sb5.delete(sb5.length() - 1, sb5.length());
        }
        if (QLog.isColorLevel()) {
            QLog.i("NotifyIdManager", 2, "saveUinIdMapToSp: invoked.  mapAsString: " + ((Object) sb5));
        }
        QMMKV.withAccount(BaseApplication.context, "common_mmkv_configurations").putString("SP_KEY_CURRENT_NOTIFY_ID_MAP", sb5.toString()).apply();
    }

    public static void s(boolean z16) {
        com.tencent.qqnt.classadapter.a.b(z16);
        C.set(z16);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        QLog.d("NotifyIdManager", 2, "cancelAllNotification: invoked. ");
        final QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.util.notification.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.m(qQNotificationManager);
            }
        }, 16, null, false);
        if (!D) {
            this.f383995e.clear();
            q();
        }
    }

    public void c(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) message);
            return;
        }
        if (message != null) {
            if (QLog.isColorLevel()) {
                QLog.d("NotifyIdManager", 2, "cancelNotificationByMessage: invoked. ", " message: ", message);
            }
            if (!i(message)) {
                d(message.frienduin);
            }
        }
    }

    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("NotifyIdManager", 2, "cancelNotificationByUin: call stack: ", new RuntimeException());
        }
        Integer num = this.f383995e.get(str);
        QLog.i("NotifyIdManager", 1, "cancelNotificationByUin: invoked.  notifyId: " + num + " friendUin: " + str);
        if (num != null) {
            QQNotificationManager.getInstance().cancel("NotifyIdManager", num.intValue());
        }
        this.f383995e.remove(str);
        q();
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("NotifyIdManager", 2, "clearUinNeedShowCareMap: invoked.  friendOrTroopUin: " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f383997h.remove(str);
            this.f383998i.remove(str);
        }
    }

    public boolean i(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) message)).booleanValue();
        }
        if (message != null && message.counter > 0) {
            return true;
        }
        return false;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f383995e.clear();
            q();
        }
    }

    public int t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("NotifyIdManager", 2, "uniqueNotifyIdByUin: invoked. ", " friendUin: ", str);
        }
        if (this.f383995e.containsKey(str)) {
            return this.f383995e.get(str).intValue();
        }
        int i3 = this.f383996f + 1;
        this.f383996f = i3;
        if (i3 >= 522) {
            this.f383996f = 512;
        }
        this.f383995e.put(str, Integer.valueOf(this.f383996f));
        q();
        p();
        return this.f383996f;
    }
}
