package com.tencent.mobileqq.guild.nt.album.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IPhotoPickAndEditApi extends QRouteApi {
    void startPhotoEdit(Activity activity, String str, int i3);

    void startPhotoEditForResult(Activity activity, Intent intent, String str, int i3, int i16);

    void startPhotoPick(Activity activity, int i3);

    void startPhotoPickForResult(Activity activity, Intent intent, int i3, int i16);
}
