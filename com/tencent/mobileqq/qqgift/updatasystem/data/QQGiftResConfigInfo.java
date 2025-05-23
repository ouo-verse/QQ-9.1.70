package com.tencent.mobileqq.qqgift.updatasystem.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGiftResConfigInfo implements Serializable {
    static IPatchRedirector $redirector_;

    /* renamed from: bg, reason: collision with root package name */
    @SerializedName(VasProfileTemplatePreloadHelper.BACKGROUND)
    public ResConfigDetailInfo f265036bg;

    @SerializedName("thumb")
    public ResConfigDetailInfo thumb;

    public QQGiftResConfigInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.thumb = new ResConfigDetailInfo();
            this.f265036bg = new ResConfigDetailInfo();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "QQGiftResConfigInfo{thumb=" + this.thumb + ", bg=" + this.f265036bg + '}';
    }

    public QQGiftResConfigInfo(ResConfigDetailInfo resConfigDetailInfo, ResConfigDetailInfo resConfigDetailInfo2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) resConfigDetailInfo, (Object) resConfigDetailInfo2);
            return;
        }
        this.thumb = new ResConfigDetailInfo();
        new ResConfigDetailInfo();
        this.thumb = resConfigDetailInfo;
        this.f265036bg = resConfigDetailInfo2;
    }
}
