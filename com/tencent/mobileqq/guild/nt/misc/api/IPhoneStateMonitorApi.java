package com.tencent.mobileqq.guild.nt.misc.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IPhoneStateMonitorApi extends QRouteApi {

    /* loaded from: classes14.dex */
    public interface a {
        void release();
    }

    /* loaded from: classes14.dex */
    public interface b {
        void a(boolean z16);
    }

    a newPhoneStateMonitor(Context context, b bVar);
}
