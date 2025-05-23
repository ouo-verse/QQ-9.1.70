package com.tencent.mobileqq.troop.selecttroopmember;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ISelectTroopMemberStarter extends QRouteApi {
    public static final int FROM_TROOPMEMBERLIST = 1;
    public static final int FROM_TROOPMEMBERMGR = 2;
    public static final String INTENT_PARAM_FROM = "from";
    public static final String INTENT_PARAM_ONLYLOADLOCALDATA = "onlyloadLocalData";
    public static final String INTENT_PARAM_TROOPUIN = "troopUin";

    void start(Activity activity, boolean z16, int i3, String str);

    void startForResult(Activity activity, boolean z16, int i3, String str, int i16);
}
