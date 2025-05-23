package com.tencent.mobileqq.qqlive.callback.room.audience;

import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;

/* loaded from: classes17.dex */
public interface GetEndPageInfoCallback {
    void onFailed(int i3, String str);

    void onSuccess(EndPageRealTimeInfo endPageRealTimeInfo);
}
