package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QAVStep extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public QAVStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        String i3 = com.tencent.av.b.i();
        StringBuilder sb5 = new StringBuilder();
        String str = File.separator;
        sb5.append(str);
        sb5.append("config.xml");
        String sb6 = sb5.toString();
        AVAvatarResMgr.v();
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("qav_config_flag", 0);
        int i16 = sharedPreferences.getInt("flag_delete", 0);
        if (i16 != 0) {
            if (QLog.isDevelopLevel()) {
                QLog.w("IAutomator", 1, "QAVStep, flag_delete[" + i16 + "]");
            }
            return 7;
        }
        FileUtils.deleteDirectory(i3 + 106);
        FileUtils.deleteFile(i3 + 132 + sb6);
        FileUtils.deleteFile(i3 + 176 + sb6);
        FileUtils.deleteFile(i3 + 216 + sb6);
        StringBuilder sb7 = new StringBuilder();
        sb7.append(i3);
        sb7.append(263);
        FileUtils.deleteDirectory(sb7.toString());
        FileUtils.deleteFile(i3 + 370 + sb6);
        FileUtils.deleteFile(i3 + "beauty" + str + "beauty_config.json");
        StringBuilder sb8 = new StringBuilder();
        sb8.append(i3);
        sb8.append("signal_strength");
        FileUtils.deleteDirectory(sb8.toString());
        sharedPreferences.edit().putInt("flag_delete", com.tencent.mobileqq.cooperation.a.a(BaseApplication.getContext())).commit();
        return 7;
    }
}
