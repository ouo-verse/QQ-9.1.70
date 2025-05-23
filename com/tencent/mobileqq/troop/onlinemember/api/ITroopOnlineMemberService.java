package com.tencent.mobileqq.troop.onlinemember.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopOnlineMemberService extends IRuntimeService {
    long getAIOTipsNextReqTime(String str);

    List<String> getAllGameOnlineList(String str);

    long getAllGameOnlineNextReqTime(String str);

    long getAllNextReqTime(String str);

    List<String> getAllOnlineList(String str);

    List<com.tencent.mobileqq.troop.onlinemember.data.b> getDetailMemberListFromCache(String str);

    long getDetailNextReqTime(String str);

    long getLastReqLocationTime();

    int getOnlineCount(String str);

    String getOnlineTip(String str);

    int getRequestListServiceType(String str);

    void removeDetailOnlineData(String str);

    void removeDetailOnlineList(String str);

    void setLastReqLocationTime(long j3);

    void updateAIOTipsCache(String str, int i3, String str2, int i16, int i17);

    void updateAllGameOnlineList(String str, List<String> list, int i3);

    void updateAllOnlineList(String str, List<String> list, int i3);

    void updateDetailOnlineListCache(String str, List<com.tencent.mobileqq.troop.onlinemember.data.b> list, int i3, String str2, int i16);
}
