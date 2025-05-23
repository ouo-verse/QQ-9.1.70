package com.tencent.mobileqq.guild.temp.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildPhotoUtilsApi extends QRouteApi {

    /* loaded from: classes14.dex */
    public interface a {
        void onDownloaded(int i3, String str);
    }

    boolean downloadNonGuildPhoto(Object obj, a aVar);

    void forward(String str, Activity activity);

    void forwardFavourite(String str, Object obj, Activity activity);

    void forwardQzone(String str, Object obj, Activity activity);

    String getPhotoListCustomizationGuildAIOClassName();

    String getPhotoListCustomizationGuildDirectMessageAIOClassName();

    String getPhotoListCustomizationGuildFeedClassName();

    String getPhotoPreviewCustomizationGuildAIOClassName();

    String getPhotoPreviewCustomizationGuildFeedClassName();

    void savePic(String str, Activity activity);

    boolean useGuildPhotoList(Object obj);
}
