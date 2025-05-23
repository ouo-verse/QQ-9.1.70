package com.tencent.mobileqq.shortvideo.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IVideoEnvironment extends QRouteApi {
    boolean checkAndLoadAVCodec();

    int getAVCodecVersion();

    String getShortVideoSoLibName();

    String getShortVideoSoPath(Context context);
}
