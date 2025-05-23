package com.tencent.mobileqq.qqlive.data.anchor.camera;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveCameraFilterInfo {
    static IPatchRedirector $redirector_;
    public String desc;

    /* renamed from: id, reason: collision with root package name */
    public String f271209id;
    public boolean isSelected;
    public int thumbHeight;
    public String thumbUrl;
    public int thumbWidth;

    public QQLiveCameraFilterInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveCameraFilterInfo(String str, String str2, String str3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f271209id = str;
        this.thumbUrl = str2;
        this.desc = str3;
        this.thumbHeight = i3;
        this.thumbWidth = i16;
    }
}
