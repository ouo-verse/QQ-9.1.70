package com.tencent.mobileqq.minigame.publicaccount.api;

import android.content.Context;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import java.util.HashMap;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGamePublicAccountApi extends QRouteApi {
    public static final String PEER_UID_MINI_GAME = "u_wYQjWwtxkvtyQFfgUpLkZQ";
    public static final String UIN_MINI_GAME_PA = "1983141935";

    boolean canPreloadHippy();

    HippyAPIProvider createHippyProvider();

    Class<? extends QPublicBaseFragment> getMiniGamePAHippyClass();

    boolean hasNewMessage();

    boolean isMiniGamePAModule(String str);

    boolean startMiniGamePA(Context context, HashMap<String, String> hashMap);
}
