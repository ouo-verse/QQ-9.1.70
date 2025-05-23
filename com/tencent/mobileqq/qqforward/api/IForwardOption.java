package com.tencent.mobileqq.qqforward.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IForwardOption extends QRouteApi {
    void getForwardRecentList(RecentContactListener recentContactListener);

    void startForwardActivityForResult(Activity activity, Intent intent, int i3);

    void startForwardActivityForResult(Activity activity, Intent intent, Class<?> cls, int i3);

    void startForwardActivityForResult(Activity activity, Intent intent, Class<?> cls, int i3, int i16, String str);
}
