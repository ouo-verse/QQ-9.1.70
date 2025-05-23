package com.tencent.mobileqq.app.guard;

import android.app.ActivityManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes11.dex */
public class GuardStateScheduler {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "GuardManager.GuardStateScheduler";
    private boolean isReady;
    private final HashMap<String, String> processMap;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class GuardStateSchedulerHolder {
        static IPatchRedirector $redirector_;
        public static GuardStateScheduler INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36969);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new GuardStateScheduler(null);
            }
        }

        public GuardStateSchedulerHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ GuardStateScheduler(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
    }

    private int checkState(int i3) {
        int stateId = GuardManager.sInstance.getStateId();
        if (i3 == stateId) {
            return i3;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "GuardState have change: prv state: ", Integer.valueOf(i3), " curState: ", Integer.valueOf(stateId));
        }
        return stateId;
    }

    private static Map<String, String> filteredRealForegroundProcMap(Map<String, String> map) {
        BaseApplication baseApplication = BaseApplication.context;
        HashMap hashMap = new HashMap();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) baseApplication.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (key != null && key.equals(runningAppProcessInfo.processName) && runningAppProcessInfo.importance == 100) {
                        hashMap.put(key, map.get(key));
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!hashMap.containsKey(entry.getKey())) {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                map.remove((String) it5.next());
            }
        }
        QLog.d(TAG, 1, "[process] filterRealForegroundProcMap: invoked. ", " realProcMap: ", hashMap);
        return hashMap;
    }

    public static GuardStateScheduler getInstance() {
        return GuardStateSchedulerHolder.INSTANCE;
    }

    private String getLatestProcess() {
        long j3 = 0;
        String str = null;
        for (Map.Entry<String, String> entry : filteredRealForegroundProcMap(this.processMap).entrySet()) {
            if (Long.parseLong(entry.getValue()) > j3) {
                j3 = Long.parseLong(entry.getValue());
                str = entry.getKey();
            }
        }
        return str;
    }

    private void nextState(int i3, String str) {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "nextState: ", GuardState.NAME_STATE[i3], " process: ", str);
            }
            guardManager.nextState(i3, str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "GuardManager is Null !! nextState: ", GuardState.NAME_STATE[i3], " process: ", str);
        }
    }

    public List<String> getForegroundProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(filteredRealForegroundProcMap(this.processMap).keySet());
        return arrayList;
    }

    public void updateStateOnMessageRecEvent(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
            return;
        }
        int checkState = checkState(i3);
        if (checkState != 5) {
            if (checkState != 7) {
                QLog.d(TAG, 2, "onMessageRec unknown state type: ", Integer.valueOf(checkState));
                return;
            } else {
                nextState(6, str);
                return;
            }
        }
        nextState(4, str);
    }

    public void updateStateOnProcessBGEvent(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onProcessBGEvent: process: ", str, " isReady: ", Boolean.valueOf(this.isReady));
        }
        if (!this.isReady) {
            QLog.d(TAG, 1, "GuardStateScheduler setReady");
            this.isReady = true;
            return;
        }
        this.processMap.remove(str);
        String latestProcess = getLatestProcess();
        if (latestProcess != null) {
            if (MobileQQ.PACKAGE_NAME.equals(latestProcess)) {
                nextState(2, latestProcess);
                return;
            } else {
                nextState(3, latestProcess);
                return;
            }
        }
        nextState(4, null);
    }

    public void updateStateOnProcessFGEvent(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onProcessFGEvent: process: ", str, " isReady: ", Boolean.valueOf(this.isReady));
        }
        if (!this.isReady) {
            this.isReady = true;
        }
        this.processMap.put(str, str2);
        String latestProcess = getLatestProcess();
        if (MobileQQ.PACKAGE_NAME.equals(latestProcess)) {
            nextState(2, latestProcess);
        } else {
            nextState(3, latestProcess);
        }
    }

    public void updateStateOnStateTickEvent(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        int checkState = checkState(i3);
        if (checkState != 2) {
            if (checkState != 4) {
                if (checkState != 6) {
                    QLog.d(TAG, 2, "onTickEvent unSupport state type: ", Integer.valueOf(checkState));
                    return;
                } else {
                    nextState(7, str);
                    return;
                }
            }
            nextState(5, str);
            return;
        }
        if (filteredRealForegroundProcMap(this.processMap).size() <= 0) {
            nextState(4, null);
        }
    }

    GuardStateScheduler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.processMap = new HashMap<>();
            this.isReady = false;
        }
    }
}
