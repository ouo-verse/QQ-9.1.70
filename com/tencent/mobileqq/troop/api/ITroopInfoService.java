package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
@Deprecated(since = "\u7fa4NT\u4e0b\u6c89\uff0c\u65b0\u903b\u8f91\u5efa\u8bae\u4f7f\u7528\u5bf9\u5e94\u4e1a\u52a1\u7684Repo\uff0c\u5982ITroopListRepo\u3001ITroopInfoRepo")
/* loaded from: classes19.dex */
public interface ITroopInfoService extends IRuntimeService {
    public static final boolean COMMONLY_USED_TROOP_SYNC_TO_RECENT_USER = true;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void onResult(Object obj);
    }

    void asyncGetTroopInfo(String str, com.tencent.mobileqq.data.troop.a aVar);

    TroopInfo findTroopInfo(String str);

    TroopInfo findTroopInfo(String str, boolean z16);

    TroopInfo findTroopInfo(String str, boolean z16, boolean z17);

    TroopInfo findTroopInfoInUI(String str);

    long getInsertJoinTroopMsgTime(String str);

    String getTroopCodeByTroopUin(String str);

    void getTroopCodeByTroopUinAsync(String str, a aVar);

    TroopInfo getTroopInfo(String str);

    TroopInfo getTroopInfoFromCache(String str);

    ArrayList<String> getTroopMemberForTroopHead(String str);

    String getTroopNameByID(String str);

    String getTroopUin(String str);

    String getTroopUinByTroopCode(String str);

    boolean isHomeworkTroop(String str);

    boolean isQidianPrivateTroop(String str);

    void setInsertJoinTroopMsgTime(String str, long j3);

    void tryToCancelTroopHideChat(String str);
}
