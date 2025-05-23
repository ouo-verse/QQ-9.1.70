package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emoticonview.sender.CustomEmotionSenderUtil;
import com.tencent.mobileqq.transfile.VasExtensionDownloaderConstant;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f extends b {

    /* renamed from: b, reason: collision with root package name */
    private CameraEmotionData f179911b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f179912c;

    /* renamed from: d, reason: collision with root package name */
    private String f179913d;

    public f(BaseQQAppInterface baseQQAppInterface, CameraEmotionData cameraEmotionData) {
        this.f179911b = cameraEmotionData;
        ICameraEmotionRoamingDBManagerService iCameraEmotionRoamingDBManagerService = (ICameraEmotionRoamingDBManagerService) baseQQAppInterface.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
        if (iCameraEmotionRoamingDBManagerService != null) {
            this.f179913d = iCameraEmotionRoamingDBManagerService.getCustomEmoticonPath(cameraEmotionData);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getBusinessType() {
        return 3;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getClickNum() {
        return this.f179911b.clickNum;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getExposeNum() {
        return this.f179911b.exposeNum;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getImgMd5() {
        String str = this.f179911b.md5;
        if (str != null) {
            return str.toLowerCase();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getImgUrl() {
        return this.f179911b.url;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URL getProtocolURL() {
        URL url;
        try {
            url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_CAMERA_EMO_PANEL_DYNAMIC, this.f179913d);
        } catch (MalformedURLException e16) {
            QLog.e("StickerRecCameraData", 1, "StickerLocalRecData getURL url exception e = " + e16.getMessage());
            url = null;
        }
        if (url == null) {
            QLog.e("StickerRecCameraData", 1, "StickerLocalRecData getURL url = null");
            return null;
        }
        return url;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getReportEventPrefix() {
        return "a-";
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (url == null) {
            return null;
        }
        return super.getURLDrawable(url, uRLDrawableOptions);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URLDrawable.URLDrawableOptions getURLDrawableOptions() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mExtraInfo = this.f179911b.url;
        return obtain;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public boolean isClicked() {
        return this.f179912c;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public boolean isExposed() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public boolean isStickerRecFromLocal() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public void onEmoticonWillShow(BaseQQAppInterface baseQQAppInterface, int i3) {
        ((ICameraEmoRoamingManagerService) baseQQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class)).syncIncreaseEmoticonExposeNum(this.f179911b);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public void sendEmoticon(BaseQQAppInterface baseQQAppInterface, Context context, com.tencent.mobileqq.activity.aio.p pVar) {
        this.f179912c = true;
        CustomEmotionSenderUtil.sendCustomEmotion(baseQQAppInterface, context, pVar, this.f179913d, true, this.f179911b.strContext, null);
        ((ICameraEmoRoamingManagerService) baseQQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class)).asyncIncreaseEmotionClickNum(this.f179911b);
    }
}
