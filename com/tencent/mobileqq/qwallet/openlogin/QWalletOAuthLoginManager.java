package com.tencent.mobileqq.qwallet.openlogin;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.financial.FinancialLogin$Cookie;
import com.tencent.mobileqq.pb.financial.FinancialLogin$OAuthLoginReq;
import com.tencent.mobileqq.pb.financial.FinancialLogin$OAuthLoginRsp;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import fl2.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.parcelize.Parcelize;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import pl2.o;
import pl2.p;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0006+,!$-.B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0014\u001a\u00020\bJM\u0010\u001e\u001a\u00020\b2\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\u00198\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\u00198\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b'\u0010%\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager;", "", "", "appId", "openId", CommonConstant.KEY_ACCESS_TOKEN, "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthStatisticBean;", "statisticBean", "", "i", "requestingUin", "", "e", "", "Lcom/tencent/mobileqq/pb/financial/FinancialLogin$Cookie;", "cookies", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthResult;", "k", "g", h.F, "f", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "activityRef", "isSilentLogin", "", "appType", "url", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$c;", "callback", "j", "(Lmqq/util/WeakReference;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$c;)V", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$a;", "b", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$a;", "callbackCenter", "c", "I", "ERR_CODE_UNKNOWN", "d", "ERR_CODE_ACCOUNT_CHANGE", "<init>", "()V", "a", "Cookie", "OAuthResult", "OAuthStatisticBean", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletOAuthLoginManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QWalletOAuthLoginManager f278603a = new QWalletOAuthLoginManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a callbackCenter = new a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int ERR_CODE_UNKNOWN = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int ERR_CODE_ACCOUNT_CHANGE = -2;

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\t\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001\u001dB;\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010'\u001a\u00020\"\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u0019\u0010!\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$Cookie;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "name", "e", "c", "value", "f", "Z", "isHttpOnly", "()Z", h.F, "a", "domain", "i", "getPath", "path", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "getExpireTime", "()J", "expireTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;J)V", BdhLogUtil.LogTag.Tag_Conn, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class Cookie implements Parcelable {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        public static final Parcelable.Creator<Cookie> CREATOR = new b();

        @NotNull
        private static final SimpleDateFormat D;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String name;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String value;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean isHttpOnly;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String domain;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String path;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final long expireTime;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$Cookie$a;", "", "Lcom/tencent/mobileqq/pb/financial/FinancialLogin$Cookie;", "pbCookie", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$Cookie;", "a", "Ljava/text/SimpleDateFormat;", "cookieExpireFormat", "Ljava/text/SimpleDateFormat;", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qwallet.openlogin.QWalletOAuthLoginManager$Cookie$a, reason: from kotlin metadata */
        /* loaded from: classes16.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Cookie a(@NotNull FinancialLogin$Cookie pbCookie) {
                Intrinsics.checkNotNullParameter(pbCookie, "pbCookie");
                String str = pbCookie.name.get();
                Intrinsics.checkNotNullExpressionValue(str, "pbCookie.name.get()");
                String str2 = pbCookie.value.get();
                Intrinsics.checkNotNullExpressionValue(str2, "pbCookie.value.get()");
                return new Cookie(str, str2, pbCookie.is_http_only.get(), pbCookie.domain.get(), pbCookie.path.get(), pbCookie.expires.get());
            }

            Companion() {
            }
        }

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public static final class b implements Parcelable.Creator<Cookie> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Cookie createFromParcel(@NotNull Parcel parcel) {
                boolean z16;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                return new Cookie(readString, readString2, z16, parcel.readString(), parcel.readString(), parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Cookie[] newArray(int i3) {
                return new Cookie[i3];
            }
        }

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            D = simpleDateFormat;
        }

        public Cookie(@NotNull String name, @NotNull String value, boolean z16, @Nullable String str, @Nullable String str2, long j3) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.name = name;
            this.value = value;
            this.isHttpOnly = z16;
            this.domain = str;
            this.path = str2;
            this.expireTime = j3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getDomain() {
            return this.domain;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cookie)) {
                return false;
            }
            Cookie cookie = (Cookie) other;
            if (Intrinsics.areEqual(this.name, cookie.name) && Intrinsics.areEqual(this.value, cookie.value) && this.isHttpOnly == cookie.isHttpOnly && Intrinsics.areEqual(this.domain, cookie.domain) && Intrinsics.areEqual(this.path, cookie.path) && this.expireTime == cookie.expireTime) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.name.hashCode() * 31) + this.value.hashCode()) * 31;
            boolean z16 = this.isHttpOnly;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode2 + i3) * 31;
            String str = this.domain;
            int i17 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i18 = (i16 + hashCode) * 31;
            String str2 = this.path;
            if (str2 != null) {
                i17 = str2.hashCode();
            }
            return ((i18 + i17) * 31) + androidx.fragment.app.a.a(this.expireTime);
        }

        @NotNull
        public String toString() {
            String str = this.name + ContainerUtils.KEY_VALUE_DELIMITER + this.value + "; Domain=" + this.domain + "; Path=" + this.path + "; Expires=" + D.format(new Date(this.expireTime * 1000)) + "; Secure;";
            if (this.isHttpOnly) {
                return str + " HttpOnly;";
            }
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.name);
            parcel.writeString(this.value);
            parcel.writeInt(this.isHttpOnly ? 1 : 0);
            parcel.writeString(this.domain);
            parcel.writeString(this.path);
            parcel.writeLong(this.expireTime);
        }
    }

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018\u0012\u0006\u0010\"\u001a\u00020\u001e\u0012\u0006\u0010'\u001a\u00020#\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0007H\u00d6\u0001J\u0019\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u0019\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthResult;", "Landroid/os/Parcelable;", "", "targetName", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$Cookie;", "f", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "appId", "", "e", "Ljava/util/List;", "b", "()Ljava/util/List;", "cookiesList", "", "J", "c", "()J", "expireTime", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthStatisticBean;", h.F, "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthStatisticBean;", "()Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthStatisticBean;", "statisticBean", "<init>", "(Ljava/lang/String;Ljava/util/List;JLcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthStatisticBean;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class OAuthResult implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<OAuthResult> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String appId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<Cookie> cookiesList;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final long expireTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final OAuthStatisticBean statisticBean;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public static final class a implements Parcelable.Creator<OAuthResult> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final OAuthResult createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i3 = 0; i3 != readInt; i3++) {
                    arrayList.add(Cookie.CREATOR.createFromParcel(parcel));
                }
                return new OAuthResult(readString, arrayList, parcel.readLong(), OAuthStatisticBean.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final OAuthResult[] newArray(int i3) {
                return new OAuthResult[i3];
            }
        }

        public OAuthResult(@NotNull String appId, @NotNull List<Cookie> cookiesList, long j3, @NotNull OAuthStatisticBean statisticBean) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(cookiesList, "cookiesList");
            Intrinsics.checkNotNullParameter(statisticBean, "statisticBean");
            this.appId = appId;
            this.cookiesList = cookiesList;
            this.expireTime = j3;
            this.statisticBean = statisticBean;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        @NotNull
        public final List<Cookie> b() {
            return this.cookiesList;
        }

        /* renamed from: c, reason: from getter */
        public final long getExpireTime() {
            return this.expireTime;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final OAuthStatisticBean getStatisticBean() {
            return this.statisticBean;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OAuthResult)) {
                return false;
            }
            OAuthResult oAuthResult = (OAuthResult) other;
            if (Intrinsics.areEqual(this.appId, oAuthResult.appId) && Intrinsics.areEqual(this.cookiesList, oAuthResult.cookiesList) && this.expireTime == oAuthResult.expireTime && Intrinsics.areEqual(this.statisticBean, oAuthResult.statisticBean)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final Cookie f(@NotNull String targetName) {
            Object obj;
            boolean contains$default;
            Intrinsics.checkNotNullParameter(targetName, "targetName");
            Iterator<T> it = this.cookiesList.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) ((Cookie) next).getName(), (CharSequence) targetName, false, 2, (Object) null);
                if (contains$default) {
                    obj = next;
                    break;
                }
            }
            return (Cookie) obj;
        }

        public int hashCode() {
            return (((((this.appId.hashCode() * 31) + this.cookiesList.hashCode()) * 31) + androidx.fragment.app.a.a(this.expireTime)) * 31) + this.statisticBean.hashCode();
        }

        @NotNull
        public String toString() {
            return "OAuthResult(appId=" + this.appId + ", cookiesList=" + this.cookiesList + ", expireTime=" + this.expireTime + ", statisticBean=" + this.statisticBean + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.appId);
            List<Cookie> list = this.cookiesList;
            parcel.writeInt(list.size());
            Iterator<Cookie> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
            parcel.writeLong(this.expireTime);
            this.statisticBean.writeToParcel(parcel, flags);
        }
    }

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthStatisticBean;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "j", "(Ljava/lang/Long;)V", "startOpenLoginTime", "e", "a", "f", "endOpenLoginTime", "k", "startXJKLoginTime", h.F, "b", "g", "endXJKLoginTime", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class OAuthStatisticBean implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<OAuthStatisticBean> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Long startOpenLoginTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Long endOpenLoginTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Long startXJKLoginTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Long endXJKLoginTime;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public static final class a implements Parcelable.Creator<OAuthStatisticBean> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final OAuthStatisticBean createFromParcel(@NotNull Parcel parcel) {
                Long valueOf;
                Long valueOf2;
                Long valueOf3;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Long l3 = null;
                if (parcel.readInt() == 0) {
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(parcel.readLong());
                }
                if (parcel.readInt() == 0) {
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(parcel.readLong());
                }
                if (parcel.readInt() == 0) {
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(parcel.readLong());
                }
                if (parcel.readInt() != 0) {
                    l3 = Long.valueOf(parcel.readLong());
                }
                return new OAuthStatisticBean(valueOf, valueOf2, valueOf3, l3);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final OAuthStatisticBean[] newArray(int i3) {
                return new OAuthStatisticBean[i3];
            }
        }

        public OAuthStatisticBean() {
            this(null, null, null, null, 15, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Long getEndOpenLoginTime() {
            return this.endOpenLoginTime;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Long getEndXJKLoginTime() {
            return this.endXJKLoginTime;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Long getStartOpenLoginTime() {
            return this.startOpenLoginTime;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final Long getStartXJKLoginTime() {
            return this.startXJKLoginTime;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OAuthStatisticBean)) {
                return false;
            }
            OAuthStatisticBean oAuthStatisticBean = (OAuthStatisticBean) other;
            if (Intrinsics.areEqual(this.startOpenLoginTime, oAuthStatisticBean.startOpenLoginTime) && Intrinsics.areEqual(this.endOpenLoginTime, oAuthStatisticBean.endOpenLoginTime) && Intrinsics.areEqual(this.startXJKLoginTime, oAuthStatisticBean.startXJKLoginTime) && Intrinsics.areEqual(this.endXJKLoginTime, oAuthStatisticBean.endXJKLoginTime)) {
                return true;
            }
            return false;
        }

        public final void f(@Nullable Long l3) {
            this.endOpenLoginTime = l3;
        }

        public final void g(@Nullable Long l3) {
            this.endXJKLoginTime = l3;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            Long l3 = this.startOpenLoginTime;
            int i3 = 0;
            if (l3 == null) {
                hashCode = 0;
            } else {
                hashCode = l3.hashCode();
            }
            int i16 = hashCode * 31;
            Long l16 = this.endOpenLoginTime;
            if (l16 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = l16.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            Long l17 = this.startXJKLoginTime;
            if (l17 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = l17.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            Long l18 = this.endXJKLoginTime;
            if (l18 != null) {
                i3 = l18.hashCode();
            }
            return i18 + i3;
        }

        public final void j(@Nullable Long l3) {
            this.startOpenLoginTime = l3;
        }

        public final void k(@Nullable Long l3) {
            this.startXJKLoginTime = l3;
        }

        @NotNull
        public String toString() {
            return "OAuthStatisticBean(startOpenLoginTime=" + this.startOpenLoginTime + ", endOpenLoginTime=" + this.endOpenLoginTime + ", startXJKLoginTime=" + this.startXJKLoginTime + ", endXJKLoginTime=" + this.endXJKLoginTime + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Long l3 = this.startOpenLoginTime;
            if (l3 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l3.longValue());
            }
            Long l16 = this.endOpenLoginTime;
            if (l16 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l16.longValue());
            }
            Long l17 = this.startXJKLoginTime;
            if (l17 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l17.longValue());
            }
            Long l18 = this.endXJKLoginTime;
            if (l18 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l18.longValue());
            }
        }

        public OAuthStatisticBean(@Nullable Long l3, @Nullable Long l16, @Nullable Long l17, @Nullable Long l18) {
            this.startOpenLoginTime = l3;
            this.endOpenLoginTime = l16;
            this.startXJKLoginTime = l17;
            this.endXJKLoginTime = l18;
        }

        public /* synthetic */ OAuthStatisticBean(Long l3, Long l16, Long l17, Long l18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? -1L : l3, (i3 & 2) != 0 ? -1L : l16, (i3 & 4) != 0 ? -1L : l17, (i3 & 8) != 0 ? -1L : l18);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ&\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012R,\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$a;", "", "", "appId", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$c;", "callback", "", "a", "", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$b;", "d", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthResult;", "cookieInfo", "", "c", "", "retCode", "retMsg", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthStatisticBean;", "statisticBean", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "callbackMap", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ConcurrentHashMap<String, List<b<c>>> callbackMap = new ConcurrentHashMap<>();

        public final synchronized boolean a(@NotNull String appId, @NotNull c callback) {
            boolean z16;
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(callback, "callback");
            List<b<c>> list = this.callbackMap.get(appId);
            if (list == null) {
                list = new ArrayList<>();
                this.callbackMap.put(appId, list);
                z16 = false;
            } else {
                z16 = true;
            }
            List<b<c>> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add((c) ((b) it.next()).a());
            }
            if (!arrayList.contains(callback)) {
                list.add(new b<>(callback));
            }
            return z16;
        }

        public final void b(@NotNull String appId, int retCode, @NotNull String retMsg, @NotNull OAuthStatisticBean statisticBean) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            Intrinsics.checkNotNullParameter(statisticBean, "statisticBean");
            List<b<c>> d16 = d(appId);
            if (d16 != null) {
                Iterator<T> it = d16.iterator();
                while (it.hasNext()) {
                    c cVar = (c) ((b) it.next()).a();
                    if (cVar != null) {
                        QLog.w("QWalletOAuthLoginManager", 1, "callback onOpenLoginFail " + cVar);
                        cVar.b(retCode, retMsg, statisticBean);
                    }
                }
            }
        }

        public final void c(@NotNull String appId, @NotNull OAuthResult cookieInfo) {
            int i3;
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(cookieInfo, "cookieInfo");
            List<b<c>> d16 = d(appId);
            if (d16 != null) {
                i3 = d16.size();
            } else {
                i3 = 0;
            }
            QLog.i("QWalletOAuthLoginManager", 1, "onSuccess, callback.size " + i3);
            if (d16 != null) {
                Iterator<T> it = d16.iterator();
                while (it.hasNext()) {
                    c cVar = (c) ((b) it.next()).a();
                    if (cVar != null) {
                        QLog.i("QWalletOAuthLoginManager", 1, "callback onSuccess " + cVar);
                        cVar.a(cookieInfo);
                    }
                }
            }
        }

        @Nullable
        public final synchronized List<b<c>> d(@NotNull String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            return this.callbackMap.remove(appId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R$\u0010\f\u001a\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u0004\u0018\u00018\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$b;", "T", "", "a", "()Ljava/lang/Object;", "", "Z", "needWeak", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "b", "Lmqq/util/WeakReference;", "weakRef", "c", "Ljava/lang/Object;", "strongRef", "callback", "<init>", "(Ljava/lang/Object;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean needWeak;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WeakReference<T> weakRef;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final T strongRef;

        public b(T t16) {
            WeakReference<T> weakReference;
            boolean isSwitchOn = ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_FINANCIAL_OAUTH_LOGIN_WEAK_REF, false);
            this.needWeak = isSwitchOn;
            if (isSwitchOn) {
                weakReference = new WeakReference<>(t16);
            } else {
                weakReference = null;
            }
            this.weakRef = weakReference;
            this.strongRef = isSwitchOn ? null : t16;
        }

        @Nullable
        public final T a() {
            if (this.needWeak) {
                WeakReference<T> weakReference = this.weakRef;
                if (weakReference != null) {
                    return weakReference.get();
                }
                return null;
            }
            return this.strongRef;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$c;", "", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthResult;", "oauthResult", "", "a", "", "retCode", "", "retMsg", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthStatisticBean;", "statisticBean", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface c {
        void a(@NotNull OAuthResult oauthResult);

        void b(int retCode, @NotNull String retMsg, @NotNull OAuthStatisticBean statisticBean);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$d", "Lpl2/o;", "Lcom/tencent/mobileqq/pb/financial/FinancialLogin$OAuthLoginRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements o<FinancialLogin$OAuthLoginRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f278625a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f278626b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAuthStatisticBean f278627c;

        d(String str, String str2, OAuthStatisticBean oAuthStatisticBean) {
            this.f278625a = str;
            this.f278626b = str2;
            this.f278627c = oAuthStatisticBean;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull FinancialLogin$OAuthLoginRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QWalletOAuthLoginManager qWalletOAuthLoginManager = QWalletOAuthLoginManager.f278603a;
            if (!qWalletOAuthLoginManager.e(this.f278625a, this.f278626b, this.f278627c)) {
                return;
            }
            this.f278627c.g(Long.valueOf(System.currentTimeMillis()));
            OAuthResult k3 = qWalletOAuthLoginManager.k(this.f278625a, rsp.cookie.get(), this.f278627c);
            QLog.i("QWalletOAuthLoginManager", 1, "OAuthLogin success, authResult=" + k3);
            if (k3 != null) {
                QWalletOAuthLoginManager.callbackCenter.c(this.f278625a, k3);
            } else {
                QWalletOAuthLoginManager.callbackCenter.b(this.f278625a, -1, p.INSTANCE.a(), this.f278627c);
            }
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("QWalletOAuthLoginManager", 1, "login onFail: " + errCode + " " + errMsg);
            this.f278627c.g(Long.valueOf(System.currentTimeMillis()));
            QWalletOAuthLoginManager.callbackCenter.b(this.f278625a, errCode, errMsg, this.f278627c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$e", "Lfl2/a$b;", "", "uin", "Lorg/json/JSONObject;", "rawData", "openId", CommonConstant.KEY_ACCESS_TOKEN, "", QAdRewardDefine$VideoParams.ISCACHE, "", "a", "", "retCode", "retMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAuthStatisticBean f278628a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f278629b;

        e(OAuthStatisticBean oAuthStatisticBean, String str) {
            this.f278628a = oAuthStatisticBean;
            this.f278629b = str;
        }

        @Override // fl2.a.b
        public void a(@Nullable String uin, @NotNull JSONObject rawData, @Nullable String openId, @Nullable String accessToken, boolean isCache) {
            Intrinsics.checkNotNullParameter(rawData, "rawData");
            this.f278628a.f(Long.valueOf(System.currentTimeMillis()));
            QWalletOAuthLoginManager qWalletOAuthLoginManager = QWalletOAuthLoginManager.f278603a;
            if (qWalletOAuthLoginManager.e(this.f278629b, uin, this.f278628a)) {
                qWalletOAuthLoginManager.i(this.f278629b, openId, accessToken, this.f278628a);
            }
        }

        @Override // fl2.a.b
        public void onFail(int retCode, @NotNull String retMsg) {
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            this.f278628a.f(Long.valueOf(System.currentTimeMillis()));
            QWalletOAuthLoginManager.callbackCenter.b(this.f278629b, retCode, retMsg, this.f278628a);
        }
    }

    QWalletOAuthLoginManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(String appId, String requestingUin, OAuthStatisticBean statisticBean) {
        if (Intrinsics.areEqual(requestingUin, com.tencent.mobileqq.base.a.c())) {
            return true;
        }
        QLog.w("QWalletOAuthLoginManager", 1, "checkAccount onFail: requestingUin=" + requestingUin + " currentUin=" + com.tencent.mobileqq.base.a.c());
        callbackCenter.b(appId, ERR_CODE_ACCOUNT_CHANGE, p.INSTANCE.a(), statisticBean);
        return false;
    }

    private final String g() {
        return "qwallet_oauth_login_result_" + com.tencent.mobileqq.base.a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String appId, String openId, String accessToken, OAuthStatisticBean statisticBean) {
        statisticBean.k(Long.valueOf(System.currentTimeMillis()));
        FinancialLogin$OAuthLoginReq financialLogin$OAuthLoginReq = new FinancialLogin$OAuthLoginReq();
        financialLogin$OAuthLoginReq.open_id.set(openId);
        financialLogin$OAuthLoginReq.access_token.set(accessToken);
        d dVar = new d(appId, com.tencent.mobileqq.base.a.c(), statisticBean);
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = FinancialLogin$OAuthLoginRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.lcpet.login.Session", "OAuthLogin", financialLogin$OAuthLoginReq, (MessageMicro) newInstance, false, true, false, null, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OAuthResult k(String appId, List<FinancialLogin$Cookie> cookies, OAuthStatisticBean statisticBean) {
        boolean z16;
        int collectionSizeOrDefault;
        List<FinancialLogin$Cookie> list = cookies;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("QWalletOAuthLoginManager", 1, "saveCookies fail, cookies is null");
            return null;
        }
        List<FinancialLogin$Cookie> list2 = cookies;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Cookie.INSTANCE.a((FinancialLogin$Cookie) it.next()));
        }
        Iterator<T> it5 = list2.iterator();
        if (it5.hasNext()) {
            long j3 = ((FinancialLogin$Cookie) it5.next()).expires.get();
            while (it5.hasNext()) {
                long j16 = ((FinancialLogin$Cookie) it5.next()).expires.get();
                if (j3 > j16) {
                    j3 = j16;
                }
            }
            OAuthResult oAuthResult = new OAuthResult(appId, arrayList, 1000 * j3, statisticBean);
            g.p(g(), oAuthResult);
            return oAuthResult;
        }
        throw new NoSuchElementException();
    }

    public final void f() {
        String g16 = g();
        QLog.w("QWalletOAuthLoginManager", 1, "clearOAuthLoginCached: " + g16);
        g.s(g16);
    }

    @Nullable
    public final OAuthResult h(@Nullable String appId) {
        OAuthResult oAuthResult = (OAuthResult) g.h(g(), OAuthResult.class, null);
        if (oAuthResult == null) {
            QLog.w("QWalletOAuthLoginManager", 1, "no cookies");
            return null;
        }
        if (appId != null && !Intrinsics.areEqual(appId, oAuthResult.getAppId())) {
            QLog.w("QWalletOAuthLoginManager", 1, "not target appId, target: " + appId + ", cookie.appId:" + appId);
            g.s("qwallet_open_auth_cookies_");
            return null;
        }
        if (System.currentTimeMillis() > oAuthResult.getExpireTime()) {
            QLog.w("QWalletOAuthLoginManager", 1, "cookie out of date:" + oAuthResult.getExpireTime());
            g.s("qwallet_open_auth_cookies_");
            return null;
        }
        return oAuthResult;
    }

    public final synchronized void j(@Nullable WeakReference<Activity> activityRef, boolean isSilentLogin, @Nullable String appId, @Nullable Integer appType, @Nullable String url, @NotNull c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (appId == null) {
            return;
        }
        if (callbackCenter.a(appId, callback)) {
            QLog.i("QWalletOAuthLoginManager", 1, "isRequesting!");
            return;
        }
        fl2.a aVar = fl2.a.f399772a;
        aVar.d();
        OAuthStatisticBean oAuthStatisticBean = new OAuthStatisticBean(null, null, null, null, 15, null);
        oAuthStatisticBean.j(Long.valueOf(System.currentTimeMillis()));
        QLog.i("QWalletOAuthLoginManager", 1, "start oauthLogin, " + appId + " " + appType + " " + url);
        aVar.c(activityRef, isSilentLogin, appId, appType, url, false, new e(oAuthStatisticBean, appId));
    }
}
