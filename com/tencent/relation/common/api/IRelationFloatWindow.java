package com.tencent.relation.common.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRelationFloatWindow extends QRouteApi {
    boolean checkFloatWindowShowing(String str);

    void hideRelationFloatWindow(String str);

    boolean showRelationFloatWindow(View view, String str, float f16, float f17);
}
