package com.tencent.mobileqq.qqalbum;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IAlbumUtils extends QRouteApi {
    String formatTimeToString(long j3);

    void sendPhoto(Activity activity, Intent intent, ArrayList<String> arrayList, HashMap<String, PhotoSendParams> hashMap, int i3, boolean z16);
}
