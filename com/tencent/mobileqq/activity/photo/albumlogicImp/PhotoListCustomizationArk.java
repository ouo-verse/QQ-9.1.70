package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.aelight.camera.ae.play.AEQuDongConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.e;
import com.tencent.qphone.base.util.QLog;
import j91.a;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes10.dex */
public class PhotoListCustomizationArk extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String I;
    private String F;
    private boolean G;
    private String H;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68913);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            I = PhotoListCustomizationArk.class.getName();
        }
    }

    public PhotoListCustomizationArk(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        super.E(intent);
        this.F = intent.getStringExtra("key_ark_app_res_path");
        this.G = intent.getBooleanExtra("key_should_compress", false);
        this.H = intent.getStringExtra("key_ark_app_engine_res_dir");
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.F();
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListCustomizationArk", 2, "ArkApp ark app res:" + this.F);
        }
        this.D.findViewById(R.id.fyh).setVisibility(4);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        a.g().b("callbackArk", null, null);
        this.D.finish();
        QAlbumUtil.anim(this.D, false, false);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void O(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        this.f184313i.K.setClickable(false);
        if (!this.f184310e.selectedPhotoList.isEmpty()) {
            PhotoListSceneBase photoListSceneBase = this.f184313i;
            ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
            photoListSceneBase.s(arrayList.get(arrayList.size() - 1));
        }
        e.e();
        if (this.f184310e.selectedPhotoList.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.e(AEQuDongConstants.INTENT_KEY_PHOTOLIST, 2, "size == 0");
                return;
            }
            return;
        }
        this.D.getIntent();
        if (this.f184310e.selectedPhotoList.size() > 0) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder(this.f184310e.selectedPhotoList.size() * 128);
                for (int i3 = 0; i3 < this.f184310e.selectedPhotoList.size(); i3++) {
                    sb5.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", Integer.valueOf(i3), this.f184310e.selectedPhotoList.get(i3)));
                }
                QLog.d("PhotoListCustomizationArk", 2, sb5.toString());
            }
            this.C.P.b();
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationArk.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationArk.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("PhotoListCustomizationArk", 1, "copy file to res: " + PhotoListCustomizationArk.this.F);
                    }
                    PhotoListCustomizationArk photoListCustomizationArk = PhotoListCustomizationArk.this;
                    String d16 = a.d(photoListCustomizationArk.f184310e.selectedPhotoList, photoListCustomizationArk.F, PhotoListCustomizationArk.this.G, PhotoListCustomizationArk.this.H);
                    Bundle bundle = new Bundle();
                    bundle.putString("bundle_key_info", d16);
                    a.g().b("callbackArk", bundle, null);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationArk.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else if (((PhotoListCustomizationDefault) PhotoListCustomizationArk.this).D != null) {
                                ((PhotoListCustomizationDefault) PhotoListCustomizationArk.this).D.closeContextMenu();
                            }
                        }
                    });
                }
            });
        } else {
            a.g().b("callbackArk", null, null);
        }
        this.D.finish();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void P(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        a.g().b("callbackArk", null, null);
        this.D.finish();
        super.P(view);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        } else {
            super.R(intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public Intent k(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Intent) iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, i3);
        }
        Intent intent = this.D.getIntent();
        intent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
        intent.putExtra("key_ark_app_res_path", this.F);
        intent.putExtra("key_should_compress", this.G);
        intent.putExtra("key_ark_app_engine_res_dir", this.H);
        return super.k(view, i3);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void u(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
        } else {
            intent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
            super.u(intent);
        }
    }
}
