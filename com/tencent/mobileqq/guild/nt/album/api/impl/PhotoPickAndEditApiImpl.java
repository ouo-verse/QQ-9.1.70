package com.tencent.mobileqq.guild.nt.album.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.guild.nt.album.api.IPhotoPickAndEditApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;

/* loaded from: classes14.dex */
public class PhotoPickAndEditApiImpl implements IPhotoPickAndEditApi {
    @Override // com.tencent.mobileqq.guild.nt.album.api.IPhotoPickAndEditApi
    public void startPhotoEdit(Activity activity, String str, int i3) {
        ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoEdit(activity, str, i3);
    }

    @Override // com.tencent.mobileqq.guild.nt.album.api.IPhotoPickAndEditApi
    public void startPhotoEditForResult(Activity activity, Intent intent, String str, int i3, int i16) {
        ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoEditForResult(activity, intent, str, i3, i16);
    }

    @Override // com.tencent.mobileqq.guild.nt.album.api.IPhotoPickAndEditApi
    public void startPhotoPick(Activity activity, int i3) {
        ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoListEdit(activity, i3);
    }

    @Override // com.tencent.mobileqq.guild.nt.album.api.IPhotoPickAndEditApi
    public void startPhotoPickForResult(Activity activity, Intent intent, int i3, int i16) {
        ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoListEditForResult(activity, intent, i3, i16);
    }
}
