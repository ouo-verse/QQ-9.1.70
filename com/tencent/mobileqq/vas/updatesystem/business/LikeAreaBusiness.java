package com.tencent.mobileqq.vas.updatesystem.business;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LikeAreaBusiness extends QQVasUpdateBusiness {
    private static final String BACKGROUND_ANIMATION_NAME = "/backgroundAnimation.png";
    public static final String BASE_LIKE_AREA_TIP = "https://tianquan.gtimg.cn/shoal/vaclient/4581e707-f4c2-4ce1-8f55-c3c6c49e7cf0.png";
    public static final String BASE_LIKE_AREA_TIP_NIGHT = "https://tianquan.gtimg.cn/shoal/vaclient/fa2bf0ec-5a1f-4958-a298-f571e691bd7c.png";
    public static final long BID = 328;
    public static final String NEW_YEAR_LUCKY_BAG = "https://tianquan.gtimg.cn/shoal/vaclient/b64c7358-586f-454a-8dcd-41a9c70cf16c.png";
    private static final String OPEN_ANIMATION_NAME = "/openAnimation.png";
    private static final String SCID_PREFIX = "likeArea.";
    protected static final String TAG = "VasUpdate_LikeAreaBusiness";
    public static final String VAS_LIKE_AREA_TIP = "https://tianquan.gtimg.cn/shoal/vaclient/527fe502-2e85-444d-8670-db335fef8870.png";
    public static final String VAS_LIKE_AREA_TIP_NIGHT = "https://tianquan.gtimg.cn/shoal/vaclient/b8d58759-3dde-4151-9f6a-fcce3bca9c30.png";

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 328L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "like_area";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "LikeAreaBusiness";
    }

    public Drawable getLikeAreaBgAnimation(int i3) {
        if (!queryFileExists(i3)) {
            return null;
        }
        String savePath = getSavePath(i3);
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setUseCache(false);
        return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable("", apngOptions, savePath + BACKGROUND_ANIMATION_NAME);
    }

    public APNGDrawable getLikeAreaOpenAnimation(int i3) {
        if (!queryFileExists(i3)) {
            return null;
        }
        String savePath = getSavePath(i3);
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(1);
        apngOptions.setUseCache(false);
        return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable("Vas", "", apngOptions, savePath + OPEN_ANIMATION_NAME);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return SCID_PREFIX + i3 + ".common.zip";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return QQVasUpdateBusiness.isEnableFileCheck(getBid());
    }

    public boolean queryFileExists(int i3) {
        String savePath = getSavePath(i3);
        String str = savePath + OPEN_ANIMATION_NAME;
        String str2 = savePath + BACKGROUND_ANIMATION_NAME;
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists() && file2.exists()) {
            return true;
        }
        startDownload(i3);
        return false;
    }
}
