package com.tencent.mobileqq.album;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.common.b;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;

@Keep
/* loaded from: classes11.dex */
public class PhotoListCustomizationScanner extends PickerCustomizationBase<a> {
    static IPatchRedirector $redirector_;

    public PhotoListCustomizationScanner(@NonNull FragmentActivity fragmentActivity, @NonNull b<a> bVar) {
        super(fragmentActivity, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragmentActivity, (Object) bVar);
        }
    }
}
