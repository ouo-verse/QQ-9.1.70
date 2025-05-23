package com.tencent.mobileqq.vas.updatesystem.api;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.util.file.b;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import sw4.c;
import y13.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0006J\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/api/UpdateSystemFileCheck;", "", "isReport", "", "(Z)V", "checkBusinessList", "", "allBusiness", "", "Lcom/tencent/vas/update/callback/listener/IBusinessCallback;", "checkFileValid", "zipFile", "Ljava/io/File;", "unzipDir", "checkLocalResMd5", "findZipFileAndCheck", "rootFile", "business", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "unCompressZip", "zipFilePath", "", "unZipFilePath", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class UpdateSystemFileCheck {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean DEBUG = false;

    @NotNull
    private static final String TAG = "UpdateSystemFileCheck";
    private static final boolean deleteNoFileDb;
    private static final boolean fileCheckForAndroidN;
    private static final boolean fileMd5Check;
    private static final boolean fileNecessaryCheck;
    private static final boolean newFileCheck;
    private final boolean isReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/api/UpdateSystemFileCheck$Companion;", "", "()V", "DEBUG", "", "TAG", "", "deleteNoFileDb", "fileCheckForAndroidN", "getFileCheckForAndroidN", "()Z", "fileMd5Check", "fileNecessaryCheck", "newFileCheck", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getFileCheckForAndroidN() {
            return UpdateSystemFileCheck.fileCheckForAndroidN;
        }

        Companion() {
        }
    }

    static {
        boolean z16;
        if (Build.VERSION.SDK_INT <= 25 && !VasNtToggle.INSTANCE.getBUG_FILE_CHECK_FOR_ANDROID_N().isEnable(true)) {
            z16 = false;
        } else {
            z16 = true;
        }
        fileCheckForAndroidN = z16;
        newFileCheck = VasNtToggle.UPDATE_SYSTEM_FILE_CHECK.isEnable(true);
        fileMd5Check = VasNtToggle.UPDATE_SYSTEM_FILE_MD5_CHECK.isEnable(true);
        fileNecessaryCheck = VasNtToggle.VAS_FILE_CHECK_NECESSARY_LIST.isEnable(false);
        deleteNoFileDb = ar.INSTANCE.b("shouyouye", "2024-06-26", "vas_delete_no_file_db").isEnable(true);
    }

    public UpdateSystemFileCheck() {
        this(false, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void findZipFileAndCheck$default(UpdateSystemFileCheck updateSystemFileCheck, File file, QQVasUpdateBusiness qQVasUpdateBusiness, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            qQVasUpdateBusiness = null;
        }
        updateSystemFileCheck.findZipFileAndCheck(file, qQVasUpdateBusiness);
    }

    private final boolean unCompressZip(String zipFilePath, String unZipFilePath) {
        boolean endsWith$default;
        if (new File(zipFilePath).exists()) {
            try {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(zipFilePath, ".zip.sge", false, 2, null);
                String replace$default = endsWith$default ? StringsKt__StringsJVMKt.replace$default(zipFilePath, ".sge", "", false, 4, (Object) null) : StringsKt__StringsJVMKt.replace$default(zipFilePath, ".sge", ".zip", false, 4, (Object) null);
                FileUtils.renameFile(new File(zipFilePath), new File(replace$default));
                FileUtils.uncompressZip(replace$default, unZipFilePath, false);
                FileUtils.renameFile(new File(replace$default), new File(zipFilePath));
                QLog.d(TAG, 1, "unCompress success: " + unZipFilePath);
                return true;
            } catch (Exception e16) {
                FileUtils.deleteDirectory(unZipFilePath);
                QLog.e(TAG, 1, "unCompress error: ", e16);
                ReportInfo.report$default(VasNtCommonReporter.getFileCheck().setValue1("fileCheck").setValue2(unZipFilePath).setValue3("unCompressError"), false, 1, null);
                return false;
            }
        }
        return false;
    }

    public final void checkBusinessList(@NotNull List<? extends IBusinessCallback> allBusiness) {
        boolean z16;
        Intrinsics.checkNotNullParameter(allBusiness, "allBusiness");
        synchronized (UpdateSystemFileCheck.class) {
            for (IBusinessCallback iBusinessCallback : allBusiness) {
                if ((iBusinessCallback instanceof QQVasUpdateBusiness) && ((QQVasUpdateBusiness) iBusinessCallback).isEnableCheckFile()) {
                    String savePath = ((QQVasUpdateBusiness) iBusinessCallback).getSavePath("");
                    boolean z17 = true;
                    QLog.d(TAG, 1, "start-check " + savePath);
                    File[] filePaths = new File(savePath).listFiles();
                    if (filePaths != null) {
                        if (filePaths.length == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            z17 = false;
                        }
                    }
                    if (!z17) {
                        Intrinsics.checkNotNullExpressionValue(filePaths, "filePaths");
                        for (File it : filePaths) {
                            if (!((QQVasUpdateBusiness) iBusinessCallback).isDownloadingOrUnpacking(it.getName())) {
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                findZipFileAndCheck$default(this, it, null, 2, null);
                            }
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean checkFileValid(@NotNull File zipFile, @NotNull File unzipDir) {
        long j3;
        Intrinsics.checkNotNullParameter(zipFile, "zipFile");
        Intrinsics.checkNotNullParameter(unzipDir, "unzipDir");
        if (!unzipDir.exists()) {
            QLog.e(TAG, 1, unzipDir + " unzip dir not exist");
            return false;
        }
        if (!zipFile.exists()) {
            QLog.e(TAG, 1, zipFile + " zip file not exist");
            return false;
        }
        if (c.f449273a.b(unzipDir.getAbsolutePath(), zipFile.getAbsolutePath(), fileCheckForAndroidN)) {
            return true;
        }
        QLog.e(TAG, 1, unzipDir + ProgressTracer.SEPARATOR + zipFile + " crc is invalid");
        String absolutePath = zipFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "zipFile.absolutePath");
        String absolutePath2 = unzipDir.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "unzipDir.absolutePath");
        boolean unCompressZip = unCompressZip(absolutePath, absolutePath2);
        if (this.isReport) {
            ReportInfo value2 = VasNtCommonReporter.getFileCheck().setValue1("fileCheck").setValue2(zipFile.toString());
            if (unCompressZip) {
                j3 = 0;
            } else {
                j3 = 1;
            }
            ReportInfo.report$default(value2.setNum1(j3), false, 1, null);
        }
        return unCompressZip;
    }

    public final void checkLocalResMd5() {
        List<c.a> a16;
        int indexOf$default;
        File file;
        synchronized (UpdateSystemFileCheck.class) {
            if (fileMd5Check && (a16 = VasUpdateWrapper.getDbManager().a(0)) != null) {
                Intrinsics.checkNotNullExpressionValue(a16, "selectAllItem(Constants.DbTable.TABLE_LOCAL)");
                for (c.a aVar : a16) {
                    try {
                        String str = aVar.f434914a;
                        Intrinsics.checkNotNullExpressionValue(str, "it.itemId");
                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "_", 0, false, 6, (Object) null);
                        if (indexOf$default > 0) {
                            String str2 = aVar.f434914a;
                            Intrinsics.checkNotNullExpressionValue(str2, "it.itemId");
                            String substring = str2.substring(indexOf$default + 1);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                            String str3 = aVar.f434914a;
                            Intrinsics.checkNotNullExpressionValue(str3, "it.itemId");
                            String substring2 = str3.substring(0, indexOf$default);
                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                            long parseLong = Long.parseLong(substring2);
                            if (parseLong != 1000 && parseLong != 16) {
                                QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(parseLong));
                                if (businessInstance.isEnableCheckFile()) {
                                    BusinessItemInfo businessItemInfo = businessInstance.getBusinessItemInfo(parseLong, substring);
                                    if (!businessInstance.isDownloadingOrUnpacking(substring)) {
                                        if (businessItemInfo.mSaveInDir) {
                                            file = new File(new File(businessItemInfo.mSavePath), aVar.f434914a + ".sge");
                                        } else {
                                            file = new File(businessItemInfo.mSavePath);
                                        }
                                        if (file.exists()) {
                                            String b16 = b.f362981a.b(file.getAbsolutePath());
                                            String md5 = new JSONObject(aVar.f434915b).optString("md5");
                                            Locale locale = Locale.ROOT;
                                            String lowerCase = b16.toLowerCase(locale);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                            Intrinsics.checkNotNullExpressionValue(md5, "md5");
                                            String lowerCase2 = md5.toLowerCase(locale);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                            if (!TextUtils.equals(lowerCase, lowerCase2)) {
                                                VasNtCommonReporter.getFileCheck().setValue1("md5_check_no_equal").setValue2(file.getAbsolutePath()).setValue3(substring).setValue4(b16).setValue5(md5).report(true);
                                                FileUtils.deleteFile(file.getParent());
                                            }
                                        } else {
                                            if (deleteNoFileDb) {
                                                VasUpdateWrapper.getDbManager().c(0, aVar.f434914a);
                                            }
                                            VasUpdateWrapper.getDbManager().c(1, aVar.f434914a);
                                            VasNtCommonReporter.getFileCheck().setValue1("md5_check_file_no_found").setValue2(file.getAbsolutePath()).setValue3(substring).report(true);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e16) {
                        QLog.i(TAG, 1, "checkLocalResMd5 exception: " + e16.getMessage());
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void findZipFileAndCheck(@NotNull File rootFile, @Nullable QQVasUpdateBusiness<?> business) {
        boolean z16;
        boolean endsWith$default;
        boolean z17;
        Intrinsics.checkNotNullParameter(rootFile, "rootFile");
        if (!rootFile.isDirectory()) {
            return;
        }
        File[] fileFiles = rootFile.listFiles();
        boolean z18 = false;
        if (fileFiles != null) {
            if (fileFiles.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = false;
                if (!z16) {
                    if (newFileCheck) {
                        QLog.e(TAG, 1, "remove empty file " + rootFile);
                        FileUtils.deleteFile(rootFile);
                        ReportInfo.report$default(VasNtCommonReporter.getFileCheck().setValue1("remove-empty").setValue2(rootFile.getName()), false, 1, null);
                        return;
                    }
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(fileFiles, "fileFiles");
                int length = fileFiles.length;
                int i3 = 0;
                boolean z19 = false;
                while (i3 < length) {
                    File file = fileFiles[i3];
                    String name = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "file.name");
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(name, ".sge", z18, 2, null);
                    if (endsWith$default) {
                        Intrinsics.checkNotNullExpressionValue(file, "file");
                        if (checkFileValid(file, rootFile) && fileNecessaryCheck && business != null) {
                            String name2 = file.getName();
                            Intrinsics.checkNotNullExpressionValue(name2, "file.name");
                            String substring = name2.substring((business.getBid() + "_").length(), file.getName().length() - 4);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                            business.checkFileAvailable(substring, 2);
                        }
                        z19 = true;
                    }
                    if (!newFileCheck) {
                        Intrinsics.checkNotNullExpressionValue(file, "file");
                        findZipFileAndCheck(file, business);
                    }
                    i3++;
                    z18 = false;
                }
                if (newFileCheck && !z19) {
                    QLog.e(TAG, 1, "remove no sge file " + rootFile);
                    FileUtils.deleteFile(rootFile);
                    ReportInfo.report$default(VasNtCommonReporter.getFileCheck().setValue1("remove-no-sge").setValue2(rootFile.getName()), false, 1, null);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public UpdateSystemFileCheck(boolean z16) {
        this.isReport = z16;
    }

    public /* synthetic */ UpdateSystemFileCheck(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16);
    }
}
