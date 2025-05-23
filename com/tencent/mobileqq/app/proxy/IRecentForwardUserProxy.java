package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.data.RecentUser;
import java.util.List;

/* loaded from: classes11.dex */
public interface IRecentForwardUserProxy {
    void clearRecentUser();

    void clearSpecificRecentUser(String str);

    List<RecentUser> getRecentList(boolean z16);

    List<RecentUser> getRecentList(boolean z16, boolean z17);

    List<RecentUser> getRecentList(boolean z16, boolean z17, boolean z18);

    void saveRecentUser(RecentUser recentUser);
}
