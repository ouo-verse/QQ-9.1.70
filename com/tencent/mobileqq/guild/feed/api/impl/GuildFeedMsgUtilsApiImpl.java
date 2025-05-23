package com.tencent.mobileqq.guild.feed.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMsgUtilsApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedMsgUtilsApiImpl implements IGuildFeedMsgUtilsApi {
    private static final String TAG = "GuildFeedMsgUtilsApiImpl";

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMsgUtilsApi
    public Class<? extends com.tencent.imcore.message.core.codec.a> getMsgFeedDecoder() {
        return kj1.a.class;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMsgUtilsApi
    public boolean isFeedChannel(AppRuntime appRuntime, String str) {
        IGProChannelInfo channelInfo;
        if (!TextUtils.isEmpty(str) && (channelInfo = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "all")).getChannelInfo(str)) != null && channelInfo.getType() == 7) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMsgUtilsApi
    public String parseRichTextPb(byte[] bArr) {
        return com.tencent.mobileqq.guild.feed.util.o.e(bArr);
    }
}
