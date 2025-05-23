package com.tencent.youtu.ytagreflectlivecheck.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTActReflectData {
    static IPatchRedirector $redirector_;
    public YTActReflectImage best;
    public YTActReflectImage eye;
    public YTActReflectImage mouth;
    public LiveStyleRequester.SeleceData select_data;

    public YTActReflectData(YTActReflectImage yTActReflectImage, YTActReflectImage yTActReflectImage2, YTActReflectImage yTActReflectImage3, LiveStyleRequester.SeleceData seleceData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, yTActReflectImage, yTActReflectImage2, yTActReflectImage3, seleceData);
            return;
        }
        this.best = yTActReflectImage;
        this.eye = yTActReflectImage2;
        this.mouth = yTActReflectImage3;
        this.select_data = seleceData;
    }
}
