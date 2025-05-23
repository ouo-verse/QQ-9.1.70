package com.qzone.common.business.service.media;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.widget.ExtendGridView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.model.PhotoInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface a {
    void a(Activity activity, PhotoInfo photoInfo, QZoneMediaBusiness qZoneMediaBusiness);

    @Deprecated
    void b(Activity activity, Fragment fragment, ArrayList<String> arrayList, HashMap<String, PicInfo> hashMap, int i3, int i16, boolean z16, boolean z17, ConcurrentHashMap<String, String> concurrentHashMap, String str, Bundle bundle, HashMap<String, LocalMediaInfo> hashMap2, QZoneMediaBusiness qZoneMediaBusiness);

    void c(Activity activity, c cVar);

    void d(Activity activity, int i3, Bundle bundle);

    void e(Activity activity, ExtendGridView extendGridView, int i3, ArrayList<PictureItem> arrayList, HashMap<String, LocalMediaInfo> hashMap, int i16, Intent intent);

    int f();

    void g(Activity activity, File file, int i3, Bundle bundle, QZoneMediaBusiness qZoneMediaBusiness);
}
