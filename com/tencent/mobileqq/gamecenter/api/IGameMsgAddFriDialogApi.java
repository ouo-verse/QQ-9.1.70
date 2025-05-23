package com.tencent.mobileqq.gamecenter.api;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGameMsgAddFriDialogApi extends QRouteApi {
    void showDialog(int i3, AppInterface appInterface, Activity activity, String str, String str2, String str3, String str4, String str5);
}
