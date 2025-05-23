package com.tencent.mobileqq.troop.homework.utils;

import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f297344a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64338);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f297344a = AppConstants.SDCARD_HOMEWORK_AUDIO + "homeworkTmp/";
    }

    public static void a() {
        VFSFile vFSFile = new VFSFile(f297344a);
        if (vFSFile.exists()) {
            for (VFSFile vFSFile2 : vFSFile.listFiles()) {
                vFSFile2.delete();
            }
        }
        VFSFile vFSFile3 = new VFSFile(AppConstants.SDCARD_HOMEWORK_AUDIO);
        if (vFSFile3.exists()) {
            for (VFSFile vFSFile4 : vFSFile3.listFiles()) {
                vFSFile4.delete();
            }
        }
    }
}
