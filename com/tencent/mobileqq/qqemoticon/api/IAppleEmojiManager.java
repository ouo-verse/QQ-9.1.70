package com.tencent.mobileqq.qqemoticon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IAppleEmojiManager extends QRouteApi {
    String getAppleEmojiSpName();

    void reDownloadAppleEmoji();
}
