package com.tencent.mobileqq.troop.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopSystemMsgUtilApi extends QRouteApi {
    String getTroopAnswerFromSP(Context context, String str);

    long getTroopFlagExtFromSP(Context context, String str);

    String getTroopNameFromSP(Context context, String str);

    String getTroopQuestionFromSP(Context context, String str);

    void saveTroopAnswerToSP(Context context, String str, String str2);

    void saveTroopFlagExToSP(Context context, String str, long j3);

    void saveTroopNameToSP(Context context, String str, String str2);

    void saveTroopOptionToSP(Context context, String str, int i3);

    void saveTroopQuestionToSP(Context context, String str, String str2);
}
