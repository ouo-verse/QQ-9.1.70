package com.tencent.mobileqq.guild.message.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes14.dex */
public interface IGuildRoamMessageHandler extends QRouteApi {
    boolean reqPullRoamMsg(String str, long j3, long j16, Bundle bundle);
}
