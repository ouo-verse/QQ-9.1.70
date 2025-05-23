package com.tencent.qqnt.emotion.stickerrecommended;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.stickerrecommended.SimpleRemoteEmoticon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes24.dex */
public abstract class j extends a implements g {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public void d(BaseQQAppInterface baseQQAppInterface, com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseQQAppInterface, (Object) aVar);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public URL getProtocolURL() {
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (URL) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            url = new URL("sticker_recommended_pic", EmotionConstants.FROM_AIO, ((o) this).w());
        } catch (MalformedURLException e16) {
            QLog.e(SimpleRemoteEmoticon.TAG, 1, "getURL create url exception e = " + e16.getMessage());
            url = null;
        }
        if (url == null) {
            QLog.e(SimpleRemoteEmoticon.TAG, 1, "getURL url = null");
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
        return "z-";
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) url, (Object) uRLDrawableOptions);
        }
        if (url == null) {
            return null;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, uRLDrawableOptions);
        drawable.setTag(new int[]{0, 0, (int) uRLDrawableOptions.mGifRoundCorner});
        return drawable;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public URLDrawable.URLDrawableOptions getURLDrawableOptions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (URLDrawable.URLDrawableOptions) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mExtraInfo = this;
        obtain.mUseMemoryCache = false;
        return obtain;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public boolean isStickerRecFromLocal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public void onEmoticonWillShow(BaseQQAppInterface baseQQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseQQAppInterface, i3);
        }
    }
}
