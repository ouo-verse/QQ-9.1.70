package com.tencent.mobileqq.activity.photo.album.api;

import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IAlbumApi extends QRouteApi {
    String getAlbumListCustomizationAIOClassName();

    ProtocolDownloader getAlbumPreviewThumbDownloader();

    String getNewPhotoListActivityClassName();
}
