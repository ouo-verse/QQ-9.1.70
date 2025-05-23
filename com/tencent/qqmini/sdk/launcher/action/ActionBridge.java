package com.tencent.qqmini.sdk.launcher.action;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IAppPageRouter;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.GameVersionInfo;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ActionBridge<T> implements Action {
    public static final Map<String, String> ACTION_CLASS;
    private static final String ACTION_NAME_EXPORT_GAME_LOG = "ExportLogFileAction";
    private static final String ACTION_NAME_GET_APP_PAGE_ROUTER = "GetAppPageRouterAction";
    private static final String ACTION_NAME_SCREEN_RECORD = "ScreenRecordAction";
    private static final String TAG = "ActionBridge";
    private Action<T> realAction;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ExportLogFileBridge extends ActionBridge<Boolean> {
        public static ExportLogFileBridge obtain() {
            ExportLogFileBridge exportLogFileBridge = new ExportLogFileBridge();
            exportLogFileBridge.setRealAction(ActionBridge.obtain(ActionBridge.ACTION_NAME_EXPORT_GAME_LOG, 0, null));
            return exportLogFileBridge;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class FavoritesActionBridge extends ActionBridge<Boolean> {
        public static final int ADD_FAVORITES = 1;

        public static FavoritesActionBridge obtain(int i3, Bundle bundle) {
            HashMap hashMap;
            if (bundle != null) {
                hashMap = new HashMap();
                hashMap.put("data", bundle);
            } else {
                hashMap = null;
            }
            FavoritesActionBridge favoritesActionBridge = new FavoritesActionBridge();
            favoritesActionBridge.setRealAction(ActionBridge.obtain("FavoritesAction", i3, hashMap));
            return favoritesActionBridge;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class GameVersionActionBridge extends ActionBridge<GameVersionInfo> {
        public static GameVersionActionBridge obtain() {
            GameVersionActionBridge gameVersionActionBridge = new GameVersionActionBridge();
            gameVersionActionBridge.setRealAction(ActionBridge.obtain("GameVersionAction", 0, null));
            return gameVersionActionBridge;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class GetAppPageRouterActionBridge extends ActionBridge<IAppPageRouter> {
        public static GetAppPageRouterActionBridge obtain() {
            GetAppPageRouterActionBridge getAppPageRouterActionBridge = new GetAppPageRouterActionBridge();
            getAppPageRouterActionBridge.setRealAction(ActionBridge.obtain(ActionBridge.ACTION_NAME_GET_APP_PAGE_ROUTER, 0, null));
            return getAppPageRouterActionBridge;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class GetLastClicksActionBridge extends ActionBridge<String> {
        public static GetLastClicksActionBridge obtain() {
            GetLastClicksActionBridge getLastClicksActionBridge = new GetLastClicksActionBridge();
            getLastClicksActionBridge.setRealAction(ActionBridge.obtain("GetLastClickAction", 0, null));
            return getLastClicksActionBridge;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class GetShareStateActionBridge extends ActionBridge<ShareState> {
        public static GetShareStateActionBridge obtain() {
            GetShareStateActionBridge getShareStateActionBridge = new GetShareStateActionBridge();
            getShareStateActionBridge.setRealAction(ActionBridge.obtain("GetShareState", 0, null));
            return getShareStateActionBridge;
        }

        @Override // com.tencent.qqmini.sdk.launcher.action.ActionBridge, com.tencent.qqmini.sdk.launcher.core.action.Action
        public ShareState perform(BaseRuntime baseRuntime) {
            return (ShareState) super.perform(baseRuntime);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class GetTheLastClickInfoActionBridge extends ActionBridge<String> {
        public static GetTheLastClickInfoActionBridge obtain() {
            GetTheLastClickInfoActionBridge getTheLastClickInfoActionBridge = new GetTheLastClickInfoActionBridge();
            getTheLastClickInfoActionBridge.setRealAction(ActionBridge.obtain("GetTheLastClickInfoAction", 0, null));
            return getTheLastClickInfoActionBridge;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class PageActionBridge extends ActionBridge<AppPageInfo> {
        public static int getPageId(IMiniAppContext iMiniAppContext) {
            AppPageInfo appPageInfo = (AppPageInfo) iMiniAppContext.performAction(obtain(1));
            if (appPageInfo != null) {
                return appPageInfo.pageId;
            }
            return -1;
        }

        public static String getPageUrl(IMiniAppContext iMiniAppContext) {
            AppPageInfo appPageInfo = (AppPageInfo) iMiniAppContext.performAction(obtain(2));
            if (appPageInfo != null) {
                return appPageInfo.pageUrl;
            }
            return null;
        }

        public static PageActionBridge obtain(int i3) {
            PageActionBridge pageActionBridge = new PageActionBridge();
            HashMap hashMap = new HashMap();
            hashMap.put("flag", Integer.valueOf(i3));
            pageActionBridge.setRealAction(ActionBridge.obtain("PageAction", 0, hashMap));
            return pageActionBridge;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class RestartActionBridge extends ActionBridge<Boolean> {
        public static RestartActionBridge obtain() {
            RestartActionBridge restartActionBridge = new RestartActionBridge();
            restartActionBridge.setRealAction(ActionBridge.obtain("RestartAction", 0, null));
            return restartActionBridge;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ScreenRecordBridge extends ActionBridge<Boolean> {
        public static ScreenRecordBridge obtain(int i3) {
            ScreenRecordBridge screenRecordBridge = new ScreenRecordBridge();
            screenRecordBridge.setRealAction(ActionBridge.obtain(ActionBridge.ACTION_NAME_SCREEN_RECORD, i3, null));
            return screenRecordBridge;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ShareActionBridge extends ActionBridge<Boolean> {
        public static final int SHARE_GAME_RAFFLE = 6;
        public static final int SHARE_GUILD = 8;
        public static final int SHARE_OTHER = 7;
        public static final int SHARE_QQ = 1;
        public static final int SHARE_QQ_CHAT = 5;
        public static final int SHARE_QZONE = 2;
        public static final int SHARE_WX_FRIEND = 3;
        public static final int SHARE_WX_MOMENT = 4;

        public static ShareActionBridge obtain(int i3, Bundle bundle) {
            HashMap hashMap;
            if (bundle != null) {
                hashMap = new HashMap();
                hashMap.put("data", bundle);
            } else {
                hashMap = null;
            }
            ShareActionBridge shareActionBridge = new ShareActionBridge();
            shareActionBridge.setRealAction(ActionBridge.obtain("ShareAction", i3, hashMap));
            return shareActionBridge;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class UpdateUIActionBridge extends ActionBridge<Boolean> {
        public static final int TOGGLE_DEBUG_PANEL = 2;
        public static final int TOGGLE_MONITOR_PANEL = 1;
        public static final int UPDATE_RED_DOT = 3;

        public static UpdateUIActionBridge obtain(int i3) {
            UpdateUIActionBridge updateUIActionBridge = new UpdateUIActionBridge();
            updateUIActionBridge.setRealAction(ActionBridge.obtain("UpdateUIAction", i3, null));
            return updateUIActionBridge;
        }

        public static Boolean toggleDebugPanel(IMiniAppContext iMiniAppContext) {
            return (Boolean) iMiniAppContext.performAction(obtain(2));
        }

        public static Boolean toggleMonitorPanel(IMiniAppContext iMiniAppContext) {
            return (Boolean) iMiniAppContext.performAction(obtain(1));
        }

        public static Boolean updateRedDot(IMiniAppContext iMiniAppContext) {
            return (Boolean) iMiniAppContext.performAction(obtain(3));
        }
    }

    static {
        HashMap hashMap = new HashMap();
        ACTION_CLASS = hashMap;
        hashMap.put("ShareAction", "com.tencent.qqmini.sdk.action.ShareAction");
        hashMap.put("FavoritesAction", "com.tencent.qqmini.sdk.action.FavoritesAction");
        hashMap.put("UpdateUIAction", "com.tencent.qqmini.sdk.action.UpdateUIAction");
        hashMap.put("PageAction", "com.tencent.qqmini.sdk.action.PageAction");
        hashMap.put("RestartAction", "com.tencent.qqmini.sdk.action.RestartAction");
        hashMap.put("GetShareState", "com.tencent.qqmini.sdk.action.GetShareState");
        hashMap.put("GetLastClickAction", "com.tencent.qqmini.minigame.action.GetLastClickAction");
        hashMap.put("GetTheLastClickInfoAction", "com.tencent.qqmini.minigame.action.GetTheLastClickInfoAction");
        hashMap.put(ACTION_NAME_EXPORT_GAME_LOG, "com.tencent.qqmini.minigame.action.ExportLogFileAction");
        hashMap.put(ACTION_NAME_GET_APP_PAGE_ROUTER, "com.tencent.qqmini.miniapp.action.GetAppPageRouterAction");
        hashMap.put(ACTION_NAME_SCREEN_RECORD, "com.tencent.qqmini.sdk.action.ScreenRecordAction");
        hashMap.put("GameVersionAction", "com.tencent.qqmini.minigame.action.GameVersionAction");
    }

    public static Action obtain(String str, int i3, Map<String, Object> map) {
        try {
            Action action = (Action) MiniAppDexLoader.g().create(ACTION_CLASS.get(str));
            if (action != null) {
                try {
                    Field declaredField = action.getClass().getDeclaredField("what");
                    if (declaredField != null) {
                        declaredField.setAccessible(true);
                        declaredField.set(action, Integer.valueOf(i3));
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    QMLog.i(TAG, "set action field:" + entry.getKey() + " valud:" + entry.getValue());
                    if (action != null) {
                        try {
                            Field declaredField2 = action.getClass().getDeclaredField(entry.getKey());
                            if (declaredField2 != null) {
                                declaredField2.setAccessible(true);
                                declaredField2.set(action, entry.getValue());
                            }
                        } catch (Throwable th6) {
                            QMLog.e(TAG, "getField exception! actionName=" + str, th6);
                        }
                    }
                }
            }
            return action;
        } catch (Throwable th7) {
            QMLog.e(TAG, "obtain action exception! actionName=" + str, th7);
            return null;
        }
    }

    public Action<T> getRealAction() {
        return this.realAction;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public T perform(BaseRuntime baseRuntime) {
        Action<T> action = this.realAction;
        if (action != null) {
            return action.perform(baseRuntime);
        }
        return null;
    }

    public void setRealAction(Action<T> action) {
        this.realAction = action;
    }
}
