package com.tencent.qq.minibox.manager;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qq.minibox.api.data.VirtualAppInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\b\u00a8\u0006,"}, d2 = {"Lcom/tencent/qq/minibox/manager/MiniBoxDownloadTask;", "Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo;", "", BdhLogUtil.LogTag.Tag_Req, "I", "getBusinessId", "()I", "m0", "(I)V", "businessId", ExifInterface.LATITUDE_SOUTH, "k0", "q0", "progress", "", "T", "J", "j0", "()J", "p0", "(J)V", "fileSize", "U", "l0", "r0", "speed", "V", "h0", "n0", "downloadFileSize", "", "W", "Ljava/lang/String;", "getDownloadFilePath", "()Ljava/lang/String;", "setDownloadFilePath", "(Ljava/lang/String;)V", "downloadFilePath", "X", "i0", "o0", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxDownloadTask extends VirtualAppInfo {

    /* renamed from: R, reason: from kotlin metadata */
    private int businessId;

    /* renamed from: S, reason: from kotlin metadata */
    private int progress;

    /* renamed from: T, reason: from kotlin metadata */
    private long fileSize;

    /* renamed from: U, reason: from kotlin metadata */
    private long speed;

    /* renamed from: V, reason: from kotlin metadata */
    private long downloadFileSize;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private String downloadFilePath = "";

    /* renamed from: X, reason: from kotlin metadata */
    private int downloadStatus;

    /* renamed from: h0, reason: from getter */
    public final long getDownloadFileSize() {
        return this.downloadFileSize;
    }

    /* renamed from: i0, reason: from getter */
    public final int getDownloadStatus() {
        return this.downloadStatus;
    }

    /* renamed from: j0, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: k0, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    /* renamed from: l0, reason: from getter */
    public final long getSpeed() {
        return this.speed;
    }

    public final void m0(int i3) {
        this.businessId = i3;
    }

    public final void n0(long j3) {
        this.downloadFileSize = j3;
    }

    public final void o0(int i3) {
        this.downloadStatus = i3;
    }

    public final void p0(long j3) {
        this.fileSize = j3;
    }

    public final void q0(int i3) {
        this.progress = i3;
    }

    public final void r0(long j3) {
        this.speed = j3;
    }
}
