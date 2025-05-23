package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class PhotoListCustomizationQcircle extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String F;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68932);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            F = PhotoListCustomizationQcircle.class.getName();
        }
    }

    public PhotoListCustomizationQcircle(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public a A(@NonNull a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, i3);
        }
        return super.A(aVar, i3);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void p(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        long j3 = m06.fileSize;
        MediaFileFilter mediaFileFilter = this.f184310e.filter;
        if (j3 > mediaFileFilter.videoSizeLimit) {
            QQToast.makeText(this.D, "\u8bf7\u4e0a\u4f20\u4e0d\u8d85\u8fc7" + (((((float) this.f184310e.filter.videoSizeLimit) / 1024.0f) / 1024.0f) / 1024.0f) + "G\u7684\u89c6\u9891", 0).show();
            return;
        }
        if (m06.mDuration > mediaFileFilter.videoMaxDuration + 1000) {
            QQToast.makeText(this.D, "\u8bf7\u4e0a\u4f20\u4e0d\u8d85\u8fc7" + ((this.f184310e.filter.videoMaxDuration / 60) / 1000) + "\u5206\u949f\u7684\u89c6\u9891", 0).show();
            return;
        }
        Intent intent = new Intent();
        Intent intent2 = this.D.getIntent();
        if (intent2 != null && intent2.getExtras() != null) {
            intent.putExtras(intent2.getExtras());
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(m06.path);
        HashMap hashMap = new HashMap();
        hashMap.put(m06.path, m06);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap);
        intent.addFlags(268435456);
        this.D.setResult(-1, intent);
        this.D.finish();
    }
}
