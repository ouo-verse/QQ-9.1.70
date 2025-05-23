package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class PhotoListCustomizationTroopFile extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String F;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68947);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            F = PhotoListCustomizationTroopFile.class.getName();
        }
    }

    protected PhotoListCustomizationTroopFile(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    protected void B0(Intent intent, boolean z16, ArrayList<String> arrayList) {
        LocalMediaInfo a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, Boolean.valueOf(z16), arrayList);
            return;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        for (int i16 = 0; i16 < this.f184310e.selectedPhotoList.size(); i16++) {
            String str = this.f184310e.selectedPhotoList.get(i16);
            if (!ImageManager.isNetworkUrl(str)) {
                if (((h) this.f184311f).b(this.f184310e, str) == 1 && (a16 = ((h) this.f184311f).a(this.f184310e, str)) != null) {
                    SendVideoInfo sendVideoInfo = new SendVideoInfo();
                    sendVideoInfo.fileSize = a16.fileSize;
                    sendVideoInfo.duration = a16.mDuration;
                    hashMap.put(Integer.valueOf(i3), sendVideoInfo);
                }
                i3++;
            }
        }
        BasePhotoListActivity basePhotoListActivity = this.D;
        PhotoUtils.sendPhoto(basePhotoListActivity, basePhotoListActivity.getIntent(), this.f184310e.selectedPhotoList, ((h) this.f184311f).f184248f, this.C.f184241v);
    }
}
