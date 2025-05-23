package com.tencent.mobileqq.guild.nt.misc.api;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildPhotoListApi extends QRouteApi {
    @NonNull
    String getGuildPhotoListCustomizationCropClassName();

    @NonNull
    Intent newChooseCoverPhotoListIntent(@NonNull Activity activity, int i3, @NonNull Point point);
}
