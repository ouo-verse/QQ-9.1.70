package com.tencent.qidian.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IQidianApi extends QRouteApi {
    Intent getProfileCardIntent(Context context, AllInOne allInOne);
}
