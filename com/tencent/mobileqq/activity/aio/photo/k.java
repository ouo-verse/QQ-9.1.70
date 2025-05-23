package com.tencent.mobileqq.activity.aio.photo;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.downloader.GalleryDecoder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k extends GalleryDecoder {
    private BaseApplicationImpl mApp;

    public k(BaseApplicationImpl baseApplicationImpl) {
        super(BaseApplication.getContext());
        this.mApp = baseApplicationImpl;
    }

    @Override // com.tencent.image.downloader.GalleryDecoder
    protected Object decodeVideo(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) {
        int i3;
        Object obj = downloadParams.tag;
        if (obj != null) {
            i3 = ((Integer) obj).intValue();
        } else {
            i3 = 0;
        }
        if (i3 == 3) {
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(file.getAbsolutePath(), 1);
            Gallery.getAIOImageScale(createVideoThumbnail.getWidth(), createVideoThumbnail.getHeight(), downloadParams.reqWidth, downloadParams.reqHeight);
            return ThumbnailUtils.createVideoThumbnail(file.getAbsolutePath(), 1);
        }
        return null;
    }

    @Override // com.tencent.image.downloader.GalleryDecoder
    protected String getLogTag() {
        return "PEAK";
    }

    @Override // com.tencent.image.downloader.GalleryDecoder
    protected void reportSafeDecode(SafeBitmapFactory.SafeDecodeOption safeDecodeOption) {
        if (!safeDecodeOption.isInJustDecodeBounds && safeDecodeOption.needRegionDecode) {
            HashMap<String, String> info = safeDecodeOption.getInfo();
            info.put("from", "GalleryDecoder");
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "safeDecode", safeDecodeOption.isGetBitmap, safeDecodeOption.runTime, safeDecodeOption.rawHeight * safeDecodeOption.rawWidth, info, "");
        }
    }

    @Override // com.tencent.image.downloader.GalleryDecoder
    protected RoundRectBitmap resizeAndClipBitmap(Bitmap bitmap, int i3) {
        try {
            return new RoundRectBitmap(bitmap, i3);
        } catch (OutOfMemoryError unused) {
            return new RoundRectBitmap(bitmap, URLDrawableHelper.getRoundCorner());
        }
    }

    @Override // com.tencent.image.downloader.GalleryDecoder
    protected boolean useJpegTurbo() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("jpgTurbo", false);
        QLog.d("PhotoDecoder", 2, "useJpegTurbo " + isSwitchOn);
        return isSwitchOn;
    }
}
