package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.sender.CustomEmotionSenderUtil;
import com.tencent.mobileqq.emoticonview.sender.FavoriteEmoticonInfoSender;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.transfile.VasExtensionDownloaderConstant;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j extends b {

    /* renamed from: b, reason: collision with root package name */
    public CustomEmotionData f179940b;

    /* renamed from: c, reason: collision with root package name */
    private Emoticon f179941c;

    /* renamed from: d, reason: collision with root package name */
    private String f179942d;

    public j(BaseQQAppInterface baseQQAppInterface, CustomEmotionData customEmotionData) {
        this.f179940b = customEmotionData;
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) baseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
        if (iFavroamingDBManagerService != null) {
            this.f179942d = iFavroamingDBManagerService.getCustomEmoticonPath(customEmotionData);
        }
        if (customEmotionData.isMarkFace) {
            this.f179941c = ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonById(customEmotionData.emoPath, customEmotionData.eId);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getBusinessType() {
        return 4;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getClickNum() {
        return this.f179940b.clickNum;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getExposeNum() {
        return this.f179940b.exposeNum;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getImgMd5() {
        String str = this.f179940b.md5;
        if (str != null) {
            return str.toLowerCase();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getImgUrl() {
        return this.f179940b.url;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0081 A[RETURN] */
    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public URL getProtocolURL() {
        URL url;
        if (!this.f179940b.isMarkFace) {
            try {
                url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_DYNAMIC, this.f179942d);
            } catch (MalformedURLException e16) {
                QLog.e("StickerRecFavoriteData", 1, "StickerRecFavoriteData getURL url exception e = " + e16.getMessage());
                url = null;
                if (url == null) {
                }
            }
        } else {
            try {
                url = new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, EmotionConstants.FROM_AIO, this.f179940b.emoPath + "_" + this.f179940b.eId);
            } catch (MalformedURLException e17) {
                QLog.e("StickerRecFavoriteData", 1, "StickerLocalRecData getURL url exception e = " + e17.getMessage());
                url = null;
                if (url == null) {
                }
            }
        }
        if (url == null) {
            QLog.e("StickerRecFavoriteData", 1, "StickerRecFavoriteData getURL url = null");
            return null;
        }
        return url;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getReportEventPrefix() {
        return "c-";
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (this.f179940b.isMarkFace && this.f179941c != null) {
            URLDrawable drawable = URLDrawable.getDrawable(url, uRLDrawableOptions);
            if (drawable.getStatus() != 1) {
                drawable.setTag(this.f179941c);
            }
            return drawable;
        }
        return super.getURLDrawable(url, uRLDrawableOptions);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URLDrawable.URLDrawableOptions getURLDrawableOptions() {
        if (this.f179940b.isMarkFace && this.f179941c != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (this.f179941c.isAPNG) {
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecFavoriteData", 2, "getURLDrawableOptions: APNG so loaded use apng image");
                }
                obtain.mUseApngImage = true;
                obtain.mPlayGifImage = false;
                obtain.mMemoryCacheKeySuffix = "useAPNG";
            }
            return obtain;
        }
        return super.getURLDrawableOptions();
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public boolean isStickerRecFromLocal() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public void onEmoticonWillShow(BaseQQAppInterface baseQQAppInterface, int i3) {
        ((IFavroamingManagerService) baseQQAppInterface.getRuntimeService(IFavroamingManagerService.class)).syncIncreaseEmoticonExposeNum(this.f179940b);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public void sendEmoticon(BaseQQAppInterface baseQQAppInterface, Context context, com.tencent.mobileqq.activity.aio.p pVar) {
        String str;
        super.sendEmoticon(baseQQAppInterface, context, pVar);
        boolean z16 = this.f179940b.isMarkFace;
        if (z16 && this.f179941c != null) {
            ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmoticon(baseQQAppInterface, context, pVar, this.f179941c, false);
        } else {
            if (!z16) {
                str = lb1.c.a(((IVipComicMqqManagerService) baseQQAppInterface.getRuntimeService(IVipComicMqqManagerService.class)).getComicStructInfoMap(), this.f179940b.md5);
            } else {
                str = null;
            }
            if (((IEmosmService) QRoute.api(IEmosmService.class)).isComeFromComic(str)) {
                FavoriteEmoticonInfoSender.sendStructMsgForImage(baseQQAppInterface, pVar, this.f179942d, str);
            } else {
                CustomEmotionSenderUtil.sendCustomEmotion(baseQQAppInterface, context, pVar, this.f179942d, true, !TextUtils.isEmpty(this.f179940b.eId), this.f179940b.eId, null);
            }
        }
        ((IFavroamingManagerService) baseQQAppInterface.getRuntimeService(IFavroamingManagerService.class)).asyncIncreaseEmotionClickNum(this.f179940b);
    }
}
