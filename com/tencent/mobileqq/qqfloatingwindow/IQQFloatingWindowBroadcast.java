package com.tencent.mobileqq.qqfloatingwindow;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQFloatingWindowBroadcast extends QRouteApi {
    @Deprecated
    void sendWindowClosedBroadcast(Context context);

    void sendWindowClosedBroadcast(Context context, int i3);

    void sendWindowClosedBroadcast(Context context, int i3, int i16);

    @Deprecated
    void sendWindowVisibleBroadcast(Context context, boolean z16);

    void sendWindowVisibleBroadcast(Context context, boolean z16, int i3);

    void sendWindowVisibleBroadcast(Context context, boolean z16, int i3, int i16);
}
