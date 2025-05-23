package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IApolloDependApi extends QRouteApi {
    void onEmoticonNewIconShown(int i3);

    boolean shouldShowNewIcon(int i3);
}
