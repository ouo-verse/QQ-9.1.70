package com.tencent.mobileqq.qqlive.callback.lottery;

import com.tencent.mobileqq.qqlive.data.lottery.QQLiveLotteryData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveLotteryCallback {
    void onError(long j3, String str);

    void onReceive(ArrayList<QQLiveLotteryData> arrayList);
}
