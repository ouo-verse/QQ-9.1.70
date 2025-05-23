package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_OPERATION.PicInfo;
import android.text.TextUtils;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.d;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h implements OtherCommonData {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public long f184246d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f184247e;

    /* renamed from: f, reason: collision with root package name */
    public int f184248f;

    /* renamed from: h, reason: collision with root package name */
    public String f184249h;

    /* renamed from: i, reason: collision with root package name */
    public int f184250i;

    /* renamed from: m, reason: collision with root package name */
    public HashMap<String, PicInfo> f184251m;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184246d = 0L;
        this.f184247e = false;
        this.f184248f = 0;
        this.f184250i = (int) ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
    }

    public LocalMediaInfo a(PhotoCommonBaseData<h> photoCommonBaseData, String str) {
        LocalMediaInfo localMediaInfo;
        LocalMediaInfo localMediaInfo2;
        HashMap<String, LocalMediaInfo> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) photoCommonBaseData, (Object) str);
        }
        HashMap<String, LocalMediaInfo> hashMap2 = photoCommonBaseData.selectedMediaInfoHashMap;
        if (hashMap2 != null) {
            localMediaInfo = hashMap2.get(str);
        } else {
            localMediaInfo = null;
        }
        if (localMediaInfo == null && (hashMap = photoCommonBaseData.allMediaInfoHashMap) != null) {
            localMediaInfo = hashMap.get(str);
        }
        if (localMediaInfo != null && (localMediaInfo.mediaWidth == 0 || localMediaInfo.mediaHeight == 0)) {
            d.a aVar = new d.a();
            com.tencent.mobileqq.shortvideo.util.d.a(str, aVar);
            int[] iArr = aVar.f288248a;
            localMediaInfo.mediaWidth = iArr[0];
            localMediaInfo.mediaHeight = iArr[1];
            localMediaInfo.rotation = iArr[2];
            HashMap<String, LocalMediaInfo> hashMap3 = photoCommonBaseData.allMediaInfoHashMap;
            if (hashMap3 != null && (localMediaInfo2 = hashMap3.get(str)) != null && (localMediaInfo2.mediaWidth == 0 || localMediaInfo2.mediaHeight == 0)) {
                localMediaInfo2.mediaWidth = localMediaInfo.mediaWidth;
                localMediaInfo2.mediaHeight = localMediaInfo.mediaHeight;
                localMediaInfo2.rotation = localMediaInfo.rotation;
            }
        }
        return localMediaInfo;
    }

    public int b(PhotoCommonBaseData<h> photoCommonBaseData, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) photoCommonBaseData, (Object) str)).intValue();
        }
        if (!TextUtils.isEmpty(str) && a(photoCommonBaseData, str) != null) {
            return QAlbumUtil.getMediaType(a(photoCommonBaseData, str));
        }
        return -1;
    }

    public boolean c(PhotoCommonBaseData<h> photoCommonBaseData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) photoCommonBaseData)).booleanValue();
        }
        for (int i3 = 0; i3 < photoCommonBaseData.selectedPhotoList.size(); i3++) {
            String str = photoCommonBaseData.selectedPhotoList.get(i3);
            if (ImageManager.isNetworkUrl(str) || b(photoCommonBaseData, str) != 0) {
                return false;
            }
        }
        return true;
    }
}
