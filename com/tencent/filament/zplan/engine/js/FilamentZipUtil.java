package com.tencent.filament.zplan.engine.js;

import androidx.annotation.Keep;
import com.tencent.filament.zplanservice.util.log.FLog;
import io.github.landerlyoung.jenny.NativeProxy;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplan/engine/js/FilamentZipUtil;", "", "()V", "TAG", "", "createFile", "Ljava/io/File;", "filePath", "doZip", "", "zos", "Ljava/util/zip/ZipOutputStream;", "file", "parentDirName", "buffer", "", "unzip", "", "zipFilePath", "folderPath", "zipByFolder", "fileDir", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentZipUtil {

    @NotNull
    public static final FilamentZipUtil INSTANCE = new FilamentZipUtil();
    private static final String TAG = "ZPlanZipUtil";

    FilamentZipUtil() {
    }

    private final File createFile(String filePath) {
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        Intrinsics.checkNotNull(parentFile);
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    private final void doZip(ZipOutputStream zos, File file, String parentDirName, byte[] buffer) {
        boolean z16;
        String str;
        File[] listFiles;
        if (parentDirName != null && parentDirName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = file.getName();
        } else {
            str = parentDirName + File.separator + file.getName();
        }
        if (file.isFile()) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                try {
                    zos.putNextEntry(new ZipEntry(str));
                    while (true) {
                        int read = bufferedInputStream.read(buffer, 0, buffer.length);
                        Unit unit = Unit.INSTANCE;
                        if (-1 == read) {
                            break;
                        } else {
                            zos.write(buffer, 0, read);
                        }
                    }
                } catch (IOException e16) {
                    FLog.INSTANCE.e(TAG, "doZip fail. filePath:" + file.getPath() + " error: ", e16);
                }
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedInputStream, null);
                return;
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(bufferedInputStream, th5);
                    throw th6;
                }
            }
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File element : listFiles) {
                Intrinsics.checkNotNullExpressionValue(element, "element");
                doZip(zos, element, str, buffer);
            }
        }
    }

    @JvmStatic
    public static final boolean unzip(@NotNull String zipFilePath, @NotNull String folderPath) {
        char last;
        String str;
        ZipFile zipFile;
        boolean contains$default;
        BufferedOutputStream bufferedOutputStream;
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        last = StringsKt___StringsKt.last(folderPath);
        if (last != File.separatorChar) {
            str = folderPath + File.separatorChar;
        } else {
            str = folderPath;
        }
        try {
            try {
                zipFile = new ZipFile(zipFilePath);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    byte[] bArr = new byte[8192];
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        if (nextElement != null) {
                            ZipEntry zipEntry = nextElement;
                            String name = zipEntry.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "ze.name");
                            Enumeration<? extends ZipEntry> enumeration = entries;
                            InputStream inputStream = null;
                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "..", false, 2, (Object) null);
                            if (!contains$default) {
                                if (zipEntry.isDirectory()) {
                                    String str2 = str + zipEntry.getName();
                                    Charset forName = Charset.forName("8859_1");
                                    Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
                                    if (str2 != null) {
                                        byte[] bytes = str2.getBytes(forName);
                                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                                        Charset forName2 = Charset.forName("GB2312");
                                        Intrinsics.checkNotNullExpressionValue(forName2, "Charset.forName(charsetName)");
                                        new File(new String(bytes, forName2)).mkdir();
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                } else {
                                    File file = new File(str + zipEntry.getName());
                                    File parentFile = file.getParentFile();
                                    if (parentFile != null) {
                                        parentFile.mkdirs();
                                    }
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                    } catch (Throwable th5) {
                                        th = th5;
                                        bufferedOutputStream = null;
                                    }
                                    try {
                                        inputStream = zipFile.getInputStream(zipEntry);
                                        while (true) {
                                            int read = inputStream.read(bArr, 0, 8192);
                                            if (read != -1) {
                                                bufferedOutputStream.write(bArr, 0, read);
                                            } else {
                                                try {
                                                    break;
                                                } catch (IOException unused) {
                                                }
                                            }
                                        }
                                        inputStream.close();
                                        try {
                                            bufferedOutputStream.flush();
                                            bufferedOutputStream.close();
                                        } catch (IOException unused2) {
                                        }
                                        entries = enumeration;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused3) {
                                            }
                                        }
                                        if (bufferedOutputStream != null) {
                                            try {
                                                bufferedOutputStream.flush();
                                                bufferedOutputStream.close();
                                                throw th;
                                            } catch (IOException unused4) {
                                                throw th;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                            entries = enumeration;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.util.zip.ZipEntry");
                        }
                    }
                    zipFile.close();
                    return true;
                } catch (Exception e16) {
                    FLog.INSTANCE.e(TAG, "unzip fail. zipFilePath:" + zipFilePath + ", folderPath:" + folderPath + ". error: ", e16);
                    zipFile.close();
                    return false;
                }
            } catch (Exception e17) {
                FLog.INSTANCE.e(TAG, "unzip fail. zipFilePath:" + zipFilePath + ", folderPath:" + folderPath + ". error: ", e17);
                return false;
            }
        } catch (Throwable th7) {
            zipFile.close();
            throw th7;
        }
    }

    public final boolean zipByFolder(@NotNull String fileDir, @NotNull String zipFilePath) {
        Intrinsics.checkNotNullParameter(fileDir, "fileDir");
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        File createFile = createFile(zipFilePath);
        File file = new File(fileDir);
        boolean z16 = false;
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        byte[] bArr = new byte[4096];
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createFile, false)));
        try {
            try {
                for (File file2 : file.listFiles()) {
                    FilamentZipUtil filamentZipUtil = INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(file2, "file");
                    filamentZipUtil.doZip(zipOutputStream, file2, null, bArr);
                }
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                z16 = true;
            } catch (IOException e16) {
                FLog.INSTANCE.e(TAG, "zipByFolder fail. fileDir:" + fileDir + ", zipFilePath:" + zipFilePath + " error: ", e16);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zipOutputStream, null);
            return z16;
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(zipOutputStream, th5);
                throw th6;
            }
        }
    }
}
