package com.tencent.mobileqq.wink.newalbum.resmanager;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.mini.push.MiniAppPushControl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b2\b\u0086\b\u0018\u0000 ;2\u00020\u0001:\u0001\fBg\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010)\u001a\u00020\u0007\u0012\u0006\u0010.\u001a\u00020\n\u0012\u0006\u00101\u001a\u00020\u0007\u0012\u0006\u00103\u001a\u00020\u0007\u0012\u0006\u00105\u001a\u00020\u0007\u0012\u0006\u00108\u001a\u00020\u0007\u00a2\u0006\u0004\b9\u0010:J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0006\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\"\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\r\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010(R\"\u0010.\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010*\u001a\u0004\b\u0018\u0010+\"\u0004\b,\u0010-R\"\u00101\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\r\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b0\u0010(R\"\u00103\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b2\u0010(R\"\u00105\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b4\u0010(R\"\u00108\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\r\u001a\u0004\b\f\u0010\u000f\"\u0004\b7\u0010(\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/resmanager/b;", "", "", "j", "", "k", "toString", "", "hashCode", "other", "", "equals", "a", "I", h.F, "()I", "version", "b", "Ljava/lang/String;", "getSoModelPath", "()Ljava/lang/String;", "setSoModelPath", "(Ljava/lang/String;)V", "soModelPath", "c", "f", "textVersion", "d", "getAlbumResourcePath", "setAlbumResourcePath", "albumResourcePath", "e", "getKeyStr", "setKeyStr", "keyStr", "getIvStr", "setIvStr", "ivStr", "g", "setThreadCount", "(I)V", "threadCount", "Z", "()Z", "setEnableFP16", "(Z)V", "enableFP16", "i", "setStartLiner", "startLiner", "setEndLiner", "endLiner", "setClearCache", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "l", "setClearAlbumCache", "clearAlbumCache", "<init>", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZIIII)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.newalbum.resmanager.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkNewAlbumResConfig {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int version;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String soModelPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int textVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String albumResourcePath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String keyStr;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String ivStr;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int threadCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean enableFP16;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int startLiner;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int endLiner;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private int clearCache;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private int clearAlbumCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0007J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0014\u0010\u0013\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0014\u0010\u0015\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/resmanager/b$a;", "", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/b;", "c", "b", "a", "", "ALBUM_RESOURCE_PATH", "Ljava/lang/String;", "ALBUM_RESOURCE_VERSION", "CLEAR_ALBUM_CACHE", "CLEAR_CACHE", "ENABLE_FP16", "END_LINER", "IV_STR", "KEY_NEW_ALBUM_LOCAL_RES_CONFIG", "KEY_STR", "SO_MODEL_PATH", "START_LINER", "TAG", "THREAD_COUNT", "VERSION", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.resmanager.b$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final WinkNewAlbumResConfig c(JSONObject jSONObject) {
            boolean z16;
            int optInt = jSONObject.optInt("version", 0);
            String optString = jSONObject.optString("so_model_path", "");
            String optString2 = jSONObject.optString("key_str", "");
            String optString3 = jSONObject.optString("iv_str", "");
            int optInt2 = jSONObject.optInt("thread_count", 2);
            if (jSONObject.optInt("enable_fp16", 1) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            int optInt3 = jSONObject.optInt("start_liner", 0);
            int optInt4 = jSONObject.optInt("end_liner", 1008);
            String optString4 = jSONObject.optString("text_path", "https://downv6.qq.com/video_story/wezone_url/defaultmode/seed_ai/seedmodels/text/sm0karzd_68.zip");
            int optInt5 = jSONObject.optInt("text_version", 61);
            int optInt6 = jSONObject.optInt(MiniAppPushControl.KEY_CTRL_CMD_CLEAR_CACHE, 0);
            int optInt7 = jSONObject.optInt("clear_album_cache", 0);
            Intrinsics.checkNotNullExpressionValue(optString, "optString(SO_MODEL_PATH, \"\")");
            Intrinsics.checkNotNullExpressionValue(optString4, "optString(ALBUM_RESOURCE\u2026ls/text/sm0karzd_68.zip\")");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(KEY_STR, \"\")");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(IV_STR, \"\")");
            return new WinkNewAlbumResConfig(optInt, optString, optInt5, optString4, optString2, optString3, optInt2, z16, optInt3, optInt4, optInt6, optInt7);
        }

        @Nullable
        public final WinkNewAlbumResConfig a() {
            boolean z16;
            String i3 = ar.f326685a.i("KEY_NEW_ALBUM_LOCAL_RES_CONFIG", "");
            if (i3.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return null;
            }
            try {
                return c(new JSONObject(i3));
            } catch (Exception e16) {
                QLog.e("WinkNewAlbumResConfig", 1, "retriveLocalResConfig, error ", e16);
                return null;
            }
        }

        @JvmStatic
        @Nullable
        public final WinkNewAlbumResConfig b() {
            boolean z16;
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("105627", "");
            if (loadAsString.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return null;
            }
            try {
                JSONObject optJSONObject = new JSONObject(loadAsString).optJSONObject("clip");
                if (optJSONObject == null) {
                    return null;
                }
                return c(optJSONObject);
            } catch (Exception e16) {
                QLog.e("WinkNewAlbumResConfig", 1, "retriveRemoteResConfig, error ", e16);
                return null;
            }
        }

        Companion() {
        }
    }

    public WinkNewAlbumResConfig(int i3, @NotNull String soModelPath, int i16, @NotNull String albumResourcePath, @NotNull String keyStr, @NotNull String ivStr, int i17, boolean z16, int i18, int i19, int i26, int i27) {
        Intrinsics.checkNotNullParameter(soModelPath, "soModelPath");
        Intrinsics.checkNotNullParameter(albumResourcePath, "albumResourcePath");
        Intrinsics.checkNotNullParameter(keyStr, "keyStr");
        Intrinsics.checkNotNullParameter(ivStr, "ivStr");
        this.version = i3;
        this.soModelPath = soModelPath;
        this.textVersion = i16;
        this.albumResourcePath = albumResourcePath;
        this.keyStr = keyStr;
        this.ivStr = ivStr;
        this.threadCount = i17;
        this.enableFP16 = z16;
        this.startLiner = i18;
        this.endLiner = i19;
        this.clearCache = i26;
        this.clearAlbumCache = i27;
    }

    @JvmStatic
    @Nullable
    public static final WinkNewAlbumResConfig i() {
        return INSTANCE.b();
    }

    /* renamed from: a, reason: from getter */
    public final int getClearAlbumCache() {
        return this.clearAlbumCache;
    }

    /* renamed from: b, reason: from getter */
    public final int getClearCache() {
        return this.clearCache;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getEnableFP16() {
        return this.enableFP16;
    }

    /* renamed from: d, reason: from getter */
    public final int getEndLiner() {
        return this.endLiner;
    }

    /* renamed from: e, reason: from getter */
    public final int getStartLiner() {
        return this.startLiner;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkNewAlbumResConfig)) {
            return false;
        }
        WinkNewAlbumResConfig winkNewAlbumResConfig = (WinkNewAlbumResConfig) other;
        if (this.version == winkNewAlbumResConfig.version && Intrinsics.areEqual(this.soModelPath, winkNewAlbumResConfig.soModelPath) && this.textVersion == winkNewAlbumResConfig.textVersion && Intrinsics.areEqual(this.albumResourcePath, winkNewAlbumResConfig.albumResourcePath) && Intrinsics.areEqual(this.keyStr, winkNewAlbumResConfig.keyStr) && Intrinsics.areEqual(this.ivStr, winkNewAlbumResConfig.ivStr) && this.threadCount == winkNewAlbumResConfig.threadCount && this.enableFP16 == winkNewAlbumResConfig.enableFP16 && this.startLiner == winkNewAlbumResConfig.startLiner && this.endLiner == winkNewAlbumResConfig.endLiner && this.clearCache == winkNewAlbumResConfig.clearCache && this.clearAlbumCache == winkNewAlbumResConfig.clearAlbumCache) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getTextVersion() {
        return this.textVersion;
    }

    /* renamed from: g, reason: from getter */
    public final int getThreadCount() {
        return this.threadCount;
    }

    /* renamed from: h, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((this.version * 31) + this.soModelPath.hashCode()) * 31) + this.textVersion) * 31) + this.albumResourcePath.hashCode()) * 31) + this.keyStr.hashCode()) * 31) + this.ivStr.hashCode()) * 31) + this.threadCount) * 31;
        boolean z16 = this.enableFP16;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((((hashCode + i3) * 31) + this.startLiner) * 31) + this.endLiner) * 31) + this.clearCache) * 31) + this.clearAlbumCache;
    }

    public final void j() {
        String k3 = k();
        QLog.d("WinkNewAlbumResConfig", 1, "saveToLocal, saveConfig:" + k3);
        ar.f326685a.r("KEY_NEW_ALBUM_LOCAL_RES_CONFIG", k3);
    }

    @NotNull
    public final String k() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", this.version);
        jSONObject.put("so_model_path", this.soModelPath);
        jSONObject.put("text_version", this.textVersion);
        jSONObject.put("text_path", this.albumResourcePath);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ath)\n        }.toString()");
        return jSONObject2;
    }

    @NotNull
    public String toString() {
        return "WinkNewAlbumResConfig(version=" + this.version + ", soModelPath=" + this.soModelPath + ", textVersion=" + this.textVersion + ", albumResourcePath=" + this.albumResourcePath + ", keyStr=" + this.keyStr + ", ivStr=" + this.ivStr + ", threadCount=" + this.threadCount + ", enableFP16=" + this.enableFP16 + ", startLiner=" + this.startLiner + ", endLiner=" + this.endLiner + ", clearCache=" + this.clearCache + ", clearAlbumCache=" + this.clearAlbumCache + ")";
    }
}
