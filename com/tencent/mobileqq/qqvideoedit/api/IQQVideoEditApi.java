package com.tencent.mobileqq.qqvideoedit.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQVideoEditApi extends QRouteApi {
    public static final String ZOOTOPIA_VIDEO_CUT_MODULE_NAME = "ZootopiaVideoCutIpcModule";

    QIPCModule getZootopiaVideoCutIPCModule();

    void jumpToVideoEditPage(Activity activity, Intent intent, LocalMediaInfo localMediaInfo);

    void jumpToZootopiaVideoEditPage(String str, HashMap<String, String> hashMap);
}
