package com.tencent.qzonehub.api.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneGroupAlbumPermissionUtil extends QRouteApi {
    boolean isSupportForwardToGroupAlbum(String str);
}
