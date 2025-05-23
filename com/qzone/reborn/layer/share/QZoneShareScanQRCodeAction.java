package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.business.BasePicureViewController;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.dt.api.ScanPicData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneShareScanQRCodeAction extends QZoneBaseShareAction {

    /* renamed from: j, reason: collision with root package name */
    private int f58148j;

    /* renamed from: k, reason: collision with root package name */
    private HdAsync f58149k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f58152a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Looper looper, c cVar) {
            super(looper);
            this.f58152a = cVar;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            File file;
            PhotoInfo photoInfo = (PhotoInfo) obj;
            ImageLoader imageLoader = ImageLoader.getInstance();
            File file2 = null;
            if (TextUtils.isEmpty(photoInfo.bigUrl)) {
                file = null;
            } else {
                QZLog.d(QZoneShareScanQRCodeAction.this.I(), 1, "decodeFile result call... photoInfo.bigUrl:", photoInfo.bigUrl);
                file = imageLoader.getImageFile(photoInfo.bigUrl);
            }
            if (file == null) {
                QZLog.w(QZoneShareScanQRCodeAction.this.I(), 1, "decodeFile result call... file == null");
                return doNext(false);
            }
            if (!TextUtils.isEmpty(photoInfo.bigUrl)) {
                QZLog.d(QZoneShareScanQRCodeAction.this.I(), 1, "decodeFile result call... currentPhotoInfo.bigUrl:", photoInfo.bigUrl);
                file2 = imageLoader.getImageFile(photoInfo.bigUrl);
            }
            if (file2 == null) {
                QZLog.w(QZoneShareScanQRCodeAction.this.I(), 1, "decodeFile result call... currentFile == null");
                return doNext(false);
            }
            if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
                c cVar = this.f58152a;
                if (cVar != null) {
                    cVar.a(photoInfo);
                }
            } else {
                QZLog.w(QZoneShareScanQRCodeAction.this.I(), "decodeFile result call... file.getAbsolutePath():" + file.getAbsolutePath() + " currentFile:" + file2.getAbsolutePath());
            }
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PhotoInfo f58154a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Looper looper, PhotoInfo photoInfo) {
            super(looper);
            this.f58154a = photoInfo;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            Boolean bool;
            PhotoInfo photoInfo = this.f58154a;
            if (photoInfo != null && ((bool = photoInfo.hasQRCode) == null || !bool.booleanValue())) {
                ScannerResult scannerResult = null;
                File imageFile = !TextUtils.isEmpty(this.f58154a.bigUrl) ? ImageLoader.getInstance().getImageFile(this.f58154a.bigUrl) : null;
                if (imageFile == null) {
                    QZLog.w(QZoneShareScanQRCodeAction.this.I(), 1, "decodeFile call... file == null");
                    return doNext(false);
                }
                if (!com.tencent.qzone.avif.a.b(this.f58154a.bigUrl) && !com.tencent.qzone.avif.a.a(imageFile)) {
                    boolean isSharpP = SharpPUtils.isSharpP(imageFile);
                    Uri parse = Uri.parse("file://" + imageFile.getAbsolutePath());
                    QZLog.d(QZoneShareScanQRCodeAction.this.I(), 1, "decodeFile call... isSharpP:", Boolean.valueOf(isSharpP), " getAbsolutePath:", imageFile.getAbsolutePath());
                    scannerResult = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(parse, QZoneShareScanQRCodeAction.this.n(), 3, isSharpP);
                } else if (QZoneConfigHelper.j()) {
                    scannerResult = QZoneShareScanQRCodeAction.this.N(imageFile, this.f58154a.bigUrl);
                } else {
                    QZLog.d(QZoneShareScanQRCodeAction.this.I(), 1, "avif scan qr code is disable");
                }
                if (scannerResult == null) {
                    return doNext(false);
                }
                this.f58154a.hasQRCode = Boolean.valueOf(scannerResult.l());
                this.f58154a.hasQQCode = Boolean.valueOf(scannerResult.j());
                return doNext(true, this.f58154a);
            }
            return doNext(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface c {
        void a(PhotoInfo photoInfo);
    }

    public QZoneShareScanQRCodeAction(Activity activity) {
        super(activity);
        this.f58148j = -1;
    }

    private ScanPicData G(PhotoInfo photoInfo) {
        ScanPicData scanPicData = new ScanPicData();
        scanPicData.w(6);
        scanPicData.u(photoInfo.bigUrl);
        PhotoParam photoParam = this.f58110e;
        if (photoParam != null) {
            scanPicData.x(String.valueOf(photoParam.ownerUin));
        }
        return scanPicData;
    }

    public void H(PhotoInfo photoInfo, c cVar) {
        QZLog.d(I(), 1, "decodeFile...");
        this.f58149k = HdAsync.with(this).then(new b(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread), photoInfo)).then(new a(Looper.getMainLooper(), cVar)).call();
    }

    public String I() {
        return "QZoneShareScanQRCodeAction";
    }

    public Pair<Boolean, Boolean> K(PhotoInfo photoInfo, c cVar) {
        if (this.f58148j == -1) {
            this.f58148j = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_IS_QRCODE_SCAN, 1);
        }
        if (this.f58148j == 0) {
            QZLog.d(I(), 1, "isNeedOpenQRCode... isQrcodeScanOpen == 0");
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        if (!com.qzone.util.z.b(photoInfo)) {
            return J(photoInfo, cVar);
        }
        Boolean bool2 = Boolean.FALSE;
        return new Pair<>(bool2, bool2);
    }

    public void M() {
        HdAsync hdAsync = this.f58149k;
        if (hdAsync != null) {
            hdAsync.cancel();
            this.f58149k.destroy();
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    void j(final f fVar, final ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        Pair<Boolean, Boolean> K = K(fVar.f58179c, null);
        if (!((Boolean) K.first).booleanValue() && !((Boolean) K.second).booleanValue()) {
            RFWLog.e("QZoneShareScanQRCodeAction", RFWLog.USR, "[MORE_SAN_QRCODE] this function is closed and not suposed to show!");
            return;
        }
        RFWLog.d("QZoneShareScanQRCodeAction", 1, "onMoreItemClick... QRCode:", K.first, " QQCode:", K.second);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneShareScanQRCodeAction.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneShareScanQRCodeAction.this.L(fVar.f58179c, actionSheetItem.action);
            }
        });
        if (actionSheetItem.action == 56) {
            LpReportInfo_pf00064.allReport(301, 5, 2);
        }
        if (BasePicureViewController.n0()) {
            ClickReport.m(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "23");
        } else {
            ClickReport.m(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "22");
        }
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "31", true);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{52};
    }

    private Pair<Boolean, Boolean> J(PhotoInfo photoInfo, c cVar) {
        if (photoInfo == null) {
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        Boolean bool2 = photoInfo.hasQQCode;
        if (bool2 != null && bool2.booleanValue()) {
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        Boolean bool3 = photoInfo.hasQRCode;
        if (bool3 != null && bool3.booleanValue()) {
            return new Pair<>(Boolean.TRUE, Boolean.FALSE);
        }
        H(photoInfo, cVar);
        Boolean bool4 = Boolean.FALSE;
        return new Pair<>(bool4, bool4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0064, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
    
        if (r2 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ScannerResult N(File file, String str) {
        Bitmap bitmap;
        try {
            bitmap = com.tencent.qzone.image.api.a.c().a(file, str, 0, 0);
        } catch (Throwable th5) {
            th = th5;
            bitmap = null;
        }
        try {
            QLog.d(I(), 1, "parseQQCodeForAvif bmp:" + bitmap + ", file: " + file.getAbsolutePath() + ", url: " + str);
            r1 = bitmap != null ? ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp(bitmap, 3) : null;
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                QLog.w(I(), 1, "parseQQCodeForAvif error:", th);
            } finally {
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void L(PhotoInfo photoInfo, int i3) {
        Bitmap b16;
        if (photoInfo == null) {
            return;
        }
        File imageFile = !TextUtils.isEmpty(photoInfo.bigUrl) ? ImageLoader.getInstance().getImageFile(photoInfo.bigUrl) : null;
        if (imageFile == null) {
            return;
        }
        String absolutePath = imageFile.getAbsolutePath();
        if (SharpPUtils.isSharpP(imageFile) || com.tencent.qzone.avif.a.a(imageFile)) {
            try {
                if (SharpPUtils.isSharpP(imageFile)) {
                    b16 = SharpPUtils.decodeSharpP(imageFile.getAbsolutePath());
                } else {
                    b16 = com.tencent.qzone.avif.a.a(imageFile) ? com.tencent.qzone.image.api.a.c().b(imageFile.getAbsolutePath(), photoInfo.bigUrl, 0, 0) : null;
                }
                if (b16 != null) {
                    String str = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                    String str2 = AppConstants.SDCARD_IMG_SAVE;
                    File file = new File(VFSAssistantUtils.getSDKPrivatePath(str2));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str2 + str);
                    if (com.qzone.util.image.c.V(b16, sDKPrivatePath, Bitmap.CompressFormat.JPEG, 90, true)) {
                        try {
                            QZLog.i(I(), "------before jump to ScannerActivity,sharpp file save success:" + str);
                            absolutePath = sDKPrivatePath;
                        } catch (Throwable th5) {
                            th = th5;
                            absolutePath = sDKPrivatePath;
                            QZLog.e(I(), "catch an exception: ", th);
                            Intent intent = new Intent();
                            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", absolutePath);
                            intent.putExtra("fromPicQRDecode", true);
                            intent.putExtra("detectType", i3 == 56 ? 2 : 1);
                            PhotoParam photoParam = this.f58110e;
                            if (photoParam != null) {
                            }
                            intent.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, photoInfo.bigUrl, null, photoParam != null ? String.valueOf(photoParam.ownerUin) : null, String.valueOf(LoginData.getInstance().getUin()), 6));
                            intent.putExtra("o3_scan_pic_data", G(photoInfo));
                            RouteUtils.startActivity(n(), intent, "/qrscan/scanner");
                        }
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        Intent intent2 = new Intent();
        intent2.putExtra("PhotoConst.SINGLE_PHOTO_PATH", absolutePath);
        intent2.putExtra("fromPicQRDecode", true);
        intent2.putExtra("detectType", i3 == 56 ? 2 : 1);
        PhotoParam photoParam2 = this.f58110e;
        intent2.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, photoInfo.bigUrl, null, photoParam2 != null ? String.valueOf(photoParam2.ownerUin) : null, String.valueOf(LoginData.getInstance().getUin()), 6));
        intent2.putExtra("o3_scan_pic_data", G(photoInfo));
        RouteUtils.startActivity(n(), intent2, "/qrscan/scanner");
    }
}
