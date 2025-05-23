package com.tencent.mobileqq.perf.tool;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.FileWriter;
import kotlin.Metadata;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/perf/tool/Pressure$IoConsumeThread", "Ljava/lang/Thread;", "", TencentLocation.RUN_MODE, "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class Pressure$IoConsumeThread extends BaseThread {
    static IPatchRedirector $redirector_;

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        File externalCacheDir = MobileQQ.sMobileQQ.getExternalCacheDir();
        if (externalCacheDir != null) {
            str = externalCacheDir.getPath();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(getName());
        sb5.append(".txt");
        String sb6 = sb5.toString();
        QLog.d("Pressure", 1, "io path: " + sb6);
        while (true) {
            File file = new File(sb6);
            if (file.length() > VasBusiness.QWALLET) {
                file.delete();
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            for (int i3 = 0; i3 < 67108865; i3++) {
                fileWriter.write((int) (Math.random() * 100));
            }
        }
    }
}
