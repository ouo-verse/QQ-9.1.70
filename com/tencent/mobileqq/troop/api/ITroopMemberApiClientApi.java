package com.tencent.mobileqq.troop.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopMemberApiClientApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void callback(Bundle bundle);
    }

    void clearHomeworkTroopRedPoint(String str, String str2);

    void doBindService();

    void doUnbindService();

    void getTroopFileStatusInfo(long j3, String str, String str2, long j16, int i3, a aVar);

    void openLocalFilePreview(String str, String str2);

    void studyRoomPicUpload(String str, a aVar);
}
