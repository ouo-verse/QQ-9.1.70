package com.tencent.mobileqq.troop.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ILaunchTroopSysMsgUIUtilApi extends QRouteApi {
    public static final int FROM_MSG_LIST = 2;
    public static final int FROM_PUSH = 3;
    public static final int FROM_SEARCH = 1;
    public static final int FROM_WITH_RCMD_NOTIFICATION_PAGE = 4;
    public static final String KEY_CUSTOM_TITLE = "key_custom_title";
    public static final String KEY_DEFAULT_TAB_INDEX = "tab";
    public static final String KEY_FROM = "key_from";
    public static final String KEY_HAS_RED = "has_red";
    public static final String KEY_PUSH_TYPE = "push_type";
    public static final String SP_NAME = "nearby_troop_count";
    public static final int TAB_INDEX_ALL = 0;
    public static final int TAB_INDEX_DOUBT = 3;
    public static final int TAB_INDEX_EXIT = 2;
    public static final int TAB_INDEX_UNDEAL = 1;

    String getFragmentNameForLaunch();

    void launchTroopNotificationFragment(Intent intent);

    void launchTroopNotificationFragment(Intent intent, boolean z16, boolean z17);

    void launchTroopNotificationWithRcmdFragment(Intent intent);
}
