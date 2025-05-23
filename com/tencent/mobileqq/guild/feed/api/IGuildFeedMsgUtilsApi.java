package com.tencent.mobileqq.guild.feed.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IGuildFeedMsgUtilsApi extends QRouteApi {
    Class<? extends com.tencent.imcore.message.core.codec.a> getMsgFeedDecoder();

    boolean isFeedChannel(AppRuntime appRuntime, String str);

    String parseRichTextPb(byte[] bArr);
}
