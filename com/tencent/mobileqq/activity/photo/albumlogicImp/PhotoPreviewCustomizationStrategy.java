package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationStrategy extends PhotoPreviewCustomizationAIO {
    static IPatchRedirector $redirector_;
    public static final String S;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68978);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            S = PhotoPreviewCustomizationStrategy.class.getName();
        }
    }

    public PhotoPreviewCustomizationStrategy(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoPreviewActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Intent V = V(v().m());
        if (V != null) {
            this.f184197m.setResult(-1, V);
            this.f184197m.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO
    public void a0(boolean z16) {
        super.a0(z16);
        if (z16) {
            v().F.setVisibility(8);
            v().G.setVisibility(8);
        }
    }
}
