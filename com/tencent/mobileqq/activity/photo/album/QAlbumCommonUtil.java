package com.tencent.mobileqq.activity.photo.album;

import android.content.res.Resources;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QAlbumCommonUtil {
    static IPatchRedirector $redirector_;

    public QAlbumCommonUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final int dp2px(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }
}
