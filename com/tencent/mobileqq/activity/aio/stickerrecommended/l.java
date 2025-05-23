package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class l extends b {

    /* renamed from: b, reason: collision with root package name */
    public Emoticon f179944b;

    /* renamed from: c, reason: collision with root package name */
    private String f179945c;

    public l(Emoticon emoticon) {
        this.f179944b = emoticon;
    }

    public boolean a() {
        if (this.f179944b.parseSoundPrintString() != null && !this.f179944b.parseSoundPrintString().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getBusinessType() {
        return 2;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getClickNum() {
        return this.f179944b.clickNum;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getExposeNum() {
        return this.f179944b.exposeNum;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getImgMd5() {
        String replace;
        String str = this.f179945c;
        if (str != null) {
            return str;
        }
        Emoticon emoticon = this.f179944b;
        if (emoticon.isAPNG) {
            replace = MarketFaceConstants.emoticonAPNGPath.replace("[epId]", emoticon.epId).replace("[eId]", this.f179944b.eId);
        } else {
            replace = MarketFaceConstants.emoticonEncryptPath.replace("[epId]", emoticon.epId).replace("[eId]", this.f179944b.eId);
        }
        byte[] fileMd5 = MD5.getFileMd5(replace);
        if (fileMd5 != null) {
            String md5 = MD5.toMD5(fileMd5);
            this.f179945c = md5;
            if (md5 != null) {
                this.f179945c = md5.toLowerCase();
            }
            return this.f179945c;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getImgUrl() {
        String str;
        String str2;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof BaseQQAppInterface)) {
            return null;
        }
        boolean supportExtensionDisplay = ((IEmojiManagerService) ((BaseQQAppInterface) waitAppRuntime).getRuntimeService(IEmojiManagerService.class)).supportExtensionDisplay(this.f179944b);
        Emoticon emoticon = this.f179944b;
        String str3 = "200";
        if (emoticon.isAPNG) {
            String replace = EmotionPanelConstans.emoticonEncryptExtensionApngUrl.replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", this.f179944b.eId);
            if (!supportExtensionDisplay) {
                str2 = "200";
            } else {
                str2 = String.valueOf(this.f179944b.extensionWidth);
            }
            String replace2 = replace.replace("[width]", str2);
            if (supportExtensionDisplay) {
                str3 = String.valueOf(this.f179944b.extensionHeight);
            }
            return replace2.replace("[height]", str3);
        }
        String replace3 = EmotionPanelConstans.emoticonEncryptExtensionUrl.replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", this.f179944b.eId);
        if (!supportExtensionDisplay) {
            str = "200";
        } else {
            str = String.valueOf(this.f179944b.extensionWidth);
        }
        String replace4 = replace3.replace("[width]", str);
        if (supportExtensionDisplay) {
            str3 = String.valueOf(this.f179944b.extensionHeight);
        }
        return replace4.replace("[height]", str3);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URL getProtocolURL() {
        URL url;
        try {
            url = new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, EmotionConstants.FROM_AIO, this.f179944b.epId + "_" + this.f179944b.eId);
        } catch (MalformedURLException e16) {
            QLog.e("StickerRecLocalData", 1, "StickerLocalRecData getURL url exception e = " + e16.getMessage());
            url = null;
        }
        if (url == null) {
            QLog.e("StickerRecLocalData", 1, "StickerLocalRecData getURL url = null");
            return null;
        }
        return url;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getReportEventPrefix() {
        if (a()) {
            return "d-";
        }
        return "b-";
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (url == null) {
            return null;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, uRLDrawableOptions);
        if (drawable.getStatus() != 1) {
            drawable.setTag(this.f179944b);
        }
        return drawable;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URLDrawable.URLDrawableOptions getURLDrawableOptions() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (this.f179944b.isAPNG) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecLocalData", 2, "getURLDrawableOptions: APNG so loaded use apng image");
            }
            obtain.mUseApngImage = true;
            obtain.mPlayGifImage = false;
            obtain.mMemoryCacheKeySuffix = "useAPNG";
        }
        return obtain;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public void onEmoticonWillShow(BaseQQAppInterface baseQQAppInterface, int i3) {
        ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncIncreaseEmoticonExposeNum(this);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public void sendEmoticon(BaseQQAppInterface baseQQAppInterface, Context context, com.tencent.mobileqq.activity.aio.p pVar) {
        super.sendEmoticon(baseQQAppInterface, context, pVar);
        ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmosmMsg(baseQQAppInterface, context, pVar, this.f179944b);
        Emoticon emoticon = this.f179944b;
        if (emoticon != null && emoticon.isNewSoundEmoticon()) {
            EmoticonOperateReport.reportNewSoundEvent(baseQQAppInterface, "0X800A932", pVar.f179555d, this.f179944b.epId);
        }
        ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncIncreaseEmotionClickNum(this.f179944b);
    }
}
