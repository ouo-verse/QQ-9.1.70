package com.tencent.mobileqq.nearby.now.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ICommentsUtil extends QRouteApi {
    CharSequence clip(CharSequence charSequence, int i3, int i16);

    String encode16(byte[] bArr);

    String formatNumber(long j3);

    String formatSimpleDateTime(long j3);

    String formatWatchNumber(long j3);

    int getChinese(String str);

    int getLength(CharSequence charSequence);

    boolean isSingleWord(char c16);

    void reportClickEvent(AppInterface appInterface, String str);

    void reportClickEvent(AppInterface appInterface, String str, String str2);

    void reportClickEvent(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6);

    String simpleFormatTime(long j3);
}
