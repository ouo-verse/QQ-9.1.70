package com.tenpay.sdk.net.core.encrypt;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/PayEcdhConfig;", "", "()V", "TAG", "", "configBean", "Lcom/tenpay/sdk/net/core/encrypt/PayEcdhConfig$EcdhConfigBean;", "userBlackList", "", "disableEcdh", "", "url", "getCmd", "initConfig", "isEnable", "", "EcdhConfigBean", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayEcdhConfig {

    @NotNull
    public static final String TAG = "QWalletHttp-PayEcdhConfig";

    @Nullable
    private static EcdhConfigBean configBean;

    @NotNull
    public static final PayEcdhConfig INSTANCE = new PayEcdhConfig();

    @NotNull
    private static final List<String> userBlackList = new ArrayList();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J7\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0006H\u00d6\u0001R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/PayEcdhConfig$EcdhConfigBean;", "", "isEnableAll", "", "whiteList", "", "", "blackList", "(ZLjava/util/List;Ljava/util/List;)V", "getBlackList", "()Ljava/util/List;", "()Z", "getWhiteList", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class EcdhConfigBean {

        @Nullable
        private final List<String> blackList;
        private final boolean isEnableAll;

        @Nullable
        private final List<String> whiteList;

        public EcdhConfigBean(boolean z16, @Nullable List<String> list, @Nullable List<String> list2) {
            this.isEnableAll = z16;
            this.whiteList = list;
            this.blackList = list2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EcdhConfigBean copy$default(EcdhConfigBean ecdhConfigBean, boolean z16, List list, List list2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = ecdhConfigBean.isEnableAll;
            }
            if ((i3 & 2) != 0) {
                list = ecdhConfigBean.whiteList;
            }
            if ((i3 & 4) != 0) {
                list2 = ecdhConfigBean.blackList;
            }
            return ecdhConfigBean.copy(z16, list, list2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsEnableAll() {
            return this.isEnableAll;
        }

        @Nullable
        public final List<String> component2() {
            return this.whiteList;
        }

        @Nullable
        public final List<String> component3() {
            return this.blackList;
        }

        @NotNull
        public final EcdhConfigBean copy(boolean isEnableAll, @Nullable List<String> whiteList, @Nullable List<String> blackList) {
            return new EcdhConfigBean(isEnableAll, whiteList, blackList);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EcdhConfigBean)) {
                return false;
            }
            EcdhConfigBean ecdhConfigBean = (EcdhConfigBean) other;
            if (this.isEnableAll == ecdhConfigBean.isEnableAll && Intrinsics.areEqual(this.whiteList, ecdhConfigBean.whiteList) && Intrinsics.areEqual(this.blackList, ecdhConfigBean.blackList)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final List<String> getBlackList() {
            return this.blackList;
        }

        @Nullable
        public final List<String> getWhiteList() {
            return this.whiteList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isEnableAll;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            List<String> list = this.whiteList;
            int i16 = 0;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            List<String> list2 = this.blackList;
            if (list2 != null) {
                i16 = list2.hashCode();
            }
            return i17 + i16;
        }

        public final boolean isEnableAll() {
            return this.isEnableAll;
        }

        @NotNull
        public String toString() {
            return "EcdhConfigBean(isEnableAll=" + this.isEnableAll + ", whiteList=" + this.whiteList + ", blackList=" + this.blackList + ")";
        }
    }

    PayEcdhConfig() {
    }

    private final String getCmd(String url) {
        List split$default;
        Object last;
        int indexOf$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{"/"}, false, 0, 6, (Object) null);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
        String str = (String) last;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str;
        }
        return str.subSequence(0, indexOf$default).toString();
    }

    private final EcdhConfigBean initConfig() {
        List list;
        String optString;
        String optString2;
        boolean z16 = false;
        List list2 = null;
        if (!((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_ECDH_CONFIG, false)) {
            return null;
        }
        JSONObject jSONObject = ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).getJSONObject(IQWalletFeatureApi.QWALLET_ECDH_CONFIG);
        QLog.i(TAG, 1, "init ecdh config: " + jSONObject);
        if (jSONObject != null && jSONObject.optInt("is_enable_all") == 1) {
            z16 = true;
        }
        if (jSONObject != null && (optString2 = jSONObject.optString(MobileQQ.PREF_WHITE_LIST_KEY)) != null) {
            list = StringsKt__StringsKt.split$default((CharSequence) optString2, new String[]{","}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        if (jSONObject != null && (optString = jSONObject.optString("black_list")) != null) {
            list2 = StringsKt__StringsKt.split$default((CharSequence) optString, new String[]{","}, false, 0, 6, (Object) null);
        }
        return new EcdhConfigBean(z16, list, list2);
    }

    public final void disableEcdh(@NotNull String url) {
        Object obj;
        Intrinsics.checkNotNullParameter(url, "url");
        String cmd = getCmd(url);
        Iterator<T> it = userBlackList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual((String) obj, cmd)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            userBlackList.add(cmd);
            QLog.w(TAG, 1, "disable ecdh cmd: " + cmd);
        }
    }

    public final boolean isEnable(@NotNull String url) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(url, "url");
        String cmd = getCmd(url);
        Iterator<T> it = userBlackList.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (Intrinsics.areEqual((String) obj2, cmd)) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        if (obj2 != null) {
            QLog.i(TAG, 1, cmd + " forbid ecdh in userBlackList");
            return false;
        }
        EcdhConfigBean ecdhConfigBean = configBean;
        if (ecdhConfigBean == null) {
            ecdhConfigBean = initConfig();
        }
        if (ecdhConfigBean == null) {
            QLog.w(TAG, 1, "forbid ecdh, configBean is null");
            return false;
        }
        if (ecdhConfigBean.isEnableAll()) {
            List<String> blackList = ecdhConfigBean.getBlackList();
            if (blackList != null) {
                Iterator<T> it5 = blackList.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    if (Intrinsics.areEqual((String) next, cmd)) {
                        obj = next;
                        break;
                    }
                }
                obj = (String) obj;
            }
            if (obj != null) {
                return false;
            }
        } else {
            List<String> whiteList = ecdhConfigBean.getWhiteList();
            if (whiteList != null) {
                Iterator<T> it6 = whiteList.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        break;
                    }
                    Object next2 = it6.next();
                    if (Intrinsics.areEqual((String) next2, cmd)) {
                        obj = next2;
                        break;
                    }
                }
                obj = (String) obj;
            }
            if (obj == null) {
                return false;
            }
        }
        return true;
    }
}
