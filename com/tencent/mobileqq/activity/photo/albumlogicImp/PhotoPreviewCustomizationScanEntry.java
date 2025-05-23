package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.i;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationScanEntry extends PhotoPreviewCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String G;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68977);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            G = PhotoPreviewCustomizationScanEntry.class.getName();
        }
    }

    protected PhotoPreviewCustomizationScanEntry(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoPreviewActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.a();
        if (this.C.f184324b.size() > 1) {
            v().L.setText((this.C.f184332j + 1) + " / " + this.C.f184324b.size());
            return;
        }
        v().L.setText(this.f184197m.getResources().getString(R.string.d09));
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void j(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        int intExtra = this.f184197m.getIntent().getIntExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, -1);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        ArrayList<String> arrayList = new ArrayList<>();
        if (stringArrayListExtra != null) {
            arrayList.addAll(stringArrayListExtra);
        }
        super.j(intent);
        this.C.f184324b.clear();
        i iVar = this.C;
        iVar.f184324b = arrayList;
        iVar.f184329g = arrayList.size();
        i iVar2 = this.C;
        iVar2.f184332j = intExtra;
        if (intExtra >= iVar2.f184329g) {
            iVar2.f184332j = -1;
        }
        this.f184334e.selectedIndex.clear();
        this.f184334e.selectedIndex.add(Integer.valueOf(this.C.f184332j));
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
        ArrayList<String> arrayList2 = photoCommonBaseData.selectedPhotoList;
        if (arrayList2 == null) {
            photoCommonBaseData.selectedPhotoList = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        if (stringExtra != null && !stringExtra.equals("")) {
            this.f184334e.selectedPhotoList.add(stringExtra);
        }
        QLog.d("PhotoPreviewCustomizationScanEntry", 1, "count=", Integer.valueOf(this.C.f184329g), " pos=", Integer.valueOf(this.C.f184332j));
        this.f184337i.notifyImageListChanged(this.f184337i.g(), this.C.f184332j);
    }
}
