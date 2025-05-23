package com.tencent.qqnt.emotion.stickerrecommended;

import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.transfile.VasExtensionDownloaderConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmosmService;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.api.IFavroamingDBManagerService;
import cooperation.peak.PeakConstants;
import java.net.URL;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public class r extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public CustomEmotionData f356623f;

    /* renamed from: g, reason: collision with root package name */
    private Emoticon f356624g;

    /* renamed from: h, reason: collision with root package name */
    private String f356625h;

    public r(BaseQQAppInterface baseQQAppInterface, CustomEmotionData customEmotionData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) customEmotionData);
            return;
        }
        this.f356623f = customEmotionData;
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) baseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
        if (iFavroamingDBManagerService != null) {
            this.f356625h = iFavroamingDBManagerService.getCustomEmoticonPath(customEmotionData);
        }
        if (customEmotionData.isMarkFace) {
            this.f356624g = ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonById(customEmotionData.emoPath, customEmotionData.eId);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        Emoticon emoticon = this.f356624g;
        if (emoticon != null) {
            return emoticon.eId;
        }
        return getImgMd5();
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public void d(BaseQQAppInterface baseQQAppInterface, com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseQQAppInterface, (Object) aVar);
            return;
        }
        super.d(baseQQAppInterface, aVar);
        CustomEmotionData customEmotionData = this.f356623f;
        if (customEmotionData.isMarkFace && this.f356624g != null) {
            ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmoticon(baseQQAppInterface, aVar, this.f356624g, false);
            return;
        }
        if (customEmotionData.isLottieEmoji) {
            try {
                aVar.e().h(new AIOMsgSendEvent.EmojiFaceSendEvent(Integer.parseInt(customEmotionData.eId), true));
            } catch (Throwable unused) {
                QLog.e("StickerRecFavoriteData", 1, "[sendEmoticon] error, invalidate lottie emoji serverId = ", this.f356623f.eId);
            }
        } else {
            Intent intent = new Intent();
            intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_EPID, this.f356623f.jumpId);
            intent.putExtra(IPicBus.ORIGINAL_MD5, this.f356623f.md5);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.f356625h);
            ((IEmosmService) QRoute.api(IEmosmService.class)).sendRecEmoPic(baseQQAppInterface, aVar, c(), intent, arrayList);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        Emoticon emoticon = this.f356624g;
        if (emoticon != null) {
            return emoticon.epId;
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return 4;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getClickNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f356623f.clickNum;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getExposeNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f356623f.exposeNum;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getImgMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String str = this.f356623f.md5;
        if (str != null) {
            return str.toLowerCase();
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getImgUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f356623f.url;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0093 A[RETURN] */
    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public URL getProtocolURL() {
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (URL) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (!this.f356623f.isMarkFace) {
            try {
                url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_DYNAMIC, this.f356625h);
            } catch (Throwable th5) {
                QLog.e("StickerRecFavoriteData", 1, "StickerRecFavoriteData getURL url exception e = " + th5.getMessage());
                url = null;
                if (url == null) {
                }
            }
        } else {
            try {
                url = new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, EmotionConstants.FROM_AIO, this.f356623f.emoPath + "_" + this.f356623f.eId);
            } catch (Throwable th6) {
                QLog.e("StickerRecFavoriteData", 1, "StickerLocalRecData getURL url exception e = " + th6.getMessage());
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

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getReportEventPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "c-";
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) url, (Object) uRLDrawableOptions);
        }
        if (this.f356623f.isMarkFace && this.f356624g != null) {
            URLDrawable drawable = URLDrawable.getDrawable(url, uRLDrawableOptions);
            if (drawable.getStatus() != 1) {
                drawable.setTag(this.f356624g);
            }
            return drawable;
        }
        return super.getURLDrawable(url, uRLDrawableOptions);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public URLDrawable.URLDrawableOptions getURLDrawableOptions() {
        Emoticon emoticon;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (URLDrawable.URLDrawableOptions) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        CustomEmotionData customEmotionData = this.f356623f;
        if (customEmotionData.isMarkFace && (emoticon = this.f356624g) != null) {
            if (emoticon.isAPNG) {
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecFavoriteData", 2, "getURLDrawableOptions: APNG so loaded use apng image");
                }
                obtain.mUseApngImage = true;
                obtain.mPlayGifImage = false;
                obtain.mMemoryCacheKeySuffix = "useAPNG";
            }
            return obtain;
        }
        obtain.mExtraInfo = customEmotionData.url;
        return obtain;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        Emoticon emoticon = this.f356624g;
        if (emoticon != null && emoticon.parseSoundPrintString() != null && !this.f356624g.parseSoundPrintString().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public boolean isStickerRecFromLocal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public void onEmoticonWillShow(BaseQQAppInterface baseQQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseQQAppInterface, i3);
        }
    }
}
