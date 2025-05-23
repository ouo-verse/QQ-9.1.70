package com.tencent.mobileqq.vas.theme.api.impl;

import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.theme.api.IThemeFileCheck;
import com.tencent.mobileqq.vas.util.VasFileCheckUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/impl/ThemeFileCheckImpl;", "Lcom/tencent/mobileqq/vas/theme/api/IThemeFileCheck;", "", "zipFilePath", "unZipFilePath", "", "isCheckThemeFileValid", "", "unCompressZip", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ThemeFileCheckImpl implements IThemeFileCheck {

    @NotNull
    private static final String TAG = "ThemeFileCheckImpl";

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeFileCheck
    public int isCheckThemeFileValid(@NotNull String zipFilePath, @NotNull String unZipFilePath) {
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        Intrinsics.checkNotNullParameter(unZipFilePath, "unZipFilePath");
        if (!VasToggle.THEME_FILE_CHECK_NEW_ENABLE.isEnable(true)) {
            return 0;
        }
        if (!new File(unZipFilePath).exists()) {
            QLog.e(TAG, 1, unZipFilePath + " unzip dir not exist");
            return 0;
        }
        if (!new File(zipFilePath).exists()) {
            QLog.e(TAG, 1, zipFilePath + " zip file not exist");
            return 1;
        }
        if (VasFileCheckUtil.INSTANCE.isCheckFileEquals(unZipFilePath, zipFilePath)) {
            return 0;
        }
        QLog.e(TAG, 1, unZipFilePath + ProgressTracer.SEPARATOR + zipFilePath + " crc is invalid");
        return 2;
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeFileCheck
    public boolean unCompressZip(@NotNull String zipFilePath, @NotNull String unZipFilePath) {
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        Intrinsics.checkNotNullParameter(unZipFilePath, "unZipFilePath");
        if (!new File(zipFilePath).exists()) {
            return false;
        }
        try {
            FileUtils.deleteDirectory(unZipFilePath);
            FileUtils.uncompressZip(zipFilePath, unZipFilePath, false);
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "unCompress error: ", e16);
            FileUtils.deleteDirectory(unZipFilePath);
            return false;
        }
    }
}
