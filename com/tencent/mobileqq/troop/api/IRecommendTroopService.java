package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface IRecommendTroopService extends IRuntimeService {
    public static final int DB_STATUS_NORMAL = 0;
    public static final int DB_STATUS_USER = 1;
    public static final String KEY_CONFIG_SHOW_NEW_RECOMMEND = "show_new_troop_recommend";
    public static final int MAX_LIST_SIZE = 50;
    public static final int RECOMMENDTROOP_CHANNEL_NOTIFICATION = 2;
    public static final int RECOMMENDTROOP_SRC_MSG = 2;
    public static final int RECOMMENDTROOP_SRC_USER = 1;
    public static final String SP_NAME_RECOMMEND_UNREAD_COUNT = "unread_recommend_troop_count";

    String getLastMessage();

    int isEnd();

    void setEnd(int i3);
}
