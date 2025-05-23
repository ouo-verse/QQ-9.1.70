package com.tencent.mobileqq.search.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchMore extends QRouteApi {
    void openSearchMoreGamePage(Context context, String str);
}
