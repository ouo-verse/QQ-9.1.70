package com.tencent.mobileqq.subaccount;

import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends QAlbumUtil {
    static IPatchRedirector $redirector_;

    public static void a() {
        QAlbumUtil.sLastAlbumPhotoCountMap.clear();
        QAlbumUtil.sLastAlbumPath = null;
        QAlbumUtil.sLastAlbumRecordTime = 0L;
        QAlbumUtil.sLastAlbumId = null;
        QAlbumUtil.sLastAlbumName = null;
    }
}
