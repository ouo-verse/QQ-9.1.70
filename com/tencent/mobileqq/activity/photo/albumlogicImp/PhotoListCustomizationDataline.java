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
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class PhotoListCustomizationDataline extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String F;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68918);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            F = PhotoListCustomizationDataline.class.getName();
        }
    }

    protected PhotoListCustomizationDataline(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < this.f184310e.selectedPhotoList.size(); i18++) {
            String str = this.f184310e.selectedPhotoList.get(i18);
            if (!ImageManager.isNetworkUrl(str)) {
                if (((h) this.f184311f).b(this.f184310e, str) == 1) {
                    LocalMediaInfo a16 = ((h) this.f184311f).a(this.f184310e, str);
                    if (a16 != null) {
                        SendVideoInfo sendVideoInfo = new SendVideoInfo();
                        sendVideoInfo.fileSize = a16.fileSize;
                        sendVideoInfo.duration = a16.mDuration;
                        hashMap.put(Integer.valueOf(i17), sendVideoInfo);
                        i16++;
                    }
                } else {
                    i3++;
                }
                i17++;
            }
        }
        String.valueOf(i3);
        String.valueOf(i16);
        if (!hashMap.isEmpty()) {
            intent.putExtra(PeakConstants.VIDEO_INFO, hashMap);
            z17 = true;
        } else {
            z17 = false;
        }
        if (com.tencent.mobileqq.shortvideo.h.f287891c != 0 && System.currentTimeMillis() - com.tencent.mobileqq.shortvideo.h.f287891c < MiniBoxNoticeInfo.MIN_5) {
            z18 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "PhotoListCustomizationDataline isConfirmed=" + z18 + " allowUploadInXGTime=" + com.tencent.mobileqq.shortvideo.h.f287891c);
        }
        if (NetworkUtil.isMobileNetWork(BaseApplication.getContext()) && !z18 && z17) {
            DialogUtil.createCustomDialog(this.D, 232, null, this.D.getResources().getString(R.string.f173101he2), new DialogInterface.OnClickListener(new Runnable(intent) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationDataline.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Intent f184387d;

                {
                    this.f184387d = intent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationDataline.this, (Object) intent);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    PhotoListCustomizationDataline photoListCustomizationDataline = PhotoListCustomizationDataline.this;
                    photoListCustomizationDataline.H0(((PhotoListCustomizationDefault) photoListCustomizationDataline).D, this.f184387d, PhotoListCustomizationDataline.this.f184310e.selectedPhotoList);
                    com.tencent.mobileqq.shortvideo.h.f287891c = System.currentTimeMillis();
                }
            }) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationDataline.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Runnable f184388d;

                {
                    this.f184388d = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationDataline.this, (Object) r5);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i19) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i19);
                    } else {
                        this.f184388d.run();
                    }
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationDataline.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationDataline.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i19) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i19);
                        return;
                    }
                    Button button = PhotoListCustomizationDataline.this.f184313i.K;
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

    protected void H0(Activity activity, Intent intent, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, intent, arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQAlbum", 2, "sendPicAndVideoToDataline...");
        }
        intent.setClassName("com.tencent.mobileqq", "com.dataline.activities.LiteActivity");
        intent.addFlags(603979776);
        intent.putExtra("param_compressInitTime", System.currentTimeMillis());
        intent.putExtra("PhotoConst.PHOTO_PATHS", arrayList);
        activity.startActivityForResult(intent, 2);
        activity.finish();
        QAlbumUtil.anim(activity, false, false);
    }
}
