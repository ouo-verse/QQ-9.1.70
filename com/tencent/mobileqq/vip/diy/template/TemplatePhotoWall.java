package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes20.dex */
public class TemplatePhotoWall extends PhotoWallView {
    static IPatchRedirector $redirector_;

    public TemplatePhotoWall(Context context, QQAppInterface qQAppInterface, String str) {
        super(context, qQAppInterface, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, str);
        } else {
            this.mEmptyBgView.setAlpha(0.8f);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView
    protected int getLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.ben;
    }
}
