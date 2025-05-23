package com.tencent.mobileqq.pic.operator;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ac;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes16.dex */
public class k extends UploadPicOperator {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pic.operator.BasePicOperator
    public void o(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageForPic);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseMemoryCache = false;
        obtain.mLoadingDrawable = ((IPicFlash) QRoute.api(IPicFlash.class)).getFlashPicReadedDrawable();
        URLDrawable drawable = ((IPicHelper) QRoute.api(IPicHelper.class)).getDrawable(messageForPic, 65537, null, obtain);
        obtain.isFlashPic = true;
        drawable.setDecodeHandler(((IPicFlash) QRoute.api(IPicFlash.class)).getFlashPicDecodeHandler());
        drawable.downloadImediatly();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    public void w(MessageForPic messageForPic, v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageForPic, (Object) vVar);
        } else {
            super.w(messageForPic, vVar);
            ac.e(messageForPic, false);
        }
    }
}
