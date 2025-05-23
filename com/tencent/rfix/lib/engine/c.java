package com.tencent.rfix.lib.engine;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.lib.entity.RFixPatchResult;
import com.tencent.rfix.lib.res.ResourceInstaller;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f364976a;

    /* renamed from: b, reason: collision with root package name */
    protected String f364977b;

    public c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f364976a = context;
        }
    }

    private boolean c(File file, File file2) {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(file);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            String str = this.f364977b + "/" + RFixConstants.RES_CONFIG_NAME;
            ZipEntry entry = zipFile.getEntry(str);
            if (entry == null) {
                RFixLog.i("RFix.QFixPatchInstaller", "tryInstallResPatch not exists " + str);
                PatchFileUtils.closeQuietly(zipFile);
                return true;
            }
            File file3 = new File(file2, "res");
            if (!PatchFileUtils.extractZipEntry(zipFile, entry, new File(file3, RFixConstants.RES_CONFIG_NAME), null)) {
                RFixLog.e("RFix.QFixPatchInstaller", "tryInstallResPatch extract res config fail.");
                PatchFileUtils.closeQuietly(zipFile);
                return false;
            }
            String str2 = this.f364977b + "/" + RFixConstants.RES_FILE_NAME;
            ZipEntry entry2 = zipFile.getEntry(str2);
            if (entry2 == null) {
                RFixLog.i("RFix.QFixPatchInstaller", "tryInstallResPatch not exists " + str2);
                PatchFileUtils.closeQuietly(zipFile);
                return false;
            }
            if (!PatchFileUtils.extractZipEntry(zipFile, entry2, new File(file3, RFixConstants.RES_FILE_NAME), null)) {
                RFixLog.e("RFix.QFixPatchInstaller", "tryInstallResPatch extract res file fail.");
                PatchFileUtils.closeQuietly(zipFile);
                return false;
            }
            boolean install = new ResourceInstaller(this.f364976a).install(file3);
            PatchFileUtils.closeQuietly(zipFile);
            return install;
        } catch (Throwable th6) {
            th = th6;
            zipFile2 = zipFile;
            try {
                RFixLog.e("RFix.QFixPatchInstaller", "tryInstallResPatch fail.", th);
                return false;
            } finally {
                PatchFileUtils.closeQuietly(zipFile2);
            }
        }
    }

    public static boolean d(Context context, File file, String str, File file2) {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(file);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if (!PatchFileUtils.extractZip(file, str + "/" + RFixConstants.SO_PATH, file2)) {
                PatchFileUtils.closeQuietly(zipFile);
                return false;
            }
            boolean i3 = new com.tencent.rfix.lib.so.b(context).i(new File(file2, RFixConstants.SO_PATH));
            PatchFileUtils.closeQuietly(zipFile);
            return i3;
        } catch (Throwable th6) {
            th = th6;
            zipFile2 = zipFile;
            try {
                RFixLog.e("RFix.QFixPatchInstaller", "tryInstallSoPatch fail.", th);
                return false;
            } finally {
                PatchFileUtils.closeQuietly(zipFile2);
            }
        }
    }

    @Override // com.tencent.rfix.lib.engine.b
    public boolean a(File file, File file2, RFixPatchResult rFixPatchResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, file, file2, rFixPatchResult)).booleanValue();
        }
        this.f364977b = "qfix-" + rFixPatchResult.patchIndex;
        RFixLog.i("RFix.QFixPatchInstaller", "installPatch subDirName=" + this.f364977b);
        TimeTrackType timeTrackType = TimeTrackType.PATCH_INSTALL_INSTALLER_RES;
        TimeTracker.beginTrack(timeTrackType);
        if (!c(file, file2)) {
            RFixLog.e("RFix.QFixPatchInstaller", "installPatch install res files fail.");
            rFixPatchResult.installResult = -6;
            return false;
        }
        TimeTracker.endTrack(timeTrackType);
        TimeTrackType timeTrackType2 = TimeTrackType.PATCH_INSTALL_INSTALLER_LIB;
        TimeTracker.beginTrack(timeTrackType2);
        if (!d(this.f364976a, file, this.f364977b, file2)) {
            RFixLog.e("RFix.QFixPatchInstaller", "installPatch install so files fail.");
            rFixPatchResult.installResult = -5;
            return false;
        }
        TimeTracker.endTrack(timeTrackType2);
        TimeTrackType timeTrackType3 = TimeTrackType.PATCH_INSTALL_INSTALLER_DEX;
        TimeTracker.beginTrack(timeTrackType3);
        if (!b(file, file2)) {
            RFixLog.e("RFix.QFixPatchInstaller", "installPatch install dex files fail.");
            rFixPatchResult.installResult = -1;
            return false;
        }
        TimeTracker.endTrack(timeTrackType3);
        RFixLog.i("RFix.QFixPatchInstaller", "installPatch install success.");
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
                    String str = this.f364977b + "/config.txt";
                    ZipEntry entry = zipFile2.getEntry(str);
                    if (entry == null) {
                        RFixLog.i("RFix.QFixPatchInstaller", "tryInstallDexFiles not exists " + str);
                        PatchFileUtils.closeQuietly(zipFile2);
                        return true;
                    }
                    if (!PatchFileUtils.extractZipEntry(zipFile2, entry, new File(file3, "config.txt"), null)) {
                        RFixLog.e("RFix.QFixPatchInstaller", "tryInstallDexFiles extract dex config fail.");
                        PatchFileUtils.closeQuietly(zipFile2);
                        return false;
                    }
                    if (!PatchFileUtils.checkMd5AndExtractZipEntry(zipFile2, zipFile2.getEntry(this.f364977b + "/classes.dex"), new File(file3, "classes.dex"))) {
                        RFixLog.e("RFix.QFixPatchInstaller", "tryInstallDexFiles extract dex file fail.");
                        PatchFileUtils.closeQuietly(zipFile2);
                        return false;
                    }
                    RFixLog.i("RFix.QFixPatchInstaller", "tryInstallDexFiles install dex files success.");
                    PatchFileUtils.closeQuietly(zipFile2);
                    return true;
                } catch (IOException e16) {
                    e = e16;
                    zipFile = zipFile2;
                    RFixLog.e("RFix.QFixPatchInstaller", "tryInstallDexFiles fail.", e);
                    PatchFileUtils.closeQuietly(zipFile);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    zipFile = zipFile2;
                    PatchFileUtils.closeQuietly(zipFile);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e17) {
            e = e17;
        }
    }

    @Override // com.tencent.rfix.lib.engine.b
    public String getPatchType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return RFixPatchInfo.PATCH_TYPE_QFIX;
    }
}
