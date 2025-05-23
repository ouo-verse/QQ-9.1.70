package com.tencent.mobileqq.vas.util;

import android.os.Build;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/util/VasFileCheckUtil;", "", "()V", "TAG", "", "compareCRC", "", "file", "Ljava/io/File;", "CRCMap", "", "", "", "isCheckFileEquals", "dirPath", "zipPath", "traverseFolder", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasFileCheckUtil {

    @NotNull
    public static final VasFileCheckUtil INSTANCE = new VasFileCheckUtil();

    @NotNull
    private static final String TAG = "VasFileCheckUtil";

    VasFileCheckUtil() {
    }

    private final boolean compareCRC(File file, Map<Long, Integer> CRCMap) {
        Integer num;
        long cRC32Value = IOUtil.getCRC32Value(file);
        int i3 = 0;
        if (CRCMap.containsKey(Long.valueOf(cRC32Value)) && (num = CRCMap.get(Long.valueOf(cRC32Value))) != null) {
            i3 = num.intValue();
        }
        CRCMap.put(Long.valueOf(cRC32Value), Integer.valueOf(i3 - 1));
        return true;
    }

    private final void traverseFolder(File dirPath, Map<Long, Integer> CRCMap) {
        File[] listFiles;
        if (!dirPath.exists()) {
            return;
        }
        if (dirPath.isFile()) {
            compareCRC(dirPath, CRCMap);
            return;
        }
        if (dirPath.isDirectory() && (listFiles = dirPath.listFiles()) != null) {
            for (File it : listFiles) {
                VasFileCheckUtil vasFileCheckUtil = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                vasFileCheckUtil.traverseFolder(it, CRCMap);
            }
        }
    }

    public final boolean isCheckFileEquals(@Nullable String dirPath, @Nullable String zipPath) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        Integer num;
        if (Build.VERSION.SDK_INT <= 25) {
            return true;
        }
        if (dirPath != null && zipPath != null) {
            if (dirPath.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (zipPath.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    try {
                        ZipFile zipFile = new ZipFile(zipPath);
                        try {
                            Enumeration<? extends ZipEntry> entries = zipFile.entries();
                            while (entries.hasMoreElements()) {
                                ZipEntry nextElement = entries.nextElement();
                                if (nextElement.getCrc() != 0) {
                                    if (linkedHashMap.containsKey(Long.valueOf(nextElement.getCrc())) && (num = linkedHashMap.get(Long.valueOf(nextElement.getCrc()))) != null) {
                                        i3 = num.intValue();
                                    } else {
                                        i3 = 0;
                                    }
                                    linkedHashMap.put(Long.valueOf(nextElement.getCrc()), Integer.valueOf(i3 + 1));
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(zipFile, null);
                            if (linkedHashMap.isEmpty()) {
                                QLog.e(TAG, 1, dirPath + " file is null");
                                return false;
                            }
                            traverseFolder(new File(dirPath), linkedHashMap);
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            for (Map.Entry<Long, Integer> entry : linkedHashMap.entrySet()) {
                                if (entry.getValue().intValue() > 0) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (z18) {
                                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                                }
                            }
                            return linkedHashMap2.isEmpty();
                        } finally {
                        }
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "zip error: " + zipPath + " " + e16);
                        return true;
                    }
                }
            }
        }
        QLog.e(TAG, 1, "filepath is null");
        return false;
    }
}
