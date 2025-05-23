package com.tencent.mobileqq.app.guardcallback;

import android.os.Process;
import com.tencent.mobileqq.app.guard.GuardConfig;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.m;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements IGuardInterface {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a() {
        if (new Random().nextInt(1000) == 666) {
            return true;
        }
        return false;
    }

    private void c(boolean z16) {
        String str;
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            return;
        }
        long d16 = sy3.b.d(Process.myPid());
        int[] activeCount = guardManager.getActiveCount();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("qqUsedMemory", String.valueOf(d16 / 1024));
        hashMap.put("resumeCount", String.valueOf((activeCount[0] * 1.0d) / 15.0d));
        hashMap.put("msgCount", String.valueOf((activeCount[1] * 1.0d) / 15.0d));
        hashMap.put("activeLevel", String.valueOf(guardManager.getActivateLevel()));
        if (z16) {
            str = "actLiteActive";
        } else {
            str = "actFullActive";
        }
        b(str, hashMap);
    }

    protected void b(String str, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) hashMap);
            return;
        }
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        hashMap.put(DownloadInfo.spKey_Config, GuardConfig.instance().configId);
        statisticCollector.collectPerformance("", str, true, 0L, 0L, hashMap, "");
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long j3) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
            return;
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            return;
        }
        float b16 = sy3.b.c().b();
        if (uy3.d.c().f440638l > 0.0f) {
            f16 = uy3.d.c().f440638l;
        } else {
            f16 = 0.95f;
        }
        if (b16 >= f16 && uy3.d.c().f440635i && guardManager.mFgProcess == null) {
            System.exit(-1);
        }
        if (j3 == (GuardManager.SUICIDE_FACTOR * 50) - 1 && a()) {
            long d16 = sy3.b.d(Process.myPid());
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("qqUsedMemory", String.valueOf(d16 / 1024));
            hashMap.put("ramSize", String.valueOf(m.c() / 1024));
            hashMap.put("heapSize", String.valueOf(Runtime.getRuntime().totalMemory() / 1024));
            hashMap.put("maxHeapSize", String.valueOf(Runtime.getRuntime().maxMemory() / 1024));
            b("GM_reborn", hashMap);
            if (QLog.isColorLevel()) {
                QLog.d(GuardManager.TAG, 2, "suicide to free memory! suicide_factor=" + GuardManager.SUICIDE_FACTOR);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null && j3 >= guardManager.getTimeout()) {
            c(true);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
    }
}
