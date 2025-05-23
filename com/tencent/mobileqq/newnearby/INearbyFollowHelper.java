package com.tencent.mobileqq.newnearby;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyFollowHelper extends QRouteApi {
    public static final int FOLLOW_FAIL = 0;
    public static final int FOLLOW_SUCCESS = 1;
    public static final String OPT_TYPE_FOLLOW = "1";
    public static final String OPT_TYPE_QUERY_STATUS = "3";
    public static final String OPT_TYPE_UNFOLLOW = "2";

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a(int i3, String str, int i16);
    }

    void followByOption(AppInterface appInterface, Context context, String str, String str2, a aVar);
}
