package com.tencent.mobileqq.guild.message.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.guild.data.GuildCommonGrayTipsParseParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes14.dex */
public interface IGuildCommonGrayTipsApi extends QRouteApi {
    CharSequence getGuildCommonGrayTipsContent(GuildCommonGrayTipsParseParams guildCommonGrayTipsParseParams, Drawable.Callback callback, boolean z16);

    String getGuildCommonGrayTipsSummary(GuildCommonGrayTipsParseParams guildCommonGrayTipsParseParams);
}
