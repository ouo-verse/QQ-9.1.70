package com.tencent.qqmini.sdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.launcher.ui.MoreItemList;
import com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;

@MiniKeep
/* loaded from: classes23.dex */
public class MorePanel {
    private static final int REQUEST_SHOW_MORE = 9527;
    private static final String TAG = "MorePanel";
    private static boolean sVisible;

    private static String getPagePath(IMiniAppContext iMiniAppContext) {
        return PageAction.obtain(iMiniAppContext).getPageUrl();
    }

    private static void reportClick(IMiniAppContext iMiniAppContext, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SDKMiniProgramLpReportDC04239.reportUserClick(iMiniAppContext.getMiniAppInfo(), SDKMiniProgramLpReportDC04239.getAppType(iMiniAppContext.getMiniAppInfo()), getPagePath(iMiniAppContext), "user_click", "more_button", str);
    }

    @MiniKeep
    public static void show(final IMiniAppContext iMiniAppContext) {
        boolean z16;
        boolean z17;
        if (sVisible) {
            QMLog.w(TAG, "Ignore. Already showing");
            return;
        }
        if (iMiniAppContext == null) {
            QMLog.w(TAG, "Failed to show. miniAppContext is null");
            return;
        }
        Activity attachedActivity = iMiniAppContext.getAttachedActivity();
        if (attachedActivity != null && !attachedActivity.isFinishing()) {
            MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
            if (miniAppInfo == null) {
                QMLog.w(TAG, "Failed to show. MiniAppInfo is null");
                return;
            }
            final ShareState obtain = GetShareState.obtain(iMiniAppContext);
            if (obtain == null) {
                QMLog.w(TAG, "Failed to show. shareState is null");
                return;
            }
            Intent intent = new Intent();
            MoreItemList.DisplaySettings displaySettings = new MoreItemList.DisplaySettings();
            displaySettings.isShowShareQQ = obtain.withShareQQ;
            displaySettings.isShowShareQzone = obtain.withShareQzone;
            displaySettings.isShowShareWxFriends = obtain.withShareWeChatFriend;
            displaySettings.isShowShareWxMoments = obtain.withShareWeChatMoment;
            displaySettings.isShowShareOthers = obtain.withShareOthers;
            boolean z18 = obtain.showDebug;
            displaySettings.isShowDebug = z18;
            boolean z19 = false;
            if (z18 && iMiniAppContext.isMiniGame()) {
                z16 = true;
            } else {
                z16 = false;
            }
            displaySettings.isShowExportLog = z16;
            displaySettings.isShowMonitor = obtain.showMonitor;
            displaySettings.isShowAbout = true;
            displaySettings.isShowComplaint = true;
            if (iMiniAppContext.isMiniGame()) {
                if (GameWnsUtils.showRestartButton() && obtain.showRestart) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            } else {
                z17 = obtain.showRestart;
            }
            displaySettings.isShowRestart = z17;
            displaySettings.isShowQQFavorite = showAddQQFavorite(miniAppInfo);
            displaySettings.isShowFavorite = showAddFavorite(miniAppInfo);
            if (miniAppInfo.topType == 1) {
                z19 = true;
            }
            displaySettings.isMyFavorite = z19;
            displaySettings.isShowShortcut = showAddShortcut(miniAppInfo);
            MoreItemList.Builder displaySettings2 = new MoreItemList.Builder().setDisplaySettings(displaySettings);
            final MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            ArrayList<MoreItem> moreItems = miniAppProxy.getMoreItems(displaySettings2);
            intent.putExtra(IPCConst.KEY_ORIENTATION_LANDSCAPE, iMiniAppContext.isOrientationLandscape());
            intent.putExtra(IPCConst.KEY_MINI_APP_INFO, miniAppInfo);
            intent.putParcelableArrayListExtra(IPCConst.KEY_MORE_ITEM_LIST, moreItems);
            ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.sdk.ui.MorePanel.1
                @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
                public boolean doOnActivityResult(int i3, int i16, Intent intent2) {
                    if (9527 == i3) {
                        boolean unused = MorePanel.sVisible = false;
                        ActivityResultManager.g().removeActivityResultListener(this);
                        if (intent2 != null) {
                            int intExtra = intent2.getIntExtra(IPCConst.RESULT_MORE_ITEM_ID, -1);
                            ShareState.this.isShareInMiniProcess = intent2.getBooleanExtra(IPCConst.RESULT_SHARE_IN_MINI_PROCESS, false);
                            OnMoreItemSelectedListener moreItemSelectedListener = miniAppProxy.getMoreItemSelectedListener();
                            if (moreItemSelectedListener != null) {
                                moreItemSelectedListener.onMoreItemSelected(iMiniAppContext, intExtra);
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }
                    return false;
                }
            });
            MiniFragmentLauncher.startTranslucentForResult(attachedActivity, intent, 9527, MiniFragmentLauncher.FragmentType.FRAGMENT_MORE);
            reportClick(iMiniAppContext, "open");
            sVisible = true;
            return;
        }
        QMLog.w(TAG, "Failed to show. activity is null");
    }

    private static boolean showAddFavorite(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null || miniAppInfo.appMode.disableAddToMyApp || miniAppInfo.isLimitedAccessApp()) {
            return false;
        }
        return true;
    }

    private static boolean showAddQQFavorite(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null || miniAppInfo.appMode.disableAddToMyFavor) {
            return false;
        }
        return true;
    }

    private static boolean showAddShortcut(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null || miniAppInfo.isLimitedAccessApp()) {
            return false;
        }
        if (!QUAUtil.isQQApp() && QUAUtil.isDemoApp()) {
            return false;
        }
        return true;
    }
}
