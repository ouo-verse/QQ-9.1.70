package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes14.dex */
public interface IGuildRecentUseEmojiHandler extends QRouteApi {
    void reqRecentUseEmojiList();
}
