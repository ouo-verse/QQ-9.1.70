package com.tencent.mobileqq.guild.api;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildMuteApi extends QRouteApi {
    String getMuteFormatHintTextInChannel(String str, String str2);

    e12.a<Long> getSelfGuildMuteLiveData(String str);

    boolean hasGuildMuteManagePermission(@Nullable String str);

    boolean selfIsMutingInGuild(String str);

    boolean selfIsQQGuildOrChannelManager(String str, String str2);
}
