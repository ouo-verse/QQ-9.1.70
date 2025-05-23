package com.tencent.mobileqq.minigame.va;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadConstant;", "", "()V", "DOWNLOAD_PROGRESS", "", "MAX_PROGRESS", "PROGRESS_RATE", "", "STATUS_DELETE", "STATUS_DOWNLOADED", "STATUS_DOWNLOADING", "STATUS_DOWNLOAD_START", "STATUS_FAILED", "STATUS_INIT", "STATUS_INIT_CAN_UPDATE", "STATUS_INSTALLED", "STATUS_NEED_UPDATE", "STATUS_PAUSE", "isNeedDownloadAndInstall", "", "data", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class MiniGameDownloadConstant {
    public static final int DOWNLOAD_PROGRESS = 98;

    @NotNull
    public static final MiniGameDownloadConstant INSTANCE = new MiniGameDownloadConstant();
    public static final int MAX_PROGRESS = 100;
    public static final float PROGRESS_RATE = 0.98f;
    public static final int STATUS_DELETE = 10;
    public static final int STATUS_DOWNLOADED = 5;
    public static final int STATUS_DOWNLOADING = 2;
    public static final int STATUS_DOWNLOAD_START = 1;
    public static final int STATUS_FAILED = 6;
    public static final int STATUS_INIT = 0;
    public static final int STATUS_INIT_CAN_UPDATE = 11;
    public static final int STATUS_INSTALLED = 9;
    public static final int STATUS_NEED_UPDATE = 7;
    public static final int STATUS_PAUSE = 4;

    MiniGameDownloadConstant() {
    }

    @JvmStatic
    public static final boolean isNeedDownloadAndInstall(@NotNull MiniGameDownloadDataWrapper data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getDownloadStatus() != 0 && data.getDownloadStatus() != 6 && data.getDownloadStatus() != 4 && data.getDownloadStatus() != 5 && data.getDownloadStatus() != 7 && data.getDownloadStatus() != 10 && data.getDownloadStatus() != 11) {
            return false;
        }
        return true;
    }
}
