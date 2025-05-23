package com.qzone.reborn.albumx.common.layer.action;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.common.share.b;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.dt.api.ScanPicData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u001c*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u00034\u001a\u0017B\u0007\u00a2\u0006\u0004\b2\u00103J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u001f\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u0007J!\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH$\u00a2\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u0000H$\u00a2\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H$\u00a2\u0006\u0004\b#\u0010\u0007J\u0017\u0010$\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u0000H$\u00a2\u0006\u0004\b$\u0010\"J\b\u0010%\u001a\u00020\u000eH$J\b\u0010'\u001a\u00020&H$J\u001f\u0010)\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u0005H$\u00a2\u0006\u0004\b)\u0010*J!\u0010,\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00028\u00002\b\u0010+\u001a\u0004\u0018\u00010\u001dH\u0004\u00a2\u0006\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction;", "Lcom/qzone/reborn/albumx/common/share/b;", "T", "Lcom/qzone/reborn/albumx/common/share/a;", "shareContext", "", "v", "(Lcom/qzone/reborn/albumx/common/share/b;)Z", "Ljava/io/File;", "file", "", "url", "Lcom/tencent/mobileqq/qrscan/ScannerResult;", HippyTKDListViewAdapter.X, "", "id", "", "w", "(Lcom/qzone/reborn/albumx/common/share/b;I)V", "Lcom/tencent/mobileqq/dt/api/ScanPicData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/qzone/reborn/albumx/common/share/b;)Lcom/tencent/mobileqq/dt/api/ScanPicData;", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "(Lcom/qzone/reborn/albumx/common/share/b;Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;)V", "f", "Lcom/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction$b;", "listener", "t", "(Lcom/qzone/reborn/albumx/common/share/b;Lcom/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction$b;)Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/qzone/reborn/albumx/common/share/b;)Ljava/lang/String;", "u", "r", ReportConstant.COSTREPORT_PREFIX, "Lcom/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction$CodeType;", "p", "scanResult", "y", "(Lcom/qzone/reborn/albumx/common/share/b;Z)V", "onScanResultListener", DomainData.DOMAIN_NAME, "(Lcom/qzone/reborn/albumx/common/share/b;Lcom/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction$b;)V", "Lcom/tencent/component/hdasync/HdAsync;", "e", "Lcom/tencent/component/hdasync/HdAsync;", "mDecodeAction", "<init>", "()V", "CodeType", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class CommonLayerShareScanCodeAction<T extends com.qzone.reborn.albumx.common.share.b> extends com.qzone.reborn.albumx.common.share.a<T> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private HdAsync mDecodeAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction$CodeType;", "", "(Ljava/lang/String;I)V", "QRCODE", "QQCODE", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public enum CodeType {
        QRCODE,
        QQCODE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction$b;", "", "", "scanResult", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void a(boolean scanResult);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction$c", "Lcom/tencent/component/hdasync/HdAsyncAction;", "", "args", "Lcom/tencent/component/hdasync/HdAsyncResult;", "call", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f52380a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonLayerShareScanCodeAction<T> f52381b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ T f52382c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f52383d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, CommonLayerShareScanCodeAction<T> commonLayerShareScanCodeAction, T t16, b bVar, Looper looper) {
            super(looper);
            this.f52380a = str;
            this.f52381b = commonLayerShareScanCodeAction;
            this.f52382c = t16;
            this.f52383d = bVar;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object args) {
            boolean l3;
            ScannerResult scannerResult = null;
            File imageFile = !TextUtils.isEmpty(this.f52380a) ? ImageLoader.getInstance().getImageFile(this.f52380a) : null;
            if (imageFile == null) {
                QLog.w("CommonLayerShareScanQRCodeAction", 1, "decodeFile call... file == null");
                HdAsyncResult doNext = doNext(false);
                Intrinsics.checkNotNullExpressionValue(doNext, "doNext(false)");
                return doNext;
            }
            if (!com.tencent.qzone.avif.a.b(this.f52380a) && !com.tencent.qzone.avif.a.a(imageFile)) {
                boolean isSharpP = SharpPUtils.isSharpP(imageFile);
                Uri parse = Uri.parse("file://" + imageFile.getAbsolutePath());
                QLog.d("CommonLayerShareScanQRCodeAction", 1, "decodeFile call... isSharpP:", Boolean.valueOf(isSharpP), " getAbsolutePath:", imageFile.getAbsolutePath());
                scannerResult = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(parse, this.f52382c.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), 3, isSharpP);
            } else if (QZoneConfigHelper.j()) {
                scannerResult = this.f52381b.x(imageFile, this.f52380a);
            } else {
                QLog.d("CommonLayerShareScanQRCodeAction", 1, "avif scan qr code is disable");
            }
            if (scannerResult == null) {
                b bVar = this.f52383d;
                if (bVar != null) {
                    bVar.a(false);
                }
                HdAsyncResult doNext2 = doNext(false);
                Intrinsics.checkNotNullExpressionValue(doNext2, "doNext(false)");
                return doNext2;
            }
            if (this.f52381b.p() == CodeType.QQCODE) {
                l3 = scannerResult.j();
            } else {
                l3 = scannerResult.l();
            }
            HdAsyncResult doNext3 = doNext(true, Boolean.valueOf(l3));
            Intrinsics.checkNotNullExpressionValue(doNext3, "doNext(true, args)");
            return doNext3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction$d", "Lcom/tencent/component/hdasync/HdAsyncAction;", "", "args", "Lcom/tencent/component/hdasync/HdAsyncResult;", "call", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f52384a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f52385b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, b bVar, Looper looper) {
            super(looper);
            this.f52384a = str;
            this.f52385b = bVar;
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
            if (TextUtils.isEmpty(this.f52384a)) {
                file = null;
            } else {
                QLog.d("CommonLayerShareScanQRCodeAction", 1, "decodeFile result call... photoInfo.bigUrl:", this.f52384a);
                file = imageLoader.getImageFile(this.f52384a);
            }
            if (file == null) {
                QLog.w("CommonLayerShareScanQRCodeAction", 1, "decodeFile result call... file == null");
                HdAsyncResult doNext2 = doNext(false);
                Intrinsics.checkNotNullExpressionValue(doNext2, "doNext(false)");
                return doNext2;
            }
            if (!TextUtils.isEmpty(this.f52384a)) {
                QLog.d("CommonLayerShareScanQRCodeAction", 1, "decodeFile result call... currentPhotoInfo.bigUrl:", this.f52384a);
                file2 = imageLoader.getImageFile(this.f52384a);
            }
            if (file2 == null) {
                QLog.w("CommonLayerShareScanQRCodeAction", 1, "decodeFile result call... currentFile == null");
                HdAsyncResult doNext3 = doNext(false);
                Intrinsics.checkNotNullExpressionValue(doNext3, "doNext(false)");
                return doNext3;
            }
            if (Intrinsics.areEqual(file.getAbsolutePath(), file2.getAbsolutePath())) {
                b bVar = this.f52385b;
                if (bVar != null) {
                    bVar.a(bool.booleanValue());
                }
            } else {
                QLog.w("CommonLayerShareScanQRCodeAction", 1, "decodeFile result call... file.getAbsolutePath():" + file.getAbsolutePath() + " currentFile:" + file2.getAbsolutePath());
            }
            HdAsyncResult doNext4 = doNext(false);
            Intrinsics.checkNotNullExpressionValue(doNext4, "doNext(false)");
            return doNext4;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction$e", "Lcom/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction$b;", "", "scanResult", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonLayerShareScanCodeAction<T> f52386a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ T f52387b;

        e(CommonLayerShareScanCodeAction<T> commonLayerShareScanCodeAction, T t16) {
            this.f52386a = commonLayerShareScanCodeAction;
            this.f52387b = t16;
        }

        @Override // com.qzone.reborn.albumx.common.layer.action.CommonLayerShareScanCodeAction.b
        public void a(boolean scanResult) {
            this.f52386a.y(this.f52387b, scanResult);
            if (scanResult) {
                this.f52387b.b().m(this.f52386a.s(), !this.f52386a.u(this.f52387b));
            }
        }
    }

    private final ScanPicData m(T shareContext) {
        ScanPicData scanPicData = new ScanPicData();
        scanPicData.w(6);
        scanPicData.u(q(shareContext));
        scanPicData.x(r(shareContext));
        return scanPicData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(CommonLayerShareScanCodeAction this$0, com.qzone.reborn.albumx.common.share.b shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.w(shareContext, item.action);
    }

    private final boolean v(T shareContext) {
        if (u(shareContext)) {
            shareContext.b().m(s(), false);
            return false;
        }
        return t(shareContext, new e(this, shareContext));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void w(T shareContext, int id5) {
        String q16 = q(shareContext);
        Bitmap bitmap = null;
        File imageFile = !TextUtils.isEmpty(q16) ? ImageLoader.getInstance().getImageFile(q16) : null;
        if (imageFile == null) {
            return;
        }
        String absolutePath = imageFile.getAbsolutePath();
        if (SharpPUtils.isSharpP(imageFile) || com.tencent.qzone.avif.a.a(imageFile)) {
            try {
                if (SharpPUtils.isSharpP(imageFile)) {
                    bitmap = SharpPUtils.decodeSharpP(imageFile.getAbsolutePath());
                } else if (com.tencent.qzone.avif.a.a(imageFile)) {
                    bitmap = com.tencent.qzone.image.api.a.c().b(imageFile.getAbsolutePath(), q16, 0, 0);
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
                            QLog.i("CommonLayerShareScanQRCodeAction", 1, "------before jump to ScannerActivity,sharpp file save success:" + str);
                            absolutePath = sDKPrivatePath;
                        } catch (Throwable th5) {
                            th = th5;
                            absolutePath = sDKPrivatePath;
                            QLog.e("CommonLayerShareScanQRCodeAction", 1, "catch an exception: ", th);
                            Intent intent = new Intent();
                            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", absolutePath);
                            intent.putExtra("fromPicQRDecode", true);
                            intent.putExtra("detectType", id5 == 56 ? 2 : 1);
                            intent.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, q16, null, r(shareContext), String.valueOf(LoginData.getInstance().getUin()), 6));
                            intent.putExtra("o3_scan_pic_data", m(shareContext));
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
        intent2.putExtra("detectType", id5 == 56 ? 2 : 1);
        intent2.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, q16, null, r(shareContext), String.valueOf(LoginData.getInstance().getUin()), 6));
        intent2.putExtra("o3_scan_pic_data", m(shareContext));
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
    public final ScannerResult x(File file, String url) {
        Bitmap bitmap;
        try {
            bitmap = com.tencent.qzone.image.api.a.c().a(file, url, 0, 0);
            try {
                QLog.d("CommonLayerShareScanQRCodeAction", 1, "parseQQCodeForAvif bmp:" + bitmap + ", file: " + file.getAbsolutePath() + ", url: " + url);
                r2 = bitmap != null ? ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp(bitmap, 3) : null;
            } catch (Throwable th5) {
                th = th5;
                try {
                    th.printStackTrace();
                    QLog.w("CommonLayerShareScanQRCodeAction", 1, "parseQQCodeForAvif error:", th);
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

    @Override // com.qzone.reborn.albumx.common.share.a
    public void a(final T shareContext, final ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (!t(shareContext, null)) {
            QLog.e("CommonLayerShareScanQRCodeAction", 1, "[MORE_SAN_QRCODE] this function is closed and not supposed to show!");
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.albumx.common.layer.action.a
                @Override // java.lang.Runnable
                public final void run() {
                    CommonLayerShareScanCodeAction.o(CommonLayerShareScanCodeAction.this, shareContext, item);
                }
            });
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public boolean f(T shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return v(shareContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n(T shareContext, b onScanResultListener) {
        HdAsync then;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        QLog.d("CommonLayerShareScanQRCodeAction", 1, "decodeFile...");
        String q16 = q(shareContext);
        HdAsync then2 = HdAsync.with(this).then(new c(q16, this, shareContext, onScanResultListener, QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread)));
        this.mDecodeAction = (then2 == null || (then = then2.then(new d(q16, onScanResultListener, Looper.getMainLooper()))) == null) ? null : then.call();
    }

    protected abstract CodeType p();

    protected abstract String q(T shareContext);

    protected abstract String r(T shareContext);

    protected abstract int s();

    protected abstract boolean t(T shareContext, b listener);

    protected abstract boolean u(T shareContext);

    protected abstract void y(T shareContext, boolean scanResult);
}
