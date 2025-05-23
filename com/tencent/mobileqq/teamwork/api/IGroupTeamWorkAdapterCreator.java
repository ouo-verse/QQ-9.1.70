package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.g;
import com.tencent.mobileqq.teamwork.m;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IGroupTeamWorkAdapterCreator extends QRouteApi {
    g getGroupTeamWorkAdapter(AppInterface appInterface, Activity activity, m mVar, Handler handler);
}
