package el2;

import android.app.Activity;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi;
import com.tencent.mobileqq.qwallet.h;
import com.tencent.mobileqq.qwallet.openlogin.QWalletOAuthLoginManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.qphone.base.util.QLog;
import fl2.a;
import i01.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0005\u0010\u0019\u000f\u0003\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002JG\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002J?\u0010\u0010\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002JI\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lel2/a;", "Li01/e;", "", "d", "", "isSilentLogin", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "a", "method", "call", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$c;", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$c;", "currentOAuthCallback", "<init>", "()V", "e", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QWalletOAuthLoginManager.c currentOAuthCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lel2/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "appId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "appType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "url", "d", VideoProxy.PARAM_ENABLE_CACHE, "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: el2.a$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class LoginRequest {

        @SerializedName("app_id")
        @Nullable
        private final String appId;

        @SerializedName("app_type")
        @Nullable
        private final Integer appType;

        @SerializedName(VideoProxy.PARAM_ENABLE_CACHE)
        @Nullable
        private final Boolean enableCache;

        @SerializedName("url")
        @Nullable
        private final String url;

        public LoginRequest() {
            this(null, null, null, null, 15, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Integer getAppType() {
            return this.appType;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Boolean getEnableCache() {
            return this.enableCache;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoginRequest)) {
                return false;
            }
            LoginRequest loginRequest = (LoginRequest) other;
            if (Intrinsics.areEqual(this.appId, loginRequest.appId) && Intrinsics.areEqual(this.appType, loginRequest.appType) && Intrinsics.areEqual(this.url, loginRequest.url) && Intrinsics.areEqual(this.enableCache, loginRequest.enableCache)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            String str = this.appId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            Integer num = this.appType;
            if (num == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = num.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.url;
            if (str2 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str2.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            Boolean bool = this.enableCache;
            if (bool != null) {
                i3 = bool.hashCode();
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "LoginRequest(appId=" + this.appId + ", appType=" + this.appType + ", url=" + this.url + ", enableCache=" + this.enableCache + ")";
        }

        public LoginRequest(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Boolean bool) {
            this.appId = str;
            this.appType = num;
            this.url = str2;
            this.enableCache = bool;
        }

        public /* synthetic */ LoginRequest(String str, Integer num, String str2, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? Boolean.FALSE : bool);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lel2/a$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "retCode", "Ljava/lang/Integer;", "getRetCode", "()Ljava/lang/Integer;", "retMsg", "Ljava/lang/String;", "getRetMsg", "()Ljava/lang/String;", "openId", "getOpenId", CommonConstant.KEY_ACCESS_TOKEN, "getAccessToken", "rawData", "getRawData", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: el2.a$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class LoginResult {

        @SerializedName(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN)
        @Nullable
        private final String accessToken;

        @SerializedName("open_id")
        @Nullable
        private final String openId;

        @SerializedName("raw_data")
        @Nullable
        private final String rawData;

        @SerializedName("ret_code")
        @Nullable
        private final Integer retCode;

        @SerializedName("ret_msg")
        @Nullable
        private final String retMsg;

        public LoginResult() {
            this(null, null, null, null, null, 31, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoginResult)) {
                return false;
            }
            LoginResult loginResult = (LoginResult) other;
            if (Intrinsics.areEqual(this.retCode, loginResult.retCode) && Intrinsics.areEqual(this.retMsg, loginResult.retMsg) && Intrinsics.areEqual(this.openId, loginResult.openId) && Intrinsics.areEqual(this.accessToken, loginResult.accessToken) && Intrinsics.areEqual(this.rawData, loginResult.rawData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            Integer num = this.retCode;
            int i3 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i16 = hashCode * 31;
            String str = this.retMsg;
            if (str == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.openId;
            if (str2 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str2.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str3 = this.accessToken;
            if (str3 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str3.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str4 = this.rawData;
            if (str4 != null) {
                i3 = str4.hashCode();
            }
            return i19 + i3;
        }

        @NotNull
        public String toString() {
            return "LoginResult(retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", openId=" + this.openId + ", accessToken=" + this.accessToken + ", rawData=" + this.rawData + ")";
        }

        public LoginResult(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.retCode = num;
            this.retMsg = str;
            this.openId = str2;
            this.accessToken = str3;
            this.rawData = str4;
        }

        public /* synthetic */ LoginResult(Integer num, String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : str4);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lel2/a$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "forceRefresh", "Z", "a", "()Z", "setForceRefresh", "(Z)V", "<init>", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: el2.a$d, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class OAuthLoginRequest {

        @SerializedName("forceRefresh")
        private boolean forceRefresh;

        public OAuthLoginRequest() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getForceRefresh() {
            return this.forceRefresh;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OAuthLoginRequest) && this.forceRefresh == ((OAuthLoginRequest) other).forceRefresh) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.forceRefresh;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "OAuthLoginRequest(forceRefresh=" + this.forceRefresh + ")";
        }

        public OAuthLoginRequest(boolean z16) {
            this.forceRefresh = z16;
        }

        public /* synthetic */ OAuthLoginRequest(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019\u00a8\u0006\""}, d2 = {"Lel2/a$e;", "", "", "toString", "", "hashCode", "other", "", "equals", "retCode", "Ljava/lang/Integer;", "getRetCode", "()Ljava/lang/Integer;", "retMsg", "Ljava/lang/String;", "getRetMsg", "()Ljava/lang/String;", "skey", "getSkey", "openId", "getOpenId", "", "startOpenLoginTime", "Ljava/lang/Long;", "getStartOpenLoginTime", "()Ljava/lang/Long;", "endOpenLoginTime", "getEndOpenLoginTime", "startXJKLoginTime", "getStartXJKLoginTime", "endXJKLoginTime", "getEndXJKLoginTime", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: el2.a$e, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class OAuthLoginResult {

        @SerializedName("end_openlogin_time")
        @Nullable
        private final Long endOpenLoginTime;

        @SerializedName("end_xjklogin_time")
        @Nullable
        private final Long endXJKLoginTime;

        @SerializedName("open_id")
        @Nullable
        private final String openId;

        @SerializedName("ret_code")
        @Nullable
        private final Integer retCode;

        @SerializedName("ret_msg")
        @Nullable
        private final String retMsg;

        @SerializedName("skey")
        @Nullable
        private final String skey;

        @SerializedName("start_openlogin_time")
        @Nullable
        private final Long startOpenLoginTime;

        @SerializedName("start_xjklogin_time")
        @Nullable
        private final Long startXJKLoginTime;

        public OAuthLoginResult() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OAuthLoginResult)) {
                return false;
            }
            OAuthLoginResult oAuthLoginResult = (OAuthLoginResult) other;
            if (Intrinsics.areEqual(this.retCode, oAuthLoginResult.retCode) && Intrinsics.areEqual(this.retMsg, oAuthLoginResult.retMsg) && Intrinsics.areEqual(this.skey, oAuthLoginResult.skey) && Intrinsics.areEqual(this.openId, oAuthLoginResult.openId) && Intrinsics.areEqual(this.startOpenLoginTime, oAuthLoginResult.startOpenLoginTime) && Intrinsics.areEqual(this.endOpenLoginTime, oAuthLoginResult.endOpenLoginTime) && Intrinsics.areEqual(this.startXJKLoginTime, oAuthLoginResult.startXJKLoginTime) && Intrinsics.areEqual(this.endXJKLoginTime, oAuthLoginResult.endXJKLoginTime)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int hashCode7;
            Integer num = this.retCode;
            int i3 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i16 = hashCode * 31;
            String str = this.retMsg;
            if (str == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.skey;
            if (str2 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str2.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str3 = this.openId;
            if (str3 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str3.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            Long l3 = this.startOpenLoginTime;
            if (l3 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = l3.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            Long l16 = this.endOpenLoginTime;
            if (l16 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = l16.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            Long l17 = this.startXJKLoginTime;
            if (l17 == null) {
                hashCode7 = 0;
            } else {
                hashCode7 = l17.hashCode();
            }
            int i28 = (i27 + hashCode7) * 31;
            Long l18 = this.endXJKLoginTime;
            if (l18 != null) {
                i3 = l18.hashCode();
            }
            return i28 + i3;
        }

        @NotNull
        public String toString() {
            return "OAuthLoginResult(retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", skey=" + this.skey + ", openId=" + this.openId + ", startOpenLoginTime=" + this.startOpenLoginTime + ", endOpenLoginTime=" + this.endOpenLoginTime + ", startXJKLoginTime=" + this.startXJKLoginTime + ", endXJKLoginTime=" + this.endXJKLoginTime + ")";
        }

        public OAuthLoginResult(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Long l3, @Nullable Long l16, @Nullable Long l17, @Nullable Long l18) {
            this.retCode = num;
            this.retMsg = str;
            this.skey = str2;
            this.openId = str3;
            this.startOpenLoginTime = l3;
            this.endOpenLoginTime = l16;
            this.startXJKLoginTime = l17;
            this.endXJKLoginTime = l18;
        }

        public /* synthetic */ OAuthLoginResult(Integer num, String str, String str2, String str3, Long l3, Long l16, Long l17, Long l18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) == 0 ? str3 : null, (i3 & 16) != 0 ? -1L : l3, (i3 & 32) != 0 ? -1L : l16, (i3 & 64) != 0 ? -1L : l17, (i3 & 128) != 0 ? -1L : l18);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"el2/a$f", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$c;", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthResult;", "oauthResult", "", "a", "", "retCode", "", "retMsg", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthStatisticBean;", "statisticBean", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class f implements QWalletOAuthLoginManager.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f396558a;

        f(Function1<Object, Unit> function1) {
            this.f396558a = function1;
        }

        @Override // com.tencent.mobileqq.qwallet.openlogin.QWalletOAuthLoginManager.c
        public void a(@NotNull QWalletOAuthLoginManager.OAuthResult oauthResult) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(oauthResult, "oauthResult");
            QWalletOAuthLoginManager.Cookie f16 = oauthResult.f("qpay-lc-skey");
            if (f16 != null) {
                str = f16.getValue();
            } else {
                str = null;
            }
            QWalletOAuthLoginManager.Cookie f17 = oauthResult.f("qpay-lc-openid");
            if (f17 != null) {
                str2 = f17.getValue();
            } else {
                str2 = null;
            }
            OAuthLoginResult oAuthLoginResult = new OAuthLoginResult(0, null, str, str2, oauthResult.getStatisticBean().getStartOpenLoginTime(), oauthResult.getStatisticBean().getEndOpenLoginTime(), oauthResult.getStatisticBean().getStartXJKLoginTime(), oauthResult.getStatisticBean().getEndXJKLoginTime());
            Function1<Object, Unit> function1 = this.f396558a;
            if (function1 != null) {
                function1.invoke(new GsonBuilder().create().toJson(oAuthLoginResult));
            }
        }

        @Override // com.tencent.mobileqq.qwallet.openlogin.QWalletOAuthLoginManager.c
        public void b(int retCode, @NotNull String retMsg, @NotNull QWalletOAuthLoginManager.OAuthStatisticBean statisticBean) {
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            Intrinsics.checkNotNullParameter(statisticBean, "statisticBean");
            OAuthLoginResult oAuthLoginResult = new OAuthLoginResult(Integer.valueOf(retCode), retMsg, null, null, statisticBean.getStartOpenLoginTime(), statisticBean.getEndOpenLoginTime(), statisticBean.getStartXJKLoginTime(), statisticBean.getEndXJKLoginTime(), 12, null);
            Function1<Object, Unit> function1 = this.f396558a;
            if (function1 != null) {
                function1.invoke(new GsonBuilder().create().toJson(oAuthLoginResult));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"el2/a$g", "Lfl2/a$b;", "", "uin", "Lorg/json/JSONObject;", "rawData", "openId", CommonConstant.KEY_ACCESS_TOKEN, "", QAdRewardDefine$VideoParams.ISCACHE, "", "a", "", "retCode", "retMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class g implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f396559a;

        g(Function1<Object, Unit> function1) {
            this.f396559a = function1;
        }

        @Override // fl2.a.b
        public void a(@Nullable String uin, @NotNull JSONObject rawData, @Nullable String openId, @Nullable String accessToken, boolean isCache) {
            Intrinsics.checkNotNullParameter(rawData, "rawData");
            LoginResult loginResult = new LoginResult(0, null, openId, accessToken, rawData.toString());
            Function1<Object, Unit> function1 = this.f396559a;
            if (function1 != null) {
                function1.invoke(new GsonBuilder().create().toJson(loginResult));
            }
        }

        @Override // fl2.a.b
        public void onFail(int retCode, @NotNull String retMsg) {
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            LoginResult loginResult = new LoginResult(Integer.valueOf(retCode), retMsg, null, null, null, 28, null);
            Function1<Object, Unit> function1 = this.f396559a;
            if (function1 != null) {
                function1.invoke(new GsonBuilder().create().toJson(loginResult));
            }
        }
    }

    private final void a(String params, Function1<Object, Unit> callback) {
        String str;
        String str2;
        if (params == null || getActivity() == null) {
            return;
        }
        WeakReference<Activity> weakReference = new WeakReference<>(getActivity());
        OAuthLoginRequest oAuthLoginRequest = (OAuthLoginRequest) new GsonBuilder().create().fromJson(params, OAuthLoginRequest.class);
        QLog.w("QWalletOpenLoginModule", 1, "receive oauthLogin: " + oAuthLoginRequest);
        if (!oAuthLoginRequest.getForceRefresh()) {
            QWalletOAuthLoginManager.OAuthResult h16 = QWalletOAuthLoginManager.f278603a.h(IQWalletKuiklyApi.FINANCIAL_APPID);
            if (h16 != null) {
                int i3 = 0;
                String str3 = null;
                QWalletOAuthLoginManager.Cookie f16 = h16.f("qpay-lc-skey");
                if (f16 != null) {
                    str = f16.getValue();
                } else {
                    str = null;
                }
                QWalletOAuthLoginManager.Cookie f17 = h16.f("qpay-lc-openid");
                if (f17 != null) {
                    str2 = f17.getValue();
                } else {
                    str2 = null;
                }
                OAuthLoginResult oAuthLoginResult = new OAuthLoginResult(i3, str3, str, str2, null, null, null, null, 240, null);
                if (callback != null) {
                    callback.invoke(new GsonBuilder().create().toJson(oAuthLoginResult));
                    return;
                }
                return;
            }
            OAuthLoginResult oAuthLoginResult2 = new OAuthLoginResult(-1, null, null, null, null, null, null, null, 252, null);
            if (callback != null) {
                callback.invoke(new GsonBuilder().create().toJson(oAuthLoginResult2));
                return;
            }
            return;
        }
        f fVar = new f(callback);
        this.currentOAuthCallback = fVar;
        QWalletOAuthLoginManager.f278603a.j(weakReference, true, IQWalletKuiklyApi.FINANCIAL_APPID, 6, null, fVar);
    }

    private final void c(boolean isSilentLogin, String params, Function1<Object, Unit> callback) {
        if (params == null) {
            return;
        }
        WeakReference<Activity> weakReference = new WeakReference<>(getActivity());
        LoginRequest loginRequest = (LoginRequest) new GsonBuilder().create().fromJson(params, LoginRequest.class);
        fl2.a.f399772a.c(weakReference, isSilentLogin, loginRequest.getAppId(), loginRequest.getAppType(), loginRequest.getUrl(), Intrinsics.areEqual(loginRequest.getEnableCache(), Boolean.TRUE), new g(callback));
    }

    private final void d() {
        fl2.a.f399772a.d();
        h.f277153a.b();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000b. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -318370553:
                if (method.equals("prepare")) {
                    d();
                    return Unit.INSTANCE;
                }
                QLog.w("QWalletOpenLoginModule", 1, "unknown method: " + method);
                return super.call(method, params, callback);
            case 103149417:
                if (method.equals("login")) {
                    c(false, params, callback);
                    return Unit.INSTANCE;
                }
                QLog.w("QWalletOpenLoginModule", 1, "unknown method: " + method);
                return super.call(method, params, callback);
            case 1105032978:
                if (method.equals("oauthLogin")) {
                    a(params, callback);
                    return Unit.INSTANCE;
                }
                QLog.w("QWalletOpenLoginModule", 1, "unknown method: " + method);
                return super.call(method, params, callback);
            case 1304526110:
                if (method.equals("loginSilent")) {
                    c(true, params, callback);
                    return Unit.INSTANCE;
                }
                QLog.w("QWalletOpenLoginModule", 1, "unknown method: " + method);
                return super.call(method, params, callback);
            default:
                QLog.w("QWalletOpenLoginModule", 1, "unknown method: " + method);
                return super.call(method, params, callback);
        }
    }
}
