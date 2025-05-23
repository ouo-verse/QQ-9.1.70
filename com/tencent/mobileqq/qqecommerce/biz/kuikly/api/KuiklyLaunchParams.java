package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import android.os.Bundle;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u000e\u0018\u0000 \\2\u00020\u0001:\u0001]B\u0007\u00a2\u0006\u0004\bZ\u0010[J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R$\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\nR\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR\"\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\nR$\u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0006\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\nR$\u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0006\u001a\u0004\b.\u0010\b\"\u0004\b/\u0010\nR\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00102\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\"\u0010:\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0010\u001a\u0004\b;\u0010\u0011\"\u0004\b<\u0010\u0013R$\u0010>\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010D\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010?\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR$\u0010G\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bG\u0010I\"\u0004\bJ\u0010KR$\u0010L\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010?\u001a\u0004\bM\u0010A\"\u0004\bN\u0010CR.\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020P0O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010W\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010\u0006\u001a\u0004\bX\u0010\b\"\u0004\bY\u0010\n\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/KuiklyLaunchParams;", "Ljava/io/Serializable;", "Landroid/os/Bundle;", "toBundle", "", "pageName", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", OpenHippyInfo.EXTRA_KEY_ERROR_URL, "getErrorUrl", "setErrorUrl", "", "isModal", "Z", "()Z", "setModal", "(Z)V", MiniChatConstants.MINI_APP_LANDSCAPE, "setLandscape", "url", "getUrl", "setUrl", "isDynamicMode", "setDynamicMode", "processName", "getProcessName", "setProcessName", OpenHippyInfo.EXTRA_KEY_IS_ANIMATED, "setAnimated", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/UpdateType;", "updateType", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/UpdateType;", "getUpdateType", "()Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/UpdateType;", "setUpdateType", "(Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/UpdateType;)V", "resId", "getResId", "setResId", "minQQVersion", "getMinQQVersion", "setMinQQVersion", "minResVersion", "getMinResVersion", "setMinResVersion", "", "openPageTs", "J", "getOpenPageTs", "()J", "setOpenPageTs", "(J)V", "timeout", "getTimeout", "setTimeout", "syncRendering", "getSyncRendering", "setSyncRendering", "", "activityForResultRequestCode", "Ljava/lang/Integer;", "getActivityForResultRequestCode", "()Ljava/lang/Integer;", "setActivityForResultRequestCode", "(Ljava/lang/Integer;)V", "quiTokenThemeMode", "getQuiTokenThemeMode", "setQuiTokenThemeMode", "isBottomNavBarImmersive", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setBottomNavBarImmersive", "(Ljava/lang/Boolean;)V", "activityAnimateType", "getActivityAnimateType", "setActivityAnimateType", "", "", "extMap", "Ljava/util/Map;", "getExtMap", "()Ljava/util/Map;", "setExtMap", "(Ljava/util/Map;)V", "qqmcConfig", "getQqmcConfig", "setQqmcConfig", "<init>", "()V", "Companion", "a", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class KuiklyLaunchParams implements Serializable {
    public static final int ACTIVITY_ANIMATE_TYPE_DEFAULT = 0;
    public static final int ACTIVITY_ANIMATE_TYPE_WEB = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String PARAM_ACTIVITY_ANIMATE_TYPE = "activity_animate_type";

    @NotNull
    public static final String PARAM_BOTTOM_NAV_BAR_HEIGHT = "bottom_nav_bar_height";

    @NotNull
    public static final String PARAM_BOTTOM_NAV_BAR_IMMERSIVE = "bottom_nav_bar_immersive";

    @NotNull
    public static final String PARAM_BUNDLE_NAME = "bundle_name";

    @NotNull
    public static final String PARAM_BUNDLE_SCENE = "scene_id";

    @NotNull
    public static final String PARAM_CUSTOM_BACK_PRESSED = "custom_back_pressed";

    @NotNull
    public static final String PARAM_ERROR_URL = "error_url";

    @NotNull
    public static final String PARAM_EXIT_NO_ANIMATE = "exit_no_animate";

    @NotNull
    public static final String PARAM_IS_ANIMATED = "is_animated";

    @NotNull
    public static final String PARAM_IS_COVER_SPLIT_PAGE = "is_cover_split_page";

    @NotNull
    public static final String PARAM_IS_DYNAMIC_MODE = "is_dynamic_mode";

    @NotNull
    public static final String PARAM_IS_LANDSCAPE = "is_landscape";

    @NotNull
    public static final String PARAM_IS_LOAD_ON_SPLIT_MODE = "is_load_on_split_mode";

    @NotNull
    public static final String PARAM_IS_NEED_CLEAR_OTHER_FRAGMENT = "is_need_clear_other_fragment";

    @NotNull
    public static final String PARAM_IS_SUPPORT_SPLIT_MODE = "is_support_split_mode";

    @NotNull
    public static final String PARAM_LAUNCH_MODE_ON_SPLIT_MODE = "launch_mode_on_split_mode";

    @NotNull
    public static final String PARAM_LOCAL_BUNDLE_NAME = "local_bundle_name";

    @NotNull
    public static final String PARAM_MIN_QQ_VERSION = "kr_min_qq_version";

    @NotNull
    public static final String PARAM_MIN_RES_VERSION = "kr_min_res_version";

    @NotNull
    public static final String PARAM_MODAL_MODE = "modal_mode";

    @NotNull
    public static final String PARAM_OPEN_PAGE_TS = "open_page_ts";

    @NotNull
    public static final String PARAM_PAGE_NAME = "page_name";

    @NotNull
    public static final String PARAM_PAGE_SOURCE = "source";

    @NotNull
    public static final String PARAM_PROCESS_NAME = "process_name";

    @NotNull
    public static final String PARAM_QQMC_CONFIG = "qqmc_config";

    @NotNull
    public static final String PARAM_QUI_TOKEN_THEME_MODE = "qui_token_theme_mode";

    @NotNull
    public static final String PARAM_START_ACTIVITY_FOR_RESULT = "start_activity_for_result";

    @NotNull
    public static final String PARAM_SYNC_RENDERING = "sync_rendering";

    @NotNull
    public static final String PARAM_TIME_OUT = "timeout";

    @NotNull
    public static final String PARAM_TURBO_DISPLAY = "kr_turbo_display";

    @NotNull
    public static final String PARAM_UPDATE_TYPE = "update_type";

    @NotNull
    public static final String PARAM_URL = "url";

    @NotNull
    public static final String PARAM_USE_HOST_DISPLAY_METRICS = "use_host_display_metrics";

    @NotNull
    public static final String PROCESS_NAME_LOCAL = "local";

    @NotNull
    public static final String PROCESS_NAME_MAIN = "main";

    @NotNull
    public static final String PROCESS_NAME_TOOL = "tool";

    @NotNull
    public static final String SPLIT_MODE_LAUNCH_MODE_SINGLE_TASK = "single_task";

    @NotNull
    public static final String SPLIT_MODE_LAUNCH_MODE_SINGLE_TOP = "single_top";

    @NotNull
    public static final String SPLIT_MODE_LAUNCH_MODE_STANDARD = "standard";

    @NotNull
    public static final String VALUE_INT_ENABLE = "1";

    @NotNull
    public static final String VALUE_STR_TRUE = "true";
    private static final long serialVersionUID = 1;

    @Nullable
    private Integer activityAnimateType;

    @Nullable
    private Integer activityForResultRequestCode;

    @Nullable
    private String errorUrl;

    @Nullable
    private Boolean isBottomNavBarImmersive;
    private boolean isDynamicMode;
    private boolean isLandscape;
    private boolean isModal;

    @Nullable
    private String minQQVersion;

    @Nullable
    private String minResVersion;
    private long openPageTs;

    @Nullable
    private String pageName;

    @Nullable
    private String processName;

    @Nullable
    private Integer quiTokenThemeMode;

    @Nullable
    private String resId;

    @Nullable
    private String url;
    private boolean isAnimated = true;

    @NotNull
    private UpdateType updateType = UpdateType.TYPE_USE_LOCAL_PRIORITY;
    private long timeout = 10000;
    private boolean syncRendering = true;

    @NotNull
    private Map<String, Object> extMap = new LinkedHashMap();

    @NotNull
    private String qqmcConfig = "";

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b2\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bO\u0010PJ\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J#\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\b\u00a2\u0006\u0004\b\u001d\u0010\u0013J#\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010#R\u0014\u0010'\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0014\u0010(\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010#R\u0014\u0010)\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010#R\u0014\u0010*\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010#R\u0014\u0010+\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010#R\u0014\u0010,\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010#R\u0014\u0010-\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010#R\u0014\u0010.\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010#R\u0014\u0010/\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u0010#R\u0014\u00100\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b0\u0010#R\u0014\u00101\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u0010#R\u0014\u00102\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b2\u0010#R\u0014\u00103\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b3\u0010#R\u0014\u00104\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b4\u0010#R\u0014\u00105\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b5\u0010#R\u0014\u00106\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b6\u0010#R\u0014\u00107\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b7\u0010#R\u0014\u00108\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b8\u0010#R\u0014\u00109\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b9\u0010#R\u0014\u0010:\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b:\u0010#R\u0014\u0010;\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b;\u0010#R\u0014\u0010<\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b<\u0010#R\u0014\u0010=\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b=\u0010#R\u0014\u0010>\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b>\u0010#R\u0014\u0010?\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b?\u0010#R\u0014\u0010@\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b@\u0010#R\u0014\u0010A\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bA\u0010#R\u0014\u0010B\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bB\u0010#R\u0014\u0010C\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bC\u0010#R\u0014\u0010D\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bD\u0010#R\u0014\u0010E\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bE\u0010#R\u0014\u0010F\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bF\u0010#R\u0014\u0010G\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bG\u0010#R\u0014\u0010H\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bH\u0010#R\u0014\u0010I\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bI\u0010#R\u0014\u0010J\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bJ\u0010#R\u0014\u0010K\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bK\u0010#R\u0014\u0010M\u001a\u00020L8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/KuiklyLaunchParams$a;", "", "requestCode", "", "c", "(Ljava/lang/Object;)Ljava/lang/Integer;", "intValue", "e", "Landroid/os/Bundle;", "bundle", "", "l", "g", "k", "value", "i", "j", tl.h.F, "a", "(Landroid/os/Bundle;)Ljava/lang/Integer;", "Lorg/json/JSONObject;", "jsonObject", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "params", "d", "(Ljava/util/Map;)Ljava/lang/Integer;", "b", "f", "ACTIVITY_ANIMATE_TYPE_DEFAULT", "I", "ACTIVITY_ANIMATE_TYPE_WEB", "PARAM_ACTIVITY_ANIMATE_TYPE", "Ljava/lang/String;", "PARAM_BOTTOM_NAV_BAR_HEIGHT", "PARAM_BOTTOM_NAV_BAR_IMMERSIVE", "PARAM_BUNDLE_NAME", "PARAM_BUNDLE_SCENE", "PARAM_CUSTOM_BACK_PRESSED", "PARAM_ERROR_URL", "PARAM_EXIT_NO_ANIMATE", "PARAM_IS_ANIMATED", "PARAM_IS_COVER_SPLIT_PAGE", "PARAM_IS_DYNAMIC_MODE", "PARAM_IS_LANDSCAPE", "PARAM_IS_LOAD_ON_SPLIT_MODE", "PARAM_IS_NEED_CLEAR_OTHER_FRAGMENT", "PARAM_IS_SUPPORT_SPLIT_MODE", "PARAM_LAUNCH_MODE_ON_SPLIT_MODE", "PARAM_LOCAL_BUNDLE_NAME", "PARAM_MIN_QQ_VERSION", "PARAM_MIN_RES_VERSION", "PARAM_MODAL_MODE", "PARAM_OPEN_PAGE_TS", "PARAM_PAGE_NAME", "PARAM_PAGE_SOURCE", "PARAM_PROCESS_NAME", "PARAM_QQMC_CONFIG", "PARAM_QUI_TOKEN_THEME_MODE", "PARAM_START_ACTIVITY_FOR_RESULT", "PARAM_SYNC_RENDERING", "PARAM_TIME_OUT", "PARAM_TURBO_DISPLAY", "PARAM_UPDATE_TYPE", "PARAM_URL", "PARAM_USE_HOST_DISPLAY_METRICS", "PROCESS_NAME_LOCAL", "PROCESS_NAME_MAIN", "PROCESS_NAME_TOOL", "SPLIT_MODE_LAUNCH_MODE_SINGLE_TASK", "SPLIT_MODE_LAUNCH_MODE_SINGLE_TOP", "SPLIT_MODE_LAUNCH_MODE_STANDARD", "VALUE_INT_ENABLE", "VALUE_STR_TRUE", "", "serialVersionUID", "J", "<init>", "()V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Integer c(Object requestCode) {
            if (requestCode instanceof Integer) {
                return (Integer) requestCode;
            }
            if (requestCode instanceof Long) {
                return Integer.valueOf((int) ((Number) requestCode).longValue());
            }
            if (requestCode instanceof String) {
                try {
                    return Integer.valueOf(Integer.parseInt((String) requestCode));
                } catch (Throwable th5) {
                    QLog.e("getActivityResultRequestCode", 1, "get request code error: " + th5);
                }
            }
            return null;
        }

        private final Integer e(Object intValue) {
            if (intValue instanceof Integer) {
                return (Integer) intValue;
            }
            if (intValue instanceof Long) {
                return Integer.valueOf((int) ((Number) intValue).longValue());
            }
            if (intValue instanceof String) {
                try {
                    return Integer.valueOf(Integer.parseInt((String) intValue));
                } catch (Throwable th5) {
                    QLog.e("getInt", 1, "get getInt error: " + th5);
                }
            }
            return null;
        }

        @Nullable
        public final Integer a(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return e(bundle.get(KuiklyLaunchParams.PARAM_ACTIVITY_ANIMATE_TYPE));
        }

        @Nullable
        public final Integer b(@NotNull Bundle params) {
            Intrinsics.checkNotNullParameter(params, "params");
            return c(params.get(KuiklyLaunchParams.PARAM_START_ACTIVITY_FOR_RESULT));
        }

        @Nullable
        public final Integer d(@NotNull Map<String, ? extends Object> params) {
            Intrinsics.checkNotNullParameter(params, "params");
            return c(params.get(KuiklyLaunchParams.PARAM_START_ACTIVITY_FOR_RESULT));
        }

        @Nullable
        public final Integer f(@NotNull Map<String, ? extends Object> params) {
            Intrinsics.checkNotNullParameter(params, "params");
            return e(params.get(KuiklyLaunchParams.PARAM_QUI_TOKEN_THEME_MODE));
        }

        public final boolean g(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Object obj = bundle.get(KuiklyLaunchParams.PARAM_IS_ANIMATED);
            if (obj != null && !i(obj)) {
                return false;
            }
            return true;
        }

        public final boolean h(@Nullable Bundle bundle) {
            Object obj;
            if (bundle != null) {
                obj = bundle.get(KuiklyLaunchParams.PARAM_BOTTOM_NAV_BAR_IMMERSIVE);
            } else {
                obj = null;
            }
            Integer e16 = e(obj);
            if (e16 != null && e16.intValue() == 1) {
                return true;
            }
            return false;
        }

        public final boolean i(@Nullable Object value) {
            if (!Intrinsics.areEqual(value, Boolean.TRUE) && !Intrinsics.areEqual(value, "1") && !Intrinsics.areEqual(value, "true")) {
                return false;
            }
            return true;
        }

        public final boolean j(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return i(bundle.get(KuiklyLaunchParams.PARAM_EXIT_NO_ANIMATE));
        }

        public final boolean k(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return i(bundle.get(KuiklyLaunchParams.PARAM_IS_LANDSCAPE));
        }

        public final boolean l(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return i(bundle.get(KuiklyLaunchParams.PARAM_MODAL_MODE));
        }

        @NotNull
        public final Map<String, Object> m(@Nullable JSONObject jsonObject) {
            if (jsonObject == null) {
                return new LinkedHashMap();
            }
            return nf2.a.a(jsonObject);
        }

        Companion() {
        }
    }

    @Nullable
    public final Integer getActivityAnimateType() {
        return this.activityAnimateType;
    }

    @Nullable
    public final Integer getActivityForResultRequestCode() {
        return this.activityForResultRequestCode;
    }

    @Nullable
    public final String getErrorUrl() {
        return this.errorUrl;
    }

    @NotNull
    public final Map<String, Object> getExtMap() {
        return this.extMap;
    }

    @Nullable
    public final String getMinQQVersion() {
        return this.minQQVersion;
    }

    @Nullable
    public final String getMinResVersion() {
        return this.minResVersion;
    }

    public final long getOpenPageTs() {
        return this.openPageTs;
    }

    @Nullable
    public final String getPageName() {
        return this.pageName;
    }

    @Nullable
    public final String getProcessName() {
        return this.processName;
    }

    @NotNull
    public final String getQqmcConfig() {
        return this.qqmcConfig;
    }

    @Nullable
    public final Integer getQuiTokenThemeMode() {
        return this.quiTokenThemeMode;
    }

    @Nullable
    public final String getResId() {
        return this.resId;
    }

    public final boolean getSyncRendering() {
        return this.syncRendering;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    @NotNull
    public final UpdateType getUpdateType() {
        return this.updateType;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: isAnimated, reason: from getter */
    public final boolean getIsAnimated() {
        return this.isAnimated;
    }

    @Nullable
    /* renamed from: isBottomNavBarImmersive, reason: from getter */
    public final Boolean getIsBottomNavBarImmersive() {
        return this.isBottomNavBarImmersive;
    }

    /* renamed from: isDynamicMode, reason: from getter */
    public final boolean getIsDynamicMode() {
        return this.isDynamicMode;
    }

    /* renamed from: isLandscape, reason: from getter */
    public final boolean getIsLandscape() {
        return this.isLandscape;
    }

    /* renamed from: isModal, reason: from getter */
    public final boolean getIsModal() {
        return this.isModal;
    }

    public final void setActivityAnimateType(@Nullable Integer num) {
        this.activityAnimateType = num;
    }

    public final void setActivityForResultRequestCode(@Nullable Integer num) {
        this.activityForResultRequestCode = num;
    }

    public final void setAnimated(boolean z16) {
        this.isAnimated = z16;
    }

    public final void setBottomNavBarImmersive(@Nullable Boolean bool) {
        this.isBottomNavBarImmersive = bool;
    }

    public final void setDynamicMode(boolean z16) {
        this.isDynamicMode = z16;
    }

    public final void setErrorUrl(@Nullable String str) {
        this.errorUrl = str;
    }

    public final void setExtMap(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extMap = map;
    }

    public final void setLandscape(boolean z16) {
        this.isLandscape = z16;
    }

    public final void setMinQQVersion(@Nullable String str) {
        this.minQQVersion = str;
    }

    public final void setMinResVersion(@Nullable String str) {
        this.minResVersion = str;
    }

    public final void setModal(boolean z16) {
        this.isModal = z16;
    }

    public final void setOpenPageTs(long j3) {
        this.openPageTs = j3;
    }

    public final void setPageName(@Nullable String str) {
        this.pageName = str;
    }

    public final void setProcessName(@Nullable String str) {
        this.processName = str;
    }

    public final void setQqmcConfig(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qqmcConfig = str;
    }

    public final void setQuiTokenThemeMode(@Nullable Integer num) {
        this.quiTokenThemeMode = num;
    }

    public final void setResId(@Nullable String str) {
        this.resId = str;
    }

    public final void setSyncRendering(boolean z16) {
        this.syncRendering = z16;
    }

    public final void setTimeout(long j3) {
        this.timeout = j3;
    }

    public final void setUpdateType(@NotNull UpdateType updateType) {
        Intrinsics.checkNotNullParameter(updateType, "<set-?>");
        this.updateType = updateType;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("page_name", this.pageName);
        bundle.putString(PARAM_ERROR_URL, this.errorUrl);
        bundle.putString("url", this.url);
        bundle.putBoolean(PARAM_MODAL_MODE, this.isModal);
        bundle.putBoolean(PARAM_IS_LANDSCAPE, this.isLandscape);
        bundle.putBoolean(PARAM_IS_DYNAMIC_MODE, this.isDynamicMode);
        bundle.putString("process_name", this.processName);
        bundle.putBoolean(PARAM_IS_ANIMATED, this.isAnimated);
        bundle.putInt("update_type", this.updateType.getType());
        bundle.putString("bundle_name", this.resId);
        bundle.putString(PARAM_MIN_QQ_VERSION, this.minQQVersion);
        bundle.putString(PARAM_MIN_RES_VERSION, this.minResVersion);
        bundle.putLong(PARAM_OPEN_PAGE_TS, this.openPageTs);
        bundle.putLong("timeout", this.timeout);
        bundle.putString(PARAM_QQMC_CONFIG, this.qqmcConfig);
        bundle.putBoolean(PARAM_SYNC_RENDERING, this.syncRendering);
        Integer num = this.activityForResultRequestCode;
        if (num != null) {
            bundle.putInt(PARAM_START_ACTIVITY_FOR_RESULT, num.intValue());
        }
        Integer num2 = this.quiTokenThemeMode;
        if (num2 != null) {
            bundle.putInt(PARAM_QUI_TOKEN_THEME_MODE, num2.intValue());
        }
        Boolean bool = this.isBottomNavBarImmersive;
        if (bool != null) {
            bundle.putInt(PARAM_BOTTOM_NAV_BAR_IMMERSIVE, bool.booleanValue() ? 1 : 0);
        }
        Integer num3 = this.activityAnimateType;
        if (num3 != null) {
            bundle.putInt(PARAM_ACTIVITY_ANIMATE_TYPE, num3.intValue());
        }
        bundle.putAll(nf2.a.b(this.extMap));
        return bundle;
    }
}
