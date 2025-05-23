package com.tencent.qne.util;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import cooperation.qzone.util.WiFiDash;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0000\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0000\u001a\u0016\u0010\t\u001a\u00020\u0002*\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0000\u001a\f\u0010\u000b\u001a\u00020\n*\u0004\u0018\u00010\u0000\u001a\f\u0010\f\u001a\u00020\u0002*\u0004\u0018\u00010\u0000\u001a\f\u0010\r\u001a\u00020\u0002*\u0004\u0018\u00010\u0000\u001a\n\u0010\u000f\u001a\u00020\u0000*\u00020\u000e\u00a8\u0006\u0010"}, d2 = {"", "folderPath", "", h.F, WadlProxyConsts.PARAM_FILENAME, "e", "Lorg/json/JSONObject;", "d", "path", "f", "", "a", "c", "b", "", "g", "qne_debug"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final class a {
    public static final void a(@Nullable String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            FilesKt__UtilsKt.deleteRecursively(file);
        }
    }

    public static final boolean b(@Nullable String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return false;
    }

    public static final boolean c(@Nullable String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

    @Nullable
    public static final JSONObject d(@Nullable String str) {
        boolean z16;
        String readText$default;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            try {
                readText$default = FilesKt__FileReadWriteKt.readText$default(new File(str), null, 1, null);
                return new JSONObject(readText$default);
            } catch (Throwable th5) {
                Logger.e("[qne]ZipUtil", Intrinsics.stringPlus("fileToJson exception, file:", str), th5);
                return null;
            }
        }
        return null;
    }

    @Nullable
    public static final String e(@Nullable String str, @NotNull String fileName) {
        boolean z16;
        File[] listFiles;
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        boolean z17 = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && (listFiles = new File(str).listFiles()) != null) {
            if (listFiles.length != 0) {
                z17 = false;
            }
            if (!z17) {
                for (File file : listFiles) {
                    String name = file.getName();
                    if (name != null) {
                        int hashCode = name.hashCode();
                        if (hashCode != -1256690875) {
                            if (hashCode != 46) {
                                if (hashCode == 1472 && name.equals("..")) {
                                }
                            } else if (name.equals(".")) {
                                continue;
                            }
                        } else if (name.equals("__MACOSX")) {
                            continue;
                        }
                    }
                    String path = file.getAbsolutePath();
                    if (file.isDirectory()) {
                        String e16 = e(path, fileName);
                        if (e16 != null) {
                            return e16;
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(path, "path");
                        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(path, fileName, false, 2, null);
                        if (endsWith$default) {
                            return path;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static final boolean f(@Nullable JSONObject jSONObject, @Nullable String str) {
        boolean z16;
        if (jSONObject == null) {
            return false;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        try {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "this.toString()");
            FilesKt__FileReadWriteKt.writeText$default(new File(str), jSONObject2, null, 2, null);
            return true;
        } catch (Throwable th5) {
            Logger.e("[qne]ZipUtil", Intrinsics.stringPlus("jsonToFile exception, path:", str), th5);
            return false;
        }
    }

    @NotNull
    public static final String g(long j3) {
        if (j3 != Long.MIN_VALUE && j3 >= 0) {
            if (j3 < 1024) {
                return j3 + " B";
            }
            if (j3 <= 1048524) {
                String format = String.format("%.1f KB", Arrays.copyOf(new Object[]{Double.valueOf(j3 / 1024)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
                return format;
            }
            if (j3 <= 1073689395) {
                String format2 = String.format("%.1f MB", Arrays.copyOf(new Object[]{Double.valueOf(j3 / 1048576)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(this, *args)");
                return format2;
            }
            if (j3 <= 1099457940684L) {
                String format3 = String.format("%.1f GB", Arrays.copyOf(new Object[]{Double.valueOf(j3 / 1073741824)}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(this, *args)");
                return format3;
            }
            if (j3 <= 1125844931261235L) {
                String format4 = String.format("%.1f TB", Arrays.copyOf(new Object[]{Double.valueOf(j3 / 256)}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(this, *args)");
                return format4;
            }
            if (j3 <= 1152865209611504844L) {
                String format5 = String.format("%.1f PB", Arrays.copyOf(new Object[]{Double.valueOf((j3 >> 10) / 256)}, 1));
                Intrinsics.checkNotNullExpressionValue(format5, "java.lang.String.format(this, *args)");
                return format5;
            }
            String format6 = String.format("%.1f EB", Arrays.copyOf(new Object[]{Double.valueOf((j3 >> 20) / 256)}, 1));
            Intrinsics.checkNotNullExpressionValue(format6, "java.lang.String.format(this, *args)");
            return format6;
        }
        return WiFiDash.NOT_AVALIBLE;
    }

    public static final boolean h(@NotNull String str, @NotNull String folderPath) {
        Iterator it;
        Sequence<ZipEntry> asSequence;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        try {
            ZipFile zipFile = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                Intrinsics.checkNotNullExpressionValue(entries, "zip.entries()");
                it = CollectionsKt__IteratorsJVMKt.iterator(entries);
                asSequence = SequencesKt__SequencesKt.asSequence(it);
                for (ZipEntry zipEntry : asSequence) {
                    String entryName = zipEntry.getName();
                    Intrinsics.checkNotNullExpressionValue(entryName, "entryName");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) entryName, (CharSequence) "..", false, 2, (Object) null);
                    if (!contains$default) {
                        File file = new File(folderPath, entryName);
                        if (zipEntry.isDirectory()) {
                            file.mkdirs();
                        } else {
                            File parentFile = file.getParentFile();
                            if (parentFile != null) {
                                parentFile.mkdirs();
                            }
                            InputStream input = zipFile.getInputStream(zipEntry);
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                try {
                                    Intrinsics.checkNotNullExpressionValue(input, "input");
                                    ByteStreamsKt.copyTo(input, fileOutputStream, 8192);
                                    CloseableKt.closeFinally(fileOutputStream, null);
                                    CloseableKt.closeFinally(input, null);
                                } finally {
                                }
                            } finally {
                            }
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(zipFile, null);
                return true;
            } finally {
            }
        } catch (Throwable th5) {
            Logger.e("[qne]ZipUtil", "Unzip failed. zipFilePath: " + str + ", folderPath: " + folderPath + '.', th5);
            return false;
        }
    }
}
