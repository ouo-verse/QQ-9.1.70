package com.tencent.mobileqq.emoticon.api;

import com.tencent.mobileqq.config.business.k;
import com.tencent.mobileqq.emosm.favroaming.a;
import com.tencent.mobileqq.emosm.favroaming.o;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFavEmoticonUtils extends QRouteApi {
    void getAccessibilityData(a aVar);

    ArrayList<EmoticonInfo> getEmoticonData();

    k getEmoticonQBoxConfig();

    void notifySyncFail();

    void removeAccessibilityListener();

    void triggerToSyncFromServer(o oVar);
}
