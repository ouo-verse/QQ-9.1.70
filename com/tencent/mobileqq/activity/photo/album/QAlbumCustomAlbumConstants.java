package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface QAlbumCustomAlbumConstants {
    public static final IPatchRedirector $redirector_ = null;
    public static final String RECENT_ALBUM_ID = "$RecentAlbumId";
    public static final String RECENT_ALBUM_NAME;
    public static final String RECENT_ALBUM_NAME_VIDEO;
    public static final String VIDEO_ALBUM_ID = "$VideoAlbumId";
    public static final String VIDEO_ALBUM_NAME;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(13210), (Class<?>) QAlbumCustomAlbumConstants.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        RECENT_ALBUM_NAME = BaseApplication.getContext().getResources().getString(R.string.f1772633h);
        RECENT_ALBUM_NAME_VIDEO = BaseApplication.getContext().getResources().getString(R.string.f1772833j);
        VIDEO_ALBUM_NAME = BaseApplication.getContext().getResources().getString(R.string.f1770532x);
    }
}
