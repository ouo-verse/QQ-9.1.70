package com.tencent.gamecenter.wadl.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameMMKVService extends QRouteApi {
    boolean deleteToSp(String... strArr);

    int getIntOutAccount(String str, int i3);

    String getStringOutAccount(String str);

    boolean readBoolFromSp(String str);

    String readFromSp(String str);

    int readFromSpInt(String str);

    long readFromSpLong(String str);

    void setIntOutAccount(String str, int i3);

    void setStringOutAccount(String str, String str2);

    boolean writeToSp(String str, String str2);

    boolean writeToSpBool(String str, boolean z16);

    void writeToSpInt(String str, int i3);

    void writeToSpLong(String str, long j3);
}
