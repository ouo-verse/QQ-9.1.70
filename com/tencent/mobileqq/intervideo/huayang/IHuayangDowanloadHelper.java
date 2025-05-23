package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.Map;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IHuayangDowanloadHelper extends QRouteApi {
    void canceLauncher();

    void downloadPlugin(String str, String str2, String str3, String str4, Map<String, IVPluginInfo> map);

    IHuayangDowanloadHelper init(Context context, String str, String str2);
}
