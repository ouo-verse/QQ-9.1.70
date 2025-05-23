package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IHuayangOpenHelper extends QRouteApi {
    void doKillProcess(Context context, String str);

    void killProcess(Context context, String str);

    void open(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6, String str7);
}
