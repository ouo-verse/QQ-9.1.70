package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildEmotionCodecApi extends QRouteApi {
    String decodeQQEmotion(String str);

    String encodeQQEmotion(String str);

    String fromQQTextBuilder(QQTextBuilder qQTextBuilder);

    QQText toQQText(String str, int i3);

    QQText toQQTextWithAnimation(String str, int i3);
}
