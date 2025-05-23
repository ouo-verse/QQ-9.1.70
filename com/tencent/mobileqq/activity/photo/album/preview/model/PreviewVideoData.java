package com.tencent.mobileqq.activity.photo.album.preview.model;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

/* loaded from: classes10.dex */
public class PreviewVideoData extends RichMediaBaseData {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public LocalMediaInfo f184339d;

    public PreviewVideoData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.richmediabrowser.model.RichMediaBaseData
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 101;
    }
}
