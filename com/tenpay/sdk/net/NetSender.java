package com.tenpay.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.HbProxySsoConfig;
import com.tenpay.sdk.net.PayGatewaySsoConfig;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.http.PayCgiServiceProxy;
import com.tenpay.sdk.net.sso.PaySsoCmd;
import com.tenpay.sdk.net.sso.PaySsoServiceProxy;
import com.tenpay.sdk.paynet.NetSenderDelegate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J>\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tenpay/sdk/net/NetSender;", "", "()V", "TAG", "", "gatewayConfig", "Lcom/tenpay/sdk/net/PayGatewaySsoConfig;", "hbProxyConfig", "Lcom/tenpay/sdk/net/HbProxySsoConfig;", "downloadCftUtilsSo", "", "getSsoConfig", "Lcom/tenpay/sdk/net/sso/PaySsoCmd;", "url", "with", "Lcom/tenpay/sdk/paynet/NetSenderDelegate;", "ctx", "Landroid/content/Context;", "baseUrl", "data", "", "uin", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class NetSender {

    @NotNull
    private static final String TAG = "NetSender";

    @NotNull
    public static final NetSender INSTANCE = new NetSender();

    @NotNull
    private static HbProxySsoConfig hbProxyConfig = HbProxySsoConfig.INSTANCE.getDefaultConfig();

    @NotNull
    private static PayGatewaySsoConfig gatewayConfig = PayGatewaySsoConfig.INSTANCE.getDefaultConfig();

    NetSender() {
    }

    private final void downloadCftUtilsSo() {
        boolean isFeatureSwitch = ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_DYNAMIC_CFTUTILS_SO);
        QLog.i(TAG, 2, "downloadCftUtilsSo: " + isFeatureSwitch);
        if (!isFeatureSwitch || !TextUtils.isEmpty(SoLoadManager.getInstance().getSoVer(SoLoadConstants.SONAME_QWALLET_CFTUTILS))) {
            return;
        }
        SoLoadManager.getInstance().download(SoLoadConstants.SONAME_QWALLET_CFTUTILS, new OnLoadListener() { // from class: com.tenpay.sdk.net.a
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                NetSender.downloadCftUtilsSo$lambda$2(i3, loadExtResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadCftUtilsSo$lambda$2(int i3, LoadExtResult loadExtResult) {
        String str;
        if (loadExtResult != null) {
            str = loadExtResult.getVer();
        } else {
            str = null;
        }
        QLog.i(TAG, 1, "downloadCftUtilsSo " + str);
    }

    private final PaySsoCmd getSsoConfig(String url) {
        boolean z16;
        String substringAfterLast$default;
        String substringBefore$default;
        PayGatewaySsoConfig.Item item;
        Object obj;
        boolean z17 = true;
        boolean z18 = false;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(url, '/', (String) null, 2, (Object) null);
            substringBefore$default = StringsKt__StringsKt.substringBefore$default(substringAfterLast$default, '.', (String) null, 2, (Object) null);
            PayGatewaySsoConfig payGatewaySsoConfig = gatewayConfig;
            PayGatewaySsoConfig.Companion companion = PayGatewaySsoConfig.INSTANCE;
            if (Intrinsics.areEqual(payGatewaySsoConfig, companion.getDefaultConfig())) {
                gatewayConfig = (PayGatewaySsoConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_GATEWAY_SSO_CONFIG, companion.getDefaultConfig());
            }
            ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, TAG, "loadConfig gateway config finish: " + gatewayConfig, null, 4, null);
            List<PayGatewaySsoConfig.Item> supportSsoList = gatewayConfig.getSupportSsoList();
            if (supportSsoList != null) {
                Iterator<T> it = supportSsoList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((PayGatewaySsoConfig.Item) obj).getCgiName(), substringBefore$default)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                item = (PayGatewaySsoConfig.Item) obj;
            } else {
                item = null;
            }
            if (item != null) {
                return new PaySsoCmd.Gateway(item.getCgiName(), item.getService(), item.getMethod());
            }
            HbProxySsoConfig hbProxySsoConfig = hbProxyConfig;
            HbProxySsoConfig.Companion companion2 = HbProxySsoConfig.INSTANCE;
            if (Intrinsics.areEqual(hbProxySsoConfig, companion2.getDefaultConfig())) {
                hbProxyConfig = (HbProxySsoConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_SSO_CONFIG, companion2.getDefaultConfig());
                ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, TAG, "load hbProxy config finish: " + hbProxyConfig, null, 4, null);
            }
            List<String> supportSsoList2 = hbProxyConfig.getSupportSsoList();
            if (supportSsoList2 != null) {
                List<String> list = supportSsoList2;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it5 = list.iterator();
                    while (it5.hasNext()) {
                        if (Intrinsics.areEqual((String) it5.next(), substringBefore$default)) {
                            break;
                        }
                    }
                }
                z17 = false;
                z18 = z17;
            }
            if (!z18) {
                return null;
            }
            return new PaySsoCmd.HbProxy(substringBefore$default, null, 2, null);
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final NetSenderDelegate with(@Nullable Context ctx, @Nullable String baseUrl, @Nullable Map<String, String> data, @Nullable String uin) {
        NetSender netSender = INSTANCE;
        netSender.downloadCftUtilsSo();
        PaySsoCmd ssoConfig = netSender.getSsoConfig(baseUrl);
        if (ssoConfig != null) {
            ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, TAG, "hit sso config: " + ssoConfig, null, 4, null);
            return PaySsoServiceProxy.INSTANCE.create().with(ctx, baseUrl, data, uin, ssoConfig);
        }
        return PayCgiServiceProxy.INSTANCE.create().with(ctx, baseUrl, data, uin);
    }
}
