package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationMiniApp extends PhotoPreviewCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String H;
    private int G;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68971);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            H = PhotoPreviewCustomizationMiniApp.class.getName();
        }
    }

    public PhotoPreviewCustomizationMiniApp(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoPreviewActivity);
        } else {
            this.G = 0;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void G(Intent intent, boolean z16, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, intent, Boolean.valueOf(z16), arrayList);
            return;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < arrayList.size(); i18++) {
            String str = arrayList.get(i18);
            if (!ImageManager.isNetworkUrl(str)) {
                int l3 = this.f184337i.l(str);
                LocalMediaInfo k3 = this.f184337i.k(str);
                if (l3 == 1) {
                    if (k3 != null) {
                        hashMap.put(Integer.valueOf(i17), k3);
                        i3++;
                    }
                } else {
                    i16++;
                }
                i17++;
            }
        }
        if (!hashMap.isEmpty()) {
            intent.putExtra(PeakConstants.VIDEO_INFO, hashMap);
        }
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184335f).f184248f);
        intent.putExtra("from_miniapp_cur_sizetype", this.G);
        QLog.d("PhotoListCustomizationMiniApp", 2, "sendImage:" + i16 + "  sendVideo:" + i3);
        intent.setComponent(null);
        intent.setAction(intent.getStringExtra(PeakConstants.DEST_BROADCAST_ACTION_NAME));
        intent.setFlags(intent.getFlags() & (-536870913) & (-67108865));
        try {
            this.f184197m.sendBroadcast(intent);
            this.f184197m.finish();
        } catch (Exception e16) {
            QLog.d("PhotoListCustomizationMiniApp", 1, "sendPhoto fail!", e16);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void j(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            super.j(intent);
            this.G = intent.getIntExtra("from_miniapp_cur_sizetype", 0);
        }
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
        if (z16) {
            v().F.setVisibility(8);
            v().G.setVisibility(8);
        } else {
            v().F.setVisibility(0);
            v().G.setVisibility(0);
        }
    }
}
