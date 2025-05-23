package com.tencent.qqmini.sdk.launcher.core.proxy.va;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/HotfixDownloadState;", "", "()V", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "progess", "getProgess", "setProgess", "status", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "setStatus", "totalSize", "", "getTotalSize", "()J", "setTotalSize", "(J)V", "toString", "", "Companion", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class HotfixDownloadState {
    public static final int STATUS_COMPLETE = 3;
    public static final int STATUS_DOWNLOADING = 1;
    public static final int STATUS_FAILED = 4;
    public static final int STATUS_INIT = 0;
    public static final int STATUS_PAUSE = 2;
    private int errorCode;
    private int progess;
    private int status;
    private long totalSize;

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final int getProgess() {
        return this.progess;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public final void setErrorCode(int i3) {
        this.errorCode = i3;
    }

    public final void setProgess(int i3) {
        this.progess = i3;
    }

    public final void setStatus(int i3) {
        this.status = i3;
    }

    public final void setTotalSize(long j3) {
        this.totalSize = j3;
    }

    @NotNull
    public String toString() {
        return "HotfixDownloadState(status=" + this.status + ", progess=" + this.progess + ", totalSize=" + this.totalSize + ", errorCode=" + this.errorCode + ')';
    }
}
