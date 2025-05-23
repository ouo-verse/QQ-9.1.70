package com.tencent.mobileqq.activity.qqsettingme.api;

import android.view.View;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes10.dex */
public interface IQVipMedalViewApi extends QRouteApi {
    void setData(View view, MedalList medalList);

    void setData(View view, MedalList medalList, Boolean bool);
}
