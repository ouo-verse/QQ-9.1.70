package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.aelight.camera.play.api.IAETemplateInfo;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.util.api.IPicChooseJumpUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.g;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;

/* loaded from: classes10.dex */
public class PhotoListCustomizationAEPlay extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String F;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68906);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            F = PhotoListCustomizationAEPlay.class.getName();
        }
    }

    PhotoListCustomizationAEPlay(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    private void G0(Intent intent) {
        this.D.setResult(-1, intent);
        this.D.finish();
    }

    private boolean H0() {
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity == null || basePhotoListActivity.getIntent() == null) {
            return false;
        }
        return this.D.getIntent().getBooleanExtra(IPicChooseJumpUtil.PIC_BACK_TYPE_RESULT, false);
    }

    private boolean I0() {
        if (this.f184310e.selectedPhotoList.size() < this.f184310e.maxSelectNum) {
            return true;
        }
        return false;
    }

    private void J0(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        g gVar = this.C;
        if (currentTimeMillis - gVar.f184299j >= 1000) {
            gVar.f184299j = currentTimeMillis;
            QQToast.makeText(this.D, str, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void J(View view, int i3, CheckBox checkBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Integer.valueOf(i3), checkBox);
        } else if (!I0() && this.f184313i.Q.m0(i3).selectStatus != 1) {
            J0(String.format(this.D.getString(R.string.a9u), Integer.valueOf(this.f184310e.maxSelectNum)));
        } else {
            super.J(view, i3, checkBox);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void L(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            super.L(view);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void O(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            return;
        }
        if (I0()) {
            J0(String.format(this.D.getString(R.string.a9v), Integer.valueOf(this.f184310e.maxSelectNum)));
            return;
        }
        this.f184313i.K.setClickable(false);
        Intent intent = new Intent();
        intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184310e.selectedPhotoList);
        intent.putExtra(IPicChooseJumpUtil.PIC_NODE_ID, this.D.getIntent().getIntExtra(IPicChooseJumpUtil.PIC_NODE_ID, 0));
        intent.putExtra(IPicChooseJumpUtil.PIC_RESULT_BACK_TYPE, 0);
        ((IAETemplateInfo) QRoute.api(IAETemplateInfo.class)).sendPickedPhotosToMe(this.D, intent);
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportPicChooseNextBtn();
        G0(intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.T();
        this.f184313i.K.setText(this.D.getString(R.string.fzq) + " " + this.f184310e.selectedPhotoList.size() + "/" + this.f184310e.maxSelectNum);
        this.f184313i.K.setEnabled(true);
        if (I0()) {
            this.f184313i.K.setBackgroundResource(R.drawable.skin_aio_album_send_button_disabled);
        } else {
            this.f184313i.K.setBackgroundResource(R.drawable.f160083a4);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean a(LocalMediaInfo localMediaInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, localMediaInfo, Boolean.valueOf(z16))).booleanValue();
        }
        if (localMediaInfo == null) {
            return false;
        }
        if (localMediaInfo.selectStatus == 2 && z16 && !I0()) {
            J0(String.format(this.D.getString(R.string.a9u), Integer.valueOf(this.f184310e.maxSelectNum)));
            return false;
        }
        return super.a(localMediaInfo, z16);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void l(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, i3);
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        Intent intent = new Intent();
        String str = "";
        if (H0()) {
            if (m06 != null) {
                str = m06.path;
            }
            intent.putExtra("PhotoConst.SELECTED_PATHS", str);
        } else {
            if (m06 != null) {
                str = m06.path;
            }
            intent.putExtra("PhotoConst.SELECTED_PATHS", str);
            intent.putExtra(IPicChooseJumpUtil.PIC_NODE_ID, this.D.getIntent().getIntExtra(IPicChooseJumpUtil.PIC_NODE_ID, 0));
            intent.putExtra(IPicChooseJumpUtil.PIC_RESULT_BACK_TYPE, 1);
            ((IAETemplateInfo) QRoute.api(IAETemplateInfo.class)).sendPickedPhotosToMe(this.D, intent);
        }
        G0(intent);
    }
}
