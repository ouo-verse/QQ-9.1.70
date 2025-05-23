package com.tencent.rmonitor.base.meta;

import android.app.Application;
import android.content.SharedPreferences;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.common.constants.SPKey;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.network.ssl.NameVerifierFactory;
import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.bugly.common.sp.SharedPreferencesProvider;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.rmonitor.base.db.d;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.logger.NativeLogger;
import com.tencent.rmonitor.common.util.AsyncSPEditor;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.b;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import r04.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/rmonitor/base/meta/BaseInfo;", "", "()V", "Info", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final class BaseInfo {

    @JvmField
    @Nullable
    public static Application app;

    @JvmField
    @Nullable
    public static d dbHelper;

    @JvmField
    @NotNull
    public static AsyncSPEditor editor;

    @JvmField
    @NotNull
    public static AtomicBoolean hasInit;

    @JvmField
    @Nullable
    public static Boolean is64Bit;

    @JvmField
    @NotNull
    public static JSONObject pubJson;

    @JvmField
    @Nullable
    public static SharedPreferences sharePreference;

    /* renamed from: Info, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);

    @NotNull
    private static String TAG = "RMonitor_BaseInfo";

    @JvmField
    @NotNull
    public static final UserMeta userMeta = new UserMeta(null, null, null, null, null, null, null, null, null, 511, null);

    @JvmField
    @NotNull
    public static final UrlMeta urlMeta = new UrlMeta(null, null, null, 7, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0002H\u0007J\b\u0010\b\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0007R(\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00062"}, d2 = {"Lcom/tencent/rmonitor/base/meta/BaseInfo$Info;", "", "", "reset", "Lcom/tencent/rmonitor/base/db/a;", "makeBaseDBParam", "initUrl", "initSp", "initInfo", "", "jsonString", "initPubJson", "version", "getConfigUrl", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "TAG$annotations", "()V", "Landroid/app/Application;", "app", "Landroid/app/Application;", "Lcom/tencent/rmonitor/base/db/d;", "dbHelper", "Lcom/tencent/rmonitor/base/db/d;", "Lcom/tencent/rmonitor/common/util/AsyncSPEditor;", "editor", "Lcom/tencent/rmonitor/common/util/AsyncSPEditor;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "is64Bit", "Ljava/lang/Boolean;", "Lorg/json/JSONObject;", "pubJson", "Lorg/json/JSONObject;", "Landroid/content/SharedPreferences;", "sharePreference", "Landroid/content/SharedPreferences;", "Lcom/tencent/rmonitor/base/meta/UrlMeta;", "urlMeta", "Lcom/tencent/rmonitor/base/meta/UrlMeta;", "Lcom/tencent/bugly/common/meta/UserMeta;", "userMeta", "Lcom/tencent/bugly/common/meta/UserMeta;", "<init>", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.base.meta.BaseInfo$Info, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final String getConfigUrl(@NotNull String version) {
            Intrinsics.checkParameterIsNotNull(version, "version");
            if ("v7".contentEquals(version)) {
                return BaseInfo.urlMeta.rmonitorDomain + "/appconfig/v7/config/" + BaseInfo.userMeta.appId + '/';
            }
            return BaseInfo.urlMeta.rmonitorDomain + "/appconfig/v5/config/" + BaseInfo.userMeta.appId + '/';
        }

        @NotNull
        public final String getTAG() {
            return BaseInfo.TAG;
        }

        @JvmStatic
        public final void initInfo() {
            boolean z16;
            boolean z17;
            d dVar;
            if (!BaseInfo.hasInit.get()) {
                Application application = BaseInfo.app;
                if (application != null) {
                    TraceGenerator.updateLaunchIdCache(application);
                    UserMeta userMeta = BaseInfo.userMeta;
                    if (userMeta.appVersion.length() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        userMeta.appVersion = b.f365535j.b(application.getApplicationContext());
                    }
                    if (userMeta.buildNumber.length() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        userMeta.buildNumber = b.f365535j.c(application.getApplicationContext());
                    }
                    FileUtil.INSTANCE.o(application);
                    NameVerifierFactory.INSTANCE.setNameVerifier(new a());
                    BaseInfo.INSTANCE.initSp();
                    try {
                        dVar = d.INSTANCE.a(application);
                    } catch (Throwable unused) {
                        dVar = null;
                    }
                    BaseInfo.dbHelper = dVar;
                    Companion companion = BaseInfo.INSTANCE;
                    UserMeta userMeta2 = BaseInfo.userMeta;
                    companion.initPubJson(userMeta2.toJSON());
                    BaseInfo.is64Bit = Boolean.valueOf(ProcessUtil.INSTANCE.is64BitProcess(application));
                    NativeLogger.initLogLevel(Logger.f365497g.f());
                    PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
                    userMeta2.setModel(privacyInformation.getModel());
                }
                BaseInfo.hasInit.compareAndSet(false, true);
            }
        }

        @JvmStatic
        public final void initPubJson(@NotNull String jsonString) {
            JSONObject jSONObject;
            Intrinsics.checkParameterIsNotNull(jsonString, "jsonString");
            try {
                jSONObject = new JSONObject(jsonString);
            } catch (Throwable unused) {
                jSONObject = new JSONObject();
            }
            BaseInfo.pubJson = jSONObject;
        }

        @JvmStatic
        public final void initSp() {
            SharedPreferences.Editor editor;
            if (BaseInfo.sharePreference == null) {
                synchronized (BaseInfo.INSTANCE.getClass()) {
                    try {
                        if (BaseInfo.sharePreference == null) {
                            BaseInfo.sharePreference = SharedPreferencesProvider.getInstance().getSharedPreferences(BaseInfo.app, SPKey.SP_NAME, false);
                            SharedPreferences sharedPreferences = BaseInfo.sharePreference;
                            if (sharedPreferences != null) {
                                editor = sharedPreferences.edit();
                            } else {
                                editor = null;
                            }
                            BaseInfo.editor = new AsyncSPEditor(editor);
                            UserMeta userMeta = BaseInfo.userMeta;
                            userMeta.sharePreference = BaseInfo.sharePreference;
                            userMeta.crashSharedPreferences = SharedPreferencesProvider.getInstance().getSharedPreferences(BaseInfo.app, Constants.BUGLY_SHARED_PREFERENCES, false);
                        }
                    } catch (Throwable th5) {
                        Logger.f365497g.c(BaseInfo.INSTANCE.getTAG(), th5);
                        BaseInfo.sharePreference = null;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        @JvmStatic
        public final void initUrl() {
            UrlMeta urlMeta = BaseInfo.urlMeta;
            urlMeta.setAuthorizationUrl(urlMeta.rmonitorDomain + "/entrance/" + BaseInfo.userMeta.appId + "/authorize/");
        }

        @JvmStatic
        @NotNull
        public final com.tencent.rmonitor.base.db.a makeBaseDBParam() {
            com.tencent.rmonitor.base.db.a aVar = new com.tencent.rmonitor.base.db.a();
            aVar.f365359b = com.tencent.rmonitor.common.util.a.INSTANCE.c(BaseInfo.app);
            UserMeta userMeta = BaseInfo.userMeta;
            aVar.f365358a = userMeta.appId;
            aVar.f365360c = userMeta.appVersion;
            aVar.f365364g = userMeta.uin;
            aVar.f365362e = TraceGenerator.getLaunchId(BaseInfo.app);
            aVar.f365363f = TraceGenerator.getProcessLaunchId();
            return aVar;
        }

        @JvmStatic
        public final void reset() {
            initUrl();
            initPubJson(BaseInfo.userMeta.toJSON());
        }

        public final void setTAG(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            BaseInfo.TAG = str;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void TAG$annotations() {
        }
    }

    static {
        SharedPreferences.Editor editor2 = null;
        SharedPreferences sharedPreferences = sharePreference;
        if (sharedPreferences != null) {
            editor2 = sharedPreferences.edit();
        }
        editor = new AsyncSPEditor(editor2);
        pubJson = new JSONObject();
        is64Bit = Boolean.TRUE;
        hasInit = new AtomicBoolean(false);
    }

    @JvmStatic
    @NotNull
    public static final String getConfigUrl(@NotNull String str) {
        return INSTANCE.getConfigUrl(str);
    }

    @NotNull
    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static final void initInfo() {
        INSTANCE.initInfo();
    }

    @JvmStatic
    public static final void initPubJson(@NotNull String str) {
        INSTANCE.initPubJson(str);
    }

    @JvmStatic
    public static final void initSp() {
        INSTANCE.initSp();
    }

    @JvmStatic
    public static final void initUrl() {
        INSTANCE.initUrl();
    }

    @JvmStatic
    @NotNull
    public static final com.tencent.rmonitor.base.db.a makeBaseDBParam() {
        return INSTANCE.makeBaseDBParam();
    }

    @JvmStatic
    public static final void reset() {
        INSTANCE.reset();
    }

    public static final void setTAG(@NotNull String str) {
        TAG = str;
    }
}
