package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Button;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.h;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class PhotoListCustomizationFileAssistant extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String F;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68925);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            F = PhotoListCustomizationFileAssistant.class.getName();
        }
    }

    public PhotoListCustomizationFileAssistant(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    protected void B0(Intent intent, boolean z16, ArrayList<String> arrayList) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, Boolean.valueOf(z16), arrayList);
            return;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        for (int i16 = 0; i16 < this.f184310e.selectedPhotoList.size(); i16++) {
            if (!ImageManager.isNetworkUrl(this.f184310e.selectedPhotoList.get(i16))) {
                LocalMediaInfo m06 = this.f184313i.Q.m0(i16);
                if (QAlbumUtil.getMediaType(m06) == 1 && m06 != null) {
                    SendVideoInfo sendVideoInfo = new SendVideoInfo();
                    sendVideoInfo.fileSize = m06.fileSize;
                    sendVideoInfo.duration = m06.mDuration;
                    hashMap.put(Integer.valueOf(i3), sendVideoInfo);
                }
                i3++;
            }
        }
        if (!hashMap.isEmpty()) {
            intent.putExtra(PeakConstants.VIDEO_INFO, hashMap);
            z17 = true;
        } else {
            z17 = false;
        }
        if (h.f287891c != 0 && System.currentTimeMillis() - h.f287891c < MiniBoxNoticeInfo.MIN_5) {
            z18 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "PhotoListCustomizationDataline isConfirmed=" + z18 + " allowUploadInXGTime=" + h.f287891c);
        }
        if (NetworkUtil.isMobileNetWork(BaseApplication.getContext()) && !z18 && z17) {
            DialogUtil.createCustomDialog(this.D, 232, null, this.D.getResources().getString(R.string.f173101he2), new DialogInterface.OnClickListener(new Runnable(intent) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationFileAssistant.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Intent f184391d;

                {
                    this.f184391d = intent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationFileAssistant.this, (Object) intent);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    PhotoListCustomizationFileAssistant photoListCustomizationFileAssistant = PhotoListCustomizationFileAssistant.this;
                    photoListCustomizationFileAssistant.H0(((PhotoListCustomizationDefault) photoListCustomizationFileAssistant).D, this.f184391d, PhotoListCustomizationFileAssistant.this.f184310e.selectedPhotoList);
                    h.f287891c = System.currentTimeMillis();
                }
            }) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationFileAssistant.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Runnable f184392d;

                {
                    this.f184392d = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationFileAssistant.this, (Object) r5);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i17) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i17);
                    } else {
                        this.f184392d.run();
                    }
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationFileAssistant.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationFileAssistant.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i17) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i17);
                        return;
                    }
                    Button button = PhotoListCustomizationFileAssistant.this.f184313i.K;
                    if (button != null) {
                        button.setClickable(true);
                    }
                }
            }).show();
            if (QLog.isColorLevel()) {
                QLog.i("QQAlbum", 2, "show datalinephoto_mobile_send_confirm dialog");
                return;
            }
            return;
        }
        H0(this.D, intent, this.f184310e.selectedPhotoList);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PhotoListCustomizationFileAssistant", 1, "...onActivityResult...");
        }
        this.D.setResult(-1, intent);
        this.D.finish();
        QAlbumUtil.anim(this.D, false, false);
    }

    protected void H0(Activity activity, Intent intent, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, intent, arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PhotoListCustomizationFileAssistant", 1, "sendPicAndVideoToFileAssistant...");
        }
        intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity");
        intent.addFlags(603979776);
        intent.putExtra("param_compressInitTime", System.currentTimeMillis());
        intent.putExtra("PhotoConst.PHOTO_PATHS", arrayList);
        activity.setResult(-1, intent);
        activity.finish();
        QAlbumUtil.anim(activity, false, false);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        } else {
            this.D.startActivityForResult(intent, 10010);
        }
    }
}
