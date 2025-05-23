package com.tencent.mobileqq.guild.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildAddQQFriendApi extends QRouteApi {
    boolean isFromGuild(int i3, int i16);

    boolean jumpToGuild(Context context, String str);
}
