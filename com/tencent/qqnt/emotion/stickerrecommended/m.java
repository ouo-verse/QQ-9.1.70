package com.tencent.qqnt.emotion.stickerrecommended;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.VasExtensionDownloaderConstant;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes24.dex */
public class m extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private CameraEmotionData f356553f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f356554g;

    /* renamed from: h, reason: collision with root package name */
    private String f356555h;

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public void d(BaseQQAppInterface baseQQAppInterface, com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseQQAppInterface, (Object) aVar);
        } else {
            this.f356554g = true;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getClickNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.f356553f.clickNum;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getExposeNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f356553f.exposeNum;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getImgMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        String str = this.f356553f.md5;
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
        return this.f356553f.url;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public URL getProtocolURL() {
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (URL) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_CAMERA_EMO_PANEL_DYNAMIC, this.f356555h);
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

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getReportEventPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "a-";
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) url, (Object) uRLDrawableOptions);
        }
        if (url == null) {
            return null;
        }
        return super.getURLDrawable(url, uRLDrawableOptions);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public URLDrawable.URLDrawableOptions getURLDrawableOptions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (URLDrawable.URLDrawableOptions) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mExtraInfo = this.f356553f.url;
        return obtain;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public boolean isClicked() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f356554g;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public boolean isExposed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
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
