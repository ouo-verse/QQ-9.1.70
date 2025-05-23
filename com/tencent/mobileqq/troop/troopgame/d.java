package com.tencent.mobileqq.troop.troopgame;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.armap.h;
import com.tencent.mobileqq.armap.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends h.a {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String g() {
        String sDKPrivatePath;
        if (com.tencent.relation.common.config.toggle.c.J.g(false)) {
            sDKPrivatePath = MobileQQ.sMobileQQ.getExternalCacheDir() + "";
            if (QLog.isColorLevel()) {
                QLog.i("TroopGameCardResHandler", 1, "[getTroopGameCardResPath]new dir path=" + sDKPrivatePath);
            }
        } else {
            sDKPrivatePath = cu.e() ? VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) : BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath();
        }
        if (sDKPrivatePath != null) {
            String str = File.separator;
            if (!sDKPrivatePath.endsWith(str)) {
                sDKPrivatePath = sDKPrivatePath + str;
            }
        }
        return sDKPrivatePath + "troopgamecard/res" + File.separator;
    }

    @Override // com.tencent.mobileqq.armap.h.a, com.tencent.mobileqq.armap.h.b
    public String b(i.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
        String str = g() + aVar.f199754c + File.separator;
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardResHandler", 2, "getUnzipDirPath dir = " + str);
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0059, code lost:
    
        if (r6 != r4) goto L18;
     */
    @Override // com.tencent.mobileqq.armap.h.a, com.tencent.mobileqq.armap.h.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(i.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, aVar, Boolean.valueOf(z16))).booleanValue();
        }
        if (!aVar.f199757f) {
            return true;
        }
        long j3 = -1;
        long j16 = BaseApplicationImpl.getApplication().getSharedPreferences("troop_game_card_sp", 4).getLong(aVar.f199754c, -1L);
        File file = new File(b(aVar));
        if (file.exists()) {
            j3 = file.lastModified();
            if (j16 > 0) {
            }
        }
        z17 = true;
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardResHandler", 2, "verifyUnzipDir result = " + z17 + ",recordedModifyTime = " + j16 + ",realModifyTime = " + j3);
        }
        return z17;
    }

    @Override // com.tencent.mobileqq.armap.h.a, com.tencent.mobileqq.armap.h.b
    public boolean d(i.a aVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar)).booleanValue();
        }
        String e16 = e(aVar);
        if (TextUtils.isEmpty(e16)) {
            return true;
        }
        File file = new File(e16);
        boolean exists = file.exists();
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardResHandler", 2, "needDownload path[" + e16 + "], exists[" + exists + "]");
        }
        if (!exists) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGameCardResHandler", 2, "needDownload exists, path[" + e16 + "]");
            }
            return true;
        }
        try {
            str = com.tencent.qqprotect.singleupdate.a.d(file);
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGameCardResHandler", 2, "needDownload Exception" + e17);
            }
            str = null;
        }
        if (!TextUtils.equals(str, aVar.f199754c)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGameCardResHandler", 2, "needDownload exists, path[" + e16 + "], filemd5[" + str + "], downloadMd5[" + aVar.f199754c + "]");
            }
            return true;
        }
        return super.d(aVar);
    }

    @Override // com.tencent.mobileqq.armap.h.a, com.tencent.mobileqq.armap.h.b
    public String e(i.a aVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        if (aVar.f199757f) {
            str = g() + aVar.f199754c + ".end";
        } else {
            str = g() + aVar.f199754c + aVar.f199755d;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardResHandler", 2, "getDownloadPath path[" + str + "]");
        }
        return str;
    }
}
