package com.tencent.mobileqq.streamtransfile;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IStreamDataManager extends QRouteApi {
    Map.Entry<String, c> getStreamFileInfoEntryByMsg(long j3, long j16);

    boolean removeStreamTaskToMemoryPool(String str);
}
