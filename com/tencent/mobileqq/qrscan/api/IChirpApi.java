package com.tencent.mobileqq.qrscan.api;

import android.util.Pair;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IChirpApi extends QRouteApi {
    Pair<Integer, short[]> encode(String str);

    int init();

    boolean loadLibrary();

    void release();
}
