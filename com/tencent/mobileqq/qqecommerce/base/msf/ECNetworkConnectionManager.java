package com.tencent.mobileqq.qqecommerce.base.msf;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u00028G\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/msf/ECNetworkConnectionManager;", "", "Lcom/tencent/mobileqq/qqecommerce/base/msf/ECNetworkConnectionManager$ECNetworkType;", "a", "()Lcom/tencent/mobileqq/qqecommerce/base/msf/ECNetworkConnectionManager$ECNetworkType;", "currentNetworkType", "<init>", "()V", "ECNetworkType", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECNetworkConnectionManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ECNetworkConnectionManager f262432a = new ECNetworkConnectionManager();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/msf/ECNetworkConnectionManager$ECNetworkType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "UNREACHABLE", Global.TRACKING_WIFI, "MOBILE_5G", "MOBILE_4G", "MOBILE_3G", "MOBILE_2G", "OTHER", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum ECNetworkType {
        UNREACHABLE("UNREACHABLE"),
        WIFI(Global.TRACKING_WIFI),
        MOBILE_5G("5G"),
        MOBILE_4G("4G"),
        MOBILE_3G("3G"),
        MOBILE_2G("2G"),
        OTHER("OTHER");

        private final String value;

        ECNetworkType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    ECNetworkConnectionManager() {
    }

    public final ECNetworkType a() {
        Object systemService = new ECRuntimeManager().getExternalApplicationContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            int type = NetworkMonitor.getType(activeNetworkInfo);
            if (type != 0) {
                if (type != 1) {
                    return ECNetworkType.OTHER;
                }
                return ECNetworkType.WIFI;
            }
            int subtype = NetworkMonitor.getSubtype(activeNetworkInfo);
            if (subtype != 17) {
                if (subtype != 20) {
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return ECNetworkType.MOBILE_2G;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            break;
                        case 13:
                            return ECNetworkType.MOBILE_4G;
                        default:
                            return ECNetworkType.OTHER;
                    }
                } else {
                    return ECNetworkType.MOBILE_5G;
                }
            }
            return ECNetworkType.MOBILE_3G;
        }
        return ECNetworkType.UNREACHABLE;
    }
}
