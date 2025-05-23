package com.tencent.gamecenter.wadl.api;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.GameNoticeInfo;
import com.tencent.gamecenter.wadl.biz.entity.f;
import com.tencent.gamecenter.wadl.biz.entity.i;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameCommApi extends QRouteApi {
    public static final int EXP_TYPE_CONTRAST = 1;
    public static final int EXP_TYPE_DEFAULT = 0;
    public static final int EXP_TYPE_EXPERIMENT = 2;
    public static final String KEY_END_DELAY = "endDelay";
    public static final String KEY_INSTALL_CONTENT = "installContent";
    public static final String KEY_INSTALL_NOTICE_ACTION_TYPE = "installNoticeActionType";
    public static final String KEY_INSTALL_SHOW_DELAY = "installShowDelay";
    public static final String KEY_INSTALL_TIPS_ACTION_TYPE = "installTipsActionType";
    public static final String KEY_PAUSE_CONTENT = "pauseContent";
    public static final String KEY_PAUSE_SHOW_DELAY = "pauseShowDelay";
    public static final String KEY_PAUSE_TIPS_ACTION_TYPE = "pauseTipsActionType";
    public static final String KEY_REG_CONTENT = "regContent";
    public static final String KEY_REG_SHOW_DELAY = "regShowDelay";
    public static final String KEY_START_DELAY = "startDelay";
    public static final String KEY_SYNC_NOTICE = "syncNotice";
    public static final String KEY_WILDCARD = "*";
    public static final String K_ABTEST_APPIDS = "appids";
    public static final String K_ABTEST_MODELS = "models";

    void clearQQGameDownloadFile();

    AppRuntime createAppRuntime(Context context, String str);

    int getExpIntValue(String str, String str2, boolean z16);

    int getExpType(String str, boolean z16, String str2, String str3);

    i getNextTipsInfo(GameNoticeInfo gameNoticeInfo, boolean z16);

    f getTaskByAppId(String str);

    boolean hasGameInstall(String str);

    boolean isExistMiniApp(String str);

    void onGameServiceExit();

    void reportGameShare(int i3, int i16, int i17, String str, String str2, String str3, String str4);
}
