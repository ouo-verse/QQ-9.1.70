package com.tencent.mobileqq.profilecard.bussiness.photowall.handler;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;

/* loaded from: classes16.dex */
public interface OnGetPhotoWallListener {
    boolean hasMore();

    void onGetQZonePhotoWall(boolean z16, String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar);

    void startFetchMore();
}
