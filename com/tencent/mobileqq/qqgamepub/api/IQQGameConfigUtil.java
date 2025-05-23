package com.tencent.mobileqq.qqgamepub.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGameConfigUtil extends QRouteApi {
    public static final int S_PLAY_VIDEO_COUNT = 3;
    public static final int S_PLAY_VIDEO_TIME = 30000;

    boolean canShowFloatWindow(String str);

    boolean checkGamePubAccountConfig();

    String getFeedWebUrl();

    String getGameMallBundleName();

    List<String> getGamePubPreloadKuilyBundleList();

    String getGamePubUrl();

    String getHippyBridgeSoName();

    boolean getHippySwitch();

    int getPushMsgInterval();

    String getSubscribePageUrl();

    boolean isCustomGameMallPubAccount();

    boolean isFlutterPreLoad();

    boolean isGamePubHippySwitch();

    boolean isGamePubKuiklySwitch();

    boolean isHippyUseAllInOneSo();

    boolean isInterceptMsg(String str);

    boolean isPubFeedByWeb();

    boolean isPushMsgSwitchOn();

    boolean isTroopUnitedGameCard();

    boolean isUpdateHippyJsBundleByHttp();

    boolean openGameCenterByKuikly(Context context, String str, boolean z16);
}
