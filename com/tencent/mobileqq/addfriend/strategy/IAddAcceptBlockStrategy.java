package com.tencent.mobileqq.addfriend.strategy;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IAddAcceptBlockStrategy extends QRouteApi {
    public static final int CODE_ACCEPT_FRIEND = 10005;
    public static final int CODE_ADD_FRIEND = 10003;
    public static final int CODE_JOIN_TROOP = 10002;
    public static final int CODE_LOGIN = 10000;
    public static final int CODE_QZONE = 10004;
    public static final int CODE_TEMP_AIO = 10001;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void onSuccess();
    }

    void checkAccountIdentity(AppRuntime appRuntime, int i3, Context context, a aVar);
}
