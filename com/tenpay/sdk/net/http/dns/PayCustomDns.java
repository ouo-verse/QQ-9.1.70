package com.tenpay.sdk.net.http.dns;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import java.net.InetAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Dns;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/sdk/net/http/dns/PayCustomDns;", "Lokhttp3/Dns;", "()V", "systemDns", "ipv4ToByteArray", "", "ip", "", "isLocalProxy", "", "lookup", "", "Ljava/net/InetAddress;", "hostname", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayCustomDns implements Dns {

    @NotNull
    private static final String CGI_MYUN_DOMAIN = "myun.tenpay.com";

    @NotNull
    private static final String CGI_MYUN_PROXY = "113.96.237.38";

    @NotNull
    private static final String TAG = "CustomDns";

    @NotNull
    private final Dns systemDns = Dns.SYSTEM;

    private final byte[] ipv4ToByteArray(String ip5) {
        List split$default;
        byte[] bArr = new byte[4];
        split$default = StringsKt__StringsKt.split$default((CharSequence) ip5, new String[]{"."}, false, 0, 6, (Object) null);
        if (split$default.size() == 4) {
            for (int i3 = 0; i3 < 4; i3++) {
                bArr[i3] = (byte) (Integer.parseInt((String) split$default.get(i3)) & 255);
            }
            return bArr;
        }
        throw new IllegalArgumentException("ip format error: " + ip5);
    }

    private final boolean isLocalProxy() {
        boolean c16 = g.c("qwalley_key_cgi_myun_proxy", false);
        boolean isSwitchOn = ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_MYUN_PROXY_WHITELIST, false);
        if (!c16 && !isSwitchOn) {
            return false;
        }
        return true;
    }

    @Override // okhttp3.Dns
    @NotNull
    public List<InetAddress> lookup(@NotNull String hostname) {
        List<InetAddress> mutableListOf;
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        if (isLocalProxy() && Intrinsics.areEqual("myun.tenpay.com", hostname)) {
            InetAddress byAddress = InetAddress.getByAddress(hostname, ipv4ToByteArray(CGI_MYUN_PROXY));
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(byAddress);
            ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, TAG, "custom dns: " + hostname + " -> " + byAddress, null, 4, null);
            return mutableListOf;
        }
        return this.systemDns.lookup(hostname);
    }
}
