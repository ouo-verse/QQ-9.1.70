package com.tencent.mobileqq.qqalbum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPhotoTempUtils extends QRouteApi {
    void sendPhoto(Activity activity, Intent intent, ArrayList<String> arrayList, int i3, boolean z16);

    Intent toCropActivity(Activity activity, Intent intent);

    Intent toEditPicActivityIntent(Activity activity, Intent intent, String str, int i3, Bundle bundle);
}
