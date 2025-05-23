package com.tencent.mobileqq.ad.emoji.api;

import com.tencent.mobileqq.ad.emoji.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface ICommercialEmoji extends QRouteApi {
    b getEmojiItem(String str);

    void handleClick(String str, String str2);

    boolean isEmojiPkgIdValid(String str);
}
