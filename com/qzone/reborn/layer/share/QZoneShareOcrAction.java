package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.util.ToastUtil;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.sharpP.SharpPUtils;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneShareOcrAction extends QZoneBaseShareAction {
    public QZoneShareOcrAction(Activity activity) {
        super(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(File file) {
        Bitmap a16;
        String absolutePath = file.getAbsolutePath();
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastTextIdentifyFail", "\u6587\u5b57\u8bc6\u522b\u5931\u8d25");
        if (SharpPUtils.isSharpP(file) || com.tencent.qzone.avif.a.a(file)) {
            try {
                if (SharpPUtils.isSharpP(file)) {
                    a16 = SharpPUtils.decodeSharpP(file.getAbsolutePath());
                } else {
                    a16 = (com.tencent.qzone.avif.a.a(file) && QZoneConfigHelper.i()) ? com.tencent.qzone.image.api.a.c().a(file, absolutePath, 0, 0) : null;
                }
                if (a16 != null) {
                    String str = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                    String str2 = AppConstants.SDCARD_IMG_SAVE;
                    File file2 = new File(VFSAssistantUtils.getSDKPrivatePath(str2));
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    absolutePath = VFSAssistantUtils.getSDKPrivatePath(str2 + str);
                    if (com.qzone.util.image.c.V(a16, absolutePath, Bitmap.CompressFormat.JPEG, 90, true)) {
                        if (QZLog.isColorLevel()) {
                            QZLog.i("QZoneFeedxShareOcrAction", "onOcrClick sharpp file save success:" + absolutePath);
                        }
                    } else {
                        ToastUtil.s(config, 4);
                        QZLog.e("QZoneFeedxShareOcrAction", "onOcrClick ImageUtil.saveBitmapToFile return false");
                        return;
                    }
                } else {
                    ToastUtil.s(config, 4);
                    QZLog.e("QZoneFeedxShareOcrAction", "onOcrClick SharpPUtils.decodeSharpP return null");
                    return;
                }
            } catch (Throwable th5) {
                ToastUtil.s(config, 4);
                QZLog.e("QZoneFeedxShareOcrAction", "onOcrClick catch an exception: ", th5);
                return;
            }
        }
        String str3 = absolutePath;
        if (QZLog.isColorLevel()) {
            QZLog.i("QZoneFeedxShareOcrAction", "onOcrClick jump to scan ocr " + str3);
        }
        ((IOCR) QRoute.api(IOCR.class)).startOcrPerformFragment(n(), str3, 2, -1009, null, false);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        String str;
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", WadlProxyConsts.OPER_TYPE_APK_SIGN, true);
        if (QZLog.isColorLevel()) {
            QZLog.i("QZoneFeedxShareOcrAction", "onOcrClick");
        }
        PhotoInfo photoInfo = fVar.f58179c;
        if (photoInfo == null) {
            QZLog.e("QZoneFeedxShareOcrAction", "onOcrClick photoInfo == null");
            return;
        }
        if (!TextUtils.isEmpty(photoInfo.bigUrl)) {
            str = fVar.f58179c.bigUrl;
        } else {
            str = !TextUtils.isEmpty(fVar.f58179c.currentUrl) ? fVar.f58179c.currentUrl : null;
        }
        if (!TextUtils.isEmpty(str)) {
            ImageLoader.getInstance().loadImageAsync(str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.reborn.layer.share.QZoneShareOcrAction.1
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                    final File imageFile = ImageManager.getInstance().getImageFile(str2, options);
                    if (imageFile == null && !TextUtils.isEmpty(str2) && !ImageManager.isNetworkUrl(str2)) {
                        imageFile = new File(str2);
                    }
                    if (imageFile != null && imageFile.exists()) {
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneShareOcrAction.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QZoneShareOcrAction.this.F(imageFile);
                            }
                        });
                    } else {
                        QZLog.e("QZoneFeedxShareOcrAction", 2, "loadImageAsync onImageLoaded file not exist .. ", str2);
                    }
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageCanceled(String str2, ImageLoader.Options options) {
                    QZLog.w("QZoneFeedxShareOcrAction", 2, "loadImageAsync onImageCanceled", str2);
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageFailed(String str2, ImageLoader.Options options) {
                    QZLog.e("QZoneFeedxShareOcrAction", 2, "loadImageAsync onImageFailed", str2);
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
                }
            }, null);
        } else {
            QZLog.e("QZoneFeedxShareOcrAction", 2, "onOcrClick image url is empty");
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastTextIdentifyFail", "\u6587\u5b57\u8bc6\u522b\u5931\u8d25"), 4);
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{52};
    }
}
