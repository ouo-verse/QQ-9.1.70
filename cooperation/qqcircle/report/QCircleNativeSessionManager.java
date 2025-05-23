package cooperation.qqcircle.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import uq3.c;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleNativeSessionManager extends BaseMultiProcessSingleton {
    private static final String KEY_XSJ_SESSION = "key_xsj_session";
    private static final String TAG = "QCircleNativeSessionManager";
    private static volatile QCircleNativeSessionManager sSingleton;
    private final AtomicBoolean mHaveDoStartInit = new AtomicBoolean(false);
    private Timer mSessionGenerateTimer;

    public static boolean enableSessionReborn() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_qfs_session_reborn", true);
    }

    public static QCircleNativeSessionManager g() {
        if (sSingleton == null) {
            synchronized (QCircleNativeSessionManager.class) {
                if (sSingleton == null) {
                    sSingleton = new QCircleNativeSessionManager();
                }
            }
        }
        return sSingleton;
    }

    private boolean isMainProcess() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    public void clearSession() {
        if (!isMainProcess()) {
            QLog.e(TAG, 1, "clearSession  is not main process");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(KEY_XSJ_SESSION, "");
        updateMultiProcessData(bundle);
        QLog.d(TAG, 1, "clearSession");
    }

    public void enterQCircle() {
        Timer timer = this.mSessionGenerateTimer;
        if (timer != null) {
            timer.cancel();
            this.mSessionGenerateTimer = null;
        }
        QLog.i(TAG, 1, "enterQCircle  scheduleTask  cancel");
    }

    public void exitQCircle() {
        String session = getSession();
        if (session != null && QCircleNativeSessionGenerator.isShortSession(session)) {
            QLog.i(TAG, 1, "exitQCircle clearSession, session = " + session);
            clearSession();
            return;
        }
        if (this.mSessionGenerateTimer != null) {
            QLog.i(TAG, 1, "exitQCircle  mSessionGenerateTimer != null");
            return;
        }
        int t36 = c.t3() * 1000;
        TimerTask timerTask = new TimerTask() { // from class: cooperation.qqcircle.report.QCircleNativeSessionManager.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                QLog.i(QCircleNativeSessionManager.TAG, 1, "exitQCircle  TimerTask run()");
                QCircleNativeSessionManager.g().clearSession();
            }
        };
        try {
            if (this.mSessionGenerateTimer == null) {
                this.mSessionGenerateTimer = new BaseTimer();
            }
            this.mSessionGenerateTimer.schedule(timerTask, t36);
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[exitQCircle] error: ", th5);
        }
        QLog.i(TAG, 1, "exitQCircle  scheduleTask  delay = " + t36);
    }

    public String getSession() {
        Object multiProcessData = getMultiProcessData(KEY_XSJ_SESSION, "");
        if (multiProcessData instanceof String) {
            String str = (String) multiProcessData;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        String generateDefaultSession = QCircleNativeSessionGenerator.generateDefaultSession();
        if (!updateSession(generateDefaultSession)) {
            return "";
        }
        return generateDefaultSession;
    }

    public void onAppStart() {
        if (this.mHaveDoStartInit.compareAndSet(false, true)) {
            QLog.e(TAG, 1, "onAppStart do clearSession");
            clearSession();
        }
    }

    public boolean updateSession(String str) {
        if (!isMainProcess()) {
            QLog.e(TAG, 1, "updateSession, is not main process, session=" + str);
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(KEY_XSJ_SESSION, str);
        updateMultiProcessData(bundle);
        return true;
    }
}
