package com.tenpay.sdk.net.core.comm;

import com.google.gson.annotations.SerializedName;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\fJ\u001c\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/tenpay/sdk/net/core/comm/SessionKey;", "", "cgiName", "", "pskey", "uin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "cftSkey", "Lcom/tenpay/sdk/net/core/comm/CftSKey;", "getPskey", "()Ljava/lang/String;", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "", "skeyType", "specialSkey", "getUin", "getRandom", "putSessionKey", "", "postDataMap", "", "Companion", "QWalletTicketConfig", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class SessionKey {
    public static final int LOGIN_TYPE_CFT_SKEY = 0;
    public static final int LOGIN_TYPE_PSKEY = 2;

    @NotNull
    private static final String TAG = "SeesionKey";

    @Nullable
    private final CftSKey cftSkey;

    @NotNull
    private final String cgiName;

    @Nullable
    private final String pskey;
    private int random;
    private final int skeyType;

    @Nullable
    private String specialSkey;

    @Nullable
    private final String uin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0004H\u00d6\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/sdk/net/core/comm/SessionKey$QWalletTicketConfig;", "", "forbidCftSKey", "", "", "(Ljava/util/List;)V", "getForbidCftSKey", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class QWalletTicketConfig {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private static final List<String> DEFAULT_FORBID_CFTSKEY_LIST;

        @NotNull
        private static final QWalletTicketConfig defaultConfig;

        @SerializedName("forbid_cftskey")
        @Nullable
        private final List<String> forbidCftSKey;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/sdk/net/core/comm/SessionKey$QWalletTicketConfig$Companion;", "", "()V", "DEFAULT_FORBID_CFTSKEY_LIST", "", "", "defaultConfig", "Lcom/tenpay/sdk/net/core/comm/SessionKey$QWalletTicketConfig;", "getDefaultConfig", "()Lcom/tenpay/sdk/net/core/comm/SessionKey$QWalletTicketConfig;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final QWalletTicketConfig getDefaultConfig() {
                return QWalletTicketConfig.defaultConfig;
            }

            Companion() {
            }
        }

        static {
            List<String> listOf;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qpay_hb_na_grap", "qpay_hb_zone_grap", "qpay_gate", "pass_sdk_auth", "qpwd_sdk_auth", "qpay_h5_gate", "qwallet", "qwallet_midas", "qpayment_trans_detail"});
            DEFAULT_FORBID_CFTSKEY_LIST = listOf;
            defaultConfig = new QWalletTicketConfig(listOf);
        }

        public QWalletTicketConfig(@Nullable List<String> list) {
            this.forbidCftSKey = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ QWalletTicketConfig copy$default(QWalletTicketConfig qWalletTicketConfig, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = qWalletTicketConfig.forbidCftSKey;
            }
            return qWalletTicketConfig.copy(list);
        }

        @Nullable
        public final List<String> component1() {
            return this.forbidCftSKey;
        }

        @NotNull
        public final QWalletTicketConfig copy(@Nullable List<String> forbidCftSKey) {
            return new QWalletTicketConfig(forbidCftSKey);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof QWalletTicketConfig) && Intrinsics.areEqual(this.forbidCftSKey, ((QWalletTicketConfig) other).forbidCftSKey)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final List<String> getForbidCftSKey() {
            return this.forbidCftSKey;
        }

        public int hashCode() {
            List<String> list = this.forbidCftSKey;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        @NotNull
        public String toString() {
            return "QWalletTicketConfig(forbidCftSKey=" + this.forbidCftSKey + ")";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SessionKey(@NotNull String cgiName, @Nullable String str, @Nullable String str2) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(cgiName, "cgiName");
        this.cgiName = cgiName;
        this.pskey = str;
        this.uin = str2;
        CftSKey cftSKey = CftSKeyCacheUtils.INSTANCE.getCftSKey(str2);
        QWalletTicketConfig qWalletTicketConfig = (QWalletTicketConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_CFTSKEY_PSKEY_CONFIG, QWalletTicketConfig.INSTANCE.getDefaultConfig());
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, TAG, "loadConfig SessionKey finish: " + qWalletTicketConfig, null, 4, null);
        SpecialKeyInfo cache = SpecialKeyInfo.INSTANCE.getCache();
        List<String> forbidCftSKey = qWalletTicketConfig.getForbidCftSKey();
        if (forbidCftSKey != null) {
            List<String> list = forbidCftSKey;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual((String) it.next(), this.cgiName)) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            if (z17) {
                z16 = true;
                if (z16 && cftSKey != null) {
                    this.cftSkey = cftSKey;
                    this.random = cftSKey.getTransSeq();
                    this.skeyType = 0;
                } else {
                    if (!(cache == null && cache.isValid())) {
                        this.cftSkey = null;
                        this.random = Math.abs(new Random().nextInt() % 16);
                        int skeyType = cache.getSkeyType();
                        this.skeyType = skeyType;
                        String skey = cache.getSkey();
                        this.specialSkey = skey;
                        ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, TAG, "hit deprecated skeyType=" + skeyType + " specialSkey=" + skey, null, 4, null);
                    } else {
                        this.cftSkey = null;
                        this.random = Math.abs(new Random().nextInt() % 16);
                        this.skeyType = 2;
                    }
                }
                ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, TAG, "init sessionKey: skeyType=" + this.skeyType + ", random=" + this.random, null, 4, null);
            }
        }
        z16 = false;
        if (z16) {
        }
        if (!(cache == null && cache.isValid())) {
        }
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, TAG, "init sessionKey: skeyType=" + this.skeyType + ", random=" + this.random, null, 4, null);
    }

    @Nullable
    public final String getPskey() {
        return this.pskey;
    }

    public final int getRandom() {
        CftSKey cftSKey = this.cftSkey;
        if (cftSKey != null) {
            return cftSKey.getTransSeq();
        }
        return this.random;
    }

    @Nullable
    public final String getUin() {
        return this.uin;
    }

    public final void putSessionKey(@NotNull Map<String, String> postDataMap) {
        String str;
        Intrinsics.checkNotNullParameter(postDataMap, "postDataMap");
        int i3 = this.skeyType;
        if (i3 != 0) {
            if (i3 != 2) {
                postDataMap.put("skey_type", String.valueOf(i3));
                postDataMap.put("skey", this.specialSkey);
                return;
            } else {
                postDataMap.put("skey_type", "2");
                postDataMap.put(QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, String.valueOf(getRandom()));
                return;
            }
        }
        CftSKey cftSKey = this.cftSkey;
        if (cftSKey != null) {
            str = cftSKey.getSkey();
        } else {
            str = null;
        }
        postDataMap.put("skey", str);
        postDataMap.put("skey_type", "0");
    }
}
