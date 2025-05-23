package com.tencent.qqmini.sdk.launcher.model;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ShareState {
    public static final String KEY_TAP_INDEX_FAVORITE = "tapIndexFavorite";
    public static final String KEY_TAP_INDEX_QQ = "tapIndexQQ";
    public static final String KEY_TAP_INDEX_QZONE = "tapIndexQZONE";
    public static final String KEY_TAP_INDEX_WX = "tapIndexWX";
    public static final String KEY_TAP_INDEX_WX_MOMENTS = "tapIndexWXMoments";
    public static final int MINI_APP_INNER_SHARE_BUTTON = 1;
    public static final int MINI_APP_MORE_BUTTON = 0;
    public static final int MINI_APP_SCREEN_RECORD = 2;
    public boolean isGettingScreenShot;
    public boolean isOrientationLandscape;
    public boolean isShareInMiniProcess;
    public boolean isShowGameBoxFloatEnable;
    public RequestEvent requestEvent;
    public String shareAppid;
    public ShareChatModel shareChatModel;
    public String shareEvent;
    public String shareJson;
    public String shareOpenid;
    public boolean showDebug;
    public boolean showMonitor;
    public String stagingJsonParams;
    public HashMap<String, Integer> tapIndexMap;
    public int launchFrom = -1;
    public boolean showRestart = true;
    public boolean showFavorites = true;
    public boolean withShareQzone = false;
    public boolean withShareQQ = false;
    public boolean withShareGuild = false;
    public boolean withShareWeChatFriend = false;
    public boolean withShareWeChatMoment = false;
    public boolean withShareOthers = false;
    public boolean withShareTicket = false;
    public boolean withShareTinyWorld = false;
    public boolean save2Local = false;
    public int fromShareMenuBtn = -1;
    public int shareCallbackId = -1;
}
