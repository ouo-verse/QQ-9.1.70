package com.tencent.mobileqq.guild.nt.message.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildSummaryUiDataFetcherApi extends QRouteApi {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes14.dex */
    public @interface FetchType {
        public static final int FETCH_TYPE_FOR_GUEST = 1;
        public static final int FETCH_TYPE_NORMAL = 0;
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
    }

    cv1.a convertMsgRecordData(MsgRecord msgRecord);

    void fetchUiDataFromMessage(String str, String str2, long j3, int i3, a aVar);
}
