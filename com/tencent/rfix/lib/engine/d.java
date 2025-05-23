package com.tencent.rfix.lib.engine;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.lib.entity.RFixPatchResult;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f364978a;

    /* renamed from: b, reason: collision with root package name */
    private String f364979b;

    public d(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f364978a = context;
        }
    }

    @Override // com.tencent.rfix.lib.engine.b
    public boolean a(File file, File file2, RFixPatchResult rFixPatchResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, file, file2, rFixPatchResult)).booleanValue();
        }
        this.f364979b = "redirect-" + rFixPatchResult.patchIndex;
        RFixLog.i("RFix.RedirectPatchInstaller", "installPatch subDirName=" + this.f364979b);
        TimeTrackType timeTrackType = TimeTrackType.PATCH_INSTALL_INSTALLER_LIB;
        TimeTracker.beginTrack(timeTrackType);
        if (!c.d(this.f364978a, file, this.f364979b, file2)) {
            RFixLog.e("RFix.RedirectPatchInstaller", "installPatch install so files fail.");
            rFixPatchResult.installResult = -8;
            return false;
        }
        TimeTracker.endTrack(timeTrackType);
        TimeTrackType timeTrackType2 = TimeTrackType.PATCH_INSTALL_INSTALLER_DEX;
        TimeTracker.beginTrack(timeTrackType2);
        if (!b(file, file2)) {
            RFixLog.e("RFix.RedirectPatchInstaller", "installPatch install dex files fail.");
            rFixPatchResult.installResult = -7;
            return false;
        }
        TimeTracker.endTrack(timeTrackType2);
        RFixLog.i("RFix.RedirectPatchInstaller", "installPatch install success.");
        rFixPatchResult.installResult = 0;
        return true;
    }

    protected boolean b(File file, File file2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) file, (Object) file2)).booleanValue();
        }
        File file3 = new File(file2, "dex");
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    if (!PatchFileUtils.checkMd5AndExtractZipEntry(zipFile2, zipFile2.getEntry(this.f364979b + "/classes.dex"), new File(file3, "classes.dex"))) {
                        RFixLog.e("RFix.RedirectPatchInstaller", "tryInstallDexFiles extract dex file fail.");
                        PatchFileUtils.closeQuietly(zipFile2);
                        return false;
                    }
                    if (!PatchFileUtils.extractZipEntry(zipFile2, zipFile2.getEntry(this.f364979b + "/config.txt"), new File(file3, "config.txt"), null)) {
                        RFixLog.e("RFix.RedirectPatchInstaller", "tryInstallDexFiles extract dex config fail.");
                        PatchFileUtils.closeQuietly(zipFile2);
                        return false;
                    }
                    PatchFileUtils.closeQuietly(zipFile2);
                    RFixLog.i("RFix.RedirectPatchInstaller", "tryInstallDexFiles install dex files success.");
                    return true;
                } catch (IOException e16) {
                    e = e16;
                    zipFile = zipFile2;
                    RFixLog.e("RFix.RedirectPatchInstaller", "tryInstallDexFiles fail.", e);
                    PatchFileUtils.closeQuietly(zipFile);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    zipFile = zipFile2;
                    PatchFileUtils.closeQuietly(zipFile);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // com.tencent.rfix.lib.engine.b
    public String getPatchType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return RFixPatchInfo.PATCH_TYPE_REDIRECT;
    }
}
