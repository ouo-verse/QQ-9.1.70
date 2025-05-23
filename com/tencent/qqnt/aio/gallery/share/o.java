package com.tencent.qqnt.aio.gallery.share;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dt.api.ScanPicData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.QMiniResult;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.aio.gallery.share.o;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d B\u0011\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u00a2\u0006\u0004\b)\u0010*J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016R\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010!R$\u0010(\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/o;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "Lcom/tencent/mobileqq/qrscan/ScannerResult;", "scannerResult", "", "isPic", "", "r", "", "detectType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "uinType", "isFilePicture", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/dt/api/ScanPicData;", "scanPicData", "o", "g", "f", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", NodeProps.VISIBLE, tl.h.F, "", "c", "a", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Z", "isUseNewShare", "Ljava/lang/String;", "getCurrentSavaPath", "()Ljava/lang/String;", "v", "(Ljava/lang/String;)V", "currentSavaPath", "<init>", "(Z)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class o extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isUseNewShare;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String currentSavaPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/o$b;", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider$ICaptureListener;", "Landroid/graphics/Bitmap;", "videoFrame", "Lcom/tencent/qqnt/aio/gallery/share/o;", "action", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "b", "", "isSuccess", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onResult", "Ljava/lang/ref/WeakReference;", "a", "Ljava/lang/ref/WeakReference;", "mWrfAction", "mWrfShareContext", "<init>", "(Lcom/tencent/qqnt/aio/gallery/share/o;Lcom/tencent/qqnt/aio/gallery/share/s;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class b implements IVideoPlayerProvider.ICaptureListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<o> mWrfAction;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<NTShareContext> mWrfShareContext;

        public b(o action, NTShareContext shareContext) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(shareContext, "shareContext");
            this.mWrfShareContext = new WeakReference<>(shareContext);
            this.mWrfAction = new WeakReference<>(action);
        }

        private final void b(Bitmap videoFrame, final o action, final NTShareContext shareContext) {
            File file = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + File.separator + "tmpaiovideoframe.jpg");
            if (!file.exists()) {
                file.createNewFile();
            }
            boolean saveBitmapWithCompressFormat = RFWSaveUtil.saveBitmapWithCompressFormat(videoFrame, file, Bitmap.CompressFormat.JPEG);
            RFWLog.i("NTQRCodeAction", RFWLog.USR, " onVideoFrameCallBack, write tmp file:" + file.getAbsolutePath() + " saveSuccess:" + saveBitmapWithCompressFormat);
            if (saveBitmapWithCompressFormat) {
                action.v(file.getAbsolutePath());
                final ScannerResult decodeQQCodeFromBmp = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp(videoFrame, 3);
                if (decodeQQCodeFromBmp != null) {
                    shareContext.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.share.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            o.b.c(o.this, shareContext, decodeQQCodeFromBmp);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(o action, NTShareContext shareContext, ScannerResult scannerResult) {
            Intrinsics.checkNotNullParameter(action, "$action");
            Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
            Intrinsics.checkNotNullExpressionValue(scannerResult, "scannerResult");
            action.r(shareContext, scannerResult, false);
        }

        @Override // com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider.ICaptureListener
        public void onResult(boolean isSuccess, Bitmap bitmap) {
            NTShareContext nTShareContext;
            o oVar = this.mWrfAction.get();
            if (oVar == null || (nTShareContext = this.mWrfShareContext.get()) == null) {
                return;
            }
            if (isSuccess && bitmap != null) {
                b(bitmap, oVar, nTShareContext);
                return;
            }
            RFWLog.i("NTQRCodeAction", RFWLog.USR, " onVideoFrame " + isSuccess + " bitmap is empty:" + (bitmap == null));
        }
    }

    public o() {
        this(false, 1, null);
    }

    private final int n(int uinType, boolean isFilePicture) {
        if (uinType != 1) {
            if (uinType != 1000) {
                if (uinType != 10014) {
                    if (!isFilePicture) {
                        return 1;
                    }
                    return 3;
                }
                if (isFilePicture) {
                    return 12;
                }
                return 11;
            }
            return 13;
        }
        if (isFilePicture) {
            return 4;
        }
        return 2;
    }

    private final void o(ScanPicData scanPicData) {
        com.tencent.xaction.log.b.a("NTQRAndMiniAppCodeAction", 1, "scanPicData info scene:" + scanPicData.l() + ", fileId:" + scanPicData.c() + ", storeId:" + scanPicData.n() + ", groupId:" + scanPicData.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(NTShareContext shareContext, o this$0) {
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IScanUtilApi iScanUtilApi = (IScanUtilApi) QRoute.api(IScanUtilApi.class);
        String existSaveOrEditPath = shareContext.getExistSaveOrEditPath();
        Intrinsics.checkNotNull(existSaveOrEditPath);
        Uri fromFile = Uri.fromFile(new File(existSaveOrEditPath));
        Intrinsics.checkNotNullExpressionValue(fromFile, "Uri.fromFile(this)");
        ScannerResult decodeQQCodeFromFile = iScanUtilApi.decodeQQCodeFromFile(fromFile, (Context) shareContext.getActivity(), 3, false);
        if (decodeQQCodeFromFile != null) {
            this$0.r(shareContext, decodeQQCodeFromFile, true);
        }
        ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).onAIOScanRecogTypeReport(decodeQQCodeFromFile != null ? decodeQQCodeFromFile.g() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(final NTShareContext shareContext, final ScannerResult scannerResult, final boolean isPic) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.share.l
            @Override // java.lang.Runnable
            public final void run() {
                o.s(NTShareContext.this, this, scannerResult, isPic);
            }
        });
        ArrayList<QBarResult> arrayList = scannerResult.f276520d;
        int size = arrayList != null ? arrayList.size() : 0;
        ArrayList<QMiniResult> arrayList2 = scannerResult.f276521e;
        com.tencent.xaction.log.b.a("NTQRCodeAction", 4, "qrSize = " + size + ", miniSize = " + (arrayList2 != null ? arrayList2.size() : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ev3.b bVar) {
        bVar.c0("recognize_qr_code", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ev3.b bVar) {
        bVar.c0("miniprogram_scan", true);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void a(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        q(shareContext, Intrinsics.areEqual("recognize_qr_code", shareContext.getActionId()) ? 1 : 2);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        int i3 = item.action;
        q(shareContext, (i3 == 55 || i3 == 126) ? 1 : 2);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<String> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("recognize_qr_code", "miniprogram_scan");
        return arrayListOf;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.SECOND;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean f() {
        return false;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return true;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void h(final NTShareContext shareContext, boolean visible) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (visible) {
            if (!shareContext.getLayerItemInfo().isVideo() && !TextUtils.isEmpty(shareContext.getExistSaveOrEditPath())) {
                RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.share.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.p(NTShareContext.this, this);
                    }
                });
                return;
            }
            View decorView = shareContext.getActivity().getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "shareContext.activity.window.decorView");
            IVideoPlayerProvider videoControlProvider = RFWLayerIOCUtil.getVideoControlProvider(decorView);
            if (videoControlProvider != null) {
                videoControlProvider.capture(new b(this, shareContext));
            }
        }
    }

    public final void v(String str) {
        this.currentSavaPath = str;
    }

    public o(boolean z16) {
        this.isUseNewShare = z16;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(55, 56, 126, 127);
        return arrayListOf;
    }

    public /* synthetic */ o(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    private final void q(NTShareContext shareContext, int detectType) {
        String g16;
        String g17;
        FileElement fileElement;
        PicElement picElement;
        ScanPicData scanPicData = new ScanPicData();
        if (!shareContext.getLayerItemInfo().isVideo()) {
            int i3 = shareContext.getAioLayerData().istroop;
            if (i3 == 1) {
                MsgRecord msgRecord = shareContext.getMsgRecord();
                if (msgRecord != null) {
                    scanPicData.r(String.valueOf(msgRecord.peerUin));
                    scanPicData.x(String.valueOf(msgRecord.senderUin));
                }
            } else if (i3 != 10014) {
                MsgRecord msgRecord2 = shareContext.getMsgRecord();
                if (msgRecord2 != null) {
                    scanPicData.x(String.valueOf(msgRecord2.senderUin));
                }
            } else {
                MsgRecord msgRecord3 = shareContext.getMsgRecord();
                if (msgRecord3 != null) {
                    scanPicData.s(msgRecord3.guildId);
                    scanPicData.o(msgRecord3.channelId);
                    scanPicData.x(msgRecord3.senderUid.toString());
                }
            }
        }
        if (shareContext.getAioLayerData() instanceof AIOPictureData) {
            scanPicData.w(n(shareContext.getAioLayerData().istroop, false));
            MsgElement targetElement = shareContext.getTargetElement();
            if (targetElement != null && (picElement = targetElement.picElement) != null) {
                scanPicData.q(picElement.fileUuid);
                scanPicData.y(String.valueOf(picElement.storeID));
                scanPicData.t(picElement.md5HexStr);
                scanPicData.p(picElement.downloadIndex);
            }
            Intent intent = new Intent();
            intent.putExtra("o3_scan_pic_data", scanPicData);
            o(scanPicData);
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).onQRDecodeSucceed(shareContext.getActivity(), shareContext.getExistSaveOrEditPath(), shareContext.getAioLayerData().istroop, true, ((AIOPictureData) shareContext.getAioLayerData()).sendUin, ((AIOPictureData) shareContext.getAioLayerData()).md5, null, ((AIOPictureData) shareContext.getAioLayerData()).uuid, detectType, com.tencent.mobileqq.richmediabrowser.h.a().m(), com.tencent.mobileqq.richmediabrowser.h.a().g(), intent);
            return;
        }
        if (shareContext.getAioLayerData() instanceof AIOFilePictureData) {
            scanPicData.w(n(shareContext.getAioLayerData().istroop, true));
            MsgElement targetElement2 = shareContext.getTargetElement();
            if (targetElement2 != null && (fileElement = targetElement2.fileElement) != null) {
                scanPicData.q(fileElement.fileUuid);
                scanPicData.y(String.valueOf(fileElement.storeID));
            }
            Intent intent2 = new Intent();
            intent2.putExtra("o3_scan_pic_data", scanPicData);
            if (com.tencent.mobileqq.service.message.remote.a.b(((AIOFilePictureData) shareContext.getAioLayerData()).H)) {
                g17 = com.tencent.mobileqq.richmediabrowser.h.a().m();
            } else {
                g17 = com.tencent.mobileqq.richmediabrowser.h.a().g();
            }
            o(scanPicData);
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).onQRDecodeSucceed(shareContext.getActivity(), shareContext.getExistSaveOrEditPath(), ((AIOFilePictureData) shareContext.getAioLayerData()).f281831d, true, g17, null, null, ((AIOFilePictureData) shareContext.getAioLayerData()).I, detectType, com.tencent.mobileqq.richmediabrowser.h.a().m(), com.tencent.mobileqq.richmediabrowser.h.a().g(), intent2);
            return;
        }
        if (shareContext.getAioLayerData() instanceof AIOVideoData) {
            ((IVideoDepend) QRoute.api(IVideoDepend.class)).onQRDecodeSucceed(shareContext.getActivity(), this.currentSavaPath, shareContext.getAioLayerData().istroop, false, ((AIOVideoData) shareContext.getAioLayerData()).F, "", "", "", 1, com.tencent.mobileqq.richmediabrowser.h.a().m(), com.tencent.mobileqq.richmediabrowser.h.a().g());
        } else if (shareContext.getAioLayerData() instanceof AIOFileVideoData) {
            if (com.tencent.mobileqq.service.message.remote.a.b(((AIOFileVideoData) shareContext.getAioLayerData()).R)) {
                g16 = com.tencent.mobileqq.richmediabrowser.h.a().m();
            } else {
                g16 = com.tencent.mobileqq.richmediabrowser.h.a().g();
            }
            ((IVideoDepend) QRoute.api(IVideoDepend.class)).onQRDecodeSucceed(shareContext.getActivity(), this.currentSavaPath, ((AIOFileVideoData) shareContext.getAioLayerData()).Q, true, g16, null, null, ((AIOFileVideoData) shareContext.getAioLayerData()).S, detectType, com.tencent.mobileqq.richmediabrowser.h.a().m(), com.tencent.mobileqq.richmediabrowser.h.a().g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(NTShareContext shareContext, o this$0, ScannerResult scannerResult, boolean z16) {
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scannerResult, "$scannerResult");
        if (shareContext.getActivity().isFinishing()) {
            return;
        }
        com.tencent.qqnt.aio.gallery.j jVar = com.tencent.qqnt.aio.gallery.j.f350008a;
        boolean g16 = jVar.g(this$0.isUseNewShare, jVar.e(shareContext.getMediaType()));
        if (scannerResult.l()) {
            if (g16) {
                RFWIocAbilityProvider.g().getIoc(ev3.b.class).withGlobal(shareContext.getActivity()).done(new OnPromiseResolved() { // from class: com.tencent.qqnt.aio.gallery.share.m
                    @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                    public final void onDone(Object obj) {
                        o.t((ev3.b) obj);
                    }
                }).run();
            } else {
                shareContext.getShareManger().j(z16 ? 55 : 126, true);
            }
            ReportController.o(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 0, 0, "", "", "", "");
        }
        if (scannerResult.j()) {
            if (g16) {
                RFWIocAbilityProvider.g().getIoc(ev3.b.class).withGlobal(shareContext.getActivity()).done(new OnPromiseResolved() { // from class: com.tencent.qqnt.aio.gallery.share.n
                    @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                    public final void onDone(Object obj) {
                        o.u((ev3.b) obj);
                    }
                }).run();
            } else {
                shareContext.getShareManger().j(z16 ? 56 : 127, true);
            }
            ReportController.o(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 1, 0, "", "", "", "");
        }
    }
}
