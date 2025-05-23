package com.tencent.autotemplate.utils;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tavsticker.model.TAVSticker;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TavStickerUtils {
    static IPatchRedirector $redirector_;

    public TavStickerUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static TAVSticker createSticker(@NonNull String str, boolean z16) {
        TAVSticker init;
        try {
            if (z16) {
                init = new TAVSticker().setAssetFilePath(str).setScale(1.0f).setRotate(0.0f).setCenterX(0.5f).setCenterY(0.5f).init();
            } else {
                init = new TAVSticker().setFilePath(str).setScale(1.0f).setRotate(0.0f).setCenterX(0.5f).setCenterY(0.5f).init();
            }
            return init;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
