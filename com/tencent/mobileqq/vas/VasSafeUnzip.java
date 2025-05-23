package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.utils.VasCommonUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.log.SLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J*\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\rH\u0007J&\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\rH\u0007J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/VasSafeUnzip;", "", "()V", "TAG", "", "deleteDirectoryContent", "", "dirStr", "holdFileList", "", "tier", "", "isCanDeleteOldDir", "", "dstPath", "srcFile", "Ljava/io/File;", "safeUnZipFile", "file", "isDeleteOldDir", "tryUnzip", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasSafeUnzip {

    @NotNull
    public static final VasSafeUnzip INSTANCE = new VasSafeUnzip();

    @NotNull
    public static final String TAG = "VasSafeUnzip";

    static {
        if (VasCommonUtils.INSTANCE.isMainProcess()) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.aq
                @Override // java.lang.Runnable
                public final void run() {
                    VasSafeUnzip._init_$lambda$1();
                }
            }, 16, null, false, 5000L);
        }
    }

    VasSafeUnzip() {
    }

    public static final void _init_$lambda$1() {
        VasMMKVProxy safeUnzip = VipNtMMKV.INSTANCE.getSafeUnzip();
        List<String> allKey = safeUnzip.allKey();
        if (allKey.isEmpty()) {
            return;
        }
        for (String str : allKey) {
            String decodeString = safeUnzip.decodeString(str, "");
            QLog.w(TAG, 1, "delete error zip file");
            try {
                ReportInfo.report$default(VasNtCommonReporter.getSafeUnzip().setValue1("delete2").setValue2(SLog.LOG_TAG).setValue3(decodeString), false, 1, null);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
            safeUnzip.removeKey(str);
        }
    }

    private final void deleteDirectoryContent(String dirStr, List<String> holdFileList) {
        deleteDirectoryContent(dirStr, holdFileList, 0);
    }

    static /* synthetic */ void deleteDirectoryContent$default(VasSafeUnzip vasSafeUnzip, String str, List list, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        vasSafeUnzip.deleteDirectoryContent(str, list, i3);
    }

    private final boolean isCanDeleteOldDir(String dstPath, File srcFile) {
        boolean endsWith$default;
        boolean endsWith$default2;
        String name = srcFile.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(name, ".sge", false, 2, null);
        if (endsWith$default) {
            Intrinsics.checkNotNullExpressionValue(name, "name");
            name = name.substring(0, name.length() - 4);
            Intrinsics.checkNotNullExpressionValue(name, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        File file = new File(dstPath);
        Intrinsics.checkNotNullExpressionValue(name, "name");
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "file.name");
        endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(name, name2, false, 2, null);
        if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
            QLog.i("VasSafeUnzip_DELETE", 1, "isCanDeleteOldDir result: " + endsWith$default2 + " src:" + srcFile.getAbsolutePath());
        }
        return endsWith$default2;
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final String safeUnZipFile(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return safeUnZipFile$default(file, null, false, 6, null);
    }

    public static /* synthetic */ String safeUnZipFile$default(File file, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return safeUnZipFile(file, z16);
    }

    private final String tryUnzip(File file, String dstPath) {
        ZipFile zipFile;
        boolean contains$default;
        try {
            zipFile = new ZipFile(file);
        } catch (Throwable th5) {
            th = th5;
            zipFile = null;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            Intrinsics.checkNotNullExpressionValue(entries, "zipFile.entries()");
            byte[] bArr = new byte[8192];
            String str = null;
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                Intrinsics.checkNotNull(nextElement, "null cannot be cast to non-null type java.util.zip.ZipEntry");
                ZipEntry zipEntry = nextElement;
                String szName = zipEntry.getName();
                if (!TextUtils.isEmpty(szName)) {
                    Intrinsics.checkNotNullExpressionValue(szName, "szName");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) szName, (CharSequence) "..", false, 2, (Object) null);
                    if (!contains$default) {
                        if (zipEntry.isDirectory()) {
                            File file2 = new File(dstPath, zipEntry.getName());
                            String absolutePath = file2.getAbsolutePath();
                            file2.mkdirs();
                            QLog.d(TAG, 4, "unzip dir name = " + ((Object) absolutePath));
                            str = absolutePath;
                        } else {
                            File file3 = new File(dstPath, zipEntry.getName());
                            File parentFile = file3.getParentFile();
                            if (parentFile != null) {
                                parentFile.mkdirs();
                            }
                            if (file3.exists()) {
                                file3.delete();
                            }
                            String absolutePath2 = file3.getAbsolutePath();
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                            try {
                                InputStream inputStream = zipFile.getInputStream(zipEntry);
                                while (true) {
                                    try {
                                        int read = inputStream.read(bArr, 0, 8192);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, read);
                                    } catch (Throwable th6) {
                                        try {
                                            throw th6;
                                        } catch (Throwable th7) {
                                            CloseableKt.closeFinally(inputStream, th6);
                                            throw th7;
                                        }
                                    }
                                }
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(inputStream, null);
                                CloseableKt.closeFinally(bufferedOutputStream, null);
                                str = absolutePath2;
                            } finally {
                            }
                        }
                    }
                }
            }
            try {
                zipFile.close();
            } catch (Throwable th8) {
                QLog.e(TAG, 1, th8, new Object[0]);
            }
            return str;
        } catch (Throwable th9) {
            th = th9;
            try {
                QLog.e(TAG, 1, "unZipFile error: ", th);
                if (zipFile == null) {
                    return null;
                }
                try {
                    zipFile.close();
                    return null;
                } catch (Throwable th10) {
                    QLog.e(TAG, 1, th10, new Object[0]);
                    return null;
                }
            } catch (Throwable th11) {
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (Throwable th12) {
                        QLog.e(TAG, 1, th12, new Object[0]);
                    }
                }
                throw th11;
            }
        }
    }

    private final void deleteDirectoryContent(String dirStr, List<String> holdFileList, int tier) {
        if (dirStr != null) {
            int length = dirStr.length() - 1;
            int i3 = 0;
            boolean z16 = false;
            while (i3 <= length) {
                boolean z17 = Intrinsics.compare((int) dirStr.charAt(!z16 ? i3 : length), 32) <= 0;
                if (z16) {
                    if (!z17) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z17) {
                    i3++;
                } else {
                    z16 = true;
                }
            }
            if (dirStr.subSequence(i3, length + 1).toString().length() == 0) {
                return;
            }
            File file = new File(dirStr);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (true ^ (listFiles.length == 0)) {
                        int length2 = listFiles.length;
                        for (int i16 = 0; i16 < length2; i16++) {
                            if (listFiles[i16].isDirectory()) {
                                deleteDirectoryContent(listFiles[i16].getAbsolutePath(), holdFileList, tier + 1);
                            } else {
                                File file2 = listFiles[i16];
                                Intrinsics.checkNotNullExpressionValue(file2, "childDirList[i]");
                                if (!holdFileList.contains(file2.getAbsolutePath())) {
                                    listFiles[i16].delete();
                                }
                            }
                        }
                    }
                }
                if (tier != 0) {
                    file.delete();
                }
            }
        }
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final String safeUnZipFile(@NotNull File file, @NotNull String dstPath) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(dstPath, "dstPath");
        return safeUnZipFile$default(file, dstPath, false, 4, null);
    }

    public static /* synthetic */ String safeUnZipFile$default(File file, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = file.getParent();
            Intrinsics.checkNotNullExpressionValue(str, "file.parent");
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return safeUnZipFile(file, str, z16);
    }

    @JvmStatic
    @Nullable
    public static final String safeUnZipFile(@NotNull File file, boolean isDeleteOldDir) {
        Intrinsics.checkNotNullParameter(file, "file");
        String parent = file.getParent();
        Intrinsics.checkNotNullExpressionValue(parent, "file.parent");
        return safeUnZipFile(file, parent, isDeleteOldDir);
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final String safeUnZipFile(@NotNull File file, @NotNull String dstPath, boolean isDeleteOldDir) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(dstPath, "dstPath");
        String valueOf = String.valueOf(dstPath.hashCode());
        VasMMKVProxy safeUnzip = VipNtMMKV.INSTANCE.getSafeUnzip();
        safeUnzip.encodeString(valueOf, dstPath);
        if (isDeleteOldDir) {
            VasSafeUnzip vasSafeUnzip = INSTANCE;
            if (vasSafeUnzip.isCanDeleteOldDir(dstPath, file)) {
                try {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(file.getAbsolutePath());
                    Unit unit = Unit.INSTANCE;
                    vasSafeUnzip.deleteDirectoryContent(dstPath, arrayList);
                } catch (IOException e16) {
                    QLog.e(TAG, 1, "safeUnZipFile DeleteOldDir", e16);
                }
            }
        }
        String tryUnzip = INSTANCE.tryUnzip(file, dstPath);
        if (tryUnzip == null) {
            try {
                ReportInfo.report$default(VasNtCommonReporter.getSafeUnzip().setValue1("delete2").setValue2("sync").setValue3(dstPath), false, 1, null);
                safeUnzip.removeKey(valueOf);
            } catch (Exception e17) {
                QLog.e(TAG, 1, e17, new Object[0]);
            }
        } else {
            safeUnzip.removeKey(valueOf);
        }
        return tryUnzip;
    }
}
