package com.tencent.mobileqq.exportfile.fragment.filelist.manager;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.exportfile.fragment.filelist.t;
import com.tencent.mobileqq.filemanager.util.ap;
import com.tencent.mobileqq.richmedialist.model.DownloadState;
import com.tencent.mobileqq.richmedialist.model.FileItemInfo;
import com.tencent.mobileqq.richmedialist.model.ItemType;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/richmedialist/model/FileItemInfo;", "", "a", "", "d", "c", "b", h.F, "e", "f", "g", "", "i", "wifiphoto_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileItemInfoExtKt {
    @NotNull
    public static final String a(@NotNull FileItemInfo fileItemInfo) {
        Intrinsics.checkNotNullParameter(fileItemInfo, "<this>");
        if (c(fileItemInfo)) {
            return t.b(fileItemInfo.getDownloadSpeed(), FileItemInfoExtKt$desc$1.INSTANCE);
        }
        String timeStr = ap.a(fileItemInfo.getCreateTime());
        if (!e(fileItemInfo)) {
            Intrinsics.checkNotNullExpressionValue(timeStr, "timeStr");
            return timeStr;
        }
        String str = timeStr + "  " + t.b(fileItemInfo.getKFileSize(), FileItemInfoExtKt$desc$timeSizeStr$1.INSTANCE);
        if (b(fileItemInfo)) {
            return str + "  " + BaseApplication.context.getString(R.string.zwc);
        }
        if (d(fileItemInfo)) {
            return str + "  " + BaseApplication.context.getString(R.string.zwa);
        }
        return str;
    }

    public static final boolean b(@NotNull FileItemInfo fileItemInfo) {
        Intrinsics.checkNotNullParameter(fileItemInfo, "<this>");
        if (fileItemInfo.getDownloadState() == DownloadState.COMPLETE && FileUtils.fileExists(fileItemInfo.getLocalSavePath())) {
            return true;
        }
        return false;
    }

    public static final boolean c(@NotNull FileItemInfo fileItemInfo) {
        Intrinsics.checkNotNullParameter(fileItemInfo, "<this>");
        if (fileItemInfo.getDownloadState() == DownloadState.DOWNLOADING) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull FileItemInfo fileItemInfo) {
        Intrinsics.checkNotNullParameter(fileItemInfo, "<this>");
        if (fileItemInfo.getDownloadState() == DownloadState.FAIL) {
            return true;
        }
        return false;
    }

    public static final boolean e(@NotNull FileItemInfo fileItemInfo) {
        Intrinsics.checkNotNullParameter(fileItemInfo, "<this>");
        if (fileItemInfo.getItemType() == ItemType.FILE) {
            return true;
        }
        return false;
    }

    public static final boolean f(@NotNull FileItemInfo fileItemInfo) {
        Intrinsics.checkNotNullParameter(fileItemInfo, "<this>");
        if (fileItemInfo.getKFileType() == ItemType.PICTURE) {
            return true;
        }
        return false;
    }

    public static final boolean g(@NotNull FileItemInfo fileItemInfo) {
        Intrinsics.checkNotNullParameter(fileItemInfo, "<this>");
        if (fileItemInfo.getKFileType() == ItemType.VIDEO) {
            return true;
        }
        return false;
    }

    public static final boolean h(@NotNull FileItemInfo fileItemInfo) {
        Intrinsics.checkNotNullParameter(fileItemInfo, "<this>");
        if (fileItemInfo.getDownloadState() == DownloadState.PAUSE) {
            return true;
        }
        return false;
    }

    public static final int i(@NotNull FileItemInfo fileItemInfo) {
        Intrinsics.checkNotNullParameter(fileItemInfo, "<this>");
        if (!c(fileItemInfo)) {
            QLog.d("FileRecordExt", 1, "progress not downloading");
            return 0;
        }
        if (fileItemInfo.getKFileSize() <= 0) {
            return 0;
        }
        return Math.min(Math.max(0, (int) ((Math.max(0, fileItemInfo.getDownloadProgress()) / ((float) fileItemInfo.getKFileSize())) * 100)), 100);
    }
}
