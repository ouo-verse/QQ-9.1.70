package com.tencent.qqmini.sdk.action;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.utils.QUAUtil;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class GetShareState implements Action<ShareState> {
    private static final String DISABLE_ALL_SHARE_TO_GUILD = "all";

    GetShareState() {
    }

    public static ShareState obtain(IMiniAppContext iMiniAppContext) {
        if (iMiniAppContext == null) {
            return null;
        }
        ShareState shareState = (ShareState) iMiniAppContext.performAction(new GetShareState());
        if (shareState == null) {
            QMLog.e(Action.TAG, "obtain shareState is null!");
            return null;
        }
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        if ((miniAppInfo != null && miniAppInfo.verType != 3) || QUAUtil.isDemoApp()) {
            shareState.showDebug = true;
            shareState.showMonitor = true;
        }
        if (shouldHideWechatChannels()) {
            shareState.withShareWeChatFriend = false;
            shareState.withShareWeChatMoment = false;
        }
        if (shouldHideQzoneChannel()) {
            shareState.withShareQzone = false;
        }
        if (shareState.withShareGuild && miniAppInfo != null) {
            shareState.withShareGuild = !shouldHideGuildChannel(miniAppInfo.appId);
        }
        updateShareStateByAppMode(shareState, miniAppInfo);
        if (QUAUtil.isQQApp() || QUAUtil.isMicroApp()) {
            shareState.isShareInMiniProcess = true;
        }
        shareState.isOrientationLandscape = iMiniAppContext.isOrientationLandscape();
        return shareState;
    }

    private static boolean shouldHideGuildChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String config = WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_APP_SHARE_TO_GUILD_BLACKLIST);
        if (config == null) {
            return false;
        }
        if ("all".equals(config)) {
            return true;
        }
        for (String str2 : config.split(",")) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean shouldHideQzoneChannel() {
        if (!QUAUtil.isQQSpeedApp() && !QUAUtil.isTimApp()) {
            return false;
        }
        return true;
    }

    private static boolean shouldHideWechatChannels() {
        if (WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_APP_SHARE_TO_WX_SWITCHER, 1) != 1 || QUAUtil.isQQSpeedApp()) {
            return true;
        }
        return false;
    }

    private static void updateShareStateByAppMode(ShareState shareState, MiniAppInfo miniAppInfo) {
        AppMode appMode;
        if (miniAppInfo != null && miniAppInfo.isSpecialMiniApp()) {
            shareState.withShareOthers = false;
        }
        if (miniAppInfo != null && (appMode = miniAppInfo.appMode) != null) {
            if (appMode.disableShareToAIO) {
                shareState.withShareQQ = false;
            }
            if (appMode.disableShareToQZone) {
                shareState.withShareQzone = false;
            }
            if (appMode.disableShareToWeChat) {
                shareState.withShareWeChatFriend = false;
                shareState.withShareWeChatMoment = false;
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public ShareState perform(BaseRuntime baseRuntime) {
        return baseRuntime.getShareState();
    }
}
