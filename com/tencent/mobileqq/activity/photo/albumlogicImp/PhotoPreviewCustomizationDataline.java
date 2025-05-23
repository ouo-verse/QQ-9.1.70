package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationDataline extends PhotoPreviewCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String G;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68965);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            G = PhotoPreviewCustomizationDataline.class.getName();
        }
    }

    protected PhotoPreviewCustomizationDataline(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoPreviewActivity);
        }
    }

    private void N(boolean z16) {
        if (z16) {
            v().C.setVisibility(8);
            v().F.setVisibility(8);
            v().G.setVisibility(8);
            return;
        }
        if (this.C.f184258q) {
            v().C.setVisibility(0);
        } else {
            v().C.setVisibility(8);
        }
        if (this.C.f184257p) {
            v().F.setVisibility(0);
            v().G.setVisibility(0);
        } else {
            v().F.setVisibility(8);
            v().G.setVisibility(8);
        }
        if (this.C.f184263v || this.f184334e.isSingleMode) {
            v().F.setVisibility(8);
            v().G.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        ArrayList<String> arrayList = this.f184334e.selectedPhotoList;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void C(View view, int i3, Bundle bundle, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, Integer.valueOf(i3), bundle, Integer.valueOf(i16), intent);
            return;
        }
        if (bundle != null) {
            bundle.putBoolean("key_multi_edit_pic", true);
            bundle.putBoolean(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, true);
        }
        super.C(view, 10000, bundle, i16, intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void a() {
        RichMediaBaseData richMediaBaseData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.a();
        RichMediaBrowserInfo item = v().getItem(v().i());
        boolean z16 = true;
        if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() != 101) {
            z16 = false;
        }
        N(z16);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void k(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        super.k(i3);
        if (v().getItem(i3).baseData.getType() == 101) {
            z16 = true;
        } else {
            z16 = false;
        }
        N(z16);
    }
}
