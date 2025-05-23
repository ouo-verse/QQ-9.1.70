package com.tencent.bugly.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ams.dsdk.utils.DBHelper;
import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.rmonitor.common.logger.Logger;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/bugly/common/utils/FileUtil;", "", "()V", "Companion", "IStreamListener", "MmapFile", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class FileUtil {
    private static String SDPath = null;
    private static final String TAG = "Bugly_FileUtil";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String RMONITOR_ROOT = "";

    @Nullable
    private static Context app = ContextUtil.getGlobalContext();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u0012H\u0007J\u0014\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J$\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\"2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u0004H\u0007J\u0012\u0010'\u001a\u00020(2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010)\u001a\u00020(2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0007J\n\u0010*\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010+\u001a\u00020\u0004H\u0007J\b\u0010,\u001a\u00020\u0004H\u0007J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0004H\u0007J\u001c\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u00042\b\b\u0002\u00101\u001a\u00020\u0004H\u0007J\u0012\u00102\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u000208H\u0007J\u001a\u00104\u001a\u00020\u00042\u0006\u00109\u001a\u00020:2\b\b\u0002\u00107\u001a\u000208H\u0007J\u001c\u0010;\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010<\u001a\u0004\u0018\u00010=H\u0007J\u001c\u0010;\u001a\u00020\u00172\b\u0010>\u001a\u0004\u0018\u0001062\b\u0010<\u001a\u0004\u0018\u00010=H\u0007J$\u0010?\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010@\u001a\u0004\u0018\u0001062\u0006\u0010\u001f\u001a\u00020\u0012H\u0007J$\u0010?\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010\u001f\u001a\u00020\u0012H\u0007J$\u0010?\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010A\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u0012H\u0007J\"\u0010C\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\b\b\u0002\u0010E\u001a\u00020\u0012H\u0007J*\u0010C\u001a\u00020\u00122\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010%2\u0006\u0010D\u001a\u00020\u00042\b\b\u0002\u0010E\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006G"}, d2 = {"Lcom/tencent/bugly/common/utils/FileUtil$Companion;", "", "()V", "RMONITOR_ROOT", "", "SDPath", "TAG", "app", "Landroid/content/Context;", "getApp", "()Landroid/content/Context;", "setApp", "(Landroid/content/Context;)V", "copyFile", "Ljava/io/File;", TtmlNode.ATTR_TTS_ORIGIN, "dist", "createFile", "", "filePath", "path", WadlProxyConsts.PARAM_FILENAME, "deleteFile", "", "file", "deleteFolder", DBHelper.COL_FOLDER, "getExternalStorageDirectory", "getFileBufferStream", "Ljava/io/BufferedOutputStream;", "fileStr", "isAppend", "getFileParentPath", "getFiles", "Ljava/util/ArrayList;", "reg", "getFilesInDir", "", QzoneZipCacheHelper.DIR, "getFolderSize", "", "getLastModifiedTime", "getProcessDir", "getRootPath", "getTempPath", "loadLibrary", "soPath", "makeTempFileName", "prefix", "suffix", "readOutputFromFile", "pathToFile", "readStream", "inputStream", "Ljava/io/InputStream;", "bufferSize", "", "inputStreamReader", "Ljava/io/InputStreamReader;", "readStreamByLine", "listener", "Lcom/tencent/bugly/common/utils/FileUtil$IStreamListener;", "stream", "writeFile", "input", "text", "", "zipFiles", "outputPath", "isGzip", "allFiles", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        private final String getExternalStorageDirectory() {
            File file;
            File file2;
            String str;
            if (!TextUtils.isEmpty(FileUtil.SDPath)) {
                return FileUtil.SDPath;
            }
            String str2 = null;
            try {
                Context app = getApp();
                if (app != null) {
                    file2 = app.getExternalFilesDir("/Tencent/RMonitor");
                } else {
                    file2 = null;
                }
                if (file2 != null) {
                    str = file2.getAbsolutePath();
                } else {
                    str = null;
                }
                FileUtil.SDPath = str;
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            try {
                if (FileUtil.SDPath == null) {
                    Context app2 = getApp();
                    if (app2 != null) {
                        file = app2.getDir("Tencent_RMonitor", 0);
                    } else {
                        file = null;
                    }
                    if (file != null) {
                        str2 = file.getAbsolutePath();
                    }
                    FileUtil.SDPath = str2;
                }
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
            FileUtil.SDPath = Intrinsics.stringPlus(FileUtil.SDPath, File.separator + getProcessDir());
            String currentProcessName = ProcessUtil.INSTANCE.getCurrentProcessName(getApp());
            Logger.f365497g.i(FileUtil.TAG, "Process: " + currentProcessName + " ,SDPath: " + FileUtil.SDPath);
            String str3 = FileUtil.SDPath;
            if (str3 == null) {
                return "";
            }
            return str3;
        }

        private final String getProcessDir() {
            boolean contains$default;
            int lastIndexOf$default;
            try {
                if (getApp() == null) {
                    return "main";
                }
                ProcessUtil.Companion companion = ProcessUtil.INSTANCE;
                if (companion.isMainProcess(getApp())) {
                    return "main";
                }
                String currentProcessName = companion.getCurrentProcessName(getApp());
                Charset charset = Charsets.UTF_8;
                if (currentProcessName != null) {
                    byte[] bytes = currentProcessName.getBytes(charset);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    String md5 = MD5Utils.getMD5(bytes);
                    if (md5 == null) {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) currentProcessName, (CharSequence) ":", false, 2, (Object) null);
                        if (!contains$default) {
                            return "main";
                        }
                        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) currentProcessName, ":", 0, false, 6, (Object) null);
                        String substring = currentProcessName.substring(lastIndexOf$default + 1);
                        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                        return substring;
                    }
                    return md5;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } catch (Throwable th5) {
                th5.printStackTrace();
                return "main";
            }
        }

        public static /* synthetic */ String makeTempFileName$default(Companion companion, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = FaceUtil.IMG_TEMP;
            }
            if ((i3 & 2) != 0) {
                str2 = "zip";
            }
            return companion.makeTempFileName(str, str2);
        }

        public static /* synthetic */ String readStream$default(Companion companion, InputStream inputStream, int i3, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                i3 = 4096;
            }
            return companion.readStream(inputStream, i3);
        }

        public static /* synthetic */ boolean zipFiles$default(Companion companion, List list, String str, boolean z16, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            return companion.zipFiles((List<String>) list, str, z16);
        }

        @JvmStatic
        @Nullable
        public final File copyFile(@NotNull File origin, @NotNull File dist) {
            File copyTo$default;
            Intrinsics.checkParameterIsNotNull(origin, "origin");
            Intrinsics.checkParameterIsNotNull(dist, "dist");
            try {
                copyTo$default = FilesKt__UtilsKt.copyTo$default(origin, dist, true, 0, 4, null);
                return copyTo$default;
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }

        @JvmStatic
        public final boolean createFile(@Nullable String path, @Nullable String fileName) {
            if (path == null || fileName == null) {
                return false;
            }
            return createFile(new File(path, fileName).getAbsolutePath());
        }

        @JvmStatic
        public final void deleteFile(@Nullable File file) {
            File[] fileArr;
            if (file != null && file.exists()) {
                if (file.isFile()) {
                    try {
                        file.delete();
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                try {
                    fileArr = file.listFiles();
                } catch (Throwable unused2) {
                    fileArr = null;
                }
                if (fileArr != null) {
                    for (File file2 : fileArr) {
                        FileUtil.INSTANCE.deleteFile(file2);
                    }
                }
                try {
                    file.delete();
                } catch (Throwable unused3) {
                }
            }
        }

        @JvmStatic
        public final void deleteFolder(@Nullable File folder) {
            if (folder != null && folder.isDirectory()) {
                File[] listFiles = folder.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        Intrinsics.checkExpressionValueIsNotNull(file, "file");
                        if (file.isFile()) {
                            file.delete();
                        } else {
                            FileUtil.INSTANCE.deleteFolder(file);
                        }
                    }
                }
                folder.delete();
            }
        }

        @Nullable
        public final Context getApp() {
            return FileUtil.app;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        
            r0 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(r7, r8), 8192);
         */
        @JvmStatic
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final synchronized BufferedOutputStream getFileBufferStream(@Nullable String fileStr, boolean isAppend) {
            boolean z16;
            BufferedOutputStream bufferedOutputStream = null;
            if (fileStr == null) {
                return null;
            }
            try {
                File file = new File(fileStr);
                File parentFile = file.getParentFile();
                boolean z17 = true;
                if (parentFile != null && (parentFile.exists() || parentFile.mkdirs())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if ((!z16 || !file.exists()) && !file.createNewFile()) {
                    z17 = false;
                }
                return bufferedOutputStream;
            } catch (IOException e16) {
                e16.printStackTrace();
                return null;
            }
        }

        @JvmStatic
        @Nullable
        public final String getFileParentPath(@Nullable String filePath) {
            if (filePath != null) {
                return new File(filePath).getParent();
            }
            return null;
        }

        @JvmStatic
        @Nullable
        public final ArrayList<File> getFiles(@Nullable String filePath, @Nullable String reg) {
            File file;
            ArrayList<File> arrayList = null;
            if (filePath != null) {
                file = new File(filePath);
            } else {
                file = null;
            }
            if (file != null && file.exists()) {
                File[] listFiles = file.listFiles();
                arrayList = new ArrayList<>();
                if (listFiles != null) {
                    if (TextUtils.isEmpty(reg)) {
                        Collections.addAll(arrayList, (File[]) Arrays.copyOf(listFiles, listFiles.length));
                    } else {
                        int length = listFiles.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            if (reg != null) {
                                File file2 = listFiles[i3];
                                Intrinsics.checkExpressionValueIsNotNull(file2, "this[i]");
                                if (Pattern.matches(reg, file2.getName())) {
                                    arrayList.add(listFiles[i3]);
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0011, code lost:
        
            r2 = kotlin.collections.ArraysKt___ArraysKt.asSequence(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        
            r2 = kotlin.sequences.SequencesKt___SequencesKt.filter(r2, com.tencent.bugly.common.utils.FileUtil$Companion$getFilesInDir$1.INSTANCE);
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
        
            r2 = kotlin.sequences.SequencesKt___SequencesKt.filter(r2, com.tencent.bugly.common.utils.FileUtil$Companion$getFilesInDir$2.INSTANCE);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        
            r2 = kotlin.sequences.SequencesKt___SequencesKt.map(r2, com.tencent.bugly.common.utils.FileUtil$Companion$getFilesInDir$3.INSTANCE);
         */
        @JvmStatic
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List<String> getFilesInDir(@NotNull String dir) {
            Sequence asSequence;
            Sequence filter;
            Sequence filter2;
            Sequence map;
            List<String> list;
            Intrinsics.checkParameterIsNotNull(dir, "dir");
            File[] listFiles = new File(dir).listFiles();
            if (listFiles != null && asSequence != null && filter != null && filter2 != null && map != null) {
                list = SequencesKt___SequencesKt.toList(map);
                return list;
            }
            return null;
        }

        @JvmStatic
        public final long getFolderSize(@Nullable File folder) {
            File[] listFiles;
            long folderSize;
            long j3 = 0;
            if (folder != null && folder.isDirectory() && (listFiles = folder.listFiles()) != null) {
                for (File file : listFiles) {
                    Intrinsics.checkExpressionValueIsNotNull(file, "file");
                    if (file.isFile()) {
                        folderSize = file.length();
                    } else {
                        folderSize = FileUtil.INSTANCE.getFolderSize(file);
                    }
                    j3 += folderSize;
                }
            }
            return j3;
        }

        @JvmStatic
        public final long getLastModifiedTime(@Nullable File file) {
            if (file != null) {
                return file.lastModified();
            }
            return -1L;
        }

        @JvmStatic
        @NotNull
        public final String getRootPath() {
            boolean z16;
            if (FileUtil.RMONITOR_ROOT.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String externalStorageDirectory = getExternalStorageDirectory();
                if (externalStorageDirectory == null) {
                    externalStorageDirectory = "";
                }
                FileUtil.RMONITOR_ROOT = externalStorageDirectory;
            }
            return FileUtil.RMONITOR_ROOT;
        }

        @JvmStatic
        @NotNull
        public final String getTempPath() {
            boolean endsWith$default;
            String rootPath = getRootPath();
            String str = File.separator;
            Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(rootPath, str, false, 2, null);
            if (endsWith$default) {
                return rootPath + FaceUtil.IMG_TEMP + str;
            }
            return rootPath + str + FaceUtil.IMG_TEMP + str;
        }

        @JvmStatic
        public final boolean loadLibrary(@NotNull String soPath) {
            Intrinsics.checkParameterIsNotNull(soPath, "soPath");
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.isX86CPU()) {
                return false;
            }
            try {
                System.loadLibrary(soPath);
                return true;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return false;
            }
        }

        @JvmStatic
        @NotNull
        public final String makeTempFileName(@NotNull String prefix, @NotNull String suffix) {
            Intrinsics.checkParameterIsNotNull(prefix, "prefix");
            Intrinsics.checkParameterIsNotNull(suffix, "suffix");
            return prefix + util.base64_pad_url + System.currentTimeMillis() + util.base64_pad_url + Random.INSTANCE.nextInt(0, 1000) + '.' + suffix;
        }

        @JvmStatic
        @NotNull
        public final String readOutputFromFile(@Nullable String pathToFile) {
            String trim;
            if (pathToFile == null) {
                return "";
            }
            File file = new File(pathToFile);
            if (!file.exists() || !file.canRead()) {
                return "";
            }
            try {
                trim = StringsKt__StringsKt.trim(readStream$default(this, new FileReader(file), 0, 2, (Object) null), '\n');
                return trim;
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
                return "";
            }
        }

        @JvmStatic
        @NotNull
        public final String readStream(@NotNull InputStream inputStream, int bufferSize) {
            Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            try {
                String readStream = FileUtil.INSTANCE.readStream(inputStreamReader, bufferSize);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(inputStreamReader, null);
                return readStream;
            } finally {
            }
        }

        @JvmStatic
        public final void readStreamByLine(@Nullable File file, @Nullable final IStreamListener listener) {
            if (file == null || listener == null || !file.exists()) {
                return;
            }
            try {
                FilesKt__FileReadWriteKt.forEachLine$default(file, null, new Function1<String, Unit>() { // from class: com.tencent.bugly.common.utils.FileUtil$Companion$readStreamByLine$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        FileUtil.IStreamListener.this.readLine(it);
                    }
                }, 1, null);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }

        public final void setApp(@Nullable Context context) {
            FileUtil.app = context;
        }

        @JvmStatic
        public final boolean writeFile(@Nullable String fileStr, @Nullable String text, boolean isAppend) {
            if (text == null) {
                return false;
            }
            Companion companion = FileUtil.INSTANCE;
            byte[] bytes = text.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return companion.writeFile(fileStr, bytes, isAppend);
        }

        @JvmStatic
        public final boolean zipFiles(@Nullable List<String> allFiles, @NotNull String outputPath, boolean isGzip) {
            Intrinsics.checkParameterIsNotNull(outputPath, "outputPath");
            try {
                File file = new File(outputPath);
                FileUtil.INSTANCE.createFile(file.getAbsolutePath());
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                DeflaterOutputStream gZIPOutputStream = isGzip ? new GZIPOutputStream(new BufferedOutputStream(fileOutputStream)) : new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                if (allFiles != null) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : allFiles) {
                            if (new File((String) obj).exists()) {
                                arrayList.add(obj);
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            File file2 = new File((String) it.next());
                            if (!isGzip) {
                                ZipOutputStream zipOutputStream = (ZipOutputStream) (!(gZIPOutputStream instanceof ZipOutputStream) ? null : gZIPOutputStream);
                                if (zipOutputStream != null) {
                                    zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                                }
                            }
                            FileInputStream fileInputStream = new FileInputStream(file2);
                            try {
                                ByteStreamsKt.copyTo(fileInputStream, gZIPOutputStream, 20480);
                                CloseableKt.closeFinally(fileInputStream, null);
                                gZIPOutputStream.flush();
                                if (!isGzip) {
                                    ZipOutputStream zipOutputStream2 = (ZipOutputStream) (!(gZIPOutputStream instanceof ZipOutputStream) ? null : gZIPOutputStream);
                                    if (zipOutputStream2 != null) {
                                        zipOutputStream2.closeEntry();
                                    }
                                }
                            } finally {
                            }
                        }
                        CloseableKt.closeFinally(gZIPOutputStream, null);
                        return true;
                    } finally {
                    }
                } else {
                    CloseableKt.closeFinally(gZIPOutputStream, null);
                    return false;
                }
            } catch (IOException e16) {
                e16.printStackTrace();
                return false;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String readStream$default(Companion companion, InputStreamReader inputStreamReader, int i3, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                i3 = 4096;
            }
            return companion.readStream(inputStreamReader, i3);
        }

        public static /* synthetic */ boolean zipFiles$default(Companion companion, String str, String str2, boolean z16, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            return companion.zipFiles(str, str2, z16);
        }

        @JvmStatic
        public final boolean createFile(@Nullable String filePath) {
            if (filePath == null) {
                return false;
            }
            File file = new File(filePath);
            if (file.exists()) {
                return true;
            }
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && (parentFile.exists() || parentFile.mkdirs())) {
                    return file.createNewFile();
                }
                return false;
            } catch (IOException e16) {
                e16.printStackTrace();
                return false;
            }
        }

        @JvmStatic
        public final synchronized boolean writeFile(@Nullable String fileStr, @Nullable byte[] text, boolean isAppend) {
            boolean z16;
            try {
                BufferedOutputStream fileBufferStream = getFileBufferStream(fileStr, isAppend);
                if (fileBufferStream != null) {
                    if (text != null) {
                        try {
                            fileBufferStream.write(text);
                            Unit unit = Unit.INSTANCE;
                        } finally {
                        }
                    }
                    CloseableKt.closeFinally(fileBufferStream, null);
                }
                z16 = true;
            } catch (IOException e16) {
                e16.printStackTrace();
                z16 = false;
            }
            return z16;
        }

        @JvmStatic
        public final void readStreamByLine(@Nullable InputStream stream, @Nullable final IStreamListener listener) {
            if (stream == null || listener == null) {
                return;
            }
            try {
                TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(stream)), new Function1<String, Unit>() { // from class: com.tencent.bugly.common.utils.FileUtil$Companion$readStreamByLine$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        FileUtil.IStreamListener.this.readLine(it);
                    }
                });
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }

        @JvmStatic
        @NotNull
        public final String readStream(@NotNull InputStreamReader inputStreamReader, int bufferSize) {
            Intrinsics.checkParameterIsNotNull(inputStreamReader, "inputStreamReader");
            StringBuffer stringBuffer = new StringBuffer(1024);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader, bufferSize);
            try {
                try {
                    Iterator<T> it = TextStreamsKt.readLines(bufferedReader).iterator();
                    while (it.hasNext()) {
                        stringBuffer.append((String) it.next());
                        stringBuffer.append("\n");
                    }
                } finally {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader, null);
                    String stringBuffer2 = stringBuffer.toString();
                    Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "sb.toString()");
                    return stringBuffer2;
                }
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedReader, null);
                String stringBuffer22 = stringBuffer.toString();
                Intrinsics.checkExpressionValueIsNotNull(stringBuffer22, "sb.toString()");
                return stringBuffer22;
            } finally {
            }
        }

        @JvmStatic
        public final void deleteFile(@Nullable String filePath) {
            deleteFile(filePath != null ? new File(filePath) : null);
        }

        @JvmStatic
        public final void writeFile(@Nullable String filePath, @Nullable InputStream input, boolean isAppend) {
            BufferedOutputStream fileBufferStream = getFileBufferStream(filePath, isAppend);
            if (fileBufferStream != null) {
                if (input != null) {
                    try {
                        BufferedInputStream bufferedInputStream = input instanceof BufferedInputStream ? (BufferedInputStream) input : new BufferedInputStream(input, 8192);
                        try {
                            byte[] bArr = new byte[8192];
                            for (int read = bufferedInputStream.read(bArr); read > 0; read = bufferedInputStream.read(bArr)) {
                                fileBufferStream.write(bArr, 0, read);
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(bufferedInputStream, null);
                        } finally {
                        }
                    } catch (Throwable th5) {
                        try {
                            throw th5;
                        } catch (Throwable th6) {
                            CloseableKt.closeFinally(fileBufferStream, th5);
                            throw th6;
                        }
                    }
                }
                CloseableKt.closeFinally(fileBufferStream, null);
            }
        }

        @JvmStatic
        public final boolean zipFiles(@NotNull String dir, @NotNull String outputPath, boolean isGzip) {
            Intrinsics.checkParameterIsNotNull(dir, "dir");
            Intrinsics.checkParameterIsNotNull(outputPath, "outputPath");
            return zipFiles(getFilesInDir(dir), outputPath, isGzip);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/bugly/common/utils/FileUtil$IStreamListener;", "", "readLine", "", "line", "", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public interface IStreamListener {
        void readLine(@NotNull String line);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/bugly/common/utils/FileUtil$MmapFile;", "", "mmapFilePath", "", "randomAccessFile", "Ljava/io/RandomAccessFile;", "byteBuffer", "Ljava/nio/MappedByteBuffer;", "(Ljava/lang/String;Ljava/io/RandomAccessFile;Ljava/nio/MappedByteBuffer;)V", "buffer", "getBuffer", "()Ljava/nio/MappedByteBuffer;", "setBuffer", "(Ljava/nio/MappedByteBuffer;)V", "file", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class MmapFile {

        @NotNull
        private MappedByteBuffer buffer;

        @NotNull
        private RandomAccessFile file;

        @NotNull
        private String filePath;

        public MmapFile(@NotNull String mmapFilePath, @NotNull RandomAccessFile randomAccessFile, @NotNull MappedByteBuffer byteBuffer) {
            Intrinsics.checkParameterIsNotNull(mmapFilePath, "mmapFilePath");
            Intrinsics.checkParameterIsNotNull(randomAccessFile, "randomAccessFile");
            Intrinsics.checkParameterIsNotNull(byteBuffer, "byteBuffer");
            this.filePath = mmapFilePath;
            this.file = randomAccessFile;
            this.buffer = byteBuffer;
        }

        @NotNull
        public final MappedByteBuffer getBuffer() {
            return this.buffer;
        }

        @NotNull
        public final RandomAccessFile getFile() {
            return this.file;
        }

        @NotNull
        public final String getFilePath() {
            return this.filePath;
        }

        public final void setBuffer(@NotNull MappedByteBuffer mappedByteBuffer) {
            Intrinsics.checkParameterIsNotNull(mappedByteBuffer, "<set-?>");
            this.buffer = mappedByteBuffer;
        }

        public final void setFile(@NotNull RandomAccessFile randomAccessFile) {
            Intrinsics.checkParameterIsNotNull(randomAccessFile, "<set-?>");
            this.file = randomAccessFile;
        }

        public final void setFilePath(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.filePath = str;
        }
    }

    @JvmStatic
    @Nullable
    public static final File copyFile(@NotNull File file, @NotNull File file2) {
        return INSTANCE.copyFile(file, file2);
    }

    @JvmStatic
    public static final boolean createFile(@Nullable String str) {
        return INSTANCE.createFile(str);
    }

    @JvmStatic
    public static final void deleteFile(@Nullable File file) {
        INSTANCE.deleteFile(file);
    }

    @JvmStatic
    public static final void deleteFolder(@Nullable File file) {
        INSTANCE.deleteFolder(file);
    }

    @JvmStatic
    @Nullable
    public static final synchronized BufferedOutputStream getFileBufferStream(@Nullable String str, boolean z16) {
        BufferedOutputStream fileBufferStream;
        synchronized (FileUtil.class) {
            fileBufferStream = INSTANCE.getFileBufferStream(str, z16);
        }
        return fileBufferStream;
    }

    @JvmStatic
    @Nullable
    public static final String getFileParentPath(@Nullable String str) {
        return INSTANCE.getFileParentPath(str);
    }

    @JvmStatic
    @Nullable
    public static final ArrayList<File> getFiles(@Nullable String str, @Nullable String str2) {
        return INSTANCE.getFiles(str, str2);
    }

    @JvmStatic
    @Nullable
    public static final List<String> getFilesInDir(@NotNull String str) {
        return INSTANCE.getFilesInDir(str);
    }

    @JvmStatic
    public static final long getFolderSize(@Nullable File file) {
        return INSTANCE.getFolderSize(file);
    }

    @JvmStatic
    public static final long getLastModifiedTime(@Nullable File file) {
        return INSTANCE.getLastModifiedTime(file);
    }

    @JvmStatic
    @NotNull
    public static final String getRootPath() {
        return INSTANCE.getRootPath();
    }

    @JvmStatic
    @NotNull
    public static final String getTempPath() {
        return INSTANCE.getTempPath();
    }

    @JvmStatic
    public static final boolean loadLibrary(@NotNull String str) {
        return INSTANCE.loadLibrary(str);
    }

    @JvmStatic
    @NotNull
    public static final String makeTempFileName(@NotNull String str, @NotNull String str2) {
        return INSTANCE.makeTempFileName(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final String readOutputFromFile(@Nullable String str) {
        return INSTANCE.readOutputFromFile(str);
    }

    @JvmStatic
    @NotNull
    public static final String readStream(@NotNull InputStream inputStream, int i3) {
        return INSTANCE.readStream(inputStream, i3);
    }

    @JvmStatic
    public static final void readStreamByLine(@Nullable File file, @Nullable IStreamListener iStreamListener) {
        INSTANCE.readStreamByLine(file, iStreamListener);
    }

    @JvmStatic
    public static final void writeFile(@Nullable String str, @Nullable InputStream inputStream, boolean z16) {
        INSTANCE.writeFile(str, inputStream, z16);
    }

    @JvmStatic
    public static final boolean zipFiles(@NotNull String str, @NotNull String str2, boolean z16) {
        return INSTANCE.zipFiles(str, str2, z16);
    }

    @JvmStatic
    public static final boolean createFile(@Nullable String str, @Nullable String str2) {
        return INSTANCE.createFile(str, str2);
    }

    @JvmStatic
    public static final void deleteFile(@Nullable String str) {
        INSTANCE.deleteFile(str);
    }

    @JvmStatic
    @NotNull
    public static final String readStream(@NotNull InputStreamReader inputStreamReader, int i3) {
        return INSTANCE.readStream(inputStreamReader, i3);
    }

    @JvmStatic
    public static final void readStreamByLine(@Nullable InputStream inputStream, @Nullable IStreamListener iStreamListener) {
        INSTANCE.readStreamByLine(inputStream, iStreamListener);
    }

    @JvmStatic
    public static final boolean writeFile(@Nullable String str, @Nullable String str2, boolean z16) {
        return INSTANCE.writeFile(str, str2, z16);
    }

    @JvmStatic
    public static final boolean zipFiles(@Nullable List<String> list, @NotNull String str, boolean z16) {
        return INSTANCE.zipFiles(list, str, z16);
    }

    @JvmStatic
    public static final synchronized boolean writeFile(@Nullable String str, @Nullable byte[] bArr, boolean z16) {
        boolean writeFile;
        synchronized (FileUtil.class) {
            writeFile = INSTANCE.writeFile(str, bArr, z16);
        }
        return writeFile;
    }
}
