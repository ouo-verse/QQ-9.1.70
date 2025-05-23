package com.tencent.hippy.qq.api;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyDebugUtil;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForMultiProcess;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscapeForMultiProcess;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForMultiProcess;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscapeForMultiProcess;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.IDomOperate;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class OpenHippyInfo {
    public static final String EXTRA_KEY_BACKGROUND_COLOR = "backgroundColor";
    public static final String EXTRA_KEY_BUNDLE_NAME = "bundleName";
    public static final String EXTRA_KEY_BUNDLE_URL = "bundleUrl";
    public static final String EXTRA_KEY_BUSINESS_BUNDLE = "businessBundle";
    public static final String EXTRA_KEY_BUSINESS_DATA = "businessData";
    public static final String EXTRA_KEY_CALL_API_TIME = "callApiTime";
    public static final String EXTRA_KEY_DOMAIN = "domain";
    public static final String EXTRA_KEY_ENTRANCE_SHOW_TIME = "entranceShowTime";
    public static final String EXTRA_KEY_ERROR_URL = "errorUrl";
    public static final String EXTRA_KEY_FRAMEWORK = "framework";
    public static final String EXTRA_KEY_FROM = "from";
    public static final String EXTRA_KEY_GROUP_ID = "groupId";
    public static final String EXTRA_KEY_IS_ANIMATED = "isAnimated";
    public static final String EXTRA_KEY_IS_COVER_SPLIT_PAGE = "is_cover_split_page";
    public static final String EXTRA_KEY_IS_CUSTOM_NIGHT_MODE = "isCustomNightMode";
    public static final String EXTRA_KEY_IS_DISABLE_PRELOAD = "isDisablePreload";
    public static final String EXTRA_KEY_IS_DISABLE_PRELOAD_WHEN_CLOSED = "isDisablePreloadWhenClosed";
    public static final String EXTRA_KEY_IS_DISABLE_TAB_PRELOAD = "isDisableTabPreload";
    public static final String EXTRA_KEY_IS_ENABLE_RIGHT_FLING = "isEnbaleRightFling";
    public static final String EXTRA_KEY_IS_FULL_SCREEN = "isFullScreen";
    private static final String EXTRA_KEY_IS_IN_TOOL_PROCESS = "isInToolProcess";
    public static final String EXTRA_KEY_IS_LANDSCAPE_SCREEN = "isLandscapeScreen";
    public static final String EXTRA_KEY_IS_LOAD_ON_SPLIT_MODE = "is_load_on_split_mode";
    public static final String EXTRA_KEY_IS_NEED_CLEAR_OTHER_FRAGMENT = "is_need_clear_other_fragment";
    private static final String EXTRA_KEY_IS_OPEN_DEBUG_HIPPY = "isOpenDebugHippy";
    public static final String EXTRA_KEY_IS_PREDRAW = "isPredraw";
    public static final String EXTRA_KEY_IS_PREDRAW_WHEN_CLOSED = "isPredrawWhenClosed";
    public static final String EXTRA_KEY_IS_PRELOAD = "isPreload";
    public static final String EXTRA_KEY_IS_PRELOAD_WHEN_CLOSED = "isPreloadWhenClosed";
    public static final String EXTRA_KEY_IS_STATUSBAR_DARKFONT = "isStatusBarDarkFont";
    public static final String EXTRA_KEY_IS_SUPPORT_SPLIT_MODE = "is_support_split_mode";
    public static final String EXTRA_KEY_IS_TRANSPARENT = "isTransparent";
    public static final String EXTRA_KEY_JS_PARAM_MAP = "js_param_map";
    public static final String EXTRA_KEY_MIN_JS_BUNDLE_VERSION = "minJsBundleVersion";
    public static final String EXTRA_KEY_MIN_SSR_COMMON_VERSION = "minSSRCommonVersion";
    public static final String EXTRA_KEY_OPEN_ID = "openId";
    public static final String EXTRA_KEY_PAGE_URL = "url";
    public static final String EXTRA_KEY_PARAMS = "params";
    public static final String EXTRA_KEY_PRELOAD_TAB_NAME = "preloadTabName";
    public static final String EXTRA_KEY_PRELOAD_TYPE = "preloadType";
    public static final String EXTRA_KEY_PRE_RENDER_TAG = "preRenderTag";
    public static final String EXTRA_KEY_PROCESS_NAME = "processName";
    public static final String EXTRA_KEY_SSR_BUNDLE_DATA = "ssrBundleData";
    public static final String EXTRA_KEY_SSR_BUNDLE_URL = "ssrBundleUrl";
    public static final String EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE = "updateJsBundleType";
    public static final String PROCESS_NAME_LOCAL = "local";
    public static final String PROCESS_NAME_MAIN = "main";
    public static final String PROCESS_NAME_TOOL = "tool";
    public static final String TAG = "HippyAccessHelper";
    public static final int UPDATE_JS_BUNDLE_TYPE_DEFAULT = 0;
    public static final int UPDATE_JS_BUNDLE_TYPE_NO_WAIT = 1;
    public Class<? extends QPublicFragmentActivity> activityClass;
    public String backgroundColor;
    public String bundleName;
    public String bundleUrl;
    public Bundle businessBundle;
    public String businessData;
    public long callApiTime;
    public String domain;
    public long entranceShowTime;
    public String errorUrl;
    public Class<? extends QPublicBaseFragment> fragmentClass;
    public String framework;
    public String from;
    public int groupId;
    public boolean isAnimated;
    public boolean isCoverSplitPage;
    public boolean isCustomNightMode;
    public boolean isDisablePreload;
    public boolean isDisablePreloadWhenClosed;
    public boolean isDisableTabPreload;
    public boolean isEnbaleRightFling;
    public boolean isFullScreen;
    private boolean isInToolProcess;
    public boolean isLandscapeScreen;
    public boolean isLoadOnSplitMode;
    public boolean isNeedClearOtherFragment;
    private boolean isOpenDebugHippy;
    public boolean isPredrawWhenClosed;
    public boolean isPreloadFromExitPage;
    public boolean isPreloadWhenClosed;
    public boolean isStatusBarDarkFont;
    public boolean isSupportSplitMode;
    public boolean isTransparent;
    private IDomOperate mDomOperateInterceptor;
    public SerializableMap mExtraMap;
    public int minJsBundleVersion;
    public int minSSRCommonVersion;
    public int openId;
    public String preRenderTag;
    public String preloadTabName;
    public TabPreloadItem.PreloadType preloadType;
    public String processName;
    public String ssrBundleData;
    public String ssrBundleUrl;
    public int updateJsBundleType;
    public String url;

    public OpenHippyInfo() {
        this.preloadTabName = "";
        this.bundleName = null;
        this.domain = null;
        this.url = null;
        this.errorUrl = null;
        this.isPreloadWhenClosed = false;
        this.preloadType = TabPreloadItem.PreloadType.NO_PRELOAD;
        this.isPredrawWhenClosed = false;
        this.isDisablePreloadWhenClosed = false;
        this.isPreloadFromExitPage = false;
        this.isDisablePreload = false;
        this.isAnimated = false;
        this.isTransparent = false;
        this.isStatusBarDarkFont = false;
        this.processName = null;
        this.isInToolProcess = false;
        this.isEnbaleRightFling = false;
        this.from = null;
        this.bundleUrl = null;
        this.framework = null;
        this.isLandscapeScreen = false;
        this.isFullScreen = true;
        this.isDisableTabPreload = false;
        this.updateJsBundleType = 0;
        this.businessData = "";
        this.preRenderTag = "";
        this.isCustomNightMode = false;
        this.isOpenDebugHippy = false;
        this.entranceShowTime = 0L;
        this.callApiTime = 0L;
        this.groupId = 0;
    }

    private Class<? extends QPublicFragmentActivity> getMainProcessStartActivityClass() {
        if (this.isTransparent) {
            if (this.isLandscapeScreen) {
                return QPublicTransFragmentActivityLandscape.class;
            }
            return QPublicTransFragmentActivity.class;
        }
        if (this.isLandscapeScreen) {
            return QPublicFragmentActivityLandscape.class;
        }
        return QPublicFragmentActivity.class;
    }

    private Class<? extends QPublicFragmentActivity> getMultiProcessStartActivityClass() {
        if (this.isTransparent) {
            if (this.isLandscapeScreen) {
                return QPublicTransFragmentActivityLandscapeForMultiProcess.class;
            }
            return QPublicTransFragmentActivityForMultiProcess.class;
        }
        if (this.isLandscapeScreen) {
            return QPublicFragmentActivityLandscapeForMultiProcess.class;
        }
        return QPublicFragmentActivityForMultiProcess.class;
    }

    private Class<? extends QPublicFragmentActivity> getToolProcessStartActivityClass() {
        if (this.isTransparent) {
            if (this.isLandscapeScreen) {
                return QPublicTransFragmentActivityLandscapeForTool.class;
            }
            return QPublicTransFragmentActivityForTool.class;
        }
        if (this.isLandscapeScreen) {
            return QPublicFragmentActivityLandscapeForTool.class;
        }
        return QPublicFragmentActivityForTool.class;
    }

    public boolean checkData() {
        if (HippyQQConstants.ModuleName.QQ_GAME_CENTER_DEBUG_TOOL.equals(this.bundleName) && !this.isOpenDebugHippy) {
            return false;
        }
        if (this.preloadType == TabPreloadItem.PreloadType.PRE_BASE) {
            if (getProcessName() == null) {
                return false;
            }
            return true;
        }
        if (TextUtils.isEmpty(this.bundleName) || getProcessName() == null) {
            return false;
        }
        return true;
    }

    public OpenHippyInfo enableOpenDebugHippy() {
        this.isOpenDebugHippy = true;
        HippyDebugUtil.setOpenDebugHippyState(true);
        return this;
    }

    public IDomOperate getDomOperateInterceptor() {
        return this.mDomOperateInterceptor;
    }

    public String getProcessName() {
        if (!TextUtils.isEmpty(this.processName)) {
            if (!this.processName.equals("main") && !this.processName.equals("tool") && !this.processName.equals("local")) {
                return null;
            }
            return this.processName;
        }
        if (this.isInToolProcess) {
            return "tool";
        }
        return "main";
    }

    public Class<? extends QPublicFragmentActivity> getStartActivityClass() {
        Class<? extends QPublicFragmentActivity> cls = this.activityClass;
        if (cls != null) {
            return cls;
        }
        String processName = getProcessName();
        if ("main".equals(processName)) {
            return getMainProcessStartActivityClass();
        }
        if ("tool".equals(processName)) {
            return getToolProcessStartActivityClass();
        }
        if ("local".equals(processName)) {
            return getMultiProcessStartActivityClass();
        }
        return null;
    }

    public Class<? extends QPublicBaseFragment> getStartFragmentClass() {
        Class<? extends QPublicBaseFragment> cls = this.fragmentClass;
        if (cls != null) {
            return cls;
        }
        return CommonHippyFragment.class;
    }

    public boolean openHippy(Context context) {
        if (!checkData()) {
            return false;
        }
        if (this.preloadType != TabPreloadItem.PreloadType.NO_PRELOAD) {
            return ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).checkAndPreloadHippyPage(this);
        }
        return ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).openHippyPage(context, this);
    }

    public IDomOperate setDomOperateInterceptor(IDomOperate iDomOperate) {
        this.mDomOperateInterceptor = iDomOperate;
        return iDomOperate;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_KEY_PRELOAD_TAB_NAME, this.preloadTabName);
        bundle.putString("bundleName", this.bundleName);
        bundle.putString("domain", this.domain);
        bundle.putString("url", this.url);
        bundle.putString(EXTRA_KEY_ERROR_URL, this.errorUrl);
        bundle.putBoolean(EXTRA_KEY_IS_PRELOAD_WHEN_CLOSED, this.isPreloadWhenClosed);
        bundle.putString(EXTRA_KEY_PRELOAD_TYPE, TabPreloadItem.preloadTypeToString(this.preloadType));
        bundle.putString(EXTRA_KEY_PRE_RENDER_TAG, this.preRenderTag);
        bundle.putString(EXTRA_KEY_BUSINESS_DATA, this.businessData);
        bundle.putBoolean(EXTRA_KEY_IS_PREDRAW_WHEN_CLOSED, this.isPredrawWhenClosed);
        bundle.putBoolean(EXTRA_KEY_IS_DISABLE_PRELOAD, this.isDisablePreload);
        bundle.putBoolean(EXTRA_KEY_IS_DISABLE_TAB_PRELOAD, this.isDisableTabPreload);
        bundle.putBoolean(EXTRA_KEY_IS_DISABLE_PRELOAD_WHEN_CLOSED, this.isDisablePreloadWhenClosed);
        bundle.putBoolean(EXTRA_KEY_IS_ANIMATED, this.isAnimated);
        bundle.putBoolean(EXTRA_KEY_IS_TRANSPARENT, this.isTransparent);
        bundle.putBoolean(EXTRA_KEY_IS_STATUSBAR_DARKFONT, this.isStatusBarDarkFont);
        bundle.putString("processName", this.processName);
        bundle.putBoolean(EXTRA_KEY_IS_IN_TOOL_PROCESS, this.isInToolProcess);
        bundle.putBoolean(EXTRA_KEY_IS_LANDSCAPE_SCREEN, this.isLandscapeScreen);
        bundle.putBoolean(EXTRA_KEY_IS_FULL_SCREEN, this.isFullScreen);
        bundle.putSerializable(EXTRA_KEY_JS_PARAM_MAP, this.mExtraMap);
        bundle.putBoolean(EXTRA_KEY_IS_ENABLE_RIGHT_FLING, this.isEnbaleRightFling);
        bundle.putString("from", this.from);
        bundle.putString(EXTRA_KEY_BUNDLE_URL, this.bundleUrl);
        bundle.putString("framework", this.framework);
        bundle.putInt(EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE, this.updateJsBundleType);
        bundle.putString("backgroundColor", this.backgroundColor);
        bundle.putBoolean(EXTRA_KEY_IS_CUSTOM_NIGHT_MODE, this.isCustomNightMode);
        bundle.putBoolean(EXTRA_KEY_IS_OPEN_DEBUG_HIPPY, this.isOpenDebugHippy);
        bundle.putLong(EXTRA_KEY_ENTRANCE_SHOW_TIME, this.entranceShowTime);
        bundle.putLong(EXTRA_KEY_CALL_API_TIME, this.callApiTime);
        bundle.putInt(EXTRA_KEY_MIN_JS_BUNDLE_VERSION, this.minJsBundleVersion);
        bundle.putString("ssrBundleUrl", this.ssrBundleUrl);
        bundle.putString("ssrBundleData", this.ssrBundleData);
        bundle.putInt(EXTRA_KEY_MIN_SSR_COMMON_VERSION, this.minSSRCommonVersion);
        bundle.putBundle(EXTRA_KEY_BUSINESS_BUNDLE, this.businessBundle);
        bundle.putInt("openId", this.openId);
        bundle.putBoolean("is_support_split_mode", this.isSupportSplitMode);
        bundle.putBoolean("is_cover_split_page", this.isCoverSplitPage);
        bundle.putBoolean("is_need_clear_other_fragment", this.isNeedClearOtherFragment);
        bundle.putBoolean("is_load_on_split_mode", this.isLoadOnSplitMode);
        bundle.putInt("groupId", this.groupId);
        return bundle;
    }

    public OpenHippyInfo(HippyMap hippyMap) {
        this.preloadTabName = "";
        this.bundleName = null;
        this.domain = null;
        this.url = null;
        this.errorUrl = null;
        this.isPreloadWhenClosed = false;
        this.preloadType = TabPreloadItem.PreloadType.NO_PRELOAD;
        this.isPredrawWhenClosed = false;
        this.isDisablePreloadWhenClosed = false;
        this.isPreloadFromExitPage = false;
        this.isDisablePreload = false;
        this.isAnimated = false;
        this.isTransparent = false;
        this.isStatusBarDarkFont = false;
        this.processName = null;
        this.isInToolProcess = false;
        this.isEnbaleRightFling = false;
        this.from = null;
        this.bundleUrl = null;
        this.framework = null;
        this.isLandscapeScreen = false;
        this.isFullScreen = true;
        this.isDisableTabPreload = false;
        this.updateJsBundleType = 0;
        this.businessData = "";
        this.preRenderTag = "";
        this.isCustomNightMode = false;
        this.isOpenDebugHippy = false;
        this.entranceShowTime = 0L;
        this.callApiTime = 0L;
        this.groupId = 0;
        if (hippyMap == null) {
            return;
        }
        this.preloadTabName = hippyMap.getString(EXTRA_KEY_PRELOAD_TAB_NAME);
        this.bundleName = hippyMap.getString("bundleName");
        this.domain = hippyMap.getString("domain");
        this.url = hippyMap.getString("url");
        this.errorUrl = hippyMap.getString(EXTRA_KEY_ERROR_URL);
        this.isPreloadWhenClosed = hippyMap.getBoolean(EXTRA_KEY_IS_PRELOAD_WHEN_CLOSED);
        this.preloadType = TabPreloadItem.convertToPreloadType(hippyMap.getString(EXTRA_KEY_PRELOAD_TYPE));
        this.preloadType = hippyMap.getBoolean("isPreload") ? TabPreloadItem.PreloadType.PRE_LOAD : this.preloadType;
        this.preloadType = hippyMap.getBoolean("isPredraw") ? TabPreloadItem.PreloadType.PRE_DRAW : this.preloadType;
        this.preRenderTag = hippyMap.getString(EXTRA_KEY_PRE_RENDER_TAG);
        this.businessData = hippyMap.getString(EXTRA_KEY_BUSINESS_DATA);
        this.isPredrawWhenClosed = hippyMap.getBoolean(EXTRA_KEY_IS_PREDRAW_WHEN_CLOSED);
        this.isDisablePreload = hippyMap.getBoolean(EXTRA_KEY_IS_DISABLE_PRELOAD);
        this.isDisableTabPreload = hippyMap.getBoolean(EXTRA_KEY_IS_DISABLE_TAB_PRELOAD);
        this.isDisablePreloadWhenClosed = hippyMap.getBoolean(EXTRA_KEY_IS_DISABLE_PRELOAD_WHEN_CLOSED);
        this.isAnimated = hippyMap.getBoolean(EXTRA_KEY_IS_ANIMATED);
        this.isTransparent = hippyMap.getBoolean(EXTRA_KEY_IS_TRANSPARENT);
        this.isStatusBarDarkFont = hippyMap.getBoolean(EXTRA_KEY_IS_STATUSBAR_DARKFONT);
        this.processName = hippyMap.getString("processName");
        this.isInToolProcess = hippyMap.getBoolean(EXTRA_KEY_IS_IN_TOOL_PROCESS);
        this.isLandscapeScreen = hippyMap.getBoolean(EXTRA_KEY_IS_LANDSCAPE_SCREEN);
        this.isFullScreen = hippyMap.getBoolean(EXTRA_KEY_IS_FULL_SCREEN);
        this.isEnbaleRightFling = hippyMap.getBoolean(EXTRA_KEY_IS_ENABLE_RIGHT_FLING);
        this.from = hippyMap.getString("from");
        this.bundleUrl = hippyMap.getString(EXTRA_KEY_BUNDLE_URL);
        this.framework = hippyMap.getString("framework");
        this.updateJsBundleType = hippyMap.getInt(EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE);
        this.backgroundColor = hippyMap.getString("backgroundColor");
        this.isCustomNightMode = hippyMap.getBoolean(EXTRA_KEY_IS_CUSTOM_NIGHT_MODE);
        this.entranceShowTime = hippyMap.getLong(EXTRA_KEY_ENTRANCE_SHOW_TIME);
        this.callApiTime = hippyMap.getLong(EXTRA_KEY_CALL_API_TIME);
        this.minJsBundleVersion = hippyMap.getInt(EXTRA_KEY_MIN_JS_BUNDLE_VERSION);
        this.ssrBundleUrl = hippyMap.getString("ssrBundleUrl");
        this.ssrBundleData = hippyMap.getString("ssrBundleData");
        this.minSSRCommonVersion = hippyMap.getInt(EXTRA_KEY_MIN_SSR_COMMON_VERSION);
        this.openId = hippyMap.getInt("openId");
        this.isSupportSplitMode = hippyMap.getBoolean("is_support_split_mode");
        this.isCoverSplitPage = hippyMap.getBoolean("is_cover_split_page");
        this.isNeedClearOtherFragment = hippyMap.getBoolean("is_need_clear_other_fragment");
        this.isLoadOnSplitMode = hippyMap.getBoolean("is_load_on_split_mode");
        this.groupId = hippyMap.getInt("groupId");
    }

    public OpenHippyInfo(JSONObject jSONObject) {
        this.preloadTabName = "";
        this.bundleName = null;
        this.domain = null;
        this.url = null;
        this.errorUrl = null;
        this.isPreloadWhenClosed = false;
        this.preloadType = TabPreloadItem.PreloadType.NO_PRELOAD;
        this.isPredrawWhenClosed = false;
        this.isDisablePreloadWhenClosed = false;
        this.isPreloadFromExitPage = false;
        this.isDisablePreload = false;
        this.isAnimated = false;
        this.isTransparent = false;
        this.isStatusBarDarkFont = false;
        this.processName = null;
        this.isInToolProcess = false;
        this.isEnbaleRightFling = false;
        this.from = null;
        this.bundleUrl = null;
        this.framework = null;
        this.isLandscapeScreen = false;
        this.isFullScreen = true;
        this.isDisableTabPreload = false;
        this.updateJsBundleType = 0;
        this.businessData = "";
        this.preRenderTag = "";
        this.isCustomNightMode = false;
        this.isOpenDebugHippy = false;
        this.entranceShowTime = 0L;
        this.callApiTime = 0L;
        this.groupId = 0;
        if (jSONObject == null) {
            return;
        }
        this.preloadTabName = jSONObject.optString(EXTRA_KEY_PRELOAD_TAB_NAME);
        this.bundleName = jSONObject.optString("bundleName");
        this.domain = jSONObject.optString("domain");
        this.url = jSONObject.optString("url");
        this.errorUrl = jSONObject.optString(EXTRA_KEY_ERROR_URL);
        this.isPreloadWhenClosed = jSONObject.optBoolean(EXTRA_KEY_IS_PRELOAD_WHEN_CLOSED);
        this.preloadType = TabPreloadItem.convertToPreloadType(jSONObject.optString(EXTRA_KEY_PRELOAD_TYPE));
        this.preloadType = jSONObject.optBoolean("isPreload") ? TabPreloadItem.PreloadType.PRE_LOAD : this.preloadType;
        this.preloadType = jSONObject.optBoolean("isPredraw") ? TabPreloadItem.PreloadType.PRE_DRAW : this.preloadType;
        this.preRenderTag = jSONObject.optString(EXTRA_KEY_PRE_RENDER_TAG);
        this.businessData = jSONObject.optString(EXTRA_KEY_BUSINESS_DATA);
        this.isPredrawWhenClosed = jSONObject.optBoolean(EXTRA_KEY_IS_PREDRAW_WHEN_CLOSED);
        this.isDisablePreload = jSONObject.optBoolean(EXTRA_KEY_IS_DISABLE_PRELOAD);
        this.isDisableTabPreload = jSONObject.optBoolean(EXTRA_KEY_IS_DISABLE_TAB_PRELOAD);
        this.isDisablePreloadWhenClosed = jSONObject.optBoolean(EXTRA_KEY_IS_DISABLE_PRELOAD_WHEN_CLOSED);
        this.isAnimated = jSONObject.optBoolean(EXTRA_KEY_IS_ANIMATED);
        this.isTransparent = jSONObject.optBoolean(EXTRA_KEY_IS_TRANSPARENT);
        this.isStatusBarDarkFont = jSONObject.optBoolean(EXTRA_KEY_IS_STATUSBAR_DARKFONT);
        this.processName = jSONObject.optString("processName");
        this.isInToolProcess = jSONObject.optBoolean(EXTRA_KEY_IS_IN_TOOL_PROCESS);
        this.isLandscapeScreen = jSONObject.optBoolean(EXTRA_KEY_IS_LANDSCAPE_SCREEN);
        this.isFullScreen = jSONObject.optBoolean(EXTRA_KEY_IS_FULL_SCREEN, true);
        this.isEnbaleRightFling = jSONObject.optBoolean(EXTRA_KEY_IS_ENABLE_RIGHT_FLING);
        this.from = jSONObject.optString("from");
        this.bundleUrl = jSONObject.optString(EXTRA_KEY_BUNDLE_URL);
        this.framework = jSONObject.optString("framework");
        this.updateJsBundleType = jSONObject.optInt(EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE);
        this.backgroundColor = jSONObject.optString("backgroundColor");
        this.isCustomNightMode = jSONObject.optBoolean(EXTRA_KEY_IS_CUSTOM_NIGHT_MODE);
        this.entranceShowTime = jSONObject.optLong(EXTRA_KEY_ENTRANCE_SHOW_TIME);
        this.callApiTime = jSONObject.optLong(EXTRA_KEY_CALL_API_TIME);
        this.minJsBundleVersion = jSONObject.optInt(EXTRA_KEY_MIN_JS_BUNDLE_VERSION);
        this.ssrBundleUrl = jSONObject.optString("ssrBundleUrl");
        this.ssrBundleData = jSONObject.optString("ssrBundleData");
        this.minSSRCommonVersion = jSONObject.optInt(EXTRA_KEY_MIN_SSR_COMMON_VERSION);
        this.openId = jSONObject.optInt("openId");
        this.isSupportSplitMode = jSONObject.optBoolean("is_support_split_mode");
        this.isCoverSplitPage = jSONObject.optBoolean("is_cover_split_page");
        this.isNeedClearOtherFragment = jSONObject.optBoolean("is_need_clear_other_fragment");
        this.isLoadOnSplitMode = jSONObject.optBoolean("is_load_on_split_mode");
        this.groupId = jSONObject.optInt("groupId");
    }

    public OpenHippyInfo(HashMap<String, String> hashMap) {
        this.preloadTabName = "";
        this.bundleName = null;
        this.domain = null;
        this.url = null;
        this.errorUrl = null;
        this.isPreloadWhenClosed = false;
        this.preloadType = TabPreloadItem.PreloadType.NO_PRELOAD;
        this.isPredrawWhenClosed = false;
        this.isDisablePreloadWhenClosed = false;
        this.isPreloadFromExitPage = false;
        this.isDisablePreload = false;
        this.isAnimated = false;
        this.isTransparent = false;
        this.isStatusBarDarkFont = false;
        this.processName = null;
        this.isInToolProcess = false;
        this.isEnbaleRightFling = false;
        this.from = null;
        this.bundleUrl = null;
        this.framework = null;
        this.isLandscapeScreen = false;
        this.isFullScreen = true;
        this.isDisableTabPreload = false;
        this.updateJsBundleType = 0;
        this.businessData = "";
        this.preRenderTag = "";
        this.isCustomNightMode = false;
        this.isOpenDebugHippy = false;
        this.entranceShowTime = 0L;
        this.callApiTime = 0L;
        this.groupId = 0;
        if (hashMap == null) {
            return;
        }
        this.preloadTabName = hashMap.get(EXTRA_KEY_PRELOAD_TAB_NAME);
        this.bundleName = hashMap.get("bundleName");
        this.domain = hashMap.get("domain");
        this.url = hashMap.get("url");
        this.errorUrl = hashMap.get(EXTRA_KEY_ERROR_URL);
        this.isPreloadWhenClosed = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_PRELOAD_WHEN_CLOSED));
        this.preloadType = TabPreloadItem.convertToPreloadType(hashMap.get(EXTRA_KEY_PRELOAD_TYPE));
        this.preloadType = Boolean.parseBoolean(hashMap.get("isPreload")) ? TabPreloadItem.PreloadType.PRE_LOAD : this.preloadType;
        this.preloadType = Boolean.parseBoolean(hashMap.get("isPredraw")) ? TabPreloadItem.PreloadType.PRE_DRAW : this.preloadType;
        this.preRenderTag = hashMap.get(EXTRA_KEY_PRE_RENDER_TAG);
        this.businessData = hashMap.get(EXTRA_KEY_BUSINESS_DATA);
        this.isPredrawWhenClosed = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_PREDRAW_WHEN_CLOSED));
        this.isDisablePreload = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_DISABLE_PRELOAD));
        this.isDisableTabPreload = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_DISABLE_TAB_PRELOAD));
        this.isDisablePreloadWhenClosed = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_DISABLE_PRELOAD_WHEN_CLOSED));
        this.isAnimated = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_ANIMATED));
        this.isTransparent = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_TRANSPARENT));
        this.isStatusBarDarkFont = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_STATUSBAR_DARKFONT));
        this.processName = hashMap.get("processName");
        this.isInToolProcess = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_IN_TOOL_PROCESS));
        this.isLandscapeScreen = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_LANDSCAPE_SCREEN));
        this.isFullScreen = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_FULL_SCREEN));
        this.isEnbaleRightFling = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_ENABLE_RIGHT_FLING));
        this.from = hashMap.get("from");
        this.bundleUrl = hashMap.get(EXTRA_KEY_BUNDLE_URL);
        this.framework = hashMap.get("framework");
        this.updateJsBundleType = hashMap.containsKey(EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE) ? Integer.parseInt(hashMap.get(EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE)) : 0;
        this.backgroundColor = hashMap.get("backgroundColor");
        this.isCustomNightMode = Boolean.parseBoolean(hashMap.get(EXTRA_KEY_IS_CUSTOM_NIGHT_MODE));
        this.entranceShowTime = hashMap.containsKey(EXTRA_KEY_ENTRANCE_SHOW_TIME) ? Long.parseLong(hashMap.get(EXTRA_KEY_ENTRANCE_SHOW_TIME)) : 0L;
        this.callApiTime = hashMap.containsKey(EXTRA_KEY_CALL_API_TIME) ? Long.parseLong(hashMap.get(EXTRA_KEY_CALL_API_TIME)) : 0L;
        this.minJsBundleVersion = hashMap.containsKey(EXTRA_KEY_MIN_JS_BUNDLE_VERSION) ? Integer.parseInt(hashMap.get(EXTRA_KEY_MIN_JS_BUNDLE_VERSION)) : 0;
        this.ssrBundleUrl = hashMap.get("ssrBundleUrl");
        this.ssrBundleData = hashMap.get("ssrBundleData");
        this.minSSRCommonVersion = hashMap.containsKey(EXTRA_KEY_MIN_SSR_COMMON_VERSION) ? Integer.parseInt(hashMap.get(EXTRA_KEY_MIN_SSR_COMMON_VERSION)) : 0;
        this.openId = hashMap.containsKey("openId") ? Integer.parseInt(hashMap.get("openId")) : 0;
        this.isSupportSplitMode = Boolean.parseBoolean(hashMap.get("is_support_split_mode"));
        this.isCoverSplitPage = Boolean.parseBoolean(hashMap.get("is_cover_split_page"));
        this.isNeedClearOtherFragment = Boolean.parseBoolean("is_need_clear_other_fragment");
        this.isLoadOnSplitMode = Boolean.parseBoolean("is_load_on_split_mode");
        this.groupId = hashMap.containsKey("groupId") ? Integer.parseInt(hashMap.get("groupId")) : 0;
    }

    public OpenHippyInfo(Bundle bundle) {
        this.preloadTabName = "";
        this.bundleName = null;
        this.domain = null;
        this.url = null;
        this.errorUrl = null;
        this.isPreloadWhenClosed = false;
        this.preloadType = TabPreloadItem.PreloadType.NO_PRELOAD;
        this.isPredrawWhenClosed = false;
        this.isDisablePreloadWhenClosed = false;
        this.isPreloadFromExitPage = false;
        this.isDisablePreload = false;
        this.isAnimated = false;
        this.isTransparent = false;
        this.isStatusBarDarkFont = false;
        this.processName = null;
        this.isInToolProcess = false;
        this.isEnbaleRightFling = false;
        this.from = null;
        this.bundleUrl = null;
        this.framework = null;
        this.isLandscapeScreen = false;
        this.isFullScreen = true;
        this.isDisableTabPreload = false;
        this.updateJsBundleType = 0;
        this.businessData = "";
        this.preRenderTag = "";
        this.isCustomNightMode = false;
        this.isOpenDebugHippy = false;
        this.entranceShowTime = 0L;
        this.callApiTime = 0L;
        this.groupId = 0;
        if (bundle == null) {
            return;
        }
        this.preloadTabName = bundle.getString(EXTRA_KEY_PRELOAD_TAB_NAME);
        this.bundleName = bundle.getString("bundleName");
        this.domain = bundle.getString("domain");
        this.url = bundle.getString("url");
        this.errorUrl = bundle.getString(EXTRA_KEY_ERROR_URL);
        this.isPreloadWhenClosed = bundle.getBoolean(EXTRA_KEY_IS_PRELOAD_WHEN_CLOSED);
        this.preloadType = TabPreloadItem.convertToPreloadType(bundle.getString(EXTRA_KEY_PRELOAD_TYPE));
        this.preloadType = bundle.getBoolean("isPreload") ? TabPreloadItem.PreloadType.PRE_LOAD : this.preloadType;
        this.preloadType = bundle.getBoolean("isPredraw") ? TabPreloadItem.PreloadType.PRE_DRAW : this.preloadType;
        this.preRenderTag = bundle.getString(EXTRA_KEY_PRE_RENDER_TAG);
        this.businessData = bundle.getString(EXTRA_KEY_BUSINESS_DATA);
        this.isPredrawWhenClosed = bundle.getBoolean(EXTRA_KEY_IS_PREDRAW_WHEN_CLOSED);
        this.isDisablePreload = bundle.getBoolean(EXTRA_KEY_IS_DISABLE_PRELOAD);
        this.isDisableTabPreload = bundle.getBoolean(EXTRA_KEY_IS_DISABLE_TAB_PRELOAD);
        this.isDisablePreloadWhenClosed = bundle.getBoolean(EXTRA_KEY_IS_DISABLE_PRELOAD_WHEN_CLOSED);
        this.isAnimated = bundle.getBoolean(EXTRA_KEY_IS_ANIMATED);
        this.isTransparent = bundle.getBoolean(EXTRA_KEY_IS_TRANSPARENT);
        this.isStatusBarDarkFont = bundle.getBoolean(EXTRA_KEY_IS_STATUSBAR_DARKFONT);
        this.processName = bundle.getString("processName");
        this.isInToolProcess = bundle.getBoolean(EXTRA_KEY_IS_IN_TOOL_PROCESS);
        this.isLandscapeScreen = bundle.getBoolean(EXTRA_KEY_IS_LANDSCAPE_SCREEN);
        this.isFullScreen = bundle.getBoolean(EXTRA_KEY_IS_FULL_SCREEN);
        this.mExtraMap = (SerializableMap) bundle.getSerializable(EXTRA_KEY_JS_PARAM_MAP);
        this.isEnbaleRightFling = bundle.getBoolean(EXTRA_KEY_IS_ENABLE_RIGHT_FLING);
        this.from = bundle.getString("from");
        this.bundleUrl = bundle.getString(EXTRA_KEY_BUNDLE_URL);
        this.framework = bundle.getString("framework");
        this.updateJsBundleType = bundle.getInt(EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE);
        this.backgroundColor = bundle.getString("backgroundColor");
        this.isCustomNightMode = bundle.getBoolean(EXTRA_KEY_IS_CUSTOM_NIGHT_MODE);
        this.isOpenDebugHippy = bundle.getBoolean(EXTRA_KEY_IS_OPEN_DEBUG_HIPPY);
        this.entranceShowTime = bundle.getLong(EXTRA_KEY_ENTRANCE_SHOW_TIME);
        this.callApiTime = bundle.getLong(EXTRA_KEY_CALL_API_TIME);
        this.minJsBundleVersion = bundle.getInt(EXTRA_KEY_MIN_JS_BUNDLE_VERSION);
        this.ssrBundleUrl = bundle.getString("ssrBundleUrl");
        this.ssrBundleData = bundle.getString("ssrBundleData");
        this.minSSRCommonVersion = bundle.getInt(EXTRA_KEY_MIN_SSR_COMMON_VERSION);
        if (this.isOpenDebugHippy) {
            HippyDebugUtil.setOpenDebugHippyState(true);
        }
        this.businessBundle = bundle.getBundle(EXTRA_KEY_BUSINESS_BUNDLE);
        this.openId = bundle.getInt("openId");
        this.isSupportSplitMode = bundle.getBoolean("is_support_split_mode");
        this.isCoverSplitPage = bundle.getBoolean("is_cover_split_page");
        this.isNeedClearOtherFragment = bundle.getBoolean("is_need_clear_other_fragment");
        this.isLoadOnSplitMode = bundle.getBoolean("is_load_on_split_mode");
        this.groupId = bundle.getInt("groupId");
    }
}
