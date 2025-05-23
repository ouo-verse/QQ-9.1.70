package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.BasePhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationFileAssistant extends PhotoPreviewCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String G;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68970);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            G = PhotoPreviewCustomizationFileAssistant.class.getName();
        }
    }

    public PhotoPreviewCustomizationFileAssistant(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoPreviewActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), bundle, Integer.valueOf(i16), intent);
            return;
        }
        if (bundle != null) {
            bundle.putBoolean("key_multi_edit_pic", true);
            bundle.putBoolean(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, true);
        }
        super.C(view, 10000, bundle, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void J() {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQAlbum", 2, "sendPicAndVideoToFileAssistant...");
        }
        BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
        if (basePhotoPreviewActivity != null && !basePhotoPreviewActivity.isFinishing()) {
            if (this.f184197m.getIntent().getParcelableExtra(PeakConstants.KEY_SEND_TO_AIO_INTENT) != null) {
                intent = (Intent) this.f184197m.getIntent().getParcelableExtra(PeakConstants.KEY_SEND_TO_AIO_INTENT);
            } else {
                intent = this.f184197m.getIntent();
            }
            intent.setExtrasClassLoader(PeakConstants.class.getClassLoader());
            intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1052);
            intent.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
            intent.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
            intent.putExtra("PhotoConst.PHOTO_PATHS", v().m());
            this.f184197m.setResult(-1, intent);
            this.f184197m.finish();
            QAlbumUtil.anim(this.f184197m, false, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        super.k(i3);
        if (v().getItem(i3).baseData.getType() == 101) {
            v().C.setVisibility(8);
            v().F.setVisibility(8);
            v().G.setVisibility(8);
            v().D.setVisibility(8);
            v().E.setVisibility(8);
            return;
        }
        if (this.C.f184258q) {
            v().C.setVisibility(0);
        } else {
            v().C.setVisibility(8);
        }
        v().F.setVisibility(8);
        v().G.setVisibility(8);
        v().D.setVisibility(8);
        v().E.setVisibility(8);
    }
}
