package com.tencent.mobileqq.location.api;

import android.app.Activity;
import com.tencent.mobileqq.location.callback.e;
import com.tencent.mobileqq.location.data.b;
import com.tencent.mobileqq.location.h;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes15.dex */
public interface ILocationShareService extends IRuntimeService {
    void addErrorShareStateCallback(e eVar);

    void addLocationUpdateListener(h hVar);

    boolean isCurrentUserSharing();

    boolean isSessionSharingLocation(int i3, String str);

    void launchShareUi(Activity activity, int i3, String str, int i16);

    void notifyStateError(int i3, String str, boolean z16);

    void notifyStateNormalClose(int i3, long j3);

    void notifyUserSwitchPhone(int i3, long j3);

    void processC2CPush(byte[] bArr);

    void processTroopPush(b bVar);

    void removeErrorShareStateCallback(e eVar);

    void removeLocationUpdateListener(h hVar);

    void requestOperateRoom(int i3, int i16, String str);

    void requestQueryRoom(int i3, String str);

    void stopLocationSharing(int i3, String str, boolean z16);
}
