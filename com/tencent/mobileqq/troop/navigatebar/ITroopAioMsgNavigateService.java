package com.tencent.mobileqq.troop.navigatebar;

import android.support.annotation.NonNull;
import android.util.ArrayMap;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.navigatebar.bean.TroopAioNavMsgCollection;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopAioMsgNavigateService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(String str, List<Long> list);
    }

    String getLastCookie();

    void notifyTroopRevokeNavMsg(String str, List<Long> list);

    void registerTroopRevokeNavMsgCallback(a aVar);

    void saveLastCookie(String str);

    void unRegisterTroopRevokeNavMsgCallback(a aVar);

    void updateTroopNavMsgCollection(@NonNull List<TroopAioNavMsgCollection> list);

    void updateTroopRevokeMsg(ArrayMap<String, List<Long>> arrayMap);
}
