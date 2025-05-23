package com.tencent.mobileqq.utils.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IDBUtils extends QRouteApi {
    int getSubAccountVersion(Context context);

    void setShowSubAccountInRecentList(Context context, String str, boolean z16);

    void setSubAccountVersion(Context context);

    boolean showSubAccountInRecentList(Context context, String str);

    boolean subAccountOldVersionUpdate(Context context, String str);
}
