package com.tencent.mobileqq.ark.api;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkQQApi extends QRouteApi {
    public static final int APP_TYPE_TENCENT = 0;
    public static final int APP_TYPE_THIRD_PARTY = 1;
    public static final String STRUCT_MSG_APP_NAME = "com.tencent.structmsg";

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void u(Context context, Bundle bundle);
    }

    a getPositionMsgDialog(Context context, int i3);

    a getTemplateMsgDialog(Context context, int i3);

    boolean isArkCustomDialog(Dialog dialog);

    void registerArkQQCallBack();

    void unregisterArkQQCallBack();
}
