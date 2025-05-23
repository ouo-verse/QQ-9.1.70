package com.tencent.mobileqq.app.proxy;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.service.message.z;
import java.util.List;

/* loaded from: classes11.dex */
public interface RecentUserProxy {
    void clearRecentUser();

    boolean contains(@NonNull RecentUser recentUser);

    boolean containsKey(@NonNull String str);

    void delAllRecentUserByUin(String str);

    void delC2CRecentUser(String str, boolean z16);

    void delRecentUser(RecentUser recentUser);

    void delRecentUser(RecentUser recentUser, boolean z16);

    void deleteRecentUserByType(int i3);

    RecentUser findRecentUser(String str, int i3);

    RecentUser findRecentUserByUin(String str, int i3);

    List<RecentUser> getHiddenRecentList();

    z getRecentConvInfo(String str, int i3);

    List<RecentUser> getRecentList(boolean z16);

    List<RecentUser> getRecentList(boolean z16, boolean z17);

    List<RecentUser> getRecentList(boolean z16, boolean z17, boolean z18);

    boolean isRecentUserInCache(String str, int i3);

    boolean isUinInRecent(String str);

    boolean isUinInRecentNotSubAccount(String str);

    void onDestroy();

    void preLoadTinyRecentUser();

    Entity removeKey(@NonNull Object obj);

    void saveRecentUser(RecentUser recentUser);

    void saveRecentUser(RecentUser recentUser, boolean z16);
}
