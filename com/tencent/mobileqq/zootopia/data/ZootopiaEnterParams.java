package com.tencent.mobileqq.zootopia.data;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserSettingServlet;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.mobileqq.zplan.authorize.api.CommonModCheckResult;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 j2\u00020\u0001:\u0001kB\u00e9\u0001\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010'\u001a\u00020\u0005\u0012\u0006\u0010*\u001a\u00020\t\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\u0016\b\u0002\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000205\u0018\u000104\u0012\b\b\u0002\u0010<\u001a\u00020\u0002\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010T\u001a\u00020\u0005\u0012\b\b\u0002\u0010X\u001a\u00020W\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u0012\b\b\u0002\u0010e\u001a\u00020\u0005\u00a2\u0006\u0004\bh\u0010iJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\"\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0015R\"\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0015R\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u000f\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0015R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u000f\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0015R\"\u0010*\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R0\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000205\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010/\u001a\u0004\b=\u00101\"\u0004\b>\u00103R\u0019\u0010?\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b?\u0010\u000f\u001a\u0004\b@\u0010\u0011R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bH\u0010J\"\u0004\bK\u0010LR$\u0010N\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010T\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010\u000f\u001a\u0004\bU\u0010\u0011\"\u0004\bV\u0010\u0015R\"\u0010X\u001a\u00020W8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010_\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010\u000f\u001a\u0004\bf\u0010\u0011\"\u0004\bg\u0010\u0015\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "Ljava/io/Serializable;", "", "isGameType", "isSmallHome", "", "toJsonString", "Lorg/json/JSONObject;", "toJsonObject", "", "type", "I", "getType", "()I", "appId", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "openId", "getOpenId", "setOpenId", "(Ljava/lang/String;)V", CommonConstant.KEY_ACCESS_TOKEN, "getAccessToken", "setAccessToken", "pakPath", "getPakPath", "setPakPath", "mapId", "getMapId", "version", "getVersion", "setVersion", "name", "getName", "setName", "projectName", "getProjectName", "setProjectName", "icon", "getIcon", "setIcon", "screenType", "getScreenType", "setScreenType", "(I)V", "showGameHealthyLoading", "Z", "getShowGameHealthyLoading", "()Z", "setShowGameHealthyLoading", "(Z)V", "", "", "ueParams", "Ljava/util/Map;", "getUeParams", "()Ljava/util/Map;", "setUeParams", "(Ljava/util/Map;)V", "needMinorsHeartBeat", "getNeedMinorsHeartBeat", "setNeedMinorsHeartBeat", "cloudModUrl", "getCloudModUrl", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "loadingParams", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "getLoadingParams", "()Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "setLoadingParams", "(Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setDownloaded", "(Ljava/lang/Boolean;)V", "", "progress", "Ljava/lang/Float;", HippyQQPagView.FunctionName.GET_PROGRESS, "()Ljava/lang/Float;", HippyQQPagView.FunctionName.SET_PROGRESS, "(Ljava/lang/Float;)V", "source", "getSource", "setSource", "", "startTime", "J", "getStartTime", "()J", "setStartTime", "(J)V", "Lcom/tencent/mobileqq/zplan/authorize/api/CommonModCheckResult;", "commonModCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/CommonModCheckResult;", "getCommonModCheckResult", "()Lcom/tencent/mobileqq/zplan/authorize/api/CommonModCheckResult;", "setCommonModCheckResult", "(Lcom/tencent/mobileqq/zplan/authorize/api/CommonModCheckResult;)V", "loadingId", "getLoadingId", "setLoadingId", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/Map;ZLjava/lang/String;Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/String;JLcom/tencent/mobileqq/zplan/authorize/api/CommonModCheckResult;Ljava/lang/String;)V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class ZootopiaEnterParams implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_HOT_PATCH_FOLDER = "HotPatchFolder";
    public static final String KEY_HOT_PATCH_VERSION = "HotPatchVersion";
    public static final String KEY_SMALL_HOME_LOAD_FROM = "smallHomeLoadFrom";
    public static final String KEY_TOKEN = "Token";
    public static final int VIEW_TYPE_GAME = 7;
    public static final int VIEW_TYPE_WORLD = 6;
    public static final String ZPLAN_APP_ID = "101968081";
    public static final String ZPLAN_APP_KEY = "79609997d78b8997e9c7989cba210936";
    private String accessToken;
    private final String appId;
    private final String cloudModUrl;
    private CommonModCheckResult commonModCheckResult;
    private String icon;
    private Boolean isDownloaded;
    private String loadingId;
    private ZootopiaMapLoadingParams loadingParams;
    private final int mapId;
    private String name;
    private boolean needMinorsHeartBeat;
    private String openId;
    private String pakPath;
    private Float progress;
    private String projectName;
    private int screenType;
    private boolean showGameHealthyLoading;
    private String source;
    private long startTime;
    private final int type;
    private Map<String, ? extends Object> ueParams;
    private String version;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004Ja\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0015R\u0014\u0010#\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0015\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams$a;", "", "", "mapId", "", "loadingId", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "a", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "loadingParams", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "", "progress", "source", "", "startTime", "modVersion", "b", "(ILcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", MiniAppGetUserSettingServlet.KEY_APP_ID, "Ljava/lang/String;", "KEY_HOT_PATCH_FOLDER", "KEY_HOT_PATCH_VERSION", MiniAppGetUserSettingServlet.KEY_OPEN_ID, "KEY_PAK_PATH", "KEY_SMALL_HOME_LOAD_FROM", "KEY_TOKEN", "KEY_UIN", "KEY_VERSION", "KEY_VIEW_TYPE", "VIEW_TYPE_GAME", "I", "VIEW_TYPE_WORLD", "ZPLAN_APP_ID", "ZPLAN_APP_KEY", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaEnterParams b(int mapId, ZootopiaMapLoadingParams loadingParams, Boolean isDownloaded, Float progress, String source, long startTime, String loadingId, String modVersion) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(modVersion, "modVersion");
            return new ZootopiaEnterParams(0, null, "", "", "", mapId, modVersion, "", "", "", 2, false, null, false, null, loadingParams, isDownloaded, progress, source, startTime, null, loadingId == null ? "" : loadingId, 1079299, null);
        }

        Companion() {
        }

        public final ZootopiaEnterParams a(int mapId, String loadingId) {
            Intrinsics.checkNotNullParameter(loadingId, "loadingId");
            return new ZootopiaEnterParams(0, null, "", "", "", mapId, "", "", "", "", 2, false, null, false, null, null, null, null, null, 0L, null, loadingId, 2095107, null);
        }
    }

    public ZootopiaEnterParams(int i3, String appId, String openId, String accessToken, String pakPath, int i16, String version, String name, String projectName, String icon, int i17, boolean z16, Map<String, ? extends Object> map, boolean z17, String str, ZootopiaMapLoadingParams zootopiaMapLoadingParams, Boolean bool, Float f16, String source, long j3, CommonModCheckResult commonModCheckResult, String loadingId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(pakPath, "pakPath");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(projectName, "projectName");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(loadingId, "loadingId");
        this.type = i3;
        this.appId = appId;
        this.openId = openId;
        this.accessToken = accessToken;
        this.pakPath = pakPath;
        this.mapId = i16;
        this.version = version;
        this.name = name;
        this.projectName = projectName;
        this.icon = icon;
        this.screenType = i17;
        this.showGameHealthyLoading = z16;
        this.ueParams = map;
        this.needMinorsHeartBeat = z17;
        this.cloudModUrl = str;
        this.loadingParams = zootopiaMapLoadingParams;
        this.isDownloaded = bool;
        this.progress = f16;
        this.source = source;
        this.startTime = j3;
        this.commonModCheckResult = commonModCheckResult;
        this.loadingId = loadingId;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getCloudModUrl() {
        return this.cloudModUrl;
    }

    public final CommonModCheckResult getCommonModCheckResult() {
        return this.commonModCheckResult;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getLoadingId() {
        return this.loadingId;
    }

    public final ZootopiaMapLoadingParams getLoadingParams() {
        return this.loadingParams;
    }

    public final int getMapId() {
        return this.mapId;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNeedMinorsHeartBeat() {
        return this.needMinorsHeartBeat;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final String getPakPath() {
        return this.pakPath;
    }

    public final Float getProgress() {
        return this.progress;
    }

    public final String getProjectName() {
        return this.projectName;
    }

    public final int getScreenType() {
        return this.screenType;
    }

    public final boolean getShowGameHealthyLoading() {
        return this.showGameHealthyLoading;
    }

    public final String getSource() {
        return this.source;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final int getType() {
        return this.type;
    }

    public final Map<String, Object> getUeParams() {
        return this.ueParams;
    }

    public final String getVersion() {
        return this.version;
    }

    /* renamed from: isDownloaded, reason: from getter */
    public final Boolean getIsDownloaded() {
        return this.isDownloaded;
    }

    public final boolean isGameType() {
        return this.type == 7;
    }

    public final boolean isSmallHome() {
        return isGameType() && this.mapId == 200001;
    }

    public final void setAccessToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accessToken = str;
    }

    public final void setCommonModCheckResult(CommonModCheckResult commonModCheckResult) {
        this.commonModCheckResult = commonModCheckResult;
    }

    public final void setDownloaded(Boolean bool) {
        this.isDownloaded = bool;
    }

    public final void setIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final void setLoadingId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.loadingId = str;
    }

    public final void setLoadingParams(ZootopiaMapLoadingParams zootopiaMapLoadingParams) {
        this.loadingParams = zootopiaMapLoadingParams;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setNeedMinorsHeartBeat(boolean z16) {
        this.needMinorsHeartBeat = z16;
    }

    public final void setOpenId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openId = str;
    }

    public final void setPakPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pakPath = str;
    }

    public final void setProgress(Float f16) {
        this.progress = f16;
    }

    public final void setProjectName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.projectName = str;
    }

    public final void setScreenType(int i3) {
        this.screenType = i3;
    }

    public final void setShowGameHealthyLoading(boolean z16) {
        this.showGameHealthyLoading = z16;
    }

    public final void setSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.source = str;
    }

    public final void setStartTime(long j3) {
        this.startTime = j3;
    }

    public final void setUeParams(Map<String, ? extends Object> map) {
        this.ueParams = map;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ViewType", this.type);
        jSONObject.put("AppId", this.appId);
        jSONObject.put("OpenId", this.openId);
        jSONObject.put("PakPath", this.pakPath);
        jSONObject.put("RoomBaseVersion", this.version);
        String currentUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(currentUin, "MobileQQ.sMobileQQ.waitA\u2026me(null).currentUin ?: \"\"");
        }
        jSONObject.put("Uin", currentUin);
        jSONObject.put(KEY_SMALL_HOME_LOAD_FROM, this.source);
        jSONObject.put(KEY_TOKEN, this.accessToken);
        Map<String, ? extends Object> map = this.ueParams;
        if (map != null && (r1 = map.entrySet().iterator()) != null) {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                if (entry.getValue() instanceof Map) {
                    Object value = entry.getValue();
                    Map<String, ? extends Object> map2 = value instanceof Map ? (Map) value : null;
                    if (map2 != null) {
                        jSONObject.put(entry.getKey(), DataConvertUtil.f329546a.d(map2));
                    }
                } else {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return jSONObject;
    }

    public final String toJsonString() {
        String jSONObject = toJsonObject().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toJsonObject().toString()");
        return jSONObject;
    }

    public /* synthetic */ ZootopiaEnterParams(int i3, String str, String str2, String str3, String str4, int i16, String str5, String str6, String str7, String str8, int i17, boolean z16, Map map, boolean z17, String str9, ZootopiaMapLoadingParams zootopiaMapLoadingParams, Boolean bool, Float f16, String str10, long j3, CommonModCheckResult commonModCheckResult, String str11, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 6 : i3, (i18 & 2) != 0 ? ZPLAN_APP_ID : str, str2, str3, str4, i16, str5, str6, str7, str8, i17, (i18 & 2048) != 0 ? false : z16, (i18 & 4096) != 0 ? null : map, (i18 & 8192) != 0 ? false : z17, (i18 & 16384) != 0 ? null : str9, (32768 & i18) != 0 ? null : zootopiaMapLoadingParams, (65536 & i18) != 0 ? Boolean.TRUE : bool, (131072 & i18) != 0 ? Float.valueOf(100.0f) : f16, (262144 & i18) != 0 ? "0" : str10, (524288 & i18) != 0 ? System.currentTimeMillis() : j3, (1048576 & i18) != 0 ? null : commonModCheckResult, (i18 & 2097152) != 0 ? "" : str11);
    }
}
