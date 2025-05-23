package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopAvatarUtilApi extends QRouteApi {
    public static final int ARTWORK = 0;
    public static final String AVATAR_ADDRESS = "https://p.qlogo.cn/gh/dir/file/";
    public static final int BIGPHOTO = 640;
    public static final String DEFAULT_TROOP_AVATAR_ADDRESS = "https://s.url.cn/pub/img/qb_group_normal.png";
    public static final int NEW_GROUP_URL = 0;
    public static final String REGEXP_URL_STRING = "https://p.qlogo.cn/gh/";
    public static final int REGULAR_URL = 1;
    public static final int THUMBE = 140;

    String getArtWork(String str);

    String getAvatarAddress(String str, String str2, int i3);

    String getThumbPhoto(String str);

    boolean isAvatarUrl(String str);

    boolean isNumeric(String str);
}
