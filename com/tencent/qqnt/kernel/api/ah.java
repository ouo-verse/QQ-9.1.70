package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoAlbumAccessDelegate;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoPreCheckCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoAuthorizationInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\fH&J$\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\fH&J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000eH&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/kernel/api/ah;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoHostListener;", "listener", "", "addKernelWiFiPhotoHostListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoAlbumAccessDelegate;", "delegate", "setAlbumAccessDelegate", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoPreCheckCallback;", "cb", "C0", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "requestVisitLocalAlbum", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Lcom/tencent/qqnt/kernel/nativeinterface/WiFiPhotoAuthorizationInfo;", "info", "acceptRequest", "reason", "rejectRequest", "error", "disconnect", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface ah extends j {
    void C0(@Nullable IKernelWiFiPhotoPreCheckCallback cb5);

    void acceptRequest(int requestId, @Nullable WiFiPhotoAuthorizationInfo info, @Nullable IOperateCallback cb5);

    void addKernelWiFiPhotoHostListener(@Nullable IKernelWiFiPhotoHostListener listener);

    void disconnect(int error);

    void rejectRequest(int requestId, int reason, @Nullable IOperateCallback cb5);

    void requestVisitLocalAlbum(@Nullable IOperateCallback cb5);

    void setAlbumAccessDelegate(@Nullable IKernelWiFiPhotoAlbumAccessDelegate delegate);
}
