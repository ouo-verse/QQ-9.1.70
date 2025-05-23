package com.tencent.mobileqq.perf.raftkit;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raftkit.RaftKit;
import com.tencent.raftkit.RaftKitConfig;
import com.tencent.raftkit.common.log.LogUtil;
import com.tencent.raftkit.common.log.Logger;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQRaftKitManager {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "QQRaftKitManager";
    private static boolean bRaftKitClassExist;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements Logger {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public QQRaftKitManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean checkRaftKitClass() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z16 = true;
        try {
            Class.forName("com.tencent.raftkit.RaftKit");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "init, RaftKit class not found ", e16);
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkRaftKitClass cost : " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return z16;
    }

    public static void checkState(boolean z16) {
        if (z16) {
            QLog.d(TAG, 2, "open");
            open();
        } else {
            close();
        }
    }

    public static void close() {
        if (!bRaftKitClassExist) {
            QLog.e(TAG, 1, "close, bRaftKitClassExist is false");
            return;
        }
        try {
            RaftKit.setFloatingStyle(-1, true);
            RaftKit.shutdownAllRunning();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "close error", e16);
        }
    }

    private static ArrayList<String> getQQLogDirs(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        String str = QLog.getLogExternalPath(context) + "/tencent/msflogs/com/tencent/mobileqq/";
        if (str != null && QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getQQLogDirs, logPath = " + str);
        }
        arrayList.add(str);
        return arrayList;
    }

    public static void init(Context context) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "init ");
        }
        boolean checkRaftKitClass = checkRaftKitClass();
        bRaftKitClassExist = checkRaftKitClass;
        if (!checkRaftKitClass) {
            QLog.e(TAG, 1, "init, bRaftKitClassExist is false");
            return;
        }
        try {
            RaftKitConfig build = new RaftKitConfig.RaftKitConfigBuilder().setEntryGroupOrder(new String[]{"\u8c03\u8bd5\u5de5\u5177"}).setLogFilterConfig(getQQLogDirs(context)).setPortalConfig(false, -1).build();
            setLogProxy();
            RaftKit.install(MobileQQ.sMobileQQ, build);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "init error", e16);
        }
    }

    public static boolean isOpened() {
        if (!bRaftKitClassExist) {
            QLog.e(TAG, 1, "close, bRaftKitClassExist is false");
            return false;
        }
        try {
            if (RaftKit.getFloatingStyle() == -1) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "close error", e16);
            return false;
        }
    }

    public static void open() {
        if (!bRaftKitClassExist) {
            QLog.e(TAG, 1, "open, bRaftKitClassExist is false");
            return;
        }
        try {
            RaftKit.setFloatingStyle(2, true);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "open error", e16);
        }
    }

    private static void setLogProxy() {
        LogUtil.setLogger(new a());
    }
}
