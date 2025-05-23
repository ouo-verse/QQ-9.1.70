package com.tencent.qqnt.emotion.stickerrecommended.ad;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent;
import com.tencent.qqnt.emotion.stickerrecommended.n;
import java.net.URL;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes24.dex */
public class e extends com.tencent.qqnt.emotion.stickerrecommended.c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    c f356445f;

    /* renamed from: g, reason: collision with root package name */
    String f356446g;

    /* renamed from: h, reason: collision with root package name */
    int f356447h;

    public e(c cVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) str);
        } else {
            this.f356445f = cVar;
            this.f356446g = str;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public void d(BaseQQAppInterface baseQQAppInterface, com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) baseQQAppInterface, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecAdData", 2, "sendEmoticon");
        }
        if (this.f356445f == null) {
            return;
        }
        aVar.e().h(new StickerRecommendEvent.SendSticker(n.a(h()), this.f356446g, null));
        MqqHandler handler = baseQQAppInterface.getHandler(getClass());
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(94));
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return 5;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getClickNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getExposeNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getImgMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        c cVar = this.f356445f;
        if (cVar != null) {
            return cVar.f356437b;
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getImgUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        c cVar = this.f356445f;
        if (cVar != null) {
            return cVar.f356436a;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044 A[RETURN] */
    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public URL getProtocolURL() {
        URL url;
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (URL) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            cVar = this.f356445f;
        } catch (Exception e16) {
            QLog.e("StickerRecAdData", 1, "getProtocolURL error ", e16);
        }
        if (cVar != null && !TextUtils.isEmpty(cVar.f356437b)) {
            url = new URL("sticker_recommended_pic", EmotionConstants.FROM_AIO, this.f356445f.f356437b);
            if (url != null) {
                QLog.e("StickerRecAdData", 1, "getURL url = null");
                return null;
            }
            return url;
        }
        url = null;
        if (url != null) {
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getReportEventPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public String getThumbUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        c cVar = this.f356445f;
        if (cVar != null) {
            return cVar.f356436a;
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) url, (Object) uRLDrawableOptions);
        }
        if (url == null) {
            return null;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, uRLDrawableOptions);
        drawable.setTag(new int[]{0, 0, (int) uRLDrawableOptions.mGifRoundCorner});
        return drawable;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.c, com.tencent.qqnt.emotion.stickerrecommended.g
    public URLDrawable.URLDrawableOptions getURLDrawableOptions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (URLDrawable.URLDrawableOptions) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mExtraInfo = this;
        return obtain;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        c cVar = this.f356445f;
        if (cVar != null) {
            return cVar.f356436a;
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public void onEmoticonWillShow(BaseQQAppInterface baseQQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) baseQQAppInterface, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecAdData", 2, "onEmoticonWillShow, index = " + i3);
        }
        this.f356447h = i3;
    }
}
