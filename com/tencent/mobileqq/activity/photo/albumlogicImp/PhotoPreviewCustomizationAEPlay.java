package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import com.tencent.aelight.camera.play.api.IAETemplateInfo;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.util.api.IPicChooseJumpUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.i;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationAEPlay extends PhotoPreviewCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String G;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68955);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            G = PhotoPreviewCustomizationAEPlay.class.getName();
        }
    }

    PhotoPreviewCustomizationAEPlay(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoPreviewActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T() {
        if (this.f184334e.selectedPhotoList.size() < this.f184334e.maxSelectNum) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        i iVar = this.C;
        if (currentTimeMillis - iVar.f184328f >= 700) {
            iVar.f184328f = currentTimeMillis;
            QQToast.makeText(this.f184197m, str, 0).show(this.f184197m.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.a();
            v().H.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAEPlay.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationAEPlay.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                    } else if (PhotoPreviewCustomizationAEPlay.this.T()) {
                        QLog.d("PhotoPreviewCustomizationAEPlay", 2, "need more pic.");
                        PhotoPreviewCustomizationAEPlay photoPreviewCustomizationAEPlay = PhotoPreviewCustomizationAEPlay.this;
                        photoPreviewCustomizationAEPlay.U(String.format(((PhotoPreviewCustomizationDefault) photoPreviewCustomizationAEPlay).f184197m.getString(R.string.a9v), Integer.valueOf(PhotoPreviewCustomizationAEPlay.this.f184334e.maxSelectNum)));
                    } else {
                        PhotoPreviewCustomizationAEPlay.this.v().H.setClickable(false);
                        Intent intent = new Intent();
                        intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", PhotoPreviewCustomizationAEPlay.this.f184334e.selectedPhotoList);
                        intent.putExtra(IPicChooseJumpUtil.PIC_NODE_ID, ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationAEPlay.this).f184197m.getIntent().getIntExtra(IPicChooseJumpUtil.PIC_NODE_ID, 0));
                        intent.putExtra(IPicChooseJumpUtil.PIC_RESULT_BACK_TYPE, 0);
                        ((IAETemplateInfo) QRoute.api(IAETemplateInfo.class)).sendPickedPhotosToMe(((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationAEPlay.this).f184197m, intent);
                        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportPicChooseNextBtn();
                        ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationAEPlay.this).f184197m.finish();
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.g();
        v().H.setText(this.f184197m.getString(R.string.fzq) + " " + this.f184334e.selectedPhotoList.size() + "/" + this.f184334e.maxSelectNum);
        v().H.setEnabled(true);
        if (T()) {
            v().H.setBackgroundResource(R.drawable.skin_aio_album_send_button_disabled);
        } else {
            v().H.setBackgroundResource(R.drawable.f160083a4);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void p(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (!this.f184334e.selectedIndex.contains(Integer.valueOf(v().i())) && this.f184334e.selectedPhotoList.size() >= this.f184334e.maxSelectNum) {
            U(String.format(this.f184197m.getString(R.string.a9u), Integer.valueOf(this.f184334e.maxSelectNum)));
        } else {
            super.p(view);
        }
    }
}
