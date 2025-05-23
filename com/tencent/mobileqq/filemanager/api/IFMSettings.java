package com.tencent.mobileqq.filemanager.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import lc1.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFMSettings extends QRouteApi {
    void free();

    long getDefalutStorgeFreeSpace();

    String getDefaultRecvPath();

    String getDefaultThumbPath();

    String getDefaultTmpPath();

    String getOtherRecvPath();

    void justDoIt(long j3, List<String> list, Activity activity, a aVar);

    void refreshInfos();

    void remove(String str);
}
