package bv3;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.msg.i;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J8\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J(\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u000fR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lbv3/d;", "", "", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "msgId", "elementId", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState$FileState;", "state", "", "percent", "totalSize", "", "filePath", "k", "targetMediaId", "l", "Lbv3/a;", "callBack", "d", "j", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "e", "b", "Lbv3/a;", "downloadCallBack", "Lcom/tencent/qqnt/msg/i;", "c", "Lcom/tencent/qqnt/msg/i;", "mKernelMsgListener", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d {

    /* renamed from: b, reason: from kotlin metadata */
    private static bv3.a downloadCallBack;

    /* renamed from: a */
    public static final d f29249a = new d();

    /* renamed from: c, reason: from kotlin metadata */
    private static final i mKernelMsgListener = new b();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29252a;

        static {
            int[] iArr = new int[RFWLayerFileDownloadState.FileState.values().length];
            try {
                iArr[RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RFWLayerFileDownloadState.FileState.DOWNLOAD_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RFWLayerFileDownloadState.FileState.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f29252a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"bv3/d$b", "Lcom/tencent/qqnt/msg/i;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "onRichMediaProgerssUpdate", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b extends i {
        b() {
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(FileTransNotifyInfo notifyInfo) {
            d.f29249a.m(notifyInfo);
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaProgerssUpdate(FileTransNotifyInfo notifyInfo) {
            d.f29249a.m(notifyInfo);
        }
    }

    d() {
    }

    public static final void h(int i3, int i16) {
        QQToast.makeText(MobileQQ.sMobileQQ, i3, i16, 0).show();
    }

    private final void i() {
        IKernelService iKernelService;
        w msgService;
        if (com.tencent.qqnt.aio.gallery.i.f350003a.c().isEmpty()) {
            QLog.d("NTKernelDownloadManager", 1, "releaseKernelDownloadListener removeListener");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) == null || (msgService = iKernelService.getMsgService()) == null) {
                return;
            }
            msgService.removeMsgListener(mKernelMsgListener);
        }
    }

    private final void l(String targetMediaId, RFWLayerFileDownloadState.FileState state, float percent, long totalSize) {
        RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
        RFWLayerFileDownloadState rFWLayerFileDownloadState = new RFWLayerFileDownloadState(targetMediaId);
        rFWLayerFileDownloadState.setFileState(state);
        rFWLayerFileDownloadState.setProgressPercent(percent);
        rFWLayerFileDownloadState.setFileSize(totalSize);
        rFWLayerDataCenter.updateFileState(rFWLayerFileDownloadState);
    }

    public final void d(bv3.a callBack) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService != null) {
            msgService.addMsgListener(mKernelMsgListener);
        }
        downloadCallBack = callBack;
    }

    public final void e(RFWLayerItemMediaInfo mediaInfo, String filePath) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        QLog.i("NTKernelDownloadManager", 1, "[dealVideoDownloadFinish] mediaId: " + mediaInfo.getMediaId() + ", downloadCallBack: " + downloadCallBack);
        com.tencent.qqnt.aio.gallery.i iVar = com.tencent.qqnt.aio.gallery.i.f350003a;
        if (iVar.c().containsKey(mediaInfo.getMediaId())) {
            TypeIntrinsics.asMutableMap(iVar.c()).remove(mediaInfo.getMediaId());
            if (!TextUtils.isEmpty(mediaInfo.getMediaId())) {
                ConcurrentHashMap<String, RFWLayerFileDownloadState.FileState> d16 = iVar.d();
                String mediaId = mediaInfo.getMediaId();
                Intrinsics.checkNotNull(mediaId);
                RFWLayerFileDownloadState.FileState fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS;
                d16.put(mediaId, fileState);
                RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
                String mediaId2 = mediaInfo.getMediaId();
                Intrinsics.checkNotNull(mediaId2);
                RFWLayerFileDownloadState rFWLayerFileDownloadState = new RFWLayerFileDownloadState(mediaId2);
                rFWLayerFileDownloadState.setFileState(fileState);
                rFWLayerFileDownloadState.setProgressPercent(1.0f);
                rFWLayerFileDownloadState.setFileSize(0L);
                rFWLayerDataCenter.updateFileState(rFWLayerFileDownloadState);
            }
            if (downloadCallBack == null) {
                QLog.i("NTKernelDownloadManager", 1, "releaseKernelDownloadListener mediaId: " + mediaInfo.getMediaId());
                i();
            }
            bv3.a aVar = downloadCallBack;
            if (aVar != null) {
                Intrinsics.checkNotNull(aVar);
                aVar.v4(mediaInfo);
            } else {
                AIOGalleryUtils.m(MobileQQ.sMobileQQ, filePath, false, new AIOGalleryUtils.d() { // from class: bv3.b
                    @Override // com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.d
                    public final void onSavePhotoResult(boolean z16) {
                        d.g(z16);
                    }
                });
            }
        }
    }

    public final void j(bv3.a callBack) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        downloadCallBack = null;
        i();
    }

    private final void k(long msgId, long elementId, RFWLayerFileDownloadState.FileState state, float percent, long totalSize, String filePath) {
        com.tencent.qqnt.aio.gallery.i iVar = com.tencent.qqnt.aio.gallery.i.f350003a;
        String str = iVar.b().get(Long.valueOf(elementId));
        if (str == null) {
            return;
        }
        if (state != RFWLayerFileDownloadState.FileState.DOWNLOADING) {
            QLog.d("NTKernelDownloadManager", 1, "updateFileDownloadState targetMediaId: " + str + ", state: " + state + ", elementId: " + elementId);
        }
        if (iVar.c().containsKey(str)) {
            QLog.d("NTKernelDownloadManager", 1, "updateFileDownloadState msgId: " + msgId + ", state: " + state + ", percent: " + percent);
            int i3 = a.f29252a[state.ordinal()];
            if (i3 == 1) {
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo = iVar.c().get(str);
                if (rFWLayerItemMediaInfo != null) {
                    bv3.a aVar = downloadCallBack;
                    if (aVar != null) {
                        aVar.H2(rFWLayerItemMediaInfo, null, null, filePath, null);
                    }
                    f29249a.e(rFWLayerItemMediaInfo, filePath);
                    return;
                }
                return;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                l(str, state, percent, totalSize);
                return;
            }
            iVar.c().remove(str);
            if (downloadCallBack == null) {
                QLog.i("NTKernelDownloadManager", 1, "DOWNLOAD_FAILED releaseKernelDownloadListener mediaId: " + str);
                i();
                return;
            }
            return;
        }
        if (state == RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS && iVar.d().containsKey(str)) {
            QLog.d("NTKernelDownloadManager", 1, "updateFileDownloadState return targetMediaId: " + str);
            return;
        }
        l(str, state, percent, totalSize);
    }

    public final void m(FileTransNotifyInfo fileTransNotifyInfo) {
        RFWLayerFileDownloadState.FileState fileState;
        boolean z16 = false;
        if (fileTransNotifyInfo != null && fileTransNotifyInfo.fileDownType == 1) {
            z16 = true;
        }
        if (z16) {
            int i3 = fileTransNotifyInfo.trasferStatus;
            if (i3 == 3) {
                fileState = RFWLayerFileDownloadState.FileState.DOWNLOADING;
            } else if (i3 == 4) {
                fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS;
            } else {
                if (i3 != 5 && i3 != 6) {
                    RFWLayerFileDownloadState.FileState fileState2 = RFWLayerFileDownloadState.FileState.UNKNOWN;
                    return;
                }
                fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_FAILED;
            }
            RFWLayerFileDownloadState.FileState fileState3 = fileState;
            long j3 = fileTransNotifyInfo.msgId;
            long j16 = fileTransNotifyInfo.msgElementId;
            float f16 = (float) fileTransNotifyInfo.fileProgress;
            long j17 = fileTransNotifyInfo.totalSize;
            String str = fileTransNotifyInfo.filePath;
            Intrinsics.checkNotNullExpressionValue(str, "notifyInfo.filePath");
            k(j3, j16, fileState3, f16 / ((float) j17), j17, str);
        }
    }

    public static /* synthetic */ void f(d dVar, RFWLayerItemMediaInfo rFWLayerItemMediaInfo, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        dVar.e(rFWLayerItemMediaInfo, str);
    }

    public static final void g(boolean z16) {
        final int i3 = z16 ? 2 : 0;
        final int i16 = z16 ? R.string.f173075h42 : R.string.f238307je;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: bv3.c
            @Override // java.lang.Runnable
            public final void run() {
                d.h(i3, i16);
            }
        });
    }
}
