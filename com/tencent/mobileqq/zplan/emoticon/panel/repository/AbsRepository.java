package com.tencent.mobileqq.zplan.emoticon.panel.repository;

import com.tencent.mobileqq.zplan.meme.animation2D.Anim2DFileCacheUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt__FileTreeWalkKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J.\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/repository/AbsRepository;", "", "Ljava/io/File;", "file", "", "c", "", "url", "", "id", "a", "parentPath", "b", "Lkotlin/Function3;", "", "callback", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class AbsRepository {
    public final String a(String url, int id5) {
        String c16 = com.tencent.zplan.common.utils.d.c(url);
        Intrinsics.checkNotNullExpressionValue(c16, "toMD5(url)");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = c16.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return Anim2DFileCacheUtil.f333892a.c("zplan_" + id5 + "_" + lowerCase + "/");
    }

    public final boolean b(File parentPath) {
        Intrinsics.checkNotNullParameter(parentPath, "parentPath");
        if (parentPath.exists() && parentPath.isDirectory()) {
            File file = new File(parentPath + "/foreground");
            File file2 = new File(parentPath + "/background");
            if (!file.exists() && !file2.exists()) {
                QLog.w("Emo2DIDataSource", 1, "isResValid false, foregroundFile && background is empty");
                return false;
            }
            if (file.exists() && file.isDirectory() && !c(file)) {
                QLog.w("Emo2DIDataSource", 1, "isResValid false, foregroundFile is empty");
                return false;
            }
            if (!file2.exists() || !file2.isDirectory() || c(file2)) {
                return true;
            }
            QLog.w("Emo2DIDataSource", 1, "isResValid false, backgroundFile is empty");
            return false;
        }
        QLog.w("Emo2DIDataSource", 1, "isResValid rootFile is not exist");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(String parentPath, Function3<? super Integer, ? super String, ? super String, Unit> callback) {
        String backgroundPath;
        File[] listFiles;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(parentPath, "parentPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        File file = new File(parentPath + "/background");
        File file2 = new File(parentPath + "/foreground");
        String foregroundPath = "";
        if (file.exists() && file.isDirectory()) {
            File[] listFiles2 = file.listFiles();
            if (listFiles2 != null) {
                if (!(listFiles2.length == 0)) {
                    z17 = true;
                    if (z17) {
                        backgroundPath = file.getAbsolutePath();
                        if (file2.exists() && file2.isDirectory()) {
                            listFiles = file2.listFiles();
                            if (listFiles != null) {
                                if (!(listFiles.length == 0)) {
                                    z16 = true;
                                    if (z16) {
                                        foregroundPath = file2.getAbsolutePath();
                                        Intrinsics.checkNotNullExpressionValue(backgroundPath, "backgroundPath");
                                        Intrinsics.checkNotNullExpressionValue(foregroundPath, "foregroundPath");
                                        callback.invoke(0, backgroundPath, foregroundPath);
                                    }
                                }
                            }
                            z16 = false;
                            if (z16) {
                            }
                        }
                        QLog.e("Emo2DIDataSource", 1, "read2DResData foregroundFile dir is empty");
                        Intrinsics.checkNotNullExpressionValue(backgroundPath, "backgroundPath");
                        Intrinsics.checkNotNullExpressionValue(foregroundPath, "foregroundPath");
                        callback.invoke(0, backgroundPath, foregroundPath);
                    }
                }
            }
            z17 = false;
            if (z17) {
            }
        }
        QLog.e("Emo2DIDataSource", 1, "read2DResData background dir is empty");
        backgroundPath = "";
        if (file2.exists()) {
            listFiles = file2.listFiles();
            if (listFiles != null) {
            }
            z16 = false;
            if (z16) {
            }
        }
        QLog.e("Emo2DIDataSource", 1, "read2DResData foregroundFile dir is empty");
        Intrinsics.checkNotNullExpressionValue(backgroundPath, "backgroundPath");
        Intrinsics.checkNotNullExpressionValue(foregroundPath, "foregroundPath");
        callback.invoke(0, backgroundPath, foregroundPath);
    }

    private final boolean c(File file) {
        FileTreeWalk walk$default;
        Sequence filter;
        int count;
        walk$default = FilesKt__FileTreeWalkKt.walk$default(file, null, 1, null);
        filter = SequencesKt___SequencesKt.filter(walk$default, new Function1<File, Boolean>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.repository.AbsRepository$isSubResValid$files$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File it) {
                String extension;
                Intrinsics.checkNotNullParameter(it, "it");
                extension = FilesKt__UtilsKt.getExtension(it);
                return Boolean.valueOf(Intrinsics.areEqual(extension, "png"));
            }
        });
        count = SequencesKt___SequencesKt.count(filter);
        QLog.w("Emo2DIDataSource", 1, "isSubResValid count=" + count + ", path=" + file.getAbsolutePath());
        return count > 0;
    }
}
