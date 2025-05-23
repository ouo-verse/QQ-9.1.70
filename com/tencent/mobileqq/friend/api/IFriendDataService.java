package com.tencent.mobileqq.friend.api;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;
import uc1.a;
import uc1.b;
import uc1.c;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes12.dex */
public interface IFriendDataService extends IRuntimeService {
    List<Groups> asyncGetGroupList(a aVar);

    Friends deleteFriend(String str);

    List<Friends> getAllFriends();

    List<Friends> getAllFriends(boolean z16);

    @Deprecated
    Friends getFriend(String str);

    @Deprecated
    Friends getFriend(String str, boolean z16);

    @Deprecated
    Friends getFriend(String str, boolean z16, boolean z17);

    @Deprecated
    Friends getFriend(String str, boolean z16, boolean z17, boolean z18);

    void getFriend(String str, b<Friends> bVar);

    int getFriendCount();

    Friends getFriendFromMemoryCache(String str);

    List<Friends> getFriendList(int i3);

    Groups getGroup(int i3);

    Groups getGroup(int i3, boolean z16);

    List<Groups> getGroupList();

    void initFriendCache();

    void initFriendCache(c cVar);

    void initGroupCache();

    boolean isFriend(String str);

    boolean isFriend(String str, boolean z16);

    boolean isInitFinished();

    void moveFriendToNewGroup(String str, int i3);

    void moveGroup(int i3, int i16);

    List<Friends> preloadPartFriendCache(List<String> list);

    boolean saveFriend(Friends friends);

    void saveFriendCache(Friends friends);

    boolean saveFriendList(List<Friends> list);

    boolean saveFriendList(List<Friends> list, boolean z16, long j3);

    boolean saveGroup(Groups groups);

    boolean saveGroupList(List<Groups> list);

    void setNtRequestFriendListSeq(int i3);

    void updateGroupSortIds(byte[] bArr, byte[] bArr2);
}
