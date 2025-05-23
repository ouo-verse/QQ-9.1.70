package com.tencent.mobileqq.listentogether.api;

import com.tencent.mobileqq.onlinestatus.an;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IOnlineMusicStatusApi extends QRouteApi {
    public static final int SOURCE_FROM_LEBA = 4;
    public static final int SOURCE_FROM_LISTEN_C2C = 2;
    public static final int SOURCE_FROM_LISTEN_GROUP = 3;
    public static final int SOURCE_FROM_STRUCT_MSG = 1;

    an buildFromMusicInfo(boolean z16);

    an buildFromSongInfo(boolean z16);
}
