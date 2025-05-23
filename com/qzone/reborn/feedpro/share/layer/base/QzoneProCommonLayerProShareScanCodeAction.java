package com.qzone.reborn.feedpro.share.layer.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.dt.api.ScanPicData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.sharpP.SharpPUtils;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 *2\u00020\u0001:\u0003+,\u0015B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H$J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H$J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H$J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H$J\b\u0010\u001d\u001a\u00020\bH$J\b\u0010\u001f\u001a\u00020\u001eH$J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0004H$J\u001a\u0010#\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0017H\u0004R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/feedpro/share/layer/base/QzoneProCommonLayerProShareScanCodeAction;", "Lcom/qzone/reborn/share/a;", "Lcom/qzone/reborn/share/e;", "shareContext", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/io/File;", "file", "", "url", "Lcom/tencent/mobileqq/qrscan/ScannerResult;", "E", "id", "", "D", "Lcom/tencent/mobileqq/dt/api/ScanPicData;", "t", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "j", "Lcom/qzone/reborn/feedpro/share/layer/base/QzoneProCommonLayerProShareScanCodeAction$b;", "listener", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "B", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/qzone/reborn/feedpro/share/layer/base/QzoneProCommonLayerProShareScanCodeAction$CodeType;", "w", "scanResult", UserInfo.SEX_FEMALE, "onScanResultListener", "u", "Lcom/tencent/component/hdasync/HdAsync;", "c", "Lcom/tencent/component/hdasync/HdAsync;", "mDecodeAction", "<init>", "()V", "d", "CodeType", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QzoneProCommonLayerProShareScanCodeAction extends com.qzone.reborn.share.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private HdAsync mDecodeAction;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/qzone/reborn/feedpro/share/layer/base/QzoneProCommonLayerProShareScanCodeAction$CodeType;", "", "(Ljava/lang/String;I)V", "QRCODE", "QQCODE", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public enum CodeType {
        QRCODE,
        QQCODE
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/qzone/reborn/feedpro/share/layer/base/QzoneProCommonLayerProShareScanCodeAction$b;", "", "", "scanResult", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void a(boolean scanResult);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedpro/share/layer/base/QzoneProCommonLayerProShareScanCodeAction$c", "Lcom/tencent/component/hdasync/HdAsyncAction;", "", "args", "Lcom/tencent/component/hdasync/HdAsyncResult;", "call", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f54244a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QzoneProCommonLayerProShareScanCodeAction f54245b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f54246c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f54247d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, QzoneProCommonLayerProShareScanCodeAction qzoneProCommonLayerProShareScanCodeAction, com.qzone.reborn.share.e eVar, b bVar, Looper looper) {
            super(looper);
            this.f54244a = str;
            this.f54245b = qzoneProCommonLayerProShareScanCodeAction;
            this.f54246c = eVar;
            this.f54247d = bVar;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object args) {
            boolean l3;
            ScannerResult scannerResult = null;
            File imageFile = !TextUtils.isEmpty(this.f54244a) ? ImageLoader.getInstance().getImageFile(this.f54244a) : null;
            if (imageFile == null) {
                QLog.w("CommonLayerProShareScanCodeAction", 1, "decodeFile call... file == null");
                HdAsyncResult doNext = doNext(false);
                Intrinsics.checkNotNullExpressionValue(doNext, "doNext(false)");
                return doNext;
            }
            if (!com.tencent.qzone.avif.a.b(this.f54244a) && !com.tencent.qzone.avif.a.a(imageFile)) {
                boolean isSharpP = SharpPUtils.isSharpP(imageFile);
                Uri parse = Uri.parse("file://" + imageFile.getAbsolutePath());
                QLog.d("CommonLayerProShareScanCodeAction", 1, "decodeFile call... isSharpP:", Boolean.valueOf(isSharpP), " getAbsolutePath:", imageFile.getAbsolutePath());
                scannerResult = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(parse, this.f54246c.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), 3, isSharpP);
            } else if (QZoneConfigHelper.j()) {
                scannerResult = this.f54245b.E(imageFile, this.f54244a);
            } else {
                QLog.d("CommonLayerProShareScanCodeAction", 1, "avif scan qr code is disable");
            }
            if (scannerResult == null) {
                b bVar = this.f54247d;
                if (bVar != null) {
                    bVar.a(false);
                }
                HdAsyncResult doNext2 = doNext(false);
                Intrinsics.checkNotNullExpressionValue(doNext2, "doNext(false)");
                return doNext2;
            }
            if (this.f54245b.w() == CodeType.QQCODE) {
                l3 = scannerResult.j();
            } else {
                l3 = scannerResult.l();
            }
            HdAsyncResult doNext3 = doNext(true, Boolean.valueOf(l3));
            Intrinsics.checkNotNullExpressionValue(doNext3, "doNext(true, args)");
            return doNext3;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedpro/share/layer/base/QzoneProCommonLayerProShareScanCodeAction$d", "Lcom/tencent/component/hdasync/HdAsyncAction;", "", "args", "Lcom/tencent/component/hdasync/HdAsyncResult;", "call", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f54248a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f54249b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, b bVar, Looper looper) {
            super(looper);
            this.f54248a = str;
            this.f54249b = bVar;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object args) {
            File file;
            if (args == null) {
                HdAsyncResult doNext = doNext(false);
                Intrinsics.checkNotNullExpressionValue(doNext, "doNext(false)");
                return doNext;
            }
            ImageLoader imageLoader = ImageLoader.getInstance();
            Boolean bool = (Boolean) args;
            File file2 = null;
            if (TextUtils.isEmpty(this.f54248a)) {
                file = null;
            } else {
                QLog.d("CommonLayerProShareScanCodeAction", 1, "decodeFile result call... photoInfo.bigUrl:", this.f54248a);
                file = imageLoader.getImageFile(this.f54248a);
            }
            if (file == null) {
                QLog.w("CommonLayerProShareScanCodeAction", 1, "decodeFile result call... file == null");
                HdAsyncResult doNext2 = doNext(false);
                Intrinsics.checkNotNullExpressionValue(doNext2, "doNext(false)");
                return doNext2;
            }
            if (!TextUtils.isEmpty(this.f54248a)) {
                QLog.d("CommonLayerProShareScanCodeAction", 1, "decodeFile result call... currentPhotoInfo.bigUrl:", this.f54248a);
                file2 = imageLoader.getImageFile(this.f54248a);
            }
            if (file2 == null) {
                QLog.w("CommonLayerProShareScanCodeAction", 1, "decodeFile result call... currentFile == null");
                HdAsyncResult doNext3 = doNext(false);
                Intrinsics.checkNotNullExpressionValue(doNext3, "doNext(false)");
                return doNext3;
            }
            if (Intrinsics.areEqual(file.getAbsolutePath(), file2.getAbsolutePath())) {
                b bVar = this.f54249b;
                if (bVar != null) {
                    bVar.a(bool.booleanValue());
                }
            } else {
                QLog.w("CommonLayerProShareScanCodeAction", 1, "decodeFile result call... file.getAbsolutePath():" + file.getAbsolutePath() + " currentFile:" + file2.getAbsolutePath());
            }
            HdAsyncResult doNext4 = doNext(false);
            Intrinsics.checkNotNullExpressionValue(doNext4, "doNext(false)");
            return doNext4;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedpro/share/layer/base/QzoneProCommonLayerProShareScanCodeAction$e", "Lcom/qzone/reborn/feedpro/share/layer/base/QzoneProCommonLayerProShareScanCodeAction$b;", "", "scanResult", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f54251b;

        e(com.qzone.reborn.share.e eVar) {
            this.f54251b = eVar;
        }

        @Override // com.qzone.reborn.feedpro.share.layer.base.QzoneProCommonLayerProShareScanCodeAction.b
        public void a(boolean scanResult) {
            QzoneProCommonLayerProShareScanCodeAction.this.F(this.f54251b, scanResult);
            if (scanResult) {
                this.f54251b.getShareManger().v(QzoneProCommonLayerProShareScanCodeAction.this.z(), !QzoneProCommonLayerProShareScanCodeAction.this.B(this.f54251b));
            }
        }
    }

    private final boolean C(com.qzone.reborn.share.e shareContext) {
        if (B(shareContext)) {
            shareContext.getShareManger().v(z(), false);
            return false;
        }
        return A(shareContext, new e(shareContext));
    }

    private final void D(com.qzone.reborn.share.e shareContext, String id5) {
        String x16 = x(shareContext);
        Bitmap bitmap = null;
        File imageFile = !TextUtils.isEmpty(x16) ? ImageLoader.getInstance().getImageFile(x16) : null;
        if (imageFile == null) {
            return;
        }
        String absolutePath = imageFile.getAbsolutePath();
        if (SharpPUtils.isSharpP(imageFile) || com.tencent.qzone.avif.a.a(imageFile)) {
            try {
                if (SharpPUtils.isSharpP(imageFile)) {
                    bitmap = SharpPUtils.decodeSharpP(imageFile.getAbsolutePath());
                } else if (com.tencent.qzone.avif.a.a(imageFile)) {
                    bitmap = com.tencent.qzone.image.api.a.c().b(imageFile.getAbsolutePath(), x16, 0, 0);
                }
                if (bitmap != null) {
                    String str = System.currentTimeMillis() + ".jpeg";
                    String str2 = AppConstants.SDCARD_IMG_SAVE;
                    File file = new File(VFSAssistantUtils.getSDKPrivatePath(str2));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str2 + str);
                    if (com.qzone.util.image.c.V(bitmap, sDKPrivatePath, Bitmap.CompressFormat.JPEG, 90, true)) {
                        try {
                            QLog.i("CommonLayerProShareScanCodeAction", 1, "------before jump to ScannerActivity,sharpp file save success:" + str);
                            absolutePath = sDKPrivatePath;
                        } catch (Throwable th5) {
                            th = th5;
                            absolutePath = sDKPrivatePath;
                            QLog.e("CommonLayerProShareScanCodeAction", 1, "catch an exception: ", th);
                            Intent intent = new Intent();
                            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", absolutePath);
                            intent.putExtra("fromPicQRDecode", true);
                            intent.putExtra("detectType", 1);
                            intent.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, x16, null, y(shareContext), String.valueOf(LoginData.getInstance().getUin()), 6));
                            intent.putExtra("o3_scan_pic_data", t(shareContext));
                            RouteUtils.startActivity(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), intent, "/qrscan/scanner");
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
        intent2.putExtra("detectType", 1);
        intent2.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, x16, null, y(shareContext), String.valueOf(LoginData.getInstance().getUin()), 6));
        intent2.putExtra("o3_scan_pic_data", t(shareContext));
        RouteUtils.startActivity(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), intent2, "/qrscan/scanner");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005f, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
    
        if (r3 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ScannerResult E(File file, String url) {
        Bitmap bitmap;
        try {
            bitmap = com.tencent.qzone.image.api.a.c().a(file, url, 0, 0);
            try {
                QLog.d("CommonLayerProShareScanCodeAction", 1, "parseQQCodeForAvif bmp:" + bitmap + ", file: " + file.getAbsolutePath() + ", url: " + url);
                r2 = bitmap != null ? ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp(bitmap, 3) : null;
            } catch (Throwable th5) {
                th = th5;
                try {
                    th.printStackTrace();
                    QLog.w("CommonLayerProShareScanCodeAction", 1, "parseQQCodeForAvif error:", th);
                } finally {
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            bitmap = null;
        }
    }

    private final ScanPicData t(com.qzone.reborn.share.e shareContext) {
        ScanPicData scanPicData = new ScanPicData();
        scanPicData.w(6);
        scanPicData.u(x(shareContext));
        scanPicData.x(y(shareContext));
        return scanPicData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(QzoneProCommonLayerProShareScanCodeAction this$0, com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        this$0.D(shareContext, this$0.z());
    }

    protected abstract boolean A(com.qzone.reborn.share.e shareContext, b listener);

    protected abstract boolean B(com.qzone.reborn.share.e shareContext);

    protected abstract void F(com.qzone.reborn.share.e shareContext, boolean scanResult);

    @Override // com.qzone.reborn.share.a
    public void b(final com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (!A(shareContext, null)) {
            QLog.e("CommonLayerProShareScanCodeAction", 1, "[MORE_SAN_QRCODE] this function is closed and not supposed to show!");
        } else {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.reborn.feedpro.share.layer.base.a
                @Override // java.lang.Runnable
                public final void run() {
                    QzoneProCommonLayerProShareScanCodeAction.v(QzoneProCommonLayerProShareScanCodeAction.this, shareContext);
                }
            });
        }
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return C(shareContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u(com.qzone.reborn.share.e shareContext, b onScanResultListener) {
        HdAsync then;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        QLog.d("CommonLayerProShareScanCodeAction", 1, "decodeFile...");
        String x16 = x(shareContext);
        HdAsync then2 = HdAsync.with(this).then(new c(x16, this, shareContext, onScanResultListener, QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread)));
        this.mDecodeAction = (then2 == null || (then = then2.then(new d(x16, onScanResultListener, Looper.getMainLooper()))) == null) ? null : then.call();
    }

    protected abstract CodeType w();

    protected abstract String x(com.qzone.reborn.share.e shareContext);

    protected abstract String y(com.qzone.reborn.share.e shareContext);

    protected abstract String z();
}
