package com.tencent.mobileqq.emoticonview;

import android.os.Parcel;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class HotPicSearchEmoticonCompositeInfo extends HotPicSearchEmoticonInfo {
    static IPatchRedirector $redirector_;

    public HotPicSearchEmoticonCompositeInfo(int i3, int i16, String str, EmotionSearchItem emotionSearchItem) {
        super(i3, i16, str, emotionSearchItem);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str, emotionSearchItem);
    }

    protected HotPicSearchEmoticonCompositeInfo(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
    }
}
