package com.tencent.bugly.common.utils;

import com.tencent.ams.dsdk.utils.DBHelper;
import com.tencent.bugly.common.heapdump.ForkJvmHeapDumper;
import com.tencent.bugly.common.heapdump.HeapDumpConfig;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.rmonitor.common.logger.Logger;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/bugly/common/utils/HprofFileIUtil;", "", "()V", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class HprofFileIUtil {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "Bugly_HprofFileIUtil";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/bugly/common/utils/HprofFileIUtil$Companion;", "", "()V", "TAG", "", "deleteLastModifiedFile", "", DBHelper.COL_FOLDER, "Ljava/io/File;", "maxSize", "", "dumpOOMHprof", "getOOMHprofPath", "getOOMHprofZipPath", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        public final void deleteLastModifiedFile(@NotNull File folder, long maxSize) {
            List<File> list;
            Intrinsics.checkParameterIsNotNull(folder, "folder");
            if (!folder.isDirectory()) {
                return;
            }
            long folderSize = FileUtil.INSTANCE.getFolderSize(folder);
            if (folderSize > maxSize) {
                File[] listFiles = folder.listFiles();
                if (listFiles != null) {
                    list = ArraysKt___ArraysKt.sortedWith(listFiles, new Comparator<T>() { // from class: com.tencent.bugly.common.utils.HprofFileIUtil$Companion$deleteLastModifiedFile$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t16, T t17) {
                            int compareValues;
                            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((File) t16).lastModified()), Long.valueOf(((File) t17).lastModified()));
                            return compareValues;
                        }
                    });
                } else {
                    list = null;
                }
                if (list != null) {
                    for (File file : list) {
                        if (folderSize > maxSize) {
                            Intrinsics.checkExpressionValueIsNotNull(file, "file");
                            if (file.isFile()) {
                                folderSize -= file.length();
                                file.delete();
                            } else if (file.isDirectory()) {
                                FileUtil.Companion companion = FileUtil.INSTANCE;
                                folderSize -= companion.getFolderSize(file);
                                companion.deleteFolder(file);
                            }
                        }
                    }
                }
            }
        }

        @JvmStatic
        public final void dumpOOMHprof() {
            try {
                File file = new File(getOOMHprofPath());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(getOOMHprofZipPath());
                if (file2.exists()) {
                    FileUtil.INSTANCE.deleteFolder(file2);
                }
                deleteLastModifiedFile(file, QZoneHelper.Constants.SUPPORT_MIX_MUSIC_DEFAULT);
                new ForkJvmHeapDumper().dump(file.getAbsolutePath() + File.separator + TraceGenerator.getProcessLaunchId() + ".hprof", new HeapDumpConfig(true, 1));
            } catch (Throwable th5) {
                Logger.f365497g.c(HprofFileIUtil.TAG, th5);
            }
        }

        @JvmStatic
        @NotNull
        public final String getOOMHprofPath() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(FileUtil.INSTANCE.getRootPath());
            String str = File.separator;
            sb5.append(str);
            sb5.append("bugly_oom_hprof");
            sb5.append(str);
            sb5.append("hprof");
            return sb5.toString();
        }

        @JvmStatic
        @NotNull
        public final String getOOMHprofZipPath() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(FileUtil.INSTANCE.getRootPath());
            String str = File.separator;
            sb5.append(str);
            sb5.append("bugly_oom_hprof");
            sb5.append(str);
            sb5.append("zips");
            return sb5.toString();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    public static final void deleteLastModifiedFile(@NotNull File file, long j3) {
        INSTANCE.deleteLastModifiedFile(file, j3);
    }

    @JvmStatic
    public static final void dumpOOMHprof() {
        INSTANCE.dumpOOMHprof();
    }

    @JvmStatic
    @NotNull
    public static final String getOOMHprofPath() {
        return INSTANCE.getOOMHprofPath();
    }

    @JvmStatic
    @NotNull
    public static final String getOOMHprofZipPath() {
        return INSTANCE.getOOMHprofZipPath();
    }
}
