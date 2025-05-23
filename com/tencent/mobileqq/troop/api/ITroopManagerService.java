package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopManagerService extends IRuntimeService {
    byte[] getTroopAppListData(String str);

    void getTroopsMemberList();

    void handleTroopMemberNewLevelChange(String str, byte[] bArr, int i3);

    void setTroopAppListData(String str, byte[] bArr);
}
