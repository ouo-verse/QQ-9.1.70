package com.tencent.mobileqq.exportfile.fragment.filelist;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.util.ap;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeDownloadState;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeNodeType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/data/c;", "", "a", "", "d", "c", "b", "e", "wifiphoto_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileRecordExtKt {
    @NotNull
    public static final String a(@NotNull com.tencent.mobileqq.exportfile.fragment.filelist.data.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (c(cVar)) {
            return t.b(cVar.a().downloadSpeed, FileRecordExtKt$desc$1.INSTANCE);
        }
        String timeStr = ap.a(cVar.a().creationTime);
        if (!e(cVar)) {
            Intrinsics.checkNotNullExpressionValue(timeStr, "timeStr");
            return timeStr;
        }
        String str = timeStr + "  " + t.b(cVar.a().fileSize, FileRecordExtKt$desc$timeSizeStr$1.INSTANCE);
        if (b(cVar)) {
            return str + "  " + BaseApplication.context.getString(R.string.zwc);
        }
        if (d(cVar)) {
            return str + "  " + BaseApplication.context.getString(R.string.zwa);
        }
        return str;
    }

    public static final boolean b(@NotNull com.tencent.mobileqq.exportfile.fragment.filelist.data.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (cVar.a().downloadState == FileBridgeDownloadState.KCOMPLETE && FileUtils.fileExists(cVar.a().localSavePath)) {
            return true;
        }
        return false;
    }

    public static final boolean c(@NotNull com.tencent.mobileqq.exportfile.fragment.filelist.data.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (cVar.a().downloadState == FileBridgeDownloadState.KDOWNLOADING) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull com.tencent.mobileqq.exportfile.fragment.filelist.data.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (cVar.a().downloadState == FileBridgeDownloadState.KFAILED) {
            return true;
        }
        return false;
    }

    public static final boolean e(@NotNull com.tencent.mobileqq.exportfile.fragment.filelist.data.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (cVar.a().nodeType == FileBridgeNodeType.KFILE) {
            return true;
        }
        return false;
    }
}
