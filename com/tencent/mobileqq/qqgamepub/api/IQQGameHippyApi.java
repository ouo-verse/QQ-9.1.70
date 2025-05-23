package com.tencent.mobileqq.qqgamepub.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.data.d;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGameHippyApi extends QRouteApi {
    public static final String OPEN_MESSAGE_PAGE_FROM_GAME_MSG_VIEW = "92001";

    int canOpenHippyByModuleName(String str);

    Class<? extends QPublicBaseFragment> getGameCenterHippyClass();

    String getGamePaHippyModuleName();

    int getHippyReportState(String str);

    JSONObject getJSONObject(String str);

    JSONObject getJsInitData(Activity activity, d dVar);

    QQGameMsgInfo getMsgInfoByHippyMap(HippyMap hippyMap);

    int getMsgPosByHippyMap(HippyMap hippyMap);

    HippyAPIProvider getQQGameHippyAPIProvider(String str);

    boolean isCanPreloadByTab(String str);

    boolean isFeatureSwitch(String str);

    boolean isFeatureSwitch(String str, boolean z16);

    boolean isFollowGamePubAccount(AppInterface appInterface);

    boolean isGameCenterBundle(String str);

    boolean isQQGameCenterBundle(String str);

    boolean isQQGamePubHippyBundle(String str);

    void openQQGameCenterByHippy(Context context, String str, String str2);

    void preloadQQGameCenterByHippy();

    void putQQGameWadlModule(@NonNull HippyEngineContext hippyEngineContext, @NonNull Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> map);

    void setReadyToPreloadHippy(boolean z16);
}
