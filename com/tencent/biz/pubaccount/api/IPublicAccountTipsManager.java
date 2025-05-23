package com.tencent.biz.pubaccount.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountTipsManager extends QRouteApi {
    public static final String TAG_ON_NEARBY_TIPS_CLICK = "tag_on_nearby_tips_click";

    View createEcshopDistanceTipsBar(String str, View.OnClickListener onClickListener);

    void hidePendant();

    void init(Context context);

    void showPendant(String str, String str2, int i3, int i16, int i17);

    void showTipsBar(ViewGroup viewGroup, View view);
}
