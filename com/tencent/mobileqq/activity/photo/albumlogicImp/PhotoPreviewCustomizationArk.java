package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import j91.a;
import java.util.Locale;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationArk extends PhotoPreviewCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String J;
    private String G;
    private boolean H;
    private String I;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68964);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            J = PhotoPreviewCustomizationArk.class.getName();
        }
    }

    public PhotoPreviewCustomizationArk(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
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
        } else {
            super.a();
            v().H.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationArk.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationArk.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        PhotoPreviewCustomizationArk.this.v().H.setClickable(false);
                        if (PhotoPreviewCustomizationArk.this.f184334e.selectedPhotoList.size() > 0) {
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder(PhotoPreviewCustomizationArk.this.f184334e.selectedPhotoList.size() * 128);
                                for (int i3 = 0; i3 < PhotoPreviewCustomizationArk.this.f184334e.selectedPhotoList.size(); i3++) {
                                    sb5.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", Integer.valueOf(i3), PhotoPreviewCustomizationArk.this.f184334e.selectedPhotoList.get(i3)));
                                }
                                QLog.d("PhotoPreviewCustomizationArk", 2, sb5.toString());
                            }
                            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationArk.1.1
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
                                        return;
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("PhotoPreviewCustomizationArk", 2, "ArkApp copy file to res: " + PhotoPreviewCustomizationArk.this.G);
                                    }
                                    PhotoPreviewCustomizationArk photoPreviewCustomizationArk = PhotoPreviewCustomizationArk.this;
                                    String d16 = a.d(photoPreviewCustomizationArk.f184334e.selectedPhotoList, photoPreviewCustomizationArk.G, PhotoPreviewCustomizationArk.this.H, PhotoPreviewCustomizationArk.this.I);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("bundle_key_info", d16);
                                    a.g().b("callbackArk", bundle, null);
                                }
                            });
                        } else {
                            a.g().b("callbackArk", null, null);
                        }
                        ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationArk.this).f184197m.finish();
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void j(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        super.j(intent);
        this.G = intent.getStringExtra("key_ark_app_res_path");
        this.H = intent.getBooleanExtra("key_should_compress", false);
        this.I = intent.getStringExtra("key_ark_app_engine_res_dir");
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (PhotoCommonBaseData.FROM_PHOTO_LIST.equals(this.C.f184326d)) {
            Intent intent = this.f184197m.getIntent();
            intent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
            intent.putExtra("key_ark_app_res_path", this.G);
            intent.putExtra("key_should_compress", this.H);
            intent.putExtra("key_ark_app_engine_res_dir", this.I);
            intent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
        }
        super.onBackPressed();
    }
}
