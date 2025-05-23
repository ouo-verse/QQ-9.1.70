package com.qq.e.comm.plugin.i.core;

import com.qq.e.comm.plugin.i.b;
import com.qq.e.comm.plugin.k.ah;
import com.qq.e.comm.plugin.k.aw;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/qq/e/comm/plugin/resdownloader/core/TimeLimitLRUCleanTask;", "Lcom/qq/e/comm/plugin/resdownloader/core/DownloadCleanTask;", "Ljava/io/File;", "downloadDir", "", "maxSizeInMByte", "expireTimeHour", "", "cleanDownloadDirByModifyTimeDesc", "doClean", "Lcom/qq/e/comm/plugin/resdownloader/DownloadCleanInfo;", "taskInfo", "", "isTaskInfoValid", "downloadCleanInfo", "<init>", "(Lcom/qq/e/comm/plugin/resdownloader/DownloadCleanInfo;)V", "Companion", "TG-ResDownloader_tangramNoPluginRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.qq.e.comm.plugin.i.a.h, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public final class TimeLimitLRUCleanTask extends b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f39492b = new a(null);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/qq/e/comm/plugin/resdownloader/core/TimeLimitLRUCleanTask$Companion;", "", "()V", "TAG", "", "TG-ResDownloader_tangramNoPluginRelease"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.qq.e.comm.plugin.i.a.h$a */
    /* loaded from: classes3.dex */
    public static final class a {
        a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeLimitLRUCleanTask(@NotNull b downloadCleanInfo) {
        super(downloadCleanInfo);
        Intrinsics.checkParameterIsNotNull(downloadCleanInfo, "downloadCleanInfo");
    }

    @Override // com.qq.e.comm.plugin.i.core.b
    protected boolean a(@NotNull b taskInfo) {
        Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
        return taskInfo.a() != null && taskInfo.b() >= 0 && taskInfo.c() >= 0 && taskInfo.f() >= 0 && taskInfo.f() <= 100;
    }

    @Override // com.qq.e.comm.plugin.i.core.b
    protected void a() {
        b mDownloadCleanInfo = this.f39469a;
        Intrinsics.checkExpressionValueIsNotNull(mDownloadCleanInfo, "mDownloadCleanInfo");
        File a16 = mDownloadCleanInfo.a();
        b mDownloadCleanInfo2 = this.f39469a;
        Intrinsics.checkExpressionValueIsNotNull(mDownloadCleanInfo2, "mDownloadCleanInfo");
        int c16 = mDownloadCleanInfo2.c();
        b mDownloadCleanInfo3 = this.f39469a;
        Intrinsics.checkExpressionValueIsNotNull(mDownloadCleanInfo3, "mDownloadCleanInfo");
        a(a16, c16, mDownloadCleanInfo3.b());
    }

    private final void a(File file, int i3, int i16) {
        if (file != null && file.exists()) {
            long dirSize = FileUtil.getDirSize(file);
            long a16 = ah.a(i3);
            if (dirSize <= a16) {
                GDTLogger.e("\u7f13\u5b58\u6e05\u9664: \u7f13\u5b58\u5927\u5c0f\u672a\u8fbe\u5230\u9608\u503c\uff0c\u4e0d\u6267\u884c\u5220\u9664\u7b56\u7565");
                return;
            }
            List<File> files = FileUtil.getFilesSortedByModifyTimeDesc(file.getAbsolutePath());
            if (g.b(files)) {
                GDTLogger.e("\u7f13\u5b58\u6e05\u9664: getFilesSortedByModifyTimeDesc is null");
                return;
            }
            b mDownloadCleanInfo = this.f39469a;
            Intrinsics.checkExpressionValueIsNotNull(mDownloadCleanInfo, "mDownloadCleanInfo");
            if (g.a(mDownloadCleanInfo.e())) {
                b mDownloadCleanInfo2 = this.f39469a;
                Intrinsics.checkExpressionValueIsNotNull(mDownloadCleanInfo2, "mDownloadCleanInfo");
                List<File> e16 = mDownloadCleanInfo2.e();
                Intrinsics.checkExpressionValueIsNotNull(e16, "mDownloadCleanInfo.fileWhiteList");
                files.removeAll(e16);
            }
            long a17 = aw.a(i16);
            b mDownloadCleanInfo3 = this.f39469a;
            Intrinsics.checkExpressionValueIsNotNull(mDownloadCleanInfo3, "mDownloadCleanInfo");
            double f16 = (a16 / 100.0d) * mDownloadCleanInfo3.f();
            try {
                Intrinsics.checkExpressionValueIsNotNull(files, "files");
                int size = files.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        return;
                    }
                    File file2 = files.get(size);
                    if (file2 != null && file2.exists()) {
                        if (System.currentTimeMillis() - file2.lastModified() < a17) {
                            return;
                        }
                        long length = file2.length();
                        if (FileUtil.deleteFileSafely(file2)) {
                            dirSize -= length;
                            if (dirSize < f16) {
                                return;
                            }
                        } else {
                            GDTLogger.e("\u7f13\u5b58\u6e05\u9664: \u6587\u4ef6\u5220\u9664\u5931\u8d25:");
                        }
                    }
                }
            } catch (Throwable th5) {
                GDTLogger.e("\u7f13\u5b58\u6e05\u9664: Exception:", th5);
            }
        } else {
            GDTLogger.e("\u7f13\u5b58\u6e05\u9664: downloadDir is null");
        }
    }
}
