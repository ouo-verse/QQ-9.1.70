package pe;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.feedpro.utils.ao;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.util.ad;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.util.QQToastUtil;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lpe/c;", "Lcom/qzone/reborn/share/a;", "Lcom/qzone/reborn/share/e;", "shareContext", "Ljava/io/File;", "file", "", ReportConstant.COSTREPORT_PREFIX, "", "j", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "c", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends com.qzone.reborn.share.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"pe/c$b", "Lcom/qzone/util/ad$a;", "", "url", "filePath", "", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements ad.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f425962b;

        b(com.qzone.reborn.share.e eVar) {
            this.f425962b = eVar;
        }

        @Override // com.qzone.util.ad.a
        public void a(String url, String filePath) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (filePath == null) {
                QZLog.e("QzoneFeedProLayerShareExtractTextAction", 1, "loadImageAsync onImageLoaded file path is null");
                return;
            }
            File file = new File(filePath);
            if (file.exists()) {
                c.this.s(this.f425962b, file);
            } else {
                QZLog.e("QzoneFeedProLayerShareExtractTextAction", 1, "loadImageAsync onImageLoaded file not exist .. ", filePath);
            }
        }

        @Override // com.qzone.util.ad.a
        public void b(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            QZLog.e("QzoneFeedProLayerShareExtractTextAction", 1, "loadImageAsync onImageFailed", url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(com.qzone.reborn.share.e shareContext, File file) {
        Bitmap a16;
        String absolutePath = file.getAbsolutePath();
        String x16 = com.qzone.reborn.configx.g.f53821a.c().x();
        if (SharpPUtils.isSharpP(file) || com.tencent.qzone.avif.a.a(file)) {
            try {
                if (SharpPUtils.isSharpP(file)) {
                    a16 = SharpPUtils.decodeSharpP(file.getAbsolutePath());
                } else {
                    a16 = (com.tencent.qzone.avif.a.a(file) && QZoneConfigHelper.i()) ? com.tencent.qzone.image.api.a.c().a(file, absolutePath, 0, 0) : null;
                }
                if (a16 != null) {
                    String str = System.currentTimeMillis() + ".jpeg";
                    String str2 = AppConstants.SDCARD_IMG_SAVE;
                    File file2 = new File(VFSAssistantUtils.getSDKPrivatePath(str2));
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    absolutePath = VFSAssistantUtils.getSDKPrivatePath(str2 + str);
                    if (com.qzone.util.image.c.V(a16, absolutePath, Bitmap.CompressFormat.JPEG, 90, true)) {
                        if (QZLog.isColorLevel()) {
                            QZLog.i("QzoneFeedProLayerShareExtractTextAction", "onOcrClick sharpp file save success:" + absolutePath);
                        }
                    } else {
                        QQToastUtil.showQQToastInUiThread(4, x16);
                        QZLog.e("QzoneFeedProLayerShareExtractTextAction", "onOcrClick ImageUtil.saveBitmapToFile return false");
                        return;
                    }
                } else {
                    QQToastUtil.showQQToastInUiThread(4, x16);
                    QZLog.e("QzoneFeedProLayerShareExtractTextAction", "onOcrClick SharpPUtils.decodeSharpP return null");
                    return;
                }
            } catch (Throwable th5) {
                QQToastUtil.showQQToastInUiThread(4, x16);
                QZLog.e("QzoneFeedProLayerShareExtractTextAction", "onOcrClick catch an exception: ", th5);
                return;
            }
        }
        String str3 = absolutePath;
        if (QZLog.isColorLevel()) {
            QZLog.i("QzoneFeedProLayerShareExtractTextAction", "onOcrClick jump to scan ocr " + str3);
        }
        ((IOCR) QRoute.api(IOCR.class)).startOcrPerformFragment(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), str3, 2, -1009, null, false);
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        ArrayList arrayListOf;
        ge.i defaultItemBean;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QzoneFeedProLayerShareExtractTextAction", 1, "share clicked");
        ge.h c16 = shareContext.c();
        RFWLayerItemMediaInfo mediaInfo = (c16 == null || (defaultItemBean = c16.getDefaultItemBean()) == null) ? null : defaultItemBean.getMediaInfo();
        String o16 = mediaInfo != null ? ao.f54312a.o(mediaInfo) : null;
        if (TextUtils.isEmpty(o16)) {
            QLog.i("QzoneFeedProLayerShareExtractTextAction", 1, "doAction media is null");
            return;
        }
        ad adVar = ad.f59766a;
        Intrinsics.checkNotNull(o16);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(o16);
        adVar.d(arrayListOf, new b(shareContext));
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("extract_text");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        ge.i defaultItemBean;
        ge.i defaultItemBean2;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ge.h c16 = shareContext.c();
        RFWLayerItemMediaInfo mediaInfo = (c16 == null || (defaultItemBean2 = c16.getDefaultItemBean()) == null) ? null : defaultItemBean2.getMediaInfo();
        QzoneFeedProLayerExtraInfoBean extraInfo = (c16 == null || (defaultItemBean = c16.getDefaultItemBean()) == null) ? null : defaultItemBean.getExtraInfo();
        String o16 = mediaInfo != null ? ao.f54312a.o(mediaInfo) : null;
        if (mediaInfo != null && extraInfo != null && !TextUtils.isEmpty(o16)) {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOCRService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
            return ((IOCRService) runtimeService).isSupportOcr(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), 2);
        }
        QLog.i("QzoneFeedProLayerShareExtractTextAction", 2, "needShowItem media is null");
        return false;
    }
}
