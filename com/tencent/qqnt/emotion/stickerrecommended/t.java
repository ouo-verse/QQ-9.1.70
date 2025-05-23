package com.tencent.qqnt.emotion.stickerrecommended;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmojiManagerService;
import com.tencent.qqnt.emotion.api.IEmosmService;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes24.dex */
public class t extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public Emoticon f356642f;

    /* renamed from: g, reason: collision with root package name */
    private String f356643g;

    public t(Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticon);
        } else {
            this.f356642f = emoticon;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        Emoticon emoticon = this.f356642f;
        if (emoticon != null) {
            return emoticon.eId;
        }
        return getImgMd5();
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public void d(BaseQQAppInterface baseQQAppInterface, com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) aVar);
            return;
        }
        super.d(baseQQAppInterface, aVar);
        ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmoticon(baseQQAppInterface, aVar, this.f356642f, false);
        Emoticon emoticon = this.f356642f;
        if (emoticon != null) {
            emoticon.isNewSoundEmoticon();
        }
        ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncIncreaseEmotionClickNum(this.f356642f);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        Emoticon emoticon = this.f356642f;
        if (emoticon != null) {
            return emoticon.epId;
        }
        return this.f356643g;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getClickNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f356642f.clickNum;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getExposeNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f356642f.exposeNum;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getImgMd5() {
        String replace;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String str = this.f356643g;
        if (str != null) {
            return str;
        }
        Emoticon emoticon = this.f356642f;
        if (emoticon.isAPNG) {
            replace = com.tencent.qqnt.emotion.constant.d.f356211i.replace("[epId]", emoticon.epId).replace("[eId]", this.f356642f.eId);
        } else {
            replace = com.tencent.qqnt.emotion.constant.d.f356212j.replace("[epId]", emoticon.epId).replace("[eId]", this.f356642f.eId);
        }
        byte[] fileMd5 = MD5.getFileMd5(replace);
        if (fileMd5 != null) {
            String md5 = MD5.toMD5(fileMd5);
            this.f356643g = md5;
            if (md5 != null) {
                this.f356643g = md5.toLowerCase();
            }
            return this.f356643g;
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getImgUrl() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof BaseQQAppInterface)) {
            return null;
        }
        boolean supportExtensionDisplay = ((IEmojiManagerService) ((BaseQQAppInterface) waitAppRuntime).getRuntimeService(IEmojiManagerService.class)).supportExtensionDisplay(this.f356642f);
        Emoticon emoticon = this.f356642f;
        String str3 = "200";
        if (emoticon.isAPNG) {
            String replace = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]_apng".replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", this.f356642f.eId);
            if (!supportExtensionDisplay) {
                str2 = "200";
            } else {
                str2 = String.valueOf(this.f356642f.extensionWidth);
            }
            String replace2 = replace.replace("[width]", str2);
            if (supportExtensionDisplay) {
                str3 = String.valueOf(this.f356642f.extensionHeight);
            }
            return replace2.replace("[height]", str3);
        }
        String replace3 = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]".replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", this.f356642f.eId);
        if (!supportExtensionDisplay) {
            str = "200";
        } else {
            str = String.valueOf(this.f356642f.extensionWidth);
        }
        String replace4 = replace3.replace("[width]", str);
        if (supportExtensionDisplay) {
            str3 = String.valueOf(this.f356642f.extensionHeight);
        }
        return replace4.replace("[height]", str3);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public URL getProtocolURL() {
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (URL) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            url = new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, EmotionConstants.FROM_AIO, this.f356642f.epId + "_" + this.f356642f.eId);
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

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getReportEventPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (h()) {
            return "d-";
        }
        return "b-";
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url, (Object) uRLDrawableOptions);
        }
        if (url == null) {
            return null;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, uRLDrawableOptions);
        if (drawable.getStatus() != 1) {
            drawable.setTag(this.f356642f);
        }
        return drawable;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public URLDrawable.URLDrawableOptions getURLDrawableOptions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (URLDrawable.URLDrawableOptions) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (this.f356642f.isAPNG) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecLocalData", 2, "getURLDrawableOptions: APNG so loaded use apng image");
            }
            obtain.mUseApngImage = true;
            obtain.mPlayGifImage = false;
            obtain.mMemoryCacheKeySuffix = "useAPNG";
        }
        return obtain;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.f356642f.parseSoundPrintString() != null && !this.f356642f.parseSoundPrintString().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public void onEmoticonWillShow(BaseQQAppInterface baseQQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseQQAppInterface, i3);
        } else {
            ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncIncreaseEmoticonExposeNum(this);
        }
    }
}
